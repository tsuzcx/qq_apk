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

class vbn
  extends uyl
{
  vbn(vbd paramvbd) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if (paramView.getVisibility() != 0) {}
    while (vzo.b()) {
      return;
    }
    paramvas = (uvj)this.a.jdField_a_of_type_Uwt.a().get(paramInt);
    paramObject = (BannerFeedItem)paramvas.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362066: 
      if (!vyp.a(vbd.a(this.a)))
      {
        bcpw.a(vbd.a(this.a), 1, ajyc.a(2131704473), 0).a();
        return;
      }
    case 2131373254: 
      sxp.a(vbd.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = vel.a(paramObject);
      int i = vel.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        vel.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131373216: 
    case 2131373224: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131373216) {}
      for (paramView = "1";; paramView = "2")
      {
        vel.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        veg.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      veg.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramvas.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bbej.a((QQAppInterface)QQStoryContext.a(), vbd.a(this.a), paramObject.schema).c();
        return;
      }
      if (!vyp.a(vbd.a(this.a)))
      {
        bcpw.a(vbd.a(this.a), 1, ajyc.a(2131704467), 0).a();
        return;
      }
      paramView = new Intent(vbd.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      vbd.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramvas.a()).getOwner();
      ((ssv)tsu.a().a(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      vel.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramvas.a()).feedId });
      return;
    }
    vbd.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbn
 * JD-Core Version:    0.7.0.1
 */