import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class xwm
  implements IEventReceiver
{
  private long a;
  protected Map<Subscriber, String> a;
  protected Set<xpd> a;
  public xwj a;
  protected boolean a;
  public boolean b;
  
  public Map<Subscriber, String> a()
  {
    return null;
  }
  
  public Set<xpd> a()
  {
    return null;
  }
  
  public void a()
  {
    Iterator localIterator;
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Subscriber)((Map.Entry)localIterator.next()).getKey();
        wjj.a().unRegisterSubscriber((Subscriber)localObject);
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (xpd)localIterator.next();
        this.jdField_a_of_type_Xwj.b((xpd)localObject);
      }
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public final void a(@NonNull xwj paramxwj, int paramInt, @NonNull xqz paramxqz)
  {
    xwj.a(paramxwj, paramInt);
    this.jdField_a_of_type_Xwj = paramxwj;
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject1 = a();
      if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
      {
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          wjj.a().registerSubscriber((String)localObject2, localSubscriber);
        }
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          this.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        this.jdField_a_of_type_JavaUtilMap.putAll((Map)localObject1);
      }
      localObject1 = a();
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
      {
        if (this.jdField_a_of_type_JavaUtilSet == null) {
          this.jdField_a_of_type_JavaUtilSet = new HashSet();
        }
        this.jdField_a_of_type_JavaUtilSet.addAll((Collection)localObject1);
      }
      this.jdField_a_of_type_Boolean = true;
    }
    a(paramxwj.a, paramxqz);
  }
  
  public final void a(xwn paramxwn, xqz paramxqz)
  {
    paramxwn.a();
    b(paramxwn, paramxqz);
  }
  
  public boolean a(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return false;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  public abstract void b(xwn paramxwn, xqz paramxqz);
  
  public boolean isValidate()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwm
 * JD-Core Version:    0.7.0.1
 */