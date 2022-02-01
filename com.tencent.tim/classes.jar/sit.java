import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

class sit
  implements WXShareHelper.a
{
  sit(sio paramsio) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((sio.c(this.this$0) == null) || (!sio.c(this.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(sio.a(this.this$0), 1, "分享失败", 0).show();
      return;
    }
    QQToast.a(sio.a(this.this$0), 2, "分享成功", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sit
 * JD-Core Version:    0.7.0.1
 */