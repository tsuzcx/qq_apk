import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class aqah
  implements aryp
{
  private aqah.a a;
  private String mCode;
  
  public aqah(String paramString, aqah.a parama)
  {
    this.mCode = paramString;
    this.a = parama;
  }
  
  public int a(String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    int i = -20;
    if (paramString1.equals(BaseApplicationImpl.sApplication.getPackageName()))
    {
      if (this.mCode == null)
      {
        paramString1 = null;
        paramInt = -1;
      }
      for (;;)
      {
        if (this.a != null) {
          this.a.Xk(paramInt);
        }
        QLog.d("UpgradeController", 1, "writeCodeToApk:" + this.mCode + ", forFile:" + paramString2 + " result: " + paramInt, paramString1);
        return paramInt;
        if (this.mCode.length() == 0)
        {
          paramString1 = null;
          paramInt = 0;
        }
        else
        {
          try
          {
            paramString1 = new File(paramString2);
            paramBundle = new File(paramString2 + "~tmp");
            if (paramBundle.exists()) {
              paramBundle.delete();
            }
            paramString1.renameTo(paramBundle);
            ataa.h(paramBundle, this.mCode);
            paramBundle.renameTo(paramString1);
            paramString1 = null;
            paramInt = 0;
          }
          catch (FileNotFoundException paramString1)
          {
            paramInt = -30;
          }
          catch (IOException paramString1)
          {
            paramInt = i;
            if (paramString1 != null)
            {
              paramInt = i;
              if (paramString1.getMessage() != null)
              {
                paramInt = i;
                if (paramString1.getMessage().contains("space")) {
                  paramInt = -10;
                }
              }
            }
          }
          catch (Exception paramString1)
          {
            paramInt = -20;
          }
        }
      }
    }
    return -1;
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (BaseApplicationImpl.sApplication.getPackageName().equals(paramString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("UpgradeController", 4, "syncVersionCodeToTool:" + paramString + ", versionCode:" + paramInt);
      }
      if ((this.a != null) && (!this.a.mm(paramInt))) {
        this.mCode = null;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Xk(int paramInt);
    
    public abstract boolean mm(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqah
 * JD-Core Version:    0.7.0.1
 */