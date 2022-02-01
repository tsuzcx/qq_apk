import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class juv
  implements CompoundButton.OnCheckedChangeListener
{
  juv(juk paramjuk, jzs.a parama, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.b.abQ)
    {
      this.b.abQ = true;
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (this.a.aGJ == 1) {
      this.b.a(this.a, paramBoolean);
    }
    for (;;)
    {
      juk.a(this.b, this.a.title);
      break;
      if (this.a.aGJ == 2)
      {
        if (paramBoolean) {
          this.b.a(this.a, this.n, paramBoolean);
        } else {
          this.b.a(this.a, paramBoolean);
        }
      }
      else if (this.a.aGJ == 3)
      {
        if (!paramBoolean) {
          this.b.a(this.a, this.n, paramBoolean);
        } else {
          this.b.a(this.a, paramBoolean);
        }
      }
      else {
        this.b.a(this.a, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     juv
 * JD-Core Version:    0.7.0.1
 */