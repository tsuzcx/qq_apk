import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class uvk
  implements pkr
{
  public uvk(ReadInjoyWebShareHelper.4 param4) {}
  
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
      znl.a(1, 2131718766);
      bool = false;
    }
    while (this.a.a)
    {
      uvh.a(this.a.this$0, "we_chat", bool);
      return;
      znl.a(2, 2131718784);
      continue;
      bool = false;
    }
    uvh.a(this.a.this$0, "we_chat_circle", bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvk
 * JD-Core Version:    0.7.0.1
 */