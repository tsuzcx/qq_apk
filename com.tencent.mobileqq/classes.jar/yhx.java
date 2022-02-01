import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class yhx
  extends yev
{
  yhx(yhn paramyhn) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if (paramView.getVisibility() != 0) {}
    while (UIUtils.isFastDoubleClick()) {
      return;
    }
    paramyhc = (ybt)this.a.jdField_a_of_type_Ydd.a().get(paramInt);
    paramObject = (BannerFeedItem)paramyhc.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362138: 
      if (!zei.a(yhn.a(this.a)))
      {
        QQToast.a(yhn.a(this.a), 1, anvx.a(2131703953), 0).a();
        return;
      }
    case 2131374602: 
      weg.a(yhn.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = ykv.a(paramObject);
      int i = ykv.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        ykv.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131374564: 
    case 2131374572: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131374564) {}
      for (paramView = "1";; paramView = "2")
      {
        ykv.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        ykq.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      ykq.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramyhc.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bhey.a((QQAppInterface)QQStoryContext.a(), yhn.a(this.a), paramObject.schema).a();
        return;
      }
      if (!zei.a(yhn.a(this.a)))
      {
        QQToast.a(yhn.a(this.a), 1, anvx.a(2131703947), 0).a();
        return;
      }
      paramView = new Intent(yhn.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      yhn.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramyhc.a()).getOwner();
      ((vzu)wzk.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      ykv.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramyhc.a()).feedId });
      return;
    }
    yhn.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhx
 * JD-Core Version:    0.7.0.1
 */