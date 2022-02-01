import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class sty
  extends Handler
{
  sty(stw paramstw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.this$0.isDestroy) {}
    label32:
    Object localObject2;
    label468:
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject1;
            do
            {
              return;
              switch (paramMessage.what)
              {
              default: 
                if (paramMessage.arg1 != 1) {
                  break label468;
                }
                this.this$0.mOfflineLoadMode = paramMessage.arg2;
                localObject1 = (String)paramMessage.obj;
                localObject2 = this.this$0.mRuntime.getWebView();
              }
            } while (localObject2 == null);
            if (this.this$0.Du == -1L) {
              this.this$0.Du = System.currentTimeMillis();
            }
            ((CustomWebView)localObject2).loadUrlOriginal((String)localObject1);
            ((CustomWebView)localObject2).requestFocus();
            if (QLog.isColorLevel()) {
              QLog.i("OfflinePluginQQ", 2, "mCheckupHandler loadUrl start \n" + (String)localObject1);
            }
            this.this$0.checkOfflineUp((String)localObject1);
            for (;;)
            {
              for (;;)
              {
                localObject1 = this.this$0.mRuntime.getActivity();
                localObject2 = this.this$0.mRuntime.a(this.this$0.mRuntime.getActivity());
                if ((localObject2 == null) || (!(localObject2 instanceof ardm.c))) {
                  break;
                }
                if (paramMessage.arg1 != 4) {
                  break label535;
                }
                if ((stw.fZ == null) || (TextUtils.isEmpty(stw.a(this.this$0)))) {
                  break;
                }
                localObject1 = (obe)stw.fZ.get(stw.a(this.this$0));
                if (this.this$0.I != null) {
                  this.this$0.I.setProgress(paramMessage.arg2);
                }
                if (this.this$0.AY == null) {
                  break;
                }
                this.this$0.AY.setText(((obe)localObject1).aoT + paramMessage.arg2 + "%");
                return;
                try
                {
                  localObject1 = (String)((Object[])(Object[])paramMessage.obj)[1];
                  localObject2 = new JSONObject();
                  ((JSONObject)localObject2).put("retcode", 0);
                  ((JSONObject)localObject2).put("data", jqo.toJsString((String)localObject1));
                  this.this$0.callJs(this.this$0.aGF, new String[] { ((JSONObject)localObject2).toString() });
                }
                catch (Exception localException1)
                {
                  try
                  {
                    JSONObject localJSONObject1 = new JSONObject();
                    localJSONObject1.put("retcode", -1);
                    localJSONObject1.put("msg", "error");
                    this.this$0.callJs(this.this$0.aGF, new String[] { localJSONObject1.toString() });
                  }
                  catch (JSONException localJSONException) {}
                }
              }
              if (!QLog.isColorLevel()) {
                break label32;
              }
              QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + localJSONException);
              break label32;
              if (paramMessage.arg1 == 2)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.i("OfflinePluginQQ", 4, "checkOfflineUpBack refresh current url");
                }
                this.this$0.reloadCurrentUrl();
              }
              else if (paramMessage.arg1 == 3)
              {
                try
                {
                  JSONObject localJSONObject2 = (JSONObject)paramMessage.obj;
                  this.this$0.ar(localJSONObject2);
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                }
              }
            }
          } while ((paramMessage.arg1 != 5) || (stw.fZ == null) || (TextUtils.isEmpty(stw.a(this.this$0))));
          localObject2 = (obe)stw.fZ.get(stw.a(this.this$0));
        } while (localObject2 == null);
        if (paramMessage.arg2 != 0) {
          break;
        }
        ((obe)localObject2).setStatus(3);
      } while (localException2 == null);
      paramMessage = localException2.getResources().getDrawable(2130839626);
      paramMessage.setBounds(0, 0, 40, 40);
      if (this.this$0.AY != null) {
        this.this$0.AY.setCompoundDrawables(paramMessage, null, null, null);
      }
      if (this.this$0.AY != null) {
        this.this$0.AY.setText(((obe)localObject2).aoS);
      }
      if (this.this$0.I != null) {
        this.this$0.I.setVisibility(8);
      }
    } while (this.this$0.fz == null);
    label535:
    this.this$0.fz.setVisibility(0);
    return;
    if ((paramMessage.arg2 == 5) || (paramMessage.arg2 == 7))
    {
      if (this.this$0.gc != null) {
        this.this$0.gc.setVisibility(8);
      }
      ((obe)localObject2).setStatus(4);
      return;
    }
    rwt.ez(1, 2131698321);
    if (this.this$0.gc != null) {
      this.this$0.gc.setVisibility(8);
    }
    ((obe)localObject2).setStatus(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sty
 * JD-Core Version:    0.7.0.1
 */