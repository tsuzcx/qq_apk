import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class mjv
  extends QIMEffectCameraCaptureUnit
{
  public mjv(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.b = new aybv(10017, 106, 4);
  }
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
    locale.Ov(false);
    locale.setFunctionFlag(2);
    locale.TS(2);
    return locale;
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    localActivity.startActivity(EditPicActivity.a(localActivity, paramh.filePath, true, true, true, true, true, 8));
  }
  
  public View onCreateView()
  {
    this.drQ = false;
    this.drP = false;
    View localView = super.onCreateView();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(2);
    this.fd.setOnClickListener(this);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjv
 * JD-Core Version:    0.7.0.1
 */