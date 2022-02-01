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

public class qis
  extends qir
{
  protected Map<String, qir> fS = new HashMap();
  
  public qis(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public void a(int paramInt, qgy.d paramd, @NonNull ArrayList<qjq> paramArrayList)
  {
    super.a(paramInt, paramd, paramArrayList);
    Iterator localIterator = this.fS.values().iterator();
    while (localIterator.hasNext()) {
      ((qir)localIterator.next()).a(paramInt, paramd, paramArrayList);
    }
  }
  
  public void a(@NonNull qir paramqir)
  {
    this.fS.put(paramqir.getClass().getName(), paramqir);
  }
  
  public void a(qis paramqis)
  {
    super.a(paramqis);
    paramqis = this.fS.values().iterator();
    while (paramqis.hasNext()) {
      ((qir)paramqis.next()).a(this);
    }
  }
  
  public void a(qji paramqji)
  {
    super.a(paramqji);
    Iterator localIterator = this.fS.values().iterator();
    while (localIterator.hasNext()) {
      ((qir)localIterator.next()).a(paramqji);
    }
  }
  
  @Nullable
  public qir b(Class<? extends qir> paramClass)
  {
    return (qir)this.fS.get(paramClass.getName());
  }
  
  public void boy()
  {
    super.boy();
    Iterator localIterator = this.fS.values().iterator();
    while (localIterator.hasNext()) {
      ((qir)localIterator.next()).boy();
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    Iterator localIterator = this.fS.values().iterator();
    while (localIterator.hasNext()) {
      ((qir)localIterator.next()).onCreate();
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561991, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qis
 * JD-Core Version:    0.7.0.1
 */