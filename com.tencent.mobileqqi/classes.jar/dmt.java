import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SearchFriendListActivity;
import java.util.ArrayList;

public class dmt
  extends BaseAdapter
{
  private dmt(SearchFriendListActivity paramSearchFriendListActivity) {}
  
  public int getCount()
  {
    return SearchFriendListActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return SearchFriendListActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2130903943, paramViewGroup, false);
      paramView = new dmu();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131232906));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131232908));
      paramView.b = ((TextView)localView.findViewById(2131234402));
      localView.setTag(paramView);
      localView.setOnClickListener(this.a);
    }
    this.a.a(localView, paramInt);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmt
 * JD-Core Version:    0.7.0.1
 */