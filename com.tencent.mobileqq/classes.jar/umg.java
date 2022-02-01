import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class umg
  extends BaseAdapter
{
  umg(umd paramumd) {}
  
  public int getCount()
  {
    return umd.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return umd.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560254, null);
      paramView = new umh(this.a);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380198));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369352));
      localView.setTag(paramView);
      localObject = (GiftServiceBean)getItem(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((GiftServiceBean)localObject).t);
      if (umd.a(this.a) != paramInt) {
        break label143;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842944);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (umh)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label143:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umg
 * JD-Core Version:    0.7.0.1
 */