import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;

class xnj
{
  private WebSoService.WebSoState.WebSo3 jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  private String jdField_a_of_type_JavaLangString;
  
  private void a(xnh paramxnh, String paramString, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    if ((paramWebSo3 != null) && (!TextUtils.isEmpty(paramString))) {
      bche.a("callJs");
    }
    try
    {
      paramxnh.callJs(paramString, new String[] { this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a() });
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    catch (Exception paramxnh)
    {
      for (;;)
      {
        paramxnh.printStackTrace();
      }
    }
  }
  
  public WebSoService.WebSoState.WebSo3 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  }
  
  public void a()
  {
    bche.a("clearJsCallback");
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = null;
  }
  
  public void a(xnh paramxnh, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    bche.a("setUpWebso3");
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = paramWebSo3;
    a(paramxnh, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
  
  public void a(xnh paramxnh, String paramString)
  {
    bche.a("registerGetData");
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramxnh, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xnj
 * JD-Core Version:    0.7.0.1
 */