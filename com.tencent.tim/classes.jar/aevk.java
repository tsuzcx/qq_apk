import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.10;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.11;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.12;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.13;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.4;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.6;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.8;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.9;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ReportedBanner;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.OlympicActConfig;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.InflaterInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;

public class aevk
  extends MSFServlet
{
  private static String bBU = acfp.m(2131704329);
  private static final int[] df = { 1, 2, 3, 5, 10, 13, 23, 31, 38, 42, 44, 46, 47, 49, 50, 53, 55, 56, 57, 61, 62, 63, 64, 65, 66, 69, 206, 205, 72, 73, 74, 75, 385, 94, 78, 79, 80, 84, 223, 82, 101, 102, 147, 86, 93, 88, 90, 96, 97, 108, 146, 111, 109, 115, 286, 118, 120, 119, 116, 130, 142, 121, 157, 211, 201, 129, 143, 140, 257, 232, 233, 148, 139, 145, 153, 149, 155, 165, 185, 167, 166, 171, 180, 182, 177, 371, 181, 184, 187, 191, 193, 188, 195, 227, 202, 190, 210, 199, 212, 407, ppf.getInteger(2131427359), ppf.getInteger(2131427360), ppf.getInteger(2131427361), ppf.getInteger(2131427356), ppf.getInteger(2131427357), 218, 226, 225, 222, 256, 228, 235, 234, 238, 247, 244, 245, 253, 295, 254, 259, 260, 262, 204, 271, 267, 275, 358, 268, 269, 272, 274, 279, 308, 281, 283, 284, 280, 360, 289, 314, 297, 301, 296, 330, 347, 313, 312, 397, 321, 326, 320, 328, 331, 336, 329, 337, 345, 351, 349, 355, 372, 384, 379, 357, 378, 381, 273, 364, 365, 369, 387, 386, 392, 393, 394, 401, 400, 403, 404, 405, 408, 410, 194, 596, 604 };
  public static String mCurUin = "";
  private boolean hasReport;
  
  private float A(float paramFloat)
  {
    return paramFloat / (50.0F * 2.0F) * (float)aqgz.hI();
  }
  
  private void A(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Medal_SPLASH_ConfigServlet", 2, "handleMedalConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      Object localObject = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("Medal_SPLASH_ConfigServlet", 2, "content" + (String)localObject);
      }
      if (localObject != null)
      {
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str2 = str5;
        String str1 = str4;
        paramConfig = str3;
        try
        {
          localObject = new JSONObject((String)localObject);
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str3 = ((JSONObject)localObject).optString("hosturl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str4 = ((JSONObject)localObject).optString("customurl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          str5 = ((JSONObject)localObject).optString("shareurl", "");
          str2 = str5;
          str1 = str4;
          paramConfig = str3;
          int i = ((JSONObject)localObject).optInt("entrance_visibility", 0);
          paramConfig = str3;
          str1 = str4;
          str2 = str5;
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              ((MedalWallMng)paramQQAppInterface.getManager(250)).j(i, paramConfig, str1, str2);
              aqmj.G(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin());
              aqmj.ab(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), i);
              return;
            }
            catch (Exception paramQQAppInterface)
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              QLog.e("SPLASH_ConfigServlet", 2, paramQQAppInterface, new Object[0]);
            }
            localException = localException;
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, localException.getMessage(), localException);
            }
            i = 0;
          }
        }
      }
    }
  }
  
  private void A(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int n = paramConfig.version.get();
    int i = aqmj.bf(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = aqmj.bg(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.getAppId();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, String.format("received TimUserSpecial remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      aqmj.aw(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
      i = 0;
    }
    Object localObject;
    int m;
    ConfigurationService.Config localConfig;
    String str;
    if (n != i)
    {
      localObject = a(paramConfig);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label431;
      }
      m = 0;
      j = 0;
      localConfig = null;
      paramConfig = null;
      str = null;
    }
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = new JSONObject((String)((List)localObject).get(0));
        if (!((JSONObject)localObject).has("TIMPersonality")) {
          break label475;
        }
        localObject = ((JSONObject)localObject).getJSONObject("TIMPersonality");
        if (!((JSONObject)localObject).has("aioTitleBgSwitch")) {
          break label470;
        }
        j = ((JSONObject)localObject).getInt("aioTitleBgSwitch");
        i = 1;
        if (((JSONObject)localObject).has("androidResourceURL")) {
          paramConfig = ((JSONObject)localObject).getString("androidResourceURL");
        }
        k = i;
        m = j;
        localConfig = paramConfig;
        if (((JSONObject)localObject).has("androidMD5"))
        {
          str = ((JSONObject)localObject).getString("androidMD5");
          localConfig = paramConfig;
          m = j;
          k = i;
        }
        if ((k != 0) && (!TextUtils.isEmpty(localConfig)) && (!TextUtils.isEmpty(str)))
        {
          paramConfig = yhv.a().k(localQQAppInterface);
          localObject = yhv.a().m(localQQAppInterface);
          bool = false;
          if ((!paramConfig.equals(localConfig)) || (!((String)localObject).equals(str))) {
            break label481;
          }
          yhv.a().b(0, m, localConfig, "", str, "", bool, 0);
          aqmj.b(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), n, 0, m, localConfig, str, "", "", bool, 0);
        }
        return;
      }
      catch (JSONException paramConfig)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 256 exception =" + paramConfig.toString());
        return;
      }
      label431:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 256,configStrList is empty ,version: " + paramConfig.version.get());
        return;
        label470:
        i = 0;
        continue;
        label475:
        k = 0;
        continue;
        label481:
        bool = true;
      }
    }
  }
  
  private void B(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    j = 0;
    int i = 0;
    k = 0;
    m = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int n = paramConfig.version.get();
    int i1 = aqmj.e(paramQQAppInterface.getApp(), mCurUin, 2);
    if (n != i1)
    {
      if (paramConfig.msg_content_list.size() <= 0) {
        break label391;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        break label266;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig content is null !");
      }
      i = 1;
      paramConfig = localObject2;
      j = i;
      k = m;
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject(paramConfig);
          if (!((JSONObject)localObject1).has("medal_strong_reminder_off")) {
            continue;
          }
          j = ((JSONObject)localObject1).getInt("medal_strong_reminder_off");
          k = j;
          j = i;
        }
        catch (Exception localException)
        {
          label266:
          localException.printStackTrace();
          j = 5;
          k = m;
          continue;
        }
        if (j == 0)
        {
          aqmj.h(paramQQAppInterface.getApp(), mCurUin, 3, k);
          if (paramQQAppInterface.iz(250)) {
            ((MedalWallMng)paramQQAppInterface.getManager(250)).Qy(k);
          }
        }
        aqmj.h(paramQQAppInterface.getApp(), mCurUin, 2, n);
        localObject1 = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handleMedalStrongReminderConfig localVersion: %s, version: %s, result: %s, value: %s, strContent: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), localObject1 }));
        }
        return;
        if (paramConfig.compress.get() != 1) {
          continue;
        }
        paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
        if (paramConfig != null) {
          try
          {
            paramConfig = new String(paramConfig, "UTF-8");
            i = 0;
          }
          catch (Throwable paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig Throwable:" + paramConfig.getMessage());
            }
            i = 2;
            paramConfig = null;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, " handleMedalStrongReminderConfig inflateConfigString error!");
      }
      i = 3;
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      break;
      label391:
      i = 4;
      paramConfig = localObject2;
      break;
      i = 6;
      j = 0;
    }
  }
  
  private void B(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i58 = paramConfig.version.get();
    int i = aqmj.am(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int j = aqmj.ai(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    int k = AppSetting.getAppId();
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("handlePokeMsgConfig.received PokeMsgConfig remote version: %d, localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i58), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (j != k)
    {
      aqmj.O(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k);
      i = 0;
    }
    Object localObject1;
    long l1;
    Object localObject9;
    int i16;
    int i15;
    int i14;
    int i13;
    Object localObject5;
    int i12;
    int i11;
    int i10;
    int i9;
    int i8;
    int i7;
    int i6;
    int i5;
    int i4;
    int i3;
    int i2;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    int i1;
    int n;
    int m;
    int i17;
    int i19;
    label1770:
    Object localObject8;
    if (i58 != i) {
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        localObject1 = paramConfig.content_list.get();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, String.format("handlePokeMsgConfig.receiveAllConfigs|size:%d,content:%s ", new Object[] { Integer.valueOf(paramConfig.content_list.size()), "test" }));
        }
        Iterator localIterator = ((List)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label7091;
        }
        Object localObject10 = (String)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handlePokeMsgConfig.receiveAllConfigs|type: 75,content: " + (String)localObject10 + ",version: " + paramConfig.version.get() + ",configSize = " + paramConfig.content_list.size());
        }
        l1 = -1L;
        localObject9 = "";
        Object localObject6 = "";
        i16 = -1;
        i15 = -1;
        i14 = -1;
        i13 = -1;
        localObject5 = null;
        i12 = 0;
        i11 = 0;
        i10 = 0;
        i9 = 0;
        i8 = 0;
        i7 = 0;
        i6 = 0;
        i5 = 0;
        i4 = 0;
        i3 = 0;
        i2 = 0;
        localObject4 = null;
        localObject3 = null;
        localObject2 = null;
        localObject1 = null;
        i1 = 0;
        n = 0;
        m = 50;
        k = 0;
        j = 0;
        i = 0;
        for (;;)
        {
          try
          {
            String[] arrayOfString = ((String)localObject10).split("\\|");
            if (arrayOfString == null) {
              continue;
            }
            int i59 = arrayOfString.length;
            int i38 = 0;
            m = 0;
            n = 0;
            i1 = 0;
            i2 = 50;
            i = 0;
            j = 0;
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localObject4 = null;
            i14 = 0;
            i15 = 0;
            k = 0;
            i18 = 0;
            i3 = 0;
            i17 = 0;
            i13 = 0;
            i12 = 0;
            i11 = 0;
            i6 = 0;
            i4 = 0;
            localObject10 = null;
            i16 = -1;
            i9 = -1;
            i8 = -1;
            i7 = -1;
            localObject9 = "";
            localObject5 = "";
            i33 = m;
            i34 = n;
            i20 = i1;
            i27 = i2;
            i21 = i;
            i22 = j;
            localObject6 = localObject1;
            localObject16 = localObject2;
            localObject12 = localObject3;
            localObject14 = localObject4;
            i37 = i14;
            i28 = i15;
            i24 = k;
            i35 = i18;
            i32 = i3;
            i30 = i17;
            i26 = i13;
            i23 = i12;
            i10 = i11;
            i36 = i6;
            i5 = i4;
            localObject15 = localObject10;
            i31 = i16;
            i29 = i9;
            i25 = i8;
            i19 = i7;
            localObject17 = localObject9;
            localObject13 = localObject5;
            l2 = l1;
            if (i38 >= i59) {
              continue;
            }
            str2 = arrayOfString[i38];
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject10;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l1;
            try
            {
              if (!str2.contains("aio_pe_view_type")) {
                continue;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject10;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              localObject6 = str2.split("=")[1].trim();
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject10;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              bool = TextUtils.isEmpty((CharSequence)localObject6);
              i39 = m;
              i40 = n;
              i41 = i1;
              i42 = i2;
              i36 = i;
              i37 = j;
              localObject19 = localObject1;
              localObject20 = localObject2;
              localObject21 = localObject3;
              localObject22 = localObject4;
              i43 = i14;
              i44 = i15;
              i45 = k;
              i46 = i18;
              i47 = i3;
              i48 = i17;
              i49 = i13;
              i50 = i12;
              i51 = i11;
              i52 = i6;
              i53 = i4;
              localObject23 = localObject10;
              i54 = i16;
              i55 = i9;
              i56 = i8;
              i57 = i7;
              localObject24 = localObject9;
              localObject25 = localObject5;
              l4 = l1;
              if (!bool) {}
              try
              {
                i40 = Integer.parseInt((String)localObject6);
                l4 = l1;
                localObject25 = localObject5;
                localObject24 = localObject9;
                i57 = i7;
                i56 = i8;
                i55 = i9;
                i54 = i16;
                localObject23 = localObject10;
                i53 = i4;
                i52 = i6;
                i51 = i11;
                i50 = i12;
                i49 = i13;
                i48 = i17;
                i47 = i3;
                i46 = i18;
                i45 = k;
                i44 = i15;
                i43 = i14;
                localObject22 = localObject4;
                localObject21 = localObject3;
                localObject20 = localObject2;
                localObject19 = localObject1;
                i37 = j;
                i36 = i;
                i42 = i2;
                i41 = i1;
                i39 = m;
              }
              catch (Exception localException1)
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject10;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l1;
                localException1.printStackTrace();
                i39 = m;
                i40 = n;
                i41 = i1;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject10;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l1;
                continue;
              }
              i38 += 1;
              m = i39;
              n = i40;
              i1 = i41;
              i2 = i42;
              i = i36;
              j = i37;
              localObject1 = localObject19;
              localObject2 = localObject20;
              localObject3 = localObject21;
              localObject4 = localObject22;
              i14 = i43;
              i15 = i44;
              k = i45;
              i18 = i46;
              i3 = i47;
              i17 = i48;
              i13 = i49;
              i12 = i50;
              i11 = i51;
              i6 = i52;
              i4 = i53;
              localObject10 = localObject23;
              i16 = i54;
              i9 = i55;
              i8 = i56;
              i7 = i57;
              localObject9 = localObject24;
              localObject5 = localObject25;
              l1 = l4;
            }
            catch (Exception localException4)
            {
              localObject9 = localObject18;
              localObject7 = localObject17;
              i16 = i35;
              i15 = i34;
              i14 = i20;
              i13 = i19;
              localObject5 = localObject16;
              i12 = i33;
              i11 = i32;
              i10 = i31;
              i9 = i30;
              i8 = i29;
              i7 = i28;
              i6 = i27;
              i5 = i26;
              i4 = i25;
              i3 = i24;
              localObject4 = localObject15;
              localObject3 = localObject14;
              localObject2 = localObject13;
              localObject1 = localObject12;
              i = i2;
              k = i1;
              j = n;
              i17 = m;
              l2 = l3;
              i2 = i23;
              i1 = i22;
              n = i21;
              m = i;
              i = i17;
            }
          }
          catch (Exception localException5)
          {
            int i18;
            int i33;
            int i34;
            int i20;
            int i27;
            int i21;
            int i22;
            Object localObject16;
            Object localObject12;
            Object localObject14;
            int i37;
            int i28;
            int i24;
            int i35;
            int i32;
            int i30;
            int i26;
            int i23;
            int i36;
            Object localObject15;
            int i31;
            int i29;
            int i25;
            Object localObject17;
            Object localObject13;
            String str2;
            Object localObject18;
            long l3;
            boolean bool;
            int i39;
            int i40;
            int i41;
            int i42;
            Object localObject19;
            Object localObject20;
            Object localObject21;
            Object localObject22;
            int i43;
            int i44;
            int i45;
            int i46;
            int i47;
            int i48;
            int i49;
            int i50;
            int i51;
            int i52;
            int i53;
            Object localObject23;
            int i54;
            int i55;
            int i56;
            int i57;
            Object localObject24;
            Object localObject25;
            long l4;
            Object localObject7;
            Object localObject11;
            long l2 = l1;
            continue;
            continue;
            continue;
            continue;
          }
          localException4.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("PokeMsg", 2, "PokeMsgConfig parse erro.fight " + localException4.getMessage());
          }
          i36 = i11;
          i17 = i12;
          i35 = i5;
          i12 = j;
          localObject11 = localObject2;
          j = n;
          i11 = i1;
          localObject13 = localObject9;
          localObject17 = localObject7;
          i19 = i16;
          i25 = i15;
          localObject2 = localObject5;
          i5 = i17;
          i23 = i9;
          i1 = i12;
          n = m;
          m = j;
          j = i11;
          localObject7 = localObject1;
          localObject1 = localObject11;
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PokeEmo", 2, String.format("PokeEmoConfig.got.the value is %s,%s,%s,%s", new Object[] { localObject4, localObject3, localObject1, localObject7 }));
            }
            localObject5 = xks.f(localQQAppInterface, 5);
            localObject9 = xks.f(localQQAppInterface, 6);
            if ((localObject4 == null) || (!((String)localObject4).equals(localObject5)) || (localObject3 == null) || (!((String)localObject3).equals(localObject9)))
            {
              xks.bhj = false;
              xks.bhk = false;
              aqmj.SM(false);
              xks.a(localQQAppInterface, (String)localObject4, (String)localObject3, xks.aVk);
            }
            aqmj.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, m, n, i1);
            xks.a(localQQAppInterface, k, (String)localObject4, (String)localObject3, (String)localObject1, (String)localObject7, j, n, i1);
            xks.Dh(m);
          }
          if ((i10 != 0) && (i23 != 0) && (i8 != 0) && (i7 != 0) && (i6 != 0))
          {
            localQQAppInterface.getApp().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("chat_tool_poke_clicked", false).commit();
            xks.o(localQQAppInterface, false);
            xks.n(localQQAppInterface, false);
            xks.D(i19, i25, i14, i13);
            aqmj.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, true, i19, i25, i14, i13);
            xks.xW((String)localObject2);
            aqmj.e(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, (String)localObject2);
            xks.Dg(i3);
            aqmj.e(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i3);
            xks.Di(i2);
            aqmj.f(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i2);
            xks.fJ(i35, i4);
            aqmj.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, i35, i4);
          }
          if ((i5 != 0) && (i36 != 0) && (i36 != 0))
          {
            localObject1 = PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).getString(localQQAppInterface.getAccount() + "_" + "aio_poke_res_url", "");
            aqmj.b(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i58, l2, (String)localObject13, (String)localObject17);
            if ((localObject13 != null) && (!((String)localObject13).equals(localObject1))) {
              ((PokeBigResHandler)localQQAppInterface.getBusinessHandler(117)).FO(true);
            }
          }
          xks.Di(i2);
          break;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i12;
          i31 = i11;
          i32 = i6;
          i33 = i4;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i8;
          i35 = i7;
          localObject17 = localObject9;
          localObject18 = localObject5;
          l3 = l1;
          if (str2.contains("aio_entry_type"))
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l1;
            localObject7 = str2.split("=")[1].trim();
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l1;
            bool = TextUtils.isEmpty((CharSequence)localObject7);
            i39 = m;
            i40 = n;
            i41 = i1;
            i42 = i2;
            i36 = i;
            i37 = j;
            localObject19 = localObject1;
            localObject20 = localObject2;
            localObject21 = localObject3;
            localObject22 = localObject4;
            i43 = i14;
            i44 = i15;
            i45 = k;
            i46 = i18;
            i47 = i3;
            i48 = i17;
            i49 = i13;
            i50 = i12;
            i51 = i11;
            i52 = i6;
            i53 = i4;
            localObject23 = localObject11;
            i54 = i16;
            i55 = i9;
            i56 = i8;
            i57 = i7;
            localObject24 = localObject9;
            localObject25 = localObject5;
            l4 = l1;
            if (!bool) {
              try
              {
                i41 = Integer.parseInt((String)localObject7);
                i39 = m;
                i40 = n;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject11;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l1;
              }
              catch (Exception localException2)
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l1;
                localException2.printStackTrace();
                i39 = m;
                i40 = n;
                i41 = i1;
                i42 = i2;
                i36 = i;
                i37 = j;
                localObject19 = localObject1;
                localObject20 = localObject2;
                localObject21 = localObject3;
                localObject22 = localObject4;
                i43 = i14;
                i44 = i15;
                i45 = k;
                i46 = i18;
                i47 = i3;
                i48 = i17;
                i49 = i13;
                i50 = i12;
                i51 = i11;
                i52 = i6;
                i53 = i4;
                localObject23 = localObject11;
                i54 = i16;
                i55 = i9;
                i56 = i8;
                i57 = i7;
                localObject24 = localObject9;
                localObject25 = localObject5;
                l4 = l1;
              }
            }
          }
          else
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i13;
            i30 = i12;
            i31 = i11;
            i32 = i6;
            i33 = i4;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i9;
            i34 = i8;
            i35 = i7;
            localObject17 = localObject9;
            localObject18 = localObject5;
            l3 = l1;
            bool = str2.contains("aio_panel_pe");
            if (bool)
            {
              i5 = i;
              i10 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              try
              {
                localObject16 = new JSONObject(str2.split("=")[1]);
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                str1 = ((JSONObject)localObject16).optString("pe_res_url");
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = str1;
                localObject4 = ((JSONObject)localObject16).optString("pe_res_md5");
                i5 = i;
                i10 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject4;
                localObject15 = str1;
                localObject2 = ((JSONObject)localObject16).optString("pe_surprise_indexes");
              }
              catch (Exception localException3)
              {
                try
                {
                  localObject3 = ((JSONObject)localObject16).optString("pe_orders");
                }
                catch (Exception localException9)
                {
                  String str1;
                  localObject3 = localObject8;
                  localObject8 = localException9;
                  continue;
                }
                try
                {
                  localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
                  localObject2 = localObject1;
                }
                catch (Exception localException10)
                {
                  localObject1 = localObject3;
                  localObject3 = localObject8;
                  localObject8 = localException10;
                  continue;
                }
                try
                {
                  localObject19 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
                  i5 = i;
                  i10 = j;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i37 = ((JSONObject)localObject16).optInt("aio_pe_input_switch");
                  i5 = i;
                  i10 = i37;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i36 = ((JSONObject)localObject16).optInt("aio_pe_feed_back_switch");
                  i5 = i36;
                  i10 = i37;
                  localObject12 = localObject19;
                  localObject13 = localObject2;
                  localObject14 = localObject4;
                  localObject15 = str1;
                  i42 = ((JSONObject)localObject16).optInt("aio_pe_bubble_limit_count");
                  i39 = 1;
                  i40 = n;
                  i41 = i1;
                  localObject20 = localObject2;
                  localObject21 = localObject4;
                  localObject22 = str1;
                  i43 = i14;
                  i44 = i15;
                  i45 = k;
                  i46 = i18;
                  i47 = i3;
                  i48 = i17;
                  i49 = i13;
                  i50 = i12;
                  i51 = i11;
                  i52 = i6;
                  i53 = i4;
                  localObject23 = localObject11;
                  i54 = i16;
                  i55 = i9;
                  i56 = i8;
                  i57 = i7;
                  localObject24 = localObject9;
                  localObject25 = localObject5;
                  l4 = l1;
                }
                catch (Exception localException11)
                {
                  localObject1 = localObject3;
                  localObject3 = localObject8;
                  localObject8 = localException11;
                  continue;
                  i3 = i19;
                  continue;
                  k = i17;
                  continue;
                  i14 = i16;
                  continue;
                }
                localException3 = localException3;
                localObject3 = localObject15;
                localObject4 = localObject14;
                localObject2 = localObject13;
                localObject1 = localObject12;
                j = i10;
                i = i5;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject4;
              localObject15 = localObject3;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              localException3.printStackTrace();
              i39 = m;
              i40 = n;
              i41 = i1;
              i42 = i2;
              i36 = i;
              i37 = j;
              localObject19 = localObject1;
              localObject20 = localObject2;
              localObject21 = localObject4;
              localObject22 = localObject3;
              i43 = i14;
              i44 = i15;
              i45 = k;
              i46 = i18;
              i47 = i3;
              i48 = i17;
              i49 = i13;
              i50 = i12;
              i51 = i11;
              i52 = i6;
              i53 = i4;
              localObject23 = localObject11;
              i54 = i16;
              i55 = i9;
              i56 = i8;
              i57 = i7;
              localObject24 = localObject9;
              localObject25 = localObject5;
              l4 = l1;
            }
            else
            {
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i4;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l1;
              i5 = i4;
              l2 = l1;
              if (str2.contains("aio_poke_strength_rule_interval"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i4;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l1;
                l2 = Long.valueOf(str2.split("=")[1].trim()).longValue();
                i5 = 1;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i6;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject5;
              l3 = l2;
              i4 = i6;
              localObject8 = localObject5;
              if (str2.contains("aio_poke_res_url"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i6;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject5;
                l3 = l2;
                localObject8 = str2.split("=")[1].trim();
                i4 = 1;
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i4;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject9;
              localObject18 = localObject8;
              l3 = l2;
              localObject5 = localObject9;
              if (str2.contains("aio_poke_res_md5"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i4;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject9;
                localObject18 = localObject8;
                l3 = l2;
                localObject5 = str2.split("=")[1].trim();
              }
              i21 = i;
              i22 = j;
              localObject12 = localObject1;
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              i23 = i14;
              i24 = i15;
              i25 = k;
              i26 = i18;
              i27 = i3;
              i28 = i17;
              i29 = i13;
              i30 = i12;
              i31 = i11;
              i32 = i4;
              i33 = i5;
              localObject16 = localObject11;
              i19 = i16;
              i20 = i9;
              i34 = i8;
              i35 = i7;
              localObject17 = localObject5;
              localObject18 = localObject8;
              l3 = l2;
              i6 = i11;
              i10 = i7;
              if (str2.contains("aio_bar_poke"))
              {
                i21 = i;
                i22 = j;
                localObject12 = localObject1;
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                i23 = i14;
                i24 = i15;
                i25 = k;
                i26 = i18;
                i27 = i3;
                i28 = i17;
                i29 = i13;
                i30 = i12;
                i31 = i11;
                i32 = i4;
                i33 = i5;
                localObject16 = localObject11;
                i19 = i16;
                i20 = i9;
                i34 = i8;
                i35 = i7;
                localObject17 = localObject5;
                localObject18 = localObject8;
                l3 = l2;
                i7 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
                i6 = i7;
                if (i7 == 0) {
                  break label7520;
                }
                i6 = i7;
                if (i7 == 1) {
                  break label7520;
                }
                i6 = i7;
                if (i7 == 2) {
                  break label7520;
                }
                i6 = i7;
                if (i7 == 3) {
                  break label7520;
                }
                if (i7 != 4) {
                  break label7560;
                }
                i6 = i7;
                break label7520;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        i21 = i;
        i22 = j;
        localObject12 = localObject1;
        localObject13 = localObject2;
        localObject14 = localObject3;
        localObject15 = localObject4;
        i23 = i14;
        i24 = i15;
        i25 = k;
        i26 = i18;
        i27 = i3;
        i28 = i17;
        i29 = i13;
        i30 = i12;
        i31 = i6;
        i32 = i4;
        i33 = i5;
        localObject16 = localObject11;
        i19 = i16;
        i20 = i9;
        i34 = i8;
        i35 = i10;
        localObject17 = localObject5;
        localObject18 = localObject8;
        l3 = l2;
        i7 = i12;
        i11 = i8;
        if (str2.contains("aio_pad_poke"))
        {
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i12;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i8;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          i8 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
          i7 = i8;
          if (i8 == 0) {
            break label7530;
          }
          i7 = i8;
          if (i8 == 1) {
            break label7530;
          }
          if (i8 != 2) {
            break label7566;
          }
          i7 = i8;
          break label7530;
        }
        i21 = i;
        i22 = j;
        localObject12 = localObject1;
        localObject13 = localObject2;
        localObject14 = localObject3;
        localObject15 = localObject4;
        i23 = i14;
        i24 = i15;
        i25 = k;
        i26 = i18;
        i27 = i3;
        i28 = i17;
        i29 = i13;
        i30 = i7;
        i31 = i6;
        i32 = i4;
        i33 = i5;
        localObject16 = localObject11;
        i19 = i16;
        i20 = i9;
        i34 = i11;
        i35 = i10;
        localObject17 = localObject5;
        localObject18 = localObject8;
        l3 = l2;
        i8 = i13;
        i12 = i9;
        if (str2.contains("aio_poke_unitcount"))
        {
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i13;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i9;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          i8 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
          if (i8 > 0) {
            break label7540;
          }
        }
        else
        {
          label5286:
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i17;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i16;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          i9 = i17;
          i13 = i16;
          if (str2.contains("aio_poke_unittime"))
          {
            i21 = i;
            i22 = j;
            localObject12 = localObject1;
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            i23 = i14;
            i24 = i15;
            i25 = k;
            i26 = i18;
            i27 = i3;
            i28 = i17;
            i29 = i8;
            i30 = i7;
            i31 = i6;
            i32 = i4;
            i33 = i5;
            localObject16 = localObject11;
            i19 = i16;
            i20 = i12;
            i34 = i11;
            i35 = i10;
            localObject17 = localObject5;
            localObject18 = localObject8;
            l3 = l2;
            i9 = Integer.valueOf(str2.split("=")[1].trim()).intValue();
            if (i9 <= 0) {
              break label6783;
            }
            break label7550;
          }
          label5530:
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i14;
          i44 = i15;
          i45 = k;
          i46 = i18;
          i47 = i3;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject11;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l2;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          if (!str2.contains("aio_panel")) {
            break;
          }
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          localObject19 = str2.split("=");
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject11;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          localObject9 = xks.hw(localObject19[1]);
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i14;
          i24 = i15;
          i25 = k;
          i26 = i18;
          i27 = i3;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          i16 = xks.bK(localObject19[1]);
        }
        try
        {
          i17 = xks.bJ(localObject19[1]);
        }
        catch (Exception localException6)
        {
          label6783:
          localObject12 = localObject8;
          label7091:
          localObject8 = localObject5;
          i17 = i10;
          i18 = i11;
          i19 = i12;
          localObject5 = localObject9;
          i12 = i5;
          i11 = i4;
          i10 = i6;
          i20 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i16;
          i3 = i15;
          i4 = j;
          i9 = i;
          j = n;
          i = m;
          i15 = k;
          k = i1;
          m = i2;
          n = i9;
          i1 = i4;
          i2 = i14;
          i4 = i15;
          i9 = i20;
          i14 = i19;
          i15 = i18;
          i16 = i17;
          localObject9 = localObject12;
        }
        try
        {
          i19 = xks.bI(localObject19[1]);
          if ((i16 == 1) || (i16 == 2)) {
            break label7513;
          }
          i14 = 0;
          i15 = k;
          if (i14 == 0) {}
        }
        catch (Exception localException7)
        {
          i19 = k;
          localObject12 = localObject8;
          i20 = i17;
          localObject8 = localObject5;
          i17 = i10;
          i15 = i11;
          i18 = i12;
          localObject5 = localObject9;
          i12 = i5;
          i11 = i4;
          i10 = i6;
          i21 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i16;
          i3 = j;
          i4 = i;
          k = i1;
          j = n;
          i = m;
          m = i2;
          n = i4;
          i1 = i3;
          i2 = i14;
          i3 = i20;
          i4 = i19;
          i9 = i21;
          i14 = i18;
          i16 = i17;
          localObject9 = localObject12;
        }
        try
        {
          i15 = xks.bL(localObject19[1]);
          k = i15;
          if (k > 0)
          {
            i15 = k;
            if (k <= 6) {}
          }
          else
          {
            i15 = 1;
          }
          if (i17 == 1) {
            break label7506;
          }
          k = 0;
          if (i19 > 0) {
            break label7499;
          }
          i3 = 3;
          i17 = 1;
          i16 = 1;
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i3;
          i44 = k;
          i45 = i15;
          i46 = i14;
          i47 = i16;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject9;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l2;
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i3;
          i24 = k;
          i25 = i15;
          i26 = i14;
          i27 = i17;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          if (!QLog.isColorLevel()) {
            break;
          }
          i21 = i;
          i22 = j;
          localObject12 = localObject1;
          localObject13 = localObject2;
          localObject14 = localObject3;
          localObject15 = localObject4;
          i23 = i3;
          i24 = k;
          i25 = i15;
          i26 = i14;
          i27 = i17;
          i28 = i9;
          i29 = i8;
          i30 = i7;
          i31 = i6;
          i32 = i4;
          i33 = i5;
          localObject16 = localObject9;
          i19 = i13;
          i20 = i12;
          i34 = i11;
          i35 = i10;
          localObject17 = localObject5;
          localObject18 = localObject8;
          l3 = l2;
          QLog.d("pokeMsg", 2, "[parsed value] pokePanelInfo:" + (String)localObject9 + " showUniquePokeFlag:" + i14 + " showUniquePokeType:" + i15 + " touchEffect:" + k + " comboNum:" + i3);
          i39 = m;
          i40 = n;
          i41 = i1;
          i42 = i2;
          i36 = i;
          i37 = j;
          localObject19 = localObject1;
          localObject20 = localObject2;
          localObject21 = localObject3;
          localObject22 = localObject4;
          i43 = i3;
          i44 = k;
          i45 = i15;
          i46 = i14;
          i47 = i16;
          i48 = i9;
          i49 = i8;
          i50 = i7;
          i51 = i6;
          i52 = i4;
          i53 = i5;
          localObject23 = localObject9;
          i54 = i13;
          i55 = i12;
          i56 = i11;
          i57 = i10;
          localObject24 = localObject5;
          localObject25 = localObject8;
          l4 = l2;
        }
        catch (Exception localException8)
        {
          localObject12 = localObject8;
          localObject8 = localObject5;
          i16 = i10;
          i15 = i11;
          i18 = i12;
          localObject5 = localObject9;
          i12 = i5;
          i11 = i4;
          i10 = i6;
          i20 = i7;
          i7 = i9;
          i6 = i3;
          i5 = i14;
          i4 = k;
          i3 = i17;
          i9 = j;
          i14 = i;
          k = i1;
          j = n;
          i = m;
          m = i2;
          n = i14;
          i1 = i9;
          i2 = i19;
          i9 = i20;
          i14 = i18;
          localObject9 = localObject12;
        }
      }
      i21 = i;
      i22 = j;
      localObject12 = localObject1;
      localObject13 = localObject2;
      localObject14 = localObject3;
      localObject15 = localObject4;
      i23 = i14;
      i24 = i15;
      i25 = k;
      i26 = i18;
      i27 = i3;
      i28 = i17;
      i29 = i13;
      i30 = i7;
      i31 = i6;
      i32 = i4;
      i33 = i5;
      localObject16 = localObject11;
      i19 = i16;
      i20 = i8;
      i34 = i11;
      i35 = i10;
      localObject17 = localObject5;
      localObject18 = localObject8;
      l3 = l2;
      i8 = xks.bTQ;
      break label7540;
      i21 = i;
      i22 = j;
      localObject12 = localObject1;
      localObject13 = localObject2;
      localObject14 = localObject3;
      localObject15 = localObject4;
      i23 = i14;
      i24 = i15;
      i25 = k;
      i26 = i18;
      i27 = i3;
      i28 = i17;
      i29 = i8;
      i30 = i7;
      i31 = i6;
      i32 = i4;
      i33 = i5;
      localObject16 = localObject11;
      i19 = i9;
      i20 = i12;
      i34 = i11;
      i35 = i10;
      localObject17 = localObject5;
      localObject18 = localObject8;
      l3 = l2;
      i9 = xks.bTR;
      break label7550;
      i33 = 0;
      i34 = 0;
      i20 = 0;
      i27 = 50;
      i21 = 0;
      i22 = 0;
      localObject8 = null;
      localObject16 = null;
      localObject12 = null;
      localObject14 = null;
      i37 = 0;
      i28 = 0;
      i24 = 0;
      i35 = 0;
      i32 = 0;
      i30 = 0;
      i26 = 0;
      i23 = 0;
      i10 = 0;
      i36 = 0;
      i5 = 0;
      localObject15 = null;
      i31 = -1;
      i29 = -1;
      i25 = -1;
      i19 = -1;
      localObject17 = "";
      localObject13 = "";
      l2 = l1;
      i2 = i37;
      localObject2 = localObject15;
      i3 = i28;
      i4 = i24;
      i1 = i34;
      i = i33;
      localObject4 = localObject14;
      n = i27;
      localObject1 = localObject16;
      j = i22;
      m = i21;
      localObject3 = localObject12;
      k = i20;
      i6 = i32;
      i7 = i30;
      i8 = i26;
      i13 = i31;
      i14 = i29;
      break label1770;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 75,content_list is empty ,version: " + paramConfig.version.get());
      }
      return;
      label7499:
      label7506:
      label7513:
      label7520:
      i10 = i6;
      i6 = 1;
    }
    for (;;)
    {
      label7530:
      i11 = i7;
      i7 = 1;
      break;
      label7540:
      i12 = i8;
      i8 = 1;
      break label5286;
      label7550:
      i13 = i9;
      i9 = 1;
      break label5530;
      label7560:
      i6 = 0;
      break label7520;
      label7566:
      i7 = 0;
    }
  }
  
  private void C(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int j = 0;
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        int k = paramConfig.version.get();
        int m = ((Integer)aqmj.a(paramQQAppInterface.getApp(), mCurUin, 2)).intValue();
        if (k != m)
        {
          if (paramConfig.msg_content_list.size() <= 0) {
            continue;
          }
          paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          if (paramConfig == null)
          {
            if (!QLog.isColorLevel()) {
              break label336;
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig content is null !");
            break label336;
            if (i == 0)
            {
              aqmj.a(paramQQAppInterface.getApp(), mCurUin, 3, localObject1);
              if (paramQQAppInterface.iz(159)) {
                ((achg)paramQQAppInterface.getManager(159)).Ec((String)localObject1);
              }
            }
            aqmj.a(paramQQAppInterface.getApp(), mCurUin, 2, Integer.valueOf(k));
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label355;
          }
          QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "handlePushRecommendShieldConfig localVersion: %s, version: %s, result: %s, strContent: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), localObject1 }));
          return;
        }
        if (paramConfig.compress.get() == 1)
        {
          paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
          if (paramConfig != null)
          {
            try
            {
              paramConfig = new String(paramConfig, "UTF-8");
              i = 0;
            }
            catch (Throwable paramConfig)
            {
              if (!QLog.isColorLevel()) {
                break label356;
              }
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig Throwable:" + paramConfig.getMessage());
            break label356;
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label363;
            }
            QLog.d("SPLASH_ConfigServlet", 2, " handlePushRecommendShieldConfig inflateConfigString error!");
            break label363;
          }
        }
        else
        {
          paramConfig = paramConfig.content.get().toStringUtf8();
          i = j;
          break label341;
          i = 4;
          paramConfig = localObject2;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      label336:
      i = 1;
      paramConfig = localObject2;
      label341:
      localObject1 = paramConfig;
      if (paramConfig == null)
      {
        localObject1 = "";
        continue;
        label355:
        return;
        label356:
        paramConfig = null;
        i = 2;
        continue;
        label363:
        paramConfig = null;
        i = 3;
      }
    }
  }
  
  private void C(ConfigurationService.Config paramConfig)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        localQQAppInterface = (QQAppInterface)getAppRuntime();
        i = paramConfig.version.get();
        j = aqmj.ay(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("longText", 2, "received LongTextMsgConfig configVersion:" + i + " ,localVersion:" + j);
        }
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          paramConfig = (String)paramConfig.content_list.get(0);
          if (QLog.isColorLevel()) {
            QLog.d("longText", 2, "received LongTextMsgConfig configContent" + paramConfig);
          }
          if (i == j) {
            break label454;
          }
        }
      }
      catch (Exception paramConfig)
      {
        QQAppInterface localQQAppInterface;
        int i;
        int j;
        int k;
        boolean bool3;
        boolean bool4;
        if (QLog.isColorLevel())
        {
          QLog.e("SPLASH_ConfigServlet", 2, "received LongTextMsgConfig error", paramConfig);
          return;
          if (i == j)
          {
            if (QLog.isColorLevel()) {
              QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, ignored because of SAME VERSION");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("longText", 2, "received LongTextMsgConfig, content_list is empty, use default config");
            return;
            bool1 = false;
            continue;
            bool2 = true;
            bool1 = false;
            continue;
          }
        }
      }
      try
      {
        if (TextUtils.isEmpty(paramConfig)) {
          continue;
        }
        paramConfig = new JSONObject(paramConfig);
        if (paramConfig == null) {
          continue;
        }
        j = Integer.parseInt(paramConfig.optString("largeMsgOp"));
        if (j != 1) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramConfig)
      {
        bool1 = false;
        continue;
      }
      try
      {
        k = Integer.parseInt(paramConfig.optString("msfPullFilter"));
        if (k != 0) {
          continue;
        }
        bool2 = false;
      }
      catch (Exception paramConfig)
      {
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("longText", 2, "received LongTextMsgConfig, parse content ltValue:" + j + ",ltSwitch:" + bool1 + ",mpfValue:" + k + ",mpfSwitch:" + bool2);
        }
        bool3 = bool1;
        bool4 = bool2;
        paramConfig = (ajkw)localQQAppInterface.getManager(166);
        paramConfig.cpe = true;
        paramConfig.cpf = bool3;
        localQQAppInterface.bIW = true;
        localQQAppInterface.bIX = bool4;
        aqmj.e(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, bool3, bool4);
        return;
      }
      catch (Exception paramConfig)
      {
        continue;
      }
      bool4 = bool2;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("longText", 2, "received LongTextMsgConfig, parse content error!", paramConfig);
        bool4 = bool2;
        bool3 = bool1;
      }
    }
    label454:
  }
  
  private void D(ConfigurationService.Config paramConfig)
  {
    QLog.i("NCtr", 1, "[handleLimitNotifyConfig]");
    Object localObject = (QQAppInterface)getAppRuntime();
    int j = paramConfig.version.get();
    int k = AppSetting.getAppId();
    aury localaury = (aury)((QQAppInterface)localObject).getBusinessHandler(146);
    int i = localaury.k(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount());
    if (localaury.bM(BaseApplicationImpl.getContext(), ((QQAppInterface)localObject).getAccount()) != k) {
      i = 0;
    }
    for (;;)
    {
      if (j != i)
      {
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label215;
        }
        localObject = paramConfig.msg_content_list.get().iterator();
        if (((Iterator)localObject).hasNext())
        {
          paramConfig = (ConfigurationService.Content)((Iterator)localObject).next();
          if (paramConfig.compress.get() != 1) {
            break label201;
          }
          paramConfig = localaury.v(paramConfig.content.get().toByteArray());
          if (paramConfig == null) {
            break label234;
          }
          paramConfig = new String(paramConfig);
        }
      }
      for (;;)
      {
        try
        {
          localaury.aV(paramConfig, j, k);
        }
        catch (Exception paramConfig)
        {
          QLog.e("NCtr", 1, "[handleLimitNotifyConfig] parse fail", paramConfig);
        }
        return;
        label201:
        paramConfig = paramConfig.content.get().toStringUtf8();
        continue;
        label215:
        QLog.i("NCtr", 1, "[hangleLimitNotifyConfig] config has no data");
        localaury.pf(mCurUin);
        return;
        label234:
        paramConfig = null;
      }
    }
  }
  
  private void E(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject4;
    if (paramConfig.msg_content_list != null)
    {
      localObject1 = localObject3;
      if (paramConfig.msg_content_list.size() > 0)
      {
        localObject4 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          if (((ConfigurationService.Content)localObject4).compress.get() != 1) {
            break label460;
          }
          localObject3 = akrf.inflateConfigString(((ConfigurationService.Content)localObject4).content.get().toByteArray());
          if (localObject3 == null) {
            break label521;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new String((byte[])localObject3, "UTF-8");
        localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4).edit();
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "SVDNAdjustment config : " + (String)localObject1);
            }
            localObject4 = new JSONObject((String)localObject1).getJSONObject("SVDNAdjustment").getJSONArray("configs").getJSONObject(0).getJSONObject("config");
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_data_type", (float)((JSONObject)localObject4).optDouble("data_type", 0.5D));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_max_downmark", ((JSONObject)localObject4).optInt("max_downmark", 2));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_max_upmark", ((JSONObject)localObject4).optInt("max_upmark", 2));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_up_threshold_base", ((JSONObject)localObject4).optInt("up_threshold_base", 11));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_down_threshold_base", ((JSONObject)localObject4).optInt("down_threshold_base", 25));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_quality_up_threshold", ((JSONObject)localObject4).optInt("up_threshold_base", 11));
            ((SharedPreferences.Editor)localObject3).putInt("SVDNAdjustment_quality_down_threshold", ((JSONObject)localObject4).optInt("down_threshold_base", 25));
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_up_threshold_coefficient", (float)((JSONObject)localObject4).optDouble("up_threshold_coefficient", 0.7D));
            ((SharedPreferences.Editor)localObject3).putFloat("SVDNAdjustment_down_threshold_coefficient", (float)((JSONObject)localObject4).optDouble("down_threshold_coefficient", 1.3D));
            ((SharedPreferences.Editor)localObject3).commit();
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          String str1;
          if (!QLog.isColorLevel()) {
            break label513;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "error: " + localException.toString());
          localException.printStackTrace();
          continue;
        }
        aasr.a();
        aasr.AP((String)localObject1);
        aqmj.F(paramQQAppInterface.getApp(), paramConfig.version.get(), mCurUin);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (QLog.isColorLevel()) {
          localUnsupportedEncodingException.printStackTrace();
        }
        localObject2 = null;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          localOutOfMemoryError.printStackTrace();
        }
        System.gc();
        try
        {
          str1 = new String((byte[])localObject3, "UTF-8");
        }
        catch (Throwable localThrowable)
        {
          str2 = null;
        }
        continue;
      }
      label460:
      String str2 = ((ConfigurationService.Content)localObject4).content.get().toStringUtf8();
      continue;
      label513:
      label521:
      str2 = null;
    }
  }
  
  /* Error */
  private void E(ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 140	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 8
    //   9: aload_1
    //   10: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   16: istore_3
    //   17: aload 8
    //   19: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: aload 8
    //   24: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   27: invokestatic 862	aqmj:bD	(Landroid/content/Context;Ljava/lang/String;)I
    //   30: istore_2
    //   31: aload 8
    //   33: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: aload 8
    //   38: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   41: invokestatic 865	aqmj:bE	(Landroid/content/Context;Ljava/lang/String;)I
    //   44: istore 4
    //   46: invokestatic 204	com/tencent/common/config/AppSetting:getAppId	()I
    //   49: istore 5
    //   51: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +50 -> 104
    //   57: ldc_w 867
    //   60: iconst_2
    //   61: ldc_w 869
    //   64: iconst_4
    //   65: anewarray 178	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_3
    //   71: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: iload_2
    //   78: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload 4
    //   86: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: iload 5
    //   94: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iload 4
    //   106: iload 5
    //   108: if_icmpeq +20 -> 128
    //   111: aload 8
    //   113: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   116: iload 5
    //   118: aload 8
    //   120: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   123: invokestatic 872	aqmj:L	(Landroid/content/Context;ILjava/lang/String;)V
    //   126: iconst_0
    //   127: istore_2
    //   128: iload_3
    //   129: iload_2
    //   130: if_icmpeq +66 -> 196
    //   133: aload_1
    //   134: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   137: ifnull +275 -> 412
    //   140: aload_1
    //   141: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   144: invokevirtual 874	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   147: ifne +265 -> 412
    //   150: aload_1
    //   151: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iconst_0
    //   155: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: astore 7
    //   163: aload 7
    //   165: getfield 334	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   168: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   171: iconst_1
    //   172: if_icmpne +207 -> 379
    //   175: aload 7
    //   177: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   180: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   183: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   186: invokestatic 357	akrf:inflateConfigString	([B)[B
    //   189: astore 7
    //   191: aload 7
    //   193: ifnonnull +4 -> 197
    //   196: return
    //   197: new 115	java/lang/String
    //   200: dup
    //   201: aload 7
    //   203: ldc_w 359
    //   206: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   209: astore 7
    //   211: new 119	org/json/JSONObject
    //   214: dup
    //   215: aload 7
    //   217: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   220: ldc_w 876
    //   223: invokevirtual 879	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   226: istore 6
    //   228: aload 8
    //   230: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   233: ldc_w 881
    //   236: iconst_4
    //   237: invokevirtual 480	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   240: invokeinterface 486 1 0
    //   245: ldc_w 883
    //   248: iload 6
    //   250: invokeinterface 494 3 0
    //   255: invokeinterface 886 1 0
    //   260: aload 8
    //   262: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   265: aload_1
    //   266: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   269: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   272: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   275: invokestatic 889	aqmj:K	(Landroid/content/Context;ILjava/lang/String;)V
    //   278: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +30 -> 311
    //   284: ldc 169
    //   286: iconst_2
    //   287: new 68	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 891
    //   297: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: iload 6
    //   302: invokevirtual 692	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   305: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq -118 -> 196
    //   317: ldc 169
    //   319: iconst_2
    //   320: new 68	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 893
    //   330: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 7
    //   335: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 895
    //   341: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_1
    //   345: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   348: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   351: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: return
    //   361: astore_1
    //   362: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq -169 -> 196
    //   368: ldc 169
    //   370: iconst_2
    //   371: aload_1
    //   372: invokestatic 899	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   375: invokestatic 902	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: aload 7
    //   381: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   384: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   387: invokevirtual 370	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   390: astore 7
    //   392: goto -181 -> 211
    //   395: astore 8
    //   397: ldc 169
    //   399: iconst_1
    //   400: aload 8
    //   402: iconst_0
    //   403: anewarray 178	java/lang/Object
    //   406: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   409: goto -98 -> 311
    //   412: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +35 -> 450
    //   418: ldc 169
    //   420: iconst_2
    //   421: new 68	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 906
    //   431: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   438: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   441: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload 8
    //   452: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   455: ldc_w 881
    //   458: iconst_4
    //   459: invokevirtual 480	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   462: invokeinterface 486 1 0
    //   467: astore_1
    //   468: aload_1
    //   469: ldc_w 881
    //   472: invokeinterface 910 2 0
    //   477: pop
    //   478: aload_1
    //   479: invokeinterface 886 1 0
    //   484: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	aevk
    //   0	485	1	paramConfig	ConfigurationService.Config
    //   30	101	2	i	int
    //   16	115	3	j	int
    //   44	65	4	k	int
    //   49	68	5	m	int
    //   226	75	6	bool	boolean
    //   161	230	7	localObject	Object
    //   7	254	8	localQQAppInterface	QQAppInterface
    //   395	56	8	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   197	211	361	java/lang/Throwable
    //   211	311	395	org/json/JSONException
  }
  
  private static int G(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
    try
    {
      long l = (localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime()) / 86400000L;
      return (int)l;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  public static String G(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append('-').append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static void Hx(String paramString) {}
  
  private void P(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
    int j = paramConfig.version.get();
    QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend, localVersion:" + i + ",serverVersion:" + j);
    if (i != j)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label230;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig == null) {
        break label220;
      }
      if (paramConfig.compress.get() != 1) {
        break label196;
      }
      paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label240;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break label210;
        }
        ((ackn)paramQQAppInterface.getManager(22)).dG(paramConfig, j);
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.e("Q.lebanew", 1, "handleNewTroopRecommend uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      label196:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label210:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend config_content is empty!");
      return;
      label220:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend content is empty!");
      return;
      label230:
      QLog.w("SPLASH_ConfigServlet", 1, "handleNewTroopRecommend msg_content_list is empty!");
      return;
      label240:
      paramConfig = null;
    }
  }
  
  public static void U(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool = false;
    int k = paramConfig.version.get();
    int j = aqmj.ba(paramQQAppInterface.getApp().getBaseContext(), mCurUin);
    if (paramConfig.msg_content_list != null) {}
    for (int i = paramConfig.msg_content_list.size();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, String.format("scribble回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      }
      if (k != j) {
        break;
      }
      return;
    }
    Object localObject1;
    byte[] arrayOfByte;
    if (i > 0)
    {
      j = 0;
      if (j < i)
      {
        localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(j);
        if (localObject1 == null) {
          break label336;
        }
        if (((ConfigurationService.Content)localObject1).compress.get() == 1)
        {
          arrayOfByte = akrf.inflateConfigString(((ConfigurationService.Content)localObject1).content.get().toByteArray());
          if (arrayOfByte == null)
          {
            QLog.e("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, "解压错误");
            localObject1 = null;
            label173:
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label336;
            }
            bool = ScribbleResMgr.b((String)localObject1, paramQQAppInterface.getApp().getBaseContext(), mCurUin);
          }
        }
      }
    }
    label336:
    for (;;)
    {
      for (;;)
      {
        j += 1;
        break;
        try
        {
          localObject1 = new String(arrayOfByte, "UTF-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          if (QLog.isColorLevel()) {
            localUnsupportedEncodingException.printStackTrace();
          }
          Object localObject2 = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              localOutOfMemoryError.printStackTrace();
            }
            System.gc();
            try
            {
              String str1 = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable localThrowable)
            {
              str2 = null;
            }
          }
        }
      }
      break label173;
      String str2 = str2.content.get().toStringUtf8();
      break label173;
      if (!bool) {
        break;
      }
      aqmj.H(paramQQAppInterface.getApp().getBaseContext(), k, mCurUin);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("handleScribbleRedSwitchConfigSPLASH_ConfigServlet", 2, "回包为空");
      return;
    }
  }
  
  public static void W(QQAppInterface paramQQAppInterface, String paramString)
  {
    mCurUin = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aevk.class);
    int[] arrayOfInt = new int[df.length + aeif.kR.length];
    System.arraycopy(df, 0, arrayOfInt, 0, df.length);
    System.arraycopy(aeif.kR, 0, arrayOfInt, df.length, aeif.kR.length);
    localNewIntent.putExtra("k_cmd_type", arrayOfInt);
    localNewIntent.putExtra("key_uin", paramString);
    localNewIntent.putExtra("k_req_occasion", 0);
    localNewIntent.putExtra("key_is_all_config", true);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void X(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = true;
    aklr localaklr = (aklr)paramQQAppInterface.getManager(228);
    int i = localaklr.lA();
    int j = paramConfig.version.get();
    QLog.d("SPLASH_ConfigServlet", 1, "handleGetOCRConfig, version:" + j + ",localVersion:" + i);
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        paramQQAppInterface = localObject2;
        if (paramConfig == null) {
          break label343;
        }
        if (paramConfig.compress.get() == 1)
        {
          paramQQAppInterface = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
          if (paramQQAppInterface == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
        paramConfig = OcrConfig.parse(paramQQAppInterface);
        paramQQAppInterface = paramConfig;
        if (paramConfig == null) {
          break label343;
        }
        paramConfig.version = j;
        bool1 = true;
        paramQQAppInterface = paramConfig;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, isSucc = " + bool1 + ", ocrConfig = " + paramQQAppInterface);
        }
        localaklr.a(bool1, paramQQAppInterface);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "Throwable:" + paramQQAppInterface.getMessage());
        }
        paramQQAppInterface = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
      }
      paramQQAppInterface = null;
      continue;
      paramQQAppInterface = paramConfig.content.get().toStringUtf8();
      continue;
      OcrConfig.deleteLocalConfig(mCurUin);
      paramQQAppInterface = localObject1;
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleGetOCRConfig, msg_content_list is null");
        paramQQAppInterface = localObject1;
        bool1 = bool2;
        continue;
        label343:
        bool1 = false;
        continue;
        bool1 = false;
        paramQQAppInterface = localObject1;
      }
    }
  }
  
  public static void X(QQAppInterface paramQQAppInterface, String paramString)
  {
    mCurUin = paramString;
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aevk.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { 34 });
    localNewIntent.putExtra("key_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void Y(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.bc(BaseApplication.getContext(), mCurUin);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      aqmj.au(BaseApplication.getContext(), mCurUin, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        while (paramConfig.hasNext())
        {
          localObject = (String)paramConfig.next();
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("kReceiptMsgEnable"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgEnable");
              aqmj.k(BaseApplication.getContext(), mCurUin, "receipt_kReceiptMsgEnable", i);
            }
            if (((JSONObject)localObject).has("kReceiptMsgMaxSendTimes"))
            {
              i = ((JSONObject)localObject).getInt("kReceiptMsgMaxSendTimes");
              aqmj.k(BaseApplication.getContext(), mCurUin, "receipt_kReceiptMsgSendTimes", i);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        wiq.aQ(paramQQAppInterface);
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  public static void Y(QQAppInterface paramQQAppInterface, String paramString)
  {
    mCurUin = paramString;
    v(paramQQAppInterface, 62);
  }
  
  public static void Z(QQAppInterface paramQQAppInterface, String paramString)
  {
    QLog.d("SPLASH_ConfigServlet", 1, " call  getServiceAccountFolderConfig ");
    mCurUin = paramString;
    v(paramQQAppInterface, 81);
  }
  
  private int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString)
  {
    ShortVideoResourceManager localShortVideoResourceManager = paramQQAppInterface.a();
    if ((localShortVideoResourceManager == null) && ("ConfigurationService.ReqGetConfigNoLogin".equals(paramString))) {
      localShortVideoResourceManager = new ShortVideoResourceManager(paramQQAppInterface);
    }
    for (int j = 1;; j = 0)
    {
      int i = ShortVideoResourceManager.Jk();
      int k = paramConfig.version.get();
      QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|received remote version: " + k + " | localVersion: " + i);
      if (k != i) {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
          if (paramConfig != null) {
            if (paramConfig.compress.get() == 1)
            {
              paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
              if (paramConfig == null) {}
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|config_content " + paramConfig);
          if (!"ConfigurationService.ReqGetConfigNoLogin".equals(paramString)) {
            break label300;
          }
          i = localShortVideoResourceManager.am(paramConfig, k);
          if (j != 0) {
            localShortVideoResourceManager.dPq();
          }
          return i;
        }
        catch (Throwable paramConfig)
        {
          QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|Throwable:" + paramConfig.getMessage());
          paramConfig = "";
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 1, "receiveAllConfigs[handleShortVideoResourceConfig]|inflateConfigString error!");
        paramConfig = "";
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
        continue;
        label300:
        i = localShortVideoResourceManager.d(paramQQAppInterface.getApp(), paramConfig, k);
        continue;
        QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| content==null");
        i = -125;
        continue;
        QLog.d("ShortVideoResourceManager", 1, "receiveAllConfigs[handleShortVideoResourceConfig]| msg_content_list is empty ,version: " + k + ",localVersion:" + i);
        i = -125;
        continue;
        i = 0;
      }
    }
  }
  
  private QQOperationViopTipTask a(String paramString)
  {
    return a(paramString, new QQOperationViopTipTask());
  }
  
  /* Error */
  private QQOperationViopTipTask a(String paramString, QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 1168	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   5: invokevirtual 1172	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   8: new 1174	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_1
    //   13: ldc_w 1176
    //   16: invokevirtual 1180	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   19: invokespecial 1181	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokevirtual 1186	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   25: astore_1
    //   26: aload_1
    //   27: ldc_w 1188
    //   30: invokeinterface 1194 2 0
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +1254 -> 1293
    //   42: aload 4
    //   44: invokeinterface 1199 1 0
    //   49: ifle +1244 -> 1293
    //   52: aload_1
    //   53: ldc_w 1201
    //   56: invokeinterface 1194 2 0
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +45 -> 110
    //   68: aload 4
    //   70: invokeinterface 1199 1 0
    //   75: ifle +35 -> 110
    //   78: aload_2
    //   79: aload_1
    //   80: ldc_w 1201
    //   83: invokeinterface 1194 2 0
    //   88: iconst_0
    //   89: invokeinterface 1205 2 0
    //   94: invokeinterface 1211 1 0
    //   99: invokeinterface 1214 1 0
    //   104: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: putfield 1217	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   110: aload_1
    //   111: ldc_w 1219
    //   114: invokeinterface 1194 2 0
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +45 -> 168
    //   126: aload 4
    //   128: invokeinterface 1199 1 0
    //   133: ifle +35 -> 168
    //   136: aload_2
    //   137: aload_1
    //   138: ldc_w 1219
    //   141: invokeinterface 1194 2 0
    //   146: iconst_0
    //   147: invokeinterface 1205 2 0
    //   152: invokeinterface 1211 1 0
    //   157: invokeinterface 1214 1 0
    //   162: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: putfield 1222	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOCount	I
    //   168: aload_1
    //   169: ldc_w 1224
    //   172: invokeinterface 1194 2 0
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +45 -> 226
    //   184: aload 4
    //   186: invokeinterface 1199 1 0
    //   191: ifle +35 -> 226
    //   194: aload_2
    //   195: aload_1
    //   196: ldc_w 1224
    //   199: invokeinterface 1194 2 0
    //   204: iconst_0
    //   205: invokeinterface 1205 2 0
    //   210: invokeinterface 1211 1 0
    //   215: invokeinterface 1214 1 0
    //   220: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: putfield 1227	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitDayAIOShowCount	I
    //   226: aload_1
    //   227: ldc_w 1229
    //   230: invokeinterface 1194 2 0
    //   235: astore 4
    //   237: aload 4
    //   239: ifnull +45 -> 284
    //   242: aload 4
    //   244: invokeinterface 1199 1 0
    //   249: ifle +35 -> 284
    //   252: aload_2
    //   253: aload_1
    //   254: ldc_w 1229
    //   257: invokeinterface 1194 2 0
    //   262: iconst_0
    //   263: invokeinterface 1205 2 0
    //   268: invokeinterface 1211 1 0
    //   273: invokeinterface 1214 1 0
    //   278: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   281: putfield 1232	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalAIOCount	I
    //   284: aload_1
    //   285: ldc_w 1234
    //   288: invokeinterface 1194 2 0
    //   293: astore 4
    //   295: aload 4
    //   297: ifnull +45 -> 342
    //   300: aload 4
    //   302: invokeinterface 1199 1 0
    //   307: ifle +35 -> 342
    //   310: aload_2
    //   311: aload_1
    //   312: ldc_w 1234
    //   315: invokeinterface 1194 2 0
    //   320: iconst_0
    //   321: invokeinterface 1205 2 0
    //   326: invokeinterface 1211 1 0
    //   331: invokeinterface 1214 1 0
    //   336: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   339: putfield 1237	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:limitTotalShowCount	I
    //   342: aload_1
    //   343: ldc_w 1239
    //   346: invokeinterface 1194 2 0
    //   351: astore 4
    //   353: aload 4
    //   355: ifnull +42 -> 397
    //   358: aload 4
    //   360: invokeinterface 1199 1 0
    //   365: ifle +32 -> 397
    //   368: aload_2
    //   369: aload_1
    //   370: ldc_w 1239
    //   373: invokeinterface 1194 2 0
    //   378: iconst_0
    //   379: invokeinterface 1205 2 0
    //   384: invokeinterface 1211 1 0
    //   389: invokeinterface 1214 1 0
    //   394: invokevirtual 1242	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setKeywordString	(Ljava/lang/String;)V
    //   397: invokestatic 1245	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   400: ifeq +33 -> 433
    //   403: ldc_w 1247
    //   406: iconst_4
    //   407: new 68	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 1249
    //   417: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_2
    //   421: invokevirtual 1253	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:getKeywordList	()Ljava/util/ArrayList;
    //   424: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_1
    //   434: ldc_w 1255
    //   437: invokeinterface 1194 2 0
    //   442: astore 4
    //   444: aload 4
    //   446: ifnull +42 -> 488
    //   449: aload 4
    //   451: invokeinterface 1199 1 0
    //   456: ifle +32 -> 488
    //   459: aload_2
    //   460: aload_1
    //   461: ldc_w 1255
    //   464: invokeinterface 1194 2 0
    //   469: iconst_0
    //   470: invokeinterface 1205 2 0
    //   475: invokeinterface 1211 1 0
    //   480: invokeinterface 1214 1 0
    //   485: invokevirtual 1258	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setBeginTime	(Ljava/lang/String;)V
    //   488: aload_1
    //   489: ldc_w 1260
    //   492: invokeinterface 1194 2 0
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull +42 -> 543
    //   504: aload 4
    //   506: invokeinterface 1199 1 0
    //   511: ifle +32 -> 543
    //   514: aload_2
    //   515: aload_1
    //   516: ldc_w 1260
    //   519: invokeinterface 1194 2 0
    //   524: iconst_0
    //   525: invokeinterface 1205 2 0
    //   530: invokeinterface 1211 1 0
    //   535: invokeinterface 1214 1 0
    //   540: invokevirtual 1263	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:setEndTime	(Ljava/lang/String;)V
    //   543: aload_1
    //   544: ldc_w 1265
    //   547: invokeinterface 1194 2 0
    //   552: astore 4
    //   554: aload 4
    //   556: ifnull +50 -> 606
    //   559: aload 4
    //   561: invokeinterface 1199 1 0
    //   566: ifle +40 -> 606
    //   569: aload_1
    //   570: ldc_w 1265
    //   573: invokeinterface 1194 2 0
    //   578: iconst_0
    //   579: invokeinterface 1205 2 0
    //   584: invokeinterface 1211 1 0
    //   589: invokeinterface 1214 1 0
    //   594: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   597: iconst_1
    //   598: if_icmpne +697 -> 1295
    //   601: aload_2
    //   602: iload_3
    //   603: putfield 1268	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:uinType	I
    //   606: aload_1
    //   607: ldc_w 1270
    //   610: invokeinterface 1194 2 0
    //   615: astore 4
    //   617: aload 4
    //   619: ifnull +197 -> 816
    //   622: aload 4
    //   624: invokeinterface 1199 1 0
    //   629: ifle +187 -> 816
    //   632: aload_1
    //   633: ldc_w 1270
    //   636: invokeinterface 1194 2 0
    //   641: iconst_0
    //   642: invokeinterface 1205 2 0
    //   647: checkcast 1272	org/w3c/dom/Element
    //   650: ldc_w 1274
    //   653: invokeinterface 1275 2 0
    //   658: astore 4
    //   660: aload 4
    //   662: ifnull +62 -> 724
    //   665: aload 4
    //   667: invokeinterface 1199 1 0
    //   672: ifle +52 -> 724
    //   675: aload_2
    //   676: aload_1
    //   677: ldc_w 1270
    //   680: invokeinterface 1194 2 0
    //   685: iconst_0
    //   686: invokeinterface 1205 2 0
    //   691: checkcast 1272	org/w3c/dom/Element
    //   694: ldc_w 1274
    //   697: invokeinterface 1275 2 0
    //   702: iconst_0
    //   703: invokeinterface 1205 2 0
    //   708: invokeinterface 1211 1 0
    //   713: invokeinterface 1214 1 0
    //   718: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   721: putfield 1278	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyTime	I
    //   724: aload_1
    //   725: ldc_w 1270
    //   728: invokeinterface 1194 2 0
    //   733: iconst_0
    //   734: invokeinterface 1205 2 0
    //   739: checkcast 1272	org/w3c/dom/Element
    //   742: ldc_w 1280
    //   745: invokeinterface 1275 2 0
    //   750: astore 4
    //   752: aload 4
    //   754: ifnull +62 -> 816
    //   757: aload 4
    //   759: invokeinterface 1199 1 0
    //   764: ifle +52 -> 816
    //   767: aload_2
    //   768: aload_1
    //   769: ldc_w 1270
    //   772: invokeinterface 1194 2 0
    //   777: iconst_0
    //   778: invokeinterface 1205 2 0
    //   783: checkcast 1272	org/w3c/dom/Element
    //   786: ldc_w 1280
    //   789: invokeinterface 1275 2 0
    //   794: iconst_0
    //   795: invokeinterface 1205 2 0
    //   800: invokeinterface 1211 1 0
    //   805: invokeinterface 1214 1 0
    //   810: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   813: putfield 1283	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:frequencyMessage	I
    //   816: aload_1
    //   817: ldc_w 1285
    //   820: invokeinterface 1194 2 0
    //   825: astore 4
    //   827: aload 4
    //   829: ifnull +464 -> 1293
    //   832: aload 4
    //   834: invokeinterface 1199 1 0
    //   839: ifle +454 -> 1293
    //   842: aload_1
    //   843: ldc_w 1285
    //   846: invokeinterface 1194 2 0
    //   851: iconst_0
    //   852: invokeinterface 1205 2 0
    //   857: checkcast 1272	org/w3c/dom/Element
    //   860: ldc_w 1286
    //   863: invokeinterface 1275 2 0
    //   868: astore 4
    //   870: aload 4
    //   872: ifnull +62 -> 934
    //   875: aload 4
    //   877: invokeinterface 1199 1 0
    //   882: ifle +52 -> 934
    //   885: aload_2
    //   886: aload_1
    //   887: ldc_w 1285
    //   890: invokeinterface 1194 2 0
    //   895: iconst_0
    //   896: invokeinterface 1205 2 0
    //   901: checkcast 1272	org/w3c/dom/Element
    //   904: ldc_w 1286
    //   907: invokeinterface 1275 2 0
    //   912: iconst_0
    //   913: invokeinterface 1205 2 0
    //   918: invokeinterface 1211 1 0
    //   923: invokeinterface 1214 1 0
    //   928: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   931: putfield 1289	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:tipType	I
    //   934: aload_1
    //   935: ldc_w 1285
    //   938: invokeinterface 1194 2 0
    //   943: iconst_0
    //   944: invokeinterface 1205 2 0
    //   949: checkcast 1272	org/w3c/dom/Element
    //   952: ldc_w 1280
    //   955: invokeinterface 1275 2 0
    //   960: astore 4
    //   962: aload 4
    //   964: ifnull +59 -> 1023
    //   967: aload 4
    //   969: invokeinterface 1199 1 0
    //   974: ifle +49 -> 1023
    //   977: aload_2
    //   978: aload_1
    //   979: ldc_w 1285
    //   982: invokeinterface 1194 2 0
    //   987: iconst_0
    //   988: invokeinterface 1205 2 0
    //   993: checkcast 1272	org/w3c/dom/Element
    //   996: ldc_w 1280
    //   999: invokeinterface 1275 2 0
    //   1004: iconst_0
    //   1005: invokeinterface 1205 2 0
    //   1010: invokeinterface 1211 1 0
    //   1015: invokeinterface 1214 1 0
    //   1020: putfield 1292	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:adwords	Ljava/lang/String;
    //   1023: aload_1
    //   1024: ldc_w 1285
    //   1027: invokeinterface 1194 2 0
    //   1032: iconst_0
    //   1033: invokeinterface 1205 2 0
    //   1038: checkcast 1272	org/w3c/dom/Element
    //   1041: ldc_w 1294
    //   1044: invokeinterface 1275 2 0
    //   1049: astore 4
    //   1051: aload 4
    //   1053: ifnull +62 -> 1115
    //   1056: aload 4
    //   1058: invokeinterface 1199 1 0
    //   1063: ifle +52 -> 1115
    //   1066: aload_2
    //   1067: aload_1
    //   1068: ldc_w 1285
    //   1071: invokeinterface 1194 2 0
    //   1076: iconst_0
    //   1077: invokeinterface 1205 2 0
    //   1082: checkcast 1272	org/w3c/dom/Element
    //   1085: ldc_w 1294
    //   1088: invokeinterface 1275 2 0
    //   1093: iconst_0
    //   1094: invokeinterface 1205 2 0
    //   1099: invokeinterface 1211 1 0
    //   1104: invokeinterface 1214 1 0
    //   1109: invokestatic 433	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1112: putfield 1297	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:linkOffset	I
    //   1115: aload_1
    //   1116: ldc_w 1285
    //   1119: invokeinterface 1194 2 0
    //   1124: iconst_0
    //   1125: invokeinterface 1205 2 0
    //   1130: checkcast 1272	org/w3c/dom/Element
    //   1133: ldc_w 1299
    //   1136: invokeinterface 1275 2 0
    //   1141: astore 4
    //   1143: aload 4
    //   1145: ifnull +59 -> 1204
    //   1148: aload 4
    //   1150: invokeinterface 1199 1 0
    //   1155: ifle +49 -> 1204
    //   1158: aload_2
    //   1159: aload_1
    //   1160: ldc_w 1285
    //   1163: invokeinterface 1194 2 0
    //   1168: iconst_0
    //   1169: invokeinterface 1205 2 0
    //   1174: checkcast 1272	org/w3c/dom/Element
    //   1177: ldc_w 1299
    //   1180: invokeinterface 1275 2 0
    //   1185: iconst_0
    //   1186: invokeinterface 1205 2 0
    //   1191: invokeinterface 1211 1 0
    //   1196: invokeinterface 1214 1 0
    //   1201: putfield 1302	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:clickableWord	Ljava/lang/String;
    //   1204: aload_1
    //   1205: ldc_w 1285
    //   1208: invokeinterface 1194 2 0
    //   1213: iconst_0
    //   1214: invokeinterface 1205 2 0
    //   1219: checkcast 1272	org/w3c/dom/Element
    //   1222: ldc_w 1304
    //   1225: invokeinterface 1275 2 0
    //   1230: astore 4
    //   1232: aload 4
    //   1234: ifnull +59 -> 1293
    //   1237: aload 4
    //   1239: invokeinterface 1199 1 0
    //   1244: ifle +49 -> 1293
    //   1247: aload_2
    //   1248: aload_1
    //   1249: ldc_w 1285
    //   1252: invokeinterface 1194 2 0
    //   1257: iconst_0
    //   1258: invokeinterface 1205 2 0
    //   1263: checkcast 1272	org/w3c/dom/Element
    //   1266: ldc_w 1304
    //   1269: invokeinterface 1275 2 0
    //   1274: iconst_0
    //   1275: invokeinterface 1205 2 0
    //   1280: invokeinterface 1211 1 0
    //   1285: invokeinterface 1214 1 0
    //   1290: putfield 1306	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:url	Ljava/lang/String;
    //   1293: aload_2
    //   1294: areturn
    //   1295: sipush 3000
    //   1298: istore_3
    //   1299: goto -698 -> 601
    //   1302: astore_1
    //   1303: aload_1
    //   1304: invokevirtual 1307	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   1307: aconst_null
    //   1308: areturn
    //   1309: astore_1
    //   1310: aload_1
    //   1311: invokevirtual 1308	org/xml/sax/SAXException:printStackTrace	()V
    //   1314: goto -7 -> 1307
    //   1317: astore_1
    //   1318: aload_1
    //   1319: invokevirtual 1309	java/io/IOException:printStackTrace	()V
    //   1322: goto -15 -> 1307
    //   1325: astore_1
    //   1326: aload_1
    //   1327: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   1330: goto -23 -> 1307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1333	0	this	aevk
    //   0	1333	1	paramString	String
    //   0	1333	2	paramQQOperationViopTipTask	QQOperationViopTipTask
    //   1	1298	3	i	int
    //   35	1203	4	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   2	37	1302	javax/xml/parsers/ParserConfigurationException
    //   42	63	1302	javax/xml/parsers/ParserConfigurationException
    //   68	110	1302	javax/xml/parsers/ParserConfigurationException
    //   110	121	1302	javax/xml/parsers/ParserConfigurationException
    //   126	168	1302	javax/xml/parsers/ParserConfigurationException
    //   168	179	1302	javax/xml/parsers/ParserConfigurationException
    //   184	226	1302	javax/xml/parsers/ParserConfigurationException
    //   226	237	1302	javax/xml/parsers/ParserConfigurationException
    //   242	284	1302	javax/xml/parsers/ParserConfigurationException
    //   284	295	1302	javax/xml/parsers/ParserConfigurationException
    //   300	342	1302	javax/xml/parsers/ParserConfigurationException
    //   342	353	1302	javax/xml/parsers/ParserConfigurationException
    //   358	397	1302	javax/xml/parsers/ParserConfigurationException
    //   397	433	1302	javax/xml/parsers/ParserConfigurationException
    //   433	444	1302	javax/xml/parsers/ParserConfigurationException
    //   449	488	1302	javax/xml/parsers/ParserConfigurationException
    //   488	499	1302	javax/xml/parsers/ParserConfigurationException
    //   504	543	1302	javax/xml/parsers/ParserConfigurationException
    //   543	554	1302	javax/xml/parsers/ParserConfigurationException
    //   559	601	1302	javax/xml/parsers/ParserConfigurationException
    //   601	606	1302	javax/xml/parsers/ParserConfigurationException
    //   606	617	1302	javax/xml/parsers/ParserConfigurationException
    //   622	660	1302	javax/xml/parsers/ParserConfigurationException
    //   665	724	1302	javax/xml/parsers/ParserConfigurationException
    //   724	752	1302	javax/xml/parsers/ParserConfigurationException
    //   757	816	1302	javax/xml/parsers/ParserConfigurationException
    //   816	827	1302	javax/xml/parsers/ParserConfigurationException
    //   832	870	1302	javax/xml/parsers/ParserConfigurationException
    //   875	934	1302	javax/xml/parsers/ParserConfigurationException
    //   934	962	1302	javax/xml/parsers/ParserConfigurationException
    //   967	1023	1302	javax/xml/parsers/ParserConfigurationException
    //   1023	1051	1302	javax/xml/parsers/ParserConfigurationException
    //   1056	1115	1302	javax/xml/parsers/ParserConfigurationException
    //   1115	1143	1302	javax/xml/parsers/ParserConfigurationException
    //   1148	1204	1302	javax/xml/parsers/ParserConfigurationException
    //   1204	1232	1302	javax/xml/parsers/ParserConfigurationException
    //   1237	1293	1302	javax/xml/parsers/ParserConfigurationException
    //   2	37	1309	org/xml/sax/SAXException
    //   42	63	1309	org/xml/sax/SAXException
    //   68	110	1309	org/xml/sax/SAXException
    //   110	121	1309	org/xml/sax/SAXException
    //   126	168	1309	org/xml/sax/SAXException
    //   168	179	1309	org/xml/sax/SAXException
    //   184	226	1309	org/xml/sax/SAXException
    //   226	237	1309	org/xml/sax/SAXException
    //   242	284	1309	org/xml/sax/SAXException
    //   284	295	1309	org/xml/sax/SAXException
    //   300	342	1309	org/xml/sax/SAXException
    //   342	353	1309	org/xml/sax/SAXException
    //   358	397	1309	org/xml/sax/SAXException
    //   397	433	1309	org/xml/sax/SAXException
    //   433	444	1309	org/xml/sax/SAXException
    //   449	488	1309	org/xml/sax/SAXException
    //   488	499	1309	org/xml/sax/SAXException
    //   504	543	1309	org/xml/sax/SAXException
    //   543	554	1309	org/xml/sax/SAXException
    //   559	601	1309	org/xml/sax/SAXException
    //   601	606	1309	org/xml/sax/SAXException
    //   606	617	1309	org/xml/sax/SAXException
    //   622	660	1309	org/xml/sax/SAXException
    //   665	724	1309	org/xml/sax/SAXException
    //   724	752	1309	org/xml/sax/SAXException
    //   757	816	1309	org/xml/sax/SAXException
    //   816	827	1309	org/xml/sax/SAXException
    //   832	870	1309	org/xml/sax/SAXException
    //   875	934	1309	org/xml/sax/SAXException
    //   934	962	1309	org/xml/sax/SAXException
    //   967	1023	1309	org/xml/sax/SAXException
    //   1023	1051	1309	org/xml/sax/SAXException
    //   1056	1115	1309	org/xml/sax/SAXException
    //   1115	1143	1309	org/xml/sax/SAXException
    //   1148	1204	1309	org/xml/sax/SAXException
    //   1204	1232	1309	org/xml/sax/SAXException
    //   1237	1293	1309	org/xml/sax/SAXException
    //   2	37	1317	java/io/IOException
    //   42	63	1317	java/io/IOException
    //   68	110	1317	java/io/IOException
    //   110	121	1317	java/io/IOException
    //   126	168	1317	java/io/IOException
    //   168	179	1317	java/io/IOException
    //   184	226	1317	java/io/IOException
    //   226	237	1317	java/io/IOException
    //   242	284	1317	java/io/IOException
    //   284	295	1317	java/io/IOException
    //   300	342	1317	java/io/IOException
    //   342	353	1317	java/io/IOException
    //   358	397	1317	java/io/IOException
    //   397	433	1317	java/io/IOException
    //   433	444	1317	java/io/IOException
    //   449	488	1317	java/io/IOException
    //   488	499	1317	java/io/IOException
    //   504	543	1317	java/io/IOException
    //   543	554	1317	java/io/IOException
    //   559	601	1317	java/io/IOException
    //   601	606	1317	java/io/IOException
    //   606	617	1317	java/io/IOException
    //   622	660	1317	java/io/IOException
    //   665	724	1317	java/io/IOException
    //   724	752	1317	java/io/IOException
    //   757	816	1317	java/io/IOException
    //   816	827	1317	java/io/IOException
    //   832	870	1317	java/io/IOException
    //   875	934	1317	java/io/IOException
    //   934	962	1317	java/io/IOException
    //   967	1023	1317	java/io/IOException
    //   1023	1051	1317	java/io/IOException
    //   1056	1115	1317	java/io/IOException
    //   1115	1143	1317	java/io/IOException
    //   1148	1204	1317	java/io/IOException
    //   1204	1232	1317	java/io/IOException
    //   1237	1293	1317	java/io/IOException
    //   2	37	1325	java/lang/Exception
    //   42	63	1325	java/lang/Exception
    //   68	110	1325	java/lang/Exception
    //   110	121	1325	java/lang/Exception
    //   126	168	1325	java/lang/Exception
    //   168	179	1325	java/lang/Exception
    //   184	226	1325	java/lang/Exception
    //   226	237	1325	java/lang/Exception
    //   242	284	1325	java/lang/Exception
    //   284	295	1325	java/lang/Exception
    //   300	342	1325	java/lang/Exception
    //   342	353	1325	java/lang/Exception
    //   358	397	1325	java/lang/Exception
    //   397	433	1325	java/lang/Exception
    //   433	444	1325	java/lang/Exception
    //   449	488	1325	java/lang/Exception
    //   488	499	1325	java/lang/Exception
    //   504	543	1325	java/lang/Exception
    //   543	554	1325	java/lang/Exception
    //   559	601	1325	java/lang/Exception
    //   601	606	1325	java/lang/Exception
    //   606	617	1325	java/lang/Exception
    //   622	660	1325	java/lang/Exception
    //   665	724	1325	java/lang/Exception
    //   724	752	1325	java/lang/Exception
    //   757	816	1325	java/lang/Exception
    //   816	827	1325	java/lang/Exception
    //   832	870	1325	java/lang/Exception
    //   875	934	1325	java/lang/Exception
    //   934	962	1325	java/lang/Exception
    //   967	1023	1325	java/lang/Exception
    //   1023	1051	1325	java/lang/Exception
    //   1056	1115	1325	java/lang/Exception
    //   1115	1143	1325	java/lang/Exception
    //   1148	1204	1325	java/lang/Exception
    //   1204	1232	1325	java/lang/Exception
    //   1237	1293	1325	java/lang/Exception
  }
  
  public static String a(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean)
  {
    int i = 0;
    paramSharedPreferences = paramSharedPreferences.getString("data_migration_tim_uins", "");
    if (TextUtils.isEmpty(paramSharedPreferences))
    {
      if (paramBoolean) {
        return paramString;
      }
      return paramSharedPreferences;
    }
    if (paramBoolean)
    {
      localObject = paramSharedPreferences.split(";");
      j = localObject.length;
      while (i < j)
      {
        if (localObject[i].equals(paramString)) {
          return paramSharedPreferences;
        }
        i += 1;
      }
      return paramSharedPreferences + ";" + paramString;
    }
    paramSharedPreferences = paramSharedPreferences.split(";");
    Object localObject = new StringBuilder();
    int j = paramSharedPreferences.length;
    i = 0;
    while (i < j)
    {
      String str = paramSharedPreferences[i];
      if (!str.equals(paramString)) {
        ((StringBuilder)localObject).append(str).append(";");
      }
      i += 1;
    }
    if ((((StringBuilder)localObject).length() > 0) && (((StringBuilder)localObject).charAt(((StringBuilder)localObject).length() - 1) == ';')) {
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static String a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1) {
      return null;
    }
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() == 0))
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format("handleCompressConfig| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return "";
    }
    if (paramConfig.msg_content_list.size() >= 2) {
      QLog.w("SPLASH_ConfigServlet", 1, "handleCompressConfig, 拉到了多份配置, type[" + paramInt2 + "], size[" + paramConfig.msg_content_list.size() + "]");
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Object localObject1 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1)).content.get().toByteArray();
      if (localObject1 == null)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| config content is null. type=" + paramInt2);
        return null;
      }
      Object localObject2;
      if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
      {
        localObject2 = aden.u((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| decompress is failed. type=" + paramInt2 + ", data=null");
          return null;
        }
      }
      String str;
      try
      {
        localObject2 = new String((byte[])localObject1, "utf-8");
        if (localObject2 == null)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleCompressConfig| switch data[] to String failed. type=" + paramInt2 + ", data=" + new String((byte[])localObject1));
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          str = null;
        }
        localObject1 = String.format("handleCompressConfig| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
        if (!QLog.isColorLevel()) {
          break label432;
        }
      }
      if ((paramConfig.version.get() != 397) && (paramConfig.version.get() != 394)) {
        QLog.i("SPLASH_ConfigServlet", 2, (String)localObject1 + "content=" + str);
      }
      for (;;)
      {
        return str;
        label432:
        QLog.i("SPLASH_ConfigServlet", 1, (String)localObject1);
      }
    }
  }
  
  public static List<String> a(ConfigurationService.Config paramConfig)
  {
    ArrayList localArrayList = null;
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      localArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig: list.size() " + paramConfig.msg_content_list.size());
      }
      Iterator localIterator = paramConfig.msg_content_list.get().iterator();
      if (localIterator.hasNext())
      {
        paramConfig = (ConfigurationService.Content)localIterator.next();
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = inflateConfigString(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {
              break label302;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig: contentitem.content =  " + paramConfig);
        }
        if (TextUtils.isEmpty(paramConfig)) {
          break;
        }
        localArrayList.add(paramConfig);
      }
      catch (Exception paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "parseCommonConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      QLog.i("SPLASH_ConfigServlet", 1, "empty contentitem");
      break;
      do
      {
        return localArrayList;
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parseCommonConfig:msg_content_list is empty ,version: " + paramConfig.version.get());
      return null;
      label302:
      paramConfig = null;
    }
  }
  
  public static List<String> a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1)
    {
      QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContentList| config content is null. type=" + paramInt2);
      return null;
    }
    if (paramConfig.content_list.size() > 0) {
      return paramConfig.content_list.get();
    }
    int i = paramConfig.msg_content_list.size();
    if (i == 0)
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format(Locale.getDefault(), "extractConfigContentList| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(i);
    paramInt1 = 0;
    if (paramInt1 < i)
    {
      Object localObject1 = ((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).content.get().toByteArray();
      Object localObject2;
      if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
      {
        localObject2 = aden.u((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          QLog.e("SPLASH_ConfigServlet", 1, paramInt1 + ": extractConfigContentList| decompress is failed. type=" + paramInt2 + ", data=null");
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        try
        {
          localObject1 = new String((byte[])localObject1, "utf-8");
          localArrayList.add(localObject1);
          localObject2 = String.format(Locale.getDefault(), "%d: extractConfigContent| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
          if (!QLog.isColorLevel()) {
            break label380;
          }
          QLog.i("SPLASH_ConfigServlet", 2, (String)localObject2 + "content=" + (String)localObject1);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          QLog.e("SPLASH_ConfigServlet", 1, paramInt1 + ": extractConfigContentList| data[] to String failed. type=" + paramInt2, localUnsupportedEncodingException);
        }
        continue;
        label380:
        QLog.i("SPLASH_ConfigServlet", 1, (String)localObject2);
      }
    }
    return localArrayList;
  }
  
  /* Error */
  private void a(int paramInt, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: getstatic 1397	cooperation/readinjoy/content/ReadInJoyDataProvider:X	Landroid/net/Uri;
    //   3: invokevirtual 1403	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc_w 1405
    //   13: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   16: invokevirtual 1411	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   19: pop
    //   20: aload 5
    //   22: invokevirtual 1415	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   25: astore 5
    //   27: new 1417	android/content/ContentValues
    //   30: dup
    //   31: invokespecial 1418	android/content/ContentValues:<init>	()V
    //   34: astore 6
    //   36: aload 6
    //   38: ldc_w 1420
    //   41: iload_1
    //   42: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: invokevirtual 1424	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   48: aload 6
    //   50: ldc_w 1426
    //   53: aload_2
    //   54: invokevirtual 1429	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc_w 1431
    //   62: aload_3
    //   63: invokevirtual 1429	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 1433
    //   69: iconst_2
    //   70: anewarray 178	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 1426
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokevirtual 1437	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   95: aload 5
    //   97: aconst_null
    //   98: aload_2
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokestatic 1443	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +148 -> 254
    //   109: aload_2
    //   110: invokeinterface 1448 1 0
    //   115: ifle +61 -> 176
    //   118: aload 4
    //   120: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   123: invokevirtual 1437	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   126: aload 5
    //   128: aload 6
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 1454	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +12 -> 151
    //   142: ldc 169
    //   144: iconst_2
    //   145: ldc_w 1456
    //   148: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 4
    //   153: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   156: invokevirtual 1437	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   159: aload 5
    //   161: aconst_null
    //   162: invokevirtual 1460	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   165: aload_2
    //   166: ifnull +9 -> 175
    //   169: aload_2
    //   170: invokeinterface 1463 1 0
    //   175: return
    //   176: aload 4
    //   178: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   181: invokevirtual 1437	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   184: aload 5
    //   186: aload 6
    //   188: invokevirtual 1467	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   191: pop
    //   192: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -44 -> 151
    //   198: ldc 169
    //   200: iconst_2
    //   201: ldc_w 1469
    //   204: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -56 -> 151
    //   210: astore_3
    //   211: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +29 -> 243
    //   217: ldc 169
    //   219: iconst_2
    //   220: new 68	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 1471
    //   230: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_3
    //   234: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_2
    //   244: ifnull -69 -> 175
    //   247: aload_2
    //   248: invokeinterface 1463 1 0
    //   253: return
    //   254: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -106 -> 151
    //   260: ldc 169
    //   262: iconst_2
    //   263: ldc_w 1473
    //   266: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto -118 -> 151
    //   272: astore 4
    //   274: aload_2
    //   275: astore_3
    //   276: aload 4
    //   278: astore_2
    //   279: aload_3
    //   280: ifnull +9 -> 289
    //   283: aload_3
    //   284: invokeinterface 1463 1 0
    //   289: aload_2
    //   290: athrow
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_3
    //   294: goto -15 -> 279
    //   297: astore 4
    //   299: aload_2
    //   300: astore_3
    //   301: aload 4
    //   303: astore_2
    //   304: goto -25 -> 279
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -99 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	aevk
    //   0	313	1	paramInt	int
    //   0	313	2	paramString1	String
    //   0	313	3	paramString2	String
    //   0	313	4	paramQQAppInterface	QQAppInterface
    //   6	179	5	localObject	Object
    //   34	153	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   109	151	210	java/lang/Exception
    //   151	165	210	java/lang/Exception
    //   176	207	210	java/lang/Exception
    //   254	269	210	java/lang/Exception
    //   109	151	272	finally
    //   151	165	272	finally
    //   176	207	272	finally
    //   254	269	272	finally
    //   27	105	291	finally
    //   211	243	297	finally
    //   27	105	307	java/lang/Exception
  }
  
  private void a(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig|type= " + paramConfig.type.get());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    adex localadex = (adex)localQQAppInterface.getManager(168);
    if (paramConfig.type.get() != 88)
    {
      OlympicServlet.a(localQQAppInterface, 88, 0, 0, 1, 3, 0);
      return;
    }
    int i = paramConfig.version.get();
    int j;
    if (paramIntent.getIntExtra("key_ar_entrance_effect_version", 0) != i) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        j = paramIntent.task_id.get();
        if (paramIntent.compress.get() == 1)
        {
          paramIntent = aden.u(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            OlympicServlet.a(localQQAppInterface, 88, i, j, 1, 4, 0);
            if (!QLog.isColorLevel()) {
              break label393;
            }
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||deCompress error!");
            paramIntent = null;
          }
        }
      }
    }
    for (;;)
    {
      paramIntent = ArEffectConfig.a(paramIntent);
      if (paramIntent != null)
      {
        paramIntent.version = i;
        if (localadex != null) {
          localadex.c(paramIntent);
        }
        for (;;)
        {
          for (;;)
          {
            OlympicServlet.a(localQQAppInterface, 88, i, j, 1, 0, 0);
            return;
            try
            {
              paramIntent = new String(paramIntent, "utf-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              paramConfig = null;
              paramIntent = paramConfig;
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, localUnsupportedEncodingException.getMessage());
          paramIntent = paramConfig;
          break;
          paramIntent = paramIntent.content.get().toStringUtf8();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig|arManager is null ");
          }
        }
      }
      OlympicServlet.a(localQQAppInterface, 88, i, j, 1, 5, 0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig||parseArEffectConfig error!");
      return;
      if (localadex != null) {
        localadex.cQZ();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig || msg_content_list is null");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArEntranceConfig || has same version");
      return;
      label393:
      paramIntent = null;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, Packet paramPacket)
  {
    Object localObject1 = new ConfigurationService.ReqGetConfig();
    int n = paramArrayOfInt.length;
    ArrayList localArrayList1 = new ArrayList(n);
    ArrayList localArrayList2 = new ArrayList(n);
    int k = 0;
    ConfigurationService.ConfigSeq localConfigSeq;
    int i1;
    int j;
    int i;
    Object localObject7;
    boolean bool;
    label1609:
    int m;
    if (k < n)
    {
      localConfigSeq = new ConfigurationService.ConfigSeq();
      i1 = paramArrayOfInt[k];
      localConfigSeq.type.set(i1);
      switch (i1)
      {
      default: 
        j = 0;
        i = j;
      case 1: 
      case 2: 
      case 3: 
      case 12: 
      case 5: 
      case 55: 
      case 10: 
      case 46: 
      case 13: 
      case 102: 
      case 101: 
      case 34: 
      case 115: 
      case 286: 
      case 23: 
      case 53: 
      case 78: 
      case 84: 
      case 167: 
      case 226: 
      case 139: 
      case 329: 
      case 351: 
      case 223: 
      case 364: 
      case 365: 
      case 31: 
      case 94: 
      case 38: 
      case 93: 
      case 44: 
      case 42: 
      case 47: 
      case 65: 
      case 49: 
      case 50: 
      case 56: 
      case 148: 
      case 61: 
      case 63: 
      case 64: 
      case 57: 
      case 66: 
      case 72: 
      case 73: 
      case 69: 
      case 74: 
      case 75: 
      case 385: 
      case 228: 
      case 256: 
      case 6: 
      case 43: 
      case 113: 
      case 80: 
      case 111: 
      case 79: 
      case 82: 
      case 90: 
      case 147: 
      case 86: 
      case 87: 
        for (;;)
        {
          try
          {
            if (aeif.a().jg(i1))
            {
              localObject2 = aeif.a();
              localObject7 = ((aeif)localObject2).a(i1);
              i = j;
              if (localObject7 != null)
              {
                i = ((aehv)localObject7).onSend(((aeif)localObject2).q(i1, mCurUin));
                bool = ((aeif)localObject2).k(paramQQAppInterface, i1);
                if (bool)
                {
                  ((aeif)localObject2).hJ(i1, 0);
                  i = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QConfigManager", 2, "[Send] t=" + i1 + " v=" + i + " up=" + bool);
                }
                localConfigSeq.version.set(i);
                if (!((aeif)localObject2).jf(i1)) {
                  break label9542;
                }
                localConfigSeq.compress.set(1);
                break label9542;
              }
            }
            if (i == 0) {
              paramQQAppInterface.a().a(localConfigSeq, paramQQAppInterface, i1);
            }
          }
          catch (Exception localException2)
          {
            Object localObject2;
            String str;
            long l;
            label3474:
            int i2;
            QLog.d("QConfigManager", 1, "exception " + i1, localException2);
            continue;
          }
          localArrayList1.add(localConfigSeq);
          localArrayList2.add(Integer.valueOf(i1));
          k += 1;
          break;
          localConfigSeq.version.set(aqmj.aP(paramQQAppInterface.getApp()));
          continue;
          localConfigSeq.version.set(aqmj.Q(paramQQAppInterface.getApp(), mCurUin));
          continue;
          aqmj.co(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
          if (paramQQAppInterface.getCurrentAccountUin() != null)
          {
            bBU = paramQQAppInterface.getCurrentNickname();
            localObject2 = aqep.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
            if (localObject2 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
              }
              j = (int)((Card)localObject2).lBirthday;
              i = andk.jl(j);
              j = andk.jm(j);
              aqmj.cp(paramQQAppInterface.getApp(), G(i, j));
              i = G(new SimpleDateFormat("MM-dd").format(new Date()), G(i, j));
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet_birth", 2, "birthday date diff is " + i);
              }
              if (i < 0) {
                continue;
              }
              if (i <= 3) {}
            }
            else
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet_birth", 2, "card===null");
              continue;
            }
            localConfigSeq.version.set(aqmj.R(paramQQAppInterface.getApp(), mCurUin));
            continue;
            localObject2 = (aevt)paramQQAppInterface.getManager(74);
            localConfigSeq.version.set(((aevt)localObject2).lA());
            localObject7 = paramIntent.getStringExtra("key_province");
            localObject2 = localObject7;
            if (localObject7 == null) {
              localObject2 = "";
            }
            str = paramIntent.getStringExtra("key_city");
            localObject7 = str;
            if (str == null) {
              localObject7 = "";
            }
            ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject2);
            ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
            continue;
            localConfigSeq.version.set(aqmj.S(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(aqmj.T(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
            continue;
            localConfigSeq.version.set(aqmj.aO(paramQQAppInterface.getApp()));
            continue;
            localConfigSeq.version.set(PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApp()));
            localConfigSeq.compress.set(1);
            continue;
            BridgeHelper.a(BaseApplication.getContext(), mCurUin).ezV();
            localConfigSeq.version.set(aqmj.K(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
            continue;
            i = aewh.getVersionCode(BaseApplicationImpl.getContext());
            if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), mCurUin, null, "qqsetting_calltab_show_key_version", 0) < i)
            {
              localConfigSeq.version.set(0);
            }
            else
            {
              localConfigSeq.version.set(aqmj.V(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
              continue;
              i = aewh.getVersionCode(BaseApplicationImpl.getContext());
              if (SettingCloneUtil.readValueForInt(BaseApplicationImpl.getContext(), mCurUin, null, "qqsetting_calltab_show_key_version", 0) < i)
              {
                localConfigSeq.version.set(0);
                paramIntent.putExtra("update101Version", i);
              }
              else
              {
                localConfigSeq.version.set(aqmj.U(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                continue;
                localObject2 = (yuu)paramQQAppInterface.getManager(102);
                localConfigSeq.version.set(((yuu)localObject2).xB());
                continue;
                localConfigSeq.version.set(aqmj.Y(paramQQAppInterface.getApp(), mCurUin));
                continue;
                localConfigSeq.version.set(aqmj.Z(paramQQAppInterface.getApp(), mCurUin));
                continue;
                localConfigSeq.version.set(aqmj.aQ(paramQQAppInterface.getApp()));
                continue;
                localConfigSeq.version.set(aqmj.aa(paramQQAppInterface.getApp(), mCurUin));
                continue;
                localConfigSeq.version.set(aqmj.ab(paramQQAppInterface.getApp(), mCurUin));
                continue;
                if (!PtvTemplateManager.auE())
                {
                  localConfigSeq.version.set(0);
                }
                else
                {
                  localConfigSeq.version.set(aqmj.aS(paramQQAppInterface.getApp()));
                  continue;
                  if (!PtvTemplateManager.awz())
                  {
                    localConfigSeq.version.set(0);
                    localConfigSeq.compress.set(1);
                  }
                  else
                  {
                    localConfigSeq.version.set(aqmj.aU(paramQQAppInterface.getApp()));
                    continue;
                    if (!alwd.auE())
                    {
                      localConfigSeq.version.set(0);
                      localConfigSeq.compress.set(1);
                    }
                    else
                    {
                      localConfigSeq.version.set(aqmj.aT(paramQQAppInterface.getApp()));
                      continue;
                      i = 0;
                      if (PtvTemplateManager.awA()) {
                        i = aqmj.aV(paramQQAppInterface.getApp());
                      }
                      localConfigSeq.version.set(i);
                      localConfigSeq.compress.set(1);
                      if (QLog.isDevelopLevel())
                      {
                        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 4, String.format("个性笔触配置版本号[%s]", new Object[] { Integer.valueOf(i) }));
                        continue;
                        i = aqmj.bp(paramQQAppInterface.getApp());
                        localConfigSeq.version.set(i);
                        localConfigSeq.compress.set(1);
                        if (QLog.isDevelopLevel())
                        {
                          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 4, String.format("日迹合拍版本号[%s]", new Object[] { Integer.valueOf(i) }));
                          continue;
                          i = aqmj.bz(paramQQAppInterface.getApp(), mCurUin);
                          localConfigSeq.version.set(i);
                          localConfigSeq.compress.set(1);
                          if (QLog.isDevelopLevel())
                          {
                            QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 4, String.format("日迹问答版本号[%s]", new Object[] { Integer.valueOf(i) }));
                            continue;
                            BusinessCommonConfig.getInstance(paramQQAppInterface).fillConfigVersion(i1, localConfigSeq);
                            continue;
                            localConfigSeq.version.set(aqmj.L(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(aqmj.M(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
                            continue;
                            localConfigSeq.version.set(aqmj.W(paramQQAppInterface.getApp(), mCurUin));
                            continue;
                            localConfigSeq.version.set(aqmj.X(paramQQAppInterface.getApp(), mCurUin));
                            continue;
                            localConfigSeq.version.set(aqmj.N(paramQQAppInterface.getApp(), mCurUin));
                            continue;
                            localConfigSeq.version.set(aqmj.ap(paramQQAppInterface.getApp(), mCurUin));
                            l = paramIntent.getLongExtra("k_adcode", 0L);
                            localObject7 = paramIntent.getStringExtra("key_province");
                            localObject2 = localObject7;
                            if (localObject7 == null) {
                              localObject2 = "";
                            }
                            str = paramIntent.getStringExtra("key_city");
                            localObject7 = str;
                            if (str == null) {
                              localObject7 = "";
                            }
                            ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject2);
                            ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
                            ((ConfigurationService.ReqGetConfig)localObject1).adcode.set(l);
                            continue;
                            bool = tam.NB();
                            if (QLog.isColorLevel()) {
                              QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                            }
                            if (bool)
                            {
                              localConfigSeq.version.set(aqmj.O(paramQQAppInterface.getApp(), mCurUin));
                              continue;
                              bool = tam.NB();
                              if (QLog.isColorLevel()) {
                                QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs, support ble=" + bool);
                              }
                              if (bool)
                              {
                                localConfigSeq.version.set(aqmj.P(paramQQAppInterface.getApp(), mCurUin));
                                continue;
                                localConfigSeq.version.set(aqmj.bd(paramQQAppInterface.getApp()));
                                continue;
                                i = aqmj.ah(paramQQAppInterface.getApp(), mCurUin);
                                j = AppSetting.getAppId();
                                if (i != j)
                                {
                                  aqmj.N(paramQQAppInterface.getApp(), mCurUin, 0);
                                  aqmj.P(paramQQAppInterface.getApp(), mCurUin, j);
                                  SearchConfigManager.aH(paramQQAppInterface, mCurUin);
                                }
                                localConfigSeq.version.set(aqmj.ag(paramQQAppInterface.getApp(), mCurUin));
                                continue;
                                localConfigSeq.version.set(aqmj.aq(paramQQAppInterface.getApp(), mCurUin));
                                continue;
                                localConfigSeq.version.set(aqmj.aR(paramQQAppInterface.getApp()));
                                localConfigSeq.compress.set(1);
                                continue;
                                localConfigSeq.version.set(aqmj.be(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(aqmj.bf(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(aqmj.bg(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(aqmj.bh(paramQQAppInterface.getApp()));
                                continue;
                                localConfigSeq.version.set(aqmj.ak(paramQQAppInterface.getApp(), mCurUin));
                                continue;
                                localConfigSeq.version.set(aqmj.au(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin()));
                                continue;
                                localConfigSeq.version.set(aqmj.bi(paramQQAppInterface.getApp()));
                                continue;
                                i = aqmj.al(paramQQAppInterface.getApp(), mCurUin);
                                localConfigSeq.version.set(i);
                                continue;
                                localConfigSeq.version.set(((achg)paramQQAppInterface.getManager(159)).lA());
                                continue;
                                i = aqmj.am(paramQQAppInterface.getApp(), mCurUin);
                                if (aqmj.ai(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.getAppId()) {
                                  i = 0;
                                }
                                localConfigSeq.version.set(i);
                                continue;
                                localObject2 = (aury)paramQQAppInterface.getBusinessHandler(146);
                                i = ((aury)localObject2).k(paramQQAppInterface.getApp(), mCurUin);
                                j = ((aury)localObject2).bM(paramQQAppInterface.getApp(), mCurUin);
                                m = AppSetting.getAppId();
                                if (j != m)
                                {
                                  i = 0;
                                  QLog.i("NCtr", 1, String.format("request NOTIFICATION_LIMIT_CONFIG localVersion: %d ,originalAppId:%d, currentAppId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) }));
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = aqmj.bd(paramQQAppInterface.getApp(), mCurUin);
                                  if (aqmj.be(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.getAppId()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  i = aqmj.bf(paramQQAppInterface.getApp(), mCurUin);
                                  if (aqmj.bg(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.getAppId()) {
                                    i = 0;
                                  }
                                  localConfigSeq.version.set(i);
                                  continue;
                                  localObject1 = DeviceProfileManager.a(paramQQAppInterface);
                                  continue;
                                  localConfigSeq.version.set(aqmj.ao(paramQQAppInterface.getApp(), mCurUin));
                                  continue;
                                  localConfigSeq.version.set(alan.k(paramQQAppInterface.getApp(), mCurUin));
                                  localConfigSeq.compress.set(1);
                                  localObject7 = paramIntent.getStringExtra("key_province");
                                  localObject2 = localObject7;
                                  if (localObject7 == null) {
                                    localObject2 = "";
                                  }
                                  str = paramIntent.getStringExtra("key_city");
                                  localObject7 = str;
                                  if (str == null) {
                                    localObject7 = "";
                                  }
                                  ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject2);
                                  ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
                                  continue;
                                  localConfigSeq.version.set(aqmj.aZ(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(aqmj.ba(paramQQAppInterface.getApp()));
                                  continue;
                                  localConfigSeq.version.set(aqmj.av(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(aqmj.ay(paramQQAppInterface.getApp(), mCurUin));
                                  continue;
                                  localConfigSeq.version.set(aqmj.at(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()));
                                  continue;
                                  localConfigSeq.version.set(aqmj.i(paramQQAppInterface.getApp(), "shop_tab", mCurUin));
                                  continue;
                                  localObject2 = (OlympicManager)paramQQAppInterface.getManager(167);
                                  if (localObject2 == null) {
                                    continue;
                                  }
                                  ((OlympicManager)localObject2).dCL();
                                  localObject2 = ((OlympicManager)localObject2).a();
                                  i = 0;
                                  if (localObject2 != null) {
                                    i = ((OlympicActConfig)localObject2).version;
                                  }
                                  localConfigSeq.version.set(i);
                                  localConfigSeq.compress.set(1);
                                  paramIntent.putExtra("config_version", i);
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.OLYMPIC_ACT_RESOURCE_CONFIG_INFO", 2, new Object[] { "oldVersion=", Integer.valueOf(i) });
                                  }
                                  if (!akrf.V(BaseApplicationImpl.getContext(), "olympic_config_act_get")) {
                                    continue;
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("Olympic.configServlet", 2, new Object[] { "check24Hour, result=true, do Report, key=", "olympic_config_act_get" });
                                  }
                                  anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "olympic_config_act_get", true, 0L, 0L, null, "", false);
                                  akrf.bK(BaseApplicationImpl.getContext(), "olympic_config_act_get");
                                  continue;
                                  localObject2 = (adex)paramQQAppInterface.getManager(168);
                                  if (localObject2 == null) {
                                    continue;
                                  }
                                  i2 = ((adex)localObject2).Bs();
                                  m = 0;
                                  i = 0;
                                  localObject7 = BaseApplicationImpl.getApplication();
                                  j = m;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          try
          {
            int i3 = ((Context)localObject7).getPackageManager().getPackageInfo(((Context)localObject7).getPackageName(), 0).versionCode;
            j = m;
            m = ((adex)localObject2).Br();
            if ((m == 0) || (i3 != m)) {
              break label9548;
            }
            j = i;
            QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig|type= 1 version code is  " + i3 + "local version type is " + m);
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            localNameNotFoundException.printStackTrace();
            QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig|type= 1 error happen");
            i = j;
            continue;
            localConfigSeq.version.set(i2);
            continue;
          }
          if (i == 1)
          {
            localConfigSeq.version.set(0);
            localConfigSeq.compress.set(1);
            localObject7 = paramIntent.getStringExtra("key_province");
            localObject2 = localObject7;
            if (localObject7 == null) {
              localObject2 = "";
            }
            str = paramIntent.getStringExtra("key_city");
            localObject7 = str;
            if (str == null) {
              localObject7 = "";
            }
            ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject2);
            ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
            paramIntent.putExtra("key_config_version", i2);
            break;
          }
          Object localObject3 = (adas)paramQQAppInterface.getManager(220);
          if (localObject3 == null) {
            break;
          }
          i = ((adas)localObject3).Bs();
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfig", 2, " local version = " + i);
          }
          if (((adas)localObject3).adn()) {
            localConfigSeq.version.set(i);
          }
          for (;;)
          {
            localConfigSeq.compress.set(1);
            paramIntent.putExtra("ar_global_key_config_version", i);
            break;
            i = 0;
            localConfigSeq.version.set(0);
          }
          localObject3 = (adas)paramQQAppInterface.getManager(220);
          if (localObject3 == null) {
            break;
          }
          i = ((adas)localObject3).Bt();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("ar_scan_star_face_config_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_STAR_FACE_CONFIG, version = " + i);
          break;
          i = adfa.G(paramQQAppInterface);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_download_cfg_version", i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SPLASH_ConfigServlet", 2, " get AR_SCAN_FACE_PRE_DOWN_CONFIG, version = " + i);
          break;
          localObject3 = (adex)paramQQAppInterface.getManager(168);
          if (localObject3 == null) {
            break;
          }
          i = ((adex)localObject3).BA();
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("key_ar_entrance_effect_version", i);
          break;
          i = aqmj.i(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", mCurUin);
          localConfigSeq.version.set(i);
          break;
          localObject3 = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
          localConfigSeq.version.set(((PhoneContactManagerImp)localObject3).xA());
          break;
          igo.a(i1, mCurUin, localConfigSeq);
          break;
          i = aeah.as(BaseApplicationImpl.getContext());
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          paramIntent.putExtra("qcamera_conf_version", i);
          paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.camera.configServlet", 2, "request QCAMERA_PHONE_CONFIG version: " + i);
          break;
          i = aqmj.i(paramQQAppInterface.getApp(), "change_machine_version", mCurUin);
          localConfigSeq.version.set(i);
          break;
          i = aqmj.ar(paramQQAppInterface.getApp(), mCurUin);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|GET_CONFIG_UPGRADE version=" + i);
          }
          localConfigSeq.version.set(i);
          paramQQAppInterface.cLz();
          arxs.a(paramQQAppInterface.getApp(), String.valueOf(AppSetting.getAppId()));
          ((accy)paramQQAppInterface.getBusinessHandler(4)).cIa();
          break;
          i = aqmj.as(paramQQAppInterface.getApp(), mCurUin);
          localConfigSeq.version.set(i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UpgradeTIMWrapper", 2, "ConfigServlet req :193, version: " + i);
          break;
          i = aqmj.i(paramQQAppInterface.getApp(), "now_entrance_action_version", mCurUin);
          localConfigSeq.version.set(i);
          break;
          i = aqmj.i(paramQQAppInterface.getApp(), "troop_common_config_version", mCurUin);
          localConfigSeq.version.set(i);
          break;
          i = aqmj.i(paramQQAppInterface.getApp(), "nearby_config_version", mCurUin);
          localConfigSeq.version.set(i);
          break;
          i = aqmj.i(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", mCurUin);
          localConfigSeq.version.set(i);
          break;
          localConfigSeq.version.set(aqmj.az(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
          localConfigSeq.compress.set(1);
          break;
          localObject3 = (acbs)paramQQAppInterface.getBusinessHandler(53);
          if (localObject3 == null) {
            break;
          }
          i = AppSetting.getAppId();
          if (i != ((acbs)localObject3).u(paramQQAppInterface.getApp(), mCurUin))
          {
            ((acbs)localObject3).o(paramQQAppInterface.getApp(), mCurUin, 0);
            ((acbs)localObject3).p(paramQQAppInterface.getApp(), mCurUin, i);
            ((acbs)localObject3).c(paramQQAppInterface.getApp(), mCurUin, true);
            ((acbs)localObject3).cHb();
          }
          localConfigSeq.version.set(((acbs)localObject3).t(paramQQAppInterface.getApp(), mCurUin));
          break;
          localConfigSeq.version.set(aqmj.aB(paramQQAppInterface.getApp(), mCurUin));
          localConfigSeq.version.set(aqmj.aC(paramQQAppInterface.getApp(), mCurUin));
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(aqmj.an(paramQQAppInterface.getApp(), mCurUin));
          break;
          localConfigSeq.version.set(amxh.Jd());
          break;
          i = amkd.C(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
          localConfigSeq.version.set(i);
          break;
          i = aqmj.i(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", mCurUin);
          localConfigSeq.version.set(i);
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(aqmj.aE(paramQQAppInterface.getApp(), mCurUin));
          break;
          if (aqmj.e(paramQQAppInterface.getApp(), mCurUin, 1) != AppSetting.getAppId())
          {
            aqmj.h(paramQQAppInterface.getApp(), mCurUin, 1, AppSetting.getAppId());
            aqmj.h(paramQQAppInterface.getApp(), mCurUin, 2, 0);
            localConfigSeq.version.set(0);
            break;
          }
          localConfigSeq.version.set(aqmj.e(paramQQAppInterface.getApp(), mCurUin, 2));
          break;
          try
          {
            if (((Integer)aqmj.a(paramQQAppInterface.getApp(), mCurUin, 1)).intValue() == AppSetting.getAppId()) {
              break label5554;
            }
            aqmj.a(paramQQAppInterface.getApp(), mCurUin, 1, Integer.valueOf(AppSetting.getAppId()));
            aqmj.a(paramQQAppInterface.getApp(), mCurUin, 2, Integer.valueOf(0));
            localConfigSeq.version.set(0);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "PUSH_RECOMMEND_SHIELD_CONFIG", localThrowable);
        break;
        label5554:
        i = ((Integer)aqmj.a(paramQQAppInterface.getApp(), mCurUin, 2)).intValue();
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(aqmj.aH(paramQQAppInterface.getApp(), mCurUin));
        break;
        if (!PtvTemplateManager.awB()) {
          localConfigSeq.version.set(0);
        }
        for (;;)
        {
          localConfigSeq.compress.set(1);
          break;
          localConfigSeq.version.set(aqmj.aX(paramQQAppInterface.getApp()));
        }
        localConfigSeq.version.set(aqmj.aF(paramQQAppInterface.getApp(), mCurUin));
        break;
        localConfigSeq.version.set(aqmj.aL(paramQQAppInterface.getApp(), mCurUin));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(aqmj.aN(paramQQAppInterface.getApp(), mCurUin));
        localConfigSeq.compress.set(1);
        break;
        Object localObject4 = (rnu)paramQQAppInterface.getManager(208);
        localConfigSeq.version.set(((rnu)localObject4).a.k(paramQQAppInterface.getApp(), mCurUin));
        break;
        localConfigSeq.version.set(aqmj.aJ(paramQQAppInterface.getApp(), mCurUin));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(obt.j(paramQQAppInterface));
        break;
        localConfigSeq.version.set(aqmj.aK(paramQQAppInterface.getApp(), mCurUin));
        break;
        i = aqmj.aU(paramQQAppInterface.getApp(), mCurUin);
        j = AppSetting.getAppId();
        if (i != j)
        {
          aqmj.an(paramQQAppInterface.getApp(), mCurUin, 0);
          aqmj.ao(paramQQAppInterface.getApp(), mCurUin, j);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "[Doutu]onsend : appIdRecord = " + i + ", appId = " + j + ", DOUTU_CONFI version = " + aqmj.aR(paramQQAppInterface.getApp(), mCurUin));
          }
          localConfigSeq.version.set(aqmj.aR(paramQQAppInterface.getApp(), mCurUin));
          localConfigSeq.compress.set(1);
          break;
          localObject4 = (afdw)getAppRuntime().getManager(214);
          if (localObject4 != null) {
            ((afdw)localObject4).HI(false);
          }
        }
        i = aqmj.ac(paramQQAppInterface.getApp(), mCurUin);
        j = AppSetting.getAppId();
        if (i != j)
        {
          aqmj.K(paramQQAppInterface.getApp(), mCurUin, 0);
          aqmj.J(paramQQAppInterface.getApp(), mCurUin, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[GreenVideo]onsend : appIdRecord = " + i + ", appId = " + j + ", GREEN_VIDEO_CONFI version = " + aqmj.ad(paramQQAppInterface.getApp(), mCurUin));
        }
        localConfigSeq.version.set(aqmj.ad(paramQQAppInterface.getApp(), mCurUin));
        localConfigSeq.compress.set(1);
        break;
        i = aqmj.ae(paramQQAppInterface.getApp(), mCurUin);
        j = AppSetting.getAppId();
        if (i != j)
        {
          aqmj.M(paramQQAppInterface.getApp(), mCurUin, 0);
          aqmj.L(paramQQAppInterface.getApp(), mCurUin, j);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "[VideoCompress]onsend : appIdRecord = " + i + ", appId = " + j + ", VIDEO_REDBAG_CONFI version = " + aqmj.aW(paramQQAppInterface.getApp(), mCurUin));
        }
        localConfigSeq.version.set(aqmj.af(paramQQAppInterface.getApp(), mCurUin));
        localConfigSeq.compress.set(1);
        break;
        if (((Integer)ajrb.c(mCurUin, "key_app_id", Integer.valueOf(0))).intValue() != AppSetting.getAppId())
        {
          ajrb.c(mCurUin, "key_tabs_config_version", Integer.valueOf(0));
          ajrb.c(mCurUin, "key_app_id", Integer.valueOf(AppSetting.getAppId()));
        }
        i = ((Integer)ajrb.c(mCurUin, "key_tabs_config_version", Integer.valueOf(0))).intValue();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        localObject7 = paramIntent.getStringExtra("key_province");
        localObject4 = localObject7;
        if (localObject7 == null) {
          localObject4 = "";
        }
        str = paramIntent.getStringExtra("key_city");
        localObject7 = str;
        if (str == null) {
          localObject7 = "";
        }
        ((ConfigurationService.ReqGetConfig)localObject1).province.set((String)localObject4);
        ((ConfigurationService.ReqGetConfig)localObject1).city.set((String)localObject7);
        break;
        i = sna.bo(mCurUin);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(anvq.P(paramQQAppInterface));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(aqmj.aP(paramQQAppInterface.getApp(), mCurUin));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(aqmj.aM(paramQQAppInterface.getApp(), mCurUin));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(xun.k(paramQQAppInterface.getApp(), mCurUin));
        localConfigSeq.compress.set(1);
        break;
        i = aqmj.i(paramQQAppInterface.getApp(), "change_machine_version", mCurUin);
        localConfigSeq.version.set(i);
        break;
        i = aqmj.i(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", mCurUin);
        localConfigSeq.version.set(i);
        break;
        localConfigSeq.version.set(aqmj.aZ(paramQQAppInterface.getApp(), mCurUin));
        break;
        localConfigSeq.version.set(aqmj.bk(paramQQAppInterface.getApp()));
        break;
        localConfigSeq.version.set(aqmj.ba(paramQQAppInterface.getApp(), mCurUin));
        break;
        localConfigSeq.version.set(aasr.ak(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(alwh.ak(paramQQAppInterface.getApp()));
        localConfigSeq.compress.set(1);
        break;
        a((ConfigurationService.ReqGetConfig)localObject1, localConfigSeq, paramQQAppInterface);
        break;
        i = aqmj.i(paramQQAppInterface.getApp(), "search_function_config_version", mCurUin);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = ((aklr)paramQQAppInterface.getManager(228)).lA();
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet OCR_CONFIG ocrVersion:" + i);
        break;
        i = aqmj.bc(BaseApplicationImpl.getContext(), mCurUin);
        localConfigSeq.version.set(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SPLASH_ConfigServlet", 2, "ConfigServlet receipt ,receiptVersion:" + i);
        break;
        i = aqmj.bG(BaseApplicationImpl.getContext(), mCurUin);
        localConfigSeq.version.set(i);
        break;
        i = aqmj.bH(BaseApplicationImpl.getContext(), mCurUin);
        localConfigSeq.version.set(i);
        break;
        i = ShortVideoResourceManager.Jk();
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoResourceManager", 2, "SHORT_VIDEO_RESOURCE_CONFIG  ,versionRes:" + i);
        }
        ShortVideoResourceManager.dPo();
        break;
        i = paramQQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = paramQQAppInterface.getPreferences().getInt("tim_login_jump", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        aaug.a(paramQQAppInterface, localConfigSeq, true, mCurUin);
        break;
        i = paramQQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        localConfigSeq.version.set(paramQQAppInterface.getPreferences().getInt("call_tim_config_version", 0));
        break;
        i = paramQQAppInterface.getPreferences().getInt("tim_pc_banner", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = paramQQAppInterface.getPreferences().getInt("troop_link_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        i = paramQQAppInterface.getPreferences().getInt("key_game_troop_bind_config_version", 0);
        localConfigSeq.version.set(i);
        localConfigSeq.compress.set(1);
        break;
        paramQQAppInterface.a().a(localConfigSeq, paramQQAppInterface, i1);
        localObject4 = (afsi)paramQQAppInterface.getManager(264);
        try
        {
          ((afsi)localObject4).a();
        }
        catch (Exception localException1)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "get local extend friend exception:", localException1);
        }
      }
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = anjn.aA(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = aqmj.i(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", mCurUin);
      localConfigSeq.version.set(i);
      break label1609;
      i = aqmj.i(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", mCurUin);
      localConfigSeq.version.set(i);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("zhitu_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("homework_troop_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      Object localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Apgz.k(paramQQAppInterface.getApp(), mCurUin));
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("new_troop_recommend", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Apir.k(paramQQAppInterface.getApp(), mCurUin));
      localConfigSeq.compress.set(1);
      break label1609;
      i = RecentDanceConfigMgr.JT();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = ahwy.a().a.Fq();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = LightVideoConfigMgr.RB();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localConfigSeq.version.set(aqmj.i(paramQQAppInterface.getApp(), "sport_config", mCurUin));
      localConfigSeq.compress.set(1);
      break label1609;
      i = aqmj.i(paramQQAppInterface.getApplication(), "troop_gift_anim_limit", "0");
      localConfigSeq.version.set(i);
      break label1609;
      localConfigSeq.version.set(0);
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("task_entry_config_version", 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("qzone_xp_config_version", 0);
      localConfigSeq.version.set(i);
      break label1609;
      i = paramQQAppInterface.getPreferences().getInt("buluo_enter_config_version" + paramQQAppInterface.getCurrentUin(), 0);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localConfigSeq.version.set(aqmj.bm(paramQQAppInterface.getApp(), mCurUin));
      break label1609;
      i = aqmj.bo(paramQQAppInterface.getApp(), mCurUin);
      if (aqmj.bp(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.getAppId()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1609;
      i = aywy.a().bJ(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = ayzr.a().bK(paramQQAppInterface.getApp());
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localObject5 = (pmb)paramQQAppInterface.getManager(181);
      localConfigSeq.version.set(((pmb)localObject5).a.k(paramQQAppInterface.getApp(), mCurUin));
      localConfigSeq.compress.set(1);
      break label1609;
      localConfigSeq.version.set(aqmj.Md());
      localConfigSeq.compress.set(1);
      break label1609;
      i = aqmj.br(paramQQAppInterface.getApp(), mCurUin);
      if (aqmj.bs(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.getAppId()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1609;
      localConfigSeq.version.set(aqmj.aA(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()));
      localConfigSeq.compress.set(1);
      break label1609;
      i = aqmj.i(paramQQAppInterface.getApp(), "wifi_connect_config_version", mCurUin);
      localConfigSeq.version.set(i);
      break label1609;
      localObject5 = (TroopManager)paramQQAppInterface.getManager(52);
      localConfigSeq.version.set(((TroopManager)localObject5).jdField_a_of_type_Smw.k(paramQQAppInterface.getApp(), mCurUin));
      localConfigSeq.compress.set(1);
      break label1609;
      i = aqmj.bA(paramQQAppInterface.getApp(), mCurUin);
      localConfigSeq.version.set(i);
      break label1609;
      localConfigSeq.version.set(aqmj.bi(paramQQAppInterface.getApp(), mCurUin));
      localConfigSeq.compress.set(1);
      break label1609;
      i = aqmj.bD(paramQQAppInterface.getApp(), mCurUin);
      if (aqmj.bE(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount()) != AppSetting.getAppId()) {
        i = 0;
      }
      localConfigSeq.version.set(i);
      break label1609;
      i = aqij.lA();
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break label1609;
      }
      QLog.i("JumpForwardPkgManager", 2, "JUMP_PKG_TOAST_CONFIG  ,version:" + i);
      break label1609;
      i = awis.t(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      i = yhf.t(paramQQAppInterface);
      localConfigSeq.version.set(i);
      localConfigSeq.compress.set(1);
      break label1609;
      localConfigSeq.version.set(((Integer)aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "config_tim_team_version_code", Integer.valueOf(0))).intValue());
      break label1609;
      Object localObject6;
      if (QLog.isColorLevel())
      {
        i = localArrayList2.size();
        localObject6 = localArrayList2.iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (Integer)((Iterator)localObject6).next();
          QLog.d("SPLASH_ConfigServlet", 2, "addAllConfigs|send type: " + localObject7 + ",length: " + i);
        }
      }
      k = localArrayList2.size();
      i = 0;
      if (i < localArrayList1.size()) {
        if (i >= localArrayList2.size()) {
          break label9533;
        }
      }
      label9518:
      label9533:
      for (j = ((Integer)localArrayList2.get(i)).intValue();; j = -1)
      {
        localObject6 = (ConfigurationService.ConfigSeq)localArrayList1.get(i);
        if (localObject6 != null)
        {
          j = ((ConfigurationService.ConfigSeq)localObject6).type.get();
          m = ((ConfigurationService.ConfigSeq)localObject6).version.get();
          n = ((ConfigurationService.ConfigSeq)localObject6).compress.get();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("sendConfigRequest | type = " + j);
          ((StringBuilder)localObject6).append(" | version: " + m);
          ((StringBuilder)localObject6).append(" | compress: " + n);
          ((StringBuilder)localObject6).append(" | length: " + k);
          Hx(((StringBuilder)localObject6).toString());
        }
        for (;;)
        {
          i += 1;
          break;
          Hx("sendConfigRequest configSeq is null type: " + j + " | length: " + k);
        }
        localObject6 = new ConfigurationService.DeviceInfo();
        if ((localArrayList2.contains(Integer.valueOf(1))) || (localArrayList2.contains(Integer.valueOf(2))) || (localArrayList2.contains(Integer.valueOf(3))) || (localArrayList2.contains(Integer.valueOf(12))))
        {
          localObject7 = new ConfigurationService.Screen();
          ((ConfigurationService.Screen)localObject7).setHasFlag(true);
          ((ConfigurationService.Screen)localObject7).width.set((int)aqgz.hK());
          ((ConfigurationService.Screen)localObject7).height.set((int)aqgz.hL());
          ((ConfigurationService.DeviceInfo)localObject6).screen = ((ConfigurationService.Screen)localObject7);
          ((ConfigurationService.DeviceInfo)localObject6).setHasFlag(true);
          ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject6);
        }
        if ((localArrayList2.contains(Integer.valueOf(47))) || (localArrayList2.contains(Integer.valueOf(65))) || (localArrayList2.contains(Integer.valueOf(156))) || (localArrayList2.contains(Integer.valueOf(297))))
        {
          localObject7 = new ConfigurationService.OS();
          ((ConfigurationService.OS)localObject7).setHasFlag(true);
          ((ConfigurationService.OS)localObject7).type.set(2);
          ((ConfigurationService.OS)localObject7).kernel.set(aqgz.getKernelVersion());
          ((ConfigurationService.OS)localObject7).sdk.set(String.valueOf(aqgz.getOsVersion()));
          ((ConfigurationService.OS)localObject7).version.set(aqgz.getDeviceOSVersion());
          ((ConfigurationService.OS)localObject7).rom.set(aqgz.getRomInfo());
          ((ConfigurationService.DeviceInfo)localObject6).brand.set(aqgz.BY());
          ((ConfigurationService.DeviceInfo)localObject6).model.set(aqgz.getDeviceModel());
          if (QLog.isDevelopLevel()) {
            QLog.w("SPLASH_ConfigServlet", 1, "addAllConfigs, brand[" + ((ConfigurationService.DeviceInfo)localObject6).brand.get() + "], model[" + ((ConfigurationService.DeviceInfo)localObject6).model.get() + "]");
          }
          ((ConfigurationService.DeviceInfo)localObject6).os = ((ConfigurationService.OS)localObject7);
          ((ConfigurationService.DeviceInfo)localObject6).setHasFlag(true);
          ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject6);
        }
        ((ConfigurationService.ReqGetConfig)localObject1).setHasFlag(true);
        ((ConfigurationService.ReqGetConfig)localObject1).seq_list.addAll(localArrayList1);
        if (paramIntent != null)
        {
          bool = paramIntent.getBooleanExtra("key_is_page_req", false);
          localObject6 = ((ConfigurationService.ReqGetConfig)localObject1).is_page_req;
          if (!bool) {
            break label9518;
          }
        }
        for (i = 1;; i = 0)
        {
          ((PBInt32Field)localObject6).set(i);
          localObject6 = paramIntent.getByteArrayExtra("key_cookies");
          if (localObject6 != null) {
            ((ConfigurationService.ReqGetConfig)localObject1).cookies.set(ByteStringMicro.copyFrom((byte[])localObject6));
          }
          localObject1 = a((ConfigurationService.ReqGetConfig)localObject1);
          if ((localObject1 != null) && (localObject1.length > 0)) {
            paramPacket.putSendData((byte[])localObject1);
          }
          if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 1) || (paramArrayOfInt[0] != 215) || (paramQQAppInterface.isLogin())) {
            break;
          }
          paramPacket.setSSOCommand("ConfigurationService.ReqGetConfigNoLogin");
          paramIntent.putExtra("k_cmd_name", "ConfigurationService.ReqGetConfigNoLogin");
          return;
        }
        paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
        return;
      }
      break label3474;
      label9542:
      i = 1;
      break;
      label9548:
      i = 1;
    }
  }
  
  /* Error */
  private void a(ConfigurationService.ReqGetConfig paramReqGetConfig, ConfigurationService.ConfigSeq paramConfigSeq, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   7: invokestatic 2576	aqmj:aS	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: invokestatic 204	com/tencent/common/config/AppSetting:getAppId	()I
    //   13: if_icmpeq +114 -> 127
    //   16: aload_3
    //   17: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   23: invokestatic 204	com/tencent/common/config/AppSetting:getAppId	()I
    //   26: invokestatic 2578	aqmj:al	(Landroid/content/Context;Ljava/lang/String;I)V
    //   29: aload_3
    //   30: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 2580	aqmj:am	(Landroid/content/Context;Ljava/lang/String;I)V
    //   40: iconst_0
    //   41: istore 4
    //   43: aload_2
    //   44: getfield 1564	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ConfigSeq:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   47: iload 4
    //   49: invokevirtual 1531	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   52: invokestatic 2583	aqgz:dZ	()Ljava/util/ArrayList;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +119 -> 178
    //   62: aload 5
    //   64: invokevirtual 2584	java/util/ArrayList:size	()I
    //   67: ifle +111 -> 178
    //   70: aload 5
    //   72: invokevirtual 2585	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   75: astore_2
    //   76: aload_2
    //   77: invokeinterface 402 1 0
    //   82: ifeq +96 -> 178
    //   85: aload_2
    //   86: invokeinterface 406 1 0
    //   91: checkcast 208	java/lang/Integer
    //   94: astore 6
    //   96: aload_1
    //   97: getfield 2588	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:carriers	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   100: aload 6
    //   102: invokevirtual 2591	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +14 -> 126
    //   115: ldc_w 2593
    //   118: iconst_2
    //   119: ldc_w 2595
    //   122: aload_1
    //   123: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: return
    //   127: aload_3
    //   128: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   134: invokestatic 2597	aqmj:aT	(Landroid/content/Context;Ljava/lang/String;)I
    //   137: istore 4
    //   139: goto -96 -> 43
    //   142: astore_2
    //   143: ldc 169
    //   145: iconst_2
    //   146: new 68	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2599
    //   156: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 365	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: astore 5
    //   175: goto -118 -> 57
    //   178: aload_3
    //   179: bipush 11
    //   181: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   184: checkcast 2601	ajdo
    //   187: invokeinterface 2604 1 0
    //   192: astore 6
    //   194: aload 6
    //   196: ifnull +229 -> 425
    //   199: aload 6
    //   201: getfield 2609	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   204: astore_3
    //   205: aload_3
    //   206: astore_2
    //   207: aload_3
    //   208: ifnull +21 -> 229
    //   211: aload_3
    //   212: astore_2
    //   213: aload_3
    //   214: ldc_w 2611
    //   217: invokevirtual 2614	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   220: ifeq +9 -> 229
    //   223: aload_3
    //   224: iconst_1
    //   225: invokevirtual 2616	java/lang/String:substring	(I)Ljava/lang/String;
    //   228: astore_2
    //   229: aload_2
    //   230: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +130 -> 363
    //   236: aload 6
    //   238: getfield 2619	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   241: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +119 -> 363
    //   247: ldc 18
    //   249: astore_2
    //   250: aload_2
    //   251: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +11 -> 265
    //   257: aload_1
    //   258: getfield 2622	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$ReqGetConfig:bind_phone_no	Lcom/tencent/mobileqq/pb/PBStringField;
    //   261: aload_2
    //   262: invokevirtual 1653	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   265: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -142 -> 126
    //   271: new 68	java/lang/StringBuilder
    //   274: dup
    //   275: bipush 100
    //   277: invokespecial 2623	java/lang/StringBuilder:<init>	(I)V
    //   280: astore_1
    //   281: aload_1
    //   282: ldc_w 2625
    //   285: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload 4
    //   290: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 2627
    //   296: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_2
    //   300: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: ldc_w 2629
    //   308: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 5
    //   314: ifnull +91 -> 405
    //   317: aload 5
    //   319: invokevirtual 2584	java/util/ArrayList:size	()I
    //   322: ifle +83 -> 405
    //   325: aload 5
    //   327: invokevirtual 2585	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 402 1 0
    //   337: ifeq +68 -> 405
    //   340: aload_1
    //   341: aload_2
    //   342: invokeinterface 406 1 0
    //   347: checkcast 208	java/lang/Integer
    //   350: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: ldc_w 2631
    //   356: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: goto -29 -> 331
    //   363: invokestatic 323	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   366: astore 7
    //   368: aload_2
    //   369: astore_3
    //   370: aload_2
    //   371: ifnonnull +6 -> 377
    //   374: ldc 18
    //   376: astore_3
    //   377: aload 7
    //   379: ldc_w 2633
    //   382: iconst_2
    //   383: anewarray 178	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload_3
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: aload 6
    //   394: getfield 2619	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   397: aastore
    //   398: invokestatic 328	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   401: astore_2
    //   402: goto -152 -> 250
    //   405: aload_1
    //   406: ldc_w 1331
    //   409: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc_w 2593
    //   416: iconst_2
    //   417: aload_1
    //   418: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: return
    //   425: ldc 18
    //   427: astore_2
    //   428: goto -178 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	aevk
    //   0	431	1	paramReqGetConfig	ConfigurationService.ReqGetConfig
    //   0	431	2	paramConfigSeq	ConfigurationService.ConfigSeq
    //   0	431	3	paramQQAppInterface	QQAppInterface
    //   41	248	4	i	int
    //   55	271	5	localArrayList	ArrayList
    //   94	299	6	localObject	Object
    //   366	12	7	localLocale	Locale
    // Exception table:
    //   from	to	target	type
    //   0	40	108	java/lang/Exception
    //   43	52	108	java/lang/Exception
    //   52	57	108	java/lang/Exception
    //   62	76	108	java/lang/Exception
    //   76	105	108	java/lang/Exception
    //   127	139	108	java/lang/Exception
    //   143	172	108	java/lang/Exception
    //   178	194	108	java/lang/Exception
    //   199	205	108	java/lang/Exception
    //   213	229	108	java/lang/Exception
    //   229	247	108	java/lang/Exception
    //   250	265	108	java/lang/Exception
    //   265	312	108	java/lang/Exception
    //   317	331	108	java/lang/Exception
    //   331	360	108	java/lang/Exception
    //   363	368	108	java/lang/Exception
    //   377	402	108	java/lang/Exception
    //   405	424	108	java/lang/Exception
    //   52	57	142	java/lang/Throwable
  }
  
  /* Error */
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, QQAppInterface paramQQAppInterface, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload 5
    //   2: ifeq +30 -> 32
    //   5: aload_1
    //   6: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   12: ifne +20 -> 32
    //   15: aload_1
    //   16: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   19: ifnull +13 -> 32
    //   22: aload_1
    //   23: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   26: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   29: ifne +2015 -> 2044
    //   32: iload 5
    //   34: ifne +450 -> 484
    //   37: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +12 -> 52
    //   43: ldc 169
    //   45: iconst_2
    //   46: ldc_w 2644
    //   49: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: iconst_0
    //   53: istore 7
    //   55: iload 7
    //   57: aload 4
    //   59: arraylength
    //   60: if_icmpge +12326 -> 12386
    //   63: aload 4
    //   65: iload 7
    //   67: iaload
    //   68: istore 9
    //   70: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +30 -> 103
    //   76: ldc 169
    //   78: iconst_2
    //   79: new 68	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 2646
    //   89: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload 9
    //   94: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: new 68	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 2648
    //   113: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload 9
    //   118: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 2434	aevk:Hx	(Ljava/lang/String;)V
    //   127: iload 9
    //   129: lookupswitch	default:+259->388, 46:+518->647, 69:+581->710, 86:+998->1127, 87:+820->949, 88:+663->792, 113:+1207->1336, 116:+429->558, 119:+1184->1313, 140:+1355->1484, 149:+418->547, 156:+346->475, 165:+1544->1673, 174:+1621->1750, 180:+418->547, 185:+1712->1841, 188:+1265->1394, 202:+1766->1895, 206:+1310->1439, 210:+1812->1941, 215:+1868->1997, 218:+418->547, 223:+1249->1378, 231:+1881->2010, 257:+1454->1583, 260:+1499->1628, 273:+1666->1795, 283:+575->704, 321:+1721->1850, 364:+1249->1378, 365:+1249->1378, 604:+1589->1718
    //   389: istore 8
    //   391: iload 8
    //   393: istore 6
    //   395: invokestatic 1534	aeif:a	()Laeif;
    //   398: iload 9
    //   400: invokevirtual 1537	aeif:jg	(I)Z
    //   403: ifeq +48 -> 451
    //   406: invokestatic 1534	aeif:a	()Laeif;
    //   409: iload 9
    //   411: invokevirtual 1540	aeif:a	(I)Laehv;
    //   414: astore_3
    //   415: iload 8
    //   417: istore 6
    //   419: aload_3
    //   420: ifnull +31 -> 451
    //   423: aload_1
    //   424: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   427: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   430: ifeq +1597 -> 2027
    //   433: bipush 254
    //   435: istore 6
    //   437: iload 6
    //   439: ifeq +9 -> 448
    //   442: aload_3
    //   443: iload 6
    //   445: invokevirtual 2651	aehv:onReqFailed	(I)V
    //   448: iconst_1
    //   449: istore 6
    //   451: iload 6
    //   453: ifne +22 -> 475
    //   456: aload_2
    //   457: invokevirtual 1572	com/tencent/mobileqq/app/QQAppInterface:a	()Laehn;
    //   460: aload_2
    //   461: iload 9
    //   463: iload 5
    //   465: aload_1
    //   466: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   469: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   472: invokevirtual 2654	aehn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IZI)V
    //   475: iload 7
    //   477: iconst_1
    //   478: iadd
    //   479: istore 7
    //   481: goto -426 -> 55
    //   484: aload_1
    //   485: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   488: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   491: ifeq +21 -> 512
    //   494: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq -445 -> 52
    //   500: ldc 169
    //   502: iconst_2
    //   503: ldc_w 2656
    //   506: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: goto -457 -> 52
    //   512: aload_1
    //   513: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   516: ifnull +13 -> 529
    //   519: aload_1
    //   520: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   523: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   526: ifne -474 -> 52
    //   529: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq -480 -> 52
    //   535: ldc 169
    //   537: iconst_2
    //   538: ldc_w 2658
    //   541: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: goto -492 -> 52
    //   547: iload 9
    //   549: iload 5
    //   551: aload_1
    //   552: invokestatic 2661	igo:a	(IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   555: goto -80 -> 475
    //   558: iload 5
    //   560: ifeq +13 -> 573
    //   563: aload_1
    //   564: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   567: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   570: ifeq -95 -> 475
    //   573: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq +12 -> 588
    //   579: ldc 169
    //   581: iconst_2
    //   582: ldc_w 2663
    //   585: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: aload_0
    //   589: getfield 2665	aevk:hasReport	Z
    //   592: ifne +35 -> 627
    //   595: aload_2
    //   596: ldc_w 2667
    //   599: ldc 18
    //   601: ldc 18
    //   603: ldc_w 2669
    //   606: ldc_w 2669
    //   609: iconst_0
    //   610: iconst_0
    //   611: ldc 18
    //   613: ldc 18
    //   615: ldc 18
    //   617: ldc 18
    //   619: invokestatic 2674	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   622: aload_0
    //   623: iconst_1
    //   624: putfield 2665	aevk:hasReport	Z
    //   627: aload_2
    //   628: iconst_4
    //   629: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   632: checkcast 2042	accy
    //   635: invokestatic 2679	aqap:a	()Laqap;
    //   638: invokevirtual 2682	aqap:b	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   641: invokevirtual 2685	accy:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   644: goto -169 -> 475
    //   647: aload_1
    //   648: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   651: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   654: ifeq +26 -> 680
    //   657: getstatic 2689	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   660: aload_2
    //   661: invokevirtual 1851	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   664: ldc_w 2691
    //   667: bipush 101
    //   669: ldc 18
    //   671: invokestatic 2697	com/tencent/mobileqq/msf/core/net/patch/PatchReporter:reportPatchEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   674: invokestatic 2702	swu:bBB	()V
    //   677: goto -202 -> 475
    //   680: aload_1
    //   681: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   684: ifnull +13 -> 697
    //   687: aload_1
    //   688: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   691: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   694: ifne -20 -> 674
    //   697: aload_2
    //   698: invokestatic 2706	tnj:aE	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   701: goto -27 -> 674
    //   704: invokestatic 2702	swu:bBB	()V
    //   707: goto -232 -> 475
    //   710: iload 5
    //   712: ifeq +13 -> 725
    //   715: aload_1
    //   716: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   719: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   722: ifeq -247 -> 475
    //   725: aload_2
    //   726: bipush 125
    //   728: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   731: checkcast 2708	zxj
    //   734: astore_3
    //   735: aload_3
    //   736: iconst_1
    //   737: putfield 2711	zxj:bur	Z
    //   740: aload_3
    //   741: getstatic 2716	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_SWITCH_DEFAULT	Z
    //   744: putfield 2719	zxj:bus	Z
    //   747: aload_3
    //   748: getstatic 2722	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT	I
    //   751: putfield 2725	zxj:cfu	I
    //   754: aload_3
    //   755: getstatic 2728	com/tencent/mobileqq/data/MessageForFoldMsgGrayTips:PASSWD_REDBAG_MSG_INDEX_WITH_ID	Z
    //   758: putfield 2731	zxj:buu	Z
    //   761: aload_2
    //   762: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   765: aload_2
    //   766: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   769: iconst_0
    //   770: aload_3
    //   771: getfield 2719	zxj:bus	Z
    //   774: aload_3
    //   775: getfield 2725	zxj:cfu	I
    //   778: aload_3
    //   779: getfield 2734	zxj:but	Z
    //   782: aload_3
    //   783: getfield 2731	zxj:buu	Z
    //   786: invokestatic 2737	aqmj:a	(Landroid/content/Context;Ljava/lang/String;IZIZZ)V
    //   789: goto -314 -> 475
    //   792: iload 5
    //   794: ifne +51 -> 845
    //   797: aload_2
    //   798: bipush 88
    //   800: iconst_0
    //   801: iconst_0
    //   802: iconst_1
    //   803: iconst_1
    //   804: iconst_0
    //   805: invokestatic 1485	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   808: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   811: ifeq -336 -> 475
    //   814: ldc_w 1476
    //   817: iconst_2
    //   818: new 68	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   825: ldc_w 2739
    //   828: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: iload 5
    //   833: invokevirtual 692	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   836: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   839: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: goto -367 -> 475
    //   845: aload_1
    //   846: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   849: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   852: ifeq +61 -> 913
    //   855: aload_1
    //   856: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   859: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   862: istore 6
    //   864: aload_2
    //   865: bipush 88
    //   867: iconst_0
    //   868: iconst_0
    //   869: iconst_1
    //   870: iload 6
    //   872: iconst_0
    //   873: invokestatic 1485	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   876: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   879: ifeq -404 -> 475
    //   882: ldc_w 1476
    //   885: iconst_2
    //   886: new 68	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   893: ldc_w 2741
    //   896: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: iload 6
    //   901: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   904: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: goto -435 -> 475
    //   913: aload_1
    //   914: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   917: ifnull +13 -> 930
    //   920: aload_1
    //   921: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   924: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   927: ifne -452 -> 475
    //   930: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   933: ifeq -458 -> 475
    //   936: ldc_w 1476
    //   939: iconst_2
    //   940: ldc_w 2743
    //   943: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: goto -471 -> 475
    //   949: iload 5
    //   951: ifne +72 -> 1023
    //   954: aload_2
    //   955: bipush 87
    //   957: iconst_0
    //   958: iconst_0
    //   959: iconst_1
    //   960: iconst_1
    //   961: iconst_0
    //   962: invokestatic 1485	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   965: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   968: ifeq +31 -> 999
    //   971: ldc_w 1476
    //   974: iconst_2
    //   975: new 68	java/lang/StringBuilder
    //   978: dup
    //   979: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   982: ldc_w 2745
    //   985: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: iload 5
    //   990: invokevirtual 692	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   993: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   999: aload_2
    //   1000: sipush 168
    //   1003: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1006: checkcast 1480	adex
    //   1009: astore_3
    //   1010: aload_3
    //   1011: ifnull -536 -> 475
    //   1014: aload_3
    //   1015: iconst_1
    //   1016: iconst_0
    //   1017: invokevirtual 2749	adex:bN	(ZZ)V
    //   1020: goto -545 -> 475
    //   1023: aload_1
    //   1024: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1027: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1030: ifeq +61 -> 1091
    //   1033: aload_1
    //   1034: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1037: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1040: istore 6
    //   1042: aload_2
    //   1043: bipush 87
    //   1045: iconst_0
    //   1046: iconst_0
    //   1047: iconst_1
    //   1048: iload 6
    //   1050: iconst_0
    //   1051: invokestatic 1485	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1054: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1057: ifeq -58 -> 999
    //   1060: ldc_w 1476
    //   1063: iconst_2
    //   1064: new 68	java/lang/StringBuilder
    //   1067: dup
    //   1068: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1071: ldc_w 2751
    //   1074: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: iload 6
    //   1079: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1082: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1085: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1088: goto -89 -> 999
    //   1091: aload_1
    //   1092: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1095: ifnull +13 -> 1108
    //   1098: aload_1
    //   1099: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1102: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1105: ifne -106 -> 999
    //   1108: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1111: ifeq -112 -> 999
    //   1114: ldc_w 1476
    //   1117: iconst_2
    //   1118: ldc_w 2753
    //   1121: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1124: goto -125 -> 999
    //   1127: iload 5
    //   1129: ifne +77 -> 1206
    //   1132: aload_0
    //   1133: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1136: bipush 86
    //   1138: iconst_0
    //   1139: iconst_0
    //   1140: iconst_1
    //   1141: iconst_1
    //   1142: iconst_0
    //   1143: invokestatic 1485	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1146: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1149: ifeq +31 -> 1180
    //   1152: ldc_w 1920
    //   1155: iconst_2
    //   1156: new 68	java/lang/StringBuilder
    //   1159: dup
    //   1160: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1163: ldc_w 2755
    //   1166: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: iload 5
    //   1171: invokevirtual 692	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1174: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1177: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1180: aload_2
    //   1181: sipush 167
    //   1184: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1187: checkcast 1895	com/tencent/mobileqq/olympic/OlympicManager
    //   1190: astore_3
    //   1191: aload_3
    //   1192: ifnull -717 -> 475
    //   1195: aload_3
    //   1196: invokevirtual 2758	com/tencent/mobileqq/olympic/OlympicManager:dCN	()V
    //   1199: aload_3
    //   1200: invokevirtual 2761	com/tencent/mobileqq/olympic/OlympicManager:dCO	()V
    //   1203: goto -728 -> 475
    //   1206: aload_1
    //   1207: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1210: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1213: ifeq +64 -> 1277
    //   1216: aload_1
    //   1217: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1220: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1223: istore 6
    //   1225: aload_0
    //   1226: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1229: bipush 86
    //   1231: iconst_0
    //   1232: iconst_0
    //   1233: iconst_1
    //   1234: iload 6
    //   1236: iconst_0
    //   1237: invokestatic 1485	com/tencent/mobileqq/olympic/OlympicServlet:a	(Lmqq/app/AppRuntime;IIIIII)V
    //   1240: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1243: ifeq -63 -> 1180
    //   1246: ldc_w 1920
    //   1249: iconst_2
    //   1250: new 68	java/lang/StringBuilder
    //   1253: dup
    //   1254: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1257: ldc_w 2763
    //   1260: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: iload 6
    //   1265: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1268: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1274: goto -94 -> 1180
    //   1277: aload_1
    //   1278: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1281: ifnull +13 -> 1294
    //   1284: aload_1
    //   1285: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1288: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1291: ifne -111 -> 1180
    //   1294: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1297: ifeq -117 -> 1180
    //   1300: ldc_w 1920
    //   1303: iconst_2
    //   1304: ldc_w 2765
    //   1307: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1310: goto -130 -> 1180
    //   1313: aload_2
    //   1314: bipush 53
    //   1316: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   1319: checkcast 2064	acbs
    //   1322: astore_3
    //   1323: aload_3
    //   1324: ifnull -849 -> 475
    //   1327: aload_3
    //   1328: iconst_0
    //   1329: iconst_0
    //   1330: invokevirtual 2767	acbs:bs	(ZZ)V
    //   1333: goto -858 -> 475
    //   1336: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1339: ifeq +12 -> 1351
    //   1342: ldc 169
    //   1344: iconst_2
    //   1345: ldc_w 2769
    //   1348: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1351: aload_2
    //   1352: sipush 179
    //   1355: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1358: checkcast 2771	alaj
    //   1361: astore_3
    //   1362: aload_3
    //   1363: ifnull -888 -> 475
    //   1366: aload_3
    //   1367: invokevirtual 2774	alaj:startDownload	()V
    //   1370: aload_3
    //   1371: iconst_0
    //   1372: invokevirtual 2777	alaj:Nz	(Z)V
    //   1375: goto -900 -> 475
    //   1378: aload_2
    //   1379: invokestatic 1766	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   1382: aload_2
    //   1383: iload 9
    //   1385: iload 5
    //   1387: aload_1
    //   1388: invokevirtual 2781	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_Fail	(Lcom/tencent/mobileqq/app/QQAppInterface;IZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;)V
    //   1391: goto -916 -> 475
    //   1394: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1397: ifeq -922 -> 475
    //   1400: aload_1
    //   1401: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1404: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1407: istore 6
    //   1409: ldc 169
    //   1411: iconst_2
    //   1412: new 68	java/lang/StringBuilder
    //   1415: dup
    //   1416: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1419: ldc_w 2783
    //   1422: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: iload 6
    //   1427: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1436: goto -961 -> 475
    //   1439: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1442: ifeq -967 -> 475
    //   1445: aload_1
    //   1446: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1449: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1452: istore 6
    //   1454: ldc 169
    //   1456: iconst_2
    //   1457: new 68	java/lang/StringBuilder
    //   1460: dup
    //   1461: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1464: ldc_w 2785
    //   1467: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: iload 6
    //   1472: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1475: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1478: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1481: goto -1006 -> 475
    //   1484: aload_1
    //   1485: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1488: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1491: istore 6
    //   1493: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1496: ifeq +30 -> 1526
    //   1499: ldc 169
    //   1501: iconst_2
    //   1502: new 68	java/lang/StringBuilder
    //   1505: dup
    //   1506: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1509: ldc_w 2787
    //   1512: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: iload 6
    //   1517: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1520: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1526: new 2789	java/util/HashMap
    //   1529: dup
    //   1530: invokespecial 2790	java/util/HashMap:<init>	()V
    //   1533: astore_3
    //   1534: aload_3
    //   1535: ldc_w 2792
    //   1538: new 68	java/lang/StringBuilder
    //   1541: dup
    //   1542: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1545: iload 6
    //   1547: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1550: ldc 18
    //   1552: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1558: invokevirtual 2795	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1561: pop
    //   1562: invokestatic 1066	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1565: invokestatic 1927	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1568: aconst_null
    //   1569: ldc_w 2797
    //   1572: iconst_0
    //   1573: lconst_0
    //   1574: lconst_0
    //   1575: aload_3
    //   1576: aconst_null
    //   1577: invokevirtual 2800	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1580: goto -1105 -> 475
    //   1583: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1586: ifeq -1111 -> 475
    //   1589: aload_1
    //   1590: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1593: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1596: istore 6
    //   1598: ldc 169
    //   1600: iconst_2
    //   1601: invokestatic 323	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1604: ldc_w 2802
    //   1607: iconst_1
    //   1608: anewarray 178	java/lang/Object
    //   1611: dup
    //   1612: iconst_0
    //   1613: iload 6
    //   1615: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1618: aastore
    //   1619: invokestatic 328	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1622: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1625: goto -1150 -> 475
    //   1628: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1631: ifeq -1156 -> 475
    //   1634: aload_1
    //   1635: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1638: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1641: istore 6
    //   1643: ldc 169
    //   1645: iconst_2
    //   1646: invokestatic 323	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1649: ldc_w 2804
    //   1652: iconst_1
    //   1653: anewarray 178	java/lang/Object
    //   1656: dup
    //   1657: iconst_0
    //   1658: iload 6
    //   1660: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1663: aastore
    //   1664: invokestatic 328	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1667: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1670: goto -1195 -> 475
    //   1673: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1676: ifeq -1201 -> 475
    //   1679: aload_1
    //   1680: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1683: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1686: istore 6
    //   1688: ldc 169
    //   1690: iconst_2
    //   1691: new 68	java/lang/StringBuilder
    //   1694: dup
    //   1695: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1698: ldc_w 2806
    //   1701: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: iload 6
    //   1706: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1709: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1712: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1715: goto -1240 -> 475
    //   1718: ldc 169
    //   1720: iconst_1
    //   1721: iconst_2
    //   1722: anewarray 178	java/lang/Object
    //   1725: dup
    //   1726: iconst_0
    //   1727: ldc_w 2808
    //   1730: aastore
    //   1731: dup
    //   1732: iconst_1
    //   1733: aload_1
    //   1734: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1737: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1740: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1743: aastore
    //   1744: invokestatic 2810	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1747: goto -1272 -> 475
    //   1750: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1753: ifeq -1278 -> 475
    //   1756: aload_1
    //   1757: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1760: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1763: istore 6
    //   1765: ldc 169
    //   1767: iconst_2
    //   1768: new 68	java/lang/StringBuilder
    //   1771: dup
    //   1772: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1775: ldc_w 2812
    //   1778: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: iload 6
    //   1783: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1786: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1789: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1792: goto -1317 -> 475
    //   1795: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1798: ifeq -1323 -> 475
    //   1801: aload_1
    //   1802: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1805: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1808: istore 6
    //   1810: ldc_w 2814
    //   1813: iconst_2
    //   1814: new 68	java/lang/StringBuilder
    //   1817: dup
    //   1818: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1821: ldc_w 2816
    //   1824: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: iload 6
    //   1829: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1832: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1835: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1838: goto -1363 -> 475
    //   1841: invokestatic 2819	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   1844: invokevirtual 2822	com/tencent/mobileqq/scribble/ScribbleResMgr:dNW	()V
    //   1847: goto -1372 -> 475
    //   1850: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1853: ifeq -1378 -> 475
    //   1856: aload_1
    //   1857: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1860: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1863: istore 6
    //   1865: ldc 169
    //   1867: iconst_2
    //   1868: new 68	java/lang/StringBuilder
    //   1871: dup
    //   1872: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1875: ldc_w 2824
    //   1878: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: iload 6
    //   1883: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1886: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1889: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1892: goto -1417 -> 475
    //   1895: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1898: ifeq -1423 -> 475
    //   1901: aload_1
    //   1902: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1905: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1908: istore 6
    //   1910: ldc_w 2593
    //   1913: iconst_2
    //   1914: new 68	java/lang/StringBuilder
    //   1917: dup
    //   1918: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1921: ldc_w 2826
    //   1924: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1927: iload 6
    //   1929: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1932: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1935: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1938: goto -1463 -> 475
    //   1941: aload_2
    //   1942: sipush 228
    //   1945: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1948: checkcast 1034	aklr
    //   1951: astore_3
    //   1952: aload_1
    //   1953: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1956: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1959: istore 6
    //   1961: ldc 169
    //   1963: iconst_1
    //   1964: new 68	java/lang/StringBuilder
    //   1967: dup
    //   1968: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1971: ldc_w 2828
    //   1974: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: iload 6
    //   1979: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1982: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1985: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1988: aload_3
    //   1989: iconst_0
    //   1990: aconst_null
    //   1991: invokevirtual 1055	aklr:a	(ZLcom/tencent/mobileqq/ocr/data/OcrConfig;)V
    //   1994: goto -1519 -> 475
    //   1997: aload_1
    //   1998: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2001: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2004: invokestatic 2831	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:UM	(I)V
    //   2007: goto -1532 -> 475
    //   2010: aload_2
    //   2011: sipush 231
    //   2014: aload_1
    //   2015: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2018: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2021: invokestatic 2834	aaug:c	(Lcom/tencent/mobileqq/app/QQAppInterface;II)V
    //   2024: goto -1549 -> 475
    //   2027: iload 5
    //   2029: ifne +9 -> 2038
    //   2032: iconst_m1
    //   2033: istore 6
    //   2035: goto -1598 -> 437
    //   2038: iconst_0
    //   2039: istore 6
    //   2041: goto -1604 -> 437
    //   2044: invokestatic 2837	java/lang/System:currentTimeMillis	()J
    //   2047: lstore 13
    //   2049: aload_1
    //   2050: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2053: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2056: istore 9
    //   2058: new 1352	java/util/ArrayList
    //   2061: dup
    //   2062: aload 4
    //   2064: arraylength
    //   2065: invokespecial 1383	java/util/ArrayList:<init>	(I)V
    //   2068: astore 19
    //   2070: iconst_0
    //   2071: istore 6
    //   2073: iload 6
    //   2075: aload 4
    //   2077: arraylength
    //   2078: if_icmpge +28 -> 2106
    //   2081: aload 19
    //   2083: aload 4
    //   2085: iload 6
    //   2087: iaload
    //   2088: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2091: invokeinterface 1363 2 0
    //   2096: pop
    //   2097: iload 6
    //   2099: iconst_1
    //   2100: iadd
    //   2101: istore 6
    //   2103: goto -30 -> 2073
    //   2106: aconst_null
    //   2107: astore 4
    //   2109: iconst_0
    //   2110: istore 11
    //   2112: iconst_0
    //   2113: istore 6
    //   2115: iload 6
    //   2117: iload 9
    //   2119: if_icmpge +8522 -> 10641
    //   2122: aload_1
    //   2123: getfield 2642	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:config_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2126: iload 6
    //   2128: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2131: checkcast 77	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config
    //   2134: astore 20
    //   2136: aload 20
    //   2138: ifnonnull +28 -> 2166
    //   2141: iload 11
    //   2143: istore 12
    //   2145: aload 4
    //   2147: astore 17
    //   2149: iload 6
    //   2151: iconst_1
    //   2152: iadd
    //   2153: istore 6
    //   2155: aload 17
    //   2157: astore 4
    //   2159: iload 12
    //   2161: istore 11
    //   2163: goto -48 -> 2115
    //   2166: aload 4
    //   2168: astore 17
    //   2170: iload 11
    //   2172: istore 12
    //   2174: aload 20
    //   2176: getfield 81	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2179: invokevirtual 2838	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   2182: ifeq -33 -> 2149
    //   2185: new 208	java/lang/Integer
    //   2188: dup
    //   2189: aload 20
    //   2191: getfield 81	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2194: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2197: invokespecial 2839	java/lang/Integer:<init>	(I)V
    //   2200: astore 18
    //   2202: aload 19
    //   2204: aload 18
    //   2206: invokeinterface 2841 2 0
    //   2211: pop
    //   2212: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2215: ifeq +41 -> 2256
    //   2218: ldc 169
    //   2220: iconst_2
    //   2221: new 68	java/lang/StringBuilder
    //   2224: dup
    //   2225: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2228: ldc_w 2843
    //   2231: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: aload 18
    //   2236: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2239: ldc_w 2845
    //   2242: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2245: iload 9
    //   2247: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2250: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2253: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2256: aload 20
    //   2258: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2261: ifnull +350 -> 2611
    //   2264: aload 20
    //   2266: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2269: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2272: ifle +339 -> 2611
    //   2275: iconst_0
    //   2276: istore 7
    //   2278: iload 7
    //   2280: aload 20
    //   2282: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2285: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2288: if_icmpge +540 -> 2828
    //   2291: aload 20
    //   2293: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2296: iconst_0
    //   2297: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2300: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   2303: astore 21
    //   2305: ldc 18
    //   2307: astore 17
    //   2309: aload 21
    //   2311: getfield 334	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2314: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2317: iconst_1
    //   2318: if_icmpne +277 -> 2595
    //   2321: aload 21
    //   2323: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2326: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2329: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2332: invokestatic 357	akrf:inflateConfigString	([B)[B
    //   2335: astore 22
    //   2337: aload 22
    //   2339: ifnull +17 -> 2356
    //   2342: new 115	java/lang/String
    //   2345: dup
    //   2346: aload 22
    //   2348: ldc_w 359
    //   2351: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2354: astore 17
    //   2356: aload 20
    //   2358: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2361: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2364: istore 8
    //   2366: aload 21
    //   2368: getfield 1495	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2371: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2374: istore 10
    //   2376: new 68	java/lang/StringBuilder
    //   2379: dup
    //   2380: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2383: astore 21
    //   2385: aload 21
    //   2387: new 68	java/lang/StringBuilder
    //   2390: dup
    //   2391: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2394: ldc_w 2847
    //   2397: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2400: aload 18
    //   2402: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2405: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2408: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2411: pop
    //   2412: aload 21
    //   2414: new 68	java/lang/StringBuilder
    //   2417: dup
    //   2418: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2421: ldc_w 2849
    //   2424: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2427: iload 7
    //   2429: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2432: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2435: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2438: pop
    //   2439: aload 21
    //   2441: new 68	java/lang/StringBuilder
    //   2444: dup
    //   2445: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2448: ldc_w 2851
    //   2451: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: iload 8
    //   2456: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2459: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2462: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: pop
    //   2466: aload 21
    //   2468: new 68	java/lang/StringBuilder
    //   2471: dup
    //   2472: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2475: ldc_w 2853
    //   2478: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: iload 10
    //   2483: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2486: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2489: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2492: pop
    //   2493: aload 21
    //   2495: new 68	java/lang/StringBuilder
    //   2498: dup
    //   2499: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2502: ldc_w 2855
    //   2505: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2508: aload 17
    //   2510: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2513: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2516: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2519: pop
    //   2520: aload 21
    //   2522: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2525: invokestatic 2434	aevk:Hx	(Ljava/lang/String;)V
    //   2528: iload 7
    //   2530: iconst_1
    //   2531: iadd
    //   2532: istore 7
    //   2534: goto -256 -> 2278
    //   2537: astore 17
    //   2539: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2542: ifeq +9876 -> 12418
    //   2545: aload 17
    //   2547: invokevirtual 850	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   2550: goto +9868 -> 12418
    //   2553: astore 17
    //   2555: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2558: ifeq +8 -> 2566
    //   2561: aload 17
    //   2563: invokevirtual 851	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2566: invokestatic 856	java/lang/System:gc	()V
    //   2569: new 115	java/lang/String
    //   2572: dup
    //   2573: aload 22
    //   2575: ldc_w 359
    //   2578: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2581: astore 17
    //   2583: goto -227 -> 2356
    //   2586: astore 17
    //   2588: ldc 18
    //   2590: astore 17
    //   2592: goto -236 -> 2356
    //   2595: aload 21
    //   2597: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2600: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2603: invokevirtual 370	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2606: astore 17
    //   2608: goto -252 -> 2356
    //   2611: aload 20
    //   2613: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2616: ifnull +188 -> 2804
    //   2619: aload 20
    //   2621: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2624: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   2627: ifle +177 -> 2804
    //   2630: iconst_0
    //   2631: istore 7
    //   2633: iload 7
    //   2635: aload 20
    //   2637: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2640: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   2643: if_icmpge +185 -> 2828
    //   2646: aload 20
    //   2648: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   2651: iconst_0
    //   2652: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   2655: checkcast 115	java/lang/String
    //   2658: astore 17
    //   2660: aload 20
    //   2662: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2665: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2668: istore 8
    //   2670: new 68	java/lang/StringBuilder
    //   2673: dup
    //   2674: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2677: astore 21
    //   2679: aload 21
    //   2681: new 68	java/lang/StringBuilder
    //   2684: dup
    //   2685: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2688: ldc_w 2857
    //   2691: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2694: aload 18
    //   2696: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2699: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2702: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2705: pop
    //   2706: aload 21
    //   2708: new 68	java/lang/StringBuilder
    //   2711: dup
    //   2712: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2715: ldc_w 2849
    //   2718: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2721: iload 7
    //   2723: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2726: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2729: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2732: pop
    //   2733: aload 21
    //   2735: new 68	java/lang/StringBuilder
    //   2738: dup
    //   2739: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2742: ldc_w 2851
    //   2745: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2748: iload 8
    //   2750: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2753: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2756: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: pop
    //   2760: aload 21
    //   2762: new 68	java/lang/StringBuilder
    //   2765: dup
    //   2766: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2769: ldc_w 2855
    //   2772: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2775: aload 17
    //   2777: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2780: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2783: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: pop
    //   2787: aload 21
    //   2789: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2792: invokestatic 2434	aevk:Hx	(Ljava/lang/String;)V
    //   2795: iload 7
    //   2797: iconst_1
    //   2798: iadd
    //   2799: istore 7
    //   2801: goto -168 -> 2633
    //   2804: new 68	java/lang/StringBuilder
    //   2807: dup
    //   2808: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2811: ldc_w 2859
    //   2814: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2817: aload 18
    //   2819: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2822: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2825: invokestatic 2434	aevk:Hx	(Ljava/lang/String;)V
    //   2828: aload 18
    //   2830: invokevirtual 607	java/lang/Integer:intValue	()I
    //   2833: lookupswitch	default:+9592->12425, 1:+2912->5745, 2:+3316->6149, 3:+3806->6639, 5:+4044->6877, 6:+6273->9106, 10:+4897->7730, 12:+4269->7102, 13:+5172->8005, 23:+5562->8395, 31:+5238->8071, 34:+5220->8053, 38:+5671->8504, 42:+6093->8926, 43:+6255->9088, 44:+2489->5322, 46:+6111->8944, 47:+2677->5510, 49:+6102->8935, 50:+6120->8953, 53:+5572->8405, 55:+4585->7418, 56:+6129->8962, 61:+6138->8971, 63:+6156->8989, 64:+6165->8998, 65:+2866->5699, 66:+6174->9007, 69:+6201->9034, 72:+6183->9016, 73:+6192->9025, 74:+6210->9043, 75:+6219->9052, 78:+5582->8415, 79:+6304->9137, 80:+6286->9119, 82:+6313->9146, 84:+5592->8425, 86:+6531->9364, 87:+6550->9383, 88:+6560->9393, 90:+6322->9155, 93:+5882->8715, 94:+5388->8221, 96:+6601->9434, 97:+6611->9444, 101:+5190->8023, 102:+5229->8062, 109:+6648->9481, 111:+6295->9128, 113:+6264->9097, 115:+5200->8033, 116:+1852->4685, 118:+6677->9510, 119:+9690->12523, 120:+6667->9500, 121:+6727->9560, 129:+6707->9540, 130:+6747->9580, 139:+5623->8456, 140:+6775->9608, 142:+6687->9520, 143:+6717->9550, 145:+6815->9648, 146:+6638->9471, 147:+6521->9354, 148:+6147->8980, 149:+6621->9454, 153:+6805->9638, 155:+6825->9658, 156:+9693->12526, 157:+6737->9570, 165:+6845->9678, 166:+6855->9688, 167:+5613->8446, 171:+6877->9710, 174:+6927->9760, 177:+6976->9809, 180:+6621->9454, 181:+6897->9730, 182:+6956->9789, 184:+6887->9720, 185:+7026->9859, 187:+6986->9819, 188:+6570->9403, 190:+7142->9975, 191:+7016->9849, 193:+1446->4279, 194:+6835->9668, 195:+6996->9829, 199:+7045->9878, 201:+6697->9530, 202:+7132->9965, 204:+7367->10200, 205:+6590->9423, 206:+6580->9413, 210:+7152->9985, 211:+6765->9598, 212:+7162->9995, 215:+7199->10032, 218:+6621->9454, 222:+7219->10052, 223:+5651->8484, 225:+7087->9920, 226:+5602->8435, 227:+7006->9839, 228:+6237->9070, 231:+9696->12529, 232:+6757->9590, 234:+7247->10080, 235:+7257->10090, 238:+7267->10100, 244:+7277->10110, 245:+7287->10120, 247:+6907->9740, 253:+7297->10130, 254:+7317->10150, 256:+6246->9079, 257:+6785->9618, 259:+7327->10160, 260:+6795->9628, 262:+7337->10170, 267:+7377->10210, 268:+7347->10180, 269:+7357->10190, 272:+6917->9750, 273:+6937->9770, 274:+7387->10220, 279:+7396->10229, 280:+7492->10325, 281:+7512->10345, 283:+7522->10355, 284:+7532->10365, 286:+5210->8043, 289:+7559->10392, 295:+7307->10140, 297:+7569->10402, 301:+7542->10375, 308:+7417->10250, 312:+7450->10283, 313:+7438->10271, 314:+7598->10431, 320:+7618->10451, 321:+7036->9869, 328:+6946->9779, 329:+5632->8465, 331:+7640->10473, 336:+7650->10483, 337:+7583->10416, 345:+7659->10492, 347:+7608->10441, 349:+7673->10506, 351:+5641->8474, 360:+7502->10335, 364:+5651->8484, 365:+5651->8484, 371:+6966->9799, 384:+7709->10542, 385:+6228->9061, 386:+7728->10561, 387:+7718->10551, 392:+7746->10579, 393:+7755->10588, 394:+7773->10606, 397:+7468->10301, 400:+7694->10527, 403:+7171->10004, 404:+7190->10023, 410:+7783->10616, 596:+7798->10631, 604:+7180->10013
    //   4205: istore 7
    //   4207: invokestatic 1534	aeif:a	()Laeif;
    //   4210: aload 18
    //   4212: invokevirtual 607	java/lang/Integer:intValue	()I
    //   4215: invokevirtual 1537	aeif:jg	(I)Z
    //   4218: ifeq +38 -> 4256
    //   4221: invokestatic 1534	aeif:a	()Laeif;
    //   4224: astore 17
    //   4226: aload 20
    //   4228: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4231: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4234: istore 7
    //   4236: aload 17
    //   4238: aload 18
    //   4240: invokevirtual 607	java/lang/Integer:intValue	()I
    //   4243: iload 7
    //   4245: aload 20
    //   4247: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   4250: invokevirtual 2862	aeif:a	(IILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)V
    //   4253: iconst_1
    //   4254: istore 7
    //   4256: iload 7
    //   4258: ifne +8170 -> 12428
    //   4261: aload_2
    //   4262: invokevirtual 1572	com/tencent/mobileqq/app/QQAppInterface:a	()Laehn;
    //   4265: aload_2
    //   4266: aload 20
    //   4268: aload 18
    //   4270: invokevirtual 607	java/lang/Integer:intValue	()I
    //   4273: invokevirtual 2865	aehn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   4276: goto +8152 -> 12428
    //   4279: aload 20
    //   4281: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4284: ifnull +8144 -> 12428
    //   4287: aload 20
    //   4289: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4292: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   4295: ifle +8133 -> 12428
    //   4298: aload 20
    //   4300: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4303: iconst_0
    //   4304: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4307: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   4310: astore 17
    //   4312: aload 17
    //   4314: ifnull +344 -> 4658
    //   4317: aload 17
    //   4319: getfield 334	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4322: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4325: iconst_1
    //   4326: if_icmpne +232 -> 4558
    //   4329: aload 17
    //   4331: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4334: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4337: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4340: invokestatic 357	akrf:inflateConfigString	([B)[B
    //   4343: astore 18
    //   4345: aload 18
    //   4347: ifnull +8065 -> 12412
    //   4350: new 115	java/lang/String
    //   4353: dup
    //   4354: aload 18
    //   4356: ldc_w 359
    //   4359: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4362: astore 17
    //   4364: aload 17
    //   4366: ifnull +8039 -> 12405
    //   4369: aload 20
    //   4371: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4374: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4377: istore 7
    //   4379: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4382: ifeq +42 -> 4424
    //   4385: ldc_w 2049
    //   4388: iconst_2
    //   4389: new 68	java/lang/StringBuilder
    //   4392: dup
    //   4393: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   4396: ldc_w 2867
    //   4399: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4402: iload 7
    //   4404: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4407: ldc_w 2869
    //   4410: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4413: aload 17
    //   4415: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4418: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4421: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4424: aload 17
    //   4426: invokestatic 2874	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;
    //   4429: astore 18
    //   4431: aload 18
    //   4433: astore 4
    //   4435: aload_0
    //   4436: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4439: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4442: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   4445: iload 7
    //   4447: invokestatic 2877	aqmj:V	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4450: aload_2
    //   4451: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4454: ldc_w 2879
    //   4457: invokestatic 2884	aqiz:isAppInstalled	(Landroid/content/Context;Ljava/lang/String;)Z
    //   4460: ifne +114 -> 4574
    //   4463: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4466: ifeq +13 -> 4479
    //   4469: ldc_w 2049
    //   4472: iconst_2
    //   4473: ldc_w 2886
    //   4476: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4479: aload 17
    //   4481: invokestatic 2889	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:Uk	(Ljava/lang/String;)V
    //   4484: aload_2
    //   4485: aload 4
    //   4487: invokestatic 2892	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   4490: aload 4
    //   4492: astore 17
    //   4494: aload 17
    //   4496: astore 4
    //   4498: goto +7930 -> 12428
    //   4501: astore 17
    //   4503: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4506: ifeq +7933 -> 12439
    //   4509: aload 17
    //   4511: invokevirtual 850	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   4514: goto +7925 -> 12439
    //   4517: astore 17
    //   4519: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4522: ifeq +8 -> 4530
    //   4525: aload 17
    //   4527: invokevirtual 851	java/lang/OutOfMemoryError:printStackTrace	()V
    //   4530: invokestatic 856	java/lang/System:gc	()V
    //   4533: new 115	java/lang/String
    //   4536: dup
    //   4537: aload 18
    //   4539: ldc_w 359
    //   4542: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4545: astore 17
    //   4547: goto -183 -> 4364
    //   4550: astore 17
    //   4552: aconst_null
    //   4553: astore 17
    //   4555: goto -191 -> 4364
    //   4558: aload 17
    //   4560: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4563: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4566: invokevirtual 370	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4569: astore 17
    //   4571: goto -207 -> 4364
    //   4574: aload 4
    //   4576: astore 17
    //   4578: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4581: ifeq -87 -> 4494
    //   4584: ldc_w 2049
    //   4587: iconst_2
    //   4588: ldc_w 2894
    //   4591: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4594: aload 4
    //   4596: astore 17
    //   4598: goto -104 -> 4494
    //   4601: astore 18
    //   4603: aload 4
    //   4605: astore 17
    //   4607: iload 11
    //   4609: istore 12
    //   4611: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4614: ifeq -2465 -> 2149
    //   4617: ldc 169
    //   4619: iconst_2
    //   4620: new 68	java/lang/StringBuilder
    //   4623: dup
    //   4624: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   4627: ldc_w 2896
    //   4630: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4633: aload 18
    //   4635: invokevirtual 172	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4638: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4641: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4644: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4647: aload 4
    //   4649: astore 17
    //   4651: iload 11
    //   4653: istore 12
    //   4655: goto -2506 -> 2149
    //   4658: aload 4
    //   4660: astore 17
    //   4662: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4665: ifeq -171 -> 4494
    //   4668: ldc_w 2049
    //   4671: iconst_2
    //   4672: ldc_w 2898
    //   4675: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4678: aload 4
    //   4680: astore 17
    //   4682: goto -188 -> 4494
    //   4685: aload_0
    //   4686: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4689: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4692: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   4695: invokestatic 2028	aqmj:ar	(Landroid/content/Context;Ljava/lang/String;)I
    //   4698: istore 7
    //   4700: aload 20
    //   4702: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4705: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4708: istore 8
    //   4710: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4713: ifeq +35 -> 4748
    //   4716: ldc 169
    //   4718: iconst_2
    //   4719: ldc_w 2900
    //   4722: iconst_2
    //   4723: anewarray 178	java/lang/Object
    //   4726: dup
    //   4727: iconst_0
    //   4728: iload 7
    //   4730: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4733: aastore
    //   4734: dup
    //   4735: iconst_1
    //   4736: iload 8
    //   4738: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4741: aastore
    //   4742: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4745: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4748: aconst_null
    //   4749: astore 18
    //   4751: iload 7
    //   4753: iload 8
    //   4755: if_icmpeq +386 -> 5141
    //   4758: aload 20
    //   4760: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4763: ifnull +14 -> 4777
    //   4766: aload 20
    //   4768: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   4771: invokevirtual 2901	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   4774: ifeq +285 -> 5059
    //   4777: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4780: ifeq +12 -> 4792
    //   4783: ldc 169
    //   4785: iconst_2
    //   4786: ldc_w 2903
    //   4789: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4792: ldc_w 2905
    //   4795: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   4798: invokestatic 2911	aqan:bR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4801: pop
    //   4802: aconst_null
    //   4803: astore 17
    //   4805: aload_0
    //   4806: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4809: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   4812: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   4815: iload 8
    //   4817: invokestatic 2913	aqmj:U	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4820: aload_2
    //   4821: iconst_4
    //   4822: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   4825: checkcast 2042	accy
    //   4828: astore 20
    //   4830: aload 17
    //   4832: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4835: ifne +468 -> 5303
    //   4838: invokestatic 2679	aqap:a	()Laqap;
    //   4841: invokevirtual 2682	aqap:b	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   4844: astore 18
    //   4846: aload 18
    //   4848: aload 17
    //   4850: invokevirtual 2918	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:bj	(Ljava/lang/String;)V
    //   4853: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4856: ifeq +42 -> 4898
    //   4859: ldc 169
    //   4861: iconst_2
    //   4862: ldc_w 2920
    //   4865: iconst_2
    //   4866: anewarray 178	java/lang/Object
    //   4869: dup
    //   4870: iconst_0
    //   4871: invokestatic 204	com/tencent/common/config/AppSetting:getAppId	()I
    //   4874: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4877: aastore
    //   4878: dup
    //   4879: iconst_1
    //   4880: aload 18
    //   4882: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   4885: getfield 2928	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4888: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4891: aastore
    //   4892: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4895: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4898: aload_2
    //   4899: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4902: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   4905: invokestatic 2931	aqmj:bw	(Landroid/content/Context;Ljava/lang/String;)I
    //   4908: aload 18
    //   4910: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   4913: getfield 2928	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4916: if_icmpeq +69 -> 4985
    //   4919: aload_2
    //   4920: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4923: aload_2
    //   4924: invokevirtual 1851	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4927: iconst_0
    //   4928: invokestatic 2934	aqmj:aI	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4931: aload_2
    //   4932: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4935: aload_2
    //   4936: invokevirtual 1851	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4939: lconst_0
    //   4940: invokestatic 2938	aqmj:x	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4943: aload_2
    //   4944: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4947: aload_2
    //   4948: invokevirtual 1851	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4951: iconst_0
    //   4952: invokestatic 2940	aqmj:aJ	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4955: aload_2
    //   4956: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4959: aload_2
    //   4960: invokevirtual 1851	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   4963: lconst_0
    //   4964: invokestatic 2943	aqmj:y	(Landroid/content/Context;Ljava/lang/String;J)V
    //   4967: aload_2
    //   4968: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4971: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   4974: aload 18
    //   4976: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   4979: getfield 2928	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4982: invokestatic 2945	aqmj:aH	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4985: invokestatic 204	com/tencent/common/config/AppSetting:getAppId	()I
    //   4988: aload 18
    //   4990: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   4993: getfield 2928	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   4996: if_icmplt +171 -> 5167
    //   4999: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5002: ifeq +12 -> 5014
    //   5005: ldc 169
    //   5007: iconst_2
    //   5008: ldc_w 2947
    //   5011: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5014: aload_2
    //   5015: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5018: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   5021: iconst_0
    //   5022: invokestatic 2913	aqmj:U	(Landroid/content/Context;Ljava/lang/String;I)V
    //   5025: ldc_w 2905
    //   5028: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   5031: invokestatic 2911	aqan:bR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   5034: pop
    //   5035: aload 18
    //   5037: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   5040: iconst_0
    //   5041: putfield 2950	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   5044: aload 20
    //   5046: aload 18
    //   5048: invokevirtual 2685	accy:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   5051: aload 20
    //   5053: invokevirtual 2953	accy:cIb	()V
    //   5056: goto +7372 -> 12428
    //   5059: aload 20
    //   5061: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5064: iconst_0
    //   5065: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5068: checkcast 115	java/lang/String
    //   5071: astore 17
    //   5073: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5076: ifeq +30 -> 5106
    //   5079: ldc 169
    //   5081: iconst_2
    //   5082: new 68	java/lang/StringBuilder
    //   5085: dup
    //   5086: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5089: ldc_w 2955
    //   5092: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5095: aload 17
    //   5097: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5100: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5103: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5106: aload 17
    //   5108: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5111: ifeq +16 -> 5127
    //   5114: ldc_w 2905
    //   5117: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   5120: invokestatic 2911	aqan:bR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   5123: pop
    //   5124: goto -319 -> 4805
    //   5127: ldc_w 2905
    //   5130: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   5133: aload 17
    //   5135: invokestatic 2958	aqan:bg	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5138: goto -333 -> 4805
    //   5141: aload 18
    //   5143: astore 17
    //   5145: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5148: ifeq -328 -> 4820
    //   5151: ldc 169
    //   5153: iconst_2
    //   5154: ldc_w 2960
    //   5157: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5160: aload 18
    //   5162: astore 17
    //   5164: goto -344 -> 4820
    //   5167: aload_0
    //   5168: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5171: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5174: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   5177: invokestatic 2837	java/lang/System:currentTimeMillis	()J
    //   5180: invokestatic 2962	aqmj:p	(Landroid/content/Context;Ljava/lang/String;J)V
    //   5183: aload 18
    //   5185: monitorenter
    //   5186: aload 18
    //   5188: getfield 2965	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:cTt	Z
    //   5191: ifne +27 -> 5218
    //   5194: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5197: ifeq +12 -> 5209
    //   5200: ldc 169
    //   5202: iconst_2
    //   5203: ldc_w 2967
    //   5206: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5209: aload 18
    //   5211: monitorexit
    //   5212: iconst_1
    //   5213: istore 11
    //   5215: goto +7213 -> 12428
    //   5218: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5221: ifeq +12 -> 5233
    //   5224: ldc 169
    //   5226: iconst_2
    //   5227: ldc_w 2969
    //   5230: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5233: aload 18
    //   5235: getfield 2972	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:dYm	I
    //   5238: ifne +21 -> 5259
    //   5241: aload 18
    //   5243: getfield 2975	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:dYl	I
    //   5246: iconst_1
    //   5247: if_icmpne +7203 -> 12450
    //   5250: iconst_1
    //   5251: istore 11
    //   5253: aload_2
    //   5254: iload 11
    //   5256: invokestatic 2977	accy:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   5259: aload 20
    //   5261: invokevirtual 2953	accy:cIb	()V
    //   5264: invokestatic 2679	aqap:a	()Laqap;
    //   5267: aload 18
    //   5269: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   5272: aload 20
    //   5274: invokevirtual 2980	aqap:a	(Lprotocol/KQQConfig/UpgradeInfo;Laqap$b;)Z
    //   5277: pop
    //   5278: aload 18
    //   5280: monitorexit
    //   5281: iconst_1
    //   5282: istore 11
    //   5284: goto +7144 -> 12428
    //   5287: astore 17
    //   5289: aload 18
    //   5291: monitorexit
    //   5292: aload 17
    //   5294: athrow
    //   5295: astore 18
    //   5297: iconst_1
    //   5298: istore 11
    //   5300: goto -697 -> 4603
    //   5303: aload 20
    //   5305: invokevirtual 2953	accy:cIb	()V
    //   5308: aload 20
    //   5310: invokestatic 2679	aqap:a	()Laqap;
    //   5313: invokevirtual 2682	aqap:b	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   5316: invokevirtual 2685	accy:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   5319: goto +7109 -> 12428
    //   5322: aload 20
    //   5324: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5327: ifnull +141 -> 5468
    //   5330: aload 20
    //   5332: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5335: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5338: ifle +130 -> 5468
    //   5341: aload_0
    //   5342: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5345: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5348: aload 20
    //   5350: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5353: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5356: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   5359: invokestatic 2983	aqmj:r	(Landroid/content/Context;ILjava/lang/String;)V
    //   5362: iconst_0
    //   5363: istore 7
    //   5365: iload 7
    //   5367: aload 20
    //   5369: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5372: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5375: if_icmpge +7090 -> 12465
    //   5378: aload 20
    //   5380: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5383: iload 7
    //   5385: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5388: checkcast 115	java/lang/String
    //   5391: astore 17
    //   5393: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5396: ifeq +47 -> 5443
    //   5399: ldc 169
    //   5401: iconst_2
    //   5402: new 68	java/lang/StringBuilder
    //   5405: dup
    //   5406: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5409: ldc_w 2985
    //   5412: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5415: aload 17
    //   5417: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5420: ldc_w 410
    //   5423: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5426: aload 20
    //   5428: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5431: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5434: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5437: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5440: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5443: aload 17
    //   5445: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5448: ifne +7008 -> 12456
    //   5451: aload_2
    //   5452: bipush 60
    //   5454: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5457: checkcast 2987	com/tencent/mobileqq/app/HotChatManager
    //   5460: aload 17
    //   5462: invokevirtual 2990	com/tencent/mobileqq/app/HotChatManager:DZ	(Ljava/lang/String;)V
    //   5465: goto +6991 -> 12456
    //   5468: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5471: ifeq +6957 -> 12428
    //   5474: ldc 169
    //   5476: iconst_2
    //   5477: new 68	java/lang/StringBuilder
    //   5480: dup
    //   5481: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5484: ldc_w 2992
    //   5487: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5490: aload 20
    //   5492: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5495: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5498: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5501: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5504: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5507: goto +6921 -> 12428
    //   5510: aload 20
    //   5512: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5515: ifnull +142 -> 5657
    //   5518: aload 20
    //   5520: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5523: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5526: ifle +131 -> 5657
    //   5529: aload_0
    //   5530: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5533: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5536: aload 20
    //   5538: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5541: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5544: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   5547: invokestatic 2994	aqmj:p	(Landroid/content/Context;ILjava/lang/String;)V
    //   5550: iconst_0
    //   5551: istore 7
    //   5553: iload 7
    //   5555: aload 20
    //   5557: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5560: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5563: if_icmpge +6914 -> 12477
    //   5566: aload 20
    //   5568: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5571: iload 7
    //   5573: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5576: checkcast 115	java/lang/String
    //   5579: astore 17
    //   5581: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5584: ifeq +47 -> 5631
    //   5587: ldc 169
    //   5589: iconst_2
    //   5590: new 68	java/lang/StringBuilder
    //   5593: dup
    //   5594: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5597: ldc_w 2996
    //   5600: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5603: aload 17
    //   5605: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: ldc_w 410
    //   5611: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5614: aload 20
    //   5616: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5619: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5622: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5625: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5628: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5631: aload 17
    //   5633: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5636: ifne +6832 -> 12468
    //   5639: aload_2
    //   5640: bipush 51
    //   5642: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   5645: checkcast 2998	syw
    //   5648: aload 17
    //   5650: iconst_0
    //   5651: invokevirtual 3001	syw:aH	(Ljava/lang/String;Z)V
    //   5654: goto +6814 -> 12468
    //   5657: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5660: ifeq +6768 -> 12428
    //   5663: ldc 169
    //   5665: iconst_2
    //   5666: new 68	java/lang/StringBuilder
    //   5669: dup
    //   5670: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5673: ldc_w 3003
    //   5676: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5679: aload 20
    //   5681: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5684: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5687: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5690: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5693: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5696: goto +6732 -> 12428
    //   5699: aload 20
    //   5701: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5704: ifnull +6724 -> 12428
    //   5707: aload_0
    //   5708: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5711: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5714: aload 20
    //   5716: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5719: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5722: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   5725: invokestatic 3005	aqmj:q	(Landroid/content/Context;ILjava/lang/String;)V
    //   5728: aload_2
    //   5729: bipush 51
    //   5731: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   5734: checkcast 2998	syw
    //   5737: aload 20
    //   5739: invokevirtual 3007	syw:b	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   5742: goto +6686 -> 12428
    //   5745: aload 20
    //   5747: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5750: ifnull +276 -> 6026
    //   5753: aload 20
    //   5755: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5758: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   5761: ifle +265 -> 6026
    //   5764: new 3009	java/io/File
    //   5767: dup
    //   5768: new 68	java/lang/StringBuilder
    //   5771: dup
    //   5772: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5775: aload_0
    //   5776: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   5779: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   5782: invokevirtual 3015	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   5785: invokevirtual 3018	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5788: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5791: ldc_w 3020
    //   5794: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5797: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5800: invokespecial 3021	java/io/File:<init>	(Ljava/lang/String;)V
    //   5803: astore 17
    //   5805: aload 17
    //   5807: invokevirtual 3024	java/io/File:exists	()Z
    //   5810: ifne +152 -> 5962
    //   5813: aload 17
    //   5815: invokevirtual 3027	java/io/File:mkdirs	()Z
    //   5818: pop
    //   5819: aload 20
    //   5821: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5824: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   5827: invokeinterface 397 1 0
    //   5832: astore 17
    //   5834: aload 17
    //   5836: invokeinterface 402 1 0
    //   5841: ifeq +6648 -> 12489
    //   5844: aload 17
    //   5846: invokeinterface 406 1 0
    //   5851: checkcast 115	java/lang/String
    //   5854: astore 18
    //   5856: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5859: ifeq +47 -> 5906
    //   5862: ldc 169
    //   5864: iconst_2
    //   5865: new 68	java/lang/StringBuilder
    //   5868: dup
    //   5869: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5872: ldc_w 3029
    //   5875: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5878: aload 18
    //   5880: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5883: ldc_w 410
    //   5886: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5889: aload 20
    //   5891: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5894: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5897: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5900: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5903: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5906: aload_0
    //   5907: aload 18
    //   5909: aload 20
    //   5911: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5914: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5917: invokespecial 3032	aevk:eu	(Ljava/lang/String;I)V
    //   5920: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5923: ifeq -89 -> 5834
    //   5926: ldc 169
    //   5928: iconst_2
    //   5929: new 68	java/lang/StringBuilder
    //   5932: dup
    //   5933: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5936: ldc_w 3034
    //   5939: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5942: aload 20
    //   5944: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   5947: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   5950: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5953: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5956: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5959: goto -125 -> 5834
    //   5962: aload 17
    //   5964: ifnull -145 -> 5819
    //   5967: aload 17
    //   5969: invokevirtual 3037	java/io/File:isDirectory	()Z
    //   5972: ifeq -153 -> 5819
    //   5975: aload 17
    //   5977: invokevirtual 3041	java/io/File:listFiles	()[Ljava/io/File;
    //   5980: astore 17
    //   5982: aload 17
    //   5984: arraylength
    //   5985: istore 8
    //   5987: iconst_0
    //   5988: istore 7
    //   5990: iload 7
    //   5992: iload 8
    //   5994: if_icmpge -175 -> 5819
    //   5997: aload 17
    //   5999: iload 7
    //   6001: aaload
    //   6002: astore 18
    //   6004: aload 18
    //   6006: ifnull +6474 -> 12480
    //   6009: aload 18
    //   6011: invokevirtual 3024	java/io/File:exists	()Z
    //   6014: ifeq +6466 -> 12480
    //   6017: aload 18
    //   6019: invokevirtual 3044	java/io/File:delete	()Z
    //   6022: pop
    //   6023: goto +6457 -> 12480
    //   6026: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6029: ifeq +36 -> 6065
    //   6032: ldc 169
    //   6034: iconst_2
    //   6035: new 68	java/lang/StringBuilder
    //   6038: dup
    //   6039: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6042: ldc_w 3046
    //   6045: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6048: aload 20
    //   6050: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6053: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6056: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6059: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6062: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6065: new 3009	java/io/File
    //   6068: dup
    //   6069: new 68	java/lang/StringBuilder
    //   6072: dup
    //   6073: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6076: aload_0
    //   6077: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6080: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6083: invokevirtual 3015	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   6086: invokevirtual 3018	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6089: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6092: ldc_w 3048
    //   6095: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6098: ldc_w 3050
    //   6101: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6104: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6107: invokespecial 3021	java/io/File:<init>	(Ljava/lang/String;)V
    //   6110: astore 17
    //   6112: aload 17
    //   6114: ifnull +9 -> 6123
    //   6117: aload 17
    //   6119: invokevirtual 3044	java/io/File:delete	()Z
    //   6122: pop
    //   6123: aload_0
    //   6124: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6127: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6130: aload 20
    //   6132: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6135: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6138: ldc_w 3052
    //   6141: ldc 18
    //   6143: invokestatic 3055	aqmj:c	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   6146: goto +6282 -> 12428
    //   6149: aload 20
    //   6151: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6154: ifnull +323 -> 6477
    //   6157: aload 20
    //   6159: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6162: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6165: ifle +312 -> 6477
    //   6168: getstatic 3060	aehp:a	Laevv;
    //   6171: invokevirtual 3065	aevv:removeAll	()V
    //   6174: aload 20
    //   6176: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6179: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   6182: invokeinterface 397 1 0
    //   6187: astore 17
    //   6189: aload 17
    //   6191: invokeinterface 402 1 0
    //   6196: ifeq +82 -> 6278
    //   6199: aload 17
    //   6201: invokeinterface 406 1 0
    //   6206: checkcast 115	java/lang/String
    //   6209: astore 18
    //   6211: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6214: ifeq +47 -> 6261
    //   6217: ldc 169
    //   6219: iconst_2
    //   6220: new 68	java/lang/StringBuilder
    //   6223: dup
    //   6224: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6227: ldc_w 3067
    //   6230: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6233: aload 18
    //   6235: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6238: ldc_w 410
    //   6241: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6244: aload 20
    //   6246: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6249: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6252: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6255: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6258: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6261: aload_0
    //   6262: aload 18
    //   6264: aload 20
    //   6266: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6269: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6272: invokespecial 3070	aevk:es	(Ljava/lang/String;I)V
    //   6275: goto -86 -> 6189
    //   6278: new 3072	aehr
    //   6281: dup
    //   6282: aload_0
    //   6283: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6286: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6289: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   6292: invokespecial 3074	aehr:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   6295: astore 17
    //   6297: aload 17
    //   6299: ifnull +13 -> 6312
    //   6302: aload 17
    //   6304: invokevirtual 3077	aehr:cXa	()V
    //   6307: aload 17
    //   6309: invokevirtual 3080	aehr:cXb	()V
    //   6312: invokestatic 1066	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6315: ldc_w 3082
    //   6318: iconst_0
    //   6319: invokevirtual 480	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   6322: astore 17
    //   6324: aload 17
    //   6326: invokeinterface 486 1 0
    //   6331: new 68	java/lang/StringBuilder
    //   6334: dup
    //   6335: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6338: ldc_w 3084
    //   6341: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6344: aload_0
    //   6345: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6348: invokevirtual 3085	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6351: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6354: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6357: iconst_1
    //   6358: invokeinterface 494 3 0
    //   6363: invokeinterface 497 1 0
    //   6368: pop
    //   6369: aload 17
    //   6371: invokeinterface 486 1 0
    //   6376: new 68	java/lang/StringBuilder
    //   6379: dup
    //   6380: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6383: ldc_w 3087
    //   6386: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6389: aload_0
    //   6390: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6393: invokevirtual 3085	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6396: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6399: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6402: iconst_1
    //   6403: invokeinterface 494 3 0
    //   6408: invokeinterface 497 1 0
    //   6413: pop
    //   6414: aload_0
    //   6415: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6418: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6421: aload 20
    //   6423: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6426: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6429: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   6432: invokestatic 2983	aqmj:r	(Landroid/content/Context;ILjava/lang/String;)V
    //   6435: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6438: ifeq +6054 -> 12492
    //   6441: ldc 169
    //   6443: iconst_2
    //   6444: new 68	java/lang/StringBuilder
    //   6447: dup
    //   6448: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6451: ldc_w 3089
    //   6454: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6457: aload 20
    //   6459: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6462: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6465: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6468: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6471: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6474: goto +6018 -> 12492
    //   6477: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6480: ifeq +36 -> 6516
    //   6483: ldc 169
    //   6485: iconst_2
    //   6486: new 68	java/lang/StringBuilder
    //   6489: dup
    //   6490: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6493: ldc_w 3091
    //   6496: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6499: aload 20
    //   6501: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6504: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6507: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6510: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6513: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6516: getstatic 3060	aehp:a	Laevv;
    //   6519: invokevirtual 3065	aevv:removeAll	()V
    //   6522: getstatic 3060	aehp:a	Laevv;
    //   6525: invokevirtual 3094	aevv:cXt	()V
    //   6528: new 3072	aehr
    //   6531: dup
    //   6532: aload_0
    //   6533: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6536: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6539: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   6542: invokespecial 3074	aehr:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   6545: astore 17
    //   6547: aload 17
    //   6549: ifnull +13 -> 6562
    //   6552: aload 17
    //   6554: invokevirtual 3077	aehr:cXa	()V
    //   6557: aload 17
    //   6559: invokevirtual 3080	aehr:cXb	()V
    //   6562: invokestatic 1066	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6565: ldc_w 3082
    //   6568: iconst_0
    //   6569: invokevirtual 480	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   6572: invokeinterface 486 1 0
    //   6577: new 68	java/lang/StringBuilder
    //   6580: dup
    //   6581: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6584: ldc_w 3087
    //   6587: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6590: aload_0
    //   6591: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6594: invokevirtual 3085	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   6597: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6600: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6603: iconst_0
    //   6604: invokeinterface 494 3 0
    //   6609: invokeinterface 497 1 0
    //   6614: pop
    //   6615: aload_0
    //   6616: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6619: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6622: aload 20
    //   6624: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6627: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6630: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   6633: invokestatic 2983	aqmj:r	(Landroid/content/Context;ILjava/lang/String;)V
    //   6636: goto +5792 -> 12428
    //   6639: aload 20
    //   6641: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6644: ifnull +95 -> 6739
    //   6647: aload 20
    //   6649: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6652: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6655: ifle +84 -> 6739
    //   6658: aload 20
    //   6660: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6663: iconst_0
    //   6664: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6667: checkcast 115	java/lang/String
    //   6670: astore 17
    //   6672: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6675: ifeq +47 -> 6722
    //   6678: ldc 169
    //   6680: iconst_2
    //   6681: new 68	java/lang/StringBuilder
    //   6684: dup
    //   6685: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6688: ldc_w 3096
    //   6691: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6694: aload 17
    //   6696: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6699: ldc_w 410
    //   6702: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6705: aload 20
    //   6707: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6710: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6713: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6716: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6719: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6722: aload_0
    //   6723: aload 17
    //   6725: aload 20
    //   6727: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6730: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6733: invokespecial 3099	aevk:et	(Ljava/lang/String;I)V
    //   6736: goto +5692 -> 12428
    //   6739: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6742: ifeq +36 -> 6778
    //   6745: ldc 169
    //   6747: iconst_2
    //   6748: new 68	java/lang/StringBuilder
    //   6751: dup
    //   6752: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6755: ldc_w 3101
    //   6758: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6761: aload 20
    //   6763: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6766: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6769: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6772: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6775: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6778: new 3009	java/io/File
    //   6781: dup
    //   6782: new 68	java/lang/StringBuilder
    //   6785: dup
    //   6786: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6789: aload_0
    //   6790: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6793: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6796: invokevirtual 3015	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   6799: invokevirtual 3018	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6802: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6805: ldc_w 3048
    //   6808: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6811: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   6814: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6817: ldc_w 3048
    //   6820: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6823: ldc_w 3103
    //   6826: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6829: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6832: invokespecial 3021	java/io/File:<init>	(Ljava/lang/String;)V
    //   6835: astore 17
    //   6837: aload 17
    //   6839: invokevirtual 3024	java/io/File:exists	()Z
    //   6842: ifeq +9 -> 6851
    //   6845: aload 17
    //   6847: invokevirtual 3044	java/io/File:delete	()Z
    //   6850: pop
    //   6851: aload_0
    //   6852: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   6855: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   6858: aload 20
    //   6860: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6863: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6866: ldc 18
    //   6868: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   6871: invokestatic 3105	aqmj:d	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V
    //   6874: goto +5554 -> 12428
    //   6877: aload 20
    //   6879: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6882: ifnull +178 -> 7060
    //   6885: aload 20
    //   6887: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6890: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6893: ifle +167 -> 7060
    //   6896: new 1352	java/util/ArrayList
    //   6899: dup
    //   6900: invokespecial 1353	java/util/ArrayList:<init>	()V
    //   6903: astore 17
    //   6905: iconst_0
    //   6906: istore 7
    //   6908: iload 7
    //   6910: aload 20
    //   6912: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6915: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   6918: if_icmpge +92 -> 7010
    //   6921: aload 20
    //   6923: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   6926: iload 7
    //   6928: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   6931: checkcast 115	java/lang/String
    //   6934: astore 18
    //   6936: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6939: ifeq +47 -> 6986
    //   6942: ldc 169
    //   6944: iconst_2
    //   6945: new 68	java/lang/StringBuilder
    //   6948: dup
    //   6949: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6952: ldc_w 3107
    //   6955: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6958: aload 18
    //   6960: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6963: ldc_w 410
    //   6966: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6969: aload 20
    //   6971: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6974: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   6977: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6980: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6983: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6986: aload_0
    //   6987: aload 18
    //   6989: invokespecial 3109	aevk:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/config/operation/QQOperationViopTipTask;
    //   6992: astore 18
    //   6994: aload 18
    //   6996: ifnull +5499 -> 12495
    //   6999: aload 17
    //   7001: aload 18
    //   7003: invokevirtual 1386	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   7006: pop
    //   7007: goto +5488 -> 12495
    //   7010: aload_0
    //   7011: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7014: checkcast 140	com/tencent/mobileqq/app/QQAppInterface
    //   7017: invokestatic 3114	aeve:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laeve;
    //   7020: aload_0
    //   7021: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7024: checkcast 140	com/tencent/mobileqq/app/QQAppInterface
    //   7027: aload 17
    //   7029: invokevirtual 3117	aeve:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/ArrayList;)V
    //   7032: aload_0
    //   7033: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7036: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7039: aload_0
    //   7040: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7043: invokevirtual 3085	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7046: aload 20
    //   7048: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7051: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7054: invokestatic 3119	aqmj:F	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7057: goto +5371 -> 12428
    //   7060: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7063: ifeq +5365 -> 12428
    //   7066: ldc 169
    //   7068: iconst_2
    //   7069: new 68	java/lang/StringBuilder
    //   7072: dup
    //   7073: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7076: ldc_w 3121
    //   7079: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7082: aload 20
    //   7084: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7087: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7090: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7093: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7096: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7099: goto +5329 -> 12428
    //   7102: aload_2
    //   7103: bipush 74
    //   7105: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7108: checkcast 1637	aevt
    //   7111: astore 17
    //   7113: aload 17
    //   7115: invokevirtual 3124	aevt:C	()Ljava/util/Set;
    //   7118: astore 21
    //   7120: new 3062	aevv
    //   7123: dup
    //   7124: bipush 21
    //   7126: iconst_2
    //   7127: invokespecial 3127	aevv:<init>	(SB)V
    //   7130: astore 18
    //   7132: aload 20
    //   7134: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7137: ifnull +129 -> 7266
    //   7140: aload 20
    //   7142: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7145: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7148: ifle +118 -> 7266
    //   7151: aload 20
    //   7153: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7156: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7159: invokeinterface 397 1 0
    //   7164: astore 22
    //   7166: aload 22
    //   7168: invokeinterface 402 1 0
    //   7173: ifeq +132 -> 7305
    //   7176: aload 22
    //   7178: invokeinterface 406 1 0
    //   7183: checkcast 115	java/lang/String
    //   7186: astore 23
    //   7188: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7191: ifeq +47 -> 7238
    //   7194: ldc 169
    //   7196: iconst_2
    //   7197: new 68	java/lang/StringBuilder
    //   7200: dup
    //   7201: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7204: ldc_w 3129
    //   7207: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7210: aload 23
    //   7212: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7215: ldc_w 410
    //   7218: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7221: aload 20
    //   7223: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7226: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7229: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7232: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7235: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7238: aload 18
    //   7240: aload 23
    //   7242: aload 21
    //   7244: invokestatic 3132	aevk:a	(Laevv;Ljava/lang/String;Ljava/util/Set;)Z
    //   7247: pop
    //   7248: aload 17
    //   7250: aload 18
    //   7252: aload 20
    //   7254: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7257: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7260: invokevirtual 3135	aevt:a	(Laevv;I)V
    //   7263: goto -97 -> 7166
    //   7266: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7269: ifeq +36 -> 7305
    //   7272: ldc 169
    //   7274: iconst_2
    //   7275: new 68	java/lang/StringBuilder
    //   7278: dup
    //   7279: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7282: ldc_w 3137
    //   7285: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7288: aload 20
    //   7290: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7293: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7296: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7299: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7302: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7305: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7308: ifeq +76 -> 7384
    //   7311: new 68	java/lang/StringBuilder
    //   7314: dup
    //   7315: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7318: ldc_w 3139
    //   7321: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7324: astore 21
    //   7326: aload 20
    //   7328: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7331: ifnonnull +69 -> 7400
    //   7334: iconst_0
    //   7335: istore 7
    //   7337: ldc 169
    //   7339: iconst_2
    //   7340: aload 21
    //   7342: iload 7
    //   7344: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7347: ldc_w 3141
    //   7350: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7353: aload 18
    //   7355: invokevirtual 3144	aevv:CD	()I
    //   7358: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7361: ldc_w 3146
    //   7364: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7367: aload 20
    //   7369: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7372: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7375: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7378: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7381: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7384: aload 17
    //   7386: aload 20
    //   7388: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7391: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7394: invokevirtual 3149	aevt:Mj	(I)V
    //   7397: goto +5031 -> 12428
    //   7400: aload 20
    //   7402: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7405: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7408: invokeinterface 225 1 0
    //   7413: istore 7
    //   7415: goto -78 -> 7337
    //   7418: aload_2
    //   7419: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7422: aload_2
    //   7423: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7426: invokestatic 1662	aqmj:T	(Landroid/content/Context;Ljava/lang/String;)I
    //   7429: istore 8
    //   7431: aload 20
    //   7433: ifnull +5071 -> 12504
    //   7436: aload 20
    //   7438: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7441: ifnull +5063 -> 12504
    //   7444: aload 20
    //   7446: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7449: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7452: istore 7
    //   7454: aload 20
    //   7456: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7459: ifnull +185 -> 7644
    //   7462: aload 20
    //   7464: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7467: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7470: ifle +174 -> 7644
    //   7473: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7476: ifeq +79 -> 7555
    //   7479: ldc 169
    //   7481: iconst_2
    //   7482: new 68	java/lang/StringBuilder
    //   7485: dup
    //   7486: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7489: ldc_w 3151
    //   7492: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7495: iload 7
    //   7497: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7500: ldc_w 3153
    //   7503: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7506: iload 8
    //   7508: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7511: ldc_w 3155
    //   7514: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7517: aload 20
    //   7519: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7522: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7525: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7528: ldc_w 3157
    //   7531: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7534: aload 20
    //   7536: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7539: iconst_0
    //   7540: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7543: checkcast 115	java/lang/String
    //   7546: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7549: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7552: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7555: new 3159	java/util/HashSet
    //   7558: dup
    //   7559: invokespecial 3160	java/util/HashSet:<init>	()V
    //   7562: astore 17
    //   7564: iconst_0
    //   7565: istore 8
    //   7567: iload 8
    //   7569: aload 20
    //   7571: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7574: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7577: if_icmpge +30 -> 7607
    //   7580: aload 17
    //   7582: aload 20
    //   7584: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7587: iload 8
    //   7589: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   7592: invokeinterface 3163 2 0
    //   7597: pop
    //   7598: iload 8
    //   7600: iconst_1
    //   7601: iadd
    //   7602: istore 8
    //   7604: goto -37 -> 7567
    //   7607: aload_2
    //   7608: sipush 138
    //   7611: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7614: checkcast 3165	ylm
    //   7617: aload 17
    //   7619: invokevirtual 3168	ylm:h	(Ljava/util/Set;)V
    //   7622: aload_0
    //   7623: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7626: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7629: aload_0
    //   7630: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7633: invokevirtual 3085	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7636: iload 7
    //   7638: invokestatic 3170	aqmj:G	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7641: goto +4870 -> 12511
    //   7644: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7647: ifeq +41 -> 7688
    //   7650: ldc 169
    //   7652: iconst_2
    //   7653: new 68	java/lang/StringBuilder
    //   7656: dup
    //   7657: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7660: ldc_w 3172
    //   7663: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7666: iload 7
    //   7668: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7671: ldc_w 3153
    //   7674: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7677: iload 8
    //   7679: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7682: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7685: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7688: iload 8
    //   7690: iload 7
    //   7692: if_icmpeq +4819 -> 12511
    //   7695: aload_2
    //   7696: sipush 138
    //   7699: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7702: checkcast 3165	ylm
    //   7705: invokevirtual 3175	ylm:cjg	()V
    //   7708: aload_0
    //   7709: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7712: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7715: aload_0
    //   7716: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7719: invokevirtual 3085	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   7722: iload 7
    //   7724: invokestatic 3170	aqmj:G	(Landroid/content/Context;Ljava/lang/String;I)V
    //   7727: goto +4784 -> 12511
    //   7730: aload 20
    //   7732: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7735: ifnull +4664 -> 12399
    //   7738: aload 20
    //   7740: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7743: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   7746: ifle +4653 -> 12399
    //   7749: aload 20
    //   7751: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   7754: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   7757: astore 17
    //   7759: aload 17
    //   7761: ifnull +195 -> 7956
    //   7764: aload 17
    //   7766: invokeinterface 225 1 0
    //   7771: ifle +185 -> 7956
    //   7774: aload 17
    //   7776: iconst_0
    //   7777: invokeinterface 226 2 0
    //   7782: checkcast 115	java/lang/String
    //   7785: astore 18
    //   7787: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7790: ifeq +47 -> 7837
    //   7793: ldc 169
    //   7795: iconst_2
    //   7796: new 68	java/lang/StringBuilder
    //   7799: dup
    //   7800: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7803: ldc_w 3177
    //   7806: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7809: aload 18
    //   7811: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7814: ldc_w 410
    //   7817: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7820: aload 20
    //   7822: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7825: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7828: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7831: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7834: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7837: aload 18
    //   7839: invokestatic 3182	jou:kW	(Ljava/lang/String;)V
    //   7842: aload 17
    //   7844: invokeinterface 397 1 0
    //   7849: astore 17
    //   7851: aload 17
    //   7853: invokeinterface 402 1 0
    //   7858: ifeq +73 -> 7931
    //   7861: aload 17
    //   7863: invokeinterface 406 1 0
    //   7868: checkcast 115	java/lang/String
    //   7871: astore 18
    //   7873: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7876: ifeq +47 -> 7923
    //   7879: ldc 169
    //   7881: iconst_2
    //   7882: new 68	java/lang/StringBuilder
    //   7885: dup
    //   7886: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7889: ldc_w 3177
    //   7892: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7895: aload 18
    //   7897: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7900: ldc_w 410
    //   7903: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7906: aload 20
    //   7908: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7911: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7914: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7917: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7920: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7923: aload 18
    //   7925: invokestatic 3187	yhz:ia	(Ljava/lang/String;)Z
    //   7928: ifeq -77 -> 7851
    //   7931: aload 20
    //   7933: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7936: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7939: istore 7
    //   7941: aload_0
    //   7942: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   7945: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   7948: iload 7
    //   7950: invokestatic 3190	aqmj:aw	(Landroid/content/Context;I)V
    //   7953: goto +4475 -> 12428
    //   7956: aconst_null
    //   7957: invokestatic 3182	jou:kW	(Ljava/lang/String;)V
    //   7960: invokestatic 3193	yhz:clearConfig	()V
    //   7963: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7966: ifeq -35 -> 7931
    //   7969: ldc 169
    //   7971: iconst_2
    //   7972: new 68	java/lang/StringBuilder
    //   7975: dup
    //   7976: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   7979: ldc_w 3195
    //   7982: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7985: aload 20
    //   7987: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7990: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7993: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7996: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7999: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8002: goto -71 -> 7931
    //   8005: invokestatic 1066	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8008: aload_2
    //   8009: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   8012: invokestatic 1675	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   8015: aload 20
    //   8017: invokevirtual 3197	cooperation/pluginbridge/BridgeHelper:J	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8020: goto +4408 -> 12428
    //   8023: aload_0
    //   8024: aload_3
    //   8025: aload 20
    //   8027: invokespecial 3200	aevk:l	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8030: goto +4398 -> 12428
    //   8033: aload_0
    //   8034: aload_3
    //   8035: aload 20
    //   8037: invokespecial 3202	aevk:j	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8040: goto +4388 -> 12428
    //   8043: aload_0
    //   8044: aload_3
    //   8045: aload 20
    //   8047: invokespecial 3204	aevk:k	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8050: goto +4378 -> 12428
    //   8053: aload_0
    //   8054: aload 20
    //   8056: invokespecial 3206	aevk:j	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8059: goto +4369 -> 12428
    //   8062: aload_0
    //   8063: aload 20
    //   8065: invokespecial 3208	aevk:i	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8068: goto +4360 -> 12428
    //   8071: aload 20
    //   8073: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8076: ifnull +103 -> 8179
    //   8079: aload 20
    //   8081: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8084: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8087: ifle +92 -> 8179
    //   8090: aload 20
    //   8092: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8095: iconst_0
    //   8096: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8099: checkcast 115	java/lang/String
    //   8102: astore 17
    //   8104: aload 20
    //   8106: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8109: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8112: istore 7
    //   8114: aload_2
    //   8115: invokevirtual 3211	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   8118: aload_2
    //   8119: aload 17
    //   8121: iload 7
    //   8123: invokevirtual 3216	com/tencent/av/gaudio/AVNotifyCenter:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   8126: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8129: ifeq +4385 -> 12514
    //   8132: ldc 169
    //   8134: iconst_2
    //   8135: new 68	java/lang/StringBuilder
    //   8138: dup
    //   8139: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8142: ldc_w 3218
    //   8145: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8148: aload 17
    //   8150: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8153: ldc_w 410
    //   8156: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8159: aload 20
    //   8161: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8164: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8167: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8170: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8173: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8176: goto +4338 -> 12514
    //   8179: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8182: ifeq +4246 -> 12428
    //   8185: ldc 169
    //   8187: iconst_2
    //   8188: new 68	java/lang/StringBuilder
    //   8191: dup
    //   8192: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8195: ldc_w 3220
    //   8198: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8201: aload 20
    //   8203: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8206: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8209: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8212: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8215: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8218: goto +4210 -> 12428
    //   8221: aload_2
    //   8222: sipush 177
    //   8225: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8228: checkcast 3222	aqqh
    //   8231: astore 17
    //   8233: aload 20
    //   8235: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8238: ifnull +98 -> 8336
    //   8241: aload 20
    //   8243: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8246: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8249: ifle +87 -> 8336
    //   8252: aload 20
    //   8254: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8257: iconst_0
    //   8258: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   8261: checkcast 115	java/lang/String
    //   8264: astore 18
    //   8266: aload 20
    //   8268: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8271: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8274: istore 7
    //   8276: aload 17
    //   8278: aload 18
    //   8280: aload_2
    //   8281: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8284: iload 7
    //   8286: invokevirtual 3225	aqqh:aa	(Ljava/lang/String;Ljava/lang/String;I)V
    //   8289: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8292: ifeq +4225 -> 12517
    //   8295: ldc 169
    //   8297: iconst_2
    //   8298: new 68	java/lang/StringBuilder
    //   8301: dup
    //   8302: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8305: ldc_w 3227
    //   8308: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8311: aload 18
    //   8313: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8316: ldc_w 410
    //   8319: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8322: iload 7
    //   8324: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8327: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8330: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8333: goto +4184 -> 12517
    //   8336: aload 17
    //   8338: aload 20
    //   8340: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8343: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8346: aload_2
    //   8347: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8350: invokevirtual 3231	aqqh:dW	(ILjava/lang/String;)V
    //   8353: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8356: ifeq +4164 -> 12520
    //   8359: ldc 169
    //   8361: iconst_2
    //   8362: new 68	java/lang/StringBuilder
    //   8365: dup
    //   8366: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8369: ldc_w 3233
    //   8372: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8375: aload 20
    //   8377: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8380: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8383: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8386: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8389: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8392: goto +4128 -> 12520
    //   8395: aload_0
    //   8396: aload_3
    //   8397: aload 20
    //   8399: invokespecial 3235	aevk:i	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8402: goto +4026 -> 12428
    //   8405: aload_0
    //   8406: aload_3
    //   8407: aload 20
    //   8409: invokespecial 3237	aevk:e	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8412: goto +4016 -> 12428
    //   8415: aload_0
    //   8416: aload_3
    //   8417: aload 20
    //   8419: invokespecial 3239	aevk:f	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8422: goto +4006 -> 12428
    //   8425: aload_0
    //   8426: aload_3
    //   8427: aload 20
    //   8429: invokespecial 3242	aevk:g	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8432: goto +3996 -> 12428
    //   8435: aload_0
    //   8436: aload_2
    //   8437: aload_3
    //   8438: aload 20
    //   8440: invokespecial 3245	aevk:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8443: goto +3985 -> 12428
    //   8446: aload_0
    //   8447: aload_3
    //   8448: aload 20
    //   8450: invokespecial 3247	aevk:h	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8453: goto +3975 -> 12428
    //   8456: aload_0
    //   8457: aload 20
    //   8459: invokespecial 3249	aevk:g	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8462: goto +3966 -> 12428
    //   8465: aload_0
    //   8466: aload 20
    //   8468: invokespecial 3251	aevk:h	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8471: goto +3957 -> 12428
    //   8474: aload_0
    //   8475: aload_2
    //   8476: aload 20
    //   8478: invokespecial 3254	aevk:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8481: goto +3947 -> 12428
    //   8484: aload_2
    //   8485: invokestatic 1766	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   8488: aload_2
    //   8489: aload 18
    //   8491: invokevirtual 607	java/lang/Integer:intValue	()I
    //   8494: aload_3
    //   8495: aload 20
    //   8497: invokevirtual 3258	com/tencent/mobileqq/utils/BusinessCommonConfig:decodeConfig	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)Ljava/lang/Boolean;
    //   8500: pop
    //   8501: goto +3927 -> 12428
    //   8504: aload 20
    //   8506: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8509: ifnull +164 -> 8673
    //   8512: aload 20
    //   8514: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8517: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8520: ifle +153 -> 8673
    //   8523: aload 20
    //   8525: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8528: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8531: invokeinterface 397 1 0
    //   8536: astore 17
    //   8538: aload 17
    //   8540: invokeinterface 402 1 0
    //   8545: ifeq +167 -> 8712
    //   8548: aload 17
    //   8550: invokeinterface 406 1 0
    //   8555: checkcast 115	java/lang/String
    //   8558: astore 18
    //   8560: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8563: ifeq +47 -> 8610
    //   8566: ldc 169
    //   8568: iconst_2
    //   8569: new 68	java/lang/StringBuilder
    //   8572: dup
    //   8573: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8576: ldc_w 3260
    //   8579: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8582: aload 18
    //   8584: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8587: ldc_w 410
    //   8590: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8593: aload 20
    //   8595: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8598: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8601: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8604: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8607: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8610: aload_0
    //   8611: aload 18
    //   8613: aload 20
    //   8615: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8618: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8621: invokespecial 3263	aevk:eq	(Ljava/lang/String;I)V
    //   8624: goto -86 -> 8538
    //   8627: astore 17
    //   8629: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8632: ifeq +33 -> 8665
    //   8635: ldc 169
    //   8637: iconst_2
    //   8638: new 68	java/lang/StringBuilder
    //   8641: dup
    //   8642: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8645: ldc_w 3265
    //   8648: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8651: aload 17
    //   8653: invokevirtual 859	java/lang/Exception:toString	()Ljava/lang/String;
    //   8656: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8659: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8662: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8665: aload 17
    //   8667: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   8670: goto +3758 -> 12428
    //   8673: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8676: ifeq +36 -> 8712
    //   8679: ldc 169
    //   8681: iconst_2
    //   8682: new 68	java/lang/StringBuilder
    //   8685: dup
    //   8686: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8689: ldc_w 3267
    //   8692: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8695: aload 20
    //   8697: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8700: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8703: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8706: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8709: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8712: goto +3716 -> 12428
    //   8715: aload 20
    //   8717: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8720: ifnull +164 -> 8884
    //   8723: aload 20
    //   8725: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8728: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   8731: ifle +153 -> 8884
    //   8734: aload 20
    //   8736: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   8739: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   8742: invokeinterface 397 1 0
    //   8747: astore 17
    //   8749: aload 17
    //   8751: invokeinterface 402 1 0
    //   8756: ifeq +167 -> 8923
    //   8759: aload 17
    //   8761: invokeinterface 406 1 0
    //   8766: checkcast 115	java/lang/String
    //   8769: astore 18
    //   8771: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8774: ifeq +47 -> 8821
    //   8777: ldc 169
    //   8779: iconst_2
    //   8780: new 68	java/lang/StringBuilder
    //   8783: dup
    //   8784: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8787: ldc_w 3269
    //   8790: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8793: aload 18
    //   8795: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8798: ldc_w 410
    //   8801: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8804: aload 20
    //   8806: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8809: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8812: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8815: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8818: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8821: aload_0
    //   8822: aload 18
    //   8824: aload 20
    //   8826: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8829: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8832: invokespecial 3272	aevk:er	(Ljava/lang/String;I)V
    //   8835: goto -86 -> 8749
    //   8838: astore 17
    //   8840: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8843: ifeq +33 -> 8876
    //   8846: ldc 169
    //   8848: iconst_2
    //   8849: new 68	java/lang/StringBuilder
    //   8852: dup
    //   8853: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8856: ldc_w 3274
    //   8859: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8862: aload 17
    //   8864: invokevirtual 859	java/lang/Exception:toString	()Ljava/lang/String;
    //   8867: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8870: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8873: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8876: aload 17
    //   8878: invokevirtual 373	java/lang/Exception:printStackTrace	()V
    //   8881: goto +3547 -> 12428
    //   8884: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8887: ifeq +36 -> 8923
    //   8890: ldc 169
    //   8892: iconst_2
    //   8893: new 68	java/lang/StringBuilder
    //   8896: dup
    //   8897: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   8900: ldc_w 3276
    //   8903: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8906: aload 20
    //   8908: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   8911: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   8914: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8917: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8920: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8923: goto +3505 -> 12428
    //   8926: aload_0
    //   8927: aload 20
    //   8929: invokespecial 3278	aevk:r	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8932: goto +3496 -> 12428
    //   8935: aload_0
    //   8936: aload 20
    //   8938: invokespecial 3280	aevk:o	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8941: goto +3487 -> 12428
    //   8944: aload_0
    //   8945: aload 20
    //   8947: invokespecial 3282	aevk:p	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8950: goto +3478 -> 12428
    //   8953: aload_0
    //   8954: aload 20
    //   8956: invokespecial 3284	aevk:q	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8959: goto +3469 -> 12428
    //   8962: aload_0
    //   8963: aload 20
    //   8965: invokespecial 3286	aevk:v	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8968: goto +3460 -> 12428
    //   8971: aload_0
    //   8972: aload 20
    //   8974: invokespecial 3288	aevk:t	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8977: goto +3451 -> 12428
    //   8980: aload_0
    //   8981: aload 20
    //   8983: invokespecial 3290	aevk:c	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8986: goto +3442 -> 12428
    //   8989: aload_0
    //   8990: aload 20
    //   8992: invokespecial 3292	aevk:s	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   8995: goto +3433 -> 12428
    //   8998: aload_0
    //   8999: aload 20
    //   9001: invokespecial 3294	aevk:u	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9004: goto +3424 -> 12428
    //   9007: aload_0
    //   9008: aload 20
    //   9010: invokespecial 3296	aevk:k	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9013: goto +3415 -> 12428
    //   9016: aload_0
    //   9017: aload 20
    //   9019: invokevirtual 3298	aevk:l	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9022: goto +3406 -> 12428
    //   9025: aload_0
    //   9026: aload 20
    //   9028: invokevirtual 3300	aevk:m	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9031: goto +3397 -> 12428
    //   9034: aload_0
    //   9035: aload 20
    //   9037: invokespecial 3302	aevk:x	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9040: goto +3388 -> 12428
    //   9043: aload_0
    //   9044: aload 20
    //   9046: invokespecial 3304	aevk:y	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9049: goto +3379 -> 12428
    //   9052: aload_0
    //   9053: aload 20
    //   9055: invokespecial 3306	aevk:B	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9058: goto +3370 -> 12428
    //   9061: aload_0
    //   9062: aload 20
    //   9064: invokespecial 3308	aevk:D	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9067: goto +3361 -> 12428
    //   9070: aload_0
    //   9071: aload 20
    //   9073: invokespecial 3311	aevk:z	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9076: goto +3352 -> 12428
    //   9079: aload_0
    //   9080: aload 20
    //   9082: invokespecial 3313	aevk:A	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9085: goto +3343 -> 12428
    //   9088: aload_0
    //   9089: aload 20
    //   9091: invokespecial 3315	aevk:n	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9094: goto +3334 -> 12428
    //   9097: aload_0
    //   9098: aload 20
    //   9100: invokespecial 3317	aevk:w	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9103: goto +3325 -> 12428
    //   9106: invokestatic 3320	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   9109: aload_1
    //   9110: ldc 18
    //   9112: invokevirtual 3323	com/tencent/mobileqq/app/DeviceProfileManager:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Ljava/lang/String;)Z
    //   9115: pop
    //   9116: goto +3312 -> 12428
    //   9119: aload_0
    //   9120: aload 20
    //   9122: invokespecial 3325	aevk:e	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9125: goto +3303 -> 12428
    //   9128: aload_0
    //   9129: aload 20
    //   9131: invokespecial 3327	aevk:f	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9134: goto +3294 -> 12428
    //   9137: aload_0
    //   9138: aload 20
    //   9140: invokevirtual 3329	aevk:d	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9143: goto +3285 -> 12428
    //   9146: aload_0
    //   9147: aload 20
    //   9149: invokespecial 3331	aevk:C	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9152: goto +3276 -> 12428
    //   9155: aload 20
    //   9157: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9160: ifnull +141 -> 9301
    //   9163: aload 20
    //   9165: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9168: invokevirtual 110	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   9171: ifle +130 -> 9301
    //   9174: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9177: ifeq +68 -> 9245
    //   9180: ldc 169
    //   9182: iconst_2
    //   9183: new 68	java/lang/StringBuilder
    //   9186: dup
    //   9187: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   9190: ldc_w 3333
    //   9193: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9196: aload 18
    //   9198: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9201: ldc_w 3157
    //   9204: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9207: aload 20
    //   9209: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9212: iconst_0
    //   9213: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   9216: checkcast 115	java/lang/String
    //   9219: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9222: ldc_w 410
    //   9225: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9228: aload 20
    //   9230: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9233: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9236: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9239: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9242: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9245: aload_2
    //   9246: sipush 169
    //   9249: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9252: checkcast 3335	cooperation/photoplus/PhotoPlusManager
    //   9255: aload 20
    //   9257: getfield 105	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:content_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   9260: iconst_0
    //   9261: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   9264: checkcast 115	java/lang/String
    //   9267: invokevirtual 3338	cooperation/photoplus/PhotoPlusManager:tk	(Ljava/lang/String;)Z
    //   9270: ifeq +3158 -> 12428
    //   9273: aload_0
    //   9274: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   9277: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   9280: aload_0
    //   9281: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   9284: invokevirtual 3085	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   9287: aload 20
    //   9289: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9292: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9295: invokestatic 3340	aqmj:W	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9298: goto +3130 -> 12428
    //   9301: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9304: ifeq +3124 -> 12428
    //   9307: ldc 169
    //   9309: iconst_2
    //   9310: new 68	java/lang/StringBuilder
    //   9313: dup
    //   9314: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   9317: ldc_w 3333
    //   9320: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9323: aload 18
    //   9325: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9328: ldc_w 3342
    //   9331: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9334: aload 20
    //   9336: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9339: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9342: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9345: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9348: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9351: goto +3077 -> 12428
    //   9354: aload_0
    //   9355: aload_2
    //   9356: aload 20
    //   9358: invokevirtual 3344	aevk:D	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9361: goto +3067 -> 12428
    //   9364: aload_0
    //   9365: aload_3
    //   9366: iload 5
    //   9368: aload 20
    //   9370: aload_1
    //   9371: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9374: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9377: invokevirtual 3347	aevk:a	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   9380: goto +3048 -> 12428
    //   9383: aload_0
    //   9384: aload_3
    //   9385: aload 20
    //   9387: invokespecial 3349	aevk:b	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9390: goto +3038 -> 12428
    //   9393: aload_0
    //   9394: aload_3
    //   9395: aload 20
    //   9397: invokespecial 3351	aevk:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9400: goto +3028 -> 12428
    //   9403: aload_0
    //   9404: aload_3
    //   9405: aload 20
    //   9407: invokespecial 3353	aevk:d	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9410: goto +3018 -> 12428
    //   9413: aload_0
    //   9414: aload_3
    //   9415: aload 20
    //   9417: invokevirtual 3355	aevk:c	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9420: goto +3008 -> 12428
    //   9423: aload_0
    //   9424: aload_2
    //   9425: aload_3
    //   9426: aload 20
    //   9428: invokevirtual 3357	aevk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9431: goto +2997 -> 12428
    //   9434: aload_0
    //   9435: aload_2
    //   9436: aload 20
    //   9438: invokespecial 3359	aevk:g	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9441: goto +2987 -> 12428
    //   9444: aload_0
    //   9445: aload_2
    //   9446: aload 20
    //   9448: invokespecial 3361	aevk:v	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9451: goto +2977 -> 12428
    //   9454: aload 18
    //   9456: invokevirtual 607	java/lang/Integer:intValue	()I
    //   9459: aload_2
    //   9460: invokevirtual 1851	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   9463: aload 20
    //   9465: invokestatic 3364	igo:a	(ILjava/lang/String;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9468: goto +2960 -> 12428
    //   9471: aload_0
    //   9472: aload_2
    //   9473: aload 20
    //   9475: invokevirtual 3366	aevk:u	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9478: goto +2950 -> 12428
    //   9481: aload_0
    //   9482: aload_3
    //   9483: iload 5
    //   9485: aload 20
    //   9487: aload_1
    //   9488: getfield 2639	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9491: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9494: invokevirtual 3368	aevk:b	(Landroid/content/Intent;ZLcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   9497: goto +2931 -> 12428
    //   9500: aload_0
    //   9501: aload_2
    //   9502: aload 20
    //   9504: invokespecial 3370	aevk:m	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9507: goto +2921 -> 12428
    //   9510: aload_0
    //   9511: aload_2
    //   9512: aload 20
    //   9514: invokespecial 3372	aevk:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9517: goto +2911 -> 12428
    //   9520: aload_0
    //   9521: aload_2
    //   9522: aload 20
    //   9524: invokespecial 3374	aevk:i	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9527: goto +2901 -> 12428
    //   9530: aload_0
    //   9531: aload_2
    //   9532: aload 20
    //   9534: invokespecial 3376	aevk:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9537: goto +2891 -> 12428
    //   9540: aload_0
    //   9541: aload_2
    //   9542: aload 20
    //   9544: invokespecial 3378	aevk:k	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9547: goto +2881 -> 12428
    //   9550: aload_0
    //   9551: aload_2
    //   9552: aload 20
    //   9554: invokevirtual 3380	aevk:l	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9557: goto +2871 -> 12428
    //   9560: aload_0
    //   9561: aload_2
    //   9562: aload 20
    //   9564: invokespecial 3382	aevk:w	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9567: goto +2861 -> 12428
    //   9570: aload_0
    //   9571: aload_2
    //   9572: aload 20
    //   9574: invokespecial 3384	aevk:x	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9577: goto +2851 -> 12428
    //   9580: aload_0
    //   9581: aload_2
    //   9582: aload 20
    //   9584: invokespecial 3386	aevk:y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9587: goto +2841 -> 12428
    //   9590: aload 20
    //   9592: invokestatic 3388	amxh:G	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9595: goto +2833 -> 12428
    //   9598: aload_0
    //   9599: aload_2
    //   9600: aload 20
    //   9602: invokespecial 3390	aevk:z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9605: goto +2823 -> 12428
    //   9608: aload_0
    //   9609: aload_2
    //   9610: aload 20
    //   9612: invokespecial 3392	aevk:A	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9615: goto +2813 -> 12428
    //   9618: aload_0
    //   9619: aload_2
    //   9620: aload 20
    //   9622: invokespecial 3394	aevk:B	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9625: goto +2803 -> 12428
    //   9628: aload_0
    //   9629: aload_2
    //   9630: aload 20
    //   9632: invokespecial 3396	aevk:C	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9635: goto +2793 -> 12428
    //   9638: aload_0
    //   9639: aload_2
    //   9640: aload 20
    //   9642: invokevirtual 3398	aevk:F	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9645: goto +2783 -> 12428
    //   9648: aload_0
    //   9649: aload_3
    //   9650: aload 20
    //   9652: invokespecial 3400	aevk:m	(Landroid/content/Intent;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9655: goto +2773 -> 12428
    //   9658: aload_0
    //   9659: aload_2
    //   9660: aload 20
    //   9662: invokespecial 3402	aevk:E	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9665: goto +2763 -> 12428
    //   9668: aload_0
    //   9669: aload_2
    //   9670: aload 20
    //   9672: invokevirtual 3404	aevk:L	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9675: goto +2753 -> 12428
    //   9678: aload_0
    //   9679: aload_2
    //   9680: aload 20
    //   9682: invokevirtual 3406	aevk:I	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9685: goto +2743 -> 12428
    //   9688: aload_2
    //   9689: sipush 208
    //   9692: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9695: checkcast 2124	rnu
    //   9698: getfield 2127	rnu:a	Lrnt;
    //   9701: aload_2
    //   9702: aload 20
    //   9704: invokevirtual 3409	rnt:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9707: goto +2721 -> 12428
    //   9710: aload_0
    //   9711: aload_2
    //   9712: aload 20
    //   9714: invokevirtual 3411	aevk:H	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9717: goto +2711 -> 12428
    //   9720: aload_0
    //   9721: aload_2
    //   9722: aload 20
    //   9724: invokevirtual 3413	aevk:J	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9727: goto +2701 -> 12428
    //   9730: aload_0
    //   9731: aload_2
    //   9732: aload 20
    //   9734: invokevirtual 3415	aevk:M	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9737: goto +2691 -> 12428
    //   9740: aload_0
    //   9741: aload_2
    //   9742: aload 20
    //   9744: invokevirtual 3417	aevk:N	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9747: goto +2681 -> 12428
    //   9750: aload_0
    //   9751: aload_2
    //   9752: aload 20
    //   9754: invokevirtual 3419	aevk:O	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9757: goto +2671 -> 12428
    //   9760: aload_0
    //   9761: aload_2
    //   9762: aload 20
    //   9764: invokevirtual 3421	aevk:R	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9767: goto +2661 -> 12428
    //   9770: aload_2
    //   9771: aload 20
    //   9773: invokestatic 3423	sna:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9776: goto +2652 -> 12428
    //   9779: aload_0
    //   9780: aload_2
    //   9781: aload 20
    //   9783: invokespecial 3425	aevk:P	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9786: goto +2642 -> 12428
    //   9789: aload_0
    //   9790: aload_2
    //   9791: aload 20
    //   9793: invokevirtual 3427	aevk:Q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9796: goto +2632 -> 12428
    //   9799: aload_0
    //   9800: aload_2
    //   9801: aload 20
    //   9803: invokevirtual 3429	aevk:S	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9806: goto +2622 -> 12428
    //   9809: aload_0
    //   9810: aload_2
    //   9811: aload 20
    //   9813: invokevirtual 3431	aevk:G	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9816: goto +2612 -> 12428
    //   9819: aload_0
    //   9820: aload_2
    //   9821: aload 20
    //   9823: invokevirtual 3433	aevk:T	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9826: goto +2602 -> 12428
    //   9829: aload_0
    //   9830: aload_2
    //   9831: aload 20
    //   9833: invokespecial 3435	aevk:o	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9836: goto +2592 -> 12428
    //   9839: aload_0
    //   9840: aload_2
    //   9841: aload 20
    //   9843: invokespecial 3437	aevk:p	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9846: goto +2582 -> 12428
    //   9849: aload_0
    //   9850: aload_2
    //   9851: aload 20
    //   9853: invokevirtual 3439	aevk:K	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9856: goto +2572 -> 12428
    //   9859: aload_0
    //   9860: aload_2
    //   9861: aload 20
    //   9863: invokevirtual 3441	aevk:V	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9866: goto +2562 -> 12428
    //   9869: aload_2
    //   9870: aload 20
    //   9872: invokestatic 3443	aevk:U	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9875: goto +2553 -> 12428
    //   9878: aload 20
    //   9880: aload_2
    //   9881: invokevirtual 1587	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9884: invokestatic 2231	aasr:ak	(Landroid/content/Context;)I
    //   9887: sipush 199
    //   9890: invokestatic 3445	aevk:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9893: astore 17
    //   9895: aload 17
    //   9897: ifnull +2531 -> 12428
    //   9900: aload_2
    //   9901: invokevirtual 1587	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9904: aload 17
    //   9906: aload 20
    //   9908: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9911: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9914: invokestatic 3447	aasr:n	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9917: goto +2511 -> 12428
    //   9920: aload 20
    //   9922: aload_2
    //   9923: invokevirtual 1587	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9926: invokestatic 2234	alwh:ak	(Landroid/content/Context;)I
    //   9929: sipush 225
    //   9932: invokestatic 3445	aevk:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   9935: astore 17
    //   9937: aload 17
    //   9939: ifnull +2489 -> 12428
    //   9942: invokestatic 3450	alwh:a	()Lalwh;
    //   9945: aload_2
    //   9946: invokevirtual 1587	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   9949: aload 17
    //   9951: aload 20
    //   9953: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   9956: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   9959: invokevirtual 3451	alwh:n	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9962: goto +2466 -> 12428
    //   9965: aload_0
    //   9966: aload_2
    //   9967: aload 20
    //   9969: invokevirtual 3453	aevk:W	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9972: goto +2456 -> 12428
    //   9975: aload_0
    //   9976: aload_2
    //   9977: aload 20
    //   9979: invokevirtual 3455	aevk:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9982: goto +2446 -> 12428
    //   9985: aload_0
    //   9986: aload_2
    //   9987: aload 20
    //   9989: invokespecial 3457	aevk:X	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   9992: goto +2436 -> 12428
    //   9995: aload_2
    //   9996: aload 20
    //   9998: invokestatic 3459	aevk:Y	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10001: goto +2427 -> 12428
    //   10004: aload_2
    //   10005: aload 20
    //   10007: invokestatic 3461	aevk:ar	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10010: goto +2418 -> 12428
    //   10013: aload_0
    //   10014: aload_2
    //   10015: aload 20
    //   10017: invokespecial 3463	aevk:as	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10020: goto +2408 -> 12428
    //   10023: aload_2
    //   10024: aload 20
    //   10026: invokestatic 3465	aevk:at	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10029: goto +2399 -> 12428
    //   10032: aload_0
    //   10033: aload_2
    //   10034: aload 20
    //   10036: aload_3
    //   10037: ldc_w 2572
    //   10040: invokevirtual 1643	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   10043: invokespecial 3467	aevk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;Ljava/lang/String;)I
    //   10046: invokestatic 3470	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:UN	(I)V
    //   10049: goto +2379 -> 12428
    //   10052: aload_2
    //   10053: sipush 238
    //   10056: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10059: checkcast 3472	jxo
    //   10062: astore 17
    //   10064: aload 17
    //   10066: ifnull +2362 -> 12428
    //   10069: aload 17
    //   10071: aload_2
    //   10072: aload 20
    //   10074: invokevirtual 3474	jxo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10077: goto +2351 -> 12428
    //   10080: aload_0
    //   10081: aload_2
    //   10082: aload 20
    //   10084: invokevirtual 3476	aevk:aa	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10087: goto +2341 -> 12428
    //   10090: aload_0
    //   10091: aload_2
    //   10092: aload 20
    //   10094: invokespecial 3478	aevk:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10097: goto +2331 -> 12428
    //   10100: aload_0
    //   10101: aload_2
    //   10102: aload 20
    //   10104: invokevirtual 3480	aevk:Z	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10107: goto +2321 -> 12428
    //   10110: aload_0
    //   10111: aload_2
    //   10112: aload 20
    //   10114: invokevirtual 3482	aevk:ah	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10117: goto +2311 -> 12428
    //   10120: aload_0
    //   10121: aload_2
    //   10122: aload 20
    //   10124: invokevirtual 3484	aevk:ab	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10127: goto +2301 -> 12428
    //   10130: aload_0
    //   10131: aload_2
    //   10132: aload 20
    //   10134: invokevirtual 3486	aevk:ac	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10137: goto +2291 -> 12428
    //   10140: aload_0
    //   10141: aload_2
    //   10142: aload 20
    //   10144: invokevirtual 3488	aevk:ad	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10147: goto +2281 -> 12428
    //   10150: aload_0
    //   10151: aload_2
    //   10152: aload 20
    //   10154: invokevirtual 3490	aevk:ae	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10157: goto +2271 -> 12428
    //   10160: aload_0
    //   10161: aload_2
    //   10162: aload 20
    //   10164: invokevirtual 3492	aevk:af	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10167: goto +2261 -> 12428
    //   10170: aload_0
    //   10171: aload_2
    //   10172: aload 20
    //   10174: invokevirtual 3494	aevk:ag	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10177: goto +2251 -> 12428
    //   10180: aload_0
    //   10181: aload_2
    //   10182: aload 20
    //   10184: invokespecial 3496	aevk:q	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10187: goto +2241 -> 12428
    //   10190: aload_0
    //   10191: aload_2
    //   10192: aload 20
    //   10194: invokespecial 3498	aevk:r	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10197: goto +2231 -> 12428
    //   10200: aload_0
    //   10201: aload_2
    //   10202: aload 20
    //   10204: invokespecial 3500	aevk:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10207: goto +2221 -> 12428
    //   10210: aload_0
    //   10211: aload_2
    //   10212: aload 20
    //   10214: invokevirtual 3502	aevk:ai	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10217: goto +2211 -> 12428
    //   10220: aload_2
    //   10221: aload 20
    //   10223: invokestatic 3506	apml:aw	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10226: goto +2202 -> 12428
    //   10229: aload_2
    //   10230: bipush 52
    //   10232: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10235: checkcast 2299	com/tencent/mobileqq/app/TroopManager
    //   10238: getfield 2302	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Apgz	Lapgz;
    //   10241: aload_2
    //   10242: aload 20
    //   10244: invokevirtual 3507	apgz:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10247: goto +2181 -> 12428
    //   10250: aload_2
    //   10251: bipush 52
    //   10253: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10256: checkcast 2299	com/tencent/mobileqq/app/TroopManager
    //   10259: getfield 2308	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Apir	Lapir;
    //   10262: aload_2
    //   10263: aload 20
    //   10265: invokevirtual 3509	apir:av	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10268: goto +2160 -> 12428
    //   10271: aload_2
    //   10272: invokestatic 3514	plz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lplz;
    //   10275: aload 20
    //   10277: invokevirtual 3516	plz:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10280: goto +2148 -> 12428
    //   10283: aload_2
    //   10284: sipush 197
    //   10287: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10290: checkcast 3518	pmj
    //   10293: aload 20
    //   10295: invokevirtual 3519	pmj:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10298: goto +2130 -> 12428
    //   10301: invokestatic 2321	ahwy:a	()Lahwy;
    //   10304: getfield 2324	ahwy:a	Lahwy$a;
    //   10307: aload 20
    //   10309: invokevirtual 3520	ahwy$a:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10312: goto +2116 -> 12428
    //   10315: astore 17
    //   10317: aload 17
    //   10319: invokevirtual 670	java/lang/Throwable:printStackTrace	()V
    //   10322: goto +2106 -> 12428
    //   10325: aload_2
    //   10326: aload 20
    //   10328: invokestatic 3523	com/tencent/mobileqq/shortvideo/util/RecentDanceConfigMgr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   10331: pop
    //   10332: goto +2096 -> 12428
    //   10335: aload_2
    //   10336: aload 20
    //   10338: invokestatic 3525	dov/com/qq/im/ptv/LightVideoConfigMgr:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)I
    //   10341: pop
    //   10342: goto +2086 -> 12428
    //   10345: aload_0
    //   10346: aload_2
    //   10347: aload 20
    //   10349: invokevirtual 3528	aevk:aj	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10352: goto +2076 -> 12428
    //   10355: aload_0
    //   10356: aload_2
    //   10357: aload 20
    //   10359: invokevirtual 3530	aevk:ak	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10362: goto +2066 -> 12428
    //   10365: aload_0
    //   10366: aload_2
    //   10367: aload 20
    //   10369: invokevirtual 3532	aevk:al	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10372: goto +2056 -> 12428
    //   10375: aload_2
    //   10376: aload 20
    //   10378: aload 18
    //   10380: invokevirtual 607	java/lang/Integer:intValue	()I
    //   10383: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   10386: invokestatic 3537	anor:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;ILjava/lang/String;)V
    //   10389: goto +2039 -> 12428
    //   10392: aload_0
    //   10393: aload_2
    //   10394: aload 20
    //   10396: invokevirtual 3539	aevk:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10399: goto +2029 -> 12428
    //   10402: aload_2
    //   10403: aload 18
    //   10405: invokevirtual 607	java/lang/Integer:intValue	()I
    //   10408: aload 20
    //   10410: invokestatic 3544	afam:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10413: goto +2015 -> 12428
    //   10416: aload_2
    //   10417: invokestatic 3549	aheq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laheq;
    //   10420: aload_2
    //   10421: aload 18
    //   10423: aload 20
    //   10425: invokevirtual 3552	aheq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/Integer;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10428: goto +2000 -> 12428
    //   10431: aload_0
    //   10432: aload_2
    //   10433: aload 20
    //   10435: invokevirtual 3554	aevk:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10438: goto +1990 -> 12428
    //   10441: aload_0
    //   10442: aload_2
    //   10443: aload 20
    //   10445: invokevirtual 3556	aevk:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10448: goto +1980 -> 12428
    //   10451: aload_2
    //   10452: sipush 181
    //   10455: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10458: checkcast 2369	pmb
    //   10461: getfield 2372	pmb:a	Lprt;
    //   10464: aload_2
    //   10465: aload 20
    //   10467: invokevirtual 3557	prt:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10470: goto +1958 -> 12428
    //   10473: aload_0
    //   10474: aload_2
    //   10475: aload 20
    //   10477: invokespecial 3559	aevk:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10480: goto +1948 -> 12428
    //   10483: aload_2
    //   10484: aload 20
    //   10486: invokestatic 3561	aevk:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10489: goto +1939 -> 12428
    //   10492: aload_2
    //   10493: aload 18
    //   10495: invokevirtual 607	java/lang/Integer:intValue	()I
    //   10498: aload 20
    //   10500: invokestatic 3565	armm:b	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10503: goto +1925 -> 12428
    //   10506: aload_2
    //   10507: bipush 52
    //   10509: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10512: checkcast 2299	com/tencent/mobileqq/app/TroopManager
    //   10515: getfield 2391	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_Smw	Lsmw;
    //   10518: aload_2
    //   10519: aload 20
    //   10521: invokevirtual 3566	smw:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10524: goto +1904 -> 12428
    //   10527: aload_0
    //   10528: aload_2
    //   10529: aload 20
    //   10531: aload 18
    //   10533: invokevirtual 607	java/lang/Integer:intValue	()I
    //   10536: invokespecial 3568	aevk:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10539: goto +1889 -> 12428
    //   10542: aload_2
    //   10543: aload 20
    //   10545: invokestatic 3570	aevk:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10548: goto +1880 -> 12428
    //   10551: aload_0
    //   10552: aload_2
    //   10553: aload 20
    //   10555: invokespecial 3572	aevk:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10558: goto +1870 -> 12428
    //   10561: aload_2
    //   10562: sipush 306
    //   10565: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10568: checkcast 3574	aifl
    //   10571: aload 20
    //   10573: invokevirtual 3576	aifl:F	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10576: goto +1852 -> 12428
    //   10579: aload_0
    //   10580: aload 20
    //   10582: invokespecial 3578	aevk:E	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10585: goto +1843 -> 12428
    //   10588: aload_2
    //   10589: sipush 236
    //   10592: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10595: checkcast 3580	aicu
    //   10598: aload 20
    //   10600: invokevirtual 3581	aicu:F	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10603: goto +1825 -> 12428
    //   10606: aload_0
    //   10607: aload_2
    //   10608: aload 20
    //   10610: invokespecial 3583	aevk:aq	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10613: goto +1815 -> 12428
    //   10616: aload_0
    //   10617: aload_2
    //   10618: aload 20
    //   10620: aload 18
    //   10622: invokevirtual 607	java/lang/Integer:intValue	()I
    //   10625: invokespecial 3585	aevk:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;I)V
    //   10628: goto +1800 -> 12428
    //   10631: aload_0
    //   10632: aload_2
    //   10633: aload 20
    //   10635: invokespecial 3587	aevk:au	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   10638: goto +1790 -> 12428
    //   10641: aload 4
    //   10643: ifnull +309 -> 10952
    //   10646: iload 11
    //   10648: ifne +32 -> 10680
    //   10651: aload_2
    //   10652: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10655: ldc_w 2879
    //   10658: invokestatic 2884	aqiz:isAppInstalled	(Landroid/content/Context;Ljava/lang/String;)Z
    //   10661: ifne +19 -> 10680
    //   10664: aload_2
    //   10665: sipush 256
    //   10668: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10671: checkcast 3589	com/tencent/mobileqq/upgrade/UpgradeTIMManager
    //   10674: aload_2
    //   10675: aload 4
    //   10677: invokevirtual 3591	com/tencent/mobileqq/upgrade/UpgradeTIMManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   10680: invokestatic 2837	java/lang/System:currentTimeMillis	()J
    //   10683: lstore 15
    //   10685: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10688: ifeq +44 -> 10732
    //   10691: ldc 169
    //   10693: iconst_2
    //   10694: new 68	java/lang/StringBuilder
    //   10697: dup
    //   10698: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   10701: ldc_w 3593
    //   10704: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10707: lload 15
    //   10709: lload 13
    //   10711: lsub
    //   10712: invokevirtual 3596	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10715: ldc_w 3598
    //   10718: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10721: iload 11
    //   10723: invokevirtual 692	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10726: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10729: invokestatic 902	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   10732: aconst_null
    //   10733: astore 4
    //   10735: aload_3
    //   10736: ifnull +1651 -> 12387
    //   10739: aload_3
    //   10740: ldc_w 1024
    //   10743: iconst_0
    //   10744: invokevirtual 2538	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   10747: istore 11
    //   10749: iload 11
    //   10751: ifeq +220 -> 10971
    //   10754: aload_3
    //   10755: ldc_w 3600
    //   10758: iconst_0
    //   10759: invokevirtual 1492	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   10762: istore 8
    //   10764: ldc 169
    //   10766: iconst_2
    //   10767: iconst_2
    //   10768: anewarray 178	java/lang/Object
    //   10771: dup
    //   10772: iconst_0
    //   10773: ldc_w 3602
    //   10776: aastore
    //   10777: dup
    //   10778: iconst_1
    //   10779: iload 8
    //   10781: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10784: aastore
    //   10785: invokestatic 1913	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   10788: iload 8
    //   10790: istore 6
    //   10792: iload 11
    //   10794: istore 5
    //   10796: aload 4
    //   10798: astore_3
    //   10799: iload 8
    //   10801: iconst_3
    //   10802: if_icmpge +179 -> 10981
    //   10805: aload_1
    //   10806: getfield 3605	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:next_req_types	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   10809: invokevirtual 389	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   10812: astore 17
    //   10814: iload 8
    //   10816: istore 6
    //   10818: iload 11
    //   10820: istore 5
    //   10822: aload 4
    //   10824: astore_3
    //   10825: aload 17
    //   10827: ifnull +154 -> 10981
    //   10830: iload 8
    //   10832: istore 6
    //   10834: iload 11
    //   10836: istore 5
    //   10838: aload 4
    //   10840: astore_3
    //   10841: aload 17
    //   10843: invokeinterface 225 1 0
    //   10848: ifle +133 -> 10981
    //   10851: aload 17
    //   10853: invokeinterface 225 1 0
    //   10858: newarray int
    //   10860: astore 4
    //   10862: aload 17
    //   10864: invokeinterface 225 1 0
    //   10869: istore 9
    //   10871: iconst_0
    //   10872: istore 7
    //   10874: iload 8
    //   10876: istore 6
    //   10878: iload 11
    //   10880: istore 5
    //   10882: aload 4
    //   10884: astore_3
    //   10885: iload 7
    //   10887: iload 9
    //   10889: if_icmpge +92 -> 10981
    //   10892: aload 17
    //   10894: iload 7
    //   10896: invokeinterface 226 2 0
    //   10901: checkcast 208	java/lang/Integer
    //   10904: invokevirtual 607	java/lang/Integer:intValue	()I
    //   10907: istore 6
    //   10909: aload 4
    //   10911: iload 7
    //   10913: iload 6
    //   10915: iastore
    //   10916: aload 19
    //   10918: invokeinterface 225 1 0
    //   10923: ifle +20 -> 10943
    //   10926: aload 19
    //   10928: new 208	java/lang/Integer
    //   10931: dup
    //   10932: iload 6
    //   10934: invokespecial 2839	java/lang/Integer:<init>	(I)V
    //   10937: invokeinterface 2841 2 0
    //   10942: pop
    //   10943: iload 7
    //   10945: iconst_1
    //   10946: iadd
    //   10947: istore 7
    //   10949: goto -75 -> 10874
    //   10952: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10955: ifeq -275 -> 10680
    //   10958: ldc_w 2049
    //   10961: iconst_2
    //   10962: ldc_w 3607
    //   10965: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10968: goto -288 -> 10680
    //   10971: iconst_0
    //   10972: istore 6
    //   10974: aload 4
    //   10976: astore_3
    //   10977: iload 11
    //   10979: istore 5
    //   10981: aload 19
    //   10983: invokeinterface 397 1 0
    //   10988: astore 4
    //   10990: aload 4
    //   10992: invokeinterface 402 1 0
    //   10997: ifeq +1185 -> 12182
    //   11000: aload 4
    //   11002: invokeinterface 406 1 0
    //   11007: checkcast 208	java/lang/Integer
    //   11010: astore 17
    //   11012: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11015: ifeq +46 -> 11061
    //   11018: ldc 169
    //   11020: iconst_2
    //   11021: new 68	java/lang/StringBuilder
    //   11024: dup
    //   11025: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   11028: ldc_w 3609
    //   11031: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11034: aload 17
    //   11036: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11039: ldc_w 2424
    //   11042: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11045: aload 19
    //   11047: invokeinterface 225 1 0
    //   11052: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11055: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11058: invokestatic 902	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   11061: new 68	java/lang/StringBuilder
    //   11064: dup
    //   11065: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   11068: ldc_w 3611
    //   11071: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11074: aload 17
    //   11076: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11079: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11082: invokestatic 2434	aevk:Hx	(Ljava/lang/String;)V
    //   11085: aload 17
    //   11087: invokevirtual 607	java/lang/Integer:intValue	()I
    //   11090: lookupswitch	default:+194->11284, 1:+652->11742, 38:+598->11688, 42:+931->12021, 46:+591->11681, 86:+885->11975, 87:+787->11877, 113:+939->12029, 116:+225->11315, 119:+1001->12091, 156:+-100->10990, 185:+1027->12117, 188:+830->11920, 191:+1055->12145, 202:+1036->12126, 205:+867->11957, 206:+849->11939, 215:+1071->12161, 223:+985->12075, 231:+-100->10990, 297:+1077->12167, 345:+1084->12174, 364:+985->12075, 365:+985->12075
    //   11285: iconst_2
    //   11286: impdep1
    //   11287: aload 17
    //   11289: invokevirtual 607	java/lang/Integer:intValue	()I
    //   11292: invokevirtual 1537	aeif:jg	(I)Z
    //   11295: ifeq -305 -> 10990
    //   11298: invokestatic 1534	aeif:a	()Laeif;
    //   11301: aload 17
    //   11303: invokevirtual 607	java/lang/Integer:intValue	()I
    //   11306: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   11309: invokevirtual 3614	aeif:cj	(ILjava/lang/String;)V
    //   11312: goto -322 -> 10990
    //   11315: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11318: ifeq +12 -> 11330
    //   11321: ldc 169
    //   11323: iconst_2
    //   11324: ldc_w 3616
    //   11327: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11330: aload_2
    //   11331: iconst_4
    //   11332: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   11335: checkcast 2042	accy
    //   11338: astore 18
    //   11340: ldc_w 2905
    //   11343: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   11346: invokestatic 3619	aqan:bS	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11349: astore 20
    //   11351: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11354: ifeq +30 -> 11384
    //   11357: ldc 169
    //   11359: iconst_2
    //   11360: new 68	java/lang/StringBuilder
    //   11363: dup
    //   11364: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   11367: ldc_w 2955
    //   11370: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11373: aload 20
    //   11375: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11378: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11381: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11384: aload 20
    //   11386: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11389: ifeq +53 -> 11442
    //   11392: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11395: ifeq +12 -> 11407
    //   11398: ldc 169
    //   11400: iconst_2
    //   11401: ldc_w 3621
    //   11404: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11407: aload_2
    //   11408: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11411: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   11414: iconst_0
    //   11415: invokestatic 2913	aqmj:U	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11418: ldc_w 2905
    //   11421: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   11424: invokestatic 2911	aqan:bR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   11427: pop
    //   11428: aload 18
    //   11430: invokestatic 2679	aqap:a	()Laqap;
    //   11433: invokevirtual 2682	aqap:b	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   11436: invokevirtual 2685	accy:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   11439: goto -449 -> 10990
    //   11442: invokestatic 2679	aqap:a	()Laqap;
    //   11445: invokevirtual 2682	aqap:b	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   11448: astore 17
    //   11450: aload 17
    //   11452: aload 20
    //   11454: invokevirtual 2918	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:bj	(Ljava/lang/String;)V
    //   11457: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11460: ifeq +42 -> 11502
    //   11463: ldc 169
    //   11465: iconst_2
    //   11466: ldc_w 2920
    //   11469: iconst_2
    //   11470: anewarray 178	java/lang/Object
    //   11473: dup
    //   11474: iconst_0
    //   11475: invokestatic 204	com/tencent/common/config/AppSetting:getAppId	()I
    //   11478: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11481: aastore
    //   11482: dup
    //   11483: iconst_1
    //   11484: aload 17
    //   11486: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   11489: getfield 2928	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   11492: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11495: aastore
    //   11496: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   11499: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11502: invokestatic 204	com/tencent/common/config/AppSetting:getAppId	()I
    //   11505: aload 17
    //   11507: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   11510: getfield 2928	protocol/KQQConfig/UpgradeInfo:iUpgradeSdkId	I
    //   11513: if_icmplt +63 -> 11576
    //   11516: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11519: ifeq +12 -> 11531
    //   11522: ldc 169
    //   11524: iconst_2
    //   11525: ldc_w 3623
    //   11528: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11531: aload_2
    //   11532: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11535: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   11538: iconst_0
    //   11539: invokestatic 2913	aqmj:U	(Landroid/content/Context;Ljava/lang/String;I)V
    //   11542: ldc_w 2905
    //   11545: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   11548: invokestatic 2911	aqan:bR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   11551: pop
    //   11552: aload 17
    //   11554: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   11557: iconst_0
    //   11558: putfield 2950	protocol/KQQConfig/UpgradeInfo:iUpgradeType	I
    //   11561: aload 18
    //   11563: aload 17
    //   11565: invokevirtual 2685	accy:a	(Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;)V
    //   11568: aload 18
    //   11570: invokevirtual 2953	accy:cIb	()V
    //   11573: goto -583 -> 10990
    //   11576: aload 17
    //   11578: monitorenter
    //   11579: aload 17
    //   11581: getfield 2965	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:cTt	Z
    //   11584: ifne +30 -> 11614
    //   11587: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11590: ifeq +12 -> 11602
    //   11593: ldc 169
    //   11595: iconst_2
    //   11596: ldc_w 2967
    //   11599: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11602: aload 17
    //   11604: monitorexit
    //   11605: goto -615 -> 10990
    //   11608: astore_1
    //   11609: aload 17
    //   11611: monitorexit
    //   11612: aload_1
    //   11613: athrow
    //   11614: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11617: ifeq +12 -> 11629
    //   11620: ldc 169
    //   11622: iconst_2
    //   11623: ldc_w 2969
    //   11626: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11629: aload 17
    //   11631: getfield 2972	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:dYm	I
    //   11634: ifne +21 -> 11655
    //   11637: aload 17
    //   11639: getfield 2975	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:dYl	I
    //   11642: iconst_1
    //   11643: if_icmpne +32 -> 11675
    //   11646: iconst_1
    //   11647: istore 11
    //   11649: aload_2
    //   11650: iload 11
    //   11652: invokestatic 2977	accy:t	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11655: invokestatic 2679	aqap:a	()Laqap;
    //   11658: aload 17
    //   11660: getfield 2923	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lprotocol/KQQConfig/UpgradeInfo;
    //   11663: aload 18
    //   11665: invokevirtual 2980	aqap:a	(Lprotocol/KQQConfig/UpgradeInfo;Laqap$b;)Z
    //   11668: pop
    //   11669: aload 17
    //   11671: monitorexit
    //   11672: goto -682 -> 10990
    //   11675: iconst_0
    //   11676: istore 11
    //   11678: goto -29 -> 11649
    //   11681: aload_2
    //   11682: invokestatic 2706	tnj:aE	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   11685: goto -695 -> 10990
    //   11688: aload_2
    //   11689: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11692: invokestatic 3626	aqmj:f	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   11695: astore 17
    //   11697: aload 17
    //   11699: invokeinterface 486 1 0
    //   11704: ldc_w 3628
    //   11707: invokeinterface 910 2 0
    //   11712: invokeinterface 497 1 0
    //   11717: pop
    //   11718: aload 17
    //   11720: invokeinterface 486 1 0
    //   11725: ldc_w 3630
    //   11728: invokeinterface 910 2 0
    //   11733: invokeinterface 497 1 0
    //   11738: pop
    //   11739: goto -749 -> 10990
    //   11742: new 68	java/lang/StringBuilder
    //   11745: dup
    //   11746: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   11749: aload_0
    //   11750: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   11753: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   11756: invokevirtual 3015	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   11759: invokevirtual 3018	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11762: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11765: ldc_w 3632
    //   11768: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11771: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11774: astore 17
    //   11776: new 3009	java/io/File
    //   11779: dup
    //   11780: aload 17
    //   11782: invokespecial 3021	java/io/File:<init>	(Ljava/lang/String;)V
    //   11785: astore 18
    //   11787: aload 18
    //   11789: ifnull -799 -> 10990
    //   11792: aload 18
    //   11794: invokevirtual 3024	java/io/File:exists	()Z
    //   11797: ifeq -807 -> 10990
    //   11800: aload 18
    //   11802: invokevirtual 3037	java/io/File:isDirectory	()Z
    //   11805: ifeq -815 -> 10990
    //   11808: aload 18
    //   11810: invokevirtual 3041	java/io/File:listFiles	()[Ljava/io/File;
    //   11813: astore 18
    //   11815: aload 18
    //   11817: ifnull -827 -> 10990
    //   11820: aload 18
    //   11822: arraylength
    //   11823: istore 8
    //   11825: iconst_0
    //   11826: istore 7
    //   11828: iload 7
    //   11830: iload 8
    //   11832: if_icmpge -842 -> 10990
    //   11835: aload 18
    //   11837: iload 7
    //   11839: aaload
    //   11840: astore 20
    //   11842: aload 20
    //   11844: ifnonnull +12 -> 11856
    //   11847: iload 7
    //   11849: iconst_1
    //   11850: iadd
    //   11851: istore 7
    //   11853: goto -25 -> 11828
    //   11856: new 3634	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1
    //   11859: dup
    //   11860: aload_0
    //   11861: aload 20
    //   11863: aload 17
    //   11865: invokespecial 3637	com/tencent/mobileqq/config/splashlogo/ConfigServlet$1:<init>	(Laevk;Ljava/io/File;Ljava/lang/String;)V
    //   11868: iconst_5
    //   11869: aconst_null
    //   11870: iconst_1
    //   11871: invokestatic 3643	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   11874: goto -27 -> 11847
    //   11877: aload_2
    //   11878: sipush 168
    //   11881: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11884: checkcast 1480	adex
    //   11887: astore 17
    //   11889: aload 17
    //   11891: ifnull +10 -> 11901
    //   11894: aload 17
    //   11896: iconst_1
    //   11897: iconst_0
    //   11898: invokevirtual 2749	adex:bN	(ZZ)V
    //   11901: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11904: ifeq -914 -> 10990
    //   11907: ldc_w 1476
    //   11910: iconst_2
    //   11911: ldc_w 3645
    //   11914: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11917: goto -927 -> 10990
    //   11920: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11923: ifeq -933 -> 10990
    //   11926: ldc_w 3647
    //   11929: iconst_2
    //   11930: ldc_w 3649
    //   11933: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11936: goto -946 -> 10990
    //   11939: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11942: ifeq -952 -> 10990
    //   11945: ldc 169
    //   11947: iconst_2
    //   11948: ldc_w 3651
    //   11951: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11954: goto -964 -> 10990
    //   11957: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11960: ifeq -970 -> 10990
    //   11963: ldc 169
    //   11965: iconst_2
    //   11966: ldc_w 3653
    //   11969: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11972: goto -982 -> 10990
    //   11975: aload_2
    //   11976: sipush 167
    //   11979: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11982: checkcast 1895	com/tencent/mobileqq/olympic/OlympicManager
    //   11985: astore 17
    //   11987: aload 17
    //   11989: ifnull +13 -> 12002
    //   11992: aload 17
    //   11994: invokevirtual 2758	com/tencent/mobileqq/olympic/OlympicManager:dCN	()V
    //   11997: aload 17
    //   11999: invokevirtual 2761	com/tencent/mobileqq/olympic/OlympicManager:dCO	()V
    //   12002: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12005: ifeq -1015 -> 10990
    //   12008: ldc_w 1920
    //   12011: iconst_2
    //   12012: ldc_w 3655
    //   12015: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12018: goto -1028 -> 10990
    //   12021: aload_0
    //   12022: aconst_null
    //   12023: invokespecial 3278	aevk:r	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;)V
    //   12026: goto -1036 -> 10990
    //   12029: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12032: ifeq +12 -> 12044
    //   12035: ldc 169
    //   12037: iconst_2
    //   12038: ldc_w 2769
    //   12041: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12044: aload_2
    //   12045: sipush 179
    //   12048: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12051: checkcast 2771	alaj
    //   12054: astore 17
    //   12056: aload 17
    //   12058: ifnull -1068 -> 10990
    //   12061: aload 17
    //   12063: invokevirtual 2774	alaj:startDownload	()V
    //   12066: aload 17
    //   12068: iconst_1
    //   12069: invokevirtual 2777	alaj:Nz	(Z)V
    //   12072: goto -1082 -> 10990
    //   12075: aload_2
    //   12076: invokestatic 1766	com/tencent/mobileqq/utils/BusinessCommonConfig:getInstance	(Lmqq/app/AppRuntime;)Lcom/tencent/mobileqq/utils/BusinessCommonConfig;
    //   12079: aload_2
    //   12080: aload 17
    //   12082: invokevirtual 607	java/lang/Integer:intValue	()I
    //   12085: invokevirtual 3658	com/tencent/mobileqq/utils/BusinessCommonConfig:handleResp_Config_NoResp	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   12088: goto -1098 -> 10990
    //   12091: aload_2
    //   12092: bipush 53
    //   12094: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   12097: checkcast 2064	acbs
    //   12100: astore 17
    //   12102: aload 17
    //   12104: ifnull -1114 -> 10990
    //   12107: aload 17
    //   12109: iconst_0
    //   12110: iconst_0
    //   12111: invokevirtual 2767	acbs:bs	(ZZ)V
    //   12114: goto -1124 -> 10990
    //   12117: invokestatic 2819	com/tencent/mobileqq/scribble/ScribbleResMgr:a	()Lcom/tencent/mobileqq/scribble/ScribbleResMgr;
    //   12120: invokevirtual 3661	com/tencent/mobileqq/scribble/ScribbleResMgr:dNV	()V
    //   12123: goto -1133 -> 10990
    //   12126: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12129: ifeq -1139 -> 10990
    //   12132: ldc_w 2593
    //   12135: iconst_2
    //   12136: ldc_w 3663
    //   12139: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   12142: goto -1152 -> 10990
    //   12145: aload_2
    //   12146: sipush 218
    //   12149: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12152: checkcast 3665	wjw
    //   12155: invokevirtual 3668	wjw:loadConfig	()V
    //   12158: goto -1168 -> 10990
    //   12161: invokestatic 3671	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:dPp	()V
    //   12164: goto -1174 -> 10990
    //   12167: iconst_1
    //   12168: invokestatic 3674	afam:HE	(Z)V
    //   12171: goto -1181 -> 10990
    //   12174: aload_2
    //   12175: iconst_1
    //   12176: invokestatic 3676	armm:ap	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   12179: goto -1189 -> 10990
    //   12182: iload 5
    //   12184: ifeq +202 -> 12386
    //   12187: iload 6
    //   12189: iconst_3
    //   12190: if_icmpge +196 -> 12386
    //   12193: aload_3
    //   12194: ifnull +192 -> 12386
    //   12197: aload_3
    //   12198: arraylength
    //   12199: ifle +187 -> 12386
    //   12202: new 68	java/lang/StringBuilder
    //   12205: dup
    //   12206: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   12209: astore 4
    //   12211: aload 4
    //   12213: ldc_w 3678
    //   12216: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12219: pop
    //   12220: aload_3
    //   12221: arraylength
    //   12222: istore 8
    //   12224: iconst_0
    //   12225: istore 7
    //   12227: iload 7
    //   12229: iload 8
    //   12231: if_icmpge +28 -> 12259
    //   12234: aload 4
    //   12236: aload_3
    //   12237: iload 7
    //   12239: iaload
    //   12240: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12243: ldc_w 3680
    //   12246: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12249: pop
    //   12250: iload 7
    //   12252: iconst_1
    //   12253: iadd
    //   12254: istore 7
    //   12256: goto -29 -> 12227
    //   12259: ldc 169
    //   12261: iconst_1
    //   12262: aload 4
    //   12264: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12267: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12270: new 994	mqq/app/NewIntent
    //   12273: dup
    //   12274: aload_2
    //   12275: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12278: ldc 2
    //   12280: invokespecial 997	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12283: astore 4
    //   12285: aload 4
    //   12287: ldc_w 1008
    //   12290: aload_3
    //   12291: invokevirtual 1012	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[I)Landroid/content/Intent;
    //   12294: pop
    //   12295: aload 4
    //   12297: ldc_w 1014
    //   12300: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   12303: invokevirtual 1017	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12306: pop
    //   12307: aload 4
    //   12309: ldc_w 2534
    //   12312: iconst_1
    //   12313: invokevirtual 1027	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   12316: pop
    //   12317: aload_1
    //   12318: getfield 3681	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12321: invokevirtual 1357	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12324: ifeq +22 -> 12346
    //   12327: aload 4
    //   12329: ldc_w 2543
    //   12332: aload_1
    //   12333: getfield 3681	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12336: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12339: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12342: invokevirtual 3684	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12345: pop
    //   12346: aload 4
    //   12348: ldc_w 1024
    //   12351: iload 5
    //   12353: invokevirtual 1027	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   12356: pop
    //   12357: aload 4
    //   12359: ldc_w 3600
    //   12362: iload 6
    //   12364: iconst_1
    //   12365: iadd
    //   12366: invokevirtual 1022	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12369: pop
    //   12370: aload 4
    //   12372: ldc_w 1019
    //   12375: iconst_0
    //   12376: invokevirtual 1022	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12379: pop
    //   12380: aload_2
    //   12381: aload 4
    //   12383: invokevirtual 1031	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12386: return
    //   12387: iconst_0
    //   12388: istore 5
    //   12390: iconst_0
    //   12391: istore 6
    //   12393: aload 4
    //   12395: astore_3
    //   12396: goto -1415 -> 10981
    //   12399: aconst_null
    //   12400: astore 17
    //   12402: goto -4643 -> 7759
    //   12405: aload 4
    //   12407: astore 17
    //   12409: goto -7915 -> 4494
    //   12412: aconst_null
    //   12413: astore 17
    //   12415: goto -8051 -> 4364
    //   12418: ldc 18
    //   12420: astore 17
    //   12422: goto -10066 -> 2356
    //   12425: goto -8221 -> 4204
    //   12428: aload 4
    //   12430: astore 17
    //   12432: iload 11
    //   12434: istore 12
    //   12436: goto -10287 -> 2149
    //   12439: aconst_null
    //   12440: astore 17
    //   12442: goto -8078 -> 4364
    //   12445: astore 18
    //   12447: goto -7844 -> 4603
    //   12450: iconst_0
    //   12451: istore 11
    //   12453: goto -7200 -> 5253
    //   12456: iload 7
    //   12458: iconst_1
    //   12459: iadd
    //   12460: istore 7
    //   12462: goto -7097 -> 5365
    //   12465: goto -37 -> 12428
    //   12468: iload 7
    //   12470: iconst_1
    //   12471: iadd
    //   12472: istore 7
    //   12474: goto -6921 -> 5553
    //   12477: goto -49 -> 12428
    //   12480: iload 7
    //   12482: iconst_1
    //   12483: iadd
    //   12484: istore 7
    //   12486: goto -6496 -> 5990
    //   12489: goto -61 -> 12428
    //   12492: goto -64 -> 12428
    //   12495: iload 7
    //   12497: iconst_1
    //   12498: iadd
    //   12499: istore 7
    //   12501: goto -5593 -> 6908
    //   12504: iload 8
    //   12506: istore 7
    //   12508: goto -5054 -> 7454
    //   12511: goto -83 -> 12428
    //   12514: goto -86 -> 12428
    //   12517: goto -89 -> 12428
    //   12520: goto -92 -> 12428
    //   12523: goto -95 -> 12428
    //   12526: goto -98 -> 12428
    //   12529: goto -101 -> 12428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	12532	0	this	aevk
    //   0	12532	1	paramRespGetConfig	ConfigurationService.RespGetConfig
    //   0	12532	2	paramQQAppInterface	QQAppInterface
    //   0	12532	3	paramIntent	Intent
    //   0	12532	4	paramArrayOfInt	int[]
    //   0	12532	5	paramBoolean	boolean
    //   393	11999	6	i	int
    //   53	12454	7	j	int
    //   389	12116	8	k	int
    //   68	10822	9	m	int
    //   2374	108	10	n	int
    //   2110	10342	11	bool1	boolean
    //   2143	10292	12	bool2	boolean
    //   2047	8663	13	l1	long
    //   10683	25	15	l2	long
    //   2147	362	17	localObject1	Object
    //   2537	9	17	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   2553	9	17	localOutOfMemoryError1	OutOfMemoryError
    //   2581	1	17	str1	String
    //   2586	1	17	localThrowable1	Throwable
    //   2590	1905	17	localObject2	Object
    //   4501	9	17	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   4517	9	17	localOutOfMemoryError2	OutOfMemoryError
    //   4545	1	17	str2	String
    //   4550	1	17	localThrowable2	Throwable
    //   4553	610	17	localObject3	Object
    //   5287	6	17	localObject4	Object
    //   5391	3158	17	localObject5	Object
    //   8627	39	17	localException1	Exception
    //   8747	13	17	localIterator	Iterator
    //   8838	39	17	localException2	Exception
    //   9893	177	17	localObject6	Object
    //   10315	3	17	localThrowable3	Throwable
    //   10812	1629	17	localObject7	Object
    //   2200	2338	18	localObject8	Object
    //   4601	33	18	localException3	Exception
    //   4749	541	18	localUpgradeDetailWrapper	com.tencent.mobileqq.upgrade.UpgradeDetailWrapper
    //   5295	1	18	localException4	Exception
    //   5854	5982	18	localObject9	Object
    //   12445	1	18	localException5	Exception
    //   2068	8978	19	localArrayList	ArrayList
    //   2134	9728	20	localObject10	Object
    //   2303	5038	21	localObject11	Object
    //   2335	4842	22	localObject12	Object
    //   7186	55	23	str3	String
    // Exception table:
    //   from	to	target	type
    //   2342	2356	2537	java/io/UnsupportedEncodingException
    //   2342	2356	2553	java/lang/OutOfMemoryError
    //   2569	2583	2586	java/lang/Throwable
    //   4350	4364	4501	java/io/UnsupportedEncodingException
    //   4350	4364	4517	java/lang/OutOfMemoryError
    //   4533	4547	4550	java/lang/Throwable
    //   4435	4479	4601	java/lang/Exception
    //   4479	4490	4601	java/lang/Exception
    //   4578	4594	4601	java/lang/Exception
    //   5186	5209	5287	finally
    //   5209	5212	5287	finally
    //   5218	5233	5287	finally
    //   5233	5250	5287	finally
    //   5253	5259	5287	finally
    //   5259	5281	5287	finally
    //   5289	5292	5287	finally
    //   5167	5186	5295	java/lang/Exception
    //   5292	5295	5295	java/lang/Exception
    //   8504	8538	8627	java/lang/Exception
    //   8538	8610	8627	java/lang/Exception
    //   8610	8624	8627	java/lang/Exception
    //   8673	8712	8627	java/lang/Exception
    //   8715	8749	8838	java/lang/Exception
    //   8749	8821	8838	java/lang/Exception
    //   8821	8835	8838	java/lang/Exception
    //   8884	8923	8838	java/lang/Exception
    //   10301	10312	10315	java/lang/Throwable
    //   11579	11602	11608	finally
    //   11602	11605	11608	finally
    //   11609	11612	11608	finally
    //   11614	11629	11608	finally
    //   11629	11646	11608	finally
    //   11649	11655	11608	finally
    //   11655	11672	11608	finally
    //   2256	2275	12445	java/lang/Exception
    //   2278	2305	12445	java/lang/Exception
    //   2309	2337	12445	java/lang/Exception
    //   2342	2356	12445	java/lang/Exception
    //   2356	2528	12445	java/lang/Exception
    //   2539	2550	12445	java/lang/Exception
    //   2555	2566	12445	java/lang/Exception
    //   2566	2569	12445	java/lang/Exception
    //   2569	2583	12445	java/lang/Exception
    //   2595	2608	12445	java/lang/Exception
    //   2611	2630	12445	java/lang/Exception
    //   2633	2795	12445	java/lang/Exception
    //   2804	2828	12445	java/lang/Exception
    //   2828	4204	12445	java/lang/Exception
    //   4207	4253	12445	java/lang/Exception
    //   4261	4276	12445	java/lang/Exception
    //   4279	4312	12445	java/lang/Exception
    //   4317	4345	12445	java/lang/Exception
    //   4350	4364	12445	java/lang/Exception
    //   4369	4424	12445	java/lang/Exception
    //   4424	4431	12445	java/lang/Exception
    //   4503	4514	12445	java/lang/Exception
    //   4519	4530	12445	java/lang/Exception
    //   4530	4533	12445	java/lang/Exception
    //   4533	4547	12445	java/lang/Exception
    //   4558	4571	12445	java/lang/Exception
    //   4662	4678	12445	java/lang/Exception
    //   4685	4748	12445	java/lang/Exception
    //   4758	4777	12445	java/lang/Exception
    //   4777	4792	12445	java/lang/Exception
    //   4792	4802	12445	java/lang/Exception
    //   4805	4820	12445	java/lang/Exception
    //   4820	4898	12445	java/lang/Exception
    //   4898	4985	12445	java/lang/Exception
    //   4985	5014	12445	java/lang/Exception
    //   5014	5056	12445	java/lang/Exception
    //   5059	5106	12445	java/lang/Exception
    //   5106	5124	12445	java/lang/Exception
    //   5127	5138	12445	java/lang/Exception
    //   5145	5160	12445	java/lang/Exception
    //   5303	5319	12445	java/lang/Exception
    //   5322	5362	12445	java/lang/Exception
    //   5365	5443	12445	java/lang/Exception
    //   5443	5465	12445	java/lang/Exception
    //   5468	5507	12445	java/lang/Exception
    //   5510	5550	12445	java/lang/Exception
    //   5553	5631	12445	java/lang/Exception
    //   5631	5654	12445	java/lang/Exception
    //   5657	5696	12445	java/lang/Exception
    //   5699	5742	12445	java/lang/Exception
    //   5745	5819	12445	java/lang/Exception
    //   5819	5834	12445	java/lang/Exception
    //   5834	5906	12445	java/lang/Exception
    //   5906	5959	12445	java/lang/Exception
    //   5967	5987	12445	java/lang/Exception
    //   6009	6023	12445	java/lang/Exception
    //   6026	6065	12445	java/lang/Exception
    //   6065	6112	12445	java/lang/Exception
    //   6117	6123	12445	java/lang/Exception
    //   6123	6146	12445	java/lang/Exception
    //   6149	6189	12445	java/lang/Exception
    //   6189	6261	12445	java/lang/Exception
    //   6261	6275	12445	java/lang/Exception
    //   6278	6297	12445	java/lang/Exception
    //   6302	6312	12445	java/lang/Exception
    //   6312	6474	12445	java/lang/Exception
    //   6477	6516	12445	java/lang/Exception
    //   6516	6547	12445	java/lang/Exception
    //   6552	6562	12445	java/lang/Exception
    //   6562	6636	12445	java/lang/Exception
    //   6639	6722	12445	java/lang/Exception
    //   6722	6736	12445	java/lang/Exception
    //   6739	6778	12445	java/lang/Exception
    //   6778	6851	12445	java/lang/Exception
    //   6851	6874	12445	java/lang/Exception
    //   6877	6905	12445	java/lang/Exception
    //   6908	6986	12445	java/lang/Exception
    //   6986	6994	12445	java/lang/Exception
    //   6999	7007	12445	java/lang/Exception
    //   7010	7057	12445	java/lang/Exception
    //   7060	7099	12445	java/lang/Exception
    //   7102	7166	12445	java/lang/Exception
    //   7166	7238	12445	java/lang/Exception
    //   7238	7263	12445	java/lang/Exception
    //   7266	7305	12445	java/lang/Exception
    //   7305	7334	12445	java/lang/Exception
    //   7337	7384	12445	java/lang/Exception
    //   7384	7397	12445	java/lang/Exception
    //   7400	7415	12445	java/lang/Exception
    //   7418	7431	12445	java/lang/Exception
    //   7436	7454	12445	java/lang/Exception
    //   7454	7555	12445	java/lang/Exception
    //   7555	7564	12445	java/lang/Exception
    //   7567	7598	12445	java/lang/Exception
    //   7607	7641	12445	java/lang/Exception
    //   7644	7688	12445	java/lang/Exception
    //   7695	7727	12445	java/lang/Exception
    //   7730	7759	12445	java/lang/Exception
    //   7764	7837	12445	java/lang/Exception
    //   7837	7851	12445	java/lang/Exception
    //   7851	7923	12445	java/lang/Exception
    //   7923	7931	12445	java/lang/Exception
    //   7931	7953	12445	java/lang/Exception
    //   7956	8002	12445	java/lang/Exception
    //   8005	8020	12445	java/lang/Exception
    //   8023	8030	12445	java/lang/Exception
    //   8033	8040	12445	java/lang/Exception
    //   8043	8050	12445	java/lang/Exception
    //   8053	8059	12445	java/lang/Exception
    //   8062	8068	12445	java/lang/Exception
    //   8071	8176	12445	java/lang/Exception
    //   8179	8218	12445	java/lang/Exception
    //   8221	8333	12445	java/lang/Exception
    //   8336	8392	12445	java/lang/Exception
    //   8395	8402	12445	java/lang/Exception
    //   8405	8412	12445	java/lang/Exception
    //   8415	8422	12445	java/lang/Exception
    //   8425	8432	12445	java/lang/Exception
    //   8435	8443	12445	java/lang/Exception
    //   8446	8453	12445	java/lang/Exception
    //   8456	8462	12445	java/lang/Exception
    //   8465	8471	12445	java/lang/Exception
    //   8474	8481	12445	java/lang/Exception
    //   8484	8501	12445	java/lang/Exception
    //   8629	8665	12445	java/lang/Exception
    //   8665	8670	12445	java/lang/Exception
    //   8840	8876	12445	java/lang/Exception
    //   8876	8881	12445	java/lang/Exception
    //   8926	8932	12445	java/lang/Exception
    //   8935	8941	12445	java/lang/Exception
    //   8944	8950	12445	java/lang/Exception
    //   8953	8959	12445	java/lang/Exception
    //   8962	8968	12445	java/lang/Exception
    //   8971	8977	12445	java/lang/Exception
    //   8980	8986	12445	java/lang/Exception
    //   8989	8995	12445	java/lang/Exception
    //   8998	9004	12445	java/lang/Exception
    //   9007	9013	12445	java/lang/Exception
    //   9016	9022	12445	java/lang/Exception
    //   9025	9031	12445	java/lang/Exception
    //   9034	9040	12445	java/lang/Exception
    //   9043	9049	12445	java/lang/Exception
    //   9052	9058	12445	java/lang/Exception
    //   9061	9067	12445	java/lang/Exception
    //   9070	9076	12445	java/lang/Exception
    //   9079	9085	12445	java/lang/Exception
    //   9088	9094	12445	java/lang/Exception
    //   9097	9103	12445	java/lang/Exception
    //   9106	9116	12445	java/lang/Exception
    //   9119	9125	12445	java/lang/Exception
    //   9128	9134	12445	java/lang/Exception
    //   9137	9143	12445	java/lang/Exception
    //   9146	9152	12445	java/lang/Exception
    //   9155	9245	12445	java/lang/Exception
    //   9245	9298	12445	java/lang/Exception
    //   9301	9351	12445	java/lang/Exception
    //   9354	9361	12445	java/lang/Exception
    //   9364	9380	12445	java/lang/Exception
    //   9383	9390	12445	java/lang/Exception
    //   9393	9400	12445	java/lang/Exception
    //   9403	9410	12445	java/lang/Exception
    //   9413	9420	12445	java/lang/Exception
    //   9423	9431	12445	java/lang/Exception
    //   9434	9441	12445	java/lang/Exception
    //   9444	9451	12445	java/lang/Exception
    //   9454	9468	12445	java/lang/Exception
    //   9471	9478	12445	java/lang/Exception
    //   9481	9497	12445	java/lang/Exception
    //   9500	9507	12445	java/lang/Exception
    //   9510	9517	12445	java/lang/Exception
    //   9520	9527	12445	java/lang/Exception
    //   9530	9537	12445	java/lang/Exception
    //   9540	9547	12445	java/lang/Exception
    //   9550	9557	12445	java/lang/Exception
    //   9560	9567	12445	java/lang/Exception
    //   9570	9577	12445	java/lang/Exception
    //   9580	9587	12445	java/lang/Exception
    //   9590	9595	12445	java/lang/Exception
    //   9598	9605	12445	java/lang/Exception
    //   9608	9615	12445	java/lang/Exception
    //   9618	9625	12445	java/lang/Exception
    //   9628	9635	12445	java/lang/Exception
    //   9638	9645	12445	java/lang/Exception
    //   9648	9655	12445	java/lang/Exception
    //   9658	9665	12445	java/lang/Exception
    //   9668	9675	12445	java/lang/Exception
    //   9678	9685	12445	java/lang/Exception
    //   9688	9707	12445	java/lang/Exception
    //   9710	9717	12445	java/lang/Exception
    //   9720	9727	12445	java/lang/Exception
    //   9730	9737	12445	java/lang/Exception
    //   9740	9747	12445	java/lang/Exception
    //   9750	9757	12445	java/lang/Exception
    //   9760	9767	12445	java/lang/Exception
    //   9770	9776	12445	java/lang/Exception
    //   9779	9786	12445	java/lang/Exception
    //   9789	9796	12445	java/lang/Exception
    //   9799	9806	12445	java/lang/Exception
    //   9809	9816	12445	java/lang/Exception
    //   9819	9826	12445	java/lang/Exception
    //   9829	9836	12445	java/lang/Exception
    //   9839	9846	12445	java/lang/Exception
    //   9849	9856	12445	java/lang/Exception
    //   9859	9866	12445	java/lang/Exception
    //   9869	9875	12445	java/lang/Exception
    //   9878	9895	12445	java/lang/Exception
    //   9900	9917	12445	java/lang/Exception
    //   9920	9937	12445	java/lang/Exception
    //   9942	9962	12445	java/lang/Exception
    //   9965	9972	12445	java/lang/Exception
    //   9975	9982	12445	java/lang/Exception
    //   9985	9992	12445	java/lang/Exception
    //   9995	10001	12445	java/lang/Exception
    //   10004	10010	12445	java/lang/Exception
    //   10013	10020	12445	java/lang/Exception
    //   10023	10029	12445	java/lang/Exception
    //   10032	10049	12445	java/lang/Exception
    //   10052	10064	12445	java/lang/Exception
    //   10069	10077	12445	java/lang/Exception
    //   10080	10087	12445	java/lang/Exception
    //   10090	10097	12445	java/lang/Exception
    //   10100	10107	12445	java/lang/Exception
    //   10110	10117	12445	java/lang/Exception
    //   10120	10127	12445	java/lang/Exception
    //   10130	10137	12445	java/lang/Exception
    //   10140	10147	12445	java/lang/Exception
    //   10150	10157	12445	java/lang/Exception
    //   10160	10167	12445	java/lang/Exception
    //   10170	10177	12445	java/lang/Exception
    //   10180	10187	12445	java/lang/Exception
    //   10190	10197	12445	java/lang/Exception
    //   10200	10207	12445	java/lang/Exception
    //   10210	10217	12445	java/lang/Exception
    //   10220	10226	12445	java/lang/Exception
    //   10229	10247	12445	java/lang/Exception
    //   10250	10268	12445	java/lang/Exception
    //   10271	10280	12445	java/lang/Exception
    //   10283	10298	12445	java/lang/Exception
    //   10301	10312	12445	java/lang/Exception
    //   10317	10322	12445	java/lang/Exception
    //   10325	10332	12445	java/lang/Exception
    //   10335	10342	12445	java/lang/Exception
    //   10345	10352	12445	java/lang/Exception
    //   10355	10362	12445	java/lang/Exception
    //   10365	10372	12445	java/lang/Exception
    //   10375	10389	12445	java/lang/Exception
    //   10392	10399	12445	java/lang/Exception
    //   10402	10413	12445	java/lang/Exception
    //   10416	10428	12445	java/lang/Exception
    //   10431	10438	12445	java/lang/Exception
    //   10441	10448	12445	java/lang/Exception
    //   10451	10470	12445	java/lang/Exception
    //   10473	10480	12445	java/lang/Exception
    //   10483	10489	12445	java/lang/Exception
    //   10492	10503	12445	java/lang/Exception
    //   10506	10524	12445	java/lang/Exception
    //   10527	10539	12445	java/lang/Exception
    //   10542	10548	12445	java/lang/Exception
    //   10551	10558	12445	java/lang/Exception
    //   10561	10576	12445	java/lang/Exception
    //   10579	10585	12445	java/lang/Exception
    //   10588	10603	12445	java/lang/Exception
    //   10606	10613	12445	java/lang/Exception
    //   10616	10628	12445	java/lang/Exception
    //   10631	10638	12445	java/lang/Exception
  }
  
  public static boolean a(aevv paramaevv, String paramString, Set<String> paramSet)
  {
    boolean bool2 = false;
    for (;;)
    {
      Document localDocument;
      String str1;
      int i;
      long l1;
      String str2;
      String str3;
      int k;
      Object localObject;
      long l2;
      long l3;
      boolean bool1;
      try
      {
        localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
        str1 = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
          str2 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str3 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
          k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
          localObject = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
          if (localObject != null) {
            str1 = ((Node)localObject).getNodeValue();
          }
          localObject = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          l2 = localSimpleDateFormat.parse((String)localObject).getTime();
          l3 = localSimpleDateFormat.parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
          if (System.currentTimeMillis() > l2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner out of date, cid = " + l1 + ", endTime = " + (String)localObject);
            }
          }
          else if (str1.length() < 15)
          {
            if (!QLog.isColorLevel()) {
              break label758;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner md5 length < 15, cid = " + l1);
          }
        }
      }
      catch (Exception paramaevv)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner parse exception,", paramaevv);
          bool1 = bool2;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "parseNearbyBannerXml,result = " + bool1 + ",bannerContent =" + paramString);
        }
        return bool1;
        if ((paramSet != null) && (paramSet.contains(l1 + str1)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SPLASH_ConfigServlet", 2, "parseXML | NearbyBanner " + l1 + " had been closed, throw it");
          break;
        }
        localObject = new StringBuffer();
        int j = 0;
        while (j < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
        {
          ((StringBuffer)localObject).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(j).getNodeValue());
          j += 1;
        }
        paramaevv.addElement(paramaevv.a(l1, str3, (byte)3, str2, ((StringBuffer)localObject).toString(), BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic" + "/" + str1, l3 + "|" + l2, (short)k, str1));
        ajrb.c(mCurUin, "has_new_banner", Boolean.valueOf(true));
        break;
        bool1 = true;
      }
      label758:
      i += 1;
    }
  }
  
  private static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    byte[] arrayOfByte = new byte[(int)l + 4];
    aqoj.DWord2Byte(arrayOfByte, 0, 4L + l);
    aqoj.b(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static void aa(QQAppInterface paramQQAppInterface, String paramString)
  {
    mCurUin = paramString;
    v(paramQQAppInterface, 43);
  }
  
  public static void ab(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      ajrk.m("GENERAL_LBS_CONFIGS_CMD", new Object[] { "getGeneralLBSConfigs", paramString, Long.valueOf(l) });
    }
    paramString = new NewIntent(paramQQAppInterface.getApp(), aevk.class);
    paramString.putExtra("k_cmd_type", new int[] { 87, 12, 174, 189 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  public static void ac(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "getPrecoverConfig, PRECOVER_CONFIG_CMD, uin=" + paramString);
    }
    paramString = (alaj)paramQQAppInterface.getManager(179);
    if ((paramString != null) && (paramString.b() != null) && (paramString.b().drf * 1000L <= 0L)) {}
    paramString = new NewIntent(paramQQAppInterface.getApp(), aevk.class);
    paramString.putExtra("k_cmd_type", new int[] { 113 });
    paramQQAppInterface.startServlet(paramString);
  }
  
  public static void ad(QQAppInterface paramQQAppInterface, String paramString)
  {
    mCurUin = paramString;
    v(paramQQAppInterface, 185);
  }
  
  public static void ap(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.bA(BaseApplication.getContext(), mCurUin);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      aqmj.aL(BaseApplication.getContext(), mCurUin, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        while (paramConfig.hasNext())
        {
          Object localObject = (String)paramConfig.next();
          try
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("isWeiYunMiniApp"))
            {
              i = ((JSONObject)localObject).getInt("isWeiYunMiniApp");
              aqmj.I(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, enableMiniApp = " + i);
              }
            }
            if (((JSONObject)localObject).has("apkgUrl"))
            {
              String str = ((JSONObject)localObject).getString("apkgUrl");
              aqmj.aj(BaseApplication.getContext(), str, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, apkgUrl = " + str);
              }
            }
            if (((JSONObject)localObject).has("miniVersion"))
            {
              i = ((JSONObject)localObject).getInt("miniVersion");
              aqmj.J(BaseApplication.getContext(), i, paramQQAppInterface.getCurrentAccountUin());
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig, miniVersion = " + i);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleWeiYunMiniAppConfig:localVersiont == version ");
    }
  }
  
  private void aq(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = aqij.lA();
    int j = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|received remote version: " + j + " | localVersion: " + i);
    }
    if (j != i)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label247;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig == null) {
        break label230;
      }
      if (paramConfig.compress.get() != 1) {
        break label216;
      }
      paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label194;
      }
    }
    label194:
    label216:
    label230:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          aqij.a().D(paramQQAppInterface.getApp(), paramConfig, j);
          return;
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|Throwable:" + paramConfig.getMessage());
          }
          paramConfig = "";
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]|inflateConfigString error!");
        }
        paramConfig = "";
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
    }
    QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| content==null");
    return;
    label247:
    if (QLog.isColorLevel()) {
      QLog.d("JumpForwardPkgManager", 2, "receiveAllConfigs[handleJumpPkgConfig]| msg_content_list is empty ,version: " + j + ",localVersion:" + i);
    }
    aqij.a().Xs(j);
  }
  
  public static void ar(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.bG(BaseApplication.getContext(), mCurUin);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleAIOConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      aqmj.aN(BaseApplication.getContext(), mCurUin, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        aqmj.s(BaseApplication.getContext(), mCurUin, "aio_config_key", paramConfig);
        wiq.aQ(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  private void as(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.aK(BaseApplication.getContext(), mCurUin);
    QLog.i("SPLASH_ConfigServlet", 1, "handleDevConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    if (i != j)
    {
      aqmj.ae(BaseApplication.getContext(), mCurUin, i);
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {}
      try
      {
        paramQQAppInterface = (String)paramQQAppInterface.get(paramQQAppInterface.size() - 1);
        QLog.d("SPLASH_ConfigServlet", 1, new Object[] { "devConfig is ", paramQQAppInterface });
        aqmj.Y(BaseApplication.getContext(), mCurUin, paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("SPLASH_ConfigServlet", 1, new Object[] { "get dev config error : ", paramQQAppInterface.getMessage() });
        return;
      }
    }
    QLog.e("SPLASH_ConfigServlet", 1, "handleDevConfig version is same of local version");
  }
  
  public static void at(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.bH(BaseApplication.getContext(), mCurUin);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      aqmj.aO(BaseApplication.getContext(), mCurUin, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        i = new JSONObject((String)paramConfig.get(paramConfig.size() - 1)).optInt("max_multimsg_totalcount");
        aqmj.m(BaseApplication.getContext(), mCurUin, "multimsg_config", i);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleMultiMsgConfig:limitTotal =  " + i);
        }
        ajlc.a().ds(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleReceiptConfig:localVersiont == version ");
  }
  
  private void au(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool = false;
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    int j = ((Integer)aqmj.a(localBaseApplication, str, "config_tim_team_version_code", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleTimTeamConfig received Config remote version:" + i + " localVersion= " + j);
    }
    if (i != j)
    {
      paramQQAppInterface = a(paramConfig);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {}
    }
    try
    {
      paramConfig = new JSONObject((String)paramQQAppInterface.get(0));
      paramQQAppInterface = "";
      if (paramConfig.has("isWeb")) {
        bool = paramConfig.getBoolean("isWeb");
      }
      if (paramConfig.has("url")) {
        paramQQAppInterface = paramConfig.getString("url");
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTimTeamConfig isWeb=" + bool + " url=" + paramQQAppInterface);
      }
      aqmj.a(localBaseApplication, str, false, "config_tim_team_is_web", Boolean.valueOf(bool));
      aqmj.a(localBaseApplication, str, false, "config_tim_team_url", paramQQAppInterface);
      aqmj.a(localBaseApplication, str, true, "config_tim_team_version_code", Integer.valueOf(i));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SPLASH_ConfigServlet", 2, paramQQAppInterface.getMessage());
    }
  }
  
  public static String b(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    if (paramConfig.version.get() == paramInt1)
    {
      QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| config content will be null localVersion is same as config.version(" + paramInt1 + "). type=" + paramInt2);
      return null;
    }
    if (paramConfig.content_list.size() > 0) {
      return (String)paramConfig.content_list.get(0);
    }
    if (paramConfig.msg_content_list.size() == 0)
    {
      QLog.i("SPLASH_ConfigServlet", 1, String.format(Locale.getDefault(), "extractConfigContent| version is update but config content is null. newVersion=%d, oldVersion=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return "";
    }
    Object localObject = ((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).content.get().toByteArray();
    if (((ConfigurationService.Content)paramConfig.msg_content_list.get(0)).compress.get() == 1)
    {
      byte[] arrayOfByte = aden.u((byte[])localObject);
      localObject = arrayOfByte;
      if (arrayOfByte == null)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| decompress is failed. type=" + paramInt2 + ", data=null");
        return null;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "utf-8");
        paramConfig = String.format(Locale.getDefault(), "extractConfigContent| config is update. version=%d, type=%d", new Object[] { Integer.valueOf(paramConfig.version.get()), Integer.valueOf(paramInt2) });
        if (QLog.isColorLevel())
        {
          QLog.i("SPLASH_ConfigServlet", 2, paramConfig + "content=" + (String)localObject);
          return localObject;
        }
      }
      catch (UnsupportedEncodingException paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "extractConfigContent| data[] to String failed. type=" + paramInt2, paramConfig);
        return null;
      }
      QLog.i("SPLASH_ConfigServlet", 1, paramConfig);
    }
  }
  
  private void b(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 2 type= " + paramConfig.type.get());
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    adex localadex = (adex)localQQAppInterface.getManager(168);
    if (localadex == null)
    {
      QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| manager is null");
      return;
    }
    Object localObject1 = BaseApplicationImpl.getApplication();
    int i;
    int j;
    ArrayList localArrayList;
    try
    {
      i = ((Context)localObject1).getPackageManager().getPackageInfo(((Context)localObject1).getPackageName(), 0).versionCode;
      localadex.KN(i);
      QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 3 type= version code is " + i);
      if (paramConfig.type.get() != 87) {
        break label752;
      }
      j = paramConfig.version.get();
      i = paramIntent.getIntExtra("key_config_version", 0);
      if (QLog.isColorLevel()) {
        QLog.d("handleResp_GetArResourceConfig", 2, "handleResp_GetArResource|server-Version is " + j);
      }
      if (i == j) {
        break label731;
      }
      if (paramConfig.msg_content_list == null) {
        break label707;
      }
      int k = paramConfig.msg_content_list.size();
      if (k <= 0) {
        break label707;
      }
      localObject1 = null;
      localArrayList = new ArrayList();
      i = 0;
      if (i < k)
      {
        localObject3 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
        m = ((ConfigurationService.Content)localObject3).task_id.get();
        localObject2 = ((ConfigurationService.Content)localObject3).content.get().toByteArray();
        paramIntent = (Intent)localObject2;
        if (((ConfigurationService.Content)localObject3).compress.get() == 1) {
          paramIntent = aden.u((byte[])localObject2);
        }
        if (paramIntent == null) {}
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int m;
        try
        {
          localObject2 = new String(paramIntent, "utf-8");
          localObject3 = ArConfigInfo.parseArConfig((String)localObject2);
          if (localObject3 != null) {
            if (localObject1 == null)
            {
              paramIntent = (Intent)localObject3;
              localArrayList.addAll(((ArConfigInfo)localObject3).mArCloudConfigInfos);
              QLog.i("ArConfig_configServlet", 1, "config loop|| taskid=" + m + ",endtime=" + ((ArConfigInfo)localObject3).aREnd + ",xmlcontent=" + (String)localObject2);
              OlympicServlet.a(localQQAppInterface, 87, j, m, 1, 0, 0);
              i += 1;
              localObject1 = paramIntent;
              continue;
              localNameNotFoundException = localNameNotFoundException;
              localNameNotFoundException.printStackTrace();
              QLog.d("ArConfig_configServlet", 1, "handleResp_GetArResourceConfig| 3 type= error happen");
            }
          }
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          Object localObject3;
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, paramIntent.getMessage());
          }
          Object localObject2 = null;
          continue;
          paramIntent = localNameNotFoundException;
          if (localNameNotFoundException.aREnd >= ((ArConfigInfo)localObject3).aREnd) {
            continue;
          }
          paramIntent = (Intent)localObject3;
          continue;
          OlympicServlet.a(localQQAppInterface, 87, j, m, 1, 5, 0);
          paramIntent = localNameNotFoundException;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||parseArConfig error!");
          paramIntent = localNameNotFoundException;
          continue;
        }
        OlympicServlet.a(localQQAppInterface, 87, j, m, 1, 4, 0);
        paramIntent = localNameNotFoundException;
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||deCompress error!");
          paramIntent = localNameNotFoundException;
        }
      }
    }
    if (localNameNotFoundException != null)
    {
      localNameNotFoundException.mArCloudConfigInfos = localArrayList;
      localNameNotFoundException.version = 2;
      localadex.KO(j);
      localadex.b(localNameNotFoundException);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "maxEndTimeArConfigInfo|| maxEndtime=" + localNameNotFoundException.aREnd);
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 0, 0);
    }
    for (;;)
    {
      i = 0;
      label648:
      if ((i == 0) || (localadex == null)) {
        break;
      }
      QLog.d("ArConfig_configServlet", 1, "arManager.downloadArResource");
      localadex.bN(true, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource|combineArConfigInfo is null");
      }
      OlympicServlet.a(localQQAppInterface, 87, j, 0, 0, 5, 0);
      continue;
      label707:
      localadex.cQY();
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource||msg_content_list is null!");
      }
    }
    label731:
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource || has same version");
    }
    for (;;)
    {
      i = 1;
      break label648;
      break;
      label752:
      QLog.d("ArConfig_configServlet", 2, "handleResp_GetArResource || fail");
      OlympicServlet.a(localQQAppInterface, 87, 0, 0, 1, 3, 0);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = alwd.a();
    int j = paramConfig.version.get();
    int i = aqmj.aT(((QQAppInterface)getAppRuntime()).getApp());
    if (!alwd.auE()) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager_VideoRedbag", 2, "serverVersion=" + j + "|localVersion=" + i);
      }
      if (j == i) {
        break;
      }
      aqmj.aA(((QQAppInterface)getAppRuntime()).getApp(), j);
      try
      {
        String str = a(paramConfig, i, 226);
        if (str != null)
        {
          paramIntent.E(paramQQAppInterface, str, 1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CapturePtvTemplateManager", 2, "receiveAllConfigs|type: 226,content: " + str + ",version: " + paramConfig.version.get());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CapturePtvTemplateManager", 2, "receiveAllConfigs|type: 226,content_list is empty ,version: " + paramConfig.version.get());
        }
        paramIntent.E(paramQQAppInterface, "", 1);
        return;
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.e("CapturePtvTemplateManager", 2, "receiveAllConfigs|exception:" + paramQQAppInterface.getMessage());
      return;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    int j = awis.t(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("AioReadInJoyConfigManager", 2, "received  Config remote version:" + i + " localversion= " + j);
    }
    if (i != j)
    {
      paramConfig = a(paramConfig, j, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AioReadInJoyConfigManager", 2, "config content : " + paramConfig);
      }
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    try
    {
      awis.Y(paramQQAppInterface, new JSONObject(paramConfig).optInt("hot_video_enable", 0));
      awis.j(paramQQAppInterface, i);
      return;
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioReadInJoyConfigManager", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  private float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat2 / 2.0F - paramFloat1 * paramFloat3 / (50.0F * 2.0F);
  }
  
  private void c(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.bi(BaseApplication.getContext(), mCurUin);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      aqmj.ay(BaseApplication.getContext(), mCurUin, i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        break label443;
      }
      Iterator localIterator = paramConfig.iterator();
      paramConfig = null;
      if (!localIterator.hasNext()) {
        break label443;
      }
      Object localObject1 = (String)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig: config_content =" + (String)localObject1);
      }
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject1).has("enable"))
          {
            i = ((JSONObject)localObject1).getInt("enable");
            localObject3 = aaku.a();
            if (i == 1)
            {
              bool = true;
              ((aaku)localObject3).s(paramQQAppInterface, bool);
              if (!((JSONObject)localObject1).has("list")) {
                break label417;
              }
              localObject3 = ((JSONObject)localObject1).getJSONArray("list");
              if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
                break label406;
              }
              j = ((JSONArray)localObject3).length();
              localObject1 = new HashSet();
              i = 0;
              if (i >= j) {
                break;
              }
            }
          }
        }
        catch (JSONException localJSONException1) {}
        try
        {
          paramConfig = ((JSONArray)localObject3).optString(i);
          if (!TextUtils.isEmpty(paramConfig)) {
            ((HashSet)localObject1).add(paramConfig);
          }
          i += 1;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            paramConfig = localJSONException1;
            localObject2 = localJSONException2;
          }
        }
        boolean bool = false;
        continue;
        aaku.a().s(paramQQAppInterface, false);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig  error =" + localJSONException1.getMessage());
        }
        aaku.a().s(paramQQAppInterface, false);
        aaku.a().a(paramQQAppInterface, null);
      }
    }
    label406:
    label417:
    label443:
    label444:
    for (;;)
    {
      break;
      aaku.a().a(paramQQAppInterface, localJSONException1);
      paramConfig = localJSONException1;
      continue;
      Object localObject2;
      aaku.a().a(paramQQAppInterface, paramConfig);
      break label444;
      aaku.a().a(paramQQAppInterface, paramConfig);
      break label444;
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "handleConversationPublicAccConfig:localVersiont == version ");
      }
      return;
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    int i = paramConfig.version.get();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    int j = yhf.t(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "RecommendedSticker received Config remote version:" + i + " localVersion= " + j);
    }
    if (i != j)
    {
      paramConfig = a(paramConfig, j, paramInt);
      if (TextUtils.isEmpty(paramConfig)) {}
    }
    try
    {
      paramConfig = new JSONObject(paramConfig);
      if ((paramConfig.has("useRecommendedSticker")) && (paramConfig.has("maxMatchLength")))
      {
        yhf.p(paramQQAppInterface, paramConfig.getBoolean("useRecommendedSticker"));
        yhf.l(localBaseApplication, str, paramConfig.getInt("maxMatchLength"));
      }
      for (;;)
      {
        yhf.j(paramQQAppInterface, i);
        return;
        yhf.p(paramQQAppInterface, false);
      }
    }
    catch (Exception paramConfig)
    {
      for (;;)
      {
        yhf.p(paramQQAppInterface, false);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, paramConfig.getMessage());
        }
      }
    }
  }
  
  private void c(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.aR(((QQAppInterface)getAppRuntime()).getApp());
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, serverVersion=" + i + "|localVersion=" + j);
    }
    byte[] arrayOfByte;
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label297;
        }
        arrayOfByte = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
        if (arrayOfByte == null) {
          break label292;
        }
      }
    }
    label292:
    label297:
    do
    {
      for (;;)
      {
        try
        {
          paramConfig = new String(arrayOfByte, "UTF-8");
          if (TextUtils.isEmpty(paramConfig)) {
            break;
          }
          boolean bool = apdg.qp(paramConfig);
          if (bool) {
            aqmj.ay(((QQAppInterface)getAppRuntime()).getApp(), i);
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopRankConfig", 2, "refreshConfig ret=" + bool);
          }
          return;
        }
        catch (Exception paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
          }
          paramConfig = null;
          continue;
        }
        catch (OutOfMemoryError paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
          }
          System.gc();
          try
          {
            paramConfig = new String(arrayOfByte, "UTF-8");
          }
          catch (Throwable paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TroopRankConfig", 2, "handleTroopRankConfigCmd", paramConfig);
            }
          }
        }
        paramConfig = null;
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopRankConfig", 2, "handleTroopRankConfigCmd, config_content is empty");
  }
  
  public static void cL(QQAppInterface paramQQAppInterface)
  {
    v(paramQQAppInterface, 5);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onSend configXml request");
    }
  }
  
  private String convertStreamToString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      try
      {
        paramInputStream.close();
        throw localObject;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localIOException.printStackTrace();
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  private void d(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handleResp_GetArGlobalConfig", 2, "handleResp_GetArGlobalConfig |  type= " + paramConfig.type.get());
    }
    adas localadas = (adas)((QQAppInterface)getAppRuntime()).getManager(220);
    int i;
    byte[] arrayOfByte;
    if (paramConfig.type.get() == 188)
    {
      i = paramConfig.version.get();
      if (paramIntent.getIntExtra("ar_global_key_config_version", 0) == i) {
        break label363;
      }
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label334;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent == null) {
        break label315;
      }
      if (paramIntent.compress.get() != 1) {
        break label301;
      }
      arrayOfByte = akrf.inflateConfigString(paramIntent.content.get().toByteArray());
      if (arrayOfByte == null) {
        break label382;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new String(arrayOfByte, "UTF-8");
        if (paramIntent != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config_content is " + paramIntent);
          }
          i = paramConfig.version.get();
          if (localadas.kO(paramIntent))
          {
            localadas.Kt(i);
            localadas.cPA();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config type 188");
        }
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramIntent)
        {
          paramIntent = null;
        }
        continue;
      }
      label301:
      paramIntent = paramIntent.content.get().toStringUtf8();
      continue;
      label315:
      if (QLog.isColorLevel())
      {
        QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
        continue;
        label334:
        if (localadas != null) {
          localadas.cPB();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "we delete ARConfig info here");
          continue;
          label363:
          if (QLog.isColorLevel())
          {
            QLog.d("handleResp_GetArGlobalConfigSPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, version same");
            continue;
            label382:
            paramIntent = null;
          }
        }
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), aevk.class);
    localNewIntent.putExtra("k_cmd_type", new int[] { paramInt });
    if (!aqmr.isEmpty(paramString)) {
      localNewIntent.putExtra("key_uin", paramString);
    }
    if ((!paramQQAppInterface.isLogin()) && (paramInt == 215)) {
      localNewIntent.setWithouLogin(true);
    }
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void d(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.Md();
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      aqmj.XD(i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleBeancurdConfigStr: " + paramConfig);
        }
        aqmj.UW(paramConfig);
        ((wkh)paramQQAppInterface.getManager(282)).xm(paramConfig);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("PatchLogTag", 1, "getPatchConfig app is null or uin is empty");
      return;
    }
    if ((paramInt != -1) && (PatchSharedPreUtil.getPatchConfigVersion(paramQQAppInterface.getApplication()) == paramInt))
    {
      QLog.d("PatchLogTag", 1, "getPatchConfig same version=" + paramInt + ", reason=" + paramString2);
      return;
    }
    mCurUin = paramString1;
    v(paramQQAppInterface, 46);
    QLog.d("PatchLogTag", 1, "getPatchConfig version=" + paramInt + ", reason=" + paramString2);
  }
  
  private void e(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i = paramConfig.version.get();
      int j = aqmj.aa(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("nearby_flower_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        aqmj.H(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        acie localacie = (acie)((QQAppInterface)getAppRuntime()).getManager(124);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label246;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localacie.eS(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label246:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 53,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void e(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.bh(BaseApplication.getContext(), mCurUin);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      aqmj.ax(BaseApplication.getContext(), mCurUin, i);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = paramConfig.iterator();
        if (paramConfig.hasNext())
        {
          Object localObject = (String)paramConfig.next();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig: config_content =" + (String)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = new JSONObject((String)localObject);
              ykm localykm;
              if (((JSONObject)localObject).has("kMarioConfigEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioConfigEnable");
                localykm = ykm.a(paramQQAppInterface);
                if (i != 1) {
                  break label324;
                }
                bool = true;
                localykm.Ab(bool);
              }
              if (((JSONObject)localObject).has("kMarioPageLen"))
              {
                i = ((JSONObject)localObject).getInt("kMarioPageLen");
                ykm.a(paramQQAppInterface).Ef(i);
              }
              if (((JSONObject)localObject).has("kMarioSaveAndShareEnable"))
              {
                i = ((JSONObject)localObject).getInt("kMarioSaveAndShareEnable");
                localykm = ykm.a(paramQQAppInterface);
                if (i != 1) {
                  break label330;
                }
                bool = true;
                localykm.Ac(bool);
              }
              if (!((JSONObject)localObject).has("kMarioSafeGateRequestInterval")) {
                break;
              }
              i = ((JSONObject)localObject).getInt("kMarioSafeGateRequestInterval");
              ykm.a(paramQQAppInterface).Ee(i);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
            break;
            label324:
            boolean bool = false;
            continue;
            label330:
            bool = false;
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("SPLASH_ConfigServlet", 2, "handleZhituConfig:localVersiont == version ");
    }
  }
  
  private void e(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = aqmj.aZ(localQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("VideoDownCTWhiteList", 2, String.format("received VideoDownCTWhiteList remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(80) }));
    }
    if (i != j)
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label167;
      }
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content: " + str + ",version: " + paramConfig.version.get());
      }
      aqmj.y(localQQAppInterface.getApp(), i, str);
    }
    label167:
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 80,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void eq(String paramString, int paramInt)
  {
    try
    {
      Object localObject = convertStreamToString(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (localObject != null)
      {
        paramString = ((String)localObject).substring(((String)localObject).indexOf("<?xml"), ((String)localObject).indexOf("</msg><msg")) + "</msg>";
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg1 = " + paramString);
        }
        String str = ((String)localObject).substring(((String)localObject).indexOf("<?xml"), ((String)localObject).indexOf("?>")) + "?>";
        localObject = ((String)localObject).substring(((String)localObject).indexOf("</msg><msg"), ((String)localObject).lastIndexOf("</msg>"));
        str = str + ((String)localObject).substring(6) + "</msg>";
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_upgrade_invite msg2 = " + str);
        }
        localObject = aqmj.f(((QQAppInterface)getAppRuntime()).getCurrentAccountUin());
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_video", paramString).commit();
        ((SharedPreferences)localObject).edit().putString("qav_upgrade_invite_multi", str).commit();
        aqmj.u(getAppRuntime().getApplication(), paramInt, mCurUin);
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse qav_upgrade_invite xml  exception : " + paramString.getMessage());
    }
  }
  
  private void er(String paramString, int paramInt)
  {
    try
    {
      paramString = convertStreamToString(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "qav_anychat_time_limit stream = " + paramString);
        }
        aqmj.h(((QQAppInterface)getAppRuntime()).getCurrentAccountUin()).edit().putString("qav_anychat_time_value", paramString).commit();
        aqmj.v(getAppRuntime().getApplication(), paramInt, mCurUin);
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet", 2, "parse qav_anychat_time_limit  exception : " + paramString.getMessage());
    }
  }
  
  private void es(String paramString, int paramInt)
  {
    int i;
    long l1;
    Object localObject1;
    Object localObject2;
    int k;
    Object localObject3;
    Object localObject4;
    long l2;
    long l3;
    Object localObject5;
    int j;
    try
    {
      Document localDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      NodeList localNodeList = localDocument.getElementsByTagName("pushbanner");
      paramString = "";
      i = 0;
      if (i < localNodeList.getLength())
      {
        l1 = Long.parseLong(localDocument.getElementsByTagName("channel").item(i).getFirstChild().getNodeValue());
        localObject1 = localDocument.getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
        localObject2 = localDocument.getElementsByTagName("digest").item(i).getFirstChild().getNodeValue();
        k = Integer.parseInt(localDocument.getElementsByTagName("weight").item(i).getFirstChild().getNodeValue());
        localObject3 = localDocument.getElementsByTagName("md5").item(i).getFirstChild();
        if (localObject3 != null) {
          paramString = ((Node)localObject3).getNodeValue();
        }
        localObject3 = localDocument.getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
        localObject4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        l2 = ((SimpleDateFormat)localObject4).parse((String)localObject3).getTime();
        l3 = ((SimpleDateFormat)localObject4).parse(localDocument.getElementsByTagName("begin").item(i).getFirstChild().getNodeValue()).getTime();
        if (System.currentTimeMillis() > l2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner is outdate , throw it");
          }
        }
        else
        {
          localObject3 = new StringBuffer();
          paramInt = 0;
          while (paramInt < localDocument.getElementsByTagName("url").item(i).getChildNodes().getLength())
          {
            ((StringBuffer)localObject3).append(localDocument.getElementsByTagName("url").item(i).getChildNodes().item(paramInt).getNodeValue());
            paramInt += 1;
          }
          localObject4 = ((StringBuffer)localObject3).toString();
          localObject3 = ((QQAppInterface)getAppRuntime()).a().createEntityManager();
          localObject5 = ((EntityManager)localObject3).query(ExpiredPushBanner.class);
          j = 0;
          paramInt = 0;
          if (localObject5 != null)
          {
            localObject5 = ((List)localObject5).iterator();
            label459:
            j = paramInt;
            if (((Iterator)localObject5).hasNext())
            {
              if (((ExpiredPushBanner)((Iterator)localObject5).next()).cid != l1) {
                break label1051;
              }
              paramInt = 1;
              break label1061;
            }
          }
          if (j != 0)
          {
            if (!QLog.isColorLevel()) {
              break label1054;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner had been close or click , throw it");
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "push exception : " + paramString.getMessage());
      }
    }
    return;
    if (paramString.length() < 15)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "this pushbanner md5 length < 15 .throw");
      }
    }
    else
    {
      localObject5 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString;
      if (!aehs.lD(paramString)) {
        ThreadManager.executeOnNetWorkThread(new ConfigServlet.4(this, (String)localObject1));
      }
      aehp.a.addElement(aehp.a.a(l1, (String)localObject2, (byte)3, (String)localObject1, (String)localObject4, (String)localObject5, l3 + "|" + l2, (short)k, paramString));
      paramInt = 1;
      k = 1;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((EntityManager)localObject3).query(ReportedBanner.class, false, null, null, null, null, "endtime DESC", null);
        j = paramInt;
        if (localObject1 != null)
        {
          j = paramInt;
          if (((List)localObject1).size() > 0)
          {
            localObject2 = ((List)localObject1).iterator();
            paramInt = k;
            if (((Iterator)localObject2).hasNext())
            {
              localObject4 = (ReportedBanner)((Iterator)localObject2).next();
              if ((localObject4 == null) || (((ReportedBanner)localObject4).cid != l1)) {
                continue;
              }
              paramInt = 0;
            }
            j = paramInt;
            if (((List)localObject1).size() > 18)
            {
              k = ((List)localObject1).size() - 1;
              j = paramInt;
              if (k >= 9)
              {
                localObject2 = (ReportedBanner)((List)localObject1).get(k);
                if ((localObject2 == null) || (((ReportedBanner)localObject2).cid == l1)) {
                  break label1064;
                }
                ((EntityManager)localObject3).remove((Entity)localObject2);
                break label1064;
              }
            }
          }
        }
        if (j == 0) {
          break label1015;
        }
        anot.a((QQAppInterface)getAppRuntime(), "dc00898", "", "", "0X80087C0", "0X80087C0", (int)l1, 0, "", "", "", "");
        localObject1 = new ReportedBanner();
        ((ReportedBanner)localObject1).cid = l1;
        ((ReportedBanner)localObject1).md5 = paramString;
        ((ReportedBanner)localObject1).endtime = l2;
        ((EntityManager)localObject3).persist((Entity)localObject1);
        if (!QLog.isColorLevel()) {
          break label1054;
        }
        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report cid: %d", new Object[] { Long.valueOf(l1) }));
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          break label1054;
        }
      }
      QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report exception t: %s", new Object[] { localThrowable }));
      break label1054;
      label1015:
      if (QLog.isColorLevel())
      {
        QLog.i("SPLASH_ConfigServlet", 2, String.format(Locale.getDefault(), "push banner report repeat cid: %d", new Object[] { Long.valueOf(l1) }));
        break label1054;
        break label1061;
      }
      label1051:
      label1054:
      i += 1;
      break;
      label1061:
      break label459;
      label1064:
      k -= 1;
    }
  }
  
  /* Error */
  private void et(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 1168	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: invokevirtual 1172	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   6: new 1174	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: ldc_w 1176
    //   14: invokevirtual 1180	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokespecial 1181	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokevirtual 1186	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   23: astore 14
    //   25: aload 14
    //   27: ldc_w 4312
    //   30: invokeinterface 1194 2 0
    //   35: astore 15
    //   37: ldc 18
    //   39: astore 12
    //   41: fconst_0
    //   42: fstore 4
    //   44: fconst_0
    //   45: fstore 5
    //   47: iconst_0
    //   48: istore 10
    //   50: ldc 18
    //   52: astore 11
    //   54: fconst_0
    //   55: fstore 6
    //   57: fconst_0
    //   58: fstore_3
    //   59: ldc_w 4314
    //   62: astore_1
    //   63: ldc 18
    //   65: astore 13
    //   67: iconst_0
    //   68: istore 9
    //   70: iload 9
    //   72: aload 15
    //   74: invokeinterface 1199 1 0
    //   79: if_icmpge +480 -> 559
    //   82: aload 14
    //   84: ldc_w 3694
    //   87: invokeinterface 1194 2 0
    //   92: iload 9
    //   94: invokeinterface 1205 2 0
    //   99: invokeinterface 1211 1 0
    //   104: invokeinterface 1214 1 0
    //   109: astore 13
    //   111: aload 14
    //   113: ldc_w 3700
    //   116: invokeinterface 1194 2 0
    //   121: iload 9
    //   123: invokeinterface 1205 2 0
    //   128: invokeinterface 1211 1 0
    //   133: invokeinterface 1214 1 0
    //   138: astore 12
    //   140: aload 14
    //   142: ldc_w 4315
    //   145: invokeinterface 1194 2 0
    //   150: iload 9
    //   152: invokeinterface 1205 2 0
    //   157: invokeinterface 1211 1 0
    //   162: invokeinterface 1214 1 0
    //   167: invokestatic 4321	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   170: fstore 4
    //   172: aload 14
    //   174: ldc_w 4322
    //   177: invokeinterface 1194 2 0
    //   182: iload 9
    //   184: invokeinterface 1205 2 0
    //   189: invokeinterface 1211 1 0
    //   194: invokeinterface 1214 1 0
    //   199: invokestatic 4321	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   202: fstore_3
    //   203: iconst_1
    //   204: istore 10
    //   206: aload 14
    //   208: ldc_w 4323
    //   211: invokeinterface 1194 2 0
    //   216: iload 9
    //   218: invokeinterface 1205 2 0
    //   223: invokeinterface 1211 1 0
    //   228: invokeinterface 1214 1 0
    //   233: invokestatic 4321	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   236: fstore 5
    //   238: aload 14
    //   240: ldc_w 4324
    //   243: invokeinterface 1194 2 0
    //   248: iload 9
    //   250: invokeinterface 1205 2 0
    //   255: invokeinterface 1211 1 0
    //   260: invokeinterface 1214 1 0
    //   265: invokestatic 4321	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   268: fstore 8
    //   270: aload 14
    //   272: ldc_w 4326
    //   275: invokeinterface 1194 2 0
    //   280: iload 9
    //   282: invokeinterface 1205 2 0
    //   287: invokeinterface 1211 1 0
    //   292: invokeinterface 1214 1 0
    //   297: astore 11
    //   299: aload 14
    //   301: ldc_w 4327
    //   304: invokeinterface 1194 2 0
    //   309: iload 9
    //   311: invokeinterface 1205 2 0
    //   316: invokeinterface 1211 1 0
    //   321: invokeinterface 1214 1 0
    //   326: invokestatic 4321	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   329: fstore 7
    //   331: aload 14
    //   333: ldc_w 4323
    //   336: invokeinterface 1194 2 0
    //   341: iload 9
    //   343: invokeinterface 1205 2 0
    //   348: invokeinterface 1211 1 0
    //   353: invokeinterface 1214 1 0
    //   358: invokestatic 4321	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   361: fstore 6
    //   363: aload 14
    //   365: ldc_w 4329
    //   368: invokeinterface 1194 2 0
    //   373: iload 9
    //   375: invokeinterface 1205 2 0
    //   380: invokeinterface 1211 1 0
    //   385: invokeinterface 1214 1 0
    //   390: astore_1
    //   391: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +295 -> 689
    //   397: ldc 169
    //   399: iconst_2
    //   400: new 68	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 4331
    //   410: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 13
    //   415: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w 4333
    //   421: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 12
    //   426: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc_w 4335
    //   432: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: fload 4
    //   437: invokevirtual 4338	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   440: ldc_w 4340
    //   443: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: fload_3
    //   447: invokevirtual 4338	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   450: ldc_w 4342
    //   453: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 10
    //   458: invokevirtual 692	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   461: ldc_w 4344
    //   464: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: fload 5
    //   469: invokevirtual 4338	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   472: ldc_w 4346
    //   475: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: fload 8
    //   480: invokevirtual 4338	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   483: ldc_w 4348
    //   486: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 11
    //   491: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 4350
    //   497: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: fload 7
    //   502: invokevirtual 4338	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   505: ldc_w 4352
    //   508: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto +168 -> 689
    //   524: astore_1
    //   525: aload 14
    //   527: ldc_w 4353
    //   530: invokeinterface 1194 2 0
    //   535: iload 9
    //   537: invokeinterface 1205 2 0
    //   542: invokeinterface 1211 1 0
    //   547: invokeinterface 1214 1 0
    //   552: invokestatic 4321	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   555: fstore_3
    //   556: goto -350 -> 206
    //   559: aload 13
    //   561: ifnull +125 -> 686
    //   564: aload 13
    //   566: invokevirtual 430	java/lang/String:trim	()Ljava/lang/String;
    //   569: ldc 18
    //   571: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   574: ifne +112 -> 686
    //   577: new 68	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   584: aload_0
    //   585: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   588: invokevirtual 2875	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   591: invokevirtual 3015	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   594: invokevirtual 3018	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   597: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 3048
    //   603: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   609: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 3048
    //   615: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 3103
    //   621: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: astore 14
    //   629: ldc_w 4355
    //   632: aload 13
    //   634: invokestatic 4360	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   637: astore 13
    //   639: fload_3
    //   640: fstore 7
    //   642: fload_3
    //   643: fconst_0
    //   644: fcmpg
    //   645: ifge +7 -> 652
    //   648: ldc 49
    //   650: fstore 7
    //   652: new 4362	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5
    //   655: dup
    //   656: aload_0
    //   657: aload 14
    //   659: aload 13
    //   661: fload 4
    //   663: fload 5
    //   665: fload 7
    //   667: aload 11
    //   669: aload_1
    //   670: fload 6
    //   672: iload 10
    //   674: iload_2
    //   675: aload 12
    //   677: invokespecial 4365	com/tencent/mobileqq/config/splashlogo/ConfigServlet$5:<init>	(Laevk;Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FZILjava/lang/String;)V
    //   680: iconst_2
    //   681: aconst_null
    //   682: iconst_0
    //   683: invokestatic 3643	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   686: return
    //   687: astore_1
    //   688: return
    //   689: iload 9
    //   691: iconst_1
    //   692: iadd
    //   693: istore 9
    //   695: fload_3
    //   696: fstore 5
    //   698: fload 6
    //   700: fstore_3
    //   701: fload 7
    //   703: fstore 6
    //   705: goto -635 -> 70
    //   708: astore_1
    //   709: ldc_w 4314
    //   712: astore_1
    //   713: goto -322 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	aevk
    //   0	716	1	paramString	String
    //   0	716	2	paramInt	int
    //   58	643	3	f1	float
    //   42	620	4	f2	float
    //   45	652	5	f3	float
    //   55	649	6	f4	float
    //   329	373	7	f5	float
    //   268	211	8	f6	float
    //   68	626	9	i	int
    //   48	625	10	bool	boolean
    //   52	616	11	str1	String
    //   39	637	12	str2	String
    //   65	595	13	str3	String
    //   23	635	14	localObject	Object
    //   35	38	15	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   172	203	524	java/lang/Exception
    //   0	37	687	java/lang/Exception
    //   70	172	687	java/lang/Exception
    //   206	363	687	java/lang/Exception
    //   391	521	687	java/lang/Exception
    //   525	556	687	java/lang/Exception
    //   564	639	687	java/lang/Exception
    //   652	686	687	java/lang/Exception
    //   363	391	708	java/lang/Exception
  }
  
  private void eu(String paramString, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        String str4 = getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/splashpic/";
        Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = ((Document)localObject2).getElementsByTagName("splash");
        String str3 = null;
        String str2 = null;
        Object localObject1 = null;
        paramString = "";
        String str1 = "";
        i = 0;
        if (i < localNodeList.getLength())
        {
          str3 = ((Document)localObject2).getElementsByTagName("img").item(i).getFirstChild().getNodeValue();
          str2 = ((Document)localObject2).getElementsByTagName("begin").item(i).getFirstChild().getNodeValue();
          localObject1 = ((Document)localObject2).getElementsByTagName("end").item(i).getFirstChild().getNodeValue();
          paramString = ((Document)localObject2).getElementsByTagName("md5").item(i).getFirstChild().getNodeValue();
          str1 = ((Document)localObject2).getElementsByTagName("channel").item(i).getFirstChild().getNodeValue();
          String str5 = ((Document)localObject2).getElementsByTagName("title").item(i).getFirstChild().getNodeValue();
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "parse result,img == " + str3 + " ,begin = " + str2 + " ,end=" + (String)localObject1 + ",md5=" + paramString + " title = " + str5);
          }
        }
        else
        {
          if ((str3 == null) || (str3.trim().equals(""))) {
            break;
          }
          str3 = MsfSdkUtils.insertMtype("ConfigCheck", str3);
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          str2 = ((SimpleDateFormat)localObject2).parse(str2).getTime() + "|" + ((SimpleDateFormat)localObject2).parse((String)localObject1).getTime();
          aqmj.c(getAppRuntime().getApplication(), paramInt, str2, paramString);
          new File(getAppRuntime().getApplication().getFilesDir().getAbsolutePath() + "/splashpic");
          if (((SimpleDateFormat)localObject2).parse((String)localObject1).getTime() < System.currentTimeMillis())
          {
            paramString = new File(str4 + paramString);
            if (paramString.exists()) {
              paramString.delete();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("SPLASH_ConfigServlet", 2, "this splash is outdate, throw it");
            return;
          }
          localObject1 = new File(str4 + paramString);
          localObject2 = new File(str4 + str2 + "_" + paramString + "_" + str1);
          if (((File)localObject2).exists()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("SPLASH_ConfigServlet", 2, "begin a thread try to download");
          }
          ThreadManager.post(new ConfigServlet.6(this, (File)localObject1, str3, paramString, (File)localObject2, str4, str2, str1, str3), 5, null, true);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      i += 1;
    }
  }
  
  private void f(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = paramIntent.getStringExtra("key_uin");
    if (!TextUtils.isEmpty(paramIntent))
    {
      int i = paramConfig.version.get();
      int j = aqmj.ab(((QQAppInterface)getAppRuntime()).getApp(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        aqmj.I(((QQAppInterface)getAppRuntime()).getApp(), paramIntent, i);
        HotChatManager localHotChatManager = (HotChatManager)((QQAppInterface)getAppRuntime()).getManager(60);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label246;
        }
        localList = paramConfig.content_list.get();
        if ((localList != null) && (localList.size() > 0))
        {
          localHotChatManager.eM(paramIntent, (String)localList.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 78,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
          }
        }
      }
    }
    label246:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 78,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void f(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    a(paramQQAppInterface, paramConfig, "handleShortVideoMsgTailConfig", new aevl(this, paramQQAppInterface));
  }
  
  private void f(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = aqmj.ba(localQQAppInterface.getApp());
    if (QLog.isColorLevel()) {
      QLog.d("MixMsgForwardConfig", 2, String.format("received MixMsgForwardConfig remote version: %d, localVersion: %d, cmd: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(111) }));
    }
    if (i != j)
    {
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label167;
      }
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 111,content: " + str + ",version: " + paramConfig.version.get());
      }
      aqmj.z(localQQAppInterface.getApp(), i, str);
    }
    label167:
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 111,content_list is empty ,version:" + paramConfig.version.get());
  }
  
  private void g(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int j = paramConfig.version.get();
    int i = aqmj.aS(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.auE()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      aqmj.az(((QQAppInterface)getAppRuntime()).getApp(), j);
      if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
        break label239;
      }
      localList = paramConfig.content_list.get();
      if ((localList != null) && (localList.size() > 0))
      {
        paramIntent.a((String)localList.get(0), (QQAppInterface)getAppRuntime(), 1);
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 84,content: " + (String)localList.get(0) + ",version: " + paramConfig.version.get());
        }
      }
    }
    label239:
    while (!QLog.isColorLevel())
    {
      List localList;
      return;
    }
    QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 84,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void g(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 96,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j == aqmj.i(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", mCurUin)) || (TextUtils.isEmpty((CharSequence)localObject))) {
              break label412;
            }
            localObject = ((String)localObject).split("=");
            if (localObject.length >= 2)
            {
              if (!"xqh_insert_into_feeds".equals(localObject[0])) {
                continue;
              }
              awit.at(paramQQAppInterface, "1".equals(localObject[1]));
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "update KANDIAN_INTERESTED_PUSH_CONFiG config , switch : " + "1".equals(localObject[1]));
              }
            }
            aqmj.g(paramQQAppInterface.getApp(), "readinjoy_interested_push_config", mCurUin, j);
            break label469;
            if ("simple_switch_fm".equals(localObject[0]))
            {
              awit.h(paramQQAppInterface, "1".equals(localObject[1]));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "update READINJOY_SIMPLE_SWITCH_FM config , switch : " + "1".equals(localObject[1]));
              continue;
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy interested push config error,cmd : 96" + paramQQAppInterface.toString());
        }
      }
      label412:
      do
      {
        if (!"simple_force_report_once".equals(localObject[0])) {
          break;
        }
        lgs.a(paramQQAppInterface, "1".equals(localObject[1]));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "update simple_force_report_once config , switch : " + "1".equals(localObject[1]));
        break;
        if (!QLog.isColorLevel()) {
          break label469;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "received KANDIAN_INTERESTED_PUSH_CONFiG IGNORE THIS ACTION  because of SAME VERSION ");
        break label469;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 96,content_list is empty ,version: " + paramConfig.version.get());
      return;
      label469:
      i += 1;
    }
  }
  
  private void g(ConfigurationService.Config paramConfig)
  {
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int k = paramConfig.version.get();
    int i = aqmj.aV(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.awA()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, String.format("个性笔触配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label115;
      }
    }
    label115:
    do
    {
      do
      {
        return;
        j = -1;
        break;
        if (j <= 0) {
          break label214;
        }
        paramConfig = a(paramConfig, i, 139);
        if (TextUtils.isEmpty(paramConfig)) {
          break label197;
        }
        localPtvTemplateManager.p(paramConfig, (QQAppInterface)getAppRuntime());
        aqmj.aC(((QQAppInterface)getAppRuntime()).getApp(), k);
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServletDoodle_Strokes_", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包内容, content: \n" + paramConfig);
      return;
    } while (!QLog.isColorLevel());
    label197:
    QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包内容为空");
    return;
    label214:
    if (QLog.isColorLevel()) {
      QLog.d("Doodle_Strokes_SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: 个性笔触配置回包为空");
    }
    localPtvTemplateManager.dPi();
  }
  
  private void h(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int j = paramConfig.version.get();
    int i = aqmj.aU(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.awz()) {
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateManager", 2, "serverVersion=" + j + "|localVersion=" + i);
      }
      if (j != i)
      {
        aqmj.aB(((QQAppInterface)getAppRuntime()).getApp(), j);
        String str = a(paramConfig, i, 167);
        if (str == null) {
          break label187;
        }
        paramIntent.a(str, (QQAppInterface)getAppRuntime(), 2);
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 167,content: " + str + ",version: " + paramConfig.version.get());
        }
      }
      label187:
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 167,content_list is empty ,version: " + paramConfig.version.get());
      return;
    }
  }
  
  private void h(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "receiveAllConfigs|type: 118,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int k = paramConfig.version.get();
            if (k != aqmj.i(paramQQAppInterface.getApp(), "now_entrance_action_version", mCurUin))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONArray((String)localObject);
                  int m = ((JSONArray)localObject).length();
                  int j = 0;
                  if (j < m)
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
                    aqmj.g(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("bid"), localJSONObject.optInt("actionType"));
                    j += 1;
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    break label341;
                  }
                }
                catch (JSONException localJSONException)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received JSONException ");
                  }
                  aqmj.g(paramQQAppInterface.getApp(), "now_entrance_action_version", mCurUin, k);
                }
              }
            }
            QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "received change machine config error,cmd : 118" + paramQQAppInterface.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServletQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "receiveAllConfigs|type: 118,content_list is empty ,version: " + paramConfig.version.get());
      return;
      label341:
      i += 1;
    }
  }
  
  private void h(ConfigurationService.Config paramConfig)
  {
    ayzv localayzv = ayzv.a();
    int k = paramConfig.version.get();
    int i = aqmj.bp(((QQAppInterface)getAppRuntime()).getApp());
    if (!localayzv.aRA()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, String.format("合拍配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label110;
      }
    }
    label110:
    do
    {
      do
      {
        return;
        j = -1;
        break;
        if (j <= 0) {
          break label212;
        }
        paramConfig = a(paramConfig, i, 329);
        if (TextUtils.isEmpty(paramConfig)) {
          break label195;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置内容, content: \n" + paramConfig);
        }
      } while (!localayzv.n(paramConfig, (QQAppInterface)getAppRuntime()));
      aqmj.aO(((QQAppInterface)getAppRuntime()).getApp(), k);
      return;
    } while (!QLog.isColorLevel());
    label195:
    QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包内容为空");
    return;
    label212:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_FOLLOW_CAPTURE_SPLASH_ConfigServlet", 2, "GetQQStoryFollowCaptureConfig|type: 合拍配置回包为空");
    }
    localayzv.eUy();
  }
  
  private void i(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    NearbyGrayTipsManager localNearbyGrayTipsManager;
    String str2;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_uin")))
    {
      int i = paramConfig.version.get();
      int j = aqmj.aQ(((QQAppInterface)getAppRuntime()).getApp());
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "serverVersion=" + i + "|localVersion=" + j);
      }
      if (i != j)
      {
        aqmj.ax(((QQAppInterface)getAppRuntime()).getApp(), i);
        localNearbyGrayTipsManager = (NearbyGrayTipsManager)((QQAppInterface)getAppRuntime()).getManager(93);
        if ((!paramConfig.content_list.has()) || (paramConfig.content_list.get().size() <= 0)) {
          break label481;
        }
        paramIntent = paramConfig.content_list.get();
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "config.content_list size=" + paramIntent.size());
        }
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          localNearbyGrayTipsManager.cKQ();
          Iterator localIterator = paramIntent.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str2 = (String)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content: " + str2 + ",version: " + paramConfig.version.get());
            }
          } while (aqmr.isEmpty(str2));
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(str2);
        if (((JSONObject)localObject).isNull("MD5")) {
          break label531;
        }
        str1 = ((JSONObject)localObject).getString("MD5");
        paramIntent = str1;
        if (!TextUtils.isEmpty(str1)) {
          paramIntent = str1.toLowerCase();
        }
        if (((JSONObject)localObject).isNull("URL")) {
          break label525;
        }
        str1 = ((JSONObject)localObject).getString("URL");
        if (aqmr.isEmpty(str1)) {
          break;
        }
        localObject = NearbyGrayTipsManager.rE();
        ThreadManager.post(new ConfigServlet.8(this, str1, new File((String)localObject + "temp.txt"), paramIntent, localNearbyGrayTipsManager), 8, null, false);
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "JSONException was thrown when parse json!!! string=" + str2);
        }
        paramIntent.printStackTrace();
      }
      break;
      localNearbyGrayTipsManager.cKP();
      localNearbyGrayTipsManager.Fv(true);
      return;
      label481:
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 23,content_list is empty ,version: " + paramConfig.version.get());
      }
      localNearbyGrayTipsManager.cKQ();
      return;
      label525:
      String str1 = null;
      continue;
      label531:
      paramIntent = null;
    }
  }
  
  private void i(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "receiveAllConfigs|type: 142,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if (j == aqmj.i(paramQQAppInterface.getApp(), "troop_common_config_version", mCurUin)) {
              break label625;
            }
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool) {
              break label625;
            }
            try
            {
              JSONObject localJSONObject = new JSONObject((String)localObject);
              aqmj.R(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optString("hot_chat_link"));
              aqmj.aa(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("aio_post_tab_plugin"));
              ((aptw)paramQQAppInterface.getManager(203)).bP(localJSONObject);
              ((aczb)paramQQAppInterface.getManager(126)).aL(localJSONObject);
              aqmj.Z(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), localJSONObject.optInt("create_troop_max_invite_num"));
              String str1 = localJSONObject.optString("nearby_faceVideo_show");
              String str2 = localJSONObject.optString("nearby_faceVideo_LV");
              String str3 = localJSONObject.optString("nearby_heart_switch");
              SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_enters", 4);
              localSharedPreferences.edit().putString("config_content", (String)localObject).commit();
              localSharedPreferences.edit().putString("nearby_faceVideo_show", str1).commit();
              localSharedPreferences.edit().putString("nearby_heart_switch", str3).commit();
              localSharedPreferences.edit().putString("nearby_faceVideo_LV", str2).commit();
              localObject = localJSONObject.optJSONObject("face_score_enter_config");
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("title"))) {
                localSharedPreferences.edit().putString("face_title", ((JSONObject)localObject).optString("title")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("detail_default"))) {
                localSharedPreferences.edit().putString("face_detail_default", ((JSONObject)localObject).optString("detail_default")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("jump_url"))) {
                localSharedPreferences.edit().putString("face_jump_url", ((JSONObject)localObject).optString("jump_url")).commit();
              }
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("detail_num"))) {
                localSharedPreferences.edit().putString("face_detail_num", ((JSONObject)localObject).optString("detail_num")).commit();
              }
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received JSONException ");
              continue;
            }
            aqmj.g(paramQQAppInterface.getApp(), "troop_common_config_version", mCurUin, j);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet.troop_common_config", 2, "received change machine config error,cmd : 142" + paramQQAppInterface.toString());
        }
      }
      label625:
      do
      {
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break;
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet.troop_common_config", 2, "receiveAllConfigs|type: 142,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  private void i(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    aqmj.t(getAppRuntime().getApplication(), i, mCurUin);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramConfig.content_list != null)
    {
      localObject1 = localObject2;
      if (paramConfig.content_list.size() > 0) {
        localObject1 = paramConfig.content_list.get();
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = (String)((List)localObject1).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        paramConfig = Xml.newPullParser();
        paramConfig.setInput(new ByteArrayInputStream(((String)localObject1).getBytes()), "UTF-8");
        for (i = 0; i != 1; i = paramConfig.next()) {
          if ((i == 2) && (paramConfig.getName().equalsIgnoreCase("JA_Switch"))) {
            JumpActivity.aR(paramConfig.nextText(), true);
          }
        }
        while (!QLog.isColorLevel()) {}
      }
      catch (Exception paramConfig)
      {
        paramConfig = paramConfig;
        paramConfig.printStackTrace();
        return;
      }
      finally {}
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 102,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static byte[] inflateConfigString(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  private float j(float paramFloat1, float paramFloat2)
  {
    return (50.0F + paramFloat1) / (50.0F * 2.0F) * paramFloat2;
  }
  
  private void j(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    int j = 0;
    paramIntent = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    if (i == aqmj.Y(((QQAppInterface)getAppRuntime()).getApp(), mCurUin)) {}
    for (;;)
    {
      return;
      aqmj.w(((QQAppInterface)getAppRuntime()).getApp(), i, mCurUin);
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        continue;
      }
      Object localObject1 = paramConfig.content_list.get();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        continue;
      }
      HashMap localHashMap = new HashMap();
      i = 0;
      if (i < ((List)localObject1).size())
      {
        Object localObject2 = (String)((List)localObject1).get(i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.fourTab", 2, "receiveAllConfigs|type: 115,content: " + (String)localObject2 + ",version: " + paramConfig.version.get());
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = ((String)localObject2).split("=");
          if ((localObject2 != null) && (localObject2.length == 2))
          {
            localHashMap.put(localObject2[0], localObject2[1]);
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqstory.fourTab", 2, "NowTabConfigCmd, name=" + localObject2[0] + ", val=" + localObject2[1]);
            }
          }
        }
      }
      paramConfig = (String)localHashMap.get("mqq_nowtab_plan");
      if (QLog.isColorLevel()) {
        QLog.i("nowtabPlan", 2, "nowtabPlan=" + paramConfig);
      }
      if (paramConfig != null) {}
      try
      {
        localObject1 = paramIntent.a().hT();
        i = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        k = Integer.valueOf(paramConfig).intValue();
        if (i != k)
        {
          localObject1 = new Integer[5];
          i = j;
        }
        switch (k)
        {
        case 0: 
          paramIntent.a().b = paramConfig.charAt(0);
          paramConfig = (String)localHashMap.get("mqq_nowtab_index");
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex=" + paramConfig);
          }
          if (paramConfig == null) {}
          break;
        }
      }
      catch (Exception paramConfig)
      {
        for (;;)
        {
          try
          {
            int k;
            for (;;)
            {
              paramIntent.getApp().getSharedPreferences("now_tab_sp", 0).edit().putInt("now_index_key", Integer.valueOf(paramConfig).intValue());
              paramIntent.a().aCV = Integer.valueOf(paramConfig).intValue();
              paramConfig = (String)localHashMap.get("mqq_open_myvideo");
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory:IsOpenMyVideo", 2, "IsOpenMyVideo=" + paramConfig);
              }
              try
              {
                if (TextUtils.isEmpty(paramConfig)) {
                  break;
                }
                ((pmb)paramIntent.getManager(181)).rO(Boolean.parseBoolean(paramConfig));
                return;
              }
              catch (Exception paramIntent)
              {
                QLog.w("Q.qqstory:drawerMyVideoItem", 2, "drawerMyVideoItem is not value of Int!");
                return;
              }
            }
            if (i < localObject1.length)
            {
              localObject1[i] = Integer.valueOf(0);
              i += 1;
            }
            else
            {
              localObject1[2] = Integer.valueOf(k);
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 0 1 nowtabPlan=" + paramConfig);
              }
              paramIntent.a().a((Integer[])localObject1);
              continue;
              paramConfig = paramConfig;
              QLog.w("Q.qqstory.fourTab:nowtabPlan", 2, "" + paramConfig.getMessage(), paramConfig);
              continue;
              localObject1[1] = Integer.valueOf(0);
              localObject1[2] = Integer.valueOf(k);
              paramIntent.a().a((Integer[])localObject1);
              if (QLog.isColorLevel())
              {
                QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 2 nowtabPlan=" + paramConfig);
                continue;
                localObject1[2] = Integer.valueOf(k);
                localObject1[1] = Integer.valueOf(1);
                paramIntent.a().a((Integer[])localObject1);
                if (QLog.isColorLevel()) {
                  QLog.i("Q.qqstory.fourTab:nowtabPlan", 2, "case 3 nowtabPlan=" + paramConfig);
                }
              }
            }
          }
          catch (Exception paramConfig)
          {
            QLog.w("Q.qqstory.fourTab:nowtabIndex", 2, "nowtabIndex is not value of Int!");
          }
        }
      }
    }
  }
  
  private void j(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 201,content: " + (String)localObject + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if (j != aqmj.i(paramQQAppInterface.getApp(), "nearby_config_version", mCurUin))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  aqmj.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), (JSONObject)localObject);
                  aqmj.g(paramQQAppInterface.getApp(), "nearby_config_version", mCurUin, j);
                }
                catch (JSONException localJSONException)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException ");
                  continue;
                }
              }
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received change machine config error,cmd : 201" + paramQQAppInterface.toString());
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 201,content_list is empty ,version: " + paramConfig.version.get());
          return;
        }
      }
      i += 1;
    }
  }
  
  private void j(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("MobileUnityManager", 2, "CMD_PHONE_UNITY_BANNER_CONFIG");
    }
    yuu localyuu = (yuu)localQQAppInterface.getManager(102);
    i = localyuu.xB();
    int m = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "newVersion " + m);
    }
    if (i == m) {
      return;
    }
    localObject1 = null;
    Object localObject2;
    Object localObject6;
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject2 = paramConfig.content_list.get();
      localObject6 = localObject1;
      if (localObject2 != null)
      {
        localObject6 = localObject1;
        if (((List)localObject2).size() > 0)
        {
          localObject1 = (String)((List)localObject2).get(0);
          localObject6 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            localObject6 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(localObject6)) {
          continue;
        }
        localyut2 = new yut();
      }
      catch (Throwable localThrowable2)
      {
        yut localyut2;
        XmlPullParser localXmlPullParser;
        int k;
        Object localObject3;
        yut localyut1 = null;
        i = 0;
        paramConfig = null;
        localObject1 = null;
        continue;
        localyut1 = null;
        int j = 0;
        Object localObject4 = null;
        Object localObject5 = null;
        continue;
      }
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(localObject6.getBytes()), "UTF-8");
        i = 0;
        paramConfig = null;
        localObject1 = null;
        k = 0;
        localyut1 = localyut2;
        j = i;
        localObject2 = paramConfig;
        localObject5 = localObject1;
        if (k == 1) {
          continue;
        }
        if (k != 2) {
          continue;
        }
        try
        {
          localObject2 = localXmlPullParser.getName();
          if (!((String)localObject2).equalsIgnoreCase("banner")) {
            continue;
          }
          k = localXmlPullParser.getAttributeCount();
          j = 0;
          if (j >= k) {
            continue;
          }
          localObject2 = localXmlPullParser.getAttributeName(j);
          if ("text".equals(localObject2))
          {
            localyut2.text = localXmlPullParser.getAttributeValue(j);
            j += 1;
            continue;
            localObject6 = localObject1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 34,content_list is empty ,version: " + paramConfig.version.get());
            localObject6 = localObject1;
            continue;
          }
          if (!"url".equals(localObject2)) {
            continue;
          }
          localyut2.url = localXmlPullParser.getAttributeValue(j);
          continue;
          QLog.e("PhoneContact.Manager", 1, "", localThrowable1);
        }
        catch (Throwable localThrowable1)
        {
          localyut1 = localyut2;
        }
      }
      catch (Throwable localThrowable3)
      {
        i = 0;
        paramConfig = null;
        localObject1 = null;
        localyut1 = localyut2;
        continue;
        continue;
        continue;
      }
      localObject5 = localObject1;
      localObject3 = paramConfig;
      j = i;
      localyuu.a(m, localObject6, localyut1);
      ((PhoneContactManagerImp)localQQAppInterface.getManager(11)).r(j, localObject5, (String)localObject3);
      return;
      if ("dayNum".equals(localObject3)) {
        localyut2.cbo = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("dayIntervalNum".equals(localObject3)) {
        localyut2.cbp = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("totalNum".equals(localObject3)) {
        localyut2.totalNum = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("loginNum".equals(localObject3)) {
        localyut2.cbq = Integer.valueOf(localXmlPullParser.getAttributeValue(j)).intValue();
      } else if ("banner".equals(localObject3)) {
        localyut2.boZ = "1".equals(localXmlPullParser.getAttributeValue(j));
      } else if ("setEntry".equals(localObject3)) {
        localyut2.bpa = "1".equals(localXmlPullParser.getAttributeValue(j));
      }
    }
    for (;;)
    {
      try
      {
        k = localXmlPullParser.next();
      }
      catch (Throwable localThrowable4)
      {
        localyut1 = localyut2;
      }
      if (((String)localObject3).equalsIgnoreCase("bindGuideWording"))
      {
        localObject3 = localXmlPullParser.nextText();
        localObject1 = localObject3;
      }
      else if (((String)localObject3).equalsIgnoreCase("bindGuideStyle"))
      {
        j = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        i = j;
      }
      else
      {
        if (!((String)localObject3).equalsIgnoreCase("guideWording")) {
          break label836;
        }
        localObject3 = localXmlPullParser.nextText();
        paramConfig = (ConfigurationService.Config)localObject3;
      }
    }
  }
  
  private void k(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    paramIntent = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = aqmj.Z(((QQAppInterface)getAppRuntime()).getApp(), mCurUin);
    if (i == j) {}
    label179:
    label195:
    do
    {
      do
      {
        return;
        aqmj.x(((QQAppInterface)getAppRuntime()).getApp(), i, mCurUin);
        for (;;)
        {
          try
          {
            if (paramConfig.msg_content_list != null)
            {
              i = paramConfig.msg_content_list.size();
              paramIntent = (aife)paramIntent.getManager(267);
              if (i <= 0) {
                break label195;
              }
              paramConfig = a(paramConfig, j, 286);
              paramIntent.aD(paramConfig);
              if (TextUtils.isEmpty(paramConfig)) {
                break label179;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd, content: \n" + paramConfig);
              return;
            }
          }
          catch (Exception paramIntent)
          {
            QLog.e("SPLASH_ConfigServlet", 2, "Exception e = " + paramIntent.toString());
            return;
          }
          i = -1;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNowDownloadEngineConfigCmd null");
      return;
      paramIntent.aD("");
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 286,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void k(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("NearbyActivity.nearByTabUrl", 4).edit();
      if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
      {
        int i = 0;
        if (i < paramConfig.content_list.size())
        {
          Object localObject = ((String)paramConfig.content_list.get(i)).trim();
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 129,content: " + (String)localObject + ",version: " + paramConfig.version.get());
          }
          int j = paramConfig.version.get();
          if (j != aqmj.i(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", mCurUin))
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (!bool) {
              for (;;)
              {
                try
                {
                  localObject = new JSONObject((String)localObject);
                  String str1 = ((JSONObject)localObject).getJSONObject("android").getString("url");
                  String str2 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_startLive");
                  String str3 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_personalCenter");
                  String str4 = ((JSONObject)localObject).getJSONObject("android").getString("menuCell_help");
                  localEditor.putString("nearByTabUrl", str1);
                  localEditor.putString("menuCell_startLive", str2);
                  localEditor.putString("menuCell_personalCenter", str3);
                  localEditor.putString("menuCell_help", str4);
                  if (Build.VERSION.SDK_INT >= 9) {
                    continue;
                  }
                  localEditor.commit();
                  if (QLog.isColorLevel()) {
                    QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received NearbyActivity.nearByTabUrl " + ((JSONObject)localObject).getJSONObject("android"));
                  }
                }
                catch (JSONException localJSONException)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received JSONException in get NearbyActivity.nearByTabUrl");
                  continue;
                }
                aqmj.g(paramQQAppInterface.getApp(), "nearby_nowlive_tab_config_version", mCurUin, j);
                i += 1;
                break;
                localEditor.apply();
              }
            }
          }
        }
        else
        {
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received change machine config error,cmd : 129" + paramQQAppInterface.toString());
      }
    }
    do
    {
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
      break;
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_config", 2, "receiveAllConfigs|type: 129,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void k(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = (String)paramConfig.content_list.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            int k = aqmj.ak(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD remote version: " + j + " | localVersion: " + k);
            }
            if ((j != k) || (paramConfig.content_list.size() > 0))
            {
              if ((obt.k((QQAppInterface)getAppRuntime(), str)) && (QLog.isColorLevel())) {
                QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD save version: " + j);
              }
              aqmj.Q(getAppRuntime().getApplication(), localQQAppInterface.getAccount(), j);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received SUBSCRIPT_RECOMMEND_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received subscript recommend config error,cmd : 66");
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 66,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  private void l(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {}
    for (Object localObject1 = paramConfig.content_list.get();; localObject1 = null)
    {
      HashMap localHashMap;
      int i;
      Object localObject2;
      Object localObject3;
      label863:
      label881:
      boolean bool;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localHashMap = new HashMap();
        i = 0;
        if (i < ((List)localObject1).size())
        {
          localObject2 = (String)((List)localObject1).get(i);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content: " + (String)localObject2 + ",version: " + paramConfig.version.get());
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((String)localObject2).split("=");
            if ((localObject2 != null) && (localObject2.length == 2))
            {
              localHashMap.put(localObject2[0], localObject2[1]);
              if (QLog.isColorLevel()) {
                QLog.i("SPLASH_ConfigServlet", 2, "GENERAL_CONFIGS_CMD, name=" + localObject2[0] + ", val=" + localObject2[1]);
              }
            }
          }
        }
        localObject2 = (String)localHashMap.get("ptlogin_flag");
        localObject1 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        ((SharedPreferences)localObject1).edit().putBoolean("ptlogin_flag" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
        localObject2 = (String)localHashMap.get("lmr_block");
        if (QLog.isColorLevel()) {
          QLog.i("new_regprxy_switch", 2, "GENERAL_CONFIGS_CMD, new_regprxy_switch=" + (String)localObject2);
        }
        if (localObject2 != null) {
          BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("new_regprxy_switch", "1".equalsIgnoreCase((String)localObject2)).commit();
        }
        localObject2 = (String)localHashMap.get("qfind_report_gps_bt_stat");
        String str = (String)localHashMap.get("qfind_searching");
        localObject3 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject3).putBoolean("qfind_searching" + getAppRuntime().getAccount(), "1".equals(str));
        ((SharedPreferences.Editor)localObject3).putBoolean("qfind_report_gps_bt_stat" + getAppRuntime().getAccount(), "1".equals(localObject2));
        ((SharedPreferences.Editor)localObject3).commit();
        if (QLog.isColorLevel()) {
          QLog.w("QFind", 2, "qfind flags qfindStatFlag=" + (String)localObject2 + ", qfind_searching=" + str);
        }
        localObject2 = (String)localHashMap.get("enable_public_device");
        if (localObject2 != null) {
          BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device" + "_" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
        }
        localObject2 = (String)localHashMap.get("search_device_enable_https");
        if (localObject2 != null)
        {
          BaseApplication.getContext().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("search_device_enable_https" + "_" + getAppRuntime().getAccount(), "1".equalsIgnoreCase((String)localObject2)).commit();
          if (QLog.isColorLevel()) {
            QLog.w("smartdevice", 2, "search_device_enable_https=" + (String)localObject2);
          }
        }
        localObject2 = (String)localHashMap.get("mqq_calltab");
        str = (String)localHashMap.get("mqq_calltab_setting");
        if ((localObject2 != null) || (str != null))
        {
          localObject3 = new Integer[7];
          if (localObject2 != null)
          {
            if (((String)localObject2).indexOf('|') <= 0) {
              break label2075;
            }
            if (localObject2.split("|")[0].equals("1"))
            {
              i = 1;
              localObject3[1] = Integer.valueOf(i);
            }
          }
          else
          {
            if (str != null)
            {
              if (!str.equals("1")) {
                break label2104;
              }
              i = 1;
              localObject3[5] = Integer.valueOf(i);
            }
            localQQAppInterface.d((Integer[])localObject3);
          }
        }
        else
        {
          localObject3 = (String)localHashMap.get("subscribe_discovery");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            oac.e(localQQAppInterface, "1".equals(localObject3));
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "subscribe discovery btn config : " + (String)localObject3);
            }
          }
          if ((localObject2 == null) || (str == null))
          {
            localObject3 = new Integer[7];
            if (localObject2 == null)
            {
              localObject3[1] = Integer.valueOf("0111100".charAt(1) - '0');
              localObject3[2] = Integer.valueOf("0111100".charAt(2) - '0');
            }
            if (str == null)
            {
              localObject3[5] = Integer.valueOf("0111100".charAt(5) - '0');
              localObject3[6] = Integer.valueOf("0111100".charAt(6) - '0');
            }
            localQQAppInterface.d((Integer[])localObject3);
          }
          localObject2 = (String)localHashMap.get("share_to_news");
          if (localObject2 != null) {
            awit.s((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("synchronize_to_qzone");
          if (localObject2 != null) {
            awit.t((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("merge_feeds");
          if (localObject2 != null) {
            awit.v((String)localObject2, localQQAppInterface);
          }
          localObject2 = (String)localHashMap.get("kandian_feeds");
          if (localObject2 != null) {
            awit.w((String)localObject2, localQQAppInterface);
          }
          i = paramConfig.version.get();
          aqmj.s(getAppRuntime().getApplication(), i, mCurUin);
          if ((paramIntent != null) && (paramIntent.hasExtra("update101Version"))) {
            SettingCloneUtil.writeValueForInt(getAppRuntime().getApplication(), mCurUin, null, "qqsetting_calltab_show_key_version", paramIntent.getIntExtra("update101Version", 0));
          }
          ArkAppCenter.GK((String)localHashMap.get("arkapp_pa_nshow"));
          ajrb.c(localQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf("1".equals(localHashMap.get("hotchat_demo"))));
          paramIntent = (alie)localQQAppInterface.getManager(89);
          paramIntent.Og((String)localHashMap.get("ptt_stream_slice_cfg"));
          paramIntent.Oh((String)localHashMap.get("ptt_optimize_cfg_v2"));
          paramIntent.Oi((String)localHashMap.get("ptt_pre_download"));
          paramIntent = (String)localHashMap.get("splashpic_charm_requirement");
          if (paramIntent != null) {
            HotChatManager.N(localQQAppInterface, paramIntent);
          }
          paramIntent = (String)localHashMap.get("kFreezeTipsShow");
          paramConfig = localQQAppInterface.getApp();
          if (Build.VERSION.SDK_INT <= 10) {
            break label2109;
          }
          i = 4;
          label1377:
          paramConfig = paramConfig.getSharedPreferences("qwallet_multi", i);
          if (paramConfig != null)
          {
            paramConfig = paramConfig.edit();
            if ((!TextUtils.isEmpty(paramIntent)) && (!"1".equals(paramIntent))) {
              break label2114;
            }
            bool = true;
            label1417:
            paramConfig.putBoolean("is_tenpay_yellowtip_valid", bool);
            paramIntent = (String)localHashMap.get("publicWhiteList");
            QWalletHelper.updatePublicAccWhiteMap(paramIntent);
            paramConfig.putString("publicAcc_white_list", paramIntent);
            paramConfig.commit();
          }
          QWalletHelper.updateHongBaoSpeedWitch(localQQAppInterface, (String)localHashMap.get("hongbao_speed"));
          paramIntent = (String)localHashMap.get("shortvideo_predownload_strategy");
          if (paramIntent == null) {}
        }
      }
      for (;;)
      {
        try
        {
          i = Integer.valueOf(paramIntent).intValue();
          localQQAppInterface.a().bL.set(i);
          paramIntent = (String)localHashMap.get("camera_compatible_list");
          if (paramIntent == null) {}
        }
        catch (Exception paramIntent)
        {
          try
          {
            anii.updateCompatibleList(paramIntent, true);
            paramIntent = (String)localHashMap.get("qqwifi_provider_mask");
            if (paramIntent != null) {
              ((SharedPreferences)localObject1).edit().putString("qqwifi_provider_mask", paramIntent).commit();
            }
            paramIntent = (String)localHashMap.get("signalling_switch");
            if (QLog.isColorLevel()) {
              QLog.i("signalling_switch", 2, "GENERAL_CONFIGS_CMD, signalling_switch=" + paramIntent);
            }
            if (paramIntent != null)
            {
              paramConfig = localQQAppInterface.a();
              if ("1".equals(paramIntent))
              {
                i = 1;
                paramConfig.UH(i);
              }
            }
            else
            {
              paramIntent = (String)localHashMap.get("public_offline_search_enable");
              if (QLog.isColorLevel()) {
                QLog.i("PAOfflineSearchManager", 2, "GENERAL_CONFIGS_CMD, public_offline_search_enable=" + paramIntent);
              }
              if (paramIntent != null)
              {
                paramConfig = amxe.a();
                if (!"1".equals(paramIntent)) {
                  continue;
                }
                bool = true;
                paramConfig.cEs = bool;
              }
              paramIntent = (String)localHashMap.get("public_advance_search_freq");
              if (QLog.isColorLevel()) {
                QLog.i("searchutils", 2, "GENERAL_CONFIGS_CMD, netsearchlevel=" + paramIntent);
              }
              if (paramIntent == null) {}
            }
          }
          catch (Exception paramIntent)
          {
            try
            {
              amxk.dDW = Integer.valueOf(paramIntent).intValue();
              aaze.bj((String)localHashMap.get("shortvideo_progressive_enable"));
              paramIntent = (String)localHashMap.get("aio_autoinput_time");
              if (paramIntent != null) {
                i = 900;
              }
              try
              {
                int j = Integer.parseInt(paramIntent);
                i = j;
              }
              catch (NumberFormatException paramConfig)
              {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time not a int");
                continue;
              }
              if (QLog.isColorLevel()) {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, aio_autoinput_time=" + paramIntent);
              }
              BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("aio_autoinput_time", i).commit();
              paramIntent = (String)localHashMap.get("pic_thumb_400");
              if (QLog.isColorLevel()) {
                QLog.i("inputx", 2, "GENERAL_CONFIGS_CMD, pic_thumb_400=" + paramIntent);
              }
              anof.hw("pic_thumb_400Enable", paramIntent);
              paramIntent = (String)localHashMap.get("Show_Business_Card");
              if (QLog.isColorLevel()) {
                QLog.d("BusinessCara_Manager", 2, "Show_Business_Card= " + paramIntent);
              }
              paramIntent = (String)localHashMap.get("TIMDocLimitSettingFlag");
              if (QLog.isColorLevel()) {
                QLog.i("TIMDocLimitSettingFlag", 2, "GENERAL_CONFIGS_CMD, TIMDocLimitSettingFlag = " + paramIntent);
              }
              if (paramIntent != null) {
                BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit().putBoolean("TIMDocLimitSettingFlag", "1".equalsIgnoreCase(paramIntent)).commit();
              }
              aiao.aoH();
              return;
              i = 0;
              break;
              label2075:
              if (((String)localObject2).equals("1"))
              {
                i = 1;
                localObject3[1] = Integer.valueOf(i);
                break label863;
              }
              i = 0;
              continue;
              label2104:
              i = 0;
              break label881;
              label2109:
              i = 0;
              break label1377;
              label2114:
              bool = false;
              break label1417;
              paramIntent = paramIntent;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet", 2, paramIntent.getMessage());
              continue;
              paramIntent = paramIntent;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("SPLASH_ConfigServlet", 2, "camera_compatible_list ERROR = " + paramIntent.getMessage());
              continue;
              i = 0;
              continue;
              bool = false;
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              continue;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 101,content_list is empty ,version: " + paramConfig.version.get());
        }
      }
    }
  }
  
  private void m(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a((QQAppInterface)getAppRuntime());
    int j = paramConfig.version.get();
    int i = aqmj.aX(((QQAppInterface)getAppRuntime()).getApp());
    if (!PtvTemplateManager.awB()) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateManager", 2, "GetBlessSpecialPendantConfig serverVersion=" + j + "|localVersion=" + i);
    }
    if (j != i)
    {
      aqmj.aD(((QQAppInterface)getAppRuntime()).getApp(), j);
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label269;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null)
      {
        if (paramIntent.compress.get() != 1) {
          break label255;
        }
        paramIntent = akrf.inflateConfigString(paramIntent.content.get().toByteArray());
        if (paramIntent == null) {
          break label250;
        }
      }
    }
    label250:
    label255:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramIntent = new String(paramIntent, "UTF-8");
          localPtvTemplateManager.q(paramIntent, (QQAppInterface)getAppRuntime());
          if (QLog.isColorLevel()) {
            QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 145,content: " + paramIntent + ",version: " + paramConfig.version.get());
          }
          return;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
        paramIntent = paramIntent.content.get().toStringUtf8();
      }
    }
    label269:
    QLog.d("PtvTemplateManager", 2, "receiveAllConfigs|type: 145,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void m(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        apqx localapqx = (apqx)paramQQAppInterface.getManager(183);
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 120,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != aqmj.i(paramQQAppInterface.getApp(), "change_machine_version", mCurUin)) && (!TextUtils.isEmpty(str)))
            {
              if (BaseApplicationImpl.isFirstLogin) {
                localapqx.Tz(str);
              }
              aqmj.g(paramQQAppInterface.getApp(), "change_machine_version", mCurUin, j);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received change machine config error,cmd : 120" + paramQQAppInterface.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 120,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  private void n(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 43,content: " + str + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = aqmj.ao(localQQAppInterface.getApp(), mCurUin);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        aqmj.R(localQQAppInterface.getApp(), mCurUin, i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save version: " + i);
        }
        a(i, "LocalChannelCity", str, localQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_LOCAL_CHANNEL_CONFIG_CMD save to database");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 43,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void o(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = aqmj.i(paramQQAppInterface.getApp(), "change_machine_version", mCurUin);
        if (paramConfig.msg_content_list == null) {
          break label262;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        apre localapre;
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatConfig error,cmd : 195", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig null");
        return;
        localapre.aD("");
        if (!QLog.isColorLevel()) {
          break label261;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 195,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      localapre = (apre)paramQQAppInterface.getManager(224);
      if (i > 0)
      {
        paramConfig = a(paramConfig, k, 195);
        localapre.aD(paramConfig);
        if (!TextUtils.isEmpty(paramConfig))
        {
          aqmj.g(paramQQAppInterface.getApp(), "change_machine_version", mCurUin, j);
          if (!QLog.isColorLevel()) {
            break label261;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatConfig, content: \n" + paramConfig);
          return;
        }
      }
      label261:
      return;
      label262:
      int i = -1;
    }
  }
  
  private void o(ConfigurationService.Config paramConfig)
  {
    try
    {
      int i = aqmj.bd(((QQAppInterface)getAppRuntime()).getApp());
      int j = paramConfig.version.get();
      if (i != j)
      {
        ThreadManager.post(new ConfigServlet.9(this, paramConfig), 8, null, false);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "received HOTCHAT_SCENE_CONFIGS_CMD same version, " + j);
        return;
      }
    }
    catch (Exception paramConfig)
    {
      paramConfig.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received HOTCHAT_SCENE_CONFIGS_CMD, EXCEPTION" + paramConfig.toString());
      }
    }
  }
  
  public static byte[] o(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    aqoj.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  private void p(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = aqmj.i(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", mCurUin);
        if (paramConfig.msg_content_list == null) {
          break label241;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyAuthVideoConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyAuthVideoConfig error,cmd : 227", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyAuthVideoConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label240;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 227,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = a(paramConfig, k, 227);
        if (!TextUtils.isEmpty(paramConfig))
        {
          ajrm.MV(paramConfig);
          aqmj.g(paramQQAppInterface.getApp(), "nearby_auth_video_config_version", mCurUin, j);
          if (!QLog.isColorLevel()) {
            break label240;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyAuthVideoConfig, content: \n" + paramConfig);
          return;
        }
      }
      label240:
      return;
      label241:
      int i = -1;
    }
  }
  
  private void p(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    try
    {
      int i = PatchSharedPreUtil.getPatchConfigVersion(BaseApplicationImpl.sApplication);
      int j = paramConfig.version.get();
      QLog.d("PatchLogTag", 1, "handlePatchConfigCmd server version: " + j + " | localVersion: " + i);
      if (j != i)
      {
        Object localObject = a(paramConfig);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          i = 0;
        }
        while (i < ((List)localObject).size())
        {
          paramConfig = (String)((List)localObject).get(i);
          QLog.d("PatchLogTag", 1, "handlePatchConfigCmd msg_content_list index=" + i + ", content=" + paramConfig);
          tnq.bh(BaseApplicationImpl.sApplication, paramConfig);
          i += 1;
          continue;
          if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
            i = 0;
          }
          while (i < paramConfig.content_list.size())
          {
            localObject = (String)paramConfig.content_list.get(i);
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd content_list index=" + i + ", content=" + (String)localObject);
            tnq.bh(BaseApplicationImpl.sApplication, (String)localObject);
            i += 1;
            continue;
            QLog.d("PatchLogTag", 1, "handlePatchConfigCmd msg_content_list and content_list are empty");
          }
        }
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, j);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, localQQAppInterface.getCurrentUin(), "actPatchConfig", 100, "");
      }
      for (;;)
      {
        tnj.aE(localQQAppInterface);
        if (PatchSharedPreUtil.getPatchConfigVersion(BaseApplicationImpl.sApplication) == j) {
          break;
        }
        PatchSharedPreUtil.updatePatchConfigVersion(BaseApplicationImpl.sApplication, 0);
        return;
        QLog.d("PatchLogTag", 1, "handlePatchConfigCmd not update config as same version");
      }
      return;
    }
    catch (Throwable paramConfig)
    {
      QLog.e("PatchLogTag", 1, "handlePatchConfigCmd throwable=" + paramConfig);
      PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, localQQAppInterface.getCurrentUin(), "actPatchConfig", 102, "");
    }
  }
  
  private void q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = aqmj.i(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", mCurUin);
        if (paramConfig.msg_content_list == null) {
          break label251;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatDialogConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatDialogConfig error,cmd : 268", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 268,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = a(paramConfig, k, 268);
        if (!TextUtils.isEmpty(paramConfig))
        {
          ((apre)paramQQAppInterface.getManager(224)).TB(paramConfig);
          aqmj.g(paramQQAppInterface.getApp(), "nearby_videochat_dialog_config_version", mCurUin, j);
          if (!QLog.isColorLevel()) {
            break label250;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatDialogConfig, content: \n" + paramConfig);
          return;
        }
      }
      label250:
      return;
      label251:
      int i = -1;
    }
  }
  
  private void q(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str1 = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,content: " + str1 + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = aqmj.ag(localQQAppInterface.getApp(), mCurUin);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        aqmj.N(localQQAppInterface.getApp(), mCurUin, i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD save version: " + i);
        }
        localIterator = paramConfig.content_list.get().iterator();
        while (localIterator.hasNext())
        {
          str2 = (String)localIterator.next();
          SearchConfigManager.m(localQQAppInterface, mCurUin, str2);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,config_content_item: " + str1 + ",version: " + paramConfig.version.get());
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SEARCH_CONFIG_CMD save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str1;
      int i;
      int j;
      Iterator localIterator;
      String str2;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 50,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void r(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      try
      {
        j = paramConfig.version.get();
        k = aqmj.i(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", mCurUin);
        if (paramConfig.msg_content_list == null) {
          break label251;
        }
        i = paramConfig.msg_content_list.size();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SPLASH_ConfigServlet", 2, String.format("handleNearbyVideoChatBannerConfig, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) }));
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.e("SPLASH_ConfigServlet", 2, "received handleNearbyVideoChatBannerConfig error,cmd : 269", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig null");
        return;
        if (!QLog.isColorLevel()) {
          break label250;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 269,content_list is empty ,version: " + paramConfig.version.get());
        return;
        if (j != k) {
          continue;
        }
      }
      if (i > 0)
      {
        paramConfig = a(paramConfig, k, 269);
        if (!TextUtils.isEmpty(paramConfig))
        {
          ((apre)paramQQAppInterface.getManager(224)).TA(paramConfig);
          aqmj.g(paramQQAppInterface.getApp(), "nearby_videochat_banner_config_version", mCurUin, j);
          if (!QLog.isColorLevel()) {
            break label250;
          }
          QLog.d("SPLASH_ConfigServlet", 2, "GetDoodleTemplateConfig|type: handleNearbyVideoChatBannerConfig, content: \n" + paramConfig);
          return;
        }
      }
      label250:
      return;
      label251:
      int i = -1;
    }
  }
  
  private void r(ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.10(this, paramConfig));
  }
  
  private void s(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = paramConfig.version.get();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    int i = aqmj.bz(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface);
    if (!axpx.aPv()) {
      i = 0;
    }
    int j;
    if (paramConfig.msg_content_list != null)
    {
      j = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, String.format("问答Tab配置回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (k != i) {
        break label112;
      }
    }
    label112:
    do
    {
      return;
      j = -1;
      break;
      if (j <= 0) {
        break label229;
      }
      paramConfig = a(paramConfig, i, 351);
      if (!TextUtils.isEmpty(paramConfig))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置内容, content: \n" + paramConfig);
        }
        aqmj.aK(((QQAppInterface)getAppRuntime()).getApp(), paramQQAppInterface, k);
        new axvw().a(paramConfig, axpx.bk.getAbsolutePath(), "temp_template_zip", new aevm(this));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包内容为空");
    return;
    label229:
    if (QLog.isColorLevel()) {
      QLog.d("QQSTORY_QUESTION_TAB_SPLASH_ConfigServlet", 2, "GetQQStoryQuestionTabConfig|type: 问答Tab配置回包为空");
    }
    axpx.eNQ();
  }
  
  private void s(ConfigurationService.Config paramConfig)
  {
    ThreadManager.post(new ConfigServlet.11(this, paramConfig), 5, null, false);
  }
  
  public static void t(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.aA(BaseApplication.getContext(), mCurUin);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      aqmj.E(BaseApplication.getContext(), i, mCurUin);
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        ajol.aq(paramQQAppInterface, (String)paramConfig.get(0));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleRespNewBoatConfig:localVersiont == version ");
  }
  
  public static void t(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, app is null, or uin is empty");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramInt == -1) || (aqmj.bd(paramQQAppInterface.getApp()) != paramInt)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, same version " + paramInt);
      return;
      mCurUin = paramString;
      v(paramQQAppInterface, 49);
    } while (!QLog.isColorLevel());
    QLog.d("Q.nearby", 2, "HOTCHAT_SCENE_CONFIGS_CMD, " + paramInt);
  }
  
  private void t(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content: " + str + ",version: " + paramConfig.version.get());
      }
      i = paramConfig.version.get();
      j = aqmj.be(localQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG remote version: " + i + " | localVersion: " + j);
      }
      if (i != j)
      {
        aqmj.aG(localQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save version: " + i);
        }
        anii.updateCompatibleList(str, true);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received CAMERA_COMPATIBLE_LIST_CONFIG save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 61,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void u(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      str = (String)paramConfig.content_list.get(0);
      i = paramConfig.version.get();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content: " + str + ",version: " + paramConfig.version.get());
      }
      if (i != aqmj.bg(localQQAppInterface.getApp()))
      {
        aqmj.aH(localQQAppInterface.getApp(), i);
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save version: " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received SHORTVIDEO_PROGRESSIVE_BLACKLIST_CONFIG save to sps");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 64,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  public static void v(QQAppInterface paramQQAppInterface, int paramInt)
  {
    d(paramQQAppInterface, paramInt, null);
  }
  
  private void v(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = paramQQAppInterface.xA();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          paramQQAppInterface.bv(i, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 97,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void v(ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.12(this, paramConfig));
  }
  
  public static void w(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoResourceManager", 2, "getShortVideoResourceConfig| getType=" + paramInt);
    }
    ShortVideoResourceManager.akY = System.currentTimeMillis();
    d(paramQQAppInterface, 215, null);
  }
  
  private void w(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleRespAddContactsViewConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if (j == aqmj.aB(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "AddContactsViewConfig serverVersion is equals to localVersion ");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "AddContactsViewConfig contentlist:" + paramConfig.content_list);
        }
      } while ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0));
      paramConfig = (String)paramConfig.content_list.get(0);
    } while (paramConfig == null);
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ConfigurationService.Config localConfig = null;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramConfig.getBytes()), "utf-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramQQAppInterface) {}
      int i = localXmlPullParser.next();
      localConfig = paramConfig;
      break label357;
      String str = localXmlPullParser.getName();
      paramConfig = localConfig;
      if (str != null)
      {
        paramConfig = localConfig;
        if (str.equalsIgnoreCase("entrencelist"))
        {
          paramConfig = localXmlPullParser.nextText();
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "AddContactsView entrencelist:" + localConfig);
          }
          if ((localConfig == null) || (localConfig.length() <= 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "success");
          }
          aqmj.e(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "AddContactsViewConfig appear exception:" + paramQQAppInterface.toString());
          return;
          label357:
          if (i != 1)
          {
            paramConfig = localConfig;
            switch (i)
            {
            }
            paramConfig = localConfig;
          }
        }
      }
    }
  }
  
  private void w(ConfigurationService.Config paramConfig)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handlePrecoverConfig, version=", Integer.valueOf(paramConfig.version.get()), ", type=", Integer.valueOf(paramConfig.type.get()), ", msg_content_list=", paramConfig.msg_content_list.get() });
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    ArrayList localArrayList = new ArrayList();
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0)) {}
    for (List localList = paramConfig.msg_content_list.get();; localList = null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handlePrecoverConfig, configList.size=");
        if (localList != null) {
          break label257;
        }
      }
      label257:
      for (Object localObject = "null";; localObject = Integer.valueOf(localList.size()))
      {
        QLog.d("SPLASH_ConfigServlet", 2, localObject);
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        while (i < localList.size())
        {
          localObject = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
          if (localObject != null)
          {
            int j = ((ConfigurationService.Content)localObject).task_id.get();
            localObject = alan.a((ConfigurationService.Content)localObject);
            if (localObject != null) {
              localArrayList.add(new Pair(Integer.valueOf(j), localObject));
            }
          }
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handlePrecoverConfig, configList is empty");
      }
      alan.j(localQQAppInterface.getApp(), paramConfig.version.get(), mCurUin);
      paramConfig = (alaj)localQQAppInterface.getManager(179);
      if (paramConfig != null)
      {
        paramConfig.lM(localArrayList);
        paramConfig.startDownload();
        paramConfig.Nz(true);
      }
      return;
    }
  }
  
  private void x(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ConfigurationService.Config localConfig = null;
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleRespClassicHeadConfig|type= " + paramConfig.type.get());
    }
    int j = paramConfig.version.get();
    if (j == aqmj.aC(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig serverVersion is equals to localVersion ");
      }
    }
    label81:
    do
    {
      break label81;
      break label81;
      do
      {
        return;
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "ClassicHeadConfig size:" + paramConfig.msg_content_list.size() + "ClassicHeadConfig content:" + paramConfig.msg_content_list.get(0));
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {}
    }
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      int i;
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break label81;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead xmlContent = " + paramConfig);
        }
        localXmlPullParser = Xml.newPullParser();
        try
        {
          localXmlPullParser.setInput(new ByteArrayInputStream(paramConfig.getBytes()), "utf-8");
          i = localXmlPullParser.getEventType();
        }
        catch (Exception paramQQAppInterface) {}
        i = localXmlPullParser.next();
        localConfig = paramConfig;
      }
      catch (Throwable paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "Throwable:" + paramConfig.getMessage());
        }
        paramConfig = null;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "inflateConfigString error!");
      }
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      String str = localXmlPullParser.getName();
      if ((str != null) && (str.equalsIgnoreCase("beginTime")))
      {
        paramConfig = localXmlPullParser.nextText();
      }
      else
      {
        paramConfig = localConfig;
        if (str != null)
        {
          paramConfig = localConfig;
          if (str.equalsIgnoreCase("endTime"))
          {
            paramConfig = localConfig + "|" + localXmlPullParser.nextText();
            continue;
            do
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead entrence:" + localConfig);
              }
              if ((localConfig == null) || (localConfig.length() <= 0)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "ClassicHead getContent success");
              }
              aqmj.f(paramQQAppInterface.getApp(), j, paramQQAppInterface.getCurrentAccountUin(), localConfig);
              paramQQAppInterface = (aczr)paramQQAppInterface.getManager(199);
              if (paramQQAppInterface == null) {
                break;
              }
              paramQQAppInterface.cPp();
              return;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("SPLASH_ConfigServlet", 2, "ClassicHeadConfig appear exception:", paramQQAppInterface);
              return;
            } while (i == 1);
            paramConfig = localConfig;
            switch (i)
            {
            }
            paramConfig = localConfig;
          }
        }
      }
    }
  }
  
  private void x(ConfigurationService.Config paramConfig)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = paramConfig.version.get();
    int j = aqmj.al(localQQAppInterface.getApp(), localQQAppInterface.getAccount());
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig remote version: " + i + " | localVersion: " + j);
    }
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      String str = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content: " + str + ",version: " + paramConfig.version.get());
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "received RedBagFoldMsgConfig content: " + str);
      }
      if (i != j) {
        zxj.b(localQQAppInterface, i, str);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 69,content_list is empty ,version: " + paramConfig.version.get());
      }
      if (i != j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, ignored because of SAME VERSION");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("msgFold", 2, "received RedBagFoldMsgConfig, content_list is empty, use default config");
    }
    paramConfig = (zxj)localQQAppInterface.getManager(125);
    paramConfig.bur = true;
    paramConfig.bus = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    paramConfig.cfu = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    paramConfig.but = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    paramConfig.buu = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    aqmj.a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), i, paramConfig.bus, paramConfig.cfu, paramConfig.but, paramConfig.buu);
  }
  
  private void y(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      i = paramConfig.version.get();
      j = aqmj.an(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
      if ((paramConfig.content_list == null) || (paramConfig.content_list.size() <= 0)) {
        break label156;
      }
      paramConfig = (String)paramConfig.content_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i + " ,localVersion:" + j + " ,configContent" + paramConfig);
      }
      if (i == j) {
        return;
      }
      if (!paramConfig.contains("headsup_switch")) {
        break label248;
      }
      bool = paramConfig.split("=")[1].trim().equals("true");
    }
    catch (Exception paramQQAppInterface)
    {
      int i;
      int j;
      boolean bool;
      label156:
      while (QLog.isColorLevel())
      {
        QLog.e("HeadsUp", 2, "received Headsup Notify error", paramQQAppInterface);
        return;
        label248:
        bool = false;
      }
    }
    aqmj.d(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, true, bool);
    return;
    if (i != j)
    {
      aqmj.d(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), i, false, true);
      paramQQAppInterface.a.cEy = false;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("HeadsUp", 2, "received Headsup Notify configVersion:" + i + " ,localVersion:" + j);
      return;
    }
  }
  
  private void y(ConfigurationService.Config paramConfig)
  {
    Object localObject = (QQAppInterface)getAppRuntime();
    if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
    {
      localObject = (achg)((QQAppInterface)localObject).getManager(159);
      if (paramConfig.content_list.size() < 0)
      {
        str = (String)paramConfig.content_list.get(0);
        i = paramConfig.version.get();
        j = ((achg)localObject).lA();
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content: " + str + ",version: " + paramConfig.version.get());
        }
        if ((i != j) || (paramConfig.content_list.size() > 0)) {
          ((achg)localObject).cb(i, str);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 74,content_list is empty ,version: " + paramConfig.version.get());
  }
  
  private void z(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    amkd.caC = paramQQAppInterface.getCurrentAccountUin();
    int i = paramConfig.version.get();
    int j = amkd.C(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchNetEntryConfig", 2, "handleSearchNetEntryConfig, version: " + i + " localVersion: " + j);
    }
    if (i == j) {
      return;
    }
    amkd.k(paramQQAppInterface.getApp(), i, paramQQAppInterface.getCurrentAccountUin());
    amkd.a(paramQQAppInterface.getApp(), paramConfig, paramQQAppInterface.getCurrentUin());
  }
  
  /* Error */
  private void z(ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 189	aevk:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 140	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 71
    //   9: aload_1
    //   10: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   13: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   16: istore 34
    //   18: aload 71
    //   20: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: aload 71
    //   25: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   28: invokestatic 1864	aqmj:bd	(Landroid/content/Context;Ljava/lang/String;)I
    //   31: istore_2
    //   32: aload 71
    //   34: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload 71
    //   39: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   42: invokestatic 1866	aqmj:be	(Landroid/content/Context;Ljava/lang/String;)I
    //   45: istore_3
    //   46: invokestatic 204	com/tencent/common/config/AppSetting:getAppId	()I
    //   49: istore 4
    //   51: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +49 -> 103
    //   57: ldc 169
    //   59: iconst_2
    //   60: ldc_w 5522
    //   63: iconst_4
    //   64: anewarray 178	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: iload 34
    //   71: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: iload_2
    //   78: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload_3
    //   85: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: iload 4
    //   93: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iload_3
    //   104: iload 4
    //   106: if_icmpeq +20 -> 126
    //   109: aload 71
    //   111: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   114: aload 71
    //   116: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   119: iload 4
    //   121: invokestatic 5524	aqmj:av	(Landroid/content/Context;Ljava/lang/String;I)V
    //   124: iconst_0
    //   125: istore_2
    //   126: iload 34
    //   128: iload_2
    //   129: if_icmpeq +3257 -> 3386
    //   132: aload_1
    //   133: iload_2
    //   134: sipush 228
    //   137: invokestatic 3445	aevk:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config;II)Ljava/lang/String;
    //   140: astore 72
    //   142: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc_w 5526
    //   151: iconst_2
    //   152: aload 72
    //   154: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload 72
    //   159: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne +3532 -> 3694
    //   165: iconst_0
    //   166: istore 20
    //   168: iconst_0
    //   169: istore 28
    //   171: iconst_0
    //   172: istore 29
    //   174: iconst_0
    //   175: istore 30
    //   177: iconst_0
    //   178: istore 31
    //   180: iconst_0
    //   181: istore 32
    //   183: iconst_0
    //   184: istore 33
    //   186: iconst_0
    //   187: istore_2
    //   188: iconst_0
    //   189: istore_3
    //   190: iconst_0
    //   191: istore 21
    //   193: iconst_0
    //   194: istore 22
    //   196: iconst_0
    //   197: istore 23
    //   199: iconst_0
    //   200: istore 24
    //   202: iconst_0
    //   203: istore 25
    //   205: iconst_0
    //   206: istore 26
    //   208: iconst_0
    //   209: istore 27
    //   211: aconst_null
    //   212: astore 67
    //   214: aconst_null
    //   215: astore 68
    //   217: aconst_null
    //   218: astore 69
    //   220: aconst_null
    //   221: astore 70
    //   223: aconst_null
    //   224: astore_1
    //   225: aconst_null
    //   226: astore 63
    //   228: aconst_null
    //   229: astore 64
    //   231: aconst_null
    //   232: astore 65
    //   234: aconst_null
    //   235: astore 66
    //   237: aconst_null
    //   238: astore 36
    //   240: ldc 18
    //   242: astore 39
    //   244: aconst_null
    //   245: astore 38
    //   247: aconst_null
    //   248: astore 60
    //   250: aconst_null
    //   251: astore 61
    //   253: aconst_null
    //   254: astore 62
    //   256: aconst_null
    //   257: astore 37
    //   259: iload_3
    //   260: istore 14
    //   262: iload 28
    //   264: istore 7
    //   266: aload 37
    //   268: astore 40
    //   270: aload 39
    //   272: astore 55
    //   274: aload 36
    //   276: astore 45
    //   278: aload_1
    //   279: astore 50
    //   281: iload 21
    //   283: istore 15
    //   285: iload 29
    //   287: istore 8
    //   289: aload 38
    //   291: astore 41
    //   293: aload 39
    //   295: astore 56
    //   297: aload 63
    //   299: astore 46
    //   301: aload 67
    //   303: astore 51
    //   305: iload 22
    //   307: istore 16
    //   309: iload 30
    //   311: istore 9
    //   313: aload 60
    //   315: astore 42
    //   317: aload 39
    //   319: astore 57
    //   321: aload 64
    //   323: astore 47
    //   325: aload 68
    //   327: astore 52
    //   329: iload 23
    //   331: istore 17
    //   333: iload 31
    //   335: istore 10
    //   337: aload 61
    //   339: astore 43
    //   341: aload 39
    //   343: astore 58
    //   345: aload 65
    //   347: astore 48
    //   349: aload 69
    //   351: astore 53
    //   353: iload 24
    //   355: istore 18
    //   357: iload 32
    //   359: istore 11
    //   361: aload 62
    //   363: astore 44
    //   365: aload 39
    //   367: astore 59
    //   369: aload 66
    //   371: astore 49
    //   373: aload 70
    //   375: astore 54
    //   377: invokestatic 1168	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   380: invokevirtual 1172	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   383: new 1174	java/io/ByteArrayInputStream
    //   386: dup
    //   387: aload 72
    //   389: ldc_w 1176
    //   392: invokevirtual 1180	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   395: invokespecial 1181	java/io/ByteArrayInputStream:<init>	([B)V
    //   398: invokevirtual 1186	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   401: astore 75
    //   403: iload_3
    //   404: istore 14
    //   406: iload 28
    //   408: istore 7
    //   410: aload 37
    //   412: astore 40
    //   414: aload 39
    //   416: astore 55
    //   418: aload 36
    //   420: astore 45
    //   422: aload_1
    //   423: astore 50
    //   425: iload 21
    //   427: istore 15
    //   429: iload 29
    //   431: istore 8
    //   433: aload 38
    //   435: astore 41
    //   437: aload 39
    //   439: astore 56
    //   441: aload 63
    //   443: astore 46
    //   445: aload 67
    //   447: astore 51
    //   449: iload 22
    //   451: istore 16
    //   453: iload 30
    //   455: istore 9
    //   457: aload 60
    //   459: astore 42
    //   461: aload 39
    //   463: astore 57
    //   465: aload 64
    //   467: astore 47
    //   469: aload 68
    //   471: astore 52
    //   473: iload 23
    //   475: istore 17
    //   477: iload 31
    //   479: istore 10
    //   481: aload 61
    //   483: astore 43
    //   485: aload 39
    //   487: astore 58
    //   489: aload 65
    //   491: astore 48
    //   493: aload 69
    //   495: astore 53
    //   497: iload 24
    //   499: istore 18
    //   501: iload 32
    //   503: istore 11
    //   505: aload 62
    //   507: astore 44
    //   509: aload 39
    //   511: astore 59
    //   513: aload 66
    //   515: astore 49
    //   517: aload 70
    //   519: astore 54
    //   521: aload 75
    //   523: ldc_w 5528
    //   526: invokeinterface 1194 2 0
    //   531: iconst_0
    //   532: invokeinterface 1205 2 0
    //   537: invokeinterface 1211 1 0
    //   542: invokeinterface 1214 1 0
    //   547: astore 72
    //   549: iload_3
    //   550: istore 14
    //   552: iload 28
    //   554: istore 7
    //   556: aload 37
    //   558: astore 40
    //   560: aload 39
    //   562: astore 55
    //   564: aload 36
    //   566: astore 45
    //   568: aload_1
    //   569: astore 50
    //   571: iload 21
    //   573: istore 15
    //   575: iload 29
    //   577: istore 8
    //   579: aload 38
    //   581: astore 41
    //   583: aload 39
    //   585: astore 56
    //   587: aload 63
    //   589: astore 46
    //   591: aload 67
    //   593: astore 51
    //   595: iload 22
    //   597: istore 16
    //   599: iload 30
    //   601: istore 9
    //   603: aload 60
    //   605: astore 42
    //   607: aload 39
    //   609: astore 57
    //   611: aload 64
    //   613: astore 47
    //   615: aload 68
    //   617: astore 52
    //   619: iload 23
    //   621: istore 17
    //   623: iload 31
    //   625: istore 10
    //   627: aload 61
    //   629: astore 43
    //   631: aload 39
    //   633: astore 58
    //   635: aload 65
    //   637: astore 48
    //   639: aload 69
    //   641: astore 53
    //   643: iload 24
    //   645: istore 18
    //   647: iload 32
    //   649: istore 11
    //   651: aload 62
    //   653: astore 44
    //   655: aload 39
    //   657: astore 59
    //   659: aload 66
    //   661: astore 49
    //   663: aload 70
    //   665: astore 54
    //   667: aload 75
    //   669: ldc_w 5530
    //   672: invokeinterface 1194 2 0
    //   677: iconst_0
    //   678: invokeinterface 1205 2 0
    //   683: invokeinterface 1211 1 0
    //   688: invokeinterface 1214 1 0
    //   693: astore 73
    //   695: iload_3
    //   696: istore 14
    //   698: iload 28
    //   700: istore 7
    //   702: aload 37
    //   704: astore 40
    //   706: aload 39
    //   708: astore 55
    //   710: aload 36
    //   712: astore 45
    //   714: aload_1
    //   715: astore 50
    //   717: iload 21
    //   719: istore 15
    //   721: iload 29
    //   723: istore 8
    //   725: aload 38
    //   727: astore 41
    //   729: aload 39
    //   731: astore 56
    //   733: aload 63
    //   735: astore 46
    //   737: aload 67
    //   739: astore 51
    //   741: iload 22
    //   743: istore 16
    //   745: iload 30
    //   747: istore 9
    //   749: aload 60
    //   751: astore 42
    //   753: aload 39
    //   755: astore 57
    //   757: aload 64
    //   759: astore 47
    //   761: aload 68
    //   763: astore 52
    //   765: iload 23
    //   767: istore 17
    //   769: iload 31
    //   771: istore 10
    //   773: aload 61
    //   775: astore 43
    //   777: aload 39
    //   779: astore 58
    //   781: aload 65
    //   783: astore 48
    //   785: aload 69
    //   787: astore 53
    //   789: iload 24
    //   791: istore 18
    //   793: iload 32
    //   795: istore 11
    //   797: aload 62
    //   799: astore 44
    //   801: aload 39
    //   803: astore 59
    //   805: aload 66
    //   807: astore 49
    //   809: aload 70
    //   811: astore 54
    //   813: aload 75
    //   815: ldc_w 5532
    //   818: invokeinterface 1194 2 0
    //   823: iconst_0
    //   824: invokeinterface 1205 2 0
    //   829: invokeinterface 1211 1 0
    //   834: invokeinterface 1214 1 0
    //   839: astore 74
    //   841: iload_3
    //   842: istore 14
    //   844: iload 28
    //   846: istore 7
    //   848: aload 37
    //   850: astore 40
    //   852: aload 39
    //   854: astore 55
    //   856: aload 36
    //   858: astore 45
    //   860: aload_1
    //   861: astore 50
    //   863: iload 21
    //   865: istore 15
    //   867: iload 29
    //   869: istore 8
    //   871: aload 38
    //   873: astore 41
    //   875: aload 39
    //   877: astore 56
    //   879: aload 63
    //   881: astore 46
    //   883: aload 67
    //   885: astore 51
    //   887: iload 22
    //   889: istore 16
    //   891: iload 30
    //   893: istore 9
    //   895: aload 60
    //   897: astore 42
    //   899: aload 39
    //   901: astore 57
    //   903: aload 64
    //   905: astore 47
    //   907: aload 68
    //   909: astore 52
    //   911: iload 23
    //   913: istore 17
    //   915: iload 31
    //   917: istore 10
    //   919: aload 61
    //   921: astore 43
    //   923: aload 39
    //   925: astore 58
    //   927: aload 65
    //   929: astore 48
    //   931: aload 69
    //   933: astore 53
    //   935: iload 24
    //   937: istore 18
    //   939: iload 32
    //   941: istore 11
    //   943: aload 62
    //   945: astore 44
    //   947: aload 39
    //   949: astore 59
    //   951: aload 66
    //   953: astore 49
    //   955: aload 70
    //   957: astore 54
    //   959: aload 75
    //   961: ldc_w 5534
    //   964: invokeinterface 1194 2 0
    //   969: iconst_0
    //   970: invokeinterface 1205 2 0
    //   975: invokeinterface 1211 1 0
    //   980: invokeinterface 1214 1 0
    //   985: astore_1
    //   986: iload_3
    //   987: istore 14
    //   989: iload 28
    //   991: istore 7
    //   993: aload 37
    //   995: astore 40
    //   997: aload 39
    //   999: astore 55
    //   1001: aload 36
    //   1003: astore 45
    //   1005: aload_1
    //   1006: astore 50
    //   1008: iload 21
    //   1010: istore 15
    //   1012: iload 29
    //   1014: istore 8
    //   1016: aload 38
    //   1018: astore 41
    //   1020: aload 39
    //   1022: astore 56
    //   1024: aload 63
    //   1026: astore 46
    //   1028: aload_1
    //   1029: astore 51
    //   1031: iload 22
    //   1033: istore 16
    //   1035: iload 30
    //   1037: istore 9
    //   1039: aload 60
    //   1041: astore 42
    //   1043: aload 39
    //   1045: astore 57
    //   1047: aload 64
    //   1049: astore 47
    //   1051: aload_1
    //   1052: astore 52
    //   1054: iload 23
    //   1056: istore 17
    //   1058: iload 31
    //   1060: istore 10
    //   1062: aload 61
    //   1064: astore 43
    //   1066: aload 39
    //   1068: astore 58
    //   1070: aload 65
    //   1072: astore 48
    //   1074: aload_1
    //   1075: astore 53
    //   1077: iload 24
    //   1079: istore 18
    //   1081: iload 32
    //   1083: istore 11
    //   1085: aload 62
    //   1087: astore 44
    //   1089: aload 39
    //   1091: astore 59
    //   1093: aload 66
    //   1095: astore 49
    //   1097: aload_1
    //   1098: astore 54
    //   1100: aload 75
    //   1102: ldc_w 5536
    //   1105: invokeinterface 1194 2 0
    //   1110: iconst_0
    //   1111: invokeinterface 1205 2 0
    //   1116: invokeinterface 1211 1 0
    //   1121: invokeinterface 1214 1 0
    //   1126: astore 36
    //   1128: iload_3
    //   1129: istore 14
    //   1131: iload 28
    //   1133: istore 7
    //   1135: aload 37
    //   1137: astore 40
    //   1139: aload 39
    //   1141: astore 55
    //   1143: aload 36
    //   1145: astore 45
    //   1147: aload_1
    //   1148: astore 50
    //   1150: iload 21
    //   1152: istore 15
    //   1154: iload 29
    //   1156: istore 8
    //   1158: aload 38
    //   1160: astore 41
    //   1162: aload 39
    //   1164: astore 56
    //   1166: aload 36
    //   1168: astore 46
    //   1170: aload_1
    //   1171: astore 51
    //   1173: iload 22
    //   1175: istore 16
    //   1177: iload 30
    //   1179: istore 9
    //   1181: aload 60
    //   1183: astore 42
    //   1185: aload 39
    //   1187: astore 57
    //   1189: aload 36
    //   1191: astore 47
    //   1193: aload_1
    //   1194: astore 52
    //   1196: iload 23
    //   1198: istore 17
    //   1200: iload 31
    //   1202: istore 10
    //   1204: aload 61
    //   1206: astore 43
    //   1208: aload 39
    //   1210: astore 58
    //   1212: aload 36
    //   1214: astore 48
    //   1216: aload_1
    //   1217: astore 53
    //   1219: iload 24
    //   1221: istore 18
    //   1223: iload 32
    //   1225: istore 11
    //   1227: aload 62
    //   1229: astore 44
    //   1231: aload 39
    //   1233: astore 59
    //   1235: aload 36
    //   1237: astore 49
    //   1239: aload_1
    //   1240: astore 54
    //   1242: aload 75
    //   1244: ldc_w 5538
    //   1247: invokeinterface 1194 2 0
    //   1252: iconst_0
    //   1253: invokeinterface 1205 2 0
    //   1258: invokeinterface 1211 1 0
    //   1263: invokeinterface 1214 1 0
    //   1268: astore 38
    //   1270: iload_3
    //   1271: istore 14
    //   1273: iload 28
    //   1275: istore 7
    //   1277: aload 38
    //   1279: astore 40
    //   1281: aload 39
    //   1283: astore 55
    //   1285: aload 36
    //   1287: astore 45
    //   1289: aload_1
    //   1290: astore 50
    //   1292: iload 21
    //   1294: istore 15
    //   1296: iload 29
    //   1298: istore 8
    //   1300: aload 38
    //   1302: astore 41
    //   1304: aload 39
    //   1306: astore 56
    //   1308: aload 36
    //   1310: astore 46
    //   1312: aload_1
    //   1313: astore 51
    //   1315: iload 22
    //   1317: istore 16
    //   1319: iload 30
    //   1321: istore 9
    //   1323: aload 38
    //   1325: astore 42
    //   1327: aload 39
    //   1329: astore 57
    //   1331: aload 36
    //   1333: astore 47
    //   1335: aload_1
    //   1336: astore 52
    //   1338: iload 23
    //   1340: istore 17
    //   1342: iload 31
    //   1344: istore 10
    //   1346: aload 38
    //   1348: astore 43
    //   1350: aload 39
    //   1352: astore 58
    //   1354: aload 36
    //   1356: astore 48
    //   1358: aload_1
    //   1359: astore 53
    //   1361: iload 24
    //   1363: istore 18
    //   1365: iload 32
    //   1367: istore 11
    //   1369: aload 38
    //   1371: astore 44
    //   1373: aload 39
    //   1375: astore 59
    //   1377: aload 36
    //   1379: astore 49
    //   1381: aload_1
    //   1382: astore 54
    //   1384: iload 25
    //   1386: istore 12
    //   1388: iload 33
    //   1390: istore 19
    //   1392: aload 39
    //   1394: astore 60
    //   1396: aload 75
    //   1398: ldc_w 5540
    //   1401: invokeinterface 1194 2 0
    //   1406: astore 61
    //   1408: aload 39
    //   1410: astore 37
    //   1412: aload 61
    //   1414: ifnull +428 -> 1842
    //   1417: aload 39
    //   1419: astore 37
    //   1421: iload_3
    //   1422: istore 14
    //   1424: iload 28
    //   1426: istore 7
    //   1428: aload 38
    //   1430: astore 40
    //   1432: aload 39
    //   1434: astore 55
    //   1436: aload 36
    //   1438: astore 45
    //   1440: aload_1
    //   1441: astore 50
    //   1443: iload 21
    //   1445: istore 15
    //   1447: iload 29
    //   1449: istore 8
    //   1451: aload 38
    //   1453: astore 41
    //   1455: aload 39
    //   1457: astore 56
    //   1459: aload 36
    //   1461: astore 46
    //   1463: aload_1
    //   1464: astore 51
    //   1466: iload 22
    //   1468: istore 16
    //   1470: iload 30
    //   1472: istore 9
    //   1474: aload 38
    //   1476: astore 42
    //   1478: aload 39
    //   1480: astore 57
    //   1482: aload 36
    //   1484: astore 47
    //   1486: aload_1
    //   1487: astore 52
    //   1489: iload 23
    //   1491: istore 17
    //   1493: iload 31
    //   1495: istore 10
    //   1497: aload 38
    //   1499: astore 43
    //   1501: aload 39
    //   1503: astore 58
    //   1505: aload 36
    //   1507: astore 48
    //   1509: aload_1
    //   1510: astore 53
    //   1512: iload 24
    //   1514: istore 18
    //   1516: iload 32
    //   1518: istore 11
    //   1520: aload 38
    //   1522: astore 44
    //   1524: aload 39
    //   1526: astore 59
    //   1528: aload 36
    //   1530: astore 49
    //   1532: aload_1
    //   1533: astore 54
    //   1535: iload 25
    //   1537: istore 12
    //   1539: iload 33
    //   1541: istore 19
    //   1543: aload 39
    //   1545: astore 60
    //   1547: aload 61
    //   1549: invokeinterface 1199 1 0
    //   1554: ifle +288 -> 1842
    //   1557: iload_3
    //   1558: istore 14
    //   1560: iload 28
    //   1562: istore 7
    //   1564: aload 38
    //   1566: astore 40
    //   1568: aload 39
    //   1570: astore 55
    //   1572: aload 36
    //   1574: astore 45
    //   1576: aload_1
    //   1577: astore 50
    //   1579: iload 21
    //   1581: istore 15
    //   1583: iload 29
    //   1585: istore 8
    //   1587: aload 38
    //   1589: astore 41
    //   1591: aload 39
    //   1593: astore 56
    //   1595: aload 36
    //   1597: astore 46
    //   1599: aload_1
    //   1600: astore 51
    //   1602: iload 22
    //   1604: istore 16
    //   1606: iload 30
    //   1608: istore 9
    //   1610: aload 38
    //   1612: astore 42
    //   1614: aload 39
    //   1616: astore 57
    //   1618: aload 36
    //   1620: astore 47
    //   1622: aload_1
    //   1623: astore 52
    //   1625: iload 23
    //   1627: istore 17
    //   1629: iload 31
    //   1631: istore 10
    //   1633: aload 38
    //   1635: astore 43
    //   1637: aload 39
    //   1639: astore 58
    //   1641: aload 36
    //   1643: astore 48
    //   1645: aload_1
    //   1646: astore 53
    //   1648: iload 24
    //   1650: istore 18
    //   1652: iload 32
    //   1654: istore 11
    //   1656: aload 38
    //   1658: astore 44
    //   1660: aload 39
    //   1662: astore 59
    //   1664: aload 36
    //   1666: astore 49
    //   1668: aload_1
    //   1669: astore 54
    //   1671: iload 25
    //   1673: istore 12
    //   1675: iload 33
    //   1677: istore 19
    //   1679: aload 39
    //   1681: astore 60
    //   1683: aload 61
    //   1685: iconst_0
    //   1686: invokeinterface 1205 2 0
    //   1691: invokeinterface 1211 1 0
    //   1696: astore 61
    //   1698: aload 39
    //   1700: astore 37
    //   1702: aload 61
    //   1704: ifnull +138 -> 1842
    //   1707: iload_3
    //   1708: istore 14
    //   1710: iload 28
    //   1712: istore 7
    //   1714: aload 38
    //   1716: astore 40
    //   1718: aload 39
    //   1720: astore 55
    //   1722: aload 36
    //   1724: astore 45
    //   1726: aload_1
    //   1727: astore 50
    //   1729: iload 21
    //   1731: istore 15
    //   1733: iload 29
    //   1735: istore 8
    //   1737: aload 38
    //   1739: astore 41
    //   1741: aload 39
    //   1743: astore 56
    //   1745: aload 36
    //   1747: astore 46
    //   1749: aload_1
    //   1750: astore 51
    //   1752: iload 22
    //   1754: istore 16
    //   1756: iload 30
    //   1758: istore 9
    //   1760: aload 38
    //   1762: astore 42
    //   1764: aload 39
    //   1766: astore 57
    //   1768: aload 36
    //   1770: astore 47
    //   1772: aload_1
    //   1773: astore 52
    //   1775: iload 23
    //   1777: istore 17
    //   1779: iload 31
    //   1781: istore 10
    //   1783: aload 38
    //   1785: astore 43
    //   1787: aload 39
    //   1789: astore 58
    //   1791: aload 36
    //   1793: astore 48
    //   1795: aload_1
    //   1796: astore 53
    //   1798: iload 24
    //   1800: istore 18
    //   1802: iload 32
    //   1804: istore 11
    //   1806: aload 38
    //   1808: astore 44
    //   1810: aload 39
    //   1812: astore 59
    //   1814: aload 36
    //   1816: astore 49
    //   1818: aload_1
    //   1819: astore 54
    //   1821: iload 25
    //   1823: istore 12
    //   1825: iload 33
    //   1827: istore 19
    //   1829: aload 39
    //   1831: astore 60
    //   1833: aload 61
    //   1835: invokeinterface 1214 1 0
    //   1840: astore 37
    //   1842: iload 27
    //   1844: istore 13
    //   1846: iload 26
    //   1848: istore 5
    //   1850: iload_2
    //   1851: istore 4
    //   1853: iload 20
    //   1855: istore 6
    //   1857: iload_3
    //   1858: istore 14
    //   1860: iload 28
    //   1862: istore 7
    //   1864: aload 38
    //   1866: astore 40
    //   1868: aload 37
    //   1870: astore 55
    //   1872: aload 36
    //   1874: astore 45
    //   1876: aload_1
    //   1877: astore 50
    //   1879: iload 21
    //   1881: istore 15
    //   1883: iload 29
    //   1885: istore 8
    //   1887: aload 38
    //   1889: astore 41
    //   1891: aload 37
    //   1893: astore 56
    //   1895: aload 36
    //   1897: astore 46
    //   1899: aload_1
    //   1900: astore 51
    //   1902: iload 22
    //   1904: istore 16
    //   1906: iload 30
    //   1908: istore 9
    //   1910: aload 38
    //   1912: astore 42
    //   1914: aload 37
    //   1916: astore 57
    //   1918: aload 36
    //   1920: astore 47
    //   1922: aload_1
    //   1923: astore 52
    //   1925: iload 23
    //   1927: istore 17
    //   1929: iload 31
    //   1931: istore 10
    //   1933: aload 38
    //   1935: astore 43
    //   1937: aload 37
    //   1939: astore 58
    //   1941: aload 36
    //   1943: astore 48
    //   1945: aload_1
    //   1946: astore 53
    //   1948: iload 24
    //   1950: istore 18
    //   1952: iload 32
    //   1954: istore 11
    //   1956: aload 38
    //   1958: astore 44
    //   1960: aload 37
    //   1962: astore 59
    //   1964: aload 36
    //   1966: astore 49
    //   1968: aload_1
    //   1969: astore 54
    //   1971: iload 25
    //   1973: istore 12
    //   1975: iload 33
    //   1977: istore 19
    //   1979: aload 37
    //   1981: astore 60
    //   1983: aload 72
    //   1985: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1988: ifne +1266 -> 3254
    //   1991: iload 27
    //   1993: istore 13
    //   1995: iload 26
    //   1997: istore 5
    //   1999: iload_2
    //   2000: istore 4
    //   2002: iload 20
    //   2004: istore 6
    //   2006: iload_3
    //   2007: istore 14
    //   2009: iload 28
    //   2011: istore 7
    //   2013: aload 38
    //   2015: astore 40
    //   2017: aload 37
    //   2019: astore 55
    //   2021: aload 36
    //   2023: astore 45
    //   2025: aload_1
    //   2026: astore 50
    //   2028: iload 21
    //   2030: istore 15
    //   2032: iload 29
    //   2034: istore 8
    //   2036: aload 38
    //   2038: astore 41
    //   2040: aload 37
    //   2042: astore 56
    //   2044: aload 36
    //   2046: astore 46
    //   2048: aload_1
    //   2049: astore 51
    //   2051: iload 22
    //   2053: istore 16
    //   2055: iload 30
    //   2057: istore 9
    //   2059: aload 38
    //   2061: astore 42
    //   2063: aload 37
    //   2065: astore 57
    //   2067: aload 36
    //   2069: astore 47
    //   2071: aload_1
    //   2072: astore 52
    //   2074: iload 23
    //   2076: istore 17
    //   2078: iload 31
    //   2080: istore 10
    //   2082: aload 38
    //   2084: astore 43
    //   2086: aload 37
    //   2088: astore 58
    //   2090: aload 36
    //   2092: astore 48
    //   2094: aload_1
    //   2095: astore 53
    //   2097: iload 24
    //   2099: istore 18
    //   2101: iload 32
    //   2103: istore 11
    //   2105: aload 38
    //   2107: astore 44
    //   2109: aload 37
    //   2111: astore 59
    //   2113: aload 36
    //   2115: astore 49
    //   2117: aload_1
    //   2118: astore 54
    //   2120: iload 25
    //   2122: istore 12
    //   2124: iload 33
    //   2126: istore 19
    //   2128: aload 37
    //   2130: astore 60
    //   2132: aload 73
    //   2134: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2137: ifne +1117 -> 3254
    //   2140: iload 27
    //   2142: istore 13
    //   2144: iload 26
    //   2146: istore 5
    //   2148: iload_2
    //   2149: istore 4
    //   2151: iload 20
    //   2153: istore 6
    //   2155: iload_3
    //   2156: istore 14
    //   2158: iload 28
    //   2160: istore 7
    //   2162: aload 38
    //   2164: astore 40
    //   2166: aload 37
    //   2168: astore 55
    //   2170: aload 36
    //   2172: astore 45
    //   2174: aload_1
    //   2175: astore 50
    //   2177: iload 21
    //   2179: istore 15
    //   2181: iload 29
    //   2183: istore 8
    //   2185: aload 38
    //   2187: astore 41
    //   2189: aload 37
    //   2191: astore 56
    //   2193: aload 36
    //   2195: astore 46
    //   2197: aload_1
    //   2198: astore 51
    //   2200: iload 22
    //   2202: istore 16
    //   2204: iload 30
    //   2206: istore 9
    //   2208: aload 38
    //   2210: astore 42
    //   2212: aload 37
    //   2214: astore 57
    //   2216: aload 36
    //   2218: astore 47
    //   2220: aload_1
    //   2221: astore 52
    //   2223: iload 23
    //   2225: istore 17
    //   2227: iload 31
    //   2229: istore 10
    //   2231: aload 38
    //   2233: astore 43
    //   2235: aload 37
    //   2237: astore 58
    //   2239: aload 36
    //   2241: astore 48
    //   2243: aload_1
    //   2244: astore 53
    //   2246: iload 24
    //   2248: istore 18
    //   2250: iload 32
    //   2252: istore 11
    //   2254: aload 38
    //   2256: astore 44
    //   2258: aload 37
    //   2260: astore 59
    //   2262: aload 36
    //   2264: astore 49
    //   2266: aload_1
    //   2267: astore 54
    //   2269: iload 25
    //   2271: istore 12
    //   2273: iload 33
    //   2275: istore 19
    //   2277: aload 37
    //   2279: astore 60
    //   2281: aload 36
    //   2283: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2286: ifne +968 -> 3254
    //   2289: iload 27
    //   2291: istore 13
    //   2293: iload 26
    //   2295: istore 5
    //   2297: iload_2
    //   2298: istore 4
    //   2300: iload 20
    //   2302: istore 6
    //   2304: iload_3
    //   2305: istore 14
    //   2307: iload 28
    //   2309: istore 7
    //   2311: aload 38
    //   2313: astore 40
    //   2315: aload 37
    //   2317: astore 55
    //   2319: aload 36
    //   2321: astore 45
    //   2323: aload_1
    //   2324: astore 50
    //   2326: iload 21
    //   2328: istore 15
    //   2330: iload 29
    //   2332: istore 8
    //   2334: aload 38
    //   2336: astore 41
    //   2338: aload 37
    //   2340: astore 56
    //   2342: aload 36
    //   2344: astore 46
    //   2346: aload_1
    //   2347: astore 51
    //   2349: iload 22
    //   2351: istore 16
    //   2353: iload 30
    //   2355: istore 9
    //   2357: aload 38
    //   2359: astore 42
    //   2361: aload 37
    //   2363: astore 57
    //   2365: aload 36
    //   2367: astore 47
    //   2369: aload_1
    //   2370: astore 52
    //   2372: iload 23
    //   2374: istore 17
    //   2376: iload 31
    //   2378: istore 10
    //   2380: aload 38
    //   2382: astore 43
    //   2384: aload 37
    //   2386: astore 58
    //   2388: aload 36
    //   2390: astore 48
    //   2392: aload_1
    //   2393: astore 53
    //   2395: iload 24
    //   2397: istore 18
    //   2399: iload 32
    //   2401: istore 11
    //   2403: aload 38
    //   2405: astore 44
    //   2407: aload 37
    //   2409: astore 59
    //   2411: aload 36
    //   2413: astore 49
    //   2415: aload_1
    //   2416: astore 54
    //   2418: iload 25
    //   2420: istore 12
    //   2422: iload 33
    //   2424: istore 19
    //   2426: aload 37
    //   2428: astore 60
    //   2430: aload 38
    //   2432: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2435: ifne +819 -> 3254
    //   2438: iload 27
    //   2440: istore 13
    //   2442: iload 26
    //   2444: istore 5
    //   2446: iload_2
    //   2447: istore 4
    //   2449: iload 20
    //   2451: istore 6
    //   2453: iload_3
    //   2454: istore 14
    //   2456: iload 28
    //   2458: istore 7
    //   2460: aload 38
    //   2462: astore 40
    //   2464: aload 37
    //   2466: astore 55
    //   2468: aload 36
    //   2470: astore 45
    //   2472: aload_1
    //   2473: astore 50
    //   2475: iload 21
    //   2477: istore 15
    //   2479: iload 29
    //   2481: istore 8
    //   2483: aload 38
    //   2485: astore 41
    //   2487: aload 37
    //   2489: astore 56
    //   2491: aload 36
    //   2493: astore 46
    //   2495: aload_1
    //   2496: astore 51
    //   2498: iload 22
    //   2500: istore 16
    //   2502: iload 30
    //   2504: istore 9
    //   2506: aload 38
    //   2508: astore 42
    //   2510: aload 37
    //   2512: astore 57
    //   2514: aload 36
    //   2516: astore 47
    //   2518: aload_1
    //   2519: astore 52
    //   2521: iload 23
    //   2523: istore 17
    //   2525: iload 31
    //   2527: istore 10
    //   2529: aload 38
    //   2531: astore 43
    //   2533: aload 37
    //   2535: astore 58
    //   2537: aload 36
    //   2539: astore 48
    //   2541: aload_1
    //   2542: astore 53
    //   2544: iload 24
    //   2546: istore 18
    //   2548: iload 32
    //   2550: istore 11
    //   2552: aload 38
    //   2554: astore 44
    //   2556: aload 37
    //   2558: astore 59
    //   2560: aload 36
    //   2562: astore 49
    //   2564: aload_1
    //   2565: astore 54
    //   2567: iload 25
    //   2569: istore 12
    //   2571: iload 33
    //   2573: istore 19
    //   2575: aload 37
    //   2577: astore 60
    //   2579: aload_1
    //   2580: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2583: ifne +671 -> 3254
    //   2586: iload 27
    //   2588: istore 13
    //   2590: iload 26
    //   2592: istore 5
    //   2594: iload_2
    //   2595: istore 4
    //   2597: iload 20
    //   2599: istore 6
    //   2601: iload_3
    //   2602: istore 14
    //   2604: iload 28
    //   2606: istore 7
    //   2608: aload 38
    //   2610: astore 40
    //   2612: aload 37
    //   2614: astore 55
    //   2616: aload 36
    //   2618: astore 45
    //   2620: aload_1
    //   2621: astore 50
    //   2623: iload 21
    //   2625: istore 15
    //   2627: iload 29
    //   2629: istore 8
    //   2631: aload 38
    //   2633: astore 41
    //   2635: aload 37
    //   2637: astore 56
    //   2639: aload 36
    //   2641: astore 46
    //   2643: aload_1
    //   2644: astore 51
    //   2646: iload 22
    //   2648: istore 16
    //   2650: iload 30
    //   2652: istore 9
    //   2654: aload 38
    //   2656: astore 42
    //   2658: aload 37
    //   2660: astore 57
    //   2662: aload 36
    //   2664: astore 47
    //   2666: aload_1
    //   2667: astore 52
    //   2669: iload 23
    //   2671: istore 17
    //   2673: iload 31
    //   2675: istore 10
    //   2677: aload 38
    //   2679: astore 43
    //   2681: aload 37
    //   2683: astore 58
    //   2685: aload 36
    //   2687: astore 48
    //   2689: aload_1
    //   2690: astore 53
    //   2692: iload 24
    //   2694: istore 18
    //   2696: iload 32
    //   2698: istore 11
    //   2700: aload 38
    //   2702: astore 44
    //   2704: aload 37
    //   2706: astore 59
    //   2708: aload 36
    //   2710: astore 49
    //   2712: aload_1
    //   2713: astore 54
    //   2715: iload 25
    //   2717: istore 12
    //   2719: iload 33
    //   2721: istore 19
    //   2723: aload 37
    //   2725: astore 60
    //   2727: aload 74
    //   2729: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2732: ifne +522 -> 3254
    //   2735: iload_3
    //   2736: istore 14
    //   2738: iload 28
    //   2740: istore 7
    //   2742: aload 38
    //   2744: astore 40
    //   2746: aload 37
    //   2748: astore 55
    //   2750: aload 36
    //   2752: astore 45
    //   2754: aload_1
    //   2755: astore 50
    //   2757: iload 21
    //   2759: istore 15
    //   2761: iload 29
    //   2763: istore 8
    //   2765: aload 38
    //   2767: astore 41
    //   2769: aload 37
    //   2771: astore 56
    //   2773: aload 36
    //   2775: astore 46
    //   2777: aload_1
    //   2778: astore 51
    //   2780: iload 22
    //   2782: istore 16
    //   2784: iload 30
    //   2786: istore 9
    //   2788: aload 38
    //   2790: astore 42
    //   2792: aload 37
    //   2794: astore 57
    //   2796: aload 36
    //   2798: astore 47
    //   2800: aload_1
    //   2801: astore 52
    //   2803: iload 23
    //   2805: istore 17
    //   2807: iload 31
    //   2809: istore 10
    //   2811: aload 38
    //   2813: astore 43
    //   2815: aload 37
    //   2817: astore 58
    //   2819: aload 36
    //   2821: astore 48
    //   2823: aload_1
    //   2824: astore 53
    //   2826: iload 24
    //   2828: istore 18
    //   2830: iload 32
    //   2832: istore 11
    //   2834: aload 38
    //   2836: astore 44
    //   2838: aload 37
    //   2840: astore 59
    //   2842: aload 36
    //   2844: astore 49
    //   2846: aload_1
    //   2847: astore 54
    //   2849: iload 25
    //   2851: istore 12
    //   2853: iload 33
    //   2855: istore 19
    //   2857: aload 37
    //   2859: astore 60
    //   2861: aload 72
    //   2863: invokestatic 604	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2866: invokevirtual 607	java/lang/Integer:intValue	()I
    //   2869: istore_2
    //   2870: iload_3
    //   2871: istore 14
    //   2873: iload_2
    //   2874: istore 7
    //   2876: aload 38
    //   2878: astore 40
    //   2880: aload 37
    //   2882: astore 55
    //   2884: aload 36
    //   2886: astore 45
    //   2888: aload_1
    //   2889: astore 50
    //   2891: iload 21
    //   2893: istore 15
    //   2895: iload_2
    //   2896: istore 8
    //   2898: aload 38
    //   2900: astore 41
    //   2902: aload 37
    //   2904: astore 56
    //   2906: aload 36
    //   2908: astore 46
    //   2910: aload_1
    //   2911: astore 51
    //   2913: iload 22
    //   2915: istore 16
    //   2917: iload_2
    //   2918: istore 9
    //   2920: aload 38
    //   2922: astore 42
    //   2924: aload 37
    //   2926: astore 57
    //   2928: aload 36
    //   2930: astore 47
    //   2932: aload_1
    //   2933: astore 52
    //   2935: iload 23
    //   2937: istore 17
    //   2939: iload_2
    //   2940: istore 10
    //   2942: aload 38
    //   2944: astore 43
    //   2946: aload 37
    //   2948: astore 58
    //   2950: aload 36
    //   2952: astore 48
    //   2954: aload_1
    //   2955: astore 53
    //   2957: iload 24
    //   2959: istore 18
    //   2961: iload_2
    //   2962: istore 11
    //   2964: aload 38
    //   2966: astore 44
    //   2968: aload 37
    //   2970: astore 59
    //   2972: aload 36
    //   2974: astore 49
    //   2976: aload_1
    //   2977: astore 54
    //   2979: iload 25
    //   2981: istore 12
    //   2983: iload_2
    //   2984: istore 19
    //   2986: aload 37
    //   2988: astore 60
    //   2990: aload 73
    //   2992: invokestatic 604	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2995: invokevirtual 607	java/lang/Integer:intValue	()I
    //   2998: istore_3
    //   2999: iload_3
    //   3000: istore 14
    //   3002: iload_2
    //   3003: istore 7
    //   3005: aload 38
    //   3007: astore 40
    //   3009: aload 37
    //   3011: astore 55
    //   3013: aload 36
    //   3015: astore 45
    //   3017: aload_1
    //   3018: astore 50
    //   3020: iload_3
    //   3021: istore 15
    //   3023: iload_2
    //   3024: istore 8
    //   3026: aload 38
    //   3028: astore 41
    //   3030: aload 37
    //   3032: astore 56
    //   3034: aload 36
    //   3036: astore 46
    //   3038: aload_1
    //   3039: astore 51
    //   3041: iload_3
    //   3042: istore 16
    //   3044: iload_2
    //   3045: istore 9
    //   3047: aload 38
    //   3049: astore 42
    //   3051: aload 37
    //   3053: astore 57
    //   3055: aload 36
    //   3057: astore 47
    //   3059: aload_1
    //   3060: astore 52
    //   3062: iload_3
    //   3063: istore 17
    //   3065: iload_2
    //   3066: istore 10
    //   3068: aload 38
    //   3070: astore 43
    //   3072: aload 37
    //   3074: astore 58
    //   3076: aload 36
    //   3078: astore 48
    //   3080: aload_1
    //   3081: astore 53
    //   3083: iload_3
    //   3084: istore 18
    //   3086: iload_2
    //   3087: istore 11
    //   3089: aload 38
    //   3091: astore 44
    //   3093: aload 37
    //   3095: astore 59
    //   3097: aload 36
    //   3099: astore 49
    //   3101: aload_1
    //   3102: astore 54
    //   3104: iload_3
    //   3105: istore 12
    //   3107: iload_2
    //   3108: istore 19
    //   3110: aload 37
    //   3112: astore 60
    //   3114: aload 74
    //   3116: invokestatic 604	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   3119: invokevirtual 607	java/lang/Integer:intValue	()I
    //   3122: istore 4
    //   3124: iload 4
    //   3126: istore 7
    //   3128: iload 7
    //   3130: istore 13
    //   3132: iload_3
    //   3133: istore 5
    //   3135: iload_2
    //   3136: istore 4
    //   3138: iload 20
    //   3140: istore 6
    //   3142: iload_2
    //   3143: iflt +111 -> 3254
    //   3146: iload 7
    //   3148: istore 13
    //   3150: iload_3
    //   3151: istore 5
    //   3153: iload_2
    //   3154: istore 4
    //   3156: iload 20
    //   3158: istore 6
    //   3160: iload_2
    //   3161: iconst_1
    //   3162: if_icmpgt +92 -> 3254
    //   3165: iload 7
    //   3167: istore 13
    //   3169: iload_3
    //   3170: istore 5
    //   3172: iload_2
    //   3173: istore 4
    //   3175: iload 20
    //   3177: istore 6
    //   3179: iload_3
    //   3180: iflt +74 -> 3254
    //   3183: iload 7
    //   3185: istore 13
    //   3187: iload_3
    //   3188: istore 5
    //   3190: iload_2
    //   3191: istore 4
    //   3193: iload 20
    //   3195: istore 6
    //   3197: iload_3
    //   3198: iconst_1
    //   3199: if_icmpgt +55 -> 3254
    //   3202: iload 7
    //   3204: istore 13
    //   3206: iload_3
    //   3207: istore 5
    //   3209: iload_2
    //   3210: istore 4
    //   3212: iload 20
    //   3214: istore 6
    //   3216: iload 7
    //   3218: iflt +36 -> 3254
    //   3221: iload 7
    //   3223: istore 13
    //   3225: iload_3
    //   3226: istore 5
    //   3228: iload_2
    //   3229: istore 4
    //   3231: iload 20
    //   3233: istore 6
    //   3235: iload 7
    //   3237: iconst_1
    //   3238: if_icmpgt +16 -> 3254
    //   3241: iconst_1
    //   3242: istore 6
    //   3244: iload_2
    //   3245: istore 4
    //   3247: iload_3
    //   3248: istore 5
    //   3250: iload 7
    //   3252: istore 13
    //   3254: aload 37
    //   3256: astore 39
    //   3258: aload_1
    //   3259: astore 37
    //   3261: iload 6
    //   3263: istore_2
    //   3264: aload 36
    //   3266: astore_1
    //   3267: iload 5
    //   3269: istore_3
    //   3270: iload 4
    //   3272: istore 6
    //   3274: iload 13
    //   3276: istore 5
    //   3278: aload 39
    //   3280: astore 36
    //   3282: iload_3
    //   3283: istore 4
    //   3285: iload 6
    //   3287: istore_3
    //   3288: iload_2
    //   3289: ifeq +97 -> 3386
    //   3292: invokestatic 5545	xva:a	()Lxva;
    //   3295: aload 71
    //   3297: invokevirtual 5546	xva:k	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3300: astore 39
    //   3302: invokestatic 5545	xva:a	()Lxva;
    //   3305: aload 71
    //   3307: invokevirtual 5547	xva:m	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   3310: astore 40
    //   3312: iconst_0
    //   3313: istore 35
    //   3315: aload 39
    //   3317: aload_1
    //   3318: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3321: ifeq +13 -> 3334
    //   3324: aload 40
    //   3326: aload 38
    //   3328: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3331: ifne +6 -> 3337
    //   3334: iconst_1
    //   3335: istore 35
    //   3337: invokestatic 5545	xva:a	()Lxva;
    //   3340: iload_3
    //   3341: iload 4
    //   3343: aload_1
    //   3344: aload 36
    //   3346: aload 38
    //   3348: aload 37
    //   3350: iload 35
    //   3352: iload 5
    //   3354: invokevirtual 5549	xva:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3357: aload 71
    //   3359: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3362: aload 71
    //   3364: invokevirtual 157	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3367: iload 34
    //   3369: iload_3
    //   3370: iload 4
    //   3372: aload_1
    //   3373: aload 38
    //   3375: aload 36
    //   3377: aload 37
    //   3379: iload 35
    //   3381: iload 5
    //   3383: invokestatic 5551	aqmj:a	(Landroid/content/Context;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3386: return
    //   3387: astore 39
    //   3389: ldc 18
    //   3391: astore 36
    //   3393: aconst_null
    //   3394: astore 37
    //   3396: iconst_0
    //   3397: istore_3
    //   3398: aconst_null
    //   3399: astore_1
    //   3400: aconst_null
    //   3401: astore 38
    //   3403: iconst_0
    //   3404: istore_2
    //   3405: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3408: ifeq +16 -> 3424
    //   3411: ldc_w 5526
    //   3414: iconst_2
    //   3415: aload 39
    //   3417: iconst_0
    //   3418: anewarray 178	java/lang/Object
    //   3421: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3424: iconst_0
    //   3425: istore 5
    //   3427: iconst_0
    //   3428: istore 6
    //   3430: aload 38
    //   3432: astore 39
    //   3434: aload_1
    //   3435: astore 38
    //   3437: iload_2
    //   3438: istore 4
    //   3440: iload 6
    //   3442: istore_2
    //   3443: aload 39
    //   3445: astore_1
    //   3446: goto -158 -> 3288
    //   3449: astore_1
    //   3450: iload 14
    //   3452: istore 4
    //   3454: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3457: ifeq +15 -> 3472
    //   3460: ldc_w 5526
    //   3463: iconst_2
    //   3464: aload_1
    //   3465: iconst_0
    //   3466: anewarray 178	java/lang/Object
    //   3469: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3472: iload 7
    //   3474: istore_3
    //   3475: aload 55
    //   3477: astore 36
    //   3479: aload 50
    //   3481: astore 37
    //   3483: iconst_0
    //   3484: istore 5
    //   3486: iconst_0
    //   3487: istore_2
    //   3488: aload 45
    //   3490: astore_1
    //   3491: aload 40
    //   3493: astore 38
    //   3495: goto -207 -> 3288
    //   3498: astore_1
    //   3499: iload 15
    //   3501: istore 4
    //   3503: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3506: ifeq +15 -> 3521
    //   3509: ldc_w 5526
    //   3512: iconst_2
    //   3513: aload_1
    //   3514: iconst_0
    //   3515: anewarray 178	java/lang/Object
    //   3518: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3521: iload 8
    //   3523: istore_3
    //   3524: aload 56
    //   3526: astore 36
    //   3528: aload 51
    //   3530: astore 37
    //   3532: iconst_0
    //   3533: istore 5
    //   3535: iconst_0
    //   3536: istore_2
    //   3537: aload 46
    //   3539: astore_1
    //   3540: aload 41
    //   3542: astore 38
    //   3544: goto -256 -> 3288
    //   3547: astore_1
    //   3548: iload 16
    //   3550: istore 4
    //   3552: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3555: ifeq +15 -> 3570
    //   3558: ldc_w 5526
    //   3561: iconst_2
    //   3562: aload_1
    //   3563: iconst_0
    //   3564: anewarray 178	java/lang/Object
    //   3567: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3570: iload 9
    //   3572: istore_3
    //   3573: aload 57
    //   3575: astore 36
    //   3577: aload 52
    //   3579: astore 37
    //   3581: iconst_0
    //   3582: istore 5
    //   3584: iconst_0
    //   3585: istore_2
    //   3586: aload 47
    //   3588: astore_1
    //   3589: aload 42
    //   3591: astore 38
    //   3593: goto -305 -> 3288
    //   3596: astore_1
    //   3597: iload 17
    //   3599: istore 4
    //   3601: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3604: ifeq +15 -> 3619
    //   3607: ldc_w 5526
    //   3610: iconst_2
    //   3611: aload_1
    //   3612: iconst_0
    //   3613: anewarray 178	java/lang/Object
    //   3616: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3619: iload 10
    //   3621: istore_3
    //   3622: aload 58
    //   3624: astore 36
    //   3626: aload 53
    //   3628: astore 37
    //   3630: iconst_0
    //   3631: istore 5
    //   3633: iconst_0
    //   3634: istore_2
    //   3635: aload 48
    //   3637: astore_1
    //   3638: aload 43
    //   3640: astore 38
    //   3642: goto -354 -> 3288
    //   3645: astore_1
    //   3646: iload 18
    //   3648: istore 4
    //   3650: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3653: ifeq +15 -> 3668
    //   3656: ldc_w 5526
    //   3659: iconst_2
    //   3660: aload_1
    //   3661: iconst_0
    //   3662: anewarray 178	java/lang/Object
    //   3665: invokestatic 904	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3668: iload 11
    //   3670: istore_3
    //   3671: aload 59
    //   3673: astore 36
    //   3675: aload 54
    //   3677: astore 37
    //   3679: iconst_0
    //   3680: istore 5
    //   3682: iconst_0
    //   3683: istore_2
    //   3684: aload 49
    //   3686: astore_1
    //   3687: aload 44
    //   3689: astore 38
    //   3691: goto -403 -> 3288
    //   3694: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3697: ifeq -311 -> 3386
    //   3700: ldc 169
    //   3702: iconst_2
    //   3703: new 68	java/lang/StringBuilder
    //   3706: dup
    //   3707: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3710: ldc_w 5553
    //   3713: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3716: aload_1
    //   3717: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3720: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3723: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3726: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3729: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3732: return
    //   3733: astore 39
    //   3735: ldc 18
    //   3737: astore 36
    //   3739: aload_1
    //   3740: astore 37
    //   3742: iconst_0
    //   3743: istore_3
    //   3744: aconst_null
    //   3745: astore_1
    //   3746: aconst_null
    //   3747: astore 38
    //   3749: iconst_0
    //   3750: istore_2
    //   3751: goto -346 -> 3405
    //   3754: astore 39
    //   3756: ldc 18
    //   3758: astore 40
    //   3760: aload_1
    //   3761: astore 37
    //   3763: iconst_0
    //   3764: istore_3
    //   3765: aconst_null
    //   3766: astore_1
    //   3767: aload 36
    //   3769: astore 38
    //   3771: iconst_0
    //   3772: istore_2
    //   3773: aload 40
    //   3775: astore 36
    //   3777: goto -372 -> 3405
    //   3780: astore 39
    //   3782: aload_1
    //   3783: astore 37
    //   3785: iload 19
    //   3787: istore_3
    //   3788: aload 38
    //   3790: astore_1
    //   3791: aload 36
    //   3793: astore 38
    //   3795: iload 12
    //   3797: istore_2
    //   3798: aload 60
    //   3800: astore 36
    //   3802: goto -397 -> 3405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3805	0	this	aevk
    //   0	3805	1	paramConfig	ConfigurationService.Config
    //   31	3767	2	i	int
    //   45	3743	3	j	int
    //   49	3600	4	k	int
    //   1848	1833	5	m	int
    //   1855	1586	6	n	int
    //   264	3209	7	i1	int
    //   287	3235	8	i2	int
    //   311	3260	9	i3	int
    //   335	3285	10	i4	int
    //   359	3310	11	i5	int
    //   1386	2410	12	i6	int
    //   1844	1431	13	i7	int
    //   260	3191	14	i8	int
    //   283	3217	15	i9	int
    //   307	3242	16	i10	int
    //   331	3267	17	i11	int
    //   355	3292	18	i12	int
    //   1390	2396	19	i13	int
    //   166	3066	20	i14	int
    //   191	2701	21	i15	int
    //   194	2720	22	i16	int
    //   197	2739	23	i17	int
    //   200	2758	24	i18	int
    //   203	2777	25	i19	int
    //   206	2385	26	i20	int
    //   209	2378	27	i21	int
    //   169	2570	28	i22	int
    //   172	2590	29	i23	int
    //   175	2610	30	i24	int
    //   178	2630	31	i25	int
    //   181	2650	32	i26	int
    //   184	2670	33	i27	int
    //   16	3352	34	i28	int
    //   3313	67	35	bool	boolean
    //   238	3563	36	localObject1	Object
    //   257	3527	37	localObject2	Object
    //   245	3549	38	localObject3	Object
    //   242	3074	39	localObject4	Object
    //   3387	29	39	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   3432	12	39	localObject5	Object
    //   3733	1	39	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   3754	1	39	localParserConfigurationException3	javax.xml.parsers.ParserConfigurationException
    //   3780	1	39	localParserConfigurationException4	javax.xml.parsers.ParserConfigurationException
    //   268	3506	40	localObject6	Object
    //   291	3250	41	localObject7	Object
    //   315	3275	42	localObject8	Object
    //   339	3300	43	localObject9	Object
    //   363	3325	44	localObject10	Object
    //   276	3213	45	localObject11	Object
    //   299	3239	46	localObject12	Object
    //   323	3264	47	localObject13	Object
    //   347	3289	48	localObject14	Object
    //   371	3314	49	localObject15	Object
    //   279	3201	50	localConfig	ConfigurationService.Config
    //   303	3226	51	localObject16	Object
    //   327	3251	52	localObject17	Object
    //   351	3276	53	localObject18	Object
    //   375	3301	54	localObject19	Object
    //   272	3204	55	localObject20	Object
    //   295	3230	56	localObject21	Object
    //   319	3255	57	localObject22	Object
    //   343	3280	58	localObject23	Object
    //   367	3305	59	localObject24	Object
    //   248	3551	60	localObject25	Object
    //   251	1583	61	localObject26	Object
    //   254	974	62	localObject27	Object
    //   226	799	63	localObject28	Object
    //   229	819	64	localObject29	Object
    //   232	839	65	localObject30	Object
    //   235	859	66	localObject31	Object
    //   212	672	67	localObject32	Object
    //   215	693	68	localObject33	Object
    //   218	714	69	localObject34	Object
    //   221	735	70	localObject35	Object
    //   7	3356	71	localQQAppInterface	QQAppInterface
    //   140	2722	72	str1	String
    //   693	2298	73	str2	String
    //   839	2276	74	str3	String
    //   401	996	75	localDocument	Document
    // Exception table:
    //   from	to	target	type
    //   377	403	3387	javax/xml/parsers/ParserConfigurationException
    //   521	549	3387	javax/xml/parsers/ParserConfigurationException
    //   667	695	3387	javax/xml/parsers/ParserConfigurationException
    //   813	841	3387	javax/xml/parsers/ParserConfigurationException
    //   959	986	3387	javax/xml/parsers/ParserConfigurationException
    //   377	403	3449	java/lang/NumberFormatException
    //   521	549	3449	java/lang/NumberFormatException
    //   667	695	3449	java/lang/NumberFormatException
    //   813	841	3449	java/lang/NumberFormatException
    //   959	986	3449	java/lang/NumberFormatException
    //   1100	1128	3449	java/lang/NumberFormatException
    //   1242	1270	3449	java/lang/NumberFormatException
    //   1396	1408	3449	java/lang/NumberFormatException
    //   1547	1557	3449	java/lang/NumberFormatException
    //   1683	1698	3449	java/lang/NumberFormatException
    //   1833	1842	3449	java/lang/NumberFormatException
    //   1983	1991	3449	java/lang/NumberFormatException
    //   2132	2140	3449	java/lang/NumberFormatException
    //   2281	2289	3449	java/lang/NumberFormatException
    //   2430	2438	3449	java/lang/NumberFormatException
    //   2579	2586	3449	java/lang/NumberFormatException
    //   2727	2735	3449	java/lang/NumberFormatException
    //   2861	2870	3449	java/lang/NumberFormatException
    //   2990	2999	3449	java/lang/NumberFormatException
    //   3114	3124	3449	java/lang/NumberFormatException
    //   377	403	3498	java/io/UnsupportedEncodingException
    //   521	549	3498	java/io/UnsupportedEncodingException
    //   667	695	3498	java/io/UnsupportedEncodingException
    //   813	841	3498	java/io/UnsupportedEncodingException
    //   959	986	3498	java/io/UnsupportedEncodingException
    //   1100	1128	3498	java/io/UnsupportedEncodingException
    //   1242	1270	3498	java/io/UnsupportedEncodingException
    //   1396	1408	3498	java/io/UnsupportedEncodingException
    //   1547	1557	3498	java/io/UnsupportedEncodingException
    //   1683	1698	3498	java/io/UnsupportedEncodingException
    //   1833	1842	3498	java/io/UnsupportedEncodingException
    //   1983	1991	3498	java/io/UnsupportedEncodingException
    //   2132	2140	3498	java/io/UnsupportedEncodingException
    //   2281	2289	3498	java/io/UnsupportedEncodingException
    //   2430	2438	3498	java/io/UnsupportedEncodingException
    //   2579	2586	3498	java/io/UnsupportedEncodingException
    //   2727	2735	3498	java/io/UnsupportedEncodingException
    //   2861	2870	3498	java/io/UnsupportedEncodingException
    //   2990	2999	3498	java/io/UnsupportedEncodingException
    //   3114	3124	3498	java/io/UnsupportedEncodingException
    //   377	403	3547	java/io/IOException
    //   521	549	3547	java/io/IOException
    //   667	695	3547	java/io/IOException
    //   813	841	3547	java/io/IOException
    //   959	986	3547	java/io/IOException
    //   1100	1128	3547	java/io/IOException
    //   1242	1270	3547	java/io/IOException
    //   1396	1408	3547	java/io/IOException
    //   1547	1557	3547	java/io/IOException
    //   1683	1698	3547	java/io/IOException
    //   1833	1842	3547	java/io/IOException
    //   1983	1991	3547	java/io/IOException
    //   2132	2140	3547	java/io/IOException
    //   2281	2289	3547	java/io/IOException
    //   2430	2438	3547	java/io/IOException
    //   2579	2586	3547	java/io/IOException
    //   2727	2735	3547	java/io/IOException
    //   2861	2870	3547	java/io/IOException
    //   2990	2999	3547	java/io/IOException
    //   3114	3124	3547	java/io/IOException
    //   377	403	3596	org/xml/sax/SAXException
    //   521	549	3596	org/xml/sax/SAXException
    //   667	695	3596	org/xml/sax/SAXException
    //   813	841	3596	org/xml/sax/SAXException
    //   959	986	3596	org/xml/sax/SAXException
    //   1100	1128	3596	org/xml/sax/SAXException
    //   1242	1270	3596	org/xml/sax/SAXException
    //   1396	1408	3596	org/xml/sax/SAXException
    //   1547	1557	3596	org/xml/sax/SAXException
    //   1683	1698	3596	org/xml/sax/SAXException
    //   1833	1842	3596	org/xml/sax/SAXException
    //   1983	1991	3596	org/xml/sax/SAXException
    //   2132	2140	3596	org/xml/sax/SAXException
    //   2281	2289	3596	org/xml/sax/SAXException
    //   2430	2438	3596	org/xml/sax/SAXException
    //   2579	2586	3596	org/xml/sax/SAXException
    //   2727	2735	3596	org/xml/sax/SAXException
    //   2861	2870	3596	org/xml/sax/SAXException
    //   2990	2999	3596	org/xml/sax/SAXException
    //   3114	3124	3596	org/xml/sax/SAXException
    //   377	403	3645	java/lang/NullPointerException
    //   521	549	3645	java/lang/NullPointerException
    //   667	695	3645	java/lang/NullPointerException
    //   813	841	3645	java/lang/NullPointerException
    //   959	986	3645	java/lang/NullPointerException
    //   1100	1128	3645	java/lang/NullPointerException
    //   1242	1270	3645	java/lang/NullPointerException
    //   1396	1408	3645	java/lang/NullPointerException
    //   1547	1557	3645	java/lang/NullPointerException
    //   1683	1698	3645	java/lang/NullPointerException
    //   1833	1842	3645	java/lang/NullPointerException
    //   1983	1991	3645	java/lang/NullPointerException
    //   2132	2140	3645	java/lang/NullPointerException
    //   2281	2289	3645	java/lang/NullPointerException
    //   2430	2438	3645	java/lang/NullPointerException
    //   2579	2586	3645	java/lang/NullPointerException
    //   2727	2735	3645	java/lang/NullPointerException
    //   2861	2870	3645	java/lang/NullPointerException
    //   2990	2999	3645	java/lang/NullPointerException
    //   3114	3124	3645	java/lang/NullPointerException
    //   1100	1128	3733	javax/xml/parsers/ParserConfigurationException
    //   1242	1270	3754	javax/xml/parsers/ParserConfigurationException
    //   1396	1408	3780	javax/xml/parsers/ParserConfigurationException
    //   1547	1557	3780	javax/xml/parsers/ParserConfigurationException
    //   1683	1698	3780	javax/xml/parsers/ParserConfigurationException
    //   1833	1842	3780	javax/xml/parsers/ParserConfigurationException
    //   1983	1991	3780	javax/xml/parsers/ParserConfigurationException
    //   2132	2140	3780	javax/xml/parsers/ParserConfigurationException
    //   2281	2289	3780	javax/xml/parsers/ParserConfigurationException
    //   2430	2438	3780	javax/xml/parsers/ParserConfigurationException
    //   2579	2586	3780	javax/xml/parsers/ParserConfigurationException
    //   2727	2735	3780	javax/xml/parsers/ParserConfigurationException
    //   2861	2870	3780	javax/xml/parsers/ParserConfigurationException
    //   2990	2999	3780	javax/xml/parsers/ParserConfigurationException
    //   3114	3124	3780	javax/xml/parsers/ParserConfigurationException
  }
  
  void D(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 147) {}
    for (;;)
    {
      return;
      int i = aqmj.i(paramQQAppInterface.getApp(), "shop_tab", mCurUin);
      int j = paramConfig.version.get();
      if ((i != j) && (paramConfig.content_list != null) && (paramConfig.content_list.size() > 0)) {
        try
        {
          paramConfig = new JSONObject((String)paramConfig.content_list.get(0));
          boolean bool = paramConfig.getBoolean("android");
          aqmj.g(paramQQAppInterface.getApp(), "shop_tab", mCurUin, j);
          paramQQAppInterface = (kdm)paramQQAppInterface.getManager(88);
          paramQQAppInterface.lM(bool);
          paramQQAppInterface.aeo = paramConfig.optBoolean("preload_web_process", false);
          paramQQAppInterface.rM = paramConfig.optLong("stay_time", 5000L);
          paramQQAppInterface.aIb = paramConfig.optInt("day_limit", 3);
          kdm.h().edit().putBoolean("preload_web", paramQQAppInterface.aeo).putLong("stayTime", paramQQAppInterface.rM).putInt("dayLimit", paramQQAppInterface.aIb).commit();
          if (QLog.isColorLevel())
          {
            QLog.i("Ecshop", 2, "current config set tab show:" + bool + ",preload:" + paramQQAppInterface.aeo + ",stayTime:" + paramQQAppInterface.rM + ",dayLimit:" + paramQQAppInterface.aIb);
            return;
          }
        }
        catch (Exception paramQQAppInterface) {}
      }
    }
  }
  
  protected void F(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig type = " + paramConfig.type.get());
    }
    int i = aqmj.aH(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig version code not changed .");
      }
      return;
    }
    aqmj.ac(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), j);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      aqmj.U(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
      return;
    }
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    byte[] arrayOfByte;
    if (paramConfig.compress.get() == 1)
    {
      arrayOfByte = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (arrayOfByte == null) {}
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(arrayOfByte, "UTF-8");
        if (TextUtils.isEmpty(paramConfig)) {
          break label367;
        }
        aqmj.U(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), paramConfig);
        ((pmb)paramQQAppInterface.getManager(181)).qQ(paramConfig);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "handleQuickShotShareToStoryConfig() configContent = " + paramConfig);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
        }
        paramConfig = null;
        continue;
      }
      catch (OutOfMemoryError paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
        }
        System.gc();
        try
        {
          paramConfig = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("SPLASH_ConfigServlet", 2, QLog.getStackTraceString(paramConfig));
          }
        }
      }
      paramConfig = null;
      continue;
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label367:
      aqmj.U(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), null);
    }
  }
  
  void G(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = aqmj.aM(paramQQAppInterface.getApp(), mCurUin);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label219;
        }
        paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label239;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {}
      }
      catch (Exception paramConfig)
      {
        try
        {
          paramConfig = new JSONObject(paramConfig);
          boolean bool1 = paramConfig.getBoolean("wifiAutoPreDown");
          boolean bool2 = paramConfig.getBoolean("noSafeDown");
          aqmj.Z(paramQQAppInterface.getApp(), "wifiAutoPreDown", "" + bool1);
          aqmj.Z(paramQQAppInterface.getApp(), "noSafeDown", "" + bool2);
          aqmj.ah(paramQQAppInterface.getApp(), mCurUin, j);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
        paramConfig = paramConfig;
        QLog.d("SPLASH_ConfigServlet", 2, "handleQQPreDownYYBConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      label219:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label239:
      paramConfig = null;
    }
  }
  
  void H(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = aqmj.aJ(paramQQAppInterface.getApp(), mCurUin);
    int j = paramConfig.version.get();
    if ((i != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label206;
        }
        paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label226;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {}
      }
      catch (Exception paramConfig)
      {
        try
        {
          Object localObject = new JSONObject(paramConfig);
          paramConfig = ((JSONObject)localObject).getString("url");
          String str = ((JSONObject)localObject).getString("wantWord");
          localObject = ((JSONObject)localObject).getString("thxWord");
          aqmj.X(paramQQAppInterface.getApp(), "url", paramConfig);
          aqmj.X(paramQQAppInterface.getApp(), "thxWord", (String)localObject);
          aqmj.X(paramQQAppInterface.getApp(), "wantWord", str);
          aqmj.ag(paramQQAppInterface.getApp(), mCurUin, j);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
        paramConfig = paramConfig;
        QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      label206:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label226:
      paramConfig = null;
    }
  }
  
  void I(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 165) {}
    int j;
    do
    {
      int i;
      do
      {
        return;
        i = aqmj.aN(paramQQAppInterface.getApp(), mCurUin);
        j = paramConfig.version.get();
      } while ((i == j) || (paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label194;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break;
        }
        try
        {
          boolean bool = new JSONObject(paramConfig).getBoolean("isShowBuluoNumRedDot");
          aqmj.ai(paramQQAppInterface.getApp(), mCurUin, j);
          aqmj.n(paramQQAppInterface.getApp(), mCurUin, bool);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
      catch (Exception paramConfig)
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoConfig|uncompress failed");
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label194:
      paramConfig = null;
    }
  }
  
  void J(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG response");
    }
    for (;;)
    {
      int i;
      try
      {
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
        {
          int j = paramConfig.version.get();
          int k = obt.j(paramQQAppInterface);
          if (j != k)
          {
            i = 0;
            if (i < paramConfig.msg_content_list.size())
            {
              Object localObject = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
              if (localObject != null)
              {
                if (((ConfigurationService.Content)localObject).compress.get() == 1)
                {
                  localObject = akrf.inflateConfigString(((ConfigurationService.Content)localObject).content.get().toByteArray());
                  if (localObject == null) {
                    break label310;
                  }
                  try
                  {
                    localObject = new String((byte[])localObject, "UTF-8");
                    if (QLog.isColorLevel()) {
                      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 184, version:" + paramConfig.version.get() + ", content:" + (String)localObject);
                    }
                    obt.h(paramQQAppInterface, (String)localObject, j);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                    break label310;
                  }
                }
                else
                {
                  str = localException.content.get().toStringUtf8();
                  continue;
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG remote version: " + j + " | localVersion: " + k);
              }
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG error", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "received PUBLIC_ACCOUNT_QQ_MAIL_CONFIG content_list is empty");
      return;
      i += 1;
      continue;
      label310:
      String str = null;
    }
  }
  
  /* Error */
  void K(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 81	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 191
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   21: invokestatic 2226	aqmj:aZ	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: iload 4
    //   36: iload_3
    //   37: if_icmpeq -24 -> 13
    //   40: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +30 -> 73
    //   46: ldc 169
    //   48: iconst_2
    //   49: new 68	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 5659
    //   59: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload 4
    //   64: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_2
    //   74: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   77: ifnull -64 -> 13
    //   80: aload_2
    //   81: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   87: ifle -74 -> 13
    //   90: aload_2
    //   91: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   94: iconst_0
    //   95: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull -90 -> 13
    //   106: aload_2
    //   107: getfield 334	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: iconst_1
    //   114: if_icmpne +349 -> 463
    //   117: aload_2
    //   118: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   127: invokestatic 357	akrf:inflateConfigString	([B)[B
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +442 -> 574
    //   135: new 115	java/lang/String
    //   138: dup
    //   139: aload_2
    //   140: ldc_w 359
    //   143: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   146: astore_2
    //   147: aload_2
    //   148: ifnull -135 -> 13
    //   151: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +29 -> 183
    //   157: ldc 169
    //   159: iconst_2
    //   160: new 68	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 5661
    //   170: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_2
    //   174: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: new 119	org/json/JSONObject
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: astore 5
    //   193: aload 5
    //   195: ifnull -182 -> 13
    //   198: aload 5
    //   200: invokevirtual 5662	org/json/JSONObject:length	()I
    //   203: ifle -190 -> 13
    //   206: new 1352	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 1353	java/util/ArrayList:<init>	()V
    //   213: astore_2
    //   214: aload 5
    //   216: invokevirtual 5665	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   219: astore 6
    //   221: aload 6
    //   223: invokeinterface 402 1 0
    //   228: ifeq +310 -> 538
    //   231: aload 6
    //   233: invokeinterface 406 1 0
    //   238: checkcast 115	java/lang/String
    //   241: astore 7
    //   243: aload 5
    //   245: aload 7
    //   247: invokevirtual 4619	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   250: astore 8
    //   252: new 5667	com/tencent/mobileqq/data/AppGuideTipsConfig
    //   255: dup
    //   256: invokespecial 5668	com/tencent/mobileqq/data/AppGuideTipsConfig:<init>	()V
    //   259: astore 9
    //   261: aload 9
    //   263: aload 7
    //   265: putfield 5671	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsType	Ljava/lang/String;
    //   268: aload 9
    //   270: aload 8
    //   272: ldc_w 5673
    //   275: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 5676	com/tencent/mobileqq/data/AppGuideTipsConfig:switchKey	Ljava/lang/String;
    //   281: aload 9
    //   283: aload 8
    //   285: ldc_w 5678
    //   288: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 604	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   294: invokevirtual 607	java/lang/Integer:intValue	()I
    //   297: putfield 5681	com/tencent/mobileqq/data/AppGuideTipsConfig:maxCount	I
    //   300: aload 9
    //   302: aload 8
    //   304: ldc_w 5683
    //   307: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 594	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   313: invokevirtual 597	java/lang/Long:longValue	()J
    //   316: putfield 5685	com/tencent/mobileqq/data/AppGuideTipsConfig:duration	J
    //   319: aload 9
    //   321: aload 8
    //   323: ldc_w 1304
    //   326: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: putfield 5688	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsUrl	Ljava/lang/String;
    //   332: aload 9
    //   334: aload 8
    //   336: ldc_w 5690
    //   339: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: putfield 5692	com/tencent/mobileqq/data/AppGuideTipsConfig:opkey	Ljava/lang/String;
    //   345: aload 9
    //   347: aload 8
    //   349: ldc_w 5694
    //   352: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: putfield 5697	com/tencent/mobileqq/data/AppGuideTipsConfig:msgTypeStr	Ljava/lang/String;
    //   358: ldc_w 4439
    //   361: aload 7
    //   363: invokevirtual 271	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   366: ifeq +143 -> 509
    //   369: aload 8
    //   371: ldc_w 1280
    //   374: invokevirtual 232	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   377: ifeq +100 -> 477
    //   380: aload 9
    //   382: aload 8
    //   384: ldc_w 1280
    //   387: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   390: putfield 5700	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   393: aload 8
    //   395: ldc_w 4369
    //   398: invokevirtual 232	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +92 -> 493
    //   404: aload 9
    //   406: aload 8
    //   408: ldc_w 4369
    //   411: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: putfield 5703	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   417: aload_2
    //   418: aload 9
    //   420: invokeinterface 1363 2 0
    //   425: pop
    //   426: goto -205 -> 221
    //   429: astore_1
    //   430: ldc 169
    //   432: iconst_1
    //   433: new 68	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 5705
    //   443: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_1
    //   447: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: return
    //   457: astore_2
    //   458: aconst_null
    //   459: astore_2
    //   460: goto -313 -> 147
    //   463: aload_2
    //   464: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   467: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   470: invokevirtual 370	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   473: astore_2
    //   474: goto -327 -> 147
    //   477: aload 9
    //   479: aload 8
    //   481: ldc_w 5707
    //   484: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield 5700	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   490: goto -97 -> 393
    //   493: aload 9
    //   495: aload 8
    //   497: ldc_w 5709
    //   500: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   503: putfield 5703	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   506: goto -89 -> 417
    //   509: aload 9
    //   511: aload 8
    //   513: ldc_w 5707
    //   516: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   519: putfield 5700	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsMsg	Ljava/lang/String;
    //   522: aload 9
    //   524: aload 8
    //   526: ldc_w 5709
    //   529: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   532: putfield 5703	com/tencent/mobileqq/data/AppGuideTipsConfig:tipsHighLight	Ljava/lang/String;
    //   535: goto -118 -> 417
    //   538: aload_1
    //   539: sipush 218
    //   542: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   545: checkcast 3665	wjw
    //   548: astore 5
    //   550: aload 5
    //   552: aload_2
    //   553: invokevirtual 5712	wjw:ge	(Ljava/util/List;)V
    //   556: aload 5
    //   558: invokevirtual 3668	wjw:loadConfig	()V
    //   561: aload_1
    //   562: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   565: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   568: iload 4
    //   570: invokestatic 5714	aqmj:as	(Landroid/content/Context;Ljava/lang/String;I)V
    //   573: return
    //   574: aconst_null
    //   575: astore_2
    //   576: goto -429 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	aevk
    //   0	579	1	paramQQAppInterface	QQAppInterface
    //   0	579	2	paramConfig	ConfigurationService.Config
    //   24	14	3	i	int
    //   32	537	4	j	int
    //   191	366	5	localObject	Object
    //   219	13	6	localIterator	Iterator
    //   241	121	7	str	String
    //   250	275	8	localJSONObject	JSONObject
    //   259	264	9	localAppGuideTipsConfig	AppGuideTipsConfig
    // Exception table:
    //   from	to	target	type
    //   183	193	429	java/lang/Exception
    //   198	221	429	java/lang/Exception
    //   221	393	429	java/lang/Exception
    //   393	417	429	java/lang/Exception
    //   417	426	429	java/lang/Exception
    //   477	490	429	java/lang/Exception
    //   493	506	429	java/lang/Exception
    //   509	535	429	java/lang/Exception
    //   538	573	429	java/lang/Exception
    //   135	147	457	java/lang/Exception
  }
  
  void L(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 194) {
      return;
    }
    int i = aqmj.aL(paramQQAppInterface.getApp(), mCurUin);
    int j = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig reqVersion=" + i + "version=" + j);
    }
    if (i != j)
    {
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label399;
      }
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() != 1) {
          break label355;
        }
        paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {
          break label428;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Pobing", 1, "handleTroopPobingConfig content" + paramConfig);
          }
          if (paramConfig == null) {}
        }
        try
        {
          Object localObject = new JSONObject(paramConfig);
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("left");
          localObject = ((JSONObject)localObject).getJSONArray("right");
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig content" + paramConfig + " left: " + localJSONArray);
            QLog.d("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig content" + paramConfig + " right: " + localObject);
          }
          TroopManager.a(paramQQAppInterface, mCurUin, localJSONArray, (JSONArray)localObject);
        }
        catch (Exception paramConfig)
        {
          QLog.e("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig failed" + paramConfig);
          continue;
        }
        aqmj.af(paramQQAppInterface.getApp(), mCurUin, j);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PobingSPLASH_ConfigServlet", 2, "handleTroopPobingConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      label355:
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label399:
      paramConfig = new JSONArray();
      TroopManager.a(paramQQAppInterface, mCurUin, paramConfig, paramConfig);
      QLog.i("SPLASH_ConfigServlet", 1, "handleTroopPobingConfig, empty config clear local");
      continue;
      label428:
      paramConfig = null;
    }
  }
  
  void M(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 181) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          i = aqmj.aR(paramQQAppInterface.getApp(), mCurUin);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        aqmj.an(paramQQAppInterface.getApp(), mCurUin, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label1415;
      }
    }
    for (;;)
    {
      label318:
      label455:
      int k;
      label518:
      label577:
      String str1;
      label637:
      int m;
      try
      {
        for (;;)
        {
          paramConfig = new String(paramConfig, "UTF-8");
          if (paramConfig == null) {
            break label1254;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Doutu", 1, "handleDoutuConfig content" + paramConfig);
          }
          try
          {
            Object localObject = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramConfig.getBytes("utf-8")));
            paramConfig = ((Document)localObject).getElementsByTagName("doutu_config");
            if ((paramConfig == null) || (paramConfig.getLength() <= 0)) {
              break;
            }
            if ((((Document)localObject).getElementsByTagName("entry") == null) || (((Document)localObject).getElementsByTagName("entry").item(0) == null)) {
              break label1410;
            }
            i = Integer.parseInt(((Document)localObject).getElementsByTagName("entry").item(0).getFirstChild().getNodeValue());
            l2 = 0L;
            l1 = l2;
            if (((Document)localObject).getElementsByTagName("timeGap") != null)
            {
              l1 = l2;
              if (((Document)localObject).getElementsByTagName("timeGap").item(0) != null) {
                l1 = Long.parseLong(((Document)localObject).getElementsByTagName("timeGap").item(0).getFirstChild().getNodeValue());
              }
            }
            if ((((Document)localObject).getElementsByTagName("duiTimes") == null) || (((Document)localObject).getElementsByTagName("duiTimes").item(0) == null)) {
              break label1404;
            }
            j = Integer.parseInt(((Document)localObject).getElementsByTagName("duiTimes").item(0).getFirstChild().getNodeValue());
            if ((((Document)localObject).getElementsByTagName("entryCombo") == null) || (((Document)localObject).getElementsByTagName("entryCombo").item(0) == null)) {
              break label1398;
            }
            k = Integer.parseInt(((Document)localObject).getElementsByTagName("entryCombo").item(0).getFirstChild().getNodeValue());
            if ((((Document)localObject).getElementsByTagName("resUrl") == null) || (((Document)localObject).getElementsByTagName("resUrl").item(0) == null)) {
              break label1393;
            }
            paramConfig = ((Document)localObject).getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue();
            if ((((Document)localObject).getElementsByTagName("resMd5") == null) || (((Document)localObject).getElementsByTagName("resMd5").item(0) == null)) {
              break label1387;
            }
            str1 = ((Document)localObject).getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue();
            l3 = 0L;
            l2 = l3;
            if (((Document)localObject).getElementsByTagName("comboDuration") != null)
            {
              l2 = l3;
              if (((Document)localObject).getElementsByTagName("comboDuration").item(0) != null) {
                l2 = Long.parseLong(((Document)localObject).getElementsByTagName("comboDuration").item(0).getFirstChild().getNodeValue());
              }
            }
            long l4 = 0L;
            l3 = l4;
            if (((Document)localObject).getElementsByTagName("comboKeep") != null)
            {
              l3 = l4;
              if (((Document)localObject).getElementsByTagName("comboKeep").item(0) != null) {
                l3 = Long.parseLong(((Document)localObject).getElementsByTagName("comboKeep").item(0).getFirstChild().getNodeValue());
              }
            }
            if ((((Document)localObject).getElementsByTagName("recommendSwitch") == null) || (((Document)localObject).getElementsByTagName("recommendSwitch").item(0) == null)) {
              break label1381;
            }
            m = Integer.parseInt(((Document)localObject).getElementsByTagName("recommendSwitch").item(0).getFirstChild().getNodeValue());
            label848:
            int i1 = 0;
            n = i1;
            if (((Document)localObject).getElementsByTagName("smartHeadPicCount") != null)
            {
              n = i1;
              if (((Document)localObject).getElementsByTagName("smartHeadPicCount").item(0) != null) {
                n = Integer.parseInt(((Document)localObject).getElementsByTagName("smartHeadPicCount").item(0).getFirstChild().getNodeValue());
              }
            }
            localObject = paramQQAppInterface.getApp();
            String str2 = mCurUin;
            if (i != 1) {
              break label1218;
            }
            bool1 = true;
            aqmj.p((Context)localObject, str2, bool1);
            aqmj.q(paramQQAppInterface.getApp(), mCurUin, l1);
            aqmj.ar(paramQQAppInterface.getApp(), mCurUin, j);
            localObject = paramQQAppInterface.getApp();
            str2 = mCurUin;
            if (k != 1) {
              break label1224;
            }
            bool1 = true;
            aqmj.q((Context)localObject, str2, bool1);
            localObject = paramQQAppInterface.getApp();
            str2 = mCurUin;
            if (m != 1) {
              break label1230;
            }
            bool1 = true;
            aqmj.r((Context)localObject, str2, bool1);
            if (paramConfig != null) {
              aqmj.ac(paramQQAppInterface.getApp(), mCurUin, paramConfig);
            }
            if (str1 != null) {
              aqmj.ad(paramQQAppInterface.getApp(), mCurUin, str1);
            }
            aqmj.r(paramQQAppInterface.getApp(), mCurUin, l2);
            aqmj.s(paramQQAppInterface.getApp(), mCurUin, l3);
            aqmj.ap(paramQQAppInterface.getApp(), mCurUin, n);
            paramQQAppInterface = (afdw)getAppRuntime().getManager(214);
            if (paramQQAppInterface == null) {
              break;
            }
            if (i != 1) {
              break label1236;
            }
            bool1 = true;
          }
          catch (Exception paramQQAppInterface)
          {
            long l2;
            long l1;
            long l3;
            int n;
            label1129:
            QLog.e("HotPicManager", 1, "handleDoutuConfig failed" + paramQQAppInterface);
            return;
          }
        }
        paramQQAppInterface.a(bool1, bool2, l1, l2, l3, bool3, n);
        paramQQAppInterface.HI(true);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuSPLASH_ConfigServlet", 2, "handleDoutuConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label1218:
      boolean bool1 = false;
      continue;
      label1224:
      bool1 = false;
      continue;
      label1230:
      bool1 = false;
      continue;
      label1236:
      bool1 = false;
      label1242:
      for (boolean bool2 = false; m != 1; bool2 = true)
      {
        bool3 = false;
        break label1129;
        label1254:
        if (QLog.isColorLevel()) {
          QLog.d("Doutu", 1, "handleDoutuConfig content is null");
        }
        aqmj.cy(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cF(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cz(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cA(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cC(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cD(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cH(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cI(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cB(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cA(paramQQAppInterface.getApp(), mCurUin);
        aqmj.cG(paramQQAppInterface.getApp(), mCurUin);
        return;
        label1381:
        m = 0;
        break label848;
        label1387:
        str1 = null;
        break label637;
        label1393:
        paramConfig = null;
        break label577;
        label1398:
        k = 0;
        break label518;
        label1404:
        j = 0;
        break label455;
        i = 0;
        break label318;
        paramConfig = null;
        break;
        if (k != 1) {
          break label1242;
        }
      }
      label1410:
      label1415:
      boolean bool3 = true;
    }
  }
  
  void N(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig.type.get() != 247) {}
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          return;
          i = aqmj.ad(paramQQAppInterface.getApp(), mCurUin);
          j = paramConfig.version.get();
          if (QLog.isColorLevel()) {
            QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig reqVersion = " + i + ", version=" + j);
          }
        } while (i == j);
        aqmj.K(paramQQAppInterface.getApp(), mCurUin, j);
      } while ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0));
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramConfig == null);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (paramConfig == null) {
        break label276;
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (paramConfig == null) {
          break label252;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GreenVideo", 1, "handleGreenVideoConfig content : " + paramConfig);
        }
        aqmj.cs(paramQQAppInterface.getApp(), paramConfig);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GreenVideoSPLASH_ConfigServlet", 2, "handleGreenVideoConfig|uncompress failed");
        }
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      label252:
      if (QLog.isColorLevel()) {
        QLog.d("GreenVideo", 1, "handleGreenVideoConfig content is null");
      }
      aqmj.fA(paramQQAppInterface.getApp());
      return;
      label276:
      paramConfig = null;
    }
  }
  
  /* Error */
  void O(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 81	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:type	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7: sipush 272
    //   10: if_icmpeq +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   21: invokestatic 2193	aqmj:af	(Landroid/content/Context;Ljava/lang/String;)I
    //   24: istore_3
    //   25: aload_2
    //   26: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   29: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   32: istore 4
    //   34: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +40 -> 77
    //   40: ldc 169
    //   42: iconst_2
    //   43: new 68	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 5856
    //   53: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 5748
    //   63: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload 4
    //   68: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iload_3
    //   78: iload 4
    //   80: if_icmpeq -67 -> 13
    //   83: aload_1
    //   84: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   87: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   90: iload 4
    //   92: invokestatic 2181	aqmj:M	(Landroid/content/Context;Ljava/lang/String;I)V
    //   95: aload_2
    //   96: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   99: ifnull -86 -> 13
    //   102: aload_2
    //   103: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   109: ifle -96 -> 13
    //   112: aload_2
    //   113: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: iconst_0
    //   117: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   120: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull -112 -> 13
    //   128: aload_2
    //   129: getfield 334	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: iconst_1
    //   136: if_icmpne +716 -> 852
    //   139: aload_2
    //   140: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   149: invokestatic 357	akrf:inflateConfigString	([B)[B
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +782 -> 936
    //   157: new 115	java/lang/String
    //   160: dup
    //   161: aload_2
    //   162: ldc_w 359
    //   165: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +696 -> 866
    //   173: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +29 -> 205
    //   179: ldc 169
    //   181: iconst_2
    //   182: new 68	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 5858
    //   192: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: invokestatic 1168	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   208: invokevirtual 1172	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   211: new 1174	java/io/ByteArrayInputStream
    //   214: dup
    //   215: aload_2
    //   216: ldc_w 1176
    //   219: invokevirtual 1180	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: invokespecial 1181	java/io/ByteArrayInputStream:<init>	([B)V
    //   225: invokevirtual 1186	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 5860
    //   233: invokeinterface 1194 2 0
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull -229 -> 13
    //   245: aload 5
    //   247: invokeinterface 1199 1 0
    //   252: ifle -239 -> 13
    //   255: new 68	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   262: astore 5
    //   264: aload_2
    //   265: ldc_w 5862
    //   268: invokeinterface 1194 2 0
    //   273: ifnull +42 -> 315
    //   276: aload 5
    //   278: aload_2
    //   279: ldc_w 5862
    //   282: invokeinterface 1194 2 0
    //   287: iconst_0
    //   288: invokeinterface 1205 2 0
    //   293: invokeinterface 1211 1 0
    //   298: invokeinterface 1214 1 0
    //   303: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 5
    //   309: bipush 124
    //   311: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc_w 5864
    //   319: invokeinterface 1194 2 0
    //   324: ifnull +42 -> 366
    //   327: aload 5
    //   329: aload_2
    //   330: ldc_w 5864
    //   333: invokeinterface 1194 2 0
    //   338: iconst_0
    //   339: invokeinterface 1205 2 0
    //   344: invokeinterface 1211 1 0
    //   349: invokeinterface 1214 1 0
    //   354: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 5
    //   360: bipush 124
    //   362: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: ldc_w 5866
    //   370: invokeinterface 1194 2 0
    //   375: ifnull +42 -> 417
    //   378: aload 5
    //   380: aload_2
    //   381: ldc_w 5866
    //   384: invokeinterface 1194 2 0
    //   389: iconst_0
    //   390: invokeinterface 1205 2 0
    //   395: invokeinterface 1211 1 0
    //   400: invokeinterface 1214 1 0
    //   405: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 5
    //   411: bipush 124
    //   413: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc_w 5868
    //   421: invokeinterface 1194 2 0
    //   426: ifnull +42 -> 468
    //   429: aload 5
    //   431: aload_2
    //   432: ldc_w 5868
    //   435: invokeinterface 1194 2 0
    //   440: iconst_0
    //   441: invokeinterface 1205 2 0
    //   446: invokeinterface 1211 1 0
    //   451: invokeinterface 1214 1 0
    //   456: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 5
    //   462: bipush 124
    //   464: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_2
    //   469: ldc_w 5870
    //   472: invokeinterface 1194 2 0
    //   477: ifnull +42 -> 519
    //   480: aload 5
    //   482: aload_2
    //   483: ldc_w 5870
    //   486: invokeinterface 1194 2 0
    //   491: iconst_0
    //   492: invokeinterface 1205 2 0
    //   497: invokeinterface 1211 1 0
    //   502: invokeinterface 1214 1 0
    //   507: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 5
    //   513: bipush 124
    //   515: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_2
    //   520: ldc_w 5872
    //   523: invokeinterface 1194 2 0
    //   528: ifnull +60 -> 588
    //   531: aload_2
    //   532: ldc_w 5872
    //   535: invokeinterface 1194 2 0
    //   540: iconst_0
    //   541: invokeinterface 1205 2 0
    //   546: ifnull +42 -> 588
    //   549: aload 5
    //   551: aload_2
    //   552: ldc_w 5872
    //   555: invokeinterface 1194 2 0
    //   560: iconst_0
    //   561: invokeinterface 1205 2 0
    //   566: invokeinterface 1211 1 0
    //   571: invokeinterface 1214 1 0
    //   576: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload 5
    //   582: bipush 124
    //   584: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_2
    //   589: ldc_w 5874
    //   592: invokeinterface 1194 2 0
    //   597: ifnull +60 -> 657
    //   600: aload_2
    //   601: ldc_w 5874
    //   604: invokeinterface 1194 2 0
    //   609: iconst_0
    //   610: invokeinterface 1205 2 0
    //   615: ifnull +42 -> 657
    //   618: aload 5
    //   620: aload_2
    //   621: ldc_w 5874
    //   624: invokeinterface 1194 2 0
    //   629: iconst_0
    //   630: invokeinterface 1205 2 0
    //   635: invokeinterface 1211 1 0
    //   640: invokeinterface 1214 1 0
    //   645: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 5
    //   651: bipush 124
    //   653: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload_2
    //   658: ldc_w 5876
    //   661: invokeinterface 1194 2 0
    //   666: ifnull +60 -> 726
    //   669: aload_2
    //   670: ldc_w 5876
    //   673: invokeinterface 1194 2 0
    //   678: iconst_0
    //   679: invokeinterface 1205 2 0
    //   684: ifnull +42 -> 726
    //   687: aload 5
    //   689: aload_2
    //   690: ldc_w 5876
    //   693: invokeinterface 1194 2 0
    //   698: iconst_0
    //   699: invokeinterface 1205 2 0
    //   704: invokeinterface 1211 1 0
    //   709: invokeinterface 1214 1 0
    //   714: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 5
    //   720: bipush 124
    //   722: invokevirtual 933	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_2
    //   727: ldc_w 5878
    //   730: invokeinterface 1194 2 0
    //   735: ifnull +52 -> 787
    //   738: aload_2
    //   739: ldc_w 5878
    //   742: invokeinterface 1194 2 0
    //   747: iconst_0
    //   748: invokeinterface 1205 2 0
    //   753: ifnull +34 -> 787
    //   756: aload 5
    //   758: aload_2
    //   759: ldc_w 5878
    //   762: invokeinterface 1194 2 0
    //   767: iconst_0
    //   768: invokeinterface 1205 2 0
    //   773: invokeinterface 1211 1 0
    //   778: invokeinterface 1214 1 0
    //   783: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_1
    //   788: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   791: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   794: aload 5
    //   796: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 5880	aqmj:ae	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   802: return
    //   803: astore_1
    //   804: ldc 169
    //   806: iconst_1
    //   807: new 68	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   814: ldc_w 5882
    //   817: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_1
    //   821: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: return
    //   831: astore_2
    //   832: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq +12 -> 847
    //   838: ldc 169
    //   840: iconst_2
    //   841: ldc_w 5884
    //   844: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aconst_null
    //   848: astore_2
    //   849: goto -680 -> 169
    //   852: aload_2
    //   853: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   856: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   859: invokevirtual 370	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   862: astore_2
    //   863: goto -694 -> 169
    //   866: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   869: ifeq +12 -> 881
    //   872: ldc 169
    //   874: iconst_2
    //   875: ldc_w 5886
    //   878: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   885: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   888: invokestatic 5889	aqmj:cE	(Landroid/content/Context;Ljava/lang/String;)V
    //   891: return
    //   892: astore_2
    //   893: goto -106 -> 787
    //   896: astore 6
    //   898: goto -172 -> 726
    //   901: astore 6
    //   903: goto -246 -> 657
    //   906: astore 6
    //   908: goto -320 -> 588
    //   911: astore 6
    //   913: goto -394 -> 519
    //   916: astore 6
    //   918: goto -450 -> 468
    //   921: astore 6
    //   923: goto -506 -> 417
    //   926: astore 6
    //   928: goto -562 -> 366
    //   931: astore 6
    //   933: goto -618 -> 315
    //   936: aconst_null
    //   937: astore_2
    //   938: goto -769 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	941	0	this	aevk
    //   0	941	1	paramQQAppInterface	QQAppInterface
    //   0	941	2	paramConfig	ConfigurationService.Config
    //   24	57	3	i	int
    //   32	59	4	j	int
    //   238	557	5	localObject	Object
    //   896	1	6	localThrowable1	Throwable
    //   901	1	6	localThrowable2	Throwable
    //   906	1	6	localThrowable3	Throwable
    //   911	1	6	localThrowable4	Throwable
    //   916	1	6	localThrowable5	Throwable
    //   921	1	6	localThrowable6	Throwable
    //   926	1	6	localThrowable7	Throwable
    //   931	1	6	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   205	240	803	java/lang/Exception
    //   245	264	803	java/lang/Exception
    //   264	315	803	java/lang/Exception
    //   315	366	803	java/lang/Exception
    //   366	417	803	java/lang/Exception
    //   417	468	803	java/lang/Exception
    //   468	519	803	java/lang/Exception
    //   519	588	803	java/lang/Exception
    //   588	657	803	java/lang/Exception
    //   657	726	803	java/lang/Exception
    //   726	787	803	java/lang/Exception
    //   787	802	803	java/lang/Exception
    //   157	169	831	java/lang/Exception
    //   726	787	892	java/lang/Throwable
    //   657	726	896	java/lang/Throwable
    //   588	657	901	java/lang/Throwable
    //   519	588	906	java/lang/Throwable
    //   468	519	911	java/lang/Throwable
    //   417	468	916	java/lang/Throwable
    //   366	417	921	java/lang/Throwable
    //   315	366	926	java/lang/Throwable
    //   264	315	931	java/lang/Throwable
  }
  
  /* Error */
  void Q(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 2214	anvq:P	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   4: istore 4
    //   6: aload_2
    //   7: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   10: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   13: istore_3
    //   14: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +40 -> 57
    //   20: ldc 169
    //   22: iconst_2
    //   23: new 68	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 5891
    //   33: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 4
    //   38: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 5893
    //   44: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpeq +157 -> 217
    //   63: aload_1
    //   64: bipush 17
    //   66: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   69: checkcast 2212	anvq
    //   72: astore 5
    //   74: aload_2
    //   75: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   78: ifnull +216 -> 294
    //   81: aload_2
    //   82: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   85: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   88: ifle +206 -> 294
    //   91: aload_2
    //   92: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: iconst_0
    //   96: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   99: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +108 -> 212
    //   107: aload_2
    //   108: getfield 334	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: iconst_1
    //   115: if_icmpne +135 -> 250
    //   118: aload_2
    //   119: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   122: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   125: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   128: invokestatic 357	akrf:inflateConfigString	([B)[B
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +179 -> 312
    //   136: new 115	java/lang/String
    //   139: dup
    //   140: aload_2
    //   141: ldc_w 359
    //   144: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +63 -> 212
    //   152: new 119	org/json/JSONObject
    //   155: dup
    //   156: aload_2
    //   157: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   160: ldc_w 5895
    //   163: invokevirtual 242	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 4
    //   168: aload 5
    //   170: iload 4
    //   172: invokevirtual 5898	anvq:Vw	(I)V
    //   175: ldc 169
    //   177: iconst_1
    //   178: new 68	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 5900
    //   188: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 5902
    //   198: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload 4
    //   203: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_1
    //   213: iload_3
    //   214: invokestatic 5904	anvq:I	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   217: return
    //   218: astore_2
    //   219: ldc 169
    //   221: iconst_1
    //   222: new 68	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 5906
    //   232: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_2
    //   236: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aconst_null
    //   246: astore_2
    //   247: goto -99 -> 148
    //   250: aload_2
    //   251: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 370	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   260: astore_2
    //   261: goto -113 -> 148
    //   264: astore_2
    //   265: ldc 169
    //   267: iconst_1
    //   268: new 68	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 5908
    //   278: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_2
    //   282: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: goto -79 -> 212
    //   294: ldc 169
    //   296: iconst_1
    //   297: ldc_w 5910
    //   300: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 5
    //   305: iconst_0
    //   306: invokevirtual 5898	anvq:Vw	(I)V
    //   309: goto -97 -> 212
    //   312: aconst_null
    //   313: astore_2
    //   314: goto -166 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	aevk
    //   0	317	1	paramQQAppInterface	QQAppInterface
    //   0	317	2	paramConfig	ConfigurationService.Config
    //   13	201	3	i	int
    //   4	198	4	j	int
    //   72	232	5	localanvq	anvq
    // Exception table:
    //   from	to	target	type
    //   136	148	218	java/lang/Exception
    //   152	212	264	java/lang/Exception
  }
  
  /* Error */
  protected void R(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   6: ldc_w 2202
    //   9: iconst_0
    //   10: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokestatic 2200	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 208	java/lang/Integer
    //   19: invokevirtual 607	java/lang/Integer:intValue	()I
    //   22: istore 5
    //   24: aload_2
    //   25: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   28: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   31: istore 6
    //   33: new 68	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 5912
    //   43: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 5893
    //   54: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 6
    //   59: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 5914
    //   65: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: astore 7
    //   70: aload_2
    //   71: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   74: ifnonnull +109 -> 183
    //   77: iconst_0
    //   78: istore_3
    //   79: ldc_w 5916
    //   82: iconst_1
    //   83: aload 7
    //   85: iload_3
    //   86: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iload 5
    //   97: iload 6
    //   99: if_icmpeq +621 -> 720
    //   102: aload_2
    //   103: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   106: ifnull +614 -> 720
    //   109: aload_2
    //   110: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   113: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   116: ifle +604 -> 720
    //   119: iload 4
    //   121: istore_3
    //   122: iload_3
    //   123: aload_2
    //   124: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   127: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   130: if_icmpge +64 -> 194
    //   133: ldc_w 5916
    //   136: iconst_1
    //   137: new 68	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 5918
    //   147: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: iload_3
    //   155: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   161: getfield 1495	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   167: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: iload_3
    //   177: iconst_1
    //   178: iadd
    //   179: istore_3
    //   180: goto -58 -> 122
    //   183: aload_2
    //   184: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   187: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   190: istore_3
    //   191: goto -112 -> 79
    //   194: aload_2
    //   195: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   198: iconst_0
    //   199: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   202: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   205: astore 7
    //   207: aload 7
    //   209: ifnull +511 -> 720
    //   212: aload 7
    //   214: getfield 334	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   217: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   220: iconst_1
    //   221: if_icmpne +536 -> 757
    //   224: aload 7
    //   226: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokestatic 357	akrf:inflateConfigString	([B)[B
    //   238: astore 7
    //   240: aload 7
    //   242: ifnull +588 -> 830
    //   245: new 115	java/lang/String
    //   248: dup
    //   249: aload 7
    //   251: ldc_w 359
    //   254: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   257: astore 7
    //   259: aload 7
    //   261: ifnull +459 -> 720
    //   264: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +31 -> 298
    //   270: ldc_w 5916
    //   273: iconst_1
    //   274: new 68	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 5920
    //   284: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 7
    //   289: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: new 119	org/json/JSONObject
    //   301: dup
    //   302: aload 7
    //   304: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 5922
    //   314: invokevirtual 5925	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   317: astore 8
    //   319: aload 8
    //   321: invokevirtual 4016	org/json/JSONArray:length	()I
    //   324: ifle +18 -> 342
    //   327: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   330: ldc_w 5927
    //   333: aload 8
    //   335: invokevirtual 5928	org/json/JSONArray:toString	()Ljava/lang/String;
    //   338: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   341: pop
    //   342: aload 7
    //   344: ldc_w 5930
    //   347: invokevirtual 4619	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   350: astore 8
    //   352: aload 8
    //   354: ifnull +18 -> 372
    //   357: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   360: ldc_w 5932
    //   363: aload 8
    //   365: invokevirtual 5933	org/json/JSONObject:toString	()Ljava/lang/String;
    //   368: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload 7
    //   374: ldc_w 5935
    //   377: invokevirtual 583	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: istore_3
    //   381: aload 8
    //   383: ifnull +17 -> 400
    //   386: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   389: ldc_w 5937
    //   392: iload_3
    //   393: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   399: pop
    //   400: aload 7
    //   402: ldc_w 5939
    //   405: invokevirtual 4619	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   408: astore 8
    //   410: aload 8
    //   412: ifnull +76 -> 488
    //   415: aload 8
    //   417: ldc_w 5941
    //   420: invokevirtual 583	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   423: istore_3
    //   424: aload 8
    //   426: ldc_w 5943
    //   429: invokevirtual 583	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   432: istore 4
    //   434: aload 8
    //   436: ldc_w 5945
    //   439: invokevirtual 583	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   442: istore 5
    //   444: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   447: ldc_w 5947
    //   450: iload_3
    //   451: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   457: pop
    //   458: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   461: ldc_w 5949
    //   464: iload 4
    //   466: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   472: pop
    //   473: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   476: ldc_w 5951
    //   479: iload 5
    //   481: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload 7
    //   490: ldc_w 5953
    //   493: invokevirtual 5925	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   496: astore 8
    //   498: aload 8
    //   500: ifnull +273 -> 773
    //   503: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   506: ldc_w 5955
    //   509: aload 8
    //   511: invokevirtual 5928	org/json/JSONArray:toString	()Ljava/lang/String;
    //   514: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   517: pop
    //   518: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   521: ldc_w 2202
    //   524: aload_2
    //   525: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   528: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   531: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   537: pop
    //   538: aload 7
    //   540: ldc_w 5957
    //   543: iconst_0
    //   544: invokevirtual 138	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   547: istore_3
    //   548: aload 7
    //   550: ldc_w 5959
    //   553: iconst_m1
    //   554: invokevirtual 138	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   557: istore 4
    //   559: aload 7
    //   561: ldc_w 5961
    //   564: iconst_0
    //   565: invokevirtual 138	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   568: istore 5
    //   570: aload 7
    //   572: ldc_w 5963
    //   575: iconst_0
    //   576: invokevirtual 138	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   579: istore 6
    //   581: aload 7
    //   583: ldc_w 5965
    //   586: invokevirtual 566	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore_2
    //   590: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   593: ldc_w 5957
    //   596: iload_3
    //   597: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   603: pop
    //   604: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   607: ldc_w 5959
    //   610: iload 4
    //   612: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   618: pop
    //   619: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   622: ldc_w 5961
    //   625: iload 5
    //   627: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   633: pop
    //   634: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   637: ldc_w 5963
    //   640: iload 6
    //   642: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   645: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   648: pop
    //   649: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   652: ldc_w 5967
    //   655: aload_2
    //   656: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   659: pop
    //   660: aload 7
    //   662: ldc_w 5969
    //   665: invokevirtual 583	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   668: istore_3
    //   669: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   672: ldc_w 5969
    //   675: iload_3
    //   676: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   682: pop
    //   683: aload 7
    //   685: ldc_w 5971
    //   688: invokevirtual 4619	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   691: astore_2
    //   692: aload_2
    //   693: ifnull +17 -> 710
    //   696: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   699: ldc_w 5973
    //   702: aload_2
    //   703: invokevirtual 5933	org/json/JSONObject:toString	()Ljava/lang/String;
    //   706: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload_1
    //   711: ldc_w 5975
    //   714: iconst_1
    //   715: iconst_1
    //   716: aconst_null
    //   717: invokevirtual 5979	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   720: return
    //   721: astore 7
    //   723: ldc_w 5916
    //   726: iconst_1
    //   727: new 68	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 5981
    //   737: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 7
    //   742: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aconst_null
    //   752: astore 7
    //   754: goto -495 -> 259
    //   757: aload 7
    //   759: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   762: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   765: invokevirtual 370	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   768: astore 7
    //   770: goto -511 -> 259
    //   773: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   776: ldc_w 5955
    //   779: ldc 18
    //   781: invokestatic 2205	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   784: pop
    //   785: goto -267 -> 518
    //   788: astore_1
    //   789: ldc_w 5916
    //   792: iconst_1
    //   793: new 68	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 5983
    //   803: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_1
    //   807: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: return
    //   817: astore_1
    //   818: ldc_w 5916
    //   821: iconst_1
    //   822: ldc_w 5985
    //   825: aload_1
    //   826: invokestatic 721	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: return
    //   830: aconst_null
    //   831: astore 7
    //   833: goto -574 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	aevk
    //   0	836	1	paramQQAppInterface	QQAppInterface
    //   0	836	2	paramConfig	ConfigurationService.Config
    //   78	598	3	i	int
    //   1	610	4	j	int
    //   22	604	5	k	int
    //   31	610	6	m	int
    //   68	616	7	localObject1	Object
    //   721	20	7	localException	Exception
    //   752	80	7	str	String
    //   317	193	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   245	259	721	java/lang/Exception
    //   298	342	788	java/lang/Exception
    //   342	352	788	java/lang/Exception
    //   357	372	788	java/lang/Exception
    //   372	381	788	java/lang/Exception
    //   386	400	788	java/lang/Exception
    //   400	410	788	java/lang/Exception
    //   415	488	788	java/lang/Exception
    //   488	498	788	java/lang/Exception
    //   503	518	788	java/lang/Exception
    //   518	692	788	java/lang/Exception
    //   696	710	788	java/lang/Exception
    //   710	720	788	java/lang/Exception
    //   773	785	788	java/lang/Exception
    //   3	77	817	java/lang/Exception
    //   79	95	817	java/lang/Exception
    //   102	119	817	java/lang/Exception
    //   122	176	817	java/lang/Exception
    //   183	191	817	java/lang/Exception
    //   194	207	817	java/lang/Exception
    //   212	240	817	java/lang/Exception
    //   264	298	817	java/lang/Exception
    //   723	751	817	java/lang/Exception
    //   757	770	817	java/lang/Exception
    //   789	816	817	java/lang/Exception
  }
  
  void S(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    QLog.i("Contact.RecommendTabConfig", 1, String.format("receive handleContactRecommendTabConfig", new Object[0]));
    if (paramConfig.type.get() != 371) {
      return;
    }
    int i = aqmj.aP(paramQQAppInterface.getApp(), mCurUin);
    int j = paramConfig.version.get();
    if (i == j)
    {
      QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, req-version equals to rsp-version, ver=%d", new Object[] { Integer.valueOf(i) }));
      return;
    }
    byte[] arrayOfByte;
    if (paramConfig.msg_content_list.size() > 0)
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {
        if (paramConfig.compress.get() == 1)
        {
          arrayOfByte = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
          if (arrayOfByte == null) {
            break label296;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(arrayOfByte, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "handleContactRecommendTabConfig config_content:" + paramConfig);
        }
        aqmj.aa(paramQQAppInterface.getApp(), mCurUin, paramConfig);
        aqmj.ak(paramQQAppInterface.getApp(), mCurUin, j);
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, uncompress failed, buf-len=%d", new Object[] { Integer.valueOf(arrayOfByte.length) }));
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, content is null", new Object[0]));
      for (;;)
      {
        paramConfig = null;
        break;
        QLog.i("Contact.RecommendTabConfig", 1, String.format("handleContactRecommendTabConfig, msg content list is empty", new Object[0]));
      }
      label296:
      paramConfig = null;
    }
  }
  
  /* Error */
  void T(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: ldc_w 6005
    //   12: iconst_1
    //   13: ldc_w 6007
    //   16: iconst_0
    //   17: anewarray 178	java/lang/Object
    //   20: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   33: invokestatic 2222	xun:k	(Landroid/content/Context;Ljava/lang/String;)I
    //   36: istore_3
    //   37: aload_2
    //   38: getfield 101	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   41: invokevirtual 87	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   44: istore 6
    //   46: iload_3
    //   47: iload 6
    //   49: if_icmpeq +396 -> 445
    //   52: aload_2
    //   53: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   56: ifnull +365 -> 421
    //   59: aload_2
    //   60: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   63: invokevirtual 296	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   66: ifle +355 -> 421
    //   69: aload_2
    //   70: getfield 293	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Config:msg_content_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   73: iconst_0
    //   74: invokevirtual 299	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   77: checkcast 301	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +326 -> 408
    //   85: aload_2
    //   86: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   89: invokevirtual 1357	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   92: ifeq +316 -> 408
    //   95: aload_2
    //   96: getfield 334	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:compress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   99: invokevirtual 337	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   102: iconst_1
    //   103: if_icmpne +217 -> 320
    //   106: aload_2
    //   107: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   110: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   113: invokevirtual 351	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   116: invokestatic 357	akrf:inflateConfigString	([B)[B
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +393 -> 514
    //   124: new 115	java/lang/String
    //   127: dup
    //   128: aload_2
    //   129: ldc_w 359
    //   132: invokespecial 362	java/lang/String:<init>	([BLjava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +215 -> 352
    //   140: new 119	org/json/JSONObject
    //   143: dup
    //   144: aload_2
    //   145: invokespecial 122	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 9
    //   150: ldc_w 6005
    //   153: iconst_1
    //   154: new 68	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 6009
    //   164: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 9
    //   179: ldc_w 6011
    //   182: invokevirtual 242	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   185: istore_3
    //   186: aload 9
    //   188: ldc_w 6013
    //   191: invokevirtual 242	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   194: istore 4
    //   196: aload 9
    //   198: ldc_w 6015
    //   201: invokevirtual 781	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   204: astore 9
    //   206: aload 8
    //   208: astore_2
    //   209: aload 9
    //   211: ifnull +123 -> 334
    //   214: aload 8
    //   216: astore_2
    //   217: aload 9
    //   219: invokevirtual 4016	org/json/JSONArray:length	()I
    //   222: ifle +112 -> 334
    //   225: new 3159	java/util/HashSet
    //   228: dup
    //   229: invokespecial 3160	java/util/HashSet:<init>	()V
    //   232: astore_2
    //   233: iload 5
    //   235: aload 9
    //   237: invokevirtual 4016	org/json/JSONArray:length	()I
    //   240: if_icmpge +94 -> 334
    //   243: aload 9
    //   245: iload 5
    //   247: invokevirtual 6016	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   250: checkcast 119	org/json/JSONObject
    //   253: ldc_w 6018
    //   256: invokevirtual 248	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 7
    //   261: aload 7
    //   263: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +12 -> 278
    //   269: aload_2
    //   270: aload 7
    //   272: invokeinterface 3163 2 0
    //   277: pop
    //   278: iload 5
    //   280: iconst_1
    //   281: iadd
    //   282: istore 5
    //   284: goto -51 -> 233
    //   287: astore_2
    //   288: ldc_w 6005
    //   291: iconst_1
    //   292: new 68	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 6020
    //   302: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_2
    //   306: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aconst_null
    //   316: astore_2
    //   317: goto -181 -> 136
    //   320: aload_2
    //   321: getfield 340	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$Content:content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   324: invokevirtual 345	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   327: invokevirtual 370	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   330: astore_2
    //   331: goto -195 -> 136
    //   334: iload_3
    //   335: istore 5
    //   337: iload 4
    //   339: istore_3
    //   340: aload_1
    //   341: invokestatic 6023	xun:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lxun;
    //   344: aload_1
    //   345: iload 5
    //   347: iload_3
    //   348: aload_2
    //   349: invokevirtual 6026	xun:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   352: aload_1
    //   353: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   356: getstatic 20	aevk:mCurUin	Ljava/lang/String;
    //   359: iload 6
    //   361: invokestatic 6028	xun:k	(Landroid/content/Context;Ljava/lang/String;I)V
    //   364: return
    //   365: astore_2
    //   366: iconst_0
    //   367: istore 4
    //   369: iconst_0
    //   370: istore_3
    //   371: ldc_w 6005
    //   374: iconst_1
    //   375: new 68	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 5908
    //   385: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_2
    //   389: invokevirtual 960	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 7
    //   400: astore_2
    //   401: iload 4
    //   403: istore 5
    //   405: goto -65 -> 340
    //   408: ldc_w 6005
    //   411: iconst_1
    //   412: ldc_w 6030
    //   415: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -66 -> 352
    //   421: ldc_w 6005
    //   424: iconst_1
    //   425: ldc_w 6032
    //   428: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_1
    //   432: invokestatic 6023	xun:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lxun;
    //   435: aload_1
    //   436: iconst_0
    //   437: iconst_0
    //   438: aconst_null
    //   439: invokevirtual 6026	xun:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IILjava/util/Set;)V
    //   442: goto -90 -> 352
    //   445: ldc_w 6005
    //   448: iconst_1
    //   449: ldc_w 6034
    //   452: iconst_1
    //   453: anewarray 178	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: iload_3
    //   459: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: invokestatic 216	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   466: invokestatic 439	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: return
    //   470: astore_2
    //   471: iload_3
    //   472: istore 4
    //   474: iconst_0
    //   475: istore_3
    //   476: goto -105 -> 371
    //   479: astore_2
    //   480: iload_3
    //   481: istore 5
    //   483: iload 4
    //   485: istore_3
    //   486: iload 5
    //   488: istore 4
    //   490: goto -119 -> 371
    //   493: astore 8
    //   495: iload_3
    //   496: istore 5
    //   498: iload 4
    //   500: istore_3
    //   501: aload_2
    //   502: astore 7
    //   504: iload 5
    //   506: istore 4
    //   508: aload 8
    //   510: astore_2
    //   511: goto -140 -> 371
    //   514: aconst_null
    //   515: astore_2
    //   516: goto -380 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	aevk
    //   0	519	1	paramQQAppInterface	QQAppInterface
    //   0	519	2	paramConfig	ConfigurationService.Config
    //   36	465	3	i	int
    //   194	313	4	j	int
    //   7	498	5	k	int
    //   44	316	6	m	int
    //   1	502	7	localObject1	Object
    //   4	211	8	localObject2	Object
    //   493	16	8	localException	Exception
    //   148	96	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   124	136	287	java/lang/Exception
    //   140	186	365	java/lang/Exception
    //   186	196	470	java/lang/Exception
    //   196	206	479	java/lang/Exception
    //   217	233	479	java/lang/Exception
    //   233	278	493	java/lang/Exception
  }
  
  void V(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    ThreadManager.getSubThreadHandler().post(new ConfigServlet.13(this, paramConfig, paramQQAppInterface));
  }
  
  void W(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = aqmj.aT(paramQQAppInterface.getApp(), mCurUin);
    int j = paramConfig.version.get();
    if (i != j) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if ((paramConfig != null) && (paramConfig.content.has())) {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {
              break label339;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        aqmj.am(paramQQAppInterface.getApp(), mCurUin, j);
        ((aiyw)paramQQAppInterface.getManager(221)).Me(paramConfig);
        if (QLog.isColorLevel()) {
          QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig reqVer: %d rspVer: %d config: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramConfig }));
        }
        return;
      }
      catch (Exception paramConfig)
      {
        QLog.e("SPLASH_ConfigServlet", 1, "handleCUOpenCardGuideConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      paramConfig = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig empty content", new Object[0]));
        paramConfig = localObject1;
        continue;
        paramConfig = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig empty config", new Object[0]));
          paramConfig = localObject1;
          continue;
          paramConfig = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("CU_OPEN_CARD_GUIDE", 2, String.format(Locale.getDefault(), "handleCUOpenCardGuideConfig same version, no need to update", new Object[0]));
            paramConfig = localObject2;
            continue;
            label339:
            paramConfig = null;
          }
        }
      }
    }
  }
  
  public void Z(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    boolean bool;
    if (i != paramQQAppInterface.getPreferences().getInt("tim_upgrade_hongdian_version", 0))
    {
      long l1 = System.currentTimeMillis();
      bool = aqiz.isAppInstalled(paramQQAppInterface.getApp(), "com.tencent.tim");
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TimUpgradeHondianManager", 2, "is install TIM = " + bool + " time cost = " + (l2 - l1));
      }
      if (bool) {
        break label386;
      }
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      Object localObject = new JSONObject((String)paramConfig.get(0));
      if (((JSONObject)localObject).has("AboutTIMRedDot"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_upgrade_hongdian_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localObject = ((JSONObject)localObject).getJSONObject("AboutTIMRedDot");
        if (((JSONObject)localObject).has("On")) {
          if (((JSONObject)localObject).getInt("On") != 1) {
            break label374;
          }
        }
      }
      label374:
      for (bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_upgrade_hongdian_switch", bool);
        if (((JSONObject)localObject).has("AboutTitle")) {
          paramConfig.putString("tim_upgrade_hongdian_title", ((JSONObject)localObject).getString("AboutTitle"));
        }
        if (((JSONObject)localObject).has("AboutSubtitle")) {
          paramConfig.putString("tim_upgrade_hongdian_sub_title", ((JSONObject)localObject).getString("AboutSubtitle"));
        }
        if (((JSONObject)localObject).has("AndroidAboutURL"))
        {
          localObject = ((JSONObject)localObject).getString("AndroidAboutURL");
          paramConfig.putString("tim_upgrade_hongdian_url", (String)localObject);
          ((UpgradeTIMManager)paramQQAppInterface.getManager(256)).Uj((String)localObject);
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_upgrade_hongdian_version", i);
        paramQQAppInterface.apply();
        return;
      }
      ((aizo)paramQQAppInterface.getManager(244)).dvI();
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return;
    }
    label386:
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, success=", Boolean.valueOf(paramBoolean) });
    }
    int m = 0;
    int i = 0;
    int j = 2;
    int k;
    OlympicActConfig localOlympicActConfig;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 86))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, result=", Integer.valueOf(paramInt) });
      }
      if (paramInt == 0)
      {
        k = paramConfig.version.get();
        paramInt = paramIntent.getIntExtra("config_version", 0);
        if (QLog.isColorLevel()) {
          QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, reqVersion=", Integer.valueOf(paramInt), ", receiveVersion=", Integer.valueOf(k) });
        }
        if (k != paramInt) {
          if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
          {
            paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
            if (paramIntent != null)
            {
              j = paramIntent.task_id.get();
              if (paramIntent.compress.get() == 1)
              {
                paramConfig = akrf.inflateConfigString(paramIntent.content.get().toByteArray());
                if (paramConfig == null)
                {
                  paramInt = 4;
                  paramIntent = null;
                  if (QLog.isColorLevel()) {
                    QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, xmlContent=", paramIntent });
                  }
                  localOlympicActConfig = OlympicActConfig.parse(getAppRuntime(), paramIntent);
                  if (QLog.isColorLevel())
                  {
                    if (localOlympicActConfig != null) {
                      break label523;
                    }
                    paramConfig = "null";
                    label294:
                    QLog.d("Olympic.configServlet", 2, new Object[] { "handleResp_GetOlympicActConfig, newConfig=", paramConfig });
                  }
                  if (localOlympicActConfig == null) {
                    break label556;
                  }
                  i = 0;
                  localOlympicActConfig.version = k;
                  paramIntent = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(167);
                  if (paramIntent == null) {
                    break label529;
                  }
                  paramIntent.a(localOlympicActConfig);
                  paramInt = i;
                  label361:
                  i = j;
                  label365:
                  j = k;
                  k = i;
                  i = paramInt;
                  paramInt = k;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        OlympicServlet.a(getAppRuntime(), 86, j, paramInt, 1, i, -1);
        paramIntent = (OlympicManager)((QQAppInterface)getAppRuntime()).getManager(167);
        if (paramIntent != null)
        {
          paramIntent.dCO();
          paramIntent.dCN();
        }
        return;
        try
        {
          paramIntent = new String(paramConfig, "UTF-8");
          paramInt = 2;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          if (QLog.isColorLevel()) {
            paramIntent.printStackTrace();
          }
          paramIntent = null;
          paramInt = 2;
        }
        catch (OutOfMemoryError paramIntent)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              paramIntent.printStackTrace();
            }
            System.gc();
            try
            {
              paramIntent = new String(paramConfig, "UTF-8");
              paramInt = 2;
            }
            catch (Throwable paramIntent)
            {
              paramIntent = null;
              paramInt = 2;
            }
          }
        }
      }
      break;
      paramIntent = paramIntent.content.get().toStringUtf8();
      paramInt = 2;
      break;
      label523:
      paramConfig = localOlympicActConfig;
      break label294;
      label529:
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label361;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, manager is null!");
      paramInt = i;
      break label361;
      label556:
      i = paramInt;
      if (paramIntent != null) {
        i = 5;
      }
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label361;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, parse failed, newConfig is null!");
      paramInt = i;
      break label361;
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, content is null");
      }
      i = 0;
      paramInt = j;
      break label365;
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, msg_content_list is null");
      }
      paramIntent = (QQAppInterface)getAppRuntime();
      paramConfig = (OlympicManager)paramIntent.getManager(167);
      if (paramConfig != null) {
        paramConfig.dCM();
      }
      OlympicActConfig.deleteFile(paramIntent, BaseApplicationImpl.getContext());
      paramInt = j;
      i = m;
      break label365;
      paramInt = j;
      i = m;
      if (!QLog.isColorLevel()) {
        break label365;
      }
      QLog.d("Olympic.configServlet", 2, "handleResp_GetOlympicActConfig, has same version");
      paramInt = j;
      i = m;
      break label365;
      paramInt = 0;
      k = 1;
      j = i;
      i = k;
      continue;
      paramInt = 0;
      k = 1;
      j = i;
      i = k;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig |  type= " + paramConfig.type.get());
    }
    if (paramConfig.type.get() != 205) {}
    do
    {
      do
      {
        do
        {
          return;
          int i = paramConfig.version.get();
          if (paramIntent.getIntExtra("key_download_cfg_version", 0) != i) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, version same");
        return;
        if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
      return;
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, content is null");
    return;
    byte[] arrayOfByte;
    if (paramIntent.compress.get() == 1)
    {
      arrayOfByte = akrf.inflateConfigString(paramIntent.content.get().toByteArray());
      if (arrayOfByte == null) {
        break label351;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new String(arrayOfByte, "UTF-8");
        if (paramIntent == null) {
          break label329;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config_content is " + paramIntent);
        }
        adfa.s(paramQQAppInterface, paramIntent, paramConfig.version.get());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig, config type 205");
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramIntent)
        {
          paramIntent = null;
        }
        continue;
      }
      paramIntent = paramIntent.content.get().toStringUtf8();
      continue;
      label329:
      adfa.cH(paramQQAppInterface);
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanFacePreDownConfig we delete ARConfig info here");
        continue;
        label351:
        paramIntent = null;
      }
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, String paramString, aevk.a parama)
  {
    int j = paramConfig.version.get();
    int i = parama.Bs();
    if (QLog.isColorLevel()) {
      QLog.d("TroopRankConfig", 2, paramString + ", serverVersion=" + j + "|localVersion=" + i);
    }
    if ((j != i) && (paramConfig.msg_content_list.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramConfig.msg_content_list.size();
      i = 0;
      if (i < k)
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        byte[] arrayOfByte;
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.compress.get() != 1) {
            break label271;
          }
          arrayOfByte = akrf.inflateConfigString(paramQQAppInterface.content.get().toByteArray());
          if (arrayOfByte == null) {
            break label266;
          }
        }
        for (;;)
        {
          try
          {
            paramQQAppInterface = new String(arrayOfByte, "UTF-8");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              localArrayList.add(paramQQAppInterface);
            }
            i += 1;
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
            }
            paramQQAppInterface = null;
            continue;
          }
          catch (OutOfMemoryError paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
            }
            System.gc();
            try
            {
              paramQQAppInterface = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable paramQQAppInterface)
            {
              if (QLog.isColorLevel()) {
                QLog.w("SPLASH_ConfigServlet", 2, paramString, paramQQAppInterface);
              }
            }
          }
          label266:
          paramQQAppInterface = null;
          continue;
          label271:
          paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
        }
      }
      if (localArrayList.size() <= 0) {
        break label314;
      }
      parama.Mi(j);
      parama.jO(localArrayList);
    }
    label314:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, paramString + ", config_content is empty");
  }
  
  public void aa(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("tim_login_jump", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramConfig.get(0));
      if (localJSONObject.has("LoginedTipForTIM"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_login_shared_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localJSONObject = localJSONObject.getJSONObject("LoginedTipForTIM");
        if (localJSONObject.has("On")) {
          if (localJSONObject.getInt("On") != 1) {
            break label463;
          }
        }
      }
      label463:
      for (boolean bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_login_s", bool);
        if (localJSONObject.has("ShowTipTimeIntervalAfterLogined")) {
          paramConfig.putInt("tim_login_tal", localJSONObject.getInt("ShowTipTimeIntervalAfterLogined"));
        }
        if (localJSONObject.has("ShowTipDay")) {
          paramConfig.putString("tim_login_sd", localJSONObject.getJSONArray("ShowTipDay").toString());
        }
        if (localJSONObject.has("ShowTipTime")) {
          paramConfig.putString("tim_login_st", localJSONObject.getJSONArray("ShowTipTime").toString());
        }
        if (localJSONObject.has("AndroidLimit")) {
          paramConfig.putInt("tim_login_l", localJSONObject.getInt("AndroidLimit"));
        }
        if (localJSONObject.has("ShowTipTotalCount")) {
          paramConfig.putInt("tim_login_tc", localJSONObject.getInt("ShowTipTotalCount"));
        }
        if (localJSONObject.has("ShowTipHourInterval")) {
          paramConfig.putInt("tim_login_sti", localJSONObject.getInt("ShowTipHourInterval"));
        }
        if (localJSONObject.has("Title")) {
          paramConfig.putString("tim_login_t", localJSONObject.getString("Title"));
        }
        if (localJSONObject.has("Message")) {
          paramConfig.putString("tim_login_c", localJSONObject.getString("Message"));
        }
        if (localJSONObject.has("Buttons")) {
          paramConfig.putString("tim_login_btns", localJSONObject.getJSONArray("Buttons").toString());
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_login_jump", i);
        paramQQAppInterface.apply();
        return;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void ab(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("tim_pc_banner", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    try
    {
      JSONObject localJSONObject = new JSONObject((String)paramConfig.get(0));
      if (localJSONObject.has("PCTIMLoginBanner"))
      {
        paramConfig = paramQQAppInterface.getApp().getSharedPreferences("tim_pc_banner_shared_pre_" + paramQQAppInterface.getCurrentUin(), 0).edit();
        localJSONObject = localJSONObject.getJSONObject("PCTIMLoginBanner");
        if (localJSONObject.has("On")) {
          if (localJSONObject.getInt("On") != 1) {
            break label338;
          }
        }
      }
      label338:
      for (boolean bool = true;; bool = false)
      {
        paramConfig.putBoolean("tim_pc_banner_switch", bool);
        if (localJSONObject.has("bannerURL")) {
          paramConfig.putString("tim_pc_banner_image_url", localJSONObject.getString("bannerURL"));
        }
        if (localJSONObject.has("bannerVersion")) {
          paramConfig.putInt("tim_pc_banner_image_ver", localJSONObject.getInt("bannerVersion"));
        }
        if (localJSONObject.has("androidURL")) {
          paramConfig.putString("tim_pc_banner_click_url", localJSONObject.getString("androidURL"));
        }
        if (localJSONObject.has("linkText")) {
          paramConfig.putString("tim_pc_banner_link_text", localJSONObject.getString("linkText"));
        }
        if (localJSONObject.has("androidLinkURL")) {
          paramConfig.putString("tim_pc_banner_link_url", localJSONObject.getString("androidLinkURL"));
        }
        paramConfig.commit();
        paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
        paramQQAppInterface.putInt("tim_pc_banner", i);
        paramQQAppInterface.apply();
        return;
      }
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void ac(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != paramQQAppInterface.getPreferences().getInt("troop_link_config_version", 0))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        if (aptl.a().qT(paramConfig)) {
          paramQQAppInterface.getPreferences().edit().putInt("troop_link_config_version", i).commit();
        }
      }
    }
  }
  
  public void ad(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    if (paramQQAppInterface == null) {}
    label17:
    do
    {
      break label17;
      do
      {
        return;
      } while (paramQQAppInterface.getInt("key_game_troop_bind_config_version", 0) == i);
      paramConfig = a(paramConfig);
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {
        break;
      }
      paramConfig = (String)paramConfig.get(0);
    } while (paramConfig == null);
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject(paramConfig);
        if ((!paramConfig.has("showBindGameEntry")) || (paramConfig.getInt("showBindGameEntry") != 1)) {
          break label266;
        }
        bool = true;
        paramQQAppInterface.edit().putBoolean("key_game_troop_bind_config_switch", bool).apply();
        paramQQAppInterface.edit().putInt("key_game_troop_bind_config_version", i).apply();
        if (!QLog.isColorLevel()) {
          break label17;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "game troop config set:" + bool);
        return;
      }
      catch (Exception paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SPLASH_ConfigServlet", 2, "game troop config parse error:" + paramQQAppInterface.toString());
      return;
      paramQQAppInterface.edit().putBoolean("key_game_troop_bind_config_switch", false).apply();
      paramQQAppInterface.edit().putInt("key_game_troop_bind_config_version", i).apply();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "game troop config empty content get");
      return;
      label266:
      boolean bool = false;
    }
  }
  
  public void ae(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = paramQQAppInterface.getPreferences().getInt("tim_aio_tips_bar_version", 0);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handleTimAIOTipsBar| config empty, delete config, version=", Integer.valueOf(i) });
      }
      paramQQAppInterface.getPreferences().edit().remove("tim_aio_tips_bar_version").apply();
      ((wjw)paramQQAppInterface.getManager(218)).bYz();
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (i == j);
      paramQQAppInterface.getPreferences().edit().putInt("tim_aio_tips_bar_version", i).apply();
      localObject = a(paramConfig);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    paramConfig = new AppGuideTipsConfig();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, new Object[] { "handleTimAIOTipsBar| Get Config ", Integer.valueOf(254), ": ", ((List)localObject).get(0) });
      }
      localObject = new JSONObject((String)((List)localObject).get(0));
      if (((JSONObject)localObject).has("SendMessageAIOTopTip"))
      {
        localObject = ((JSONObject)localObject).getJSONObject("SendMessageAIOTopTip");
        paramConfig.switchKey = ((JSONObject)localObject).getString("switch");
        paramConfig.maxCount = Integer.valueOf(((JSONObject)localObject).getString("total")).intValue();
        paramConfig.duration = Long.valueOf(((JSONObject)localObject).getString("duration")).longValue();
        paramConfig.tipsUrl = ((JSONObject)localObject).getString("androidURL");
        paramConfig.tipsMsg = ((JSONObject)localObject).getString("title");
        paramConfig.msgTypeStr = ((JSONObject)localObject).getString("androidtypes");
        paramConfig.aioTypeStr = ((JSONObject)localObject).getString("androidAIOTypes");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    paramQQAppInterface = (wjw)paramQQAppInterface.getManager(218);
    paramQQAppInterface.a(paramConfig);
    paramQQAppInterface.bYy();
  }
  
  public void af(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != anjn.aA(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0)) {
        anjn.a((String)paramConfig.get(0), i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void ag(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    boolean bool4 = true;
    boolean bool5 = false;
    int i = paramConfig.version.get();
    Object localObject2;
    SharedPreferences.Editor localEditor;
    Object localObject1;
    boolean bool1;
    if (i != paramQQAppInterface.getPreferences().getInt("data_migration_tim_version", 0))
    {
      paramConfig = a(paramConfig);
      localObject2 = paramQQAppInterface.getApp().getSharedPreferences("data_migration_tim", 0);
      localEditor = ((SharedPreferences)localObject2).edit();
      if ((paramConfig == null) || (paramConfig.size() <= 0)) {}
    }
    else
    {
      try
      {
        paramConfig = new JSONObject((String)paramConfig.get(0));
        if (!paramConfig.has("DataMigration")) {
          break label332;
        }
        localObject1 = paramConfig.getJSONObject("DataMigration");
        paramConfig = "";
        str1 = "";
        if (!((JSONObject)localObject1).has("switch")) {
          break label565;
        }
        if (((JSONObject)localObject1).getInt("switch") != 1) {
          break label367;
        }
        bool1 = true;
      }
      catch (JSONException paramConfig)
      {
        for (;;)
        {
          String str1;
          label173:
          paramConfig.printStackTrace();
        }
      }
      if (!((JSONObject)localObject1).has("uninstall")) {
        break label559;
      }
      if (((JSONObject)localObject1).getInt("uninstall") == 1)
      {
        bool1 = true;
        break label578;
        if (((JSONObject)localObject1).has("title")) {
          paramConfig = ((JSONObject)localObject1).getString("title");
        }
        if (((JSONObject)localObject1).has("content")) {
          str1 = ((JSONObject)localObject1).getString("content");
        }
        bool1 = bool5;
        if (((JSONObject)localObject1).has("uninstallNotify"))
        {
          if (((JSONObject)localObject1).getInt("uninstallNotify") != 1) {
            break label379;
          }
          bool1 = bool4;
          break label585;
        }
      }
    }
    label559:
    label565:
    label578:
    label585:
    for (;;)
    {
      if (((JSONObject)localObject1).has("uninstallTitle")) {}
      for (String str2 = ((JSONObject)localObject1).getString("uninstallTitle");; str2 = "")
      {
        if (((JSONObject)localObject1).has("uninstallContent")) {}
        for (localObject1 = ((JSONObject)localObject1).getString("uninstallContent");; localObject1 = "")
        {
          localObject2 = a((SharedPreferences)localObject2, paramQQAppInterface.getCurrentAccountUin(), bool2);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
            }
            localEditor.clear();
          }
          for (;;)
          {
            label332:
            localEditor.apply();
            paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
            paramQQAppInterface.putInt("data_migration_tim_version", i);
            paramQQAppInterface.apply();
            return;
            label367:
            bool1 = false;
            break;
            bool1 = false;
            break label578;
            label379:
            bool1 = false;
            break label585;
            localEditor.putString("data_migration_tim_uins", (String)localObject2);
            localEditor.putBoolean("data_migration_tim_uninstall_flag", bool3);
            localEditor.putString("data_migration_tim_title", paramConfig);
            localEditor.putString("data_migration_tim_content", str1);
            localEditor.putBoolean("data_migration_tim_uninstall_notify", bool1);
            localEditor.putString("data_migration_tim_uninstall_title", str2);
            localEditor.putString("data_migration_tim_uninstall_content", (String)localObject1);
            continue;
            paramConfig = a((SharedPreferences)localObject2, paramQQAppInterface.getCurrentAccountUin(), false);
            if (TextUtils.isEmpty(paramConfig))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "handleDataMigrationForTIM| remove all uins");
              }
              localEditor.clear();
            }
            else
            {
              localEditor.putString("data_migration_tim_uins", paramConfig);
            }
          }
        }
      }
      boolean bool3 = false;
      break label173;
      boolean bool2 = false;
      break;
      bool2 = bool1;
      break;
      bool3 = bool1;
      break label173;
    }
  }
  
  public void ah(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    Object localObject;
    if (i != paramQQAppInterface.getPreferences().getInt("call_tim_config_version", 0))
    {
      localObject = a(paramConfig);
      paramConfig = paramQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + paramQQAppInterface.getCurrentUin(), 0).edit();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label262;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)((List)localObject).get(0));
        if (((JSONObject)localObject).has("TIMFreeCloud"))
        {
          localObject = ((JSONObject)localObject).getJSONObject("TIMFreeCloud");
          if (((JSONObject)localObject).has("On")) {
            paramConfig.putBoolean("call_tim_config_switch", "1".equals(((JSONObject)localObject).getString("On")));
          }
          if (((JSONObject)localObject).has("Title")) {
            paramConfig.putString("call_tim_config_title", ((JSONObject)localObject).getString("Title"));
          }
          if (((JSONObject)localObject).has("androidURL")) {
            paramConfig.putString("call_tim_config_url", ((JSONObject)localObject).getString("androidURL"));
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      paramConfig.commit();
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putInt("call_tim_config_version", i);
      paramQQAppInterface.apply();
      return;
      label262:
      paramConfig.putBoolean("call_tim_config_switch", false);
    }
  }
  
  void ai(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 267) || (paramQQAppInterface == null)) {}
    int i;
    int j;
    do
    {
      return;
      i = aqmj.i(paramQQAppInterface.getApp(), "sport_config", mCurUin);
      j = paramConfig.version.get();
    } while (i == j);
    ((aqtz)paramQQAppInterface.getManager(260)).I(paramConfig);
    aqmj.g(paramQQAppInterface.getApp(), "sport_config", mCurUin, j);
  }
  
  public void aj(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 281) || (paramQQAppInterface == null)) {}
    do
    {
      String str;
      do
      {
        return;
        str = b(paramConfig, aqmj.i(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0"), 281);
      } while (TextUtils.isEmpty(str));
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig content: " + str);
      }
      int i = paramConfig.version.get();
      aqmj.g(paramQQAppInterface.getApp(), "troop_gift_anim_limit", "0", i);
      try
      {
        i = new JSONObject(str).getInt("limitGiftAnimCount");
        apqk.dVo = i;
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
        paramQQAppInterface.putInt("AIOAnimationControlManager_limit_gif_count_MAX", i);
        paramQQAppInterface.commit();
        return;
      }
      catch (JSONException paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.w("SPLASH_ConfigServlet", 2, "handleTroopGiftLimitConfig error" + paramQQAppInterface.getMessage());
  }
  
  public void ak(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig == null) || (paramConfig.type.get() != 283)) {
      return;
    }
    paramQQAppInterface = a(paramConfig);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = (String)paramQQAppInterface.get(0);
      QLog.d("SafeModeUtil", 1, "handleSafeModeCmd configJson = " + paramQQAppInterface);
      MsfCmdConfig.executeSafeModeCmd(paramConfig.version.get(), paramQQAppInterface);
    }
    for (;;)
    {
      swu.bBB();
      return;
      QLog.d("SafeModeUtil", 1, "handleSafeModeCmd null");
    }
  }
  
  public void al(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.type.get() != 284) || (paramQQAppInterface == null)) {}
    int i;
    int j;
    do
    {
      return;
      i = aqmj.i(paramQQAppInterface.getApp(), "task_entry_config_version", mCurUin);
      j = paramConfig.version.get();
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "handleTaskEntryConfig reqVersion = " + i);
      }
    } while (i == j);
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("task_entry_config" + mCurUin, 0).edit();
    paramConfig = a(paramConfig);
    String str1;
    if ((paramConfig != null) && (paramConfig.size() > 0))
    {
      str1 = (String)paramConfig.get(0);
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "handleTaskEntryConfig configJson = " + str1);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(str1);
        paramConfig = ((JSONObject)localObject).optString("icon_url");
        String str2 = ((JSONObject)localObject).optString("night_icon_url");
        String str3 = ((JSONObject)localObject).optString("jump_url");
        localObject = ((JSONObject)localObject).optString("word");
        if ((!TextUtils.isEmpty(paramConfig)) && (!TextUtils.isEmpty(str3)))
        {
          localEditor.putBoolean("open", true);
          localEditor.putString("icon_url", paramConfig);
          localEditor.putString("night_icon_url", str2);
          localEditor.putString("jump_url", str3);
          localEditor.putString("word", (String)localObject);
          aqmj.g(paramQQAppInterface.getApp(), "task_entry_config_version", mCurUin, j);
          localEditor.commit();
          return;
        }
        localEditor.putBoolean("open", false);
        localEditor.remove("icon_url");
        localEditor.remove("night_icon_url");
        localEditor.remove("jump_url");
        localEditor.remove("word");
        continue;
      }
      catch (JSONException paramConfig)
      {
        localEditor.clear();
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramConfig = str1;
        if (str1 == null) {
          paramConfig = "";
        }
        QLog.e("zivonchen", 2, new Object[] { "handleTaskEntryConfig json fail. content: ", paramConfig });
        continue;
      }
      localEditor.clear();
    }
  }
  
  public void am(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != aywy.a().bJ(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(paramConfig.size() - 1);
        aywy.a().b(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void an(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    if (i != ayzr.a().bK(paramQQAppInterface.getApp()))
    {
      paramConfig = a(paramConfig);
      if ((paramConfig != null) && (paramConfig.size() > 0))
      {
        paramConfig = (String)paramConfig.get(0);
        ayzr.a().c(paramConfig, i, paramQQAppInterface.getApp());
      }
    }
  }
  
  public void ao(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = aqmj.i(paramQQAppInterface.getApp(), "buluo_enter_config_version", mCurUin);
    if (QLog.isColorLevel()) {
      QLog.i("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      localObject1 = a(paramConfig);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        localObject1 = (String)((List)localObject1).get(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          paramConfig = new JSONObject((String)localObject1);
          if (paramConfig.has("jump_url"))
          {
            paramConfig = paramConfig.getJSONObject("jump_url");
            if (paramConfig.has("android"))
            {
              Object localObject2 = new JSONObject(paramConfig.getString("android"));
              if ((((JSONObject)localObject2).has("url")) && (((JSONObject)localObject2).has("scheme")))
              {
                paramConfig = ((JSONObject)localObject2).getString("scheme");
                localObject2 = ((JSONObject)localObject2).getString("url");
                paramConfig = paramConfig + aqgo.encodeToString(((String)localObject2).getBytes(), 0);
                aqmj.P(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
                if (QLog.isColorLevel()) {
                  QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig. buluoEntryUrl: ", paramConfig });
                }
              }
            }
          }
          for (;;)
          {
            aqmj.g(paramQQAppInterface.getApp(), "buluo_enter_config_version", mCurUin, i);
            return;
            if (paramConfig.has("tribe_summary_url"))
            {
              paramConfig = paramConfig.optJSONObject("tribe_summary_url");
              if (paramConfig.has("android"))
              {
                paramConfig = paramConfig.optString("android");
                aqmj.Q(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramConfig);
              }
            }
          }
        }
        catch (JSONException paramConfig)
        {
          for (;;)
          {
            Object localObject1;
            if (QLog.isColorLevel())
            {
              paramConfig = (ConfigurationService.Config)localObject1;
              if (localObject1 == null) {
                paramConfig = "";
              }
              QLog.e("SPLASH_ConfigServlet", 2, new Object[] { "handleBuluoEnterConfig json fail. content: ", paramConfig });
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig json fail. configContent is empty ,version: " + paramConfig.version.get());
      return;
    }
    QLog.i("SPLASH_ConfigServlet", 2, "handleBuluoEnterConfig:localVersion == version = " + i);
  }
  
  public void b(Intent paramIntent, boolean paramBoolean, ConfigurationService.Config paramConfig, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] ENTER success=" + paramBoolean + " result=" + paramInt);
    }
    int j = 0;
    int i = 2;
    String str = paramIntent.getStringExtra("uin");
    int k;
    if ((paramBoolean) && (paramConfig != null) && (paramConfig.type.get() == 109)) {
      if (paramInt == 0)
      {
        k = paramConfig.version.get();
        int m = paramIntent.getIntExtra("qcamera_conf_version", 0);
        QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] reqVersion=" + m + " receiveVersion=" + k);
        paramInt = i;
        i = j;
        if (k != m)
        {
          aeah.ak(BaseApplicationImpl.getContext(), k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 2, "[handleRespQCameraPhoneConfig] save version: " + k + " and check config version: " + aeah.as(BaseApplicationImpl.getContext()));
          }
          if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
            break label560;
          }
          paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
          i = paramIntent.task_id.get();
          if (paramIntent.compress.get() != 1) {
            break label506;
          }
          paramIntent = aeah.v(paramIntent.content.get().toByteArray());
          if (paramIntent == null)
          {
            paramInt = 4;
            aeah.x(BaseApplicationImpl.getContext(), true);
            QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] uncompress failed");
          }
        }
        else
        {
          j = paramInt;
          paramInt = k;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          QLog.i("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] rptResult=" + j);
          paramIntent = new HashMap();
          paramIntent.put("rpt_type", String.valueOf(109));
          paramIntent.put("rpt_task_id", String.valueOf(k));
          paramIntent.put("rpt_req_version", String.valueOf(i));
          paramIntent.put("rpt_version", String.valueOf(paramInt));
          paramIntent.put("rpt_report_type", String.valueOf(1));
          paramIntent.put("rpt_result", String.valueOf(j));
          anpc.a(BaseApplication.getContext()).collectPerformance(str, "qcamera_phone_config_pull_event", paramBoolean, 0L, 0L, paramIntent, String.valueOf(j));
          return;
          paramInt = 0;
          paramIntent = new String(paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig] zip");
          }
          try
          {
            aeah.c(BaseApplicationImpl.getContext(), paramIntent, k);
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            paramInt = 3;
          }
        }
        break;
        label506:
        paramIntent = paramIntent.content.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("Q.camera.configServlet", 4, "[handleRespQCameraPhoneConfig]");
        }
        try
        {
          aeah.c(BaseApplicationImpl.getContext(), paramIntent, k);
          paramInt = 0;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          paramInt = 3;
        }
      }
      break;
      label560:
      paramInt = 5;
      QLog.w("Q.camera.configServlet", 1, "[handleRespQCameraPhoneConfig] no data, current disableCameraSDK=" + aeah.bh(BaseApplicationImpl.getContext()));
      i = j;
      break;
      paramInt = 0;
      j = 1;
      k = 0;
      i = 0;
      continue;
      paramInt = 0;
      j = 1;
      k = 0;
      i = 0;
    }
  }
  
  void c(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig |  type= " + paramConfig.type.get());
    }
    adas localadas = (adas)((QQAppInterface)getAppRuntime()).getManager(220);
    int i;
    byte[] arrayOfByte;
    if (paramConfig.type.get() == 206)
    {
      i = paramConfig.version.get();
      if (paramIntent.getIntExtra("ar_scan_star_face_config_version", 0) == i) {
        break label353;
      }
      if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
        break label325;
      }
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramIntent == null) {
        break label307;
      }
      if (paramIntent.compress.get() != 1) {
        break label293;
      }
      arrayOfByte = akrf.inflateConfigString(paramIntent.content.get().toByteArray());
      if (arrayOfByte == null) {
        break label371;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new String(arrayOfByte, "UTF-8");
        if (paramIntent != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, config_content is " + paramIntent);
          }
          i = paramConfig.version.get();
          if (localadas.kP(paramIntent)) {
            localadas.Ku(i);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, config type 206");
        }
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = null;
        continue;
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(arrayOfByte, "UTF-8");
        }
        catch (Throwable paramIntent)
        {
          paramIntent = null;
        }
        continue;
      }
      label293:
      paramIntent = paramIntent.content.get().toStringUtf8();
      continue;
      label307:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, content is null");
        continue;
        label325:
        if (localadas != null) {
          localadas.cPC();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig we delete ARConfig info here");
          continue;
          label353:
          if (QLog.isColorLevel())
          {
            QLog.d("SPLASH_ConfigServlet", 2, "handleResp_GetArScanStarFaceConfig, version same");
            continue;
            label371:
            paramIntent = null;
          }
        }
      }
    }
  }
  
  public void d(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 79,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != aqmj.av(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin())) || (paramConfig.content_list.size() > 0))
            {
              str = str.split("=")[1];
              if (!TextUtils.isEmpty(str)) {
                awit.u(str, localQQAppInterface);
              }
              aqmj.A(localQQAppInterface.getApp(), j, localQQAppInterface.getCurrentAccountUin());
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_MERGE_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy merge config error,cmd : 79" + paramConfig.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 79,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  protected void l(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (paramConfig != null) {}
    for (;;)
    {
      try
      {
        if (paramConfig.type.get() != 143) {
          break label366;
        }
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label431;
        }
        Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (localObject1 == null) {
          break label349;
        }
        if (((ConfigurationService.Content)localObject1).compress.get() == 1)
        {
          byte[] arrayOfByte = akrf.inflateConfigString(((ConfigurationService.Content)localObject1).content.get().toByteArray());
          if (arrayOfByte == null) {
            break label425;
          }
          try
          {
            localObject1 = new String(arrayOfByte, "UTF-8");
            if (localObject1 == null) {
              break label431;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "receiveAllConfigs|type: 143,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            }
            int i = paramConfig.version.get();
            if ((i == aqmj.i(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", mCurUin)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            ajpt.MH((String)localObject1);
            ajpt.MI((String)localObject1);
            aqmj.cv(paramQQAppInterface.getApp(), (String)localObject1);
            aqmj.g(paramQQAppInterface.getApp(), "nearby_glamour_level_config_version", mCurUin, i);
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            if (!QLog.isColorLevel()) {
              break label432;
            }
            localUnsupportedEncodingException.printStackTrace();
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              localOutOfMemoryError.printStackTrace();
            }
            System.gc();
            try
            {
              String str = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable localThrowable)
            {
              localObject2 = null;
            }
            continue;
          }
        }
        else
        {
          localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label431;
        }
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "received CHNAGE_MACHINE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label431;
        }
      }
      QLog.e("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "received change machine config error,cmd : 143" + paramQQAppInterface.toString());
      return;
      label349:
      if (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, "handleNearbyGlamourLevelConfig, content is null");
        return;
        label366:
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("receiveAllConfigs|type: 143,content_list is empty ,version: ");
          if (paramConfig != null) {}
          for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
          {
            QLog.d("SPLASH_ConfigServletQ.nearby.tag_nearby_glamour_level_config", 2, paramQQAppInterface);
            return;
          }
          localObject2 = null;
          continue;
        }
      }
      label425:
      label431:
      return;
      label432:
      Object localObject2 = null;
    }
  }
  
  public void l(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            String str = (String)paramConfig.content_list.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 72,content: " + str + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != aqmj.au(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin())) || (paramConfig.content_list.size() > 0))
            {
              if (awit.e(localQQAppInterface, str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SPLASH_ConfigServlet", 2, "received 72 ark config");
                }
                aqmj.X(getAppRuntime().getApplication(), localQQAppInterface.getCurrentUin(), j);
                break label304;
              }
              if ((!obt.l((QQAppInterface)getAppRuntime(), str)) || (!QLog.isColorLevel())) {
                continue;
              }
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD save version: " + j);
              continue;
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder config error,cmd : 72");
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_CONFIG_CMD IGNORE THIS ACTION  because of SAME VERSION");
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 72,content_list is empty ,version: " + paramConfig.version.get());
          return;
        }
      }
      label304:
      i += 1;
    }
  }
  
  public void m(ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
        if ((paramConfig.content_list != null) && (paramConfig.content_list.size() > 0))
        {
          i = 0;
          if (i < paramConfig.content_list.size())
          {
            Object localObject1 = ((String)paramConfig.content_list.get(i)).trim();
            if (QLog.isColorLevel()) {
              QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 73,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
            }
            int j = paramConfig.version.get();
            if ((j != aqmj.bi(localQQAppInterface.getApp())) || (paramConfig.content_list.size() > 0))
            {
              Object localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject1).getBytes("utf-8")));
              localObject1 = (Element)((Document)localObject2).getElementsByTagName("kandian_setting").item(0);
              localObject2 = (Element)((Document)localObject2).getElementsByTagName("url").item(0);
              localObject1 = ((Element)localObject1).getFirstChild().getNodeValue();
              localObject2 = ((Element)localObject2).getFirstChild().getNodeValue();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                aqmj.k(localQQAppInterface.getApp(), (String)localObject2, "1".equals(localObject1));
              }
              aqmj.aI(localQQAppInterface.getApp(), j);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("SPLASH_ConfigServlet", 2, "received READINJOY_FOLDER_SETTING_CMD IGNORE THIS ACTION  because of SAME VERSION");
            }
          }
        }
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received readinjoy folder setting config error,cmd : 73");
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 73,content_list is empty ,version: " + paramConfig.version.get());
      return;
      i += 1;
    }
  }
  
  protected void n(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        amjm localamjm = (amjm)paramQQAppInterface.getManager(222);
        if ((paramConfig != null) && (paramConfig.type.get() == 190)) {
          if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
          {
            i = 0;
            if (i < paramConfig.msg_content_list.size())
            {
              Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
              if (localObject1 == null) {
                break label382;
              }
              if (((ConfigurationService.Content)localObject1).compress.get() == 1)
              {
                byte[] arrayOfByte = akrf.inflateConfigString(((ConfigurationService.Content)localObject1).content.get().toByteArray());
                if (arrayOfByte == null) {
                  break label460;
                }
                try
                {
                  localObject1 = new String(arrayOfByte, "UTF-8");
                  if (localObject1 == null) {
                    break label466;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "receiveAllConfigs|type: 190,content: " + (String)localObject1 + ",version: " + paramConfig.version.get());
                  }
                  int j = paramConfig.version.get();
                  if ((j == aqmj.i(paramQQAppInterface.getApp(), "search_function_config_version", mCurUin)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
                    continue;
                  }
                  localamjm.PI(new JSONObject((String)localObject1).optString("kFTSFunctionListUrlKey"));
                  aqmj.g(paramQQAppInterface.getApp(), "search_function_config_version", mCurUin, j);
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  if (!QLog.isColorLevel()) {
                    break label473;
                  }
                  localUnsupportedEncodingException.printStackTrace();
                  break label473;
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  if (QLog.isColorLevel()) {
                    localOutOfMemoryError.printStackTrace();
                  }
                  System.gc();
                  try
                  {
                    String str = new String(arrayOfByte, "UTF-8");
                  }
                  catch (Throwable localThrowable)
                  {
                    localObject2 = null;
                  }
                  continue;
                }
              }
              else
              {
                localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label466;
              }
              QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "received SEARCH_FUNCTION_MODULE_CONFIG IGNORE THIS ACTION  because of SAME VERSION ");
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "received search function module error,cmd : 190" + paramQQAppInterface.toString());
        }
      }
      label382:
      do
      {
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, "handleFunctionModuleConfig, content is null");
        break;
      } while (!QLog.isColorLevel());
      Object localObject2 = new StringBuilder().append("receiveAllConfigs|type: 190,msg_content_list is empty ,version: ");
      if (paramConfig != null) {}
      for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
      {
        QLog.d("SPLASH_ConfigServletQ.uniteSearch.tag_search_function_module", 2, paramQQAppInterface);
        return;
      }
      label460:
      localObject2 = null;
      continue;
      label466:
      i += 1;
      continue;
      label473:
      localObject2 = null;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    boolean bool = paramFromServiceMsg.isSuccess();
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {}
    for (;;)
    {
      return;
      int i;
      if (QLog.isColorLevel())
      {
        i = 0;
        while (i < arrayOfInt.length)
        {
          QLog.i("SPLASH_ConfigServlet", 2, "onReceive|shouldReceive cmd: " + arrayOfInt[i] + ",length: " + arrayOfInt.length);
          i += 1;
        }
      }
      Object localObject = paramFromServiceMsg.getWupBuffer();
      if ((localObject == null) || (localObject.length < 4))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "wup buf is null!!!");
        }
        aevn.a("0", arrayOfInt, paramFromServiceMsg.getResultCode());
        anmi.a(arrayOfInt, paramFromServiceMsg);
        int k = arrayOfInt.length;
        i = j;
        while (i < k)
        {
          if (arrayOfInt[i] == 215)
          {
            ShortVideoResourceManager.UM(-5);
            axiy.e("SPLASH_ConfigServlet", "【SHORT_VIDEO_RESOURCE_CONFIG】RES_OVERTIME");
          }
          i += 1;
        }
      }
      else
      {
        paramFromServiceMsg.putWupBuffer(o((byte[])localObject));
        localObject = new ConfigurationService.RespGetConfig();
        try
        {
          ((ConfigurationService.RespGetConfig)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
          try
          {
            tns.zz(((ConfigurationService.RespGetConfig)localObject).min_req_interval_for_reconnect.get());
            a((ConfigurationService.RespGetConfig)localObject, localQQAppInterface, paramIntent, arrayOfInt, bool);
            return;
          }
          catch (Exception paramIntent) {}
          if (QLog.isColorLevel())
          {
            QLog.w("SPLASH_ConfigServlet", 2, paramIntent.toString());
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "error: " + paramIntent.toString());
          }
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int[] arrayOfInt = paramIntent.getIntArrayExtra("k_cmd_type");
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      int i = 0;
      while (i < arrayOfInt.length)
      {
        QLog.i("SPLASH_ConfigServlet", 2, "onSend. cmd: " + arrayOfInt[i] + ",length: " + arrayOfInt.length);
        i += 1;
      }
    }
    a(localQQAppInterface, paramIntent, arrayOfInt, paramPacket);
  }
  
  public void u(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig|type= " + paramConfig.type.get());
    }
    if (paramConfig != null) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        if (paramConfig.type.get() != 146) {
          break label283;
        }
        if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() <= 0)) {
          break label345;
        }
        Object localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (localObject1 != null)
        {
          if (((ConfigurationService.Content)localObject1).compress.get() == 1)
          {
            byte[] arrayOfByte = akrf.inflateConfigString(((ConfigurationService.Content)localObject1).content.get().toByteArray());
            if (arrayOfByte == null) {
              break label340;
            }
            try
            {
              localObject1 = new String(arrayOfByte, "UTF-8");
              if (localObject1 == null) {
                break label345;
              }
              if (QLog.isColorLevel()) {
                QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, config_content is " + (String)localObject1);
              }
              ajol.s(paramQQAppInterface, (String)localObject1, paramConfig.version.get());
              return;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              if (!QLog.isColorLevel()) {
                break label346;
              }
              localUnsupportedEncodingException.printStackTrace();
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              if (QLog.isColorLevel()) {
                localOutOfMemoryError.printStackTrace();
              }
              System.gc();
              try
              {
                String str = new String(arrayOfByte, "UTF-8");
              }
              catch (Throwable localThrowable)
              {
                localObject2 = null;
              }
              continue;
            }
          }
          localObject2 = ((ConfigurationService.Content)localObject2).content.get().toStringUtf8();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label345;
        }
        QLog.d("HotFriend_SPLASH_ConfigServlet", 2, "handleRespGetHotDaysConfig, content is null");
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label345;
        }
      }
      QLog.e("HotFriend_SPLASH_ConfigServlet", 2, paramQQAppInterface.toString());
      return;
      label283:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("content_list is empty ,version: ");
        if (paramConfig != null) {}
        for (paramQQAppInterface = Integer.valueOf(paramConfig.version.get());; paramQQAppInterface = "")
        {
          QLog.d("HotFriend_SPLASH_ConfigServlet", 2, paramQQAppInterface);
          return;
        }
        label340:
        localObject2 = null;
      }
      else
      {
        label345:
        return;
        label346:
        localObject2 = null;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract int Bs();
    
    public abstract void Mi(int paramInt);
    
    public abstract void jO(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevk
 * JD-Core Version:    0.7.0.1
 */