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

public class xfv
  extends xfu
{
  protected Map<String, xfu> a = new HashMap();
  
  public xfv(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561819, paramViewGroup, false);
  }
  
  public void a(int paramInt, xcz paramxcz, @NonNull ArrayList<xhf> paramArrayList)
  {
    super.a(paramInt, paramxcz, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xfu)localIterator.next()).a(paramInt, paramxcz, paramArrayList);
    }
  }
  
  public void a(@NonNull xfu paramxfu)
  {
    this.a.put(paramxfu.getClass().getName(), paramxfu);
  }
  
  public void a(xfv paramxfv)
  {
    super.a(paramxfv);
    paramxfv = this.a.values().iterator();
    while (paramxfv.hasNext()) {
      ((xfu)paramxfv.next()).a(this);
    }
  }
  
  public void a(xgt paramxgt)
  {
    super.a(paramxgt);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xfu)localIterator.next()).a(paramxgt);
    }
  }
  
  @Nullable
  public xfu b(Class<? extends xfu> paramClass)
  {
    return (xfu)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xfu)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xfu)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfv
 * JD-Core Version:    0.7.0.1
 */