package com.tencent.mobileqq.imcore.proxy;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.OGAbstractDao;
import java.util.HashMap;

public class IMCoreProxyRoute
{
  public static class AIOUtils
  {
    private static Proxy AIOUtilsProxy;
    
    public static boolean getLogcatDBOperation()
    {
      if (AIOUtilsProxy != null) {
        return AIOUtilsProxy.getLogcatDBOperation();
      }
      return false;
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      AIOUtilsProxy = paramProxy;
    }
    
    public static abstract interface Proxy
    {
      public abstract boolean getLogcatDBOperation();
    }
  }
  
  public static class CaughtExceptionReport
  {
    private static Proxy CaughtExceptionReportProxy;
    
    public static void e(@NonNull Throwable paramThrowable, @NonNull String paramString)
    {
      if (CaughtExceptionReportProxy != null) {
        CaughtExceptionReportProxy.e(paramThrowable, paramString);
      }
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      CaughtExceptionReportProxy = paramProxy;
    }
    
    public static abstract interface Proxy
    {
      public abstract void e(@NonNull Throwable paramThrowable, @NonNull String paramString);
    }
  }
  
  public static abstract interface GetStaticProxy<T>
  {
    public abstract T get();
  }
  
  public static class MsgProxyUtils
  {
    private static Proxy MsgProxyUtilsProxy;
    
    public static boolean isSaveConversation(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      if (MsgProxyUtilsProxy != null) {
        return MsgProxyUtilsProxy.isSaveConversation(paramString1, paramString2, paramInt1, paramInt2);
      }
      return true;
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      MsgProxyUtilsProxy = paramProxy;
    }
    
    public static abstract interface Proxy
    {
      public abstract boolean isSaveConversation(String paramString1, String paramString2, int paramInt1, int paramInt2);
    }
  }
  
  public static class OGEntityDaoManager
  {
    private static Proxy OGEntityDaoManagerProxy;
    
    public static OGAbstractDao getEntityDao(Class paramClass)
    {
      if (OGEntityDaoManagerProxy != null) {
        return OGEntityDaoManagerProxy.getEntityDao(paramClass);
      }
      return null;
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      OGEntityDaoManagerProxy = paramProxy;
    }
    
    public static abstract interface Proxy
    {
      public abstract OGAbstractDao getEntityDao(Class paramClass);
    }
  }
  
  public static class SQLiteFTSUtils
  {
    private static Proxy SQLiteFTSUtilsProxy;
    
    public static int getFTSNotifyFlag()
    {
      if (SQLiteFTSUtilsProxy != null) {
        return SQLiteFTSUtilsProxy.getFTSNotifyFlag();
      }
      return 0;
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      SQLiteFTSUtilsProxy = paramProxy;
    }
    
    public static abstract interface Proxy
    {
      public abstract int getFTSNotifyFlag();
    }
  }
  
  public static class StatisticCollector
  {
    public static final String DB_OP_RESULT = "DatabaseOperatorResult_";
    private static Proxy StatisticCollectorProxy;
    
    public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
    {
      if (StatisticCollectorProxy != null) {
        StatisticCollectorProxy.collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
      }
    }
    
    public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
    {
      if (StatisticCollectorProxy != null) {
        StatisticCollectorProxy.collectPerformance(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
      }
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      StatisticCollectorProxy = paramProxy;
    }
    
    public static abstract interface Proxy
    {
      public abstract void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3);
      
      public abstract void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2);
    }
    
    public static class ReportTag
    {
      public static final String TAG_FAIL_CODE = "param_FailCode";
    }
  }
  
  public static class TableBuilder
  {
    private static Proxy TableBuilderProxy;
    
    public static String createIndexSQLStatement(Entity paramEntity)
    {
      if (TableBuilderProxy != null) {
        return TableBuilderProxy.createIndexSQLStatement(paramEntity);
      }
      return null;
    }
    
    public static Class[] getNeedPrivateFieldsClass()
    {
      if (TableBuilderProxy != null) {
        return TableBuilderProxy.getNeedPrivateFieldsClass();
      }
      return new Class[0];
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      TableBuilderProxy = paramProxy;
    }
    
    public static abstract interface Proxy
    {
      public abstract String createIndexSQLStatement(Entity paramEntity);
      
      public abstract Class[] getNeedPrivateFieldsClass();
    }
  }
  
  public static class ThreadRegulator
  {
    private static Proxy ThreadRegulatorProxy;
    
    public static void checkInNextBusiness()
    {
      if (ThreadRegulatorProxy != null) {
        ThreadRegulatorProxy.checkInNextBusiness();
      }
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      ThreadRegulatorProxy = paramProxy;
    }
    
    public static abstract interface Proxy
    {
      public abstract void checkInNextBusiness();
    }
  }
  
  public static class ThreadTraceHelper
  {
    private static Proxy threadTraceProxy;
    
    public static void addWaitingTransThread(long paramLong, String paramString)
    {
      if (threadTraceProxy != null) {
        threadTraceProxy.addWaitingTransThread(paramLong, paramString);
      }
    }
    
    public static void registerProxy(Proxy paramProxy)
    {
      threadTraceProxy = paramProxy;
    }
    
    public static void removeWaitingTransThread(long paramLong)
    {
      if (threadTraceProxy != null) {
        threadTraceProxy.removeWaitingTransThread(paramLong);
      }
    }
    
    public static void setCurrentTransThread(long paramLong, String paramString)
    {
      if (threadTraceProxy != null) {
        threadTraceProxy.setCurrentTransThread(paramLong, paramString);
      }
    }
    
    public static abstract interface Proxy
    {
      public abstract void addWaitingTransThread(long paramLong, String paramString);
      
      public abstract void removeWaitingTransThread(long paramLong);
      
      public abstract void setCurrentTransThread(long paramLong, String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute
 * JD-Core Version:    0.7.0.1
 */