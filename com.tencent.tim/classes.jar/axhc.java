import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment.2.1;
import mqq.os.MqqHandler;

public class axhc
  extends axbo
{
  public axhc(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void cd(boolean paramBoolean, int paramInt)
  {
    AETakeFacePhotoPreviewFragment.a(this.a).removeObserver(this);
    ThreadManager.getUIHandler().post(new AETakeFacePhotoPreviewFragment.2.1(this, paramBoolean, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhc
 * JD-Core Version:    0.7.0.1
 */