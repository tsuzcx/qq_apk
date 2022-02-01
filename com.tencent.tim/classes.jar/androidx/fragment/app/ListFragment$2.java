package androidx.fragment.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ListFragment$2
  implements AdapterView.OnItemClickListener
{
  ListFragment$2(ListFragment paramListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.this$0.onListItemClick((ListView)paramAdapterView, paramView, paramInt, paramLong);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.ListFragment.2
 * JD-Core Version:    0.7.0.1
 */