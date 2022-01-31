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

public class vqa
  extends vpv<vpy>
{
  ImageView a;
  
  private vqa(@NonNull Context paramContext, ViewGroup paramViewGroup)
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
  
  public void a(vpy paramvpy, int paramInt)
  {
    super.a(paramvpy, paramInt);
    Object localObject = paramvpy.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((tdz)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((tdz)localObject).jdField_a_of_type_Tdy;
        if (localObject != null)
        {
          float f = vjr.a(this.a.getResources()) / ((tdy)localObject).d;
          paramvpy = new File(paramvpy.c, ((tdy)localObject).jdField_a_of_type_JavaLangString);
          vlt.a().a(this.a.getContext(), this.a, paramvpy.toURI().toString(), (int)(((tdy)localObject).b * f), (int)(((tdy)localObject).c * f), null);
          paramvpy = new RelativeLayout.LayoutParams((int)(((tdy)localObject).b * f), (int)(((tdy)localObject).c * f));
          if ((((tdy)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramvpy.addRule(9);
          }
          if ((((tdy)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramvpy.addRule(10);
          }
          if ((((tdy)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramvpy.addRule(11);
          }
          if ((((tdy)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramvpy.addRule(12);
          }
          if ((((tdy)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramvpy.addRule(14);
          }
          if ((((tdy)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramvpy.addRule(15);
          }
          if ((((tdy)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramvpy.addRule(13);
          }
          if ((((tdy)localObject).jdField_a_of_type_ArrayOfInt != null) && (((tdy)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramvpy.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramvpy.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramvpy.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramvpy.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramvpy);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqa
 * JD-Core Version:    0.7.0.1
 */