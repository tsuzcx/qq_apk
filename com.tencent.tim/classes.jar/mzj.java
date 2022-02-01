import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.VolumeReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.WeakHashMap;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class mzj
{
  private static mzj jdField_a_of_type_Mzj;
  private mzj.a jdField_a_of_type_Mzj$a;
  private mzj.b jdField_a_of_type_Mzj$b;
  private mzj.c jdField_a_of_type_Mzj$c;
  private int aWA = -1;
  private int aWB = -1;
  private int aWC;
  private int aWz = -1;
  private String akS;
  private String akT = "";
  private boolean anz;
  private boolean aqE = true;
  private boolean aqF = true;
  private boolean aqG = true;
  private boolean aqH;
  private boolean aqI;
  private boolean aqJ;
  private boolean aqK = true;
  private boolean aqL;
  private boolean aqM = true;
  private boolean aqN;
  private boolean aqO = true;
  private boolean aqP;
  private AudioManager audioManager;
  private Runnable cK = new VideoVolumeControl.1(this);
  private Map<mye, Boolean> eB = new WeakHashMap();
  private Map<VideoFeedsPlayManager, Boolean> eC = new WeakHashMap();
  private Handler handler = new Handler(Looper.getMainLooper());
  private ArrayList<WeakReference<ImageView>> ly = new ArrayList();
  private Timer o;
  
  public static mzj a()
  {
    if (jdField_a_of_type_Mzj == null) {}
    try
    {
      if (jdField_a_of_type_Mzj == null) {
        jdField_a_of_type_Mzj = new mzj();
      }
      return jdField_a_of_type_Mzj;
    }
    finally {}
  }
  
  public static boolean av(Context paramContext)
  {
    try
    {
      int i = ((TelephonyManager)paramContext.getSystemService("phone")).getCallState();
      return (i == 1) || (i == 2);
    }
    catch (Exception paramContext)
    {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "obtain inCall info failed " + paramContext.toString());
    }
    return false;
  }
  
  public boolean Fa()
  {
    return this.aqF;
  }
  
  public boolean Fb()
  {
    return this.aqG;
  }
  
  public boolean Fc()
  {
    return !this.aqI;
  }
  
  public boolean P(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.aqH;
    }
    if (this.audioManager == null) {
      this.audioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    }
    if (this.audioManager.getStreamVolume(3) <= 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.aqH = paramBoolean;
      return this.aqH;
    }
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoFeedsPlayManager != null)
    {
      paramVideoFeedsPlayManager.setMute(P(false));
      if (!this.eC.containsKey(paramVideoFeedsPlayManager)) {
        this.eC.put(paramVideoFeedsPlayManager, Boolean.valueOf(true));
      }
      this.aWC = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "addVideoMgr :" + paramVideoFeedsPlayManager + " list:" + this.eC);
    }
  }
  
  public void aO(Activity paramActivity)
  {
    if (paramActivity == null) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "inKandianModule errParam，activity == null");
    }
    do
    {
      return;
      this.akS = paramActivity.toString();
      if ("".equals(this.akT)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "inKandianModule origin:" + this.akT + " act:" + paramActivity.toString());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "real inKandianModule origin:" + this.akT + " act:" + paramActivity.toString());
    }
    this.akT = paramActivity.toString();
    this.audioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    if (this.jdField_a_of_type_Mzj$c == null) {
      this.jdField_a_of_type_Mzj$c = new mzj.c(null);
    }
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.media.VOLUME_CHANGED_ACTION");
    paramActivity.addAction("android.intent.action.HEADSET_PLUG");
    paramActivity.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramActivity.addAction("android.media.RINGER_MODE_CHANGED");
    this.aqO = true;
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_Mzj$c, paramActivity);
    if (this.jdField_a_of_type_Mzj$a == null) {
      this.jdField_a_of_type_Mzj$a = new mzj.a();
    }
    ThreadManager.excute(new VideoVolumeControl.2(this), 16, null, true);
    if (this.jdField_a_of_type_Mzj$b == null) {
      this.jdField_a_of_type_Mzj$b = new mzj.b();
    }
    this.aWz = this.audioManager.getRingerMode();
    this.aWB = this.aWz;
  }
  
  public void aP(Activity paramActivity)
  {
    if (this.akT.equals(paramActivity.toString()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "really outKandianModule origin is:" + this.akT + " act:" + paramActivity.toString() + ",formDynamicTo1T3:" + this.aqJ);
      }
      if (this.audioManager != null) {
        this.audioManager.abandonAudioFocus(null);
      }
      if (!"".equals(this.akT))
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.jdField_a_of_type_Mzj$c);
        ThreadManager.excute(new VideoVolumeControl.4(this), 16, null, true);
      }
      this.jdField_a_of_type_Mzj$b = null;
      this.jdField_a_of_type_Mzj$c = null;
      this.akT = "";
      this.audioManager = null;
      if (!this.aqJ)
      {
        g(false, "outKandianModule", 2);
        g(this.aqE, "outKandianModule", 1);
        this.aqI = false;
        if ((paramActivity instanceof ReadInJoyNewFeedsActivity)) {
          noy.a().clean();
        }
        if (this.o != null)
        {
          this.o.cancel();
          this.o.purge();
          this.o = null;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.aqJ = false;
        this.aqK = false;
      }
    }
    QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, "outKandianModule origin:" + this.akT + " act:" + paramActivity.toString());
  }
  
  void aST()
  {
    Iterator localIterator = this.eB.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (mye)localIterator.next();
      if (localObject != null) {
        ((mye)localObject).aST();
      }
    }
    localIterator = this.eC.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (VideoFeedsPlayManager)localIterator.next();
      if (localObject != null) {
        ((VideoFeedsPlayManager)localObject).aST();
      }
    }
  }
  
  public void aUI()
  {
    if (this.o == null) {
      this.o = new Timer();
    }
    this.aqM = false;
    this.o.schedule(new VideoVolumeControl.3(this), 2000L);
  }
  
  public void aUJ()
  {
    if (!this.aqI) {
      g(this.aqE, "start auto play", 1);
    }
  }
  
  public float aj()
  {
    if (this.audioManager != null) {
      return this.audioManager.getStreamVolume(3) / this.audioManager.getStreamMaxVolume(3);
    }
    return 0.0F;
  }
  
  public void b(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoFeedsPlayManager != null) {
      this.eC.remove(paramVideoFeedsPlayManager);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "removeVideoMgr :" + paramVideoFeedsPlayManager + " list:" + this.eC);
    }
  }
  
  public void b(mye parammye)
  {
    if (parammye != null)
    {
      parammye.setMute(Fb());
      if (!this.eB.containsKey(parammye)) {
        this.eB.put(parammye, Boolean.valueOf(true));
      }
      parammye.a(this.jdField_a_of_type_Mzj$b);
      this.aWC = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "addVideoManager :" + parammye + " list:" + this.eB);
    }
  }
  
  public void c(mye parammye)
  {
    if (parammye != null) {
      this.eB.remove(parammye);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "removeVideoManager :" + parammye + " list:" + this.eB);
    }
  }
  
  public void g(boolean paramBoolean, String paramString, int paramInt)
  {
    int j = 0;
    if (!this.aqI) {
      this.aqI = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "setMute :" + paramBoolean + ", oldValue:" + this.aqF + " reason:" + paramString + " what:" + paramInt);
    }
    label156:
    label244:
    int i;
    if ((paramInt == 1) || (paramInt == 0))
    {
      paramString = this.eB.keySet().iterator();
      Object localObject;
      for (boolean bool1 = false; paramString.hasNext(); bool1 = ((mye)localObject).isPlaying() | bool1)
      {
        localObject = (mye)paramString.next();
        if (localObject == null) {
          break label422;
        }
        ((mye)localObject).setMute(paramBoolean);
      }
      this.aqG = paramBoolean;
      if (bool1) {
        if (this.aqG) {
          break label250;
        }
      }
      label250:
      for (boolean bool2 = true;; bool2 = false)
      {
        z(bool2, "by user click mute btn ");
        if ((paramInt != 2) && (paramInt != 0)) {
          break label261;
        }
        paramString = this.eC.keySet().iterator();
        while (paramString.hasNext())
        {
          localObject = (VideoFeedsPlayManager)paramString.next();
          if (localObject == null) {
            break label416;
          }
          ((VideoFeedsPlayManager)localObject).setMute(paramBoolean);
          paramInt = ((VideoFeedsPlayManager)localObject).isPlaying() | bool1;
          i = paramInt;
        }
      }
      this.aqH = paramBoolean;
      label261:
      this.aqF = paramBoolean;
      if ((this.ly != null) && (this.ly.size() > 0)) {
        paramInt = j;
      }
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.ly.size())
        {
          paramString = (WeakReference)this.ly.get(paramInt);
          if ((paramString == null) || (paramString.get() == null)) {
            break label431;
          }
          if (!paramBoolean) {
            break label387;
          }
          ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130843886));
        }
      }
      catch (Exception paramString)
      {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "failed to update volume view:" + paramString.toString());
      }
      return;
      label387:
      ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130843887));
      break label431;
      label416:
      paramInt = i;
      break label244;
      label422:
      break;
      i = 0;
      break label156;
      label431:
      paramInt += 1;
    }
  }
  
  public boolean isMute()
  {
    return this.aqF;
  }
  
  public void k(ImageView paramImageView)
  {
    this.ly.add(new WeakReference(paramImageView));
  }
  
  public void oT(boolean paramBoolean)
  {
    this.aqE = paramBoolean;
  }
  
  public void oU(boolean paramBoolean)
  {
    this.aqH = paramBoolean;
  }
  
  public void oV(boolean paramBoolean)
  {
    this.aqN = paramBoolean;
  }
  
  void oW(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.eB.keySet().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (mye)localIterator.next();
        if ((localObject != null) && (((mye)localObject).isPlaying()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          if (((mye)localObject).qc() != 5) {
            ((mye)localObject).oL(true);
          }
          ((mye)localObject).pause();
        }
      }
      localIterator = this.eC.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoFeedsPlayManager)localIterator.next();
        if ((localObject != null) && (((VideoFeedsPlayManager)localObject).isPlaying()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          if (((VideoFeedsPlayManager)localObject).pX() != 5) {
            ((VideoFeedsPlayManager)localObject).oB(true);
          }
          ((VideoFeedsPlayManager)localObject).pause();
        }
      }
    }
  }
  
  public void oX(boolean paramBoolean)
  {
    this.aqJ = paramBoolean;
    if (paramBoolean) {
      this.aqK = true;
    }
  }
  
  public void oY(boolean paramBoolean)
  {
    this.aqL = paramBoolean;
  }
  
  public void sW(int paramInt)
  {
    if (this.audioManager != null)
    {
      this.audioManager.adjustStreamVolume(3, paramInt, 0);
      if (this.audioManager.getStreamVolume(3) == 0) {
        g(true, "system volume 0", this.aWC);
      }
    }
    else
    {
      return;
    }
    g(false, "system volume change", this.aWC);
  }
  
  /* Error */
  public void z(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 133	mzj:anz	Z
    //   7: aload_0
    //   8: getfield 97	mzj:handler	Landroid/os/Handler;
    //   11: ifnull +82 -> 93
    //   14: aload_0
    //   15: getfield 111	mzj:cK	Ljava/lang/Runnable;
    //   18: ifnull +75 -> 93
    //   21: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +39 -> 63
    //   27: ldc 154
    //   29: iconst_2
    //   30: new 156	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 513
    //   40: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: ldc_w 515
    //   50: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: getfield 97	mzj:handler	Landroid/os/Handler;
    //   67: aload_0
    //   68: getfield 111	mzj:cK	Ljava/lang/Runnable;
    //   71: invokevirtual 519	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   74: aload_0
    //   75: getfield 133	mzj:anz	Z
    //   78: ifeq +18 -> 96
    //   81: aload_0
    //   82: getfield 97	mzj:handler	Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield 111	mzj:cK	Ljava/lang/Runnable;
    //   89: invokevirtual 523	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   92: pop
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield 97	mzj:handler	Landroid/os/Handler;
    //   100: aload_0
    //   101: getfield 111	mzj:cK	Ljava/lang/Runnable;
    //   104: ldc2_w 386
    //   107: invokevirtual 527	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   110: pop
    //   111: goto -18 -> 93
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	mzj
    //   0	119	1	paramBoolean	boolean
    //   0	119	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	63	114	finally
    //   63	93	114	finally
    //   96	111	114	finally
  }
  
  public class a
    extends PhoneStateListener
  {
    a() {}
    
    public void onCallStateChanged(int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "onCallStateChanged:" + paramInt);
      }
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        mzj.this.oW(true);
        return;
      case 2: 
        mzj.this.oW(true);
        return;
      }
      mzj.this.aST();
    }
  }
  
  class b
    implements mye.a
  {
    b() {}
    
    public void a(mye.b paramb, myi parammyi, int paramInt1, int paramInt2, Object paramObject)
    {
      if (paramInt2 == 0) {}
      do
      {
        do
        {
          do
          {
            return;
          } while ((paramInt2 == 1) || (paramInt2 == 2));
          if (paramInt2 != 3) {
            break;
          }
          mzj.this.g(mzj.this.Fb(), "video playing", 1);
        } while (mzj.this.Fb());
        mzj.this.z(true, "PLAY_STATE_PLAYING");
        return;
      } while ((paramInt2 == 4) || (paramInt2 == 5) || (paramInt2 == 6) || (paramInt2 != 7));
    }
  }
  
  public class c
    extends BroadcastReceiver
  {
    private c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().isBackground_Stop) || (BaseApplicationImpl.getApplication().getRuntime().isBackground_Pause)) {}
      label24:
      do
      {
        do
        {
          do
          {
            do
            {
              break label24;
              break label24;
              do
              {
                return;
              } while (mzj.b(mzj.this));
              if (mzj.c(mzj.this))
              {
                mzj.b(mzj.this, false);
                return;
              }
              if (mzj.a(mzj.this) != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "VolumeReceiver onReceive null");
            return;
          } while (!mzj.d(mzj.this));
          if (!mzj.e(mzj.this)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "dynamicPauseReceive true");
        return;
        int i;
        try
        {
          if (!paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            continue;
          }
          i = mzj.a(mzj.this).getStreamVolume(3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change:" + i);
          }
          if (mzj.f(mzj.this))
          {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change shield ");
            return;
          }
        }
        catch (Exception paramContext)
        {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "VolumeReceiver", paramContext);
          return;
        }
        if (i == 0)
        {
          mzj.this.g(true, "system volume 0", mzj.a(mzj.this));
          return;
        }
        mzj.this.g(false, "system volume change", mzj.a(mzj.this));
        return;
      } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
      boolean bool = mzj.a(mzj.this).isWiredHeadsetOn();
      if (mzj.g(mzj.this))
      {
        mzj.c(mzj.this, false);
        return;
      }
      mzj.d(mzj.this, true);
      if (bool) {
        mzj.this.g(false, "headset on", mzj.a(mzj.this));
      }
      for (;;)
      {
        mzj.a(mzj.this).postDelayed(new VideoVolumeControl.VolumeReceiver.1(this), 200L);
        return;
        mzj.this.g(true, "headset off", mzj.a(mzj.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzj
 * JD-Core Version:    0.7.0.1
 */