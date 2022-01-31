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

class uot
  extends ulp
{
  uot(uoh paramuoh) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if (vms.b()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131307539: 
        if ((this.a.jdField_a_of_type_Ujx.a() == null) || (this.a.jdField_a_of_type_Ujx.a().size() <= paramInt) || (this.a.jdField_a_of_type_Ujx.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_Ujx.a().get(paramInt) instanceof ukv));
    paramView = (ukv)this.a.jdField_a_of_type_Ujx.a().get(paramInt);
    paramObject = new ArrayList();
    paramunw = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramunw.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramunw.next();
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
      paramView = ((ukt)this.a.jdField_a_of_type_Ujx.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        tgp.a(uoh.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      urk.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        sis.a(paramObject, uoh.a(this.a));
      }
      if (this.a.jdField_a_of_type_Ujx.a().size() <= 0) {
        break;
      }
      urp.a("home_page", "clk_retry", urp.a(paramView.a()), 0, new String[] { "1", urp.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      urk.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((ukt)this.a.jdField_a_of_type_Ujx.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(uoh.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        uoh.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        urp.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        urk.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      uoh.a(this.a, paramInt);
      return;
      paramView = ((ukt)this.a.jdField_a_of_type_Ujx.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(uoh.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        uoh.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        urp.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        urk.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uot
 * JD-Core Version:    0.7.0.1
 */