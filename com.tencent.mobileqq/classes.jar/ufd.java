import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.15;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.26;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ufd
  extends WebViewPlugin
{
  static HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  static Map<String, ArrayList<String>> jdField_a_of_type_JavaUtilMap;
  public static HashMap<String, String> b;
  static Map<String, ArrayList<String>> jdField_b_of_type_JavaUtilMap;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String l;
  public int a;
  public Activity a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  public Handler a;
  bjnw jdField_a_of_type_Bjnw;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  String jdField_a_of_type_JavaLangString;
  ArrayList<uge> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public rxk a;
  set jdField_a_of_type_Set = null;
  ufa jdField_a_of_type_Ufa;
  zon jdField_a_of_type_Zon = null;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  String jdField_b_of_type_JavaLangString;
  ArrayList<ugd> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  int c;
  int d;
  public int e;
  public int f;
  String k = "";
  String m;
  public String n = "";
  public String o = "";
  public String p = "";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), "publicAccountNew.getPicture");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "troopNotice.showPicture");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), "qbizApi.getNetworkType");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "ui.closeWebViews");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), "ui.setOnShareQQFriendHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), "ui.setOnShareQZoneHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), "ui.setOnShareWXFriendHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), "ui.setOnShareWXTimelineHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(8), "publicAccount.getLocation");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), "publicAccountNew.hideMenuItems");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), "publicAccountNew.showMenuItems");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), "publicAccountNew.hideAllNonBaseMenuItem");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(13), "publicAccountNew.showAllNonBaseMenuItem");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(14), "publicAccountNew.showWebPanel");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(15), "publicAccountNew.scanQRCode");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(16), "publicAccountNew.setRightButtonState");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(17), "publicAccountNew.uploadImage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(18), "publicAccountNew.downloadImage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(20), "publicAccountNew.hideWebToolbar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(21), "publicAccountNew.showWebToolbar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(30), "wallet.publicPay");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(40), "publicAccountNew.startRecord");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(41), "publicAccountNew.stopRecord");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(42), "publicAccountNew.playVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(43), "publicAccountNew.pauseVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(44), "publicAccountNew.stopVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(45), "publicAccountNew.uploadVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(46), "publicAccountNew.downloadVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(47), "publicAccountNew.onVoiceRecordEnd");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(48), "publicAccountNew.onVoicePlayEnd");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(49), "publicAccountNew.selectAndUploadAvatar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(50), "publicAccountNew.addPreDownloadVideo");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(51), "publicAccountNew.stopPreDownloadVideo");
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ufd()
  {
    this.jdField_a_of_type_Int = 1281;
    this.jdField_b_of_type_Int = 1282;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Rxk = null;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new ufe(this);
    this.mPluginNameSpace = "publicAccountNew";
  }
  
  public static WebResourceResponse a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = (String)jdField_b_of_type_JavaUtilHashMap.get(paramString);
        if (paramString == null) {
          return null;
        }
        paramString = npt.a(SafeBitmapFactory.decodeFile(paramString));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/png", "UTF-8", paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  public static String a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    int i1 = 0;
    JSONObject localJSONObject1 = new JSONObject();
    if (paramReadInJoyUserInfo != null) {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("accountType", Integer.valueOf(paramReadInJoyUserInfo.accountType));
        localJSONObject2.putOpt("uin", paramReadInJoyUserInfo.uin);
        localJSONObject1.putOpt("accountInfo", localJSONObject2);
        localJSONObject1.putOpt("nickName", paramReadInJoyUserInfo.nick);
        localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("faceType", Integer.valueOf(paramReadInJoyUserInfo.faceType));
        localJSONObject2.putOpt("timeStamp", Long.valueOf(paramReadInJoyUserInfo.timestamp));
        localJSONObject2.putOpt("faceFlag", Integer.valueOf(paramReadInJoyUserInfo.faceFlag));
        localJSONObject2.putOpt("url", ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
        localJSONObject2.putOpt("sysID", Integer.valueOf(paramReadInJoyUserInfo.systemID));
        localJSONObject1.putOpt("headerInfo", localJSONObject2);
        localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("ccLevel", Integer.valueOf(paramReadInJoyUserInfo.accountLevel));
        localJSONObject2.putOpt("iconUrlSmall", paramReadInJoyUserInfo.smallIconUrl);
        localJSONObject2.putOpt("iconUrlLarge", paramReadInJoyUserInfo.largeIconUrl);
        localJSONObject1.putOpt("accountLevelInfo", localJSONObject2);
        localJSONObject2 = new JSONObject();
        if (paramReadInJoyUserInfo.isLiving()) {
          i1 = 1;
        }
        localJSONObject2.putOpt("isLiving", Integer.valueOf(i1));
        localJSONObject2.putOpt("source", Integer.valueOf(paramReadInJoyUserInfo.getLiveSource()));
        localJSONObject2.putOpt("url", paramReadInJoyUserInfo.getLiveUrl());
        localJSONObject1.putOpt("liveStatusInfo", localJSONObject2);
        localJSONObject1.putOpt("retCode", Integer.valueOf(0));
        localJSONObject1.putOpt("retMsg", "");
        paramReadInJoyUserInfo = localJSONObject1.toString();
        return paramReadInJoyUserInfo;
      }
      catch (Exception paramReadInJoyUserInfo)
      {
        QLog.e("PublicAccountH5AbilityPlugin", 1, paramReadInJoyUserInfo.getMessage());
      }
    }
    try
    {
      localJSONObject1.putOpt("retCode", Integer.valueOf(-1));
      localJSONObject1.putOpt("retMsg", paramReadInJoyUserInfo.getMessage());
      return localJSONObject1.toString();
    }
    catch (Exception paramReadInJoyUserInfo)
    {
      for (;;)
      {
        QLog.e("PublicAccountH5AbilityPlugin", 1, paramReadInJoyUserInfo.getMessage());
      }
    }
  }
  
  public static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("retCode", Integer.valueOf(-1));
      localJSONObject.putOpt("retMsg", paramString);
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.d("PublicAccountH5AbilityPlugin", 1, paramString.getMessage());
      }
    }
  }
  
  public static void a(long paramLong, tiv paramtiv, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_get_user_info_action", localBundle, new ufi(paramtiv, paramString));
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {}
    String str2;
    do
    {
      return;
      str2 = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str2));
    int i1 = paramIntent.getIntExtra("result_code", -1);
    if (i1 == 0) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PublicAccountH5AbilityPlugin.15(this), 200L);
    }
    String str1 = "";
    if (paramIntent.hasExtra("result_msg")) {
      str1 = paramIntent.getStringExtra("result_msg");
    }
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("retCode", i1);
      paramIntent.put("msg", str1);
      callJs(str2, new String[] { paramIntent.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (pay.g() >= 2)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131717351), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    paramString4 = new Bundle();
    paramString4.putString("arg_topic_id", paramString1);
    paramString4.putString("mTaskID", String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D)));
    paramString4.putString("arg_topic_id", paramString1);
    paramString4.putString("arg_topic_name", paramString2);
    paramString4.putInt("arg_ad_tag", paramInt1);
    paramString4.putString("arg_callback", paramString3);
    paramString4.putString("arg_ugc_edit_cookie", paramString8);
    oph.a(this, this.mRuntime.a(), paramString4, (byte)116);
    pay.a("2", "2");
  }
  
  private void a(String paramString, String... paramVarArgs)
  {
    int i1 = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (this.jdField_a_of_type_AndroidAppActivity != null)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountH5AbilityPlugin", 2, "selectAndInviteFriend param json:" + ((JSONObject)localObject1).toString());
        }
        paramString = ((JSONObject)localObject1).optString("rowkey", "");
        int i2 = ((JSONObject)localObject1).optInt("maxSelect");
        int i3 = ((JSONObject)localObject1).optInt("maxCount");
        paramVarArgs = ((JSONObject)localObject1).optString("callback", "");
        Object localObject2 = ((JSONObject)localObject1).optString("invitedUins", "[]");
        localObject1 = new StringBuilder();
        if ((localObject2 != null) && (((String)localObject2).trim().length() > 0))
        {
          localObject2 = new JSONArray(((String)localObject2).trim());
          if (i1 < ((JSONArray)localObject2).length())
          {
            ((StringBuilder)localObject1).append(((JSONArray)localObject2).get(i1));
            if (i1 >= ((JSONArray)localObject2).length() - 1) {
              break label339;
            }
            ((StringBuilder)localObject1).append(",");
            break label339;
          }
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("opentype", 1);
        ((Intent)localObject2).putExtra("filterUins", ((StringBuilder)localObject1).toString());
        ((Intent)localObject2).putExtra("maxSelect", i2);
        if (i3 > 0) {
          ((Intent)localObject2).putExtra("maxCount", i3);
        }
        ((Intent)localObject2).putExtra("rowkey", paramString);
        ((Intent)localObject2).putExtra("callback", paramVarArgs);
        PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, ReadInJoySelectMemberAQFragment.class, 119);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountH5AbilityPlugin", 2, "selectAndInviteFriend e = " + paramString);
        }
        paramString.printStackTrace();
        return;
      }
      label339:
      i1 += 1;
    }
  }
  
  public static void a(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i1)).equals(paramString))
        {
          paramArrayList.remove(i1);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str1 = paramJSONObject.optString("uniqueKey");
        int i1 = paramJSONObject.optInt("source", 3);
        Object localObject2 = paramJSONObject.optString("feedsID", "");
        int i2 = paramJSONObject.optInt("feedsType", -1);
        int i3 = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        String str4 = paramJSONObject.optString("sourceName", "");
        String str5 = paramJSONObject.optString("picUrl", "");
        long l1 = paramJSONObject.optLong("duration", -1L);
        String str6 = paramJSONObject.optString("articleID", "");
        Object localObject1 = paramJSONObject.optString("commentID");
        String str2 = paramJSONObject.optString("subCommentID");
        bool1 = paramJSONObject.optBoolean("isAwesome");
        int i4 = paramJSONObject.optInt("jumpType");
        int i5 = paramJSONObject.optInt("showType", 0);
        boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
        QLog.d("PublicAccountH5AbilityPlugin", 1, "startShowComment  uniqueKey = " + str1 + "source = " + i1 + "feedsId = " + (String)localObject2 + " feedsType=" + i2 + "adTag = " + i3 + "title = " + str3 + "sourceName = " + str4 + "picUrl =" + str5 + "duration = " + l1 + "articleId =" + str6);
        paramJSONObject = new Bundle();
        paramJSONObject.putSerializable("commonCommentData", new CommonCommentData(str6, i2, (String)localObject2, i3, str3, str4, str5, l1));
        paramJSONObject.putInt("source", i1);
        paramJSONObject.putString("commentId", (String)localObject1);
        paramJSONObject.putString("subCommentId", str2);
        paramJSONObject.putBoolean("isAwesome", bool1);
        paramJSONObject.putInt("jumpType", i4);
        paramJSONObject.putInt("seq", paramInt);
        paramJSONObject.putBoolean("canBiu", bool2);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((AnchorData)localObject2).jdField_b_of_type_JavaLangString = str2;
        ((AnchorData)localObject2).jdField_a_of_type_Boolean = bool1;
        QLog.d("PublicAccountH5AbilityPlugin", 1, "anchorData commentId:" + (String)localObject1 + " ,subCommentId :" + str2);
        localObject1 = BaseActivity.sTopActivity;
        if (i5 == 1)
        {
          bool1 = true;
          ReadInJoyAtlasCommentFragment.a((Context)localObject1, str1, null, null, null, (AnchorData)localObject2, false, bool1, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        boolean bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramJSONObject));
      }
      bool1 = false;
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, tiu paramtiu)
  {
    zon localzon = zon.a();
    localzon.a();
    a(paramJSONObject, localzon.a(new ufj(paramtiu, paramString)));
  }
  
  public static void a(tiv paramtiv, String paramString)
  {
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_get_app_type_action", new Bundle(), new ufh(paramtiv, paramString));
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString1)) {}
    do
    {
      do
      {
        return false;
        paramString1 = (ArrayList)jdField_a_of_type_JavaUtilMap.get(paramString1);
        if (!"QQApi.shareMsg".equals(paramString2)) {
          break;
        }
      } while ((!a(paramString1, "ui.setOnShareQQFriendHandler")) && (!a(paramString1, "ui.ui.setOnShareQZoneHandler")) && (!a(paramString1, "ui.ui.setOnShareWXFriendHandler")) && (!a(paramString1, "ui.setOnShareWXTimelineHandler")));
      return true;
    } while (!a(paramString1, paramString2));
    if ("qbizApi.getNetworkType".equals(paramString2)) {
      bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005868", "0X8005868", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if ("publicAccount.getLocation".equals(paramString2)) {
        bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586A", "0X800586A", 0, 0, "", "", "", "");
      } else if ("ui.closeWebViews".equals(paramString2)) {
        bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586D", "0X800586D", 0, 0, "", "", "", "");
      } else if ("troopNotice.showPicture".equals(paramString2)) {
        bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005896", "0X8005896", 0, 0, "1", "", "", "");
      }
    }
  }
  
  public static boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i1)).equals(paramString)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static int[] a(int paramInt)
  {
    int[] arrayOfInt = new int[32];
    int i1 = 0;
    while (i1 < 32)
    {
      arrayOfInt[(31 - i1)] = (paramInt >> i1 & 0x1);
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  private void d(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optJSONArray("imageIDs");
        int i3 = ((JSONObject)localObject2).optInt("index");
        String str1 = ((JSONObject)localObject2).optString("srcID");
        boolean bool1 = ((JSONObject)localObject2).optBoolean("isNotShowIndex", true);
        boolean bool2 = ((JSONObject)localObject2).optBoolean("showTitle", false);
        String str2 = new String(bfuc.decode(((JSONObject)localObject2).optString("title", ""), 0));
        String str3 = ((JSONObject)localObject2).optString("articleUrl", "");
        boolean bool3 = ((JSONObject)localObject2).optBoolean("isReport", false);
        long l1 = ((JSONObject)localObject2).optLong("touin");
        long l2 = ((JSONObject)localObject2).optLong("feeds_id");
        int i4 = ((JSONObject)localObject2).optInt("feeds_type");
        long l3 = ((JSONObject)localObject2).optLong("articleId");
        int i5 = ((JSONObject)localObject2).optInt("source");
        int i1 = 0;
        if (localObject1 != null) {
          i1 = ((JSONArray)localObject1).length();
        }
        if (Boolean.valueOf(bool3).booleanValue())
        {
          paramString = new PublicAccountShowPictureReport();
          paramString.parse((JSONObject)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountH5AbilityPlugin", 2, new Object[] { "KANDIAN Grid Image title: ", str2, ", articleUrl: ", str3, ", showTitle: ", Boolean.valueOf(bool2) });
          }
          if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PublicAccountH5AbilityPlugin", 2, "imageList is null or length is 0");
            return;
          }
          localObject2 = new ArrayList();
          int i2 = 0;
          if (i2 < ((JSONArray)localObject1).length())
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject1).get(i2).toString());
            i2 += 1;
            continue;
          }
          if (this.jdField_a_of_type_AndroidAppActivity == null) {
            break;
          }
          localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, TroopAvatarWallPreviewActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("index", i3);
          localBundle.putStringArrayList("seqNum", (ArrayList)localObject2);
          localBundle.putBoolean("needBottomBar", false);
          localBundle.putBoolean("IS_EDIT", false);
          localBundle.putBoolean("is_use_path", true);
          localBundle.putBoolean("is_show_action", true);
          localBundle.putBoolean("is_not_show_index", bool1);
          localBundle.putBoolean("is_grid_image_report", true);
          localBundle.putString("to_uin", Long.toString(l1));
          localBundle.putString("feeds_id", Long.toString(l2));
          localBundle.putString("article_id", Long.toString(l3));
          localBundle.putString("scroll_image_r5", pay.a(i1, -1, Integer.toString(i5), i4, "", "", null));
          localBundle.putString("read_article_r5", pay.a(i1, -1, Integer.toString(i5), i4, "", null));
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("src_id", str1);
          }
          if ((bool2) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
          {
            localBundle.putBoolean("is_show_content_url", true);
            localBundle.putString("article_url", str3);
            localBundle.putString("article_title", str2);
          }
          if ((paramString != null) && (paramString.isReport)) {
            localBundle.putString("PublicAccountShowPictureReport", paramString.toString());
          }
          ((Intent)localObject1).putExtras(localBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 100);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = null;
    }
  }
  
  private void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    localObject = ((CookieManager)localObject).getCookie(paramString);
    if (localObject != null) {
      localBundle.putString("Cookie", (String)localObject);
    }
    if (!NetworkUtil.isNetworkAvailable(this.mRuntime.a()))
    {
      yyi.a(1, 2131692955);
      return;
    }
    localObject = new bhht(this.mRuntime.a());
    ((bhht)localObject).c(2131693585);
    ((bhht)localObject).show();
    ThreadManager.executeOnSubThread(new PublicAccountH5AbilityPlugin.26(this, paramString, localBundle, (bhht)localObject));
  }
  
  public ArrayList<String> a()
  {
    bgww localbgww = (bgww)super.getBrowserComponent(4);
    if (localbgww != null) {
      return localbgww.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_Zon = zon.a();
      this.jdField_a_of_type_Zon.a();
    }
    if (this.jdField_a_of_type_Rxk == null) {
      this.jdField_a_of_type_Rxk = rxk.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt1);
    localIntent.putExtra("PhotoConst.CUSTOM_SENDBTN_TEXT", amtj.a(2131707879));
    if (paramInt2 == 1)
    {
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 2);
      if (paramInt2 != 0) {
        break label168;
      }
      localIntent.putExtra("PhotoConst.original_button", true);
      localIntent.putExtra("PhotoConst.quality_count_tv", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().gotoSelectPicture(this, localIntent, (byte)111);
      }
      return;
      if (paramInt2 != 2) {
        break;
      }
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label168:
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.putExtra("PhotoConst.quality_count_tv", false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarFragment.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("key_from_kandian_uploadimg", true);
    String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "readinjoy_avatar_upload/");
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt3);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt4);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt5);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt6);
    localIntent.putExtra("from", paramInt1);
    localIntent.putExtra("type", paramInt2);
    if (this.mRuntime.a() != null)
    {
      paramInt1 = this.mRuntime.a().switchRequestCode(this, paramByte);
      localIntent.putExtra("keyAction", "actionSelectPicture");
      localIntent.putExtra("requestCode", paramInt1);
    }
    startActivityForResult(localIntent, paramByte);
    AlbumUtil.anim(this.jdField_a_of_type_AndroidAppActivity, false, true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.jdField_a_of_type_Bjnw == null) {
      this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561276, null);
    this.jdField_a_of_type_Bjnw.a((View)localObject, null);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131366841);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131366839);
    localObject = (TextView)((View)localObject).findViewById(2131366921);
    if (paramInt1 == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bjnw.isShowing()) {
        this.jdField_a_of_type_Bjnw.show();
      }
      localTextView1.setOnClickListener(new ufn(this, paramString));
      localTextView2.setOnClickListener(new ufo(this, paramInt3, paramInt2, paramString));
      ((TextView)localObject).setOnClickListener(new ufp(this));
      return;
      if (paramInt1 == 2)
      {
        ((TextView)localObject).setVisibility(8);
        localTextView1.setVisibility(8);
      }
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    String str3 = this.k;
    String str1;
    if (str3 != null)
    {
      str1 = str3;
      if (!"".equals(str3)) {}
    }
    else
    {
      str1 = "12345678";
    }
    try
    {
      Long.parseLong(str1);
      if ((this.jdField_a_of_type_Zon != null) && (!"".equals(paramString1))) {
        this.jdField_a_of_type_Zon.b(paramString1, paramInt, str1, paramBoolean, new ufs(this, paramBoolean, paramString3, paramString2), new uft(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "12345678";
      }
    }
  }
  
  void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject2 = this.k;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!"".equals(localObject2)) {}
    }
    else
    {
      localObject1 = "12345678";
    }
    try
    {
      Long.parseLong((String)localObject1);
      if ((this.jdField_a_of_type_Zon != null) && (!"".equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PAH5Manager", 2, "HttpUtil.getNetWorkType()" + HttpUtil.getNetWorkType());
        }
        if (HttpUtil.getNetWorkType() != 1)
        {
          localObject2 = new File(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "size" + ((File)localObject2).length());
          }
          if (((File)localObject2).length() > 204800L) {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "你已离开wifi环境", 0).a();
          }
        }
        this.jdField_a_of_type_Zon.a(paramString1, paramInt, (String)localObject1, paramBoolean, new ufq(this, paramString2, paramBoolean), new ufr(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "12345678";
      }
    }
  }
  
  void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("pic_local_path");
    if (paramBundle != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (paramBundle.equals(((Map.Entry)localObject3).getValue())) {
          ((ArrayList)localObject1).add((String)((Map.Entry)localObject3).getKey());
        }
      }
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          uge localuge = (uge)((Iterator)localObject3).next();
          if (((String)localObject2).equals(localuge.jdField_b_of_type_JavaLangString)) {
            paramBundle.add(localuge);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramBundle);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        paramBundle = (uge)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localObject1 = (String)jdField_b_of_type_JavaUtilHashMap.get(paramBundle.jdField_b_of_type_JavaLangString);
        a(paramBundle.jdField_a_of_type_Int, (String)localObject1, true, paramBundle.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  void a(String paramString)
  {
    this.k = "";
    if (paramString != null) {
      jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, odw.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.4.8,3,0");
    localJSApiWebServerRequest.cmd.set(this.jdField_b_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.k);
      localJSONObject.put("mediaid", paramString1);
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new ufl(this, paramString2, paramInt, paramBoolean, paramString1));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, odw.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.4.8,3,0");
    localJSApiWebServerRequest.cmd.set(1);
    localJSApiWebServerRequest.body.set(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountH5AbilityPlugin", 2, "鉴权body为:  " + paramString2);
    }
    localNewIntent.setObserver(new ufm(this, paramString1));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
  }
  
  void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, odw.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.4.8,3,0");
    localJSApiWebServerRequest.cmd.set(this.jdField_a_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("puin", this.k);
        if (!paramBoolean) {
          continue;
        }
        localJSONObject.put("url", paramString1);
        localJSONObject.put("type", "2");
      }
      catch (JSONException paramString1)
      {
        ufa localufa;
        paramString1.printStackTrace();
        continue;
      }
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new ufk(this, paramBoolean, paramString2));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      return;
      localJSONObject.put("type", "4");
      if (this.jdField_a_of_type_Ufa == null) {
        this.jdField_a_of_type_Ufa = new ufa(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
      }
      this.jdField_a_of_type_Ufa.h();
      localJSONObject.put("file_uuid", paramString1);
      localufa = this.jdField_a_of_type_Ufa;
      localJSONObject.put("file_md5", ufa.b());
      localufa = this.jdField_a_of_type_Ufa;
      localJSONObject.put("file_name", ufa.c());
      localufa = this.jdField_a_of_type_Ufa;
      localJSONObject.put("file_size", ufa.b());
      localufa = this.jdField_a_of_type_Ufa;
      localJSONObject.put("file_time", ufa.c());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("sendUuidForMediaIdRequest file_uuid = ").append(paramString1).append(" file_md5=");
        localufa = this.jdField_a_of_type_Ufa;
        paramString1 = paramString1.append(ufa.b()).append(" file_name:");
        localufa = this.jdField_a_of_type_Ufa;
        paramString1 = paramString1.append(ufa.c()).append(" file_size=");
        localufa = this.jdField_a_of_type_Ufa;
        paramString1 = paramString1.append(ufa.b()).append(" file_time=");
        localufa = this.jdField_a_of_type_Ufa;
        QLog.i("PublicAccountH5AbilityPlugin", 2, ufa.c());
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!a(a(), str)) {
        a().add(str);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().setRightButton(paramBoolean);
      }
      return;
      bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ufa != null) {
      this.jdField_a_of_type_Ufa.f();
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("fromBrowser", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      a(a(), str);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PoiMapActivity.class).putExtra("uin", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_Zon.c();
  }
  
  void c(String paramString)
  {
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ugd localugd = (ugd)localIterator.next();
        if (paramString.equals(localugd.jdField_b_of_type_JavaLangString)) {
          localArrayList.add(localugd);
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      paramString = (ugd)this.jdField_b_of_type_JavaUtilArrayList.get(0);
      a(paramString.jdField_b_of_type_JavaLangString, paramString.jdField_a_of_type_Int, true, paramString.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void d()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().showActionSheet();
    }
  }
  
  public void e()
  {
    a().clear();
    a().add("menuItem:share:qq");
    a().add("menuItem:share:QZone");
    a().add("menuItem:share:appMessage");
    a().add("menuItem:share:timeline");
    a().add("menuItem:openWithQQBrowser");
    a().add("menuItem:openWithSafari");
    a().add("menuItem:favorite");
    a().add("menuItem:copyUrl");
    a().add("menuItem:exportTencentDocs");
  }
  
  public void f()
  {
    a().clear();
  }
  
  public void g()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().setBottomBarVisible(false);
    }
  }
  
  public void h()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().setBottomBarVisible(true);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934600L)
    {
      if (paramMap != null)
      {
        int i1 = ((Integer)paramMap.get("requestCode")).intValue();
        if ((i1 == 1) || (i1 == 113) || (i1 == 114) || (i1 == 115) || (i1 == 116) || (i1 == 117) || (i1 == 118) || (i1 == 119) || (i1 == 122))
        {
          int i2 = ((Integer)paramMap.get("resultCode")).intValue();
          onActivityResult((Intent)paramMap.get("data"), (byte)i1, i2);
          return true;
        }
      }
    }
    else if (paramLong == 8589934597L) {
      b();
    }
    return false;
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 187
    //   2: aload_3
    //   3: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6: ifeq +4474 -> 4480
    //   9: ldc_w 1446
    //   12: aload 4
    //   14: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   17: ifeq +125 -> 142
    //   20: aload 5
    //   22: ifnull +82 -> 104
    //   25: aload 5
    //   27: arraylength
    //   28: ifle +76 -> 104
    //   31: new 224	org/json/JSONObject
    //   34: dup
    //   35: aload 5
    //   37: iconst_0
    //   38: aaload
    //   39: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   42: ldc_w 533
    //   45: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +47 -> 100
    //   56: new 224	org/json/JSONObject
    //   59: dup
    //   60: invokespecial 225	org/json/JSONObject:<init>	()V
    //   63: astore_2
    //   64: aload_2
    //   65: ldc_w 314
    //   68: iconst_0
    //   69: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload_2
    //   74: ldc_w 406
    //   77: ldc_w 1448
    //   80: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_0
    //   85: aload_1
    //   86: iconst_1
    //   87: anewarray 201	java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: aload_2
    //   93: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   96: aastore
    //   97: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   100: aload_0
    //   101: invokevirtual 1449	ufd:c	()V
    //   104: aconst_null
    //   105: ldc_w 756
    //   108: ldc_w 758
    //   111: ldc 163
    //   113: ldc_w 1451
    //   116: ldc_w 1451
    //   119: iconst_0
    //   120: iconst_0
    //   121: ldc 163
    //   123: ldc 163
    //   125: ldc 163
    //   127: ldc 163
    //   129: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   139: goto -35 -> 104
    //   142: ldc_w 1453
    //   145: aload 4
    //   147: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   150: ifeq +55 -> 205
    //   153: aload 5
    //   155: ifnull +40 -> 195
    //   158: aload 5
    //   160: arraylength
    //   161: ifle +34 -> 195
    //   164: new 224	org/json/JSONObject
    //   167: dup
    //   168: aload 5
    //   170: iconst_0
    //   171: aaload
    //   172: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   175: ldc 237
    //   177: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   180: astore_1
    //   181: ldc 163
    //   183: aload_1
    //   184: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifne +8 -> 195
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual 1455	ufd:b	(Ljava/lang/String;)V
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   202: goto -7 -> 195
    //   205: ldc_w 1457
    //   208: aload 4
    //   210: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   213: ifeq +97 -> 310
    //   216: aload 5
    //   218: ifnull +82 -> 300
    //   221: aload 5
    //   223: arraylength
    //   224: ifle +76 -> 300
    //   227: new 224	org/json/JSONObject
    //   230: dup
    //   231: aload 5
    //   233: iconst_0
    //   234: aaload
    //   235: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   238: ldc_w 533
    //   241: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   244: astore_1
    //   245: aload_1
    //   246: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   249: ifne +47 -> 296
    //   252: new 224	org/json/JSONObject
    //   255: dup
    //   256: invokespecial 225	org/json/JSONObject:<init>	()V
    //   259: astore_2
    //   260: aload_2
    //   261: ldc_w 314
    //   264: iconst_0
    //   265: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload_2
    //   270: ldc_w 406
    //   273: ldc_w 1448
    //   276: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload_0
    //   281: aload_1
    //   282: iconst_1
    //   283: anewarray 201	java/lang/String
    //   286: dup
    //   287: iconst_0
    //   288: aload_2
    //   289: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   292: aastore
    //   293: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   296: aload_0
    //   297: invokevirtual 1459	ufd:d	()V
    //   300: iconst_1
    //   301: ireturn
    //   302: astore_1
    //   303: aload_1
    //   304: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   307: goto -7 -> 300
    //   310: ldc_w 1461
    //   313: aload 4
    //   315: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   318: ifeq +110 -> 428
    //   321: aload 5
    //   323: ifnull +95 -> 418
    //   326: aload 5
    //   328: arraylength
    //   329: ifle +89 -> 418
    //   332: new 224	org/json/JSONObject
    //   335: dup
    //   336: aload 5
    //   338: iconst_0
    //   339: aaload
    //   340: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   343: astore_1
    //   344: aload_1
    //   345: ldc_w 1463
    //   348: invokevirtual 629	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   351: istore 13
    //   353: aload_1
    //   354: ldc_w 533
    //   357: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   360: astore_1
    //   361: aload_1
    //   362: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   365: ifne +47 -> 412
    //   368: new 224	org/json/JSONObject
    //   371: dup
    //   372: invokespecial 225	org/json/JSONObject:<init>	()V
    //   375: astore_2
    //   376: aload_2
    //   377: ldc_w 314
    //   380: iconst_0
    //   381: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   384: pop
    //   385: aload_2
    //   386: ldc_w 406
    //   389: ldc_w 1448
    //   392: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   395: pop
    //   396: aload_0
    //   397: aload_1
    //   398: iconst_1
    //   399: anewarray 201	java/lang/String
    //   402: dup
    //   403: iconst_0
    //   404: aload_2
    //   405: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   408: aastore
    //   409: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   412: aload_0
    //   413: iload 13
    //   415: invokevirtual 1465	ufd:a	(Z)V
    //   418: iconst_1
    //   419: ireturn
    //   420: astore_1
    //   421: aload_1
    //   422: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   425: goto -7 -> 418
    //   428: ldc_w 1467
    //   431: aload 4
    //   433: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   436: ifeq +180 -> 616
    //   439: aload 5
    //   441: ifnull +137 -> 578
    //   444: aload 5
    //   446: arraylength
    //   447: ifle +131 -> 578
    //   450: new 224	org/json/JSONObject
    //   453: dup
    //   454: aload 5
    //   456: iconst_0
    //   457: aaload
    //   458: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   461: astore_2
    //   462: aload_2
    //   463: ldc_w 533
    //   466: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   469: astore_1
    //   470: aload_2
    //   471: ldc_w 1469
    //   474: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   477: astore_3
    //   478: new 174	java/util/ArrayList
    //   481: dup
    //   482: invokespecial 175	java/util/ArrayList:<init>	()V
    //   485: astore_2
    //   486: aload_3
    //   487: ifnull +35 -> 522
    //   490: iconst_0
    //   491: istore 6
    //   493: iload 6
    //   495: aload_3
    //   496: invokevirtual 547	org/json/JSONArray:length	()I
    //   499: if_icmpge +23 -> 522
    //   502: aload_2
    //   503: aload_3
    //   504: iload 6
    //   506: invokevirtual 1471	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   509: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   512: pop
    //   513: iload 6
    //   515: iconst_1
    //   516: iadd
    //   517: istore 6
    //   519: goto -26 -> 493
    //   522: aload_1
    //   523: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifne +47 -> 573
    //   529: new 224	org/json/JSONObject
    //   532: dup
    //   533: invokespecial 225	org/json/JSONObject:<init>	()V
    //   536: astore_3
    //   537: aload_3
    //   538: ldc_w 314
    //   541: iconst_0
    //   542: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   545: pop
    //   546: aload_3
    //   547: ldc_w 406
    //   550: ldc_w 1448
    //   553: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload_0
    //   558: aload_1
    //   559: iconst_1
    //   560: anewarray 201	java/lang/String
    //   563: dup
    //   564: iconst_0
    //   565: aload_3
    //   566: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   569: aastore
    //   570: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   573: aload_0
    //   574: aload_2
    //   575: invokevirtual 1473	ufd:a	(Ljava/util/ArrayList;)V
    //   578: aconst_null
    //   579: ldc_w 756
    //   582: ldc_w 758
    //   585: ldc 163
    //   587: ldc_w 1475
    //   590: ldc_w 1475
    //   593: iconst_0
    //   594: iconst_0
    //   595: ldc 163
    //   597: ldc 163
    //   599: ldc 163
    //   601: ldc 163
    //   603: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   606: iconst_1
    //   607: ireturn
    //   608: astore_1
    //   609: aload_1
    //   610: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   613: goto -35 -> 578
    //   616: ldc_w 1477
    //   619: aload 4
    //   621: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   624: ifeq +180 -> 804
    //   627: aload 5
    //   629: ifnull +137 -> 766
    //   632: aload 5
    //   634: arraylength
    //   635: ifle +131 -> 766
    //   638: new 224	org/json/JSONObject
    //   641: dup
    //   642: aload 5
    //   644: iconst_0
    //   645: aaload
    //   646: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   649: astore_2
    //   650: aload_2
    //   651: ldc_w 533
    //   654: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   657: astore_1
    //   658: aload_2
    //   659: ldc_w 1469
    //   662: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   665: astore_3
    //   666: new 174	java/util/ArrayList
    //   669: dup
    //   670: invokespecial 175	java/util/ArrayList:<init>	()V
    //   673: astore_2
    //   674: aload_3
    //   675: ifnull +35 -> 710
    //   678: iconst_0
    //   679: istore 6
    //   681: iload 6
    //   683: aload_3
    //   684: invokevirtual 547	org/json/JSONArray:length	()I
    //   687: if_icmpge +23 -> 710
    //   690: aload_2
    //   691: aload_3
    //   692: iload 6
    //   694: invokevirtual 1471	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   697: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   700: pop
    //   701: iload 6
    //   703: iconst_1
    //   704: iadd
    //   705: istore 6
    //   707: goto -26 -> 681
    //   710: aload_1
    //   711: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   714: ifne +47 -> 761
    //   717: new 224	org/json/JSONObject
    //   720: dup
    //   721: invokespecial 225	org/json/JSONObject:<init>	()V
    //   724: astore_3
    //   725: aload_3
    //   726: ldc_w 314
    //   729: iconst_0
    //   730: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   733: pop
    //   734: aload_3
    //   735: ldc_w 406
    //   738: ldc_w 1448
    //   741: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   744: pop
    //   745: aload_0
    //   746: aload_1
    //   747: iconst_1
    //   748: anewarray 201	java/lang/String
    //   751: dup
    //   752: iconst_0
    //   753: aload_3
    //   754: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   757: aastore
    //   758: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   761: aload_0
    //   762: aload_2
    //   763: invokevirtual 1479	ufd:b	(Ljava/util/ArrayList;)V
    //   766: aconst_null
    //   767: ldc_w 756
    //   770: ldc_w 758
    //   773: ldc 163
    //   775: ldc_w 1481
    //   778: ldc_w 1481
    //   781: iconst_0
    //   782: iconst_0
    //   783: ldc 163
    //   785: ldc 163
    //   787: ldc 163
    //   789: ldc 163
    //   791: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   794: iconst_1
    //   795: ireturn
    //   796: astore_1
    //   797: aload_1
    //   798: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   801: goto -35 -> 766
    //   804: ldc_w 1483
    //   807: aload 4
    //   809: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   812: ifeq +125 -> 937
    //   815: aload 5
    //   817: ifnull +82 -> 899
    //   820: aload 5
    //   822: arraylength
    //   823: ifle +76 -> 899
    //   826: new 224	org/json/JSONObject
    //   829: dup
    //   830: aload 5
    //   832: iconst_0
    //   833: aaload
    //   834: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   837: ldc_w 533
    //   840: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   843: astore_1
    //   844: aload_1
    //   845: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   848: ifne +47 -> 895
    //   851: new 224	org/json/JSONObject
    //   854: dup
    //   855: invokespecial 225	org/json/JSONObject:<init>	()V
    //   858: astore_2
    //   859: aload_2
    //   860: ldc_w 314
    //   863: iconst_0
    //   864: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   867: pop
    //   868: aload_2
    //   869: ldc_w 406
    //   872: ldc_w 1448
    //   875: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   878: pop
    //   879: aload_0
    //   880: aload_1
    //   881: iconst_1
    //   882: anewarray 201	java/lang/String
    //   885: dup
    //   886: iconst_0
    //   887: aload_2
    //   888: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   891: aastore
    //   892: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   895: aload_0
    //   896: invokevirtual 1485	ufd:e	()V
    //   899: aconst_null
    //   900: ldc_w 756
    //   903: ldc_w 758
    //   906: ldc 163
    //   908: ldc_w 1487
    //   911: ldc_w 1487
    //   914: iconst_0
    //   915: iconst_0
    //   916: ldc 163
    //   918: ldc 163
    //   920: ldc 163
    //   922: ldc 163
    //   924: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   927: iconst_1
    //   928: ireturn
    //   929: astore_1
    //   930: aload_1
    //   931: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   934: goto -35 -> 899
    //   937: ldc_w 1489
    //   940: aload 4
    //   942: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   945: ifeq +125 -> 1070
    //   948: aload 5
    //   950: ifnull +82 -> 1032
    //   953: aload 5
    //   955: arraylength
    //   956: ifle +76 -> 1032
    //   959: new 224	org/json/JSONObject
    //   962: dup
    //   963: aload 5
    //   965: iconst_0
    //   966: aaload
    //   967: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   970: ldc_w 533
    //   973: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   976: astore_1
    //   977: aload_1
    //   978: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   981: ifne +47 -> 1028
    //   984: new 224	org/json/JSONObject
    //   987: dup
    //   988: invokespecial 225	org/json/JSONObject:<init>	()V
    //   991: astore_2
    //   992: aload_2
    //   993: ldc_w 314
    //   996: iconst_0
    //   997: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1000: pop
    //   1001: aload_2
    //   1002: ldc_w 406
    //   1005: ldc_w 1448
    //   1008: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1011: pop
    //   1012: aload_0
    //   1013: aload_1
    //   1014: iconst_1
    //   1015: anewarray 201	java/lang/String
    //   1018: dup
    //   1019: iconst_0
    //   1020: aload_2
    //   1021: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1024: aastore
    //   1025: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1028: aload_0
    //   1029: invokevirtual 1490	ufd:f	()V
    //   1032: aconst_null
    //   1033: ldc_w 756
    //   1036: ldc_w 758
    //   1039: ldc 163
    //   1041: ldc_w 1492
    //   1044: ldc_w 1492
    //   1047: iconst_0
    //   1048: iconst_0
    //   1049: ldc 163
    //   1051: ldc 163
    //   1053: ldc 163
    //   1055: ldc 163
    //   1057: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1060: iconst_1
    //   1061: ireturn
    //   1062: astore_1
    //   1063: aload_1
    //   1064: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   1067: goto -35 -> 1032
    //   1070: ldc_w 1494
    //   1073: aload 4
    //   1075: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1078: ifeq +125 -> 1203
    //   1081: aload 5
    //   1083: ifnull +82 -> 1165
    //   1086: aload 5
    //   1088: arraylength
    //   1089: ifle +76 -> 1165
    //   1092: new 224	org/json/JSONObject
    //   1095: dup
    //   1096: aload 5
    //   1098: iconst_0
    //   1099: aaload
    //   1100: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1103: ldc_w 533
    //   1106: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1109: astore_1
    //   1110: aload_1
    //   1111: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1114: ifne +47 -> 1161
    //   1117: new 224	org/json/JSONObject
    //   1120: dup
    //   1121: invokespecial 225	org/json/JSONObject:<init>	()V
    //   1124: astore_2
    //   1125: aload_2
    //   1126: ldc_w 314
    //   1129: iconst_0
    //   1130: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1133: pop
    //   1134: aload_2
    //   1135: ldc_w 406
    //   1138: ldc_w 1448
    //   1141: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1144: pop
    //   1145: aload_0
    //   1146: aload_1
    //   1147: iconst_1
    //   1148: anewarray 201	java/lang/String
    //   1151: dup
    //   1152: iconst_0
    //   1153: aload_2
    //   1154: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1157: aastore
    //   1158: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1161: aload_0
    //   1162: invokevirtual 1495	ufd:h	()V
    //   1165: aconst_null
    //   1166: ldc_w 756
    //   1169: ldc_w 758
    //   1172: ldc 163
    //   1174: ldc_w 1497
    //   1177: ldc_w 1497
    //   1180: iconst_0
    //   1181: iconst_0
    //   1182: ldc 163
    //   1184: ldc 163
    //   1186: ldc 163
    //   1188: ldc 163
    //   1190: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1193: iconst_1
    //   1194: ireturn
    //   1195: astore_1
    //   1196: aload_1
    //   1197: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   1200: goto -35 -> 1165
    //   1203: ldc_w 1499
    //   1206: aload 4
    //   1208: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1211: ifeq +125 -> 1336
    //   1214: aload 5
    //   1216: ifnull +82 -> 1298
    //   1219: aload 5
    //   1221: arraylength
    //   1222: ifle +76 -> 1298
    //   1225: new 224	org/json/JSONObject
    //   1228: dup
    //   1229: aload 5
    //   1231: iconst_0
    //   1232: aaload
    //   1233: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1236: ldc_w 533
    //   1239: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1242: astore_1
    //   1243: aload_1
    //   1244: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1247: ifne +47 -> 1294
    //   1250: new 224	org/json/JSONObject
    //   1253: dup
    //   1254: invokespecial 225	org/json/JSONObject:<init>	()V
    //   1257: astore_2
    //   1258: aload_2
    //   1259: ldc_w 314
    //   1262: iconst_0
    //   1263: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1266: pop
    //   1267: aload_2
    //   1268: ldc_w 406
    //   1271: ldc_w 1448
    //   1274: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1277: pop
    //   1278: aload_0
    //   1279: aload_1
    //   1280: iconst_1
    //   1281: anewarray 201	java/lang/String
    //   1284: dup
    //   1285: iconst_0
    //   1286: aload_2
    //   1287: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1290: aastore
    //   1291: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1294: aload_0
    //   1295: invokevirtual 1501	ufd:g	()V
    //   1298: aconst_null
    //   1299: ldc_w 756
    //   1302: ldc_w 758
    //   1305: ldc 163
    //   1307: ldc_w 1503
    //   1310: ldc_w 1503
    //   1313: iconst_0
    //   1314: iconst_0
    //   1315: ldc 163
    //   1317: ldc 163
    //   1319: ldc 163
    //   1321: ldc 163
    //   1323: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1326: iconst_1
    //   1327: ireturn
    //   1328: astore_1
    //   1329: aload_1
    //   1330: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   1333: goto -35 -> 1298
    //   1336: ldc_w 1505
    //   1339: aload 4
    //   1341: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1344: ifeq +336 -> 1680
    //   1347: aload 5
    //   1349: ifnull +289 -> 1638
    //   1352: aload 5
    //   1354: arraylength
    //   1355: ifle +283 -> 1638
    //   1358: new 224	org/json/JSONObject
    //   1361: dup
    //   1362: aload 5
    //   1364: iconst_0
    //   1365: aaload
    //   1366: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1369: astore_3
    //   1370: aload_3
    //   1371: ldc_w 533
    //   1374: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1377: astore_1
    //   1378: aload_3
    //   1379: ldc_w 1507
    //   1382: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1385: astore_2
    //   1386: aload_3
    //   1387: ldc_w 1509
    //   1390: iconst_1
    //   1391: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1394: istore 6
    //   1396: getstatic 132	ufd:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1399: aload_2
    //   1400: invokevirtual 199	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1403: checkcast 201	java/lang/String
    //   1406: astore_3
    //   1407: new 1173	java/io/File
    //   1410: dup
    //   1411: aload_3
    //   1412: invokespecial 1174	java/io/File:<init>	(Ljava/lang/String;)V
    //   1415: astore 4
    //   1417: aload 4
    //   1419: ifnull +11 -> 1430
    //   1422: aload 4
    //   1424: invokevirtual 1512	java/io/File:exists	()Z
    //   1427: ifne +40 -> 1467
    //   1430: aload_0
    //   1431: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1434: new 507	java/lang/StringBuilder
    //   1437: dup
    //   1438: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   1441: ldc_w 1513
    //   1444: invokestatic 987	amtj:a	(I)Ljava/lang/String;
    //   1447: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: aload_3
    //   1451: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1457: iconst_0
    //   1458: invokestatic 1184	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1461: invokevirtual 1187	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1464: pop
    //   1465: iconst_1
    //   1466: ireturn
    //   1467: aload 4
    //   1469: invokevirtual 1177	java/io/File:length	()J
    //   1472: ldc2_w 1514
    //   1475: lcmp
    //   1476: ifle +37 -> 1513
    //   1479: aload_0
    //   1480: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1483: new 507	java/lang/StringBuilder
    //   1486: dup
    //   1487: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   1490: ldc_w 1517
    //   1493: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: aload_3
    //   1497: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1503: iconst_0
    //   1504: invokestatic 1184	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1507: invokevirtual 1187	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1510: pop
    //   1511: iconst_1
    //   1512: ireturn
    //   1513: aload_0
    //   1514: getfield 177	ufd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1517: invokevirtual 1230	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1520: astore 4
    //   1522: aload 4
    //   1524: invokeinterface 1217 1 0
    //   1529: ifeq +51 -> 1580
    //   1532: aload 4
    //   1534: invokeinterface 1221 1 0
    //   1539: checkcast 1232	uge
    //   1542: astore 5
    //   1544: aload_2
    //   1545: ifnull -23 -> 1522
    //   1548: aload_2
    //   1549: aload 5
    //   1551: getfield 1233	uge:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1554: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1557: ifeq -35 -> 1522
    //   1560: aload_0
    //   1561: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1564: ldc_w 1518
    //   1567: invokestatic 987	amtj:a	(I)Ljava/lang/String;
    //   1570: iconst_0
    //   1571: invokestatic 1184	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1574: invokevirtual 1187	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1577: pop
    //   1578: iconst_1
    //   1579: ireturn
    //   1580: new 1232	uge
    //   1583: dup
    //   1584: invokespecial 1519	uge:<init>	()V
    //   1587: astore 4
    //   1589: aload 4
    //   1591: aload_1
    //   1592: putfield 1239	uge:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1595: aload 4
    //   1597: aload_2
    //   1598: putfield 1233	uge:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1601: aload 4
    //   1603: iload 6
    //   1605: putfield 1238	uge:jdField_a_of_type_Int	I
    //   1608: aload_0
    //   1609: getfield 177	ufd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1612: aload 4
    //   1614: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1617: pop
    //   1618: aload_0
    //   1619: getfield 177	ufd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1622: invokevirtual 581	java/util/ArrayList:size	()I
    //   1625: iconst_1
    //   1626: if_icmpne +44 -> 1670
    //   1629: aload_0
    //   1630: iload 6
    //   1632: aload_3
    //   1633: iconst_1
    //   1634: aload_1
    //   1635: invokevirtual 1241	ufd:a	(ILjava/lang/String;ZLjava/lang/String;)V
    //   1638: aconst_null
    //   1639: ldc_w 756
    //   1642: ldc_w 758
    //   1645: ldc 163
    //   1647: ldc_w 1521
    //   1650: ldc_w 1521
    //   1653: iconst_0
    //   1654: iconst_2
    //   1655: ldc_w 773
    //   1658: ldc 163
    //   1660: ldc 163
    //   1662: ldc 163
    //   1664: iconst_0
    //   1665: invokestatic 1526	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1668: iconst_1
    //   1669: ireturn
    //   1670: iconst_1
    //   1671: ireturn
    //   1672: astore_1
    //   1673: aload_1
    //   1674: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   1677: goto -39 -> 1638
    //   1680: ldc_w 1528
    //   1683: aload 4
    //   1685: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1688: ifeq +245 -> 1933
    //   1691: aload 5
    //   1693: ifnull +199 -> 1892
    //   1696: aload 5
    //   1698: arraylength
    //   1699: ifle +193 -> 1892
    //   1702: new 224	org/json/JSONObject
    //   1705: dup
    //   1706: aload 5
    //   1708: iconst_0
    //   1709: aaload
    //   1710: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1713: astore_3
    //   1714: aload_3
    //   1715: ldc_w 533
    //   1718: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1721: astore_1
    //   1722: aload_3
    //   1723: ldc_w 1530
    //   1726: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1729: astore_2
    //   1730: aload_3
    //   1731: ldc_w 1509
    //   1734: iconst_1
    //   1735: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1738: istore 6
    //   1740: ldc 163
    //   1742: aload_1
    //   1743: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1746: ifne +12 -> 1758
    //   1749: ldc 163
    //   1751: aload_2
    //   1752: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1755: ifeq +20 -> 1775
    //   1758: aload_0
    //   1759: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1762: ldc_w 1532
    //   1765: iconst_0
    //   1766: invokestatic 1184	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1769: invokevirtual 1187	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1772: pop
    //   1773: iconst_1
    //   1774: ireturn
    //   1775: aload_0
    //   1776: getfield 179	ufd:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1779: invokevirtual 1230	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1782: astore_3
    //   1783: aload_3
    //   1784: invokeinterface 1217 1 0
    //   1789: ifeq +50 -> 1839
    //   1792: aload_3
    //   1793: invokeinterface 1221 1 0
    //   1798: checkcast 1387	ugd
    //   1801: astore 4
    //   1803: aload_2
    //   1804: ifnull -21 -> 1783
    //   1807: aload_2
    //   1808: aload 4
    //   1810: getfield 1388	ugd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1813: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1816: ifeq -33 -> 1783
    //   1819: aload_0
    //   1820: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1823: ldc_w 1533
    //   1826: invokestatic 987	amtj:a	(I)Ljava/lang/String;
    //   1829: iconst_0
    //   1830: invokestatic 1184	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   1833: invokevirtual 1187	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   1836: pop
    //   1837: iconst_1
    //   1838: ireturn
    //   1839: new 1387	ugd
    //   1842: dup
    //   1843: invokespecial 1534	ugd:<init>	()V
    //   1846: astore_3
    //   1847: aload_3
    //   1848: aload_1
    //   1849: putfield 1390	ugd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1852: aload_3
    //   1853: aload_2
    //   1854: putfield 1388	ugd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1857: aload_3
    //   1858: iload 6
    //   1860: putfield 1389	ugd:jdField_a_of_type_Int	I
    //   1863: aload_0
    //   1864: getfield 179	ufd:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1867: aload_3
    //   1868: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1871: pop
    //   1872: aload_0
    //   1873: getfield 179	ufd:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1876: invokevirtual 581	java/util/ArrayList:size	()I
    //   1879: iconst_1
    //   1880: if_icmpne +43 -> 1923
    //   1883: aload_0
    //   1884: aload_2
    //   1885: iload 6
    //   1887: iconst_1
    //   1888: aload_1
    //   1889: invokevirtual 1392	ufd:a	(Ljava/lang/String;IZLjava/lang/String;)V
    //   1892: aconst_null
    //   1893: ldc_w 756
    //   1896: ldc_w 758
    //   1899: ldc 163
    //   1901: ldc_w 1536
    //   1904: ldc_w 1536
    //   1907: iconst_0
    //   1908: iconst_2
    //   1909: ldc_w 773
    //   1912: ldc 163
    //   1914: ldc 163
    //   1916: ldc 163
    //   1918: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1921: iconst_1
    //   1922: ireturn
    //   1923: iconst_1
    //   1924: ireturn
    //   1925: astore_1
    //   1926: aload_1
    //   1927: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   1930: goto -38 -> 1892
    //   1933: ldc_w 1538
    //   1936: aload 4
    //   1938: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1941: ifeq +343 -> 2284
    //   1944: aload 5
    //   1946: ifnull +11867 -> 13813
    //   1949: aload 5
    //   1951: arraylength
    //   1952: ifle +11861 -> 13813
    //   1955: new 224	org/json/JSONObject
    //   1958: dup
    //   1959: aload 5
    //   1961: iconst_0
    //   1962: aaload
    //   1963: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1966: astore_2
    //   1967: aload_2
    //   1968: ldc_w 533
    //   1971: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1974: astore_1
    //   1975: aload_2
    //   1976: ldc_w 1507
    //   1979: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1982: astore_3
    //   1983: aload_2
    //   1984: ldc_w 1509
    //   1987: iconst_1
    //   1988: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1991: istore 6
    //   1993: aload_3
    //   1994: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1997: istore 13
    //   1999: iload 13
    //   2001: ifeq +95 -> 2096
    //   2004: new 224	org/json/JSONObject
    //   2007: dup
    //   2008: invokespecial 225	org/json/JSONObject:<init>	()V
    //   2011: astore_2
    //   2012: aload_2
    //   2013: ldc_w 314
    //   2016: iconst_m1
    //   2017: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2020: pop
    //   2021: aload_2
    //   2022: ldc_w 406
    //   2025: ldc_w 1540
    //   2028: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2031: pop
    //   2032: aload_0
    //   2033: aload_1
    //   2034: iconst_1
    //   2035: anewarray 201	java/lang/String
    //   2038: dup
    //   2039: iconst_0
    //   2040: aload_2
    //   2041: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2044: aastore
    //   2045: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2048: aconst_null
    //   2049: ldc_w 756
    //   2052: ldc_w 758
    //   2055: ldc 163
    //   2057: ldc_w 1542
    //   2060: ldc_w 1542
    //   2063: iconst_0
    //   2064: iconst_2
    //   2065: ldc_w 773
    //   2068: ldc 163
    //   2070: ldc 163
    //   2072: ldc 163
    //   2074: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2077: goto +11736 -> 13813
    //   2080: astore_1
    //   2081: aload_1
    //   2082: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2085: goto -37 -> 2048
    //   2088: astore_1
    //   2089: aload_1
    //   2090: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2093: goto +11720 -> 13813
    //   2096: aload_0
    //   2097: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2100: ifnonnull +26 -> 2126
    //   2103: aload_0
    //   2104: new 1325	ufa
    //   2107: dup
    //   2108: aload_0
    //   2109: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   2112: aload_0
    //   2113: getfield 1326	ufd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2116: aload_0
    //   2117: getfield 485	ufd:mRuntime	Lbgve;
    //   2120: invokespecial 1329	ufa:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbgve;)V
    //   2123: putfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2126: aload_0
    //   2127: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2130: aload_3
    //   2131: invokevirtual 1544	ufa:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2134: astore_2
    //   2135: new 1173	java/io/File
    //   2138: dup
    //   2139: aload_2
    //   2140: invokespecial 1174	java/io/File:<init>	(Ljava/lang/String;)V
    //   2143: astore_3
    //   2144: aload_3
    //   2145: invokevirtual 1512	java/io/File:exists	()Z
    //   2148: ifne +58 -> 2206
    //   2151: new 224	org/json/JSONObject
    //   2154: dup
    //   2155: invokespecial 225	org/json/JSONObject:<init>	()V
    //   2158: astore_2
    //   2159: aload_2
    //   2160: ldc_w 314
    //   2163: iconst_m1
    //   2164: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2167: pop
    //   2168: aload_2
    //   2169: ldc_w 406
    //   2172: ldc_w 1540
    //   2175: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2178: pop
    //   2179: aload_0
    //   2180: aload_1
    //   2181: iconst_1
    //   2182: anewarray 201	java/lang/String
    //   2185: dup
    //   2186: iconst_0
    //   2187: aload_2
    //   2188: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2191: aastore
    //   2192: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2195: goto -147 -> 2048
    //   2198: astore_1
    //   2199: aload_1
    //   2200: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2203: goto -155 -> 2048
    //   2206: aload_3
    //   2207: invokevirtual 1177	java/io/File:length	()J
    //   2210: ldc2_w 1545
    //   2213: lcmp
    //   2214: ifle +58 -> 2272
    //   2217: new 224	org/json/JSONObject
    //   2220: dup
    //   2221: invokespecial 225	org/json/JSONObject:<init>	()V
    //   2224: astore_2
    //   2225: aload_2
    //   2226: ldc_w 314
    //   2229: iconst_m1
    //   2230: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2233: pop
    //   2234: aload_2
    //   2235: ldc_w 406
    //   2238: ldc_w 1548
    //   2241: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2244: pop
    //   2245: aload_0
    //   2246: aload_1
    //   2247: iconst_1
    //   2248: anewarray 201	java/lang/String
    //   2251: dup
    //   2252: iconst_0
    //   2253: aload_2
    //   2254: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2257: aastore
    //   2258: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2261: goto -213 -> 2048
    //   2264: astore_3
    //   2265: aload_3
    //   2266: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2269: goto -24 -> 2245
    //   2272: aload_0
    //   2273: iload 6
    //   2275: aload_2
    //   2276: iconst_0
    //   2277: aload_1
    //   2278: invokevirtual 1241	ufd:a	(ILjava/lang/String;ZLjava/lang/String;)V
    //   2281: goto -233 -> 2048
    //   2284: ldc_w 1550
    //   2287: aload 4
    //   2289: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2292: ifeq +167 -> 2459
    //   2295: aload 5
    //   2297: ifnull +11518 -> 13815
    //   2300: aload 5
    //   2302: arraylength
    //   2303: ifle +11512 -> 13815
    //   2306: new 224	org/json/JSONObject
    //   2309: dup
    //   2310: aload 5
    //   2312: iconst_0
    //   2313: aaload
    //   2314: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2317: astore_2
    //   2318: aload_2
    //   2319: ldc_w 533
    //   2322: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2325: astore_1
    //   2326: aload_2
    //   2327: ldc_w 1530
    //   2330: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2333: astore_3
    //   2334: aload_2
    //   2335: ldc_w 1509
    //   2338: iconst_1
    //   2339: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2342: istore 6
    //   2344: aload_3
    //   2345: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2348: istore 13
    //   2350: iload 13
    //   2352: ifeq +95 -> 2447
    //   2355: new 224	org/json/JSONObject
    //   2358: dup
    //   2359: invokespecial 225	org/json/JSONObject:<init>	()V
    //   2362: astore_2
    //   2363: aload_2
    //   2364: ldc_w 314
    //   2367: iconst_m1
    //   2368: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2371: pop
    //   2372: aload_2
    //   2373: ldc_w 406
    //   2376: ldc_w 1552
    //   2379: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2382: pop
    //   2383: aload_0
    //   2384: aload_1
    //   2385: iconst_1
    //   2386: anewarray 201	java/lang/String
    //   2389: dup
    //   2390: iconst_0
    //   2391: aload_2
    //   2392: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2395: aastore
    //   2396: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2399: aconst_null
    //   2400: ldc_w 756
    //   2403: ldc_w 758
    //   2406: ldc 163
    //   2408: ldc_w 1554
    //   2411: ldc_w 1554
    //   2414: iconst_0
    //   2415: iconst_2
    //   2416: ldc_w 773
    //   2419: ldc 163
    //   2421: ldc 163
    //   2423: ldc 163
    //   2425: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2428: goto +11387 -> 13815
    //   2431: astore_1
    //   2432: aload_1
    //   2433: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2436: goto -37 -> 2399
    //   2439: astore_1
    //   2440: aload_1
    //   2441: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2444: goto +11371 -> 13815
    //   2447: aload_0
    //   2448: aload_3
    //   2449: iload 6
    //   2451: iconst_0
    //   2452: aload_1
    //   2453: invokevirtual 1392	ufd:a	(Ljava/lang/String;IZLjava/lang/String;)V
    //   2456: goto -57 -> 2399
    //   2459: ldc_w 1556
    //   2462: aload 4
    //   2464: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2467: ifeq +239 -> 2706
    //   2470: aload 5
    //   2472: ifnull +11352 -> 13824
    //   2475: aload 5
    //   2477: arraylength
    //   2478: ifle +11346 -> 13824
    //   2481: new 224	org/json/JSONObject
    //   2484: dup
    //   2485: aload 5
    //   2487: iconst_0
    //   2488: aaload
    //   2489: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2492: astore_3
    //   2493: aload_3
    //   2494: ldc_w 533
    //   2497: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2500: astore_1
    //   2501: aload_3
    //   2502: ldc_w 1558
    //   2505: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2508: istore 8
    //   2510: iload 8
    //   2512: bipush 9
    //   2514: if_icmpgt +11303 -> 13817
    //   2517: iload 8
    //   2519: iconst_1
    //   2520: if_icmpge +11290 -> 13810
    //   2523: goto +11294 -> 13817
    //   2526: aload_3
    //   2527: ldc_w 1560
    //   2530: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2533: astore_2
    //   2534: aload_3
    //   2535: ldc_w 1562
    //   2538: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2541: astore_3
    //   2542: aload_3
    //   2543: ifnull +11261 -> 13804
    //   2546: aload_3
    //   2547: invokevirtual 547	org/json/JSONArray:length	()I
    //   2550: iconst_1
    //   2551: if_icmpne +11253 -> 13804
    //   2554: aload_3
    //   2555: iconst_0
    //   2556: invokevirtual 1471	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2559: astore_3
    //   2560: ldc_w 1564
    //   2563: aload_3
    //   2564: invokevirtual 1567	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2567: ifeq +91 -> 2658
    //   2570: iconst_1
    //   2571: istore 6
    //   2573: iconst_0
    //   2574: istore 9
    //   2576: iload 9
    //   2578: istore 7
    //   2580: aload_2
    //   2581: ifnull +34 -> 2615
    //   2584: iload 9
    //   2586: istore 7
    //   2588: aload_2
    //   2589: invokevirtual 547	org/json/JSONArray:length	()I
    //   2592: iconst_1
    //   2593: if_icmpne +22 -> 2615
    //   2596: aload_2
    //   2597: iconst_0
    //   2598: invokevirtual 1471	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2601: astore_2
    //   2602: ldc_w 1569
    //   2605: aload_2
    //   2606: invokevirtual 1567	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2609: ifeq +65 -> 2674
    //   2612: iconst_1
    //   2613: istore 7
    //   2615: aload_0
    //   2616: iload 6
    //   2618: iload 7
    //   2620: aload_1
    //   2621: iload 8
    //   2623: invokevirtual 1571	ufd:a	(IILjava/lang/String;I)V
    //   2626: aconst_null
    //   2627: ldc_w 756
    //   2630: ldc_w 758
    //   2633: ldc 163
    //   2635: ldc_w 1573
    //   2638: ldc_w 1573
    //   2641: iconst_0
    //   2642: iconst_2
    //   2643: ldc_w 773
    //   2646: ldc 163
    //   2648: ldc 163
    //   2650: ldc 163
    //   2652: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2655: goto +11169 -> 13824
    //   2658: ldc_w 1575
    //   2661: aload_3
    //   2662: invokevirtual 1567	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2665: ifeq +11139 -> 13804
    //   2668: iconst_2
    //   2669: istore 6
    //   2671: goto -98 -> 2573
    //   2674: ldc_w 1577
    //   2677: aload_2
    //   2678: invokevirtual 1567	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2681: istore 13
    //   2683: iload 9
    //   2685: istore 7
    //   2687: iload 13
    //   2689: ifeq -74 -> 2615
    //   2692: iconst_2
    //   2693: istore 7
    //   2695: goto -80 -> 2615
    //   2698: astore_1
    //   2699: aload_1
    //   2700: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2703: goto +11121 -> 13824
    //   2706: ldc_w 1579
    //   2709: aload 4
    //   2711: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2714: ifeq +119 -> 2833
    //   2717: aload 5
    //   2719: ifnull +104 -> 2823
    //   2722: aload 5
    //   2724: arraylength
    //   2725: ifle +98 -> 2823
    //   2728: new 224	org/json/JSONObject
    //   2731: dup
    //   2732: aload 5
    //   2734: iconst_0
    //   2735: aaload
    //   2736: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2739: ldc_w 533
    //   2742: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2745: putstatic 1581	ufd:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2748: getstatic 1581	ufd:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2751: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2754: ifne +40 -> 2794
    //   2757: aload_0
    //   2758: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2761: ifnonnull +26 -> 2787
    //   2764: aload_0
    //   2765: new 1325	ufa
    //   2768: dup
    //   2769: aload_0
    //   2770: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   2773: aload_0
    //   2774: getfield 1326	ufd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2777: aload_0
    //   2778: getfield 485	ufd:mRuntime	Lbgve;
    //   2781: invokespecial 1329	ufa:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbgve;)V
    //   2784: putfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2787: aload_0
    //   2788: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2791: invokevirtual 1582	ufa:b	()V
    //   2794: aconst_null
    //   2795: ldc_w 756
    //   2798: ldc_w 758
    //   2801: ldc 163
    //   2803: ldc_w 1584
    //   2806: ldc_w 1584
    //   2809: iconst_0
    //   2810: iconst_2
    //   2811: ldc_w 773
    //   2814: ldc 163
    //   2816: ldc 163
    //   2818: ldc 163
    //   2820: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2823: iconst_1
    //   2824: ireturn
    //   2825: astore_1
    //   2826: aload_1
    //   2827: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2830: goto -7 -> 2823
    //   2833: ldc_w 1586
    //   2836: aload 4
    //   2838: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2841: ifeq +154 -> 2995
    //   2844: aload 5
    //   2846: ifnull +82 -> 2928
    //   2849: aload 5
    //   2851: arraylength
    //   2852: ifle +76 -> 2928
    //   2855: new 224	org/json/JSONObject
    //   2858: dup
    //   2859: aload 5
    //   2861: iconst_0
    //   2862: aaload
    //   2863: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2866: ldc_w 533
    //   2869: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2872: putstatic 1588	ufd:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2875: aload_0
    //   2876: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2879: ifnull +51 -> 2930
    //   2882: aload_0
    //   2883: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2886: invokevirtual 1590	ufa:a	()Z
    //   2889: ifeq +41 -> 2930
    //   2892: aload_0
    //   2893: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   2896: invokevirtual 1591	ufa:c	()V
    //   2899: aconst_null
    //   2900: ldc_w 756
    //   2903: ldc_w 758
    //   2906: ldc 163
    //   2908: ldc_w 1593
    //   2911: ldc_w 1593
    //   2914: iconst_0
    //   2915: iconst_2
    //   2916: ldc_w 773
    //   2919: ldc 163
    //   2921: ldc 163
    //   2923: ldc 163
    //   2925: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2928: iconst_1
    //   2929: ireturn
    //   2930: new 224	org/json/JSONObject
    //   2933: dup
    //   2934: invokespecial 225	org/json/JSONObject:<init>	()V
    //   2937: astore_1
    //   2938: aload_1
    //   2939: ldc_w 314
    //   2942: iconst_m1
    //   2943: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2946: pop
    //   2947: aload_1
    //   2948: ldc_w 406
    //   2951: ldc_w 1595
    //   2954: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2957: pop
    //   2958: aload_0
    //   2959: getstatic 1588	ufd:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2962: iconst_1
    //   2963: anewarray 201	java/lang/String
    //   2966: dup
    //   2967: iconst_0
    //   2968: aload_1
    //   2969: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2972: aastore
    //   2973: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2976: goto -77 -> 2899
    //   2979: astore_1
    //   2980: aload_1
    //   2981: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2984: goto -85 -> 2899
    //   2987: astore_1
    //   2988: aload_1
    //   2989: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   2992: goto -64 -> 2928
    //   2995: ldc_w 1597
    //   2998: aload 4
    //   3000: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3003: ifeq +380 -> 3383
    //   3006: aload 5
    //   3008: ifnull +10818 -> 13826
    //   3011: aload 5
    //   3013: arraylength
    //   3014: ifle +10812 -> 13826
    //   3017: new 224	org/json/JSONObject
    //   3020: dup
    //   3021: aload 5
    //   3023: iconst_0
    //   3024: aaload
    //   3025: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3028: astore_1
    //   3029: aload_1
    //   3030: ldc_w 533
    //   3033: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3036: putstatic 1599	ufd:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3039: aload_1
    //   3040: ldc_w 1507
    //   3043: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3046: astore_1
    //   3047: getstatic 1599	ufd:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3050: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3053: ifne +165 -> 3218
    //   3056: aload_1
    //   3057: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3060: ifne +266 -> 3326
    //   3063: aload_0
    //   3064: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3067: ifnull +15 -> 3082
    //   3070: aload_0
    //   3071: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3074: invokevirtual 1601	ufa:b	()Z
    //   3077: ifeq +5 -> 3082
    //   3080: iconst_1
    //   3081: ireturn
    //   3082: aload_0
    //   3083: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3086: ifnonnull +26 -> 3112
    //   3089: aload_0
    //   3090: new 1325	ufa
    //   3093: dup
    //   3094: aload_0
    //   3095: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   3098: aload_0
    //   3099: getfield 1326	ufd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3102: aload_0
    //   3103: getfield 485	ufd:mRuntime	Lbgve;
    //   3106: invokespecial 1329	ufa:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbgve;)V
    //   3109: putfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3112: aload_0
    //   3113: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3116: aload_1
    //   3117: invokevirtual 1544	ufa:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3120: astore_2
    //   3121: new 224	org/json/JSONObject
    //   3124: dup
    //   3125: invokespecial 225	org/json/JSONObject:<init>	()V
    //   3128: astore_1
    //   3129: new 1173	java/io/File
    //   3132: dup
    //   3133: aload_2
    //   3134: invokespecial 1174	java/io/File:<init>	(Ljava/lang/String;)V
    //   3137: invokevirtual 1512	java/io/File:exists	()Z
    //   3140: ifeq +126 -> 3266
    //   3143: aload_0
    //   3144: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3147: aload_2
    //   3148: invokevirtual 1602	ufa:b	(Ljava/lang/String;)V
    //   3151: aload_1
    //   3152: ldc_w 314
    //   3155: iconst_0
    //   3156: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3159: pop
    //   3160: aload_1
    //   3161: ldc_w 406
    //   3164: ldc_w 1604
    //   3167: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3170: pop
    //   3171: aconst_null
    //   3172: ldc_w 756
    //   3175: ldc_w 758
    //   3178: ldc 163
    //   3180: ldc_w 1606
    //   3183: ldc_w 1606
    //   3186: iconst_0
    //   3187: iconst_0
    //   3188: ldc_w 773
    //   3191: ldc 163
    //   3193: ldc 163
    //   3195: ldc 163
    //   3197: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3200: aload_0
    //   3201: getstatic 1599	ufd:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3204: iconst_1
    //   3205: anewarray 201	java/lang/String
    //   3208: dup
    //   3209: iconst_0
    //   3210: aload_1
    //   3211: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3214: aastore
    //   3215: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3218: aconst_null
    //   3219: ldc_w 756
    //   3222: ldc_w 758
    //   3225: ldc 163
    //   3227: ldc_w 1606
    //   3230: ldc_w 1606
    //   3233: iconst_0
    //   3234: iconst_2
    //   3235: ldc_w 773
    //   3238: ldc 163
    //   3240: ldc 163
    //   3242: ldc 163
    //   3244: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3247: goto +10579 -> 13826
    //   3250: astore_2
    //   3251: aload_2
    //   3252: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3255: goto -84 -> 3171
    //   3258: astore_1
    //   3259: aload_1
    //   3260: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3263: goto +10563 -> 13826
    //   3266: aload_1
    //   3267: ldc_w 314
    //   3270: iconst_m1
    //   3271: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3274: pop
    //   3275: aload_1
    //   3276: ldc_w 406
    //   3279: ldc_w 1540
    //   3282: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3285: pop
    //   3286: aconst_null
    //   3287: ldc_w 756
    //   3290: ldc_w 758
    //   3293: ldc 163
    //   3295: ldc_w 1606
    //   3298: ldc_w 1606
    //   3301: iconst_0
    //   3302: iconst_m1
    //   3303: ldc_w 773
    //   3306: ldc 163
    //   3308: ldc 163
    //   3310: ldc 163
    //   3312: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3315: goto -115 -> 3200
    //   3318: astore_2
    //   3319: aload_2
    //   3320: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3323: goto -37 -> 3286
    //   3326: new 224	org/json/JSONObject
    //   3329: dup
    //   3330: invokespecial 225	org/json/JSONObject:<init>	()V
    //   3333: astore_1
    //   3334: aload_1
    //   3335: ldc_w 314
    //   3338: iconst_m1
    //   3339: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3342: pop
    //   3343: aload_1
    //   3344: ldc_w 406
    //   3347: ldc_w 1608
    //   3350: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3353: pop
    //   3354: aload_0
    //   3355: getstatic 1599	ufd:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3358: iconst_1
    //   3359: anewarray 201	java/lang/String
    //   3362: dup
    //   3363: iconst_0
    //   3364: aload_1
    //   3365: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3368: aastore
    //   3369: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3372: goto -154 -> 3218
    //   3375: astore_1
    //   3376: aload_1
    //   3377: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3380: goto -162 -> 3218
    //   3383: ldc_w 1610
    //   3386: aload 4
    //   3388: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3391: ifeq +226 -> 3617
    //   3394: aload 5
    //   3396: ifnull +10432 -> 13828
    //   3399: aload 5
    //   3401: arraylength
    //   3402: ifle +10426 -> 13828
    //   3405: new 224	org/json/JSONObject
    //   3408: dup
    //   3409: aload 5
    //   3411: iconst_0
    //   3412: aaload
    //   3413: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3416: astore_2
    //   3417: aload_2
    //   3418: ldc_w 533
    //   3421: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3424: astore_1
    //   3425: aload_2
    //   3426: ldc_w 1507
    //   3429: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3432: astore_2
    //   3433: aload_2
    //   3434: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3437: ifne +132 -> 3569
    //   3440: aload_0
    //   3441: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3444: ifnonnull +26 -> 3470
    //   3447: aload_0
    //   3448: new 1325	ufa
    //   3451: dup
    //   3452: aload_0
    //   3453: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   3456: aload_0
    //   3457: getfield 1326	ufd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3460: aload_0
    //   3461: getfield 485	ufd:mRuntime	Lbgve;
    //   3464: invokespecial 1329	ufa:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbgve;)V
    //   3467: putfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3470: aload_0
    //   3471: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3474: aload_2
    //   3475: invokevirtual 1544	ufa:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3478: pop
    //   3479: aload_0
    //   3480: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3483: invokevirtual 1601	ufa:b	()Z
    //   3486: ifeq +83 -> 3569
    //   3489: aload_0
    //   3490: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3493: invokevirtual 1611	ufa:g	()V
    //   3496: new 224	org/json/JSONObject
    //   3499: dup
    //   3500: invokespecial 225	org/json/JSONObject:<init>	()V
    //   3503: astore_2
    //   3504: aload_2
    //   3505: ldc_w 314
    //   3508: iconst_0
    //   3509: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3512: pop
    //   3513: aload_2
    //   3514: ldc_w 406
    //   3517: ldc_w 1604
    //   3520: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3523: pop
    //   3524: aload_0
    //   3525: aload_1
    //   3526: iconst_1
    //   3527: anewarray 201	java/lang/String
    //   3530: dup
    //   3531: iconst_0
    //   3532: aload_2
    //   3533: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3536: aastore
    //   3537: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3540: aconst_null
    //   3541: ldc_w 756
    //   3544: ldc_w 758
    //   3547: ldc 163
    //   3549: ldc_w 1613
    //   3552: ldc_w 1613
    //   3555: iconst_0
    //   3556: iconst_0
    //   3557: ldc_w 773
    //   3560: ldc 163
    //   3562: ldc 163
    //   3564: ldc 163
    //   3566: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3569: aconst_null
    //   3570: ldc_w 756
    //   3573: ldc_w 758
    //   3576: ldc 163
    //   3578: ldc_w 1613
    //   3581: ldc_w 1613
    //   3584: iconst_0
    //   3585: iconst_2
    //   3586: ldc_w 773
    //   3589: ldc 163
    //   3591: ldc 163
    //   3593: ldc 163
    //   3595: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3598: goto +10230 -> 13828
    //   3601: astore_1
    //   3602: aload_1
    //   3603: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3606: goto -66 -> 3540
    //   3609: astore_1
    //   3610: aload_1
    //   3611: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3614: goto +10214 -> 13828
    //   3617: ldc_w 1615
    //   3620: aload 4
    //   3622: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3625: ifeq +165 -> 3790
    //   3628: aload 5
    //   3630: ifnull +150 -> 3780
    //   3633: aload 5
    //   3635: arraylength
    //   3636: ifle +144 -> 3780
    //   3639: new 224	org/json/JSONObject
    //   3642: dup
    //   3643: aload 5
    //   3645: iconst_0
    //   3646: aaload
    //   3647: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3650: astore_1
    //   3651: aload_1
    //   3652: ldc_w 533
    //   3655: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3658: putstatic 1617	ufd:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3661: aload_1
    //   3662: ldc_w 1507
    //   3665: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3668: astore_1
    //   3669: aload_1
    //   3670: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3673: ifne +78 -> 3751
    //   3676: aload_0
    //   3677: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3680: ifnonnull +26 -> 3706
    //   3683: aload_0
    //   3684: new 1325	ufa
    //   3687: dup
    //   3688: aload_0
    //   3689: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   3692: aload_0
    //   3693: getfield 1326	ufd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3696: aload_0
    //   3697: getfield 485	ufd:mRuntime	Lbgve;
    //   3700: invokespecial 1329	ufa:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbgve;)V
    //   3703: putfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3706: aload_0
    //   3707: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3710: aload_1
    //   3711: invokevirtual 1544	ufa:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3714: pop
    //   3715: aload_0
    //   3716: getfield 1323	ufd:jdField_a_of_type_Ufa	Lufa;
    //   3719: invokevirtual 1618	ufa:e	()V
    //   3722: aconst_null
    //   3723: ldc_w 756
    //   3726: ldc_w 758
    //   3729: ldc 163
    //   3731: ldc_w 1620
    //   3734: ldc_w 1620
    //   3737: iconst_0
    //   3738: iconst_0
    //   3739: ldc_w 773
    //   3742: ldc 163
    //   3744: ldc 163
    //   3746: ldc 163
    //   3748: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3751: aconst_null
    //   3752: ldc_w 756
    //   3755: ldc_w 758
    //   3758: ldc 163
    //   3760: ldc_w 1620
    //   3763: ldc_w 1620
    //   3766: iconst_0
    //   3767: iconst_2
    //   3768: ldc_w 773
    //   3771: ldc 163
    //   3773: ldc 163
    //   3775: ldc 163
    //   3777: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3780: iconst_1
    //   3781: ireturn
    //   3782: astore_1
    //   3783: aload_1
    //   3784: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3787: goto -7 -> 3780
    //   3790: ldc_w 1622
    //   3793: aload 4
    //   3795: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3798: ifeq +44 -> 3842
    //   3801: aload 5
    //   3803: ifnull +29 -> 3832
    //   3806: aload 5
    //   3808: arraylength
    //   3809: ifle +23 -> 3832
    //   3812: new 224	org/json/JSONObject
    //   3815: dup
    //   3816: aload 5
    //   3818: iconst_0
    //   3819: aaload
    //   3820: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3823: ldc_w 533
    //   3826: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3829: putstatic 1624	ufd:g	Ljava/lang/String;
    //   3832: iconst_1
    //   3833: ireturn
    //   3834: astore_1
    //   3835: aload_1
    //   3836: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3839: goto -7 -> 3832
    //   3842: ldc_w 1626
    //   3845: aload 4
    //   3847: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3850: ifeq +44 -> 3894
    //   3853: aload 5
    //   3855: ifnull +29 -> 3884
    //   3858: aload 5
    //   3860: arraylength
    //   3861: ifle +23 -> 3884
    //   3864: new 224	org/json/JSONObject
    //   3867: dup
    //   3868: aload 5
    //   3870: iconst_0
    //   3871: aaload
    //   3872: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3875: ldc_w 533
    //   3878: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3881: putstatic 1628	ufd:h	Ljava/lang/String;
    //   3884: iconst_1
    //   3885: ireturn
    //   3886: astore_1
    //   3887: aload_1
    //   3888: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   3891: goto -7 -> 3884
    //   3894: ldc_w 1630
    //   3897: aload 4
    //   3899: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3902: ifeq +171 -> 4073
    //   3905: aload 5
    //   3907: ifnull +144 -> 4051
    //   3910: aload 5
    //   3912: arraylength
    //   3913: ifle +138 -> 4051
    //   3916: new 224	org/json/JSONObject
    //   3919: dup
    //   3920: aload 5
    //   3922: iconst_0
    //   3923: aaload
    //   3924: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3927: astore_1
    //   3928: aload_1
    //   3929: ldc_w 533
    //   3932: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3935: putstatic 1632	ufd:i	Ljava/lang/String;
    //   3938: aload_1
    //   3939: ldc_w 1067
    //   3942: iconst_1
    //   3943: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3946: istore 10
    //   3948: sipush 640
    //   3951: istore 6
    //   3953: sipush 640
    //   3956: istore 7
    //   3958: sipush 640
    //   3961: istore 8
    //   3963: sipush 640
    //   3966: istore 9
    //   3968: aload_1
    //   3969: ldc_w 1634
    //   3972: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3975: ifeq +26 -> 4001
    //   3978: aload_1
    //   3979: ldc_w 1634
    //   3982: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3985: istore 7
    //   3987: aload_0
    //   3988: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   3991: iload 7
    //   3993: iconst_2
    //   3994: idiv
    //   3995: i2f
    //   3996: invokestatic 1643	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   3999: istore 6
    //   4001: aload_1
    //   4002: ldc_w 1645
    //   4005: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4008: ifeq +26 -> 4034
    //   4011: aload_1
    //   4012: ldc_w 1645
    //   4015: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4018: istore 9
    //   4020: aload_0
    //   4021: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   4024: iload 9
    //   4026: iconst_2
    //   4027: idiv
    //   4028: i2f
    //   4029: invokestatic 1643	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   4032: istore 8
    //   4034: aload_0
    //   4035: iconst_1
    //   4036: iload 10
    //   4038: bipush 118
    //   4040: iload 6
    //   4042: iload 8
    //   4044: iload 7
    //   4046: iload 9
    //   4048: invokevirtual 1647	ufd:a	(IIBIIII)V
    //   4051: iconst_1
    //   4052: ireturn
    //   4053: astore_1
    //   4054: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4057: ifeq -6 -> 4051
    //   4060: ldc_w 321
    //   4063: iconst_2
    //   4064: ldc_w 1649
    //   4067: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4070: goto -19 -> 4051
    //   4073: ldc_w 1651
    //   4076: aload 4
    //   4078: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4081: ifeq +195 -> 4276
    //   4084: iconst_0
    //   4085: istore 14
    //   4087: iload 14
    //   4089: istore 13
    //   4091: aload 5
    //   4093: ifnull +142 -> 4235
    //   4096: iload 14
    //   4098: istore 13
    //   4100: aload 5
    //   4102: arraylength
    //   4103: ifle +132 -> 4235
    //   4106: invokestatic 1657	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4109: invokevirtual 1660	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   4112: invokevirtual 1664	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   4115: astore_1
    //   4116: new 224	org/json/JSONObject
    //   4119: dup
    //   4120: aload 5
    //   4122: iconst_0
    //   4123: aaload
    //   4124: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4127: astore_2
    //   4128: aload_2
    //   4129: ldc_w 533
    //   4132: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4135: putstatic 1666	ufd:j	Ljava/lang/String;
    //   4138: aload_2
    //   4139: ldc_w 1067
    //   4142: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4145: istore 10
    //   4147: aload_1
    //   4148: getfield 1671	android/util/DisplayMetrics:widthPixels	I
    //   4151: ldc2_w 1672
    //   4154: invokestatic 1679	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4157: istore 6
    //   4159: aload_1
    //   4160: getfield 1671	android/util/DisplayMetrics:widthPixels	I
    //   4163: ldc2_w 1680
    //   4166: invokestatic 1679	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4169: istore 7
    //   4171: sipush 750
    //   4174: istore 8
    //   4176: sipush 416
    //   4179: istore 9
    //   4181: iload 10
    //   4183: iconst_1
    //   4184: if_icmpne +9646 -> 13830
    //   4187: aload_1
    //   4188: getfield 1671	android/util/DisplayMetrics:widthPixels	I
    //   4191: ldc2_w 1672
    //   4194: invokestatic 1679	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4197: istore 7
    //   4199: sipush 160
    //   4202: istore 9
    //   4204: sipush 160
    //   4207: istore 8
    //   4209: iload 7
    //   4211: istore 6
    //   4213: goto +9617 -> 13830
    //   4216: aload_0
    //   4217: iconst_2
    //   4218: iconst_0
    //   4219: bipush 121
    //   4221: iload 6
    //   4223: iload 7
    //   4225: iload 8
    //   4227: iload 9
    //   4229: invokevirtual 1647	ufd:a	(IIBIIII)V
    //   4232: iconst_1
    //   4233: istore 13
    //   4235: ldc_w 321
    //   4238: iconst_1
    //   4239: new 507	java/lang/StringBuilder
    //   4242: dup
    //   4243: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   4246: ldc_w 1683
    //   4249: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4252: aload 5
    //   4254: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4257: ldc_w 1685
    //   4260: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4263: iload 13
    //   4265: invokevirtual 1688	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4268: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4271: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4274: iconst_1
    //   4275: ireturn
    //   4276: ldc_w 1690
    //   4279: aload 4
    //   4281: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4284: ifeq +198 -> 4482
    //   4287: aload_0
    //   4288: getfield 161	ufd:jdField_a_of_type_Boolean	Z
    //   4291: ifeq +5 -> 4296
    //   4294: iconst_1
    //   4295: ireturn
    //   4296: aload 5
    //   4298: ifnull +182 -> 4480
    //   4301: aload 5
    //   4303: arraylength
    //   4304: ifle +176 -> 4480
    //   4307: new 224	org/json/JSONObject
    //   4310: dup
    //   4311: aload 5
    //   4313: iconst_0
    //   4314: aaload
    //   4315: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4318: astore_2
    //   4319: aload_2
    //   4320: ldc_w 1692
    //   4323: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4326: putstatic 1694	ufd:l	Ljava/lang/String;
    //   4329: aload_2
    //   4330: ldc_w 1696
    //   4333: ldc_w 1698
    //   4336: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4339: pop
    //   4340: aload_0
    //   4341: getfield 485	ufd:mRuntime	Lbgve;
    //   4344: invokevirtual 1701	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   4347: astore_1
    //   4348: aload_1
    //   4349: ifnull +9444 -> 13793
    //   4352: aload_1
    //   4353: invokevirtual 1706	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   4356: astore_1
    //   4357: aload_2
    //   4358: ldc_w 267
    //   4361: aload_1
    //   4362: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4365: pop
    //   4366: aload_2
    //   4367: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4370: astore_3
    //   4371: aload_0
    //   4372: aload_2
    //   4373: ldc_w 533
    //   4376: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4379: putfield 1708	ufd:m	Ljava/lang/String;
    //   4382: aload_2
    //   4383: ldc_w 1710
    //   4386: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   4389: astore_2
    //   4390: new 174	java/util/ArrayList
    //   4393: dup
    //   4394: invokespecial 175	java/util/ArrayList:<init>	()V
    //   4397: astore 4
    //   4399: aload_2
    //   4400: ifnull +41 -> 4441
    //   4403: aload 4
    //   4405: invokevirtual 1398	java/util/ArrayList:clear	()V
    //   4408: iconst_0
    //   4409: istore 6
    //   4411: iload 6
    //   4413: aload_2
    //   4414: invokevirtual 547	org/json/JSONArray:length	()I
    //   4417: if_icmpge +24 -> 4441
    //   4420: aload 4
    //   4422: aload_2
    //   4423: iload 6
    //   4425: invokevirtual 1471	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   4428: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4431: pop
    //   4432: iload 6
    //   4434: iconst_1
    //   4435: iadd
    //   4436: istore 6
    //   4438: goto -27 -> 4411
    //   4441: getstatic 128	ufd:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   4444: aload_1
    //   4445: invokeinterface 1243 2 0
    //   4450: pop
    //   4451: getstatic 130	ufd:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   4454: aload_1
    //   4455: aload 4
    //   4457: invokeinterface 1711 3 0
    //   4462: pop
    //   4463: aload_1
    //   4464: ifnull +9 -> 4473
    //   4467: aload_0
    //   4468: aload_1
    //   4469: aload_3
    //   4470: invokevirtual 1712	ufd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4473: iconst_1
    //   4474: ireturn
    //   4475: astore_1
    //   4476: aload_1
    //   4477: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   4480: iconst_0
    //   4481: ireturn
    //   4482: ldc_w 1714
    //   4485: aload 4
    //   4487: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4490: ifeq +133 -> 4623
    //   4493: new 224	org/json/JSONObject
    //   4496: dup
    //   4497: aload 5
    //   4499: iconst_0
    //   4500: aaload
    //   4501: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4504: astore_2
    //   4505: aload_2
    //   4506: ldc_w 533
    //   4509: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4512: astore_1
    //   4513: aload_2
    //   4514: ldc_w 1716
    //   4517: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4520: istore 6
    //   4522: aload_0
    //   4523: getfield 485	ufd:mRuntime	Lbgve;
    //   4526: invokevirtual 1018	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4529: ifnull +50 -> 4579
    //   4532: aload_0
    //   4533: getfield 485	ufd:mRuntime	Lbgve;
    //   4536: invokevirtual 1018	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4539: getfield 1720	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4542: ifnull +37 -> 4579
    //   4545: aload_0
    //   4546: getfield 485	ufd:mRuntime	Lbgve;
    //   4549: invokevirtual 1018	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4552: getfield 1720	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4555: getfield 1726	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mSwiftTitleUI	Lbgtw;
    //   4558: ifnull +21 -> 4579
    //   4561: aload_0
    //   4562: getfield 485	ufd:mRuntime	Lbgve;
    //   4565: invokevirtual 1018	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4568: getfield 1720	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4571: getfield 1726	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mSwiftTitleUI	Lbgtw;
    //   4574: iload 6
    //   4576: invokevirtual 1731	bgtw:setRightViewTextDisable	(I)V
    //   4579: new 224	org/json/JSONObject
    //   4582: dup
    //   4583: invokespecial 225	org/json/JSONObject:<init>	()V
    //   4586: astore_2
    //   4587: aload_2
    //   4588: ldc_w 314
    //   4591: iconst_0
    //   4592: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4595: pop
    //   4596: aload_0
    //   4597: aload_1
    //   4598: iconst_1
    //   4599: anewarray 201	java/lang/String
    //   4602: dup
    //   4603: iconst_0
    //   4604: aload_2
    //   4605: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4608: aastore
    //   4609: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4612: goto -132 -> 4480
    //   4615: astore_1
    //   4616: aload_1
    //   4617: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   4620: goto -140 -> 4480
    //   4623: ldc_w 1733
    //   4626: aload 4
    //   4628: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4631: ifeq +367 -> 4998
    //   4634: aload 5
    //   4636: ifnull +352 -> 4988
    //   4639: aload 5
    //   4641: arraylength
    //   4642: ifle +346 -> 4988
    //   4645: new 224	org/json/JSONObject
    //   4648: dup
    //   4649: aload 5
    //   4651: iconst_0
    //   4652: aaload
    //   4653: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4656: astore_2
    //   4657: aload_2
    //   4658: ldc_w 533
    //   4661: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4664: astore_1
    //   4665: aload_2
    //   4666: ldc_w 267
    //   4669: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4672: astore_3
    //   4673: aload_1
    //   4674: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4677: ifne +311 -> 4988
    //   4680: aload_3
    //   4681: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4684: ifne +304 -> 4988
    //   4687: new 224	org/json/JSONObject
    //   4690: dup
    //   4691: invokespecial 225	org/json/JSONObject:<init>	()V
    //   4694: astore_2
    //   4695: aload_2
    //   4696: ldc_w 314
    //   4699: iconst_0
    //   4700: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4703: pop
    //   4704: aload_2
    //   4705: ldc_w 406
    //   4708: ldc_w 1448
    //   4711: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4714: pop
    //   4715: iconst_0
    //   4716: istore 14
    //   4718: aload_3
    //   4719: invokestatic 1737	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4722: astore_3
    //   4723: iload 14
    //   4725: istore 13
    //   4727: aload_3
    //   4728: ifnull +27 -> 4755
    //   4731: iload 14
    //   4733: istore 13
    //   4735: new 1173	java/io/File
    //   4738: dup
    //   4739: getstatic 1740	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   4742: aload_3
    //   4743: invokespecial 1742	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   4746: invokevirtual 1512	java/io/File:exists	()Z
    //   4749: ifeq +6 -> 4755
    //   4752: iconst_1
    //   4753: istore 13
    //   4755: aload_2
    //   4756: ldc_w 1744
    //   4759: iload 13
    //   4761: invokevirtual 1747	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4764: pop
    //   4765: invokestatic 1751	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   4768: invokevirtual 1755	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   4771: astore_3
    //   4772: aload_3
    //   4773: ifnull +215 -> 4988
    //   4776: aload_3
    //   4777: ldc_w 1757
    //   4780: invokevirtual 1763	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   4783: checkcast 1304	com/tencent/common/app/AppInterface
    //   4786: astore_3
    //   4787: aload_3
    //   4788: ifnull +200 -> 4988
    //   4791: invokestatic 1657	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4794: new 507	java/lang/StringBuilder
    //   4797: dup
    //   4798: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   4801: ldc_w 1765
    //   4804: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4807: aload_3
    //   4808: invokevirtual 1768	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4811: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4814: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4817: iconst_4
    //   4818: invokevirtual 1772	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   4821: astore_3
    //   4822: aload_3
    //   4823: ifnull +165 -> 4988
    //   4826: aload_3
    //   4827: ldc_w 1774
    //   4830: iconst_0
    //   4831: invokeinterface 1779 3 0
    //   4836: istore 13
    //   4838: aload_3
    //   4839: ldc_w 1781
    //   4842: iconst_0
    //   4843: invokeinterface 1779 3 0
    //   4848: istore 14
    //   4850: aload_3
    //   4851: ldc_w 1783
    //   4854: iconst_0
    //   4855: invokeinterface 1779 3 0
    //   4860: istore 15
    //   4862: aload_3
    //   4863: ldc_w 1785
    //   4866: iconst_0
    //   4867: invokeinterface 1779 3 0
    //   4872: istore 16
    //   4874: aload_3
    //   4875: ldc_w 1787
    //   4878: iconst_0
    //   4879: invokeinterface 1779 3 0
    //   4884: istore 17
    //   4886: aload_2
    //   4887: ldc_w 1789
    //   4890: iload 13
    //   4892: invokevirtual 1747	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4895: pop
    //   4896: aload_2
    //   4897: ldc_w 1791
    //   4900: iload 14
    //   4902: invokevirtual 1747	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4905: pop
    //   4906: aload_2
    //   4907: ldc_w 1793
    //   4910: iload 15
    //   4912: invokevirtual 1747	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4915: pop
    //   4916: aload_2
    //   4917: ldc_w 1795
    //   4920: iload 16
    //   4922: invokevirtual 1747	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4925: pop
    //   4926: aload_2
    //   4927: ldc_w 1797
    //   4930: iload 17
    //   4932: invokevirtual 1747	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4935: pop
    //   4936: aload_0
    //   4937: aload_1
    //   4938: iconst_1
    //   4939: anewarray 201	java/lang/String
    //   4942: dup
    //   4943: iconst_0
    //   4944: aload_2
    //   4945: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4948: aastore
    //   4949: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4952: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4955: ifeq +33 -> 4988
    //   4958: ldc_w 321
    //   4961: iconst_2
    //   4962: new 507	java/lang/StringBuilder
    //   4965: dup
    //   4966: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   4969: ldc_w 1733
    //   4972: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4975: aload_2
    //   4976: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4979: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4982: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4985: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4988: iconst_1
    //   4989: ireturn
    //   4990: astore_1
    //   4991: aload_1
    //   4992: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   4995: goto -7 -> 4988
    //   4998: ldc_w 1799
    //   5001: aload 4
    //   5003: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5006: ifeq +79 -> 5085
    //   5009: aload_0
    //   5010: iconst_4
    //   5011: invokespecial 959	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5014: checkcast 961	bgww
    //   5017: astore_1
    //   5018: aload_1
    //   5019: ifnull +48 -> 5067
    //   5022: aload_0
    //   5023: getfield 485	ufd:mRuntime	Lbgve;
    //   5026: invokevirtual 1018	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   5029: astore_2
    //   5030: aload_2
    //   5031: ifnull +36 -> 5067
    //   5034: aload_2
    //   5035: invokevirtual 1395	com/tencent/mobileqq/webview/swift/WebViewFragment:showActionSheet	()V
    //   5038: aload_1
    //   5039: getfield 1802	bgww:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5042: ifnull +25 -> 5067
    //   5045: aload_1
    //   5046: getfield 1802	bgww:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5049: getfield 1808	com/tencent/mobileqq/utils/ShareActionSheetBuilder:mScrollView2	Lcom/tencent/biz/widgets/ElasticHorScrView;
    //   5052: ifnull +15 -> 5067
    //   5055: aload_1
    //   5056: getfield 1802	bgww:jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   5059: getfield 1808	com/tencent/mobileqq/utils/ShareActionSheetBuilder:mScrollView2	Lcom/tencent/biz/widgets/ElasticHorScrView;
    //   5062: bipush 8
    //   5064: invokevirtual 1811	com/tencent/biz/widgets/ElasticHorScrView:setVisibility	(I)V
    //   5067: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5070: ifeq +13 -> 5083
    //   5073: ldc_w 321
    //   5076: iconst_2
    //   5077: ldc_w 1799
    //   5080: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5083: iconst_1
    //   5084: ireturn
    //   5085: ldc_w 1813
    //   5088: aload 4
    //   5090: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5093: ifeq +143 -> 5236
    //   5096: new 224	org/json/JSONObject
    //   5099: dup
    //   5100: invokespecial 225	org/json/JSONObject:<init>	()V
    //   5103: astore_3
    //   5104: invokestatic 1817	oof:a	()I
    //   5107: iconst_1
    //   5108: if_icmpne +8739 -> 13847
    //   5111: ldc_w 1819
    //   5114: astore_1
    //   5115: invokestatic 1820	oof:b	()I
    //   5118: iconst_1
    //   5119: if_icmpne +8735 -> 13854
    //   5122: ldc_w 1819
    //   5125: astore_2
    //   5126: aload_3
    //   5127: ldc_w 314
    //   5130: iconst_0
    //   5131: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   5134: pop
    //   5135: aload_3
    //   5136: ldc_w 1822
    //   5139: aload_1
    //   5140: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5143: pop
    //   5144: aload_3
    //   5145: ldc_w 1824
    //   5148: aload_2
    //   5149: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5152: pop
    //   5153: aload 5
    //   5155: ifnull +53 -> 5208
    //   5158: aload 5
    //   5160: arraylength
    //   5161: ifle +47 -> 5208
    //   5164: new 224	org/json/JSONObject
    //   5167: dup
    //   5168: aload 5
    //   5170: iconst_0
    //   5171: aaload
    //   5172: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5175: ldc_w 533
    //   5178: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5181: astore_1
    //   5182: aload_1
    //   5183: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5186: ifne +8659 -> 13845
    //   5189: aload_0
    //   5190: aload_1
    //   5191: iconst_1
    //   5192: anewarray 201	java/lang/String
    //   5195: dup
    //   5196: iconst_0
    //   5197: aload_3
    //   5198: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5201: aastore
    //   5202: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5205: goto +8640 -> 13845
    //   5208: ldc_w 321
    //   5211: iconst_1
    //   5212: ldc_w 1826
    //   5215: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5218: goto +8627 -> 13845
    //   5221: astore_1
    //   5222: ldc_w 321
    //   5225: iconst_1
    //   5226: ldc_w 1828
    //   5229: aload_1
    //   5230: invokestatic 1831	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5233: goto +8612 -> 13845
    //   5236: ldc_w 1833
    //   5239: aload 4
    //   5241: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5244: ifeq +136 -> 5380
    //   5247: aload 5
    //   5249: ifnull +102 -> 5351
    //   5252: aload 5
    //   5254: arraylength
    //   5255: ifle +96 -> 5351
    //   5258: new 224	org/json/JSONObject
    //   5261: dup
    //   5262: aload 5
    //   5264: iconst_0
    //   5265: aaload
    //   5266: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5269: astore_1
    //   5270: aload_1
    //   5271: ldc_w 533
    //   5274: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5277: astore_2
    //   5278: aload_2
    //   5279: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5282: ifne +25 -> 5307
    //   5285: aload_0
    //   5286: aload_2
    //   5287: iconst_1
    //   5288: anewarray 201	java/lang/String
    //   5291: dup
    //   5292: iconst_0
    //   5293: aload_0
    //   5294: getfield 485	ufd:mRuntime	Lbgve;
    //   5297: invokevirtual 1836	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   5300: invokestatic 1841	oze:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   5303: aastore
    //   5304: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5307: new 507	java/lang/StringBuilder
    //   5310: dup
    //   5311: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   5314: ldc 163
    //   5316: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5319: aload_1
    //   5320: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5323: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5326: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5329: astore_1
    //   5330: ldc_w 321
    //   5333: iconst_1
    //   5334: iconst_2
    //   5335: anewarray 830	java/lang/Object
    //   5338: dup
    //   5339: iconst_0
    //   5340: ldc_w 1828
    //   5343: aastore
    //   5344: dup
    //   5345: iconst_1
    //   5346: aload_1
    //   5347: aastore
    //   5348: invokestatic 839	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5351: iconst_1
    //   5352: ireturn
    //   5353: astore_1
    //   5354: new 507	java/lang/StringBuilder
    //   5357: dup
    //   5358: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   5361: ldc 163
    //   5363: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5366: aload_1
    //   5367: invokevirtual 1842	org/json/JSONException:toString	()Ljava/lang/String;
    //   5370: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5373: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5376: astore_1
    //   5377: goto -47 -> 5330
    //   5380: ldc_w 1844
    //   5383: aload 4
    //   5385: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5388: ifeq +138 -> 5526
    //   5391: aload 5
    //   5393: ifnull +104 -> 5497
    //   5396: aload 5
    //   5398: arraylength
    //   5399: ifle +98 -> 5497
    //   5402: new 224	org/json/JSONObject
    //   5405: dup
    //   5406: aload 5
    //   5408: iconst_0
    //   5409: aaload
    //   5410: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5413: astore_1
    //   5414: aload_1
    //   5415: ldc_w 533
    //   5418: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5421: astore_2
    //   5422: aload_1
    //   5423: ldc_w 1846
    //   5426: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5429: astore_3
    //   5430: aload_2
    //   5431: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5434: ifne +19 -> 5453
    //   5437: aload_0
    //   5438: aload_2
    //   5439: iconst_1
    //   5440: anewarray 201	java/lang/String
    //   5443: dup
    //   5444: iconst_0
    //   5445: aload_3
    //   5446: invokestatic 1849	com/tencent/biz/pubaccount/util/Achilles:a	(Ljava/lang/String;)Ljava/lang/String;
    //   5449: aastore
    //   5450: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5453: new 507	java/lang/StringBuilder
    //   5456: dup
    //   5457: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   5460: ldc 163
    //   5462: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5465: aload_1
    //   5466: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5469: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5472: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5475: astore_1
    //   5476: ldc_w 321
    //   5479: iconst_1
    //   5480: iconst_2
    //   5481: anewarray 830	java/lang/Object
    //   5484: dup
    //   5485: iconst_0
    //   5486: ldc_w 1828
    //   5489: aastore
    //   5490: dup
    //   5491: iconst_1
    //   5492: aload_1
    //   5493: aastore
    //   5494: invokestatic 839	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5497: iconst_1
    //   5498: ireturn
    //   5499: astore_1
    //   5500: new 507	java/lang/StringBuilder
    //   5503: dup
    //   5504: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   5507: ldc 163
    //   5509: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5512: aload_1
    //   5513: invokevirtual 1850	java/lang/Exception:toString	()Ljava/lang/String;
    //   5516: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5519: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5522: astore_1
    //   5523: goto -47 -> 5476
    //   5526: ldc_w 1852
    //   5529: aload 4
    //   5531: invokevirtual 1567	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5534: ifeq +138 -> 5672
    //   5537: aload 5
    //   5539: ifnull +101 -> 5640
    //   5542: aload 5
    //   5544: arraylength
    //   5545: ifle +95 -> 5640
    //   5548: new 224	org/json/JSONObject
    //   5551: dup
    //   5552: aload 5
    //   5554: iconst_0
    //   5555: aaload
    //   5556: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5559: astore_1
    //   5560: aload_1
    //   5561: ldc_w 533
    //   5564: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5567: astore_2
    //   5568: aload_1
    //   5569: ldc_w 1846
    //   5572: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5575: astore_3
    //   5576: aload_2
    //   5577: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5580: ifne +16 -> 5596
    //   5583: aload_2
    //   5584: aload_3
    //   5585: aload_0
    //   5586: getfield 485	ufd:mRuntime	Lbgve;
    //   5589: iconst_0
    //   5590: invokestatic 1855	com/tencent/biz/pubaccount/util/Achilles:a	(Ljava/lang/String;Ljava/lang/String;Lbgve;Z)Z
    //   5593: ifeq +49 -> 5642
    //   5596: new 507	java/lang/StringBuilder
    //   5599: dup
    //   5600: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   5603: ldc 163
    //   5605: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: aload_1
    //   5609: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5612: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5615: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5618: astore_1
    //   5619: ldc_w 321
    //   5622: iconst_1
    //   5623: iconst_2
    //   5624: anewarray 830	java/lang/Object
    //   5627: dup
    //   5628: iconst_0
    //   5629: ldc_w 1828
    //   5632: aastore
    //   5633: dup
    //   5634: iconst_1
    //   5635: aload_1
    //   5636: aastore
    //   5637: invokestatic 839	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5640: iconst_1
    //   5641: ireturn
    //   5642: goto -46 -> 5596
    //   5645: astore_1
    //   5646: new 507	java/lang/StringBuilder
    //   5649: dup
    //   5650: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   5653: ldc 163
    //   5655: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5658: aload_1
    //   5659: invokevirtual 1850	java/lang/Exception:toString	()Ljava/lang/String;
    //   5662: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5665: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5668: astore_1
    //   5669: goto -50 -> 5619
    //   5672: ldc_w 1857
    //   5675: aload 4
    //   5677: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5680: ifeq +66 -> 5746
    //   5683: aload 5
    //   5685: ifnull -1205 -> 4480
    //   5688: aload 5
    //   5690: arraylength
    //   5691: ifle -1211 -> 4480
    //   5694: new 224	org/json/JSONObject
    //   5697: dup
    //   5698: aload 5
    //   5700: iconst_0
    //   5701: aaload
    //   5702: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5705: ldc_w 1859
    //   5708: iconst_1
    //   5709: invokevirtual 638	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5712: istore 13
    //   5714: getstatic 1864	qoj:a	Lqok;
    //   5717: invokevirtual 1869	qok:a	()Lqoj;
    //   5720: iload 13
    //   5722: ldc_w 1871
    //   5725: invokevirtual 1874	qoj:a	(ZLjava/lang/String;)V
    //   5728: goto -1248 -> 4480
    //   5731: astore_1
    //   5732: ldc_w 321
    //   5735: iconst_1
    //   5736: aload_1
    //   5737: invokevirtual 1842	org/json/JSONException:toString	()Ljava/lang/String;
    //   5740: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5743: goto -1263 -> 4480
    //   5746: ldc_w 1876
    //   5749: aload 4
    //   5751: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5754: ifeq +140 -> 5894
    //   5757: aload 5
    //   5759: ifnull -1279 -> 4480
    //   5762: aload 5
    //   5764: arraylength
    //   5765: ifle -1285 -> 4480
    //   5768: new 224	org/json/JSONObject
    //   5771: dup
    //   5772: aload 5
    //   5774: iconst_0
    //   5775: aaload
    //   5776: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5779: astore_3
    //   5780: aload_3
    //   5781: ldc_w 1067
    //   5784: iconst_0
    //   5785: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5788: istore 6
    //   5790: aload_3
    //   5791: ldc_w 1878
    //   5794: iconst_0
    //   5795: invokevirtual 638	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5798: istore 13
    //   5800: aload_3
    //   5801: ldc_w 1880
    //   5804: iconst_0
    //   5805: invokevirtual 638	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5808: istore 14
    //   5810: aload_3
    //   5811: ldc_w 1882
    //   5814: ldc 163
    //   5816: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5819: astore_1
    //   5820: aload_3
    //   5821: ldc_w 1884
    //   5824: iconst_1
    //   5825: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5828: istore 7
    //   5830: aload_3
    //   5831: ldc_w 1886
    //   5834: ldc 163
    //   5836: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5839: astore_2
    //   5840: aload_3
    //   5841: ldc_w 533
    //   5844: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5847: astore_3
    //   5848: getstatic 1864	qoj:a	Lqok;
    //   5851: invokevirtual 1869	qok:a	()Lqoj;
    //   5854: iload 6
    //   5856: iload 13
    //   5858: iload 14
    //   5860: aload_1
    //   5861: iload 7
    //   5863: aload_2
    //   5864: new 1888	ufv
    //   5867: dup
    //   5868: aload_0
    //   5869: aload_3
    //   5870: invokespecial 1889	ufv:<init>	(Lufd;Ljava/lang/String;)V
    //   5873: invokevirtual 1892	qoj:a	(IZZLjava/lang/String;ILjava/lang/String;Lqol;)V
    //   5876: goto -1396 -> 4480
    //   5879: astore_1
    //   5880: ldc_w 321
    //   5883: iconst_1
    //   5884: aload_1
    //   5885: invokevirtual 1842	org/json/JSONException:toString	()Ljava/lang/String;
    //   5888: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5891: goto -1411 -> 4480
    //   5894: ldc_w 1894
    //   5897: aload 4
    //   5899: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5902: ifeq +2571 -> 8473
    //   5905: aload 5
    //   5907: ifnull -1427 -> 4480
    //   5910: aload 5
    //   5912: arraylength
    //   5913: ifle -1433 -> 4480
    //   5916: new 224	org/json/JSONObject
    //   5919: dup
    //   5920: aload 5
    //   5922: iconst_0
    //   5923: aaload
    //   5924: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5927: astore 43
    //   5929: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5932: ifeq +34 -> 5966
    //   5935: ldc_w 321
    //   5938: iconst_2
    //   5939: new 507	java/lang/StringBuilder
    //   5942: dup
    //   5943: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   5946: ldc_w 1896
    //   5949: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5952: aload 43
    //   5954: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5957: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5960: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5963: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5966: aload 43
    //   5968: ldc_w 606
    //   5971: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5974: astore 42
    //   5976: aload 43
    //   5978: ldc_w 608
    //   5981: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5984: astore_3
    //   5985: aload 43
    //   5987: ldc_w 1898
    //   5990: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5993: astore 41
    //   5995: aload 41
    //   5997: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6000: ifeq +7861 -> 13861
    //   6003: aload_2
    //   6004: astore 41
    //   6006: aload 43
    //   6008: ldc_w 1900
    //   6011: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6014: istore 10
    //   6016: ldc 163
    //   6018: astore 5
    //   6020: iload 10
    //   6022: iconst_1
    //   6023: if_icmpne +24 -> 6047
    //   6026: new 201	java/lang/String
    //   6029: dup
    //   6030: aload 43
    //   6032: ldc_w 1902
    //   6035: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6038: iconst_2
    //   6039: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   6042: invokespecial 798	java/lang/String:<init>	([B)V
    //   6045: astore 5
    //   6047: lconst_0
    //   6048: lstore 18
    //   6050: lconst_0
    //   6051: lstore 22
    //   6053: lconst_0
    //   6054: lstore 24
    //   6056: lconst_0
    //   6057: lstore 36
    //   6059: lconst_0
    //   6060: lstore 38
    //   6062: ldc 163
    //   6064: astore 40
    //   6066: new 201	java/lang/String
    //   6069: dup
    //   6070: aload 42
    //   6072: iconst_0
    //   6073: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   6076: invokespecial 798	java/lang/String:<init>	([B)V
    //   6079: astore_1
    //   6080: new 201	java/lang/String
    //   6083: dup
    //   6084: aload_3
    //   6085: iconst_0
    //   6086: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   6089: invokespecial 798	java/lang/String:<init>	([B)V
    //   6092: astore_2
    //   6093: aload 43
    //   6095: ldc_w 1904
    //   6098: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6101: astore_3
    //   6102: aload 43
    //   6104: ldc_w 519
    //   6107: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6110: astore 4
    //   6112: aload 4
    //   6114: astore 40
    //   6116: lload 18
    //   6118: lstore 20
    //   6120: lload 38
    //   6122: lstore 34
    //   6124: lload 36
    //   6126: lstore 32
    //   6128: lload 24
    //   6130: lstore 30
    //   6132: lload 22
    //   6134: lstore 28
    //   6136: lload 18
    //   6138: lstore 26
    //   6140: aload_3
    //   6141: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6144: ifne +36 -> 6180
    //   6147: lload 38
    //   6149: lstore 34
    //   6151: lload 36
    //   6153: lstore 32
    //   6155: lload 24
    //   6157: lstore 30
    //   6159: lload 22
    //   6161: lstore 28
    //   6163: lload 18
    //   6165: lstore 26
    //   6167: new 1906	java/math/BigInteger
    //   6170: dup
    //   6171: aload_3
    //   6172: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6175: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   6178: lstore 20
    //   6180: lload 38
    //   6182: lstore 34
    //   6184: lload 36
    //   6186: lstore 32
    //   6188: lload 24
    //   6190: lstore 30
    //   6192: lload 22
    //   6194: lstore 28
    //   6196: lload 20
    //   6198: lstore 26
    //   6200: aload 43
    //   6202: ldc_w 1912
    //   6205: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6208: astore 4
    //   6210: lload 22
    //   6212: lstore 18
    //   6214: lload 38
    //   6216: lstore 34
    //   6218: lload 36
    //   6220: lstore 32
    //   6222: lload 24
    //   6224: lstore 30
    //   6226: lload 22
    //   6228: lstore 28
    //   6230: lload 20
    //   6232: lstore 26
    //   6234: aload 4
    //   6236: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6239: ifne +37 -> 6276
    //   6242: lload 38
    //   6244: lstore 34
    //   6246: lload 36
    //   6248: lstore 32
    //   6250: lload 24
    //   6252: lstore 30
    //   6254: lload 22
    //   6256: lstore 28
    //   6258: lload 20
    //   6260: lstore 26
    //   6262: new 1906	java/math/BigInteger
    //   6265: dup
    //   6266: aload 4
    //   6268: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6271: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   6274: lstore 18
    //   6276: lload 38
    //   6278: lstore 34
    //   6280: lload 36
    //   6282: lstore 32
    //   6284: lload 24
    //   6286: lstore 30
    //   6288: lload 18
    //   6290: lstore 28
    //   6292: lload 20
    //   6294: lstore 26
    //   6296: aload 43
    //   6298: ldc_w 1914
    //   6301: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6304: astore 4
    //   6306: lload 24
    //   6308: lstore 22
    //   6310: lload 38
    //   6312: lstore 34
    //   6314: lload 36
    //   6316: lstore 32
    //   6318: lload 24
    //   6320: lstore 30
    //   6322: lload 18
    //   6324: lstore 28
    //   6326: lload 20
    //   6328: lstore 26
    //   6330: aload 4
    //   6332: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6335: ifne +37 -> 6372
    //   6338: lload 38
    //   6340: lstore 34
    //   6342: lload 36
    //   6344: lstore 32
    //   6346: lload 24
    //   6348: lstore 30
    //   6350: lload 18
    //   6352: lstore 28
    //   6354: lload 20
    //   6356: lstore 26
    //   6358: new 1906	java/math/BigInteger
    //   6361: dup
    //   6362: aload 4
    //   6364: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6367: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   6370: lstore 22
    //   6372: lload 38
    //   6374: lstore 34
    //   6376: lload 36
    //   6378: lstore 32
    //   6380: lload 22
    //   6382: lstore 30
    //   6384: lload 18
    //   6386: lstore 28
    //   6388: lload 20
    //   6390: lstore 26
    //   6392: aload 43
    //   6394: ldc_w 1916
    //   6397: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6400: astore 4
    //   6402: lload 36
    //   6404: lstore 24
    //   6406: lload 38
    //   6408: lstore 34
    //   6410: lload 36
    //   6412: lstore 32
    //   6414: lload 22
    //   6416: lstore 30
    //   6418: lload 18
    //   6420: lstore 28
    //   6422: lload 20
    //   6424: lstore 26
    //   6426: aload 4
    //   6428: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6431: ifne +37 -> 6468
    //   6434: lload 38
    //   6436: lstore 34
    //   6438: lload 36
    //   6440: lstore 32
    //   6442: lload 22
    //   6444: lstore 30
    //   6446: lload 18
    //   6448: lstore 28
    //   6450: lload 20
    //   6452: lstore 26
    //   6454: new 1906	java/math/BigInteger
    //   6457: dup
    //   6458: aload 4
    //   6460: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6463: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   6466: lstore 24
    //   6468: lload 38
    //   6470: lstore 34
    //   6472: lload 24
    //   6474: lstore 32
    //   6476: lload 22
    //   6478: lstore 30
    //   6480: lload 18
    //   6482: lstore 28
    //   6484: lload 20
    //   6486: lstore 26
    //   6488: aload 43
    //   6490: ldc_w 1918
    //   6493: invokevirtual 807	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6496: lstore 36
    //   6498: lload 36
    //   6500: lstore 34
    //   6502: lload 24
    //   6504: lstore 32
    //   6506: lload 22
    //   6508: lstore 30
    //   6510: lload 18
    //   6512: lstore 28
    //   6514: lload 20
    //   6516: lstore 26
    //   6518: aload 43
    //   6520: ldc 227
    //   6522: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6525: istore 7
    //   6527: lload 24
    //   6529: lstore 32
    //   6531: aload_3
    //   6532: astore 42
    //   6534: aload 40
    //   6536: astore_3
    //   6537: lload 20
    //   6539: lstore 26
    //   6541: lload 22
    //   6543: lstore 24
    //   6545: lload 36
    //   6547: lstore 20
    //   6549: lload 18
    //   6551: lstore 22
    //   6553: aload_1
    //   6554: astore 4
    //   6556: aload 42
    //   6558: astore_1
    //   6559: lload 26
    //   6561: lstore 18
    //   6563: aload 43
    //   6565: ldc_w 1920
    //   6568: lconst_1
    //   6569: invokevirtual 618	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   6572: lstore 26
    //   6574: aload 43
    //   6576: ldc_w 1067
    //   6579: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6582: istore 6
    //   6584: aload 43
    //   6586: ldc_w 1922
    //   6589: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6592: istore 9
    //   6594: aload 43
    //   6596: ldc_w 1924
    //   6599: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6602: astore 45
    //   6604: aload 43
    //   6606: ldc_w 612
    //   6609: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6612: istore 8
    //   6614: aload 43
    //   6616: ldc_w 533
    //   6619: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6622: astore 42
    //   6624: new 201	java/lang/String
    //   6627: dup
    //   6628: aload 43
    //   6630: ldc_w 1926
    //   6633: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6636: iconst_0
    //   6637: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   6640: invokespecial 798	java/lang/String:<init>	([B)V
    //   6643: astore 46
    //   6645: aload 43
    //   6647: ldc_w 602
    //   6650: iconst_1
    //   6651: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   6654: istore 11
    //   6656: new 1928	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   6659: dup
    //   6660: invokespecial 1929	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:<init>	()V
    //   6663: astore 44
    //   6665: aload 44
    //   6667: lload 22
    //   6669: putfield 1932	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   6672: aload 44
    //   6674: aload 4
    //   6676: putfield 1935	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   6679: aload 44
    //   6681: aload_2
    //   6682: putfield 1938	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   6685: aload 44
    //   6687: aload 45
    //   6689: putfield 1941	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   6692: aload 44
    //   6694: iload 8
    //   6696: putfield 1944	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   6699: aload 44
    //   6701: lload 18
    //   6703: putfield 1947	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   6706: aload 44
    //   6708: aload 46
    //   6710: putfield 1950	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   6713: aload 44
    //   6715: lload 32
    //   6717: putfield 1952	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:businessId	J
    //   6720: aload 44
    //   6722: iload 11
    //   6724: putfield 1955	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   6727: aload 43
    //   6729: ldc_w 1957
    //   6732: invokevirtual 1960	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6735: astore 40
    //   6737: aload 44
    //   6739: new 1962	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo
    //   6742: dup
    //   6743: invokespecial 1963	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:<init>	()V
    //   6746: putfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6749: aload 44
    //   6751: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6754: new 1969	rep
    //   6757: dup
    //   6758: invokespecial 1970	rep:<init>	()V
    //   6761: putfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   6764: aload 44
    //   6766: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6769: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   6772: lload 24
    //   6774: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6777: putfield 1976	rep:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   6780: aload 44
    //   6782: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6785: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   6788: lload 26
    //   6790: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6793: putfield 1978	rep:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   6796: aload 44
    //   6798: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6801: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   6804: new 174	java/util/ArrayList
    //   6807: dup
    //   6808: invokespecial 175	java/util/ArrayList:<init>	()V
    //   6811: putfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6814: aload 40
    //   6816: ifnull +389 -> 7205
    //   6819: iconst_0
    //   6820: istore 8
    //   6822: iload 8
    //   6824: aload 40
    //   6826: invokevirtual 547	org/json/JSONArray:length	()I
    //   6829: if_icmpge +376 -> 7205
    //   6832: new 1983	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   6835: dup
    //   6836: invokespecial 1984	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   6839: astore 47
    //   6841: aload 40
    //   6843: iload 8
    //   6845: invokevirtual 1988	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6848: astore 48
    //   6850: aload 47
    //   6852: aload 48
    //   6854: ldc 237
    //   6856: invokevirtual 807	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6859: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6862: putfield 1989	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   6865: aload 47
    //   6867: new 201	java/lang/String
    //   6870: dup
    //   6871: aload 48
    //   6873: ldc_w 1991
    //   6876: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6879: iconst_0
    //   6880: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   6883: invokespecial 798	java/lang/String:<init>	([B)V
    //   6886: putfield 1992	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6889: aload 47
    //   6891: aload 47
    //   6893: getfield 1992	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6896: putfield 1993	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6899: aload 47
    //   6901: aload 48
    //   6903: ldc_w 1995
    //   6906: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6909: putfield 1996	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   6912: aload 47
    //   6914: aload 48
    //   6916: ldc_w 811
    //   6919: iconst_1
    //   6920: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   6923: putfield 1997	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   6926: aload 47
    //   6928: aload 48
    //   6930: ldc_w 1999
    //   6933: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6936: putfield 2000	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_c_of_type_Int	I
    //   6939: aload 48
    //   6941: ldc_w 2002
    //   6944: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6947: astore 49
    //   6949: aload 48
    //   6951: ldc_w 2004
    //   6954: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6957: astore 50
    //   6959: aload 49
    //   6961: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6964: ifne +39 -> 7003
    //   6967: aload 50
    //   6969: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6972: ifne +31 -> 7003
    //   6975: aload 47
    //   6977: new 2006	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   6980: dup
    //   6981: lconst_0
    //   6982: new 201	java/lang/String
    //   6985: dup
    //   6986: aload 49
    //   6988: iconst_0
    //   6989: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   6992: invokespecial 798	java/lang/String:<init>	([B)V
    //   6995: aload 50
    //   6997: invokespecial 2009	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   7000: putfield 2012	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   7003: iload 10
    //   7005: iconst_1
    //   7006: if_icmpne +3 -> 7009
    //   7009: aload 48
    //   7011: ldc_w 1904
    //   7014: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7017: astore 48
    //   7019: aload 48
    //   7021: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7024: ifne +23 -> 7047
    //   7027: aload 47
    //   7029: new 1906	java/math/BigInteger
    //   7032: dup
    //   7033: aload 48
    //   7035: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   7038: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   7041: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7044: putfield 2013	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   7047: aload 44
    //   7049: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7052: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   7055: getfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7058: aload 47
    //   7060: invokeinterface 2016 2 0
    //   7065: pop
    //   7066: iload 8
    //   7068: iconst_1
    //   7069: iadd
    //   7070: istore 8
    //   7072: goto -250 -> 6822
    //   7075: aload 4
    //   7077: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   7080: iconst_0
    //   7081: istore 7
    //   7083: lload 34
    //   7085: lstore 20
    //   7087: aload_3
    //   7088: astore 4
    //   7090: aload 40
    //   7092: astore_3
    //   7093: goto -530 -> 6563
    //   7096: astore 40
    //   7098: ldc_w 321
    //   7101: iconst_1
    //   7102: new 507	java/lang/StringBuilder
    //   7105: dup
    //   7106: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   7109: ldc_w 2018
    //   7112: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7115: aload 40
    //   7117: invokevirtual 1842	org/json/JSONException:toString	()Ljava/lang/String;
    //   7120: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7123: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7126: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7129: aconst_null
    //   7130: astore 40
    //   7132: goto -395 -> 6737
    //   7135: astore 48
    //   7137: ldc_w 321
    //   7140: iconst_1
    //   7141: new 507	java/lang/StringBuilder
    //   7144: dup
    //   7145: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   7148: ldc_w 2018
    //   7151: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7154: aload 48
    //   7156: invokevirtual 1850	java/lang/Exception:toString	()Ljava/lang/String;
    //   7159: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7162: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7165: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7168: goto -121 -> 7047
    //   7171: astore_1
    //   7172: ldc_w 321
    //   7175: iconst_1
    //   7176: new 507	java/lang/StringBuilder
    //   7179: dup
    //   7180: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   7183: ldc_w 2020
    //   7186: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7189: aload_1
    //   7190: invokevirtual 1842	org/json/JSONException:toString	()Ljava/lang/String;
    //   7193: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7196: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7199: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7202: goto -2722 -> 4480
    //   7205: aload 43
    //   7207: ldc_w 2022
    //   7210: invokevirtual 2026	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   7213: astore 43
    //   7215: ldc 163
    //   7217: astore 40
    //   7219: aload 43
    //   7221: ifnull +6566 -> 13787
    //   7224: iload 11
    //   7226: lload 26
    //   7228: invokestatic 2031	pgb:a	(IJ)Z
    //   7231: ifeq +6556 -> 13787
    //   7234: aload 44
    //   7236: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7239: new 2033	rfj
    //   7242: dup
    //   7243: invokespecial 2034	rfj:<init>	()V
    //   7246: putfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7249: aload 43
    //   7251: ldc_w 2039
    //   7254: iconst_0
    //   7255: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7258: istore 12
    //   7260: aload 43
    //   7262: ldc_w 2041
    //   7265: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7268: astore 40
    //   7270: aload 43
    //   7272: ldc_w 2043
    //   7275: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7278: astore 47
    //   7280: aload 47
    //   7282: ifnull +365 -> 7647
    //   7285: aload 44
    //   7287: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7290: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7293: new 1969	rep
    //   7296: dup
    //   7297: invokespecial 1970	rep:<init>	()V
    //   7300: putfield 2044	rfj:jdField_a_of_type_Rep	Lrep;
    //   7303: aload 44
    //   7305: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7308: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7311: getfield 2044	rfj:jdField_a_of_type_Rep	Lrep;
    //   7314: new 174	java/util/ArrayList
    //   7317: dup
    //   7318: invokespecial 175	java/util/ArrayList:<init>	()V
    //   7321: putfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7324: iconst_0
    //   7325: istore 8
    //   7327: iload 8
    //   7329: aload 47
    //   7331: invokevirtual 547	org/json/JSONArray:length	()I
    //   7334: if_icmpge +313 -> 7647
    //   7337: new 1983	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   7340: dup
    //   7341: invokespecial 1984	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   7344: astore 48
    //   7346: aload 47
    //   7348: iload 8
    //   7350: invokevirtual 1988	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7353: astore 49
    //   7355: aload 48
    //   7357: aload 49
    //   7359: ldc 237
    //   7361: invokevirtual 807	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   7364: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7367: putfield 1989	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   7370: aload 48
    //   7372: new 201	java/lang/String
    //   7375: dup
    //   7376: aload 49
    //   7378: ldc_w 1991
    //   7381: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7384: iconst_0
    //   7385: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   7388: invokespecial 798	java/lang/String:<init>	([B)V
    //   7391: putfield 1992	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7394: aload 48
    //   7396: aload 48
    //   7398: getfield 1992	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7401: putfield 1993	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7404: aload 48
    //   7406: aload 49
    //   7408: ldc_w 1995
    //   7411: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7414: putfield 1996	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   7417: aload 48
    //   7419: aload 49
    //   7421: ldc_w 811
    //   7424: iconst_1
    //   7425: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7428: putfield 1997	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   7431: aload 48
    //   7433: aload 49
    //   7435: ldc_w 1999
    //   7438: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7441: putfield 2000	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_c_of_type_Int	I
    //   7444: aload 49
    //   7446: ldc_w 2002
    //   7449: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7452: astore 50
    //   7454: aload 49
    //   7456: ldc_w 2004
    //   7459: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7462: astore 51
    //   7464: aload 50
    //   7466: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7469: ifne +39 -> 7508
    //   7472: aload 51
    //   7474: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7477: ifne +31 -> 7508
    //   7480: aload 48
    //   7482: new 2006	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   7485: dup
    //   7486: lconst_0
    //   7487: new 201	java/lang/String
    //   7490: dup
    //   7491: aload 50
    //   7493: iconst_0
    //   7494: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   7497: invokespecial 798	java/lang/String:<init>	([B)V
    //   7500: aload 51
    //   7502: invokespecial 2009	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   7505: putfield 2012	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   7508: aload 49
    //   7510: ldc_w 1904
    //   7513: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7516: astore 49
    //   7518: aload 49
    //   7520: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7523: ifne +23 -> 7546
    //   7526: aload 48
    //   7528: new 1906	java/math/BigInteger
    //   7531: dup
    //   7532: aload 49
    //   7534: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   7537: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   7540: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7543: putfield 2013	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   7546: aload 44
    //   7548: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7551: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7554: getfield 2044	rfj:jdField_a_of_type_Rep	Lrep;
    //   7557: getfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7560: aload 48
    //   7562: invokeinterface 2016 2 0
    //   7567: pop
    //   7568: iload 8
    //   7570: iconst_1
    //   7571: iadd
    //   7572: istore 8
    //   7574: goto -247 -> 7327
    //   7577: astore 49
    //   7579: ldc_w 321
    //   7582: iconst_1
    //   7583: new 507	java/lang/StringBuilder
    //   7586: dup
    //   7587: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   7590: ldc_w 2018
    //   7593: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7596: aload 49
    //   7598: invokevirtual 1850	java/lang/Exception:toString	()Ljava/lang/String;
    //   7601: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7604: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7607: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7610: goto -64 -> 7546
    //   7613: astore_1
    //   7614: ldc_w 321
    //   7617: iconst_1
    //   7618: new 507	java/lang/StringBuilder
    //   7621: dup
    //   7622: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   7625: ldc_w 2046
    //   7628: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7631: aload_1
    //   7632: invokevirtual 2047	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   7635: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7638: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7641: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7644: goto -3164 -> 4480
    //   7647: aload 44
    //   7649: new 201	java/lang/String
    //   7652: dup
    //   7653: aload 40
    //   7655: iconst_0
    //   7656: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   7659: invokespecial 798	java/lang/String:<init>	([B)V
    //   7662: putfield 1935	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   7665: aload 44
    //   7667: ldc 163
    //   7669: putfield 1950	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   7672: iload 12
    //   7674: iconst_3
    //   7675: if_icmpeq +9 -> 7684
    //   7678: iload 12
    //   7680: iconst_2
    //   7681: if_icmpne +6210 -> 13891
    //   7684: aload 44
    //   7686: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7689: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7692: new 174	java/util/ArrayList
    //   7695: dup
    //   7696: invokespecial 175	java/util/ArrayList:<init>	()V
    //   7699: putfield 2048	rfj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7702: new 2050	rfk
    //   7705: dup
    //   7706: invokespecial 2051	rfk:<init>	()V
    //   7709: astore 4
    //   7711: aload 43
    //   7713: ldc_w 2053
    //   7716: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7719: astore 43
    //   7721: aload 43
    //   7723: ifnull +6162 -> 13885
    //   7726: aload 43
    //   7728: invokevirtual 547	org/json/JSONArray:length	()I
    //   7731: ifle +6154 -> 13885
    //   7734: aload 4
    //   7736: aload 43
    //   7738: iconst_0
    //   7739: invokevirtual 1988	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7742: ldc_w 2055
    //   7745: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7748: putfield 2056	rfk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   7751: aload 44
    //   7753: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7756: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7759: getfield 2048	rfj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7762: aload 4
    //   7764: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   7767: pop
    //   7768: goto +6117 -> 13885
    //   7771: iload 9
    //   7773: bipush 22
    //   7775: if_icmpne +52 -> 7827
    //   7778: new 2058	rem
    //   7781: dup
    //   7782: invokespecial 2059	rem:<init>	()V
    //   7785: astore 4
    //   7787: aload 4
    //   7789: aload_2
    //   7790: putfield 2060	rem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7793: aload 4
    //   7795: aload 45
    //   7797: putfield 2061	rem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7800: aload 4
    //   7802: aload 46
    //   7804: putfield 2062	rem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   7807: aload 4
    //   7809: lload 20
    //   7811: putfield 2064	rem:jdField_a_of_type_Long	J
    //   7814: aload 44
    //   7816: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7819: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7822: aload 4
    //   7824: putfield 2067	rfj:jdField_a_of_type_Rem	Lrem;
    //   7827: aload 44
    //   7829: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7832: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7835: iload 12
    //   7837: putfield 2068	rfj:jdField_a_of_type_Int	I
    //   7840: aload 44
    //   7842: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7845: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   7848: aload 44
    //   7850: getfield 1935	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   7853: putfield 2069	rfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7856: aload 40
    //   7858: astore_2
    //   7859: aload 44
    //   7861: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7864: ldc 163
    //   7866: putfield 2070	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7869: aload 44
    //   7871: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7874: ldc 163
    //   7876: putfield 2071	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   7879: aload 44
    //   7881: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7884: ldc 163
    //   7886: putfield 2072	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7889: new 369	android/content/Intent
    //   7892: dup
    //   7893: aload_0
    //   7894: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   7897: ldc_w 2074
    //   7900: invokespecial 850	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7903: astore 4
    //   7905: aload 4
    //   7907: ldc_w 2076
    //   7910: aload 44
    //   7912: invokevirtual 2079	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   7915: pop
    //   7916: aload_3
    //   7917: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7920: ifne +13 -> 7933
    //   7923: aload 4
    //   7925: ldc_w 2081
    //   7928: aload_3
    //   7929: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7932: pop
    //   7933: aload 4
    //   7935: ldc_w 2083
    //   7938: iload 9
    //   7940: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7943: pop
    //   7944: aload 4
    //   7946: ldc_w 2085
    //   7949: iload 6
    //   7951: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7954: pop
    //   7955: aload 4
    //   7957: ldc_w 2087
    //   7960: aload 42
    //   7962: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7965: pop
    //   7966: iconst_3
    //   7967: istore 6
    //   7969: iload 9
    //   7971: iconst_5
    //   7972: if_icmpne +5943 -> 13915
    //   7975: iconst_4
    //   7976: istore 6
    //   7978: aload 4
    //   7980: ldc_w 2089
    //   7983: iload 6
    //   7985: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7988: pop
    //   7989: aload 4
    //   7991: ldc_w 2091
    //   7994: aload_1
    //   7995: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7998: pop
    //   7999: aload 4
    //   8001: ldc_w 602
    //   8004: iload 11
    //   8006: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8009: pop
    //   8010: aload 4
    //   8012: ldc_w 2093
    //   8015: aload_2
    //   8016: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8019: pop
    //   8020: aload 4
    //   8022: ldc_w 2095
    //   8025: lload 20
    //   8027: invokevirtual 2098	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8030: pop
    //   8031: aload 4
    //   8033: ldc_w 2100
    //   8036: iload 7
    //   8038: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8041: pop
    //   8042: aload 4
    //   8044: ldc_w 2102
    //   8047: aload 41
    //   8049: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8052: pop
    //   8053: iload 9
    //   8055: bipush 23
    //   8057: if_icmpne +146 -> 8203
    //   8060: aload 41
    //   8062: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8065: ifne +14 -> 8079
    //   8068: aload 44
    //   8070: getfield 1938	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   8073: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8076: ifeq +127 -> 8203
    //   8079: ldc_w 321
    //   8082: iconst_1
    //   8083: ldc_w 2104
    //   8086: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8089: iconst_0
    //   8090: ireturn
    //   8091: aload 44
    //   8093: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8096: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   8099: new 174	java/util/ArrayList
    //   8102: dup
    //   8103: invokespecial 175	java/util/ArrayList:<init>	()V
    //   8106: putfield 2105	rfj:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   8109: new 2107	rfl
    //   8112: dup
    //   8113: invokespecial 2108	rfl:<init>	()V
    //   8116: astore 47
    //   8118: aload 43
    //   8120: ldc_w 2110
    //   8123: invokevirtual 2026	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   8126: astore 43
    //   8128: aload 43
    //   8130: ifnull +5776 -> 13906
    //   8133: aload 47
    //   8135: aload 43
    //   8137: ldc_w 2112
    //   8140: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8143: putfield 2113	rfl:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   8146: aload 47
    //   8148: aload 43
    //   8150: ldc_w 2115
    //   8153: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8156: i2l
    //   8157: putfield 2116	rfl:jdField_a_of_type_Long	J
    //   8160: aload 47
    //   8162: aload 4
    //   8164: putfield 2117	rfl:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   8167: aload 44
    //   8169: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8172: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   8175: getfield 2105	rfj:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   8178: aload 47
    //   8180: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   8183: pop
    //   8184: goto +5722 -> 13906
    //   8187: iload 12
    //   8189: iconst_1
    //   8190: if_icmpne +5722 -> 13912
    //   8193: aload 44
    //   8195: ldc 163
    //   8197: putfield 1941	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   8200: goto +5712 -> 13912
    //   8203: iload 10
    //   8205: iconst_1
    //   8206: if_icmpne +163 -> 8369
    //   8209: aload 44
    //   8211: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8214: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   8217: getfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   8220: ifnull +5561 -> 13781
    //   8223: aload 44
    //   8225: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8228: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   8231: getfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   8234: invokeinterface 2118 1 0
    //   8239: ifle +5542 -> 13781
    //   8242: new 507	java/lang/StringBuilder
    //   8245: dup
    //   8246: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   8249: aload 5
    //   8251: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8254: ldc_w 2120
    //   8257: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8260: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8263: astore_1
    //   8264: aload_1
    //   8265: astore_2
    //   8266: aload_1
    //   8267: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8270: ifeq +7 -> 8277
    //   8273: ldc_w 2122
    //   8276: astore_2
    //   8277: new 507	java/lang/StringBuilder
    //   8280: dup
    //   8281: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   8284: ldc_w 2124
    //   8287: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8290: aload_2
    //   8291: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8294: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8297: astore_1
    //   8298: invokestatic 2129	pkp:a	()Lpkp;
    //   8301: new 2131	ugc
    //   8304: dup
    //   8305: aload_0
    //   8306: aload 42
    //   8308: iload 11
    //   8310: invokespecial 2134	ugc:<init>	(Lufd;Ljava/lang/String;I)V
    //   8313: invokevirtual 2137	pkp:a	(Lpkt;)V
    //   8316: aload_0
    //   8317: getfield 1302	ufd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   8320: checkcast 2139	com/tencent/mobileqq/app/BrowserAppInterface
    //   8323: invokevirtual 2142	com/tencent/mobileqq/app/BrowserAppInterface:a	()Lpks;
    //   8326: invokevirtual 2147	pks:a	()Lpkm;
    //   8329: aload_0
    //   8330: getfield 485	ufd:mRuntime	Lbgve;
    //   8333: invokevirtual 1836	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   8336: invokevirtual 2150	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   8339: lload 18
    //   8341: aload 44
    //   8343: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8346: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   8349: lconst_0
    //   8350: aload_1
    //   8351: lload 22
    //   8353: ldc2_w 613
    //   8356: iload 6
    //   8358: aload_3
    //   8359: iload 11
    //   8361: aload 44
    //   8363: invokevirtual 2155	pkm:a	(JJLrep;JLjava/lang/String;JJILjava/lang/String;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   8366: goto -3886 -> 4480
    //   8369: aload 4
    //   8371: ldc_w 2089
    //   8374: iconst_4
    //   8375: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8378: pop
    //   8379: aload 4
    //   8381: ldc_w 2083
    //   8384: iconst_0
    //   8385: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8388: pop
    //   8389: aload 4
    //   8391: ldc_w 2157
    //   8394: iconst_0
    //   8395: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8398: pop
    //   8399: aload 4
    //   8401: ldc_w 602
    //   8404: iconst_1
    //   8405: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8408: pop
    //   8409: aload 4
    //   8411: ldc_w 2159
    //   8414: iconst_0
    //   8415: invokevirtual 994	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8418: pop
    //   8419: aload 4
    //   8421: ldc_w 2161
    //   8424: iconst_1
    //   8425: invokevirtual 994	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8428: pop
    //   8429: aload 4
    //   8431: ldc_w 2163
    //   8434: iconst_1
    //   8435: invokevirtual 994	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8438: pop
    //   8439: aload 4
    //   8441: ldc_w 2165
    //   8444: lload 18
    //   8446: invokevirtual 2098	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8449: pop
    //   8450: aload_0
    //   8451: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   8454: aload 4
    //   8456: bipush 113
    //   8458: invokevirtual 907	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   8461: aload_0
    //   8462: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   8465: iconst_0
    //   8466: iconst_0
    //   8467: invokevirtual 2168	android/app/Activity:overridePendingTransition	(II)V
    //   8470: goto -3990 -> 4480
    //   8473: ldc_w 2170
    //   8476: aload 4
    //   8478: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   8481: ifeq +2364 -> 10845
    //   8484: aload 5
    //   8486: ifnull -4006 -> 4480
    //   8489: aload 5
    //   8491: arraylength
    //   8492: ifle -4012 -> 4480
    //   8495: aload_0
    //   8496: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   8499: instanceof 2172
    //   8502: ifeq -4022 -> 4480
    //   8505: new 224	org/json/JSONObject
    //   8508: dup
    //   8509: aload 5
    //   8511: iconst_0
    //   8512: aaload
    //   8513: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8516: astore 43
    //   8518: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8521: ifeq +34 -> 8555
    //   8524: ldc_w 321
    //   8527: iconst_2
    //   8528: new 507	java/lang/StringBuilder
    //   8531: dup
    //   8532: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   8535: ldc_w 1896
    //   8538: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8541: aload 43
    //   8543: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8546: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8549: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8552: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8555: aload 43
    //   8557: ldc_w 606
    //   8560: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8563: astore 42
    //   8565: aload 43
    //   8567: ldc_w 608
    //   8570: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8573: astore_3
    //   8574: aload 43
    //   8576: ldc_w 1898
    //   8579: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8582: astore 41
    //   8584: aload 41
    //   8586: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8589: ifeq +5395 -> 13984
    //   8592: aload_2
    //   8593: astore 41
    //   8595: aload 43
    //   8597: ldc_w 1900
    //   8600: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8603: istore 10
    //   8605: ldc 163
    //   8607: astore 5
    //   8609: iload 10
    //   8611: iconst_1
    //   8612: if_icmpne +24 -> 8636
    //   8615: new 201	java/lang/String
    //   8618: dup
    //   8619: aload 43
    //   8621: ldc_w 1902
    //   8624: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8627: iconst_2
    //   8628: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   8631: invokespecial 798	java/lang/String:<init>	([B)V
    //   8634: astore 5
    //   8636: lconst_0
    //   8637: lstore 18
    //   8639: lconst_0
    //   8640: lstore 22
    //   8642: lconst_0
    //   8643: lstore 24
    //   8645: lconst_0
    //   8646: lstore 36
    //   8648: lconst_0
    //   8649: lstore 38
    //   8651: ldc 163
    //   8653: astore 40
    //   8655: new 201	java/lang/String
    //   8658: dup
    //   8659: aload 42
    //   8661: iconst_0
    //   8662: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   8665: invokespecial 798	java/lang/String:<init>	([B)V
    //   8668: astore_1
    //   8669: new 201	java/lang/String
    //   8672: dup
    //   8673: aload_3
    //   8674: iconst_0
    //   8675: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   8678: invokespecial 798	java/lang/String:<init>	([B)V
    //   8681: astore_2
    //   8682: aload 43
    //   8684: ldc_w 1904
    //   8687: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8690: astore_3
    //   8691: aload 43
    //   8693: ldc_w 519
    //   8696: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8699: astore 4
    //   8701: aload 4
    //   8703: astore 40
    //   8705: lload 18
    //   8707: lstore 20
    //   8709: lload 38
    //   8711: lstore 34
    //   8713: lload 36
    //   8715: lstore 32
    //   8717: lload 24
    //   8719: lstore 30
    //   8721: lload 22
    //   8723: lstore 28
    //   8725: lload 18
    //   8727: lstore 26
    //   8729: aload_3
    //   8730: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8733: ifne +36 -> 8769
    //   8736: lload 38
    //   8738: lstore 34
    //   8740: lload 36
    //   8742: lstore 32
    //   8744: lload 24
    //   8746: lstore 30
    //   8748: lload 22
    //   8750: lstore 28
    //   8752: lload 18
    //   8754: lstore 26
    //   8756: new 1906	java/math/BigInteger
    //   8759: dup
    //   8760: aload_3
    //   8761: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8764: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   8767: lstore 20
    //   8769: lload 38
    //   8771: lstore 34
    //   8773: lload 36
    //   8775: lstore 32
    //   8777: lload 24
    //   8779: lstore 30
    //   8781: lload 22
    //   8783: lstore 28
    //   8785: lload 20
    //   8787: lstore 26
    //   8789: aload 43
    //   8791: ldc_w 1912
    //   8794: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8797: astore 4
    //   8799: lload 22
    //   8801: lstore 18
    //   8803: lload 38
    //   8805: lstore 34
    //   8807: lload 36
    //   8809: lstore 32
    //   8811: lload 24
    //   8813: lstore 30
    //   8815: lload 22
    //   8817: lstore 28
    //   8819: lload 20
    //   8821: lstore 26
    //   8823: aload 4
    //   8825: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8828: ifne +37 -> 8865
    //   8831: lload 38
    //   8833: lstore 34
    //   8835: lload 36
    //   8837: lstore 32
    //   8839: lload 24
    //   8841: lstore 30
    //   8843: lload 22
    //   8845: lstore 28
    //   8847: lload 20
    //   8849: lstore 26
    //   8851: new 1906	java/math/BigInteger
    //   8854: dup
    //   8855: aload 4
    //   8857: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8860: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   8863: lstore 18
    //   8865: lload 38
    //   8867: lstore 34
    //   8869: lload 36
    //   8871: lstore 32
    //   8873: lload 24
    //   8875: lstore 30
    //   8877: lload 18
    //   8879: lstore 28
    //   8881: lload 20
    //   8883: lstore 26
    //   8885: aload 43
    //   8887: ldc_w 1914
    //   8890: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8893: astore 4
    //   8895: lload 24
    //   8897: lstore 22
    //   8899: lload 38
    //   8901: lstore 34
    //   8903: lload 36
    //   8905: lstore 32
    //   8907: lload 24
    //   8909: lstore 30
    //   8911: lload 18
    //   8913: lstore 28
    //   8915: lload 20
    //   8917: lstore 26
    //   8919: aload 4
    //   8921: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8924: ifne +37 -> 8961
    //   8927: lload 38
    //   8929: lstore 34
    //   8931: lload 36
    //   8933: lstore 32
    //   8935: lload 24
    //   8937: lstore 30
    //   8939: lload 18
    //   8941: lstore 28
    //   8943: lload 20
    //   8945: lstore 26
    //   8947: new 1906	java/math/BigInteger
    //   8950: dup
    //   8951: aload 4
    //   8953: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8956: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   8959: lstore 22
    //   8961: lload 38
    //   8963: lstore 34
    //   8965: lload 36
    //   8967: lstore 32
    //   8969: lload 22
    //   8971: lstore 30
    //   8973: lload 18
    //   8975: lstore 28
    //   8977: lload 20
    //   8979: lstore 26
    //   8981: aload 43
    //   8983: ldc_w 1916
    //   8986: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8989: astore 4
    //   8991: lload 36
    //   8993: lstore 24
    //   8995: lload 38
    //   8997: lstore 34
    //   8999: lload 36
    //   9001: lstore 32
    //   9003: lload 22
    //   9005: lstore 30
    //   9007: lload 18
    //   9009: lstore 28
    //   9011: lload 20
    //   9013: lstore 26
    //   9015: aload 4
    //   9017: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9020: ifne +37 -> 9057
    //   9023: lload 38
    //   9025: lstore 34
    //   9027: lload 36
    //   9029: lstore 32
    //   9031: lload 22
    //   9033: lstore 30
    //   9035: lload 18
    //   9037: lstore 28
    //   9039: lload 20
    //   9041: lstore 26
    //   9043: new 1906	java/math/BigInteger
    //   9046: dup
    //   9047: aload 4
    //   9049: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9052: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   9055: lstore 24
    //   9057: lload 38
    //   9059: lstore 34
    //   9061: lload 24
    //   9063: lstore 32
    //   9065: lload 22
    //   9067: lstore 30
    //   9069: lload 18
    //   9071: lstore 28
    //   9073: lload 20
    //   9075: lstore 26
    //   9077: aload 43
    //   9079: ldc_w 1918
    //   9082: invokevirtual 807	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9085: lstore 36
    //   9087: lload 36
    //   9089: lstore 34
    //   9091: lload 24
    //   9093: lstore 32
    //   9095: lload 22
    //   9097: lstore 30
    //   9099: lload 18
    //   9101: lstore 28
    //   9103: lload 20
    //   9105: lstore 26
    //   9107: aload 43
    //   9109: ldc 227
    //   9111: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9114: istore 7
    //   9116: lload 24
    //   9118: lstore 32
    //   9120: aload_3
    //   9121: astore 42
    //   9123: aload 40
    //   9125: astore_3
    //   9126: lload 20
    //   9128: lstore 26
    //   9130: lload 22
    //   9132: lstore 24
    //   9134: lload 36
    //   9136: lstore 20
    //   9138: lload 18
    //   9140: lstore 22
    //   9142: aload_1
    //   9143: astore 4
    //   9145: aload 42
    //   9147: astore_1
    //   9148: lload 26
    //   9150: lstore 18
    //   9152: aload 43
    //   9154: ldc_w 1920
    //   9157: lconst_1
    //   9158: invokevirtual 618	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   9161: lstore 26
    //   9163: aload 43
    //   9165: ldc_w 1067
    //   9168: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9171: istore 6
    //   9173: aload 43
    //   9175: ldc_w 1922
    //   9178: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9181: istore 9
    //   9183: aload 43
    //   9185: ldc_w 1924
    //   9188: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9191: astore 45
    //   9193: aload 43
    //   9195: ldc_w 612
    //   9198: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9201: istore 8
    //   9203: aload 43
    //   9205: ldc_w 533
    //   9208: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9211: astore 42
    //   9213: new 201	java/lang/String
    //   9216: dup
    //   9217: aload 43
    //   9219: ldc_w 1926
    //   9222: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9225: iconst_0
    //   9226: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   9229: invokespecial 798	java/lang/String:<init>	([B)V
    //   9232: astore 46
    //   9234: aload 43
    //   9236: ldc_w 602
    //   9239: iconst_1
    //   9240: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9243: istore 11
    //   9245: new 1928	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   9248: dup
    //   9249: invokespecial 1929	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:<init>	()V
    //   9252: astore 44
    //   9254: aload 44
    //   9256: lload 22
    //   9258: putfield 1932	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   9261: aload 44
    //   9263: aload 4
    //   9265: putfield 1935	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   9268: aload 44
    //   9270: aload_2
    //   9271: putfield 1938	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   9274: aload 44
    //   9276: aload 45
    //   9278: putfield 1941	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   9281: aload 44
    //   9283: iload 8
    //   9285: putfield 1944	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   9288: aload 44
    //   9290: lload 18
    //   9292: putfield 1947	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   9295: aload 44
    //   9297: aload 46
    //   9299: putfield 1950	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   9302: aload 44
    //   9304: lload 32
    //   9306: putfield 1952	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:businessId	J
    //   9309: aload 44
    //   9311: iload 11
    //   9313: putfield 1955	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   9316: aload 43
    //   9318: ldc_w 1957
    //   9321: invokevirtual 1960	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9324: astore 40
    //   9326: aload 44
    //   9328: new 1962	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo
    //   9331: dup
    //   9332: invokespecial 1963	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:<init>	()V
    //   9335: putfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9338: aload 44
    //   9340: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9343: new 1969	rep
    //   9346: dup
    //   9347: invokespecial 1970	rep:<init>	()V
    //   9350: putfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   9353: aload 44
    //   9355: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9358: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   9361: lload 24
    //   9363: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9366: putfield 1976	rep:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   9369: aload 44
    //   9371: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9374: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   9377: lload 26
    //   9379: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9382: putfield 1978	rep:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   9385: aload 44
    //   9387: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9390: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   9393: new 174	java/util/ArrayList
    //   9396: dup
    //   9397: invokespecial 175	java/util/ArrayList:<init>	()V
    //   9400: putfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9403: aload 40
    //   9405: ifnull +311 -> 9716
    //   9408: iconst_0
    //   9409: istore 8
    //   9411: iload 8
    //   9413: aload 40
    //   9415: invokevirtual 547	org/json/JSONArray:length	()I
    //   9418: if_icmpge +298 -> 9716
    //   9421: new 1983	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   9424: dup
    //   9425: invokespecial 1984	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   9428: astore 47
    //   9430: aload 40
    //   9432: iload 8
    //   9434: invokevirtual 1988	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   9437: astore 48
    //   9439: aload 47
    //   9441: aload 48
    //   9443: ldc 237
    //   9445: invokevirtual 807	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9448: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9451: putfield 1989	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   9454: aload 47
    //   9456: new 201	java/lang/String
    //   9459: dup
    //   9460: aload 48
    //   9462: ldc_w 1991
    //   9465: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9468: iconst_0
    //   9469: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   9472: invokespecial 798	java/lang/String:<init>	([B)V
    //   9475: putfield 1992	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9478: aload 47
    //   9480: aload 47
    //   9482: getfield 1992	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9485: putfield 1993	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9488: aload 47
    //   9490: aload 48
    //   9492: ldc_w 1995
    //   9495: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9498: putfield 1996	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   9501: aload 47
    //   9503: aload 48
    //   9505: ldc_w 811
    //   9508: iconst_1
    //   9509: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9512: putfield 1997	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   9515: aload 47
    //   9517: aload 48
    //   9519: ldc_w 1999
    //   9522: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9525: putfield 2000	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_c_of_type_Int	I
    //   9528: aload 48
    //   9530: ldc_w 2002
    //   9533: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9536: astore 49
    //   9538: aload 48
    //   9540: ldc_w 2004
    //   9543: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9546: astore 50
    //   9548: aload 49
    //   9550: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9553: ifne +39 -> 9592
    //   9556: aload 50
    //   9558: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9561: ifne +31 -> 9592
    //   9564: aload 47
    //   9566: new 2006	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   9569: dup
    //   9570: lconst_0
    //   9571: new 201	java/lang/String
    //   9574: dup
    //   9575: aload 49
    //   9577: iconst_0
    //   9578: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   9581: invokespecial 798	java/lang/String:<init>	([B)V
    //   9584: aload 50
    //   9586: invokespecial 2009	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   9589: putfield 2012	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   9592: iload 10
    //   9594: iconst_1
    //   9595: if_icmpne +3 -> 9598
    //   9598: aload 48
    //   9600: ldc_w 1904
    //   9603: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9606: astore 48
    //   9608: aload 48
    //   9610: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9613: ifne +23 -> 9636
    //   9616: aload 47
    //   9618: new 1906	java/math/BigInteger
    //   9621: dup
    //   9622: aload 48
    //   9624: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9627: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   9630: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9633: putfield 2013	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   9636: aload 44
    //   9638: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9641: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   9644: getfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9647: aload 47
    //   9649: invokeinterface 2016 2 0
    //   9654: pop
    //   9655: iload 8
    //   9657: iconst_1
    //   9658: iadd
    //   9659: istore 8
    //   9661: goto -250 -> 9411
    //   9664: aload 4
    //   9666: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   9669: iconst_0
    //   9670: istore 7
    //   9672: lload 34
    //   9674: lstore 20
    //   9676: aload_3
    //   9677: astore 4
    //   9679: aload 40
    //   9681: astore_3
    //   9682: goto -530 -> 9152
    //   9685: astore 40
    //   9687: aload 40
    //   9689: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   9692: aconst_null
    //   9693: astore 40
    //   9695: goto -369 -> 9326
    //   9698: astore 48
    //   9700: aload 48
    //   9702: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   9705: goto -69 -> 9636
    //   9708: astore_1
    //   9709: aload_1
    //   9710: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   9713: goto -5233 -> 4480
    //   9716: aload 43
    //   9718: ldc_w 2022
    //   9721: invokevirtual 2026	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9724: astore 43
    //   9726: ldc 163
    //   9728: astore 40
    //   9730: aload 43
    //   9732: ifnull +4043 -> 13775
    //   9735: iload 11
    //   9737: lload 26
    //   9739: invokestatic 2031	pgb:a	(IJ)Z
    //   9742: ifeq +4033 -> 13775
    //   9745: aload 44
    //   9747: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9750: new 2033	rfj
    //   9753: dup
    //   9754: invokespecial 2034	rfj:<init>	()V
    //   9757: putfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   9760: aload 43
    //   9762: ldc_w 2039
    //   9765: iconst_0
    //   9766: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9769: istore 12
    //   9771: aload 43
    //   9773: ldc_w 2041
    //   9776: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9779: astore 40
    //   9781: aload 43
    //   9783: ldc_w 2043
    //   9786: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9789: astore 47
    //   9791: aload 47
    //   9793: ifnull +305 -> 10098
    //   9796: aload 44
    //   9798: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9801: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   9804: new 1969	rep
    //   9807: dup
    //   9808: invokespecial 1970	rep:<init>	()V
    //   9811: putfield 2044	rfj:jdField_a_of_type_Rep	Lrep;
    //   9814: aload 44
    //   9816: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9819: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   9822: getfield 2044	rfj:jdField_a_of_type_Rep	Lrep;
    //   9825: new 174	java/util/ArrayList
    //   9828: dup
    //   9829: invokespecial 175	java/util/ArrayList:<init>	()V
    //   9832: putfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9835: iconst_0
    //   9836: istore 8
    //   9838: iload 8
    //   9840: aload 47
    //   9842: invokevirtual 547	org/json/JSONArray:length	()I
    //   9845: if_icmpge +253 -> 10098
    //   9848: new 1983	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   9851: dup
    //   9852: invokespecial 1984	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   9855: astore 48
    //   9857: aload 47
    //   9859: iload 8
    //   9861: invokevirtual 1988	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   9864: astore 49
    //   9866: aload 48
    //   9868: aload 49
    //   9870: ldc 237
    //   9872: invokevirtual 807	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9875: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9878: putfield 1989	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   9881: aload 48
    //   9883: new 201	java/lang/String
    //   9886: dup
    //   9887: aload 49
    //   9889: ldc_w 1991
    //   9892: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9895: iconst_0
    //   9896: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   9899: invokespecial 798	java/lang/String:<init>	([B)V
    //   9902: putfield 1992	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9905: aload 48
    //   9907: aload 48
    //   9909: getfield 1992	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9912: putfield 1993	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9915: aload 48
    //   9917: aload 49
    //   9919: ldc_w 1995
    //   9922: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9925: putfield 1996	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   9928: aload 48
    //   9930: aload 49
    //   9932: ldc_w 811
    //   9935: iconst_1
    //   9936: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9939: putfield 1997	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   9942: aload 48
    //   9944: aload 49
    //   9946: ldc_w 1999
    //   9949: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9952: putfield 2000	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_c_of_type_Int	I
    //   9955: aload 49
    //   9957: ldc_w 2002
    //   9960: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9963: astore 50
    //   9965: aload 49
    //   9967: ldc_w 2004
    //   9970: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9973: astore 51
    //   9975: aload 50
    //   9977: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9980: ifne +39 -> 10019
    //   9983: aload 51
    //   9985: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9988: ifne +31 -> 10019
    //   9991: aload 48
    //   9993: new 2006	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   9996: dup
    //   9997: lconst_0
    //   9998: new 201	java/lang/String
    //   10001: dup
    //   10002: aload 50
    //   10004: iconst_0
    //   10005: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   10008: invokespecial 798	java/lang/String:<init>	([B)V
    //   10011: aload 51
    //   10013: invokespecial 2009	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   10016: putfield 2012	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   10019: aload 49
    //   10021: ldc_w 1904
    //   10024: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10027: astore 49
    //   10029: aload 49
    //   10031: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10034: ifne +23 -> 10057
    //   10037: aload 48
    //   10039: new 1906	java/math/BigInteger
    //   10042: dup
    //   10043: aload 49
    //   10045: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   10048: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   10051: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10054: putfield 2013	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   10057: aload 44
    //   10059: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10062: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   10065: getfield 2044	rfj:jdField_a_of_type_Rep	Lrep;
    //   10068: getfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10071: aload 48
    //   10073: invokeinterface 2016 2 0
    //   10078: pop
    //   10079: iload 8
    //   10081: iconst_1
    //   10082: iadd
    //   10083: istore 8
    //   10085: goto -247 -> 9838
    //   10088: astore 49
    //   10090: aload 49
    //   10092: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   10095: goto -38 -> 10057
    //   10098: aload 44
    //   10100: new 201	java/lang/String
    //   10103: dup
    //   10104: aload 40
    //   10106: iconst_0
    //   10107: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   10110: invokespecial 798	java/lang/String:<init>	([B)V
    //   10113: putfield 1935	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   10116: aload 44
    //   10118: ldc 163
    //   10120: putfield 1950	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   10123: iload 12
    //   10125: iconst_3
    //   10126: if_icmpeq +9 -> 10135
    //   10129: iload 12
    //   10131: iconst_2
    //   10132: if_icmpne +3882 -> 14014
    //   10135: aload 44
    //   10137: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10140: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   10143: new 174	java/util/ArrayList
    //   10146: dup
    //   10147: invokespecial 175	java/util/ArrayList:<init>	()V
    //   10150: putfield 2048	rfj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10153: new 2050	rfk
    //   10156: dup
    //   10157: invokespecial 2051	rfk:<init>	()V
    //   10160: astore 4
    //   10162: aload 43
    //   10164: ldc_w 2053
    //   10167: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10170: astore 43
    //   10172: aload 43
    //   10174: ifnull +3834 -> 14008
    //   10177: aload 43
    //   10179: invokevirtual 547	org/json/JSONArray:length	()I
    //   10182: ifle +3826 -> 14008
    //   10185: aload 4
    //   10187: aload 43
    //   10189: iconst_0
    //   10190: invokevirtual 1988	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   10193: ldc_w 2055
    //   10196: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10199: putfield 2056	rfk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   10202: aload 44
    //   10204: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10207: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   10210: getfield 2048	rfj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10213: aload 4
    //   10215: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10218: pop
    //   10219: goto +3789 -> 14008
    //   10222: iload 9
    //   10224: bipush 22
    //   10226: if_icmpne +52 -> 10278
    //   10229: new 2058	rem
    //   10232: dup
    //   10233: invokespecial 2059	rem:<init>	()V
    //   10236: astore 4
    //   10238: aload 4
    //   10240: aload_2
    //   10241: putfield 2060	rem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10244: aload 4
    //   10246: aload 45
    //   10248: putfield 2061	rem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10251: aload 4
    //   10253: aload 46
    //   10255: putfield 2062	rem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   10258: aload 4
    //   10260: lload 20
    //   10262: putfield 2064	rem:jdField_a_of_type_Long	J
    //   10265: aload 44
    //   10267: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10270: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   10273: aload 4
    //   10275: putfield 2067	rfj:jdField_a_of_type_Rem	Lrem;
    //   10278: aload 44
    //   10280: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10283: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   10286: iload 12
    //   10288: putfield 2068	rfj:jdField_a_of_type_Int	I
    //   10291: aload 44
    //   10293: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10296: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   10299: aload 44
    //   10301: getfield 1935	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   10304: putfield 2069	rfj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10307: aload 40
    //   10309: astore_2
    //   10310: aload 44
    //   10312: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10315: ldc 163
    //   10317: putfield 2070	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10320: aload 44
    //   10322: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10325: ldc 163
    //   10327: putfield 2071	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   10330: aload 44
    //   10332: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10335: ldc 163
    //   10337: putfield 2072	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10340: new 369	android/content/Intent
    //   10343: dup
    //   10344: aload_0
    //   10345: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10348: ldc_w 2074
    //   10351: invokespecial 850	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   10354: astore 4
    //   10356: aload 4
    //   10358: ldc_w 2076
    //   10361: aload 44
    //   10363: invokevirtual 2079	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   10366: pop
    //   10367: aload_3
    //   10368: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10371: ifne +13 -> 10384
    //   10374: aload 4
    //   10376: ldc_w 2081
    //   10379: aload_3
    //   10380: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10383: pop
    //   10384: aload 4
    //   10386: ldc_w 2083
    //   10389: iload 9
    //   10391: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10394: pop
    //   10395: aload 4
    //   10397: ldc_w 2085
    //   10400: iload 6
    //   10402: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10405: pop
    //   10406: aload 4
    //   10408: ldc_w 2087
    //   10411: aload 42
    //   10413: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10416: pop
    //   10417: iconst_3
    //   10418: istore 6
    //   10420: iload 9
    //   10422: iconst_5
    //   10423: if_icmpne +3615 -> 14038
    //   10426: iconst_4
    //   10427: istore 6
    //   10429: aload 4
    //   10431: ldc_w 2089
    //   10434: iload 6
    //   10436: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10439: pop
    //   10440: aload 4
    //   10442: ldc_w 2091
    //   10445: aload_1
    //   10446: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10449: pop
    //   10450: aload 4
    //   10452: ldc_w 602
    //   10455: iload 11
    //   10457: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10460: pop
    //   10461: aload 4
    //   10463: ldc_w 2093
    //   10466: aload_2
    //   10467: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10470: pop
    //   10471: aload 4
    //   10473: ldc_w 2095
    //   10476: lload 20
    //   10478: invokevirtual 2098	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   10481: pop
    //   10482: aload 4
    //   10484: ldc_w 2100
    //   10487: iload 7
    //   10489: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10492: pop
    //   10493: aload 4
    //   10495: ldc_w 2102
    //   10498: aload 41
    //   10500: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10503: pop
    //   10504: iload 9
    //   10506: bipush 23
    //   10508: if_icmpne +146 -> 10654
    //   10511: aload 41
    //   10513: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10516: ifne +14 -> 10530
    //   10519: aload 44
    //   10521: getfield 1938	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   10524: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10527: ifeq +127 -> 10654
    //   10530: ldc_w 321
    //   10533: iconst_1
    //   10534: ldc_w 2104
    //   10537: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10540: iconst_0
    //   10541: ireturn
    //   10542: aload 44
    //   10544: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10547: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   10550: new 174	java/util/ArrayList
    //   10553: dup
    //   10554: invokespecial 175	java/util/ArrayList:<init>	()V
    //   10557: putfield 2105	rfj:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10560: new 2107	rfl
    //   10563: dup
    //   10564: invokespecial 2108	rfl:<init>	()V
    //   10567: astore 47
    //   10569: aload 43
    //   10571: ldc_w 2110
    //   10574: invokevirtual 2026	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10577: astore 43
    //   10579: aload 43
    //   10581: ifnull +3448 -> 14029
    //   10584: aload 47
    //   10586: aload 43
    //   10588: ldc_w 2112
    //   10591: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10594: putfield 2113	rfl:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   10597: aload 47
    //   10599: aload 43
    //   10601: ldc_w 2115
    //   10604: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10607: i2l
    //   10608: putfield 2116	rfl:jdField_a_of_type_Long	J
    //   10611: aload 47
    //   10613: aload 4
    //   10615: putfield 2117	rfl:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   10618: aload 44
    //   10620: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10623: getfield 2037	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rfj	Lrfj;
    //   10626: getfield 2105	rfj:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10629: aload 47
    //   10631: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10634: pop
    //   10635: goto +3394 -> 14029
    //   10638: iload 12
    //   10640: iconst_1
    //   10641: if_icmpne +3394 -> 14035
    //   10644: aload 44
    //   10646: ldc 163
    //   10648: putfield 1941	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   10651: goto +3384 -> 14035
    //   10654: iload 10
    //   10656: iconst_1
    //   10657: if_icmpne +165 -> 10822
    //   10660: aload 44
    //   10662: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10665: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   10668: getfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10671: ifnull +3098 -> 13769
    //   10674: aload 44
    //   10676: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10679: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   10682: getfield 1981	rep:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10685: invokeinterface 2118 1 0
    //   10690: ifle +3079 -> 13769
    //   10693: new 507	java/lang/StringBuilder
    //   10696: dup
    //   10697: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   10700: aload 5
    //   10702: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10705: ldc_w 2120
    //   10708: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10711: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10714: astore_1
    //   10715: aload_1
    //   10716: astore_2
    //   10717: aload_1
    //   10718: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10721: ifeq +7 -> 10728
    //   10724: ldc_w 2122
    //   10727: astore_2
    //   10728: new 507	java/lang/StringBuilder
    //   10731: dup
    //   10732: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   10735: ldc_w 2124
    //   10738: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10741: aload_2
    //   10742: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10745: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10748: astore_1
    //   10749: aload_0
    //   10750: getfield 1302	ufd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   10753: checkcast 2139	com/tencent/mobileqq/app/BrowserAppInterface
    //   10756: invokevirtual 2142	com/tencent/mobileqq/app/BrowserAppInterface:a	()Lpks;
    //   10759: astore_2
    //   10760: invokestatic 2129	pkp:a	()Lpkp;
    //   10763: new 2131	ugc
    //   10766: dup
    //   10767: aload_0
    //   10768: aload 42
    //   10770: iload 11
    //   10772: invokespecial 2134	ugc:<init>	(Lufd;Ljava/lang/String;I)V
    //   10775: invokevirtual 2137	pkp:a	(Lpkt;)V
    //   10778: aload_2
    //   10779: invokevirtual 2147	pks:a	()Lpkm;
    //   10782: aload_0
    //   10783: getfield 485	ufd:mRuntime	Lbgve;
    //   10786: invokevirtual 1836	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   10789: invokevirtual 2150	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   10792: lload 18
    //   10794: aload 44
    //   10796: getfield 1967	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10799: getfield 1973	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Rep	Lrep;
    //   10802: lconst_0
    //   10803: aload_1
    //   10804: lload 22
    //   10806: ldc2_w 613
    //   10809: iload 6
    //   10811: aload_3
    //   10812: iload 11
    //   10814: aload 44
    //   10816: invokevirtual 2155	pkm:a	(JJLrep;JLjava/lang/String;JJILjava/lang/String;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   10819: goto -6339 -> 4480
    //   10822: aload_0
    //   10823: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10826: aload 4
    //   10828: bipush 113
    //   10830: invokevirtual 907	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   10833: aload_0
    //   10834: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10837: iconst_0
    //   10838: iconst_0
    //   10839: invokevirtual 2168	android/app/Activity:overridePendingTransition	(II)V
    //   10842: goto -6362 -> 4480
    //   10845: ldc_w 2174
    //   10848: aload 4
    //   10850: invokevirtual 1444	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   10853: ifeq +48 -> 10901
    //   10856: aload 5
    //   10858: ifnull -6378 -> 4480
    //   10861: aload 5
    //   10863: arraylength
    //   10864: ifle -6384 -> 4480
    //   10867: aload_0
    //   10868: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10871: instanceof 2172
    //   10874: ifeq -6394 -> 4480
    //   10877: aload_0
    //   10878: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10881: checkcast 699	com/tencent/mobileqq/app/BaseActivity
    //   10884: new 2176	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$6
    //   10887: dup
    //   10888: aload_0
    //   10889: aload 5
    //   10891: invokespecial 2179	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$6:<init>	(Lufd;[Ljava/lang/String;)V
    //   10894: invokestatic 2184	sou:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/Runnable;)Z
    //   10897: pop
    //   10898: goto -6418 -> 4480
    //   10901: ldc_w 2186
    //   10904: aload 4
    //   10906: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10909: ifeq +94 -> 11003
    //   10912: new 224	org/json/JSONObject
    //   10915: dup
    //   10916: aload 5
    //   10918: iconst_0
    //   10919: aaload
    //   10920: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10923: astore_1
    //   10924: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10927: ifeq -6447 -> 4480
    //   10930: ldc_w 2188
    //   10933: iconst_2
    //   10934: new 507	java/lang/StringBuilder
    //   10937: dup
    //   10938: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   10941: ldc_w 2190
    //   10944: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10947: aload_1
    //   10948: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10951: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10954: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10957: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10960: goto -6480 -> 4480
    //   10963: astore_1
    //   10964: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10967: ifeq -6487 -> 4480
    //   10970: ldc_w 2188
    //   10973: iconst_2
    //   10974: new 507	java/lang/StringBuilder
    //   10977: dup
    //   10978: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   10981: ldc_w 2192
    //   10984: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10987: aload_1
    //   10988: invokevirtual 324	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   10991: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10994: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10997: invokestatic 517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   11000: goto -6520 -> 4480
    //   11003: ldc_w 2194
    //   11006: aload 4
    //   11008: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11011: ifeq +27 -> 11038
    //   11014: aload_0
    //   11015: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   11018: checkcast 699	com/tencent/mobileqq/app/BaseActivity
    //   11021: new 2196	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$7
    //   11024: dup
    //   11025: aload_0
    //   11026: aload 5
    //   11028: invokespecial 2197	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$7:<init>	(Lufd;[Ljava/lang/String;)V
    //   11031: invokestatic 2184	sou:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/Runnable;)Z
    //   11034: pop
    //   11035: goto -6555 -> 4480
    //   11038: ldc_w 2199
    //   11041: aload 4
    //   11043: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11046: ifeq +63 -> 11109
    //   11049: new 224	org/json/JSONObject
    //   11052: dup
    //   11053: aload 5
    //   11055: iconst_0
    //   11056: aaload
    //   11057: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11060: ldc_w 2201
    //   11063: invokevirtual 2202	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11066: astore_1
    //   11067: aload_1
    //   11068: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11071: ifeq +30 -> 11101
    //   11074: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11077: ifeq -6597 -> 4480
    //   11080: ldc_w 321
    //   11083: iconst_2
    //   11084: ldc_w 2204
    //   11087: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11090: goto -6610 -> 4480
    //   11093: astore_1
    //   11094: aload_1
    //   11095: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   11098: goto -6618 -> 4480
    //   11101: aload_0
    //   11102: aload_1
    //   11103: invokespecial 2206	ufd:e	(Ljava/lang/String;)V
    //   11106: goto -6626 -> 4480
    //   11109: ldc_w 2208
    //   11112: aload 4
    //   11114: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11117: ifeq +100 -> 11217
    //   11120: new 224	org/json/JSONObject
    //   11123: dup
    //   11124: aload 5
    //   11126: iconst_0
    //   11127: aaload
    //   11128: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11131: astore_1
    //   11132: aload_1
    //   11133: ldc_w 2210
    //   11136: invokevirtual 2213	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   11139: istore 6
    //   11141: aload_1
    //   11142: ldc_w 2215
    //   11145: invokevirtual 2213	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   11148: istore 7
    //   11150: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11153: ifeq +42 -> 11195
    //   11156: ldc_w 321
    //   11159: iconst_2
    //   11160: new 507	java/lang/StringBuilder
    //   11163: dup
    //   11164: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   11167: ldc_w 2217
    //   11170: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11173: iload 6
    //   11175: invokevirtual 645	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11178: ldc_w 2219
    //   11181: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11184: iload 7
    //   11186: invokevirtual 645	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11189: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11192: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11195: aload_0
    //   11196: getfield 144	ufd:jdField_a_of_type_Zon	Lzon;
    //   11199: iload 6
    //   11201: iload 7
    //   11203: invokevirtual 2220	zon:a	(II)V
    //   11206: goto -6726 -> 4480
    //   11209: astore_1
    //   11210: aload_1
    //   11211: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   11214: goto -6734 -> 4480
    //   11217: ldc_w 2222
    //   11220: aload 4
    //   11222: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11225: ifeq +468 -> 11693
    //   11228: new 224	org/json/JSONObject
    //   11231: dup
    //   11232: aload 5
    //   11234: iconst_0
    //   11235: aaload
    //   11236: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11239: astore 4
    //   11241: aload 4
    //   11243: ldc_w 2224
    //   11246: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11249: ifeq +2514 -> 13763
    //   11252: aload 4
    //   11254: ldc_w 2224
    //   11257: invokevirtual 629	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11260: istore 13
    //   11262: aload 4
    //   11264: ldc_w 635
    //   11267: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11270: ifeq +2487 -> 13757
    //   11273: aload 4
    //   11275: ldc_w 635
    //   11278: invokevirtual 629	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11281: istore 14
    //   11283: aload 4
    //   11285: ldc_w 2226
    //   11288: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11291: ifeq +2460 -> 13751
    //   11294: aload 4
    //   11296: ldc_w 2226
    //   11299: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11302: astore_1
    //   11303: ldc_w 321
    //   11306: iconst_2
    //   11307: new 507	java/lang/StringBuilder
    //   11310: dup
    //   11311: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   11314: ldc_w 2228
    //   11317: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11320: aload_1
    //   11321: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11324: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11327: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11330: new 201	java/lang/String
    //   11333: dup
    //   11334: aload_1
    //   11335: iconst_0
    //   11336: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   11339: invokespecial 798	java/lang/String:<init>	([B)V
    //   11342: astore_2
    //   11343: aload_2
    //   11344: astore_1
    //   11345: ldc_w 321
    //   11348: iconst_2
    //   11349: new 507	java/lang/StringBuilder
    //   11352: dup
    //   11353: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   11356: ldc_w 2230
    //   11359: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11362: aload_1
    //   11363: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11366: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11369: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11372: aload_1
    //   11373: astore_2
    //   11374: aload 4
    //   11376: ldc_w 2232
    //   11379: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11382: ifeq +2363 -> 13745
    //   11385: aload 4
    //   11387: ldc_w 2232
    //   11390: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11393: astore_1
    //   11394: new 201	java/lang/String
    //   11397: dup
    //   11398: aload_1
    //   11399: iconst_0
    //   11400: invokestatic 795	bfuc:decode	(Ljava/lang/String;I)[B
    //   11403: invokespecial 798	java/lang/String:<init>	([B)V
    //   11406: astore_3
    //   11407: aload_3
    //   11408: astore_1
    //   11409: aload 4
    //   11411: ldc_w 2234
    //   11414: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11417: ifeq +2322 -> 13739
    //   11420: aload 4
    //   11422: ldc_w 2234
    //   11425: iconst_m1
    //   11426: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11429: istore 6
    //   11431: aload 4
    //   11433: ldc_w 2236
    //   11436: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11439: ifeq +2294 -> 13733
    //   11442: aload 4
    //   11444: ldc_w 2236
    //   11447: iconst_0
    //   11448: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11451: istore 7
    //   11453: iconst_0
    //   11454: istore 8
    //   11456: aload 4
    //   11458: ldc_w 1562
    //   11461: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11464: ifeq +14 -> 11478
    //   11467: aload 4
    //   11469: ldc_w 1562
    //   11472: iconst_0
    //   11473: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11476: istore 8
    //   11478: aload 4
    //   11480: ldc_w 533
    //   11483: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11486: astore_3
    //   11487: aload 4
    //   11489: ldc_w 2238
    //   11492: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   11495: astore 5
    //   11497: aload 4
    //   11499: ldc_w 2240
    //   11502: iconst_0
    //   11503: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11506: istore 9
    //   11508: new 369	android/content/Intent
    //   11511: dup
    //   11512: invokespecial 556	android/content/Intent:<init>	()V
    //   11515: astore 4
    //   11517: aload 4
    //   11519: ldc_w 2242
    //   11522: iconst_0
    //   11523: invokevirtual 994	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11526: pop
    //   11527: aload 4
    //   11529: ldc_w 2244
    //   11532: iload 13
    //   11534: invokevirtual 994	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11537: pop
    //   11538: aload 4
    //   11540: ldc_w 2246
    //   11543: aload_2
    //   11544: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11547: pop
    //   11548: aload 4
    //   11550: ldc_w 2248
    //   11553: aload_1
    //   11554: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11557: pop
    //   11558: aload 4
    //   11560: ldc_w 2250
    //   11563: iload 6
    //   11565: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11568: pop
    //   11569: aload 4
    //   11571: ldc_w 2252
    //   11574: iload 7
    //   11576: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11579: pop
    //   11580: aload 4
    //   11582: ldc_w 2254
    //   11585: iload 8
    //   11587: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11590: pop
    //   11591: aload 4
    //   11593: ldc_w 367
    //   11596: aload_3
    //   11597: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11600: pop
    //   11601: aload 4
    //   11603: ldc_w 2256
    //   11606: iload 9
    //   11608: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11611: pop
    //   11612: aload 4
    //   11614: ldc_w 2258
    //   11617: iload 14
    //   11619: invokevirtual 994	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11622: pop
    //   11623: aload 4
    //   11625: ldc_w 2260
    //   11628: iconst_1
    //   11629: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11632: pop
    //   11633: aload 5
    //   11635: ifnull +17 -> 11652
    //   11638: aload 4
    //   11640: ldc_w 2262
    //   11643: aload 5
    //   11645: invokevirtual 2263	org/json/JSONArray:toString	()Ljava/lang/String;
    //   11648: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11651: pop
    //   11652: aload_0
    //   11653: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   11656: aload 4
    //   11658: ldc_w 2265
    //   11661: bipush 117
    //   11663: invokestatic 2269	com/tencent/mobileqq/activity/PublicTransFragmentActivity:b	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Class;I)V
    //   11666: goto -7186 -> 4480
    //   11669: astore_1
    //   11670: aload_1
    //   11671: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   11674: goto -7194 -> 4480
    //   11677: astore_2
    //   11678: aload_2
    //   11679: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   11682: goto -337 -> 11345
    //   11685: astore_3
    //   11686: aload_3
    //   11687: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   11690: goto -281 -> 11409
    //   11693: ldc_w 2271
    //   11696: aload 4
    //   11698: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11701: ifeq +14 -> 11715
    //   11704: aload_0
    //   11705: aload 5
    //   11707: iconst_0
    //   11708: aaload
    //   11709: invokespecial 2273	ufd:d	(Ljava/lang/String;)V
    //   11712: goto -7232 -> 4480
    //   11715: ldc_w 2275
    //   11718: aload 4
    //   11720: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11723: ifeq +117 -> 11840
    //   11726: aconst_null
    //   11727: astore_1
    //   11728: new 224	org/json/JSONObject
    //   11731: dup
    //   11732: aload 5
    //   11734: iconst_0
    //   11735: aaload
    //   11736: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11739: ldc_w 533
    //   11742: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11745: astore_2
    //   11746: aload_2
    //   11747: astore_1
    //   11748: new 369	android/content/Intent
    //   11751: dup
    //   11752: invokespecial 556	android/content/Intent:<init>	()V
    //   11755: astore_3
    //   11756: aload_2
    //   11757: astore_1
    //   11758: aload_3
    //   11759: ldc_w 2277
    //   11762: aload 5
    //   11764: iconst_0
    //   11765: aaload
    //   11766: invokevirtual 567	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11769: pop
    //   11770: aload_2
    //   11771: astore_1
    //   11772: aload_0
    //   11773: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   11776: aload_3
    //   11777: ldc_w 2279
    //   11780: invokestatic 2282	com/tencent/mobileqq/activity/PublicTransFragmentActivity:b	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   11783: aload_2
    //   11784: astore_1
    //   11785: aload_0
    //   11786: aload_2
    //   11787: iconst_1
    //   11788: anewarray 201	java/lang/String
    //   11791: dup
    //   11792: iconst_0
    //   11793: new 224	org/json/JSONObject
    //   11796: dup
    //   11797: invokespecial 225	org/json/JSONObject:<init>	()V
    //   11800: ldc_w 314
    //   11803: iconst_0
    //   11804: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11807: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11810: aastore
    //   11811: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11814: goto -7334 -> 4480
    //   11817: astore_2
    //   11818: aload_2
    //   11819: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   11822: aload_0
    //   11823: aload_1
    //   11824: iconst_1
    //   11825: anewarray 201	java/lang/String
    //   11828: dup
    //   11829: iconst_0
    //   11830: ldc_w 2284
    //   11833: aastore
    //   11834: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11837: goto -7357 -> 4480
    //   11840: ldc_w 2286
    //   11843: aload 4
    //   11845: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11848: ifeq +161 -> 12009
    //   11851: aconst_null
    //   11852: astore_2
    //   11853: aload_2
    //   11854: astore_1
    //   11855: new 224	org/json/JSONObject
    //   11858: dup
    //   11859: aload 5
    //   11861: iconst_0
    //   11862: aaload
    //   11863: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11866: astore_3
    //   11867: aload_2
    //   11868: astore_1
    //   11869: aload_3
    //   11870: ldc_w 533
    //   11873: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11876: astore_2
    //   11877: aload_2
    //   11878: astore_1
    //   11879: aload_3
    //   11880: ldc_w 2288
    //   11883: invokevirtual 781	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   11886: astore_3
    //   11887: aload_2
    //   11888: astore_1
    //   11889: new 174	java/util/ArrayList
    //   11892: dup
    //   11893: invokespecial 175	java/util/ArrayList:<init>	()V
    //   11896: astore 4
    //   11898: iconst_0
    //   11899: istore 6
    //   11901: aload_2
    //   11902: astore_1
    //   11903: iload 6
    //   11905: aload_3
    //   11906: invokevirtual 547	org/json/JSONArray:length	()I
    //   11909: if_icmpge +32 -> 11941
    //   11912: aload_2
    //   11913: astore_1
    //   11914: aload 4
    //   11916: aload_3
    //   11917: iload 6
    //   11919: invokevirtual 1988	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   11922: ldc_w 267
    //   11925: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11928: invokevirtual 845	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   11931: pop
    //   11932: iload 6
    //   11934: iconst_1
    //   11935: iadd
    //   11936: istore 6
    //   11938: goto -37 -> 11901
    //   11941: aload_2
    //   11942: astore_1
    //   11943: aload_0
    //   11944: getfield 144	ufd:jdField_a_of_type_Zon	Lzon;
    //   11947: aload 4
    //   11949: invokevirtual 2289	zon:b	(Ljava/util/ArrayList;)V
    //   11952: aload_2
    //   11953: astore_1
    //   11954: aload_0
    //   11955: aload_2
    //   11956: iconst_1
    //   11957: anewarray 201	java/lang/String
    //   11960: dup
    //   11961: iconst_0
    //   11962: new 224	org/json/JSONObject
    //   11965: dup
    //   11966: invokespecial 225	org/json/JSONObject:<init>	()V
    //   11969: ldc_w 314
    //   11972: iconst_0
    //   11973: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11976: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11979: aastore
    //   11980: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11983: goto -7503 -> 4480
    //   11986: astore_2
    //   11987: aload_2
    //   11988: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   11991: aload_0
    //   11992: aload_1
    //   11993: iconst_1
    //   11994: anewarray 201	java/lang/String
    //   11997: dup
    //   11998: iconst_0
    //   11999: ldc_w 2284
    //   12002: aastore
    //   12003: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12006: goto -7526 -> 4480
    //   12009: ldc_w 2291
    //   12012: aload 4
    //   12014: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12017: ifeq +258 -> 12275
    //   12020: new 224	org/json/JSONObject
    //   12023: dup
    //   12024: aload 5
    //   12026: iconst_0
    //   12027: aaload
    //   12028: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12031: astore_3
    //   12032: aload_3
    //   12033: ldc_w 533
    //   12036: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12039: astore_2
    //   12040: aload_3
    //   12041: ldc_w 2293
    //   12044: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   12047: ifeq +13 -> 12060
    //   12050: aload_3
    //   12051: ldc_w 2293
    //   12054: ldc 163
    //   12056: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12059: pop
    //   12060: ldc 163
    //   12062: astore_1
    //   12063: aload_3
    //   12064: ldc_w 2295
    //   12067: invokevirtual 1637	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   12070: ifeq +13 -> 12083
    //   12073: aload_3
    //   12074: ldc_w 2295
    //   12077: ldc 163
    //   12079: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12082: astore_1
    //   12083: ldc_w 2297
    //   12086: aload_1
    //   12087: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12090: ifeq +93 -> 12183
    //   12093: aload_0
    //   12094: getfield 146	ufd:jdField_a_of_type_Rxk	Lrxk;
    //   12097: ldc_w 2299
    //   12100: aconst_null
    //   12101: invokevirtual 2302	rxk:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   12104: ldc_w 2304
    //   12107: ldc 163
    //   12109: invokevirtual 2306	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12112: astore_1
    //   12113: ldc 163
    //   12115: aload_1
    //   12116: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12119: istore 13
    //   12121: iload 13
    //   12123: ifne -7643 -> 4480
    //   12126: new 224	org/json/JSONObject
    //   12129: dup
    //   12130: aload_1
    //   12131: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12134: astore_1
    //   12135: aload_0
    //   12136: aload_2
    //   12137: iconst_1
    //   12138: anewarray 201	java/lang/String
    //   12141: dup
    //   12142: iconst_0
    //   12143: new 224	org/json/JSONObject
    //   12146: dup
    //   12147: invokespecial 225	org/json/JSONObject:<init>	()V
    //   12150: ldc_w 2308
    //   12153: aload_1
    //   12154: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12157: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12160: aastore
    //   12161: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12164: goto -7684 -> 4480
    //   12167: astore_1
    //   12168: aload_1
    //   12169: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   12172: goto -7692 -> 4480
    //   12175: astore_1
    //   12176: aload_1
    //   12177: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   12180: goto -7700 -> 4480
    //   12183: ldc_w 2310
    //   12186: aload_1
    //   12187: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12190: ifeq -7710 -> 4480
    //   12193: aload_0
    //   12194: getfield 146	ufd:jdField_a_of_type_Rxk	Lrxk;
    //   12197: ldc_w 2312
    //   12200: aconst_null
    //   12201: invokevirtual 2302	rxk:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   12204: ldc_w 2314
    //   12207: ldc 163
    //   12209: invokevirtual 2306	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12212: astore_1
    //   12213: ldc 163
    //   12215: aload_1
    //   12216: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12219: istore 13
    //   12221: iload 13
    //   12223: ifne -7743 -> 4480
    //   12226: new 224	org/json/JSONObject
    //   12229: dup
    //   12230: aload_1
    //   12231: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12234: astore_1
    //   12235: aload_0
    //   12236: aload_2
    //   12237: iconst_1
    //   12238: anewarray 201	java/lang/String
    //   12241: dup
    //   12242: iconst_0
    //   12243: new 224	org/json/JSONObject
    //   12246: dup
    //   12247: invokespecial 225	org/json/JSONObject:<init>	()V
    //   12250: ldc_w 2308
    //   12253: aload_1
    //   12254: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   12257: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12260: aastore
    //   12261: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12264: goto -7784 -> 4480
    //   12267: astore_1
    //   12268: aload_1
    //   12269: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   12272: goto -7792 -> 4480
    //   12275: ldc_w 2316
    //   12278: aload 4
    //   12280: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12283: ifeq +192 -> 12475
    //   12286: new 224	org/json/JSONObject
    //   12289: dup
    //   12290: aload 5
    //   12292: iconst_0
    //   12293: aaload
    //   12294: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12297: astore_1
    //   12298: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12301: ifeq +30 -> 12331
    //   12304: ldc_w 321
    //   12307: iconst_2
    //   12308: new 507	java/lang/StringBuilder
    //   12311: dup
    //   12312: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   12315: ldc_w 2318
    //   12318: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12321: aload_1
    //   12322: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12325: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12328: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12331: aload_1
    //   12332: ldc_w 2320
    //   12335: invokevirtual 2323	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   12338: lstore 18
    //   12340: aload_1
    //   12341: ldc_w 2215
    //   12344: invokevirtual 2213	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   12347: istore 6
    //   12349: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12352: ifeq +42 -> 12394
    //   12355: ldc_w 321
    //   12358: iconst_2
    //   12359: new 507	java/lang/StringBuilder
    //   12362: dup
    //   12363: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   12366: ldc_w 2217
    //   12369: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12372: lload 18
    //   12374: invokevirtual 662	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12377: ldc_w 2219
    //   12380: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12383: iload 6
    //   12385: invokevirtual 645	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12388: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12391: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12394: aload_0
    //   12395: getfield 144	ufd:jdField_a_of_type_Zon	Lzon;
    //   12398: lload 18
    //   12400: iload 6
    //   12402: invokevirtual 2326	zon:a	(JI)V
    //   12405: aload_0
    //   12406: getfield 485	ufd:mRuntime	Lbgve;
    //   12409: invokevirtual 490	bgve:a	()Landroid/app/Activity;
    //   12412: iconst_m1
    //   12413: new 369	android/content/Intent
    //   12416: dup
    //   12417: invokespecial 556	android/content/Intent:<init>	()V
    //   12420: ldc_w 2215
    //   12423: iload 6
    //   12425: invokevirtual 562	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12428: invokevirtual 2330	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   12431: goto -7951 -> 4480
    //   12434: astore_1
    //   12435: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12438: ifeq +30 -> 12468
    //   12441: ldc_w 321
    //   12444: iconst_2
    //   12445: new 507	java/lang/StringBuilder
    //   12448: dup
    //   12449: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   12452: ldc_w 2332
    //   12455: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12458: aload_1
    //   12459: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12462: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12465: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12468: aload_1
    //   12469: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   12472: goto -7992 -> 4480
    //   12475: ldc_w 2334
    //   12478: aload 4
    //   12480: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12483: ifeq +14 -> 12497
    //   12486: aload_0
    //   12487: aload 4
    //   12489: aload 5
    //   12491: invokespecial 2336	ufd:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12494: goto -8014 -> 4480
    //   12497: ldc_w 2338
    //   12500: aload 4
    //   12502: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12505: ifeq +185 -> 12690
    //   12508: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12511: ifeq +13 -> 12524
    //   12514: ldc_w 321
    //   12517: iconst_2
    //   12518: ldc_w 2340
    //   12521: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12524: aload_0
    //   12525: getfield 148	ufd:jdField_a_of_type_Set	Lset;
    //   12528: ifnonnull +14 -> 12542
    //   12531: aload_0
    //   12532: new 2341	set
    //   12535: dup
    //   12536: invokespecial 2342	set:<init>	()V
    //   12539: putfield 148	ufd:jdField_a_of_type_Set	Lset;
    //   12542: aload_0
    //   12543: getfield 148	ufd:jdField_a_of_type_Set	Lset;
    //   12546: astore_1
    //   12547: aload_1
    //   12548: new 2344	uga
    //   12551: dup
    //   12552: aload_0
    //   12553: invokespecial 2345	uga:<init>	(Lufd;)V
    //   12556: invokevirtual 2348	set:a	(Lsew;)V
    //   12559: new 224	org/json/JSONObject
    //   12562: dup
    //   12563: aload 5
    //   12565: iconst_0
    //   12566: aaload
    //   12567: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12570: astore_2
    //   12571: aload_2
    //   12572: ldc_w 533
    //   12575: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12578: astore_3
    //   12579: aload_2
    //   12580: ldc_w 2350
    //   12583: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12586: astore 4
    //   12588: aload_2
    //   12589: ldc_w 2352
    //   12592: iconst_m1
    //   12593: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12596: istore 6
    //   12598: aload_2
    //   12599: ldc_w 2354
    //   12602: iconst_0
    //   12603: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12606: istore 7
    //   12608: aload_2
    //   12609: ldc_w 2356
    //   12612: iconst_0
    //   12613: invokevirtual 598	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12616: istore 8
    //   12618: aload_2
    //   12619: ldc_w 2358
    //   12622: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12625: astore 5
    //   12627: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12630: ifeq +33 -> 12663
    //   12633: ldc_w 321
    //   12636: iconst_2
    //   12637: new 507	java/lang/StringBuilder
    //   12640: dup
    //   12641: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   12644: ldc_w 2360
    //   12647: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12650: aload_2
    //   12651: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12654: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12657: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12660: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12663: aload_1
    //   12664: aload 4
    //   12666: iload 6
    //   12668: iload 7
    //   12670: i2l
    //   12671: iload 8
    //   12673: aload 5
    //   12675: aload_3
    //   12676: invokevirtual 2363	set:a	(Ljava/lang/String;IJILjava/lang/String;Ljava/lang/String;)V
    //   12679: goto -8199 -> 4480
    //   12682: astore_1
    //   12683: aload_1
    //   12684: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   12687: goto -8207 -> 4480
    //   12690: ldc_w 2365
    //   12693: aload 4
    //   12695: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12698: ifeq +35 -> 12733
    //   12701: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12704: ifeq +13 -> 12717
    //   12707: ldc_w 321
    //   12710: iconst_2
    //   12711: ldc_w 2367
    //   12714: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12717: aload_0
    //   12718: getfield 148	ufd:jdField_a_of_type_Set	Lset;
    //   12721: astore_1
    //   12722: aload_1
    //   12723: ifnull -8243 -> 4480
    //   12726: aload_1
    //   12727: invokevirtual 2368	set:a	()V
    //   12730: goto -8250 -> 4480
    //   12733: ldc_w 2370
    //   12736: aload 4
    //   12738: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12741: ifeq +83 -> 12824
    //   12744: new 338	android/os/Bundle
    //   12747: dup
    //   12748: invokespecial 339	android/os/Bundle:<init>	()V
    //   12751: astore_1
    //   12752: new 224	org/json/JSONObject
    //   12755: dup
    //   12756: aload 5
    //   12758: iconst_0
    //   12759: aaload
    //   12760: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12763: astore_3
    //   12764: aload_3
    //   12765: ldc_w 267
    //   12768: invokevirtual 2202	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12771: astore_2
    //   12772: aload_3
    //   12773: ldc_w 2372
    //   12776: ldc 163
    //   12778: invokevirtual 523	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12781: astore_3
    //   12782: aload_1
    //   12783: ldc_w 267
    //   12786: aload_2
    //   12787: invokevirtual 452	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12790: aload_1
    //   12791: ldc_w 2372
    //   12794: aload_3
    //   12795: invokevirtual 452	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12798: aload_0
    //   12799: getfield 146	ufd:jdField_a_of_type_Rxk	Lrxk;
    //   12802: ifnull -8322 -> 4480
    //   12805: aload_0
    //   12806: getfield 146	ufd:jdField_a_of_type_Rxk	Lrxk;
    //   12809: ldc_w 2374
    //   12812: aload_1
    //   12813: invokevirtual 2302	rxk:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   12816: pop
    //   12817: goto -8337 -> 4480
    //   12820: astore_1
    //   12821: goto -8341 -> 4480
    //   12824: ldc_w 2376
    //   12827: aload 4
    //   12829: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12832: ifeq +97 -> 12929
    //   12835: new 224	org/json/JSONObject
    //   12838: dup
    //   12839: aload 5
    //   12841: iconst_0
    //   12842: aaload
    //   12843: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12846: ldc_w 1904
    //   12849: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12852: astore_1
    //   12853: ldc_w 321
    //   12856: iconst_2
    //   12857: new 507	java/lang/StringBuilder
    //   12860: dup
    //   12861: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   12864: ldc_w 2378
    //   12867: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12870: aload_1
    //   12871: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12874: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12877: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12880: new 369	android/content/Intent
    //   12883: dup
    //   12884: invokespecial 556	android/content/Intent:<init>	()V
    //   12887: astore_2
    //   12888: aload_2
    //   12889: ldc_w 809
    //   12892: new 1906	java/math/BigInteger
    //   12895: dup
    //   12896: aload_1
    //   12897: invokespecial 1907	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   12900: invokevirtual 1910	java/math/BigInteger:longValue	()J
    //   12903: invokevirtual 2098	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   12906: pop
    //   12907: aload_0
    //   12908: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   12911: aload_2
    //   12912: ldc_w 2380
    //   12915: invokestatic 2382	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   12918: goto -8438 -> 4480
    //   12921: astore_1
    //   12922: aload_1
    //   12923: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   12926: goto -8446 -> 4480
    //   12929: ldc_w 2384
    //   12932: aload 4
    //   12934: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12937: ifeq +203 -> 13140
    //   12940: new 224	org/json/JSONObject
    //   12943: dup
    //   12944: aload 5
    //   12946: iconst_0
    //   12947: aaload
    //   12948: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12951: astore_2
    //   12952: aload_2
    //   12953: ldc_w 2386
    //   12956: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   12959: istore 6
    //   12961: aload_2
    //   12962: ldc_w 2388
    //   12965: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12968: astore_3
    //   12969: aload_2
    //   12970: ldc_w 1293
    //   12973: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12976: astore 4
    //   12978: aload_2
    //   12979: ldc_w 533
    //   12982: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12985: astore 5
    //   12987: iload 6
    //   12989: tableswitch	default:+1118 -> 14107, 1:+137->13126, 2:+1125->14114, 3:+144->13133
    //   13017: aconst_null
    //   13018: lstore_2
    //   13019: iconst_1
    //   13020: new 507	java/lang/StringBuilder
    //   13023: dup
    //   13024: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   13027: ldc_w 2390
    //   13030: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13033: iload 6
    //   13035: invokevirtual 645	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13038: ldc_w 2392
    //   13041: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13044: aload_3
    //   13045: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13048: ldc_w 2392
    //   13051: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13054: aload 4
    //   13056: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13059: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13062: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13065: aconst_null
    //   13066: ldc 163
    //   13068: aload_1
    //   13069: aload_1
    //   13070: iconst_0
    //   13071: iconst_0
    //   13072: ldc 163
    //   13074: ldc 163
    //   13076: aload_3
    //   13077: aload_2
    //   13078: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   13081: iconst_0
    //   13082: invokestatic 2395	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   13085: aload_0
    //   13086: aload 5
    //   13088: iconst_1
    //   13089: anewarray 201	java/lang/String
    //   13092: dup
    //   13093: iconst_0
    //   13094: new 224	org/json/JSONObject
    //   13097: dup
    //   13098: invokespecial 225	org/json/JSONObject:<init>	()V
    //   13101: ldc_w 314
    //   13104: iconst_0
    //   13105: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   13108: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   13111: aastore
    //   13112: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13115: goto -8635 -> 4480
    //   13118: astore_1
    //   13119: aload_1
    //   13120: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   13123: goto -8643 -> 4480
    //   13126: ldc_w 2397
    //   13129: astore_1
    //   13130: goto -114 -> 13016
    //   13133: ldc_w 2399
    //   13136: astore_1
    //   13137: goto -121 -> 13016
    //   13140: ldc_w 2401
    //   13143: aload 4
    //   13145: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13148: ifeq +61 -> 13209
    //   13151: new 224	org/json/JSONObject
    //   13154: dup
    //   13155: aload 5
    //   13157: iconst_0
    //   13158: aaload
    //   13159: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13162: ldc_w 533
    //   13165: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13168: astore_1
    //   13169: new 224	org/json/JSONObject
    //   13172: dup
    //   13173: aload 5
    //   13175: iconst_0
    //   13176: aaload
    //   13177: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13180: aload_1
    //   13181: new 2403	ugb
    //   13184: dup
    //   13185: aload_0
    //   13186: invokespecial 2404	ugb:<init>	(Lufd;)V
    //   13189: invokestatic 2406	ufd:a	(Lorg/json/JSONObject;Ljava/lang/String;Ltiu;)V
    //   13192: iconst_1
    //   13193: ireturn
    //   13194: astore_1
    //   13195: ldc_w 321
    //   13198: iconst_1
    //   13199: ldc_w 2408
    //   13202: aload_1
    //   13203: invokestatic 1831	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13206: goto -14 -> 13192
    //   13209: ldc_w 2410
    //   13212: aload 4
    //   13214: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13217: ifeq +196 -> 13413
    //   13220: invokestatic 2413	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13223: ifne +9 -> 13232
    //   13226: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13229: ifeq +25 -> 13254
    //   13232: ldc_w 321
    //   13235: iconst_1
    //   13236: iconst_2
    //   13237: anewarray 830	java/lang/Object
    //   13240: dup
    //   13241: iconst_0
    //   13242: ldc_w 2415
    //   13245: aastore
    //   13246: dup
    //   13247: iconst_1
    //   13248: aload 5
    //   13250: aastore
    //   13251: invokestatic 839	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   13254: aload 5
    //   13256: ifnull +865 -> 14121
    //   13259: aload 5
    //   13261: arraylength
    //   13262: ifle +859 -> 14121
    //   13265: new 224	org/json/JSONObject
    //   13268: dup
    //   13269: aload 5
    //   13271: iconst_0
    //   13272: aaload
    //   13273: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13276: ldc_w 2417
    //   13279: invokevirtual 529	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13282: istore 6
    //   13284: iload 6
    //   13286: ifne +57 -> 13343
    //   13289: invokestatic 2413	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13292: ifne +9 -> 13301
    //   13295: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13298: ifeq +13 -> 13311
    //   13301: ldc_w 321
    //   13304: iconst_1
    //   13305: ldc_w 2419
    //   13308: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13311: aload_0
    //   13312: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   13315: iconst_m1
    //   13316: new 369	android/content/Intent
    //   13319: dup
    //   13320: invokespecial 556	android/content/Intent:<init>	()V
    //   13323: ldc_w 2421
    //   13326: iconst_1
    //   13327: invokevirtual 994	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   13330: invokevirtual 2330	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   13333: aload_0
    //   13334: getfield 365	ufd:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   13337: invokevirtual 2424	android/app/Activity:finish	()V
    //   13340: goto +781 -> 14121
    //   13343: invokestatic 2413	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13346: ifne +9 -> 13355
    //   13349: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13352: ifeq +769 -> 14121
    //   13355: ldc_w 321
    //   13358: iconst_1
    //   13359: new 507	java/lang/StringBuilder
    //   13362: dup
    //   13363: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   13366: ldc_w 2426
    //   13369: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13372: iload 6
    //   13374: invokevirtual 645	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13377: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13380: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13383: goto +738 -> 14121
    //   13386: astore_1
    //   13387: invokestatic 2413	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   13390: ifne +9 -> 13399
    //   13393: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13396: ifeq +725 -> 14121
    //   13399: ldc_w 321
    //   13402: iconst_1
    //   13403: ldc_w 2428
    //   13406: aload_1
    //   13407: invokestatic 1831	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13410: goto +711 -> 14121
    //   13413: ldc_w 2430
    //   13416: aload 4
    //   13418: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13421: ifeq +60 -> 13481
    //   13424: ldc_w 321
    //   13427: iconst_1
    //   13428: ldc_w 2432
    //   13431: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13434: new 224	org/json/JSONObject
    //   13437: dup
    //   13438: aload 5
    //   13440: iconst_0
    //   13441: aaload
    //   13442: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13445: ldc_w 533
    //   13448: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13451: astore_1
    //   13452: new 2434	uff
    //   13455: dup
    //   13456: aload_0
    //   13457: invokespecial 2435	uff:<init>	(Lufd;)V
    //   13460: aload_1
    //   13461: invokestatic 2437	ufd:a	(Ltiv;Ljava/lang/String;)V
    //   13464: iconst_1
    //   13465: ireturn
    //   13466: astore_1
    //   13467: ldc_w 321
    //   13470: iconst_1
    //   13471: aload_1
    //   13472: invokevirtual 324	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13475: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13478: goto -14 -> 13464
    //   13481: ldc_w 2439
    //   13484: aload 4
    //   13486: invokevirtual 586	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13489: ifeq -9009 -> 4480
    //   13492: ldc_w 321
    //   13495: iconst_1
    //   13496: ldc_w 2441
    //   13499: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13502: new 224	org/json/JSONObject
    //   13505: dup
    //   13506: aload 5
    //   13508: iconst_0
    //   13509: aaload
    //   13510: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13513: astore_1
    //   13514: aload_1
    //   13515: ldc 237
    //   13517: invokevirtual 807	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   13520: lstore 18
    //   13522: aload_1
    //   13523: ldc_w 533
    //   13526: invokevirtual 596	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13529: astore_1
    //   13530: lload 18
    //   13532: new 2443	ufg
    //   13535: dup
    //   13536: aload_0
    //   13537: invokespecial 2444	ufg:<init>	(Lufd;)V
    //   13540: aload_1
    //   13541: invokestatic 2446	ufd:a	(JLtiv;Ljava/lang/String;)V
    //   13544: iconst_1
    //   13545: ireturn
    //   13546: astore_1
    //   13547: ldc_w 321
    //   13550: iconst_1
    //   13551: aload_1
    //   13552: invokevirtual 324	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13555: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13558: aload_0
    //   13559: aload_0
    //   13560: getfield 2447	ufd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   13563: iconst_1
    //   13564: anewarray 201	java/lang/String
    //   13567: dup
    //   13568: iconst_0
    //   13569: aload_1
    //   13570: invokevirtual 324	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13573: invokestatic 2448	ufd:a	(Ljava/lang/String;)Ljava/lang/String;
    //   13576: aastore
    //   13577: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13580: goto -36 -> 13544
    //   13583: astore 4
    //   13585: aload_1
    //   13586: astore 42
    //   13588: ldc 163
    //   13590: astore_1
    //   13591: aload_3
    //   13592: astore_2
    //   13593: lload 38
    //   13595: lstore 34
    //   13597: lload 36
    //   13599: lstore 32
    //   13601: aload 42
    //   13603: astore_3
    //   13604: goto -3940 -> 9664
    //   13607: astore 4
    //   13609: ldc 163
    //   13611: astore 42
    //   13613: aload_1
    //   13614: astore_3
    //   13615: aload 42
    //   13617: astore_1
    //   13618: lload 38
    //   13620: lstore 34
    //   13622: lload 36
    //   13624: lstore 32
    //   13626: goto -3962 -> 9664
    //   13629: astore 4
    //   13631: aload_1
    //   13632: astore 42
    //   13634: aload_3
    //   13635: astore_1
    //   13636: lload 30
    //   13638: lstore 24
    //   13640: lload 28
    //   13642: lstore 22
    //   13644: lload 26
    //   13646: lstore 18
    //   13648: aload 42
    //   13650: astore_3
    //   13651: goto -3987 -> 9664
    //   13654: astore 4
    //   13656: aload_1
    //   13657: astore 42
    //   13659: ldc 163
    //   13661: astore_1
    //   13662: aload_3
    //   13663: astore_2
    //   13664: lload 38
    //   13666: lstore 34
    //   13668: lload 36
    //   13670: lstore 32
    //   13672: aload 42
    //   13674: astore_3
    //   13675: goto -6600 -> 7075
    //   13678: astore 4
    //   13680: ldc 163
    //   13682: astore 42
    //   13684: aload_1
    //   13685: astore_3
    //   13686: aload 42
    //   13688: astore_1
    //   13689: lload 38
    //   13691: lstore 34
    //   13693: lload 36
    //   13695: lstore 32
    //   13697: goto -6622 -> 7075
    //   13700: astore 4
    //   13702: aload_1
    //   13703: astore 42
    //   13705: aload_3
    //   13706: astore_1
    //   13707: lload 30
    //   13709: lstore 24
    //   13711: lload 28
    //   13713: lstore 22
    //   13715: lload 26
    //   13717: lstore 18
    //   13719: aload 42
    //   13721: astore_3
    //   13722: goto -6647 -> 7075
    //   13725: astore_1
    //   13726: iload 14
    //   13728: istore 13
    //   13730: goto -9495 -> 4235
    //   13733: iconst_0
    //   13734: istore 7
    //   13736: goto -2283 -> 11453
    //   13739: iconst_m1
    //   13740: istore 6
    //   13742: goto -2311 -> 11431
    //   13745: ldc 163
    //   13747: astore_1
    //   13748: goto -2339 -> 11409
    //   13751: ldc 163
    //   13753: astore_2
    //   13754: goto -2380 -> 11374
    //   13757: iconst_1
    //   13758: istore 14
    //   13760: goto -2477 -> 11283
    //   13763: iconst_0
    //   13764: istore 13
    //   13766: goto -2504 -> 11262
    //   13769: aload 5
    //   13771: astore_1
    //   13772: goto -3057 -> 10715
    //   13775: aload 40
    //   13777: astore_2
    //   13778: goto -3468 -> 10310
    //   13781: aload 5
    //   13783: astore_1
    //   13784: goto -5520 -> 8264
    //   13787: aload 40
    //   13789: astore_2
    //   13790: goto -5931 -> 7859
    //   13793: aconst_null
    //   13794: astore_1
    //   13795: goto -9438 -> 4357
    //   13798: iconst_0
    //   13799: istore 13
    //   13801: goto -9566 -> 4235
    //   13804: iconst_0
    //   13805: istore 6
    //   13807: goto -11234 -> 2573
    //   13810: goto -11284 -> 2526
    //   13813: iconst_1
    //   13814: ireturn
    //   13815: iconst_1
    //   13816: ireturn
    //   13817: bipush 9
    //   13819: istore 8
    //   13821: goto -11295 -> 2526
    //   13824: iconst_1
    //   13825: ireturn
    //   13826: iconst_1
    //   13827: ireturn
    //   13828: iconst_1
    //   13829: ireturn
    //   13830: iload 10
    //   13832: iconst_1
    //   13833: if_icmpeq -9617 -> 4216
    //   13836: iload 10
    //   13838: iconst_2
    //   13839: if_icmpne -41 -> 13798
    //   13842: goto -9626 -> 4216
    //   13845: iconst_1
    //   13846: ireturn
    //   13847: ldc_w 2450
    //   13850: astore_1
    //   13851: goto -8736 -> 5115
    //   13854: ldc_w 2450
    //   13857: astore_2
    //   13858: goto -8732 -> 5126
    //   13861: goto -7855 -> 6006
    //   13864: astore 4
    //   13866: aload_3
    //   13867: astore_2
    //   13868: ldc 163
    //   13870: astore_1
    //   13871: lload 38
    //   13873: lstore 34
    //   13875: lload 36
    //   13877: lstore 32
    //   13879: aload 42
    //   13881: astore_3
    //   13882: goto -6807 -> 7075
    //   13885: iconst_1
    //   13886: istore 6
    //   13888: goto -6117 -> 7771
    //   13891: iload 12
    //   13893: iconst_4
    //   13894: if_icmpeq -5803 -> 8091
    //   13897: iload 12
    //   13899: iconst_5
    //   13900: if_icmpne -5713 -> 8187
    //   13903: goto -5812 -> 8091
    //   13906: iconst_2
    //   13907: istore 6
    //   13909: goto -6138 -> 7771
    //   13912: goto -6141 -> 7771
    //   13915: iload 9
    //   13917: bipush 11
    //   13919: if_icmpne +9 -> 13928
    //   13922: iconst_5
    //   13923: istore 6
    //   13925: goto -5947 -> 7978
    //   13928: iload 9
    //   13930: bipush 6
    //   13932: if_icmpne +10 -> 13942
    //   13935: bipush 6
    //   13937: istore 6
    //   13939: goto -5961 -> 7978
    //   13942: iload 9
    //   13944: bipush 12
    //   13946: if_icmpne +10 -> 13956
    //   13949: bipush 7
    //   13951: istore 6
    //   13953: goto -5975 -> 7978
    //   13956: iload 9
    //   13958: bipush 13
    //   13960: if_icmpne +10 -> 13970
    //   13963: bipush 8
    //   13965: istore 6
    //   13967: goto -5989 -> 7978
    //   13970: iload 9
    //   13972: bipush 15
    //   13974: if_icmplt -5996 -> 7978
    //   13977: iload 9
    //   13979: istore 6
    //   13981: goto -6003 -> 7978
    //   13984: goto -5389 -> 8595
    //   13987: astore 4
    //   13989: aload_3
    //   13990: astore_2
    //   13991: ldc 163
    //   13993: astore_1
    //   13994: lload 38
    //   13996: lstore 34
    //   13998: lload 36
    //   14000: lstore 32
    //   14002: aload 42
    //   14004: astore_3
    //   14005: goto -4341 -> 9664
    //   14008: iconst_1
    //   14009: istore 6
    //   14011: goto -3789 -> 10222
    //   14014: iload 12
    //   14016: iconst_4
    //   14017: if_icmpeq -3475 -> 10542
    //   14020: iload 12
    //   14022: iconst_5
    //   14023: if_icmpne -3385 -> 10638
    //   14026: goto -3484 -> 10542
    //   14029: iconst_2
    //   14030: istore 6
    //   14032: goto -3810 -> 10222
    //   14035: goto -3813 -> 10222
    //   14038: iload 9
    //   14040: bipush 11
    //   14042: if_icmpne +9 -> 14051
    //   14045: iconst_5
    //   14046: istore 6
    //   14048: goto -3619 -> 10429
    //   14051: iload 9
    //   14053: bipush 6
    //   14055: if_icmpne +10 -> 14065
    //   14058: bipush 6
    //   14060: istore 6
    //   14062: goto -3633 -> 10429
    //   14065: iload 9
    //   14067: bipush 12
    //   14069: if_icmpne +10 -> 14079
    //   14072: bipush 7
    //   14074: istore 6
    //   14076: goto -3647 -> 10429
    //   14079: iload 9
    //   14081: bipush 13
    //   14083: if_icmpne +10 -> 14093
    //   14086: bipush 8
    //   14088: istore 6
    //   14090: goto -3661 -> 10429
    //   14093: iload 9
    //   14095: bipush 15
    //   14097: if_icmplt -3668 -> 10429
    //   14100: iload 9
    //   14102: istore 6
    //   14104: goto -3675 -> 10429
    //   14107: ldc_w 2452
    //   14110: astore_1
    //   14111: goto -1095 -> 13016
    //   14114: ldc_w 2454
    //   14117: astore_1
    //   14118: goto -1102 -> 13016
    //   14121: iconst_1
    //   14122: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	14123	0	this	ufd
    //   0	14123	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	14123	2	paramString1	String
    //   0	14123	3	paramString2	String
    //   0	14123	4	paramString3	String
    //   0	14123	5	paramVarArgs	String[]
    //   491	13612	6	i1	int
    //   2578	11157	7	i2	int
    //   2508	11312	8	i3	int
    //   2574	11527	9	i4	int
    //   3946	9894	10	i5	int
    //   6654	4159	11	i6	int
    //   7258	6766	12	i7	int
    //   351	13449	13	bool1	boolean
    //   4085	9674	14	bool2	boolean
    //   4860	51	15	bool3	boolean
    //   4872	49	16	bool4	boolean
    //   4884	47	17	bool5	boolean
    //   6048	7670	18	l1	long
    //   6118	4359	20	l2	long
    //   6051	7663	22	l3	long
    //   6054	7656	24	l4	long
    //   6138	7578	26	l5	long
    //   6134	7578	28	l6	long
    //   6130	7578	30	l7	long
    //   6126	7875	32	l8	long
    //   6122	7875	34	l9	long
    //   6057	7942	36	l10	long
    //   6060	7935	38	l11	long
    //   6064	1027	40	localObject1	Object
    //   7096	20	40	localJSONException1	JSONException
    //   7130	2550	40	localObject2	Object
    //   9685	3	40	localJSONException2	JSONException
    //   9693	4095	40	str1	String
    //   5993	4519	41	str2	String
    //   5974	8029	42	localObject3	Object
    //   5927	4673	43	localObject4	Object
    //   6663	4152	44	localArticleInfo	com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo
    //   6602	3645	45	str3	String
    //   6643	3611	46	str4	String
    //   6839	3791	47	localObject5	Object
    //   6848	186	48	localObject6	Object
    //   7135	20	48	localException1	Exception
    //   7344	2279	48	localObject7	Object
    //   9698	3	48	localException2	Exception
    //   9855	217	48	localBiuCommentInfo	com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo
    //   6947	586	49	localObject8	Object
    //   7577	20	49	localException3	Exception
    //   9536	508	49	localObject9	Object
    //   10088	3	49	localException4	Exception
    //   6957	3046	50	str5	String
    //   7462	2550	51	str6	String
    // Exception table:
    //   from	to	target	type
    //   31	100	134	org/json/JSONException
    //   100	104	134	org/json/JSONException
    //   164	195	197	org/json/JSONException
    //   227	296	302	org/json/JSONException
    //   296	300	302	org/json/JSONException
    //   332	412	420	org/json/JSONException
    //   412	418	420	org/json/JSONException
    //   450	486	608	org/json/JSONException
    //   493	513	608	org/json/JSONException
    //   522	573	608	org/json/JSONException
    //   573	578	608	org/json/JSONException
    //   638	674	796	org/json/JSONException
    //   681	701	796	org/json/JSONException
    //   710	761	796	org/json/JSONException
    //   761	766	796	org/json/JSONException
    //   826	895	929	org/json/JSONException
    //   895	899	929	org/json/JSONException
    //   959	1028	1062	org/json/JSONException
    //   1028	1032	1062	org/json/JSONException
    //   1092	1161	1195	org/json/JSONException
    //   1161	1165	1195	org/json/JSONException
    //   1225	1294	1328	org/json/JSONException
    //   1294	1298	1328	org/json/JSONException
    //   1358	1417	1672	org/json/JSONException
    //   1422	1430	1672	org/json/JSONException
    //   1430	1465	1672	org/json/JSONException
    //   1467	1511	1672	org/json/JSONException
    //   1513	1522	1672	org/json/JSONException
    //   1522	1544	1672	org/json/JSONException
    //   1548	1578	1672	org/json/JSONException
    //   1580	1638	1672	org/json/JSONException
    //   1702	1758	1925	org/json/JSONException
    //   1758	1773	1925	org/json/JSONException
    //   1775	1783	1925	org/json/JSONException
    //   1783	1803	1925	org/json/JSONException
    //   1807	1837	1925	org/json/JSONException
    //   1839	1892	1925	org/json/JSONException
    //   2004	2048	2080	org/json/JSONException
    //   1955	1999	2088	org/json/JSONException
    //   2048	2077	2088	org/json/JSONException
    //   2081	2085	2088	org/json/JSONException
    //   2096	2126	2088	org/json/JSONException
    //   2126	2159	2088	org/json/JSONException
    //   2199	2203	2088	org/json/JSONException
    //   2206	2225	2088	org/json/JSONException
    //   2245	2261	2088	org/json/JSONException
    //   2265	2269	2088	org/json/JSONException
    //   2272	2281	2088	org/json/JSONException
    //   2159	2195	2198	org/json/JSONException
    //   2225	2245	2264	org/json/JSONException
    //   2355	2399	2431	org/json/JSONException
    //   2306	2350	2439	org/json/JSONException
    //   2399	2428	2439	org/json/JSONException
    //   2432	2436	2439	org/json/JSONException
    //   2447	2456	2439	org/json/JSONException
    //   2481	2510	2698	org/json/JSONException
    //   2526	2542	2698	org/json/JSONException
    //   2546	2570	2698	org/json/JSONException
    //   2588	2612	2698	org/json/JSONException
    //   2615	2655	2698	org/json/JSONException
    //   2658	2668	2698	org/json/JSONException
    //   2674	2683	2698	org/json/JSONException
    //   2728	2787	2825	org/json/JSONException
    //   2787	2794	2825	org/json/JSONException
    //   2794	2823	2825	org/json/JSONException
    //   2930	2976	2979	org/json/JSONException
    //   2855	2899	2987	org/json/JSONException
    //   2899	2928	2987	org/json/JSONException
    //   2980	2984	2987	org/json/JSONException
    //   3151	3171	3250	org/json/JSONException
    //   3017	3080	3258	org/json/JSONException
    //   3082	3112	3258	org/json/JSONException
    //   3112	3151	3258	org/json/JSONException
    //   3171	3200	3258	org/json/JSONException
    //   3200	3218	3258	org/json/JSONException
    //   3218	3247	3258	org/json/JSONException
    //   3251	3255	3258	org/json/JSONException
    //   3286	3315	3258	org/json/JSONException
    //   3319	3323	3258	org/json/JSONException
    //   3326	3334	3258	org/json/JSONException
    //   3376	3380	3258	org/json/JSONException
    //   3266	3286	3318	org/json/JSONException
    //   3334	3372	3375	org/json/JSONException
    //   3504	3540	3601	org/json/JSONException
    //   3405	3470	3609	org/json/JSONException
    //   3470	3504	3609	org/json/JSONException
    //   3540	3569	3609	org/json/JSONException
    //   3569	3598	3609	org/json/JSONException
    //   3602	3606	3609	org/json/JSONException
    //   3639	3706	3782	org/json/JSONException
    //   3706	3751	3782	org/json/JSONException
    //   3751	3780	3782	org/json/JSONException
    //   3812	3832	3834	org/json/JSONException
    //   3864	3884	3886	org/json/JSONException
    //   3916	3948	4053	org/json/JSONException
    //   3968	4001	4053	org/json/JSONException
    //   4001	4034	4053	org/json/JSONException
    //   4034	4051	4053	org/json/JSONException
    //   4307	4348	4475	org/json/JSONException
    //   4352	4357	4475	org/json/JSONException
    //   4357	4399	4475	org/json/JSONException
    //   4403	4408	4475	org/json/JSONException
    //   4411	4432	4475	org/json/JSONException
    //   4441	4463	4475	org/json/JSONException
    //   4467	4473	4475	org/json/JSONException
    //   4493	4579	4615	org/json/JSONException
    //   4579	4612	4615	org/json/JSONException
    //   4645	4715	4990	org/json/JSONException
    //   4718	4723	4990	org/json/JSONException
    //   4735	4752	4990	org/json/JSONException
    //   4755	4772	4990	org/json/JSONException
    //   4776	4787	4990	org/json/JSONException
    //   4791	4822	4990	org/json/JSONException
    //   4826	4988	4990	org/json/JSONException
    //   5104	5111	5221	org/json/JSONException
    //   5115	5122	5221	org/json/JSONException
    //   5126	5153	5221	org/json/JSONException
    //   5158	5205	5221	org/json/JSONException
    //   5208	5218	5221	org/json/JSONException
    //   5258	5307	5353	org/json/JSONException
    //   5307	5330	5353	org/json/JSONException
    //   5402	5453	5499	java/lang/Exception
    //   5453	5476	5499	java/lang/Exception
    //   5548	5596	5645	java/lang/Exception
    //   5596	5619	5645	java/lang/Exception
    //   5694	5728	5731	org/json/JSONException
    //   5768	5876	5879	org/json/JSONException
    //   6727	6737	7096	org/json/JSONException
    //   7009	7047	7135	java/lang/Exception
    //   5916	5966	7171	org/json/JSONException
    //   5966	6003	7171	org/json/JSONException
    //   6006	6016	7171	org/json/JSONException
    //   6026	6047	7171	org/json/JSONException
    //   6066	6080	7171	org/json/JSONException
    //   6080	6093	7171	org/json/JSONException
    //   6093	6112	7171	org/json/JSONException
    //   6140	6147	7171	org/json/JSONException
    //   6167	6180	7171	org/json/JSONException
    //   6200	6210	7171	org/json/JSONException
    //   6234	6242	7171	org/json/JSONException
    //   6262	6276	7171	org/json/JSONException
    //   6296	6306	7171	org/json/JSONException
    //   6330	6338	7171	org/json/JSONException
    //   6358	6372	7171	org/json/JSONException
    //   6392	6402	7171	org/json/JSONException
    //   6426	6434	7171	org/json/JSONException
    //   6454	6468	7171	org/json/JSONException
    //   6488	6498	7171	org/json/JSONException
    //   6518	6527	7171	org/json/JSONException
    //   6563	6727	7171	org/json/JSONException
    //   6737	6814	7171	org/json/JSONException
    //   6822	7003	7171	org/json/JSONException
    //   7009	7047	7171	org/json/JSONException
    //   7047	7066	7171	org/json/JSONException
    //   7075	7080	7171	org/json/JSONException
    //   7098	7129	7171	org/json/JSONException
    //   7137	7168	7171	org/json/JSONException
    //   7205	7215	7171	org/json/JSONException
    //   7224	7280	7171	org/json/JSONException
    //   7285	7324	7171	org/json/JSONException
    //   7327	7508	7171	org/json/JSONException
    //   7508	7546	7171	org/json/JSONException
    //   7546	7568	7171	org/json/JSONException
    //   7579	7610	7171	org/json/JSONException
    //   7647	7672	7171	org/json/JSONException
    //   7684	7721	7171	org/json/JSONException
    //   7726	7768	7171	org/json/JSONException
    //   7778	7827	7171	org/json/JSONException
    //   7827	7856	7171	org/json/JSONException
    //   7859	7933	7171	org/json/JSONException
    //   7933	7966	7171	org/json/JSONException
    //   7978	8053	7171	org/json/JSONException
    //   8060	8079	7171	org/json/JSONException
    //   8079	8089	7171	org/json/JSONException
    //   8091	8128	7171	org/json/JSONException
    //   8133	8184	7171	org/json/JSONException
    //   8193	8200	7171	org/json/JSONException
    //   8209	8264	7171	org/json/JSONException
    //   8266	8273	7171	org/json/JSONException
    //   8277	8366	7171	org/json/JSONException
    //   8369	8470	7171	org/json/JSONException
    //   7508	7546	7577	java/lang/Exception
    //   5916	5966	7613	java/lang/NumberFormatException
    //   5966	6003	7613	java/lang/NumberFormatException
    //   6006	6016	7613	java/lang/NumberFormatException
    //   6026	6047	7613	java/lang/NumberFormatException
    //   6066	6080	7613	java/lang/NumberFormatException
    //   6080	6093	7613	java/lang/NumberFormatException
    //   6093	6112	7613	java/lang/NumberFormatException
    //   6140	6147	7613	java/lang/NumberFormatException
    //   6167	6180	7613	java/lang/NumberFormatException
    //   6200	6210	7613	java/lang/NumberFormatException
    //   6234	6242	7613	java/lang/NumberFormatException
    //   6262	6276	7613	java/lang/NumberFormatException
    //   6296	6306	7613	java/lang/NumberFormatException
    //   6330	6338	7613	java/lang/NumberFormatException
    //   6358	6372	7613	java/lang/NumberFormatException
    //   6392	6402	7613	java/lang/NumberFormatException
    //   6426	6434	7613	java/lang/NumberFormatException
    //   6454	6468	7613	java/lang/NumberFormatException
    //   6488	6498	7613	java/lang/NumberFormatException
    //   6518	6527	7613	java/lang/NumberFormatException
    //   6563	6727	7613	java/lang/NumberFormatException
    //   6727	6737	7613	java/lang/NumberFormatException
    //   6737	6814	7613	java/lang/NumberFormatException
    //   6822	7003	7613	java/lang/NumberFormatException
    //   7009	7047	7613	java/lang/NumberFormatException
    //   7047	7066	7613	java/lang/NumberFormatException
    //   7075	7080	7613	java/lang/NumberFormatException
    //   7098	7129	7613	java/lang/NumberFormatException
    //   7137	7168	7613	java/lang/NumberFormatException
    //   7205	7215	7613	java/lang/NumberFormatException
    //   7224	7280	7613	java/lang/NumberFormatException
    //   7285	7324	7613	java/lang/NumberFormatException
    //   7327	7508	7613	java/lang/NumberFormatException
    //   7508	7546	7613	java/lang/NumberFormatException
    //   7546	7568	7613	java/lang/NumberFormatException
    //   7579	7610	7613	java/lang/NumberFormatException
    //   7647	7672	7613	java/lang/NumberFormatException
    //   7684	7721	7613	java/lang/NumberFormatException
    //   7726	7768	7613	java/lang/NumberFormatException
    //   7778	7827	7613	java/lang/NumberFormatException
    //   7827	7856	7613	java/lang/NumberFormatException
    //   7859	7933	7613	java/lang/NumberFormatException
    //   7933	7966	7613	java/lang/NumberFormatException
    //   7978	8053	7613	java/lang/NumberFormatException
    //   8060	8079	7613	java/lang/NumberFormatException
    //   8079	8089	7613	java/lang/NumberFormatException
    //   8091	8128	7613	java/lang/NumberFormatException
    //   8133	8184	7613	java/lang/NumberFormatException
    //   8193	8200	7613	java/lang/NumberFormatException
    //   8209	8264	7613	java/lang/NumberFormatException
    //   8266	8273	7613	java/lang/NumberFormatException
    //   8277	8366	7613	java/lang/NumberFormatException
    //   8369	8470	7613	java/lang/NumberFormatException
    //   9316	9326	9685	org/json/JSONException
    //   9598	9636	9698	java/lang/Exception
    //   8495	8555	9708	org/json/JSONException
    //   8555	8592	9708	org/json/JSONException
    //   8595	8605	9708	org/json/JSONException
    //   8615	8636	9708	org/json/JSONException
    //   8655	8669	9708	org/json/JSONException
    //   8669	8682	9708	org/json/JSONException
    //   8682	8701	9708	org/json/JSONException
    //   8729	8736	9708	org/json/JSONException
    //   8756	8769	9708	org/json/JSONException
    //   8789	8799	9708	org/json/JSONException
    //   8823	8831	9708	org/json/JSONException
    //   8851	8865	9708	org/json/JSONException
    //   8885	8895	9708	org/json/JSONException
    //   8919	8927	9708	org/json/JSONException
    //   8947	8961	9708	org/json/JSONException
    //   8981	8991	9708	org/json/JSONException
    //   9015	9023	9708	org/json/JSONException
    //   9043	9057	9708	org/json/JSONException
    //   9077	9087	9708	org/json/JSONException
    //   9107	9116	9708	org/json/JSONException
    //   9152	9316	9708	org/json/JSONException
    //   9326	9403	9708	org/json/JSONException
    //   9411	9592	9708	org/json/JSONException
    //   9598	9636	9708	org/json/JSONException
    //   9636	9655	9708	org/json/JSONException
    //   9664	9669	9708	org/json/JSONException
    //   9687	9692	9708	org/json/JSONException
    //   9700	9705	9708	org/json/JSONException
    //   9716	9726	9708	org/json/JSONException
    //   9735	9791	9708	org/json/JSONException
    //   9796	9835	9708	org/json/JSONException
    //   9838	10019	9708	org/json/JSONException
    //   10019	10057	9708	org/json/JSONException
    //   10057	10079	9708	org/json/JSONException
    //   10090	10095	9708	org/json/JSONException
    //   10098	10123	9708	org/json/JSONException
    //   10135	10172	9708	org/json/JSONException
    //   10177	10219	9708	org/json/JSONException
    //   10229	10278	9708	org/json/JSONException
    //   10278	10307	9708	org/json/JSONException
    //   10310	10384	9708	org/json/JSONException
    //   10384	10417	9708	org/json/JSONException
    //   10429	10504	9708	org/json/JSONException
    //   10511	10530	9708	org/json/JSONException
    //   10530	10540	9708	org/json/JSONException
    //   10542	10579	9708	org/json/JSONException
    //   10584	10635	9708	org/json/JSONException
    //   10644	10651	9708	org/json/JSONException
    //   10660	10715	9708	org/json/JSONException
    //   10717	10724	9708	org/json/JSONException
    //   10728	10819	9708	org/json/JSONException
    //   10822	10842	9708	org/json/JSONException
    //   10019	10057	10088	java/lang/Exception
    //   10912	10960	10963	java/lang/Exception
    //   11049	11090	11093	org/json/JSONException
    //   11101	11106	11093	org/json/JSONException
    //   11120	11195	11209	org/json/JSONException
    //   11195	11206	11209	org/json/JSONException
    //   11228	11262	11669	org/json/JSONException
    //   11262	11283	11669	org/json/JSONException
    //   11283	11330	11669	org/json/JSONException
    //   11330	11343	11669	org/json/JSONException
    //   11345	11372	11669	org/json/JSONException
    //   11374	11394	11669	org/json/JSONException
    //   11394	11407	11669	org/json/JSONException
    //   11409	11431	11669	org/json/JSONException
    //   11431	11453	11669	org/json/JSONException
    //   11456	11478	11669	org/json/JSONException
    //   11478	11633	11669	org/json/JSONException
    //   11638	11652	11669	org/json/JSONException
    //   11652	11666	11669	org/json/JSONException
    //   11678	11682	11669	org/json/JSONException
    //   11686	11690	11669	org/json/JSONException
    //   11330	11343	11677	java/lang/Exception
    //   11394	11407	11685	java/lang/Exception
    //   11728	11746	11817	java/lang/Exception
    //   11748	11756	11817	java/lang/Exception
    //   11758	11770	11817	java/lang/Exception
    //   11772	11783	11817	java/lang/Exception
    //   11785	11814	11817	java/lang/Exception
    //   11855	11867	11986	java/lang/Exception
    //   11869	11877	11986	java/lang/Exception
    //   11879	11887	11986	java/lang/Exception
    //   11889	11898	11986	java/lang/Exception
    //   11903	11912	11986	java/lang/Exception
    //   11914	11932	11986	java/lang/Exception
    //   11943	11952	11986	java/lang/Exception
    //   11954	11983	11986	java/lang/Exception
    //   12126	12164	12167	org/json/JSONException
    //   12020	12060	12175	org/json/JSONException
    //   12063	12083	12175	org/json/JSONException
    //   12083	12121	12175	org/json/JSONException
    //   12168	12172	12175	org/json/JSONException
    //   12183	12221	12175	org/json/JSONException
    //   12268	12272	12175	org/json/JSONException
    //   12226	12264	12267	org/json/JSONException
    //   12286	12331	12434	org/json/JSONException
    //   12331	12394	12434	org/json/JSONException
    //   12394	12431	12434	org/json/JSONException
    //   12547	12663	12682	org/json/JSONException
    //   12663	12679	12682	org/json/JSONException
    //   12752	12817	12820	org/json/JSONException
    //   12835	12918	12921	org/json/JSONException
    //   12940	12987	13118	org/json/JSONException
    //   13016	13115	13118	org/json/JSONException
    //   13151	13192	13194	org/json/JSONException
    //   13259	13284	13386	org/json/JSONException
    //   13289	13301	13386	org/json/JSONException
    //   13301	13311	13386	org/json/JSONException
    //   13311	13340	13386	org/json/JSONException
    //   13343	13355	13386	org/json/JSONException
    //   13355	13383	13386	org/json/JSONException
    //   13434	13464	13466	java/lang/Exception
    //   13502	13544	13546	java/lang/Exception
    //   8669	8682	13583	java/lang/Exception
    //   8682	8701	13607	java/lang/Exception
    //   8729	8736	13629	java/lang/Exception
    //   8756	8769	13629	java/lang/Exception
    //   8789	8799	13629	java/lang/Exception
    //   8823	8831	13629	java/lang/Exception
    //   8851	8865	13629	java/lang/Exception
    //   8885	8895	13629	java/lang/Exception
    //   8919	8927	13629	java/lang/Exception
    //   8947	8961	13629	java/lang/Exception
    //   8981	8991	13629	java/lang/Exception
    //   9015	9023	13629	java/lang/Exception
    //   9043	9057	13629	java/lang/Exception
    //   9077	9087	13629	java/lang/Exception
    //   9107	9116	13629	java/lang/Exception
    //   6080	6093	13654	java/lang/Exception
    //   6093	6112	13678	java/lang/Exception
    //   6140	6147	13700	java/lang/Exception
    //   6167	6180	13700	java/lang/Exception
    //   6200	6210	13700	java/lang/Exception
    //   6234	6242	13700	java/lang/Exception
    //   6262	6276	13700	java/lang/Exception
    //   6296	6306	13700	java/lang/Exception
    //   6330	6338	13700	java/lang/Exception
    //   6358	6372	13700	java/lang/Exception
    //   6392	6402	13700	java/lang/Exception
    //   6426	6434	13700	java/lang/Exception
    //   6454	6468	13700	java/lang/Exception
    //   6488	6498	13700	java/lang/Exception
    //   6518	6527	13700	java/lang/Exception
    //   4106	4171	13725	org/json/JSONException
    //   4187	4199	13725	org/json/JSONException
    //   4216	4232	13725	org/json/JSONException
    //   6066	6080	13864	java/lang/Exception
    //   8655	8669	13987	java/lang/Exception
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Zon != null) {
      this.jdField_a_of_type_Zon.f();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.n = "";
    this.o = "";
    this.p = "";
  }
  
  public void j()
  {
    Object localObject = AppConstants.SDCARD_PATH + "c2bCAM/";
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", "-1");
        ((JSONObject)localObject).put("msg", "no sdcard");
        callJs(this.o, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    this.p = UUID.randomUUID().toString();
    this.n = ((String)localObject + this.p + ".jpg");
    localObject = new Intent();
    FileProvider7Helper.setSystemCapture(this.jdField_a_of_type_AndroidAppActivity, new File(this.n), (Intent)localObject);
    try
    {
      startActivityForResult((Intent)localObject, (byte)112);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void k()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        l();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755826);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559574);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131372546)).setText(amtj.a(2131707919));
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  void l()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Zon == null) {
      this.jdField_a_of_type_Zon = zon.a();
    }
    this.jdField_a_of_type_Zon.e();
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 2512	com/tencent/mobileqq/webview/swift/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +152 -> 161
    //   12: aload_1
    //   13: ifnull +119 -> 132
    //   16: new 224	org/json/JSONObject
    //   19: dup
    //   20: invokespecial 225	org/json/JSONObject:<init>	()V
    //   23: astore 7
    //   25: aload 7
    //   27: ldc_w 314
    //   30: iconst_0
    //   31: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   34: pop
    //   35: aload 7
    //   37: ldc_w 406
    //   40: ldc_w 1448
    //   43: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_1
    //   48: ldc_w 2514
    //   51: invokevirtual 372	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 140	ufd:jdField_c_of_type_Int	I
    //   59: iconst_1
    //   60: if_icmpne +42 -> 102
    //   63: aload 7
    //   65: ldc_w 2514
    //   68: aload_1
    //   69: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: aconst_null
    //   74: ldc_w 756
    //   77: ldc_w 758
    //   80: ldc 163
    //   82: ldc_w 2516
    //   85: ldc_w 2516
    //   88: iconst_0
    //   89: iconst_0
    //   90: ldc_w 773
    //   93: ldc 163
    //   95: ldc 163
    //   97: ldc 163
    //   99: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: getfield 2447	ufd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +23 -> 132
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 2447	ufd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   117: iconst_1
    //   118: anewarray 201	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: aload 7
    //   125: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   128: aastore
    //   129: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   132: aload_0
    //   133: iconst_m1
    //   134: putfield 140	ufd:jdField_c_of_type_Int	I
    //   137: aload_0
    //   138: iconst_m1
    //   139: putfield 142	ufd:jdField_d_of_type_Int	I
    //   142: return
    //   143: astore 8
    //   145: aload 8
    //   147: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   150: goto -103 -> 47
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   158: goto -85 -> 73
    //   161: iload_2
    //   162: bipush 112
    //   164: if_icmpne +143 -> 307
    //   167: new 1173	java/io/File
    //   170: dup
    //   171: aload_0
    //   172: getfield 181	ufd:n	Ljava/lang/String;
    //   175: invokespecial 1174	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore_1
    //   179: new 224	org/json/JSONObject
    //   182: dup
    //   183: invokespecial 225	org/json/JSONObject:<init>	()V
    //   186: astore 7
    //   188: new 545	org/json/JSONArray
    //   191: dup
    //   192: invokespecial 2517	org/json/JSONArray:<init>	()V
    //   195: astore 8
    //   197: aload_1
    //   198: ifnull +36 -> 234
    //   201: aload_1
    //   202: invokevirtual 1512	java/io/File:exists	()Z
    //   205: ifeq +29 -> 234
    //   208: invokestatic 2521	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   211: new 2523	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$2
    //   214: dup
    //   215: aload_0
    //   216: aload 8
    //   218: aload 7
    //   220: invokespecial 2526	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$2:<init>	(Lufd;Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    //   223: invokevirtual 2532	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   226: pop
    //   227: return
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   233: return
    //   234: aload 7
    //   236: ldc_w 314
    //   239: iconst_1
    //   240: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload 7
    //   246: ldc_w 406
    //   249: ldc_w 2533
    //   252: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload 7
    //   258: ldc_w 1562
    //   261: ldc_w 1564
    //   264: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 183	ufd:o	Ljava/lang/String;
    //   273: iconst_1
    //   274: anewarray 201	java/lang/String
    //   277: dup
    //   278: iconst_0
    //   279: aload 7
    //   281: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   284: aastore
    //   285: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   288: aload_0
    //   289: ldc 163
    //   291: putfield 181	ufd:n	Ljava/lang/String;
    //   294: aload_0
    //   295: ldc 163
    //   297: putfield 183	ufd:o	Ljava/lang/String;
    //   300: aload_0
    //   301: ldc 163
    //   303: putfield 185	ufd:p	Ljava/lang/String;
    //   306: return
    //   307: iload_2
    //   308: bipush 111
    //   310: if_icmpne +327 -> 637
    //   313: new 224	org/json/JSONObject
    //   316: dup
    //   317: invokespecial 225	org/json/JSONObject:<init>	()V
    //   320: astore 8
    //   322: new 545	org/json/JSONArray
    //   325: dup
    //   326: invokespecial 2517	org/json/JSONArray:<init>	()V
    //   329: astore 9
    //   331: aload_1
    //   332: ifnull +93 -> 425
    //   335: aload_1
    //   336: ldc_w 2535
    //   339: invokevirtual 2539	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   342: astore 7
    //   344: iconst_0
    //   345: istore_3
    //   346: aload 7
    //   348: ifnull +11 -> 359
    //   351: aload 7
    //   353: invokevirtual 581	java/util/ArrayList:size	()I
    //   356: ifne +75 -> 431
    //   359: aload 8
    //   361: ldc_w 314
    //   364: iconst_1
    //   365: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   368: pop
    //   369: aload 8
    //   371: ldc_w 406
    //   374: ldc 163
    //   376: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   379: pop
    //   380: aload 8
    //   382: ldc_w 1562
    //   385: ldc_w 1575
    //   388: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload_0
    //   393: aload_0
    //   394: getfield 183	ufd:o	Ljava/lang/String;
    //   397: iconst_1
    //   398: anewarray 201	java/lang/String
    //   401: dup
    //   402: iconst_0
    //   403: aload 8
    //   405: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   408: aastore
    //   409: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   412: aload_0
    //   413: ldc 163
    //   415: putfield 183	ufd:o	Ljava/lang/String;
    //   418: return
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 415	org/json/JSONException:printStackTrace	()V
    //   424: return
    //   425: aconst_null
    //   426: astore 7
    //   428: goto -84 -> 344
    //   431: aload_1
    //   432: ldc_w 2541
    //   435: iconst_0
    //   436: invokevirtual 384	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   439: ifne +5 -> 444
    //   442: iconst_1
    //   443: istore_3
    //   444: iload_3
    //   445: ifeq +1302 -> 1747
    //   448: invokestatic 2521	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   451: new 2543	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$3
    //   454: dup
    //   455: aload_0
    //   456: aload 7
    //   458: aload 9
    //   460: aload 8
    //   462: invokespecial 2546	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$3:<init>	(Lufd;Ljava/util/ArrayList;Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    //   465: invokevirtual 2532	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   468: pop
    //   469: return
    //   470: iload_3
    //   471: aload 7
    //   473: invokevirtual 581	java/util/ArrayList:size	()I
    //   476: if_icmpge +60 -> 536
    //   479: invokestatic 2470	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   482: astore_1
    //   483: new 507	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 2548
    //   493: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_1
    //   497: invokevirtual 2471	java/util/UUID:toString	()Ljava/lang/String;
    //   500: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: astore_1
    //   507: aload 9
    //   509: iload_3
    //   510: aload_1
    //   511: invokevirtual 2551	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   514: pop
    //   515: getstatic 132	ufd:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   518: aload_1
    //   519: aload 7
    //   521: iload_3
    //   522: invokevirtual 582	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   525: invokevirtual 62	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   528: pop
    //   529: iload_3
    //   530: iconst_1
    //   531: iadd
    //   532: istore_3
    //   533: goto -63 -> 470
    //   536: aload 8
    //   538: ldc_w 2553
    //   541: aload 9
    //   543: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   546: pop
    //   547: aload 8
    //   549: ldc_w 314
    //   552: iconst_0
    //   553: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload 8
    //   559: ldc_w 406
    //   562: ldc_w 1448
    //   565: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   568: pop
    //   569: aload 8
    //   571: ldc_w 1562
    //   574: ldc_w 1575
    //   577: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   580: pop
    //   581: aload_0
    //   582: aload_0
    //   583: getfield 183	ufd:o	Ljava/lang/String;
    //   586: iconst_1
    //   587: anewarray 201	java/lang/String
    //   590: dup
    //   591: iconst_0
    //   592: aload 8
    //   594: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   597: aastore
    //   598: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   601: aload_0
    //   602: ldc 163
    //   604: putfield 183	ufd:o	Ljava/lang/String;
    //   607: aconst_null
    //   608: ldc_w 756
    //   611: ldc_w 758
    //   614: ldc 163
    //   616: ldc_w 1573
    //   619: ldc_w 1573
    //   622: iconst_0
    //   623: iconst_0
    //   624: ldc_w 773
    //   627: ldc 163
    //   629: ldc 163
    //   631: ldc 163
    //   633: invokestatic 765	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   636: return
    //   637: iload_2
    //   638: bipush 113
    //   640: if_icmpne +136 -> 776
    //   643: iconst_m1
    //   644: istore 4
    //   646: iload_3
    //   647: iconst_m1
    //   648: if_icmpne +6 -> 654
    //   651: iconst_0
    //   652: istore 4
    //   654: aload_1
    //   655: ifnull -513 -> 142
    //   658: aload_1
    //   659: ldc_w 2087
    //   662: invokevirtual 372	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   665: astore 7
    //   667: aload_1
    //   668: ldc_w 2091
    //   671: invokevirtual 372	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   674: astore 8
    //   676: aload_1
    //   677: ldc_w 602
    //   680: iconst_1
    //   681: invokevirtual 384	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   684: istore 5
    //   686: aload 7
    //   688: ifnull +63 -> 751
    //   691: aload 8
    //   693: ifnull +58 -> 751
    //   696: new 224	org/json/JSONObject
    //   699: dup
    //   700: invokespecial 225	org/json/JSONObject:<init>	()V
    //   703: astore_1
    //   704: aload_1
    //   705: ldc_w 1904
    //   708: aload 8
    //   710: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload_1
    //   715: ldc_w 314
    //   718: iload 4
    //   720: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   723: pop
    //   724: aload_1
    //   725: ldc_w 602
    //   728: iload 5
    //   730: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   733: pop
    //   734: aload_0
    //   735: aload 7
    //   737: iconst_1
    //   738: anewarray 201	java/lang/String
    //   741: dup
    //   742: iconst_0
    //   743: aload_1
    //   744: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   747: aastore
    //   748: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   751: getstatic 2558	uhd:a	Luhd;
    //   754: astore_1
    //   755: iload_3
    //   756: iconst_m1
    //   757: if_icmpne +13 -> 770
    //   760: iconst_1
    //   761: istore 6
    //   763: aload_1
    //   764: iload 6
    //   766: invokevirtual 2559	uhd:a	(Z)V
    //   769: return
    //   770: iconst_0
    //   771: istore 6
    //   773: goto -10 -> 763
    //   776: iload_2
    //   777: bipush 114
    //   779: if_icmpeq +21 -> 800
    //   782: iload_2
    //   783: bipush 115
    //   785: if_icmpeq +15 -> 800
    //   788: iload_2
    //   789: bipush 116
    //   791: if_icmpeq +9 -> 800
    //   794: iload_2
    //   795: bipush 122
    //   797: if_icmpne +294 -> 1091
    //   800: aload_1
    //   801: ifnull -659 -> 142
    //   804: aload_1
    //   805: ldc_w 367
    //   808: invokevirtual 372	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   811: astore 9
    //   813: aload 9
    //   815: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   818: ifne -676 -> 142
    //   821: ldc 163
    //   823: astore 8
    //   825: aload 8
    //   827: astore 7
    //   829: iload_2
    //   830: tableswitch	default:+50 -> 880, 114:+152->982, 115:+160->990, 116:+168->998, 117:+54->884, 118:+54->884, 119:+54->884, 120:+54->884, 121:+54->884, 122:+176->1006
    //   881: iconst_5
    //   882: astore 7
    //   884: iload_3
    //   885: iconst_m1
    //   886: if_icmpne +128 -> 1014
    //   889: aload_1
    //   890: ldc_w 2561
    //   893: invokevirtual 372	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   896: astore_1
    //   897: aload_1
    //   898: ifnull -756 -> 142
    //   901: new 224	org/json/JSONObject
    //   904: dup
    //   905: aload_1
    //   906: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   909: astore_1
    //   910: aload_1
    //   911: ldc_w 314
    //   914: iconst_0
    //   915: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   918: pop
    //   919: aload_1
    //   920: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   923: astore_1
    //   924: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq +38 -> 965
    //   930: ldc_w 321
    //   933: iconst_2
    //   934: new 507	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   941: aload 7
    //   943: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: ldc_w 2563
    //   949: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload_1
    //   953: invokestatic 2566	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   956: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   965: aload_0
    //   966: aload 9
    //   968: iconst_1
    //   969: anewarray 201	java/lang/String
    //   972: dup
    //   973: iconst_0
    //   974: aload_1
    //   975: aastore
    //   976: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   979: return
    //   980: astore_1
    //   981: return
    //   982: ldc_w 2174
    //   985: astore 7
    //   987: goto -103 -> 884
    //   990: ldc_w 2186
    //   993: astore 7
    //   995: goto -111 -> 884
    //   998: ldc_w 2194
    //   1001: astore 7
    //   1003: goto -119 -> 884
    //   1006: ldc_w 2568
    //   1009: astore 7
    //   1011: goto -127 -> 884
    //   1014: new 224	org/json/JSONObject
    //   1017: dup
    //   1018: invokespecial 225	org/json/JSONObject:<init>	()V
    //   1021: astore_1
    //   1022: aload_1
    //   1023: ldc_w 314
    //   1026: iconst_m1
    //   1027: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1030: pop
    //   1031: aload_1
    //   1032: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1035: astore_1
    //   1036: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1039: ifeq +35 -> 1074
    //   1042: ldc_w 321
    //   1045: iconst_2
    //   1046: new 507	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   1053: aload 7
    //   1055: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: ldc_w 2563
    //   1061: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload_1
    //   1065: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: aload_0
    //   1075: aload 9
    //   1077: iconst_1
    //   1078: anewarray 201	java/lang/String
    //   1081: dup
    //   1082: iconst_0
    //   1083: aload_1
    //   1084: aastore
    //   1085: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1088: return
    //   1089: astore_1
    //   1090: return
    //   1091: iload_2
    //   1092: bipush 118
    //   1094: if_icmpeq +9 -> 1103
    //   1097: iload_2
    //   1098: bipush 121
    //   1100: if_icmpne +440 -> 1540
    //   1103: ldc 163
    //   1105: astore 8
    //   1107: aload 8
    //   1109: astore 7
    //   1111: iload_2
    //   1112: tableswitch	default:+32 -> 1144, 118:+150->1262, 119:+36->1148, 120:+36->1148, 121:+158->1270
    //   1145: iconst_5
    //   1146: astore 7
    //   1148: aload_1
    //   1149: ifnonnull +129 -> 1278
    //   1152: iload_3
    //   1153: ifne -1011 -> 142
    //   1156: new 224	org/json/JSONObject
    //   1159: dup
    //   1160: invokespecial 225	org/json/JSONObject:<init>	()V
    //   1163: astore_1
    //   1164: aload_1
    //   1165: ldc_w 314
    //   1168: iconst_1
    //   1169: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1172: pop
    //   1173: aload_1
    //   1174: ldc_w 406
    //   1177: ldc_w 2569
    //   1180: invokestatic 987	amtj:a	(I)Ljava/lang/String;
    //   1183: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1186: pop
    //   1187: aload_1
    //   1188: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1191: astore_1
    //   1192: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1195: ifeq +33 -> 1228
    //   1198: ldc_w 321
    //   1201: iconst_2
    //   1202: new 507	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   1209: ldc_w 2571
    //   1212: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: aload_1
    //   1216: invokestatic 2566	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1219: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1228: aload_0
    //   1229: aload 7
    //   1231: iconst_1
    //   1232: anewarray 201	java/lang/String
    //   1235: dup
    //   1236: iconst_0
    //   1237: aload_1
    //   1238: aastore
    //   1239: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1242: return
    //   1243: astore_1
    //   1244: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1247: ifeq -1105 -> 142
    //   1250: ldc_w 321
    //   1253: iconst_2
    //   1254: aload_1
    //   1255: invokestatic 712	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1258: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1261: return
    //   1262: getstatic 1632	ufd:i	Ljava/lang/String;
    //   1265: astore 7
    //   1267: goto -119 -> 1148
    //   1270: getstatic 1666	ufd:j	Ljava/lang/String;
    //   1273: astore 7
    //   1275: goto -127 -> 1148
    //   1278: aload 7
    //   1280: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1283: ifne -1141 -> 142
    //   1286: iload_3
    //   1287: iconst_m1
    //   1288: if_icmpne +161 -> 1449
    //   1291: aload_1
    //   1292: ldc_w 2573
    //   1295: invokevirtual 2577	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1298: astore 8
    //   1300: aload 8
    //   1302: ifnull -1160 -> 142
    //   1305: aload 8
    //   1307: ldc_w 314
    //   1310: invokevirtual 2578	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1313: istore_3
    //   1314: aload 8
    //   1316: ldc_w 267
    //   1319: invokevirtual 1202	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1322: astore_1
    //   1323: aload 8
    //   1325: ldc_w 406
    //   1328: invokevirtual 1202	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1331: astore 8
    //   1333: new 224	org/json/JSONObject
    //   1336: dup
    //   1337: invokespecial 225	org/json/JSONObject:<init>	()V
    //   1340: astore 9
    //   1342: aload 9
    //   1344: ldc_w 314
    //   1347: iload_3
    //   1348: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1351: pop
    //   1352: aload 9
    //   1354: ldc_w 267
    //   1357: aload_1
    //   1358: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1361: pop
    //   1362: aload 9
    //   1364: ldc_w 406
    //   1367: aload 8
    //   1369: invokevirtual 408	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1372: pop
    //   1373: aload 9
    //   1375: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1378: astore_1
    //   1379: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1382: ifeq +33 -> 1415
    //   1385: ldc_w 321
    //   1388: iconst_2
    //   1389: new 507	java/lang/StringBuilder
    //   1392: dup
    //   1393: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   1396: ldc_w 2571
    //   1399: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1402: aload_1
    //   1403: invokestatic 2566	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1406: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1412: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1415: aload_0
    //   1416: aload 7
    //   1418: iconst_1
    //   1419: anewarray 201	java/lang/String
    //   1422: dup
    //   1423: iconst_0
    //   1424: aload_1
    //   1425: aastore
    //   1426: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1429: return
    //   1430: astore_1
    //   1431: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1434: ifeq -1292 -> 142
    //   1437: ldc_w 321
    //   1440: iconst_2
    //   1441: aload_1
    //   1442: invokestatic 712	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1445: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1448: return
    //   1449: new 224	org/json/JSONObject
    //   1452: dup
    //   1453: invokespecial 225	org/json/JSONObject:<init>	()V
    //   1456: astore_1
    //   1457: aload_1
    //   1458: ldc_w 314
    //   1461: iconst_m1
    //   1462: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1465: pop
    //   1466: aload_1
    //   1467: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1470: astore_1
    //   1471: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1474: ifeq +30 -> 1504
    //   1477: ldc_w 321
    //   1480: iconst_2
    //   1481: new 507	java/lang/StringBuilder
    //   1484: dup
    //   1485: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   1488: ldc_w 2580
    //   1491: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1494: aload_1
    //   1495: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1501: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1504: aload_0
    //   1505: aload_0
    //   1506: getfield 2447	ufd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1509: iconst_1
    //   1510: anewarray 201	java/lang/String
    //   1513: dup
    //   1514: iconst_0
    //   1515: aload_1
    //   1516: aastore
    //   1517: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1520: return
    //   1521: astore_1
    //   1522: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1525: ifeq -1383 -> 142
    //   1528: ldc_w 321
    //   1531: iconst_2
    //   1532: aload_1
    //   1533: invokestatic 712	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1536: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1539: return
    //   1540: iload_2
    //   1541: bipush 117
    //   1543: if_icmpne +188 -> 1731
    //   1546: aload_1
    //   1547: ifnull -1405 -> 142
    //   1550: aload_1
    //   1551: ldc_w 367
    //   1554: invokevirtual 372	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1557: astore 7
    //   1559: aload 7
    //   1561: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1564: ifne -1422 -> 142
    //   1567: iload_3
    //   1568: sipush 1699
    //   1571: if_icmpne +46 -> 1617
    //   1574: new 338	android/os/Bundle
    //   1577: dup
    //   1578: invokespecial 339	android/os/Bundle:<init>	()V
    //   1581: astore 8
    //   1583: aload 8
    //   1585: ldc_w 2582
    //   1588: aload_1
    //   1589: invokevirtual 2586	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1592: invokestatic 349	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   1595: ldc_w 351
    //   1598: ldc_w 2588
    //   1601: aload 8
    //   1603: new 2590	ufu
    //   1606: dup
    //   1607: aload_0
    //   1608: aload 7
    //   1610: invokespecial 2591	ufu:<init>	(Lufd;Ljava/lang/String;)V
    //   1613: invokevirtual 362	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   1616: return
    //   1617: aload_1
    //   1618: ldc_w 2561
    //   1621: invokevirtual 372	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1624: astore_1
    //   1625: aload_1
    //   1626: ifnull +82 -> 1708
    //   1629: new 224	org/json/JSONObject
    //   1632: dup
    //   1633: aload_1
    //   1634: invokespecial 502	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1637: astore_1
    //   1638: iload_3
    //   1639: iconst_m1
    //   1640: if_icmpne +79 -> 1719
    //   1643: aload_1
    //   1644: ldc_w 314
    //   1647: iconst_0
    //   1648: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1651: pop
    //   1652: aload_1
    //   1653: invokevirtual 319	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1656: astore_1
    //   1657: invokestatic 505	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1660: ifeq +33 -> 1693
    //   1663: ldc_w 321
    //   1666: iconst_2
    //   1667: new 507	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   1674: ldc_w 2593
    //   1677: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: aload_1
    //   1681: invokestatic 2566	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1684: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: invokevirtual 515	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1690: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1693: aload_0
    //   1694: aload 7
    //   1696: iconst_1
    //   1697: anewarray 201	java/lang/String
    //   1700: dup
    //   1701: iconst_0
    //   1702: aload_1
    //   1703: aastore
    //   1704: invokevirtual 412	ufd:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1707: return
    //   1708: new 224	org/json/JSONObject
    //   1711: dup
    //   1712: invokespecial 225	org/json/JSONObject:<init>	()V
    //   1715: astore_1
    //   1716: goto -78 -> 1638
    //   1719: aload_1
    //   1720: ldc_w 314
    //   1723: iconst_m1
    //   1724: invokevirtual 404	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1727: pop
    //   1728: goto -76 -> 1652
    //   1731: iload_2
    //   1732: bipush 119
    //   1734: if_icmpne -1592 -> 142
    //   1737: aload_0
    //   1738: aload_1
    //   1739: invokespecial 2595	ufd:a	(Landroid/content/Intent;)V
    //   1742: return
    //   1743: astore_1
    //   1744: goto -993 -> 751
    //   1747: iconst_0
    //   1748: istore_3
    //   1749: goto -1279 -> 470
    //   1752: astore_1
    //   1753: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1754	0	this	ufd
    //   0	1754	1	paramIntent	Intent
    //   0	1754	2	paramByte	byte
    //   0	1754	3	paramInt	int
    //   644	75	4	i1	int
    //   684	45	5	i2	int
    //   761	11	6	bool	boolean
    //   23	1672	7	localObject1	Object
    //   143	3	8	localJSONException	JSONException
    //   195	1407	8	localObject2	Object
    //   329	1045	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	47	143	org/json/JSONException
    //   63	73	153	org/json/JSONException
    //   201	227	228	org/json/JSONException
    //   234	306	228	org/json/JSONException
    //   351	359	419	org/json/JSONException
    //   359	418	419	org/json/JSONException
    //   431	442	419	org/json/JSONException
    //   448	469	419	org/json/JSONException
    //   470	529	419	org/json/JSONException
    //   536	636	419	org/json/JSONException
    //   901	965	980	java/lang/Exception
    //   965	979	980	java/lang/Exception
    //   1014	1074	1089	java/lang/Exception
    //   1074	1088	1089	java/lang/Exception
    //   1156	1228	1243	java/lang/Exception
    //   1228	1242	1243	java/lang/Exception
    //   1333	1415	1430	java/lang/Exception
    //   1415	1429	1430	java/lang/Exception
    //   1449	1504	1521	java/lang/Exception
    //   1504	1520	1521	java/lang/Exception
    //   704	751	1743	java/lang/Exception
    //   1629	1638	1752	java/lang/Exception
    //   1643	1652	1752	java/lang/Exception
    //   1652	1693	1752	java/lang/Exception
    //   1693	1707	1752	java/lang/Exception
    //   1708	1716	1752	java/lang/Exception
    //   1719	1728	1752	java/lang/Exception
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
      this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    }
    a();
  }
  
  public void onDestroy()
  {
    if (this.mRuntime != null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        a(localCustomWebView.getUrl());
      }
    }
    super.onDestroy();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      i();
      if (this.jdField_a_of_type_Zon != null) {
        this.jdField_a_of_type_Zon.b();
      }
      a().clear();
      if (this.jdField_a_of_type_Ufa != null) {
        this.jdField_a_of_type_Ufa.f();
      }
    }
    if (this.jdField_a_of_type_Set != null)
    {
      this.jdField_a_of_type_Set.b();
      this.jdField_a_of_type_Set = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufd
 * JD-Core Version:    0.7.0.1
 */