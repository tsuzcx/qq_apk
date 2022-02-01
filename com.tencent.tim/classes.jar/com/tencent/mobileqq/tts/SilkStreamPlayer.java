package com.tencent.mobileqq.tts;

import android.app.Application;
import android.content.Context;
import android.media.AudioTrack;
import android.os.Handler;
import aofy;
import apzn;
import apzo;
import apzr;
import aqhs;
import aqiw;
import aqlv;
import arwv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.TtsResBody.RspBody;
import com.tencent.mobileqq.richmedia.TtsResBody.voice_item;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import jqc;
import org.json.JSONException;
import org.json.JSONObject;

public class SilkStreamPlayer
{
  private static long asr;
  private SilkStreamPlayerThread jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread;
  private a jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a;
  private HttpsURLConnection jdField_a_of_type_JavaxNetSslHttpsURLConnection;
  private String bce;
  private String crR;
  private Application mApplication = BaseApplicationImpl.sApplication;
  private Context mCtx;
  private InputStream mInputStream;
  private String mUin;
  private String skey;
  
  public SilkStreamPlayer(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mCtx = paramContext;
    this.crR = aofy.og(paramString1).replaceAll("/", " ");
    this.mUin = paramString2;
    this.skey = paramString3;
  }
  
  private InputStream c()
    throws IOException
  {
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection = ((HttpsURLConnection)new URL("https://textts.qq.com/cgi-bin/tts").openConnection());
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setRequestMethod("POST");
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setRequestProperty("Accept", "application/json");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uin=");
    ((StringBuilder)localObject1).append(this.mUin);
    ((StringBuilder)localObject1).append(";skey=");
    ((StringBuilder)localObject1).append(this.skey);
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setRequestProperty("Cookie", ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setDoOutput(true);
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setDoInput(true);
    try
    {
      localObject1 = SSLContext.getDefault();
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.setSSLSocketFactory(((SSLContext)localObject1).getSocketFactory());
      }
      localObject1 = new JSONObject();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      try
      {
        ((JSONObject)localObject1).put("appid", "201908021016");
        ((JSONObject)localObject1).put("uin", Long.valueOf(this.mUin));
        ((JSONObject)localObject1).put("sendUin", Long.valueOf(this.bce));
        ((JSONObject)localObject1).put("text", this.crR);
        ((JSONObject)localObject1).put("textmd5", arwv.toMD5(this.crR));
        long l = asr;
        asr = 1L + l;
        ((JSONObject)localObject1).put("seq", l);
        ((JSONObject)localObject1).put("clientVersion", "AND_" + AppSetting.getAppId() + "_" + "3.4.4");
        ((JSONObject)localObject1).put("net", jqc.getNetWorkType());
        DataOutputStream localDataOutputStream = new DataOutputStream(this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getOutputStream());
        localDataOutputStream.write(new String(((JSONObject)localObject1).toString().getBytes(), "utf-8").getBytes());
        localDataOutputStream.flush();
        localDataOutputStream.close();
        if (this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getResponseCode() == 200)
        {
          return this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getInputStream();
          localNoSuchAlgorithmException = localNoSuchAlgorithmException;
          QLog.e("SilkStreamPlayer", 2, localNoSuchAlgorithmException, new Object[0]);
          Object localObject2 = null;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SilkStreamPlayer", 1, localJSONException, new Object[0]);
          }
        }
      }
    }
    return null;
  }
  
  private byte[] e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  private boolean t(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    byte[] arrayOfByte = aqhs.hexStr2Bytes("02232153494C4B5F5633");
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < 10)
      {
        if (arrayOfByte[i] != paramArrayOfByte[i]) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void Uh(String paramString)
  {
    this.bce = paramString;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a = parama;
  }
  
  public boolean isPlaying()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread != null) && (SilkStreamPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread));
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a = null;
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread == null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread = new SilkStreamPlayerThread(this.mApplication);
    }
    ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread, 128, null, true);
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread != null)
    {
      SilkStreamPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$SilkStreamPlayerThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a.onStop();
    }
  }
  
  class SilkStreamPlayerThread
    implements Runnable
  {
    private SilkCodecWrapper a;
    private boolean cTd;
    private boolean cTe;
    private volatile boolean cxm;
    private int duy;
    private byte[] ff;
    private byte[] fg;
    private AudioTrack mAudioTrack;
    private int sampleRate;
    
    public SilkStreamPlayerThread(Application paramApplication)
    {
      this.a = new SilkCodecWrapper(paramApplication, false);
    }
    
    private void Xi(int paramInt)
    {
      if (!this.cTd)
      {
        this.sampleRate = paramInt;
        this.duy = aqlv.kg(paramInt);
        this.ff = new byte[this.duy];
        this.fg = new byte[this.duy];
      }
      try
      {
        if (this.a == null) {
          this.a = new SilkCodecWrapper(SilkStreamPlayer.a(SilkStreamPlayer.this), false);
        }
        this.a.init(paramInt, 0, 1);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.cxm = false;
          QLog.d("SilkStreamPlayer", 1, "SILK解码器初始化失败", localIOException);
        }
      }
      this.cTd = true;
    }
    
    private void Xj(int paramInt)
    {
      if (!this.cTe)
      {
        int i = AudioTrack.getMinBufferSize(paramInt, 4, 2);
        if (this.mAudioTrack != null)
        {
          this.mAudioTrack.pause();
          this.mAudioTrack.flush();
          this.mAudioTrack.stop();
        }
        this.mAudioTrack = new AudioTrack(3, paramInt, 1, 2, i, 1);
        this.mAudioTrack.play();
        this.cTe = true;
      }
    }
    
    void a(InputStream paramInputStream, byte[] paramArrayOfByte)
    {
      paramArrayOfByte = new byte[2];
      try
      {
        if ((this.cxm) && (paramInputStream.available() > 0))
        {
          if (this.a != null) {
            break label35;
          }
          this.cxm = false;
        }
        for (;;)
        {
          paramInputStream.close();
          return;
          label35:
          if (paramInputStream.read(paramArrayOfByte, 0, 2) > 0) {
            break;
          }
          this.cxm = false;
          if (QLog.isColorLevel()) {
            QLog.d("SilkStreamPlayer", 1, "SILK帧播size解析错误");
          }
        }
      }
      catch (IOException paramInputStream)
      {
        while (QLog.isColorLevel())
        {
          QLog.d("SilkStreamPlayer", 2, paramInputStream, new Object[0]);
          return;
          int i = aqlv.z(paramArrayOfByte);
          if ((i < 0) || (i > this.ff.length))
          {
            this.cxm = false;
            if (QLog.isColorLevel()) {
              QLog.d("SilkStreamPlayer", 1, "SILK帧size不在正确范围内");
            }
          }
          else
          {
            paramInputStream.read(this.ff, 0, i);
            i = this.a.a(this.ff, this.fg, i, this.fg.length);
            if (i < 0)
            {
              this.cxm = false;
              if (QLog.isColorLevel()) {
                QLog.d("SilkStreamPlayer", 1, "SILK解码器解码错误");
              }
            }
            else if (this.cxm)
            {
              i = this.mAudioTrack.write(this.fg, 0, i);
              this.mAudioTrack.flush();
              if (i < 0)
              {
                this.cxm = false;
                if (QLog.isColorLevel()) {
                  QLog.e("SilkStreamPlayer", 1, "AudioTrack播放缓冲区写入错误");
                }
              }
            }
          }
        }
      }
    }
    
    public void run()
    {
      SilkStreamPlayer.a(SilkStreamPlayer.this, apzr.a().get(MD5Coding.encodeHexStr(SilkStreamPlayer.a(SilkStreamPlayer.this))));
      int j;
      if (SilkStreamPlayer.a(SilkStreamPlayer.this) != null) {
        j = 1;
      }
      for (;;)
      {
        if (this.a != null) {}
        try
        {
          this.a.close();
          this.a.release();
          this.cxm = true;
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          localapzn = new apzn(SilkStreamPlayer.a(SilkStreamPlayer.this));
          localapzo = new apzo(localByteArrayOutputStream);
          i = 1;
          if (this.cxm)
          {
            if (!aqiw.isNetworkAvailable(SilkStreamPlayer.a(SilkStreamPlayer.this)))
            {
              this.cxm = false;
              ThreadManagerV2.getUIHandlerV2().post(new SilkStreamPlayer.SilkStreamPlayerThread.2(this));
              i = 0;
              if ((j == 0) && (i != 0)) {
                apzr.a().a(SilkStreamPlayer.a(SilkStreamPlayer.this), localByteArrayOutputStream);
              }
              this.cxm = false;
              if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() == 0)) {}
            }
            try
            {
              this.mAudioTrack.pause();
              this.mAudioTrack.flush();
              this.mAudioTrack.stop();
              this.mAudioTrack.release();
              if (this.a != null) {
                this.a.release();
              }
              localapzn.close();
              if (SilkStreamPlayer.a(SilkStreamPlayer.this).available() > 0) {
                SilkStreamPlayer.a(SilkStreamPlayer.this).close();
              }
              SilkStreamPlayer.a(SilkStreamPlayer.this).disconnect();
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Object localObject3;
                Object localObject1;
                byte[] arrayOfByte;
                Object localObject4;
                Object localObject2;
                int k;
                List localList;
                int m;
                if (QLog.isColorLevel()) {
                  QLog.d("SilkStreamPlayer", 1, localException2, new Object[0]);
                }
              }
            }
            this.mAudioTrack = null;
            this.a.eer();
            this.cTd = false;
            this.cTe = false;
            if (SilkStreamPlayer.a(SilkStreamPlayer.this) != null) {
              SilkStreamPlayer.a(SilkStreamPlayer.this).onStop();
            }
            do
            {
              return;
              i = 3;
              try
              {
                do
                {
                  if (SilkStreamPlayer.a(SilkStreamPlayer.this) != null) {
                    SilkStreamPlayer.a(SilkStreamPlayer.this).ecM();
                  }
                  SilkStreamPlayer.a(SilkStreamPlayer.this, SilkStreamPlayer.b(SilkStreamPlayer.this));
                  if (SilkStreamPlayer.a(SilkStreamPlayer.this) != null) {
                    SilkStreamPlayer.a(SilkStreamPlayer.this).ecN();
                  }
                  InputStream localInputStream = SilkStreamPlayer.a(SilkStreamPlayer.this);
                  if (localInputStream != null) {
                    break;
                  }
                  j = i - 1;
                  i = j;
                } while (j > 0);
              }
              catch (IOException localIOException1)
              {
                for (;;)
                {
                  if (SilkStreamPlayer.a(SilkStreamPlayer.this) != null) {
                    SilkStreamPlayer.a(SilkStreamPlayer.this).ecN();
                  }
                  QLog.d("SilkStreamPlayer", 2, localIOException1, new Object[0]);
                }
              }
              if ((SilkStreamPlayer.a(SilkStreamPlayer.this) != null) && (SilkStreamPlayer.a(SilkStreamPlayer.this) != null)) {
                break label1009;
              }
            } while (!QLog.isColorLevel());
            QLog.d("SilkStreamPlayer", 1, "InputStream / 网络连接失败");
            ThreadManagerV2.getUIHandlerV2().post(new SilkStreamPlayer.SilkStreamPlayerThread.1(this));
            return;
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            apzn localapzn;
            apzo localapzo;
            int i;
            if (QLog.isColorLevel())
            {
              QLog.e("SilkStreamPlayer", 1, localIOException2, new Object[0]);
              continue;
              if (!this.cxm)
              {
                i = 0;
              }
              else
              {
                localObject3 = new byte[0];
                localObject1 = localObject3;
                try
                {
                  if (SilkStreamPlayer.a(SilkStreamPlayer.this) != null)
                  {
                    localObject1 = localObject3;
                    SilkStreamPlayer.a(SilkStreamPlayer.this).ecM();
                  }
                  localObject1 = localObject3;
                  arrayOfByte = localapzn.az();
                  if ((j == 0) && (arrayOfByte != null))
                  {
                    localObject1 = arrayOfByte;
                    localapzo.append(arrayOfByte, 0, arrayOfByte.length);
                  }
                  localObject3 = arrayOfByte;
                  localObject1 = arrayOfByte;
                  if (SilkStreamPlayer.a(SilkStreamPlayer.this) != null)
                  {
                    localObject1 = arrayOfByte;
                    SilkStreamPlayer.a(SilkStreamPlayer.this).ecN();
                    localObject3 = arrayOfByte;
                  }
                  if ((localObject3 != null) && (localObject3.length != 0)) {
                    break label720;
                  }
                  this.cxm = false;
                }
                catch (IOException localIOException3)
                {
                  for (;;)
                  {
                    try
                    {
                      localapzo.close();
                      i = 1;
                    }
                    catch (Exception localException1)
                    {
                      QLog.e("SilkStreamPlayer", 1, "cout close err: ", localException1);
                      i = 0;
                    }
                    localIOException3 = localIOException3;
                    QLog.e("SilkStreamPlayer", 1, "SilkStreamPlayerThread#run byteArray contact error", localIOException3);
                    localObject4 = localObject1;
                    if (SilkStreamPlayer.a(SilkStreamPlayer.this) != null)
                    {
                      SilkStreamPlayer.a(SilkStreamPlayer.this).ecN();
                      localObject4 = localObject1;
                    }
                  }
                }
                continue;
                label720:
                localObject2 = new TtsResBody.RspBody();
                try
                {
                  ((TtsResBody.RspBody)localObject2).mergeFrom((byte[])localObject4);
                  k = ((TtsResBody.RspBody)localObject2).pcm_sample_rate.get();
                  if (k == 0)
                  {
                    this.cxm = false;
                    i = 0;
                  }
                }
                catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
                {
                  for (;;)
                  {
                    QLog.e("SilkStreamPlayer", 1, "TtsResBody序列化失败" + localObject4);
                  }
                  Xi(k);
                  Xj(k);
                  if (!this.cxm)
                  {
                    i = 0;
                    continue;
                  }
                  localList = ((TtsResBody.RspBody)localObject2).voice_data.get();
                  if (localList.size() <= 0)
                  {
                    this.cxm = false;
                    if (!QLog.isColorLevel()) {
                      break label1004;
                    }
                    QLog.e("SilkStreamPlayer", 1, "当前SILK帧无数据");
                    i = 0;
                    continue;
                  }
                  k = 0;
                  while ((k < localList.size()) && (this.cxm))
                  {
                    localObject4 = ((TtsResBody.voice_item)localList.get(k)).voice.get().toByteArray();
                    localObject2 = localObject4;
                    m = i;
                    if (i != 0)
                    {
                      localObject2 = localObject4;
                      m = i;
                      if (SilkStreamPlayer.a(SilkStreamPlayer.this, (byte[])localObject4))
                      {
                        localObject2 = SilkStreamPlayer.a(SilkStreamPlayer.this, (byte[])localObject4, 10, localObject4.length - 10);
                        m = 0;
                      }
                    }
                    a(new ByteArrayInputStream((byte[])localObject2), (byte[])localObject2);
                    k += 1;
                    i = m;
                  }
                }
                continue;
                label1004:
                i = 0;
              }
            }
          }
          label1009:
          j = 0;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ecM();
    
    public abstract void ecN();
    
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.SilkStreamPlayer
 * JD-Core Version:    0.7.0.1
 */