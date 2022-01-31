import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.WeakReferenceHandler;
import mqq.app.AppRuntime;

public class eih
  implements NearbyTroopsBaseView.INearbyTroopContext
{
  public eih(NearbyTroopsActivity paramNearbyTroopsActivity) {}
  
  public int a()
  {
    return this.a.I;
  }
  
  public Activity a()
  {
    return this.a;
  }
  
  public View a()
  {
    return this.a.findViewById(2131297591);
  }
  
  public TextView a()
  {
    return NearbyTroopsActivity.b(this.a);
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public WeakReferenceHandler a()
  {
    return NearbyTroopsActivity.a(this.a);
  }
  
  public String a()
  {
    return this.a.d;
  }
  
  public AppRuntime a()
  {
    return NearbyTroopsActivity.a(this.a);
  }
  
  public void a(int paramInt)
  {
    NearbyTroopsActivity.a(this.a).setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.a.b(paramCharSequence);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.runOnUiThread(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.a.isResume()) {
      QQToast.a(a(), paramString, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  public boolean a()
  {
    return this.a.f();
  }
  
  public void b(int paramInt)
  {
    NearbyTroopsActivity.a(this.a).setVisibility(paramInt);
  }
  
  public void b(CharSequence paramCharSequence) {}
  
  public boolean b()
  {
    return this.a.d();
  }
  
  public boolean c()
  {
    return this.a.e();
  }
  
  public boolean d()
  {
    return (this.a == null) || (!this.a.isResume());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eih
 * JD-Core Version:    0.7.0.1
 */