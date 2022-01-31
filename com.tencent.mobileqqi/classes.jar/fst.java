import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;

public class fst
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public fst(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = EmoticonLinearLayout.d(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout);
  }
  
  public void run()
  {
    EmoticonInfo localEmoticonInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.getParent() != null) && (this.jdField_a_of_type_Int == EmoticonLinearLayout.c(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout)) && (EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout) != null))
    {
      localEmoticonInfo = (EmoticonInfo)EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout).getTag();
      if (localEmoticonInfo != null)
      {
        if ((EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout) != null) && (EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout).a(localEmoticonInfo))) {
          break label173;
        }
        EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout, true);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.getParent().requestDisallowInterceptTouchEvent(true);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.sendAccessibilityEvent(2);
        if (!"delete".equals(localEmoticonInfo.a)) {
          break label133;
        }
        EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout).run();
      }
    }
    label133:
    while (("setting".equals(localEmoticonInfo.a)) || ("add".equals(localEmoticonInfo.a))) {
      return;
    }
    EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout, EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout), localEmoticonInfo);
    return;
    label173:
    EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fst
 * JD-Core Version:    0.7.0.1
 */