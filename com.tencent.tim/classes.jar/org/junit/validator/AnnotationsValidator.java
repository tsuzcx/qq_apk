package org.junit.validator;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.Annotatable;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public final class AnnotationsValidator
  implements TestClassValidator
{
  private static final List<AnnotatableValidator<?>> VALIDATORS = Arrays.asList(new AnnotatableValidator[] { new ClassValidator(null), new MethodValidator(null), new FieldValidator(null) });
  
  public List<Exception> validateTestClass(TestClass paramTestClass)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = VALIDATORS.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((AnnotatableValidator)localIterator.next()).validateTestClass(paramTestClass));
    }
    return localArrayList;
  }
  
  static abstract class AnnotatableValidator<T extends Annotatable>
  {
    private static final AnnotationValidatorFactory ANNOTATION_VALIDATOR_FACTORY = new AnnotationValidatorFactory();
    
    private List<Exception> validateAnnotatable(T paramT)
    {
      ArrayList localArrayList = new ArrayList();
      Annotation[] arrayOfAnnotation = paramT.getAnnotations();
      int j = arrayOfAnnotation.length;
      int i = 0;
      while (i < j)
      {
        ValidateWith localValidateWith = (ValidateWith)arrayOfAnnotation[i].annotationType().getAnnotation(ValidateWith.class);
        if (localValidateWith != null) {
          localArrayList.addAll(validateAnnotatable(ANNOTATION_VALIDATOR_FACTORY.createAnnotationValidator(localValidateWith), paramT));
        }
        i += 1;
      }
      return localArrayList;
    }
    
    abstract Iterable<T> getAnnotatablesForTestClass(TestClass paramTestClass);
    
    abstract List<Exception> validateAnnotatable(AnnotationValidator paramAnnotationValidator, T paramT);
    
    public List<Exception> validateTestClass(TestClass paramTestClass)
    {
      ArrayList localArrayList = new ArrayList();
      paramTestClass = getAnnotatablesForTestClass(paramTestClass).iterator();
      while (paramTestClass.hasNext()) {
        localArrayList.addAll(validateAnnotatable((Annotatable)paramTestClass.next()));
      }
      return localArrayList;
    }
  }
  
  static class ClassValidator
    extends AnnotationsValidator.AnnotatableValidator<TestClass>
  {
    private ClassValidator()
    {
      super();
    }
    
    Iterable<TestClass> getAnnotatablesForTestClass(TestClass paramTestClass)
    {
      return Collections.singletonList(paramTestClass);
    }
    
    List<Exception> validateAnnotatable(AnnotationValidator paramAnnotationValidator, TestClass paramTestClass)
    {
      return paramAnnotationValidator.validateAnnotatedClass(paramTestClass);
    }
  }
  
  static class FieldValidator
    extends AnnotationsValidator.AnnotatableValidator<FrameworkField>
  {
    private FieldValidator()
    {
      super();
    }
    
    Iterable<FrameworkField> getAnnotatablesForTestClass(TestClass paramTestClass)
    {
      return paramTestClass.getAnnotatedFields();
    }
    
    List<Exception> validateAnnotatable(AnnotationValidator paramAnnotationValidator, FrameworkField paramFrameworkField)
    {
      return paramAnnotationValidator.validateAnnotatedField(paramFrameworkField);
    }
  }
  
  static class MethodValidator
    extends AnnotationsValidator.AnnotatableValidator<FrameworkMethod>
  {
    private MethodValidator()
    {
      super();
    }
    
    Iterable<FrameworkMethod> getAnnotatablesForTestClass(TestClass paramTestClass)
    {
      return paramTestClass.getAnnotatedMethods();
    }
    
    List<Exception> validateAnnotatable(AnnotationValidator paramAnnotationValidator, FrameworkMethod paramFrameworkMethod)
    {
      return paramAnnotationValidator.validateAnnotatedMethod(paramFrameworkMethod);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.validator.AnnotationsValidator
 * JD-Core Version:    0.7.0.1
 */