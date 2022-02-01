import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aeiy
  extends aehv<aeix>
{
  public static aeix b(int paramInt)
  {
    aeix localaeix = (aeix)aeif.a().o(paramInt);
    if (localaeix != null) {
      return localaeix;
    }
    return new aeix();
  }
  
  @NonNull
  public aeix a(int paramInt)
  {
    return new aeix();
  }
  
  public aeix a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    return new aeix(paramString);
  }
  
  @Nullable
  public aeix a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + type());
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      paramArrayOfaeic = paramArrayOfaeic[0].content;
      if (!TextUtils.isEmpty(paramArrayOfaeic)) {
        return a(paramArrayOfaeic);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + type());
    }
    return null;
  }
  
  public void a(aeix paramaeix)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onUpdate]  config type = " + type());
    }
  }
  
  public Class<aeix> clazz()
  {
    return aeix.class;
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
    QLog.d("ArkConfProcessor", 1, "[onReqFailed] failCode=" + paramInt + ", config type = " + type());
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
  }
  
  public int type()
  {
    return 0;
  }
  
  public static class a
    extends aeiy
  {
    public aeix a(String paramString)
    {
      QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
      try
      {
        aeje.a locala = (aeje.a)aeij.a(paramString, aeje.a.class);
        return new aeix.a(paramString, locala);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("ArkAIDictConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
          Object localObject = null;
        }
      }
    }
    
    public void a(aeix paramaeix)
    {
      super.a(paramaeix);
      if (paramaeix == null) {
        QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
      }
      do
      {
        do
        {
          do
          {
            return;
            QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaeix.getContent());
            paramaeix = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          } while (paramaeix == null);
          paramaeix = (ArkAppCenter)paramaeix.getManager(121);
        } while (paramaeix == null);
        paramaeix = paramaeix.a();
      } while (paramaeix == null);
      paramaeix.cTz();
    }
    
    public int type()
    {
      return 170;
    }
  }
  
  public static class b
    extends aeiy
  {
    public aeix a(String paramString)
    {
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
      for (;;)
      {
        try
        {
          aeje.b localb = (aeje.b)aeij.a(paramString, aeje.b.class);
          aeje.l locall;
          QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException1)
        {
          try
          {
            locall = (aeje.l)aeij.a(paramString, aeje.l.class);
            return new aeix.b(paramString, localb, locall);
          }
          catch (QStorageInstantiateException localQStorageInstantiateException2)
          {
            Object localObject;
            break label71;
          }
          localQStorageInstantiateException1 = localQStorageInstantiateException1;
          localb = null;
        }
        label71:
        localObject = null;
      }
    }
    
    public void a(aeix paramaeix)
    {
      super.a(paramaeix);
      if (paramaeix == null) {
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
      }
      adph localadph;
      do
      {
        return;
        QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaeix.getContent());
        localadph = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
        paramaeix = paramaeix.a();
      } while (paramaeix == null);
      localadph.a(paramaeix.a());
    }
    
    public int type()
    {
      return 186;
    }
  }
  
  public static class c
    extends aeiy
  {
    public aeix a(String paramString)
    {
      QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
      try
      {
        aeje.c localc = (aeje.c)aeij.a(paramString, aeje.c.class);
        return new aeix.c(paramString, localc);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("ArkConfProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
          Object localObject = null;
        }
      }
    }
    
    public int type()
    {
      return 250;
    }
  }
  
  public static class d
    extends aeiy
  {
    public aeix a(String paramString)
    {
      QLog.d("ArkMsgAIDisableConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
      try
      {
        aeje.g localg = (aeje.g)aeij.a(paramString, aeje.g.class);
        return new aeix.d(paramString, localg);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("ArkMsgAIDisableConfProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
          Object localObject = null;
        }
      }
    }
    
    public boolean isAccountRelated()
    {
      return true;
    }
    
    public int type()
    {
      return 159;
    }
  }
  
  public static class e
    extends aeiy
  {
    public aeix a(String paramString)
    {
      QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
      try
      {
        aeje.h localh = (aeje.h)aeij.a(paramString, aeje.h.class);
        return new aeix.e(paramString, localh);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("ArkPlatformConfProcessor", 1, "readJsonOrXml:" + paramString + "fail", localQStorageInstantiateException);
          Object localObject = null;
        }
      }
    }
    
    public void a(aeix paramaeix)
    {
      super.a(paramaeix);
      if (paramaeix == null) {
        QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
      }
      do
      {
        return;
        QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramaeix.getContent());
        paramaeix = paramaeix.a();
        adqt.cTP();
      } while ((paramaeix == null) || (paramaeix.a() == null));
      paramaeix = paramaeix.a();
      if (paramaeix == null)
      {
        QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
        return;
      }
      ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramaeix.bUl, paramaeix.vC, paramaeix.vB);
    }
    
    public int type()
    {
      return 380;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeiy
 * JD-Core Version:    0.7.0.1
 */