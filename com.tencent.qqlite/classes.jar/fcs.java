import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.open.appcommon.js.AsyncMethodMap;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class fcs
  implements Runnable
{
  public fcs(OpenJsBridge paramOpenJsBridge, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject3 = new ArrayList(Arrays.asList((this.jdField_a_of_type_JavaLangString + "/#").split("/")));
    if (((ArrayList)localObject3).size() < 6) {}
    for (;;)
    {
      return;
      Object localObject1 = (String)((ArrayList)localObject3).get(2);
      String str1 = (String)((ArrayList)localObject3).get(3);
      String str2 = (String)((ArrayList)localObject3).get(4);
      Object localObject2;
      String str3;
      if (str1.trim().equals("callBatch"))
      {
        localObject2 = (String)((ArrayList)localObject3).get(5);
        str3 = (String)((ArrayList)localObject3).get(6);
        localObject3 = (String)((ArrayList)localObject3).get(7);
      }
      try
      {
        long l1 = Long.parseLong(str2);
        long l2 = Long.parseLong(str3);
        int i = Integer.parseInt((String)localObject3);
        localObject1 = (JsBridge.JsHandler)this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.b.get(localObject1);
        if ((localObject1 != null) && ((localObject1 instanceof BaseInterface)))
        {
          ((BaseInterface)localObject1).callBatch(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.b, l1, (String)localObject2, Long.valueOf(l2).longValue(), i);
          return;
        }
        try
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:QzoneApp.fire('interface." + str1 + "',{guid:" + l1 + ",    'r':-2,'data':'no such method'});");
          return;
        }
        catch (Exception localException1)
        {
          return;
        }
        try
        {
          l1 = Long.parseLong(str2);
          localObject2 = ((ArrayList)localObject3).subList(5, ((ArrayList)localObject3).size() - 1);
          if (AsyncMethodMap.a.contains(localException1)) {
            ((List)localObject2).add(str2);
          }
          if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a((String)localObject1, localException1, (List)localObject2, new OpenJsBridge.OpenJsBridgeListener(this.jdField_a_of_type_ComTencentSmttSdkWebView, l1, this.jdField_a_of_type_JavaLangString));
          return;
        }
        catch (Exception localException2) {}
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fcs
 * JD-Core Version:    0.7.0.1
 */