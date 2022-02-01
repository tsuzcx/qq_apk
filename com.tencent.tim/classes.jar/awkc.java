import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWVoiceController.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class awkc
  implements aqnt.a, QQRecorder.a
{
  public static String cQZ = "record_status";
  public static String cRa = "record_url";
  public static String cRb = "record_local_path";
  public static String cRc = "shard_pref_name";
  private aqnt jdField_a_of_type_Aqnt;
  private awkc.a jdField_a_of_type_Awkc$a;
  private QQRecorder d;
  public int dFH = 360000;
  private int eBx;
  private String mAudioUrl;
  protected WeakReference<Context> mContext;
  private Handler mHandler = new awkd(this);
  private SharedPreferences mPref;
  
  public awkc(Context paramContext, awkc.a parama)
  {
    this.mContext = new WeakReference(paramContext);
    this.jdField_a_of_type_Awkc$a = parama;
  }
  
  private boolean aNd()
  {
    if (QQServiceForAV.vx())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHWVoiceController", 2, "VideoProcessAlive");
      }
      return true;
    }
    if (this.mContext == null) {
      return false;
    }
    Object localObject = (Context)this.mContext.get();
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video")) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void abP(String paramString)
  {
    if (this.mContext == null) {}
    do
    {
      return;
      localObject = (Context)this.mContext.get();
    } while (localObject == null);
    this.mPref = n((Context)localObject);
    Object localObject = this.mPref.edit();
    ((SharedPreferences.Editor)localObject).remove(paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static SharedPreferences n(Context paramContext)
  {
    return paramContext.getSharedPreferences(cRc, 0);
  }
  
  public boolean YA()
  {
    if (this.jdField_a_of_type_Aqnt != null)
    {
      this.jdField_a_of_type_Aqnt.release();
      this.jdField_a_of_type_Aqnt = null;
      return true;
    }
    return false;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.dFH -= 200;
    this.mHandler.sendEmptyMessageDelayed(2, this.dFH);
    return this.dFH + 200;
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    paramRecorderParam = aqlv.c(paramRecorderParam.mAudioType, paramRecorderParam.mSampleRate);
    alid.nY(paramString);
    alid.a(paramString, paramRecorderParam, paramRecorderParam.length);
    aqge.ce(2131230758, false);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    alid.nZ(paramString);
    this.jdField_a_of_type_Awkc$a.d(paramString, paramDouble);
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    alid.Of(paramString1);
    this.jdField_a_of_type_Awkc$a.eDZ();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    alid.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void abN(String paramString)
  {
    this.mAudioUrl = paramString;
    String str2 = sq(paramString);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!new File(str2).exists())
      {
        abP(paramString);
        str1 = null;
      }
    }
    if ((this.jdField_a_of_type_Awkc$a != null) && (!TextUtils.isEmpty(str1)))
    {
      this.jdField_a_of_type_Awkc$a.eB(1, paramString);
      abQ(str1);
      return;
    }
    ThreadManager.postImmediately(new TroopHWVoiceController.1(this), null, false);
  }
  
  public void abO(String paramString)
  {
    if (this.mContext == null) {}
    do
    {
      return;
      localObject = (Context)this.mContext.get();
    } while (localObject == null);
    this.mPref = n((Context)localObject);
    Object localObject = this.mPref.edit();
    ((SharedPreferences.Editor)localObject).putString(this.mAudioUrl, paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void abQ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_Aqnt != null) {
      return;
    }
    Handler localHandler = new Handler();
    if (paramString.endsWith("amr")) {}
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_Aqnt = new aqnt(paramString, localHandler, i);
      this.jdField_a_of_type_Aqnt.cf(BaseApplication.getContext());
      this.jdField_a_of_type_Aqnt.aFk();
      this.jdField_a_of_type_Aqnt.a(this);
      this.jdField_a_of_type_Aqnt.start();
      return;
    }
  }
  
  public void abR(String paramString)
  {
    if (this.mContext == null) {}
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.mContext.get();
    } while (localContext == null);
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label115;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1)
        {
          if (aNd())
          {
            QQToast.a(BaseApplication.getContext(), 2131697385, 0).show();
            return;
            i = 0;
            break;
            label115:
            i = 0;
            continue;
          }
          if (AudioHelper.isForbidByRubbishMeizu(1))
          {
            ChatActivityUtils.db(localContext);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHWVoiceController", 2, "startRecord() is called");
          }
          if (this.d == null) {
            this.d = new QQRecorder(localContext);
          }
          localObject = new QQRecorder.RecorderParam(aqlv.dZQ, 0, 0);
          paramString = aojs.a(paramString, null, 2, null);
          this.d.b((QQRecorder.RecorderParam)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("QQRecorder", 2, "path: " + paramString);
          }
          this.d.a(this);
          aqge.m(localContext, true);
          if (QLog.isColorLevel()) {
            QLog.d("TroopHWVoiceController", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
          }
          this.d.start(paramString);
          return;
        }
        QQToast.a(BaseApplication.getContext(), 2131719248, 0).show();
        return;
      }
    }
    QQToast.a(BaseApplication.getContext(), 2131696377, 0).show();
  }
  
  public void as(int paramInt) {}
  
  public void at(String paramString) {}
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public int bz()
  {
    this.jdField_a_of_type_Awkc$a.eDY();
    return 250;
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    YA();
    if (this.jdField_a_of_type_Awkc$a == null) {
      return;
    }
    if (this.eBx > 0)
    {
      this.jdField_a_of_type_Awkc$a.eC(this.eBx, paramString);
      this.eBx = 0;
      return;
    }
    this.jdField_a_of_type_Awkc$a.eB(3, this.mAudioUrl);
  }
  
  public void c(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public void eD(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_Aqnt != null) {
      return;
    }
    Handler localHandler = new Handler();
    if (paramString.endsWith("amr")) {}
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_Aqnt = new aqnt(paramString, localHandler, i);
      this.jdField_a_of_type_Aqnt.cf(BaseApplication.getContext());
      this.jdField_a_of_type_Aqnt.aFk();
      this.jdField_a_of_type_Aqnt.a(this);
      this.eBx = paramInt;
      this.jdField_a_of_type_Aqnt.start();
      return;
    }
  }
  
  public void eEa()
  {
    if ((this.d != null) && (!this.d.isStop()))
    {
      this.mHandler.removeMessages(3);
      this.mHandler.removeMessages(2);
      this.mHandler.sendEmptyMessageDelayed(3, 200L);
    }
  }
  
  public void hB() {}
  
  public String sq(String paramString)
  {
    if (this.mContext == null) {
      return null;
    }
    Context localContext = (Context)this.mContext.get();
    if (localContext == null) {
      return null;
    }
    this.mPref = n(localContext);
    return this.mPref.getString(paramString, null);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString, double paramDouble);
    
    public abstract void eB(int paramInt, String paramString);
    
    public abstract void eC(int paramInt, String paramString);
    
    public abstract void eDY();
    
    public abstract void eDZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkc
 * JD-Core Version:    0.7.0.1
 */