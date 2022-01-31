import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;

class xej
{
  private WebSoService.WebSoState.WebSo3 jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  private String jdField_a_of_type_JavaLangString;
  
  private void a(xeh paramxeh, String paramString, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    if ((paramWebSo3 != null) && (!TextUtils.isEmpty(paramString))) {
      bbee.a("callJs");
    }
    try
    {
      paramxeh.callJs(paramString, new String[] { this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a() });
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    catch (Exception paramxeh)
    {
      for (;;)
      {
        paramxeh.printStackTrace();
      }
    }
  }
  
  public WebSoService.WebSoState.WebSo3 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  }
  
  public void a()
  {
    bbee.a("clearJsCallback");
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = null;
  }
  
  public void a(xeh paramxeh, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    bbee.a("setUpWebso3");
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = paramWebSo3;
    a(paramxeh, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
  
  public void a(xeh paramxeh, String paramString)
  {
    bbee.a("registerGetData");
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramxeh, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xej
 * JD-Core Version:    0.7.0.1
 */