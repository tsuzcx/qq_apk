import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vvz
  implements View.OnClickListener
{
  public vvz(QCircleExpandableTextView paramQCircleExpandableTextView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a;
    boolean bool;
    if (!this.a.jdField_b_of_type_Boolean)
    {
      bool = true;
      ((QCircleExpandableTextView)localObject).jdField_b_of_type_Boolean = bool;
      if (!this.a.jdField_b_of_type_Boolean) {
        break label157;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_b_of_type_JavaLangString);
      if (this.a.jdField_a_of_type_Vwc != null)
      {
        this.a.jdField_a_of_type_Vwc.b(false);
        this.a.jdField_a_of_type_Vwc.a(false);
      }
    }
    for (localObject = new vwb(this.a, this.a.getHeight(), this.a.d, null);; localObject = new vwb(this.a, this.a.getHeight(), this.a.c + this.a.e, null))
    {
      ((vwb)localObject).setFillAfter(true);
      ((vwb)localObject).setAnimationListener(new vwa(this));
      this.a.clearAnimation();
      this.a.startAnimation((Animation)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label157:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_JavaLangString);
      if (this.a.jdField_a_of_type_Vwc != null)
      {
        this.a.jdField_a_of_type_Vwc.b(true);
        this.a.jdField_a_of_type_Vwc.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvz
 * JD-Core Version:    0.7.0.1
 */