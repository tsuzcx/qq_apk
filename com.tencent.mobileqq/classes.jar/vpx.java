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

public class vpx
  extends vps<vpv>
{
  ImageView a;
  
  private vpx(@NonNull Context paramContext, ViewGroup paramViewGroup)
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
  
  public void a(vpv paramvpv, int paramInt)
  {
    super.a(paramvpv, paramInt);
    Object localObject = paramvpv.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((tdw)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((tdw)localObject).jdField_a_of_type_Tdv;
        if (localObject != null)
        {
          float f = vjo.a(this.a.getResources()) / ((tdv)localObject).d;
          paramvpv = new File(paramvpv.c, ((tdv)localObject).jdField_a_of_type_JavaLangString);
          vlq.a().a(this.a.getContext(), this.a, paramvpv.toURI().toString(), (int)(((tdv)localObject).b * f), (int)(((tdv)localObject).c * f), null);
          paramvpv = new RelativeLayout.LayoutParams((int)(((tdv)localObject).b * f), (int)(((tdv)localObject).c * f));
          if ((((tdv)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramvpv.addRule(9);
          }
          if ((((tdv)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramvpv.addRule(10);
          }
          if ((((tdv)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramvpv.addRule(11);
          }
          if ((((tdv)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramvpv.addRule(12);
          }
          if ((((tdv)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramvpv.addRule(14);
          }
          if ((((tdv)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramvpv.addRule(15);
          }
          if ((((tdv)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramvpv.addRule(13);
          }
          if ((((tdv)localObject).jdField_a_of_type_ArrayOfInt != null) && (((tdv)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramvpv.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramvpv.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramvpv.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramvpv.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramvpv);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpx
 * JD-Core Version:    0.7.0.1
 */