package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

class InformationFaceAdapter$DownloadProgressCallback$1
  implements Runnable
{
  InformationFaceAdapter$DownloadProgressCallback$1(InformationFaceAdapter.a parama, int paramInt) {}
  
  public void run()
  {
    InformationFaceAdapter.a.a(this.a).setVisibility(0);
    InformationFaceAdapter.a.a(this.a).setProgress(this.val$percent);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "progress:" + this.val$percent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.1
 * JD-Core Version:    0.7.0.1
 */