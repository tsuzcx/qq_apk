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

class qyw
  extends qwo
{
  qyw(qyk paramqyk) {}
  
  public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
  {
    if (rpq.isFastDoubleClick()) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131375136: 
        if ((this.this$0.a.bY() == null) || (this.this$0.a.bY().size() <= paramInt) || (this.this$0.a.bY().get(paramInt) == null)) {
          break label378;
        }
      }
    } while (!(this.this$0.a.bY().get(paramInt) instanceof qwc));
    paramView = (qwc)this.this$0.a.bY().get(paramInt);
    paramObject = new ArrayList();
    paramqyd = paramView.bS().iterator();
    paramInt = 0;
    label175:
    if (paramqyd.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramqyd.next();
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
      paramView = ((qwa)this.this$0.a.bY().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        qev.a(qyk.a(this.this$0), ((TagFeedItem)paramView).tagItem.a);
        return;
      }
      ram.e("Q.qqstory.home:FeedSegment", "why tagFeedItem is null?");
      return;
      if (paramObject.size() > 0) {
        pnx.a(paramObject, qyk.a(this.this$0));
      }
      if (this.this$0.a.bY().size() <= 0) {
        break;
      }
      rar.a("home_page", "clk_retry", rar.a(paramView.c()), 0, new String[] { "1", rar.bX(this.this$0.mFeedType), String.valueOf(paramInt), paramView.c().feedId });
      return;
      label378:
      ram.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      paramView = ((qwa)this.this$0.a.bY().get(paramInt)).a();
      if ((paramView == null) || (!(paramView instanceof TagFeedItem))) {
        break;
      }
      paramView = (TagFeedItem)paramView;
      if (!TextUtils.isEmpty(paramView.schema))
      {
        paramObject = new Intent(qyk.b(this.this$0), QQBrowserActivity.class);
        paramObject.putExtra("url", paramView.schema);
        qyk.c(this.this$0).startActivity(paramObject);
      }
      for (;;)
      {
        rar.a("home_page", "clk_more_tag", 0, 0, new String[] { "", String.valueOf(paramView.tagItem.a.id) });
        return;
        ram.e("Q.qqstory.home:FeedSegment", "tag schema is null.");
      }
      qyk.a(this.this$0, paramInt);
      return;
      paramView = ((qwa)this.this$0.a.bY().get(paramInt)).a();
      if ((paramView != null) && ((paramView instanceof TagFeedItem)))
      {
        paramView = ((TagFeedItem)paramView).tagItem.toJSONString();
        if (paramView == null) {
          break label635;
        }
        paramObject = new Intent(qyk.d(this.this$0), StoryTransitionActivity.class);
        paramObject.putExtra("jump_action", 1);
        paramObject.putExtra("video_tag", paramView);
        qyk.e(this.this$0).startActivity(paramObject);
      }
      for (;;)
      {
        rar.a("home_page", "tag_clk_join", 0, 0, new String[0]);
        return;
        label635:
        ram.e("Q.qqstory.home:FeedSegment", "click tag, tag is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qyw
 * JD-Core Version:    0.7.0.1
 */