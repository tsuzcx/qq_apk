import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class tvi
  extends RecyclerView.ViewHolder
{
  private Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LinearLayout b;
  
  public tvi(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371644));
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
    this.b = ((LinearLayout)paramView.findViewById(2131369097));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369683));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new tvj(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378982));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvi
 * JD-Core Version:    0.7.0.1
 */