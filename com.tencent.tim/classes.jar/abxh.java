import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils.1;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils.2;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class abxh
{
  public static JSONArray H;
  public static long OP;
  public static boolean bGc = true;
  public static boolean bGd;
  public static boolean bGe;
  public static boolean bGf;
  public static boolean bGg;
  public static String bil;
  public static JSONObject bk;
  public static JSONObject bl;
  public static JSONObject bm;
  public static JSONObject bn;
  public static JSONObject bo;
  private static JSONObject bp;
  public static int ctr;
  public static int cts;
  public static ArrayList<Integer> sO = new ArrayList();
  public static ArrayList<Integer> sP = new ArrayList();
  public static ArrayList<Integer> sQ = new ArrayList();
  public static ArrayList<Integer> sR = new ArrayList();
  
  public static void CX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      abxi.bju = iT(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloConfigUtils", 2, "sApolloStoreUrl = " + abxi.bju);
  }
  
  public static void G(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramQQAppInterface = new JSONObject(paramString);
        if (!paramQQAppInterface.has("traceConfig")) {
          continue;
        }
        sR.clear();
        paramQQAppInterface = paramQQAppInterface.optJSONObject("traceConfig").optJSONArray("featureList");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 0)) {
          continue;
        }
        int i = 0;
        if (i >= paramQQAppInterface.length()) {
          continue;
        }
        paramString = paramQQAppInterface.optJSONObject(i);
        int k = paramString.optInt("featureId");
        if (paramString.optInt("isFocus") == 1) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            sR.add(Integer.valueOf(k));
          }
          i += 1;
          break;
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloConfigUtils", 1, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void H(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloConfigUtils", 1, "parsePreDownloadConfig content is null");
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      JSONObject localJSONObject2;
      ApolloPreDownloadData localApolloPreDownloadData;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("preDownLoadRes");
        if (paramString == null) {
          break;
        }
        localHashMap = new HashMap();
        if (i >= paramString.length()) {
          break label350;
        }
        JSONObject localJSONObject1 = paramString.optJSONObject(i);
        localJSONObject2 = localJSONObject1.optJSONObject("android");
        if (localJSONObject2 == null) {
          break label377;
        }
        localApolloPreDownloadData = new ApolloPreDownloadData();
        localApolloPreDownloadData.reportId = localJSONObject1.optString("reportId");
        localApolloPreDownloadData.url = localJSONObject1.optString("url");
        if (TextUtils.isEmpty(localApolloPreDownloadData.url))
        {
          QLog.e("ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig url is null, reportId:", localApolloPreDownloadData.reportId });
        }
        else
        {
          localApolloPreDownloadData.resId = aszr.getMD5String(localApolloPreDownloadData.url);
          localApolloPreDownloadData.md5 = localJSONObject1.optString("md5");
          localApolloPreDownloadData.version = localJSONObject1.optInt("version");
          localApolloPreDownloadData.minVer = localJSONObject1.optString("minQQVer");
          localApolloPreDownloadData.maxVer = localJSONObject1.optString("maxQQVer");
          localApolloPreDownloadData.endTime = localJSONObject1.optLong("endTime");
          if ((!TextUtils.isEmpty(localApolloPreDownloadData.minVer)) && (!TextUtils.isEmpty(localApolloPreDownloadData.maxVer)) && (!l("3.4.4", localApolloPreDownloadData.minVer, localApolloPreDownloadData.maxVer))) {
            QLog.e("ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig ver is not correct, url:", localApolloPreDownloadData.url });
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloConfigUtils", 1, "parsePreDownloadConfig e:", paramQQAppInterface);
        return;
      }
      localApolloPreDownloadData.dir = localJSONObject2.optString("dir");
      localApolloPreDownloadData.zipDir = localJSONObject2.optString("zipDir");
      localApolloPreDownloadData.dirType = localJSONObject2.optInt("dirType");
      localHashMap.put(localApolloPreDownloadData.resId, localApolloPreDownloadData);
      break label377;
      label350:
      if (localHashMap.size() <= 0) {
        break;
      }
      ThreadManager.excute(new ApolloConfigUtils.2(paramQQAppInterface, localHashMap), 160, null, true);
      return;
      label377:
      i += 1;
    }
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApplication() == null) || (TextUtils.isEmpty(paramString))) {}
    Object localObject2;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      return;
      try
      {
        localObject2 = paramQQAppInterface.getApplication();
        localObject1 = new JSONObject(paramString);
        if (localObject1 != null)
        {
          paramString = ((JSONObject)localObject1).optString("apolloSwitch");
          aqmj.aE((Context)localObject2, Integer.parseInt(paramString));
          localObject3 = ((JSONObject)localObject1).optString("apollo3dSwitch");
          QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] apolloSwitch=", paramString, ", apollo3dSwitch=", localObject3 });
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label270;
          }
          aqmj.aF((Context)localObject2, Integer.parseInt((String)localObject3));
        }
      }
      catch (Exception paramString)
      {
        try
        {
          j = paramString.length;
          i = 0;
          while (i < j)
          {
            localObject3 = paramString[i];
            sP.add(Integer.valueOf(Integer.parseInt((String)localObject3)));
            i += 1;
          }
          aqmj.aF((Context)localObject2, 0);
        }
        catch (Exception paramString)
        {
          QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] parse game id error, e=", paramString);
        }
        paramString = paramString;
        QLog.e("ApolloConfigUtils", 1, "aplloConfig parse json exception = " + paramString);
        return;
      }
    }
    if (((JSONObject)localObject1).has("default")) {}
    int i;
    int j;
    label270:
    for (paramString = ((JSONObject)localObject1).optJSONObject("default").optJSONObject("rules");; paramString = ((JSONObject)localObject1).optJSONObject("rules"))
    {
      bk = paramString;
      if (!((JSONObject)localObject1).has("switchSet")) {
        break label797;
      }
      bl = ((JSONObject)localObject1).optJSONObject("switchSet");
      if (bl == null) {
        break label903;
      }
      paramString = bl.optString("gameMenuBlackList");
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] gameMenuBlackListStr=", paramString });
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      paramString = paramString.split("\\|");
      if (paramString == null) {
        break;
      }
      i = paramString.length;
      if (i <= 0) {
        break;
      }
    }
    boolean bool;
    if (bl.optInt("traceReportSwitch", 1) == 1)
    {
      bool = true;
      bGc = bool;
      if (bl.optInt("disablePreLoadEngineSwitch_V3", 0) != 1) {
        break label732;
      }
      bool = true;
      label369:
      bGd = bool;
      if (bl.optInt("disablePipeLog_V3", 0) != 1) {
        break label738;
      }
      bool = true;
      label391:
      ApolloEngine.Dz(bool);
      if (bl.optInt("disableSettingMeDestroySwitch", 0) != 1) {
        break label744;
      }
      bool = true;
      label413:
      bGe = bool;
      cts = bl.optInt("disableSettingMeDestroyTimeOut", 0);
      if (bl.optInt("disablePreLoadcm3DSwitch_V3") != 1) {
        break label750;
      }
      bool = true;
      label447:
      bGf = bool;
      OP = bl.optLong("gameConnHeartbeatInterval");
      if (bl.optInt("enableGL3_0", 1) != 1) {
        break label756;
      }
      bool = true;
      label481:
      bGg = bool;
      if (bl.optInt("disableCreateRenderThread", 0) != 1) {
        break label762;
      }
      bool = true;
      label503:
      abhh.bCR = bool;
      if (bl.optInt("apolloEngineLockEnable_V3", 0) != 1) {
        break label768;
      }
      bool = true;
      label525:
      abhh.bCS = bool;
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sSwitchSet=", bl.toString() });
      long l = bl.optLong("store_page_load_timeout_value");
      if (l <= 0L) {
        break label774;
      }
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
      paramString.putLong("SP_KEY_APOLLO_STORE_PAGE_LOAD_TIMEOUT_VALUE", l);
      paramString.apply();
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sStorePageLoadTimeoutValue=", Long.valueOf(l) });
    }
    for (;;)
    {
      for (;;)
      {
        paramString = bl.optString("transparentGameList");
        QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] transparentGameListStr=", paramString });
        if (TextUtils.isEmpty(paramString)) {
          break label797;
        }
        paramString = paramString.split("\\|");
        if (paramString == null) {
          break label797;
        }
        i = paramString.length;
        if (i <= 0) {
          break label797;
        }
        label768:
        label774:
        try
        {
          j = paramString.length;
          i = 0;
          while (i < j)
          {
            localObject3 = paramString[i];
            sQ.add(Integer.valueOf(Integer.parseInt((String)localObject3)));
            i += 1;
          }
          bool = false;
        }
        catch (Exception paramString)
        {
          label732:
          label738:
          label744:
          label750:
          label756:
          label762:
          QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] parse trans game id error, e=", paramString);
        }
      }
      bool = false;
      break label369;
      bool = false;
      break label391;
      bool = false;
      break label413;
      bool = false;
      break label447;
      bool = false;
      break label481;
      bool = false;
      break label503;
      bool = false;
      break label525;
      QLog.d("ApolloConfigUtils", 1, "[parseConfigJson] sStorePageLoadTimeoutValue from config not > 0, use default value. ");
    }
    label797:
    if (((JSONObject)localObject1).has("errorAction"))
    {
      paramString = ((JSONObject)localObject1).optString("errorAction");
      if (!TextUtils.isEmpty(paramString))
      {
        localObject3 = paramString.split(",");
        if (localObject3 != null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < paramString.length())
      {
        sO.add(Integer.valueOf(Integer.parseInt(localObject3[i])));
        if (!QLog.isColorLevel()) {
          break label1473;
        }
        QLog.d("ApolloConfigUtils", 2, "errorAction =" + localObject3[i]);
        break label1473;
        label903:
        QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] sSwitchSet null");
        break label797;
      }
      if (((JSONObject)localObject1).has("shopUrl"))
      {
        paramString = ((JSONObject)localObject1).optJSONArray("shopUrl");
        if (paramString != null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < paramString.length())
        {
          localObject3 = paramString.getJSONObject(i);
          if (!l("3.4.4", ((JSONObject)localObject3).optString("minVersion"), ((JSONObject)localObject3).optString("maxVersion"))) {
            break label1466;
          }
          localObject3 = ((JSONObject)localObject3).optString("url");
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label1466;
          }
          CX((String)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloConfigUtils", 2, "localversion target.url=" + (String)localObject3);
          }
        }
        if (((JSONObject)localObject1).has("urlConfig")) {
          b(((JSONObject)localObject1).optJSONObject("urlConfig"), paramBoolean);
        }
        if (((JSONObject)localObject1).has("freqConfig"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("freqConfig");
          if (paramString != null)
          {
            i = paramString.optInt("drawerBubble", 3);
            j = paramString.optInt("aioBubble", 3);
            localObject2 = ((Context)localObject2).getSharedPreferences("apollo_sp", 0);
            ((SharedPreferences)localObject2).edit().putInt("bubble_max_count", i);
            ((SharedPreferences)localObject2).edit().putInt("sp_key_aio_bubble_max_count", j);
            ((SharedPreferences)localObject2).edit().commit();
            i = paramString.optInt("foregroundEvent") * 1000 * 60;
            if (kds.aIc < i) {
              kds.aIc = i;
            }
          }
        }
        if (((JSONObject)localObject1).has("avConfig"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("avConfig");
          if (localObject2 != null)
          {
            paramString = ((JSONObject)localObject2).optString("url");
            localObject2 = ((JSONObject)localObject2).optString("md5");
            if (!TextUtils.isEmpty(paramString)) {
              abxi.bjs = paramString;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              abxi.bjt = (String)localObject2;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, "gameAVSOUrl =" + paramString + ", md5=" + (String)localObject2);
            }
          }
        }
        if (((JSONObject)localObject1).has("gameConfig"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("gameConfig");
          if ((paramString != null) && (paramString.has("aio")))
          {
            localObject3 = paramString.getJSONObject("aio");
            paramString = ((JSONObject)localObject3).optString("aioPanelTip");
            localObject1 = ((JSONObject)localObject3).optString("gamePanelTip");
            localObject2 = ((JSONObject)localObject3).optString("gamePanelBg");
            localObject3 = ((JSONObject)localObject3).optString("gamePanelBgColor");
            if (!TextUtils.isEmpty(paramString)) {
              abxi.bjP = paramString;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              abxi.bjQ = (String)localObject1;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              abxi.bjR = ((String)localObject2).trim();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              abxi.bjS = ((String)localObject3).trim();
            }
          }
        }
        if (abhh.ch.get()) {
          break;
        }
        paramString = (abhh)paramQQAppInterface.getManager(153);
        abhh.ch.set(true);
        paramString.cBP();
        return;
        label1466:
        i += 1;
      }
      label1473:
      i += 1;
    }
  }
  
  public static void b(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
        if (localJSONArray != null)
        {
          i = 0;
          localObject1 = "3.4.4";
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            String str1 = localJSONObject.optString("minVersion");
            String str2 = localJSONObject.optString("maxVersion");
            localObject3 = localJSONObject.optString("androidUrl");
            Object localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = localJSONObject.optString("url");
            }
            if (l("3.4.4", str1, str2))
            {
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                abxi.bjG = (String)localObject2;
                abxi.bjH = localJSONObject.optString("id");
                abxi.bjI = abxi.bim + "/script/" + abxi.bjH + "/";
                if (paramBoolean)
                {
                  localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
                  ((SharedPreferences)localObject3).edit().putString("sp_key_config_script", paramJSONObject.toString());
                  ((SharedPreferences)localObject3).edit().commit();
                }
              }
              localObject3 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloConfigUtils", 2, new Object[] { "parseBaseScriptConfig: localversion target.url=" + (String)localObject2, ",scriptId:", abxi.bjH, ",isUpdate:", Boolean.valueOf(paramBoolean) });
                localObject3 = localObject1;
              }
            }
            else
            {
              localObject3 = localObject1;
              if (q("3.4.4", str1) < 0)
              {
                localObject3 = localObject1;
                if (q((String)localObject1, str1) < 0)
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    abxi.bjJ = (String)localObject2;
                    abxi.bjK = localJSONObject.optString("id");
                    abxi.bjL = abxi.bim + "/script/" + abxi.bjK + "/";
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloConfigUtils", 2, "parseBaseScriptConfig: newestMinVersion=" + str1 + " target.url=" + (String)localObject2 + ", id=" + abxi.bjK);
                  }
                  localObject3 = str1;
                }
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.d("ApolloConfigUtils", 1, paramString + " parse configUrl error e=" + paramJSONObject.toString());
      }
      return;
      i += 1;
      Object localObject1 = localObject3;
    }
  }
  
  public static void b(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject != null)
    {
      j(paramJSONObject, "mall");
      j(paramJSONObject, "new_mall");
      j(paramJSONObject, "interact");
      j(paramJSONObject, "game_rank");
      j(paramJSONObject, "game_life");
      j(paramJSONObject, "coin");
      j(paramJSONObject, "my_card");
      j(paramJSONObject, "my_card_detail");
      j(paramJSONObject, "crystal");
      j(paramJSONObject, "production");
      j(paramJSONObject, "game_manage");
      j(paramJSONObject, "game_center");
      j(paramJSONObject, "new_interact");
      j(paramJSONObject, "game_city");
      j(paramJSONObject, "apollo_drawer_game_box_lottie");
      j(paramJSONObject, "apollo_plus_url");
      j(paramJSONObject, "3d_mall");
      j(paramJSONObject, "3d_interact");
      j(paramJSONObject, "3d_game_city");
      j(paramJSONObject, "2d_3available_interact");
      b(paramJSONObject, "base_script", paramBoolean);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        QLog.d("ApolloConfigUtils", 1, new Object[] { "parseUrlGrayConfigJson, isUpdate:", Boolean.valueOf(paramBoolean), ",content:", paramString });
        paramQQAppInterface = new JSONObject(paramString);
        if (paramQQAppInterface.has("grayUrlConfig"))
        {
          b(paramQQAppInterface.optJSONObject("grayUrlConfig"), paramBoolean);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloConfigUtils", 1, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloConfigUtils", 1, "parseGameConfigJson content is null");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        bm = localJSONObject1.optJSONObject("aioGameTab");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("moreGameConfig");
        bn = localJSONObject1.optJSONObject("gameAudioConfig");
        bo = localJSONObject1.optJSONObject("plusPanelGameConfig");
        H = localJSONObject1.optJSONArray("quickTipsConfig");
        abmi.p(H);
        ctr = localJSONObject1.optInt("gameMinTimeOut");
        bil = localJSONObject1.optString("notFullScreenModelList");
        bp = localJSONObject1.optJSONObject("textureViewConfig");
        abhh.aI(bp);
        if (paramBoolean)
        {
          QLog.e("ApolloConfigUtils", 1, "parseGameConfigJson online get update");
          ThreadManager.excute(new ApolloConfigUtils.1(paramQQAppInterface), 32, null, true);
        }
        if (localJSONObject2 != null)
        {
          ablf.ao("aio.enter.bg", localJSONObject2.optString("entranceBkgUrl"));
          paramString = localJSONObject2.optString("entranceUrl_Android_general");
          paramBoolean = ApolloGameUtil.Z(paramQQAppInterface);
          if (paramBoolean)
          {
            paramString = localJSONObject2.optString("entranceUrl_Android");
            String str = localJSONObject2.optString("entranceUrl_Android_3d");
            if ((ApolloGameUtil.aa(paramQQAppInterface)) && (!TextUtils.isEmpty(str))) {
              paramString = str;
            }
          }
          else
          {
            paramQQAppInterface = paramString;
            if (TextUtils.isEmpty(paramString)) {
              paramQQAppInterface = localJSONObject2.optString("entranceUrl");
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, new Object[] { "parseGameConfigJson enter:", paramQQAppInterface, ",isOpenCmShow:", Boolean.valueOf(paramBoolean) });
            }
            ablf.ao("aio.enter", paramQQAppInterface);
            ablf.ao("aio.enter.name", localJSONObject2.optString("entranceName"));
          }
        }
        else
        {
          paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("apollo_sp", 0).edit();
          if (localJSONObject1.has("freqConfig"))
          {
            paramString = localJSONObject1.optJSONObject("freqConfig");
            if (paramString != null) {
              paramQQAppInterface.putInt("sp_key_exit_game_guide_count_limit", paramString.optInt("exitGuideCount", 1));
            }
          }
          if (localJSONObject1.has("switchSet"))
          {
            paramString = localJSONObject1.optJSONObject("switchSet");
            if (paramString != null) {
              paramQQAppInterface.putInt("sp_key_exit_show_game_box_guide", paramString.optInt("gameBoxGuideSwitch"));
            }
          }
          paramQQAppInterface.apply();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloConfigUtils", 1, "Exception:", paramQQAppInterface);
        return;
      }
    }
  }
  
  public static void eB(String paramString1, String paramString2)
  {
    if ("mall".equals(paramString1)) {
      CX(paramString2);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return;
                                  if (!"interact".equals(paramString1)) {
                                    break;
                                  }
                                } while (TextUtils.isEmpty(paramString2));
                                abxi.bjv = iT(paramString2);
                              } while (!QLog.isColorLevel());
                              QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloStoreInteractUrl=", abxi.bjv });
                              return;
                              if ("game_rank".equals(paramString1))
                              {
                                abxi.bjk = paramString2;
                                return;
                              }
                              if ("game_life".equals(paramString1))
                              {
                                abxi.bjl = paramString2;
                                return;
                              }
                              if ("coin".equals(paramString1))
                              {
                                abxi.bjm = paramString2;
                                return;
                              }
                              if ("my_card".equals(paramString1))
                              {
                                abxi.bjn = paramString2;
                                return;
                              }
                              if ("crystal".equals(paramString1))
                              {
                                abxi.bjp = paramString2;
                                return;
                              }
                              if ("production".equals(paramString1))
                              {
                                abxi.bjq = paramString2;
                                return;
                              }
                              if ("game_manage".equals(paramString1))
                              {
                                abxi.bjr = paramString2;
                                return;
                              }
                              if ("my_card_detail".equals(paramString1))
                              {
                                abxi.bjo = paramString2;
                                return;
                              }
                              if (!"new_mall".equals(paramString1)) {
                                break;
                              }
                            } while (TextUtils.isEmpty(paramString2));
                            abxi.bjw = iT(paramString2);
                          } while (!QLog.isColorLevel());
                          QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewStoreUrl=", abxi.bjw });
                          return;
                          if (!"game_center".equals(paramString1)) {
                            break;
                          }
                        } while (TextUtils.isEmpty(paramString2));
                        abxi.bjx = iT(paramString2);
                      } while (!QLog.isColorLevel());
                      QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCenterUrl=", abxi.bjx });
                      return;
                      if (!"new_interact".equals(paramString1)) {
                        break;
                      }
                    } while (TextUtils.isEmpty(paramString2));
                    abxi.bjy = iT(paramString2);
                  } while (!QLog.isColorLevel());
                  QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewInteractUrl=", abxi.bjy });
                  return;
                  if (!"game_city".equals(paramString1)) {
                    break;
                  }
                } while (TextUtils.isEmpty(paramString2));
                abxi.bjz = iT(paramString2);
              } while (!QLog.isColorLevel());
              QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCityUrl=", abxi.bjz });
              return;
              if ("apollo_drawer_game_box_lottie".equals(paramString1))
              {
                abxi.bjE = paramString2;
                return;
              }
              if (!"apollo_plus_url".equals(paramString1)) {
                break;
              }
            } while (TextUtils.isEmpty(paramString2));
            abxi.bjF = paramString2;
            return;
            if (!"3d_mall".equals(paramString1)) {
              break;
            }
          } while (TextUtils.isEmpty(paramString2));
          abxi.bjA = iT(paramString2);
          return;
          if (!"3d_interact".equals(paramString1)) {
            break;
          }
        } while (TextUtils.isEmpty(paramString2));
        abxi.bjB = iT(paramString2);
        return;
        if (!"3d_game_city".equals(paramString1)) {
          break;
        }
      } while (TextUtils.isEmpty(paramString2));
      abxi.bjC = iT(paramString2);
      return;
    } while ((!"2d_3available_interact".equals(paramString1)) || (TextUtils.isEmpty(paramString2)));
    abxi.bjD = iT(paramString2);
  }
  
  protected static String iT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("[client]", "androidQQ").replace("[version]", "3.4.4.3058").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
  }
  
  public static void j(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray(paramString);
        if (paramJSONObject != null)
        {
          i = 0;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            if (!l("3.4.4", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion"))) {
              continue;
            }
            String str = localJSONObject.optString("androidUrl");
            paramJSONObject = str;
            if (TextUtils.isEmpty(str)) {
              paramJSONObject = localJSONObject.optString("url");
            }
            eB(paramString, paramJSONObject);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, paramString + " localversion target.url=" + paramJSONObject);
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloConfigUtils", 2, paramString + " parse configUrl error e=" + paramJSONObject.toString());
      }
      i += 1;
    }
  }
  
  public static boolean l(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          if ((q(paramString1, paramString2) >= 0) && (q(paramString1, paramString3) <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, "localversion target. min=" + paramString2 + ",local =" + paramString1 + ",max=" + paramString3);
            }
            return true;
          }
        }
        catch (Throwable paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloConfigUtils", 2, paramString1.toString());
    return false;
  }
  
  public static int q(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return -2;
    }
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return 1;
    }
    paramString1 = paramString1.trim();
    paramString2 = paramString2.trim();
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    if ((paramString1.length <= 0) || (paramString2.length <= 0)) {
      return -2;
    }
    paramString1 = new ArrayList(Arrays.asList(paramString1));
    paramString2 = new ArrayList(Arrays.asList(paramString2));
    int i;
    int j;
    int k;
    for (;;)
    {
      try
      {
        i = paramString1.size() - 1;
        if ((i < 0) || (Integer.parseInt((String)paramString1.get(i)) != 0))
        {
          i = paramString2.size() - 1;
          if (i < 0) {
            break label320;
          }
          if (Integer.parseInt((String)paramString2.get(i)) != 0)
          {
            break label320;
            if (i >= paramString1.size()) {
              continue;
            }
            j = Integer.parseInt((String)paramString1.get(i));
            if (paramString2.size() >= i + 1) {
              continue;
            }
            return 1;
          }
        }
        else
        {
          paramString1.remove(i);
          i -= 1;
          continue;
        }
        paramString2.remove(i);
        i -= 1;
        continue;
        k = Integer.parseInt((String)paramString2.get(i));
        if (j <= k) {
          break;
        }
        return 1;
        i = paramString2.size();
        j = paramString1.size();
        if (i > j) {
          return -1;
        }
        return 0;
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloConfigUtils", 1, "compareVersion fail e:" + paramString1.toString());
        return -2;
      }
      label320:
      i = 0;
    }
    if (j == k) {}
    while (j >= k)
    {
      i += 1;
      break;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxh
 * JD-Core Version:    0.7.0.1
 */