import android.view.View;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pqv
  extends prh
{
  pqv(pqu parampqu) {}
  
  public void onClick(View paramView)
  {
    pqn localpqn;
    int i;
    if ((!this.this$0.aBj) && (this.this$0.y != null))
    {
      localpqn = (pqn)this.this$0.a();
      if (pqu.a(this.this$0) != 11) {
        break label145;
      }
      i = 211;
    }
    for (;;)
    {
      StoryDetailActivity.a(this.this$0.y, this.this$0.a.feedId, i, 0);
      i = rar.b(this.this$0.a);
      rar.a("home_page", "clk_like_more", rar.a(this.this$0.a), 0, new String[] { String.valueOf(i), rar.bX(localpqn.mFeedType), "", this.this$0.a.feedId });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label145:
      if (pqu.a(this.this$0) == 12) {
        i = 222;
      } else {
        i = 210;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqv
 * JD-Core Version:    0.7.0.1
 */