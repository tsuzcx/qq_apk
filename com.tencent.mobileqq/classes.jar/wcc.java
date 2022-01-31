import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class wcc
  extends RecyclerView.ViewHolder
{
  private Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public wcc(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305633));
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131303203));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312552));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wcc
 * JD-Core Version:    0.7.0.1
 */