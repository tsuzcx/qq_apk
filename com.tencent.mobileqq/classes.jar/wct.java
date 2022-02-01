import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

class wct
  extends RecyclerView.ViewHolder
{
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public ImageView b;
  
  public wct(wcs paramwcs, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369610));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369604));
    this.b = ((ImageView)paramView.findViewById(2131369603));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369608));
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    FrameLayout.LayoutParams localLayoutParams;
    if (wcp.a(this.jdField_a_of_type_Wcs.jdField_a_of_type_Wcp) == 0)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("Q群: " + paramLong);
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt != 0) {
        break label165;
      }
      localLayoutParams.setMargins(0, 0, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(bdep.a(5.0F), 0, bdep.a(5.0F), 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new wcu(this, paramLong));
      this.b.setOnClickListener(new wcv(this, paramLong));
      return;
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramLong));
      break;
      label165:
      if (paramInt == this.jdField_a_of_type_Wcs.jdField_a_of_type_JavaUtilList.size() - 1) {
        localLayoutParams.setMargins(bdep.a(5.0F), 0, bdep.a(38.0F), 0);
      } else {
        localLayoutParams.setMargins(bdep.a(5.0F), 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wct
 * JD-Core Version:    0.7.0.1
 */