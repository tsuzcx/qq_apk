import android.text.TextUtils;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebDataHandler;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class zbo
{
  public String a;
  public WeakReference a;
  private WeakReference b;
  
  public zbo(ApolloWebDataHandler paramApolloWebDataHandler, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramApolloWebDataHandler);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(zbp paramzbp, ApolloWebStatistics paramApolloWebStatistics)
  {
    ApolloWebDataHandler localApolloWebDataHandler = (ApolloWebDataHandler)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localApolloWebDataHandler != null) && (paramzbp != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramApolloWebStatistics != null) {
          paramApolloWebStatistics.d = System.currentTimeMillis();
        }
        if (zbp.a(paramzbp) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { zbp.a(paramzbp).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + zbp.a(paramzbp));
      }
      if (ApolloWebDataHandler.a(localApolloWebDataHandler) != null)
      {
        ApolloWebDataHandler.a(localApolloWebDataHandler).remove(zbp.a(paramzbp));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + zbp.a(paramzbp));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zbo
 * JD-Core Version:    0.7.0.1
 */