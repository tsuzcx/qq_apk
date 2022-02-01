package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import kxz;
import mym;

public class VideoPreDownloadMgr$3$1
  implements Runnable
{
  public VideoPreDownloadMgr$3$1(mym parammym, kxz paramkxz) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Kxz.vid.equals(VideoPreDownloadMgr.a(this.jdField_a_of_type_Mym.this$0)))
    {
      if (this.jdField_a_of_type_Mym.this$0.I(this.jdField_a_of_type_Kxz.url, this.jdField_a_of_type_Kxz.vid))
      {
        if (QLog.isColorLevel()) {
          QLog.i(VideoPreDownloadMgr.access$300(), 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + this.jdField_a_of_type_Kxz.vid);
        }
        VideoPreDownloadMgr.a(this.jdField_a_of_type_Mym.this$0, null);
        VideoPreDownloadMgr.c(this.jdField_a_of_type_Mym.this$0);
      }
    }
    else {
      return;
    }
    VideoPreDownloadMgr.a(this.jdField_a_of_type_Mym.this$0, this.jdField_a_of_type_Kxz.url, this.jdField_a_of_type_Kxz.vid, this.jdField_a_of_type_Kxz.videoType, this.jdField_a_of_type_Mym.val$duration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.3.1
 * JD-Core Version:    0.7.0.1
 */