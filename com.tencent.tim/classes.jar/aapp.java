import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.a;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class aapp
  implements P2VEditMusicDialog.a
{
  aapp(aapn paramaapn) {}
  
  public void AD(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (aapn.a(this.b) != null) {
      aapn.a(this.b).aAR = paramString;
    }
  }
  
  public void Gd(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (aapn.a(this.b) != null)
    {
      if (paramInt == 0) {
        aapn.a(this.b).setImageResource(2130847531);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      aapn.a(this.b).setImageResource(2130847530);
      return;
    }
    aapn.a(this.b).setImageResource(2130847524);
  }
  
  public boolean KZ()
  {
    return (aapn.a(this.b) == null) || (!aapn.a(this.b).ags());
  }
  
  public boolean WO()
  {
    return false;
  }
  
  public boolean WP()
  {
    return true;
  }
  
  public rkc a()
  {
    if (aapn.a(this.b) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + aapn.a(this.b).mZ());
    }
    return aapn.a(this.b);
  }
  
  public void cwf()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (aapn.a(this.b) != null) {
      aapn.a(this.b, aapn.a(this.b).getCurrentPosition());
    }
    aapn.a(this.b, true);
  }
  
  public void cwg()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onStopCurFragmentMusic: ");
    aapn.a(this.b, 0);
    aapn.a(this.b, false);
  }
  
  public void cwh()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    aapn.a(this.b);
  }
  
  public void cwi()
  {
    aapn.b(this.b, false);
  }
  
  public void h(rkc paramrkc)
  {
    if (paramrkc != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramrkc.mZ() + " " + paramrkc.start + " to " + paramrkc.end);
      if (paramrkc.musicType == 0)
      {
        aapn.a(this.b, false);
        aapn.b(this.b, true);
      }
    }
    for (;;)
    {
      aapn.a(this.b, paramrkc);
      return;
      if (paramrkc.musicType == 1)
      {
        aapn.a(this.b, false);
        aapn.b(this.b, false);
        continue;
        aapn.a(this.b, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapp
 * JD-Core Version:    0.7.0.1
 */