import KQQ.ReqItem;
import KQQ.RespItem;
import KQQ.UserBitFlagReq;
import KQQ.UserBitFlagRes;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.QQSettingUtil.1;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aqeu
{
  public static int J(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt("setting_quit_" + paramString, 0);
  }
  
  public static SpannableString a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramResources == null) {
      return new SpannableString("");
    }
    if (!aqss.k(localAppInterface.getApp(), paramInt1)) {
      aqss.a((QQAppInterface)localAppInterface, paramInt1, null, false);
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new SpannableString("*");
      paramInt2 = (int)paramResources.getDimension(2131298879);
      paramResources = paramResources.getDrawable(2130846755);
      paramResources = aqqx.a(localAppInterface, aqep.T(paramInt1, aqep.dYP), "", paramResources, aqqx.pe, "halfStar", false, null);
      paramResources.setBounds(0, 0, paramInt2, paramInt2);
      if (bool) {
        paramResources.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        ((SpannableString)localObject).setSpan(new ImageSpan(paramResources), 0, 1, 33);
        return localObject;
        paramResources.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
      }
    }
    int k = paramInt2 / 64;
    paramInt2 %= 64;
    int m = paramInt2 / 16;
    int i1 = paramInt2 % 16;
    int n = i1 / 4;
    String str1 = "";
    int i = 0;
    while (i < 4)
    {
      paramInt2 = 0;
      localObject = "";
      switch (i)
      {
      }
      for (;;)
      {
        int j = 0;
        while (j < paramInt2)
        {
          str1 = str1 + (String)localObject;
          j += 1;
        }
        localObject = "!";
        paramInt2 = k;
        continue;
        localObject = "@";
        paramInt2 = m;
        continue;
        localObject = "#";
        paramInt2 = n;
        continue;
        localObject = "%";
        paramInt2 = i1 % 4;
      }
      i += 1;
    }
    if ((paramInt3 > 1) && (str1.length() > paramInt3))
    {
      localObject = str1.substring(0, paramInt3 - 1);
      str1 = (String)localObject + "$";
    }
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str1);
      paramInt3 = (int)paramResources.getDimension(2131298879);
      paramInt2 = 0;
      if (paramInt2 < str1.length())
      {
        String str2 = str1.substring(paramInt2, paramInt2 + 1);
        if ("!".equalsIgnoreCase(str2))
        {
          localObject = paramResources.getDrawable(2130846753);
          localObject = aqqx.a(localAppInterface, aqep.T(paramInt1, aqep.dYT), "", (Drawable)localObject, aqqx.pe, "crown", false, null);
          label466:
          if (localObject != null)
          {
            if (!"&".equalsIgnoreCase(str2)) {
              break label705;
            }
            ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
            label498:
            if (!bool) {
              break label717;
            }
            ((Drawable)localObject).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), paramInt2, paramInt2 + 1, 33);
          paramInt2 += 1;
          break;
          if ("@".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130846757);
            localObject = aqqx.a(localAppInterface, aqep.T(paramInt1, aqep.dYS), "", (Drawable)localObject, aqqx.pe, "sun", false, null);
            break label466;
          }
          if ("#".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130846754);
            localObject = aqqx.a(localAppInterface, aqep.T(paramInt1, aqep.dYR), "", (Drawable)localObject, aqqx.pe, "moon", false, null);
            break label466;
          }
          if ("%".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130846756);
            localObject = aqqx.a(localAppInterface, aqep.T(paramInt1, aqep.dYQ), "", (Drawable)localObject, aqqx.pe, "star", false, null);
            break label466;
          }
          if ("$".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130851860);
            break label466;
          }
          localObject = null;
          break label466;
          label705:
          ((Drawable)localObject).setBounds(0, 0, paramInt3, paramInt3);
          break label498;
          label717:
          ((Drawable)localObject).setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseQQLevel, sLevel = " + str1 + ", span = " + localSpannableString);
      }
      return localSpannableString;
    }
  }
  
  public static SpannableString a(View paramView, Resources paramResources, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    }
    for (localObject = aqrt.a().b(((QQAppInterface)localObject).getCurrentUin(), paramLong, paramInt, paramBoolean);; localObject = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return new SpannableString("");
      }
      SpannableString localSpannableString = new SpannableString("KB");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = URLDrawable.getDrawable((String)localObject, new ColorDrawable(), new ColorDrawable());
        if (((URLDrawable)localObject).getStatus() == 1) {
          ((URLDrawable)localObject).setBounds(0, 0, rpq.dip2px(BaseApplicationImpl.getContext(), 47.0F), rpq.dip2px(BaseApplicationImpl.getContext(), 14.0F));
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((URLDrawable)localObject).setURLDrawableListener(new aqev(paramView));
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), 0, 1, 33);
          paramView = paramResources.getDrawable(2130846778);
          paramView.setBounds(0, 0, (int)paramResources.getDimension(2131297498), rpq.dip2px(BaseApplicationImpl.getContext(), 5.0F));
          localSpannableString.setSpan(new ImageSpan(paramView), 1, 2, 33);
        }
        return localSpannableString;
        ((URLDrawable)localObject).restartDownload();
        ((URLDrawable)localObject).setBounds(0, 0, 1, 1);
        continue;
        localObject = null;
      }
    }
  }
  
  public static SpannableString a(View paramView, Resources paramResources, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(paramView);
    SpannableString localSpannableString = new SpannableString("");
    paramView = null;
    int i = (int)paramResources.getDimension(2131297527);
    Drawable localDrawable;
    if ((paramBoolean1) && (paramInt > 0))
    {
      localSpannableString = new SpannableString("sb");
      paramView = "https://i.gtimg.cn/club/mobile/profile/vipicon2016/android/svip_" + paramInt + ".png";
      localDrawable = paramResources.getDrawable(2130847936);
      paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
      paramView.setBounds(0, 0, (int)(68.0D * (i / 24.0D)), i);
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.mutate();
        ((URLDrawable)paramView).setURLDrawableListener(new aqew(localWeakReference));
        localSpannableString.setSpan(new ImageSpan(paramView), 0, 1, 33);
        paramView = paramResources.getDrawable(2130846778);
        paramView.setBounds(0, 0, (int)paramResources.getDimension(2131297498), i);
        localSpannableString.setSpan(new ImageSpan(paramView), 1, 2, 33);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseClubLevel, bSuperVipOpen=" + paramBoolean1 + ", bQQVipOpen=" + paramBoolean2 + ",iVipLevel=" + paramInt);
      }
      return localSpannableString;
      if ((paramBoolean2) && (paramInt > 0))
      {
        localSpannableString = new SpannableString("vb");
        paramView = "https://i.gtimg.cn/club/mobile/profile/vipicon2016/android/vip_" + paramInt + ".png";
        localDrawable = paramResources.getDrawable(2130847937);
        paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
        paramView.setBounds(0, 0, (int)(58.0D * (i / 24.0D)), i);
      }
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = true;
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.destroy();
    if (paramBoolean)
    {
      bool = false;
      localIntent.putExtra("tab_index", MainFragment.bIk);
    }
    paramQQAppInterface.logout(bool);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i = J(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    z(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
    paramActivity.startActivityForResult(localIntent, 1000);
    if (QQPlayerService.isPlaying())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
  }
  
  public static int ah(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getApplicationContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("mywallet_flag", 1);
  }
  
  public static void ew(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.execute(new QQSettingUtil.1(paramQQAppInterface));
  }
  
  public static void ex(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramQQAppInterface.getApp();
    boolean bool = SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131697129), "qqsetting_auto_receive_pic_key", true);
    int i;
    Object localObject3;
    if (bool)
    {
      i = 1;
      ((Map)localObject1).put("Clk_auto_receive_pic", Integer.valueOf(i));
      localObject3 = (amhj)paramQQAppInterface.getManager(15);
      if (localObject3 != null)
      {
        bool = ((amhj)localObject3).avP();
        if (!bool) {
          break label1197;
        }
        i = 1;
        label83:
        ((Map)localObject1).put("Clk_signature_qzone", Integer.valueOf(i));
        if (!accy.b(paramQQAppInterface, false)) {
          break label1202;
        }
        i = 1;
        label108:
        ((Map)localObject1).put("Download_new", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131719914), "qqsetting_notify_icon_key", false)) {
          break label1207;
        }
        i = 1;
        label146:
        ((Map)localObject1).put("System_icon", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, paramQQAppInterface.getApp().getString(2131697083), "qqsetting_enter_sendmsg_key", false)) {
          break label1212;
        }
        i = 1;
        label186:
        ((Map)localObject1).put("Enter_sendmsg", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, paramQQAppInterface.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true)) {
          break label1217;
        }
        i = 1;
        label222:
        ((Map)localObject1).put("Mobile_pc_online", Integer.valueOf(i));
        if (!paramQQAppInterface.abw()) {
          break label1222;
        }
        i = 1;
        label246:
        ((Map)localObject1).put("Visible_same", Integer.valueOf(i));
        if (!paramQQAppInterface.aby()) {
          break label1227;
        }
        i = 1;
        label270:
        ((Map)localObject1).put("Same_likeme", Integer.valueOf(i));
        if (!paramQQAppInterface.aQ(true)) {
          break label1232;
        }
        i = 1;
        label295:
        ((Map)localObject1).put("Search_number", Integer.valueOf(i));
        if (!ajrb.nB(paramQQAppInterface.getAccount())) {
          break label1237;
        }
        i = 1;
        label322:
        ((Map)localObject1).put("Visible_nearby", Integer.valueOf(i));
        if (!paramQQAppInterface.abx()) {
          break label1242;
        }
        i = 1;
        label346:
        ((Map)localObject1).put("Nearby_likeme", Integer.valueOf(i));
        if (paramQQAppInterface.AK() != 0) {
          break label1247;
        }
        i = 0;
        label370:
        if (i == 0) {
          break label1252;
        }
        i = 1;
        label376:
        ((Map)localObject1).put("Latest_chatlog_syn", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.getCurrentAccountUin()) != 2) {
          break label1257;
        }
        i = 1;
        label406:
        if (i == 0) {
          break label1262;
        }
        i = 1;
        label412:
        ((Map)localObject1).put("Gesture_password", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), null, "security_scan_key", "qqsetting_security_scan_key", false)) {
          break label1267;
        }
        i = 1;
        label447:
        ((Map)localObject1).put("Security_check", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.getCurrentAccountUin()) != 2) {
          break label1272;
        }
        i = 1;
        label477:
        if (i == 0) {
          break label1277;
        }
        i = 1;
        label483:
        ((Map)localObject1).put("Setting_Gesture_password", Integer.valueOf(i));
        if (!aizp.a().aqd()) {
          break label1282;
        }
        i = 1;
        label509:
        ((Map)localObject1).put("Clk_hide_grp_heper", Integer.valueOf(i));
        if (!aizp.a().aqe()) {
          break label1287;
        }
        i = 1;
        label535:
        ((Map)localObject1).put("Clk_grp_heper_top", Integer.valueOf(i));
        localObject2 = ((Map)localObject1).keySet();
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          anot.a(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", (String)localObject3, 0, 0, String.valueOf(((Map)localObject1).get(localObject3)), "", "", "");
          continue;
        }
        if (!SettingCloneUtil.readValue(paramQQAppInterface.getApp(), null, paramQQAppInterface.getApp().getString(2131697091), "qqsetting_screenshot_key", false)) {
          break label1292;
        }
        i = 1;
        anot.a(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", "Shake_screenshot_switch", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.aR(false)) {
          break label1297;
        }
        i = 1;
        anot.a(paramQQAppInterface, "CliStatus", "", "", "0X80044D1", "0X80044D1", 0, 0, String.valueOf(i), "", "", "");
        localObject1 = ((acff)paramQQAppInterface.getManager(51)).b(paramQQAppInterface.getCurrentAccountUin());
        if (localObject1 != null)
        {
          if (!((Card)localObject1).allowPeopleSee) {
            break label1302;
          }
          i = 1;
          anot.a(paramQQAppInterface, "CliStatus", "", "", "0X8004884", "0X8004884", 0, 0, String.valueOf(i), "", "", "");
        }
        if (!HotChatManager.af(paramQQAppInterface)) {
          break label1307;
        }
        i = 1;
        anot.a(paramQQAppInterface, "CliStatus", "", "", "0X8004B1E", "0X8004B1E", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.aT(false)) {
          break label1312;
        }
        i = 1;
        anot.a(paramQQAppInterface, "CliStatus", "", "", "0X8004C5C", "0X8004C5C", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.aU(false)) {
          break label1317;
        }
        i = 1;
        anot.a(paramQQAppInterface, "CliStatus", "", "", "0X8004C5D", "0X8004C5D", 0, 0, String.valueOf(i), "", "", "");
        localObject3 = (acff)paramQQAppInterface.getManager(51);
        i = ((acff)localObject3).Au();
        if (i <= 0) {
          break label1322;
        }
        localObject1 = "1";
        if (i > 0)
        {
          localObject2 = String.valueOf(i);
          anot.a(paramQQAppInterface, "CliStatus", "", "", "0X8004C69", "0X8004C69", 0, 0, (String)localObject1, (String)localObject2, String.valueOf(((acff)localObject3).At()), "");
          if (((acof)paramQQAppInterface.getManager(85)).aX(false))
          {
            i = 1;
            anot.a(paramQQAppInterface, "CliStatus", "", "", "0X8004E0C", "0X8004E0C", 0, i, String.valueOf(i), "", "", "");
            if (!paramQQAppInterface.bJb) {
              continue;
            }
            i = 1;
            anot.a(paramQQAppInterface, "CliStatus", "", "", "0X8004EDE", "0X8004EDE", 0, 0, String.valueOf(i), "", "", "");
            localObject1 = ((zbq)paramQQAppInterface.getManager(295)).di();
            if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
              break label1191;
            }
            localObject1 = ((List)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label1191;
            }
            localObject2 = (zbm)((Iterator)localObject1).next();
            int j = ((zbm)localObject2).id;
            if (!((zbm)localObject2).bqy) {
              continue;
            }
            i = 2;
            anot.a(paramQQAppInterface, "CliStatus", "", "", "0X80097A1", "0X80097A1", j, 0, String.valueOf(i), "", "", "");
            continue;
          }
        }
        else
        {
          localObject2 = "";
          continue;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
      }
      catch (Exception paramQQAppInterface) {}
      label1191:
      return;
      i = 0;
      break;
      label1197:
      i = 0;
      break label83;
      label1202:
      i = 0;
      break label108;
      label1207:
      i = 0;
      break label146;
      label1212:
      i = 0;
      break label186;
      label1217:
      i = 0;
      break label222;
      label1222:
      i = 0;
      break label246;
      label1227:
      i = 0;
      break label270;
      label1232:
      i = 0;
      break label295;
      label1237:
      i = 0;
      break label322;
      label1242:
      i = 0;
      break label346;
      label1247:
      i = 1;
      break label370;
      label1252:
      i = 0;
      break label376;
      label1257:
      i = 0;
      break label406;
      label1262:
      i = 0;
      break label412;
      label1267:
      i = 0;
      break label447;
      label1272:
      i = 0;
      break label477;
      label1277:
      i = 0;
      break label483;
      label1282:
      i = 0;
      break label509;
      label1287:
      i = 0;
      break label535;
      label1292:
      i = 0;
      continue;
      label1297:
      i = 0;
      continue;
      label1302:
      i = 0;
      continue;
      label1307:
      i = 0;
      continue;
      label1312:
      i = 0;
      continue;
      label1317:
      i = 0;
      continue;
      label1322:
      localObject1 = "0";
    }
  }
  
  public static void ey(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Vip_pay_mywallet").append('|').append(paramQQAppInterface.getCurrentAccountUin()).append('|').append("").append('|').append("wallet").append('|').append("index").append('|').append(0).append('|').append(1).append('|').append(0).append('|').append("").append('|').append("").append('|').append("").append('|').append("").append('|');
      anpc.a(null).i(paramQQAppInterface, localStringBuilder.toString());
    }
  }
  
  public static void z(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt("setting_quit_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static class a
    implements andh
  {
    private QQAppInterface mApp;
    
    public a(QQAppInterface paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
    }
    
    public ReqItem a(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "getCheckUpdateItemData");
      }
      ReqItem localReqItem = new ReqItem();
      localReqItem.cOperType = 1;
      localReqItem.eServiceID = 106;
      UserBitFlagReq localUserBitFlagReq = new UserBitFlagReq();
      localUserBitFlagReq.cEmotionMall = 0;
      localUserBitFlagReq.cMyWallet = ((byte)aqeu.ah(this.mApp));
      localUserBitFlagReq.cPtt2Text = 0;
      localUserBitFlagReq.cAccout2Dis = 0;
      localReqItem.vecParam = localUserBitFlagReq.toByteArray();
      return localReqItem;
    }
    
    public void a(RespItem paramRespItem)
    {
      boolean bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "handleCheckUpdateItemData");
      }
      if (paramRespItem.eServiceID == 106)
      {
        UserBitFlagRes localUserBitFlagRes = new UserBitFlagRes();
        localUserBitFlagRes.readFrom(new JceInputStream(paramRespItem.vecUpdate));
        int i = localUserBitFlagRes.cEmotionMall;
        int j = localUserBitFlagRes.cMyWallet;
        int k = localUserBitFlagRes.cAccout2Dis;
        if (QLog.isColorLevel()) {
          QLog.d("QQSetting", 2, "vEmotion=" + i + ",cMyWallet=" + j + ",cPtt2Text=" + localUserBitFlagRes.cPtt2Text + " ,cAccout2Dis=" + k);
        }
        if (this.mApp != null)
        {
          this.mApp.getApp().getApplicationContext().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().putInt("mywallet_flag", j).putInt("select_member_contacts_flag", k).commit();
          paramRespItem = this.mApp;
          if (localUserBitFlagRes.cPtt2Text != 1) {
            break label211;
          }
        }
      }
      for (;;)
      {
        anvq.i(paramRespItem, bool);
        return;
        label211:
        bool = false;
      }
    }
    
    public int mT()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqeu
 * JD-Core Version:    0.7.0.1
 */