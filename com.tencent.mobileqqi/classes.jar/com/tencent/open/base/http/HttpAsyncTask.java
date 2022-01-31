package com.tencent.open.base.http;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.Executor;

public abstract class HttpAsyncTask
  extends AsyncTask
{
  protected static final String g = "https://openmobile.qq.com/";
  protected String h = null;
  protected String i = null;
  
  public HttpAsyncTask(String paramString1, String paramString2)
  {
    this.h = paramString1;
    if (!paramString1.toLowerCase().startsWith("http")) {
      this.h = ("https://openmobile.qq.com/" + paramString1);
    }
    this.i = paramString2;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public Executor a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return ThreadManager.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.http.HttpAsyncTask
 * JD-Core Version:    0.7.0.1
 */