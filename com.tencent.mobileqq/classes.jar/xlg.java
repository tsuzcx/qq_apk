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
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class xlg
  extends Handler
{
  xlg(xle paramxle, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
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
                this.a.b = paramMessage.arg2;
                localObject1 = (String)paramMessage.obj;
                localObject2 = this.a.mRuntime.a();
              }
            } while (localObject2 == null);
            if (this.a.jdField_a_of_type_Long == -1L) {
              this.a.jdField_a_of_type_Long = System.currentTimeMillis();
            }
            ((CustomWebView)localObject2).loadUrlOriginal((String)localObject1);
            ((CustomWebView)localObject2).requestFocus();
            if (QLog.isColorLevel()) {
              QLog.i("OfflinePluginQQ", 2, "mCheckupHandler loadUrl start \n" + (String)localObject1);
            }
            this.a.a((String)localObject1);
            for (;;)
            {
              for (;;)
              {
                localObject1 = this.a.mRuntime.a();
                localObject2 = this.a.mRuntime.a(this.a.mRuntime.a());
                if ((localObject2 == null) || (!(localObject2 instanceof bchj))) {
                  break;
                }
                if (paramMessage.arg1 != 4) {
                  break label535;
                }
                if ((xle.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(xle.a(this.a)))) {
                  break;
                }
                localObject1 = (sek)xle.jdField_a_of_type_JavaUtilHashMap.get(xle.a(this.a));
                if (this.a.jdField_a_of_type_AndroidWidgetProgressBar != null) {
                  this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg2);
                }
                if (this.a.jdField_a_of_type_AndroidWidgetTextView == null) {
                  break;
                }
                this.a.jdField_a_of_type_AndroidWidgetTextView.setText(((sek)localObject1).e + paramMessage.arg2 + "%");
                return;
                try
                {
                  localObject1 = (String)((Object[])(Object[])paramMessage.obj)[1];
                  localObject2 = new JSONObject();
                  ((JSONObject)localObject2).put("retcode", 0);
                  ((JSONObject)localObject2).put("data", nax.a((String)localObject1));
                  this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
                }
                catch (Exception localException1)
                {
                  try
                  {
                    JSONObject localJSONObject1 = new JSONObject();
                    localJSONObject1.put("retcode", -1);
                    localJSONObject1.put("msg", "error");
                    this.a.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
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
                this.a.c();
              }
              else if (paramMessage.arg1 == 3)
              {
                try
                {
                  JSONObject localJSONObject2 = (JSONObject)paramMessage.obj;
                  this.a.a(localJSONObject2);
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                }
              }
            }
          } while ((paramMessage.arg1 != 5) || (xle.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(xle.a(this.a))));
          localObject2 = (sek)xle.jdField_a_of_type_JavaUtilHashMap.get(xle.a(this.a));
        } while (localObject2 == null);
        if (paramMessage.arg2 != 0) {
          break;
        }
        ((sek)localObject2).a(3);
      } while (localException2 == null);
      paramMessage = localException2.getResources().getDrawable(2130839116);
      paramMessage.setBounds(0, 0, 40, 40);
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessage, null, null, null);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(((sek)localObject2).d);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    } while (this.a.jdField_a_of_type_AndroidWidgetLinearLayout == null);
    label535:
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    return;
    if ((paramMessage.arg2 == 5) || (paramMessage.arg2 == 7))
    {
      if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      ((sek)localObject2).a(4);
      return;
    }
    wim.a(1, 2131696391);
    if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    ((sek)localObject2).a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xlg
 * JD-Core Version:    0.7.0.1
 */