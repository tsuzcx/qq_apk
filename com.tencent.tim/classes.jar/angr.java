import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import java.io.File;

public class angr
{
  public static angr.a a(String paramString)
  {
    return new angr.a(paramString);
  }
  
  public static final String bv(String paramString1, String paramString2)
  {
    return paramString1 + '_' + paramString2;
  }
  
  public static String no(String paramString)
  {
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      VideoEnvironment.m("ShortVideoSoManager:computeMd5[MD5.getFileMd5]md5=" + str1, null);
      String str3;
      if (str1 != null)
      {
        str3 = str1;
        if (!"".equals(str1)) {}
      }
      else
      {
        str3 = np(paramString);
      }
      return str3;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        VideoEnvironment.m("ShortVideoSoManager:computeMd5[MD5.getFileMd5] ", localUnsatisfiedLinkError);
        String str2 = np(paramString);
      }
    }
  }
  
  static String np(String paramString)
  {
    try
    {
      paramString = aszr.getFileMD5String(new File(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      VideoEnvironment.m("ShortVideoSoManager:computeMd5[getFileMD5String]", paramString);
    }
    return null;
  }
  
  public static boolean pa(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_mgr_sp", 4).edit();
    localEditor.putString("sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.m("ShortVideoSoManager.storeSoNewVersion saveAVCodecOK=" + bool, null);
    return bool;
  }
  
  public static String q(File paramFile)
  {
    return aqhq.readFileContent(paramFile);
  }
  
  public static String zG()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_mgr_sp", 4).getString("sv_md5_version_soname_key", "d000_1");
  }
  
  public static class a
  {
    private String cdG;
    private String[] gB;
    
    a(String paramString)
    {
      this.cdG = paramString;
    }
    
    public int Jm()
    {
      if ((this.cdG == null) || ("".equals(this.cdG))) {
        return -3;
      }
      this.gB = this.cdG.split("\\_");
      if (this.gB == null) {
        return -1;
      }
      if (this.gB.length < 2) {
        return -2;
      }
      return 0;
    }
    
    int d(char paramChar)
    {
      if ((this.cdG == null) || ("".equals(this.cdG))) {
        return -3;
      }
      this.gB = this.cdG.split("\\" + paramChar);
      if (this.gB == null) {
        return -1;
      }
      if (this.gB.length < 2) {
        return -2;
      }
      return 0;
    }
    
    String getKey()
    {
      return this.gB[0].trim();
    }
    
    public String getMd5()
    {
      return this.gB[0].trim();
    }
    
    String getValue()
    {
      return this.gB[1].trim();
    }
    
    public String getVersion()
    {
      return this.gB[1].trim();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angr
 * JD-Core Version:    0.7.0.1
 */