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

class vbk
  extends uyi
{
  vbk(vba paramvba) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if (paramView.getVisibility() != 0) {}
    while (vzl.b()) {
      return;
    }
    paramvap = (uvg)this.a.jdField_a_of_type_Uwq.a().get(paramInt);
    paramObject = (BannerFeedItem)paramvap.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362065: 
      if (!vym.a(vba.a(this.a)))
      {
        bcql.a(vba.a(this.a), 1, ajya.a(2131704484), 0).a();
        return;
      }
    case 2131373256: 
      sxm.a(vba.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = vei.a(paramObject);
      int i = vei.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        vei.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131373218: 
    case 2131373226: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131373218) {}
      for (paramView = "1";; paramView = "2")
      {
        vei.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        ved.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      ved.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramvap.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bbex.a((QQAppInterface)QQStoryContext.a(), vba.a(this.a), paramObject.schema).c();
        return;
      }
      if (!vym.a(vba.a(this.a)))
      {
        bcql.a(vba.a(this.a), 1, ajya.a(2131704478), 0).a();
        return;
      }
      paramView = new Intent(vba.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      vba.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramvap.a()).getOwner();
      ((sss)tsr.a().a(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      vei.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramvap.a()).feedId });
      return;
    }
    vba.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbk
 * JD-Core Version:    0.7.0.1
 */