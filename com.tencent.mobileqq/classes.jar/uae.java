import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;

public class uae
  implements View.OnClickListener
{
  public uae(QCircleExpandableTextView paramQCircleExpandableTextView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    boolean bool;
    if (!this.a.jdField_b_of_type_Boolean)
    {
      bool = true;
      paramView.jdField_b_of_type_Boolean = bool;
      if (!this.a.jdField_b_of_type_Boolean) {
        break label137;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_b_of_type_JavaLangString);
      if (this.a.jdField_a_of_type_Uah != null) {
        this.a.jdField_a_of_type_Uah.a(false);
      }
    }
    for (paramView = new uag(this.a, this.a.getHeight(), this.a.d, null);; paramView = new uag(this.a, this.a.getHeight(), this.a.c + this.a.e, null))
    {
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new uaf(this));
      this.a.clearAnimation();
      this.a.startAnimation(paramView);
      return;
      bool = false;
      break;
      label137:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_JavaLangString);
      if (this.a.jdField_a_of_type_Uah != null) {
        this.a.jdField_a_of_type_Uah.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uae
 * JD-Core Version:    0.7.0.1
 */