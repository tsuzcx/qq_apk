import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tpa<T>
  implements toz<T>
{
  private List<Class<? extends T>> pY = new ArrayList();
  private List<T> pZ = new ArrayList();
  
  private T create(Class<? extends T> paramClass)
  {
    try
    {
      paramClass = paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      QLog.e("ClassGeneratorImpl", 1, paramClass, new Object[0]);
    }
    return null;
  }
  
  private T getInstance(Class<? extends T> paramClass)
  {
    Iterator localIterator = this.pZ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject.getClass().equals(paramClass)) {
        return localObject;
      }
    }
    return null;
  }
  
  public List<T> cB()
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.pY.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Class)localIterator.next();
        Object localObject2 = getInstance((Class)localObject1);
        if (localObject2 != null)
        {
          localArrayList.add(localObject2);
          continue;
        }
        localObject1 = create((Class)localObject1);
      }
      finally {}
      if (localObject1 != null)
      {
        this.pZ.add(localObject1);
        localList.add(localObject1);
      }
    }
    return localList;
  }
  
  public void register(Class<? extends T> paramClass)
  {
    if (paramClass != null) {}
    try
    {
      if (!this.pY.contains(paramClass)) {
        this.pY.add(paramClass);
      }
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tpa
 * JD-Core Version:    0.7.0.1
 */