import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class wys
  implements biyn
{
  wys(String paramString, wwb paramwwb, wyj paramwyj) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -3: 
    case -1: 
    default: 
      if (this.jdField_a_of_type_Wwb != null) {
        this.jdField_a_of_type_Wwb.b(this.jdField_a_of_type_Wyj);
      }
      break;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (this.jdField_a_of_type_Wwb != null)
      {
        this.jdField_a_of_type_Wwb.a(this.jdField_a_of_type_Wyj);
        continue;
        if (this.jdField_a_of_type_Wwb != null)
        {
          this.jdField_a_of_type_Wwb.c(this.jdField_a_of_type_Wyj);
          continue;
          if (this.jdField_a_of_type_Wwb != null) {
            this.jdField_a_of_type_Wwb.b(this.jdField_a_of_type_Wyj);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wys
 * JD-Core Version:    0.7.0.1
 */