import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.av.redpacket.ui.RedPacketShareFragment.3;
import com.tencent.av.redpacket.ui.RedPacketShareFragment.3.1;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;

public class itg
  implements WXShareHelper.a
{
  public itg(RedPacketShareFragment.3.1 param1) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((RedPacketShareFragment.d(this.a.a.this$0) == null) || (!RedPacketShareFragment.d(this.a.a.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    QLog.d("RedPacketShareFragment", 1, "WL_DEBUG ActionSheetAdapter.CHANNEL_WX_FRIEND onWXShareResp resp.errCode = " + paramBaseResp.errCode);
    switch (paramBaseResp.errCode)
    {
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      RedPacketShareFragment.ak("0X8008CF8", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itg
 * JD-Core Version:    0.7.0.1
 */