import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.VolumeReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import mqq.app.AppRuntime;

public class mzk
{
  private mzk.b jdField_a_of_type_Mzk$b;
  private mzk.d jdField_a_of_type_Mzk$d;
  private String akU = "";
  private boolean anz;
  private boolean aqL;
  private boolean aqM = true;
  private boolean aqO = true;
  private boolean aqP;
  private AudioManager audioManager;
  private Runnable cK = new VideoVolumeController.1(this);
  private Handler handler = new Handler(Looper.getMainLooper());
  private ArrayList<mzk.a> lz = new ArrayList();
  private Timer o;
  
  public static final mzk a()
  {
    return mzk.c.b();
  }
  
  public void a(mzk.a parama)
  {
    this.lz.add(parama);
  }
  
  public void b(mzk.a parama)
  {
    this.lz.remove(parama);
  }
  
  public void ce(Context paramContext)
  {
    if (paramContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "inKandianModule: context:" + paramContext);
      }
      oa(Integer.toHexString(System.identityHashCode(paramContext)));
    }
  }
  
  public void cf(Context paramContext)
  {
    if (paramContext != null) {
      ob(Integer.toHexString(System.identityHashCode(paramContext)));
    }
  }
  
  public int getStreamMaxVolume(int paramInt)
  {
    if (this.audioManager != null) {
      return this.audioManager.getStreamMaxVolume(paramInt);
    }
    return 0;
  }
  
  void oW(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.lz.iterator();
      while (localIterator.hasNext()) {
        ((mzk.a)localIterator.next()).aUK();
      }
    }
  }
  
  public void oa(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoVolumeController", 2, "inKandianModule: hexString:" + paramString);
    }
    if (!"".equals(this.akU))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "inKandianModule origin:" + this.akU + " act:" + paramString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoVolumeController", 2, "real inKandianModule origin:" + this.akU + " act:" + paramString);
    }
    this.akU = paramString;
    this.audioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    this.jdField_a_of_type_Mzk$d = new mzk.d(null);
    paramString = new IntentFilter();
    paramString.addAction("android.media.VOLUME_CHANGED_ACTION");
    paramString.addAction("android.intent.action.HEADSET_PLUG");
    paramString.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramString.addAction("android.media.RINGER_MODE_CHANGED");
    this.aqO = true;
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_Mzk$d, paramString);
    paramString = (TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone");
    this.jdField_a_of_type_Mzk$b = new mzk.b();
    paramString.listen(this.jdField_a_of_type_Mzk$b, 32);
  }
  
  public void ob(String paramString)
  {
    if (this.akU.equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "really outKandianModule origin is:" + this.akU + " act:" + paramString);
      }
      if (this.audioManager != null) {
        this.audioManager.abandonAudioFocus(null);
      }
      if (!"".equals(this.akU))
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.jdField_a_of_type_Mzk$d);
        ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(this.jdField_a_of_type_Mzk$b, 0);
      }
      this.jdField_a_of_type_Mzk$b = null;
      this.jdField_a_of_type_Mzk$d = null;
      this.akU = "";
      this.audioManager = null;
      if (this.o != null)
      {
        this.o.cancel();
        this.o.purge();
        this.o = null;
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VideoVolumeController", 2, "outKandianModule origin:" + this.akU + " act:" + paramString);
  }
  
  /* Error */
  public void z(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 88	mzk:anz	Z
    //   7: aload_0
    //   8: getfield 65	mzk:handler	Landroid/os/Handler;
    //   11: ifnull +82 -> 93
    //   14: aload_0
    //   15: getfield 72	mzk:cK	Ljava/lang/Runnable;
    //   18: ifnull +75 -> 93
    //   21: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +39 -> 63
    //   27: ldc 112
    //   29: iconst_2
    //   30: new 114	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 267
    //   40: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 270	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: ldc_w 272
    //   50: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: getfield 65	mzk:handler	Landroid/os/Handler;
    //   67: aload_0
    //   68: getfield 72	mzk:cK	Ljava/lang/Runnable;
    //   71: invokevirtual 276	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   74: aload_0
    //   75: getfield 88	mzk:anz	Z
    //   78: ifeq +18 -> 96
    //   81: aload_0
    //   82: getfield 65	mzk:handler	Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield 72	mzk:cK	Ljava/lang/Runnable;
    //   89: invokevirtual 280	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   92: pop
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield 65	mzk:handler	Landroid/os/Handler;
    //   100: aload_0
    //   101: getfield 72	mzk:cK	Ljava/lang/Runnable;
    //   104: ldc2_w 281
    //   107: invokevirtual 286	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   110: pop
    //   111: goto -18 -> 93
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	mzk
    //   0	119	1	paramBoolean	boolean
    //   0	119	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	63	114	finally
    //   63	93	114	finally
    //   96	111	114	finally
  }
  
  public static abstract interface a
  {
    public abstract void aUK();
    
    public abstract void oZ(boolean paramBoolean);
    
    public abstract void sX(int paramInt);
  }
  
  class b
    extends PhoneStateListener
  {
    b() {}
    
    public void onCallStateChanged(int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "onCallStateChanged:" + paramInt);
      }
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        mzk.this.oW(true);
        return;
      }
      mzk.this.oW(true);
    }
  }
  
  static class c
  {
    private static final mzk a = new mzk(null);
  }
  
  public class d
    extends BroadcastReceiver
  {
    private d() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().isBackground_Stop) || (BaseApplicationImpl.getApplication().getRuntime().isBackground_Pause)) {}
      do
      {
        for (;;)
        {
          return;
          if (mzk.a(mzk.this) == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoVolumeController", 2, "VolumeReceiver onReceive null");
            }
          }
          else if (mzk.b(mzk.this)) {
            if (mzk.c(mzk.this))
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoVolumeController", 2, "dynamicPauseReceive true");
              }
            }
            else
            {
              int i;
              try
              {
                if (!paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                  break;
                }
                i = mzk.a(mzk.this).getStreamVolume(3);
                if (QLog.isColorLevel()) {
                  QLog.d("VideoVolumeController", 2, "volume change:" + i);
                }
                if (mzk.d(mzk.this))
                {
                  QLog.d("VideoVolumeController", 2, "volume change shield ");
                  return;
                }
              }
              catch (Exception paramContext)
              {
                QLog.d("VideoVolumeController", 1, "VolumeReceiver", paramContext);
                return;
              }
              paramContext = mzk.a(mzk.this).iterator();
              while (paramContext.hasNext()) {
                ((mzk.a)paramContext.next()).sX(i);
              }
            }
          }
        }
      } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
      boolean bool = mzk.a(mzk.this).isWiredHeadsetOn();
      if (mzk.e(mzk.this))
      {
        mzk.a(mzk.this, false);
        return;
      }
      mzk.b(mzk.this, true);
      paramContext = mzk.a(mzk.this).iterator();
      while (paramContext.hasNext()) {
        ((mzk.a)paramContext.next()).oZ(bool);
      }
      mzk.a(mzk.this).postDelayed(new VideoVolumeController.VolumeReceiver.1(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzk
 * JD-Core Version:    0.7.0.1
 */