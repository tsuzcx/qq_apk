package android.support.v4.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.token.av;
import com.tencent.token.av.b;
import com.tencent.token.ay;
import com.tencent.token.az;
import com.tencent.token.bh;
import com.tencent.token.ej;

public class SupportActivity
  extends Activity
  implements ay
{
  private ej<Class<? extends a>, a> mExtraDataMap = new ej();
  private az mLifecycleRegistry = new az(this);
  
  public <T extends a> T getExtraData(Class<T> paramClass)
  {
    return (a)this.mExtraDataMap.get(paramClass);
  }
  
  public av getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bh.a(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLifecycleRegistry.a(av.b.c);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void putExtraData(a parama)
  {
    this.mExtraDataMap.put(parama.getClass(), parama);
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.SupportActivity
 * JD-Core Version:    0.7.0.1
 */