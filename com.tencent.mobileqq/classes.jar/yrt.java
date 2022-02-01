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

class yrt
  extends yop
{
  yrt(yrh paramyrh) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yqw paramyqw)
  {
    if (zps.b()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131374594: 
        if ((this.a.jdField_a_of_type_Ymx.a() == null) || (this.a.jdField_a_of_type_Ymx.a().size() <= paramInt) || (this.a.jdField_a_of_type_Ymx.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_Ymx.a().get(paramInt) instanceof ynv));
    paramView = (ynv)this.a.jdField_a_of_type_Ymx.a().get(paramInt);
    paramObject = new ArrayList();
    paramyqw = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramyqw.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramyqw.next();
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
      paramView = ((ynt)this.a.jdField_a_of_type_Ymx.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        xjq.a(yrh.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      yuk.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        wlt.a(paramObject, yrh.a(this.a));
      }
      if (this.a.jdField_a_of_type_Ymx.a().size() <= 0) {
        break;
      }
      yup.a("home_page", "clk_retry", yup.a(paramView.a()), 0, new String[] { "1", yup.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      yuk.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((ynt)this.a.jdField_a_of_type_Ymx.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(yrh.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        yrh.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        yup.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        yuk.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      yrh.a(this.a, paramInt);
      return;
      paramView = ((ynt)this.a.jdField_a_of_type_Ymx.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(yrh.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        yrh.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        yup.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        yuk.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrt
 * JD-Core Version:    0.7.0.1
 */