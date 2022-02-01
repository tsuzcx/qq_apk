import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagUserItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;

class xsv
  implements bjoe
{
  xsv(xss paramxss, bjnw parambjnw, int paramInt, xpe paramxpe) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bjnw.e();
    switch (paramInt)
    {
    }
    Object localObject2;
    do
    {
      do
      {
        return;
        xss.b(this.jdField_a_of_type_Xss, this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Xpe.a().type != 3) {
          break;
        }
      } while (!(this.jdField_a_of_type_Xpe.a().getOwner() instanceof QQUserUIItem));
      paramView = ((QQUserUIItem)this.jdField_a_of_type_Xpe.a().getOwner()).qq;
      localObject1 = new StringBuilder();
      localObject2 = this.jdField_a_of_type_Xss.a(this.jdField_a_of_type_Int);
      if (localObject2 != null)
      {
        localObject2 = (VideoListLayout)((xsh)localObject2).a(2131374382);
        if (localObject2 != null)
        {
          localObject2 = ((VideoListLayout)localObject2).a();
          if (localObject2 != null)
          {
            paramInt = ((StoryHomeHorizontalListView)localObject2).getFirstVisiblePosition();
            while (paramInt <= ((StoryHomeHorizontalListView)localObject2).getLastVisiblePosition())
            {
              List localList = this.jdField_a_of_type_Xpe.d();
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
      xwa.c("video_nenegative", "close_IDrecommend", 0, 0, new String[] { "", paramView, "", ((StringBuilder)localObject1).toString() });
      return;
    } while ((this.jdField_a_of_type_Xpe.a().type != 6) || (!(this.jdField_a_of_type_Xpe.a().getOwner() instanceof TagUserItem)));
    long l = ((TagUserItem)this.jdField_a_of_type_Xpe.a().getOwner()).tagId;
    paramView = new StringBuilder();
    Object localObject1 = this.jdField_a_of_type_Xss.a(this.jdField_a_of_type_Int);
    if (localObject1 != null)
    {
      localObject1 = (VideoListLayout)((xsh)localObject1).a(2131374382);
      if (localObject1 != null)
      {
        localObject1 = ((VideoListLayout)localObject1).a();
        if (localObject1 != null)
        {
          paramInt = ((StoryHomeHorizontalListView)localObject1).getFirstVisiblePosition();
          while (paramInt <= ((StoryHomeHorizontalListView)localObject1).getLastVisiblePosition())
          {
            localObject2 = this.jdField_a_of_type_Xpe.d();
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
    xwa.c("video_nenegative", "close_newsrecommend", 0, 0, new String[] { "", String.valueOf(l), "", paramView.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsv
 * JD-Core Version:    0.7.0.1
 */