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

public abstract class ttm
  implements IEventReceiver
{
  private long a;
  protected Map<Subscriber, String> a;
  protected Set<tmd> a;
  public ttj a;
  protected boolean a;
  public boolean b;
  
  public Map<Subscriber, String> a()
  {
    return null;
  }
  
  public Set<tmd> a()
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
        sgi.a().unRegisterSubscriber((Subscriber)localObject);
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (tmd)localIterator.next();
        this.jdField_a_of_type_Ttj.b((tmd)localObject);
      }
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public final void a(@NonNull ttj paramttj, int paramInt, @NonNull tnz paramtnz)
  {
    ttj.a(paramttj, paramInt);
    this.jdField_a_of_type_Ttj = paramttj;
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
          sgi.a().registerSubscriber((String)localObject2, localSubscriber);
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
    a(paramttj.a, paramtnz);
  }
  
  public final void a(ttn paramttn, tnz paramtnz)
  {
    paramttn.a();
    b(paramttn, paramtnz);
  }
  
  public boolean a(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return false;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  public abstract void b(ttn paramttn, tnz paramtnz);
  
  public boolean isValidate()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ttm
 * JD-Core Version:    0.7.0.1
 */