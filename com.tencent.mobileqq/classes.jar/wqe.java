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

class wqe
  extends wna
{
  wqe(wps paramwps) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    if (xod.b()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131373703: 
        if ((this.a.jdField_a_of_type_Wli.a() == null) || (this.a.jdField_a_of_type_Wli.a().size() <= paramInt) || (this.a.jdField_a_of_type_Wli.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_Wli.a().get(paramInt) instanceof wmg));
    paramView = (wmg)this.a.jdField_a_of_type_Wli.a().get(paramInt);
    paramObject = new ArrayList();
    paramwph = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramwph.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramwph.next();
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
      paramView = ((wme)this.a.jdField_a_of_type_Wli.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        via.a(wps.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      wsv.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        ukd.a(paramObject, wps.a(this.a));
      }
      if (this.a.jdField_a_of_type_Wli.a().size() <= 0) {
        break;
      }
      wta.a("home_page", "clk_retry", wta.a(paramView.a()), 0, new String[] { "1", wta.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      wsv.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((wme)this.a.jdField_a_of_type_Wli.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(wps.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        wps.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        wta.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        wsv.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      wps.a(this.a, paramInt);
      return;
      paramView = ((wme)this.a.jdField_a_of_type_Wli.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(wps.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        wps.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        wta.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        wsv.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqe
 * JD-Core Version:    0.7.0.1
 */