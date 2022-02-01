import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abqp
  implements View.OnClickListener
{
  abqp(abql paramabql) {}
  
  public void onClick(View paramView)
  {
    if ((abql.a(this.this$0).isPaused()) || (abql.b(this.this$0)))
    {
      abql.b(this.this$0, false);
      abql.a(this.this$0).resume();
      abql.c(this.this$0).setVisibility(8);
      abql.b(this.this$0).setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (abql.a(this.this$0).isPlaying())
      {
        abql.b(this.this$0, true);
        abql.a(this.this$0).pause();
        abql.b(this.this$0).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqp
 * JD-Core Version:    0.7.0.1
 */