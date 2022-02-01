import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

class oxl
  implements WXShareHelper.a
{
  oxl(oxh paramoxh) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((oxh.a(this.this$0) == null) || (!oxh.a(this.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.this$0.getActivity(), 1, acfp.m(2131715065), 0).show();
      return;
    }
    QQToast.a(this.this$0.getActivity(), 2, acfp.m(2131715067), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxl
 * JD-Core Version:    0.7.0.1
 */