import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahma
  implements View.OnClickListener
{
  ahma(ahlx paramahlx, boolean paramBoolean, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (this.a.e == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.e.hideSoftInputFromWindow();
      ahlx.a(this.a, this.chv, this.val$title, this.rJ);
      this.a.dnZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahma
 * JD-Core Version:    0.7.0.1
 */