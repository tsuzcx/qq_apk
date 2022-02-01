import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView;
import com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView.b;
import com.tencent.mobileqq.nearby.now.view.widget.TopicViewItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class akba
  extends BaseAdapter
{
  public akba(StartLiveTopicLabelListView paramStartLiveTopicLabelListView) {}
  
  public int getCount()
  {
    if ((StartLiveTopicLabelListView.a(this.a) == null) || (StartLiveTopicLabelListView.a(this.a).size() == 0)) {
      return 0;
    }
    return StartLiveTopicLabelListView.a(this.a).size();
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
      paramView = new StartLiveTopicLabelListView.b(this.a, null);
      localObject = new TopicViewItem(StartLiveTopicLabelListView.a(this.a));
      ((View)localObject).setTag(paramView);
      paramView.text = ((String)StartLiveTopicLabelListView.a(this.a).get(paramInt));
      if (!acfp.m(2131714771).equals(paramView.text)) {
        break label162;
      }
      ((View)localObject).setBackgroundResource(StartLiveTopicLabelListView.a(this.a));
      ((TopicViewItem)localObject).setTextColor(StartLiveTopicLabelListView.b(this.a));
    }
    for (;;)
    {
      ((View)localObject).setOnClickListener(new akbb(this));
      ((TopicViewItem)localObject).setText(paramView.text);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      StartLiveTopicLabelListView.b localb = (StartLiveTopicLabelListView.b)paramView.getTag();
      localObject = paramView;
      paramView = localb;
      break;
      label162:
      ((View)localObject).setBackgroundResource(StartLiveTopicLabelListView.c(this.a));
      ((TopicViewItem)localObject).setTextColor(StartLiveTopicLabelListView.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akba
 * JD-Core Version:    0.7.0.1
 */