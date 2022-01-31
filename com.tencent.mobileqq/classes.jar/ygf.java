import android.text.TextUtils;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;

class ygf
  implements Runnable
{
  ygf(yge paramyge, ApolloSurfaceView paramApolloSurfaceView, AVVideoCtrl.VideoFrame paramVideoFrame) {}
  
  public void run()
  {
    String str = CmGameUtil.a().getCurrentAccountUin();
    CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(AVCameraCaptureModel.a(this.jdField_a_of_type_Yge.a.a));
    if (localCmGameOpenIdFinder == null) {}
    while (TextUtils.isEmpty(localCmGameOpenIdFinder.b(str))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ygf
 * JD-Core Version:    0.7.0.1
 */