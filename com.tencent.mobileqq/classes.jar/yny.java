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

class yny
  extends yku
{
  yny(ynm paramynm) {}
  
  public void a(int paramInt, View paramView, Object paramObject, ynb paramynb)
  {
    if (zlx.b()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131374457: 
        if ((this.a.jdField_a_of_type_Yjc.a() == null) || (this.a.jdField_a_of_type_Yjc.a().size() <= paramInt) || (this.a.jdField_a_of_type_Yjc.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_Yjc.a().get(paramInt) instanceof yka));
    paramView = (yka)this.a.jdField_a_of_type_Yjc.a().get(paramInt);
    paramObject = new ArrayList();
    paramynb = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramynb.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramynb.next();
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
      paramView = ((yjy)this.a.jdField_a_of_type_Yjc.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        xfv.a(ynm.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      yqp.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        why.a(paramObject, ynm.a(this.a));
      }
      if (this.a.jdField_a_of_type_Yjc.a().size() <= 0) {
        break;
      }
      yqu.a("home_page", "clk_retry", yqu.a(paramView.a()), 0, new String[] { "1", yqu.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      yqp.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((yjy)this.a.jdField_a_of_type_Yjc.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(ynm.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        ynm.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        yqu.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        yqp.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      ynm.a(this.a, paramInt);
      return;
      paramView = ((yjy)this.a.jdField_a_of_type_Yjc.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(ynm.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        ynm.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        yqu.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        yqp.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yny
 * JD-Core Version:    0.7.0.1
 */