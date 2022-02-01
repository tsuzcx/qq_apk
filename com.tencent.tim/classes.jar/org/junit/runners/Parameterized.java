package org.junit.runners;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Runner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

public class Parameterized
  extends Suite
{
  private static final ParametersRunnerFactory DEFAULT_FACTORY = new BlockJUnit4ClassRunnerWithParametersFactory();
  private static final List<Runner> NO_RUNNERS = Collections.emptyList();
  private final List<Runner> runners;
  
  public Parameterized(Class<?> paramClass)
    throws Throwable
  {
    super(paramClass, NO_RUNNERS);
    paramClass = getParametersRunnerFactory(paramClass);
    Parameters localParameters = (Parameters)getParametersMethod().getAnnotation(Parameters.class);
    this.runners = Collections.unmodifiableList(createRunnersForParameters(allParameters(), localParameters.name(), paramClass));
  }
  
  private Iterable<Object> allParameters()
    throws Throwable
  {
    Object localObject = getParametersMethod().invokeExplosively(null, new Object[0]);
    if ((localObject instanceof Iterable)) {
      return (Iterable)localObject;
    }
    if ((localObject instanceof Object[])) {
      return Arrays.asList((Object[])localObject);
    }
    throw parametersMethodReturnedWrongType();
  }
  
  private List<Runner> createRunnersForParameters(Iterable<Object> paramIterable, String paramString, ParametersRunnerFactory paramParametersRunnerFactory)
    throws InitializationError, Exception
  {
    try
    {
      paramString = createTestsForParameters(paramIterable, paramString);
      paramIterable = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        paramIterable.add(paramParametersRunnerFactory.createRunnerForTestWithParameters((TestWithParameters)paramString.next()));
      }
      return paramIterable;
    }
    catch (ClassCastException paramIterable)
    {
      throw parametersMethodReturnedWrongType();
    }
  }
  
  private TestWithParameters createTestWithNotNormalizedParameters(String paramString, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {}
    for (paramObject = (Object[])paramObject;; paramObject = new Object[] { paramObject }) {
      return createTestWithParameters(getTestClass(), paramString, paramInt, paramObject);
    }
  }
  
  private static TestWithParameters createTestWithParameters(TestClass paramTestClass, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    paramString = MessageFormat.format(paramString.replaceAll("\\{index\\}", Integer.toString(paramInt)), paramArrayOfObject);
    return new TestWithParameters("[" + paramString + "]", paramTestClass, Arrays.asList(paramArrayOfObject));
  }
  
  private List<TestWithParameters> createTestsForParameters(Iterable<Object> paramIterable, String paramString)
    throws Exception
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localArrayList.add(createTestWithNotNormalizedParameters(paramString, i, paramIterable.next()));
      i += 1;
    }
    return localArrayList;
  }
  
  private FrameworkMethod getParametersMethod()
    throws Exception
  {
    Iterator localIterator = getTestClass().getAnnotatedMethods(Parameters.class).iterator();
    while (localIterator.hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)localIterator.next();
      if ((localFrameworkMethod.isStatic()) && (localFrameworkMethod.isPublic())) {
        return localFrameworkMethod;
      }
    }
    throw new Exception("No public static parameters method on class " + getTestClass().getName());
  }
  
  private ParametersRunnerFactory getParametersRunnerFactory(Class<?> paramClass)
    throws InstantiationException, IllegalAccessException
  {
    paramClass = (UseParametersRunnerFactory)paramClass.getAnnotation(UseParametersRunnerFactory.class);
    if (paramClass == null) {
      return DEFAULT_FACTORY;
    }
    return (ParametersRunnerFactory)paramClass.value().newInstance();
  }
  
  private Exception parametersMethodReturnedWrongType()
    throws Exception
  {
    return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", new Object[] { getTestClass().getName(), getParametersMethod().getName() }));
  }
  
  protected List<Runner> getChildren()
  {
    return this.runners;
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface Parameter
  {
    int value() default 0;
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD})
  public static @interface Parameters
  {
    String name() default "{index}";
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface UseParametersRunnerFactory
  {
    Class<? extends ParametersRunnerFactory> value() default BlockJUnit4ClassRunnerWithParametersFactory.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runners.Parameterized
 * JD-Core Version:    0.7.0.1
 */