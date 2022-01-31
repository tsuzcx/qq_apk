package com.tencent.open.base.http;

import android.content.Context;
import android.os.Bundle;

public class ImageUploadAsyncTask
  extends HttpCgiAsyncTask
{
  protected Context a;
  
  public ImageUploadAsyncTask(Context paramContext, String paramString1, String paramString2, HttpCgiAsyncTask.Callback paramCallback)
  {
    super(paramString1, paramString2, paramCallback);
    this.a = paramContext;
  }
  
  public HttpBaseUtil.Statistic a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return HttpBaseUtil.a(this.a, paramString1, paramString2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.http.ImageUploadAsyncTask
 * JD-Core Version:    0.7.0.1
 */