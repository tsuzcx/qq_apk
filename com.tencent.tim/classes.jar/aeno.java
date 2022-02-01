import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeno
  extends aehv<aeno.a>
{
  @NonNull
  public aeno.a a(int paramInt)
  {
    return new aeno.a();
  }
  
  @Nullable
  public aeno.a a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aeno.a locala = new aeno.a();
      locala.b(paramArrayOfaeic);
      return locala;
    }
    return new aeno.a();
  }
  
  public void a(aeno.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<aeno.a> clazz()
  {
    return aeno.a.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      return aqmj.ax(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 368;
  }
  
  public static class a
  {
    public void b(aeic[] paramArrayOfaeic)
    {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[handleReadInJoyResetAllConfig] " + paramArrayOfaeic);
      if (paramArrayOfaeic != null) {
        try
        {
          if (paramArrayOfaeic.length > 0)
          {
            new kzj();
            int j = paramArrayOfaeic.length;
            int i = 0;
            while (i < j)
            {
              boolean bool = TextUtils.isEmpty(paramArrayOfaeic[i].content);
              if (bool) {}
              i += 1;
            }
          }
          return;
        }
        catch (Exception paramArrayOfaeic)
        {
          QLog.e("ReadinjoyResetFunctionConfProcessor", 1, "[handleReadInJoyResetAllConfig] ", paramArrayOfaeic);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeno
 * JD-Core Version:    0.7.0.1
 */