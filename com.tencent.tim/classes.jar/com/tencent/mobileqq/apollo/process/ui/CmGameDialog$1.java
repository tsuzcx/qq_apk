package com.tencent.mobileqq.apollo.process.ui;

import abpw;
import abqe;
import android.text.TextUtils;
import org.json.JSONObject;

public class CmGameDialog$1
  implements Runnable
{
  public CmGameDialog$1(abpw paramabpw, String paramString1, String paramString2, abqe paramabqe, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.val$type)) && (!TextUtils.isEmpty(this.bho)) && (this.b != null))
    {
      if (!"toast".equals(this.val$type)) {
        break label106;
      }
      if (!"show".equals(this.bho)) {
        break label82;
      }
      this.this$0.a(this.bh.optString("title"), this.bh.optInt("duration", -1), this.b);
    }
    label81:
    label82:
    label106:
    do
    {
      do
      {
        do
        {
          break label81;
          do
          {
            return;
          } while (!"hide".equals(this.bho));
          this.this$0.b(this.b);
          return;
          if (!"alert".equals(this.val$type)) {
            break;
          }
          if ("show".equals(this.bho)) {
            this.this$0.b(this.bh.optString("title"), this.bh.optString("content"), this.b);
          }
        } while (!"hide".equals(this.bho));
        this.this$0.hideDialog();
        return;
      } while (!"loading".equals(this.val$type));
      if ("show".equals(this.bho)) {
        this.this$0.a(this.bh.optString("title"), this.b);
      }
    } while (!"hide".equals(this.bho));
    this.this$0.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1
 * JD-Core Version:    0.7.0.1
 */