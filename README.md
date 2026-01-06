# This project is designed to demo java 25 features
It includes only two things:
* Flexible constructor bodies
* Pattern matching

## Flexible constructor bodies
Was introduced in [JEP 482](https://openjdk.org/jeps/482) in Java 23, Java 25 is the first LTS version which has that feature.

### Some history why it was done like this
The problem which this feature solves, lays when first version of Java was developed.
At that time there were other OOP languages like C++, and in C++ this polymorphism in constructors worked even weirder:
```cpp
using namespace std;
class Base {
        public:
        Base(){
                cout << "Invoking base constructor\n";
                someMethod();// ????
        }

        virtual void someMethod() {
                cout << "I am a based method\n";
        }
};

class Child : public Base {
        public:
        void someMethod() override {
                cout << "I am a child method\n";
        }
};

int main() {
        Child child;
        Base& base = child;
        cout << "Invoking child method after initialization as base\n";
        base.someMethod();
        return 0;
}
```
<details>
It doesn't work, the base method will be called when you call virtual method from a constructor, the method is not really "virtual", you will call "your method", not that one which is in "Child".
</details>

Here is the Java similar example:

```java
class Base {
    public Base() {
        someMethod();
    }

    public void someMethod() {
        System.out.println("I'm a based method");
    }
}

class Child extends Base {
    @Override
    public void someMethod() {
        System.out.println("I'm a child method");
    }
}
public class Main {
    public static void main() {
        Base base = new Child();
        System.out.println("Invoking some method from base");
        base.someMethod();
    }
}
```

<details>
Java did that differently, and polymorphism in constructors works 🎉
</details>

However, there are another set of problems with it:
```java
class Base {
    public Base() {
        someMethod();
    }

    public void someMethod() {
        System.out.println("I'm a based method");
    }
}

class Child extends Base {
    private final String name;

    public Child(String name) {
        this.name = name;
    }
    
    @Override
    public void someMethod() {
        System.out.printf("I'm a child method, my name is: %s\n", name);
    }
}
public class Main {
    public static void main() {
        Base base = new Child();
        System.out.println("Invoking some method from base");
        base.someMethod();
    }
}
```

<details>
The <b>name</b> will be null, so polymorphism works kind of, but not really.
In this example there is implicit super call which is placed before name is assigned.
</details>

Intuitively, this is the first thing which every developer does, is this:

```java
class Child extends Base {
    private final String name;

    public Child(String name) {
        this.name = name;
        super();
    }
    
    @Override
    public void someMethod() {
        System.out.printf("I'm a child method, my name is: %s\n", name);
    }
}
```

<details>
<p>
    But this code won't compile prior Java 23.
    You will get a compile error stating that the <b>super()</b> must be the first statement in the constructor,<br>
    which is really sad, because all we want to do here is initialize our own fields before invoking parent constructor, to make this scuffed example work.
</p>

<p>
    This compile error is even stranger, since we are ALLOWED to call "instance methods" from a constructor, and because of that we may get such bug, but we aren't allowed to fix that.
</p>

<p>
    You may also say that sometimes this is "a bad design", that we call instance methods from a constructor.
    But I will say that it is sometimes pretty, and much better than alternative solutions.
</p>
</details>

## Links to talks which were used as references:
https://youtu.be/3k2bIMFeIp8?si=bV7zoTLil8FIw87E
