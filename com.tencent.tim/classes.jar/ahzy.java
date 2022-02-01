import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpic.DiskStorageManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout.d;
import java.lang.ref.WeakReference;

public class ahzy
  implements aiae.a, HotVideoMongoliaRelativeLayout.d
{
  public static final DiskStorageManager a;
  static boolean cjB;
  static boolean cjC;
  public static volatile boolean cjx;
  public HotVideoMongoliaRelativeLayout a;
  boolean cjA;
  private volatile boolean cjy;
  private volatile boolean cjz;
  public final Runnable gD;
  final Runnable gE;
  WeakReference<HotPicPageView> hf;
  private AudioManager mAudioManager;
  public Context mContext;
  long mDuration;
  boolean mEnd;
  public Handler mHandler;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqHotpicDiskStorageManager = new DiskStorageManager(50);
  }
  
  public static void cZ(QQAppInterface paramQQAppInterface)
  {
    cjB = false;
    cjC = false;
    cjx = false;
  }
  
  public void KO(boolean paramBoolean)
  {
    if (!paramBoolean) {
      pause();
    }
  }
  
  public void KP(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      pause();
    }
  }
  
  public void PJ(int paramInt) {}
  
  boolean aoE()
  {
    return false;
  }
  
  public void drE()
  {
    if ((this.mDuration <= 0L) && (!aoE())) {}
  }
  
  public void drF()
  {
    this.mHandler.postDelayed(this.gD, 100L);
  }
  
  public void drG()
  {
    this.mHandler.removeCallbacks(this.gD);
  }
  
  public void drH()
  {
    this.cjA = false;
    this.mHandler.removeCallbacks(this.gE);
  }
  
  public void drI()
  {
    pause();
  }
  
  public void drJ()
  {
    if (this.mAudioManager == null) {
      this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    }
    int i = this.mAudioManager.getStreamVolume(3);
    if (this.hf == null) {}
    HotPicPageView localHotPicPageView;
    do
    {
      return;
      localHotPicPageView = (HotPicPageView)this.hf.get();
    } while (localHotPicPageView == null);
    localHotPicPageView.PB(i);
  }
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public void onDestroy()
  {
    drH();
    drG();
    this.mEnd = true;
    this.cjz = false;
    aiae.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.getContext()).a(this);
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void pause() {}
  
  public void v(int paramInt, View paramView)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return;
          if (this.cjy)
          {
            this.cjy = false;
            return;
          }
        } while ((this.cjy) || (this.cjz));
        return;
      } while (this.cjz);
      return;
    }
    drH();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.PI(3);
    drF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzy
 * JD-Core Version:    0.7.0.1
 */