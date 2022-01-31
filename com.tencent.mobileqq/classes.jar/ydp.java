import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.CameraGlFilterListener;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.qphone.base.util.QLog;

public class ydp
  implements Runnable
{
  public ydp(CameraFilterGLView paramCameraFilterGLView, VideoFilterList paramVideoFilterList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, QQVideoMaterial paramQQVideoMaterial, boolean paramBoolean4, int paramInt, boolean paramBoolean5) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.c = this.b;
    label92:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (this.c))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.c);
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) || (!this.d)) {
        break label441;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.b(true);
      l = (SystemClock.elapsedRealtime() - l) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_changeFilter=" + l / 1000.0D + "ms]");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) {
        break label537;
      }
      if (!CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).jdField_a_of_type_Boolean)
      {
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).jdField_a_of_type_Boolean = true;
        if ((CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null) && (this.c))
        {
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.b, 0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.b) {
            break label455;
          }
          bool = true;
          label236:
          CameraFilterGLView.a((CameraFilterGLView)localObject, bool);
        }
      }
      if (!CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).jdField_a_of_type_Boolean)
      {
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).jdField_a_of_type_Boolean = true;
        if ((CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null) && (!CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView)) && (this.d))
        {
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.f, 1);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.f == true) {
            CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView, false);
          }
        }
      }
      localObject = CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView, this.jdField_a_of_type_Int);
      if (localObject != null) {
        break label668;
      }
    }
    label397:
    label537:
    label668:
    for (boolean bool = false;; bool = true)
    {
      int i;
      if (CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.a;
        if ((!this.b) || (FlowCameraConstant.jdField_a_of_type_Int == 2)) {
          break label461;
        }
        i = 1;
        if ((str == null) || (str.length() == 0)) {
          break label466;
        }
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(true, str, 2);
      }
      for (;;)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.a(false);
        break;
        label441:
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView.a.b(false);
        break label92;
        label455:
        bool = false;
        break label236;
        label461:
        i = 0;
        break label397;
        label466:
        if ((i != 0) && (!this.e))
        {
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(true, "切换后置摄像头试试", 0);
          return;
        }
        if (this.e)
        {
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(true, LbsFilterStatusManager.a(), 3);
          return;
        }
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(bool, (String)localObject, 1);
        return;
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).jdField_a_of_type_Boolean = false;
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).jdField_a_of_type_Boolean = false;
        if ((CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null) && (this.c))
        {
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(true, 0);
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView, false);
        }
        while (CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null)
        {
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(false, null, -1);
          return;
          if ((CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null) && (this.d))
          {
            CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(true, 1);
            CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView, false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ydp
 * JD-Core Version:    0.7.0.1
 */