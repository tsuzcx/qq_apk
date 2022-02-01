import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class aibx
  implements ILoggerFactory
{
  private static aibx jdField_a_of_type_Aibx = new aibx();
  private final ConcurrentMap<String, Logger> jdField_a_of_type_JavaUtilConcurrentConcurrentMap = new ConcurrentHashMap();
  
  public static ILoggerFactory a()
  {
    return jdField_a_of_type_Aibx;
  }
  
  public Logger getLogger(String paramString)
  {
    Logger localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.get(paramString);
    if (localLogger != null) {
      paramString = localLogger;
    }
    aibx.a locala;
    do
    {
      return paramString;
      locala = new aibx.a(paramString);
      localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.putIfAbsent(paramString, locala);
      paramString = localLogger;
    } while (localLogger != null);
    return locala;
  }
  
  class a
    implements Logger
  {
    private String name;
    
    a(String paramString)
    {
      this.name = paramString;
    }
    
    private void log(int paramInt, String paramString, Throwable paramThrowable)
    {
      String str = String.valueOf(this.name);
      switch (paramInt)
      {
      default: 
        return;
      case 4: 
      case 5: 
        if (paramThrowable == null)
        {
          QLog.d(str, 4, paramString);
          return;
        }
        QLog.d(str, 4, paramString, paramThrowable);
        return;
      case 3: 
        if (paramThrowable == null)
        {
          QLog.i(str, 2, paramString);
          return;
        }
        QLog.i(str, 2, paramString, paramThrowable);
        return;
      case 2: 
        if (paramThrowable == null)
        {
          QLog.w(str, 1, paramString);
          return;
        }
        QLog.w(str, 1, paramString, paramThrowable);
        return;
      }
      if (paramThrowable == null)
      {
        QLog.e(str, 1, paramString);
        return;
      }
      QLog.e(str, 1, paramString, paramThrowable);
    }
    
    public void debug(String paramString)
    {
      log(4, paramString, null);
    }
    
    public void debug(String paramString, Object paramObject)
    {
      log(4, aicd.a(paramString, paramObject).getMessage(), null);
    }
    
    public void debug(String paramString, Object paramObject1, Object paramObject2)
    {
      log(4, aicd.a(paramString, paramObject1, paramObject2).getMessage(), null);
    }
    
    public void debug(String paramString, Throwable paramThrowable)
    {
      log(4, paramString, paramThrowable);
    }
    
    public void debug(String paramString, Object... paramVarArgs)
    {
      log(4, aicd.a(paramString, paramVarArgs).getMessage(), null);
    }
    
    public void error(String paramString)
    {
      log(1, paramString, null);
    }
    
    public void error(String paramString, Object paramObject)
    {
      log(1, aicd.a(paramString, paramObject).getMessage(), null);
    }
    
    public void error(String paramString, Object paramObject1, Object paramObject2)
    {
      log(1, aicd.a(paramString, paramObject1, paramObject2).getMessage(), null);
    }
    
    public void error(String paramString, Throwable paramThrowable)
    {
      log(1, paramString, paramThrowable);
    }
    
    public void error(String paramString, Object... paramVarArgs)
    {
      log(1, aicd.a(paramString, paramVarArgs).getMessage(), null);
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public void info(String paramString)
    {
      log(3, paramString, null);
    }
    
    public void info(String paramString, Object paramObject)
    {
      log(3, aicd.a(paramString, paramObject).getMessage(), null);
    }
    
    public void info(String paramString, Object paramObject1, Object paramObject2)
    {
      log(3, aicd.a(paramString, paramObject1, paramObject2).getMessage(), null);
    }
    
    public void info(String paramString, Throwable paramThrowable)
    {
      log(3, paramString, paramThrowable);
    }
    
    public void info(String paramString, Object... paramVarArgs)
    {
      log(3, aicd.a(paramString, paramVarArgs).getMessage(), null);
    }
    
    public boolean isDebugEnabled()
    {
      return QLog.isDevelopLevel();
    }
    
    public boolean isErrorEnabled()
    {
      return QLog.getUIN_REPORTLOG_LEVEL() >= 1;
    }
    
    public boolean isInfoEnabled()
    {
      return QLog.isColorLevel();
    }
    
    public boolean isTraceEnabled()
    {
      return QLog.isDevelopLevel();
    }
    
    public boolean isWarnEnabled()
    {
      return QLog.getUIN_REPORTLOG_LEVEL() >= 1;
    }
    
    public void trace(String paramString)
    {
      log(5, paramString, null);
    }
    
    public void trace(String paramString, Object paramObject)
    {
      log(5, aicd.a(paramString, paramObject).getMessage(), null);
    }
    
    public void trace(String paramString, Object paramObject1, Object paramObject2)
    {
      log(5, aicd.a(paramString, paramObject1, paramObject2).getMessage(), null);
    }
    
    public void trace(String paramString, Throwable paramThrowable)
    {
      log(5, paramString, paramThrowable);
    }
    
    public void trace(String paramString, Object... paramVarArgs)
    {
      log(5, aicd.a(paramString, paramVarArgs).getMessage(), null);
    }
    
    public void warn(String paramString)
    {
      log(2, paramString, null);
    }
    
    public void warn(String paramString, Object paramObject)
    {
      log(2, aicd.a(paramString, paramObject).getMessage(), null);
    }
    
    public void warn(String paramString, Object paramObject1, Object paramObject2)
    {
      log(2, aicd.a(paramString, paramObject1, paramObject2).getMessage(), null);
    }
    
    public void warn(String paramString, Throwable paramThrowable)
    {
      log(2, paramString, paramThrowable);
    }
    
    public void warn(String paramString, Object... paramVarArgs)
    {
      log(2, aicd.a(paramString, paramVarArgs).getMessage(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibx
 * JD-Core Version:    0.7.0.1
 */