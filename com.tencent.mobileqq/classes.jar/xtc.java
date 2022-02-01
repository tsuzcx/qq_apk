import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class xtc
  extends xqa
{
  xtc(xss paramxss) {}
  
  public void a(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if (paramView.getVisibility() != 0) {}
    while (UIUtils.isFastDoubleClick()) {
      return;
    }
    paramxsh = (xmy)this.a.jdField_a_of_type_Xoi.a().get(paramInt);
    paramObject = (BannerFeedItem)paramxsh.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362134: 
      if (!ypp.a(xss.a(this.a)))
      {
        QQToast.a(xss.a(this.a), 1, amtj.a(2131703602), 0).a();
        return;
      }
    case 2131374364: 
      vpl.a(xss.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = xwa.a(paramObject);
      int i = xwa.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        xwa.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131374326: 
    case 2131374334: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131374326) {}
      for (paramView = "1";; paramView = "2")
      {
        xwa.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        xvv.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      xvv.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramxsh.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bfwg.a((QQAppInterface)QQStoryContext.a(), xss.a(this.a), paramObject.schema).a();
        return;
      }
      if (!ypp.a(xss.a(this.a)))
      {
        QQToast.a(xss.a(this.a), 1, amtj.a(2131703596), 0).a();
        return;
      }
      paramView = new Intent(xss.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      xss.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramxsh.a()).getOwner();
      ((vkz)wkp.a().getBusinessHandler(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      xwa.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramxsh.a()).feedId });
      return;
    }
    xss.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtc
 * JD-Core Version:    0.7.0.1
 */