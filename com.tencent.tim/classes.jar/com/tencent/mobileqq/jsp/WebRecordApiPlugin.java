package com.tencent.mobileqq.jsp;

import acbn;
import acfp;
import ahbj;
import ailt;
import alid;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Base64;
import aqfe;
import aqge;
import aqgz;
import aqhq;
import aqlv;
import aqnt;
import aqnt.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jqc;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebRecordApiPlugin
  extends WebViewPlugin
{
  private a a;
  private String bOU;
  private String bOV;
  private String bOW;
  
  public WebRecordApiPlugin()
  {
    this.mPluginNameSpace = "webRecord";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"webRecord".equals(paramString2)) {
      return false;
    }
    if (this.a == null) {
      this.a = new a(this.mRuntime.a(), (BaseActivity)this.mRuntime.getActivity());
    }
    if ("startRecord".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.bOU = paramJsBridgeListener.optString("callback", "");
        int i = paramJsBridgeListener.optInt("format", 0);
        int j = paramJsBridgeListener.optInt("maxTime", 0);
        this.a.iu(i, j);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    if ("stopRecord".equals(paramString3))
    {
      this.a.ap(0);
      return true;
    }
    if ("play".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.bOV = paramJsBridgeListener.optString("callback", "");
        paramJsBridgeListener = paramJsBridgeListener.optString("recordID", "");
        this.a.play(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    if ("pause".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("recordID", "");
        this.a.IL(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    if ("stop".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("recordID", "");
        this.a.LK(paramJsBridgeListener);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    if ("upload".equals(paramString3)) {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        this.bOW = paramString2.optString("callback", "");
        paramJsBridgeListener = paramString2.optJSONArray("recordIDs");
        paramString1 = paramString2.optString("cgi", "");
        paramString2 = paramString2.optString("cookie", "");
        this.a.a(paramJsBridgeListener, paramString1, paramString2);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    boolean bool = this.a.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.a.ap(1);
    }
  }
  
  class AudioUploadTask
    implements Runnable
  {
    protected AudioInfo b;
    protected WeakReference<BaseActivity> mActivity;
    private String mCookie;
    protected Handler mHandler;
    protected int mState;
    protected String mUrl;
    
    public AudioUploadTask(BaseActivity paramBaseActivity, Handler paramHandler, String paramString1, String paramString2, AudioInfo paramAudioInfo)
    {
      this.mUrl = paramString1;
      this.mCookie = paramString2;
      this.mActivity = new WeakReference(paramBaseActivity);
      this.mHandler = paramHandler;
      if (paramAudioInfo != null) {
        this.b = new AudioInfo(paramAudioInfo);
      }
      this.mState = -1;
    }
    
    public void run()
    {
      this.mState = 1;
      if (this.mActivity == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = (BaseActivity)this.mActivity.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebRecordApiPlugin", 2, "PreUploadTask activity is null!");
        }
        this.mState = 0;
        return;
      }
      if ((this.b == null) || (!ahbj.isFileExists(this.b.path)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebRecordApiPlugin", 2, "Audio is null!");
        }
        this.mState = 0;
        return;
      }
      Object localObject2 = ((BaseActivity)localObject1).getAppRuntime();
      localObject1 = ((AppRuntime)localObject2).getAccount();
      localObject2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.mState = 0;
        return;
      }
      Object localObject4 = new HashMap();
      ((Map)localObject4).put("type", "1");
      ((Map)localObject4).put("name", this.b.path);
      ((Map)localObject4).put("fileName", this.b.path);
      Object localObject5 = new HashMap();
      ((Map)localObject5).put("file", this.b.path);
      HashMap localHashMap = new HashMap();
      localHashMap.put("Connection", "keep-alive");
      localHashMap.put("Referer", "https://www.qq.com");
      if (!TextUtils.isEmpty(this.mCookie)) {
        localHashMap.put("Cookie", this.mCookie);
      }
      localObject4 = jqc.a(this.mUrl, (String)localObject1, (String)localObject2, (Map)localObject4, (Map)localObject5, localHashMap);
      localObject5 = new JSONObject();
      for (;;)
      {
        try
        {
          ((JSONObject)localObject5).put("path", this.b.path);
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject2 = this.mHandler.obtainMessage(16711689);
            localObject1 = localObject2;
          }
          try
          {
            ((JSONObject)localObject5).put("msg", localObject4);
            ((Message)localObject2).obj = localObject5;
            this.mHandler.sendMessage((Message)localObject2);
            this.mState = 0;
            return;
          }
          catch (JSONException localJSONException1) {}
          localObject4 = this.mHandler.obtainMessage(16711690);
          localObject1 = localObject4;
          ((JSONObject)localObject5).put("msg", acfp.m(2131716901));
          localObject2 = localObject4;
          localObject1 = localObject4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject1 = localObject4;
          QLog.d("WebRecordApiPlugin", 2, "scalePublishImage failed: path = " + this.b.path);
          localObject2 = localObject4;
          continue;
        }
        catch (JSONException localJSONException2)
        {
          Object localObject3;
          localObject1 = null;
          continue;
        }
        localJSONException1.printStackTrace();
        localObject3 = localObject1;
      }
    }
  }
  
  public class a
    implements aqnt.a, QQRecorder.a
  {
    private aqnt a;
    protected WebRecordApiPlugin.AudioUploadTask a;
    private AppInterface app;
    private QQRecorder b;
    private boolean beZ = true;
    private double cJ;
    private Handler cZ = new ailt(this, Looper.getMainLooper());
    int fateOfRecorder = 0;
    private String filePath;
    public BaseActivity i;
    private int mAudioType = 1;
    private int maxTime = 60000;
    
    public a(AppInterface paramAppInterface, BaseActivity paramBaseActivity)
    {
      this.app = paramAppInterface;
      this.i = paramBaseActivity;
    }
    
    private void LL(String paramString)
    {
      Object localObject = new Time();
      ((Time)localObject).setToNow();
      if (((Time)localObject).hour < 3) {}
      String str;
      do
      {
        return;
        localObject = aqfe.get(this.i, "LAST_DELETE_TIME");
        str = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
      } while ((localObject != null) && (str.equals(localObject)));
      ThreadManager.post(new WebRecordApiPlugin.AudioApiHelper.2(this, paramString), 8, null, false);
    }
    
    private int getFateOfRecorder()
    {
      return this.fateOfRecorder;
    }
    
    private String n(int paramInt, boolean paramBoolean)
    {
      String str1 = acbn.SDCARD_PATH + "webrecord/";
      Object localObject = null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebRecordApiPlugin", 2, "getTransferFilePath dir: " + str1);
        }
        String str2 = vd();
        File localFile = new File(str1);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        localObject = new File(str1 + str2 + (String)localObject);
        if ((paramBoolean) && (!((File)localObject).exists())) {}
        try
        {
          ((File)localObject).createNewFile();
          label163:
          if (QLog.isColorLevel()) {
            QLog.d("WebRecordApiPlugin", 2, "getTransferFilePath : " + ((File)localObject).getAbsoluteFile().toString());
          }
          return ((File)localObject).getAbsoluteFile().toString();
          localObject = ".amr";
          continue;
          localObject = ".slk";
        }
        catch (IOException localIOException)
        {
          break label163;
        }
      }
    }
    
    private void setFateOfRecorder(int paramInt)
    {
      this.fateOfRecorder = paramInt;
    }
    
    private String vd()
    {
      try
      {
        Thread.sleep(1L);
        long l = System.currentTimeMillis();
        String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
        return str;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      finally {}
    }
    
    public void IL(String paramString)
    {
      if (this.jdField_a_of_type_Aqnt != null)
      {
        this.jdField_a_of_type_Aqnt.pause();
        WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.c(WebRecordApiPlugin.this), new String[] { "{'code':1,'recordID':'" + paramString + "'}" });
      }
    }
    
    public void LK(String paramString)
    {
      if (this.jdField_a_of_type_Aqnt != null)
      {
        this.jdField_a_of_type_Aqnt.release();
        this.jdField_a_of_type_Aqnt = null;
        WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.c(WebRecordApiPlugin.this), new String[] { "{'code':2,'recordID':'" + paramString + "'}" });
      }
    }
    
    public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onBeginReceiveData() is called");
      }
      this.maxTime -= 200;
      this.cZ.sendEmptyMessageDelayed(16711687, this.maxTime);
      return this.maxTime + 200;
    }
    
    public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderPrepare() is called");
      }
      paramRecorderParam = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
      alid.nY(paramString);
      alid.a(paramString, paramRecorderParam, paramRecorderParam.length);
      aqge.ce(2131230758, false);
    }
    
    public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderEnd() is called");
      }
      if (this.beZ)
      {
        this.beZ = false;
        this.cZ.removeMessages(1);
      }
      int j = getFateOfRecorder();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + j);
      }
      byte[] arrayOfByte;
      Object localObject;
      if (j == 0)
      {
        alid.nZ(paramString);
        aqfe.J(this.i, this.filePath, Double.toString(this.cJ));
        arrayOfByte = aqhq.readFile(paramString);
        localObject = null;
        paramRecorderParam = (QQRecorder.RecorderParam)localObject;
        if (arrayOfByte == null) {}
      }
      try
      {
        paramRecorderParam = Base64.encodeToString(arrayOfByte, 0);
        localObject = paramRecorderParam;
        if (TextUtils.isEmpty(paramRecorderParam)) {
          localObject = "";
        }
        paramRecorderParam = new JSONObject();
        do
        {
          try
          {
            paramRecorderParam.put("code", 1);
            paramRecorderParam.put("recordID", paramString);
            paramRecorderParam.put("msg", localObject);
            paramString = paramRecorderParam.toString();
            if (QLog.isColorLevel()) {
              QLog.d("WebRecordApiPlugin", 2, "onRecorderEnd result=" + paramString);
            }
            WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { paramString });
            return;
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        } while (j != 1);
        alid.Of(paramString);
        return;
      }
      catch (Exception paramRecorderParam)
      {
        for (;;)
        {
          paramRecorderParam = (QQRecorder.RecorderParam)localObject;
        }
      }
    }
    
    public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderError() is called");
      }
      alid.Of(paramString1);
      this.cZ.removeMessages(1);
      WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderError is called'}" });
    }
    
    public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderSilceEnd() is called maxAmplitude=" + paramInt2);
      }
      alid.a(paramString, paramArrayOfByte, paramInt1);
      if (this.beZ)
      {
        this.beZ = false;
        this.cZ.removeMessages(1);
      }
      this.cJ = paramDouble;
    }
    
    public void a(JSONArray paramJSONArray, String paramString1, String paramString2)
    {
      int j = 0;
      if (j < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optString(j, "");
        File localFile = new File((String)localObject);
        String str = aqfe.get(this.i, (String)localObject);
        long l;
        if ((localFile.exists()) && (!TextUtils.isEmpty(str)))
        {
          double d = Double.valueOf(str).doubleValue();
          localFile = new File((String)localObject);
          if (localFile.exists())
          {
            l = localFile.length();
            label97:
            localObject = new AudioInfo((String)localObject, (int)d, l);
            this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioUploadTask = new WebRecordApiPlugin.AudioUploadTask(WebRecordApiPlugin.this, this.i, this.cZ, paramString1, paramString2, (AudioInfo)localObject);
            ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioUploadTask, 5, null, true);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          l = 0L;
          break label97;
          WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.a(WebRecordApiPlugin.this), new String[] { "{'code':1,'recordID':'" + (String)localObject + "','msg':'record not found or its duration is 0'}" });
        }
      }
    }
    
    public void ap(int paramInt)
    {
      if ((this.b != null) && (!this.b.isStop()) && (!this.cZ.hasMessages(16711686)))
      {
        this.cZ.removeMessages(16711688);
        this.cZ.removeMessages(16711686);
        this.cZ.removeMessages(16711687);
        if (QLog.isColorLevel()) {
          QLog.d("WebRecordApiPlugin", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
        }
        this.fateOfRecorder = paramInt;
        if (this.b != null)
        {
          Message localMessage = this.cZ.obtainMessage(16711686);
          this.cZ.sendMessageDelayed(localMessage, 200L);
        }
      }
    }
    
    public void as(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderVolumeStateChanged() is called");
      }
    }
    
    public void at(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderNotReady() is called,path is:" + paramString);
      }
      WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderNotReady is called'}" });
    }
    
    public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderAbnormal() is called");
      }
      WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderAbnormal is called'}" });
    }
    
    public int bz()
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderStart() is called");
      }
      this.cZ.removeMessages(1);
      this.cZ.sendEmptyMessageDelayed(1, 2000L);
      this.beZ = true;
      WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':0,'recordID':'" + this.filePath + "','msg':''}" });
      return 250;
    }
    
    public void c(int paramInt1, String paramString, int paramInt2)
    {
      LK(paramString);
    }
    
    public void c(String paramString, int paramInt1, int paramInt2) {}
    
    public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitFailed() is called");
      }
      WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':-1,'recordID':'-1','msg':'onInitFailed is called'}" });
    }
    
    public void d(String paramString, int paramInt1, int paramInt2) {}
    
    public void hB()
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitSuccess() is called");
      }
    }
    
    public boolean isRecording()
    {
      return (this.b != null) && (this.b.isRecording());
    }
    
    public void iu(int paramInt1, int paramInt2)
    {
      if ((paramInt1 == 1) || (paramInt1 == 0)) {
        this.mAudioType = paramInt1;
      }
      if ((paramInt2 > 0) && (paramInt2 * 1000 < this.maxTime)) {
        this.maxTime = (paramInt2 * 1000);
      }
      if ((this.b != null) && (this.b.isRecording()))
      {
        WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':-1,'recordID':'-1','msg':'is recording now'}" });
        return;
      }
      Object localObject = Environment.getExternalStorageDirectory();
      if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
      {
        paramInt1 = 1;
        if ((!Environment.getExternalStorageState().equals("mounted")) || (paramInt1 == 0)) {
          break label248;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          localObject = aqgz.getSDCardMemory();
          if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
          {
            if (AudioHelper.isForbidByRubbishMeizu(1))
            {
              WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.i.getString(2131700599) + "," + this.i.getString(2131700600) + "'}" });
              return;
              paramInt1 = 0;
              break;
              label248:
              paramInt1 = 0;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("WebRecordApiPlugin", 2, "startRecord() is called");
            }
            if (this.b == null) {
              this.b = new QQRecorder(this.i);
            }
            LL(acbn.SDCARD_PATH + "webrecord/");
            if (this.mAudioType == 0) {
              localObject = new QQRecorder.RecorderParam(aqlv.dZQ, 0, 0);
            }
            for (this.filePath = n(2, true);; this.filePath = n(25, true))
            {
              this.b.b((QQRecorder.RecorderParam)localObject);
              if (QLog.isColorLevel()) {
                QLog.i("QQRecorder", 2, "path: " + this.filePath);
              }
              this.b.a(this);
              aqge.m(this.i, true);
              this.b.start(this.filePath);
              setFateOfRecorder(0);
              return;
              localObject = new QQRecorder.RecorderParam(aqlv.dZR, 16000, 1);
            }
          }
          WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.i.getString(2131719248) + "'}" });
          return;
        }
      }
      WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.b(WebRecordApiPlugin.this), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.i.getString(2131696377) + "'}" });
    }
    
    public void play(String paramString)
    {
      Object localObject = new File(paramString);
      if ((((File)localObject).exists()) && (aqfe.get(this.i, paramString) != null))
      {
        double d = Double.valueOf(aqfe.get(this.i, paramString)).doubleValue();
        long l;
        if (((File)localObject).exists())
        {
          l = ((File)localObject).length();
          localObject = new AudioInfo(paramString, (int)d, l);
          if (this.jdField_a_of_type_Aqnt != null) {
            break label196;
          }
          this.jdField_a_of_type_Aqnt = new aqnt(((AudioInfo)localObject).path, new Handler(), ((AudioInfo)localObject).getAudioType());
          this.jdField_a_of_type_Aqnt.cf(this.i);
          this.jdField_a_of_type_Aqnt.aFk();
          this.jdField_a_of_type_Aqnt.a(this);
          this.jdField_a_of_type_Aqnt.start();
        }
        for (;;)
        {
          WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.c(WebRecordApiPlugin.this), new String[] { "{'code':0,'recordID':'" + paramString + "'}" });
          return;
          l = 0L;
          break;
          label196:
          this.jdField_a_of_type_Aqnt.bvB();
        }
      }
      WebRecordApiPlugin.this.callJs(WebRecordApiPlugin.c(WebRecordApiPlugin.this), new String[] { "{'code':3,'recordID':'" + paramString + "'}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin
 * JD-Core Version:    0.7.0.1
 */