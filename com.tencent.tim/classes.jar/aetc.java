import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aetc
  extends aehv<aetb>
{
  public static aetb a()
  {
    aetb localaetb = (aetb)aeif.a().o(529);
    if (localaetb != null) {
      return localaetb;
    }
    return new aetb();
  }
  
  @NonNull
  public aetb a(int paramInt)
  {
    return new aetb();
  }
  
  @Nullable
  public aetb a(aeic[] paramArrayOfaeic)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfaeic != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaeic.length > 0)
      {
        str = paramArrayOfaeic[0].content;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str)) {
          if (QLog.isColorLevel()) {
            QLog.e("SigTopicConfProcessor", 1, "SigTopic.[onParsed] type=" + type() + ", content = " + str);
          }
        }
      }
    }
    try
    {
      paramArrayOfaeic = (aetb.a)aeij.a(str, aetb.a.class);
      localObject1 = new aetb(str, paramArrayOfaeic);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaeic)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfaeic);
        paramArrayOfaeic = null;
      }
    }
  }
  
  public void a(aetb paramaetb) {}
  
  public Class<aetb> clazz()
  {
    return aetb.class;
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
    return 529;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetc
 * JD-Core Version:    0.7.0.1
 */