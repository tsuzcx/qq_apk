import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class wnh
{
  public wnh.a a;
  public int bPy = -1;
  public int bPz = -1;
  public boolean beD;
  public int id = -1;
  public ArrayList<String> qi;
  public ArrayList<wnh.b> qj;
  
  public static class a
  {
    public int actId;
    public int bPA;
    public int bPB;
    public int bid;
    public int endTs;
  }
  
  public static class b
  {
    public static final int SIZE = (int)(32.0F * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    int imageType;
    String value;
    
    public static int bH(String paramString)
    {
      if (paramString.equalsIgnoreCase("Emoji")) {
        return 0;
      }
      if (paramString.equalsIgnoreCase("Face")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("Image")) {
        return 2;
      }
      if (paramString.equalsIgnoreCase("Lottie")) {
        return 3;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnh
 * JD-Core Version:    0.7.0.1
 */