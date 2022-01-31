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

class wqc
  extends wna
{
  wqc(wps paramwps) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    if (paramView.getVisibility() != 0) {}
    while (xod.b()) {
      return;
    }
    paramwph = (wjy)this.a.jdField_a_of_type_Wli.a().get(paramInt);
    paramObject = (BannerFeedItem)paramwph.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362068: 
      if (!xne.a(wps.a(this.a)))
      {
        QQToast.a(wps.a(this.a), 1, alpo.a(2131704856), 0).a();
        return;
      }
    case 2131373705: 
      ume.a(wps.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = wta.a(paramObject);
      int i = wta.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        wta.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131373667: 
    case 2131373675: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131373667) {}
      for (paramView = "1";; paramView = "2")
      {
        wta.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        wsv.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      wsv.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramwph.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bdds.a((QQAppInterface)QQStoryContext.a(), wps.a(this.a), paramObject.schema).c();
        return;
      }
      if (!xne.a(wps.a(this.a)))
      {
        QQToast.a(wps.a(this.a), 1, alpo.a(2131704850), 0).a();
        return;
      }
      paramView = new Intent(wps.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      wps.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramwph.a()).getOwner();
      ((uhk)vhj.a().a(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      wta.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramwph.a()).feedId });
      return;
    }
    wps.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqc
 * JD-Core Version:    0.7.0.1
 */