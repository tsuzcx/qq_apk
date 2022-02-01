import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.qqstory.takevideo.dancemachine.PKVideoSharer.2.1;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;

public class zam
  implements bjig
{
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share]  shareToWechat errorCode : " + paramBaseResp.errCode + "   errorStr : " + paramBaseResp.errCode + "  transaction : " + paramBaseResp.transaction + "  openId : " + paramBaseResp.openId + " type : " + paramBaseResp.getType() + " bitmap ");
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    if ((paramBaseResp.errCode != 0) && (paramBaseResp.errCode != -2)) {
      this.jdField_a_of_type_Zal.a.runOnUiThread(new PKVideoSharer.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zam
 * JD-Core Version:    0.7.0.1
 */