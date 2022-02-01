import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class zau
  extends aehv<ContactReportUtils.a>
{
  @NonNull
  public ContactReportUtils.a a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new ContactReportUtils.a();
  }
  
  @Nullable
  public ContactReportUtils.a a(aeic[] paramArrayOfaeic)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfaeic);
      if (paramArrayOfaeic != null)
      {
        j = paramArrayOfaeic.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaeic[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((aeic)localObject1).content);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      j = paramArrayOfaeic.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaeic[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aeic)localObject2).content))) {
          try
          {
            localObject1 = new ContactReportUtils.a();
            localObject2 = new JSONObject(((aeic)localObject2).content);
            if (((JSONObject)localObject2).has("enable")) {
              ((ContactReportUtils.a)localObject1).isEnable = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((ContactReportUtils.a)localObject1).interval = ((JSONObject)localObject2).getLong("interval");
            }
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("ReportExposeConfigProcessor", 1, localThrowable, new Object[0]);
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void b(ContactReportUtils.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (parama != null) {
      ContactReportUtils.a(parama);
    }
  }
  
  public Class<ContactReportUtils.a> clazz()
  {
    return ContactReportUtils.a.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 438;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zau
 * JD-Core Version:    0.7.0.1
 */