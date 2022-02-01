import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.now.view.widget.LabelViewItem;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class akbf
  extends BaseAdapter
{
  public akbf(TopicLabelListView paramTopicLabelListView) {}
  
  public int getCount()
  {
    if ((TopicLabelListView.a(this.b) == null) || (TopicLabelListView.a(this.b).size() == 0)) {
      return 0;
    }
    return TopicLabelListView.a(this.b).size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = new TopicLabelListView.a(this.b, null);
      localObject = new LabelViewItem(TopicLabelListView.a(this.b));
      ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((View)localObject).setTag(paramView);
    }
    for (;;)
    {
      paramView.text = ((String)TopicLabelListView.a(this.b).get(paramInt));
      ((LabelViewItem)localObject).setText(paramView.text);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      TopicLabelListView.a locala = (TopicLabelListView.a)paramView.getTag();
      localObject = paramView;
      paramView = locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbf
 * JD-Core Version:    0.7.0.1
 */