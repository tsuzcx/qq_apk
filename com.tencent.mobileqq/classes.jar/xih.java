import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class xih
  implements bjig
{
  xih(String paramString, xfq paramxfq, xhy paramxhy) {}
  
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
      if (this.jdField_a_of_type_Xfq != null) {
        this.jdField_a_of_type_Xfq.b(this.jdField_a_of_type_Xhy);
      }
      break;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (this.jdField_a_of_type_Xfq != null)
      {
        this.jdField_a_of_type_Xfq.a(this.jdField_a_of_type_Xhy);
        continue;
        if (this.jdField_a_of_type_Xfq != null)
        {
          this.jdField_a_of_type_Xfq.c(this.jdField_a_of_type_Xhy);
          continue;
          if (this.jdField_a_of_type_Xfq != null) {
            this.jdField_a_of_type_Xfq.b(this.jdField_a_of_type_Xhy);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xih
 * JD-Core Version:    0.7.0.1
 */