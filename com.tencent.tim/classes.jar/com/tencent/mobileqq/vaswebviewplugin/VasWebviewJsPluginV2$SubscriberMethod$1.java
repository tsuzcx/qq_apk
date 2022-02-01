package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

class VasWebviewJsPluginV2$SubscriberMethod$1
  implements Runnable
{
  VasWebviewJsPluginV2$SubscriberMethod$1(VasWebviewJsPluginV2.SubscriberMethod paramSubscriberMethod, WeakReference paramWeakReference, VasWebviewJsPluginV2.JsData paramJsData, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      Class[] arrayOfClass = this.this$0.method.getParameterTypes();
      if (TextUtils.isEmpty(this.this$0.args))
      {
        if ((arrayOfClass.length == 1) && (VasWebviewJsPluginV2.JsData.class.isAssignableFrom(arrayOfClass[0])))
        {
          this.this$0.method.invoke(this.val$weakReferenceInstance.get(), new Object[] { this.val$jsData });
          return;
        }
        this.this$0.method.invoke(this.val$weakReferenceInstance.get(), new Object[0]);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("VasWebviewJsPluginV2", 1, localException, new Object[0]);
      return;
    }
    String[] arrayOfString = this.this$0.args.split("\\|");
    Object[] arrayOfObject = new Object[arrayOfString.length];
    int i = 0;
    for (;;)
    {
      int j = arrayOfObject.length;
      if (i < j) {
        try
        {
          Object localObject1 = this.val$json.get(arrayOfString[i]);
          arrayOfObject[i] = localObject1;
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            Object localObject2 = null;
          }
        }
      }
    }
    this.this$0.method.invoke(this.val$weakReferenceInstance.get(), arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2.SubscriberMethod.1
 * JD-Core Version:    0.7.0.1
 */