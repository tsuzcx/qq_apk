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

public class xlu
  extends xlt
{
  protected Map<String, xlt> a = new HashMap();
  
  public xlu(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561833, paramViewGroup, false);
  }
  
  public void a(int paramInt, xiy paramxiy, @NonNull ArrayList<xne> paramArrayList)
  {
    super.a(paramInt, paramxiy, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xlt)localIterator.next()).a(paramInt, paramxiy, paramArrayList);
    }
  }
  
  public void a(@NonNull xlt paramxlt)
  {
    this.a.put(paramxlt.getClass().getName(), paramxlt);
  }
  
  public void a(xlu paramxlu)
  {
    super.a(paramxlu);
    paramxlu = this.a.values().iterator();
    while (paramxlu.hasNext()) {
      ((xlt)paramxlu.next()).a(this);
    }
  }
  
  public void a(xms paramxms)
  {
    super.a(paramxms);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xlt)localIterator.next()).a(paramxms);
    }
  }
  
  @Nullable
  public xlt b(Class<? extends xlt> paramClass)
  {
    return (xlt)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xlt)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((xlt)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlu
 * JD-Core Version:    0.7.0.1
 */