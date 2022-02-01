import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anvz
  extends aehv<anvz.a>
{
  public static anvz.a a()
  {
    return (anvz.a)aeif.a().o(610);
  }
  
  @NonNull
  public anvz.a a(int paramInt)
  {
    return new anvz.a();
  }
  
  @Nullable
  public anvz.a a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModeConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return anvz.a.b(paramArrayOfaeic);
    }
    return null;
  }
  
  public void a(anvz.a parama) {}
  
  public Class<anvz.a> clazz()
  {
    return anvz.a.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 610;
  }
  
  public static final class a
  {
    public boolean cKj;
    public int dNf;
    
    public static boolean a(a parama)
    {
      return parama.dNf == 1;
    }
    
    public static a b(aeic[] paramArrayOfaeic)
    {
      a locala = new a();
      if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < paramArrayOfaeic.length)
          {
            String str = paramArrayOfaeic[i].content;
            try
            {
              locala.dNf = new JSONObject(str).optInt("ConfigEnableStudyMode");
              locala.cKj = true;
              anwa.QF(a(locala));
              QLog.i("StudyModeConfigProcessor", 1, "[study mode config], mGraySwitch:" + locala.dNf);
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e("StudyModeConfigProcessor", 1, localThrowable, new Object[0]);
              }
            }
          }
        }
      }
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvz
 * JD-Core Version:    0.7.0.1
 */