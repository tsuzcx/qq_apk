import android.text.TextUtils;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;

class yjo
  implements Runnable
{
  yjo(yjn paramyjn, AVVideoCtrl.VideoFrame paramVideoFrame, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void run()
  {
    CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(AVCameraCaptureModel.a(this.jdField_a_of_type_Yjn.a.a));
    if (localCmGameOpenIdFinder == null) {
      return;
    }
    String str2 = localCmGameOpenIdFinder.b(this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = localCmGameOpenIdFinder.a(Long.parseLong(this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier));
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativeRemotePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yjo
 * JD-Core Version:    0.7.0.1
 */