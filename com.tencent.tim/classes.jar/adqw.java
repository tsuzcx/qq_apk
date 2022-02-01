import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class adqw
{
  private static final adqw a = new adqw(1);
  private static final adqw b = new adqw(2);
  private static boolean bQu;
  private static adqw c = b;
  private final SharedPreferences Q;
  private final SharedPreferences R;
  private final String bvf;
  private final String bvg;
  private final int cJr;
  private final String mRootDirectory;
  
  private adqw(int paramInt)
  {
    this.cJr = paramInt;
    this.mRootDirectory = dK(paramInt);
    this.bvg = dL(paramInt);
    this.Q = b(paramInt);
    this.R = c(paramInt);
    if (paramInt == 1)
    {
      this.bvf = "test.ark.qq.com";
      return;
    }
    this.bvf = "cgi.ark.qq.com";
  }
  
  public static adqw a()
  {
    if (!bQu)
    {
      bQu = true;
      ArkAppCenter.r("ArkApp", "ArkTemp.getCurrent sso env isTestEnv=" + false);
    }
    c = b;
    return c;
  }
  
  private static SharedPreferences b(int paramInt)
  {
    if (paramInt == 2) {
      return BaseApplication.getContext().getSharedPreferences("ArkAppServerConfig", 0);
    }
    return BaseApplication.getContext().getSharedPreferences("ArkAppServerConfigDebug", 0);
  }
  
  private static SharedPreferences c(int paramInt)
  {
    if (paramInt == 2) {
      return BaseApplication.getContext().getSharedPreferences("ArkAppCacheConfig", 0);
    }
    return BaseApplication.getContext().getSharedPreferences("ArkAppCacheConfigDebug", 0);
  }
  
  private static String dK(int paramInt)
  {
    String str = sR();
    if (paramInt == 1) {
      return str + "/ArkAppTest";
    }
    return str + "/ArkApp";
  }
  
  private static String dL(int paramInt)
  {
    String str = sR();
    if (paramInt == 1) {
      return str + "/pddata/prd/arkapp/test";
    }
    return str + "/pddata/prd/arkapp";
  }
  
  private static String sR()
  {
    return BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath();
  }
  
  public int BT()
  {
    return this.cJr;
  }
  
  public String getRootDirectory()
  {
    return this.mRootDirectory;
  }
  
  public String sO()
  {
    return this.mRootDirectory + "/Debug";
  }
  
  public String sS()
  {
    return this.bvg + "/Dict";
  }
  
  public String sT()
  {
    return this.mRootDirectory + "/Crash";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqw
 * JD-Core Version:    0.7.0.1
 */