import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.ISecurityFileHelper;

public class aczs
{
  private static final Map<String, Integer> jA = new HashMap();
  
  public static int D(String arg0, String paramString2)
  {
    paramString2 = ??? + "_" + paramString2;
    synchronized (jA)
    {
      if (jA.containsKey(paramString2))
      {
        i = ((Integer)jA.get(paramString2)).intValue();
        return i;
      }
      int i = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4).getInt(paramString2, 0);
      jA.put(paramString2, Integer.valueOf(i));
    }
  }
  
  public static void J(String arg0, String paramString2, int paramInt)
  {
    int i = -1;
    paramString2 = ??? + "_" + paramString2;
    synchronized (jA)
    {
      if (jA.containsKey(paramString2)) {
        i = ((Integer)jA.get(paramString2)).intValue();
      }
      if (i != paramInt)
      {
        BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4).edit().putInt(paramString2, paramInt).commit();
        jA.put(paramString2, Integer.valueOf(paramInt));
      }
      return;
    }
  }
  
  private static File[] a(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    paramFile = arrayOfFile;
    if (arrayOfFile == null)
    {
      QLog.e("DiySecureFileHelper", 1, new Throwable(), new Object[0]);
      paramFile = new File[0];
    }
    return paramFile;
  }
  
  private static void fl(String paramString1, String paramString2)
  {
    Object localObject1 = new File(paramString1);
    int i;
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isFile()) {
        break label75;
      }
      i = aqhq.ad(paramString1, paramString2);
      if (i != 0) {
        QLog.d("DiySecureFileHelper", 1, "Move [" + paramString1 + "] errorcode = " + i);
      }
    }
    for (;;)
    {
      aqhq.cn(paramString1);
      return;
      label75:
      if (((File)localObject1).isDirectory())
      {
        localObject1 = a((File)localObject1);
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          fl(localObject2.getAbsolutePath(), new File(paramString2, localObject2.getName()).getAbsolutePath());
          i += 1;
        }
      }
    }
  }
  
  public static String jH(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 4)
    {
      str = paramString.substring(4);
      if (QLog.isDevelopLevel()) {
        QLog.d("DiySecureFileHelper", 4, paramString + " -> " + str);
      }
    }
    return str;
  }
  
  static abstract class a
  {
    protected final SharedPreferences pref = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 0);
    
    protected boolean adi()
    {
      return !this.pref.contains(getKey());
    }
    
    protected void cPr()
    {
      this.pref.edit().putBoolean(getKey(), true).commit();
    }
    
    protected abstract String getKey();
  }
  
  public static class b
    extends aczs.a
    implements ISecurityFileHelper
  {
    public b()
    {
      super();
    }
    
    public String declareBusinessFileName()
    {
      return "TIM_Favorite";
    }
    
    public boolean doMigrate(File paramFile)
    {
      QLog.d("ISecurityFileHelper", 1, "Move Theme file start");
      paramFile = new File(ThemeDiyStyleLogic.getSdcardDIYDir());
      File[] arrayOfFile;
      int j;
      int i;
      Object localObject1;
      Object localObject2;
      if ((paramFile.exists()) && (paramFile.isDirectory()))
      {
        arrayOfFile = aczs.d(paramFile);
        j = arrayOfFile.length;
        i = 0;
        if (i < j)
        {
          localObject1 = arrayOfFile[i];
          if ((!((File)localObject1).isDirectory()) || (new File((File)localObject1, ".moveflag").exists())) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((File)localObject1).getName();
            if ((((String)localObject2).length() > 4) && (((String)localObject2).matches("[0-9]{5,}")))
            {
              localObject2 = paramFile.getAbsolutePath() + "/" + aczs.jH((String)localObject2);
              aqhq.UD((String)localObject2 + "/.moveflag");
              aczs.fl(((File)localObject1).getAbsolutePath(), (String)localObject2);
            }
          }
        }
      }
      paramFile = new File(acbn.SDCARD_PATH);
      if ((paramFile.exists()) && (paramFile.isDirectory()))
      {
        paramFile = aczs.d(paramFile);
        int n = paramFile.length;
        int k = 0;
        while (k < n)
        {
          arrayOfFile = paramFile[k];
          int m = 0;
          i = 0;
          localObject1 = arrayOfFile.getName();
          j = m;
          if (arrayOfFile.isDirectory())
          {
            j = m;
            if (((String)localObject1).length() > 4)
            {
              j = m;
              if (((String)localObject1).matches("[0-9]{5,}"))
              {
                if (aczs.d(arrayOfFile).length > 0)
                {
                  localObject2 = aczs.d(arrayOfFile);
                  int i1 = localObject2.length;
                  m = 0;
                  for (;;)
                  {
                    j = i;
                    if (m >= i1) {
                      break;
                    }
                    Object localObject3 = localObject2[m];
                    j = i;
                    if (((File)localObject3).isDirectory())
                    {
                      j = i;
                      if (((File)localObject3).getName().equals("custom_background"))
                      {
                        localObject3 = aczs.d((File)localObject3);
                        j = localObject3.length;
                        i = 0;
                        while (i < j)
                        {
                          Object localObject4 = localObject3[i];
                          if (localObject4.isFile())
                          {
                            aqhq.UD(ThemeDiyStyleLogic.getSdcardDIYDir() + aczs.jH((String)localObject1) + "/.moveflag");
                            aqhq.ad(localObject4.getAbsolutePath(), ThemeDiyStyleLogic.getSdcardDIYDir() + aczs.jH((String)localObject1) + "/" + localObject4.getName());
                          }
                          i += 1;
                        }
                        j = 1;
                      }
                    }
                    m += 1;
                    i = j;
                  }
                }
                j = 1;
              }
            }
          }
          if (j != 0) {
            aqhq.cn(arrayOfFile.getAbsolutePath());
          }
          k += 1;
        }
      }
      cPr();
      return true;
    }
    
    protected String getKey()
    {
      return "QQThemeMigration";
    }
    
    public boolean needMigration()
    {
      return adi();
    }
    
    public File oldBusinessDir(String paramString)
    {
      return null;
    }
    
    public boolean oldBusinessDirExist(String paramString)
    {
      return false;
    }
    
    public String[] reportHistoryFileInfo()
    {
      return new String[] { "0", "0" };
    }
  }
  
  public static class c
    extends aczs.a
    implements ISecurityFileHelper
  {
    public c()
    {
      super();
    }
    
    public String declareBusinessFileName()
    {
      return "TIM_Favorite";
    }
    
    public boolean doMigrate(File paramFile)
    {
      QLog.d("ISecurityFileHelper", 1, "Move QQFavorite file start");
      File localFile = new File(acbn.bmd);
      if ((localFile.exists()) && (paramFile.isDirectory()))
      {
        paramFile = aczs.d(localFile);
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          localFile = paramFile[i];
          String str = localFile.getName();
          if ((str.length() > 4) && (str.matches("[0-9]{5}.*"))) {
            aqhq.ad(localFile.getAbsolutePath(), acbn.bmd + aczs.jH(str));
          }
          i += 1;
        }
      }
      cPr();
      return true;
    }
    
    protected String getKey()
    {
      return "QQFavoriteMigration";
    }
    
    public boolean needMigration()
    {
      if (adi())
      {
        File localFile = new File(acbn.bmd);
        if ((localFile.exists()) && (localFile.isDirectory())) {
          return true;
        }
        cPr();
      }
      return false;
    }
    
    public File oldBusinessDir(String paramString)
    {
      return null;
    }
    
    public boolean oldBusinessDirExist(String paramString)
    {
      return false;
    }
    
    public String[] reportHistoryFileInfo()
    {
      return new String[] { "0", "0" };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczs
 * JD-Core Version:    0.7.0.1
 */