import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class aqss
  extends aqsm
{
  public static aqss a = new aqss();
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, aqqq paramaqqq, boolean paramBoolean)
  {
    a.download(paramQQAppInterface, "qqVipLevel." + paramInt, paramaqqq, paramBoolean);
  }
  
  public static boolean k(Context paramContext, int paramInt)
  {
    String str = "qqVipLevel." + paramInt;
    return new File(a.getDir(paramContext, str)).exists();
  }
  
  public long getBID()
  {
    return 41L;
  }
  
  protected String getRootDir()
  {
    return "qqlevel_icon";
  }
  
  protected String getScidPrefix()
  {
    return "qqVipLevel.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqss
 * JD-Core Version:    0.7.0.1
 */