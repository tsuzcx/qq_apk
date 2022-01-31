import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class gem
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int c;
  int d;
  
  public gem(UiApiPlugin paramUiApiPlugin, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = UiApiPlugin.a(this.jdField_b_of_type_JavaLangString, this.c, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (isInterrupted()) {
        throw new InterruptedException();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      System.gc();
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "3", "{}" });
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", localOutOfMemoryError.toString() });
      return;
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "{}" });
      return;
    }
    catch (JSONException localJSONException)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "2", "{}" });
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
      if ((localActivity != null) && (!localActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "1", "{}" });
      }
      return;
    }
    finally
    {
      if (this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gem
 * JD-Core Version:    0.7.0.1
 */