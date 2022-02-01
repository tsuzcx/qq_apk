package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.TestClass;

public class RuleMemberValidator
{
  public static final RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR = classRuleValidatorBuilder().forMethods().withValidator(new DeclaringClassMustBePublic(null)).withValidator(new MemberMustBeStatic(null)).withValidator(new MemberMustBePublic(null)).withValidator(new MethodMustBeATestRule(null)).build();
  public static final RuleMemberValidator CLASS_RULE_VALIDATOR = classRuleValidatorBuilder().withValidator(new DeclaringClassMustBePublic(null)).withValidator(new MemberMustBeStatic(null)).withValidator(new MemberMustBePublic(null)).withValidator(new FieldMustBeATestRule(null)).build();
  public static final RuleMemberValidator RULE_METHOD_VALIDATOR = testRuleValidatorBuilder().forMethods().withValidator(new MemberMustBeNonStaticOrAlsoClassRule(null)).withValidator(new MemberMustBePublic(null)).withValidator(new MethodMustBeARule(null)).build();
  public static final RuleMemberValidator RULE_VALIDATOR = testRuleValidatorBuilder().withValidator(new MemberMustBeNonStaticOrAlsoClassRule(null)).withValidator(new MemberMustBePublic(null)).withValidator(new FieldMustBeARule(null)).build();
  private final Class<? extends Annotation> annotation;
  private final boolean methods;
  private final List<RuleValidator> validatorStrategies;
  
  RuleMemberValidator(Builder paramBuilder)
  {
    this.annotation = paramBuilder.annotation;
    this.methods = paramBuilder.methods;
    this.validatorStrategies = paramBuilder.validators;
  }
  
  private static Builder classRuleValidatorBuilder()
  {
    return new Builder(ClassRule.class, null);
  }
  
  private static boolean isMethodRule(FrameworkMember<?> paramFrameworkMember)
  {
    return MethodRule.class.isAssignableFrom(paramFrameworkMember.getType());
  }
  
  private static boolean isRuleType(FrameworkMember<?> paramFrameworkMember)
  {
    return (isMethodRule(paramFrameworkMember)) || (isTestRule(paramFrameworkMember));
  }
  
  private static boolean isTestRule(FrameworkMember<?> paramFrameworkMember)
  {
    return TestRule.class.isAssignableFrom(paramFrameworkMember.getType());
  }
  
  private static Builder testRuleValidatorBuilder()
  {
    return new Builder(Rule.class, null);
  }
  
  private void validateMember(FrameworkMember<?> paramFrameworkMember, List<Throwable> paramList)
  {
    Iterator localIterator = this.validatorStrategies.iterator();
    while (localIterator.hasNext()) {
      ((RuleValidator)localIterator.next()).validate(paramFrameworkMember, this.annotation, paramList);
    }
  }
  
  public void validate(TestClass paramTestClass, List<Throwable> paramList)
  {
    if (this.methods) {}
    for (paramTestClass = paramTestClass.getAnnotatedMethods(this.annotation);; paramTestClass = paramTestClass.getAnnotatedFields(this.annotation))
    {
      paramTestClass = paramTestClass.iterator();
      while (paramTestClass.hasNext()) {
        validateMember((FrameworkMember)paramTestClass.next(), paramList);
      }
    }
  }
  
  static class Builder
  {
    private final Class<? extends Annotation> annotation;
    private boolean methods;
    private final List<RuleMemberValidator.RuleValidator> validators;
    
    private Builder(Class<? extends Annotation> paramClass)
    {
      this.annotation = paramClass;
      this.methods = false;
      this.validators = new ArrayList();
    }
    
    RuleMemberValidator build()
    {
      return new RuleMemberValidator(this);
    }
    
    Builder forMethods()
    {
      this.methods = true;
      return this;
    }
    
    Builder withValidator(RuleMemberValidator.RuleValidator paramRuleValidator)
    {
      this.validators.add(paramRuleValidator);
      return this;
    }
  }
  
  static final class DeclaringClassMustBePublic
    implements RuleMemberValidator.RuleValidator
  {
    private boolean isDeclaringClassPublic(FrameworkMember<?> paramFrameworkMember)
    {
      return Modifier.isPublic(paramFrameworkMember.getDeclaringClass().getModifiers());
    }
    
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!isDeclaringClassPublic(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be declared in a public class."));
      }
    }
  }
  
  static final class FieldMustBeARule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!RuleMemberValidator.isRuleType(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must implement MethodRule or TestRule."));
      }
    }
  }
  
  static final class FieldMustBeATestRule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!RuleMemberValidator.isTestRule(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must implement TestRule."));
      }
    }
  }
  
  static final class MemberMustBeNonStaticOrAlsoClassRule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      boolean bool = RuleMemberValidator.isMethodRule(paramFrameworkMember);
      int i;
      if (paramFrameworkMember.getAnnotation(ClassRule.class) != null)
      {
        i = 1;
        if ((paramFrameworkMember.isStatic()) && ((bool) || (i == 0))) {
          if (!RuleMemberValidator.isMethodRule(paramFrameworkMember)) {
            break label71;
          }
        }
      }
      label71:
      for (String str = "must not be static.";; str = "must not be static or it must be annotated with @ClassRule.")
      {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, str));
        return;
        i = 0;
        break;
      }
    }
  }
  
  static final class MemberMustBePublic
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!paramFrameworkMember.isPublic()) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be public."));
      }
    }
  }
  
  static final class MemberMustBeStatic
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!paramFrameworkMember.isStatic()) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be static."));
      }
    }
  }
  
  static final class MethodMustBeARule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!RuleMemberValidator.isRuleType(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must return an implementation of MethodRule or TestRule."));
      }
    }
  }
  
  static final class MethodMustBeATestRule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!RuleMemberValidator.isTestRule(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must return an implementation of TestRule."));
      }
    }
  }
  
  static abstract interface RuleValidator
  {
    public abstract void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator
 * JD-Core Version:    0.7.0.1
 */