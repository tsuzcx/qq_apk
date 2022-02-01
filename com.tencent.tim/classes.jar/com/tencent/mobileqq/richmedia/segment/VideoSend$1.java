package com.tencent.mobileqq.richmedia.segment;

import ambv;
import ambw;
import amjg;
import android.os.Bundle;
import aolt;
import aqhq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class VideoSend$1
  implements Runnable
{
  public VideoSend$1(ambw paramambw, ambv paramambv, Bundle paramBundle) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "submitTask begin");
    }
    if (this.d.mType == 1) {
      if (this.this$0.zg.size() == this.d.mIndex)
      {
        this.this$0.zg.add(this.d);
        localObject = new File(this.d.mPath);
        this.d.mFileLength = ((File)localObject).length();
        this.d.mMd5 = amjg.calcMD5(this.d.mPath);
        if (this.d.mIndex == 0)
        {
          this.d.mTimestamp = 0L;
          this.this$0.a(this.d);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.d.mTimestamp = (this.d.mStartTime - ((ambv)this.this$0.zg.get(0)).mStartTime);
        break;
      } while (!QLog.isColorLevel());
      QLog.d("VideoSend", 2, "submitTask failed, mVideoSliceInfos.size():" + this.this$0.zg.size() + " info:" + this.d);
      return;
      if (this.d.mType == 3)
      {
        this.d.mPath = this.this$0.getAudioPath();
        localObject = new File(this.d.mPath);
        this.d.mFileLength = ((File)localObject).length();
        this.d.mMd5 = amjg.calcMD5(this.d.mPath);
        this.this$0.b = this.d;
        this.d.mIndex = this.this$0.zg.size();
        this.this$0.a(this.d);
        return;
      }
      if (this.d.mType == 4)
      {
        this.d.mPath = this.this$0.getThumbPath();
        this.d.mIndex = -1;
        this.this$0.b(this.d, this.val$data);
        return;
      }
    } while (this.d.mType != 5);
    this.d.mPath = this.this$0.yK();
    Object localObject = new File(this.d.mPath);
    this.d.mFileLength = ((File)localObject).length();
    int i = this.d.mVideoDuration;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "combine file is generated," + this.d + " msVideo:" + i);
    }
    if ((this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileStatus == 1003))
    {
      localObject = ShortVideoUtils.a(this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo, "mp4");
      aqhq.copyFile(this.d.mPath, (String)localObject);
      this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileName = ((String)localObject);
      this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (i / 1000);
      this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)this.d.mFileLength);
      this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.serial();
      this.this$0.mApp.b().c(this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.istroop, this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.msgData);
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "combine file is generated,message is sent, info:" + this.d + " saveVideoPath:" + (String)localObject);
      }
      this.this$0.jdField_c_of_type_Ambv = this.d;
      if (this.this$0.a != null) {
        this.this$0.a.VR(1003);
      }
      this.this$0.destroy();
      return;
    }
    this.d.mMd5 = amjg.calcMD5(this.d.mPath);
    this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.mLocalMd5 = this.d.mMd5;
    localObject = ShortVideoUtils.a(this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo, "mp4");
    aqhq.copyFile(this.d.mPath, (String)localObject);
    this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (i / 1000);
    this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)this.d.mFileLength);
    this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileName = ((String)localObject);
    this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.serial();
    this.this$0.mApp.b().c(this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.istroop, this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.this$0.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.msgData);
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "combine file is generated, info:" + this.d + " saveVideoPath:" + (String)localObject);
    }
    if ((this.this$0.dBF == 1) && (!this.val$data.getBoolean("video_segment_capture_success", true))) {
      this.d.cCb = false;
    }
    this.this$0.a(this.d);
    this.this$0.jdField_c_of_type_Ambv = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.1
 * JD-Core Version:    0.7.0.1
 */