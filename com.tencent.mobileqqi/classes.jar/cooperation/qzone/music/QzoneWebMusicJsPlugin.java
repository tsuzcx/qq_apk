package cooperation.qzone.music;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import ihl;
import ihm;
import ihn;
import iho;
import ihp;
import ihq;
import ihr;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneWebMusicJsPlugin
  extends WebViewPlugin
  implements RemoteMusicManager.MusicEventListener
{
  public static final String EVENT_BUFFERING = "buffering";
  public static final String EVENT_BUTTON_CLICK = "buttonclick";
  public static final String EVENT_CANCEL = "cancel";
  public static final String EVENT_ERROR = "error";
  public static final String EVENT_FINISH = "finish";
  public static final String EVENT_GET_PLAY_MODE = "playmode";
  public static final String EVENT_GET_SONGINFO = "songinfo";
  public static final String EVENT_PAUSED = "paused";
  public static final String EVENT_PLAYING = "playing";
  public static final String EVENT_STOP = "stop";
  public static final String EVENT_UNKOWN = "unknow";
  public static final String MUSIC_METHOD_NAMESPACE = "QzMusic";
  private static final String WEB_APP_MUSIC_EVENT = "WEBAPP_MUSIC";
  private String TAG = QzoneWebMusicJsPlugin.class.getSimpleName();
  private boolean isFlowWarningVisible = false;
  private boolean isShowing = false;
  private boolean isUseRemoteMusicManager = false;
  private boolean isWebPageListening = false;
  private boolean mTempChecked = false;
  
  private void callWebPageInterface(String paramString)
  {
    if ((this.isWebPageListening) && (!this.isDestroy)) {
      this.mRuntime.a().loadUrl("javascript:QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + paramString + "\"}})");
    }
  }
  
  private void callWebPageInterface(String paramString, Bundle paramBundle)
  {
    JSONObject localJSONObject;
    if (this.isWebPageListening) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("uin", getCurrentHostUin());
      if (paramBundle != null)
      {
        SongInfo localSongInfo = (SongInfo)paramBundle.getParcelable("param.song");
        if (localSongInfo != null)
        {
          localJSONObject.put("name", localSongInfo.jdField_b_of_type_JavaLangString);
          localJSONObject.put("singer", localSongInfo.g);
          localJSONObject.put("songId", localSongInfo.jdField_a_of_type_Long);
          localJSONObject.put("singerId", localSongInfo.jdField_b_of_type_Long);
          localJSONObject.put("type", localSongInfo.jdField_a_of_type_Int);
          localJSONObject.put("cover", localSongInfo.d);
        }
        localJSONObject.put("state", getStateString(paramBundle.getInt("param.state", -1)));
        localJSONObject.put("total", paramBundle.getInt("param.duration"));
        localJSONObject.put("curr", paramBundle.getInt("param.currentTime"));
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    if (!this.isDestroy) {
      this.mRuntime.a().loadUrl("javascript:QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + paramString + "\",value:" + localJSONObject.toString() + "}})");
    }
  }
  
  private static SongInfo convertSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    try
    {
      localSongInfo.jdField_b_of_type_JavaLangString = paramJSONObject.getString("name");
      localSongInfo.g = paramJSONObject.getString("singer");
      localSongInfo.jdField_a_of_type_Long = paramJSONObject.getLong("songId");
      localSongInfo.jdField_a_of_type_Int = paramJSONObject.getInt("type");
      localSongInfo.d = paramJSONObject.getString("cover");
      localSongInfo.jdField_b_of_type_Long = paramJSONObject.getLong("singerId");
      localSongInfo.f = paramJSONObject.getString("album");
      return localSongInfo;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localSongInfo;
  }
  
  private long getCurrentHostUin()
  {
    try
    {
      String str = Uri.parse(this.mRuntime.a().getUrl()).getQueryParameter("guestuin");
      if (str == null) {
        return this.mRuntime.a().getLongAccountUin();
      }
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "illegal guestuin");
      }
    }
    return 10000L;
  }
  
  private String getStateString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknow";
    case 1: 
      return "buffering";
    case 2: 
      return "playing";
    case 3: 
      return "paused";
    case 4: 
    case 6: 
      return "stop";
    }
    return "error";
  }
  
  private boolean needPlayTips()
  {
    return (NetworkUtil.c(BaseApplicationImpl.getContext())) && (!this.mTempChecked);
  }
  
  private static final void showPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DialogUtil.a(paramContext, 230, "流量提示", "你正处于非WiFi环境，继续播放将会消耗流量，运营商可能会收取费用，是否继续", "继续", "取消", paramOnClickListener2, paramOnClickListener1).show();
  }
  
  public void getPlayMode()
  {
    RemoteMusicManager.getInstance().getPlayMode();
  }
  
  public void getPlayingSongInfo()
  {
    RemoteMusicManager.getInstance().getPlayingSong();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMusic")) {}
    do
    {
      return false;
      if ((paramString3.equals("playMusic")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
      {
        paramJsBridgeListener = this.mRuntime.a();
        if ((paramJsBridgeListener != null) && (needPlayTips()))
        {
          showPlayTips(paramJsBridgeListener, new ihl(this, paramVarArgs), new ihm(this));
          this.isFlowWarningVisible = true;
        }
        for (;;)
        {
          return true;
          playMusic(paramVarArgs[0]);
        }
      }
      if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
      {
        paramJsBridgeListener = this.mRuntime.a();
        if ((paramJsBridgeListener != null) && (needPlayTips()))
        {
          showPlayTips(paramJsBridgeListener, new ihn(this, paramVarArgs), new iho(this));
          this.isFlowWarningVisible = true;
        }
        for (;;)
        {
          return true;
          playMusicList(paramVarArgs[0]);
        }
      }
      if (paramString3.equals("resumePlay"))
      {
        resumePlay();
        return true;
      }
      if (paramString3.equals("pausePlay"))
      {
        pausePlay();
        return true;
      }
      if ((paramString3.equals("listenMusicState")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        listenMusicState(paramVarArgs[0]);
        return true;
      }
      if (paramString3.equals("musicListChange"))
      {
        musicListChange();
        return true;
      }
      if ((paramString3.equals("setPlayMode")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        setPlayMode(paramVarArgs[0]);
        return true;
      }
      if ((paramString3.equals("setRightButton")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        setRightButton(paramVarArgs[0]);
        return true;
      }
      if (paramString3.equals("getPlayingSongInfo"))
      {
        getPlayingSongInfo();
        return true;
      }
      if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        playMusicList(paramVarArgs[0]);
        return true;
      }
    } while (!paramString3.equals("getPlayMode"));
    getPlayMode();
    return true;
  }
  
  public void listenMusicState(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("isOpen");
      if (i == 1)
      {
        this.isWebPageListening = true;
        RemoteMusicManager.getInstance().addOnMusicEventListener(this);
        this.isUseRemoteMusicManager = true;
        return;
      }
      if (i == 0)
      {
        this.isWebPageListening = false;
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void musicListChange()
  {
    RemoteMusicManager.getInstance().notifyPlayListChange();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RemoteMusicManager.getInstance().removeOnMusicEventListener(this);
    if (this.isUseRemoteMusicManager) {
      RemoteMusicManager.getInstance().destroy();
    }
  }
  
  public void onMusicEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramBundle.getBundle("data") == null)) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("data");
          if (paramBundle != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.TAG, 2, "call js function,bundle is empty");
        return;
        String str = getStateString(paramBundle.getInt("param.state", -1));
        if (!paramString.equals("cmd.notifyStateCallback")) {
          break;
        }
        callWebPageInterface(str, paramBundle);
        bool = paramBundle.getBoolean("param.needPlayTips");
        paramString = this.mRuntime.a();
      } while ((paramString == null) || (paramString.isFinishing()) || (this.isShowing) || (!bool) || (!needPlayTips()));
      pausePlay();
      showPlayTips(paramString, new ihq(this), new ihr(this));
      this.isShowing = true;
      return;
      if (paramString.equals("cmd.getPlayMode"))
      {
        callWebPageInterface("playmode", paramBundle);
        return;
      }
    } while (!paramString.equals("cmd.getPlayingSong"));
    callWebPageInterface("songinfo", paramBundle);
  }
  
  public void pausePlay()
  {
    RemoteMusicManager.getInstance().pausePlay();
  }
  
  public void playMusic(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(convertSongInfo(new JSONObject(paramString)));
      if (localArrayList.size() > 0)
      {
        RemoteMusicManager.getInstance().playMusicList(getCurrentHostUin(), 1, 0, 102, localArrayList);
        return;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.TAG, 2, "song info error");
    }
  }
  
  /* Error */
  public void playMusicList(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 441	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 442	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: new 123	org/json/JSONObject
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 384	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: ldc_w 459
    //   24: invokevirtual 222	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   27: istore_2
    //   28: aload_1
    //   29: ldc_w 461
    //   32: invokevirtual 465	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   35: astore_1
    //   36: iload_2
    //   37: istore 4
    //   39: iload_3
    //   40: aload_1
    //   41: invokevirtual 470	org/json/JSONArray:length	()I
    //   44: if_icmpge +34 -> 78
    //   47: aload 5
    //   49: aload_1
    //   50: iload_3
    //   51: invokevirtual 474	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   54: invokestatic 444	cooperation/qzone/music/QzoneWebMusicJsPlugin:convertSongInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/music/SongInfo;
    //   57: invokevirtual 447	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: iload_3
    //   62: iconst_1
    //   63: iadd
    //   64: istore_3
    //   65: goto -29 -> 36
    //   68: astore_1
    //   69: iconst_0
    //   70: istore_2
    //   71: aload_1
    //   72: invokevirtual 455	org/json/JSONException:printStackTrace	()V
    //   75: iload_2
    //   76: istore 4
    //   78: aload 5
    //   80: invokevirtual 451	java/util/ArrayList:size	()I
    //   83: ifle +21 -> 104
    //   86: invokestatic 308	cooperation/qzone/music/RemoteMusicManager:getInstance	()Lcooperation/qzone/music/RemoteMusicManager;
    //   89: aload_0
    //   90: invokespecial 130	cooperation/qzone/music/QzoneWebMusicJsPlugin:getCurrentHostUin	()J
    //   93: iconst_2
    //   94: iload 4
    //   96: bipush 103
    //   98: aload 5
    //   100: invokevirtual 454	cooperation/qzone/music/RemoteMusicManager:playMusicList	(JIIILjava/util/ArrayList;)V
    //   103: return
    //   104: invokestatic 260	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -4 -> 103
    //   110: aload_0
    //   111: getfield 65	cooperation/qzone/music/QzoneWebMusicJsPlugin:TAG	Ljava/lang/String;
    //   114: iconst_2
    //   115: ldc_w 476
    //   118: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: return
    //   122: astore_1
    //   123: goto -52 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	QzoneWebMusicJsPlugin
    //   0	126	1	paramString	String
    //   27	49	2	i	int
    //   1	64	3	j	int
    //   37	58	4	k	int
    //   9	90	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   11	28	68	org/json/JSONException
    //   28	36	122	org/json/JSONException
    //   39	61	122	org/json/JSONException
  }
  
  public void resumePlay()
  {
    RemoteMusicManager.getInstance().resumePlay();
  }
  
  /* Error */
  public void setPlayMode(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: new 123	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 384	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: ldc_w 479
    //   15: invokevirtual 480	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   18: istore 4
    //   20: iload 4
    //   22: ifeq +38 -> 60
    //   25: iconst_1
    //   26: istore_2
    //   27: aload_1
    //   28: ldc_w 482
    //   31: invokevirtual 480	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +27 -> 65
    //   41: invokestatic 308	cooperation/qzone/music/RemoteMusicManager:getInstance	()Lcooperation/qzone/music/RemoteMusicManager;
    //   44: aload_0
    //   45: getfield 93	cooperation/qzone/music/QzoneWebMusicJsPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   48: invokevirtual 244	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   51: invokevirtual 249	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   54: iload_2
    //   55: iload_3
    //   56: invokevirtual 485	cooperation/qzone/music/RemoteMusicManager:setPlayMode	(JII)V
    //   59: return
    //   60: iconst_0
    //   61: istore_2
    //   62: goto -35 -> 27
    //   65: iconst_0
    //   66: istore_3
    //   67: goto -26 -> 41
    //   70: astore_1
    //   71: iconst_0
    //   72: istore_2
    //   73: aload_1
    //   74: invokevirtual 455	org/json/JSONException:printStackTrace	()V
    //   77: iconst_0
    //   78: istore_3
    //   79: goto -38 -> 41
    //   82: astore_1
    //   83: goto -10 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	QzoneWebMusicJsPlugin
    //   0	86	1	paramString	String
    //   26	47	2	i	int
    //   1	78	3	j	int
    //   18	19	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	70	org/json/JSONException
    //   27	36	82	org/json/JSONException
  }
  
  public void setRightButton(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("text");
      String str = ((JSONObject)localObject).getString("color");
      boolean bool = ((JSONObject)localObject).getBoolean("visible");
      if ((this.mRuntime.a() instanceof QQBrowserActivity))
      {
        localObject = (TextView)this.mRuntime.a().findViewById(2131231380);
        if (bool) {}
        try
        {
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextColor(Color.parseColor("#" + str));
          ((TextView)localObject).setText(paramString);
          ((TextView)localObject).setOnClickListener(new ihp(this));
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            break label152;
          }
          QLog.e(this.TAG, 2, "set right textview error");
          paramString.printStackTrace();
          return;
        }
        ((TextView)localObject).setVisibility(8);
        return;
      }
    }
    catch (Exception paramString)
    {
      label152:
      paramString.printStackTrace();
    }
  }
  
  public void stopPlay()
  {
    RemoteMusicManager.getInstance().stopPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin
 * JD-Core Version:    0.7.0.1
 */