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

public class wra
  extends wqz
{
  protected Map<String, wqz> a = new HashMap();
  
  public wra(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561751, paramViewGroup, false);
  }
  
  public void a(int paramInt, woe paramwoe, @NonNull ArrayList<wsk> paramArrayList)
  {
    super.a(paramInt, paramwoe, paramArrayList);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((wqz)localIterator.next()).a(paramInt, paramwoe, paramArrayList);
    }
  }
  
  public void a(@NonNull wqz paramwqz)
  {
    this.a.put(paramwqz.getClass().getName(), paramwqz);
  }
  
  public void a(wra paramwra)
  {
    super.a(paramwra);
    paramwra = this.a.values().iterator();
    while (paramwra.hasNext()) {
      ((wqz)paramwra.next()).a(this);
    }
  }
  
  public void a(wry paramwry)
  {
    super.a(paramwry);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((wqz)localIterator.next()).a(paramwry);
    }
  }
  
  @Nullable
  public wqz b(Class<? extends wqz> paramClass)
  {
    return (wqz)this.a.get(paramClass.getName());
  }
  
  protected void b()
  {
    super.b();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((wqz)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((wqz)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wra
 * JD-Core Version:    0.7.0.1
 */