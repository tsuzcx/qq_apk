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

public class vde
  extends vcz<vdc>
{
  ImageView a;
  
  private vde(@NonNull Context paramContext, ViewGroup paramViewGroup)
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
  
  public void a(vdc paramvdc, int paramInt)
  {
    super.a(paramvdc, paramInt);
    Object localObject = paramvdc.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((srd)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((srd)localObject).jdField_a_of_type_Src;
        if (localObject != null)
        {
          float f = uwv.a(this.a.getResources()) / ((src)localObject).d;
          paramvdc = new File(paramvdc.c, ((src)localObject).jdField_a_of_type_JavaLangString);
          uyx.a().a(this.a.getContext(), this.a, paramvdc.toURI().toString(), (int)(((src)localObject).b * f), (int)(((src)localObject).c * f), null);
          paramvdc = new RelativeLayout.LayoutParams((int)(((src)localObject).b * f), (int)(((src)localObject).c * f));
          if ((((src)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramvdc.addRule(9);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramvdc.addRule(10);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramvdc.addRule(11);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramvdc.addRule(12);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramvdc.addRule(14);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramvdc.addRule(15);
          }
          if ((((src)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramvdc.addRule(13);
          }
          if ((((src)localObject).jdField_a_of_type_ArrayOfInt != null) && (((src)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramvdc.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramvdc.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramvdc.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramvdc.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramvdc);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vde
 * JD-Core Version:    0.7.0.1
 */