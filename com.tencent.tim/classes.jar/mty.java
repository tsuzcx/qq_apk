import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mty
  implements ksz.d
{
  mty(mtw parammtw) {}
  
  public void aGM()
  {
    if (mtw.a(this.b) != null) {
      mtw.a(this.b).aGM();
    }
  }
  
  public void mI(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.aSh();
      return;
    }
    this.b.aSi();
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
      mtw.a(this.b).aGH();
      this.b.aSi();
    }
  }
  
  public void pM(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    mtw.a(this.b).commentCount = paramInt;
    mtw.a(this.b).i(mtw.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mty
 * JD-Core Version:    0.7.0.1
 */