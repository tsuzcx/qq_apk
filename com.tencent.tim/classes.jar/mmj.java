import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class mmj
  implements AdapterView.OnItemClickListener
{
  public mmj(EditVideoFragment paramEditVideoFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EditVideoFragment.a(this.a, (ColumnInfo)EditVideoFragment.a(this.a).get(paramInt));
    if (EditVideoFragment.a(this.a) != null) {
      EditVideoFragment.a(this.a).columnId = EditVideoFragment.a(this.a).columnID;
    }
    EditVideoFragment.a(this.a).notifyDataSetChanged();
    EditVideoFragment.a(this.a);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmj
 * JD-Core Version:    0.7.0.1
 */