package com.tencent.open.appcommon;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import hon;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public class ResourceUpdater$CheckUpdateCallback
  implements HttpCgiAsyncTask.Callback
{
  public String a;
  public CountDownLatch a;
  
  public ResourceUpdater$CheckUpdateCallback(CountDownLatch paramCountDownLatch, String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = paramCountDownLatch;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(Exception paramException)
  {
    LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> CheckUpdateCallback -> Check update cgi request exception : " + paramException.toString());
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    LogUtility.b(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> Resource update check end !!!");
    Common.a(false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogUtility.a(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> CheckUpdateCallback -> reponseCode OK. result = " + paramJSONObject);
    ThreadManager.a(new hon(this, paramJSONObject));
    Common.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.ResourceUpdater.CheckUpdateCallback
 * JD-Core Version:    0.7.0.1
 */