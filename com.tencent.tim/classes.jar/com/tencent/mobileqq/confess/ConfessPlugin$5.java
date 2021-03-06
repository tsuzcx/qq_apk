package com.tencent.mobileqq.confess;

import aeha;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import jqc;
import mqq.os.MqqHandler;
import org.json.JSONArray;

public class ConfessPlugin$5
  implements Runnable
{
  ConfessPlugin$5(ConfessPlugin paramConfessPlugin, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray, String paramString4, String paramString5, String paramString6, int paramInt4, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject3 = this.this$0.mRuntime.getActivity();
    Object localObject4 = this.this$0.mRuntime.a();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("activity=").append(localObject3).append("  app=").append(localObject4).append(" finishing?");
      if ((localObject3 == null) || (!((Activity)localObject3).isFinishing())) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ConfessPlugin", 2, bool);
      if ((localObject3 != null) && (localObject4 != null) && (!((Activity)localObject3).isFinishing())) {
        break;
      }
      ConfessPlugin.a(this.this$0);
      ConfessPlugin.a(this.this$0, false);
      return;
    }
    Bitmap localBitmap = aeha.a((AppInterface)localObject4, (Context)localObject3, this.cMR, this.cMS, this.val$type, this.val$title, this.val$desc, this.ake, this.I, this.this$0.b);
    if ((this.cMS == 0) && (localBitmap != null)) {}
    for (Object localObject2 = aeha.b((AppInterface)localObject4, (Context)localObject3, this.cMR, this.cMS, this.val$type, this.val$title, this.val$desc, this.ake, this.I, this.this$0.b);; localObject2 = null)
    {
      if ((localBitmap == null) || ((this.cMS == 0) && (localObject2 == null)))
      {
        ConfessPlugin.a(this.this$0);
        ConfessPlugin.a(this.this$0, false);
        ConfessPlugin.a(this.this$0, 0, 2131720152);
        return;
      }
      String str3 = aeha.a((AppInterface)localObject4, (Context)localObject3, localBitmap);
      String str1 = this.ake;
      if (this.cMS == 0)
      {
        localObject1 = aeha.a(str3, this.this$0.mRuntime.a());
        localObject2 = aeha.a(aeha.a((AppInterface)localObject4, (Context)localObject3, (Bitmap)localObject2), this.this$0.mRuntime.a());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = ((String)localObject2).replace("http://qqadapt.qpic.cn/qqshare/", "");
          str1 = Uri.parse(this.ake).buildUpon().appendQueryParameter("ct", (String)localObject3).build().toString();
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(str3)) || ((this.cMS == 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))))
        {
          ConfessPlugin.a(this.this$0);
          ConfessPlugin.a(this.this$0, false);
          ConfessPlugin.a(this.this$0, 1, 2131698711);
          return;
        }
        localObject2 = this.bxl;
        String str2 = this.bxm;
        if (QLog.isColorLevel()) {
          QLog.d("ConfessPlugin", 2, "processShare share_url_tmp:" + str1 + " remoteUrl:" + (String)localObject1 + " srcUrl:" + this.bxl + " srcIconUrl:" + this.bxm);
        }
        localObject3 = localObject1;
        localObject4 = localObject2;
        Object localObject5;
        if (this.cMS == 0)
        {
          localObject5 = new HashMap();
          if ((localObject2 != null) && (((String)localObject2).length() > 30)) {
            ((HashMap)localObject5).put("srcUrl", localObject2);
          }
          if ((str2 != null) && (str2.length() > 30)) {
            ((HashMap)localObject5).put("srcIconUrl", str2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 30)) {
            ((HashMap)localObject5).put("remoteUrl", localObject1);
          }
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (!((HashMap)localObject5).isEmpty())
          {
            localObject4 = jqc.b((HashMap)localObject5);
            localObject3 = (String)((HashMap)localObject4).get("remoteUrl");
            if (localObject3 != null) {
              localObject1 = localObject3;
            }
            localObject3 = (String)((HashMap)localObject4).get("srcUrl");
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
            localObject5 = (String)((HashMap)localObject4).get("srcIconUrl");
            localObject3 = localObject1;
            localObject4 = localObject2;
            if (localObject5 == null) {}
          }
        }
        for (localObject3 = localObject5;; localObject3 = str2)
        {
          ThreadManager.getUIHandler().post(new ConfessPlugin.5.1(this, str1, (String)localObject1, (String)localObject2, (String)localObject3, str3, localBitmap));
          return;
          localObject2 = localObject4;
          localObject1 = localObject3;
        }
        continue;
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.5
 * JD-Core Version:    0.7.0.1
 */