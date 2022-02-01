import android.text.TextUtils;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.qphone.base.util.QLog;

class aipi
  extends ainv
{
  aipi(aipd paramaipd) {}
  
  protected void O(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.this$0.O(paramString1, paramString2, paramBoolean);
  }
  
  protected void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onFloatNeedShowOrDismiss show:" + paramBoolean + " session:" + paramListenTogetherSession);
    }
    if (paramListenTogetherSession == null) {
      return;
    }
    int i = paramListenTogetherSession.type;
    String str = paramListenTogetherSession.uin;
    if (paramBoolean)
    {
      Object localObject = null;
      MusicInfo localMusicInfo = paramListenTogetherSession.b();
      paramListenTogetherSession = localObject;
      if (localMusicInfo != null) {
        paramListenTogetherSession = localMusicInfo.album;
      }
      this.this$0.a.albumUrl = paramListenTogetherSession;
      this.this$0.de(i, str);
      return;
    }
    this.this$0.df(i, str);
  }
  
  protected void as(String paramString, int paramInt1, int paramInt2)
  {
    aipd.a(this.this$0, paramString, paramInt1, paramInt2);
  }
  
  protected void c(ISong paramISong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onPlayMusicChange song.id:" + paramISong.getId());
    }
    aipd.a(this.this$0, paramISong.getId());
    this.this$0.a.albumUrl = paramISong.wY();
    aipd.a(this.this$0);
  }
  
  protected void d(ListenTogetherSession paramListenTogetherSession)
  {
    if (paramListenTogetherSession == null) {
      return;
    }
    if (paramListenTogetherSession.deR == 2) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "onUIModuleNeedRefresh sessionJoined:" + bool);
      }
      if (!bool) {
        break;
      }
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramListenTogetherSession != null)
      {
        paramListenTogetherSession = paramListenTogetherSession.b();
        localObject1 = localObject2;
        if (paramListenTogetherSession != null) {
          localObject1 = paramListenTogetherSession.album;
        }
      }
      this.this$0.a.albumUrl = ((String)localObject1);
      aipd.a(this.this$0);
      return;
    }
  }
  
  protected void e(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "onLyricModuleSwitchChange, newUserClosed:" + paramBoolean1 + " type:" + paramInt + " uin:" + paramString + " mFloatParams:" + this.this$0.a);
      }
      if ((this.this$0.a.G(paramInt, paramString)) && (this.this$0.a.ckZ != paramBoolean1))
      {
        this.this$0.a.ckZ = paramBoolean1;
        aipd.a(this.this$0);
        if ((!TextUtils.isEmpty(this.this$0.bPo)) && (!paramBoolean1) && (paramBoolean2))
        {
          aipd.a(this.this$0, this.this$0.bPo);
          if (this.this$0.ay != null) {
            aipd.a(this.this$0, this.this$0.bPo, this.this$0.bPs, this.this$0.ay.booleanValue());
          }
          aipd.a(this.this$0, this.this$0.bPo, this.this$0.mPlayState);
        }
      }
      if (paramBoolean2) {
        this.this$0.u(paramInt, paramString, paramBoolean1);
      }
      return;
    }
  }
  
  protected void eT(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onPlayStateChange state:" + paramInt);
    }
    if (paramInt == 2) {
      if (this.this$0.b != null) {
        this.this$0.b.setPlayState(true);
      }
    }
    for (;;)
    {
      aipd.b(this.this$0, paramString, paramInt);
      aogn.a().dUA();
      return;
      if (paramInt == 3)
      {
        if (this.this$0.b != null) {
          this.this$0.b.setPlayState(false);
        }
      }
      else if ((paramInt == 4) && (this.this$0.b != null)) {
        this.this$0.b.setPlayState(false);
      }
    }
  }
  
  protected void onThemeChange()
  {
    if ((this.this$0.clg) && (this.this$0.b != null)) {
      this.this$0.b.onThemeChange();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipi
 * JD-Core Version:    0.7.0.1
 */