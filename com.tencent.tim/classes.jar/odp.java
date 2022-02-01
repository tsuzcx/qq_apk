import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.a;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class odp
  implements WxShareHelperFromReadInjoy.a
{
  public odp(ReadInjoyWebShareHelper.4 param4) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((this.a.this$0.Qt == null) || (!this.a.this$0.Qt.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      rwt.ez(1, 2131720152);
      bool = false;
    }
    while (this.a.awy)
    {
      odm.a(this.a.this$0, "we_chat", bool);
      return;
      rwt.ez(2, 2131720175);
      continue;
      bool = false;
    }
    odm.a(this.a.this$0, "we_chat_circle", bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odp
 * JD-Core Version:    0.7.0.1
 */