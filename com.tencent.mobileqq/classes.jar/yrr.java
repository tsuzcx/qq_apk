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

class yrr
  extends yop
{
  yrr(yrh paramyrh) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yqw paramyqw)
  {
    if (paramView.getVisibility() != 0) {}
    while (zps.b()) {
      return;
    }
    paramyqw = (yln)this.a.jdField_a_of_type_Ymx.a().get(paramInt);
    paramObject = (BannerFeedItem)paramyqw.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362134: 
      if (!zot.a(yrh.a(this.a)))
      {
        QQToast.a(yrh.a(this.a), 1, anzj.a(2131703372), 0).a();
        return;
      }
    case 2131374596: 
      wnu.a(yrh.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = yup.a(paramObject);
      int i = yup.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        yup.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131374558: 
    case 2131374566: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131374558) {}
      for (paramView = "1";; paramView = "2")
      {
        yup.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        yuk.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      yuk.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramyqw.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bhni.a((QQAppInterface)QQStoryContext.a(), yrh.a(this.a), paramObject.schema).a();
        return;
      }
      if (!zot.a(yrh.a(this.a)))
      {
        QQToast.a(yrh.a(this.a), 1, anzj.a(2131703366), 0).a();
        return;
      }
      paramView = new Intent(yrh.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      yrh.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramyqw.a()).getOwner();
      ((wja)xiz.a().a(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      yup.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramyqw.a()).feedId });
      return;
    }
    yrh.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrr
 * JD-Core Version:    0.7.0.1
 */