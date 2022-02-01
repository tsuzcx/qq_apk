import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.4;
import com.tencent.qphone.base.util.QLog;

public class aogn
  extends aogr
{
  private static aogn jdField_a_of_type_Aogn;
  private aqqq jdField_a_of_type_Aqqq = new aogq(this);
  anll b = new aogo(this);
  private int bgJ;
  private boolean cLz;
  private int dOz;
  acci h = new aogp(this);
  private String mCurrentUin = "";
  private View mViewRoot;
  
  public static aogn a()
  {
    if (jdField_a_of_type_Aogn == null) {}
    try
    {
      if (jdField_a_of_type_Aogn == null)
      {
        jdField_a_of_type_Aogn = new aogn();
        ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_Aogn.h);
        ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(jdField_a_of_type_Aogn.b);
      }
      return jdField_a_of_type_Aogn;
    }
    finally {}
  }
  
  public void VM(int paramInt)
  {
    if (paramInt > 0)
    {
      this.dOz = paramInt;
      this.cLD = true;
      aqsp.a.download(null, this.dOz, this.jdField_a_of_type_Aqqq, false);
    }
    do
    {
      return;
      this.dOz = 0;
      this.cLD = false;
      RP(null);
    } while (this.mViewRoot == null);
    ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.4(this));
  }
  
  public boolean azA()
  {
    return this.dOz > 0;
  }
  
  public void c(View paramView, String paramString, int paramInt)
  {
    if ((paramView == null) || (anlm.ayn())) {}
    do
    {
      return;
      dUA();
      this.mViewRoot = paramView;
      this.bgJ = paramInt;
      this.mCurrentUin = paramString;
      if (this.cLD) {
        hP(paramView);
      }
    } while (!QLog.isColorLevel());
    QLog.i("FloatViewSkin", 2, "enter uin:" + this.mCurrentUin + "  type:" + this.bgJ + " mIsUserSkin:" + this.cLD);
  }
  
  public void dUA()
  {
    aqrb localaqrb = (aqrb)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(71);
    if (localaqrb != null) {
      localaqrb.efi();
    }
  }
  
  public void gd(String paramString, int paramInt)
  {
    this.dOz = paramInt;
    BaseApplicationImpl.sImageCache.evictAll();
    if (TextUtils.isEmpty(paramString))
    {
      RP(paramString);
      this.cLD = false;
    }
    for (;;)
    {
      hP(this.mViewRoot);
      return;
      RP(paramString);
      this.cLD = true;
      this.cLz = true;
    }
  }
  
  public void hO(View paramView)
  {
    this.mViewRoot = paramView;
  }
  
  public void hP(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatViewSkin", 2, "setMusicBarSkin uin:" + this.mCurrentUin + "  type:" + this.bgJ + " mIsUserSkin:" + this.cLD);
    }
    QLog.i("FloatViewSkin", 1, "setMusicBarSkin mIsShowSkin:" + this.cLz + "  mIsUserSkin:" + this.cLD);
    if ((paramView == null) || (!this.cLz)) {
      return;
    }
    if (anlm.ayn()) {}
    for (this.mEnable = false;; this.mEnable = true)
    {
      paramView = paramView.getRootView();
      a(paramView, 2131372118, 2130845700, "qq_aio_listentogether_lyrics_music_point@3x.png");
      b(paramView, 2131372088, 2130845697, "qq_aio_listentogether_lyrics_music_bg@3x.png");
      b(paramView, 2131372124, 2130845699, "qq_aio_listentogether_lyrics_music_dot@3x.png");
      b(paramView, 2131364694, 2130845698, "qq_aio_listentogether_lyrics_music_close@3x.png");
      return;
    }
  }
  
  public void leave()
  {
    if (this.mViewRoot != null) {
      hP(this.mViewRoot);
    }
    this.mViewRoot = null;
    if (QLog.isColorLevel()) {
      QLog.i("FloatViewSkin", 2, "leave uin:" + this.mCurrentUin + "  type:" + this.bgJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogn
 * JD-Core Version:    0.7.0.1
 */