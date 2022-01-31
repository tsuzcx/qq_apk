import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import java.util.List;

public class cki
  implements AdapterView.OnItemClickListener
{
  public cki(EmosmActivity paramEmosmActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a) {}
    do
    {
      do
      {
        return;
        paramAdapterView = (EmoticonPackage)EmosmActivity.a(this.a).getItem(paramInt);
        if (this.a.b)
        {
          EmosmActivity.a(this.a).setSelected(paramInt);
          EmosmActivity.a(this.a).notifyDataSetChanged();
          paramAdapterView = EmosmActivity.a(this.a).getSelectedPackages();
          if ((paramAdapterView != null) && (paramAdapterView.size() > 0))
          {
            EmosmActivity.a(this.a).setEnabled(true);
            EmosmActivity.d(this.a).setEnabled(true);
            return;
          }
          EmosmActivity.a(this.a).setEnabled(false);
          EmosmActivity.e(this.a).setEnabled(false);
          return;
        }
      } while (!EmosmUtils.showNetEnable(this.a));
      this.a.a = true;
      paramView = paramAdapterView.epId;
    } while (paramAdapterView.jobType != 2);
    paramAdapterView = paramAdapterView.kinId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cki
 * JD-Core Version:    0.7.0.1
 */