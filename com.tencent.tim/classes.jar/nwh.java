import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

class nwh
  implements WXShareHelper.a
{
  nwh(nwg paramnwg) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((nwg.a(this.this$0) == null) || (!nwg.a(this.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      rwt.ez(1, 2131720152);
      bool = false;
    }
    for (;;)
    {
      odg.d.a.nV(bool);
      return;
      rwt.ez(2, 2131720175);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwh
 * JD-Core Version:    0.7.0.1
 */