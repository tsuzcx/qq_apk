import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aoci
  extends aobo
{
  public aoci(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment) {}
  
  public void e(boolean paramBoolean, String paramString, int paramInt, List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      ahao.JD(acfp.m(2131715185));
    }
    while (!paramString.equalsIgnoreCase(this.a.cjl)) {
      return;
    }
    this.a.GQ.clear();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (TimDocSSOMsg.UinRightInfo)paramString.next();
      aoae.b localb = new aoae.b();
      localb.uin = String.valueOf(paramList.uint64_uin.get());
      localb.b = paramList;
      this.a.a.a(localb);
    }
    this.a.dNL = paramInt;
    TeamWorkAuthorizeSettingFragment.a(this.a, this.a.dNL);
    TeamWorkAuthorizeSettingFragment.a(this.a);
    TeamWorkAuthorizeSettingFragment.a(this.a, true);
  }
  
  public void u(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      ahao.JD(acfp.m(2131715197));
    }
    while ((this.a.dNK != paramInt) && (!paramString.equalsIgnoreCase(this.a.cjl))) {
      return;
    }
    if ((0 == 0) && (QLog.isDevelopLevel())) {
      QLog.i("TeamWorkAuthorizeSettingFragment", 1, "padInfo is null, maybe is newpad");
    }
    this.a.GQ.clear();
    if (0 != 0) {
      throw new NullPointerException();
    }
    for (;;)
    {
      TeamWorkAuthorizeSettingFragment.a(this.a, this.a.dNL);
      TeamWorkAuthorizeSettingFragment.a(this.a);
      TeamWorkAuthorizeSettingFragment.a(this.a, true);
      return;
      this.a.dNL = 2;
    }
  }
  
  public void v(boolean paramBoolean, String paramString, int paramInt)
  {
    TeamWorkAuthorizeSettingFragment.a(this.a, true);
    this.a.getRightTextView().setEnabled(true);
    this.a.stopTitleProgress();
    if (!paramBoolean) {
      ahao.JD(acfp.m(2131715140));
    }
    Intent localIntent;
    do
    {
      return;
      ahao.JE(acfp.m(2131715142));
      this.a.stopTitleProgress();
      localIntent = new Intent();
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("type", paramInt);
    } while (!this.a.isAdded());
    this.a.getActivity().setResult(1122, localIntent);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoci
 * JD-Core Version:    0.7.0.1
 */