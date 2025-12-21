/// Classic example of flexible constructor bodies in case if some validation should be done before constructing the parent.
/// * Not jdk25 example: [flexibleconstructors.validation.CasualCar]
/// * Jdk25 example: [flexibleconstructors.validation.CasualCarJdk25]
///
/// This thing becomes even more useful, if construction of parent entity is "heavy", so we could save some time by validating some things in the child class before constructing parent class.
///
/// Although it is possible to do this before jdk25, with static methods as shown already, but jdk25 looks better
package flexibleconstructors.validation;