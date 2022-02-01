package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import aqzs;
import araz.e;
import arts;
import artv.b;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import jqc;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;
import svi;

public class Share$1
  implements Runnable
{
  public Share$1(svi paramsvi, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("shareWebPage", 2, "QConnect rich START. title=" + this.this$0.zc + ", desc=" + this.this$0.aue + ", thumb=" + this.this$0.auf + ", shareURL=" + this.val$url);
    }
    int i = 0;
    if (TextUtils.isEmpty(this.this$0.auf)) {
      i = 1;
    }
    int j = i;
    if (TextUtils.isEmpty(this.this$0.aue)) {
      j = i | 0x2;
    }
    if (TextUtils.isEmpty(this.this$0.zc)) {}
    int m;
    int k;
    long l1;
    long l2;
    for (int i1 = j | 0x4;; i1 = j)
    {
      m = 0;
      k = 0;
      l1 = System.currentTimeMillis();
      l2 = l1;
      try
      {
        localObject1 = new Bundle();
        l2 = l1;
        ((Bundle)localObject1).putString("report_type", "102");
        l2 = l1;
        ((Bundle)localObject1).putString("act_type", "53");
        l2 = l1;
        ((Bundle)localObject1).putString("intext_3", "1");
        l2 = l1;
        ((Bundle)localObject1).putString("intext_2", "" + i1);
        l2 = l1;
        ((Bundle)localObject1).putString("stringext_1", this.val$url);
        l2 = l1;
        arts.a().a((Bundle)localObject1, "", this.this$0.c.getAccount(), false);
        l2 = l1;
        localObject1 = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { this.this$0.c.getAccount(), URLEncoder.encode(this.val$url) });
        l2 = l1;
        l1 = System.currentTimeMillis();
      }
      catch (Exception localException1)
      {
        try
        {
          label388:
          this.this$0.bzn = 0;
          i2 = 0;
          i = m;
        }
        catch (Exception localException3)
        {
          Object localObject1;
          int i2;
          Object localObject2;
          int n;
          WebViewFragment localWebViewFragment;
          i = 0;
          k = 1;
          continue;
        }
        try
        {
          localObject2 = ((JSONObject)localObject1).getString("title");
          i = m;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            m = 4;
            k = m;
            i = m;
            if (TextUtils.isEmpty(this.this$0.zc))
            {
              i = m;
              this.this$0.zc = ((String)localObject2);
              k = m;
            }
          }
          i = k;
          localObject2 = ((JSONObject)localObject1).getString("abstract");
          m = k;
          i = k;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            k |= 0x2;
            m = k;
            i = k;
            if (TextUtils.isEmpty(this.this$0.aue))
            {
              i = k;
              this.this$0.aue = ((String)localObject2);
              m = k;
            }
          }
          n = m;
          m = n;
        }
        catch (Exception localException4)
        {
          k = 0;
          continue;
        }
        try
        {
          localObject1 = ((JSONObject)localObject1).getString("thumbUrl");
          i = n;
          k = i2;
          m = n;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            n |= 0x1;
            i = n;
            k = i2;
            m = n;
            if (TextUtils.isEmpty(this.this$0.auf))
            {
              m = n;
              this.this$0.auf = ((String)localObject1);
              m = n;
              this.this$0.aNs = false;
              m = n;
              this.this$0.bzl = 0;
              k = i2;
              i = n;
            }
          }
          m = j;
          if (QLog.isColorLevel()) {
            QLog.e("shareWebPage", 2, "QConnect rich END. title=" + this.this$0.zc + ", desc=" + this.this$0.aue + ", thumb=" + this.this$0.auf + ", shareURL=" + this.val$url);
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "13");
          ((Bundle)localObject1).putString("intext_3", "1");
          ((Bundle)localObject1).putString("intext_1", "" + k);
          ((Bundle)localObject1).putString("stringext_2", "" + m);
          ((Bundle)localObject1).putString("intext_5", "" + l1);
          ((Bundle)localObject1).putString("intext_2", "" + i1);
          ((Bundle)localObject1).putString("intext_4", "" + i);
          if (k > 0) {
            ((Bundle)localObject1).putString("stringext_1", this.val$url);
          }
          arts.a().a((Bundle)localObject1, "", this.this$0.c.getAccount(), false);
          localObject1 = new Bundle();
          j = 0;
          if (TextUtils.isEmpty(this.this$0.auf)) {
            j = 1;
          }
          i = j;
          if (TextUtils.isEmpty(this.this$0.aue)) {
            i = j | 0x2;
          }
          j = i;
          if (TextUtils.isEmpty(this.this$0.zc)) {
            j = i | 0x4;
          }
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "92");
          localObject2 = new StringBuilder().append("");
          if (j != 0) {
            continue;
          }
          i = 0;
          ((Bundle)localObject1).putString("intext_1", i);
          ((Bundle)localObject1).putString("intext_4", "" + m);
          ((Bundle)localObject1).putString("intext_3", "" + artv.b.kL(this.bzp));
          ((Bundle)localObject1).putString("intext_2", "" + j);
          ((Bundle)localObject1).putString("stringext_1", this.val$url);
          arts.a().a((Bundle)localObject1, "", this.this$0.c.getAccount(), false);
          if (!(this.this$0.activity instanceof araz.e)) {
            continue;
          }
          localObject1 = (araz.e)this.this$0.activity;
          if ((!TextUtils.isEmpty(this.this$0.auf)) || (localObject1 == null)) {
            continue;
          }
          ThreadManager.getUIHandler().post(new Share.1.1(this, (araz.e)localObject1));
          return;
        }
        catch (Exception localException5)
        {
          i = m;
          k = 0;
          continue;
        }
        localException1 = localException1;
        k = 1;
        l1 = l2;
        j = 0;
        i = 0;
        localException1.printStackTrace();
        m = j;
        continue;
        i = 1;
        continue;
        if ((this.this$0.activity instanceof aqzs))
        {
          localWebViewFragment = ((aqzs)this.this$0.activity).c();
          continue;
        }
        localWebViewFragment = null;
        continue;
        svi.a(this.this$0, this.val$url, this.bzp, this.aNv);
        return;
      }
      try
      {
        localObject1 = jqc.a(this.this$0.activity, (String)localObject1, null, "GET", null, null, 5000, 5000);
        l2 = System.currentTimeMillis();
        l1 = l2 - l1;
        if (localObject1 == null) {
          continue;
        }
        l2 = l1;
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200) {
          continue;
        }
        l2 = l1;
        localObject1 = jqc.a((HttpResponse)localObject1);
      }
      catch (Exception localException2)
      {
        i = 0;
        j = 0;
        k = 1;
        continue;
        i = 0;
        k = 1;
        continue;
        String str = "";
        break label388;
      }
      l2 = l1;
      localObject1 = new JSONObject((String)localObject1);
      l2 = l1;
      j = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
      if (j != 0) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.1
 * JD-Core Version:    0.7.0.1
 */