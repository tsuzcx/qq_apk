import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class afyj
  implements afyg.a
{
  private static volatile afyj a;
  private static Object lock = new Object();
  protected afyg a;
  private WeakReference<ExtendFriendVoiceView> aA;
  private WeakReference<BaseActivity> az;
  private volatile boolean mIsPlaying;
  
  private afyj(BaseActivity paramBaseActivity)
  {
    this.az = new WeakReference(paramBaseActivity);
  }
  
  public static final afyj a(BaseActivity paramBaseActivity)
  {
    if (jdField_a_of_type_Afyj == null) {}
    synchronized (lock)
    {
      if (jdField_a_of_type_Afyj == null) {
        jdField_a_of_type_Afyj = new afyj(paramBaseActivity);
      }
      return jdField_a_of_type_Afyj;
    }
  }
  
  public static final void ddO()
  {
    synchronized (lock)
    {
      stopAll();
      jdField_a_of_type_Afyj = null;
      return;
    }
  }
  
  public static final void stopAll()
  {
    synchronized (lock)
    {
      if (jdField_a_of_type_Afyj != null)
      {
        if (jdField_a_of_type_Afyj.isPlaying()) {
          jdField_a_of_type_Afyj.aRx();
        }
        ExtendFriendVoiceView localExtendFriendVoiceView = jdField_a_of_type_Afyj.a();
        if ((localExtendFriendVoiceView != null) && (localExtendFriendVoiceView.isAnimating())) {
          localExtendFriendVoiceView.stopAnimation();
        }
      }
      return;
    }
  }
  
  public void Iw(boolean paramBoolean) {}
  
  public void Nm(int paramInt) {}
  
  public ExtendFriendVoiceView a()
  {
    if (this.aA != null) {
      return (ExtendFriendVoiceView)this.aA.get();
    }
    return null;
  }
  
  public void a(ExtendFriendVoiceView paramExtendFriendVoiceView)
  {
    if (paramExtendFriendVoiceView != null) {
      this.aA = new WeakReference(paramExtendFriendVoiceView);
    }
  }
  
  public void aRx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatAioVoicePlayerManager", 2, "stopVoice");
    }
    if (this.jdField_a_of_type_Afyg != null)
    {
      this.jdField_a_of_type_Afyg.stop();
      this.mIsPlaying = false;
    }
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_Afyg != null) {
      this.jdField_a_of_type_Afyg.abandonAudioFocus();
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2) {}
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean isPlaying()
  {
    return this.mIsPlaying;
  }
  
  public void pc(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatAioVoicePlayerManager", 2, "playVoice " + paramString);
    }
    BaseActivity localBaseActivity = (BaseActivity)this.az.get();
    if (localBaseActivity != null)
    {
      if (this.jdField_a_of_type_Afyg == null) {
        this.jdField_a_of_type_Afyg = new afyg(this, localBaseActivity);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_Afyg.play(paramString);
        this.mIsPlaying = true;
      }
    }
  }
  
  public void u(File paramFile) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyj
 * JD-Core Version:    0.7.0.1
 */