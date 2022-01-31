import android.text.TextUtils;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;

class zbz
{
  private WebSoService.WebSoState.WebSo3 jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  private String jdField_a_of_type_JavaLangString;
  
  private void a(zbx paramzbx, String paramString, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    if ((paramWebSo3 != null) && (!TextUtils.isEmpty(paramString))) {
      begt.a("callJs");
    }
    try
    {
      paramzbx.callJs(paramString, new String[] { this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a() });
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    catch (Exception paramzbx)
    {
      for (;;)
      {
        paramzbx.printStackTrace();
      }
    }
  }
  
  public WebSoService.WebSoState.WebSo3 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
  }
  
  public void a()
  {
    begt.a("clearJsCallback");
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = null;
  }
  
  public void a(zbx paramzbx, WebSoService.WebSoState.WebSo3 paramWebSo3)
  {
    begt.a("setUpWebso3");
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3 = paramWebSo3;
    a(paramzbx, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
  
  public void a(zbx paramzbx, String paramString)
  {
    begt.a("registerGetData");
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramzbx, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zbz
 * JD-Core Version:    0.7.0.1
 */