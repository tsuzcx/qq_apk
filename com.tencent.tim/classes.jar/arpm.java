import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class arpm
  extends asau
{
  public arpm(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  protected void W(boolean paramBoolean, List<AppInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityControlActivity", 2, "onDelApp: invoked.  isSuccess: " + paramBoolean + " infos: " + paramList);
    }
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      AuthorityControlFragment.a(this.this$0).nm(paramList);
      AuthorityControlFragment.a(this.this$0).elG();
      if (AuthorityControlFragment.a(this.this$0).getCount() == 0) {
        AuthorityControlFragment.a(this.this$0);
      }
      int i = paramList.size();
      paramList = String.format(acfp.m(2131702927), new Object[] { Integer.valueOf(i) });
      QQToast.a(AuthorityControlFragment.a(this.this$0), 2, paramList, 0).show();
      localQQAppInterface = AuthorityControlFragment.a(this.this$0);
      if (!paramBoolean) {
        break label207;
      }
    }
    label207:
    for (paramList = "0";; paramList = "1")
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009E1D", "0X8009E1D", 0, 0, paramList, "", "", "");
      return;
      QQToast.a(AuthorityControlFragment.a(this.this$0), 1, acfp.m(2131702931), 0).show();
      break;
    }
  }
  
  protected void c(boolean paramBoolean, List<AppInfo> paramList, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityControlActivity", 2, "onGetAuthorizeAppList: invoked.  isSuccess: " + paramBoolean + " infos: " + paramList);
    }
    if (paramBoolean)
    {
      paramString = paramList;
      if (paramList == null) {
        paramString = new ArrayList();
      }
      AuthorityControlFragment.a(this.this$0).nl(paramString);
      AuthorityControlFragment.a(this.this$0, new ArrayList(paramString));
      if (AuthorityControlFragment.a(this.this$0).getCount() == 0) {
        AuthorityControlFragment.a(this.this$0);
      }
    }
    for (;;)
    {
      AuthorityControlFragment.a(this.this$0).notifyDataSetChanged();
      if ((AuthorityControlFragment.a(this.this$0).isShowing()) && (!this.this$0.isRemoving())) {}
      try
      {
        AuthorityControlFragment.a(this.this$0).dismiss();
        label148:
        AuthorityControlFragment.a(this.this$0, paramBoolean);
        return;
        AuthorityControlFragment.a(this.this$0).setVisibility(0);
        this.this$0.setRightButton(2131690649, this.this$0);
        continue;
        AuthorityControlFragment.a(this.this$0);
      }
      catch (Throwable paramList)
      {
        break label148;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpm
 * JD-Core Version:    0.7.0.1
 */