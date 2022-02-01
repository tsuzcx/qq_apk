import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.widget.HorizontalListView.d;
import java.util.List;
import java.util.Map;

class qtg
  implements HorizontalListView.d
{
  qtg(qtf paramqtf, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, qtc paramqtc) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.c.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      qtf.a(this.a).gb.put("2_" + this.a.a.d.feedId, ((StoryVideoItem)this.b.la.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtg
 * JD-Core Version:    0.7.0.1
 */