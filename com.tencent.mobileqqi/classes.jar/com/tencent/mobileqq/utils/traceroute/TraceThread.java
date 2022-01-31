package com.tencent.mobileqq.utils.traceroute;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TraceThread
  extends Thread
{
  private int jdField_a_of_type_Int;
  private TraceConstants.TraceMethod jdField_a_of_type_ComTencentMobileqqUtilsTracerouteTraceConstants$TraceMethod;
  private String jdField_a_of_type_JavaLangString = "TraceRoute";
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  private String b;
  
  public TraceThread(Handler paramHandler, TraceConstants.TraceMethod paramTraceMethod, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
    int i = paramInt;
    if (paramInt < 0) {
      i = 1;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentMobileqqUtilsTracerouteTraceConstants$TraceMethod = paramTraceMethod;
  }
  
  private String a(String paramString)
  {
    return c("ping " + paramString + " -c " + this.jdField_a_of_type_Int);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Message localMessage;
    do
    {
      return;
      localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = paramString;
      paramString = (Handler)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString == null);
    paramString.sendMessage(localMessage);
  }
  
  @SuppressLint({"all"})
  private String b(String paramString)
  {
    return c("/data/data/com.tencent.mobileqqi/traceroute " + paramString);
  }
  
  private String c(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    for (;;)
    {
      try
      {
        localProcess = Runtime.getRuntime().exec(paramString);
        str1 = str2;
        localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
        str1 = str2;
        paramString = localBufferedReader.readLine();
        if (paramString != null) {
          break label157;
        }
        str1 = str2;
        localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getErrorStream()));
        str1 = str2;
        str2 = localBufferedReader.readLine();
        paramString = "";
        str1 = str2;
        if (str1 == null) {}
      }
      catch (IOException localIOException1)
      {
        Process localProcess;
        BufferedReader localBufferedReader;
        paramString = str1;
        localIOException1.printStackTrace();
        return paramString;
      }
      try
      {
        str1 = paramString + str1 + "\r\n";
        paramString = str1;
        str1 = paramString;
        str2 = localBufferedReader.readLine();
        str1 = str2;
      }
      catch (IOException localIOException2)
      {
        continue;
      }
      localBufferedReader.close();
      localProcess.destroy();
      return paramString;
      label157:
      str2 = "";
      str1 = paramString;
      paramString = str2;
    }
  }
  
  public void run()
  {
    Object localObject;
    try
    {
      setName("trace-" + this.b);
      localObject = InetAddress.getByName(this.b);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsTracerouteTraceConstants$TraceMethod == TraceConstants.TraceMethod.UDP) {}
      for (localObject = b(((InetAddress)localObject).getHostAddress()); ((String)localObject).length() > 0; localObject = a(this.b))
      {
        a((String)localObject, TraceConstants.TraceAction.TRACE_COMPLETE.ordinal());
        return;
      }
      a((String)localObject, TraceConstants.TraceAction.TRACE_ERROR.ordinal());
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      localUnknownHostException.printStackTrace();
      localObject = "";
    }
    try
    {
      String str = localUnknownHostException.getMessage();
      localObject = str;
    }
    catch (Exception localException)
    {
      label111:
      break label111;
    }
    a((String)localObject, TraceConstants.TraceAction.TRACE_ERROR.ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.traceroute.TraceThread
 * JD-Core Version:    0.7.0.1
 */