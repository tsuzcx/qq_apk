import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

final class qdx
  implements WXShareHelper.a
{
  qdx(String paramString, qbj paramqbj, qdo paramqdo) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (!this.awV.equals(paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -3: 
    case -1: 
    default: 
      if (this.b != null) {
        this.b.b(this.a);
      }
      break;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (this.b != null)
      {
        this.b.a(this.a);
        continue;
        if (this.b != null)
        {
          this.b.c(this.a);
          continue;
          if (this.b != null) {
            this.b.b(this.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdx
 * JD-Core Version:    0.7.0.1
 */