package com.tencent.open.appcommon.js;

import android.app.Activity;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.JsWebWorker;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public class WebWorkerInterface
  extends BaseInterface
{
  protected JsWebWorker a;
  protected final WebView a;
  
  public WebWorkerInterface(Activity paramActivity, WebView paramWebView)
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.jdField_a_of_type_ComTencentOpenAppcommonJsWebWorker = new JsWebWorker(paramActivity, paramWebView);
  }
  
  public void async_Work(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (!hasRight()) {}
    while (paramString1.indexOf(File.pathSeparator) != -1) {
      return;
    }
    paramString1 = Common.e() + File.separator + paramString1;
    this.jdField_a_of_type_ComTencentOpenAppcommonJsWebWorker.a(paramString1, paramString2, paramString3, paramArrayOfString);
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentOpenAppcommonJsWebWorker.a(this.jdField_a_of_type_ComTencentSmttSdkWebView.hashCode());
  }
  
  public String doWork(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    if (!hasRight()) {
      paramString1 = "baby,you don't have permission";
    }
    do
    {
      return paramString1;
      LogUtility.c("JsWebWorker", "invoke>>" + paramString1 + ">>>" + paramString2 + ">>>" + paramString3);
      if (paramString1.indexOf(File.pathSeparator) != -1) {
        return "baby,you don't have permission";
      }
      paramString1 = Common.e() + File.separator + paramString1;
      paramString2 = this.jdField_a_of_type_ComTencentOpenAppcommonJsWebWorker.a(paramString1, paramString2, paramString3, paramArrayOfString);
      paramString1 = paramString2;
    } while (!StringAddition.a(paramString2));
    return "";
  }
  
  public String getInterfaceName()
  {
    return "q_worker";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.WebWorkerInterface
 * JD-Core Version:    0.7.0.1
 */