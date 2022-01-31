import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.ClassicEmoticonPanelView;

public class def
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public def(ClassicEmoticonPanelView paramClassicEmoticonPanelView) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = ClassicEmoticonPanelView.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.getParent() != null) && (this.jdField_a_of_type_Int == ClassicEmoticonPanelView.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.b != -1) && (ClassicEmoticonPanelView.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView) != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.sendAccessibilityEvent(2);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.b == 20)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.jdField_a_of_type_JavaLangRunnable.run();
        return;
      }
      ClassicEmoticonPanelView.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.b);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewClassicEmoticonPanelView.b = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     def
 * JD-Core Version:    0.7.0.1
 */