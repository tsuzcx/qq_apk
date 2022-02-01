import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.UinRightInfo;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamwork.TeamWorkAuthorizeSettingActivity;
import java.util.Iterator;
import java.util.List;

public class aukk
  extends aulm
{
  public aukk(TeamWorkAuthorizeSettingActivity paramTeamWorkAuthorizeSettingActivity) {}
  
  public void e(boolean paramBoolean, String paramString, int paramInt, List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      ahao.JD("权限获取失败，请稍后再试。");
    }
    while (!paramString.equalsIgnoreCase(this.a.cjl)) {
      return;
    }
    this.a.GQ.clear();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (TimDocSSOMsg.UinRightInfo)paramString.next();
      aukn.b localb = new aukn.b();
      localb.uin = String.valueOf(paramList.uint64_uin.get());
      localb.c = paramList;
      this.a.a.a(localb);
    }
    this.a.dNL = paramInt;
    TeamWorkAuthorizeSettingActivity.a(this.a, this.a.dNL);
    TeamWorkAuthorizeSettingActivity.a(this.a);
    TeamWorkAuthorizeSettingActivity.a(this.a, true);
  }
  
  public void u(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      ahao.JD("权限获取失败，请稍后再试。");
    }
    while ((this.a.dNK != paramInt) && (!paramString.equalsIgnoreCase(this.a.cjl))) {
      return;
    }
    PadInfo localPadInfo = null;
    Object localObject = (aull)this.a.app.getManager(372);
    if (localObject != null) {
      localPadInfo = ((aull)localObject).a(paramString, paramInt);
    }
    if ((localPadInfo == null) && (QLog.isDevelopLevel())) {
      QLog.i("TeamWorkAuthorizeSettingActivity", 1, "padInfo is null, maybe is newpad");
    }
    this.a.GQ.clear();
    if (localPadInfo != null)
    {
      paramString = localPadInfo.getRightList().iterator();
      while (paramString.hasNext())
      {
        localObject = (TimDocSSOMsg.UinRightInfo)paramString.next();
        aukn.b localb = new aukn.b();
        localb.uin = String.valueOf(((TimDocSSOMsg.UinRightInfo)localObject).uint64_uin.get());
        localb.c = ((TimDocSSOMsg.UinRightInfo)localObject);
        this.a.a.a(localb);
      }
    }
    for (this.a.dNL = localPadInfo.policy;; this.a.dNL = 2)
    {
      TeamWorkAuthorizeSettingActivity.a(this.a, this.a.dNL);
      TeamWorkAuthorizeSettingActivity.a(this.a);
      TeamWorkAuthorizeSettingActivity.a(this.a, true);
      return;
    }
  }
  
  public void v(boolean paramBoolean, String paramString, int paramInt)
  {
    TeamWorkAuthorizeSettingActivity.a(this.a, true);
    this.a.getRightTextView().setEnabled(true);
    this.a.stopTitleProgress();
    if (!paramBoolean)
    {
      ahao.JD("权限设置失败，请稍后再试。");
      return;
    }
    QQToast.a(this.a, 2, "权限设置成功", 0).show(this.a.getTitleBarHeight());
    Object localObject = (aull)this.a.app.getManager(372);
    if (localObject != null)
    {
      PadInfo localPadInfo = ((aull)localObject).a(paramString, paramInt);
      if (localPadInfo != null) {
        localPadInfo.policy = this.a.dNL;
      }
      ((aull)localObject).h(localPadInfo);
    }
    this.a.stopTitleProgress();
    localObject = new Intent();
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("type", paramInt);
    this.a.setResult(1122, (Intent)localObject);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukk
 * JD-Core Version:    0.7.0.1
 */