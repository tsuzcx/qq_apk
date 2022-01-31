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

public class xep
  extends xek<xen>
{
  ImageView a;
  
  private xep(@NonNull Context paramContext, ViewGroup paramViewGroup)
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
  
  public void a(xen paramxen, int paramInt)
  {
    super.a(paramxen, paramInt);
    Object localObject = paramxen.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((uso)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((uso)localObject).jdField_a_of_type_Usn;
        if (localObject != null)
        {
          float f = wyg.a(this.a.getResources()) / ((usn)localObject).d;
          paramxen = new File(paramxen.c, ((usn)localObject).jdField_a_of_type_JavaLangString);
          xai.a().a(this.a.getContext(), this.a, paramxen.toURI().toString(), (int)(((usn)localObject).b * f), (int)(((usn)localObject).c * f), null);
          paramxen = new RelativeLayout.LayoutParams((int)(((usn)localObject).b * f), (int)(((usn)localObject).c * f));
          if ((((usn)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramxen.addRule(9);
          }
          if ((((usn)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramxen.addRule(10);
          }
          if ((((usn)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramxen.addRule(11);
          }
          if ((((usn)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramxen.addRule(12);
          }
          if ((((usn)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramxen.addRule(14);
          }
          if ((((usn)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramxen.addRule(15);
          }
          if ((((usn)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramxen.addRule(13);
          }
          if ((((usn)localObject).jdField_a_of_type_ArrayOfInt != null) && (((usn)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramxen.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramxen.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramxen.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramxen.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramxen);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xep
 * JD-Core Version:    0.7.0.1
 */