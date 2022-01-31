import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.util.VersionUtils;
import java.util.HashMap;

public class xrw
  implements Runnable
{
  public xrw(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    String str = null;
    if (this.a.E) {
      return;
    }
    if (!this.a.g)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.a.b.setVisibility(0);
      VideoAnimation.a(this.a.b, 0.1F, 1.2F, 0.1F, 1.2F, 400, null);
      if (VersionUtils.e()) {
        this.a.G();
      }
      NewFlowCameraActivity.a(this.a).put("cameraType", String.valueOf(FlowCameraConstant.a));
      NewFlowCameraActivity.a(this.a).put("isTemplateMode", String.valueOf(this.a.g));
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null) {
        str = this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
      }
      NewFlowCameraActivity.a(this.a).put("templateId", str);
      if ((this.a.o != 90) && (this.a.o != 270)) {
        break label569;
      }
    }
    label562:
    label569:
    for (int i = 1;; i = 0)
    {
      NewFlowCameraActivity.a(this.a).put("cameraOrientation", String.valueOf(i));
      NewFlowCameraActivity.a(this.a).put("isFaceDectected", String.valueOf(NewFlowCameraActivity.jdField_a_of_type_Boolean));
      NewFlowCameraActivity.a(this.a, System.currentTimeMillis());
      if ((NewFlowCameraActivity.a(this.a) > 0L) && (NewFlowCameraActivity.b(this.a) - NewFlowCameraActivity.a(this.a) > 0L)) {}
      for (long l = NewFlowCameraActivity.b(this.a) - NewFlowCameraActivity.a(this.a);; l = 0L)
      {
        NewFlowCameraActivity.b(this.a, 0L);
        NewFlowCameraActivity.a(this.a).put("previewDuration", String.valueOf(l));
        return;
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        Object localObject;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter != null)
        {
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.a();
          if ((localObject == null) || (TextUtils.isEmpty(((PtvTemplateManager.PtvTemplateInfo)localObject).iconurl))) {
            break label499;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          i = AIOUtils.a(50.0F, this.a.getResources());
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(this.a.getResources().getColor(2131493213));
          localGradientDrawable.setShape(1);
          localGradientDrawable.setSize(i, i);
          localURLDrawableOptions.mRequestWidth = i;
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
          localURLDrawableOptions.mLoadingDrawable = localGradientDrawable;
          localObject = URLDrawable.getDrawable(((PtvTemplateManager.PtvTemplateInfo)localObject).iconurl, localURLDrawableOptions);
          ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(i, i));
          ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        for (;;)
        {
          if (!VersionUtils.e()) {
            break label562;
          }
          this.a.G();
          break;
          label499:
          if ((localObject != null) && (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals("0")))
          {
            this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            this.a.b.setVisibility(0);
            VideoAnimation.a(this.a.b, 0.1F, 1.2F, 0.1F, 1.2F, 400, null);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrw
 * JD-Core Version:    0.7.0.1
 */