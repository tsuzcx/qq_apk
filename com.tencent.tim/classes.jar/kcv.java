import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

final class kcv
  implements WXShareHelper.a
{
  kcv(String paramString, odg.e parame) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((this.XY == null) || (!this.XY.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      rwt.eA(1, 2131720152);
      bool = false;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      if (this.a == null) {
        break;
      }
      this.a.onResult(bool);
      return;
      rwt.eA(2, 2131720175);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kcv
 * JD-Core Version:    0.7.0.1
 */