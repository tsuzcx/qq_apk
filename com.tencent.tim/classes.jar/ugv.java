import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity.8.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;

public class ugv
  extends acfd
{
  public ugv(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  void c(String paramString, View paramView)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramView == null)) {
      return;
    }
    this.this$0.runOnUiThread(new AssociatedAccountManageActivity.8.1(this, paramString, paramView));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    View localView;
    do
    {
      return;
      localView = AssociatedAccountManageActivity.a(this.this$0, paramString, 0);
      if (localView != null) {
        c(paramString, localView);
      }
      localView = AssociatedAccountManageActivity.a(this.this$0, paramString, 1);
    } while (localView == null);
    c(paramString, localView);
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "onUpdateFriendInfo  uin = " + paramString + " isSuccess = " + paramBoolean);
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    View localView;
    do
    {
      return;
      localView = AssociatedAccountManageActivity.a(this.this$0, paramString, 0);
      if (localView != null)
      {
        ((SingleLineTextView)localView.findViewById(2131372190)).setText(aqgv.n(this.this$0.app, paramString));
        c(paramString, localView);
      }
      localView = AssociatedAccountManageActivity.a(this.this$0, paramString, 1);
    } while (localView == null);
    ((SingleLineTextView)localView.findViewById(2131372190)).setText(aqgv.n(this.this$0.app, paramString));
    c(paramString, localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugv
 * JD-Core Version:    0.7.0.1
 */