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

public class vsj
  extends vsi
{
  protected Map<String, vsi> a = new HashMap();
  
  public vsj(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561598, paramViewGroup, false);
  }
  
  public void a(int paramInt, vpn paramvpn, @NonNull ArrayList<vtt> paramArrayList)
  {
    super.a(paramInt, paramvpn, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((vsi)localIterator.next()).a(paramInt, paramvpn, paramArrayList);
    }
  }
  
  public void a(@NonNull vsi paramvsi)
  {
    this.a.put(paramvsi.getClass().getName(), paramvsi);
  }
  
  public void a(vsj paramvsj)
  {
    super.a(paramvsj);
    paramvsj = this.a.values().iterator();
    while (paramvsj.hasNext()) {
      ((vsi)paramvsj.next()).a(this);
    }
  }
  
  public void a(vth paramvth)
  {
    super.a(paramvth);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((vsi)localIterator.next()).a(paramvth);
    }
  }
  
  @Nullable
  public vsi b(Class<? extends vsi> paramClass)
  {
    return (vsi)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((vsi)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((vsi)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsj
 * JD-Core Version:    0.7.0.1
 */