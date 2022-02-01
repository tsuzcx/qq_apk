import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.qqstory.takevideo.dancemachine.PKVideoSharer.2.1;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;

public class rfn
  implements WXShareHelper.a
{
  public void a(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share]  shareToWechat errorCode : " + paramBaseResp.errCode + "   errorStr : " + paramBaseResp.errCode + "  transaction : " + paramBaseResp.transaction + "  openId : " + paramBaseResp.openId + " type : " + paramBaseResp.getType() + " bitmap ");
    }
    if (this.val$bitmap != null) {
      this.val$bitmap.recycle();
    }
    if ((paramBaseResp.errCode != 0) && (paramBaseResp.errCode != -2)) {
      this.this$0.mContext.runOnUiThread(new PKVideoSharer.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfn
 * JD-Core Version:    0.7.0.1
 */