import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class aogy
{
  private String ckH;
  private String themeId;
  private String zipPath;
  
  public String AG()
  {
    return ThemeUtil.getThemeConfigID(this.themeId);
  }
  
  public String AH()
  {
    return this.ckH;
  }
  
  public aogy a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    return a("999").a(localBaseApplication, "999_540", "999_540");
  }
  
  public aogy a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = aR(paramContext);
    this.zipPath = (paramContext + paramString1 + ".zip");
    this.ckH = (paramContext + paramString1 + File.separator + paramString2 + File.separator);
    return this;
  }
  
  public aogy a(String paramString)
  {
    this.themeId = paramString;
    return this;
  }
  
  public String aR(Context paramContext)
  {
    paramContext = paramContext.getDir("theme_810", 0).getAbsolutePath();
    StringBuilder localStringBuilder = wja.b().append(paramContext);
    if (!paramContext.endsWith(File.separator)) {
      localStringBuilder.append(File.separator);
    }
    return this.themeId + File.separator;
  }
  
  public String aS(Context paramContext)
  {
    paramContext = aR(paramContext);
    return paramContext + "3_" + AG() + ".cfg";
  }
  
  public boolean azE()
  {
    return new File(this.zipPath).exists();
  }
  
  public boolean azF()
  {
    return new File(this.ckH).exists();
  }
  
  public aogy b()
  {
    return a(BaseApplicationImpl.getContext(), "test", "test");
  }
  
  public aogy c()
  {
    this.zipPath = null;
    this.ckH = null;
    return this;
  }
  
  public String getThemeId()
  {
    return this.themeId;
  }
  
  public String getZipPath()
  {
    return this.zipPath;
  }
  
  public String toString()
  {
    return this.zipPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogy
 * JD-Core Version:    0.7.0.1
 */