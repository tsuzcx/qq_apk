import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.io.File;
import java.net.URI;

public class yvx
  extends yvs<yvv>
{
  ImageView a;
  
  private yvx(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = new RelativeLayout(paramContext);
    paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.a = new ImageView(paramContext);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    paramViewGroup.addView(this.a);
    return paramViewGroup;
  }
  
  public void a(yvv paramyvv, int paramInt)
  {
    super.a(paramyvv, paramInt);
    Object localObject = paramyvv.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((wkp)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((wkp)localObject).jdField_a_of_type_Wko;
        if (localObject != null)
        {
          float f = ypx.a(this.a.getResources()) / ((wko)localObject).d;
          paramyvv = new File(paramyvv.c, ((wko)localObject).jdField_a_of_type_JavaLangString);
          yry.a().a(this.a.getContext(), this.a, paramyvv.toURI().toString(), (int)(((wko)localObject).b * f), (int)(((wko)localObject).c * f), null);
          paramyvv = new RelativeLayout.LayoutParams((int)(((wko)localObject).b * f), (int)(((wko)localObject).c * f));
          if ((((wko)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramyvv.addRule(9);
          }
          if ((((wko)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramyvv.addRule(10);
          }
          if ((((wko)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramyvv.addRule(11);
          }
          if ((((wko)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramyvv.addRule(12);
          }
          if ((((wko)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramyvv.addRule(14);
          }
          if ((((wko)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramyvv.addRule(15);
          }
          if ((((wko)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramyvv.addRule(13);
          }
          if ((((wko)localObject).jdField_a_of_type_ArrayOfInt != null) && (((wko)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramyvv.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramyvv.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramyvv.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramyvv.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramyvv);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvx
 * JD-Core Version:    0.7.0.1
 */