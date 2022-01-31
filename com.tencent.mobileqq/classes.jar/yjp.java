import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class yjp
  implements bevy
{
  yjp(yjk paramyjk) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((yjk.c(this.a) == null) || (!yjk.c(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(yjk.a(this.a), 1, "分享失败", 0).a();
      return;
    }
    QQToast.a(yjk.a(this.a), 2, "分享成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yjp
 * JD-Core Version:    0.7.0.1
 */