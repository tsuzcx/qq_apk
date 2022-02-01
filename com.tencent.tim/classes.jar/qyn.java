import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagUserItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

class qyn
  implements ausj.a
{
  qyn(qyk paramqyk, ausj paramausj, int paramInt, qwa paramqwa) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.superDismiss();
    switch (paramInt)
    {
    }
    Object localObject2;
    do
    {
      do
      {
        return;
        qyk.b(this.this$0, this.val$position);
        if (this.c.a().type != 3) {
          break;
        }
      } while (!(this.c.a().getOwner() instanceof QQUserUIItem));
      paramView = ((QQUserUIItem)this.c.a().getOwner()).qq;
      localObject1 = new StringBuilder();
      localObject2 = this.this$0.a(this.val$position);
      if (localObject2 != null)
      {
        localObject2 = (VideoListLayout)((qyd)localObject2).get(2131375156);
        if (localObject2 != null)
        {
          localObject2 = ((VideoListLayout)localObject2).a();
          if (localObject2 != null)
          {
            paramInt = ((StoryHomeHorizontalListView)localObject2).getFirstVisiblePosition();
            while (paramInt <= ((StoryHomeHorizontalListView)localObject2).getLastVisiblePosition())
            {
              List localList = this.c.bZ();
              if ((paramInt >= 0) && (paramInt < localList.size()))
              {
                ((StringBuilder)localObject1).append(((StoryVideoItem)localList.get(paramInt)).mVid);
                if (paramInt < ((StoryHomeHorizontalListView)localObject2).getLastVisiblePosition()) {
                  ((StringBuilder)localObject1).append(",");
                }
              }
              paramInt += 1;
            }
          }
        }
      }
      rar.c("video_nenegative", "close_IDrecommend", 0, 0, new String[] { "", paramView, "", ((StringBuilder)localObject1).toString() });
      return;
    } while ((this.c.a().type != 6) || (!(this.c.a().getOwner() instanceof TagUserItem)));
    long l = ((TagUserItem)this.c.a().getOwner()).tagId;
    paramView = new StringBuilder();
    Object localObject1 = this.this$0.a(this.val$position);
    if (localObject1 != null)
    {
      localObject1 = (VideoListLayout)((qyd)localObject1).get(2131375156);
      if (localObject1 != null)
      {
        localObject1 = ((VideoListLayout)localObject1).a();
        if (localObject1 != null)
        {
          paramInt = ((StoryHomeHorizontalListView)localObject1).getFirstVisiblePosition();
          while (paramInt <= ((StoryHomeHorizontalListView)localObject1).getLastVisiblePosition())
          {
            localObject2 = this.c.bZ();
            if ((paramInt >= 0) && (paramInt < ((List)localObject2).size()))
            {
              paramView.append(((StoryVideoItem)((List)localObject2).get(paramInt)).mVid);
              if (paramInt < ((StoryHomeHorizontalListView)localObject1).getLastVisiblePosition()) {
                paramView.append(",");
              }
            }
            paramInt += 1;
          }
        }
      }
    }
    rar.c("video_nenegative", "close_newsrecommend", 0, 0, new String[] { "", String.valueOf(l), "", paramView.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qyn
 * JD-Core Version:    0.7.0.1
 */