/// This package represents an example for flexible constructor bodies in case if parent entity needs to have another entity,
/// which we should fill with some fields.
/// It is possible to do without this feature, but most probably it will look ugly, unless if you create a builder for [flexibleconstructors.heavyinitialization.Dependency] entity which is required for [flexibleconstructors.abstractmethod.AbstractEntity].
/// * Nice example for jdk25, see: [flexibleconstructors.heavyinitialization.solution.OwnerJdk25]
/// * Ugly example see (prior jdk25) see: [flexibleconstructors.heavyinitialization.Owner]
package flexibleconstructors.heavyinitialization;