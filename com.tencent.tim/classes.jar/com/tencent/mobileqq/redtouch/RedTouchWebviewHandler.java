package com.tencent.mobileqq.redtouch;

import affz;
import altq;
import altt;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aqhq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouchWebviewHandler
  extends VasWebviewJsPlugin
{
  private static final String ERRMSG_EXCEPTION = "exception";
  private static final String ERRMSG_FAILED = "failed";
  private static final String ERRMSG_NO_DATA = "data not prepared or cannot find the path, try again.";
  private static final String ERRMSG_SUCCESS = "success";
  public static final int INTVALUE_UNKNOWN = -1;
  public static final String KEY_CALLBACK = "callback";
  public static final String KEY_ERROR_MSG = "errorMessage";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESULT = "ret";
  public static final String KEY_SRC_TYPE = "srcType";
  public static final String KEY_TYPE = "type";
  public static final int LEBA_ITEM_OFF = 0;
  public static final int LEBA_ITEM_ON = 1;
  public static final String METHOD_GET_LEBA_STATE = "getDynamicState";
  public static final String METHOD_SET_LEBA_STATE = "setDynamicState";
  private static final String OBJECT_NAME = "redpoint";
  public static final String PLUGIN_NAMESPACE = "redpoint";
  public static final String REDBUFFERJSON_2722 = "2722";
  public static final String REDBUFFERJSON_PARAM = "param";
  public static String TAG = "RedTouchWebviewHandler";
  public static final int VALUE_EXCEPTION = -1;
  public static final int VALUE_FAILED = 1;
  public static final int VALUE_SUCCESS = 0;
  private AppInterface browserApp;
  
  public RedTouchWebviewHandler()
  {
    this.mPluginNameSpace = "redpoint";
  }
  
  private void IPCItemClick(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    super.sendRemoteReq(affz.a("myIndividuationRedInfo", null, 0, localBundle), false, true);
  }
  
  private BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String paramString)
  {
    if ((this.browserApp == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getappinfo path or browserapp = null");
      }
      paramString = null;
    }
    Object localObject1;
    label145:
    do
    {
      return paramString;
      localObject1 = new File(this.browserApp.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.browserApp.getCurrentAccountUin());
      if (!((File)localObject1).exists()) {}
      try
      {
        ((File)localObject1).createNewFile();
        localObject2 = new BusinessInfoCheckUpdate.TimeRspBody();
      }
      catch (IOException paramString)
      {
        try
        {
          localObject1 = aqhq.fileToBytes((File)localObject1);
          if (localObject1 != null) {
            break label145;
          }
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo body = null");
          }
          return null;
        }
        finally {}
        paramString = paramString;
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getappinfo create file exception ");
        }
        return null;
      }
      try
      {
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).mergeFrom((byte[])localObject1);
        if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo localTimeRspBody null ");
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getappinfo mergeFrom exception ");
        }
        return null;
      }
      Object localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get().iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
      } while (!((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get().equals(paramString));
      paramString = (String)localObject1;
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "getappinfo path= " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get() + ";inewflag = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get());
    return localObject1;
    return null;
  }
  
  private List<BusinessInfoCheckUpdate.AppInfo> getAppInfoListByPath(List<String> paramList)
  {
    if ((this.browserApp == null) || (paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getappinfolist paths is empty or browserapp = null");
      }
    }
    label152:
    do
    {
      for (;;)
      {
        return null;
        localObject1 = new File(this.browserApp.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.browserApp.getCurrentAccountUin());
        if (!((File)localObject1).exists()) {}
        try
        {
          ((File)localObject1).createNewFile();
        }
        catch (IOException paramList)
        {
          try
          {
            localObject1 = aqhq.fileToBytes((File)localObject1);
            if (localObject1 != null) {
              break label152;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i(TAG, 2, "getappinfolist body = null");
            return null;
          }
          finally {}
          paramList = paramList;
          paramList.printStackTrace();
        }
        if (QLog.isColorLevel())
        {
          QLog.i(TAG, 2, "getappinfolist create file exception ");
          return null;
          localObject2 = new BusinessInfoCheckUpdate.TimeRspBody();
          try
          {
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).mergeFrom((byte[])localObject1);
            if ((localObject2 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has())) {
              break label221;
            }
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "getappinfolist localTimeRspBody null ");
              return null;
            }
          }
          catch (Exception paramList)
          {
            paramList.printStackTrace();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "getappinfolist mergeFrom exception ");
    return null;
    label221:
    Object localObject1 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get();
    Object localObject2 = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localObject2;
      }
      String str = (String)paramList.next();
      Iterator localIterator = ((List)localObject1).iterator();
      if (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        if (!localAppInfo.path.get().equals(str)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getappinfolist path= " + localAppInfo.path.get() + ";inewflag = " + localAppInfo.iNewFlag.get());
        }
        ((List)localObject2).add(localAppInfo);
      }
    }
    return localObject2;
  }
  
  private JSONObject getRedBufferJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("param");
        if (localJSONObject2 == null) {
          return null;
        }
        Iterator localIterator = localJSONObject2.keys();
        paramJSONObject = localJSONObject1;
        if (localIterator.hasNext())
        {
          paramJSONObject = localJSONObject2.getJSONObject((String)localIterator.next());
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  private String getReportBufferString(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    JSONArray localJSONArray;
    JSONObject localJSONObject1;
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray();
        localJSONObject1 = new JSONObject();
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          paramString = paramString.getJSONObject("msg");
          if (paramString == null) {
            break;
          }
          Iterator localIterator = paramString.keys();
          if (!localIterator.hasNext()) {
            break;
          }
          JSONObject localJSONObject2 = new JSONObject();
          String str = (String)localIterator.next();
          localObject = paramString.getJSONObject(str);
          if (!((JSONObject)localObject).has("stat")) {
            break label176;
          }
          i = ((JSONObject)localObject).getInt("stat");
          if (i != 1) {
            continue;
          }
          if (!((JSONObject)localObject).has("content")) {
            break label181;
          }
          localObject = ((JSONObject)localObject).getString("content");
          localJSONObject2.put(str, localObject);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      continue;
      label176:
      int i = -1;
      continue;
      label181:
      Object localObject = "";
    }
    localJSONObject1.put("msg", localJSONArray);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  /* Error */
  private void handleGetAppinfo(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 291	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 292	org/json/JSONObject:<init>	()V
    //   7: astore 10
    //   9: new 291	org/json/JSONObject
    //   12: dup
    //   13: invokespecial 292	org/json/JSONObject:<init>	()V
    //   16: astore 9
    //   18: aload_2
    //   19: ldc_w 335
    //   22: invokevirtual 336	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 11
    //   27: aload_2
    //   28: ldc_w 338
    //   31: invokevirtual 342	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   34: checkcast 344	com/tencent/mobileqq/redtouch/RedAppInfo
    //   37: invokestatic 349	altt:a	(Lcom/tencent/mobileqq/redtouch/RedAppInfo;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   40: astore 13
    //   42: bipush 254
    //   44: istore 4
    //   46: ldc_w 302
    //   49: astore_2
    //   50: iconst_0
    //   51: istore_3
    //   52: ldc_w 302
    //   55: astore 8
    //   57: new 277	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 278	java/util/ArrayList:<init>	()V
    //   64: astore 12
    //   66: aload 8
    //   68: astore 6
    //   70: aload_2
    //   71: astore 7
    //   73: aload 13
    //   75: ifnull +137 -> 212
    //   78: aload 13
    //   80: getfield 353	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   83: getfield 358	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   86: invokevirtual 217	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   89: astore 14
    //   91: aload 13
    //   93: getfield 237	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   96: invokevirtual 241	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   99: astore 7
    //   101: aload_2
    //   102: astore 6
    //   104: aload 13
    //   106: getfield 361	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 364	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: iconst_m1
    //   113: if_icmpne +292 -> 405
    //   116: bipush 253
    //   118: istore 4
    //   120: iconst_0
    //   121: istore_3
    //   122: aload_2
    //   123: astore 6
    //   125: aload 12
    //   127: ldc_w 302
    //   130: invokevirtual 365	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload_2
    //   135: astore 6
    //   137: aload 10
    //   139: ldc_w 367
    //   142: bipush 253
    //   144: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_2
    //   149: astore 6
    //   151: aload 10
    //   153: ldc 26
    //   155: ldc_w 372
    //   158: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload_2
    //   163: astore 6
    //   165: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +37 -> 205
    //   171: aload_2
    //   172: astore 6
    //   174: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   177: iconst_2
    //   178: new 156	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 374
    //   188: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 10
    //   193: invokevirtual 331	org/json/JSONObject:toString	()Ljava/lang/String;
    //   196: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 7
    //   207: astore 6
    //   209: aload_2
    //   210: astore 7
    //   212: new 376	altq
    //   215: dup
    //   216: aload_0
    //   217: getfield 380	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   220: invokevirtual 385	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   223: invokespecial 388	altq:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   226: invokevirtual 391	altq:yz	()Ljava/lang/String;
    //   229: astore_2
    //   230: iload_3
    //   231: istore 5
    //   233: aload 6
    //   235: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   238: ifne +18 -> 256
    //   241: iload_3
    //   242: istore 5
    //   244: aload 6
    //   246: aload_2
    //   247: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +6 -> 256
    //   253: iconst_1
    //   254: istore 5
    //   256: new 81	android/os/Bundle
    //   259: dup
    //   260: invokespecial 82	android/os/Bundle:<init>	()V
    //   263: astore_2
    //   264: aload_2
    //   265: ldc 32
    //   267: iload 4
    //   269: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   272: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload_2
    //   276: ldc_w 397
    //   279: aload 7
    //   281: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_2
    //   285: ldc_w 399
    //   288: iload 5
    //   290: invokestatic 395	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   293: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_2
    //   297: ldc_w 401
    //   300: aload 12
    //   302: invokevirtual 405	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   305: aload_2
    //   306: ldc 29
    //   308: aload 6
    //   310: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_2
    //   314: ldc_w 335
    //   317: aload 11
    //   319: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_2
    //   323: ldc 23
    //   325: aload_1
    //   326: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload_0
    //   330: ldc_w 407
    //   333: aload_1
    //   334: aload_0
    //   335: getfield 411	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$b;
    //   338: getfield 416	com/tencent/mobileqq/emosm/Client$b:key	I
    //   341: aload_2
    //   342: invokestatic 94	affz:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   345: iconst_0
    //   346: iconst_1
    //   347: invokespecial 98	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   350: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +34 -> 387
    //   356: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   359: iconst_2
    //   360: new 156	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 418
    //   370: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 10
    //   375: invokevirtual 331	org/json/JSONObject:toString	()Ljava/lang/String;
    //   378: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: aload_0
    //   388: aload_1
    //   389: iconst_1
    //   390: anewarray 243	java/lang/String
    //   393: dup
    //   394: iconst_0
    //   395: aload 10
    //   397: invokevirtual 331	org/json/JSONObject:toString	()Ljava/lang/String;
    //   400: aastore
    //   401: invokevirtual 422	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   404: return
    //   405: aload_2
    //   406: astore 6
    //   408: aload 10
    //   410: ldc_w 367
    //   413: iconst_0
    //   414: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload_2
    //   419: astore 6
    //   421: aload 9
    //   423: ldc_w 424
    //   426: aload 13
    //   428: getfield 427	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   431: invokevirtual 364	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   434: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   437: pop
    //   438: aload_2
    //   439: astore 6
    //   441: aload 9
    //   443: ldc_w 428
    //   446: aload 13
    //   448: getfield 255	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   451: invokevirtual 260	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   454: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   457: pop
    //   458: aload_2
    //   459: astore 6
    //   461: aload 13
    //   463: getfield 255	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   466: invokevirtual 260	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   469: istore 4
    //   471: aload_2
    //   472: astore 6
    //   474: new 304	org/json/JSONArray
    //   477: dup
    //   478: invokespecial 305	org/json/JSONArray:<init>	()V
    //   481: astore 8
    //   483: iconst_0
    //   484: istore_3
    //   485: aload_2
    //   486: astore 6
    //   488: iload_3
    //   489: aload 13
    //   491: getfield 431	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   494: invokevirtual 436	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   497: if_icmpge +46 -> 543
    //   500: aload_2
    //   501: astore 6
    //   503: aload 8
    //   505: aload 13
    //   507: getfield 431	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   510: iload_3
    //   511: invokevirtual 439	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   514: invokevirtual 330	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   517: pop
    //   518: aload_2
    //   519: astore 6
    //   521: aload 12
    //   523: aload 13
    //   525: getfield 431	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   528: iload_3
    //   529: invokevirtual 439	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   532: invokevirtual 365	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   535: pop
    //   536: iload_3
    //   537: iconst_1
    //   538: iadd
    //   539: istore_3
    //   540: goto -55 -> 485
    //   543: aload_2
    //   544: astore 6
    //   546: new 291	org/json/JSONObject
    //   549: dup
    //   550: invokespecial 292	org/json/JSONObject:<init>	()V
    //   553: astore 15
    //   555: aload 14
    //   557: ifnull +113 -> 670
    //   560: iconst_0
    //   561: istore_3
    //   562: aload_2
    //   563: astore 6
    //   565: iload_3
    //   566: aload 14
    //   568: invokeinterface 440 1 0
    //   573: if_icmpge +97 -> 670
    //   576: aload_2
    //   577: astore 6
    //   579: aload 15
    //   581: ldc_w 442
    //   584: aload 14
    //   586: iload_3
    //   587: invokeinterface 443 2 0
    //   592: checkcast 445	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   595: getfield 447	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   598: invokevirtual 364	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   601: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   604: pop
    //   605: aload_2
    //   606: astore 6
    //   608: aload 15
    //   610: ldc_w 449
    //   613: aload 14
    //   615: iload_3
    //   616: invokeinterface 443 2 0
    //   621: checkcast 445	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   624: getfield 451	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   627: invokevirtual 241	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   630: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   633: pop
    //   634: aload_2
    //   635: astore 6
    //   637: aload 15
    //   639: ldc_w 453
    //   642: aload 14
    //   644: iload_3
    //   645: invokeinterface 443 2 0
    //   650: checkcast 445	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   653: getfield 455	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   656: invokevirtual 241	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   659: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   662: pop
    //   663: iload_3
    //   664: iconst_1
    //   665: iadd
    //   666: istore_3
    //   667: goto -105 -> 562
    //   670: aload_2
    //   671: astore 6
    //   673: aload 9
    //   675: ldc_w 338
    //   678: aload 15
    //   680: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   683: pop
    //   684: aload_2
    //   685: astore 6
    //   687: aload 9
    //   689: ldc_w 401
    //   692: aload 8
    //   694: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   697: pop
    //   698: aload_2
    //   699: astore 6
    //   701: aload 9
    //   703: ldc 38
    //   705: aload 13
    //   707: getfield 361	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   710: invokevirtual 364	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   713: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   716: pop
    //   717: aload_2
    //   718: astore 6
    //   720: aload 9
    //   722: ldc_w 397
    //   725: aload 13
    //   727: getfield 457	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   730: invokevirtual 241	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   733: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   736: pop
    //   737: aload_2
    //   738: astore 6
    //   740: aload 9
    //   742: ldc 29
    //   744: aload 13
    //   746: getfield 237	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   749: invokevirtual 241	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   752: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   755: pop
    //   756: aload_2
    //   757: astore 6
    //   759: aload 9
    //   761: ldc_w 459
    //   764: aload 13
    //   766: getfield 461	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:appset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   769: invokevirtual 260	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   772: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   775: pop
    //   776: aload_2
    //   777: astore 6
    //   779: aload 9
    //   781: ldc_w 463
    //   784: aload 13
    //   786: getfield 465	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:modify_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   789: invokevirtual 364	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   792: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   795: pop
    //   796: aload_2
    //   797: astore 6
    //   799: aload 9
    //   801: ldc_w 467
    //   804: aload 13
    //   806: getfield 469	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   809: invokevirtual 260	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   812: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   815: pop
    //   816: aload_2
    //   817: astore 6
    //   819: aload 9
    //   821: ldc_w 471
    //   824: aload 13
    //   826: getfield 473	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   829: invokevirtual 364	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   832: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   835: pop
    //   836: aload_2
    //   837: astore 6
    //   839: aload 10
    //   841: ldc_w 475
    //   844: aload 9
    //   846: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   849: pop
    //   850: aload_2
    //   851: astore 6
    //   853: aload_0
    //   854: aload 13
    //   856: getfield 457	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   859: invokevirtual 241	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   862: invokespecial 110	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getReportBufferString	(Ljava/lang/String;)Ljava/lang/String;
    //   865: astore_2
    //   866: iload 4
    //   868: istore_3
    //   869: iconst_0
    //   870: istore 4
    //   872: goto -710 -> 162
    //   875: astore 9
    //   877: aload 8
    //   879: astore 7
    //   881: aload 9
    //   883: invokevirtual 300	org/json/JSONException:printStackTrace	()V
    //   886: bipush 252
    //   888: istore 4
    //   890: iconst_0
    //   891: istore_3
    //   892: aload 12
    //   894: ldc_w 302
    //   897: invokevirtual 365	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   900: pop
    //   901: aload 7
    //   903: astore 6
    //   905: aload_2
    //   906: astore 7
    //   908: goto -696 -> 212
    //   911: astore 9
    //   913: aload 6
    //   915: astore_2
    //   916: goto -35 -> 881
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	919	0	this	RedTouchWebviewHandler
    //   0	919	1	paramString	String
    //   0	919	2	paramBundle	Bundle
    //   51	841	3	i	int
    //   44	845	4	j	int
    //   231	58	5	k	int
    //   68	846	6	localObject1	Object
    //   71	836	7	localObject2	Object
    //   55	823	8	localObject3	Object
    //   16	829	9	localJSONObject1	JSONObject
    //   875	7	9	localJSONException1	JSONException
    //   911	1	9	localJSONException2	JSONException
    //   7	833	10	localJSONObject2	JSONObject
    //   25	293	11	str	String
    //   64	829	12	localArrayList	ArrayList
    //   40	815	13	localAppInfo	BusinessInfoCheckUpdate.AppInfo
    //   89	554	14	localList	List
    //   553	126	15	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   78	101	875	org/json/JSONException
    //   104	116	911	org/json/JSONException
    //   125	134	911	org/json/JSONException
    //   137	148	911	org/json/JSONException
    //   151	162	911	org/json/JSONException
    //   165	171	911	org/json/JSONException
    //   174	205	911	org/json/JSONException
    //   408	418	911	org/json/JSONException
    //   421	438	911	org/json/JSONException
    //   441	458	911	org/json/JSONException
    //   461	471	911	org/json/JSONException
    //   474	483	911	org/json/JSONException
    //   488	500	911	org/json/JSONException
    //   503	518	911	org/json/JSONException
    //   521	536	911	org/json/JSONException
    //   546	555	911	org/json/JSONException
    //   565	576	911	org/json/JSONException
    //   579	605	911	org/json/JSONException
    //   608	634	911	org/json/JSONException
    //   637	663	911	org/json/JSONException
    //   673	684	911	org/json/JSONException
    //   687	698	911	org/json/JSONException
    //   701	717	911	org/json/JSONException
    //   720	737	911	org/json/JSONException
    //   740	756	911	org/json/JSONException
    //   759	776	911	org/json/JSONException
    //   779	796	911	org/json/JSONException
    //   799	816	911	org/json/JSONException
    //   819	836	911	org/json/JSONException
    //   839	850	911	org/json/JSONException
    //   853	866	911	org/json/JSONException
  }
  
  private void handleGetRedpointShowInfo(String paramString, Bundle paramBundle)
  {
    int j = -1;
    localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    if (paramBundle == null)
    {
      paramBundle = null;
      localJSONObject2 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put("code", 0);
        if (paramBundle == null) {
          continue;
        }
        j = paramBundle.getRed_type();
        i = 1;
        localJSONObject2.put("hintType", j);
        localJSONObject2.put("number", 0);
        localJSONObject2.put("isShow", i);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getRedPointShowInfo:" + localJSONObject1.toString());
        }
      }
      catch (JSONException paramBundle)
      {
        int i;
        paramBundle.printStackTrace();
        try
        {
          localJSONObject1.put("code", -1);
          localJSONObject1.put("errorMessage", "missing callback");
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
        continue;
      }
      callJs(paramString, new String[] { localJSONObject1.toString() });
      return;
      paramBundle = (RedTypeInfo)paramBundle.getSerializable("redInfo");
      break;
      i = 0;
    }
  }
  
  private void handleLebaItemGet(String paramString, Bundle paramBundle)
  {
    int i = 1;
    int j = -1;
    if (paramBundle == null) {}
    for (;;)
    {
      if (i == 0) {
        j = paramBundle.getInt("type", -1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "get leba item result: " + i + ", type: " + j);
      }
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("ret", i);
        paramBundle.put("type", j);
        if (i == 0) {
          paramBundle.put("errorMessage", "success");
        }
        for (;;)
        {
          callJs(paramString, new String[] { paramBundle.toString() });
          return;
          i = paramBundle.getInt("ret");
          break;
          paramBundle.put("errorMessage", "data not prepared or cannot find the path, try again.");
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void handleLebaItemSet(String paramString, Bundle paramBundle)
  {
    int i = 1;
    if (paramBundle == null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "set leba item result: " + i);
      }
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("ret", i);
        if (i == 0) {
          paramBundle.put("errorMessage", "success");
        }
        for (;;)
        {
          callJs(paramString, new String[] { paramBundle.toString() });
          return;
          i = paramBundle.getInt("ret");
          break;
          paramBundle.put("errorMessage", "failed");
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void handleRedInfoResponse(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          paramBundle.setClassLoader(RedAppInfo.class.getClassLoader());
          str = paramBundle.getString("subCmd");
        } while (str == null);
        if ("redTouch_getIndividuationType".equals(str))
        {
          handlegetIndivationType(paramString, paramBundle);
          return;
        }
      } while ("redTouch_reportRedTouch".equals(str));
      if ("redTouch_reportBusinessRedTouch".equals(str))
      {
        handleReportRedtouch(paramString, paramBundle);
        return;
      }
      if ("redTouch_getAppInfo".equals(str))
      {
        handleGetAppinfo(paramString, paramBundle);
        return;
      }
    } while (!"redTouch_getRedPointShowInfo_path".equals(str));
    handlegetRedpointShowInfoPath(paramString, paramBundle);
  }
  
  /* Error */
  private void handleReportRedtouch(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 291	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 292	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: aload_2
    //   10: ldc_w 338
    //   13: invokevirtual 342	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   16: checkcast 344	com/tencent/mobileqq/redtouch/RedAppInfo
    //   19: astore 8
    //   21: aload_2
    //   22: ldc 29
    //   24: invokevirtual 336	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 9
    //   29: aload_2
    //   30: ldc_w 546
    //   33: invokevirtual 336	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_2
    //   37: new 291	org/json/JSONObject
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 307	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 7
    //   47: aload_0
    //   48: getfield 380	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   51: invokevirtual 550	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   54: astore_2
    //   55: new 552	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody
    //   58: dup
    //   59: invokespecial 553	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   62: astore 6
    //   64: aload 6
    //   66: getfield 557	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   69: aload_0
    //   70: getfield 380	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   73: invokevirtual 385	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   76: invokevirtual 167	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   79: invokestatic 563	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: invokevirtual 569	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   85: aload 6
    //   87: getfield 572	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: ldc_w 574
    //   93: invokevirtual 576	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   96: aload 6
    //   98: getfield 579	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   101: bipush 109
    //   103: invokevirtual 582	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   106: aload 6
    //   108: getfield 585	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: aload 9
    //   113: invokestatic 588	altq:dP	(Ljava/lang/String;)I
    //   116: invokevirtual 582	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   119: aload 6
    //   121: getfield 591	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   124: new 156	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   131: getstatic 596	android/os/Build$VERSION:SDK_INT	I
    //   134: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc_w 302
    //   140: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokevirtual 576	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   149: aload 8
    //   151: invokevirtual 599	com/tencent/mobileqq/redtouch/RedAppInfo:fS	()Ljava/util/List;
    //   154: ifnull +16 -> 170
    //   157: aload 6
    //   159: getfield 602	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:missionid	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   162: aload 8
    //   164: invokevirtual 599	com/tencent/mobileqq/redtouch/RedAppInfo:fS	()Ljava/util/List;
    //   167: invokevirtual 605	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   170: new 277	java/util/ArrayList
    //   173: dup
    //   174: invokespecial 278	java/util/ArrayList:<init>	()V
    //   177: astore 8
    //   179: aload 7
    //   181: invokevirtual 299	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   184: astore 9
    //   186: aload 9
    //   188: invokeinterface 228 1 0
    //   193: ifeq +156 -> 349
    //   196: aload 9
    //   198: invokeinterface 232 1 0
    //   203: checkcast 243	java/lang/String
    //   206: astore 10
    //   208: new 607	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData
    //   211: dup
    //   212: invokespecial 608	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:<init>	()V
    //   215: astore 11
    //   217: aload 11
    //   219: getfield 610	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   222: aload 10
    //   224: invokevirtual 576	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   227: aload 11
    //   229: getfield 613	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: aload 7
    //   234: aload 10
    //   236: invokevirtual 323	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokevirtual 576	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   242: aload 8
    //   244: aload 11
    //   246: invokeinterface 283 2 0
    //   251: pop
    //   252: getstatic 619	java/lang/System:out	Ljava/io/PrintStream;
    //   255: new 156	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 621
    //   265: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 11
    //   270: getfield 610	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   273: invokevirtual 241	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   276: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 623
    //   282: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 11
    //   287: getfield 613	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   290: invokevirtual 241	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   293: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokevirtual 628	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   302: goto -116 -> 186
    //   305: astore_2
    //   306: aload 5
    //   308: ldc_w 367
    //   311: iconst_m1
    //   312: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   315: pop
    //   316: aload 5
    //   318: ldc 26
    //   320: ldc_w 630
    //   323: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   326: pop
    //   327: aload_2
    //   328: invokevirtual 300	org/json/JSONException:printStackTrace	()V
    //   331: aload_0
    //   332: aload_1
    //   333: iconst_1
    //   334: anewarray 243	java/lang/String
    //   337: dup
    //   338: iconst_0
    //   339: aload 5
    //   341: invokevirtual 331	org/json/JSONObject:toString	()Ljava/lang/String;
    //   344: aastore
    //   345: invokevirtual 422	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   348: return
    //   349: new 291	org/json/JSONObject
    //   352: dup
    //   353: invokespecial 292	org/json/JSONObject:<init>	()V
    //   356: astore 7
    //   358: aload 7
    //   360: ifnull +13 -> 373
    //   363: aload 7
    //   365: ldc_w 632
    //   368: iconst_5
    //   369: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload 6
    //   375: getfield 633	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   378: aload 7
    //   380: invokevirtual 331	org/json/JSONObject:toString	()Ljava/lang/String;
    //   383: invokevirtual 576	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   386: aload 6
    //   388: getfield 636	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:reportdata	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   391: aload 8
    //   393: invokevirtual 637	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   396: new 639	com/tencent/qphone/base/remote/ToServiceMsg
    //   399: dup
    //   400: ldc_w 641
    //   403: aload_0
    //   404: getfield 380	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   407: invokevirtual 385	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   410: invokevirtual 167	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   413: ldc_w 643
    //   416: invokespecial 646	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   419: astore 7
    //   421: aload 7
    //   423: aload 6
    //   425: invokevirtual 650	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   428: invokevirtual 654	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   431: aload 7
    //   433: getfield 658	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   436: ldc_w 660
    //   439: iconst_1
    //   440: invokevirtual 664	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   443: aload 7
    //   445: invokevirtual 667	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   448: arraylength
    //   449: i2l
    //   450: lstore_3
    //   451: lload_3
    //   452: l2i
    //   453: iconst_4
    //   454: iadd
    //   455: newarray byte
    //   457: astore 6
    //   459: aload 6
    //   461: iconst_0
    //   462: ldc2_w 668
    //   465: lload_3
    //   466: ladd
    //   467: invokestatic 675	aqoj:DWord2Byte	([BIJ)V
    //   470: aload 6
    //   472: iconst_4
    //   473: aload 7
    //   475: invokevirtual 667	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   478: lload_3
    //   479: l2i
    //   480: invokestatic 679	aqoj:b	([BI[BI)V
    //   483: aload 7
    //   485: aload 6
    //   487: invokevirtual 654	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   490: new 681	mqq/app/NewIntent
    //   493: dup
    //   494: aload_2
    //   495: invokevirtual 686	android/app/Activity:getApplication	()Landroid/app/Application;
    //   498: ldc_w 688
    //   501: invokespecial 691	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   504: astore_2
    //   505: aload_2
    //   506: ldc_w 639
    //   509: invokevirtual 694	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   512: aload 7
    //   514: invokevirtual 698	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   517: pop
    //   518: aload_0
    //   519: getfield 380	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   522: invokevirtual 385	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   525: aload_2
    //   526: invokevirtual 702	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   529: aload 5
    //   531: ldc_w 367
    //   534: iconst_0
    //   535: invokevirtual 370	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   538: pop
    //   539: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq -211 -> 331
    //   545: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   548: iconst_2
    //   549: new 156	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 704
    //   559: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 5
    //   564: invokevirtual 331	org/json/JSONObject:toString	()Ljava/lang/String;
    //   567: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: goto -245 -> 331
    //   579: astore_2
    //   580: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq -252 -> 331
    //   586: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   589: iconst_2
    //   590: new 156	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   597: ldc_w 704
    //   600: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_2
    //   604: invokevirtual 705	java/lang/Exception:toString	()Ljava/lang/String;
    //   607: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: goto -285 -> 331
    //   619: astore 6
    //   621: aload 6
    //   623: invokevirtual 300	org/json/JSONException:printStackTrace	()V
    //   626: goto -299 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	this	RedTouchWebviewHandler
    //   0	629	1	paramString	String
    //   0	629	2	paramBundle	Bundle
    //   450	29	3	l	long
    //   7	556	5	localJSONObject	JSONObject
    //   62	424	6	localObject1	Object
    //   619	3	6	localJSONException	JSONException
    //   45	468	7	localObject2	Object
    //   19	373	8	localObject3	Object
    //   27	170	9	localObject4	Object
    //   206	29	10	str	String
    //   215	71	11	localReportStaticsData	com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData
    // Exception table:
    //   from	to	target	type
    //   37	170	305	org/json/JSONException
    //   170	186	305	org/json/JSONException
    //   186	302	305	org/json/JSONException
    //   349	358	305	org/json/JSONException
    //   363	373	305	org/json/JSONException
    //   373	576	305	org/json/JSONException
    //   37	170	579	java/lang/Exception
    //   170	186	579	java/lang/Exception
    //   186	302	579	java/lang/Exception
    //   349	358	579	java/lang/Exception
    //   363	373	579	java/lang/Exception
    //   373	576	579	java/lang/Exception
    //   306	327	619	org/json/JSONException
  }
  
  private void handleSetAppInfo(String paramString, Bundle paramBundle)
  {
    int i;
    if (paramBundle == null)
    {
      i = -1;
      paramBundle = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramBundle.put("code", i);
        if (i != -3) {
          continue;
        }
        paramBundle.put("errorMessage", "appInfo not found");
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "setAppInfo:" + paramBundle.toString());
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
      i = paramBundle.getInt("iret");
      break;
      if (i == -4) {
        paramBundle.put("errorMessage", "failed to set appInfo");
      }
    }
  }
  
  private void handlegetIndivationType(String paramString, Bundle paramBundle)
  {
    String str1 = "0";
    localJSONObject1 = new JSONObject();
    localObject = str1;
    for (;;)
    {
      try
      {
        RedAppInfo localRedAppInfo = (RedAppInfo)paramBundle.getParcelable("redInfo");
        localObject = str1;
        String str2 = paramBundle.getString("path");
        paramBundle = str1;
        if (localRedAppInfo != null)
        {
          paramBundle = str1;
          localObject = str1;
          if (localRedAppInfo.If() != 0)
          {
            localObject = str1;
            JSONObject localJSONObject2 = getRedBufferJson(new JSONObject(localRedAppInfo.yw()));
            paramBundle = str1;
            if (localJSONObject2 != null)
            {
              localObject = str1;
              if (!localJSONObject2.has("_red_ext_busi_")) {
                continue;
              }
              localObject = str1;
              paramBundle = localJSONObject2.getString("_red_ext_busi_");
            }
          }
        }
        localObject = paramBundle;
        localJSONObject1.put("result", paramBundle);
        localObject = paramBundle;
        onReportRed(altt.a(localRedAppInfo), 1002);
        localObject = paramBundle;
        IPCItemClick(str2);
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        try
        {
          localJSONObject1.put("result", localObject);
          callJs(paramString, new String[] { localJSONObject1.toString() });
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
        continue;
      }
      callJs(paramString, new String[] { localJSONObject1.toString() });
      return;
      paramBundle = "0";
    }
  }
  
  private void handlegetRedpointShowInfoPath(String paramString, Bundle paramBundle)
  {
    RedAppInfo localRedAppInfo = (RedAppInfo)paramBundle.getParcelable("redInfo");
    paramBundle = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    if (localRedAppInfo == null) {}
    try
    {
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "missing path");
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getRedPointShowInfo:" + paramBundle.toString());
        }
        callJs(paramString, new String[] { paramBundle.toString() });
        return;
        if (localRedAppInfo.getType() != -1) {
          break;
        }
        paramBundle.put("code", -3);
        paramBundle.put("errorMessage", "appInfo not found");
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        localJSONException1.printStackTrace();
        try
        {
          paramBundle.put("code", -1);
          paramBundle.put("errorMessage", "missing callback");
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        continue;
        paramBundle.put("code", 0);
        localJSONObject.put("hintType", localJSONException2.getType());
        localJSONObject.put("number", localJSONException2.Ii());
        localJSONObject.put("isShow", localJSONException2.If());
        paramBundle.put("data", localJSONObject);
      }
    }
  }
  
  private void onReportRed(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if ((paramAppInfo == null) || (paramAppInfo.iNewFlag.get() == 0)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("service_type", 0);
      localJSONObject.put("act_id", paramInt);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localJSONObject.put("service_id", 100005);
      new altq(this.mRuntime.a()).h(paramAppInfo, localJSONObject.toString());
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void getAppInfo(String paramString)
  {
    try
    {
      if (new JSONObject(paramString).has("pathList"))
      {
        getAppInfoList(paramString);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getappinfo js startime : " + l);
      }
      ThreadManager.post(new RedTouchWebviewHandler.1(this, paramString, l), 8, null, true);
    }
  }
  
  public void getAppInfoList(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getappinfolist js startime : " + l);
    }
    ThreadManager.post(new RedTouchWebviewHandler.2(this, paramString, l), 8, null, true);
  }
  
  public void getDynamicState(String paramString)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Failed to parse json string: " + paramString);
        }
        localObject = null;
      }
      paramString = str;
      try
      {
        str = localObject.getString("callback");
        paramString = str;
        Bundle localBundle = new Bundle();
        paramString = str;
        localBundle.putInt("path", altq.dP(localObject.getString("path")));
        paramString = str;
        sendRemoteReq(affz.a("leba_item_get", str, this.mOnRemoteResp.key, localBundle), false, false);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ret", -1);
          localJSONObject2.put("errorMessage", "exception");
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void getIndividuationType(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("callback");
      Bundle localBundle = new Bundle();
      localBundle.putString("path", "100005.100022");
      localBundle.putString("subCmd", "redTouch_getIndividuationType");
      super.sendRemoteReq(affz.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getRedPointShowInfo(String paramString)
  {
    localObject2 = "callback";
    localJSONObject = new JSONObject();
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      int i;
      String str;
      if (!((JSONObject)localObject3).isNull("set"))
      {
        localObject1 = paramString;
        localObject2 = ((JSONObject)localObject3).getString("set");
        try
        {
          i = Integer.parseInt((String)localObject2);
          if ((i != 0) && (i != 1) && (i != 2))
          {
            localObject1 = paramString;
            localJSONObject.put("code", -3);
            localObject1 = paramString;
            localJSONObject.put("errorMessage", "redPoint showInfo not found");
            localObject1 = paramString;
            callJs(paramString, new String[] { localJSONObject.toString() });
            return;
          }
        }
        catch (Exception localException)
        {
          str = paramString;
          localJSONObject.put("code", -3);
          str = paramString;
          localJSONObject.put("errorMessage", "redPoint showInfo not found");
          str = paramString;
          callJs(paramString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing callback");
        callJs(str, new String[] { localJSONObject.toString() });
        return;
        str = paramString;
        localObject2 = new Bundle();
        str = paramString;
        ((Bundle)localObject2).putInt("setId", i);
        str = paramString;
        super.sendRemoteReq(affz.a("redTouch_getRedPointShowInfo_set", paramString, this.mOnRemoteResp.key, (Bundle)localObject2), false, true);
        return;
        str = paramString;
        if (!((JSONObject)localObject3).isNull("path"))
        {
          str = paramString;
          localObject2 = ((JSONObject)localObject3).getString("path");
          str = paramString;
          localObject3 = new Bundle();
          str = paramString;
          ((Bundle)localObject3).putString("path", (String)localObject2);
          str = paramString;
          ((Bundle)localObject3).putString("subCmd", "redTouch_getRedPointShowInfo_path");
          str = paramString;
          super.sendRemoteReq(affz.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
          return;
        }
        str = paramString;
        localJSONObject.put("code", -1);
        str = paramString;
        localJSONObject.put("errorMessage", "missing set and path");
        str = paramString;
        callJs(paramString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getServerTime(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getString("callback");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localJSONObject1.put("time", NetConnInfoCenter.getServerTimeMillis());
          localJSONObject2.put("data", localJSONObject1);
          localJSONObject2.put("code", 0);
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception localException2)
        {
          break label80;
        }
        localException1 = localException1;
        paramString = "callback";
      }
      try
      {
        label80:
        localJSONObject2.put("code", -1);
        localJSONObject2.put("errorMessage", "missing callback");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("redpoint"))) {
      return false;
    }
    paramJsBridgeListener = new ArrayList();
    while (i < paramVarArgs.length)
    {
      paramJsBridgeListener.add(paramVarArgs[i]);
      i += 1;
    }
    return call(paramString3, paramJsBridgeListener);
  }
  
  public void isEnterFromRedPoint(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("callback");
        try
        {
          localObject = ((JSONObject)localObject).getString("path");
          if (!new altq(this.mRuntime.a()).yz().equals(localObject))
          {
            localJSONObject.put("code", 0);
            localJSONObject.put("data", 0);
            localObject = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "isEnterFromRedPoint:" + localJSONObject.toString());
              localObject = paramString;
            }
            callJs((String)localObject, new String[] { localJSONObject.toString() });
            return;
          }
          localJSONObject.put("code", 0);
          localJSONObject.put("data", 1);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramString = "callback";
        continue;
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.browserApp = this.mRuntime.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      str1 = paramBundle.getString("cmd");
      str2 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if ("leba_item_set".equals(str1))
      {
        handleLebaItemSet(str2, paramBundle);
        return;
      }
      if ("leba_item_get".equals(str1))
      {
        handleLebaItemGet(str2, paramBundle);
        return;
      }
      if ("redTouch_setAppInfo".equals(str1))
      {
        handleSetAppInfo(str2, paramBundle);
        return;
      }
      if ("redTouch_getRedPointShowInfo_set".equals(str1))
      {
        handleGetRedpointShowInfo(str2, paramBundle);
        return;
      }
    } while (!"redTouch_getRedInfo".equals(str1));
    handleRedInfoResponse(str2, paramBundle);
  }
  
  public void reportBusinessRedTouch(String paramString)
  {
    String str2 = "callback";
    JSONObject localJSONObject1 = new JSONObject();
    String str1 = str2;
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      str1 = str2;
      paramString = localJSONObject2.getString("callback");
      str1 = paramString;
      localJSONObject2.remove("callback");
      str1 = paramString;
      str2 = localJSONObject2.getString("path");
      str1 = paramString;
      localJSONObject2.remove("path");
      str1 = paramString;
      Bundle localBundle = new Bundle();
      str1 = paramString;
      localBundle.putString("path", str2);
      str1 = paramString;
      localBundle.putString("json", localJSONObject2.toString());
      str1 = paramString;
      localBundle.putString("subCmd", "redTouch_reportBusinessRedTouch");
      str1 = paramString;
      super.sendRemoteReq(affz.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    try
    {
      localJSONObject1.put("code", -1);
      localJSONObject1.put("errorMessage", "missing path or callback");
      callJs(str1, new String[] { localJSONObject1.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void reportRedTouch(String paramString)
  {
    Object localObject2 = "callback";
    ArrayList localArrayList = new ArrayList();
    localJSONObject = new JSONObject();
    localObject1 = localObject2;
    try
    {
      localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      localObject2 = ((JSONObject)localObject3).getString("path");
      localObject1 = paramString;
      j = ((JSONObject)localObject3).getInt("isWithRedPoint");
      localObject1 = paramString;
      localObject3 = ((JSONObject)localObject3).optJSONArray("missions");
      if (localObject3 == null) {
        break label151;
      }
      localObject1 = paramString;
      if (((JSONArray)localObject3).length() <= 0) {
        break label151;
      }
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject3;
        int j;
        int i;
        String str;
        paramString.printStackTrace();
        try
        {
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "missing path or callback or isWithRedPoint");
          callJs((String)localObject1, new String[] { localJSONObject.toString() });
          return;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        i += 1;
      }
    }
    localObject1 = paramString;
    if (i < ((JSONArray)localObject3).length())
    {
      localObject1 = paramString;
      str = ((JSONArray)localObject3).getString(i);
      localObject1 = paramString;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = paramString;
        localArrayList.add(str);
      }
    }
    else
    {
      label151:
      localObject1 = paramString;
      localObject3 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject3).putString("path", (String)localObject2);
      localObject1 = paramString;
      ((Bundle)localObject3).putInt("isWithRedPoint", j);
      localObject1 = paramString;
      if (localArrayList.size() > 0)
      {
        localObject1 = paramString;
        ((Bundle)localObject3).putStringArrayList("missions", localArrayList);
      }
      localObject1 = paramString;
      ((Bundle)localObject3).putString("subCmd", "redTouch_reportRedTouch");
      localObject1 = paramString;
      super.sendRemoteReq(affz.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
      localObject1 = paramString;
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("code", 0);
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          localObject1 = paramString;
          QLog.i(TAG, 2, "reportRedTouch:" + ((JSONObject)localObject2).toString());
        }
        localObject1 = paramString;
        callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = paramString;
          QLog.e(TAG, 1, "reportRedTouch: Exception e = " + localException.getMessage());
          localObject1 = paramString;
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void setAppInfo(String paramString)
  {
    Object localObject2 = "callback";
    JSONObject localJSONObject = new JSONObject();
    new JSONObject();
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      localObject3 = ((JSONObject)localObject3).getJSONObject("appInfo");
      localObject1 = paramString;
      localObject2 = new BusinessInfoCheckUpdate.AppInfo();
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.set(((JSONObject)localObject3).getInt("appID"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(((JSONObject)localObject3).getInt("iNewFlag"));
      localObject1 = paramString;
      JSONArray localJSONArray = ((JSONObject)localObject3).getJSONArray("missions");
      int i = 0;
      for (;;)
      {
        localObject1 = paramString;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramString;
        ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.add(localJSONArray.getString(i));
        i += 1;
      }
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).type.set(((JSONObject)localObject3).getInt("type"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.set(((JSONObject)localObject3).getString("buffer"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.set(((JSONObject)localObject3).getString("path"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).appset.set(((JSONObject)localObject3).getInt("appset"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set(((JSONObject)localObject3).getInt("modify_ts"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).num.set(((JSONObject)localObject3).getInt("num"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).push_red_ts.set(((JSONObject)localObject3).getInt("push_red_ts"));
      localObject1 = paramString;
      localObject3 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject3).putParcelable("red", altt.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
      localObject1 = paramString;
      super.sendRemoteReq(affz.a("redTouch_setAppInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    try
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "missing appInfo or callback or appInfo json format error");
      callJs((String)localObject1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setDynamicState(String paramString)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Failed to parse json string: " + paramString);
        }
        localObject = null;
      }
      paramString = str;
      try
      {
        str = localObject.getString("callback");
        paramString = str;
        Bundle localBundle = new Bundle();
        paramString = str;
        localBundle.putInt("path", altq.dP(localObject.getString("path")));
        paramString = str;
        localBundle.putInt("type", localObject.getInt("type"));
        paramString = str;
        sendRemoteReq(affz.a("leba_item_set", str, this.mOnRemoteResp.key, localBundle), false, false);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ret", -1);
          localJSONObject2.put("errorMessage", "exception");
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    super.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler
 * JD-Core Version:    0.7.0.1
 */