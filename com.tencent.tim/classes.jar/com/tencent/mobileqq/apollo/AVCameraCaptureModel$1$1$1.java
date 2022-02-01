package com.tencent.mobileqq.apollo;

import abgx;
import abgy;
import abgz;
import abmt;
import abpc;
import android.text.TextUtils;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.common.app.AppInterface;

public class AVCameraCaptureModel$1$1$1
  extends IApolloRunnableTask
{
  public AVCameraCaptureModel$1$1$1(abgz paramabgz, ApolloSurfaceView paramApolloSurfaceView, AVVideoCtrl.VideoFrame paramVideoFrame) {}
  
  public String aV()
  {
    return "nativePreviewCallback";
  }
  
  public void run()
  {
    String str = abmt.getAppInterface().getCurrentAccountUin();
    abpc localabpc = abmt.a(abgx.a(this.jdField_a_of_type_Abgz.a.a));
    if (localabpc == null) {}
    while (TextUtils.isEmpty(localabpc.iC(str))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().nativePreviewCallback(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().Nn, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.data, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.width, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.height, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.rotate, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.videoFormat, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$VideoFrame.srcType, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1
 * JD-Core Version:    0.7.0.1
 */