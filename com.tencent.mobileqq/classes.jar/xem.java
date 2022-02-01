import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class xem
  implements bihh
{
  xem(String paramString, xbv paramxbv, xed paramxed) {}
  
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
      if (this.jdField_a_of_type_Xbv != null) {
        this.jdField_a_of_type_Xbv.b(this.jdField_a_of_type_Xed);
      }
      break;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (this.jdField_a_of_type_Xbv != null)
      {
        this.jdField_a_of_type_Xbv.a(this.jdField_a_of_type_Xed);
        continue;
        if (this.jdField_a_of_type_Xbv != null)
        {
          this.jdField_a_of_type_Xbv.c(this.jdField_a_of_type_Xed);
          continue;
          if (this.jdField_a_of_type_Xbv != null) {
            this.jdField_a_of_type_Xbv.b(this.jdField_a_of_type_Xed);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xem
 * JD-Core Version:    0.7.0.1
 */