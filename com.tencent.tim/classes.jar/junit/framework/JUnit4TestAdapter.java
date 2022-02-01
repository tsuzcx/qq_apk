package junit.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Ignore;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;

public class JUnit4TestAdapter
  implements Test, Describable, Filterable, Sortable
{
  private final JUnit4TestAdapterCache fCache;
  private final Class<?> fNewTestClass;
  private final Runner fRunner;
  
  public JUnit4TestAdapter(Class<?> paramClass)
  {
    this(paramClass, JUnit4TestAdapterCache.getDefault());
  }
  
  public JUnit4TestAdapter(Class<?> paramClass, JUnit4TestAdapterCache paramJUnit4TestAdapterCache)
  {
    this.fCache = paramJUnit4TestAdapterCache;
    this.fNewTestClass = paramClass;
    this.fRunner = Request.classWithoutSuiteMethod(paramClass).getRunner();
  }
  
  private boolean isIgnored(Description paramDescription)
  {
    return paramDescription.getAnnotation(Ignore.class) != null;
  }
  
  private Description removeIgnored(Description paramDescription)
  {
    if (isIgnored(paramDescription)) {
      return Description.EMPTY;
    }
    Description localDescription1 = paramDescription.childlessCopy();
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext())
    {
      Description localDescription2 = removeIgnored((Description)paramDescription.next());
      if (!localDescription2.isEmpty()) {
        localDescription1.addChild(localDescription2);
      }
    }
    return localDescription1;
  }
  
  public int countTestCases()
  {
    return this.fRunner.testCount();
  }
  
  public void filter(Filter paramFilter)
    throws NoTestsRemainException
  {
    paramFilter.apply(this.fRunner);
  }
  
  public Description getDescription()
  {
    return removeIgnored(this.fRunner.getDescription());
  }
  
  public Class<?> getTestClass()
  {
    return this.fNewTestClass;
  }
  
  public List<Test> getTests()
  {
    return this.fCache.asTestList(getDescription());
  }
  
  public void run(TestResult paramTestResult)
  {
    this.fRunner.run(this.fCache.getNotifier(paramTestResult, this));
  }
  
  public void sort(Sorter paramSorter)
  {
    paramSorter.apply(this.fRunner);
  }
  
  public String toString()
  {
    return this.fNewTestClass.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     junit.framework.JUnit4TestAdapter
 * JD-Core Version:    0.7.0.1
 */