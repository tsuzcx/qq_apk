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

public class yhe
  extends ygz<yhc>
{
  ImageView a;
  
  private yhe(@NonNull Context paramContext, ViewGroup paramViewGroup)
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
  
  public void a(yhc paramyhc, int paramInt)
  {
    super.a(paramyhc, paramInt);
    Object localObject = paramyhc.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((vvu)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((vvu)localObject).jdField_a_of_type_Vvt;
        if (localObject != null)
        {
          float f = ybe.a(this.a.getResources()) / ((vvt)localObject).d;
          paramyhc = new File(paramyhc.c, ((vvt)localObject).jdField_a_of_type_JavaLangString);
          ydf.a().a(this.a.getContext(), this.a, paramyhc.toURI().toString(), (int)(((vvt)localObject).b * f), (int)(((vvt)localObject).c * f), null);
          paramyhc = new RelativeLayout.LayoutParams((int)(((vvt)localObject).b * f), (int)(((vvt)localObject).c * f));
          if ((((vvt)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramyhc.addRule(9);
          }
          if ((((vvt)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramyhc.addRule(10);
          }
          if ((((vvt)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramyhc.addRule(11);
          }
          if ((((vvt)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramyhc.addRule(12);
          }
          if ((((vvt)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramyhc.addRule(14);
          }
          if ((((vvt)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramyhc.addRule(15);
          }
          if ((((vvt)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramyhc.addRule(13);
          }
          if ((((vvt)localObject).jdField_a_of_type_ArrayOfInt != null) && (((vvt)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramyhc.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramyhc.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramyhc.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramyhc.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramyhc);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhe
 * JD-Core Version:    0.7.0.1
 */