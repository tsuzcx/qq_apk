import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class xsf
  implements Runnable
{
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Bitmap b;
  
  public xsf(NewFlowCameraActivity paramNewFlowCameraActivity, @NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap1;
    this.b = paramBitmap2;
  }
  
  private void a()
  {
    if ((NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) == null) || (NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) == null) || (NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) == null))
    {
      SLog.e("PTV.NewFlowCameraActivity", "RunnableUpdateThumb error. mFragmentAnimThumbView == null or mFragmentThumbView == null or mFragmentNumView == null.");
      return;
    }
    NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).setVisibility(0);
    NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).setVisibility(8);
    int i = ScreenUtil.a;
    int j = ScreenUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getApplicationContext());
    int k = AIOUtils.a(47.0F, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getResources());
    int m = AIOUtils.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getResources());
    int n = AIOUtils.a(12.0F, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getResources());
    int i1 = AIOUtils.a(20.0F, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getResources());
    SLog.c("PTV.NewFlowCameraActivity", "startScaleAnim. sWidth:" + i + " sHeight:" + j + " dWidth:" + k + " dHeight:" + m + " sMarginLeft:" + 0 + " sMarginBottom:" + 0 + " dMarginLeft:" + n + " dMarginBottom:" + i1);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.addUpdateListener(new xsg(this, k, i, m, j, n, i1));
    localValueAnimator.addListener(new xsh(this));
    localValueAnimator.start();
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.k)
    {
      SLog.e("PTV.NewFlowCameraActivity", "RunnableUpdateThumb error. enableMultiFragment = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.k) });
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsf
 * JD-Core Version:    0.7.0.1
 */