import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.2;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afyg
{
  private afyg.a jdField_a_of_type_Afyg$a;
  private aqnt jdField_a_of_type_Aqnt;
  private AudioManager.OnAudioFocusChangeListener b = new afyh(this);
  private Object lock = new Object();
  private BaseActivity mActivity;
  private AudioManager mAudioManager;
  
  public afyg(afyg.a parama, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Afyg$a = parama;
    this.mActivity = paramBaseActivity;
    this.mAudioManager = ((AudioManager)this.mActivity.getSystemService("audio"));
  }
  
  public void abandonAudioFocus()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoicePlayer", 2, "abandonAudioFocus");
    }
    if (this.mAudioManager != null) {
      this.mAudioManager.abandonAudioFocus(this.b);
    }
  }
  
  public boolean mg(String arg1)
  {
    if ((this.mActivity != null) && (this.mActivity.isFinishing())) {
      QLog.e("ExtendFriendVoicePlayer", 2, "playLocal file but activity isFinish");
    }
    String str;
    for (;;)
    {
      return false;
      str = ???;
      try
      {
        if (!ahbj.isFileExists(???))
        {
          str = aojs.a(this.mActivity.app.getCurrentAccountUin(), MD5.toMD5(???), 23, null);
          File localFile = new File(str);
          if ((!localFile.exists()) || (localFile.length() <= 0L))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ExtendFriendVoicePlayer", 2, String.format("playLocal file not exist : %s", new Object[] { ??? }));
            return false;
          }
        }
      }
      catch (Exception ???)
      {
        QLog.e("ExtendFriendVoicePlayer", 1, "playLocal", ???);
        return false;
      }
    }
    synchronized (this.lock)
    {
      if (this.jdField_a_of_type_Aqnt != null)
      {
        this.jdField_a_of_type_Aqnt.release();
        this.jdField_a_of_type_Aqnt = null;
      }
      this.jdField_a_of_type_Aqnt = new aqnt(str, new Handler(), 1);
      this.jdField_a_of_type_Aqnt.aFk();
      this.jdField_a_of_type_Aqnt.a(this.jdField_a_of_type_Afyg$a);
      this.jdField_a_of_type_Aqnt.start();
      if (this.mAudioManager != null) {
        this.mAudioManager.requestAudioFocus(this.b, 3, 2);
      }
      return true;
    }
  }
  
  public void play(String paramString)
  {
    if (!mg(paramString)) {
      ThreadManager.executeOnFileThread(new ExtendFriendVoicePlayer.2(this, paramString));
    }
  }
  
  public void stop()
  {
    try
    {
      synchronized (this.lock)
      {
        if (this.jdField_a_of_type_Aqnt != null)
        {
          this.jdField_a_of_type_Aqnt.release();
          this.jdField_a_of_type_Aqnt = null;
        }
        abandonAudioFocus();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoicePlayer", 1, "stop e=" + localException);
    }
  }
  
  public static abstract interface a
    extends aqnt.a
  {
    public abstract void Iw(boolean paramBoolean);
    
    public abstract void Nm(int paramInt);
    
    public abstract void u(File paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyg
 * JD-Core Version:    0.7.0.1
 */