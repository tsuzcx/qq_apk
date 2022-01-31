import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;

public class bkg
  implements Runnable
{
  public bkg(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI) {}
  
  public void run()
  {
    int i = this.a.jdField_a_of_type_AndroidViewViewGroup.getWidth();
    int j = this.a.b.getWidth();
    int k = this.a.jdField_a_of_type_AndroidWidgetImageButton.getWidth();
    this.a.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(i - j - k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkg
 * JD-Core Version:    0.7.0.1
 */