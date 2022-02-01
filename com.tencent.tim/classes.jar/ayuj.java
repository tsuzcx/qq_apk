import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.qq.im.capture.music.QQMusicDownloader;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class ayuj
  extends aygy
{
  private View Nt;
  private final AudioPlayerBase.a b;
  private axrh jdField_d_of_type_Axrh = new ayuk(this);
  private AudioPlayer jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private boolean dAT;
  private boolean dAU;
  private MusicItemInfo l;
  private QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo;
  
  public ayuj(aytw paramaytw, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    super(paramaytw);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a = new ayul(this);
    this.qzoneVerticalVideoTopicInfo = paramQzoneVerticalVideoTopicInfo;
  }
  
  private void Yt()
  {
    if (this.dAU) {
      return;
    }
    this.jdField_b_of_type_Aygz.a(Message.obtain(null, 3, 1, 0));
    stopMusic();
    n(this.l);
  }
  
  private boolean b(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {}
    while (((paramMusicItemInfo.mType == 5) || (paramMusicItemInfo.mType == 1)) && (!aqhq.fileExistsAndNotEmpty(paramMusicItemInfo.getLocalPath()))) {
      return false;
    }
    return true;
  }
  
  private void eTH()
  {
    if (this.qzoneVerticalVideoTopicInfo.ags())
    {
      this.l = new MusicItemInfo();
      this.l.mSongMid = this.qzoneVerticalVideoTopicInfo.getMusicId();
      this.l.mMusicName = this.qzoneVerticalVideoTopicInfo.GS();
      this.l.mUrl = this.qzoneVerticalVideoTopicInfo.GT();
      this.l.mType = 1;
      ayhm localayhm = (ayhm)this.jdField_b_of_type_Aygz.a(ayhm.class);
      if (localayhm != null) {
        localayhm.tt(true);
      }
      if (b(this.l)) {
        this.dAT = true;
      }
    }
    else
    {
      return;
    }
    o(this.l);
  }
  
  private void eTI()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer == null)
    {
      this.jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(getContext(), this.jdField_b_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a);
      this.jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer.setAudioStream(3);
    }
  }
  
  private void initView()
  {
    this.Nt = LayoutInflater.from(getContext()).inflate(2131562456, null);
    ((TextView)this.Nt.findViewById(2131380966)).setText(this.qzoneVerticalVideoTopicInfo.GU());
    Object localObject = (URLImageView)this.Nt.findViewById(2131369834);
    if (!TextUtils.isEmpty(this.qzoneVerticalVideoTopicInfo.GV())) {
      ((URLImageView)localObject).setBackgroundURL(this.qzoneVerticalVideoTopicInfo.GV());
    }
    for (;;)
    {
      localObject = (RelativeLayout)y(2131366264);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = wja.dp2px(110.0F, getResources());
      localLayoutParams.leftMargin = wja.dp2px(10.0F, getResources());
      ((RelativeLayout)localObject).addView(this.Nt, localLayoutParams);
      return;
      ((URLImageView)localObject).setVisibility(8);
    }
  }
  
  private void n(MusicItemInfo paramMusicItemInfo)
  {
    if (this.dAU) {}
    do
    {
      return;
      eTI();
    } while ((this.jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) || (paramMusicItemInfo == null) || (!b(paramMusicItemInfo)));
    this.jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer.play(paramMusicItemInfo.getLocalPath());
  }
  
  private void o(MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = QQMusicDownloader.a(paramMusicItemInfo.mUrl, paramMusicItemInfo.getLocalPath(), this.jdField_d_of_type_Axrh);
    if (paramMusicItemInfo != null) {
      QQMusicDownloader.a(paramMusicItemInfo, this.jdField_d_of_type_Axrh);
    }
  }
  
  private void stopMusic()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
    {
      this.jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer.stop();
      this.jdField_d_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    }
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    if ((this.l != null) && (!TextUtils.isEmpty(this.l.getLocalPath())))
    {
      paramayqb.g.backgroundMusicPath = this.l.getLocalPath();
      paramayqb.g.isMuteRecordVoice = true;
      paramayqb.g.backgroundMusicOffset = this.l.musicStart;
      paramayqb.g.backgroundMusicDuration = ((int)ShortVideoUtils.getDuration(this.l.getLocalPath()));
      if (paramayqb.g.backgroundMusicDuration <= 0) {
        paramayqb.g.backgroundMusicPath = null;
      }
    }
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      stopMusic();
      n(this.l);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    initView();
    eTH();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.dAU = true;
    super.onPause();
    stopMusic();
  }
  
  public void onResume()
  {
    this.dAU = false;
    super.onResume();
    if (this.dAT) {
      Yt();
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      if (this.Nt != null) {
        this.Nt.setVisibility(8);
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while (this.Nt == null);
      this.Nt.setVisibility(0);
      return;
    } while (this.Nt == null);
    this.Nt.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayuj
 * JD-Core Version:    0.7.0.1
 */