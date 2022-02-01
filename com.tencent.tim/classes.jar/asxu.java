import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class asxu
{
  public static String Ek()
  {
    return BaseApplication.getContext().getDir("qqprotect", 0).toString();
  }
  
  public static String El()
  {
    return Ek() + File.separator + "qseclibs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxu
 * JD-Core Version:    0.7.0.1
 */