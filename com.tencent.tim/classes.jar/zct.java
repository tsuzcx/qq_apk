import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class zct
  implements View.OnClickListener
{
  public zct(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.this$0.tQ.iterator();
    while (localIterator.hasNext()) {
      ((EmoticonFromGroupEntity)localIterator.next()).status = -1;
    }
    this.this$0.tQ.clear();
    EmoticonGroupStoreFragment.a(this.this$0).setVisibility(8);
    EmoticonGroupStoreFragment.b(this.this$0).setVisibility(0);
    EmoticonGroupStoreFragment.a(this.this$0).bqM = false;
    EmoticonGroupStoreFragment.a(this.this$0).aF(false);
    EmoticonGroupStoreFragment.a(this.this$0).notifyDataSetChanged();
    EmoticonGroupStoreFragment.e(this.this$0);
    this.this$0.L(true);
    this.this$0.resetLeftButton();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zct
 * JD-Core Version:    0.7.0.1
 */