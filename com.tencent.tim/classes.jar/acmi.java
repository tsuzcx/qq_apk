import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.a;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.pb.theme.ThemeAuth.DiyThemeDetail;
import com.tencent.pb.theme.ThemeAuth.ReqBody;
import com.tencent.pb.theme.ThemeAuth.RspBody;
import com.tencent.pb.theme.ThemeAuth.RspDiyThemeDetail;
import com.tencent.pb.theme.ThemeAuth.RspDiyThemeInfo;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1ReqAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1RspAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x2ReqCheck;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x2RspCheck;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x3ReqSet;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x3RspSet;
import com.tencent.pb.theme.ThemeAuth.ThemeFileInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class acmi
  extends accg
{
  private static String bpC;
  public ThemeDiyStyleLogic.a a;
  public Bundle ax;
  AtomicBoolean cI = new AtomicBoolean(false);
  public AtomicBoolean cJ = new AtomicBoolean(true);
  AtomicBoolean cK = new AtomicBoolean(false);
  
  public acmi(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void H(int paramInt, String paramString1, String paramString2)
  {
    if ((3 == paramInt) && (!"1000".equals(paramString1)))
    {
      ThemeUtil.setErrorThemeId(this.mApp.getApplication(), paramString1, false);
      ThemeUtil.getUserCurrentThemeVersion(this.mApp);
      bool = SkinEngine.getInstances().setSkinRootPath(this.mApp.getApplication(), null);
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, set default theme");
      if (bool == true) {
        ThreadManager.getUIHandler().post(new ThemeHandler.1(this));
      }
      paramString2 = ThemeUtil.getThemeInfo(this.mApp.getApplication(), paramString1);
      if (paramString2 != null)
      {
        paramString2.status = "1";
        ThemeUtil.setThemeInfo(this.mApp.getApplication(), paramString2);
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth error, set theme status=ThemeUtil.THEME_STATUS_DOWNLOAD_END, reqthemeId=" + paramString1);
        }
      }
      try
      {
        paramString1 = new aogy().a(paramString1).aR(this.mApp.getApplication());
        aqhq.delete(paramString1, true);
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth no right, delete: " + paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth delete Error, msg=" + paramString1.getMessage());
        return;
      }
    }
    if (paramInt != 4) {
      ThemeUtil.setWeekLoopTheme(this.mApp, null, null, 0L);
    }
    boolean bool = SkinEngine.getInstances().setSkinRootPath(this.mApp.getApplication(), null);
    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth vip Error, set default theme");
    int i;
    if ((paramInt == 1) || (paramInt == 2)) {
      i = 1;
    }
    for (;;)
    {
      if (bool) {
        anot.a(null, "CliOper", "", "", "theme", "0X8007234", 0, 0, String.valueOf(i), "", "", "");
      }
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = acfp.m(2131715306);
      }
      if (bool)
      {
        paramString2 = this.mApp.getHandler(Conversation.class);
        Message localMessage = new Message();
        localMessage.what = 1049;
        Bundle localBundle = new Bundle();
        localBundle.putString("expireMsg", str);
        localBundle.putString("themeId", paramString1);
        localBundle.putInt("authResult", paramInt);
        localBundle.putInt("expireType", i);
        localMessage.obj = localBundle;
        paramString2.sendMessage(localMessage);
      }
      if (ThemeBackground.getMarkOfAioBgFromDiy(this.mApp.getApplication(), "theme_bg_aio_path", this.mApp.getAccount()))
      {
        wkj.i(this.mApp.getApplication(), this.app.getAccount(), null, "null");
        ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_aio_path", this.app.getAccount());
      }
      ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_setting_path_png", this.app.getAccount());
      ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_message_path_png", this.app.getAccount());
      ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_friend_path_png", this.app.getAccount());
      ThemeBackground.clear(this.mApp.getApplication(), "theme_bg_dynamic_path_png", this.app.getAccount());
      return;
      if ((paramInt == 10) || (paramInt == 11)) {
        i = 2;
      } else if (paramInt == 6) {
        i = 3;
      } else {
        i = 4;
      }
    }
  }
  
  private int a(ToServiceMsg paramToServiceMsg, int paramInt)
    throws InvalidProtocolBufferMicroException
  {
    int i = paramInt;
    if (-1 == paramInt)
    {
      ThemeAuth.ReqBody localReqBody = new ThemeAuth.ReqBody();
      localReqBody.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      i = localReqBody.uint32_sub_cmd.get();
    }
    if (1 == i) {
      ThemeUtil.getUinThemePreferences(this.mApp).edit().putLong("authTime", 0L).commit();
    }
    return i;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ThemeAuth.DiyThemeDetail paramDiyThemeDetail)
  {
    MobileQQ localMobileQQ = this.mApp.getApplication();
    Object localObject = ThemeBackground.getSharedPreferences(localMobileQQ, this.mApp.getAccount(), 0);
    if ((paramInt1 == 2) && (!ChatBackgroundManager.g(localMobileQQ, this.mApp.getAccount(), null).equals("null"))) {
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramDiyThemeDetail.str_bg_url.get();
    }
    for (;;)
    {
      int i = paramInt2;
      if (1 > paramInt2) {
        i = paramDiyThemeDetail.uin32_id.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeHandler", 2, "update sv ThemeBackground, page=" + paramInt1 + ", id=" + i + ", url=" + paramString1);
      }
      String str1;
      boolean bool;
      if (!TextUtils.isEmpty(paramString1))
      {
        str1 = ((SharedPreferences)localObject).getString(paramString3 + "_id", "");
        localObject = ((SharedPreferences)localObject).getString(paramString3 + "_url", "");
        if ((!("" + i).equals(str1)) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label619;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "updateThemeBackgroundPic, bgType=" + paramString3 + ", notChange=" + bool + ", localId=" + str1 + ", id=" + i + ", url=" + paramString1 + ", page=" + paramInt1);
        }
        if (bool) {
          break;
        }
        if (paramDiyThemeDetail == null) {
          break label625;
        }
        localObject = paramDiyThemeDetail.str_name.get();
        label354:
        if (paramDiyThemeDetail == null) {
          break label650;
        }
        paramInt2 = paramDiyThemeDetail.uin32_feetype.get();
        label368:
        if (paramDiyThemeDetail == null) {
          break label655;
        }
        str1 = paramDiyThemeDetail.str_bg_thumbnail_url.get();
        label383:
        String str2 = ChatBackgroundManager.c(true, "" + i);
        ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString3, this.mApp.getAccount(), str2, paramString1, "" + i, (String)localObject, paramInt2, str1, true);
        if (!paramString3.equals(paramString2))
        {
          String str3 = ChatBackgroundManager.c(true, "" + i);
          ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString2, this.mApp.getAccount(), str3, paramString1, "" + i, (String)localObject, paramInt2, str1, true);
        }
        if (paramInt1 == 2) {
          wkj.i(localMobileQQ, this.app.getAccount(), null, str2);
        }
      }
      if ((!"100".equals(String.valueOf(i))) && (!"0".equals(String.valueOf(i)))) {
        break;
      }
      if (paramDiyThemeDetail != null) {}
      for (paramInt1 = paramDiyThemeDetail.uin32_feetype.get();; paramInt1 = 1)
      {
        ThemeBackground.setThemeBackgroundPic(localMobileQQ, paramString3, this.mApp.getAccount(), "", "", "", "", paramInt1, null, true);
        return;
        label619:
        bool = false;
        break;
        label625:
        localObject = "" + i;
        break label354;
        label650:
        paramInt2 = 1;
        break label368;
        label655:
        str1 = null;
        break label383;
      }
    }
  }
  
  private void a(ThemeAuth.RspBody paramRspBody)
  {
    int i = ((ThemeAuth.SubCmd0x2RspCheck)paramRspBody.msg_subcmd0x2_rsp_check.get()).int32_result.get();
    if (QLog.isColorLevel()) {
      QLog.i("Theme.ThemeHandler", 2, "handleThemeVersionCheck:" + i);
    }
    paramRspBody = this.mApp.getAccount();
    if (!TextUtils.isEmpty(paramRspBody))
    {
      paramRspBody = this.mApp.getApplication().getSharedPreferences(paramRspBody, 0);
      if (i == 6) {
        paramRspBody.edit().putBoolean("need_check_theme_ver", true).commit();
      }
      if (paramRspBody.getBoolean("need_check_theme_ver", false)) {
        paramRspBody.edit().putBoolean("need_check_theme_ver", false).commit();
      }
    }
    if (i == 0)
    {
      paramRspBody = this.mApp.getHandler(Conversation.class);
      Message localMessage = new Message();
      localMessage.what = 1038;
      localMessage.obj = bpC;
      paramRspBody.sendMessage(localMessage);
      anot.a(this.app, "CliOper", "", "", "0X8005B9E", "0X8005B9E", 0, 0, "", "", "", "");
      localMessage = new Message();
      localMessage.what = 1039;
      paramRspBody.sendMessageDelayed(localMessage, 90000L);
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, ThemeAuth.RspBody paramRspBody, boolean paramBoolean)
    throws InvalidProtocolBufferMicroException
  {
    String str = acfp.m(2131715309);
    int i;
    if (paramBoolean)
    {
      paramToServiceMsg = (ThemeAuth.SubCmd0x3RspSet)paramRspBody.msg_subcmd0x3_rsp_set.get();
      i = paramToServiceMsg.int32_result.get();
      paramRspBody = String.valueOf(paramToServiceMsg.uint32_theme_id.get());
    }
    for (paramToServiceMsg = paramToServiceMsg.str_diy_theme_err_msg.get();; paramToServiceMsg = str)
    {
      if ((QLog.isColorLevel()) || (i != 0)) {
        QLog.d("Theme.ThemeHandler", 1, "handleThemeAuth Set result:" + i + ", themeId:" + paramRspBody);
      }
      if ((this.a != null) && (this.ax != null)) {
        break;
      }
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:null == service || null == reqbundle, result:" + i);
      this.ax = null;
      this.a = null;
      return true;
      paramRspBody = new ThemeAuth.ReqBody();
      paramRspBody.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      int j = ((ThemeAuth.SubCmd0x3ReqSet)paramRspBody.msg_subcmd0x3_req_set.get()).uint32_theme_id.get();
      i = -404;
      paramRspBody = String.valueOf(j);
    }
    this.ax.putString("message", paramToServiceMsg);
    this.ax.putInt("result_int", i);
    if ((!TextUtils.isEmpty(paramRspBody)) && (paramRspBody.equals(this.ax.getString("themeId"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeHandler", 2, "handleThemeAuth set back themeId=" + paramRspBody + ", result=" + i);
      }
      paramToServiceMsg = this.a;
      if (i == 0)
      {
        i = 4;
        paramToServiceMsg.callback(16, i, this.ax, null);
        this.ax = null;
        this.a = null;
        this.cK.set(true);
      }
    }
    for (;;)
    {
      return false;
      i = 8;
      break;
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:themeId has changed themeId=" + paramRspBody + ", rbThemeid=" + this.ax.getString("themeId"));
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, ThemeAuth.SubCmd0x1RspAuth paramSubCmd0x1RspAuth, String paramString1, String paramString2)
  {
    String str2 = String.valueOf(paramSubCmd0x1RspAuth.uint32_theme_id.get());
    String str1 = paramSubCmd0x1RspAuth.str_version.get();
    String str3 = paramSubCmd0x1RspAuth.str_download_url.get();
    int i = paramSubCmd0x1RspAuth.int32_suit_id.get();
    if ((QLog.isColorLevel()) || ((paramString2 != null) && (!paramString1.equals(str2)))) {
      QLog.d("Theme.ThemeHandler", 2, "authHandler get themeId=" + str2 + ",ver=" + str1 + ",Url=" + str3 + ", seriesId=" + i + ", reqthemeId:" + paramString1 + ", reqVersion:" + paramString2);
    }
    if (!"999".equals(str2))
    {
      paramString1 = str1;
      if (!"1000".equals(str2)) {}
    }
    else
    {
      paramString1 = "20000000";
    }
    if ((TextUtils.isEmpty(paramString1)) || ("0".equals(str2))) {
      paramString1 = String.valueOf(200);
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("oldEnginePath", null);
    paramString2 = SkinEngine.getInstances().getSkinRootPath();
    QLog.e("Theme.ThemeHandler", 1, "engine path old is : " + paramToServiceMsg + " new is " + paramString2);
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(paramToServiceMsg)))
    {
      QLog.e("Theme.ThemeHandler", 1, "engine init during auth, resend auth");
      cMC();
      return true;
    }
    if (i <= 0)
    {
      QLog.e("Theme.ThemeHandler", 1, "clear weekTheme because seriesId=" + i);
      ThemeUtil.setWeekLoopTheme(this.mApp, null, null, 0L);
    }
    if (i > 0)
    {
      paramToServiceMsg = ThemeUtil.getWeekLoopTheme(this.app);
      if (!TextUtils.isEmpty(paramToServiceMsg)) {
        eU(paramToServiceMsg, "203");
      }
    }
    for (;;)
    {
      return false;
      if ((!"0".equals(str2)) && (!TextUtils.isEmpty(paramString1)) && (!this.cK.get()))
      {
        if (paramSubCmd0x1RspAuth.uint32_diy_theme_flag.get() == 1)
        {
          paramToServiceMsg = (ThemeAuth.RspDiyThemeInfo)paramSubCmd0x1RspAuth.rsp_diy_theme_info.get();
          paramSubCmd0x1RspAuth = (ThemeAuth.RspDiyThemeDetail)paramSubCmd0x1RspAuth.rsp_diy_theme_detail.get();
          a(0, paramToServiceMsg.uin32_drawer_tab_id.get(), paramToServiceMsg.str_drawer_tab_url.get(), "theme_bg_setting_path", "theme_bg_setting_path_png", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.drawer_tab_detail.get());
          a(1, paramToServiceMsg.uin32_message_tab_id.get(), paramToServiceMsg.str_message_tab_url.get(), "theme_bg_message_path", "theme_bg_message_path_png", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.message_tab_detail.get());
          a(2, paramToServiceMsg.uin32_aio_tab_id.get(), paramToServiceMsg.str_aio_tab_url.get(), "theme_bg_aio_path", "theme_bg_aio_path", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.aio_tab_detail.get());
          a(3, paramToServiceMsg.uin32_friend_tab_id.get(), paramToServiceMsg.str_friend_tab_url.get(), "theme_bg_friend_path", "theme_bg_friend_path_png", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.friend_tab_detail.get());
          a(4, paramToServiceMsg.uin32_dynamic_tab_id.get(), paramToServiceMsg.str_dynamic_tab_url.get(), "theme_bg_dynamic_path", "theme_bg_dynamic_path_png", (ThemeAuth.DiyThemeDetail)paramSubCmd0x1RspAuth.dynamic_tab_detail.get());
        }
        eU(str2, "204");
      }
      else
      {
        D(null, null, true);
      }
    }
  }
  
  private void ck(Bundle paramBundle)
  {
    if (this.mApp == null)
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
      return;
    }
    Object localObject1 = this.mApp.getApplication();
    String str1 = paramBundle.getString("themeId");
    String str2 = paramBundle.getString("themePath");
    Object localObject2;
    Object localObject3;
    String str3;
    try
    {
      localObject2 = new ThemeAuth.SubCmd0x1ReqAuth();
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).uint32_op_type.set(1);
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).uint32_theme_id.set(Integer.parseInt(str1));
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).str_theme_version.set("20000000");
      ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
      localObject3 = ThemeUtil.getUinThemePreferences(this.mApp);
      str3 = ((SharedPreferences)localObject3).getString("currentThemeId_6.3.5", null);
      l1 = ((SharedPreferences)localObject3).getLong("themeSetTimeKey", 0L);
      QLog.d("Theme.ThemeHandler", 1, "Theme Auth themeId=" + str1 + ",version=" + "20000000" + ", userThemeId=" + str3 + ",currentThemeResPath=" + str2 + ", usr=" + aofy.aA(this.mApp.getAccount(), 2) + ", oldTime=" + l1);
      if ("1000".equals(str1)) {
        break label962;
      }
      Object localObject4 = p(str2);
      if (((HashMap)localObject4).size() < 3) {
        QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth fileMD5 size error:size=" + ((HashMap)localObject4).size());
      }
      localObject4 = ((HashMap)localObject4).entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "Theme file Info,Filepath=" + (String)localEntry.getKey() + ",FileMd5=" + (String)localEntry.getValue());
          }
          ThemeAuth.ThemeFileInfo localThemeFileInfo = new ThemeAuth.ThemeFileInfo();
          localThemeFileInfo.str_file_path.set((String)localEntry.getKey());
          localThemeFileInfo.str_file_md5.set((String)localEntry.getValue());
          ((ThemeAuth.SubCmd0x1ReqAuth)localObject2).rpt_msg_topic_file_info.add(localThemeFileInfo);
          continue;
          if (BaseApplicationImpl.IS_SUPPORT_THEME) {
            break;
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("Theme.ThemeHandler", 1, "Theme Auth send Exception:" + paramBundle.getMessage() + ", themeId=" + str1 + ", version=" + "20000000");
    }
    label516:
    label563:
    do
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth ERROR_CODE_ISNOT_SUPPORT_THEME.");
      int j = aqiw.getSystemNetwork(null);
      if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
        break;
      }
      i = 1;
      aogz.a(null, "theme_detail", "205", 157, j, i, str1, "20000000", "1", "");
      return;
      ((SharedPreferences)localObject3).edit().putLong("authTime", 0L).commit();
      localObject3 = new ThemeAuth.ReqBody();
      ((ThemeAuth.ReqBody)localObject3).uint32_sub_cmd.set(1);
      ((ThemeAuth.ReqBody)localObject3).int32_plat_id.set(109);
      ((ThemeAuth.ReqBody)localObject3).str_qq_version.set("3.4.4.3058");
      ((ThemeAuth.ReqBody)localObject3).uint32_qq_version.set(Integer.parseInt("3058"));
      ((ThemeAuth.ReqBody)localObject3).msg_subcmd0x1_req_auth.set((MessageMicro)localObject2);
      ((ThemeAuth.ReqBody)localObject3).setHasFlag(true);
      localObject2 = new ToServiceMsg("mobileqq.service", this.mApp.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
      ((ToServiceMsg)localObject2).putWupBuffer(((ThemeAuth.ReqBody)localObject3).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putAll(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeHandler", 2, "Theme Auth send request, themeID=" + str1 + ", userThemeId=" + str3);
      }
      super.sendPbReq((ToServiceMsg)localObject2);
    } while (("1000".equals(str1)) || (TextUtils.isEmpty(str2)));
    paramBundle = new File(str2);
    long l1 = System.currentTimeMillis();
    localObject1 = ThemeUtil.getThemeInfo((Context)localObject1, str1);
    long l2 = System.currentTimeMillis();
    if (localObject1 != null) {}
    for (int i = 1;; i = -1)
    {
      aogz.a(null, "theme_sp_speed", "204", 153, -1, i, String.valueOf(l2 - l1), "6653", "read", "");
      if ((paramBundle.isDirectory()) && (localObject1 != null))
      {
        i = ThemeUtil.getFileNumInFile(paramBundle);
        if ((i > 0) && ((((ThemeUtil.ThemeInfo)localObject1).fileNum <= 0) || (i >= ((ThemeUtil.ThemeInfo)localObject1).fileNum))) {
          break;
        }
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo.fileNum:" + ((ThemeUtil.ThemeInfo)localObject1).fileNum + ", fileNum:" + i + ", themeId=" + str1 + ", version=" + "20000000" + ", currentThemeResPath:" + str2);
        aogz.a(this.app, "theme_detail", "204", 157, aqiw.getSystemNetwork(null), 101, str1, "665", String.valueOf(i), String.valueOf(((ThemeUtil.ThemeInfo)localObject1).fileNum));
        break;
        label962:
        if ((!TextUtils.isEmpty(str3)) && (!"1000".equals(str3))) {
          break label563;
        }
        l1 = ((SharedPreferences)localObject3).getLong("authTime", 0L);
        l2 = System.currentTimeMillis();
        if (l2 > l1 + 7200000L)
        {
          ((SharedPreferences)localObject3).edit().putLong("authTime", l2).commit();
          break label563;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "sendThemeAuth nowTime <= authTime + 2h");
        }
        aogc.QN(true);
        return;
      }
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo == null || currentThemeResPath:" + str2);
      break;
      i = -40;
      break label516;
    }
  }
  
  private void eU(String paramString1, String paramString2) {}
  
  private HashMap<String, String> p(String paramString)
  {
    paramString = aqhq.ag(paramString);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while ((i < 3) && (i < paramString.size()))
    {
      int j = new Random().nextInt(paramString.size() - 1);
      String str1 = (String)paramString.get(j);
      String str2 = str1.substring(str1.substring(0, str1.lastIndexOf(47)).lastIndexOf('/') + 1);
      if ((str2 != null) && (str2.length() > 0) && (!localHashMap.containsKey(str2)))
      {
        String str3 = aqhq.bZ(str1, "MD5");
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme getRandomFileMd5 file=" + str1 + ",key=" + str2 + ",md5=" + str3 + ", files=" + paramString.size() + ", index=" + j);
        }
        if ((str3 != null) && (str3.length() > 0)) {
          localHashMap.put(str2, str3);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public void D(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.cI.set(true);
    }
    label12:
    String str;
    do
    {
      do
      {
        return;
      } while (!this.cI.get());
      this.cI.set(false);
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {}
      }
      else
      {
        paramString2 = ThemeUtil.getCurrentThemeInfo();
        paramString1 = paramString2.getString("themeId");
        str = paramString2.getString("version");
      }
    } while ((TextUtils.isEmpty(paramString1)) || ("1000".equals(paramString1)) || ("999".equals(paramString1)) || (TextUtils.isEmpty(str)));
    bpC = paramString1;
    for (;;)
    {
      int i;
      try
      {
        i = Integer.parseInt(str) % 10000;
        paramString2 = ThemeUtil.getThemeDensity(this.mApp.getApp());
        if (!"m".equals(paramString2)) {
          break label376;
        }
        i -= 1000;
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "ver = " + i);
        }
        paramString2 = new ThemeAuth.SubCmd0x2ReqCheck();
        paramString2.str_theme_version.set(String.valueOf(i));
        paramString2.uint32_theme_id.set(Integer.parseInt(paramString1));
        paramString1 = new ThemeAuth.ReqBody();
        paramString1.uint32_sub_cmd.set(2);
        paramString1.int32_plat_id.set(109);
        paramString1.str_qq_version.set("3.4.4.3058");
        paramString1.uint32_qq_version.set(Integer.parseInt("3058"));
        paramString1.msg_subcmd0x2_req_check.set(paramString2);
        paramString1.setHasFlag(true);
        paramString2 = new ToServiceMsg("mobileqq.service", this.mApp.getCurrentAccountUin(), "AuthSvr.ThemeAuth");
        paramString2.putWupBuffer(paramString1.toByteArray());
        super.sendPbReq(paramString2);
        if (!QLog.isColorLevel()) {
          break label12;
        }
        QLog.i("Theme.ThemeHandler", 2, "ThemeVersion Check sent,cur_ver = " + i);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Theme.ThemeHandler", 2, "Exception:" + paramString1.toString());
      return;
      label376:
      paramBoolean = "h".equals(paramString2);
      if (paramBoolean) {
        i -= 2000;
      } else {
        i -= 3000;
      }
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, ThemeDiyStyleLogic.a parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 74
    //   11: iconst_2
    //   12: new 120	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 984
    //   22: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 778
    //   32: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 986
    //   42: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +8 -> 67
    //   62: aload 4
    //   64: ifnonnull +13 -> 77
    //   67: ldc 74
    //   69: iconst_2
    //   70: ldc_w 988
    //   73: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: return
    //   77: aload 4
    //   79: ldc 218
    //   81: aload_1
    //   82: invokevirtual 216	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: aload 5
    //   88: putfield 468	acmi:a	Lcom/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$a;
    //   91: aload_0
    //   92: aload 4
    //   94: putfield 470	acmi:ax	Landroid/os/Bundle;
    //   97: new 478	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet
    //   100: dup
    //   101: invokespecial 989	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: getfield 481	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_theme_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: aload_1
    //   110: invokestatic 664	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   113: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   116: aload_3
    //   117: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   120: istore 8
    //   122: iload 7
    //   124: istore 6
    //   126: iload 8
    //   128: ifne +9 -> 137
    //   131: aload_3
    //   132: invokestatic 664	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   135: istore 6
    //   137: aload_2
    //   138: getfield 992	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_suit_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   141: iload 6
    //   143: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   146: aload 4
    //   148: ldc_w 994
    //   151: invokevirtual 998	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull +9 -> 165
    //   159: aload 4
    //   161: aload_1
    //   162: invokevirtual 844	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   165: ldc_w 1000
    //   168: aload 4
    //   170: ldc_w 1002
    //   173: invokevirtual 488	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: invokevirtual 42	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq +277 -> 456
    //   182: new 1004	com/tencent/pb/theme/ThemeAuth$diyThemeInfo
    //   185: dup
    //   186: invokespecial 1005	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:<init>	()V
    //   189: astore_1
    //   190: aload_1
    //   191: getfield 1006	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_drawer_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   194: aload 4
    //   196: ldc_w 1008
    //   199: invokevirtual 488	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 664	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   205: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   208: aload_1
    //   209: getfield 1009	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_message_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   212: aload 4
    //   214: ldc_w 1011
    //   217: invokevirtual 488	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: invokestatic 664	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   226: aload_1
    //   227: getfield 1012	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_aio_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   230: aload 4
    //   232: ldc_w 1014
    //   235: invokevirtual 488	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokestatic 664	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   244: aload_1
    //   245: getfield 1017	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_freind_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   248: aload 4
    //   250: ldc_w 1019
    //   253: invokevirtual 488	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokestatic 664	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   259: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   262: aload_1
    //   263: getfield 1022	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:uin32_dynamics_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   266: aload 4
    //   268: ldc_w 1024
    //   271: invokevirtual 488	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokestatic 664	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   277: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   280: aload_2
    //   281: getfield 1028	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:diy_theme_info	Lcom/tencent/pb/theme/ThemeAuth$diyThemeInfo;
    //   284: aload_1
    //   285: invokevirtual 1029	com/tencent/pb/theme/ThemeAuth$diyThemeInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   288: aload_2
    //   289: getfield 1030	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_diy_theme_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   292: iconst_1
    //   293: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   296: new 276	com/tencent/pb/theme/ThemeAuth$ReqBody
    //   299: dup
    //   300: invokespecial 277	com/tencent/pb/theme/ThemeAuth$ReqBody:<init>	()V
    //   303: astore_1
    //   304: aload_1
    //   305: getfield 291	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   308: iconst_3
    //   309: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   312: aload_1
    //   313: getfield 804	com/tencent/pb/theme/ThemeAuth$ReqBody:int32_plat_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   316: bipush 109
    //   318: invokevirtual 805	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   321: aload_1
    //   322: getfield 808	com/tencent/pb/theme/ThemeAuth$ReqBody:str_qq_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   325: ldc_w 810
    //   328: invokevirtual 670	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   331: aload_1
    //   332: getfield 813	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_qq_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   335: ldc_w 815
    //   338: invokestatic 664	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   341: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   344: aload_1
    //   345: getfield 476	com/tencent/pb/theme/ThemeAuth$ReqBody:msg_subcmd0x3_req_set	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet;
    //   348: aload_2
    //   349: invokevirtual 1031	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   352: aload_1
    //   353: iconst_1
    //   354: invokevirtual 824	com/tencent/pb/theme/ThemeAuth$ReqBody:setHasFlag	(Z)V
    //   357: new 279	com/tencent/qphone/base/remote/ToServiceMsg
    //   360: dup
    //   361: ldc_w 826
    //   364: aload_0
    //   365: getfield 46	acmi:mApp	Lcom/tencent/common/app/AppInterface;
    //   368: invokevirtual 829	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   371: ldc_w 831
    //   374: invokespecial 834	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   377: astore_2
    //   378: aload_2
    //   379: aload_1
    //   380: invokevirtual 837	com/tencent/pb/theme/ThemeAuth$ReqBody:toByteArray	()[B
    //   383: invokevirtual 841	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   386: aload_0
    //   387: aload_2
    //   388: invokespecial 850	accg:sendPbReq	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   391: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq -318 -> 76
    //   397: ldc 74
    //   399: iconst_2
    //   400: ldc_w 1033
    //   403: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: return
    //   407: astore_1
    //   408: ldc 74
    //   410: iconst_2
    //   411: new 120	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 1035
    //   421: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_1
    //   425: invokevirtual 979	java/lang/Exception:toString	()Ljava/lang/String;
    //   428: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: return
    //   438: astore_1
    //   439: ldc 74
    //   441: iconst_1
    //   442: ldc_w 1037
    //   445: aload_1
    //   446: invokestatic 1040	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   449: iload 7
    //   451: istore 6
    //   453: goto -316 -> 137
    //   456: aload_2
    //   457: getfield 1030	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_diy_theme_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   460: iconst_0
    //   461: invokevirtual 657	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   464: goto -168 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	acmi
    //   0	467	1	paramString1	String
    //   0	467	2	paramString2	String
    //   0	467	3	paramString3	String
    //   0	467	4	paramBundle	Bundle
    //   0	467	5	parama	ThemeDiyStyleLogic.a
    //   124	328	6	i	int
    //   1	449	7	j	int
    //   120	7	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   77	122	407	java/lang/Exception
    //   137	155	407	java/lang/Exception
    //   159	165	407	java/lang/Exception
    //   165	296	407	java/lang/Exception
    //   296	406	407	java/lang/Exception
    //   439	449	407	java/lang/Exception
    //   456	464	407	java/lang/Exception
    //   131	137	438	java/lang/Exception
  }
  
  public void cMC()
  {
    if (this.mApp == null)
    {
      QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
      return;
    }
    MobileQQ localMobileQQ = this.mApp.getApplication();
    Object localObject1 = ThemeUtil.getThemePreferences(localMobileQQ);
    Object localObject4;
    Object localObject3;
    if (1 > ((SharedPreferences)localObject1).getInt("themeSpVersion", 0))
    {
      localObject4 = ((SharedPreferences)localObject1).edit();
      try
      {
        localObject1 = ((SharedPreferences)localObject1).getString("userDownloadTheme", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          JSONObject localJSONObject1 = new JSONObject((String)localObject1);
          Iterator localIterator = localJSONObject1.keys();
          while (localIterator.hasNext())
          {
            String str1 = String.valueOf(localIterator.next());
            if ((!TextUtils.isEmpty(str1)) && (!"1000".equals(str1)) && (!"999".equals(str1)))
            {
              JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str1);
              if (localJSONObject2 != null)
              {
                String str2 = localJSONObject2.optString("version");
                localObject3 = ThemeUtil.getThemeInfo(localMobileQQ, str1);
                localObject1 = localObject3;
                if (localObject3 == null)
                {
                  localObject1 = new ThemeUtil.ThemeInfo();
                  ((ThemeUtil.ThemeInfo)localObject1).themeId = str1;
                  ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme = localJSONObject2.optBoolean("sound");
                  ((ThemeUtil.ThemeInfo)localObject1).fileNum = localJSONObject2.optInt("fileNum");
                }
                ((ThemeUtil.ThemeInfo)localObject1).version = str2;
                ((ThemeUtil.ThemeInfo)localObject1).zipVer = Integer.parseInt(str2);
                ((ThemeUtil.ThemeInfo)localObject1).status = "1";
                ThemeUtil.setThemeInfo(localMobileQQ, (ThemeUtil.ThemeInfo)localObject1);
              }
            }
          }
        }
        ((SharedPreferences.Editor)localObject4).putInt("themeSpVersion", 1).commit();
      }
      catch (Exception localException)
      {
        QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth themeUpdate error:" + localException.getMessage());
      }
    }
    else
    {
      localObject4 = ThemeUtil.getCurrentThemeInfo();
      ((Bundle)localObject4).putString("oldEnginePath", ((Bundle)localObject4).getString("themePath"));
      QLog.d("Theme.ThemeHandler", 1, "sendThemeAuth init: , skThemeId:" + ((Bundle)localObject4).getString("themeId") + ", skVersion:" + ((Bundle)localObject4).getString("version") + ", qqVersion:" + "3.4.4");
      localObject3 = ((Bundle)localObject4).getString("themeId");
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = "1000";
        ((Bundle)localObject4).putString("themeId", "1000");
      }
      if (anlm.pp((String)localObject2))
      {
        localObject3 = aohc.c(this.app).getString("themeID");
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth isThemeSimpleUI:" + (String)localObject2 + " pre:" + (String)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label515;
        }
        localObject2 = "1000";
        label469:
        ((Bundle)localObject4).putString("themeId", (String)localObject2);
        if (!"1000".equals(localObject3)) {
          break label520;
        }
        ((Bundle)localObject4).remove("themePath");
      }
    }
    for (;;)
    {
      ck((Bundle)localObject4);
      return;
      ((SharedPreferences.Editor)localObject4).remove("userDownloadTheme");
      break;
      label515:
      localObject2 = localObject3;
      break label469;
      label520:
      if (!"999".equals(localObject3)) {
        break label554;
      }
      ((Bundle)localObject4).putString("themePath", new aogy().a().AH());
    }
    label554:
    Object localObject2 = new aogy().a((String)localObject3);
    ((VasQuickUpdateManager)this.app.getManager(184)).queryItemVersion(3, ((aogy)localObject2).AG(), true, false, 0L, new acmk(this, (aogy)localObject2, localMobileQQ, (Bundle)localObject4));
  }
  
  public void eV(String paramString1, String paramString2)
  {
    boolean bool1 = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    boolean bool2 = anlm.ayn();
    if (!bool2)
    {
      if (!bool1) {
        break label110;
      }
      ThemeSwitcher.a("1103", paramString2, null);
    }
    for (;;)
    {
      QLog.e("Theme.ThemeHandler", 1, "onGetServerTheme: " + paramString1 + "," + bool2 + "," + bool1 + "," + paramString2);
      if (!ThemeUtil.isFixTheme(paramString1)) {
        aohc.a(this.app, paramString1, "20000000");
      }
      return;
      label110:
      ThemeSwitcher.a(paramString1, paramString2, new acmj(this));
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  /* Error */
  public void onReceive(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 831
    //   3: aload_2
    //   4: invokevirtual 1186	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   7: invokevirtual 42	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +51 -> 68
    //   20: ldc 74
    //   22: iconst_2
    //   23: new 120	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 1188
    //   33: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 1191	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   40: invokevirtual 370	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   43: ldc_w 1193
    //   46: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_3
    //   50: checkcast 1195	[B
    //   53: checkcast 1195	[B
    //   56: invokestatic 1201	aqoj:C	([B)Ljava/lang/String;
    //   59: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: new 403	com/tencent/pb/theme/ThemeAuth$RspBody
    //   71: dup
    //   72: invokespecial 1202	com/tencent/pb/theme/ThemeAuth$RspBody:<init>	()V
    //   75: astore 7
    //   77: aload_3
    //   78: ifnull +16 -> 94
    //   81: aload 7
    //   83: aload_3
    //   84: checkcast 1195	[B
    //   87: checkcast 1195	[B
    //   90: invokevirtual 1205	com/tencent/pb/theme/ThemeAuth$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: pop
    //   94: aload 7
    //   96: getfield 1206	com/tencent/pb/theme/ThemeAuth$RspBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   99: invokevirtual 1209	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   102: ifeq +593 -> 695
    //   105: aload 7
    //   107: getfield 1206	com/tencent/pb/theme/ThemeAuth$RspBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 297	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: istore 4
    //   115: aload_2
    //   116: invokevirtual 1191	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   119: ifeq +582 -> 701
    //   122: aload_3
    //   123: ifnull +578 -> 701
    //   126: iconst_1
    //   127: istore 6
    //   129: iload 4
    //   131: istore 5
    //   133: iload 6
    //   135: ifne +64 -> 199
    //   138: aload_0
    //   139: aload_1
    //   140: iload 4
    //   142: invokespecial 1211	acmi:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)I
    //   145: istore 5
    //   147: ldc 74
    //   149: iconst_1
    //   150: new 120	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 1213
    //   160: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_3
    //   164: checkcast 1195	[B
    //   167: checkcast 1195	[B
    //   170: invokestatic 1201	aqoj:C	([B)Ljava/lang/String;
    //   173: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 1215
    //   179: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 5
    //   184: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iconst_3
    //   194: iload 5
    //   196: if_icmpne -183 -> 13
    //   199: iconst_1
    //   200: iload 5
    //   202: if_icmpne +629 -> 831
    //   205: aload 7
    //   207: getfield 1219	com/tencent/pb/theme/ThemeAuth$RspBody:msg_subcmd0x1_rsp_auth	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth;
    //   210: invokevirtual 1220	com/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   213: checkcast 508	com/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth
    //   216: astore_2
    //   217: aload_2
    //   218: getfield 1221	com/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   221: invokevirtual 419	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   224: istore 4
    //   226: new 276	com/tencent/pb/theme/ThemeAuth$ReqBody
    //   229: dup
    //   230: invokespecial 277	com/tencent/pb/theme/ThemeAuth$ReqBody:<init>	()V
    //   233: astore_3
    //   234: aload_3
    //   235: aload_1
    //   236: invokevirtual 283	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   239: iconst_4
    //   240: aload_1
    //   241: invokevirtual 283	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   244: arraylength
    //   245: iconst_4
    //   246: isub
    //   247: invokevirtual 287	com/tencent/pb/theme/ThemeAuth$ReqBody:mergeFrom	([BII)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   250: pop
    //   251: aload_3
    //   252: getfield 819	com/tencent/pb/theme/ThemeAuth$ReqBody:msg_subcmd0x1_req_auth	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth;
    //   255: invokevirtual 1222	com/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   258: checkcast 650	com/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth
    //   261: astore 8
    //   263: aload 8
    //   265: getfield 658	com/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth:uint32_theme_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   268: invokevirtual 297	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   271: invokestatic 177	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   274: astore_3
    //   275: aload 8
    //   277: getfield 667	com/tencent/pb/theme/ThemeAuth$SubCmd0x1ReqAuth:str_theme_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   280: invokevirtual 340	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   283: astore 8
    //   285: iload 4
    //   287: ifeq +420 -> 707
    //   290: ldc 74
    //   292: iconst_1
    //   293: new 120	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 1224
    //   303: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload 4
    //   308: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: ldc_w 528
    //   314: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 530
    //   324: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 8
    //   329: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload_0
    //   339: getfield 249	acmi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: ldc_w 1226
    //   345: iload 4
    //   347: invokestatic 177	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   350: iload 4
    //   352: invokestatic 177	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   355: aconst_null
    //   356: fconst_0
    //   357: invokestatic 1231	aqri:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   360: new 717	java/util/HashMap
    //   363: dup
    //   364: invokespecial 903	java/util/HashMap:<init>	()V
    //   367: astore 9
    //   369: aload 9
    //   371: ldc 220
    //   373: iload 4
    //   375: invokestatic 177	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   378: invokevirtual 950	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   381: pop
    //   382: invokestatic 679	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   385: invokestatic 1236	anpc:a	(Landroid/content/Context;)Lanpc;
    //   388: ldc 169
    //   390: ldc_w 1226
    //   393: iconst_0
    //   394: lconst_0
    //   395: ldc2_w 1237
    //   398: aload 9
    //   400: ldc 169
    //   402: iconst_1
    //   403: invokevirtual 1242	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   406: aload_0
    //   407: getfield 249	acmi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   410: ldc_w 794
    //   413: ldc_w 640
    //   416: sipush 157
    //   419: aconst_null
    //   420: invokestatic 792	aqiw:getSystemNetwork	(Landroid/content/Context;)I
    //   423: iconst_0
    //   424: iload 4
    //   426: isub
    //   427: aload_3
    //   428: aload 8
    //   430: ldc 105
    //   432: ldc 169
    //   434: invokestatic 801	aogz:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   437: new 717	java/util/HashMap
    //   440: dup
    //   441: invokespecial 903	java/util/HashMap:<init>	()V
    //   444: astore 9
    //   446: aload 9
    //   448: ldc_w 1244
    //   451: aload_3
    //   452: invokevirtual 950	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   455: pop
    //   456: aload 9
    //   458: ldc_w 1246
    //   461: aload 8
    //   463: invokevirtual 950	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   466: pop
    //   467: aload 9
    //   469: ldc_w 1248
    //   472: iload 4
    //   474: invokestatic 177	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   477: invokevirtual 950	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   480: pop
    //   481: aload_0
    //   482: getfield 46	acmi:mApp	Lcom/tencent/common/app/AppInterface;
    //   485: invokevirtual 52	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   488: invokestatic 1236	anpc:a	(Landroid/content/Context;)Lanpc;
    //   491: astore 10
    //   493: aload_0
    //   494: getfield 46	acmi:mApp	Lcom/tencent/common/app/AppInterface;
    //   497: invokevirtual 239	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   500: astore 11
    //   502: iload 4
    //   504: ifne +387 -> 891
    //   507: iconst_1
    //   508: istore 6
    //   510: aload 10
    //   512: aload 11
    //   514: ldc_w 1250
    //   517: iload 6
    //   519: lconst_1
    //   520: lconst_0
    //   521: aload 9
    //   523: ldc 169
    //   525: iconst_0
    //   526: invokevirtual 1242	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   529: iload 4
    //   531: iconst_1
    //   532: if_icmplt +246 -> 778
    //   535: iload 4
    //   537: iconst_5
    //   538: if_icmpeq +240 -> 778
    //   541: iload 4
    //   543: bipush 14
    //   545: if_icmpeq +233 -> 778
    //   548: iload 4
    //   550: bipush 20
    //   552: if_icmpgt +226 -> 778
    //   555: aload_0
    //   556: getfield 46	acmi:mApp	Lcom/tencent/common/app/AppInterface;
    //   559: invokestatic 301	com/tencent/mobileqq/theme/ThemeUtil:getUinThemePreferences	(Lmqq/app/AppRuntime;)Landroid/content/SharedPreferences;
    //   562: invokeinterface 307 1 0
    //   567: ldc_w 1252
    //   570: iload 4
    //   572: invokeinterface 1094 3 0
    //   577: invokeinterface 318 1 0
    //   582: pop
    //   583: aload_0
    //   584: getfield 46	acmi:mApp	Lcom/tencent/common/app/AppInterface;
    //   587: ldc 36
    //   589: ldc_w 395
    //   592: invokestatic 1255	com/tencent/mobileqq/theme/ThemeUtil:setCurrentThemeIdVersion	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;
    //   595: pop
    //   596: aload 7
    //   598: getfield 1219	com/tencent/pb/theme/ThemeAuth$RspBody:msg_subcmd0x1_rsp_auth	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth;
    //   601: getfield 1258	com/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth:str_err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   604: invokevirtual 340	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   607: astore_1
    //   608: ldc 74
    //   610: iconst_1
    //   611: new 120	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 1260
    //   621: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: iload 4
    //   626: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   629: ldc_w 528
    //   632: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_3
    //   636: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 1262
    //   642: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload_1
    //   646: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: aload_0
    //   656: iload 4
    //   658: aload_3
    //   659: aload_1
    //   660: invokespecial 1264	acmi:H	(ILjava/lang/String;Ljava/lang/String;)V
    //   663: return
    //   664: astore_1
    //   665: ldc 74
    //   667: iconst_1
    //   668: new 120	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 1266
    //   678: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_1
    //   682: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   685: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: return
    //   695: iconst_m1
    //   696: istore 4
    //   698: goto -583 -> 115
    //   701: iconst_0
    //   702: istore 6
    //   704: goto -575 -> 129
    //   707: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq -304 -> 406
    //   713: ldc 74
    //   715: iconst_2
    //   716: new 120	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   723: ldc_w 1268
    //   726: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: iload 4
    //   731: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   734: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: goto -334 -> 406
    //   743: astore 9
    //   745: ldc 74
    //   747: iconst_1
    //   748: new 120	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 1270
    //   758: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 9
    //   763: invokevirtual 979	java/lang/Exception:toString	()Ljava/lang/String;
    //   766: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: goto -246 -> 529
    //   778: iload 4
    //   780: ifne +16 -> 796
    //   783: aload_0
    //   784: aload_1
    //   785: aload_2
    //   786: aload_3
    //   787: aload 8
    //   789: invokespecial 1272	acmi:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x1RspAuth;Ljava/lang/String;Ljava/lang/String;)Z
    //   792: ifeq -779 -> 13
    //   795: return
    //   796: ldc 74
    //   798: iconst_1
    //   799: new 120	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   806: ldc_w 1274
    //   809: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: iload 4
    //   814: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   817: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   823: aload_0
    //   824: aconst_null
    //   825: aconst_null
    //   826: iconst_1
    //   827: invokevirtual 644	acmi:D	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   830: return
    //   831: iconst_2
    //   832: iload 5
    //   834: if_icmpne +10 -> 844
    //   837: aload_0
    //   838: aload 7
    //   840: invokespecial 1276	acmi:a	(Lcom/tencent/pb/theme/ThemeAuth$RspBody;)V
    //   843: return
    //   844: iconst_3
    //   845: iload 5
    //   847: if_icmpne +16 -> 863
    //   850: aload_0
    //   851: aload_1
    //   852: aload 7
    //   854: iload 6
    //   856: invokespecial 1278	acmi:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/pb/theme/ThemeAuth$RspBody;Z)Z
    //   859: ifeq -846 -> 13
    //   862: return
    //   863: ldc 74
    //   865: iconst_1
    //   866: new 120	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 1280
    //   876: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: iload 5
    //   881: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   884: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   890: return
    //   891: iconst_0
    //   892: istore 6
    //   894: goto -384 -> 510
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	897	0	this	acmi
    //   0	897	1	paramToServiceMsg	ToServiceMsg
    //   0	897	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	897	3	paramObject	Object
    //   113	700	4	i	int
    //   131	749	5	j	int
    //   127	766	6	bool	boolean
    //   75	778	7	localRspBody	ThemeAuth.RspBody
    //   261	527	8	localObject	Object
    //   367	155	9	localHashMap	HashMap
    //   743	19	9	localException	Exception
    //   491	20	10	localanpc	anpc
    //   500	13	11	str	String
    // Exception table:
    //   from	to	target	type
    //   68	77	664	java/lang/Exception
    //   81	94	664	java/lang/Exception
    //   94	115	664	java/lang/Exception
    //   115	122	664	java/lang/Exception
    //   138	193	664	java/lang/Exception
    //   205	285	664	java/lang/Exception
    //   290	406	664	java/lang/Exception
    //   406	437	664	java/lang/Exception
    //   555	663	664	java/lang/Exception
    //   707	740	664	java/lang/Exception
    //   745	775	664	java/lang/Exception
    //   783	795	664	java/lang/Exception
    //   796	830	664	java/lang/Exception
    //   837	843	664	java/lang/Exception
    //   850	862	664	java/lang/Exception
    //   863	890	664	java/lang/Exception
    //   437	502	743	java/lang/Exception
    //   510	529	743	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acmi
 * JD-Core Version:    0.7.0.1
 */