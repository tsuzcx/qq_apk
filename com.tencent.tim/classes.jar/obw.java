import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.s;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.a;
import com.tencent.biz.pubaccount.util.Achilles;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.10;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.21;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.5;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.6;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.BiuObserver.1;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class obw
  extends WebViewPlugin
{
  public static String apr;
  public static String aps;
  public static String apt;
  public static String apu;
  public static String apv;
  public static String apw;
  public static String apx;
  public static String apy;
  public static String apz;
  public static HashMap<String, String> eH = new HashMap();
  static Map<String, ArrayList<String>> eW;
  static Map<String, ArrayList<String>> eX;
  static HashMap<Integer, String> map = new HashMap();
  ausj G;
  mzl jdField_a_of_type_Mzl = null;
  obu jdField_a_of_type_Obu;
  AtomicBoolean ac = new AtomicBoolean(false);
  public Activity activity;
  String apA;
  public String apB = "";
  public String apC = "";
  public String apD = "";
  AppInterface app;
  boolean awk = false;
  public int bea = 1281;
  public int beb = 1282;
  int bec = -1;
  int bed = -1;
  public int bee = 1;
  public int bef = -1;
  public muw c = null;
  String callback;
  ProgressDialog e;
  ArrayList<obw.c> lZ = new ArrayList();
  skj mClient = null;
  public Handler mHandler = new obx(this);
  ArrayList<obw.b> ma = new ArrayList();
  String pUin = "";
  String uin;
  
  static
  {
    map.put(Integer.valueOf(0), "publicAccountNew.getPicture");
    map.put(Integer.valueOf(1), "troopNotice.showPicture");
    map.put(Integer.valueOf(2), "qbizApi.getNetworkType");
    map.put(Integer.valueOf(3), "ui.closeWebViews");
    map.put(Integer.valueOf(4), "ui.setOnShareQQFriendHandler");
    map.put(Integer.valueOf(5), "ui.setOnShareQZoneHandler");
    map.put(Integer.valueOf(6), "ui.setOnShareWXFriendHandler");
    map.put(Integer.valueOf(7), "ui.setOnShareWXTimelineHandler");
    map.put(Integer.valueOf(8), "publicAccount.getLocation");
    map.put(Integer.valueOf(10), "publicAccountNew.hideMenuItems");
    map.put(Integer.valueOf(11), "publicAccountNew.showMenuItems");
    map.put(Integer.valueOf(12), "publicAccountNew.hideAllNonBaseMenuItem");
    map.put(Integer.valueOf(13), "publicAccountNew.showAllNonBaseMenuItem");
    map.put(Integer.valueOf(14), "publicAccountNew.showWebPanel");
    map.put(Integer.valueOf(15), "publicAccountNew.scanQRCode");
    map.put(Integer.valueOf(16), "publicAccountNew.setRightButtonState");
    map.put(Integer.valueOf(17), "publicAccountNew.uploadImage");
    map.put(Integer.valueOf(18), "publicAccountNew.downloadImage");
    map.put(Integer.valueOf(20), "publicAccountNew.hideWebToolbar");
    map.put(Integer.valueOf(21), "publicAccountNew.showWebToolbar");
    map.put(Integer.valueOf(30), "wallet.publicPay");
    map.put(Integer.valueOf(40), "publicAccountNew.startRecord");
    map.put(Integer.valueOf(41), "publicAccountNew.stopRecord");
    map.put(Integer.valueOf(42), "publicAccountNew.playVoice");
    map.put(Integer.valueOf(43), "publicAccountNew.pauseVoice");
    map.put(Integer.valueOf(44), "publicAccountNew.stopVoice");
    map.put(Integer.valueOf(45), "publicAccountNew.uploadVoice");
    map.put(Integer.valueOf(46), "publicAccountNew.downloadVoice");
    map.put(Integer.valueOf(47), "publicAccountNew.onVoiceRecordEnd");
    map.put(Integer.valueOf(48), "publicAccountNew.onVoicePlayEnd");
    map.put(Integer.valueOf(49), "publicAccountNew.selectAndUploadAvatar");
    map.put(Integer.valueOf(50), "publicAccountNew.addPreDownloadVideo");
    map.put(Integer.valueOf(51), "publicAccountNew.stopPreDownloadVideo");
    eW = new HashMap();
    eX = new HashMap();
  }
  
  public obw()
  {
    this.mPluginNameSpace = "publicAccountNew";
  }
  
  public static boolean K(String paramString1, String paramString2)
  {
    if (!eW.containsKey(paramString1)) {}
    do
    {
      do
      {
        return false;
        paramString1 = (ArrayList)eW.get(paramString1);
        if (!"QQApi.shareMsg".equals(paramString2)) {
          break;
        }
      } while ((!a(paramString1, "ui.setOnShareQQFriendHandler")) && (!a(paramString1, "ui.ui.setOnShareQZoneHandler")) && (!a(paramString1, "ui.ui.setOnShareWXFriendHandler")) && (!a(paramString1, "ui.setOnShareWXTimelineHandler")));
      return true;
    } while (!a(paramString1, paramString2));
    if ("qbizApi.getNetworkType".equals(paramString2)) {
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005868", "0X8005868", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if ("publicAccount.getLocation".equals(paramString2)) {
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586A", "0X800586A", 0, 0, "", "", "", "");
      } else if ("ui.closeWebViews".equals(paramString2)) {
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586D", "0X800586D", 0, 0, "", "", "", "");
      } else if ("troopNotice.showPicture".equals(paramString2)) {
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005896", "0X8005896", 0, 0, "1", "", "", "");
      }
    }
  }
  
  public static WebResourceResponse a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = (String)eH.get(paramString);
        if (paramString == null) {
          return null;
        }
        paramString = jqs.a(SafeBitmapFactory.decodeFile(paramString));
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
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (kxm.nT() >= 2) {
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
    kqi.a(this, this.mRuntime.getActivity(), paramString4, (byte)116);
    kxm.bA("2", "2");
  }
  
  public static void a(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str1 = paramJSONObject.optString("uniqueKey");
        int i = paramJSONObject.optInt("source", 3);
        Object localObject2 = paramJSONObject.optString("feedsID", "");
        int j = paramJSONObject.optInt("feedsType", -1);
        int k = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        String str4 = paramJSONObject.optString("sourceName", "");
        String str5 = paramJSONObject.optString("picUrl", "");
        long l = paramJSONObject.optLong("duration", -1L);
        String str6 = paramJSONObject.optString("articleID", "");
        Object localObject1 = paramJSONObject.optString("commentID");
        String str2 = paramJSONObject.optString("subCommentID");
        bool1 = paramJSONObject.optBoolean("isAwesome");
        int m = paramJSONObject.optInt("jumpType");
        int n = paramJSONObject.optInt("showType", 0);
        boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
        QLog.d("PublicAccountH5AbilityPlugin", 1, "startShowComment  uniqueKey = " + str1 + "source = " + i + "feedsId = " + (String)localObject2 + " feedsType=" + j + "adTag = " + k + "title = " + str3 + "sourceName = " + str4 + "picUrl =" + str5 + "duration = " + l + "articleId =" + str6);
        paramJSONObject = new Bundle();
        paramJSONObject.putSerializable("commonCommentData", new CommonCommentData(str6, j, (String)localObject2, k, str3, str4, str5, l));
        paramJSONObject.putInt("source", i);
        paramJSONObject.putString("commentId", (String)localObject1);
        paramJSONObject.putString("subCommentId", str2);
        paramJSONObject.putBoolean("isAwesome", bool1);
        paramJSONObject.putInt("jumpType", m);
        paramJSONObject.putInt("seq", paramInt);
        paramJSONObject.putBoolean("canBiu", bool2);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).acb = ((String)localObject1);
        ((AnchorData)localObject2).acd = str2;
        ((AnchorData)localObject2).ahJ = bool1;
        QLog.d("PublicAccountH5AbilityPlugin", 1, "anchorData commentId:" + (String)localObject1 + " ,subCommentId :" + str2);
        localObject1 = BaseActivity.sTopActivity;
        if (n == 1)
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
  
  public static void a(JSONObject paramJSONObject, String paramString, BridgeModule.a parama)
  {
    skj localskj = skj.a();
    localskj.bzj();
    a(paramJSONObject, localskj.a(new oco(parama, paramString)));
  }
  
  public static boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i)).equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void aV(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.activity == null)) {}
    String str2;
    do
    {
      return;
      str2 = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str2));
    int i = paramIntent.getIntExtra("result_code", -1);
    if (i == 0) {
      this.mHandler.postDelayed(new PublicAccountH5AbilityPlugin.10(this), 200L);
    }
    String str1 = "";
    if (paramIntent.hasExtra("result_msg")) {
      str1 = paramIntent.getStringExtra("result_msg");
    }
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("retCode", i);
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
  
  private void e(String paramString, String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (this.activity != null)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountH5AbilityPlugin", 2, "selectAndInviteFriend param json:" + ((JSONObject)localObject1).toString());
        }
        paramString = ((JSONObject)localObject1).optString("rowkey", "");
        int j = ((JSONObject)localObject1).optInt("maxSelect");
        int k = ((JSONObject)localObject1).optInt("maxCount");
        paramVarArgs = ((JSONObject)localObject1).optString("callback", "");
        Object localObject2 = ((JSONObject)localObject1).optString("invitedUins", "[]");
        localObject1 = new StringBuilder();
        if ((localObject2 != null) && (((String)localObject2).trim().length() > 0))
        {
          localObject2 = new JSONArray(((String)localObject2).trim());
          if (i < ((JSONArray)localObject2).length())
          {
            ((StringBuilder)localObject1).append(((JSONArray)localObject2).get(i));
            if (i >= ((JSONArray)localObject2).length() - 1) {
              break label339;
            }
            ((StringBuilder)localObject1).append(",");
            break label339;
          }
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("opentype", 1);
        ((Intent)localObject2).putExtra("filterUins", ((StringBuilder)localObject1).toString());
        ((Intent)localObject2).putExtra("maxSelect", j);
        if (k > 0) {
          ((Intent)localObject2).putExtra("maxCount", k);
        }
        ((Intent)localObject2).putExtra("rowkey", paramString);
        ((Intent)localObject2).putExtra("callback", paramVarArgs);
        PublicFragmentActivity.startForResult(this.activity, (Intent)localObject2, ReadInJoySelectMemberAQFragment.class, 119);
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
      i += 1;
    }
  }
  
  public static void e(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i)).equals(paramString))
        {
          paramArrayList.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public static boolean ev(String paramString)
  {
    return eW.containsKey(paramString);
  }
  
  public static int[] f(int paramInt)
  {
    int[] arrayOfInt = new int[32];
    int i = 0;
    while (i < 32)
    {
      arrayOfInt[(31 - i)] = (paramInt >> i & 0x1);
      i += 1;
    }
    return arrayOfInt;
  }
  
  private void pg(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optJSONArray("imageIDs");
        int k = ((JSONObject)localObject2).optInt("index");
        String str1 = ((JSONObject)localObject2).optString("srcID");
        boolean bool1 = ((JSONObject)localObject2).optBoolean("isNotShowIndex", true);
        boolean bool2 = ((JSONObject)localObject2).optBoolean("showTitle", false);
        String str2 = new String(aqgo.decode(((JSONObject)localObject2).optString("title", ""), 0));
        String str3 = ((JSONObject)localObject2).optString("articleUrl", "");
        boolean bool3 = ((JSONObject)localObject2).optBoolean("isReport", false);
        long l1 = ((JSONObject)localObject2).optLong("touin");
        long l2 = ((JSONObject)localObject2).optLong("feeds_id");
        int m = ((JSONObject)localObject2).optInt("feeds_type");
        long l3 = ((JSONObject)localObject2).optLong("articleId");
        int n = ((JSONObject)localObject2).optInt("source");
        int i = 0;
        if (localObject1 != null) {
          i = ((JSONArray)localObject1).length();
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
          int j = 0;
          if (j < ((JSONArray)localObject1).length())
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject1).get(j).toString());
            j += 1;
            continue;
          }
          if (this.activity == null) {
            break;
          }
          localObject1 = new Intent(this.activity, TroopAvatarWallPreviewActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("index", k);
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
          localBundle.putString("scroll_image_r5", kxm.a(i, -1, Integer.toString(n), m, "", "", null));
          localBundle.putString("read_article_r5", kxm.a(i, -1, Integer.toString(n), m, "", null));
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
          this.activity.startActivityForResult((Intent)localObject1, 100);
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
  
  private void pj(String paramString)
  {
    Bundle localBundle = new Bundle();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    localObject = ((CookieManager)localObject).getCookie(paramString);
    if (localObject != null) {
      localBundle.putString("Cookie", (String)localObject);
    }
    if (!aqiw.isNetworkAvailable(this.mRuntime.getActivity()))
    {
      rwt.ez(1, 2131694663);
      return;
    }
    localObject = new arhz(this.mRuntime.getActivity());
    ((arhz)localObject).setMessage(2131695695);
    ((arhz)localObject).show();
    ThreadManager.executeOnSubThread(new PublicAccountH5AbilityPlugin.21(this, paramString, localBundle, (arhz)localObject));
  }
  
  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Intent localIntent = new Intent(this.activity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarFragment.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("key_from_kandian_uploadimg", true);
    String str = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "readinjoy_avatar_upload/");
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt3);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt4);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt5);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt6);
    localIntent.putExtra("from", paramInt1);
    localIntent.putExtra("type", paramInt2);
    if (this.mRuntime.b() != null)
    {
      paramInt1 = this.mRuntime.b().switchRequestCode(this, paramByte);
      localIntent.putExtra("keyAction", "actionSelectPicture");
      localIntent.putExtra("requestCode", paramInt1);
    }
    startActivityForResult(localIntent, paramByte);
    aqfy.anim(this.activity, false, true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.G == null) {
      this.G = ((ausj)auss.a(this.activity, null));
    }
    Object localObject = LayoutInflater.from(this.activity).inflate(2131561540, null);
    this.G.setActionContentView((View)localObject, null);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131367243);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131367241);
    localObject = (TextView)((View)localObject).findViewById(2131367323);
    if (paramInt1 == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      if (!this.G.isShowing()) {
        this.G.show();
      }
      localTextView1.setOnClickListener(new ocb(this, paramString));
      localTextView2.setOnClickListener(new occ(this, paramInt3, paramInt2, paramString));
      ((TextView)localObject).setOnClickListener(new ocd(this));
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
    String str3 = this.pUin;
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
      if ((this.mClient != null) && (!"".equals(paramString1))) {
        this.mClient.b(paramString1, paramInt, str1, paramBoolean, new ocg(this, paramBoolean, paramString3, paramString2), new och(this));
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
    Object localObject2 = this.pUin;
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
      if ((this.mClient != null) && (!"".equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PAH5Manager", 2, "HttpUtil.getNetWorkType()" + jqc.getNetWorkType());
        }
        if (jqc.getNetWorkType() != 1)
        {
          localObject2 = new File(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "size" + ((File)localObject2).length());
          }
          if (((File)localObject2).length() > 204800L) {
            QQToast.a(this.activity, "你已离开wifi环境", 0).show();
          }
        }
        this.mClient.a(paramString1, paramInt, (String)localObject1, paramBoolean, new oce(this, paramString2, paramBoolean), new ocf(this));
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
  
  void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.activity, kbs.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("3.4.4,3,0");
    localJSApiWebServerRequest.cmd.set(this.bea);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("puin", this.pUin);
        if (!paramBoolean) {
          continue;
        }
        localJSONObject.put("url", paramString1);
        localJSONObject.put("type", "2");
      }
      catch (JSONException paramString1)
      {
        obu localobu;
        paramString1.printStackTrace();
        continue;
      }
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new oby(this, paramBoolean, paramString2));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.app.startServlet(localNewIntent);
      return;
      localJSONObject.put("type", "4");
      if (this.jdField_a_of_type_Obu == null) {
        this.jdField_a_of_type_Obu = new obu(this.activity, this.uin, this.mRuntime);
      }
      this.jdField_a_of_type_Obu.bdq();
      localJSONObject.put("file_uuid", paramString1);
      localobu = this.jdField_a_of_type_Obu;
      localJSONObject.put("file_md5", obu.lf());
      localobu = this.jdField_a_of_type_Obu;
      localJSONObject.put("file_name", obu.lg());
      localobu = this.jdField_a_of_type_Obu;
      localJSONObject.put("file_size", obu.rf());
      localobu = this.jdField_a_of_type_Obu;
      localJSONObject.put("file_time", obu.rg());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("sendUuidForMediaIdRequest file_uuid = ").append(paramString1).append(" file_md5=");
        localobu = this.jdField_a_of_type_Obu;
        paramString1 = paramString1.append(obu.lf()).append(" file_name:");
        localobu = this.jdField_a_of_type_Obu;
        paramString1 = paramString1.append(obu.lg()).append(" file_size=");
        localobu = this.jdField_a_of_type_Obu;
        paramString1 = paramString1.append(obu.rf()).append(" file_time=");
        localobu = this.jdField_a_of_type_Obu;
        QLog.i("PublicAccountH5AbilityPlugin", 2, obu.rg());
      }
    }
  }
  
  void aR(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("pic_local_path");
    if (paramBundle != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = eH.entrySet().iterator();
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
        localObject3 = this.lZ.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          obw.c localc = (obw.c)((Iterator)localObject3).next();
          if (((String)localObject2).equals(localc.localId)) {
            paramBundle.add(localc);
          }
        }
      }
      this.lZ.removeAll(paramBundle);
      if (this.lZ.size() > 0)
      {
        paramBundle = (obw.c)this.lZ.get(0);
        localObject1 = (String)eH.get(paramBundle.localId);
        a(paramBundle.bek, (String)localObject1, true, paramBundle.callback);
      }
    }
  }
  
  void b(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.activity, kbs.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("3.4.4,3,0");
    localJSApiWebServerRequest.cmd.set(this.beb);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.pUin);
      localJSONObject.put("mediaid", paramString1);
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new obz(this, paramString2, paramInt, paramBoolean, paramString1));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.app.startServlet(localNewIntent);
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
  
  void bT(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.activity, kbs.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("3.4.4,3,0");
    localJSApiWebServerRequest.cmd.set(1);
    localJSApiWebServerRequest.body.set(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountH5AbilityPlugin", 2, "鉴权body为:  " + paramString2);
    }
    localNewIntent.setObserver(new oca(this, paramString1));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.app.startServlet(localNewIntent);
  }
  
  public void bY(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!a(bh(), str)) {
        bh().add(str);
      }
    }
  }
  
  public void bZ(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      e(bh(), str);
    }
  }
  
  public void bdA()
  {
    if (this.mClient == null) {
      this.mClient = skj.a();
    }
    this.mClient.bzn();
  }
  
  public void bds()
  {
    if (this.activity == null) {
      return;
    }
    Intent localIntent = new Intent(this.activity, PoiMapActivity.class).putExtra("uin", this.uin);
    this.activity.startActivity(localIntent);
    this.mClient.bzl();
  }
  
  public void bdt()
  {
    if (this.mRuntime.b() != null) {
      this.mRuntime.b().Qq();
    }
  }
  
  public void bdu()
  {
    bh().clear();
    bh().add("menuItem:share:qq");
    bh().add("menuItem:share:QZone");
    bh().add("menuItem:share:appMessage");
    bh().add("menuItem:share:timeline");
    bh().add("menuItem:openWithQQBrowser");
    bh().add("menuItem:openWithSafari");
    bh().add("menuItem:favorite");
    bh().add("menuItem:copyUrl");
    bh().add("menuItem:exportTencentDocs");
  }
  
  public void bdv()
  {
    bh().clear();
  }
  
  public void bdw()
  {
    if (this.mRuntime.b() != null) {
      this.mRuntime.b().ff(false);
    }
  }
  
  public void bdx()
  {
    if (this.mRuntime.b() != null) {
      this.mRuntime.b().ff(true);
    }
  }
  
  public void bdy()
  {
    if (this.mClient != null) {
      this.mClient.bdy();
    }
    this.lZ.clear();
    this.ma.clear();
    this.apB = "";
    this.apC = "";
    this.apD = "";
  }
  
  public void bdz()
  {
    Object localObject = acbn.SDCARD_PATH + "c2bCAM/";
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", "-1");
        ((JSONObject)localObject).put("msg", "no sdcard");
        callJs(this.apC, new String[] { ((JSONObject)localObject).toString() });
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
    this.apD = UUID.randomUUID().toString();
    this.apB = ((String)localObject + this.apD + ".jpg");
    localObject = new Intent();
    FileProvider7Helper.setSystemCapture(this.activity, new File(this.apB), (Intent)localObject);
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
  
  public ArrayList<String> bh()
  {
    arbt localarbt = (arbt)super.getBrowserComponent(4);
    if (localarbt != null) {
      return localarbt.qo;
    }
    return null;
  }
  
  void cancleProgressDailog()
  {
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.cancel();
    }
  }
  
  public void dx(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.activity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt1);
    if (paramInt2 == 1)
    {
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 2);
      if (paramInt2 != 0) {
        break label154;
      }
      localIntent.putExtra("PhotoConst.original_button", true);
      localIntent.putExtra("PhotoConst.quality_count_tv", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.activity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      if (this.mRuntime.b() != null) {
        this.mRuntime.b().a(this, localIntent, (byte)111);
      }
      return;
      if (paramInt2 != 2) {
        break;
      }
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label154:
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.putExtra("PhotoConst.quality_count_tv", false);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934600L)
    {
      if (paramMap != null)
      {
        int i = ((Integer)paramMap.get("requestCode")).intValue();
        if ((i == 1) || (i == 113) || (i == 114) || (i == 115) || (i == 116) || (i == 117) || (i == 118) || (i == 119) || (i == 122))
        {
          int j = ((Integer)paramMap.get("resultCode")).intValue();
          onActivityResult((Intent)paramMap.get("data"), (byte)i, j);
          return true;
        }
      }
    }
    else if (paramLong == 8589934597L) {
      onPause();
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i;
    label1616:
    int k;
    label1849:
    label2495:
    int m;
    label2050:
    int j;
    label2594:
    label3236:
    label3692:
    int n;
    boolean bool2;
    if ("publicAccountNew".endsWith(paramString2))
    {
      if ("openLocation".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          bds();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005869", "0X8005869", 0, 0, "", "", "", "");
        return true;
      }
      if ("showOfficialAccountProfile".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin");
          if (!"".equals(paramJsBridgeListener)) {
            ph(paramJsBridgeListener);
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("showWebPanel".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          bdt();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("setRightButtonState".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          bool1 = paramJsBridgeListener.optBoolean("hidden");
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          qw(bool1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("hideMenuItems".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optJSONArray("menuList");
          paramString1 = new ArrayList();
          if (paramString2 != null)
          {
            i = 0;
            while (i < paramString2.length())
            {
              paramString1.add(paramString2.optString(i));
              i += 1;
            }
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2 = new JSONObject();
            paramString2.put("retCode", 0);
            paramString2.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          bY(paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586E", "0X800586E", 0, 0, "", "", "", "");
        return true;
      }
      if ("showMenuItems".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optJSONArray("menuList");
          paramString1 = new ArrayList();
          if (paramString2 != null)
          {
            i = 0;
            while (i < paramString2.length())
            {
              paramString1.add(paramString2.optString(i));
              i += 1;
            }
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2 = new JSONObject();
            paramString2.put("retCode", 0);
            paramString2.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          bZ(paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586F", "0X800586F", 0, 0, "", "", "", "");
        return true;
      }
      if ("hideAllNonBaseMenuItem".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          bdu();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005870", "0X8005870", 0, 0, "", "", "", "");
        return true;
      }
      if ("showAllNonBaseMenuItem".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          bdv();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005871", "0X8005871", 0, 0, "", "", "", "");
        return true;
      }
      if ("showWebToolbar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          bdx();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005898", "0X8005898", 0, 0, "", "", "", "");
        return true;
      }
      if ("hideWebToolbar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          bdw();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005897", "0X8005897", 0, 0, "", "", "", "");
        return true;
      }
      if ("uploadImage".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          paramString1 = paramString2.optString("localId");
          i = paramString2.optInt("isShowProgressTips", 1);
          paramString2 = (String)eH.get(paramString1);
          paramString3 = new File(paramString2);
          if ((paramString3 == null) || (!paramString3.exists()))
          {
            QQToast.a(this.activity, "", 0).show();
            return true;
          }
          if (paramString3.length() > 2097152L)
          {
            QQToast.a(this.activity, "请选择小于2M文件" + paramString2, 0).show();
            return true;
          }
          paramString3 = this.lZ.iterator();
          while (paramString3.hasNext())
          {
            paramVarArgs = (obw.c)paramString3.next();
            if ((paramString1 != null) && (paramString1.equals(paramVarArgs.localId))) {
              return true;
            }
          }
          paramString3 = new obw.c();
          paramString3.callback = paramJsBridgeListener;
          paramString3.localId = paramString1;
          paramString3.bek = i;
          this.lZ.add(paramString3);
          if (this.lZ.size() != 1) {
            break label1616;
          }
          a(i, paramString2, true, paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, 2, "1", "", "", "", false);
        return true;
        return true;
      }
      if ("downloadImage".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          paramString1 = paramString2.optString("serverId");
          i = paramString2.optInt("isShowProgressTips", 1);
          if (("".equals(paramJsBridgeListener)) || ("".equals(paramString1)))
          {
            QQToast.a(this.activity, "callback or mediaId is null", 0).show();
            return true;
          }
          paramString2 = this.ma.iterator();
          while (paramString2.hasNext())
          {
            paramString3 = (obw.b)paramString2.next();
            if ((paramString1 != null) && (paramString1.equals(paramString3.apI))) {
              return true;
            }
          }
          paramString2 = new obw.b();
          paramString2.callback = paramJsBridgeListener;
          paramString2.apI = paramString1;
          paramString2.bek = i;
          this.ma.add(paramString2);
          if (this.ma.size() != 1) {
            break label1849;
          }
          b(paramString1, i, true, paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, 2, "1", "", "", "");
        return true;
        return true;
      }
      if ("uploadVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13327;
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = paramString1.optString("localId");
            i = paramString1.optInt("isShowProgressTips", 1);
            bool1 = TextUtils.isEmpty(paramString2);
            if (bool1) {
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", -1);
                paramString1.put("msg", "file not exists");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                continue;
              }
            }
            if (this.jdField_a_of_type_Obu != null) {
              break label2050;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          this.jdField_a_of_type_Obu = new obu(this.activity, this.uin, this.mRuntime);
          paramString1 = this.jdField_a_of_type_Obu.fo(paramString2);
          paramString2 = new File(paramString1);
          if (!paramString2.exists())
          {
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("retCode", -1);
              paramString1.put("msg", "file not exists");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if (paramString2.length() > 5242880L)
          {
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("retCode", -1);
              paramString1.put("msg", "请上传5MB以内的音频");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
          else
          {
            a(i, paramString1, false, paramJsBridgeListener);
          }
        }
      }
      if ("downloadVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13329;
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = paramString1.optString("serverId");
            i = paramString1.optInt("isShowProgressTips", 1);
            bool1 = TextUtils.isEmpty(paramString2);
            if (bool1) {
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", -1);
                paramString1.put("msg", "invalid serverId");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                continue;
              }
            }
            b(paramString2, i, false, paramJsBridgeListener);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("getPicture".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13338;
        }
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          k = paramString2.optInt("count");
          if (k > 9) {
            break label13331;
          }
          if (k >= 1) {
            break label13324;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          break label13338;
        }
        paramString1 = paramString2.optJSONArray("sizeType");
        paramString2 = paramString2.optJSONArray("sourceType");
        if ((paramString2 == null) || (paramString2.length() != 1)) {
          break label13318;
        }
        paramString2 = paramString2.optString(0);
        if ("camera".equalsIgnoreCase(paramString2))
        {
          i = 1;
          m = 0;
          j = m;
          if (paramString1 != null)
          {
            j = m;
            if (paramString1.length() == 1)
            {
              paramString1 = paramString1.optString(0);
              if (!"original".equalsIgnoreCase(paramString1)) {
                break label2594;
              }
              j = 1;
            }
          }
        }
        for (;;)
        {
          a(i, j, paramJsBridgeListener, k);
          anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 2, "1", "", "", "");
          break label13338;
          if (!"album".equalsIgnoreCase(paramString2)) {
            break label13318;
          }
          i = 2;
          break;
          bool1 = "compressed".equalsIgnoreCase(paramString1);
          j = m;
          if (bool1) {
            j = 2;
          }
        }
      }
      if ("startRecord".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          apr = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(apr))
          {
            if (this.jdField_a_of_type_Obu == null) {
              this.jdField_a_of_type_Obu = new obu(this.activity, this.uin, this.mRuntime);
            }
            this.jdField_a_of_type_Obu.startRecord();
          }
          anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 2, "1", "", "", "");
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("stopRecord".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        for (;;)
        {
          try
          {
            aps = new JSONObject(paramVarArgs[0]).optString("callback");
            if ((this.jdField_a_of_type_Obu == null) || (!this.jdField_a_of_type_Obu.qh())) {
              continue;
            }
            this.jdField_a_of_type_Obu.stopRecord();
            anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 2, "1", "", "", "");
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            continue;
          }
          return true;
          try
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("retCode", -1);
            paramJsBridgeListener.put("msg", "fail");
            callJs(aps, new String[] { paramJsBridgeListener.toString() });
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("playVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13340;
        }
        for (;;)
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            apt = paramJsBridgeListener.optString("callback");
            paramJsBridgeListener = paramJsBridgeListener.optString("localId");
            if (!TextUtils.isEmpty(apt))
            {
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                break label3236;
              }
              if ((this.jdField_a_of_type_Obu != null) && (this.jdField_a_of_type_Obu.isPlaying())) {
                return true;
              }
              if (this.jdField_a_of_type_Obu == null) {
                this.jdField_a_of_type_Obu = new obu(this.activity, this.uin, this.mRuntime);
              }
              paramString1 = this.jdField_a_of_type_Obu.fo(paramJsBridgeListener);
              paramJsBridgeListener = new JSONObject();
              if (new File(paramString1).exists()) {
                this.jdField_a_of_type_Obu.pc(paramString1);
              }
            }
            else
            {
              try
              {
                paramJsBridgeListener.put("retCode", 0);
                paramJsBridgeListener.put("msg", "success");
                anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, 0, "1", "", "", "");
                callJs(apt, new String[] { paramJsBridgeListener.toString() });
                anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramString1)
              {
                paramString1.printStackTrace();
                continue;
              }
            }
            try
            {
              paramJsBridgeListener.put("retCode", -1);
              paramJsBridgeListener.put("msg", "file not exists");
              anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, -1, "1", "", "", "");
            }
            catch (JSONException paramString1)
            {
              for (;;)
              {
                paramString1.printStackTrace();
              }
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          paramJsBridgeListener = new JSONObject();
          try
          {
            paramJsBridgeListener.put("retCode", -1);
            paramJsBridgeListener.put("msg", "missing arguments");
            callJs(apt, new String[] { paramJsBridgeListener.toString() });
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("pauseVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13342;
        }
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString1 = paramString1.optString("localId");
          if (!TextUtils.isEmpty(paramString1))
          {
            if (this.jdField_a_of_type_Obu == null) {
              this.jdField_a_of_type_Obu = new obu(this.activity, this.uin, this.mRuntime);
            }
            this.jdField_a_of_type_Obu.fo(paramString1);
            if (this.jdField_a_of_type_Obu.isPlaying())
            {
              this.jdField_a_of_type_Obu.bdp();
              paramString1 = new JSONObject();
            }
          }
          try
          {
            paramString1.put("retCode", 0);
            paramString1.put("msg", "success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2D", "0X8005D2D", 0, 0, "1", "", "", "");
            anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2D", "0X8005D2D", 0, 2, "1", "", "", "");
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          if (!"stopVoice".endsWith(paramString3)) {
            break label3692;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          apu = paramJsBridgeListener.optString("callback");
          paramJsBridgeListener = paramJsBridgeListener.optString("localId");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            if (this.jdField_a_of_type_Obu == null) {
              this.jdField_a_of_type_Obu = new obu(this.activity, this.uin, this.mRuntime);
            }
            this.jdField_a_of_type_Obu.fo(paramJsBridgeListener);
            this.jdField_a_of_type_Obu.aRx();
            anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2E", "0X8005D2E", 0, 0, "1", "", "", "");
          }
          anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2E", "0X8005D2E", 0, 2, "1", "", "", "");
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("onVoiceRecordEnd".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          apv = new JSONObject(paramVarArgs[0]).optString("callback");
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("onVoicePlayEnd".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          apw = new JSONObject(paramVarArgs[0]).optString("callback");
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("selectAndUploadAvatar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          apx = paramJsBridgeListener.optString("callback");
          n = paramJsBridgeListener.optInt("type", 1);
          i = 640;
          j = 640;
          k = 640;
          m = 640;
          if (paramJsBridgeListener.has("width"))
          {
            j = paramJsBridgeListener.optInt("width");
            i = aqcx.dip2px(this.activity, j / 2);
          }
          if (paramJsBridgeListener.has("height"))
          {
            m = paramJsBridgeListener.optInt("height");
            k = aqcx.dip2px(this.activity, m / 2);
          }
          a(1, n, (byte)118, i, k, j, m);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PublicAccountH5AbilityPlugin", 2, "selectAndUploadAvatar  json parse error");
            }
          }
        }
        return true;
      }
      if ("uploadTopicPic".endsWith(paramString3))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramVarArgs != null)
        {
          bool1 = bool2;
          if (paramVarArgs.length <= 0) {}
        }
      }
    }
    try
    {
      paramJsBridgeListener = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      paramString1 = new JSONObject(paramVarArgs[0]);
      apy = paramString1.optString("callback");
      n = paramString1.optInt("type");
      i = Utils.rp2px(paramJsBridgeListener.widthPixels, 360.0D);
      j = Utils.rp2px(paramJsBridgeListener.widthPixels, 200.0D);
      k = 750;
      m = 416;
      if (n != 1) {
        break label13344;
      }
      j = Utils.rp2px(paramJsBridgeListener.widthPixels, 360.0D);
      m = 160;
      k = 160;
      i = j;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        label4118:
        bool1 = bool2;
        continue;
        j = 0;
        continue;
        i = -1;
        continue;
        paramJsBridgeListener = "";
        continue;
        paramString1 = "";
        continue;
        bool2 = true;
        continue;
        bool1 = false;
        continue;
        paramJsBridgeListener = paramVarArgs;
        continue;
        paramString1 = str1;
        continue;
        paramJsBridgeListener = paramVarArgs;
        continue;
        paramString1 = str1;
        continue;
        paramJsBridgeListener = null;
      }
    }
    a(2, 0, (byte)121, i, j, k, m);
    boolean bool1 = true;
    label4137:
    QLog.d("PublicAccountH5AbilityPlugin", 1, "uploadTopicPic  args:" + paramVarArgs + " isExecuted:" + bool1);
    return true;
    if ("config".endsWith(paramString3))
    {
      if (this.awk) {
        return true;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          apz = paramString1.optString("appId");
          paramString1.put("appver", "3.4.4");
          paramJsBridgeListener = this.mRuntime.getWebView();
          if (paramJsBridgeListener == null) {
            break label13307;
          }
          paramJsBridgeListener = paramJsBridgeListener.getUrl();
          paramString1.put("url", paramJsBridgeListener);
          paramString2 = paramString1.toString();
          this.apA = paramString1.optString("callback");
          paramString1 = paramString1.optJSONArray("jsApiList");
          paramString3 = new ArrayList();
          if (paramString1 != null)
          {
            paramString3.clear();
            i = 0;
            while (i < paramString1.length())
            {
              paramString3.add(paramString1.optString(i));
              i += 1;
            }
          }
          eW.remove(paramJsBridgeListener);
          eX.put(paramJsBridgeListener, paramString3);
          if (paramJsBridgeListener != null) {
            bT(paramJsBridgeListener, paramString2);
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
    }
    label4382:
    label5028:
    do
    {
      for (;;)
      {
        return false;
        if (!"isEnabledRightButton".endsWith(paramString3)) {
          break;
        }
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          i = paramString1.optInt("status");
          if ((this.mRuntime.b() != null) && (this.mRuntime.b().a != null) && (this.mRuntime.b().a.a != null)) {
            this.mRuntime.b().a.a.setRightViewTextDisable(i);
          }
          paramString1 = new JSONObject();
          paramString1.put("retCode", 0);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      if ("reportpreloaddata".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optString("url");
          if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (!TextUtils.isEmpty(paramString2)))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            bool2 = false;
            paramString2 = PreloadManager.fk(paramString2);
            bool1 = bool2;
            if (paramString2 != null)
            {
              bool1 = bool2;
              if (new File(acbn.bnB, paramString2).exists()) {
                bool1 = true;
              }
            }
            paramString1.put("hit", bool1);
            paramString2 = BaseApplicationImpl.getApplication().getRuntime();
            if (paramString2 != null)
            {
              paramString2 = (AppInterface)paramString2.getAppRuntime("modular_web");
              if (paramString2 != null)
              {
                paramString2 = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramString2.getCurrentAccountUin(), 4);
                if (paramString2 != null)
                {
                  bool1 = paramString2.getBoolean("kandian_feeds_preload", false);
                  bool2 = paramString2.getBoolean("kandian_feeds_preload_wifi", false);
                  boolean bool3 = paramString2.getBoolean("kandian_feeds_preload_4G", false);
                  boolean bool4 = paramString2.getBoolean("kandian_feeds_preload_3G", false);
                  boolean bool5 = paramString2.getBoolean("kandian_feeds_preload_2G", false);
                  paramString1.put("readInJoyPreload", bool1);
                  paramString1.put("readInJoyPreloadWifi", bool2);
                  paramString1.put("readInJoyPreload4G", bool3);
                  paramString1.put("readInJoyPreload3G", bool4);
                  paramString1.put("readInJoyPreload2G", bool5);
                  callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                  if (QLog.isColorLevel()) {
                    QLog.i("PublicAccountH5AbilityPlugin", 2, "reportpreloaddata" + paramString1.toString());
                  }
                }
              }
            }
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("showOnlyShareMenu".endsWith(paramString3))
      {
        paramJsBridgeListener = (arbt)super.getBrowserComponent(4);
        if (paramJsBridgeListener != null)
        {
          paramString1 = this.mRuntime.b();
          if (paramString1 != null)
          {
            paramString1.Qq();
            if ((paramJsBridgeListener.a != null) && (paramJsBridgeListener.a.d != null)) {
              paramJsBridgeListener.a.d.setVisibility(8);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountH5AbilityPlugin", 2, "showOnlyShareMenu");
        }
        return true;
      }
      if ("getBiuTriggerType".equals(paramString3))
      {
        paramString2 = new JSONObject();
        try
        {
          if (kpn.nx() != 1) {
            break label13361;
          }
          paramJsBridgeListener = "fastBiu";
          if (kpn.ny() != 1) {
            break label13368;
          }
          paramString1 = "fastBiu";
          paramString2.put("retCode", 0);
          paramString2.put("click", paramJsBridgeListener);
          paramString2.put("longClick", paramString1);
          if ((paramVarArgs != null) && (paramVarArgs.length > 0))
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            if (!TextUtils.isEmpty(paramJsBridgeListener)) {
              callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
            }
          }
          else
          {
            QLog.e("PublicAccountH5AbilityPlugin", 1, "[handleJsRequest] empty args when getBiuTriggerType");
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          QLog.e("PublicAccountH5AbilityPlugin", 1, "[handleJsRequest] ", paramJsBridgeListener);
        }
      }
      if ("queryKBPredownloadInfo".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramString1)) {
            callJs(paramString1, new String[] { kvr.b(this.mRuntime.a()) });
          }
          paramJsBridgeListener = "" + paramJsBridgeListener.toString();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener = "" + paramJsBridgeListener.toString();
          }
        }
        QLog.d("PublicAccountH5AbilityPlugin", 1, new Object[] { "[handleJsRequest] ", paramJsBridgeListener });
        return true;
      }
      if ("queryPredownloadInfo".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("callback");
          paramString2 = paramJsBridgeListener.optString("packageName");
          if (!TextUtils.isEmpty(paramString1)) {
            callJs(paramString1, new String[] { Achilles.fi(paramString2) });
          }
          paramJsBridgeListener = "" + paramJsBridgeListener.toString();
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener = "" + paramJsBridgeListener.toString();
          }
        }
        QLog.d("PublicAccountH5AbilityPlugin", 1, new Object[] { "[handleJsRequest] ", paramJsBridgeListener });
        return true;
      }
      if ("installPredownloadInfo".equalsIgnoreCase(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        for (;;)
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            paramString1 = paramJsBridgeListener.optString("callback");
            paramString2 = paramJsBridgeListener.optString("packageName");
            if ((!TextUtils.isEmpty(paramString1)) && (!Achilles.a(paramString1, paramString2, this.mRuntime, false))) {
              continue;
            }
            paramJsBridgeListener = "" + paramJsBridgeListener.toString();
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener = "" + paramJsBridgeListener.toString();
            continue;
          }
          QLog.d("PublicAccountH5AbilityPlugin", 1, new Object[] { "[handleJsRequest] ", paramJsBridgeListener });
          return true;
        }
      }
      if (!"likeBiuFusionRequestBehavior".equals(paramString3)) {
        break;
      }
    } while ((paramVarArgs == null) || (paramVarArgs.length <= 0));
    label5017:
    Object localObject3;
    long l10;
    long l11;
    long l9;
    long l8;
    int i2;
    label7330:
    label9401:
    label13247:
    label13375:
    for (;;)
    {
      long l1;
      long l3;
      long l4;
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  for (;;)
                  {
                    for (;;)
                    {
                      for (;;)
                      {
                        for (;;)
                        {
                          for (;;)
                          {
                            String str2;
                            try
                            {
                              localObject4 = new JSONObject(paramVarArgs[0]);
                              if (QLog.isColorLevel()) {
                                QLog.i("PublicAccountH5AbilityPlugin", 2, "web json:" + ((JSONObject)localObject4).toString());
                              }
                              localObject3 = ((JSONObject)localObject4).optString("title");
                              paramString2 = ((JSONObject)localObject4).optString("sourceName");
                              str2 = ((JSONObject)localObject4).optString("sourceUrl");
                              if (!TextUtils.isEmpty(str2)) {
                                break label13375;
                              }
                              str2 = paramString1;
                              n = ((JSONObject)localObject4).optInt("hiddenBiuComponent");
                              paramVarArgs = "";
                              if (n == 1) {
                                paramVarArgs = new String(aqgo.decode(((JSONObject)localObject4).optString("newComment"), 2));
                              }
                              l1 = 0L;
                              l3 = 0L;
                              l4 = 0L;
                              l10 = 0L;
                              l11 = 0L;
                              Object localObject1 = "";
                              for (;;)
                              {
                                try
                                {
                                  paramJsBridgeListener = new String(aqgo.decode((String)localObject3, 0));
                                }
                                catch (Exception paramString3)
                                {
                                  long l2;
                                  long l7;
                                  long l6;
                                  long l5;
                                  String str3;
                                  String str4;
                                  int i1;
                                  ArticleInfo localArticleInfo;
                                  Object localObject5;
                                  Object localObject6;
                                  Object localObject8;
                                  String str5;
                                  Object localObject2;
                                  Object localObject7;
                                  String str6;
                                  Object localObject9;
                                  String str1;
                                  paramString1 = paramString2;
                                  paramJsBridgeListener = "";
                                  l9 = l11;
                                  l8 = l10;
                                  paramString2 = (String)localObject3;
                                  continue;
                                  i = 1;
                                  continue;
                                  if (i2 == 4) {
                                    continue;
                                  }
                                  if (i2 != 5) {
                                    continue;
                                  }
                                  continue;
                                  i = 2;
                                  continue;
                                  continue;
                                  if (m != 11) {
                                    continue;
                                  }
                                  i = 5;
                                  continue;
                                  if (m != 6) {
                                    continue;
                                  }
                                  i = 6;
                                  continue;
                                  if (m != 12) {
                                    continue;
                                  }
                                  i = 7;
                                  continue;
                                  if (m != 13) {
                                    continue;
                                  }
                                  i = 8;
                                  continue;
                                  if (m < 15) {
                                    continue;
                                  }
                                  i = m;
                                  continue;
                                  continue;
                                }
                                try
                                {
                                  paramString1 = new String(aqgo.decode(paramString2, 0));
                                }
                                catch (Exception paramString3)
                                {
                                  localObject3 = paramJsBridgeListener;
                                  paramJsBridgeListener = "";
                                  paramString1 = paramString2;
                                  l9 = l11;
                                  l8 = l10;
                                  paramString2 = (String)localObject3;
                                }
                              }
                              try
                              {
                                paramString2 = ((JSONObject)localObject4).optString("feedsId");
                                paramString3 = ((JSONObject)localObject4).optString("rowkey");
                                localObject1 = paramString3;
                                l2 = l1;
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l3;
                                l5 = l1;
                              }
                              catch (Exception paramString3)
                              {
                                localObject3 = "";
                                paramString2 = paramJsBridgeListener;
                                paramJsBridgeListener = (JsBridgeListener)localObject3;
                                l9 = l11;
                                l8 = l10;
                                continue;
                              }
                              try
                              {
                                if (!TextUtils.isEmpty(paramString2))
                                {
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l1;
                                  l2 = new BigInteger(paramString2).longValue();
                                }
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l3;
                                l5 = l2;
                                paramString3 = ((JSONObject)localObject4).optString("ariticleId");
                                l1 = l3;
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l3;
                                l5 = l2;
                                if (!TextUtils.isEmpty(paramString3))
                                {
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l2;
                                  l1 = new BigInteger(paramString3).longValue();
                                }
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l1;
                                l5 = l2;
                                paramString3 = ((JSONObject)localObject4).optString("originFeedsId");
                                l3 = l4;
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l1;
                                l5 = l2;
                                if (!TextUtils.isEmpty(paramString3))
                                {
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l1;
                                  l5 = l2;
                                  l3 = new BigInteger(paramString3).longValue();
                                }
                                l9 = l11;
                                l8 = l10;
                                l7 = l3;
                                l6 = l1;
                                l5 = l2;
                                paramString3 = ((JSONObject)localObject4).optString("businessId");
                                l4 = l10;
                                l9 = l11;
                                l8 = l10;
                                l7 = l3;
                                l6 = l1;
                                l5 = l2;
                                if (!TextUtils.isEmpty(paramString3))
                                {
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  l4 = new BigInteger(paramString3).longValue();
                                }
                                l9 = l11;
                                l8 = l4;
                                l7 = l3;
                                l6 = l1;
                                l5 = l2;
                                l10 = ((JSONObject)localObject4).optLong("accountID");
                                l9 = l10;
                                l8 = l4;
                                l7 = l3;
                                l6 = l1;
                                l5 = l2;
                                j = ((JSONObject)localObject4).optInt("accountType");
                                l8 = l4;
                                localObject3 = paramString2;
                                paramString2 = (String)localObject1;
                                l5 = l2;
                                l4 = l3;
                                l2 = l10;
                                l3 = l1;
                                paramString3 = paramJsBridgeListener;
                                paramJsBridgeListener = (JsBridgeListener)localObject3;
                                l1 = l5;
                                l5 = ((JSONObject)localObject4).optLong("originFeedsType", 1L);
                                i = ((JSONObject)localObject4).optInt("type");
                                m = ((JSONObject)localObject4).optInt("adtag");
                                str3 = ((JSONObject)localObject4).optString("picurl");
                                k = ((JSONObject)localObject4).optInt("duration");
                                localObject3 = ((JSONObject)localObject4).optString("callback");
                                str4 = new String(aqgo.decode(((JSONObject)localObject4).optString("accountDesc"), 0));
                                i1 = ((JSONObject)localObject4).optInt("feedsType", 1);
                                localArticleInfo = new ArticleInfo();
                                localArticleInfo.mArticleID = l3;
                                localArticleInfo.mTitle = paramString3;
                                localArticleInfo.mSubscribeName = paramString1;
                                localArticleInfo.mFirstPagePicUrl = str3;
                                localArticleInfo.mVideoDuration = k;
                                localArticleInfo.mFeedId = l1;
                                localArticleInfo.mSummary = str4;
                                localArticleInfo.businessId = l8;
                                localArticleInfo.mFeedType = i1;
                              }
                              catch (Exception paramString3)
                              {
                                localObject3 = paramJsBridgeListener;
                                paramJsBridgeListener = paramString2;
                                l4 = l7;
                                l3 = l6;
                                l1 = l5;
                                paramString2 = (String)localObject3;
                                continue;
                              }
                              try
                              {
                                localObject1 = ((JSONObject)localObject4).getJSONArray("biuLevelList");
                                localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = new SocializeFeedsInfo.c();
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y = Long.valueOf(l4);
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z = Long.valueOf(l5);
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT = new ArrayList();
                                if (localObject1 != null)
                                {
                                  k = 0;
                                  if (k < ((JSONArray)localObject1).length())
                                  {
                                    localObject5 = new SocializeFeedsInfo.BiuCommentInfo();
                                    localObject6 = ((JSONArray)localObject1).getJSONObject(k);
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).i = Long.valueOf(((JSONObject)localObject6).optLong("uin"));
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahU = new String(aqgo.decode(((JSONObject)localObject6).optString("comment"), 0));
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahj = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahU;
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aRW = ((JSONObject)localObject6).optInt("biuTime");
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aLh = ((JSONObject)localObject6).optInt("feeds_type", 1);
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aSO = ((JSONObject)localObject6).optInt("op_type");
                                    localObject8 = ((JSONObject)localObject6).optString("jumpName");
                                    str5 = ((JSONObject)localObject6).optString("jumpUrl");
                                    if ((!TextUtils.isEmpty((CharSequence)localObject8)) && (!TextUtils.isEmpty(str5))) {
                                      ((SocializeFeedsInfo.BiuCommentInfo)localObject5).a = new SocializeFeedsInfo.JumpInfo(0L, new String(aqgo.decode((String)localObject8, 0)), str5);
                                    }
                                    if (n != 1) {}
                                  }
                                }
                              }
                              catch (JSONException localJSONException1)
                              {
                                try
                                {
                                  localObject6 = ((JSONObject)localObject6).optString("feedsId");
                                  if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).x = Long.valueOf(new BigInteger((String)localObject6).longValue());
                                  }
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.add(localObject5);
                                  k += 1;
                                  continue;
                                  paramString3.printStackTrace();
                                  j = 0;
                                  l2 = l9;
                                  paramString3 = paramString2;
                                  paramString2 = (String)localObject1;
                                  continue;
                                  localJSONException1 = localJSONException1;
                                  QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior " + localJSONException1.toString());
                                  localObject2 = null;
                                }
                                catch (Exception localException1)
                                {
                                  QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior " + localException1.toString());
                                  continue;
                                }
                              }
                            }
                            catch (JSONException paramJsBridgeListener)
                            {
                              QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior jsapi json exception " + paramJsBridgeListener.toString());
                              break;
                              localObject4 = ((JSONObject)localObject4).optJSONObject("ugcInfo");
                              localObject2 = "";
                              if ((localObject4 == null) || (!ndi.o(i1, l5))) {
                                break label13301;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r = new SocializeFeedsInfo.r();
                              i2 = ((JSONObject)localObject4).optInt("ugcType", 0);
                              localObject2 = ((JSONObject)localObject4).optString("ugcComment");
                              localObject5 = ((JSONObject)localObject4).optJSONArray("ugcAtLevelList");
                              if (localObject5 == null) {
                                break label7330;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b = new SocializeFeedsInfo.c();
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT = new ArrayList();
                              k = 0;
                              if (k >= ((JSONArray)localObject5).length()) {
                                break label7330;
                              }
                              localObject7 = new SocializeFeedsInfo.BiuCommentInfo();
                              localObject8 = ((JSONArray)localObject5).getJSONObject(k);
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).i = Long.valueOf(((JSONObject)localObject8).optLong("uin"));
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).ahU = new String(aqgo.decode(((JSONObject)localObject8).optString("comment"), 0));
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).ahj = ((SocializeFeedsInfo.BiuCommentInfo)localObject7).ahU;
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).aRW = ((JSONObject)localObject8).optInt("biuTime");
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).aLh = ((JSONObject)localObject8).optInt("feeds_type", 1);
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).aSO = ((JSONObject)localObject8).optInt("op_type");
                              str5 = ((JSONObject)localObject8).optString("jumpName");
                              str6 = ((JSONObject)localObject8).optString("jumpUrl");
                              if ((!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str6))) {
                                ((SocializeFeedsInfo.BiuCommentInfo)localObject7).a = new SocializeFeedsInfo.JumpInfo(0L, new String(aqgo.decode(str5, 0)), str6);
                              }
                              try
                              {
                                localObject8 = ((JSONObject)localObject8).optString("feedsId");
                                if (!TextUtils.isEmpty((CharSequence)localObject8)) {
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject7).x = Long.valueOf(new BigInteger((String)localObject8).longValue());
                                }
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT.add(localObject7);
                                k += 1;
                              }
                              catch (Exception localException3)
                              {
                                QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior " + localException3.toString());
                                continue;
                              }
                            }
                            catch (NumberFormatException paramJsBridgeListener)
                            {
                              QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior jsapi " + paramJsBridgeListener.toString());
                            }
                            break;
                            localArticleInfo.mTitle = new String(aqgo.decode((String)localObject2, 0));
                            localArticleInfo.mSummary = "";
                            if ((i2 != 3) && (i2 != 2)) {
                              break label13405;
                            }
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la = new ArrayList();
                            paramString3 = new SocializeFeedsInfo.s();
                            Object localObject4 = ((JSONObject)localObject4).optJSONArray("ugcPicInfo");
                            if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
                              break label13399;
                            }
                            paramString3.aii = ((JSONArray)localObject4).getJSONObject(0).optString("ugcPicUrl");
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.add(paramString3);
                            break label13399;
                            if (m == 22)
                            {
                              paramString3 = new SocializeFeedsInfo.a();
                              paramString3.accountNick = paramString1;
                              paramString3.ahS = str3;
                              paramString3.ahT = str4;
                              paramString3.vM = l2;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a = paramString3;
                            }
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa = i2;
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail = localArticleInfo.mTitle;
                            paramString1 = (String)localObject2;
                            localArticleInfo.mSocialFeedInfo.ahL = "";
                            localArticleInfo.mSocialFeedInfo.ahN = "";
                            localArticleInfo.mSocialFeedInfo.ahM = "";
                            paramString3 = new Intent(this.activity, ReadInJoyDeliverBiuActivity.class);
                            paramString3.putExtra("arg_article_info", localArticleInfo);
                            if (!TextUtils.isEmpty(paramString2)) {
                              paramString3.putExtra("biu_rowkey", paramString2);
                            }
                            paramString3.putExtra("arg_from_type", m);
                            paramString3.putExtra("arg_type", i);
                            paramString3.putExtra("result_js_callback", (String)localObject3);
                            i = 3;
                            if (m != 5) {
                              break label13429;
                            }
                            i = 4;
                            paramString3.putExtra("biu_src", i);
                            paramString3.putExtra("feed_id", paramJsBridgeListener);
                            paramString3.putExtra("feedsType", i1);
                            paramString3.putExtra("ugc_comment", paramString1);
                            paramString3.putExtra("arg_account_id", l2);
                            paramString3.putExtra("arg_account_type", j);
                            paramString3.putExtra("arg_source_url", str2);
                            if ((m == 23) && ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(localArticleInfo.mSubscribeName))))
                            {
                              QLog.d("PublicAccountH5AbilityPlugin", 1, "web page share but core info empty !");
                              return false;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb = new ArrayList();
                              localObject5 = new SocializeFeedsInfo.t();
                              localObject4 = ((JSONObject)localObject4).optJSONObject("ugcVideoInfo");
                              if (localObject4 == null) {
                                break label13420;
                              }
                              ((SocializeFeedsInfo.t)localObject5).pic_url = ((JSONObject)localObject4).optString("ugcVideoCoverUrl");
                              ((SocializeFeedsInfo.t)localObject5).duration = ((JSONObject)localObject4).optInt("ugcVideoDuration");
                              ((SocializeFeedsInfo.t)localObject5).title = paramString3;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.add(localObject5);
                              break label13420;
                              if (i2 != 1) {
                                break label13426;
                              }
                              localArticleInfo.mFirstPagePicUrl = "";
                              break label13426;
                            }
                            if (n == 1)
                            {
                              if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() <= 0)) {
                                break label13295;
                              }
                              paramJsBridgeListener = paramVarArgs + "//";
                              paramString1 = paramJsBridgeListener;
                              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                                paramString1 = "Biu~";
                              }
                              paramJsBridgeListener = "：" + paramString1;
                              lcc.a().b(new obw.a((String)localObject3, i1));
                              ((BrowserAppInterface)this.app).a().b().a(this.mRuntime.a().getLongAccountUin(), l1, localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c, 0L, paramJsBridgeListener, l3, -1L, i, paramString2, i1, localArticleInfo);
                              break;
                            }
                            paramString3.putExtra("biu_src", 4);
                            paramString3.putExtra("arg_from_type", 0);
                            paramString3.putExtra("arg_biu_state", 0);
                            paramString3.putExtra("feedsType", 1);
                            paramString3.putExtra("fast_biu_type", false);
                            paramString3.putExtra("should_show_dialog", true);
                            paramString3.putExtra("is_modified_biu", true);
                            paramString3.putExtra("modified_feeds_id", l1);
                            this.activity.startActivityForResult(paramString3, 113);
                            this.activity.overridePendingTransition(0, 0);
                            break;
                            if ("showMultiBiuEditPage".endsWith(paramString3))
                            {
                              if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
                                break;
                              }
                              for (;;)
                              {
                                try
                                {
                                  if (!(this.activity instanceof QQBrowserActivity)) {
                                    break;
                                  }
                                  localObject4 = new JSONObject(paramVarArgs[0]);
                                  if (QLog.isColorLevel()) {
                                    QLog.i("PublicAccountH5AbilityPlugin", 2, "web json:" + ((JSONObject)localObject4).toString());
                                  }
                                  localObject3 = ((JSONObject)localObject4).optString("title");
                                  paramString2 = ((JSONObject)localObject4).optString("sourceName");
                                  str2 = ((JSONObject)localObject4).optString("sourceUrl");
                                  if (!TextUtils.isEmpty(str2)) {
                                    break label13498;
                                  }
                                  str2 = paramString1;
                                  n = ((JSONObject)localObject4).optInt("hiddenBiuComponent");
                                  paramVarArgs = "";
                                  if (n == 1) {
                                    paramVarArgs = new String(aqgo.decode(((JSONObject)localObject4).optString("newComment"), 2));
                                  }
                                  l1 = 0L;
                                  l3 = 0L;
                                  l4 = 0L;
                                  l10 = 0L;
                                  l11 = 0L;
                                  localObject2 = "";
                                }
                                catch (JSONException paramJsBridgeListener)
                                {
                                  paramJsBridgeListener.printStackTrace();
                                }
                                for (;;)
                                {
                                  try
                                  {
                                    paramJsBridgeListener = new String(aqgo.decode((String)localObject3, 0));
                                  }
                                  catch (Exception paramString3)
                                  {
                                    paramString1 = paramString2;
                                    paramJsBridgeListener = "";
                                    l9 = l11;
                                    l8 = l10;
                                    paramString2 = (String)localObject3;
                                    break;
                                    i = 1;
                                    continue;
                                    if (i2 == 4) {
                                      continue;
                                    }
                                    if (i2 != 5) {
                                      continue;
                                    }
                                    continue;
                                    i = 2;
                                    continue;
                                    continue;
                                    if (m != 11) {
                                      continue;
                                    }
                                    i = 5;
                                    continue;
                                    if (m != 6) {
                                      continue;
                                    }
                                    i = 6;
                                    continue;
                                    if (m != 12) {
                                      continue;
                                    }
                                    i = 7;
                                    continue;
                                    if (m != 13) {
                                      continue;
                                    }
                                    i = 8;
                                    continue;
                                    if (m < 15) {
                                      continue;
                                    }
                                    i = m;
                                    continue;
                                    paramJsBridgeListener = "0X8009E1E";
                                    continue;
                                    paramJsBridgeListener = "0X8009E20";
                                    continue;
                                  }
                                  try
                                  {
                                    paramString1 = new String(aqgo.decode(paramString2, 0));
                                  }
                                  catch (Exception paramString3)
                                  {
                                    localObject3 = paramJsBridgeListener;
                                    paramJsBridgeListener = "";
                                    paramString1 = paramString2;
                                    l9 = l11;
                                    l8 = l10;
                                    paramString2 = (String)localObject3;
                                    break;
                                  }
                                }
                                try
                                {
                                  paramString2 = ((JSONObject)localObject4).optString("feedsId");
                                  paramString3 = ((JSONObject)localObject4).optString("rowkey");
                                  localObject2 = paramString3;
                                  l2 = l1;
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l1;
                                }
                                catch (Exception paramString3)
                                {
                                  localObject3 = "";
                                  paramString2 = paramJsBridgeListener;
                                  paramJsBridgeListener = (JsBridgeListener)localObject3;
                                  l9 = l11;
                                  l8 = l10;
                                  continue;
                                }
                                try
                                {
                                  if (!TextUtils.isEmpty(paramString2))
                                  {
                                    l9 = l11;
                                    l8 = l10;
                                    l7 = l4;
                                    l6 = l3;
                                    l5 = l1;
                                    l2 = new BigInteger(paramString2).longValue();
                                  }
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l2;
                                  paramString3 = ((JSONObject)localObject4).optString("ariticleId");
                                  l1 = l3;
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l2;
                                  if (!TextUtils.isEmpty(paramString3))
                                  {
                                    l9 = l11;
                                    l8 = l10;
                                    l7 = l4;
                                    l6 = l3;
                                    l5 = l2;
                                    l1 = new BigInteger(paramString3).longValue();
                                  }
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l1;
                                  l5 = l2;
                                  paramString3 = ((JSONObject)localObject4).optString("originFeedsId");
                                  l3 = l4;
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l1;
                                  l5 = l2;
                                  if (!TextUtils.isEmpty(paramString3))
                                  {
                                    l9 = l11;
                                    l8 = l10;
                                    l7 = l4;
                                    l6 = l1;
                                    l5 = l2;
                                    l3 = new BigInteger(paramString3).longValue();
                                  }
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  paramString3 = ((JSONObject)localObject4).optString("businessId");
                                  l4 = l10;
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  if (!TextUtils.isEmpty(paramString3))
                                  {
                                    l9 = l11;
                                    l8 = l10;
                                    l7 = l3;
                                    l6 = l1;
                                    l5 = l2;
                                    l4 = new BigInteger(paramString3).longValue();
                                  }
                                  l9 = l11;
                                  l8 = l4;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  l10 = ((JSONObject)localObject4).optLong("accountID");
                                  l9 = l10;
                                  l8 = l4;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  j = ((JSONObject)localObject4).optInt("accountType");
                                  l8 = l4;
                                  localObject3 = paramString2;
                                  paramString2 = (String)localObject2;
                                  l5 = l2;
                                  l4 = l3;
                                  l2 = l10;
                                  l3 = l1;
                                  paramString3 = paramJsBridgeListener;
                                  paramJsBridgeListener = (JsBridgeListener)localObject3;
                                  l1 = l5;
                                  l5 = ((JSONObject)localObject4).optLong("originFeedsType", 1L);
                                  i = ((JSONObject)localObject4).optInt("type");
                                  m = ((JSONObject)localObject4).optInt("adtag");
                                  str3 = ((JSONObject)localObject4).optString("picurl");
                                  k = ((JSONObject)localObject4).optInt("duration");
                                  localObject3 = ((JSONObject)localObject4).optString("callback");
                                  str4 = new String(aqgo.decode(((JSONObject)localObject4).optString("accountDesc"), 0));
                                  i1 = ((JSONObject)localObject4).optInt("feedsType", 1);
                                  localArticleInfo = new ArticleInfo();
                                  localArticleInfo.mArticleID = l3;
                                  localArticleInfo.mTitle = paramString3;
                                  localArticleInfo.mSubscribeName = paramString1;
                                  localArticleInfo.mFirstPagePicUrl = str3;
                                  localArticleInfo.mVideoDuration = k;
                                  localArticleInfo.mFeedId = l1;
                                  localArticleInfo.mSummary = str4;
                                  localArticleInfo.businessId = l8;
                                  localArticleInfo.mFeedType = i1;
                                }
                                catch (Exception paramString3)
                                {
                                  localObject3 = paramJsBridgeListener;
                                  paramJsBridgeListener = paramString2;
                                  l4 = l7;
                                  l3 = l6;
                                  l1 = l5;
                                  paramString2 = (String)localObject3;
                                  continue;
                                }
                                try
                                {
                                  localObject2 = ((JSONObject)localObject4).getJSONArray("biuLevelList");
                                  localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = new SocializeFeedsInfo.c();
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y = Long.valueOf(l4);
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z = Long.valueOf(l5);
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT = new ArrayList();
                                  if (localObject2 == null) {
                                    break label9401;
                                  }
                                  k = 0;
                                  if (k >= ((JSONArray)localObject2).length()) {
                                    break label9401;
                                  }
                                  localObject5 = new SocializeFeedsInfo.BiuCommentInfo();
                                  localObject7 = ((JSONArray)localObject2).getJSONObject(k);
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).i = Long.valueOf(((JSONObject)localObject7).optLong("uin"));
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahU = new String(aqgo.decode(((JSONObject)localObject7).optString("comment"), 0));
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahj = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).ahU;
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aRW = ((JSONObject)localObject7).optInt("biuTime");
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aLh = ((JSONObject)localObject7).optInt("feeds_type", 1);
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).aSO = ((JSONObject)localObject7).optInt("op_type");
                                  localObject9 = ((JSONObject)localObject7).optString("jumpName");
                                  str5 = ((JSONObject)localObject7).optString("jumpUrl");
                                  if ((!TextUtils.isEmpty((CharSequence)localObject9)) && (!TextUtils.isEmpty(str5))) {
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).a = new SocializeFeedsInfo.JumpInfo(0L, new String(aqgo.decode((String)localObject9, 0)), str5);
                                  }
                                  if (n != 1) {}
                                }
                                catch (JSONException localJSONException2)
                                {
                                  try
                                  {
                                    localObject7 = ((JSONObject)localObject7).optString("feedsId");
                                    if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                                      ((SocializeFeedsInfo.BiuCommentInfo)localObject5).x = Long.valueOf(new BigInteger((String)localObject7).longValue());
                                    }
                                    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.add(localObject5);
                                    k += 1;
                                    continue;
                                    paramString3.printStackTrace();
                                    j = 0;
                                    l2 = l9;
                                    paramString3 = paramString2;
                                    paramString2 = (String)localObject2;
                                    continue;
                                    localJSONException2 = localJSONException2;
                                    localJSONException2.printStackTrace();
                                    str1 = null;
                                  }
                                  catch (Exception localException2)
                                  {
                                    localException2.printStackTrace();
                                  }
                                }
                              }
                              break;
                              localObject4 = ((JSONObject)localObject4).optJSONObject("ugcInfo");
                              str1 = "";
                              if ((localObject4 == null) || (!ndi.o(i1, l5))) {
                                break label13289;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r = new SocializeFeedsInfo.r();
                              i2 = ((JSONObject)localObject4).optInt("ugcType", 0);
                              str1 = ((JSONObject)localObject4).optString("ugcComment");
                              localObject5 = ((JSONObject)localObject4).optJSONArray("ugcAtLevelList");
                              if (localObject5 != null)
                              {
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b = new SocializeFeedsInfo.c();
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT = new ArrayList();
                                k = 0;
                                for (;;)
                                {
                                  if (k < ((JSONArray)localObject5).length())
                                  {
                                    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
                                    localObject9 = ((JSONArray)localObject5).getJSONObject(k);
                                    localBiuCommentInfo.i = Long.valueOf(((JSONObject)localObject9).optLong("uin"));
                                    localBiuCommentInfo.ahU = new String(aqgo.decode(((JSONObject)localObject9).optString("comment"), 0));
                                    localBiuCommentInfo.ahj = localBiuCommentInfo.ahU;
                                    localBiuCommentInfo.aRW = ((JSONObject)localObject9).optInt("biuTime");
                                    localBiuCommentInfo.aLh = ((JSONObject)localObject9).optInt("feeds_type", 1);
                                    localBiuCommentInfo.aSO = ((JSONObject)localObject9).optInt("op_type");
                                    str5 = ((JSONObject)localObject9).optString("jumpName");
                                    str6 = ((JSONObject)localObject9).optString("jumpUrl");
                                    if ((!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str6))) {
                                      localBiuCommentInfo.a = new SocializeFeedsInfo.JumpInfo(0L, new String(aqgo.decode(str5, 0)), str6);
                                    }
                                    try
                                    {
                                      localObject9 = ((JSONObject)localObject9).optString("feedsId");
                                      if (!TextUtils.isEmpty((CharSequence)localObject9)) {
                                        localBiuCommentInfo.x = Long.valueOf(new BigInteger((String)localObject9).longValue());
                                      }
                                      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT.add(localBiuCommentInfo);
                                      k += 1;
                                    }
                                    catch (Exception localException4)
                                    {
                                      for (;;)
                                      {
                                        localException4.printStackTrace();
                                      }
                                    }
                                  }
                                }
                              }
                              localArticleInfo.mTitle = new String(aqgo.decode(str1, 0));
                              localArticleInfo.mSummary = "";
                              if ((i2 != 3) && (i2 != 2)) {
                                break label13528;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la = new ArrayList();
                              paramString3 = new SocializeFeedsInfo.s();
                              localObject4 = ((JSONObject)localObject4).optJSONArray("ugcPicInfo");
                              if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
                                break label13522;
                              }
                              paramString3.aii = ((JSONArray)localObject4).getJSONObject(0).optString("ugcPicUrl");
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.add(paramString3);
                              break label13522;
                              if (m == 22)
                              {
                                paramString3 = new SocializeFeedsInfo.a();
                                paramString3.accountNick = paramString1;
                                paramString3.ahS = str3;
                                paramString3.ahT = str4;
                                paramString3.vM = l2;
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a = paramString3;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa = i2;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail = localArticleInfo.mTitle;
                              paramString1 = str1;
                              localArticleInfo.mSocialFeedInfo.ahL = "";
                              localArticleInfo.mSocialFeedInfo.ahN = "";
                              localArticleInfo.mSocialFeedInfo.ahM = "";
                              paramString3 = new Intent(this.activity, ReadInJoyDeliverBiuActivity.class);
                              paramString3.putExtra("arg_article_info", localArticleInfo);
                              if (!TextUtils.isEmpty(paramString2)) {
                                paramString3.putExtra("biu_rowkey", paramString2);
                              }
                              paramString3.putExtra("arg_from_type", m);
                              paramString3.putExtra("arg_type", i);
                              paramString3.putExtra("result_js_callback", (String)localObject3);
                              i = 3;
                              if (m != 5) {
                                break label13552;
                              }
                              i = 4;
                              paramString3.putExtra("biu_src", i);
                              paramString3.putExtra("feed_id", paramJsBridgeListener);
                              paramString3.putExtra("feedsType", i1);
                              paramString3.putExtra("ugc_comment", paramString1);
                              paramString3.putExtra("arg_account_id", l2);
                              paramString3.putExtra("arg_account_type", j);
                              paramString3.putExtra("arg_source_url", str2);
                              if ((m == 23) && ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(localArticleInfo.mSubscribeName))))
                              {
                                QLog.d("PublicAccountH5AbilityPlugin", 1, "web page share but core info empty !");
                                return false;
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb = new ArrayList();
                                localObject5 = new SocializeFeedsInfo.t();
                                localObject4 = ((JSONObject)localObject4).optJSONObject("ugcVideoInfo");
                                if (localObject4 == null) {
                                  break label13543;
                                }
                                ((SocializeFeedsInfo.t)localObject5).pic_url = ((JSONObject)localObject4).optString("ugcVideoCoverUrl");
                                ((SocializeFeedsInfo.t)localObject5).duration = ((JSONObject)localObject4).optInt("ugcVideoDuration");
                                ((SocializeFeedsInfo.t)localObject5).title = paramString3;
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.add(localObject5);
                                break label13543;
                                if (i2 != 1) {
                                  break label13549;
                                }
                                localArticleInfo.mFirstPagePicUrl = "";
                                break label13549;
                              }
                              if (n == 1)
                              {
                                if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() <= 0)) {
                                  break label13283;
                                }
                                paramJsBridgeListener = paramVarArgs + "//";
                                paramString1 = paramJsBridgeListener;
                                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                                  paramString1 = "Biu~";
                                }
                                paramJsBridgeListener = "：" + paramString1;
                                paramString1 = ((BrowserAppInterface)this.app).a();
                                lcc.a().b(new obw.a((String)localObject3, i1));
                                paramString1.b().a(this.mRuntime.a().getLongAccountUin(), l1, localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c, 0L, paramJsBridgeListener, l3, -1L, i, paramString2, i1, localArticleInfo);
                                break;
                              }
                              this.activity.startActivityForResult(paramString3, 113);
                              this.activity.overridePendingTransition(0, 0);
                              break;
                            }
                            if ("showUGCEditPage".endsWith(paramString3))
                            {
                              if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || (!(this.activity instanceof QQBrowserActivity))) {
                                break;
                              }
                              nhr.a((BaseActivity)this.activity, new PublicAccountH5AbilityPlugin.5(this, paramVarArgs));
                              break;
                            }
                            if (!"showUGCVideoUploadPage".equals(paramString3)) {
                              break label10689;
                            }
                            try
                            {
                              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoUploadPage() param json:" + paramJsBridgeListener.toString());
                            }
                            catch (Exception paramJsBridgeListener) {}
                          }
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoUploadPage() Exception=" + paramJsBridgeListener.getMessage());
                          break;
                          label10689:
                          if ("showUGCVideoRecordPage".equals(paramString3))
                          {
                            nhr.a((BaseActivity)this.activity, new PublicAccountH5AbilityPlugin.6(this, paramVarArgs));
                            break;
                          }
                          if (!"sharePicToWeChatCircle".equals(paramString3)) {
                            break label10795;
                          }
                          try
                          {
                            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("pictureUrl");
                            if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                              break label10787;
                            }
                            if (!QLog.isColorLevel()) {
                              break;
                            }
                            QLog.d("PublicAccountH5AbilityPlugin", 2, "url is null");
                          }
                          catch (JSONException paramJsBridgeListener)
                          {
                            paramJsBridgeListener.printStackTrace();
                          }
                        }
                        break;
                        pj(paramJsBridgeListener);
                        break;
                        if (!"updateTopicCardFollowInfo".equals(paramString3)) {
                          break label10903;
                        }
                        try
                        {
                          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                          i = paramJsBridgeListener.getInt("topicId");
                          j = paramJsBridgeListener.getInt("followInfo");
                          if (QLog.isColorLevel()) {
                            QLog.d("PublicAccountH5AbilityPlugin", 2, "topic id = " + i + "\t follow info =" + j);
                          }
                          this.mClient.eD(i, j);
                        }
                        catch (JSONException paramJsBridgeListener)
                        {
                          paramJsBridgeListener.printStackTrace();
                        }
                      }
                      break;
                      if ("showCommentEditor".equals(paramString3))
                      {
                        try
                        {
                          paramString3 = new JSONObject(paramVarArgs[0]);
                          if (!paramString3.has("enableAnonymous")) {
                            break label13277;
                          }
                          bool1 = paramString3.optBoolean("enableAnonymous");
                          if (!paramString3.has("canBiu")) {
                            break label13271;
                          }
                          bool2 = paramString3.optBoolean("canBiu");
                          if (!paramString3.has("placeholder")) {
                            break label13265;
                          }
                          paramJsBridgeListener = paramString3.optString("placeholder");
                          QLog.d("PublicAccountH5AbilityPlugin", 2, "ph5 | comment_placeholder : " + paramJsBridgeListener);
                        }
                        catch (JSONException paramJsBridgeListener)
                        {
                          paramJsBridgeListener.printStackTrace();
                        }
                        try
                        {
                          paramString1 = new String(aqgo.decode(paramJsBridgeListener, 0));
                          paramJsBridgeListener = paramString1;
                        }
                        catch (Exception paramString1)
                        {
                          paramString1.printStackTrace();
                          break label11031;
                        }
                        QLog.d("PublicAccountH5AbilityPlugin", 2, "ph5 | comment_placeholder after decode: " + paramJsBridgeListener);
                        paramString1 = paramJsBridgeListener;
                        if (!paramString3.has("defaultTxt")) {
                          break label13259;
                        }
                        paramJsBridgeListener = paramString3.optString("defaultTxt");
                        try
                        {
                          paramString2 = new String(aqgo.decode(paramJsBridgeListener, 0));
                          paramJsBridgeListener = paramString2;
                        }
                        catch (Exception paramString2)
                        {
                          for (;;)
                          {
                            paramString2.printStackTrace();
                          }
                        }
                        if (!paramString3.has("maxLength")) {
                          break label13253;
                        }
                        i = paramString3.optInt("maxLength", -1);
                        if (!paramString3.has("commentType")) {
                          break label13247;
                        }
                        j = paramString3.optInt("commentType", 0);
                        k = 0;
                        if (paramString3.has("sourceType")) {
                          k = paramString3.optInt("sourceType", 0);
                        }
                        paramString2 = paramString3.optString("callback");
                        paramVarArgs = paramString3.optJSONArray("defaultCommentAtLevel");
                        m = paramString3.optInt("openAt", 0);
                        paramString3 = new Intent();
                        paramString3.putExtra("comment_type", false);
                        paramString3.putExtra("arg_comment_enable_anonymous", bool1);
                        paramString3.putExtra("arg_comment_placeholder", paramString1);
                        paramString3.putExtra("arg_comment_default_txt", paramJsBridgeListener);
                        paramString3.putExtra("arg_comment_max_length", i);
                        paramString3.putExtra("arg_comment_comment_type", j);
                        paramString3.putExtra("arg_comment_source_type", k);
                        paramString3.putExtra("arg_callback", paramString2);
                        paramString3.putExtra("arg_comment_open_at", m);
                        paramString3.putExtra("comment_can_biu", bool2);
                        paramString3.putExtra("public_fragment_window_feature", 1);
                        if (paramVarArgs != null) {
                          paramString3.putExtra("arg_comment_default_comment_at", paramVarArgs.toString());
                        }
                        PublicTransFragmentActivity.startForResult(this.activity, paramString3, ReadInJoyCommentComponentFragment.class, 117);
                        break;
                        break;
                      }
                      if ("showPicture".equals(paramString3))
                      {
                        pg(paramVarArgs[0]);
                        break;
                      }
                      if (!"showNativeAd".equals(paramString3)) {
                        break label11526;
                      }
                      paramJsBridgeListener = null;
                      try
                      {
                        paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
                        paramJsBridgeListener = paramString1;
                        paramString2 = new Intent();
                        paramJsBridgeListener = paramString1;
                        paramString2.putExtra("param_ad_json", paramVarArgs[0]);
                        paramJsBridgeListener = paramString1;
                        PublicTransFragmentActivity.start(this.activity, paramString2, ReadInJoyNativeAdFragment.class);
                        paramJsBridgeListener = paramString1;
                        callJs(paramString1, new String[] { new JSONObject().put("retCode", 0).toString() });
                      }
                      catch (Exception paramString1)
                      {
                        paramString1.printStackTrace();
                        callJs(paramJsBridgeListener, new String[] { "{\"retCode\":-1}" });
                      }
                    }
                    break;
                    if (!"preloadNativeAdResource".equals(paramString3)) {
                      break label11695;
                    }
                    paramString1 = null;
                    paramJsBridgeListener = paramString1;
                    try
                    {
                      paramString2 = new JSONObject(paramVarArgs[0]);
                      paramJsBridgeListener = paramString1;
                      paramString1 = paramString2.optString("callback");
                      paramJsBridgeListener = paramString1;
                      paramString2 = paramString2.optJSONArray("resourceList");
                      paramJsBridgeListener = paramString1;
                      paramString3 = new ArrayList();
                      i = 0;
                      for (;;)
                      {
                        paramJsBridgeListener = paramString1;
                        if (i >= paramString2.length()) {
                          break;
                        }
                        paramJsBridgeListener = paramString1;
                        paramString3.add(paramString2.getJSONObject(i).optString("url"));
                        i += 1;
                      }
                      paramJsBridgeListener = paramString1;
                      this.mClient.cB(paramString3);
                      paramJsBridgeListener = paramString1;
                      callJs(paramString1, new String[] { new JSONObject().put("retCode", 0).toString() });
                    }
                    catch (Exception paramString1)
                    {
                      paramString1.printStackTrace();
                      callJs(paramJsBridgeListener, new String[] { "{\"retCode\":-1}" });
                    }
                  }
                  break;
                  if (!"getLocalCache".equals(paramString3)) {
                    break label11961;
                  }
                  try
                  {
                    for (;;)
                    {
                      paramString2 = new JSONObject(paramVarArgs[0]);
                      paramString1 = paramString2.optString("callback");
                      if (paramString2.has("localkey")) {
                        paramString2.optString("localkey", "");
                      }
                      paramJsBridgeListener = "";
                      if (paramString2.has("scene")) {
                        paramJsBridgeListener = paramString2.optString("scene", "");
                      }
                      if (!"messageBox".equals(paramJsBridgeListener)) {
                        break label11869;
                      }
                      paramJsBridgeListener = this.c.b("CMD_GET_UNREAD_MESSAGE_BOX_DATA", null).getString("VALUE_UNREAD_MESSAGE_BOX_DATA", "");
                      bool1 = "".equals(paramJsBridgeListener);
                      if (bool1) {
                        break;
                      }
                      try
                      {
                        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
                        callJs(paramString1, new String[] { new JSONObject().put("retData", paramJsBridgeListener).toString() });
                      }
                      catch (JSONException paramJsBridgeListener)
                      {
                        paramJsBridgeListener.printStackTrace();
                      }
                    }
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    paramJsBridgeListener.printStackTrace();
                  }
                }
                break;
                label11869:
                if (!"commentPage".equals(paramJsBridgeListener)) {
                  break;
                }
                paramJsBridgeListener = this.c.b("CMD_GET_CLICK_COMMENT_ACTICLEINFO", null).getString("VALUE_CLICK_COMMENT_ACTICLEINFO", "");
                bool1 = "".equals(paramJsBridgeListener);
                if (bool1) {
                  break;
                }
                try
                {
                  paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
                  callJs(paramString1, new String[] { new JSONObject().put("retData", paramJsBridgeListener).toString() });
                }
                catch (JSONException paramJsBridgeListener)
                {
                  paramJsBridgeListener.printStackTrace();
                }
              }
              break;
              if (!"updateAccountCardFollowInfo".equals(paramString3)) {
                break label12161;
              }
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountH5AbilityPlugin", 2, "updateAccountCardFollowInfo jsonObject = " + paramJsBridgeListener);
                }
                l1 = paramJsBridgeListener.getLong("followUin");
                i = paramJsBridgeListener.getInt("followInfo");
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountH5AbilityPlugin", 2, "topic id = " + l1 + "\t follow info =" + i);
                }
                this.mClient.af(l1, i);
                this.mRuntime.getActivity().setResult(-1, new Intent().putExtra("followInfo", i));
              }
              catch (JSONException paramJsBridgeListener)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("PublicAccountH5AbilityPlugin", 2, "updateAccountCardFollowInfo e = " + paramJsBridgeListener);
                }
                paramJsBridgeListener.printStackTrace();
              }
            }
            break;
            if ("selectAndInviteFriend".equals(paramString3))
            {
              e(paramString3, paramVarArgs);
              break;
            }
            if (!"addPreDownloadVideo".equals(paramString3)) {
              break label12376;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountH5AbilityPlugin", 2, "WebVideoPredownload addPreDownloadVideo");
            }
            if (this.jdField_a_of_type_Mzl == null) {
              this.jdField_a_of_type_Mzl = new mzl();
            }
            paramJsBridgeListener = this.jdField_a_of_type_Mzl;
            try
            {
              paramJsBridgeListener.a(new ocm(this));
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramString2 = paramString1.optString("callback");
              paramString3 = paramString1.optString("video_vid");
              i = paramString1.optInt("busitype", -1);
              j = paramString1.optInt("video_duration", 0);
              k = paramString1.optInt("cache_duration", 0);
              paramVarArgs = paramString1.optString("video_url");
              if (QLog.isColorLevel()) {
                QLog.d("PublicAccountH5AbilityPlugin", 2, "WebVideoPredownload addPreDownloadVideo , content = " + paramString1.toString());
              }
              paramJsBridgeListener.b(paramString3, i, j, k, paramVarArgs, paramString2);
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          break;
          label12376:
          if ("stopPreDownloadVideo".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountH5AbilityPlugin", 2, "WebVideoPredownload stopPreDownloadVideo");
            }
            paramJsBridgeListener = this.jdField_a_of_type_Mzl;
            if (paramJsBridgeListener == null) {
              break;
            }
            paramJsBridgeListener.aUL();
            break;
          }
          if (!"openViola".equals(paramString3)) {
            break label12510;
          }
          paramJsBridgeListener = new Bundle();
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.getString("url");
            paramString2 = paramString2.optString("webUrl", "");
            paramJsBridgeListener.putString("url", paramString1);
            paramJsBridgeListener.putString("webUrl", paramString2);
            if (this.c == null) {
              break;
            }
            this.c.b("CMD_OPEN_VIOLA_FROM_TOOL", paramJsBridgeListener);
          }
          catch (JSONException paramJsBridgeListener) {}
        }
        break;
        label12510:
        if (!"showVisibleUserList".equals(paramString3)) {
          break label12615;
        }
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("feedsId");
          QLog.d("PublicAccountH5AbilityPlugin", 2, "showVisibleUserList feedsId " + paramJsBridgeListener);
          paramString1 = new Intent();
          paramString1.putExtra("feeds_id", new BigInteger(paramJsBridgeListener).longValue());
          PublicFragmentActivity.start(this.activity, paramString1, ReadInJoyPrivacyListFragment.class);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      break label4382;
      label12615:
      if ("reportKandian".equals(paramString3)) {
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            i = paramString1.optInt("op");
            paramString2 = paramString1.optString("bid");
            paramString3 = paramString1.optString("data");
            paramVarArgs = paramString1.optString("callback");
            switch (i)
            {
            case 1: 
              QLog.d("PublicAccountH5AbilityPlugin", 1, "reportKandian " + i + " " + paramString2 + " " + paramString3);
              kbp.a(null, "", paramJsBridgeListener, paramJsBridgeListener, 0, 0, "", "", paramString2, paramString1.toString(), false);
              callJs(paramVarArgs, new String[] { new JSONObject().put("retCode", 0).toString() });
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          break;
          paramJsBridgeListener = "0X8009D64";
          continue;
          paramJsBridgeListener = "0X8009E1F";
        }
      }
      if ("showReadInJoyNativeCommentView".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          a(new JSONObject(paramVarArgs[0]), paramJsBridgeListener, new ocn(this));
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            QLog.e("PublicAccountH5AbilityPlugin", 1, "showReadInJoyNativeCommentView Exception:", paramJsBridgeListener);
          }
        }
      }
      if (!"accountEditPageCompleted".equals(paramString3)) {
        break label4382;
      }
      if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
        QLog.d("PublicAccountH5AbilityPlugin", 1, new Object[] { "invoke jsCallback publicAccountNew.accountEditPageCompleted args:", paramVarArgs });
      }
      if (paramVarArgs == null) {
        break label13635;
      }
      try
      {
        if (paramVarArgs.length <= 0) {
          break label13635;
        }
        i = new JSONObject(paramVarArgs[0]).optInt("retcode");
        if (i == 0)
        {
          if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
            QLog.d("PublicAccountH5AbilityPlugin", 1, "invoke jsCallback publicAccountNew.accountEditPageCompleted completed!");
          }
          this.activity.setResult(-1, new Intent().putExtra("key_ugc_account_edit", true));
          this.activity.finish();
        }
        else if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
        {
          QLog.d("PublicAccountH5AbilityPlugin", 1, "invoke jsCallback publicAccountNew.accountEditPageCompleted not completed, retCode=" + i);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isDebugVersion()) {
          break label13083;
        }
      }
      if (!QLog.isColorLevel()) {
        break label13635;
      }
      QLog.e("PublicAccountH5AbilityPlugin", 1, "invoke jsCallback publicAccountNew.accountEditPageCompleted Exception:", paramJsBridgeListener);
      break label13635;
      label13253:
      label13259:
      label13265:
      label13271:
      label13277:
      label13283:
      label13289:
      label13295:
      label13301:
      label13307:
      do
      {
        bool1 = false;
        break label4137;
        i = 0;
        break label2495;
        break;
        return true;
        return true;
        k = 9;
        break;
        return true;
        return true;
        return true;
        if (n == 1) {
          break label4118;
        }
      } while (n != 2);
      break label4118;
      return true;
      paramJsBridgeListener = "normalBiu";
      break label5017;
      paramString1 = "normalBiu";
      break label5028;
    }
    label10787:
    label10795:
    label11695:
    label11961:
    label13399:
    label13405:
    label13420:
    label13426:
    label13429:
    return true;
  }
  
  void init()
  {
    if (this.ac.compareAndSet(false, true))
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
    if (this.c == null) {
      this.c = muw.a();
    }
  }
  
  /* Error */
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 2440	com/tencent/mobileqq/webview/swift/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +150 -> 159
    //   12: aload_1
    //   13: ifnull +117 -> 130
    //   16: new 365	org/json/JSONObject
    //   19: dup
    //   20: invokespecial 589	org/json/JSONObject:<init>	()V
    //   23: astore 7
    //   25: aload 7
    //   27: ldc_w 591
    //   30: iconst_0
    //   31: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   34: pop
    //   35: aload 7
    //   37: ldc_w 596
    //   40: ldc_w 1393
    //   43: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_1
    //   48: ldc_w 2442
    //   51: invokevirtual 561	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 169	obw:bec	I
    //   59: iconst_1
    //   60: if_icmpne +40 -> 100
    //   63: aload 7
    //   65: ldc_w 2442
    //   68: aload_1
    //   69: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: aconst_null
    //   74: ldc 247
    //   76: ldc 249
    //   78: ldc 192
    //   80: ldc_w 2444
    //   83: ldc_w 2444
    //   86: iconst_0
    //   87: iconst_0
    //   88: ldc_w 264
    //   91: ldc 192
    //   93: ldc 192
    //   95: ldc 192
    //   97: invokestatic 256	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 2445	obw:callback	Ljava/lang/String;
    //   104: invokestatic 567	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +23 -> 130
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 2445	obw:callback	Ljava/lang/String;
    //   115: iconst_1
    //   116: anewarray 235	java/lang/String
    //   119: dup
    //   120: iconst_0
    //   121: aload 7
    //   123: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   126: aastore
    //   127: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   130: aload_0
    //   131: iconst_m1
    //   132: putfield 169	obw:bec	I
    //   135: aload_0
    //   136: iconst_m1
    //   137: putfield 171	obw:bed	I
    //   140: return
    //   141: astore 8
    //   143: aload 8
    //   145: invokevirtual 607	org/json/JSONException:printStackTrace	()V
    //   148: goto -101 -> 47
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 607	org/json/JSONException:printStackTrace	()V
    //   156: goto -83 -> 73
    //   159: iload_2
    //   160: bipush 112
    //   162: if_icmpne +143 -> 305
    //   165: new 1040	java/io/File
    //   168: dup
    //   169: aload_0
    //   170: getfield 210	obw:apB	Ljava/lang/String;
    //   173: invokespecial 1041	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: astore_1
    //   177: new 365	org/json/JSONObject
    //   180: dup
    //   181: invokespecial 589	org/json/JSONObject:<init>	()V
    //   184: astore 7
    //   186: new 634	org/json/JSONArray
    //   189: dup
    //   190: invokespecial 2446	org/json/JSONArray:<init>	()V
    //   193: astore 8
    //   195: aload_1
    //   196: ifnull +36 -> 232
    //   199: aload_1
    //   200: invokevirtual 1305	java/io/File:exists	()Z
    //   203: ifeq +29 -> 232
    //   206: invokestatic 2450	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   209: new 2452	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$2
    //   212: dup
    //   213: aload_0
    //   214: aload 8
    //   216: aload 7
    //   218: invokespecial 2455	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$2:<init>	(Lobw;Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    //   221: invokevirtual 2461	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   224: pop
    //   225: return
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 607	org/json/JSONException:printStackTrace	()V
    //   231: return
    //   232: aload 7
    //   234: ldc_w 591
    //   237: iconst_1
    //   238: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   241: pop
    //   242: aload 7
    //   244: ldc_w 596
    //   247: ldc_w 2462
    //   250: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   253: pop
    //   254: aload 7
    //   256: ldc_w 1513
    //   259: ldc_w 1515
    //   262: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   265: pop
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 212	obw:apC	Ljava/lang/String;
    //   271: iconst_1
    //   272: anewarray 235	java/lang/String
    //   275: dup
    //   276: iconst_0
    //   277: aload 7
    //   279: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   282: aastore
    //   283: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   286: aload_0
    //   287: ldc 192
    //   289: putfield 210	obw:apB	Ljava/lang/String;
    //   292: aload_0
    //   293: ldc 192
    //   295: putfield 212	obw:apC	Ljava/lang/String;
    //   298: aload_0
    //   299: ldc 192
    //   301: putfield 214	obw:apD	Ljava/lang/String;
    //   304: return
    //   305: iload_2
    //   306: bipush 111
    //   308: if_icmpne +325 -> 633
    //   311: new 365	org/json/JSONObject
    //   314: dup
    //   315: invokespecial 589	org/json/JSONObject:<init>	()V
    //   318: astore 8
    //   320: new 634	org/json/JSONArray
    //   323: dup
    //   324: invokespecial 2446	org/json/JSONArray:<init>	()V
    //   327: astore 9
    //   329: aload_1
    //   330: ifnull +93 -> 423
    //   333: aload_1
    //   334: ldc_w 2464
    //   337: invokevirtual 2468	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   340: astore 7
    //   342: iconst_0
    //   343: istore_3
    //   344: aload 7
    //   346: ifnull +11 -> 357
    //   349: aload 7
    //   351: invokevirtual 545	java/util/ArrayList:size	()I
    //   354: ifne +75 -> 429
    //   357: aload 8
    //   359: ldc_w 591
    //   362: iconst_1
    //   363: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   366: pop
    //   367: aload 8
    //   369: ldc_w 596
    //   372: ldc 192
    //   374: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   377: pop
    //   378: aload 8
    //   380: ldc_w 1513
    //   383: ldc_w 1526
    //   386: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   389: pop
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 212	obw:apC	Ljava/lang/String;
    //   395: iconst_1
    //   396: anewarray 235	java/lang/String
    //   399: dup
    //   400: iconst_0
    //   401: aload 8
    //   403: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   406: aastore
    //   407: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   410: aload_0
    //   411: ldc 192
    //   413: putfield 212	obw:apC	Ljava/lang/String;
    //   416: return
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual 607	org/json/JSONException:printStackTrace	()V
    //   422: return
    //   423: aconst_null
    //   424: astore 7
    //   426: goto -84 -> 342
    //   429: aload_1
    //   430: ldc_w 2470
    //   433: iconst_0
    //   434: invokevirtual 572	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   437: ifne +5 -> 442
    //   440: iconst_1
    //   441: istore_3
    //   442: iload_3
    //   443: ifeq +1286 -> 1729
    //   446: invokestatic 2450	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   449: new 2472	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$3
    //   452: dup
    //   453: aload_0
    //   454: aload 7
    //   456: aload 9
    //   458: aload 8
    //   460: invokespecial 2475	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$3:<init>	(Lobw;Ljava/util/ArrayList;Lorg/json/JSONArray;Lorg/json/JSONObject;)V
    //   463: invokevirtual 2461	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   466: pop
    //   467: return
    //   468: iload_3
    //   469: aload 7
    //   471: invokevirtual 545	java/util/ArrayList:size	()I
    //   474: if_icmpge +60 -> 534
    //   477: invokestatic 1318	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   480: astore_1
    //   481: new 426	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 2477
    //   491: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 1319	java/util/UUID:toString	()Ljava/lang/String;
    //   498: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: astore_1
    //   505: aload 9
    //   507: iload_3
    //   508: aload_1
    //   509: invokevirtual 2480	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   512: pop
    //   513: getstatic 161	obw:eH	Ljava/util/HashMap;
    //   516: aload_1
    //   517: aload 7
    //   519: iload_3
    //   520: invokevirtual 548	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   523: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   526: pop
    //   527: iload_3
    //   528: iconst_1
    //   529: iadd
    //   530: istore_3
    //   531: goto -63 -> 468
    //   534: aload 8
    //   536: ldc_w 2482
    //   539: aload 9
    //   541: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   544: pop
    //   545: aload 8
    //   547: ldc_w 591
    //   550: iconst_0
    //   551: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   554: pop
    //   555: aload 8
    //   557: ldc_w 596
    //   560: ldc_w 1393
    //   563: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   566: pop
    //   567: aload 8
    //   569: ldc_w 1513
    //   572: ldc_w 1526
    //   575: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   578: pop
    //   579: aload_0
    //   580: aload_0
    //   581: getfield 212	obw:apC	Ljava/lang/String;
    //   584: iconst_1
    //   585: anewarray 235	java/lang/String
    //   588: dup
    //   589: iconst_0
    //   590: aload 8
    //   592: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   595: aastore
    //   596: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   599: aload_0
    //   600: ldc 192
    //   602: putfield 212	obw:apC	Ljava/lang/String;
    //   605: aconst_null
    //   606: ldc 247
    //   608: ldc 249
    //   610: ldc 192
    //   612: ldc_w 1524
    //   615: ldc_w 1524
    //   618: iconst_0
    //   619: iconst_0
    //   620: ldc_w 264
    //   623: ldc 192
    //   625: ldc 192
    //   627: ldc 192
    //   629: invokestatic 256	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   632: return
    //   633: iload_2
    //   634: bipush 113
    //   636: if_icmpne +136 -> 772
    //   639: iconst_m1
    //   640: istore 4
    //   642: iload_3
    //   643: iconst_m1
    //   644: if_icmpne +6 -> 650
    //   647: iconst_0
    //   648: istore 4
    //   650: aload_1
    //   651: ifnull -511 -> 140
    //   654: aload_1
    //   655: ldc_w 2068
    //   658: invokevirtual 561	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   661: astore 7
    //   663: aload_1
    //   664: ldc_w 2072
    //   667: invokevirtual 561	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   670: astore 8
    //   672: aload_1
    //   673: ldc_w 382
    //   676: iconst_1
    //   677: invokevirtual 572	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   680: istore 5
    //   682: aload 7
    //   684: ifnull +63 -> 747
    //   687: aload 8
    //   689: ifnull +58 -> 747
    //   692: new 365	org/json/JSONObject
    //   695: dup
    //   696: invokespecial 589	org/json/JSONObject:<init>	()V
    //   699: astore_1
    //   700: aload_1
    //   701: ldc_w 1840
    //   704: aload 8
    //   706: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   709: pop
    //   710: aload_1
    //   711: ldc_w 591
    //   714: iload 4
    //   716: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   719: pop
    //   720: aload_1
    //   721: ldc_w 382
    //   724: iload 5
    //   726: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   729: pop
    //   730: aload_0
    //   731: aload 7
    //   733: iconst_1
    //   734: anewarray 235	java/lang/String
    //   737: dup
    //   738: iconst_0
    //   739: aload_1
    //   740: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   743: aastore
    //   744: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   747: getstatic 2487	odg$d:a	Lodg$d;
    //   750: astore_1
    //   751: iload_3
    //   752: iconst_m1
    //   753: if_icmpne +13 -> 766
    //   756: iconst_1
    //   757: istore 6
    //   759: aload_1
    //   760: iload 6
    //   762: invokevirtual 2490	odg$d:nV	(Z)V
    //   765: return
    //   766: iconst_0
    //   767: istore 6
    //   769: goto -10 -> 759
    //   772: iload_2
    //   773: bipush 114
    //   775: if_icmpeq +21 -> 796
    //   778: iload_2
    //   779: bipush 115
    //   781: if_icmpeq +15 -> 796
    //   784: iload_2
    //   785: bipush 116
    //   787: if_icmpeq +9 -> 796
    //   790: iload_2
    //   791: bipush 122
    //   793: if_icmpne +294 -> 1087
    //   796: aload_1
    //   797: ifnull -657 -> 140
    //   800: aload_1
    //   801: ldc_w 335
    //   804: invokevirtual 561	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   807: astore 9
    //   809: aload 9
    //   811: invokestatic 567	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   814: ifne -674 -> 140
    //   817: ldc 192
    //   819: astore 8
    //   821: aload 8
    //   823: astore 7
    //   825: iload_2
    //   826: tableswitch	default:+50 -> 876, 114:+152->978, 115:+160->986, 116:+168->994, 117:+54->880, 118:+54->880, 119:+54->880, 120:+54->880, 121:+54->880, 122:+176->1002
    //   877: iconst_5
    //   878: astore 7
    //   880: iload_3
    //   881: iconst_m1
    //   882: if_icmpne +128 -> 1010
    //   885: aload_1
    //   886: ldc_w 2492
    //   889: invokevirtual 561	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   892: astore_1
    //   893: aload_1
    //   894: ifnull -754 -> 140
    //   897: new 365	org/json/JSONObject
    //   900: dup
    //   901: aload_1
    //   902: invokespecial 610	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   905: astore_1
    //   906: aload_1
    //   907: ldc_w 591
    //   910: iconst_0
    //   911: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   914: pop
    //   915: aload_1
    //   916: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   919: astore_1
    //   920: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   923: ifeq +38 -> 961
    //   926: ldc_w 424
    //   929: iconst_2
    //   930: new 426	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   937: aload 7
    //   939: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc_w 2494
    //   945: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload_1
    //   949: invokestatic 2499	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eS	(Ljava/lang/String;)Ljava/lang/String;
    //   952: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   958: invokestatic 467	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   961: aload_0
    //   962: aload 9
    //   964: iconst_1
    //   965: anewarray 235	java/lang/String
    //   968: dup
    //   969: iconst_0
    //   970: aload_1
    //   971: aastore
    //   972: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   975: return
    //   976: astore_1
    //   977: return
    //   978: ldc_w 2159
    //   981: astore 7
    //   983: goto -103 -> 880
    //   986: ldc_w 2171
    //   989: astore 7
    //   991: goto -111 -> 880
    //   994: ldc_w 2182
    //   997: astore 7
    //   999: goto -119 -> 880
    //   1002: ldc_w 2501
    //   1005: astore 7
    //   1007: goto -127 -> 880
    //   1010: new 365	org/json/JSONObject
    //   1013: dup
    //   1014: invokespecial 589	org/json/JSONObject:<init>	()V
    //   1017: astore_1
    //   1018: aload_1
    //   1019: ldc_w 591
    //   1022: iconst_m1
    //   1023: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1026: pop
    //   1027: aload_1
    //   1028: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1031: astore_1
    //   1032: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1035: ifeq +35 -> 1070
    //   1038: ldc_w 424
    //   1041: iconst_2
    //   1042: new 426	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1049: aload 7
    //   1051: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: ldc_w 2494
    //   1057: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: aload_1
    //   1061: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 467	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1070: aload_0
    //   1071: aload 9
    //   1073: iconst_1
    //   1074: anewarray 235	java/lang/String
    //   1077: dup
    //   1078: iconst_0
    //   1079: aload_1
    //   1080: aastore
    //   1081: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1084: return
    //   1085: astore_1
    //   1086: return
    //   1087: iload_2
    //   1088: bipush 118
    //   1090: if_icmpeq +9 -> 1099
    //   1093: iload_2
    //   1094: bipush 121
    //   1096: if_icmpne +426 -> 1522
    //   1099: ldc 192
    //   1101: astore 8
    //   1103: aload 8
    //   1105: astore 7
    //   1107: iload_2
    //   1108: tableswitch	default:+32 -> 1140, 118:+136->1244, 119:+36->1144, 120:+36->1144, 121:+144->1252
    //   1141: iconst_5
    //   1142: astore 7
    //   1144: aload_1
    //   1145: ifnonnull +115 -> 1260
    //   1148: iload_3
    //   1149: ifne -1009 -> 140
    //   1152: new 365	org/json/JSONObject
    //   1155: dup
    //   1156: invokespecial 589	org/json/JSONObject:<init>	()V
    //   1159: astore_1
    //   1160: aload_1
    //   1161: ldc_w 591
    //   1164: iconst_1
    //   1165: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1168: pop
    //   1169: aload_1
    //   1170: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1173: astore_1
    //   1174: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1177: ifeq +33 -> 1210
    //   1180: ldc_w 424
    //   1183: iconst_2
    //   1184: new 426	java/lang/StringBuilder
    //   1187: dup
    //   1188: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1191: ldc_w 2503
    //   1194: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: aload_1
    //   1198: invokestatic 2499	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eS	(Ljava/lang/String;)Ljava/lang/String;
    //   1201: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: invokestatic 467	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1210: aload_0
    //   1211: aload 7
    //   1213: iconst_1
    //   1214: anewarray 235	java/lang/String
    //   1217: dup
    //   1218: iconst_0
    //   1219: aload_1
    //   1220: aastore
    //   1221: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1224: return
    //   1225: astore_1
    //   1226: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1229: ifeq -1089 -> 140
    //   1232: ldc_w 424
    //   1235: iconst_2
    //   1236: aload_1
    //   1237: invokestatic 523	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1240: invokestatic 666	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1243: return
    //   1244: getstatic 1593	obw:apx	Ljava/lang/String;
    //   1247: astore 7
    //   1249: goto -105 -> 1144
    //   1252: getstatic 1632	obw:apy	Ljava/lang/String;
    //   1255: astore 7
    //   1257: goto -113 -> 1144
    //   1260: aload 7
    //   1262: invokestatic 567	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1265: ifne -1125 -> 140
    //   1268: iload_3
    //   1269: iconst_m1
    //   1270: if_icmpne +161 -> 1431
    //   1273: aload_1
    //   1274: ldc_w 2505
    //   1277: invokevirtual 2509	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1280: astore 8
    //   1282: aload 8
    //   1284: ifnull -1144 -> 140
    //   1287: aload 8
    //   1289: ldc_w 591
    //   1292: invokevirtual 2510	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1295: istore_3
    //   1296: aload 8
    //   1298: ldc_w 1102
    //   1301: invokevirtual 1184	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1304: astore_1
    //   1305: aload 8
    //   1307: ldc_w 596
    //   1310: invokevirtual 1184	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1313: astore 8
    //   1315: new 365	org/json/JSONObject
    //   1318: dup
    //   1319: invokespecial 589	org/json/JSONObject:<init>	()V
    //   1322: astore 9
    //   1324: aload 9
    //   1326: ldc_w 591
    //   1329: iload_3
    //   1330: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1333: pop
    //   1334: aload 9
    //   1336: ldc_w 1102
    //   1339: aload_1
    //   1340: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1343: pop
    //   1344: aload 9
    //   1346: ldc_w 596
    //   1349: aload 8
    //   1351: invokevirtual 599	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1354: pop
    //   1355: aload 9
    //   1357: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1360: astore_1
    //   1361: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1364: ifeq +33 -> 1397
    //   1367: ldc_w 424
    //   1370: iconst_2
    //   1371: new 426	java/lang/StringBuilder
    //   1374: dup
    //   1375: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1378: ldc_w 2503
    //   1381: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: aload_1
    //   1385: invokestatic 2499	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eS	(Ljava/lang/String;)Ljava/lang/String;
    //   1388: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokestatic 467	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1397: aload_0
    //   1398: aload 7
    //   1400: iconst_1
    //   1401: anewarray 235	java/lang/String
    //   1404: dup
    //   1405: iconst_0
    //   1406: aload_1
    //   1407: aastore
    //   1408: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1411: return
    //   1412: astore_1
    //   1413: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1416: ifeq -1276 -> 140
    //   1419: ldc_w 424
    //   1422: iconst_2
    //   1423: aload_1
    //   1424: invokestatic 523	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1427: invokestatic 666	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1430: return
    //   1431: new 365	org/json/JSONObject
    //   1434: dup
    //   1435: invokespecial 589	org/json/JSONObject:<init>	()V
    //   1438: astore_1
    //   1439: aload_1
    //   1440: ldc_w 591
    //   1443: iconst_m1
    //   1444: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1447: pop
    //   1448: aload_1
    //   1449: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1452: astore_1
    //   1453: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1456: ifeq +30 -> 1486
    //   1459: ldc_w 424
    //   1462: iconst_2
    //   1463: new 426	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1470: ldc_w 2512
    //   1473: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: aload_1
    //   1477: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: invokestatic 467	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1486: aload_0
    //   1487: aload_0
    //   1488: getfield 2445	obw:callback	Ljava/lang/String;
    //   1491: iconst_1
    //   1492: anewarray 235	java/lang/String
    //   1495: dup
    //   1496: iconst_0
    //   1497: aload_1
    //   1498: aastore
    //   1499: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1502: return
    //   1503: astore_1
    //   1504: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1507: ifeq -1367 -> 140
    //   1510: ldc_w 424
    //   1513: iconst_2
    //   1514: aload_1
    //   1515: invokestatic 523	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1518: invokestatic 666	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1521: return
    //   1522: iload_2
    //   1523: bipush 117
    //   1525: if_icmpne +188 -> 1713
    //   1528: aload_1
    //   1529: ifnull -1389 -> 140
    //   1532: aload_1
    //   1533: ldc_w 335
    //   1536: invokevirtual 561	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1539: astore 7
    //   1541: aload 7
    //   1543: invokestatic 567	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1546: ifne -1406 -> 140
    //   1549: iload_3
    //   1550: sipush 1699
    //   1553: if_icmpne +46 -> 1599
    //   1556: new 299	android/os/Bundle
    //   1559: dup
    //   1560: invokespecial 300	android/os/Bundle:<init>	()V
    //   1563: astore 8
    //   1565: aload 8
    //   1567: ldc_w 2514
    //   1570: aload_1
    //   1571: invokevirtual 2518	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1574: invokestatic 2523	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   1577: ldc_w 2525
    //   1580: ldc_w 2527
    //   1583: aload 8
    //   1585: new 2529	oci
    //   1588: dup
    //   1589: aload_0
    //   1590: aload 7
    //   1592: invokespecial 2530	oci:<init>	(Lobw;Ljava/lang/String;)V
    //   1595: invokevirtual 2534	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   1598: return
    //   1599: aload_1
    //   1600: ldc_w 2492
    //   1603: invokevirtual 561	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1606: astore_1
    //   1607: aload_1
    //   1608: ifnull +82 -> 1690
    //   1611: new 365	org/json/JSONObject
    //   1614: dup
    //   1615: aload_1
    //   1616: invokespecial 610	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1619: astore_1
    //   1620: iload_3
    //   1621: iconst_m1
    //   1622: if_icmpne +79 -> 1701
    //   1625: aload_1
    //   1626: ldc_w 591
    //   1629: iconst_0
    //   1630: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1633: pop
    //   1634: aload_1
    //   1635: invokevirtual 600	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1638: astore_1
    //   1639: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1642: ifeq +33 -> 1675
    //   1645: ldc_w 424
    //   1648: iconst_2
    //   1649: new 426	java/lang/StringBuilder
    //   1652: dup
    //   1653: invokespecial 427	java/lang/StringBuilder:<init>	()V
    //   1656: ldc_w 2536
    //   1659: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: aload_1
    //   1663: invokestatic 2499	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eS	(Ljava/lang/String;)Ljava/lang/String;
    //   1666: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: invokevirtual 461	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1672: invokestatic 467	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1675: aload_0
    //   1676: aload 7
    //   1678: iconst_1
    //   1679: anewarray 235	java/lang/String
    //   1682: dup
    //   1683: iconst_0
    //   1684: aload_1
    //   1685: aastore
    //   1686: invokevirtual 604	obw:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1689: return
    //   1690: new 365	org/json/JSONObject
    //   1693: dup
    //   1694: invokespecial 589	org/json/JSONObject:<init>	()V
    //   1697: astore_1
    //   1698: goto -78 -> 1620
    //   1701: aload_1
    //   1702: ldc_w 591
    //   1705: iconst_m1
    //   1706: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1709: pop
    //   1710: goto -76 -> 1634
    //   1713: iload_2
    //   1714: bipush 119
    //   1716: if_icmpne -1576 -> 140
    //   1719: aload_0
    //   1720: aload_1
    //   1721: invokespecial 2538	obw:aV	(Landroid/content/Intent;)V
    //   1724: return
    //   1725: astore_1
    //   1726: goto -979 -> 747
    //   1729: iconst_0
    //   1730: istore_3
    //   1731: goto -1263 -> 468
    //   1734: astore_1
    //   1735: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1736	0	this	obw
    //   0	1736	1	paramIntent	Intent
    //   0	1736	2	paramByte	byte
    //   0	1736	3	paramInt	int
    //   640	75	4	i	int
    //   680	45	5	j	int
    //   757	11	6	bool	boolean
    //   23	1654	7	localObject1	Object
    //   141	3	8	localJSONException	JSONException
    //   193	1391	8	localObject2	Object
    //   327	1029	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	47	141	org/json/JSONException
    //   63	73	151	org/json/JSONException
    //   199	225	226	org/json/JSONException
    //   232	304	226	org/json/JSONException
    //   349	357	417	org/json/JSONException
    //   357	416	417	org/json/JSONException
    //   429	440	417	org/json/JSONException
    //   446	467	417	org/json/JSONException
    //   468	527	417	org/json/JSONException
    //   534	632	417	org/json/JSONException
    //   897	961	976	java/lang/Exception
    //   961	975	976	java/lang/Exception
    //   1010	1070	1085	java/lang/Exception
    //   1070	1084	1085	java/lang/Exception
    //   1152	1210	1225	java/lang/Exception
    //   1210	1224	1225	java/lang/Exception
    //   1315	1397	1412	java/lang/Exception
    //   1397	1411	1412	java/lang/Exception
    //   1431	1486	1503	java/lang/Exception
    //   1486	1502	1503	java/lang/Exception
    //   700	747	1725	java/lang/Exception
    //   1611	1620	1734	java/lang/Exception
    //   1625	1634	1734	java/lang/Exception
    //   1634	1675	1734	java/lang/Exception
    //   1675	1689	1734	java/lang/Exception
    //   1690	1698	1734	java/lang/Exception
    //   1701	1710	1734	java/lang/Exception
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.app = this.mRuntime.a();
      this.activity = this.mRuntime.getActivity();
      this.uin = this.app.getAccount();
    }
    init();
  }
  
  public void onDestroy()
  {
    if (this.mRuntime != null)
    {
      CustomWebView localCustomWebView = this.mRuntime.getWebView();
      if (localCustomWebView != null) {
        pf(localCustomWebView.getUrl());
      }
    }
    super.onDestroy();
    if (this.ac.get())
    {
      bdy();
      if (this.mClient != null) {
        this.mClient.bzk();
      }
      bh().clear();
      if (this.jdField_a_of_type_Obu != null) {
        this.jdField_a_of_type_Obu.bdo();
      }
    }
    if (this.jdField_a_of_type_Mzl != null)
    {
      this.jdField_a_of_type_Mzl.destory();
      this.jdField_a_of_type_Mzl = null;
    }
  }
  
  protected void onPause()
  {
    if (this.jdField_a_of_type_Obu != null) {
      this.jdField_a_of_type_Obu.bdo();
    }
  }
  
  void pf(String paramString)
  {
    this.pUin = "";
    if (paramString != null) {
      eW.remove(paramString);
    }
  }
  
  public void ph(String paramString)
  {
    if (this.activity == null) {
      return;
    }
    Intent localIntent = new Intent(this.activity, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("fromBrowser", true);
    this.activity.startActivity(localIntent);
  }
  
  void pi(String paramString)
  {
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.ma.iterator();
      while (localIterator.hasNext())
      {
        obw.b localb = (obw.b)localIterator.next();
        if (paramString.equals(localb.apI)) {
          localArrayList.add(localb);
        }
      }
      this.ma.removeAll(localArrayList);
    }
    if (this.ma.size() > 0)
    {
      paramString = (obw.b)this.ma.get(0);
      b(paramString.apI, paramString.bek, true, paramString.callback);
    }
  }
  
  public void qw(boolean paramBoolean)
  {
    if (paramBoolean) {
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.mRuntime.b() != null) {
        this.mRuntime.b().Td(paramBoolean);
      }
      return;
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
    }
  }
  
  void showProgressDialog()
  {
    try
    {
      if (this.e != null) {
        cancleProgressDailog();
      }
      while (!this.e.isShowing())
      {
        this.e.show();
        return;
        this.e = new ReportProgressDialog(this.activity, 2131756467);
        this.e.setCancelable(true);
        this.e.show();
        this.e.setContentView(2131559761);
        TextView localTextView = (TextView)this.e.findViewById(2131373180);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public class a
    extends lce
  {
    final String callback;
    final int feedsType;
    
    public a(String paramString, int paramInt)
    {
      this.callback = paramString;
      this.feedsType = paramInt;
    }
    
    public void h(long paramLong, int paramInt, String paramString)
    {
      super.h(paramLong, paramInt, paramString);
      QLog.d("PublicAccountH5AbilityPlugin", 2, "[onBiuResult] " + paramLong + " " + paramInt + " errorMsg");
      try
      {
        paramString = new JSONObject();
        paramString.put("feedsId", String.valueOf(paramLong));
        paramString.put("retCode", paramInt);
        paramString.put("feedsType", this.feedsType);
        obw.this.callJs(this.callback, new String[] { paramString.toString() });
        ThreadManager.getUIHandler().post(new PublicAccountH5AbilityPlugin.BiuObserver.1(this));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("PublicAccountH5AbilityPlugin", 1, "[onBiuResult] ", paramString);
      }
    }
  }
  
  static class b
  {
    String apI;
    int bek;
    String callback;
  }
  
  static class c
  {
    int bek;
    String callback;
    String localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obw
 * JD-Core Version:    0.7.0.1
 */