import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ywc
  extends yvs<ywb>
{
  public final ImageView a;
  public final TextView a;
  public final TextView b = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378735);
  
  ywc(ywb paramywb, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378658));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368501));
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561684, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a(ywb paramywb, int paramInt)
  {
    super.a(paramywb, paramInt);
    if ((this.jdField_a_of_type_Yvr != null) && (((ywb)this.jdField_a_of_type_Yvr).c != 0) && (((ywb)this.jdField_a_of_type_Yvr).a != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((ywb)this.jdField_a_of_type_Yvr).c);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((ywb)this.jdField_a_of_type_Yvr).a);
      this.b.setText(((ywb)this.jdField_a_of_type_Yvr).b);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.b.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywc
 * JD-Core Version:    0.7.0.1
 */