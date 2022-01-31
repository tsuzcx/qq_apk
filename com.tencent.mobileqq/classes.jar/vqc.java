import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class vqc
  extends vps<vqb>
{
  public final ImageView a;
  public final TextView a;
  public final TextView b = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377105);
  
  vqc(vqb paramvqb, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377032));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367776));
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561253, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a(vqb paramvqb, int paramInt)
  {
    super.a(paramvqb, paramInt);
    if ((this.jdField_a_of_type_Vpr != null) && (((vqb)this.jdField_a_of_type_Vpr).c != 0) && (((vqb)this.jdField_a_of_type_Vpr).a != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((vqb)this.jdField_a_of_type_Vpr).c);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((vqb)this.jdField_a_of_type_Vpr).a);
      this.b.setText(((vqb)this.jdField_a_of_type_Vpr).b);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.b.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqc
 * JD-Core Version:    0.7.0.1
 */