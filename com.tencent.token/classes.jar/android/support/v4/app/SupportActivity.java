package android.support.v4.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.token.bj;
import com.tencent.token.bj.b;
import com.tencent.token.bm;
import com.tencent.token.bn;
import com.tencent.token.bv;
import com.tencent.token.ex;

public class SupportActivity
  extends Activity
  implements bm
{
  private ex<Class<? extends a>, a> mExtraDataMap = new ex();
  private bn mLifecycleRegistry = new bn(this);
  
  public <T extends a> T getExtraData(Class<T> paramClass)
  {
    return (a)this.mExtraDataMap.get(paramClass);
  }
  
  public bj getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bv.a(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLifecycleRegistry.a(bj.b.c);
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