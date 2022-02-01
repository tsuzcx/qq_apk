import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class xte
  extends xqa
{
  xte(xss paramxss) {}
  
  public void a(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if (UIUtils.isFastDoubleClick()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131374362: 
        if ((this.a.jdField_a_of_type_Xoi.a() == null) || (this.a.jdField_a_of_type_Xoi.a().size() <= paramInt) || (this.a.jdField_a_of_type_Xoi.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_Xoi.a().get(paramInt) instanceof xpg));
    paramView = (xpg)this.a.jdField_a_of_type_Xoi.a().get(paramInt);
    paramObject = new ArrayList();
    paramxsh = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramxsh.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramxsh.next();
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
      paramView = ((xpe)this.a.jdField_a_of_type_Xoi.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        wlg.a(xss.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      xvv.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        vns.a(paramObject, xss.a(this.a));
      }
      if (this.a.jdField_a_of_type_Xoi.a().size() <= 0) {
        break;
      }
      xwa.a("home_page", "clk_retry", xwa.a(paramView.a()), 0, new String[] { "1", xwa.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      xvv.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((xpe)this.a.jdField_a_of_type_Xoi.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(xss.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        xss.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        xwa.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        xvv.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      xss.a(this.a, paramInt);
      return;
      paramView = ((xpe)this.a.jdField_a_of_type_Xoi.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(xss.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        xss.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        xwa.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        xvv.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xte
 * JD-Core Version:    0.7.0.1
 */