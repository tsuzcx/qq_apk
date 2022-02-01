package org.junit.runners.parameterized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.runners.model.TestClass;

public class TestWithParameters
{
  private final String name;
  private final List<Object> parameters;
  private final TestClass testClass;
  
  public TestWithParameters(String paramString, TestClass paramTestClass, List<Object> paramList)
  {
    notNull(paramString, "The name is missing.");
    notNull(paramTestClass, "The test class is missing.");
    notNull(paramList, "The parameters are missing.");
    this.name = paramString;
    this.testClass = paramTestClass;
    this.parameters = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  private static void notNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (TestWithParameters)paramObject;
    } while ((this.name.equals(paramObject.name)) && (this.parameters.equals(paramObject.parameters)) && (this.testClass.equals(paramObject.testClass)));
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<Object> getParameters()
  {
    return this.parameters;
  }
  
  public TestClass getTestClass()
  {
    return this.testClass;
  }
  
  public int hashCode()
  {
    return 14747 * ((this.name.hashCode() + 14747) * 14747 + this.testClass.hashCode()) + this.parameters.hashCode();
  }
  
  public String toString()
  {
    return this.testClass.getName() + " '" + this.name + "' with parameters " + this.parameters;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runners.parameterized.TestWithParameters
 * JD-Core Version:    0.7.0.1
 */