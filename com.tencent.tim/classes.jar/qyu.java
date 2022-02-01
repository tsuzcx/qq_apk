import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class qyu
  extends qwo
{
  qyu(qyk paramqyk) {}
  
  public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
  {
    if (paramView.getVisibility() != 0) {}
    while (rpq.isFastDoubleClick()) {
      return;
    }
    paramqyd = (quw)this.this$0.a.bY().get(paramInt);
    paramObject = (BannerFeedItem)paramqyd.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362166: 
      if (!rpc.hasInternet(qyk.a(this.this$0)))
      {
        QQToast.a(qyk.a(this.this$0), 1, acfp.m(2131706196), 0).show();
        return;
      }
    case 2131375138: 
      ppf.f(qyk.a(this.this$0), 4, paramObject.getOwner().getUnionId());
      paramInt = rar.a(paramObject);
      int i = rar.b(paramObject);
      if (this.this$0.mFeedType == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        rar.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131375100: 
    case 2131375108: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131375100) {}
      for (paramView = "1";; paramView = "2")
      {
        rar.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        ram.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      ram.b("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramqyd.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        aqik.c((QQAppInterface)QQStoryContext.c(), qyk.a(this.this$0), paramObject.schema).ace();
        return;
      }
      if (!rpc.hasInternet(qyk.a(this.this$0)))
      {
        QQToast.a(qyk.a(this.this$0), 1, acfp.m(2131706190), 0).show();
        return;
      }
      paramView = new Intent(qyk.a(this.this$0), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      qyk.a(this.this$0).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramqyd.a()).getOwner();
      ((pma)qem.getQQAppInterface().getBusinessHandler(98)).b(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      rar.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramqyd.a()).feedId });
      return;
    }
    qyk.a(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qyu
 * JD-Core Version:    0.7.0.1
 */