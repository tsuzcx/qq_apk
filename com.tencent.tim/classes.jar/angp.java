import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class angp
{
  public static angp.c a(String paramString)
  {
    String str = paramString;
    if (angz.awV())
    {
      str = paramString;
      if (!paramString.endsWith("64bit")) {
        str = paramString + "64bit";
      }
    }
    paramString = new angp.c();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4);
    paramString.version = localSharedPreferences.getInt(str + "_version_k", 0);
    paramString.status = localSharedPreferences.getInt(str + "_status_k", -1);
    paramString.dFx = localSharedPreferences.getInt(str + "_last_error_k", -1);
    return paramString;
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramString;
    if (angz.awV())
    {
      str = paramString;
      if (!paramString.endsWith("64bit")) {
        str = paramString + "64bit";
      }
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4).edit();
    paramString.putInt(str + "_version_k", paramInt1);
    paramString.putInt(str + "_status_k", paramInt2);
    paramString.putInt(str + "_last_error_k", paramInt3);
    return paramString.commit();
  }
  
  public static abstract interface a
  {
    public abstract void cu(int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
    extends angp.a
  {
    public abstract void jy(int paramInt1, int paramInt2);
  }
  
  public static class c
  {
    public int dFx;
    public int status;
    public int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angp
 * JD-Core Version:    0.7.0.1
 */