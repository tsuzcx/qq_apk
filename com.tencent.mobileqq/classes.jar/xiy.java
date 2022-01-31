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

public class xiy
  extends xit<xiw>
{
  ImageView a;
  
  private xiy(@NonNull Context paramContext, ViewGroup paramViewGroup)
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
  
  public void a(xiw paramxiw, int paramInt)
  {
    super.a(paramxiw, paramInt);
    Object localObject = paramxiw.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((uwx)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((uwx)localObject).jdField_a_of_type_Uww;
        if (localObject != null)
        {
          float f = xcp.a(this.a.getResources()) / ((uww)localObject).d;
          paramxiw = new File(paramxiw.c, ((uww)localObject).jdField_a_of_type_JavaLangString);
          xer.a().a(this.a.getContext(), this.a, paramxiw.toURI().toString(), (int)(((uww)localObject).b * f), (int)(((uww)localObject).c * f), null);
          paramxiw = new RelativeLayout.LayoutParams((int)(((uww)localObject).b * f), (int)(((uww)localObject).c * f));
          if ((((uww)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramxiw.addRule(9);
          }
          if ((((uww)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramxiw.addRule(10);
          }
          if ((((uww)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramxiw.addRule(11);
          }
          if ((((uww)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramxiw.addRule(12);
          }
          if ((((uww)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramxiw.addRule(14);
          }
          if ((((uww)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramxiw.addRule(15);
          }
          if ((((uww)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramxiw.addRule(13);
          }
          if ((((uww)localObject).jdField_a_of_type_ArrayOfInt != null) && (((uww)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramxiw.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramxiw.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramxiw.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramxiw.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramxiw);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xiy
 * JD-Core Version:    0.7.0.1
 */