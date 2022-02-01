import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer.1;
import com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer.1.2.1;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;

public class rfp
  implements WXShareHelper.a
{
  public rfp(VideoSharer.1 param1, Bitmap paramBitmap) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.val$iconBitmap != null) && (!this.val$iconBitmap.isRecycled())) {
      this.val$iconBitmap.recycle();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share]  shareToWechat errorCode : " + paramBaseResp.errCode + "   errorStr : " + paramBaseResp.errCode + "  transaction : " + paramBaseResp.transaction + "  openId : " + paramBaseResp.openId + " type : " + paramBaseResp.getType());
    }
    if ((paramBaseResp.errCode != 0) && (paramBaseResp.errCode != -2)) {
      this.a.this$0.mContext.runOnUiThread(new VideoSharer.1.2.1(this));
    }
    if (paramBaseResp.errCode == 0)
    {
      if (rfo.a(this.a.this$0) != 2) {
        break label180;
      }
      alwx.aF("wechat_moments", rfo.a(this.a.this$0));
    }
    label180:
    while (rfo.a(this.a.this$0) != 1) {
      return;
    }
    alwx.aF("wechat_friends", rfo.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfp
 * JD-Core Version:    0.7.0.1
 */