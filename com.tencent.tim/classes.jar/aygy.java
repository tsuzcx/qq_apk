import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;
import org.json.JSONObject;

public abstract class aygy
  implements IEventReceiver
{
  protected long BK;
  public boolean Yp;
  public ayii a;
  @NonNull
  public final aygz b;
  
  public aygy(@NonNull aygz paramaygz)
  {
    this.b = paramaygz;
  }
  
  private void checkState()
  {
    if (this.a == null) {
      ambe.j(new IllegalStateException("have not attached ui"));
    }
  }
  
  public boolean Qk()
  {
    return (this.a == null) || (this.a.getActivity() == null) || (this.a.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.a.getActivity().isDestroyed()));
  }
  
  public int RR()
  {
    return this.b.RR();
  }
  
  public aygy.a a(Class<? extends aygy.a> paramClass)
  {
    checkState();
    return this.b.a(paramClass);
  }
  
  @NonNull
  public ayii a()
  {
    checkState();
    return this.a;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    a(paramayqb);
  }
  
  public void a(ayii paramayii)
  {
    if (this.a != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramayii == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.a = paramayii;
  }
  
  @Deprecated
  public void a(@NonNull ayqb paramayqb) {}
  
  public void a(Class<? extends aygy.a> paramClass, aygy.a parama)
  {
    checkState();
    this.b.a(paramClass, parama);
  }
  
  public void c(@NonNull ayqb paramayqb)
  {
    ((axpr)axov.a(5)).cT(this.a.getActivity());
  }
  
  public void c(@NonNull Error paramError) {}
  
  public void cm(JSONObject paramJSONObject) {}
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    p(paramInt2, paramObject);
  }
  
  protected boolean e(Message paramMessage)
  {
    return false;
  }
  
  public void eRE()
  {
    this.a = null;
  }
  
  public void eRt() {}
  
  public void eRy() {}
  
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
  
  public void onActivityFinish() {}
  
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
    this.Yp = true;
    eRE();
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
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    checkState();
  }
  
  public void p(int paramInt, Object paramObject) {}
  
  @NonNull
  public View y(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygy
 * JD-Core Version:    0.7.0.1
 */