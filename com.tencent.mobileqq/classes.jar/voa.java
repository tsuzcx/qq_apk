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

public class voa
  extends vnz
{
  protected Map<String, vnz> a = new HashMap();
  
  public voa(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561580, paramViewGroup, false);
  }
  
  public void a(int paramInt, vle paramvle, @NonNull ArrayList<vpk> paramArrayList)
  {
    super.a(paramInt, paramvle, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((vnz)localIterator.next()).a(paramInt, paramvle, paramArrayList);
    }
  }
  
  public void a(@NonNull vnz paramvnz)
  {
    this.a.put(paramvnz.getClass().getName(), paramvnz);
  }
  
  public void a(voa paramvoa)
  {
    super.a(paramvoa);
    paramvoa = this.a.values().iterator();
    while (paramvoa.hasNext()) {
      ((vnz)paramvoa.next()).a(this);
    }
  }
  
  public void a(voy paramvoy)
  {
    super.a(paramvoy);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((vnz)localIterator.next()).a(paramvoy);
    }
  }
  
  @Nullable
  public vnz b(Class<? extends vnz> paramClass)
  {
    return (vnz)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((vnz)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((vnz)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     voa
 * JD-Core Version:    0.7.0.1
 */