import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView;
import java.lang.ref.WeakReference;

public class yqf
  implements View.OnClickListener
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public yqf(GdtCanvasPictureComponentView paramGdtCanvasPictureComponentView, String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString3;
  }
  
  public void onClick(View paramView)
  {
    if ((GdtCanvasPictureComponentView.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentView) != null) && (GdtCanvasPictureComponentView.b(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentView).get() != null)) {
      ((yqo)GdtCanvasPictureComponentView.c(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentView).get()).a(this.c, GdtCanvasPictureComponentView.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentView).id, this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yqf
 * JD-Core Version:    0.7.0.1
 */