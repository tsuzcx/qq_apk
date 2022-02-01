import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mkm
  implements AdapterView.OnItemClickListener
{
  public mkm(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment, boolean paramBoolean) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.anj) {}
    for (;;)
    {
      this.a.getActivity().finish();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      Intent localIntent = new Intent();
      Object localObject = paramAdapterView.getItemAtPosition(paramInt);
      if ((localObject != null) && ((localObject instanceof TagInfo)))
      {
        localIntent.putExtra("SEARCH_TAG_RESULT", (TagInfo)localObject);
        this.a.getActivity().setResult(-1, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mkm
 * JD-Core Version:    0.7.0.1
 */