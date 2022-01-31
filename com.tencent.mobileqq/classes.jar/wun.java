import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class wun
  extends wrj
{
  wun(wub paramwub) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if (xsm.b()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131373754: 
        if ((this.a.jdField_a_of_type_Wpr.a() == null) || (this.a.jdField_a_of_type_Wpr.a().size() <= paramInt) || (this.a.jdField_a_of_type_Wpr.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_Wpr.a().get(paramInt) instanceof wqp));
    paramView = (wqp)this.a.jdField_a_of_type_Wpr.a().get(paramInt);
    paramObject = new ArrayList();
    paramwtq = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramwtq.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramwtq.next();
      if (!localStoryVideoItem.isUploadFail()) {
        break label645;
      }
      paramObject.add(localStoryVideoItem);
      paramInt += 1;
    }
    label645:
    for (;;)
    {
      break label175;
      paramView = ((wqn)this.a.jdField_a_of_type_Wpr.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        vmj.a(wub.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      wxe.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        uom.a(paramObject, wub.a(this.a));
      }
      if (this.a.jdField_a_of_type_Wpr.a().size() <= 0) {
        break;
      }
      wxj.a("home_page", "clk_retry", wxj.a(paramView.a()), 0, new String[] { "1", wxj.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      wxe.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((wqn)this.a.jdField_a_of_type_Wpr.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(wub.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        wub.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        wxj.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        wxe.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      wub.a(this.a, paramInt);
      return;
      paramView = ((wqn)this.a.jdField_a_of_type_Wpr.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(wub.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        wub.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        wxj.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        wxe.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wun
 * JD-Core Version:    0.7.0.1
 */