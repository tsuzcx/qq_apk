import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class uaw
  implements phs
{
  public uaw(ReadInjoyWebShareHelper.4 param4) {}
  
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
      zvc.a(1, 2131718007);
      bool = false;
    }
    while (this.a.a)
    {
      uat.a(this.a.this$0, "we_chat", bool);
      return;
      zvc.a(2, 2131718025);
      continue;
      bool = false;
    }
    uat.a(this.a.this$0, "we_chat_circle", bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uaw
 * JD-Core Version:    0.7.0.1
 */