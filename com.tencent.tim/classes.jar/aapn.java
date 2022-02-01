import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.VideoView;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.a;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class aapn
{
  private arhz L;
  private long Mh;
  private long Mi;
  private long Mj;
  private DialogInterface.OnShowListener jdField_a_of_type_AndroidContentDialogInterface$OnShowListener;
  private final P2VEditMusicDialog.a jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a = new aapp(this);
  private Activity activity;
  private ImageButton av;
  private DialogInterface.OnDismissListener jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener;
  private final AudioPlayerBase.a jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a = new aapo(this);
  private boolean bwL;
  private FixedSizeVideoView c;
  private int cij;
  private AudioPlayer d;
  private WeakReference<Dialog> eU;
  private rkc i;
  private String localVideoPath;
  private QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo;
  
  private aapn(Activity paramActivity, FixedSizeVideoView paramFixedSizeVideoView, ImageButton paramImageButton, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    this.activity = paramActivity;
    this.c = paramFixedSizeVideoView;
    this.av = paramImageButton;
    this.qzoneVerticalVideoTopicInfo = paramQzoneVerticalVideoTopicInfo;
    this.i = c();
  }
  
  private void CD(boolean paramBoolean)
  {
    float f2 = 0.0F;
    if (this.c != null) {}
    for (;;)
    {
      try
      {
        Object localObject = VideoView.class.getDeclaredField("mMediaPlayer");
        ((Field)localObject).setAccessible(true);
        localObject = (MediaPlayer)((Field)localObject).get(this.c);
        if (localObject != null)
        {
          if (paramBoolean)
          {
            f1 = 0.0F;
            break label100;
            ((MediaPlayer)localObject).setVolume(f1, f2);
          }
        }
        else {
          return;
        }
        float f1 = 1.0F;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        QZLog.e("EditLocalVideoMusicMixe", 2, localNoSuchFieldException, new Object[0]);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QZLog.e("EditLocalVideoMusicMixe", 2, localIllegalAccessException, new Object[0]);
        return;
      }
      f2 = 1.0F;
      continue;
      label100:
      if (!paramBoolean) {}
    }
  }
  
  private void CE(boolean paramBoolean)
  {
    if (this.d != null) {
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (int j = this.d.getCurrentPosition();; j = 0)
    {
      this.cij = j;
      if (this.i == null) {
        CD(false);
      }
      this.d.stop();
      this.d = null;
      return;
    }
  }
  
  private boolean WN()
  {
    return (this.i != null) && (eL() - this.i.duration > 0L);
  }
  
  public static aapn a(Activity paramActivity, FixedSizeVideoView paramFixedSizeVideoView, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo, ImageButton paramImageButton)
  {
    return new aapn(paramActivity, paramFixedSizeVideoView, paramImageButton, paramQzoneVerticalVideoTopicInfo);
  }
  
  private rkc c()
  {
    if ((this.qzoneVerticalVideoTopicInfo != null) && (this.qzoneVerticalVideoTopicInfo.ags()))
    {
      rkc localrkc = new rkc();
      localrkc.aAQ = this.qzoneVerticalVideoTopicInfo.GT();
      localrkc.id = this.qzoneVerticalVideoTopicInfo.getTopicId();
      localrkc.title = this.qzoneVerticalVideoTopicInfo.GS();
      localrkc.musicType = 3;
      return localrkc;
    }
    return null;
  }
  
  private void cwe()
  {
    if (this.d == null)
    {
      this.d = new AudioPlayer(this.activity, this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a);
      this.d.setAudioStream(3);
    }
    AudioPlayer localAudioPlayer;
    String str;
    if (this.i != null)
    {
      if (TextUtils.isEmpty(this.i.aAR)) {
        break label119;
      }
      localAudioPlayer = this.d;
      str = this.i.aAR;
      if (this.cij == 0) {
        break label108;
      }
    }
    label108:
    for (int j = this.cij;; j = this.i.start)
    {
      localAudioPlayer.seekPlay(str, j);
      this.activity.sendBroadcast(new Intent("action_music_start"));
      CD(true);
      return;
    }
    label119:
    QZLog.e("EditLocalVideoMusicMixe", 2, new Object[] { "startAudioPlayback: music not downloaded " + this.i.aAQ });
  }
  
  private long eL()
  {
    return this.Mi - this.Mh;
  }
  
  public void CC(boolean paramBoolean)
  {
    this.bwL = paramBoolean;
  }
  
  public void J(long paramLong, String paramString)
  {
    gr(0, (int)paramLong);
    this.Mj = paramLong;
    this.localVideoPath = paramString;
  }
  
  public boolean WL()
  {
    return (this.eU != null) && (this.eU.get() != null) && (((Dialog)this.eU.get()).isShowing());
  }
  
  public boolean WM()
  {
    return (this.i != null) && ((this.i.musicType == 0) || (this.i.musicType == 3) || (this.i.musicType == 2)) && (!this.bwL);
  }
  
  public void a(aapn.a parama)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new EditLocalVideoMusicMixRunnable(this.Mh, this.Mi, this.Mj, this.localVideoPath, this.i, new aapq(this, parama)));
  }
  
  public void b(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  public void b(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
  
  public void cvZ()
  {
    P2VEditMusicDialog localP2VEditMusicDialog = new P2VEditMusicDialog(this.activity, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a, (int)eL(), true);
    if (this.jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener != null) {
      localP2VEditMusicDialog.setOnDismissListener(this.jdField_b_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener != null) {
      localP2VEditMusicDialog.setOnShowListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener);
    }
    localP2VEditMusicDialog.setCanceledOnTouchOutside(false);
    localP2VEditMusicDialog.show();
    this.eU = new WeakReference(localP2VEditMusicDialog);
  }
  
  public void cwa()
  {
    CE(false);
    cwe();
  }
  
  public void cwb()
  {
    CE(false);
  }
  
  public void cwc()
  {
    CE(true);
  }
  
  public void cwd()
  {
    cwe();
  }
  
  public void gH(long paramLong)
  {
    if (this.i != null) {
      new P2VEditMusicDialog(this.activity, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$a, (int)paramLong, true);
    }
  }
  
  public void gr(int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 > 0)
    {
      this.Mh = paramInt1;
      this.Mi = paramInt2;
      Log.d("EditLocalVideoMusicMixe", "updateVideoFrameClippedRange: " + paramInt1 + " " + paramInt2);
      return;
    }
    Log.w("EditLocalVideoMusicMixe", "updateVideoFrameClippedRange: duration less or equal than zero " + paramInt2 + " " + paramInt1);
  }
  
  public static abstract interface a
  {
    public abstract void AB(String paramString);
    
    public abstract void cvW();
    
    public abstract void cvX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapn
 * JD-Core Version:    0.7.0.1
 */