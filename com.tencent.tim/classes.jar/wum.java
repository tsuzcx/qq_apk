import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

class wum
  implements AdapterView.c
{
  wum(wuk paramwuk) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (zmc)wuk.a(this.this$0).a.getItem(paramInt - 1);
    wuk.a(this.this$0, paramAdapterView);
    wuk.a(this.this$0).dismiss();
    anot.a(wuk.a(this.this$0).app, "dc00898", "", "", "0X800A417", "0X800A417", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wum
 * JD-Core Version:    0.7.0.1
 */