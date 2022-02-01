import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aelr
  extends aehv<aelq>
{
  public static aelq b(int paramInt)
  {
    aelq localaelq = (aelq)aeif.a().o(paramInt);
    if (localaelq != null) {
      return localaelq;
    }
    return new aelq();
  }
  
  @NonNull
  public aelq a(int paramInt)
  {
    return new aelq();
  }
  
  @Nullable
  public aelq a(aeic[] paramArrayOfaeic)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaeic != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaeic.length > 0)
      {
        localObject1 = paramArrayOfaeic[0].content;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaeic = (aelq.a)aeij.a(localObject1, aelq.a.class);
      localObject1 = new aelq((String)localObject1, paramArrayOfaeic);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaeic)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaeic);
        paramArrayOfaeic = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(aelq paramaelq)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramaelq.getContent());
  }
  
  public Class<aelq> clazz()
  {
    return aelq.class;
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
    return 466;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelr
 * JD-Core Version:    0.7.0.1
 */