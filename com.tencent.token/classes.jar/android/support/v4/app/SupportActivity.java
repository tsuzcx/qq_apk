package android.support.v4.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.token.au;
import com.tencent.token.au.b;
import com.tencent.token.aw;
import com.tencent.token.ax;
import com.tencent.token.be;
import com.tencent.token.eg;

public class SupportActivity
  extends Activity
  implements aw
{
  private eg<Class<? extends a>, a> mExtraDataMap = new eg();
  private ax mLifecycleRegistry = new ax(this);
  
  public <T extends a> T getExtraData(Class<T> paramClass)
  {
    return (a)this.mExtraDataMap.get(paramClass);
  }
  
  public au getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    be.a(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLifecycleRegistry.a(au.b.c);
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