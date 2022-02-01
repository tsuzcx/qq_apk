import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController.1;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apml
  extends apgi
{
  public static long arH = -1L;
  apqz.a a;
  public PanelIconLinearLayout a;
  public boolean cRo = true;
  public int dUY;
  public auvw f;
  
  public apml(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopChatPie paramTroopChatPie)
  {
    this.mApp = paramQQAppInterface;
    this.mContextRef = new WeakReference(paramBaseActivity);
    this.mSessionInfo = paramTroopChatPie.sessionInfo;
    this.Es = paramTroopChatPie.r();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView = new RedDotAnimateView(paramBaseActivity.getActivity());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(9.0F, paramBaseActivity.getActivity().getResources()), wja.dp2px(9.0F, paramBaseActivity.getActivity().getResources()));
    localLayoutParams.addRule(7, 2131377369);
    localLayoutParams.addRule(6, 2131377369);
    localLayoutParams.rightMargin = wja.dp2px(4.0F, paramBaseActivity.getActivity().getResources());
    localLayoutParams.topMargin = wja.dp2px(11.0F, paramBaseActivity.getActivity().getResources());
    paramTroopChatPie.j().addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramTroopChatPie.a();
    if ((arH < 0L) && (arH != -9223372036854775808L))
    {
      lO(paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.getCurrentUin(), 0).getLong("homework_troop_ent", -9223372036854775808L));
      return;
    }
    lO(arH);
  }
  
  private boolean aBk()
  {
    aeku localaeku = aekv.a();
    return (localaeku != null) && (localaeku.agT());
  }
  
  public static void aT(QQAppInterface paramQQAppInterface, String paramString)
  {
    aqfr.a(paramQQAppInterface, paramString, "homework", "AioAssign_Show", 0, 0, new String[] { paramString, "", "", aqfr.r(paramQQAppInterface, paramString) });
    aqfr.a(paramQQAppInterface, paramString, "Grp_notice", "CreateNotice_Show", 0, 0, new String[] { paramString, "", "", "" });
  }
  
  private void au(int paramInt, long paramLong)
  {
    if (!this.cRo) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new HomeworkTroopController.1(this, paramInt), paramLong);
  }
  
  public static void aw(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
    if (QLog.isColorLevel()) {
      QLog.i("HomeworkTroopController", 2, "handleHomeworkTroopConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      paramConfig = aevk.a(paramConfig);
      localEditor = paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.getCurrentUin(), 0).edit();
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        str = (String)paramConfig.get(0);
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkTroopController", 2, new Object[] { "parse handleHomeworkTroopConfig: ", str });
        }
        for (;;)
        {
          try
          {
            paramConfig = new JSONObject(str);
            if (paramConfig.has("HWTroopAIOTip"))
            {
              localObject = paramConfig.getJSONObject("HWTroopAIOTip");
              if (((JSONObject)localObject).has("show")) {
                localEditor.putInt("homework_troop_aio_tip_show", ((JSONObject)localObject).getInt("show"));
              }
            }
            if (paramConfig.has("keywordConfigs"))
            {
              localObject = paramConfig.getJSONArray("keywordConfigs").toString();
              localEditor.putString("troop_school_keyword_config", (String)localObject);
              ((apri)paramQQAppInterface.getManager(262)).updateConfig((String)localObject);
            }
            localObject = paramConfig.optString("grayTroopUin");
            l1 = 0L;
          }
          catch (JSONException paramConfig)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            paramConfig = str;
            if (str != null) {
              continue;
            }
            paramConfig = "";
            QLog.e("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopConfig json fail. content: ", paramConfig });
            localEditor.clear();
            continue;
          }
          try
          {
            l2 = Long.parseLong((String)localObject);
            l1 = l2;
            localEditor.putLong("homework_troop_ent", l2);
            l1 = l2;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localEditor.putLong("homework_troop_ent", -9223372036854775808L);
          }
        }
        localObject = (apgj)paramQQAppInterface.getManager(289);
        if ((((apgj)localObject).a instanceof apml)) {
          ((apml)((apgj)localObject).a).lO(l1);
        }
        ((aprp)paramQQAppInterface.getManager(109)).bO(paramConfig);
        localEditor.apply();
        paramQQAppInterface.getPreferences().edit().putInt("homework_troop_config_version", i).apply();
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        SharedPreferences.Editor localEditor;
        String str;
        Object localObject;
        long l1;
        long l2;
        return;
        localEditor.clear();
      }
    }
    QLog.i("HomeworkTroopController", 2, "handleHomeworkTroopConfig:localVersion == version = " + i);
  }
  
  private void lO(long paramLong)
  {
    boolean bool2 = false;
    bool3 = true;
    try
    {
      long l = Long.parseLong(this.mSessionInfo.aTl);
      if (paramLong != -9223372036854775808L)
      {
        bool1 = bool2;
        if (paramLong >= 0L)
        {
          bool1 = bool2;
          if (l >= paramLong) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("HomeworkTroopController", 2, new Object[] { "parse troopUin error. troopUin=", this.mSessionInfo.aTl });
          bool1 = bool3;
        }
      }
    }
    this.cRo = bool1;
  }
  
  public void RG(boolean paramBoolean)
  {
    RT(paramBoolean);
  }
  
  public void RH(boolean paramBoolean)
  {
    boolean bool;
    if ((this.cRo) && (TroopInfo.isAdmin(this.mApp, this.mSessionInfo.aTl)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip start. isHomeworkTroop=", Boolean.valueOf(paramBoolean), ", canShow=", Boolean.valueOf(bool) });
      }
      if (bool) {
        break label78;
      }
    }
    label78:
    do
    {
      return;
      bool = false;
      break;
      if (!paramBoolean) {
        break label238;
      }
      paramBoolean = apqz.c(this.mApp, this.mSessionInfo.aTl, "homework_troop_aio_panel_tip_homework");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasHomeworkShown=", Boolean.valueOf(paramBoolean) });
      }
      if (!paramBoolean)
      {
        au(1, 500L);
        apqz.c(this.mApp, this.mSessionInfo.aTl, "homework_troop_aio_panel_tip_homework", true);
        return;
      }
      paramBoolean = apqz.c(this.mApp, this.mSessionInfo.aTl, "homework_troop_aio_panel_tip_notification");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasNotificationShown=", Boolean.valueOf(paramBoolean) });
      }
    } while (paramBoolean);
    au(2, 500L);
    apqz.c(this.mApp, this.mSessionInfo.aTl, "homework_troop_aio_panel_tip_notification", true);
    return;
    label238:
    dZr();
  }
  
  public void RR(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListIcon start. isHomeworkTroop=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.cRo) && (paramBoolean))
    {
      aqfr.a(this.mApp, this.mSessionInfo.aTl, "homework", "AioSee_Show", 0, 0, new String[] { this.mSessionInfo.aTl, "", "", aqfr.r(this.mApp, this.mSessionInfo.aTl) });
      localWebProcessManager = (WebProcessManager)this.mApp.getManager(13);
      if (localWebProcessManager != null) {}
    }
    while (aBk())
    {
      do
      {
        WebProcessManager localWebProcessManager;
        do
        {
          return;
        } while (!localWebProcessManager.aFT());
        localWebProcessManager.egu();
      } while (!QLog.isColorLevel());
      QLog.d("HomeworkTroopController", 2, "start preloadWebProcess");
      return;
    }
    this.Es.setOnClickListener(null);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, " hide troop class hw rightbtn");
    }
    this.Es.setVisibility(8);
  }
  
  public void RS(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mContextRef.get();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "showHomeworkListRedDot,show = " + paramBoolean + ",context = " + localBaseActivity + ",mRightRedDot = " + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView);
    }
    if (localBaseActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView == null) {
      return;
    }
    if ((this.cRo) && (paramBoolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.getVisibility() != 0) {
        aqfr.b("Grp_edu", "homework", "AioSee_Reddot_Show", 0, 0, new String[] { this.mSessionInfo.aTl });
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibleAndZeroRadius();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.startAnimation();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(8);
  }
  
  public void RT(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint start. show=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.cRo) && (paramBoolean))
    {
      int i = apqz.m(this.mApp, this.mSessionInfo.aTl);
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint check cache. troopUin=", this.mSessionInfo.aTl, ", result=", Integer.valueOf(i) });
      }
      if (i != 0)
      {
        RS(true);
        return;
      }
    }
    RS(false);
  }
  
  public void a(boolean paramBoolean, apqz.a parama, TroopChatPie paramTroopChatPie)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramTroopChatPie.app.getManager(52)).b(paramTroopChatPie.sessionInfo.aTl);
    if ((localTroopInfo != null) && (localTroopInfo.isHomeworkTroop())) {
      if (parama != null) {
        apqz.a(paramTroopChatPie.app, paramTroopChatPie.sessionInfo.aTl, paramTroopChatPie.app.getCurrentAccountUin(), parama, paramBoolean);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.jdField_a_of_type_Apqz$a == null) {
        this.jdField_a_of_type_Apqz$a = new apmo(this, paramTroopChatPie);
      }
      apqz.a(paramTroopChatPie.app, paramTroopChatPie.sessionInfo.aTl, paramTroopChatPie.app.getCurrentAccountUin(), this.jdField_a_of_type_Apqz$a, paramBoolean);
      return;
    }
    if (localTroopInfo == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("HomeworkTroopController", 2, new Object[] { "checkHomeworkTroopIdentity skip. has troopInfo = ", Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void a(boolean paramBoolean, TroopChatPie paramTroopChatPie)
  {
    a(paramBoolean, new apmn(this), paramTroopChatPie);
  }
  
  public void a(boolean paramBoolean1, TroopChatPie paramTroopChatPie, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "updateTroopAioUI" + paramBoolean1);
    }
    if (paramBoolean2)
    {
      paramTroopChatPie.b.b(paramTroopChatPie.app, paramTroopChatPie.sessionInfo, paramTroopChatPie);
      if (paramBoolean1) {
        aT(paramTroopChatPie.app, paramTroopChatPie.sessionInfo.aTl);
      }
    }
    RR(paramBoolean1);
    if (!paramBoolean1)
    {
      if (paramTroopChatPie.a != null) {
        paramTroopChatPie.a.a(paramTroopChatPie.a(), false);
      }
      RT(false);
      RH(false);
      return;
    }
    a(true, null, paramTroopChatPie);
    if (paramTroopChatPie.a().isResume())
    {
      RH(true);
      return;
    }
    paramTroopChatPie.blW = true;
  }
  
  public void dZr()
  {
    if (this.f != null)
    {
      this.f.dismiss();
      this.f = null;
      this.dUY = 0;
    }
  }
  
  public void dZs()
  {
    if ((this.f != null) && (this.f.isShowing()) && (this.dUY > 0)) {
      au(this.dUY, 0L);
    }
  }
  
  public void destroy()
  {
    RS(false);
    dZr();
  }
  
  public void e(TroopChatPie paramTroopChatPie)
  {
    if ((paramTroopChatPie.a != null) && (paramTroopChatPie.a.a(paramTroopChatPie.a()))) {}
    do
    {
      return;
      if (!((aiqk)paramTroopChatPie.a(33)).apu()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("HomeworkTroopController", 2, "showHomeworkTroopIdentityAIOTip. isListenTogetherTime");
    return;
    if (paramTroopChatPie.app.getApp().getSharedPreferences("homework_troop_config" + paramTroopChatPie.app.getCurrentUin(), 0).getInt("homework_troop_aio_tip_show", 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "showHomeworkTroopIdentityAIOTip. show = ", Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      if (paramTroopChatPie.a == null) {
        paramTroopChatPie.a = new yip(paramTroopChatPie.mActivity, paramTroopChatPie.sessionInfo, paramTroopChatPie.app.getCurrentAccountUin());
      }
      paramTroopChatPie.a.a(paramTroopChatPie.a(), true);
      return;
    }
  }
  
  public void f(TroopChatPie paramTroopChatPie)
  {
    if ((paramTroopChatPie.W != null) && (paramTroopChatPie.W.isShowing())) {
      return;
    }
    e(paramTroopChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apml
 * JD-Core Version:    0.7.0.1
 */