import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class yjm
  implements yjf
{
  private View.OnClickListener C = new yjn(this);
  public apat a;
  private yjh a;
  private QQAppInterface app;
  private boolean bmQ;
  public Toast e;
  private View.OnClickListener ei = new yjo(this);
  private BaseActivity mActivity;
  private SessionInfo sessionInfo;
  
  public yjm(QQAppInterface paramQQAppInterface, yjh paramyjh, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, apat paramapat, Toast paramToast)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Yjh = paramyjh;
    this.mActivity = paramBaseActivity;
    this.sessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Apat = paramapat;
    this.e = paramToast;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = this.mActivity.getString(2131721468);
    if (this.app.cs(this.sessionInfo.aTl) == 3) {
      paramVarArgs = this.mActivity.getString(2131721469);
    }
    View localView = ChatActivityUtils.a(this.mActivity, paramVarArgs, this.ei, this.C);
    anot.a(this.app, "P_CliOper", "Grp_msg", "", "AIOchat", "exp_setmsg", 0, 0, this.sessionInfo.aTl, "", "", "");
    QQAppInterface localQQAppInterface = this.app;
    String str = this.sessionInfo.aTl;
    if (this.app.cs(this.sessionInfo.aTl) == 3) {}
    for (paramVarArgs = "1";; paramVarArgs = "0")
    {
      anot.a(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "exp_topbar", 0, 0, str, paramVarArgs, "", "");
      return localView;
    }
  }
  
  public void caS()
  {
    if ((isShowing()) || (this.bmQ)) {
      aizp.a().an(this.app, this.sessionInfo.aTl);
    }
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    do
    {
      do
      {
        return;
      } while (this.sessionInfo.cZ != 1);
      if ((this.jdField_a_of_type_Apat == null) || (!this.jdField_a_of_type_Apat.aAL())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAssistTipsBar", 2, "navigateBar is show, return ");
    return;
    ThreadManager.post(new TroopAssistTipsBar.1(this), 8, null, true);
  }
  
  public boolean isShowing()
  {
    return 3 == this.jdField_a_of_type_Yjh.wN();
  }
  
  public int wM()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjm
 * JD-Core Version:    0.7.0.1
 */