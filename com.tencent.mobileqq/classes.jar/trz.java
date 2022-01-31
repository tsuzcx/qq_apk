import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class trz
  implements bcww
{
  trz(String paramString, tpi paramtpi, trq paramtrq) {}
  
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
      if (this.jdField_a_of_type_Tpi != null) {
        this.jdField_a_of_type_Tpi.b(this.jdField_a_of_type_Trq);
      }
      break;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (this.jdField_a_of_type_Tpi != null)
      {
        this.jdField_a_of_type_Tpi.a(this.jdField_a_of_type_Trq);
        continue;
        if (this.jdField_a_of_type_Tpi != null)
        {
          this.jdField_a_of_type_Tpi.c(this.jdField_a_of_type_Trq);
          continue;
          if (this.jdField_a_of_type_Tpi != null) {
            this.jdField_a_of_type_Tpi.b(this.jdField_a_of_type_Trq);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     trz
 * JD-Core Version:    0.7.0.1
 */