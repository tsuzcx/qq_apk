package dov.com.qq.im.capture.view;

import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter;

class StaticStickerProviderView$3
  implements Runnable
{
  StaticStickerProviderView$3(StaticStickerProviderView paramStaticStickerProviderView, int paramInt, String paramString) {}
  
  public void run()
  {
    FaceListPage localFaceListPage = this.this$0.a.a(this.val$position);
    if (localFaceListPage != null) {
      localFaceListPage.adC(this.cWx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView.3
 * JD-Core Version:    0.7.0.1
 */