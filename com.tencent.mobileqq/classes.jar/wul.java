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

class wul
  extends wrj
{
  wul(wub paramwub) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if (paramView.getVisibility() != 0) {}
    while (xsm.b()) {
      return;
    }
    paramwtq = (woh)this.a.jdField_a_of_type_Wpr.a().get(paramInt);
    paramObject = (BannerFeedItem)paramwtq.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362068: 
      if (!xrn.a(wub.a(this.a)))
      {
        QQToast.a(wub.a(this.a), 1, alud.a(2131704868), 0).a();
        return;
      }
    case 2131373756: 
      uqn.a(wub.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = wxj.a(paramObject);
      int i = wxj.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        wxj.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131373718: 
    case 2131373726: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131373718) {}
      for (paramView = "1";; paramView = "2")
      {
        wxj.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        wxe.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      wxe.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramwtq.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bdib.a((QQAppInterface)QQStoryContext.a(), wub.a(this.a), paramObject.schema).c();
        return;
      }
      if (!xrn.a(wub.a(this.a)))
      {
        QQToast.a(wub.a(this.a), 1, alud.a(2131704862), 0).a();
        return;
      }
      paramView = new Intent(wub.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      wub.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramwtq.a()).getOwner();
      ((ult)vls.a().a(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      wxj.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramwtq.a()).feedId });
      return;
    }
    wub.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wul
 * JD-Core Version:    0.7.0.1
 */