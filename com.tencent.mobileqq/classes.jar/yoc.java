import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class yoc
  implements bfah
{
  yoc(ynx paramynx) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((ynx.c(this.a) == null) || (!ynx.c(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(ynx.a(this.a), 1, "分享失败", 0).a();
      return;
    }
    QQToast.a(ynx.a(this.a), 2, "分享成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoc
 * JD-Core Version:    0.7.0.1
 */