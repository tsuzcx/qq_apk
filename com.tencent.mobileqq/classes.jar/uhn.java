import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class uhn
  implements pbq
{
  public uhn(ReadInjoyWebShareHelper.4 param4) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((this.a.this$0.a == null) || (!this.a.this$0.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      yyi.a(1, 2131718380);
      bool = false;
    }
    while (this.a.a)
    {
      uhk.a(this.a.this$0, "we_chat", bool);
      return;
      yyi.a(2, 2131718398);
      continue;
      bool = false;
    }
    uhk.a(this.a.this$0, "we_chat_circle", bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhn
 * JD-Core Version:    0.7.0.1
 */