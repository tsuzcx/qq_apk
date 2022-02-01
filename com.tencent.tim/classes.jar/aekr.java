import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class aekr
  extends aehv<aekq>
{
  @NonNull
  public aekq a(int paramInt)
  {
    return new aekq();
  }
  
  @Nullable
  public aekq a(aeic[] paramArrayOfaeic)
  {
    QLog.i("MSFConfigProcessor", 1, "[onParsed] config");
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aekq localaekq = aekq.a(paramArrayOfaeic[0].content);
      QLog.d("MSFConfigProcessor", 1, "onParsed " + paramArrayOfaeic[0].content);
      return localaekq;
    }
    QLog.d("MSFConfigProcessor", 1, "onParsed is null");
    return new aekq();
  }
  
  public void a(aekq paramaekq)
  {
    if (paramaekq == null)
    {
      QLog.e("MSFConfigProcessor", 1, "onUpdate but newConf==null");
      return;
    }
    QLog.d("MSFConfigProcessor", 1, "onUpdate " + paramaekq.toString());
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("sp_crypt", 4).edit();
    localEditor.putBoolean("manager_enable_crypt", paramaekq.bUJ);
    localEditor.putBoolean("is_crypt_log_open", paramaekq.bUK);
    localEditor.apply();
  }
  
  public Class<aekq> clazz()
  {
    return aekq.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("MSFConfigProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 661;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekr
 * JD-Core Version:    0.7.0.1
 */