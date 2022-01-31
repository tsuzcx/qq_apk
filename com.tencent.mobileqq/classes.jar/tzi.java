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

public class tzi
  extends tzh
{
  protected Map<String, tzh> a = new HashMap();
  
  public tzi(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561390, paramViewGroup, false);
  }
  
  public void a(int paramInt, twm paramtwm, @NonNull ArrayList<uas> paramArrayList)
  {
    super.a(paramInt, paramtwm, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tzh)localIterator.next()).a(paramInt, paramtwm, paramArrayList);
    }
  }
  
  public void a(@NonNull tzh paramtzh)
  {
    this.a.put(paramtzh.getClass().getName(), paramtzh);
  }
  
  public void a(tzi paramtzi)
  {
    super.a(paramtzi);
    paramtzi = this.a.values().iterator();
    while (paramtzi.hasNext()) {
      ((tzh)paramtzi.next()).a(this);
    }
  }
  
  public void a(uag paramuag)
  {
    super.a(paramuag);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tzh)localIterator.next()).a(paramuag);
    }
  }
  
  @Nullable
  public tzh b(Class<? extends tzh> paramClass)
  {
    return (tzh)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tzh)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tzh)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzi
 * JD-Core Version:    0.7.0.1
 */