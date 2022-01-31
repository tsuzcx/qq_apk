import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class xxo
  implements Runnable
{
  public xxo(NewFlowCameraActivity paramNewFlowCameraActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    int i = AIOUtils.a(47.0F, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getResources());
    int j = AIOUtils.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getResources());
    Bitmap localBitmap1 = BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, i, j, false);
    if (localBitmap1 == null) {
      SLog.e("PTV.NewFlowCameraActivity", "resizeThumb = null.");
    }
    Bitmap localBitmap2;
    do
    {
      return;
      localBitmap2 = new RoundedTransformation(AIOUtils.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getResources()), 0, j * 1.0F / i, null, null).a(localBitmap1);
      if (localBitmap2 == null)
      {
        SLog.e("PTV.NewFlowCameraActivity", "roundThumb = null.");
        return;
      }
      i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      float f1 = ScreenUtil.a;
      float f2 = ScreenUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getApplicationContext());
      if (i / j > f1 / f2) {}
      for (localBitmap1 = BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(f1 / f2 * j), j, true); localBitmap1 == null; localBitmap1 = BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, i, (int)(f2 / f1 * i), true))
      {
        SLog.e("PTV.NewFlowCameraActivity", "animBitmap = null.");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.post(new xym(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, localBitmap1, localBitmap2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xxo
 * JD-Core Version:    0.7.0.1
 */