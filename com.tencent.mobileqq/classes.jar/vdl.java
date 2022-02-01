import android.graphics.Bitmap;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePart.6;

public class vdl
  implements aobv
{
  public vdl(QCircleSharePart.6 param6, aobu paramaobu) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.d("QCircleSharePart", 1, "shareToWeChat share user icon(need decode task)  onDecodeTaskCompleted");
    QCircleSharePart.6.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleSharePart$6, paramBitmap);
    this.jdField_a_of_type_Aobu.a(null);
    this.jdField_a_of_type_Aobu.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdl
 * JD-Core Version:    0.7.0.1
 */