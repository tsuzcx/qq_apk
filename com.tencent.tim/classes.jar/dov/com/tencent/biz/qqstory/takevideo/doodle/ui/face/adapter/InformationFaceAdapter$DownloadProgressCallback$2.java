package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import acfp;
import ayna.c;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  InformationFaceAdapter$DownloadProgressCallback$2(InformationFaceAdapter.a parama, boolean paramBoolean, ayna.c paramc) {}
  
  public void run()
  {
    InformationFaceAdapter.a.a(this.a).setVisibility(8);
    if (this.dAc) {
      InformationFaceAdapter.a(this.a.this$0, InformationFaceAdapter.a.a(this.a), this.c);
    }
    for (;;)
    {
      this.a.onDestroy();
      return;
      QQToast.a(InformationFaceAdapter.a.a(this.a).getContext(), 0, acfp.m(2131707411), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */