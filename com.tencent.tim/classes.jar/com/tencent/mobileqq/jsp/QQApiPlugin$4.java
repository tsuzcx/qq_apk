package com.tencent.mobileqq.jsp;

import aiju;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import arts;
import artv.b;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.io.IOException;
import java.util.Map;
import jqc;

public class QQApiPlugin$4
  implements Runnable
{
  public QQApiPlugin$4(aiju paramaiju, String paramString1, Map paramMap, Runnable paramRunnable, String paramString2, String paramString3) {}
  
  public void run()
  {
    int i = 1;
    try
    {
      localObject1 = jqc.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.akc), "GET", null, null);
      if (localObject1 == null) {
        break label126;
      }
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      if (localObject1 == null) {
        break label126;
      }
      int j = ((Bitmap)localObject1).getWidth();
      int k = ((Bitmap)localObject1).getHeight();
      if (j * k <= 8000) {
        break label370;
      }
      double d = Math.sqrt(8000.0D / (j * k));
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(j * d), (int)(k * d), true);
      ((Bitmap)localObject1).recycle();
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject1;
      Object localObject2;
      break label126;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    this.eI.put("image", localObject1);
    label126:
    if (this.this$0.mRuntime.getActivity().getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
    {
      this.this$0.mRuntime.getActivity().runOnUiThread(this.val$r);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "96");
      localObject2 = new StringBuilder().append("");
      if (this.eI.get("image") != null) {
        break label350;
      }
      ((Bundle)localObject1).putString("intext_1", i);
      ((Bundle)localObject1).putString("intext_4", "0");
      localObject2 = new StringBuilder().append("");
      if (!"2".equals(this.amz)) {
        break label355;
      }
    }
    label222:
    label355:
    for (i = 3;; i = 4)
    {
      ((Bundle)localObject1).putString("intext_3", artv.b.kL(i));
      ((Bundle)localObject1).putString("stringext_1", this.ake);
      arts.a().a((Bundle)localObject1, "", this.this$0.mRuntime.a().getAccount(), false);
      return;
      this.this$0.mRuntime.a().runOnUiThread(this.val$r);
      break;
      i = 0;
      break label222;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin.4
 * JD-Core Version:    0.7.0.1
 */