import android.graphics.Bitmap;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePart.4;

public class oxk
  implements aqdf.a
{
  public oxk(QCircleSharePart.4 param4, aqdf paramaqdf) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.d("QCircleSharePart", 1, "shareToWeChat share user icon(need decode task)  onDecodeTaskCompleted");
    QCircleSharePart.4.a(this.a, paramBitmap);
    this.b.a(null);
    this.b.destory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxk
 * JD-Core Version:    0.7.0.1
 */