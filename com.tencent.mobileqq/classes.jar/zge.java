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

public class zge
  extends zfz<zgc>
{
  ImageView a;
  
  private zge(@NonNull Context paramContext, ViewGroup paramViewGroup)
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
  
  public void a(zgc paramzgc, int paramInt)
  {
    super.a(paramzgc, paramInt);
    Object localObject = paramzgc.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((wue)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((wue)localObject).jdField_a_of_type_Wud;
        if (localObject != null)
        {
          float f = yzv.a(this.a.getResources()) / ((wud)localObject).d;
          paramzgc = new File(paramzgc.c, ((wud)localObject).jdField_a_of_type_JavaLangString);
          zbx.a().a(this.a.getContext(), this.a, paramzgc.toURI().toString(), (int)(((wud)localObject).b * f), (int)(((wud)localObject).c * f), null);
          paramzgc = new RelativeLayout.LayoutParams((int)(((wud)localObject).b * f), (int)(((wud)localObject).c * f));
          if ((((wud)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramzgc.addRule(9);
          }
          if ((((wud)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramzgc.addRule(10);
          }
          if ((((wud)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramzgc.addRule(11);
          }
          if ((((wud)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramzgc.addRule(12);
          }
          if ((((wud)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramzgc.addRule(14);
          }
          if ((((wud)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramzgc.addRule(15);
          }
          if ((((wud)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramzgc.addRule(13);
          }
          if ((((wud)localObject).jdField_a_of_type_ArrayOfInt != null) && (((wud)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramzgc.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramzgc.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramzgc.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramzgc.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramzgc);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zge
 * JD-Core Version:    0.7.0.1
 */