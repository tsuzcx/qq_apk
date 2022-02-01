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

public class zcj
  extends zce<zch>
{
  ImageView a;
  
  private zcj(@NonNull Context paramContext, ViewGroup paramViewGroup)
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
  
  public void a(zch paramzch, int paramInt)
  {
    super.a(paramzch, paramInt);
    Object localObject = paramzch.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((wqj)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((wqj)localObject).jdField_a_of_type_Wqi;
        if (localObject != null)
        {
          float f = ywa.a(this.a.getResources()) / ((wqi)localObject).d;
          paramzch = new File(paramzch.c, ((wqi)localObject).jdField_a_of_type_JavaLangString);
          yyc.a().a(this.a.getContext(), this.a, paramzch.toURI().toString(), (int)(((wqi)localObject).b * f), (int)(((wqi)localObject).c * f), null);
          paramzch = new RelativeLayout.LayoutParams((int)(((wqi)localObject).b * f), (int)(((wqi)localObject).c * f));
          if ((((wqi)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramzch.addRule(9);
          }
          if ((((wqi)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramzch.addRule(10);
          }
          if ((((wqi)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramzch.addRule(11);
          }
          if ((((wqi)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramzch.addRule(12);
          }
          if ((((wqi)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramzch.addRule(14);
          }
          if ((((wqi)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramzch.addRule(15);
          }
          if ((((wqi)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramzch.addRule(13);
          }
          if ((((wqi)localObject).jdField_a_of_type_ArrayOfInt != null) && (((wqi)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramzch.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramzch.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramzch.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramzch.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramzch);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcj
 * JD-Core Version:    0.7.0.1
 */