import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class xpp
  extends xpo
{
  protected Map<String, xpo> a = new HashMap();
  
  public xpp(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561874, paramViewGroup, false);
  }
  
  public void a(int paramInt, xmt paramxmt, @NonNull ArrayList<xqz> paramArrayList)
  {
    super.a(paramInt, paramxmt, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xpo)localIterator.next()).a(paramInt, paramxmt, paramArrayList);
    }
  }
  
  public void a(@NonNull xpo paramxpo)
  {
    this.a.put(paramxpo.getClass().getName(), paramxpo);
  }
  
  public void a(xpp paramxpp)
  {
    super.a(paramxpp);
    paramxpp = this.a.values().iterator();
    while (paramxpp.hasNext()) {
      ((xpo)paramxpp.next()).a(this);
    }
  }
  
  public void a(xqn paramxqn)
  {
    super.a(paramxqn);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xpo)localIterator.next()).a(paramxqn);
    }
  }
  
  @Nullable
  public xpo b(Class<? extends xpo> paramClass)
  {
    return (xpo)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xpo)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xpo)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpp
 * JD-Core Version:    0.7.0.1
 */