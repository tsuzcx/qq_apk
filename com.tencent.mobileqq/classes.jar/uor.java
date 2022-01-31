import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class uor
  extends ulp
{
  uor(uoh paramuoh) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if (paramView.getVisibility() != 0) {}
    while (vms.b()) {
      return;
    }
    paramunw = (uin)this.a.jdField_a_of_type_Ujx.a().get(paramInt);
    paramObject = (BannerFeedItem)paramunw.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296525: 
      if (!vlt.a(uoh.a(this.a)))
      {
        bbmy.a(uoh.a(this.a), 1, ajjy.a(2131638688), 0).a();
        return;
      }
    case 2131307541: 
      skt.a(uoh.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = urp.a(paramObject);
      int i = urp.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        urp.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131307503: 
    case 2131307511: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131307503) {}
      for (paramView = "1";; paramView = "2")
      {
        urp.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        urk.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      urk.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramunw.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bade.a((QQAppInterface)QQStoryContext.a(), uoh.a(this.a), paramObject.schema).c();
        return;
      }
      if (!vlt.a(uoh.a(this.a)))
      {
        bbmy.a(uoh.a(this.a), 1, ajjy.a(2131638682), 0).a();
        return;
      }
      paramView = new Intent(uoh.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      uoh.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramunw.a()).getOwner();
      ((sfz)tfy.a().a(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      urp.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramunw.a()).feedId });
      return;
    }
    uoh.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uor
 * JD-Core Version:    0.7.0.1
 */