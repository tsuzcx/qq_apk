import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class zcu
  implements AdapterView.OnItemClickListener
{
  public zcu(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    zcy.a locala = (zcy.a)EmoticonGroupStoreFragment.a(this.this$0).get(paramInt);
    boolean bool = locala.isChecked;
    if (bool)
    {
      if (EmoticonGroupStoreFragment.b(this.this$0).contains(locala.uin)) {
        EmoticonGroupStoreFragment.b(this.this$0).remove(locala.uin);
      }
      locala = (zcy.a)EmoticonGroupStoreFragment.a(this.this$0).get(paramInt);
      if (bool) {
        break label144;
      }
    }
    label144:
    for (bool = true;; bool = false)
    {
      locala.isChecked = bool;
      EmoticonGroupStoreFragment.a(this.this$0).notifyDataSetChanged();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      EmoticonGroupStoreFragment.b(this.this$0).add(locala.uin);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcu
 * JD-Core Version:    0.7.0.1
 */