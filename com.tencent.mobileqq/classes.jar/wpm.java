import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class wpm
  extends RecyclerView.ViewHolder
{
  private Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public wpm(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371329));
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368868));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378380));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wpm
 * JD-Core Version:    0.7.0.1
 */