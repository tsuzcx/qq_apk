import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;

public class cqx
  extends EmoticonPackageDownloadListener
{
  public cqx(EmosmActivity paramEmosmActivity) {}
  
  public void onCoverComplete(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if ((paramEmoticonPackage == null) || (paramInt1 != 2) || (paramInt2 != 0)) {}
    while (EmosmActivity.a(this.a) == null) {
      return;
    }
    this.a.runOnUiThread(EmosmActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqx
 * JD-Core Version:    0.7.0.1
 */