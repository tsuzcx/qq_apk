import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.capture.data.QIMBeautyItem;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class rpw
{
  public static String aBz = "{\"appName\":\"微视\",\"appid\":\"1101083114 \",\"isAutoDownload\":\"1\",\"isAutoInstall\":\"1\",\"isAutoInstallBySDK\":1,\"isShowNotification\":\"1\",\"packageName\":\"com.tencent.weishi\",\"url\":\"https://qzs.qzone.qq.com/qzone/qzact/act/external/weishi/weishi-download/index.html?pkg=3006\",\"via\":\"ANDROIDQQ.FEED\"}";
  
  private static DownloadInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localDownloadInfo.appId = localJSONObject.getString("appid");
      localDownloadInfo.urlStr = localJSONObject.getString("url");
      localDownloadInfo.packageName = localJSONObject.getString("packageName");
      localDownloadInfo.via = localJSONObject.getString("via");
      localDownloadInfo.isAutoInstall = true;
      localDownloadInfo.isAutoInstallBySDK = true;
      localDownloadInfo.ell = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
      String str = localJSONObject.getString("isAutoInstall");
      if (str != null) {
        localDownloadInfo.isAutoInstall = str.equals("1");
      }
      str = localJSONObject.getString("isAutoInstallBySDK");
      if (str != null) {
        localDownloadInfo.isAutoInstallBySDK = str.equals("1");
      }
      str = localJSONObject.getString("isShowNotification");
      if (str != null) {
        if (!str.equals("1")) {
          break label186;
        }
      }
      label186:
      for (int i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;; i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE)
      {
        localDownloadInfo.ell = i;
        localDownloadInfo.ddw = true;
        localDownloadInfo.source = "biz_src_jc_qzone";
        localDownloadInfo.pushTitle = localJSONObject.getString("appName");
        return localDownloadInfo;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("WeishiGuideUtils", 4, "json err:" + paramString);
    }
  }
  
  public static rpw.a a(Object paramObject)
  {
    int k = 1;
    String str1 = "1";
    String str3 = "";
    String str2 = "5";
    String str4 = "";
    int j = 0;
    rpw.a locala = null;
    Object localObject = "";
    if (paramObject != null) {
      if ((paramObject instanceof QIMFilterCategoryItem))
      {
        localObject = (QIMFilterCategoryItem)paramObject;
        if (((QIMFilterCategoryItem)localObject).dwd)
        {
          str3 = ((QIMFilterCategoryItem)localObject).name;
          paramObject = ((QIMFilterCategoryItem)localObject).aBF;
          if (!((QIMFilterCategoryItem)localObject).isDovItem()) {
            break label471;
          }
        }
      }
    }
    label461:
    label466:
    label471:
    for (int i = 2;; i = 1)
    {
      str4 = "1";
      str1 = "2";
      str2 = "7";
      localObject = "clk_combo";
      j = 1;
      if (aqmr.isEmpty(paramObject))
      {
        paramObject = "weishi://camera?logsour=3006";
        i = k;
        label105:
        locala = new rpw.a();
        locala.aBA = str1;
        locala.aBB = str3;
        locala.aBC = str2;
        locala.btX = i;
        locala.aBE = str4;
        locala.aBF = paramObject;
        locala.aBG = ((String)localObject);
        locala.btY = j;
        if (i == 2)
        {
          locala.aBD = "DOV";
          return locala;
          str1 = "11";
          str3 = ((QIMFilterCategoryItem)localObject).name;
          paramObject = ((QIMFilterCategoryItem)localObject).aBF;
          str2 = "11";
          if (!((QIMFilterCategoryItem)localObject).isDovItem()) {
            break label466;
          }
        }
      }
      for (i = 2;; i = 1)
      {
        j = 0;
        str4 = "11";
        localObject = "clk_filter";
        break;
        if ((paramObject instanceof MusicItemInfo))
        {
          paramObject = (MusicItemInfo)paramObject;
          str1 = "4";
          str3 = paramObject.mMusicName;
          paramObject = paramObject.jumpWs;
          str2 = "9";
          localObject = "clk_music";
          str4 = "2";
          i = 1;
          j = 2;
          break;
        }
        if ((paramObject instanceof PtvTemplateManager.PtvTemplateInfo))
        {
          localObject = (PtvTemplateManager.PtvTemplateInfo)paramObject;
          str1 = "3";
          str3 = ((PtvTemplateManager.PtvTemplateInfo)localObject).name;
          paramObject = ((PtvTemplateManager.PtvTemplateInfo)localObject).jump_app;
          str2 = "8";
          if (!((PtvTemplateManager.PtvTemplateInfo)localObject).isDovItem()) {
            break label461;
          }
        }
        for (i = 2;; i = 1)
        {
          j = 3;
          str4 = "3";
          localObject = "clk_poster";
          break;
          if ((paramObject instanceof PressDarkImageButton))
          {
            str1 = "5";
            i = 1;
            paramObject = locala;
            break;
          }
          if ((paramObject instanceof String))
          {
            str1 = "1";
            str3 = "";
            paramObject = (String)paramObject;
            str2 = "6";
            i = 1;
            break;
          }
          if ((paramObject instanceof QIMBeautyItem))
          {
            localObject = (QIMBeautyItem)paramObject;
            str1 = "10";
            str3 = ((QIMBeautyItem)localObject).name;
            paramObject = ((QIMBeautyItem)localObject).aBF;
            str2 = "10";
            if (((QIMBeautyItem)localObject).isDovItem()) {}
            for (i = 2;; i = 1)
            {
              str4 = "10";
              localObject = "clk_beauty";
              break;
              locala.aBD = acfp.m(2131716914);
              return locala;
              break label105;
            }
          }
          i = 1;
          paramObject = locala;
          break;
        }
      }
    }
  }
  
  public static rrt a(Context paramContext, Object paramObject)
  {
    rpw.a locala = a(paramObject);
    if (locala == null) {
      return null;
    }
    String str1 = locala.aBA;
    String str2 = locala.aBB;
    String str3 = locala.aBF;
    int j = locala.btX;
    String str4 = locala.aBE;
    int k = locala.btY;
    int i;
    int m;
    if (((paramContext instanceof EditPicActivity)) || ((paramContext instanceof EditVideoActivity)))
    {
      i = 1;
      if (!(paramContext instanceof Activity)) {
        break label570;
      }
      paramObject = ((Activity)paramContext).getIntent();
      if (paramObject == null) {
        break label564;
      }
      m = paramObject.getIntExtra("entrance_type", 0);
      if (m != 1) {
        break label179;
      }
      paramObject = "biz_src_jc_hyws";
      label108:
      if (!(paramContext instanceof QIMCameraCaptureActivity)) {
        break label200;
      }
      paramObject = "biz_src_jc_camera";
    }
    for (;;)
    {
      label119:
      if (j == 2)
      {
        if (aqiz.isAppInstalled(paramContext, "com.tencent.qim"))
        {
          anot.a(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 1, str4, "dov", "", "");
          aqiz.r(paramContext, "com.tencent.qim", null);
        }
        for (;;)
        {
          return null;
          i = 0;
          break;
          if ((m != 120) && (m != 121)) {
            break label564;
          }
          paramObject = "biz_src_jc_story";
          break label108;
          if (!(paramContext instanceof EditVideoActivity)) {
            break label561;
          }
          paramObject = "biz_src_jc_editor";
          break label119;
          anot.a(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 0, str4, "dov", "", "");
          qev.cB(paramContext);
        }
      }
      label179:
      label200:
      if ("biz_src_jc_hyws".equals(paramObject)) {
        if (!isWeishiInstalled(paramContext)) {
          break label451;
        }
      }
      label451:
      for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
      {
        anot.a(null, "dc00898", "", "", "weishi_share_shoot", (String)localObject, k, 0, "", "", "", "");
        anot.a(null, "dc00899", "grp_story", "", "weishi_share", locala.aBG, 0, 0, str1, str2, "", "");
        if (!isWeishiInstalled(paramContext)) {
          break;
        }
        anot.a(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 1, str4, "weishi", "", "");
        anot.a(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 1, str1, str2, "", "");
        if (paramContext != null)
        {
          localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          ((Intent)localObject).setData(Uri.parse(str3));
          if (!TextUtils.isEmpty(paramObject)) {
            ((Intent)localObject).putExtra("big_brother_source_key", paramObject);
          }
          paramContext.startActivity((Intent)localObject);
        }
        return null;
      }
      anot.a(null, "dc00899", "grp_story", "", "app_share", "clk_entry", i, 0, str4, "weishi", "", "");
      localObject = locala.aBC;
      anot.a(null, "dc00899", "grp_story", "", "weishi_share", "clk_ws", 0, 2, str1, str2, "", "");
      paramContext = new rrt(paramContext, 2131756780, paramObject);
      paramContext.a("https://pub.idqqimg.com/pc/misc/files/20180423/4c3ece054ae044eb85797d31fa487ce7.jpg");
      paramContext.a("", (String)localObject, "");
      paramContext.show();
      return paramContext;
      label561:
      continue;
      label564:
      paramObject = "";
      break label108;
      label570:
      paramObject = "";
    }
  }
  
  public static void aU(Context paramContext, String paramString)
  {
    if (!rpc.ak(paramContext))
    {
      QQToast.a(paramContext, acfp.m(2131716916), 0).show();
      return;
    }
    ayzr.a().anq();
    DownloadInfo localDownloadInfo = a(aBz);
    if (localDownloadInfo == null)
    {
      ram.w("WeishiGuideUtils", "get null info");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("gotoWeishiDownload", 2, " gotoWeishiDownload = " + localDownloadInfo.urlStr);
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", localDownloadInfo.urlStr);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("big_brother_source_key", paramString);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void aq(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject == null) {}
    int i;
    int j;
    do
    {
      return;
      i = paramObject.btX;
      j = paramObject.btY;
    } while (i != 1);
    anot.a(null, "dc00898", "", "", "weishi_share_shoot", "story_entry_exp", j, 0, "", "", "", "");
  }
  
  public static boolean isWeishiInstalled(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return ausc.bb(paramContext, "com.tencent.weishi");
  }
  
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    String str;
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("no")))
    {
      str = paramString2;
      if (!paramString2.equals("default")) {}
    }
    else
    {
      str = "weishi://main?goto=recommend&logsour=3006";
    }
    paramString2 = new Intent();
    paramString2.setAction("android.intent.action.VIEW");
    paramString2.setData(Uri.parse(str));
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2.putExtra("big_brother_source_key", paramString1);
    }
    if (!(paramContext instanceof Activity)) {
      paramString2.addFlags(268435456);
    }
    paramContext.startActivity(paramString2);
  }
  
  public static class a
  {
    String aBA;
    String aBB;
    String aBC;
    public String aBD;
    String aBE;
    public String aBF;
    public String aBG;
    int btX;
    int btY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpw
 * JD-Core Version:    0.7.0.1
 */