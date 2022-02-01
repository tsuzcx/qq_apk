import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class abcb
  extends VasWebviewJsPlugin
{
  private aqiq a = aqiq.a();
  private QvipSpecialSoundManager b;
  
  public abcb()
  {
    this.mPluginNameSpace = "specialRing";
  }
  
  private void A(String paramString, List<abbg.a> paramList)
  {
    log("-->responseRingsList,callback:" + paramString + ",list:" + paramList);
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        if ((paramList == null) || (paramList.size() <= 0))
        {
          log("-->responseRingsList:list is empety");
          localJSONObject1.put("code", -1);
          localJSONObject1.put("errorMessage", "rings not found");
          callJs(paramString, new String[] { localJSONObject1.toString() });
          return;
        }
        localJSONObject2 = new JSONObject();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        abbg.a locala = (abbg.a)paramList.next();
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("id", locala.id);
        localJSONObject3.put("soundName", locala.bfb);
        localJSONObject3.put("type", locala.type);
        localJSONObject3.put("soundVersion", locala.bfc);
        localJSONObject3.put("soundUrl", locala.ace);
        localJSONObject3.put("whiteList", locala.bfd);
        localJSONObject3.put("isShow", locala.isShow);
        localJSONObject3.put("backgroundUrl", locala.backgroundUrl);
        localJSONObject3.put("access", locala.bfe);
        localJSONObject3.put("useNum", locala.cnA);
        localJSONObject3.put("classify", locala.classify);
        localJSONObject3.put("classifyName", locala.aZu);
        localJSONObject3.put("limitFreeStart", locala.bff);
        localJSONObject3.put("limitFreeEnd", locala.bfg);
        if ((locala.ace != null) && (!TextUtils.isEmpty(locala.ace)) && (isFileExist(locala.ace)))
        {
          localJSONObject3.put("isDownload", true);
          localJSONObject2.put(String.valueOf(locala.id), localJSONObject3);
        }
        else
        {
          localJSONObject3.put("isDownload", false);
        }
      }
      catch (JSONException paramList)
      {
        log("-->json exception:" + paramList.toString() + ".Reload json...");
        Bk(paramString);
        return;
      }
    }
    paramList = new JSONObject();
    paramList.put("rings", localJSONObject2);
    localJSONObject1.put("code", 0);
    localJSONObject1.put("data", paramList);
    callJs(paramString, new String[] { localJSONObject1.toString() });
  }
  
  private void Bk(String paramString)
  {
    File localFile = new File(this.mRuntime.getActivity().getApplicationContext().getFilesDir(), "https://i.gtimg.cn/club/moblie/special_sound/sound_config.json");
    if ((localFile.exists()) && (!localFile.delete())) {
      log("-->can't delete file!");
    }
    this.b.a(new abcd(this, paramString));
  }
  
  private boolean a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
    throws JSONException
  {
    log("-->handleSetRing,id=" + paramInt + ",uin=" + paramString1);
    if (paramBoolean)
    {
      this.mRuntime.getActivity().getApplicationContext().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit().putInt("special_care_id_cache" + paramString1, paramInt).commit();
      paramString1 = new JSONObject();
      paramString1.put("code", 0);
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    if (!aqiw.isNetSupport(this.mRuntime.getActivity().getApplicationContext()))
    {
      log("-->no network");
      paramString1 = new JSONObject();
      paramString1.put("code", -1);
      paramString1.put("errorMessage", getErrorMsg(-1));
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt);
    localBundle.putString("uin", paramString1);
    sendRemoteReq(affz.a("special_care_set_ring", paramString2, this.mOnRemoteResp.key, localBundle), false, false);
    return true;
  }
  
  private boolean a(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    File localFile = new File(this.mRuntime.getActivity().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json");
    JSONObject localJSONObject = new JSONObject();
    if (localFile.exists())
    {
      log("-->config file already exists!");
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "Config file already exists at local.");
    }
    for (;;)
    {
      callJs(paramString, new String[] { localJSONObject.toString() });
      return true;
      try
      {
        bool = localFile.createNewFile();
        if (!bool)
        {
          log("-->Could not create config file!");
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "Could not create file!");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          boolean bool = false;
        }
        log("-->Write config to file.");
        e(localFile, paramJSONObject.toString());
        localJSONObject.put("code", 0);
      }
    }
  }
  
  private boolean al(String paramString1, String paramString2)
    throws JSONException
  {
    log("-->handleCancelDownload,url:" + paramString1 + ",callback:" + paramString2);
    paramString1 = new JSONObject();
    paramString1.put("code", 0);
    callJs(paramString2, new String[] { paramString1.toString() });
    return true;
  }
  
  private boolean am(String paramString1, String paramString2)
    throws JSONException
  {
    log("-->handleIsSpecialCareFriend,friendUin:" + paramString1 + ",callback:" + paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("friendUin", paramString1);
    sendRemoteReq(affz.a("is_special_friend", paramString2, this.mOnRemoteResp.key, localBundle), false, false);
    return true;
  }
  
  private boolean c(String paramString1, String paramString2, boolean paramBoolean)
    throws JSONException
  {
    log("-->handleGetRing, uin=" + paramString1 + ",callback=" + paramString2);
    if (paramBoolean)
    {
      int i = this.mRuntime.getActivity().getApplicationContext().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getInt("special_care_id_cache" + paramString1, 1);
      paramString1 = new JSONObject();
      paramString1.put("id", i);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("code", 0);
      ((JSONObject)localObject).put("data", paramString1);
      callJs(paramString2, new String[] { ((JSONObject)localObject).toString() });
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", paramString1);
    sendRemoteReq(affz.a("special_care_get_ring", paramString2, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
    return true;
  }
  
  /* Error */
  private void e(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +26 -> 30
    //   7: aconst_null
    //   8: astore_3
    //   9: new 376	java/io/FileOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 379	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   17: astore_1
    //   18: aload_1
    //   19: aload_2
    //   20: invokevirtual 383	java/lang/String:getBytes	()[B
    //   23: invokevirtual 387	java/io/FileOutputStream:write	([B)V
    //   26: aload_1
    //   27: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   30: return
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   38: return
    //   39: astore_1
    //   40: return
    //   41: astore_1
    //   42: aload_3
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 390	java/io/FileOutputStream:close	()V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: return
    //   52: astore_2
    //   53: goto -5 -> 48
    //   56: astore_3
    //   57: aload_1
    //   58: astore_2
    //   59: aload_3
    //   60: astore_1
    //   61: goto -17 -> 44
    //   64: astore_2
    //   65: goto -31 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	abcb
    //   0	68	1	paramFile	File
    //   0	68	2	paramString	String
    //   8	35	3	localObject1	Object
    //   56	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	31	java/io/IOException
    //   34	38	39	java/io/IOException
    //   9	18	41	finally
    //   26	30	50	java/io/IOException
    //   44	48	52	java/io/IOException
    //   18	26	56	finally
    //   18	26	64	java/io/IOException
  }
  
  private boolean e(int paramInt, String paramString1, String paramString2)
    throws JSONException
  {
    log("-->handleSetRing,id=" + paramInt + ",uin=" + paramString1);
    if (!aqiw.isNetSupport(this.mRuntime.getActivity().getApplicationContext()))
    {
      log("-->no network");
      paramString1 = new JSONObject();
      paramString1.put("code", -1);
      paramString1.put("errorMessage", getErrorMsg(-1));
      callJs(paramString2, new String[] { paramString1.toString() });
      return true;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt);
    localBundle.putString("uin", paramString1);
    sendRemoteReq(affz.a("sepcial_care_delete_ring", paramString2, this.mOnRemoteResp.key, localBundle), false, false);
    return true;
  }
  
  private String getErrorMsg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN ERROR";
    case -1: 
      return "ERR_NO_NETWORK";
    case -2: 
      return "ERR_REQUEST_TIMEOUT";
    case -3: 
      return "ERR_ANDROID_ERROR";
    case 0: 
      return "SUCC";
    case 10001: 
      return "ERR_METHOD_NOT_SUPPORT";
    case 10002: 
      return "ERR_INVALID_ARGUMENT";
    case 10003: 
      return "ERR_SET_REMIND_ERROR";
    case 10004: 
      return "ERR_CLEAR_REMIND_ERROR";
    case 10005: 
      return "ERR_GET_CLUBINFO_ERROR";
    case 10010: 
      return "ERR_SET_QUOTA_LIMIT";
    case 11001: 
      return "ERR_PROTO_SERIAL_ERR";
    case 20001: 
      return "ERR_OIDB_INIT_ERR";
    case 20002: 
      return "ERR_OIDB_PB_SR_ERR";
    case 20003: 
      return "E_OIDB_PB_PACK_ERR";
    }
    return "E_OIDB_PB_UNPACK_ERR";
  }
  
  private boolean isFileExist(String paramString)
  {
    paramString = new File(this.mRuntime.getActivity().getApplicationContext().getFilesDir(), paramString);
    if (paramString != null) {
      return paramString.exists();
    }
    return false;
  }
  
  private boolean jd(String paramString)
    throws JSONException
  {
    log("-->handleGetRingsInfo,callback=" + paramString);
    if (!this.b.XO()) {
      this.b.a(new abcc(this, paramString));
    }
    for (;;)
    {
      return true;
      String str = "key_special_sound_list" + this.mRuntime.a().getCurrentAccountUin();
      A(paramString, (List)QvipSpecialSoundManager.ib.get(str));
    }
  }
  
  private boolean je(String paramString)
  {
    log("-->handleGetFriendCount,callback=" + paramString);
    sendRemoteReq(affz.a("special_care_get_friend_count", paramString, this.mOnRemoteResp.key, null), false, false);
    return true;
  }
  
  private boolean jf(String paramString)
    throws JSONException
  {
    boolean bool;
    JSONObject localJSONObject;
    if (!this.a.isPlaying())
    {
      bool = true;
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "handleStopRing " + bool);
      localJSONObject = new JSONObject();
      if (bool) {
        break label98;
      }
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "stop error");
    }
    for (;;)
    {
      callJs(paramString, new String[] { localJSONObject.toString() });
      return true;
      bool = this.a.stop();
      break;
      label98:
      localJSONObject.put("code", 0);
    }
  }
  
  private boolean jg(String paramString)
  {
    log("-->handleGetSpecialSoundSwitchState,callback:" + paramString);
    sendRemoteReq(affz.a("special_care_get_switch_state", paramString, this.mOnRemoteResp.key, null), false, false);
    return true;
  }
  
  private boolean jh(String paramString)
    throws JSONException
  {
    File localFile = new File(this.mRuntime.getActivity().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json");
    JSONObject localJSONObject = new JSONObject();
    if (localFile.exists()) {
      localJSONObject.put("code", 0);
    }
    for (;;)
    {
      callJs(paramString, new String[] { localJSONObject.toString() });
      return true;
      localJSONObject.put("code", 1);
      localJSONObject.put("errorMessage", "config file does not exists at local!");
    }
  }
  
  private void k(String paramString, Bundle paramBundle)
    throws JSONException
  {
    log("-->onSetRingForFriendIpcResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -3);
      paramBundle.put("errorMessage", getErrorMsg(-3));
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("error");
    paramBundle = new JSONObject();
    if (i != 0)
    {
      log("-->set ring failed, error:" + getErrorMsg(i));
      paramBundle.put("code", i);
      paramBundle.put("errorMessage", getErrorMsg(i));
    }
    for (;;)
    {
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
      log("-->set ring ok!");
      paramBundle.put("code", 0);
    }
  }
  
  private void l(String paramString, Bundle paramBundle)
    throws JSONException
  {
    log("-->handleGetRingResponse, callback=" + paramString + ",bundle=" + paramBundle);
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "invalid data");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("id");
    paramBundle = new JSONObject();
    paramBundle.put("id", i);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("code", 0);
    localJSONObject.put("data", paramBundle);
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QVipSpecialSoundWebViewPlugin", 2, paramString);
    }
  }
  
  private void m(String paramString, Bundle paramBundle)
    throws JSONException
  {
    log("-->handleGetFriendCountResponse,callback=" + paramString + ",bundle=" + paramBundle);
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle == null)
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "id error");
    }
    for (;;)
    {
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
      int i = paramBundle.getInt("count");
      localJSONObject.put("code", 0);
      paramBundle = new JSONObject();
      paramBundle.put("nums", i);
      localJSONObject.put("data", paramBundle);
    }
  }
  
  private void n(String paramString, Bundle paramBundle)
    throws JSONException
  {
    log("-->onDeleteSpecialSoundResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -3);
      paramBundle.put("errorMessage", getErrorMsg(-3));
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("error");
    paramBundle = new JSONObject();
    if (i != 0)
    {
      log("-->delete ring failed");
      paramBundle.put("code", i);
      paramBundle.put("errorMessage", getErrorMsg(i));
    }
    for (;;)
    {
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
      log("-->delete ring ok!");
      paramBundle.put("code", 0);
    }
  }
  
  private void o(String paramString, Bundle paramBundle)
    throws JSONException
  {
    log("-->onSpecialSoundSwitchState,callback=" + paramString);
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "get state failed");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("state");
    paramBundle = new JSONObject();
    paramBundle.put("code", 0);
    JSONObject localJSONObject = new JSONObject();
    if (i == 1) {}
    for (i = 1;; i = 0)
    {
      localJSONObject.put("canPlay", i);
      paramBundle.put("data", localJSONObject);
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
  }
  
  private boolean o(int paramInt, String paramString)
    throws JSONException
  {
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, "handleDownloadRing: " + paramInt);
    JSONObject localJSONObject = new JSONObject();
    if (aqst.l(this.mRuntime.getActivity(), paramInt))
    {
      QLog.e("QVipSpecialSoundWebViewPlugin", 1, "handleDownloadRing: " + paramInt + " exists");
      localJSONObject.put("code", 2);
      localJSONObject.put("errorCode", 0);
      callJs(paramString, new String[] { localJSONObject.toString() });
      return true;
    }
    localJSONObject.put("code", 0);
    callJs(paramString, new String[] { localJSONObject.toString() });
    QuickUpdateIPCModule.a(37L, aqst.a.getScid(paramInt), new abce(this, paramString));
    return true;
  }
  
  private void p(String paramString, Bundle paramBundle)
    throws JSONException
  {
    log("-->isSpecialFriendIpcResponse");
    if (paramBundle == null)
    {
      paramBundle = new JSONObject();
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "invalid data");
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    int i = paramBundle.getInt("isSpecialFriend");
    paramBundle = new JSONObject();
    paramBundle.put("code", 0);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("isSpecialFriend", i);
    paramBundle.put("data", localJSONObject);
    callJs(paramString, new String[] { paramBundle.toString() });
  }
  
  private boolean p(int paramInt, String paramString)
    throws JSONException
  {
    QLog.e("QVipSpecialSoundWebViewPlugin", 1, "handlePlayRing: " + paramInt);
    JSONObject localJSONObject = new JSONObject();
    if (this.a.isPlaying()) {}
    for (boolean bool = this.a.stop();; bool = true)
    {
      this.a.setOnCompletionListener(new abcf(this, paramInt, paramString));
      String str = aqst.l(this.mRuntime.getActivity(), paramInt);
      if (!new File(str).exists())
      {
        localJSONObject.put("code", 2);
        localJSONObject.put("errorMessage", "audio is missing");
        callJs(paramString, new String[] { localJSONObject.toString() });
        return true;
      }
      this.a.a(this.mRuntime.getActivity().getApplicationContext(), str, new abcb.a(localJSONObject, paramString, bool));
      return true;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("specialRing"))) {
      log("-->handleJsRequest returned, pkgName=" + paramString2);
    }
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1 == null) {
          continue;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        try
        {
          paramJsBridgeListener = paramString1.getString("callback");
        }
        catch (Exception paramJsBridgeListener)
        {
          try
          {
            for (;;)
            {
              log("-->handleJsRequest:method:" + paramString3 + ",callback" + paramJsBridgeListener + ", json:" + paramString1.toString());
              if (!paramString3.equals("getRingsInfo")) {
                break;
              }
              bool1 = jd(paramJsBridgeListener);
              return bool1;
              paramJsBridgeListener = paramJsBridgeListener;
              log("-->failed to parse json str,json=" + null);
              paramJsBridgeListener.printStackTrace();
              paramString1 = null;
            }
            if (paramString3.equals("cancelDownload"))
            {
              al(paramString1.getString("url"), paramJsBridgeListener);
            }
            else
            {
              if (paramString3.equals("downloadRing")) {
                return o(paramString1.optInt("id"), paramJsBridgeListener);
              }
              boolean bool3 = paramString3.equals("setDefaultRing");
              if (!bool3) {}
            }
            label295:
            return true;
          }
          catch (Exception paramString1)
          {
            try
            {
              bool1 = paramString1.getBoolean("lazy");
              return a(paramString1.getInt("id"), paramString1.getString("uin"), bool1, paramJsBridgeListener);
              bool2 = paramString3.equals("getDefaultRing");
              if (bool2) {}
              try
              {
                bool2 = paramString1.getBoolean("lazy");
                bool1 = bool2;
              }
              catch (Exception paramString2)
              {
                break label295;
              }
              return c(paramString1.getString("uin"), paramJsBridgeListener, bool1);
              if (paramString3.equals("play")) {
                return p(paramString1.optInt("id"), paramJsBridgeListener);
              }
              if (paramString3.equals("stop")) {
                return jf(paramJsBridgeListener);
              }
              if (paramString3.equals("getSpecialFriendsNum")) {
                return je(paramJsBridgeListener);
              }
              if (paramString3.equals("deleteSpecialSound")) {
                return e(paramString1.getInt("id"), paramString1.getString("uin"), paramJsBridgeListener);
              }
              if (paramString3.equals("canPlaySpecialSound")) {
                return jg(paramJsBridgeListener);
              }
              if (paramString3.equals("isSpecialCareFriend")) {
                return am(paramString1.getString("friendUin"), paramJsBridgeListener);
              }
              if (paramString3.equals("queryRingDataStatus")) {
                return jh(paramJsBridgeListener);
              }
              if (paramString3.equals("pushRingData"))
              {
                bool1 = a(paramJsBridgeListener, paramString1.getJSONObject("data"));
                return bool1;
                paramString1 = paramString1;
                paramJsBridgeListener = null;
                for (;;)
                {
                  log("-->handleJsRequest exception:" + paramString1.toString());
                  try
                  {
                    paramString1 = new JSONObject();
                    paramString1.put("code", -1);
                    paramString1.put("errorMessage", "exception");
                    callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                  }
                  catch (Exception paramJsBridgeListener)
                  {
                    paramJsBridgeListener.printStackTrace();
                  }
                  paramString1 = paramString1;
                }
              }
            }
            catch (Exception paramString2)
            {
              for (;;)
              {
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.b = new QvipSpecialSoundManager(this.mRuntime.getActivity().getApplicationContext(), this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.release();
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str1;
      String str2;
      try
      {
        if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
          return;
        }
        str1 = paramBundle.getString("cmd");
        str2 = paramBundle.getString("callbackid");
        paramBundle = paramBundle.getBundle("response");
        log("-->onResponse,callback=" + str2 + ",cmd=" + str1 + ",respbundle=" + paramBundle);
        if (str1 == null) {
          return;
        }
        if ("special_care_get_ring".equals(str1))
        {
          l(str2, paramBundle);
          return;
        }
        if ("special_care_get_friend_count".equals(str1))
        {
          m(str2, paramBundle);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        log("-->exception in onResponse," + paramBundle.toString());
        paramBundle.printStackTrace();
        return;
      }
      if ("special_care_set_ring".equals(str1))
      {
        k(str2, paramBundle);
        return;
      }
      if ("sepcial_care_delete_ring".equals(str1))
      {
        n(str2, paramBundle);
        return;
      }
      if ("special_care_get_switch_state".equals(str1))
      {
        o(str2, paramBundle);
        return;
      }
      if ("is_special_friend".equals(str1)) {
        p(str2, paramBundle);
      }
    }
  }
  
  public class a
    implements MediaPlayer.OnPreparedListener
  {
    boolean bBP;
    String callback;
    JSONObject result;
    
    public a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
    {
      this.result = paramJSONObject;
      this.callback = paramString;
      this.bBP = paramBoolean;
    }
    
    public void onError()
    {
      try
      {
        this.result.put("code", 2);
        this.result.put("errorMessage", "can't play");
        abcb.this.callJs(this.callback, new String[] { this.result.toString() });
        return;
      }
      catch (Exception localException1)
      {
        abcb.a(abcb.this, "-->handleJsRequest exception:" + localException1.toString());
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("code", 2);
          localJSONObject.put("errorMessage", "exception");
          abcb.this.callJs(this.callback, new String[] { localJSONObject.toString() });
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    
    public void onPrepared(MediaPlayer paramMediaPlayer)
    {
      if (abcb.a(abcb.this).start()) {}
      try
      {
        if (!this.bBP)
        {
          abcb.a(abcb.this, "-->play failed");
          this.result.put("code", 2);
          this.result.put("errorMessage", "can't play");
        }
        for (;;)
        {
          abcb.this.callJs(this.callback, new String[] { this.result.toString() });
          return;
          this.result.put("code", 0);
        }
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        abcb.a(abcb.this, "-->handleJsRequest exception:" + paramMediaPlayer.toString());
        try
        {
          paramMediaPlayer = new JSONObject();
          paramMediaPlayer.put("code", 2);
          paramMediaPlayer.put("errorMessage", "exception");
          abcb.this.callJs(this.callback, new String[] { paramMediaPlayer.toString() });
          return;
        }
        catch (Exception paramMediaPlayer)
        {
          paramMediaPlayer.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcb
 * JD-Core Version:    0.7.0.1
 */