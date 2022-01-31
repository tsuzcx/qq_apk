import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.util.WeakReferenceHandler;

public class cdl
  implements BaseTroopView.ITroopContext
{
  public cdl(TroopActivity paramTroopActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public View a()
  {
    return this.a.findViewById(2131296564);
  }
  
  public ForwardOperations a()
  {
    return TroopActivity.a(this.a);
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public WeakReferenceHandler a()
  {
    return TroopActivity.a(this.a);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.a.j != 2) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TroopActivity.a(this.a).a(0).a(paramBoolean);
      return;
    }
    TroopActivity.a(this.a).a(1).a(paramBoolean);
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
    return TroopActivity.a(this.a);
  }
  
  public View b()
  {
    return this.a.findViewById(2131297145);
  }
  
  public View c()
  {
    return this.a.findViewById(2131297595);
  }
  
  public View d()
  {
    return TroopActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdl
 * JD-Core Version:    0.7.0.1
 */