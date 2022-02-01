import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aakj
  implements View.OnClickListener
{
  private static final int[] jA = { 2131692292, 2130839792 };
  private static final int[] jB = { 2131692290, 2130839791 };
  private static final int[] jC = { 2131692300, 2130839783 };
  private static final int[] jt = { 2131692281, 2130839780 };
  public static final int[] ju = { 2131692295, 2130839794 };
  private static final int[] jv = { 2131692288, 2130839763 };
  private static final int[] jw = { 2131692285, 2130839784 };
  private static final int[] jx = { 2131692298, 2130839783 };
  private static final int[] jy = { 2131692294, 2130839793 };
  private static final int[] jz = { 2131692287, 2130839785 };
  private RedTouch C;
  private RedTouch F;
  private TextView Of;
  auuw b;
  private String bdo = "";
  private boolean bwa;
  private boolean bwb;
  private boolean bwc;
  private boolean bwd;
  public boolean bwe;
  public BaseActivity h;
  private List<auuw.a> vq;
  private ImageView wk;
  
  public aakj(BaseActivity paramBaseActivity)
  {
    this.h = paramBaseActivity;
  }
  
  public static Intent a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("from_+", true);
    localIntent.putExtra("leftViewText", paramBaseActivity.getString(2131691039));
    localIntent.putExtra("selfSet_leftViewText", paramBaseActivity.getString(2131691039));
    localIntent.putExtra("start_time", System.currentTimeMillis());
    paramBaseActivity = new Bundle();
    paramBaseActivity.putLong("PromotionType", paramLong1);
    paramBaseActivity.putLong("RecoglizeMask", paramLong2);
    paramBaseActivity.putString("H5Source", String.valueOf(paramInt));
    localIntent.putExtra("web_invoke_params", paramBaseActivity);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  public static void a(Intent paramIntent, FrameHelperActivity paramFrameHelperActivity)
  {
    if ((paramIntent != null) && (paramFrameHelperActivity != null) && ((paramFrameHelperActivity.getActivity() instanceof SplashActivity)))
    {
      paramFrameHelperActivity = (SplashActivity)paramFrameHelperActivity.getActivity();
      if (!paramIntent.getBooleanExtra("open_leba_tab_fragment", false)) {
        break label42;
      }
      paramFrameHelperActivity.ch(paramIntent);
    }
    label42:
    while (!paramIntent.getBooleanExtra("open_chatfragment", false)) {
      return;
    }
    aalb.w(paramFrameHelperActivity, paramIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    if (!a(paramBaseActivity)) {
      return;
    }
    paramBaseActivity.startActivity(a(paramBaseActivity, paramLong1, paramLong2, paramInt));
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (paramBaseActivity.isInMultiWindow())
    {
      QQToast.a(paramBaseActivity, acfp.m(2131713711), 0).show();
      return false;
    }
    return true;
  }
  
  private void cvc()
  {
    if (!VideoEnvironment.o(this.h.app)) {
      aqha.a(this.h, 230).setMessage(acfp.m(2131713713)).setPositiveButton(2131721079, new aakn(this)).show();
    }
    do
    {
      return;
      if (this.h.app.bF())
      {
        QQToast.a(BaseApplicationImpl.getContext(), 2131698108, 1).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
        return;
      }
    } while (!VideoEnvironment.q(this.h.app));
    cvd();
  }
  
  protected void FZ(int paramInt)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.h, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=2&seq=" + l));
    this.h.startActivityForResult(localIntent, -1);
    anot.a(this.h.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  public boolean KA()
  {
    if (ShortVideoUtils.awI()) {
      return true;
    }
    ThreadManager.post(new RecentOptPopBar.4(this), 8, null, true);
    return false;
  }
  
  public void W(String paramString, long paramLong)
  {
    if (this.h == null) {}
    while (this.h.getSharedPreferences("SP_SHOT_REDTOUCH_TIME" + this.h.getAppInterface().getCurrentAccountUin(), 0).getLong(paramString, 0L) != 0L) {
      return;
    }
    this.h.getSharedPreferences("SP_SHOT_REDTOUCH_TIME" + this.h.getAppInterface().getCurrentAccountUin(), 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public boolean WA()
  {
    return false;
  }
  
  public auuw.a a(int[] paramArrayOfInt)
  {
    auuw.a locala = new auuw.a();
    locala.id = paramArrayOfInt[0];
    locala.title = this.h.getResources().getString(paramArrayOfInt[0]);
    locala.contentDescription = this.h.getResources().getString(paramArrayOfInt[0]);
    locala.iconId = paramArrayOfInt[1];
    return locala;
  }
  
  public auuw.a b(int[] paramArrayOfInt)
  {
    auuw.a locala = new auuw.a();
    locala.id = paramArrayOfInt[0];
    locala.contentDescription = this.h.getResources().getString(paramArrayOfInt[0]);
    locala.iconId = paramArrayOfInt[1];
    RecentDanceConfigMgr.DItemInfo localDItemInfo = RecentDanceConfigMgr.a();
    if (localDItemInfo != null)
    {
      locala.title = localDItemInfo.showName;
      locala.l = localDItemInfo.drawable;
      return locala;
    }
    locala.title = this.h.getResources().getString(paramArrayOfInt[0]);
    locala.l = null;
    return locala;
  }
  
  public void cuB()
  {
    this.vq = new ArrayList();
    this.vq.add(a(jy));
    this.vq.add(a(jt));
    this.vq.add(a(ju));
    this.vq.add(a(jv));
    this.vq.add(a(jw));
    aeku localaeku = aekv.a();
    if ((localaeku != null) && (localaeku.agP())) {
      this.vq.add(a(jB));
    }
    this.bwb = false;
    if ((RecentDanceConfigMgr.u(this.h.app)) && (WA()))
    {
      this.vq.add(b(jC));
      this.bwb = true;
    }
    this.bwd = false;
    if ((zyn.b(this.h.getCurrentAccountUin(), "F2FRedpackEntry", false)) && (WA()))
    {
      this.vq.add(a(jz));
      this.bwd = true;
      anot.a(this.h.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
    }
    if (AudioHelper.isDev()) {
      PstnCardTestActivity.addDebugMenu(this.h.app, this.vq);
    }
    this.b = auuw.b(this.h, this.vq, new aakk(this), new aakl(this));
  }
  
  protected void cuU()
  {
    a(this.h, 0L, 0L, 0);
    anot.a(this.h.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  protected void cuV()
  {
    Intent localIntent = new Intent(this.h, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 2);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.h.getString(2131691039));
    localIntent.putExtra("selfSet_leftViewText", this.h.getString(2131691039));
    this.h.startActivity(localIntent);
    anot.a(this.h.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((altq)this.h.app.getManager(36)).OS(String.valueOf("101210.101211"));
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void cuW() {}
  
  protected void cuX()
  {
    avhc.c(this.h, 8, null);
    anot.a(this.h.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  protected void cuY()
  {
    long l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    Intent localIntent = new Intent(this.h, QrcodeHbGuiderActivity.class);
    localIntent.putExtra("appInfo", "");
    localIntent.putExtra("vacreport_key_seq", l);
    this.h.startActivity(localIntent);
    anot.a(this.h.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
  }
  
  protected void cuZ()
  {
    Intent localIntent = new Intent(this.h, NewTroopCreateActivity.class);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.setFlags(603979776);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("create_source", 0);
    this.h.startActivityForResult(localIntent, 1300);
    this.h.overridePendingTransition(2130772009, 2130772013);
    anot.a(this.h.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
    anot.a(this.h.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
    anpc.report("tim_msg_tab_r_plus_click_add_group_chat");
  }
  
  protected void cva()
  {
    anot.a(this.h.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    rar.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    rar.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
    if (this.bwa) {
      anjo.QD(anjo.cew);
    }
    cvb();
    if (avfp.h != null) {
      avfp.h.dqV();
    }
  }
  
  protected void cvb()
  {
    if (!VideoEnvironment.o(this.h.app)) {
      aqha.a(this.h, 230).setMessage(acfp.m(2131713714)).setPositiveButton(2131721079, new aakm(this)).show();
    }
  }
  
  protected void cvd()
  {
    Object localObject = RecentDanceConfigMgr.a();
    if (localObject == null) {
      RecentDanceConfigMgr.printLog("showDanceCategoryPanel:[Plus] itemInfo=null");
    }
    do
    {
      return;
      boolean bool = anhq.t(this.h.app);
      RecentDanceConfigMgr.printLog("showDanceCategoryPanel: videoUsable=" + bool);
      alwx.dKy();
      localObject = awrp.a(null, this.h.getClass().getName(), 10004, 8, ((RecentDanceConfigMgr.DItemInfo)localObject).unfold, ((RecentDanceConfigMgr.DItemInfo)localObject).categoryID, ((RecentDanceConfigMgr.DItemInfo)localObject).itemID);
      rnq.a().a(this.h, (Bundle)localObject, 9010);
    } while (!MediaPlayerManager.a(this.h.app).isPlaying());
    MediaPlayerManager.a(this.h.app).stop(false);
  }
  
  protected void cve()
  {
    if ((this.h != null) && (this.h.app != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("ExtendFriendLimitChatFromeType", 1);
      PublicFragmentActivity.start(this.h, localIntent, ExtendFriendLimitChatMatchFragment.class);
      this.h.overridePendingTransition(2130772009, 2130772002);
      afxv.a().NF(4);
      anot.a(this.h.app, "dc00898", "", "", "0X800A69C", "0X800A69C", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("RecentOptPopBar", 2, "activity or app is null");
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      this.b.dismiss();
    }
  }
  
  public boolean isShowing()
  {
    return (this.b != null) && (this.b.isShowing());
  }
  
  public void onClick(View paramView)
  {
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPause()
  {
    if (this.b != null) {
      this.b.onPause();
    }
  }
  
  public void t(View paramView, int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.b.dkR)) {
      this.b = null;
    }
    if (this.b == null) {
      cuB();
    }
    for (;;)
    {
      this.b.showAsDropDown(paramView, paramInt1, paramInt2);
      label576:
      if ((this.C == null) || (this.F == null))
      {
        paramView = (LinearLayout)this.b.getContentView().findViewById(2131365360);
        paramInt1 = 0;
        label76:
        if (paramInt1 < paramView.getChildCount()) {
          try
          {
            Object localObject = paramView.getChildAt(paramInt1);
            if (((auuw.a)((View)localObject).getTag()).id == 2131692281)
            {
              localObject = (TextView)((View)localObject).findViewById(2131379576);
              this.C = new RedTouch(this.h, (View)localObject).a(21).a();
            }
            for (;;)
            {
              paramInt1 += 1;
              break label76;
              if (this.bwc)
              {
                localObject = afwy.s(this.h.app);
                if ((localObject != null) && (this.bdo != null) && (!((String)localObject).equals(this.bdo))) {
                  this.bwe = true;
                }
              }
              if (((this.bwc) && (!afwy.au(this.h.app))) || ((!this.bwc) && (afwy.au(this.h.app)))) {
                this.bwe = true;
              }
              if (this.bwe)
              {
                cuB();
                this.bwe = false;
              }
              if (!WA()) {
                break;
              }
              if (((this.bwd) && (!zyn.b(this.h.getCurrentAccountUin(), "F2FRedpackEntry", false))) || ((!this.bwd) && (zyn.b(this.h.getCurrentAccountUin(), "F2FRedpackEntry", false))))
              {
                cuB();
                this.C = null;
                this.F = null;
              }
              if (zyn.iF(this.h.getCurrentAccountUin()))
              {
                if (this.Of != null) {
                  this.Of.setTextColor(this.Of.getResources().getColor(2131165727));
                }
                if (this.wk != null) {
                  this.wk.setImageResource(2130839785);
                }
              }
              while (((this.bwb) && (!RecentDanceConfigMgr.u(this.h.app))) || ((!this.bwb) && (RecentDanceConfigMgr.u(this.h.app))) || ((this.bwb) && (RecentDanceConfigMgr.u(this.h.app)) && (RecentDanceConfigMgr.ayf())))
              {
                cuB();
                break;
                if (this.Of != null) {
                  this.Of.setTextColor(this.Of.getResources().getColor(2131167304));
                }
                if (this.wk != null) {
                  this.wk.setImageResource(2130839786);
                }
              }
              if (((auuw.a)((View)localObject).getTag()).id != 2131692298) {
                break label576;
              }
              localObject = ((View)localObject).findViewById(2131369088);
              this.F = new RedTouch(this.h, (View)localObject).a(53).a();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              continue;
              if (((auuw.a)localException.getTag()).id == 2131692287)
              {
                this.Of = ((TextView)localException.findViewById(2131379576));
                this.wk = ((ImageView)localException.findViewById(2131369088));
                if (zyn.iF(this.h.getCurrentAccountUin()))
                {
                  this.Of.setTextColor(this.Of.getResources().getColor(2131165727));
                  this.wk.setImageResource(2130839785);
                }
                else
                {
                  this.Of.setTextColor(this.Of.getResources().getColor(2131167304));
                  this.wk.setImageResource(2130839786);
                }
              }
            }
          }
        }
      }
    }
    if (this.C != null)
    {
      paramView = ((altq)this.h.app.getManager(36)).getAppInfoByPath("101210.101211");
      this.C.e(paramView);
    }
    if ((this.F == null) || (this.F != null)) {
      if (anjo.pl(anjo.cew)) {
        break label852;
      }
    }
    label852:
    for (boolean bool = true;; bool = false)
    {
      this.bwa = bool;
      if (this.bwa != this.F.czm) {
        this.F.Of(this.bwa);
      }
      awsw.dv(BaseApplicationImpl.getContext(), "peak_preload_plus_panel");
      KA();
      if (this.bwc) {
        anot.a(this.h.app, "dc00898", "", "", "0X800A69B", "0X800A69B", 0, 0, "", "", "", "");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakj
 * JD-Core Version:    0.7.0.1
 */