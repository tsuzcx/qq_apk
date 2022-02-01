import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yip
  implements View.OnClickListener, yjf
{
  private String aWf;
  private Activity mActivity;
  private SessionInfo mSessionInfo;
  View mView;
  
  public yip(Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    this.mActivity = paramActivity;
    this.mSessionInfo = paramSessionInfo;
    this.aWf = paramString;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.mView == null)
    {
      this.mView = LayoutInflater.from(this.mActivity).inflate(2131560825, null);
      this.mView.setOnClickListener(this);
    }
    return this.mView;
  }
  
  public void a(@NonNull yjh paramyjh, boolean paramBoolean)
  {
    boolean bool = a(paramyjh);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopTipsBar", 2, new Object[] { "show() isShowing=", Boolean.valueOf(bool), ", show=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean) {
      if (!bool)
      {
        paramyjh.a(this, new Object[0]);
        aqfr.b("Grp_edu", "Grp_AIO", "mberinfotopGuidebar_Show", 0, 0, new String[] { this.mSessionInfo.aTl });
      }
    }
    while (!bool) {
      return;
    }
    paramyjh.ciA();
  }
  
  public boolean a(@NonNull yjh paramyjh)
  {
    int i = paramyjh.wN();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopTipsBar", 2, new Object[] { "show cur type=", Integer.valueOf(i) });
    }
    return i == getType();
  }
  
  public int getType()
  {
    return 19;
  }
  
  public void h(int paramInt, Object... paramVarArgs) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopTipsBar", 2, "click tips, jump to web");
    }
    apqz.p(this.mActivity, this.aWf, this.mSessionInfo.aTl, "aioTip");
    aqfr.b("Grp_edu", "Grp_AIO", "mberinfotopGuidebar_Clk", 0, 0, new String[] { this.mSessionInfo.aTl });
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public int wM()
  {
    return 58;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yip
 * JD-Core Version:    0.7.0.1
 */