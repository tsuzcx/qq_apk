import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class awri
{
  private static String cSj;
  private static String cSk;
  
  public static String Hp()
  {
    if (cSj != null) {
      return cSj;
    }
    Object localObject1 = BaseApplicationImpl.sApplication.getExternalFilesDir(null);
    if (localObject1 == null) {}
    for (localObject1 = BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath();; localObject1 = ((File)localObject1).getAbsolutePath())
    {
      Object localObject2 = localObject1;
      if (!((String)localObject1).endsWith("/")) {
        localObject2 = (String)localObject1 + "/";
      }
      cSj = (String)localObject2;
      return localObject2;
    }
  }
  
  private static String ct(long paramLong)
  {
    return zo() + paramLong + "/";
  }
  
  public static String cu(long paramLong)
  {
    return ct(paramLong) + "disk_file_cache" + "/";
  }
  
  public static String zo()
  {
    if (cSk != null) {
      return cSk;
    }
    String str = Hp();
    str = str + "Tencent" + "/" + "weiyun" + "/";
    cSk = str;
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awri
 * JD-Core Version:    0.7.0.1
 */