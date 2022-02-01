package com.tencent.mobileqq.apollo;

import abgx;
import abgy;
import abha;
import abmt;
import abpc;
import android.text.TextUtils;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;

public class AVCameraCaptureModel$1$2$1
  extends IApolloRunnableTask
{
  public AVCameraCaptureModel$1$2$1(abha paramabha, AVVideoCtrl.VideoFrame paramVideoFrame, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public String aV()
  {
    return "nativeRemotePreviewCallback";
  }
  
  public void run()
  {
    abpc localabpc = abmt.a(abgx.a(this.jdField_a_of_type_Abha.a.a));
    if (localabpc == null) {
      return;
    }
    String str2 = localabpc.iC(this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = localabpc.bh(Long.parseLong(this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier));
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.identifier;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativeRemotePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().Nn, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.2.1
 * JD-Core Version:    0.7.0.1
 */