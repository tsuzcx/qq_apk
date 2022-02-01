import android.content.Context;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

public class lqn
  implements ViewBase.OnClickListener
{
  private final String TAG = "OnSmallGameCardClickListener";
  private LaunchParam jdField_a_of_type_ComTencentMobileqqMiniSdkLaunchParam = new LaunchParam();
  private jyq jdField_a_of_type_Jyq;
  private ArticleInfo b;
  private int channelID;
  private int cmd;
  private Context context;
  private int position;
  
  public lqn(ArticleInfo paramArticleInfo, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramArticleInfo;
    this.context = paramContext;
    this.cmd = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqMiniSdkLaunchParam.scene = 2103;
    this.channelID = paramInt2;
    this.position = paramInt3;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.b == null) || (this.b.mSmallMiniGameInfo == null)) {
      return;
    }
    paramViewBase = "";
    String str = "";
    switch (this.cmd)
    {
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramViewBase)) && (!TextUtils.isEmpty(str)) && (!MiniAppLauncher.startMiniApp(this.context, paramViewBase, 2103, null)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnSmallGameCardClickListener", 0, "mini game url error jump by appid url = " + paramViewBase);
        }
        MiniAppLauncher.launchMiniAppById(this.context, str, null, null, null, null, 2103);
      }
      report();
      return;
      this.jdField_a_of_type_Jyq = new jyq.a().a(501L).b(50101L).c(5010104L).c(this.b.mSmallMiniGameInfo.abg).d(this.b.mSmallMiniGameInfo.abd).h(String.valueOf(this.position)).e(this.b.mSmallMiniGameInfo.abk).f("1").g(this.b.mSmallMiniGameInfo.aba).a();
      jzk.a(this.context, this.jdField_a_of_type_Jyq);
      paramViewBase = this.b.mSmallMiniGameInfo.aba;
      str = this.b.mSmallMiniGameInfo.abd;
      continue;
      this.jdField_a_of_type_Jyq = new jyq.a().a(501L).b(50101L).c(5010104L).c(this.b.mSmallMiniGameInfo.abh).d(this.b.mSmallMiniGameInfo.abe).h(String.valueOf(this.position)).e(this.b.mSmallMiniGameInfo.abl).f("2").g(this.b.mSmallMiniGameInfo.abb).a();
      jzk.a(this.context, this.jdField_a_of_type_Jyq);
      paramViewBase = this.b.mSmallMiniGameInfo.abb;
      str = this.b.mSmallMiniGameInfo.abe;
      continue;
      this.jdField_a_of_type_Jyq = new jyq.a().a(501L).b(50101L).c(5010104L).c(this.b.mSmallMiniGameInfo.abj).d(this.b.mSmallMiniGameInfo.abf).h(String.valueOf(this.position)).e(this.b.mSmallMiniGameInfo.abm).f("3").g(this.b.mSmallMiniGameInfo.abc).a();
      jzk.a(this.context, this.jdField_a_of_type_Jyq);
      paramViewBase = this.b.mSmallMiniGameInfo.abc;
      str = this.b.mSmallMiniGameInfo.abf;
      continue;
      this.jdField_a_of_type_Jyq = new jyq.a().a(501L).b(50101L).c(5010105L).h(String.valueOf(this.position)).a();
      jzk.a(this.context, this.jdField_a_of_type_Jyq);
      kxm.C(this.context, this.b.mSmallMiniGameInfo.moreUrl);
    }
  }
  
  public void report()
  {
    int k = this.channelID;
    int i;
    if (this.b.hasChannelInfo())
    {
      i = this.b.mChannelInfoId;
      if (!TextUtils.isEmpty(this.b.mArticleFriendLikeText)) {
        break label159;
      }
    }
    label159:
    for (int j = 0;; j = 1)
    {
      String str = kxm.f(this.b);
      kbp.a(null, "CliOper", "", this.b.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(this.b.mFeedId), Long.toString(this.b.mArticleID), Integer.toString(this.b.mStrategyId), kxm.a(this.b.mAlgorithmID, kxm.a(this.b), k, i, j, aqiw.isWifiConnected(this.context), str, this.b.mStrCircleId, this.b.innerUniqueID, kxm.h(this.b), this.b), false);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqn
 * JD-Core Version:    0.7.0.1
 */