package com.tencent.biz.pubaccount.readinjoy.engine;

import affn;
import affo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lci;
import lci.a;
import lcl;

public final class ReadInJoyWebRenderEngine$3
  implements Runnable
{
  public ReadInJoyWebRenderEngine$3(lci.a parama, String paramString) {}
  
  public void run()
  {
    int j = 0;
    if (!lcl.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInJoyWebRenderEngine", 2, " checkReinstallSoDel is false, return and wait for next load");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("native_render loadLibrary from: ").append(this.val$from);
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (affo.ajd()) {
          continue;
        }
        localStringBuilder.append("viola jsc lib not exist");
        if (this.a != null) {
          this.a.onError(lci.aNh);
        }
        localSharedPreferences1 = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
        l2 = localSharedPreferences1.getLong("js_lib", 0L);
        if (l2 <= 0L) {
          continue;
        }
        if (System.currentTimeMillis() - l2 > 120000L)
        {
          affo.cYK();
          localSharedPreferences1.edit().putLong("js_lib", System.currentTimeMillis()).commit();
        }
        lci.qD(1);
      }
      catch (Throwable localThrowable)
      {
        SharedPreferences localSharedPreferences1;
        lci.access$202(false);
        localStringBuilder.append(localThrowable.getMessage());
        if (this.a == null) {
          continue;
        }
        this.a.onError(lci.aNg);
        return;
        if (affn.ajd()) {
          break label470;
        }
        if (this.a == null) {
          continue;
        }
        this.a.onError(lci.aNi);
        SharedPreferences localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
        long l2 = localSharedPreferences2.getLong("js_lib_biz", 0L);
        if (l2 <= 0L) {
          break label444;
        }
        if (System.currentTimeMillis() - l2 <= 120000L) {
          continue;
        }
        affn.cYK();
        localSharedPreferences2.edit().putLong("js_lib_biz", System.currentTimeMillis()).commit();
        lci.qD(2);
        continue;
      }
      finally
      {
        localStringBuilder.append(", isLoaded: ").append(lci.access$200()).append(", cost: ").append(System.currentTimeMillis() - l1);
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      }
      localStringBuilder.append(", isLoaded: ").append(lci.access$200()).append(", cost: ").append(System.currentTimeMillis() - l1);
      QLog.i("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      return;
      localSharedPreferences1.edit().putLong("js_lib", System.currentTimeMillis()).commit();
      continue;
      label444:
      localObject.edit().putLong("js_lib_biz", System.currentTimeMillis()).commit();
      continue;
      label470:
      String str1 = lcl.jg();
      String[] arrayOfString = affo.eX;
      int k = arrayOfString.length;
      int i = 0;
      String str2;
      File localFile;
      while (i < k)
      {
        str2 = arrayOfString[i];
        localFile = new File(str1, str2);
        if (localFile.exists())
        {
          System.load(localFile.getAbsolutePath());
          i += 1;
        }
        else
        {
          if (this.a != null) {
            this.a.onError(lci.aNh);
          }
          localStringBuilder.append(str2).append(" not exist");
          lci.qD(1);
        }
      }
      arrayOfString = affn.eX;
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        str2 = arrayOfString[i];
        localFile = new File(str1, str2);
        if (localFile.exists())
        {
          System.load(localFile.getAbsolutePath());
          i += 1;
        }
        else
        {
          if (this.a != null) {
            this.a.onError(lci.aNi);
          }
          localStringBuilder.append(str2).append(" not exist");
          lci.qD(2);
        }
      }
      lci.access$202(true);
      if (this.a != null) {
        this.a.onFinish(lci.aNk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.3
 * JD-Core Version:    0.7.0.1
 */