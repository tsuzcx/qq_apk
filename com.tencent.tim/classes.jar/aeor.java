import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class aeor
  extends aehv<aeoq>
{
  public static String bAb = "{\n    \"switch\":1,\n    \"match\":[\n        {\n            \"key\":\"花木兰\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191028162616_9505/libai_dae.zip\",\n            \"md5\":\"52b1ab75bbd04aef4eb889cc6b625dad\"\n        },\n        {\n            \"key\":\"miku\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191029174146_1019/miku_fbx.zip\",\n            \"md5\":\"f957c6847f06e485a021ed81d5b5024a\"\n        },\n        {\n            \"key\":\"莓莓蛋糕\",\n            \"resUrl\":\"https://d3g.qq.com/sngapp/app/update/20191107111004_5856/cake_dae.zip\",\n            \"md5\":\"4fe9009093acbea20a65f281958879eb\"\n        }\n    ],\n    \"blackList\":\"SLA-AL00\"\n}";
  private WeakReference<awku> av;
  
  private void a(boolean paramBoolean, aeoq paramaeoq, String paramString1, String paramString2)
  {
    awll.a().d(paramaeoq);
    if (this.av == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config listener = null");
      return;
    }
    awku localawku = (awku)this.av.get();
    if (localawku == null)
    {
      QLog.e("VipARConfProcessor", 1, "load config vipARConfigListener = null");
      return;
    }
    if (paramBoolean)
    {
      paramString2 = paramaeoq;
      if (paramaeoq == null) {
        paramString2 = new aeoq();
      }
      QLog.i("VipARConfProcessor", 1, "notifyListener isSuccess : " + paramBoolean + " refer  = " + paramString1 + " data  = " + paramString2.toString());
      localawku.c(paramString2);
      return;
    }
    QLog.i("VipARConfProcessor", 1, "notifyListener fail :  refer  = " + paramString1 + " error = " + paramString2);
    localawku.abU(paramString2);
  }
  
  @NonNull
  public aeoq a(int paramInt)
  {
    QLog.e("VipARConfProcessor", 1, "migrateOldOrDefaultContent: " + paramInt);
    return new aeoq();
  }
  
  @Nullable
  public aeoq a(aeic[] paramArrayOfaeic)
  {
    if (paramArrayOfaeic != null) {
      try
      {
        if (paramArrayOfaeic.length > 0)
        {
          int j = paramArrayOfaeic.length;
          int i = 0;
          while (i < j)
          {
            aeic localaeic = paramArrayOfaeic[i];
            if (localaeic != null)
            {
              aeoq localaeoq = aeoq.a(localaeic.content);
              if (QLog.isColorLevel()) {
                QLog.d("VipARConfProcessor", 2, "onParsed " + localaeic.content);
              }
              if (localaeoq != null) {
                return localaeoq;
              }
            }
            i += 1;
          }
        }
        return new aeoq();
      }
      catch (Exception paramArrayOfaeic)
      {
        paramArrayOfaeic.printStackTrace();
        QLog.e("VipARConfProcessor", 1, "onParsed Exception = " + paramArrayOfaeic.getMessage());
      }
    }
  }
  
  public void b(aeoq paramaeoq)
  {
    if ((QLog.isColorLevel()) && (paramaeoq != null)) {
      QLog.i("VipARConfProcessor", 2, "onUpdate: " + paramaeoq.toString());
    }
    if (paramaeoq != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramaeoq, "onUpdate", " error bean = null");
      return;
    }
  }
  
  public Class<aeoq> clazz()
  {
    return aeoq.class;
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
    QLog.e("VipARConfProcessor", 1, "onReqFailed: " + paramInt);
    a(false, null, "onReqFailed", " failCode = " + paramInt);
  }
  
  public int type()
  {
    return 499;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeor
 * JD-Core Version:    0.7.0.1
 */