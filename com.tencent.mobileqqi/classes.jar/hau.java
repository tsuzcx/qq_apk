import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;

public final class hau
  extends Thread
{
  public hau(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = CardHandler.a(this.a, CardHandler.c(BaseApplication.getContext()));
    int i = CardHandler.d(BaseApplication.getContext());
    String str2 = CardHandler.a(this.a, i);
    ImageUtil.a(this.b, str1);
    ImageUtil.a(this.b, str2, i, i);
    FileUtils.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hau
 * JD-Core Version:    0.7.0.1
 */