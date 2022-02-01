import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ksd
  implements View.OnClickListener
{
  public ksd(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.ahd)
      {
        ReadInJoyCommentComponentFragment.a(this.this$0, false);
      }
      else
      {
        ReadInJoyCommentComponentFragment.a(this.this$0, true);
        continue;
        ReadInJoyCommentComponentFragment.b(this.this$0);
        continue;
        ReadInJoyCommentComponentFragment.b(this.this$0);
        if (ReadInJoyCommentComponentFragment.a(this.this$0) != null)
        {
          if (ReadInJoyCommentComponentFragment.c(this.this$0) >= ReadInJoyCommentComponentFragment.a(this.this$0).length) {
            ReadInJoyCommentComponentFragment.a(this.this$0, 0);
          }
          this.this$0.oP.setText(ReadInJoyCommentComponentFragment.a(this.this$0)[ReadInJoyCommentComponentFragment.c(this.this$0)]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksd
 * JD-Core Version:    0.7.0.1
 */