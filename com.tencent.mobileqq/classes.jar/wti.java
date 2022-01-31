import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.AECamera.View.WatermarkEditView;

public class wti
  extends wug
{
  private static boolean jdField_a_of_type_Boolean;
  private WatermarkEditView jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView;
  
  public wti(Activity paramActivity, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView == null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131298296);
      if (localViewStub != null)
      {
        localViewStub.inflate();
        this.jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView = ((WatermarkEditView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131298295));
        this.jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    if (this.jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView.a();
    }
  }
  
  public Object a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(jdField_a_of_type_Boolean);
  }
  
  protected void a() {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 589825: 
      e();
      jdField_a_of_type_Boolean = true;
      return;
    }
    if ((this.jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView != null) && (this.jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView.getVisibility() == 0)) {
      this.jdField_a_of_type_DovComQqImAECameraViewWatermarkEditView.setVisibility(8);
    }
    jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wti
 * JD-Core Version:    0.7.0.1
 */