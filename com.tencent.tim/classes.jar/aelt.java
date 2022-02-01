import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aelt
  extends aehv<aels>
{
  public static aels b(int paramInt)
  {
    aels localaels = (aels)aeif.a().o(paramInt);
    if (localaels != null) {
      return localaels;
    }
    return new aels();
  }
  
  @NonNull
  public aels a(int paramInt)
  {
    return new aels();
  }
  
  @Nullable
  public aels a(aeic[] paramArrayOfaeic)
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
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaeic = (aels.a)aeij.a(localObject1, aels.a.class);
      localObject1 = new aels((String)localObject1, paramArrayOfaeic);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaeic)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaeic);
        paramArrayOfaeic = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(aels paramaels)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramaels.getContent());
  }
  
  public Class<aels> clazz()
  {
    return aels.class;
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
    return 467;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelt
 * JD-Core Version:    0.7.0.1
 */