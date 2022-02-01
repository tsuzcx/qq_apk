import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class wjx
  implements WXShareHelper.WXShareListener
{
  wjx(String paramString, whg paramwhg, wjo paramwjo) {}
  
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
      if (this.jdField_a_of_type_Whg != null) {
        this.jdField_a_of_type_Whg.b(this.jdField_a_of_type_Wjo);
      }
      break;
    }
    for (;;)
    {
      WXShareHelper.getInstance().removeObserver(this);
      return;
      if (this.jdField_a_of_type_Whg != null)
      {
        this.jdField_a_of_type_Whg.a(this.jdField_a_of_type_Wjo);
        continue;
        if (this.jdField_a_of_type_Whg != null)
        {
          this.jdField_a_of_type_Whg.c(this.jdField_a_of_type_Wjo);
          continue;
          if (this.jdField_a_of_type_Whg != null) {
            this.jdField_a_of_type_Whg.b(this.jdField_a_of_type_Wjo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wjx
 * JD-Core Version:    0.7.0.1
 */