import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;

public final class esd
  extends Thread
{
  public esd(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = CardHandler.a(this.a, CardHandler.b(BaseApplication.getContext()));
    int i = CardHandler.c(BaseApplication.getContext());
    String str2 = CardHandler.a(this.a, i);
    ImageUtil.a(this.b, str1);
    ImageUtil.a(this.b, str2, i, i);
    FileUtils.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     esd
 * JD-Core Version:    0.7.0.1
 */