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

public class tzl
  extends tzk
{
  protected Map<String, tzk> a = new HashMap();
  
  public tzl(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561391, paramViewGroup, false);
  }
  
  public void a(int paramInt, twp paramtwp, @NonNull ArrayList<uav> paramArrayList)
  {
    super.a(paramInt, paramtwp, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tzk)localIterator.next()).a(paramInt, paramtwp, paramArrayList);
    }
  }
  
  public void a(@NonNull tzk paramtzk)
  {
    this.a.put(paramtzk.getClass().getName(), paramtzk);
  }
  
  public void a(tzl paramtzl)
  {
    super.a(paramtzl);
    paramtzl = this.a.values().iterator();
    while (paramtzl.hasNext()) {
      ((tzk)paramtzl.next()).a(this);
    }
  }
  
  public void a(uaj paramuaj)
  {
    super.a(paramuaj);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tzk)localIterator.next()).a(paramuaj);
    }
  }
  
  @Nullable
  public tzk b(Class<? extends tzk> paramClass)
  {
    return (tzk)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tzk)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tzk)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzl
 * JD-Core Version:    0.7.0.1
 */