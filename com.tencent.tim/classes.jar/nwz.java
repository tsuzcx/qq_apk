import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nwz
  implements ksz.d
{
  nwz(nww paramnww) {}
  
  public void aGM()
  {
    if (nww.a(this.this$0) != null) {
      nww.a(this.this$0).aGM();
    }
  }
  
  public void mI(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    this.this$0.ql(true);
    nww.a(this.this$0).onBackPress();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      nww.a(this.this$0).aGH();
      this.this$0.ql(false);
      nww.a(this.this$0).onBackPress();
    }
  }
  
  public void pM(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwz
 * JD-Core Version:    0.7.0.1
 */