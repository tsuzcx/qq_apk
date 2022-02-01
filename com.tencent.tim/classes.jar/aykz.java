import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.text.DynamicTextItem;

class aykz
  implements View.OnClickListener
{
  aykz(aykw paramaykw) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.d != null)
    {
      aykw.a(this.this$0, false);
      this.this$0.b = this.this$0.d;
      this.this$0.b.setText(aykw.a(this.this$0), this.this$0.mText);
      this.this$0.b.setTextSize(this.this$0.mSize);
      if ((this.this$0.b instanceof axvb)) {
        ((axvb)this.this$0.b).setTextColor(this.this$0.mColor);
      }
      this.this$0.nN(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykz
 * JD-Core Version:    0.7.0.1
 */