import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

class aiiz
  implements afdi.a
{
  aiiz(aiiy paramaiiy) {}
  
  public void a(afdi paramafdi)
  {
    try
    {
      paramafdi.dismiss();
      this.this$0.mRuntime.getActivity().finish();
      anot.a(null, "CliOper", "", "", "0X80094EB", "0X80094EB", 0, 0, "", "", "", "");
      return;
    }
    catch (Throwable paramafdi)
    {
      for (;;)
      {
        QLog.e("DocxApiPlugin", 1, "handleEvent", paramafdi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiiz
 * JD-Core Version:    0.7.0.1
 */