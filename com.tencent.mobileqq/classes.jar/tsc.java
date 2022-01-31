import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class tsc
  implements bcwh
{
  tsc(String paramString, tpl paramtpl, trt paramtrt) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -3: 
    case -1: 
    default: 
      if (this.jdField_a_of_type_Tpl != null) {
        this.jdField_a_of_type_Tpl.b(this.jdField_a_of_type_Trt);
      }
      break;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (this.jdField_a_of_type_Tpl != null)
      {
        this.jdField_a_of_type_Tpl.a(this.jdField_a_of_type_Trt);
        continue;
        if (this.jdField_a_of_type_Tpl != null)
        {
          this.jdField_a_of_type_Tpl.c(this.jdField_a_of_type_Trt);
          continue;
          if (this.jdField_a_of_type_Tpl != null) {
            this.jdField_a_of_type_Tpl.b(this.jdField_a_of_type_Trt);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsc
 * JD-Core Version:    0.7.0.1
 */