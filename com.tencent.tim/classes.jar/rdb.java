import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class rdb
  implements IEventReceiver
{
  protected long BK;
  public rel a;
  @NonNull
  public final rdc b;
  
  public rdb(@NonNull rdc paramrdc)
  {
    this.b = paramrdc;
  }
  
  private void checkState()
  {
    if (this.a == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  public rdb.a a(Class<? extends rdb.a> paramClass)
  {
    checkState();
    return this.b.a(paramClass);
  }
  
  @NonNull
  public rel a()
  {
    checkState();
    return this.a;
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    a(paramrkm);
  }
  
  public void a(Class<? extends rdb.a> paramClass, rdb.a parama)
  {
    checkState();
    this.b.a(paramClass, parama);
  }
  
  public void a(rel paramrel)
  {
    if (this.a != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramrel == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.a = paramrel;
  }
  
  @Deprecated
  public void a(@NonNull rkm paramrkm) {}
  
  public void c(@NonNull Error paramError) {}
  
  public void c(@NonNull rkm paramrkm) {}
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    p(paramInt2, paramObject);
  }
  
  protected boolean e(Message paramMessage)
  {
    return false;
  }
  
  public final boolean f(@NonNull Message paramMessage)
  {
    boolean bool = e(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  @NonNull
  public Context getContext()
  {
    checkState();
    return this.a.getContext();
  }
  
  @NonNull
  public Resources getResources()
  {
    checkState();
    return this.a.getContext().getResources();
  }
  
  protected String getString(int paramInt)
  {
    checkState();
    return getResources().getString(paramInt);
  }
  
  public boolean isValidate()
  {
    return this.b.isValidate();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    checkState();
  }
  
  public boolean onBackPressed()
  {
    checkState();
    return false;
  }
  
  public void onCreate()
  {
    checkState();
  }
  
  public void onDestroy()
  {
    checkState();
  }
  
  public void onPause()
  {
    checkState();
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    checkState();
  }
  
  public void onResume()
  {
    checkState();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    checkState();
  }
  
  public void onStart()
  {
    checkState();
  }
  
  public void onStop()
  {
    checkState();
  }
  
  public void p(int paramInt, Object paramObject) {}
  
  @NonNull
  protected View y(int paramInt)
  {
    checkState();
    View localView = this.a.getRootView().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdb
 * JD-Core Version:    0.7.0.1
 */