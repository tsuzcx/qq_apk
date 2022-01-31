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

class vbm
  extends uyi
{
  vbm(vba paramvba) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if (vzl.b()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131373254: 
        if ((this.a.jdField_a_of_type_Uwq.a() == null) || (this.a.jdField_a_of_type_Uwq.a().size() <= paramInt) || (this.a.jdField_a_of_type_Uwq.a().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.a.jdField_a_of_type_Uwq.a().get(paramInt) instanceof uxo));
    paramView = (uxo)this.a.jdField_a_of_type_Uwq.a().get(paramInt);
    paramObject = new ArrayList();
    paramvap = paramView.a().iterator();
    paramInt = 0;
    label175:
    if (paramvap.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramvap.next();
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
      paramView = ((uxm)this.a.jdField_a_of_type_Uwq.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        tti.a(vba.a(this.a), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      ved.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        svl.a(paramObject, vba.a(this.a));
      }
      if (this.a.jdField_a_of_type_Uwq.a().size() <= 0) {
        break;
      }
      vei.a("home_page", "clk_retry", vei.a(paramView.a()), 0, new String[] { "1", vei.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      label378:
      ved.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((uxm)this.a.jdField_a_of_type_Uwq.a().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(vba.b(this.a), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        vba.c(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        vei.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.a) });
        return;
        ved.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      vba.a(this.a, paramInt);
      return;
      paramView = ((uxm)this.a.jdField_a_of_type_Uwq.a().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.a();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(vba.d(this.a), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        vba.e(this.a).startActivity(paramObject);
      }
      for (;;)
      {
        vei.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        ved.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbm
 * JD-Core Version:    0.7.0.1
 */