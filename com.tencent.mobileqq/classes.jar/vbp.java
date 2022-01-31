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

class vbp
  extends uyl
{
  vbp(vbd paramvbd) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if (vzo.b()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131373252: 
        if ((this.a.jdField_a_of_type_Uwt.a() == null) || (this.a.jdField_a_of_type_Uwt.a().size() <= paramInt) || (this.a.jdField_a_of_type_Uwt.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_Uwt.a().get(paramInt) instanceof uxr));
    paramView = (uxr)this.a.jdField_a_of_type_Uwt.a().get(paramInt);
    paramObject = new ArrayList();
    paramvas = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramvas.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramvas.next();
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
      paramView = ((uxp)this.a.jdField_a_of_type_Uwt.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        ttl.a(vbd.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      veg.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        svo.a(paramObject, vbd.a(this.a));
      }
      if (this.a.jdField_a_of_type_Uwt.a().size() <= 0) {
        break;
      }
      vel.a("home_page", "clk_retry", vel.a(paramView.a()), 0, new String[] { "1", vel.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      veg.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((uxp)this.a.jdField_a_of_type_Uwt.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(vbd.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        vbd.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        vel.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        veg.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      vbd.a(this.a, paramInt);
      return;
      paramView = ((uxp)this.a.jdField_a_of_type_Uwt.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(vbd.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        vbd.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        vel.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        veg.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbp
 * JD-Core Version:    0.7.0.1
 */