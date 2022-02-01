import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class zgj
  extends zfz<zgi>
{
  public final ImageView a;
  public final TextView a;
  public final TextView b = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378679);
  
  zgj(zgi paramzgi, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378603));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368320));
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561738, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a(zgi paramzgi, int paramInt)
  {
    super.a(paramzgi, paramInt);
    if ((this.jdField_a_of_type_Zfy != null) && (((zgi)this.jdField_a_of_type_Zfy).c != 0) && (((zgi)this.jdField_a_of_type_Zfy).a != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((zgi)this.jdField_a_of_type_Zfy).c);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((zgi)this.jdField_a_of_type_Zfy).a);
      this.b.setText(((zgi)this.jdField_a_of_type_Zfy).b);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.b.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgj
 * JD-Core Version:    0.7.0.1
 */