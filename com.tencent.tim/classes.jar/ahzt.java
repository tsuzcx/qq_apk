import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.hotpic.HotVideoData.a;
import com.tencent.mobileqq.hotpic.HotVideoData.b;
import java.io.File;

class ahzt
  implements HotVideoData.a
{
  ahzt(ahzs paramahzs, HotVideoData paramHotVideoData, File paramFile, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void a(HotVideoData.b paramb)
  {
    if (paramb.mResult)
    {
      this.d.url = paramb.wM();
      ahzs.a(this.a, this.val$file, this.d, this.val$handler);
    }
    do
    {
      return;
      this.val$file.delete();
      this.d.onFileDownloadFailed(this.d.picIndex);
    } while (this.val$handler == null);
    this.val$handler.onFileDownloadFailed(this.d.picIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzt
 * JD-Core Version:    0.7.0.1
 */