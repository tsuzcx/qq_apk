import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;

public class deg
  implements Runnable
{
  public deg(BigEmoticonViewBinder paramBigEmoticonViewBinder, View paramView) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder.a(0);
    Button localButton;
    View localView;
    if (i == 2005)
    {
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297056);
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297058);
      if (localView != null) {
        localView.setVisibility(8);
      }
      if (localButton != null) {
        localButton.setVisibility(0);
      }
    }
    do
    {
      do
      {
        return;
      } while (i != 2004);
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297081);
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297082);
      if (localView != null) {
        localView.setVisibility(8);
      }
    } while (localButton == null);
    localButton.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     deg
 * JD-Core Version:    0.7.0.1
 */