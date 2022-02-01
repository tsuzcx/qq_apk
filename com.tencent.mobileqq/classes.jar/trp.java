import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class trp
  extends BaseAdapter
{
  trp(trm paramtrm) {}
  
  public int getCount()
  {
    return trm.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return trm.a(this.a).get(paramInt);
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560201, null);
      paramView = new trq(this.a);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380126));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369167));
      localView.setTag(paramView);
      localObject = (GiftServiceBean)getItem(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((GiftServiceBean)localObject).t);
      if (trm.a(this.a) != paramInt) {
        break label143;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842858);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (trq)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label143:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842859);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trp
 * JD-Core Version:    0.7.0.1
 */