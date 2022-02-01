import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4;
import com.tencent.qphone.base.util.QLog;

public class aldt
  extends aquy
{
  public aldt(VipProfileCardPreviewActivity.4 param4) {}
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style end download, url : %s, resultCode : %d ", new Object[] { paramaquz.key, Integer.valueOf(paramaquz.errCode) }));
    }
  }
  
  public void onProgress(aquz paramaquz)
  {
    int i = (int)paramaquz.fj;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style progress, url : %s, progress : %d", new Object[] { paramaquz.key, Integer.valueOf(i) }));
    }
  }
  
  public boolean onStart(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style start download, url : %s, position : %s ", new Object[] { paramaquz.key, Integer.valueOf(this.a.val$pos) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldt
 * JD-Core Version:    0.7.0.1
 */