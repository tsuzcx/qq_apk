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

public class tmp
  extends tmo
{
  protected Map<String, tmo> a = new HashMap();
  
  public tmp(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495800, paramViewGroup, false);
  }
  
  public void a(int paramInt, tjt paramtjt, @NonNull ArrayList<tnz> paramArrayList)
  {
    super.a(paramInt, paramtjt, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tmo)localIterator.next()).a(paramInt, paramtjt, paramArrayList);
    }
  }
  
  public void a(@NonNull tmo paramtmo)
  {
    this.a.put(paramtmo.getClass().getName(), paramtmo);
  }
  
  public void a(tmp paramtmp)
  {
    super.a(paramtmp);
    paramtmp = this.a.values().iterator();
    while (paramtmp.hasNext()) {
      ((tmo)paramtmp.next()).a(this);
    }
  }
  
  public void a(tnn paramtnn)
  {
    super.a(paramtnn);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tmo)localIterator.next()).a(paramtnn);
    }
  }
  
  @Nullable
  public tmo b(Class<? extends tmo> paramClass)
  {
    return (tmo)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tmo)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((tmo)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmp
 * JD-Core Version:    0.7.0.1
 */