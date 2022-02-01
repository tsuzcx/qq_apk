import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

public class uuq
  implements WXShareHelper.a
{
  public uuq(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.this$0.Qt == null) || (!this.this$0.Qt.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      rwt.ez(1, 2131720152);
      return;
    }
    rwt.ez(2, 2131720175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uuq
 * JD-Core Version:    0.7.0.1
 */