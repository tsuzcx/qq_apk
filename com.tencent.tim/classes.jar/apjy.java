import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment.a;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.Set;

public class apjy
  implements AdapterView.c
{
  public apjy(SelectReciteParagraphFragment paramSelectReciteParagraphFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.dg.contains(Integer.valueOf(paramInt))) {
      this.a.dg.remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      this.a.a.notifyDataSetChanged();
      this.a.eap();
      return;
      this.a.dg.add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjy
 * JD-Core Version:    0.7.0.1
 */