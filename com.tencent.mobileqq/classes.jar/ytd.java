import com.tencent.biz.ui.TouchWebView;
import com.tencent.widget.ScrollView;

public class ytd
{
  private static final String jdField_a_of_type_JavaLangString = ytd.class.getSimpleName();
  private float jdField_a_of_type_Float;
  public int a;
  public bhuz a;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  public boolean a;
  
  public ytd(ScrollView paramScrollView, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    this.jdField_a_of_type_ComTencentWidgetScrollView = paramScrollView;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_ComTencentWidgetScrollView == null) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    while ((this.jdField_a_of_type_Float <= 0.0F) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canScrollVertically(-1)) || (paramInt != 0) || (!this.jdField_a_of_type_ComTencentWidgetScrollView.canScrollVertically(-1))) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetScrollView.fling((int)-this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytd
 * JD-Core Version:    0.7.0.1
 */