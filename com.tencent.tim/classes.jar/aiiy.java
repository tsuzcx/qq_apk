import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.activity.TeamWorkPicBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.jsp.DocxApiPlugin.10;
import com.tencent.mobileqq.jsp.DocxApiPlugin.2;
import com.tencent.mobileqq.jsp.DocxApiPlugin.3;
import com.tencent.mobileqq.jsp.DocxApiPlugin.4;
import com.tencent.mobileqq.jsp.DocxApiPlugin.5;
import com.tencent.mobileqq.jsp.DocxApiPlugin.6;
import com.tencent.mobileqq.jsp.DocxApiPlugin.7;
import com.tencent.mobileqq.jsp.DocxApiPlugin.8;
import com.tencent.mobileqq.jsp.DocxApiPlugin.9;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.Pair;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aiiy
  extends WebViewPlugin
{
  private afdi jdField_a_of_type_Afdi;
  private afdp jdField_a_of_type_Afdp;
  private afdm b;
  private String bNX;
  
  public aiiy()
  {
    this.mPluginNameSpace = "docx";
  }
  
  private void Lr(String paramString)
  {
    QLog.d("DocxApiPlugin", 2, "req json = " + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.bNX = paramString.optString("callback");
      new TeamWorkForceShare(this, paramString).azD();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, TouchWebView paramTouchWebView)
  {
    if (!aeuk.a().aia()) {}
    while ((TextUtils.isEmpty(paramString)) || (aocb.nL == null) || (aocb.nL.get(paramString) == null) || (((Integer)aocb.nL.get(paramString)).intValue() != 2)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("retcode", 1);
        ThreadManager.getUIHandler().post(new DocxApiPlugin.7(paramTouchWebView, paramString));
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("DocxApiPlugin", 1, "JSONException ", paramString);
        return;
      }
    }
    aocb.nL.remove(paramString);
    if (aobh.pM(paramString))
    {
      ThreadManager.excute(new DocxApiPlugin.8(paramString, paramTouchWebView), 64, null, false);
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("retcode", 1);
      ThreadManager.getUIHandler().post(new DocxApiPlugin.9(paramTouchWebView, paramString));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("DocxApiPlugin", 1, "JSONException ", paramString);
    }
  }
  
  private void dsF()
  {
    ThreadManager.excute(new DocxApiPlugin.6(this), 64, null, false);
  }
  
  private void ex(ArrayList<String> paramArrayList)
  {
    ThreadManager.excute(new DocxApiPlugin.5(this, paramArrayList), 128, null, false);
  }
  
  public void Ll(String paramString)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        boolean bool = localJSONObject.optBoolean("success");
        String str2 = localJSONObject.optString("url");
        paramString = localJSONObject.optString("fileName");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isSuccess", bool);
        localBundle.putString("url", str2);
        localBundle.putString("fileName", paramString);
        paramString = this.mRuntime.getActivity();
        if ((!(paramString instanceof TeamWorkDocEditBrowserActivity)) || (((TeamWorkDocEditBrowserActivity)paramString).b() == null)) {
          break label203;
        }
        paramString = ((TeamWorkDocEditBrowserActivity)paramString).b().getUrl();
        String str1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str1 = localJSONObject.optString("refer_url");
        }
        localBundle.putString("docUrl", str1);
        localBundle.putString("cookie", CookieManager.getInstance().getCookie(str2));
        QIPCClientHelper.getInstance().getClient().callServer("TeamWorkModule", "action_download_export_file", localBundle);
      }
      catch (Exception paramString)
      {
        QLog.e("DocxApiPlugin", 1, "downloadExportedFile exception e = " + paramString.toString());
        continue;
      }
      finally {}
      return;
      label203:
      paramString = null;
    }
  }
  
  public void Lm(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        boolean bool = ((JSONObject)localObject).optBoolean("success");
        String str2 = ((JSONObject)localObject).optString("url");
        String str3 = ((JSONObject)localObject).optString("fileName");
        paramString = this.mRuntime.getActivity();
        if ((!(paramString instanceof TeamWorkDocEditBrowserActivity)) || (((TeamWorkDocEditBrowserActivity)paramString).b() == null)) {
          break label218;
        }
        paramString = ((TeamWorkDocEditBrowserActivity)paramString).b().getUrl();
        String str1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str1 = ((JSONObject)localObject).optString("refer_url");
        }
        paramString = CookieManager.getInstance().getCookie(str2);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isSuccess", bool);
        ((Bundle)localObject).putString("url", str2);
        ((Bundle)localObject).putString("fileName", str3);
        ((Bundle)localObject).putString("docUrl", str1);
        ((Bundle)localObject).putString("cookie", paramString);
        ((Bundle)localObject).putBoolean("isMiniProgram", false);
        aoal.a(this.mRuntime.getActivity(), aoal.a(str3), (Bundle)localObject);
      }
      catch (Exception paramString)
      {
        QLog.e("DocxApiPlugin", 1, "openDownloadExportedFile exception e = " + paramString.toString());
        continue;
      }
      finally {}
      return;
      label218:
      paramString = null;
    }
  }
  
  public void Ln(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("fileName");
      new Bundle().putString("fileName", paramString);
      aoal.M(this.mRuntime.getActivity(), paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("DocxApiPlugin", 1, "startExportedFile exception e = " + paramString.toString());
      }
    }
    finally {}
  }
  
  public void Lo(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("folderId");
      QQBrowserActivity localQQBrowserActivity = (QQBrowserActivity)this.mRuntime.getActivity();
      ThreadManager.postImmediately(new DocxApiPlugin.10(this, localQQBrowserActivity, localQQBrowserActivity.b().getUrl()), null, true);
      Intent localIntent = new Intent(localQQBrowserActivity, FMActivity.class);
      localIntent.putExtra(aoaf.cjs, true);
      localIntent.addFlags(536870912);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("busiType", 9);
      localIntent.putExtra("peerType", 10006);
      localIntent.putExtra("tab_tab_type", 7);
      localIntent.putExtra("only_show_local_tab", true);
      localIntent.putExtra(aoaf.cjt, paramString);
      localIntent.putExtra("smart_device_support_flag", 8);
      localQQBrowserActivity.startActivity(localIntent);
      localQQBrowserActivity.overridePendingTransition(2130771991, 2130771992);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("DocxApiPlugin", 1, "openFMActivityToImport exception e = " + paramString.toString());
      }
    }
    finally {}
  }
  
  void Lp(String paramString)
  {
    Object localObject1;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DocxApiPlugin", 2, "handleWriteClipboard jsonString = " + paramString);
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for empty json");
        return;
      }
      localObject1 = this.mRuntime.getActivity();
      if (localObject1 == null)
      {
        QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for null activity");
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("DocxApiPlugin", 1, "handleWriteClipboard exception", paramString);
      return;
    }
    paramString = new JSONObject(paramString);
    String str1 = paramString.optString("plain");
    String str2 = paramString.optString("html");
    if (QLog.isColorLevel()) {
      QLog.d("DocxApiPlugin", 2, "handleWriteClipboard text = " + str1 + ",html = " + str2);
    }
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
    {
      QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for empty text and html");
      return;
    }
    ClipboardManager localClipboardManager = (ClipboardManager)((Activity)localObject1).getSystemService("clipboard");
    Object localObject2 = null;
    ClipData.Item localItem;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localItem = new ClipData.Item(str1, str2);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        paramString = new String[2];
        paramString[0] = "text/plain";
        paramString[1] = "text/html";
        localObject1 = localItem;
      }
    }
    for (;;)
    {
      paramString = new ClipData("", paramString, (ClipData.Item)localObject1);
      alkw.a(localClipboardManager, paramString);
      localClipboardManager.setPrimaryClip(paramString);
      return;
      if ((!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
      {
        paramString = new String[1];
        paramString[0] = "text/plain";
        localObject1 = localItem;
      }
      else
      {
        paramString = localObject2;
        localObject1 = localItem;
        if (TextUtils.isEmpty(str1))
        {
          paramString = localObject2;
          localObject1 = localItem;
          if (!TextUtils.isEmpty(str2))
          {
            paramString = new String[1];
            paramString[0] = "text/html";
            localObject1 = localItem;
            continue;
            localObject1 = new ClipData.Item(str1);
            paramString = new String[1];
            paramString[0] = "text/plain";
          }
        }
      }
    }
  }
  
  void Lq(String paramString)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    String str;
    JSONObject localJSONObject;
    Object localObject4;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DocxApiPlugin", 2, "handleReadClipboard jsonString = " + paramString);
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard return for empty json");
        return;
      }
      str = new JSONObject(paramString).optString("callback");
      localJSONObject = new JSONObject();
      localObject4 = this.mRuntime.getActivity();
      if (localObject4 == null)
      {
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard return for null activity");
        callJs(str, new String[] { String.valueOf(-2), localJSONObject.toString() });
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("DocxApiPlugin", 1, "handleReadClipboard exception", localException);
      try
      {
        callJs(new JSONObject(paramString).optString("callback"), new String[] { String.valueOf(-3), new JSONObject().toString() });
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("DocxApiPlugin", 1, "handleReadClipboard Exception e1", paramString);
        return;
      }
      localObject4 = (ClipboardManager)((Activity)localObject4).getSystemService("clipboard");
      alkw.a((ClipboardManager)localObject4);
      localObject4 = ((ClipboardManager)localObject4).getPrimaryClip();
      if (QLog.isColorLevel()) {
        QLog.d("DocxApiPlugin", 2, "handleReadClipboard ClipData = " + localObject4);
      }
      if (localObject4 == null) {
        break label449;
      }
    }
    Object localObject2;
    if (((ClipData)localObject4).getItemCount() > 0)
    {
      localObject3 = ((ClipData)localObject4).getItemAt(0);
      localObject2 = ((ClipData.Item)localObject3).getText().toString();
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject4 = ((ClipData.Item)localObject3).getHtmlText();
        localObject3 = localObject2;
        localObject2 = localObject4;
        if (!QLog.isColorLevel()) {
          break label455;
        }
        QLog.d("DocxApiPlugin", 2, "handleReadClipboard text  = " + (String)localObject3 + ",html = " + (String)localObject2);
        break label455;
      }
    }
    label431:
    label449:
    label455:
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        i = 1;
        if (i != 0) {
          break label431;
        }
        localJSONObject.put("plain", localObject3);
        localJSONObject.put("html", localObject2);
      }
      for (int i = 0;; i = -1)
      {
        callJs(str, new String[] { String.valueOf(i), localJSONObject.toString() });
        return;
        i = 0;
        break;
      }
      localObject3 = localObject2;
      localObject2 = null;
      break;
      localObject2 = null;
      break;
      localObject3 = null;
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DocxApiPlugin", 2, "handleEvent " + paramString + ", type=" + paramLong + ", info=" + paramMap);
    }
    if (paramLong == 8589934601L)
    {
      if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null) || (!(this.mRuntime.getActivity() instanceof QQBrowserActivity)))
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent sth is null or not instanceof QQBrowserActivity");
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      if (!this.mRuntime.getActivity().getIntent().getBooleanExtra("doc_from_aio", false)) {
        QLog.e("DocxApiPlugin", 1, "handleEvent not fromAIO, url=" + paramString);
      }
      if (this.jdField_a_of_type_Afdi != null)
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent guide has shown");
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      Pair localPair = afdf.a(this.mRuntime.a());
      boolean bool = ((Boolean)localPair.first).booleanValue();
      int i = ((Integer)localPair.second).intValue();
      int j = afdj.a(this.mRuntime.a(), this.mRuntime.getActivity());
      if (QLog.isColorLevel()) {
        QLog.i("DocxApiPlugin", 2, "handleEvent enable=" + bool + ", total=" + i + ", shown=" + j);
      }
      if (!bool)
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent not enable");
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      if (j >= i)
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent shown >= total");
        return super.handleEvent(paramString, paramLong, paramMap);
      }
      this.jdField_a_of_type_Afdi = new afdi(this.mRuntime.getActivity());
      this.jdField_a_of_type_Afdi.a(new aiiz(this));
      afdj.a(this.mRuntime.a(), this.mRuntime.getActivity(), j + 1);
      try
      {
        this.jdField_a_of_type_Afdi.show();
        anot.a(null, "CliOper", "", "", "0X80094EA", "0X80094EA", 0, 0, "", "", "", "");
        return true;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DocxApiPlugin", 1, "", localThrowable);
        return super.handleEvent(paramString, paramLong, paramMap);
      }
    }
    if (paramLong == 8589934597L) {
      if (this.jdField_a_of_type_Afdp != null) {
        this.jdField_a_of_type_Afdp.stop();
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (paramLong != 8589934611L) {}
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DocxApiPlugin", 2, " handleJsRequest url = " + paramString1 + " pkgName = " + paramString2 + ",method = " + paramString3);
    }
    if ("docx".equals(paramString2))
    {
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if ((!"readyToInsertImageCallBack".equals(paramString3)) || (paramVarArgs.length > 1)) {}
    }
    else
    {
      try
      {
        if (paramVarArgs.length == 1)
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.getString("attachmentId");
          paramString1 = paramString1.getString("localpath");
          paramString2 = this.mRuntime.getActivity();
          if (QLog.isColorLevel()) {
            QLog.i("TeamWorkDocEditBrowserActivity", 2, "回调id = " + paramJsBridgeListener + " localPath = " + paramString1);
          }
          if ((paramString2 != null) && ((paramString2 instanceof TeamWorkDocEditBrowserActivity))) {
            ThreadManager.postImmediately(new DocxApiPlugin.2(this, paramString2, paramString1, paramJsBridgeListener), null, false);
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("DocxApiPlugin", 4, "readyToInsertImageCallBack failed:" + paramJsBridgeListener);
          }
        }
      }
      return false;
    }
    if (("getDocxImageIndex".equals(paramString3)) && (paramVarArgs.length <= 1)) {}
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
              try
              {
                if (paramVarArgs.length != 1) {
                  break;
                }
                paramString1 = new JSONObject(paramVarArgs[0]);
                paramJsBridgeListener = new ArrayList();
                if (!paramString1.has("currentImageIndex")) {
                  break label2124;
                }
                i = paramString1.getInt("currentImageIndex");
                if (paramString1.has("imageList"))
                {
                  paramString1 = paramString1.getJSONArray("imageList");
                  if (paramString1 != null)
                  {
                    j = 0;
                    if (j < paramString1.length())
                    {
                      paramJsBridgeListener.add((String)paramString1.get(j));
                      j += 1;
                      continue;
                    }
                  }
                }
                if (QLog.isColorLevel()) {
                  QLog.i("TeamWorkDocEditBrowserActivity", 2, " index = " + i + " urls.size = " + paramJsBridgeListener.size());
                }
                paramString1 = this.mRuntime.getActivity();
                if ((paramString1 == null) || (!(paramString1 instanceof TeamWorkDocEditBrowserActivity)) || (i == -1)) {
                  break;
                }
                paramString2 = new ArrayList();
                int j = 0;
                if (j < paramJsBridgeListener.size())
                {
                  paramString3 = new PicInfo();
                  paramString3.bSZ = ((String)paramJsBridgeListener.get(j));
                  paramString3.thumbUrl = ((String)paramJsBridgeListener.get(j));
                  paramString2.add(paramString3);
                  j += 1;
                  continue;
                }
                paramJsBridgeListener = new Intent(paramString1, TeamWorkPicBrowserActivity.class);
                paramJsBridgeListener.putExtra("intent_param_index", i);
                paramJsBridgeListener.putExtra("intent_param_pic_infos", paramString2);
                paramJsBridgeListener.addFlags(536870912);
                paramString1.startActivity(paramJsBridgeListener);
              }
              catch (Exception paramJsBridgeListener) {}
              if (!QLog.isDevelopLevel()) {
                break;
              }
              QLog.d("DocxApiPlugin", 4, "getDocxImageList failed:" + paramJsBridgeListener);
              break;
              if ((!"setAuthForSharePad".equals(paramString3)) || (paramVarArgs.length > 1)) {
                break label995;
              }
              try
              {
                if ((paramVarArgs.length != 1) || (!(this.mRuntime.getActivity() instanceof QQBrowserActivity))) {
                  break;
                }
                paramJsBridgeListener = new SharePolicyInfo();
                paramString1 = new JSONObject(paramVarArgs[0]);
                paramJsBridgeListener.cjd = ((String)paramString1.opt("authFirstLineInfo"));
                paramJsBridgeListener.cje = ((String)paramString1.opt("authSecondLineInfo"));
                paramJsBridgeListener.policy = ((Integer)paramString1.opt("policy")).intValue();
                paramJsBridgeListener.isCreator = ((Boolean)paramString1.opt("isCreator")).booleanValue();
                paramJsBridgeListener.cjf = ((String)paramString1.opt("docName"));
                paramJsBridgeListener.docType = ((Integer)paramString1.opt("docType")).intValue();
                paramJsBridgeListener.cjg = ((String)paramString1.opt("docIconUrl"));
                paramJsBridgeListener.taskType = ((Integer)paramString1.opt("taskType")).intValue();
                paramJsBridgeListener.share_url = ((String)paramString1.opt("share_url"));
                paramJsBridgeListener.dNJ = ((Integer)paramString1.opt("memLength")).intValue();
                paramJsBridgeListener.cjh = ((String)paramString1.opt("memListPrefix"));
                paramJsBridgeListener.cji = ((String)paramString1.opt("descriptionSuffix"));
                paramJsBridgeListener.padId = ((String)paramString1.opt("padId"));
                paramJsBridgeListener.cjj = ((String)paramString1.opt("domainId"));
                paramJsBridgeListener.title = ((String)paramString1.opt("padTitle"));
                paramJsBridgeListener.folderId = ((String)paramString1.opt("folderId"));
                paramString1 = (QQBrowserActivity)this.mRuntime.getActivity();
                if ((paramString1 == null) || (paramString1.c() == null)) {
                  break;
                }
                paramString1 = paramString1.c();
                if (paramString1 == null) {
                  break;
                }
                paramString1.b().a(paramJsBridgeListener);
                paramJsBridgeListener = paramString1.b();
                if (paramJsBridgeListener == null) {
                  break;
                }
                paramJsBridgeListener = (arbt)paramJsBridgeListener.q(4);
                if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener.a instanceof aobu))) {
                  break;
                }
                paramJsBridgeListener.a.updateUIIfShowing();
              }
              catch (Exception paramJsBridgeListener)
              {
                QLog.d("DocxApiPlugin", 1, "setAuthForSharePad error:" + paramJsBridgeListener);
              }
            }
            break;
            label995:
            if (("sendDocToChat".equals(paramString3)) && (paramVarArgs.length <= 1)) {
              return mY(paramVarArgs[0]);
            }
            if (("writeSystemClipboard".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (paramVarArgs.length != 1) {
                break;
              }
              Lp(paramVarArgs[0]);
              break;
            }
            if (("readSystemClipboard".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (paramVarArgs.length != 1) {
                break;
              }
              Lq(paramVarArgs[0]);
              break;
            }
            if (("eventShare".equals(paramString3)) && (paramVarArgs.length == 1))
            {
              Lr(paramVarArgs[0]);
              break;
            }
            if (("openLocalFilesToImport".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              Lo(paramVarArgs[0]);
              break;
            }
            if (("openExportedFile".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              Ll(paramVarArgs[0]);
              break;
            }
            if (("openExportedFileAndDownload".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (aqiw.isNetSupport(this.mRuntime.getActivity()))
              {
                Lm(paramVarArgs[0]);
                break;
              }
              QQToast.a(this.mRuntime.getActivity(), this.mRuntime.getActivity().getString(2131695432), 0).show();
              break;
            }
            if (("txDocsStartExport".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null)) {
                break;
              }
              if (aqiw.isNetSupport(this.mRuntime.getActivity()))
              {
                Ln(paramVarArgs[0]);
                break;
              }
              QQToast.a(this.mRuntime.getActivity(), this.mRuntime.getActivity().getString(2131695432), 0).show();
              break;
            }
            if (("voiceInputSetup".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.jdField_a_of_type_Afdp != null) {
                break;
              }
              this.jdField_a_of_type_Afdp = new afdp(this);
              this.jdField_a_of_type_Afdp.aiL();
              break;
            }
            boolean bool;
            if (("voiceInputStart".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.jdField_a_of_type_Afdp != null)
              {
                if (paramVarArgs.length == 1)
                {
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                    bool = this.jdField_a_of_type_Afdp.y(paramJsBridgeListener);
                    return bool;
                  }
                  catch (Throwable paramJsBridgeListener)
                  {
                    QLog.e("DocxApiPlugin", 1, "VoiceInputHelper start error", paramJsBridgeListener);
                  }
                  break;
                }
                QLog.e("DocxApiPlugin", 1, "VoiceInputHelper start args error.");
                break;
              }
              QLog.e("DocxApiPlugin", 1, "VoiceInputHelper has destroyed, start failed.");
              break;
            }
            if (("voiceInputStop".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.jdField_a_of_type_Afdp == null) {
                break;
              }
              this.jdField_a_of_type_Afdp.stop();
              break;
            }
            if (("cameraCheckPermission".equals(paramString3)) && (paramVarArgs.length <= 1))
            {
              if (this.b == null) {
                this.b = new afdm(this);
              }
              if (paramVarArgs.length == 1)
              {
                try
                {
                  paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                  bool = this.b.ij(paramJsBridgeListener);
                  return bool;
                }
                catch (Throwable paramJsBridgeListener)
                {
                  QLog.e("DocxApiPlugin", 1, "CameraHelper checkPermission error", paramJsBridgeListener);
                }
                break;
              }
              QLog.e("DocxApiPlugin", 1, "CameraHelper checkPermission args error.");
              break;
            }
            if ((!"getTcntDocData".equals(paramString3)) || (paramVarArgs.length > 1)) {
              break label1709;
            }
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString1.optString("url");
              paramString1 = paramString1.optString("callback");
              ThreadManager.excute(new DocxApiPlugin.3(this, aobh.nP(paramJsBridgeListener), paramString1, paramJsBridgeListener), 64, null, false);
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
            }
          }
          break;
          label1709:
          if ((!"delTcntDocData".equals(paramString3)) || (paramVarArgs.length > 1)) {
            break label1777;
          }
          try
          {
            ThreadManager.excute(new DocxApiPlugin.4(this, aobh.nP(new JSONObject(paramVarArgs[0]).optString("url"))), 64, null, false);
          }
          catch (JSONException paramJsBridgeListener)
          {
            QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
          }
        }
        break;
        label1777:
        if ((!"preFetchTcntDocData".equals(paramString3)) || (paramVarArgs.length > 1)) {
          break label2058;
        }
        paramString1 = aeuk.a();
        if ((!paramString1.ahY()) || (!paramString1.ahZ())) {
          return false;
        }
        dsF();
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]).optJSONArray("keys");
          if (paramString2 == null) {
            break;
          }
          paramJsBridgeListener = new ArrayList(paramString2.length());
          i = 0;
          while (i < paramString2.length())
          {
            paramJsBridgeListener.add(paramString2.getJSONObject(i).optString("doc_url"));
            i += 1;
          }
          if ((paramString1.aia()) && (!paramJsBridgeListener.isEmpty()))
          {
            paramString1 = (String)paramJsBridgeListener.get(0);
            if (((FragmentActivity)this.mRuntime.getActivity()).getSupportFragmentManager().findFragmentByTag("doc_preload") == null)
            {
              QLog.e("DocxApiPlugin", 1, "tendocpreload UnVisibleWebViewFragment create ");
              aoca.RL(paramString1);
              paramString2 = new Intent();
              paramString2.putExtra("url", paramString1);
              paramString2.putExtra("hide_more_button", true);
              paramString2.putExtra("webStyle", "noBottomBar");
              paramString2.putExtra("isScreenOrientationPortrait", true);
              paramString2.putExtra("title", " ");
              paramString1 = UnVisibleWebViewFragment.b(paramString2);
              ((FragmentActivity)this.mRuntime.getActivity()).getSupportFragmentManager().beginTransaction().add(paramString1, "doc_preload").commitAllowingStateLoss();
            }
          }
          ex(paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          QLog.e("DocxApiPlugin", 1, "JSONException ", paramJsBridgeListener);
        }
      }
      break;
      label2058:
      if ((!"showShareView".equals(paramString3)) || (paramVarArgs.length > 1)) {
        break;
      }
      paramJsBridgeListener = (QQBrowserActivity)this.mRuntime.getActivity();
      if ((paramJsBridgeListener == null) || (paramJsBridgeListener.c() == null)) {
        break;
      }
      paramJsBridgeListener = paramJsBridgeListener.c();
      if ((paramJsBridgeListener == null) || (!(paramJsBridgeListener instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment))) {
        break;
      }
      ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)paramJsBridgeListener).bVI();
      break;
      label2124:
      int i = -1;
    }
  }
  
  /* Error */
  public boolean mY(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: new 29	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   22: ldc 27
    //   24: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 993	aoaf:cjv	Ljava/lang/String;
    //   30: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_1
    //   37: new 29	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 995
    //   47: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 485	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc_w 966
    //   63: astore 8
    //   65: aconst_null
    //   66: astore 7
    //   68: ldc_w 997
    //   71: astore 6
    //   73: ldc2_w 998
    //   76: lstore 4
    //   78: new 48	org/json/JSONObject
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 50	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   86: astore_1
    //   87: aload_1
    //   88: ldc_w 964
    //   91: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 10
    //   96: aload_1
    //   97: ldc_w 1001
    //   100: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 9
    //   105: aload_1
    //   106: ldc_w 736
    //   109: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 15
    //   114: aload_1
    //   115: ldc_w 1003
    //   118: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 11
    //   123: aload_1
    //   124: ldc_w 1005
    //   127: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 16
    //   132: aload_1
    //   133: ldc_w 1007
    //   136: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 17
    //   141: aload_1
    //   142: ldc_w 1009
    //   145: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 12
    //   150: aload_1
    //   151: ldc_w 1011
    //   154: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 13
    //   159: aload_1
    //   160: ldc_w 1013
    //   163: invokevirtual 1016	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   166: istore_2
    //   167: aload_0
    //   168: getfield 201	aiiy:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   171: invokevirtual 207	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   174: checkcast 281	com/tencent/mobileqq/activity/QQBrowserActivity
    //   177: astore 14
    //   179: aload 14
    //   181: invokevirtual 1017	com/tencent/mobileqq/activity/QQBrowserActivity:getIntent	()Landroid/content/Intent;
    //   184: ldc_w 1019
    //   187: invokevirtual 1022	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore_1
    //   191: aload 15
    //   193: invokestatic 1027	aobw:pN	(Ljava/lang/String;)Z
    //   196: ifeq +30 -> 226
    //   199: ldc_w 1029
    //   202: astore 8
    //   204: ldc_w 1030
    //   207: invokestatic 1035	acfp:m	(I)Ljava/lang/String;
    //   210: astore_1
    //   211: getstatic 1038	aobw:cjS	Ljava/lang/String;
    //   214: astore 6
    //   216: getstatic 1041	aobw:cjU	Ljava/lang/String;
    //   219: astore 7
    //   221: getstatic 1045	aobw:aoS	J
    //   224: lstore 4
    //   226: new 293	android/content/Intent
    //   229: dup
    //   230: invokespecial 955	android/content/Intent:<init>	()V
    //   233: astore 18
    //   235: aload 18
    //   237: ldc_w 1005
    //   240: aload 16
    //   242: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   245: pop
    //   246: aload 18
    //   248: ldc_w 1007
    //   251: aload 17
    //   253: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   256: pop
    //   257: aload 18
    //   259: ldc_w 1047
    //   262: iconst_1
    //   263: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   266: pop
    //   267: aload 18
    //   269: aload 14
    //   271: ldc_w 1049
    //   274: invokevirtual 1053	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   277: pop
    //   278: aload 18
    //   280: ldc_w 1055
    //   283: iconst_1
    //   284: invokevirtual 307	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   287: pop
    //   288: aload 18
    //   290: ldc_w 1057
    //   293: sipush 1001
    //   296: invokevirtual 319	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   299: pop
    //   300: aload 18
    //   302: ldc_w 1059
    //   305: ldc_w 1061
    //   308: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   311: pop
    //   312: aload 18
    //   314: ldc_w 1063
    //   317: bipush 95
    //   319: invokevirtual 319	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   322: pop
    //   323: aload 18
    //   325: ldc_w 1065
    //   328: aload 15
    //   330: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   333: pop
    //   334: aload 18
    //   336: ldc_w 1067
    //   339: aload 11
    //   341: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   344: pop
    //   345: lload 4
    //   347: ldc2_w 1068
    //   350: lcmp
    //   351: ifeq +14 -> 365
    //   354: aload 18
    //   356: ldc_w 1071
    //   359: lload 4
    //   361: invokevirtual 1074	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   364: pop
    //   365: aload 18
    //   367: ldc_w 1076
    //   370: aload 6
    //   372: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   375: pop
    //   376: aload 18
    //   378: ldc_w 1078
    //   381: aload_1
    //   382: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   385: pop
    //   386: aload 18
    //   388: ldc_w 1080
    //   391: aload 7
    //   393: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   396: pop
    //   397: aload 18
    //   399: ldc_w 1082
    //   402: aload 8
    //   404: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   407: pop
    //   408: aload 18
    //   410: ldc_w 1084
    //   413: ldc_w 400
    //   416: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   419: pop
    //   420: aload 18
    //   422: ldc_w 1086
    //   425: ldc_w 400
    //   428: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   431: pop
    //   432: aload 10
    //   434: astore_1
    //   435: aload 10
    //   437: ifnull +44 -> 481
    //   440: aload 10
    //   442: astore_1
    //   443: aload 10
    //   445: invokevirtual 1087	java/lang/String:length	()I
    //   448: bipush 45
    //   450: if_icmple +31 -> 481
    //   453: new 29	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   460: aload 10
    //   462: iconst_0
    //   463: bipush 45
    //   465: invokevirtual 1091	java/lang/String:substring	(II)Ljava/lang/String;
    //   468: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc_w 1093
    //   474: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: astore_1
    //   481: aload 18
    //   483: ldc_w 964
    //   486: aload_1
    //   487: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   490: pop
    //   491: aload 9
    //   493: astore 6
    //   495: aload 9
    //   497: ifnull +46 -> 543
    //   500: aload 9
    //   502: astore 6
    //   504: aload 9
    //   506: invokevirtual 1087	java/lang/String:length	()I
    //   509: bipush 60
    //   511: if_icmple +32 -> 543
    //   514: new 29	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   521: aload 9
    //   523: iconst_0
    //   524: bipush 60
    //   526: invokevirtual 1091	java/lang/String:substring	(II)Ljava/lang/String;
    //   529: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc_w 1093
    //   535: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: astore 6
    //   543: aload 18
    //   545: ldc_w 1001
    //   548: aload 6
    //   550: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   553: pop
    //   554: aload 18
    //   556: ldc_w 1095
    //   559: aload 11
    //   561: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   564: pop
    //   565: aload 18
    //   567: ldc_w 1097
    //   570: ldc_w 1029
    //   573: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   576: pop
    //   577: aload 18
    //   579: ldc_w 1071
    //   582: ldc2_w 1068
    //   585: invokevirtual 1074	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   588: pop
    //   589: aload 18
    //   591: ldc_w 1099
    //   594: aload 14
    //   596: ldc_w 1100
    //   599: iconst_1
    //   600: anewarray 1102	java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: aload_1
    //   606: aastore
    //   607: invokevirtual 1105	com/tencent/mobileqq/activity/QQBrowserActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   610: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   613: pop
    //   614: aload 18
    //   616: ldc_w 1011
    //   619: aload 13
    //   621: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   624: pop
    //   625: aload 18
    //   627: ldc_w 1013
    //   630: iload_2
    //   631: invokevirtual 319	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   634: pop
    //   635: aload 12
    //   637: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   640: ifne +37 -> 677
    //   643: aload 18
    //   645: ldc_w 1107
    //   648: aload 12
    //   650: invokevirtual 331	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   653: pop
    //   654: invokestatic 237	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   657: invokevirtual 241	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   660: ldc 243
    //   662: ldc_w 1109
    //   665: aload 18
    //   667: invokevirtual 1113	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   670: invokevirtual 251	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   673: pop
    //   674: goto -663 -> 11
    //   677: new 29	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   684: ldc 27
    //   686: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: getstatic 993	aoaf:cjv	Ljava/lang/String;
    //   692: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: iconst_1
    //   699: ldc_w 1115
    //   702: invokestatic 485	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: goto -51 -> 654
    //   708: astore_1
    //   709: new 29	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   716: ldc 27
    //   718: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: getstatic 993	aoaf:cjv	Ljava/lang/String;
    //   724: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: iconst_1
    //   731: ldc_w 1117
    //   734: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   737: goto -726 -> 11
    //   740: astore_1
    //   741: aload_0
    //   742: monitorexit
    //   743: aload_1
    //   744: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	this	aiiy
    //   0	745	1	paramString	String
    //   166	465	2	i	int
    //   6	2	3	bool	boolean
    //   76	284	4	l	long
    //   71	478	6	localObject	Object
    //   66	326	7	str1	String
    //   63	340	8	str2	String
    //   103	419	9	str3	String
    //   94	367	10	str4	String
    //   121	439	11	str5	String
    //   148	501	12	str6	String
    //   157	463	13	str7	String
    //   177	418	14	localQQBrowserActivity	QQBrowserActivity
    //   112	217	15	str8	String
    //   130	111	16	str9	String
    //   139	113	17	str10	String
    //   233	433	18	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   78	191	708	org/json/JSONException
    //   191	199	708	org/json/JSONException
    //   204	226	708	org/json/JSONException
    //   226	345	708	org/json/JSONException
    //   354	365	708	org/json/JSONException
    //   365	432	708	org/json/JSONException
    //   443	481	708	org/json/JSONException
    //   481	491	708	org/json/JSONException
    //   504	543	708	org/json/JSONException
    //   543	654	708	org/json/JSONException
    //   654	674	708	org/json/JSONException
    //   677	705	708	org/json/JSONException
    //   2	7	740	finally
    //   15	60	740	finally
    //   78	191	740	finally
    //   191	199	740	finally
    //   204	226	740	finally
    //   226	345	740	finally
    //   354	365	740	finally
    //   365	432	740	finally
    //   443	481	740	finally
    //   481	491	740	finally
    //   504	543	740	finally
    //   543	654	740	finally
    //   654	674	740	finally
    //   677	705	740	finally
    //   709	737	740	finally
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    int i;
    int j;
    if ((this.bNX != null) && (!TextUtils.isEmpty(this.bNX)))
    {
      paramIntent = "ok";
      if (paramByte != 17) {
        break label125;
      }
      paramIntent = "user canceld share panel";
      i = 0;
      j = 0;
    }
    label172:
    for (;;)
    {
      label44:
      paramIntent = String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt), paramIntent });
      QLog.d("DocxApiPlugin", 2, "rsp json = " + paramIntent);
      callJs(this.bNX, new String[] { paramIntent });
      return;
      label125:
      if ((paramByte == 18) || (paramByte == 52))
      {
        if (paramByte == 18) {}
        for (i = 1;; i = 2)
        {
          if (paramInt != 0) {
            break label172;
          }
          paramInt = -1;
          paramIntent = "user canceled";
          j = i;
          i = 0;
          break;
        }
        paramInt = 0;
        j = i;
        i = 2;
      }
      else if ((paramByte == 86) || (paramByte == 120))
      {
        if (paramByte == 86) {}
        for (i = 3;; i = 4) {
          switch (paramInt)
          {
          default: 
            j = i;
            i = 0;
            break label44;
          }
        }
        j = i;
        i = 2;
        continue;
        paramIntent = "err comm";
        j = i;
        i = 0;
        continue;
        paramIntent = "user canceled";
        j = i;
        i = 0;
        continue;
        paramIntent = "sent failed";
        j = i;
        i = 0;
        continue;
        paramIntent = "auth denied";
        j = i;
        i = 0;
        continue;
        paramIntent = "unsupport";
        j = i;
        i = 0;
        continue;
        paramIntent = "err ban";
        j = i;
        i = 0;
      }
      else
      {
        paramInt = 0;
        i = 0;
        j = 0;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime == null) {}
    for (AppInterface localAppInterface = null;; localAppInterface = this.mRuntime.a())
    {
      afdp.p(localAppInterface);
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Afdi = null;
    if (this.b != null)
    {
      this.b.destroy();
      this.b = null;
    }
    if (this.jdField_a_of_type_Afdp != null)
    {
      this.jdField_a_of_type_Afdp.destroy();
      this.jdField_a_of_type_Afdp = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiiy
 * JD-Core Version:    0.7.0.1
 */