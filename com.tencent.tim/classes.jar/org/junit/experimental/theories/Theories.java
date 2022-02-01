package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

public class Theories
  extends BlockJUnit4ClassRunner
{
  public Theories(Class<?> paramClass)
    throws InitializationError
  {
    super(paramClass);
  }
  
  private void validateDataPointFields(List<Throwable> paramList)
  {
    Field[] arrayOfField = getTestClass().getJavaClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Field localField = arrayOfField[i];
      if ((localField.getAnnotation(DataPoint.class) == null) && (localField.getAnnotation(DataPoints.class) == null)) {}
      for (;;)
      {
        i += 1;
        break;
        if (!Modifier.isStatic(localField.getModifiers())) {
          paramList.add(new Error("DataPoint field " + localField.getName() + " must be static"));
        }
        if (!Modifier.isPublic(localField.getModifiers())) {
          paramList.add(new Error("DataPoint field " + localField.getName() + " must be public"));
        }
      }
    }
  }
  
  private void validateDataPointMethods(List<Throwable> paramList)
  {
    Method[] arrayOfMethod = getTestClass().getJavaClass().getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    if (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if ((localMethod.getAnnotation(DataPoint.class) == null) && (localMethod.getAnnotation(DataPoints.class) == null)) {}
      for (;;)
      {
        i += 1;
        break;
        if (!Modifier.isStatic(localMethod.getModifiers())) {
          paramList.add(new Error("DataPoint method " + localMethod.getName() + " must be static"));
        }
        if (!Modifier.isPublic(localMethod.getModifiers())) {
          paramList.add(new Error("DataPoint method " + localMethod.getName() + " must be public"));
        }
      }
    }
  }
  
  private void validateParameterSupplier(Class<? extends ParameterSupplier> paramClass, List<Throwable> paramList)
  {
    Object localObject = paramClass.getConstructors();
    if (localObject.length != 1) {
      paramList.add(new Error("ParameterSupplier " + paramClass.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
    }
    do
    {
      return;
      localObject = localObject[0].getParameterTypes();
    } while ((localObject.length == 0) || (localObject[0].equals(TestClass.class)));
    paramList.add(new Error("ParameterSupplier " + paramClass.getName() + " constructor must take either nothing or a single TestClass instance"));
  }
  
  public void collectInitializationErrors(List<Throwable> paramList)
  {
    super.collectInitializationErrors(paramList);
    validateDataPointFields(paramList);
    validateDataPointMethods(paramList);
  }
  
  public List<FrameworkMethod> computeTestMethods()
  {
    ArrayList localArrayList = new ArrayList(super.computeTestMethods());
    List localList = getTestClass().getAnnotatedMethods(Theory.class);
    localArrayList.removeAll(localList);
    localArrayList.addAll(localList);
    return localArrayList;
  }
  
  public Statement methodBlock(FrameworkMethod paramFrameworkMethod)
  {
    return new TheoryAnchor(paramFrameworkMethod, getTestClass());
  }
  
  public void validateConstructor(List<Throwable> paramList)
  {
    validateOnlyOneConstructor(paramList);
  }
  
  public void validateTestMethods(List<Throwable> paramList)
  {
    Iterator localIterator = computeTestMethods().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (FrameworkMethod)localIterator.next();
      if (((FrameworkMethod)localObject).getAnnotation(Theory.class) != null)
      {
        ((FrameworkMethod)localObject).validatePublicVoid(false, paramList);
        ((FrameworkMethod)localObject).validateNoTypeParametersOnArgs(paramList);
      }
      for (;;)
      {
        localObject = ParameterSignature.signatures(((FrameworkMethod)localObject).getMethod()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ParametersSuppliedBy localParametersSuppliedBy = (ParametersSuppliedBy)((ParameterSignature)((Iterator)localObject).next()).findDeepAnnotation(ParametersSuppliedBy.class);
          if (localParametersSuppliedBy != null) {
            validateParameterSupplier(localParametersSuppliedBy.value(), paramList);
          }
        }
        break;
        ((FrameworkMethod)localObject).validatePublicVoidNoArg(false, paramList);
      }
    }
  }
  
  public static class TheoryAnchor
    extends Statement
  {
    private List<AssumptionViolatedException> fInvalidParameters = new ArrayList();
    private int successes = 0;
    private final TestClass testClass;
    private final FrameworkMethod testMethod;
    
    public TheoryAnchor(FrameworkMethod paramFrameworkMethod, TestClass paramTestClass)
    {
      this.testMethod = paramFrameworkMethod;
      this.testClass = paramTestClass;
    }
    
    private TestClass getTestClass()
    {
      return this.testClass;
    }
    
    private Statement methodCompletesWithParameters(FrameworkMethod paramFrameworkMethod, Assignments paramAssignments, Object paramObject)
    {
      return new Theories.TheoryAnchor.2(this, paramAssignments, paramFrameworkMethod, paramObject);
    }
    
    private boolean nullsOk()
    {
      Theory localTheory = (Theory)this.testMethod.getMethod().getAnnotation(Theory.class);
      if (localTheory == null) {
        return false;
      }
      return localTheory.nullsAccepted();
    }
    
    public void evaluate()
      throws Throwable
    {
      runWithAssignment(Assignments.allUnassigned(this.testMethod.getMethod(), getTestClass()));
      if (this.testMethod.getAnnotation(Theory.class) != null) {}
      for (int i = 1;; i = 0)
      {
        if ((this.successes == 0) && (i != 0)) {
          Assert.fail("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.fInvalidParameters);
        }
        return;
      }
    }
    
    protected void handleAssumptionViolation(AssumptionViolatedException paramAssumptionViolatedException)
    {
      this.fInvalidParameters.add(paramAssumptionViolatedException);
    }
    
    protected void handleDataPointSuccess()
    {
      this.successes += 1;
    }
    
    protected void reportParameterizedError(Throwable paramThrowable, Object... paramVarArgs)
      throws Throwable
    {
      if (paramVarArgs.length == 0) {
        throw paramThrowable;
      }
      throw new ParameterizedAssertionError(paramThrowable, this.testMethod.getName(), paramVarArgs);
    }
    
    protected void runWithAssignment(Assignments paramAssignments)
      throws Throwable
    {
      if (!paramAssignments.isComplete())
      {
        runWithIncompleteAssignment(paramAssignments);
        return;
      }
      runWithCompleteAssignment(paramAssignments);
    }
    
    protected void runWithCompleteAssignment(Assignments paramAssignments)
      throws Throwable
    {
      new Theories.TheoryAnchor.1(this, getTestClass().getJavaClass(), paramAssignments).methodBlock(this.testMethod).evaluate();
    }
    
    protected void runWithIncompleteAssignment(Assignments paramAssignments)
      throws Throwable
    {
      Iterator localIterator = paramAssignments.potentialsForNextUnassigned().iterator();
      while (localIterator.hasNext()) {
        runWithAssignment(paramAssignments.assignNext((PotentialAssignment)localIterator.next()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.Theories
 * JD-Core Version:    0.7.0.1
 */