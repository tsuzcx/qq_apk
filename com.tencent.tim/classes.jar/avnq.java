import android.content.Context;
import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.qqreader.shadow.ReaderShadowImpl.1;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class avnq
  implements IShadow
{
  private static avnq jdField_a_of_type_Avnq;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService u;
  
  private avnq()
  {
    setILoggerFactory();
    this.u = acmo.b(192);
  }
  
  public static avnq a()
  {
    if (jdField_a_of_type_Avnq == null) {}
    try
    {
      if (jdField_a_of_type_Avnq == null) {
        jdField_a_of_type_Avnq = new avnq();
      }
      return jdField_a_of_type_Avnq;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new aibt("Reader");
    aibq localaibq = new aibq(paramContext, "Reader", paramString, "5");
    boolean bool;
    if ((localaibq.wasUpdating()) || (localaibq.getLatest() == null))
    {
      bool = true;
      avoc.i("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localaibq.update();
      if (!bool) {
        break label209;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if ((paramString == null) || (avnp.e(paramContext, paramString))) {
          break label220;
        }
        bool = paramString.delete();
        avoc.e("ReaderShadowImpl", "[loadPluginManager] pm apk is invalid and delete result=" + bool);
        paramContext = null;
        if (paramContext == null) {
          break label218;
        }
        return new DynamicPluginManager(new avns(localaibq, paramContext));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        avoc.e("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        avof.h(paramContext, -101, "cdn update ExecutionException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        avoc.e("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        avof.h(paramContext, -102, "cdn update InterruptedException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      label209:
      paramString = localaibq.getLatest();
      continue;
      label218:
      return null;
      label220:
      paramContext = paramString;
    }
  }
  
  public void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    this.u.execute(new ReaderShadowImpl.1(this, paramContext, paramString1, paramString2, paramLong, paramBundle, paramEnterCallback));
  }
  
  public PluginManager getPluginManager(Context paramContext, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager == null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager = a(paramContext, paramString1);
    }
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  }
  
  public boolean hasPluginManager()
  {
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager != null;
  }
  
  public void setILoggerFactory()
  {
    if (LoggerFactory.getILoggerFactory() == null) {
      LoggerFactory.setILoggerFactory(aibx.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnq
 * JD-Core Version:    0.7.0.1
 */