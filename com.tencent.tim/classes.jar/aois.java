import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class aois
  implements PopupWindow.OnDismissListener
{
  aoit a;
  BaseActivity mContext;
  
  public aois(BaseActivity paramBaseActivity)
  {
    this.mContext = paramBaseActivity;
  }
  
  public void a(TroopChatPie paramTroopChatPie, View paramView)
  {
    paramView = (InputMethodManager)this.mContext.getSystemService("input_method");
    if (paramView.isActive()) {
      paramView.hideSoftInputFromWindow(this.mContext.getWindow().getDecorView().getWindowToken(), 0);
    }
    if (this.a == null)
    {
      this.a = aoit.a(paramTroopChatPie, this.mContext, -1, -1);
      this.a.setOnDismissListener(this);
      aohy.a(this.mContext.app).dUG();
    }
    paramTroopChatPie = this.mContext.getWindow();
    if (paramTroopChatPie != null)
    {
      paramView = paramTroopChatPie.getAttributes();
      paramView.alpha = 0.5F;
      paramTroopChatPie.setAttributes(paramView);
    }
    this.a.setAnimationStyle(2131755741);
    this.a.showAtLocation(this.mContext.getWindow().getDecorView(), 80, 0, 0);
    this.a.dUL();
  }
  
  public boolean azJ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.isShowing())
      {
        this.a.dismiss();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void dUK()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherPanel", 2, "destroyPanel");
    }
    azJ();
    this.a.onDestroy();
    this.a = null;
  }
  
  public void onDismiss()
  {
    aohy.a(this.mContext.app).QQ(false);
    Window localWindow = this.mContext.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.alpha = 1.0F;
      localWindow.setAttributes(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aois
 * JD-Core Version:    0.7.0.1
 */