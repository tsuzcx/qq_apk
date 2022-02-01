import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;

class wxx
  implements wxw.b
{
  wxx(wxw paramwxw) {}
  
  public void a(View paramView, IntimateInfo.MemoryDayInfo paramMemoryDayInfo)
  {
    int j;
    int i;
    if (wxw.a(this.b) != null)
    {
      j = wxw.a(this.b).getChildCount();
      if (j > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        paramView = wxw.a(this.b).getChildAt(i).getTag();
        if (((paramView instanceof IntimateInfo.MemoryDayInfo)) && (((IntimateInfo.MemoryDayInfo)paramView).dateType == paramMemoryDayInfo.dateType)) {
          wxw.a(this.b).removeViewAt(i);
        }
      }
      else
      {
        if (wxw.a(this.b).getChildCount() <= 0) {
          wxw.a(this.b).setVisibility(8);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxx
 * JD-Core Version:    0.7.0.1
 */