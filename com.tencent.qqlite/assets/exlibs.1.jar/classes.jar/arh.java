import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.util.NearbyProfileUtil;

public class arh
  extends BaseAdapter
{
  private arh(JobSelectionActivity paramJobSelectionActivity) {}
  
  public int getCount()
  {
    if (JobSelectionActivity.a(this.a)) {
      return NearbyProfileUtil.d.length;
    }
    return NearbyProfileUtil.d.length - 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (JobSelectionActivity.a(this.a)) {
      return NearbyProfileUtil.d[paramInt];
    }
    return NearbyProfileUtil.d[(paramInt + 1)];
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2130903490, paramViewGroup, false);
      paramView = new ari(null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298197));
      paramView.b = ((TextView)localView.findViewById(2131296455));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298198));
      localView.setTag(paramView);
    }
    paramView = (ari)localView.getTag();
    int i = paramInt;
    if (!JobSelectionActivity.a(this.a)) {
      i = paramInt + 1;
    }
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[i]);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a[i]);
    if (i < NearbyProfileUtil.d.length - 1) {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((JobSelectionActivity.a(this.a)) && (i == 0)) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      paramView.b.setText(NearbyProfileUtil.d[i]);
      if (JobSelectionActivity.a(this.a) != i) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return localView;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     arh
 * JD-Core Version:    0.7.0.1
 */