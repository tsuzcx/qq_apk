import android.app.Activity;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.a;

public class axxs
  implements FaceListPage.a
{
  public axxs(StaticStickerProviderView paramStaticStickerProviderView, Activity paramActivity) {}
  
  public void bsI()
  {
    ram.d("StaticStickerProviderView", "用户点击重新拉取地理贴纸");
    ((axsu)axov.a(4)).c(true, this.val$activity);
  }
  
  public void cancel(String paramString)
  {
    ram.d("StaticStickerProviderView", "用户点击下载取消：" + paramString);
  }
  
  public void fM(String paramString)
  {
    ram.d("StaticStickerProviderView", "用户点击下载：" + paramString);
    ras.sp("0X80075DD");
    if (!((aykn)psx.a(39)).s(paramString, true)) {
      ram.w("StaticStickerProviderView", "用户点击下载启动失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxs
 * JD-Core Version:    0.7.0.1
 */