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

class ynw
  extends yku
{
  ynw(ynm paramynm) {}
  
  public void a(int paramInt, View paramView, Object paramObject, ynb paramynb)
  {
    if (paramView.getVisibility() != 0) {}
    while (zlx.b()) {
      return;
    }
    paramynb = (yhs)this.a.jdField_a_of_type_Yjc.a().get(paramInt);
    paramObject = (BannerFeedItem)paramynb.a();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362128: 
      if (!zky.a(ynm.a(this.a)))
      {
        QQToast.a(ynm.a(this.a), 1, anni.a(2131703265), 0).a();
        return;
      }
    case 2131374459: 
      wjz.a(ynm.a(this.a), 4, paramObject.getOwner().getUnionId());
      paramInt = yqu.a(paramObject);
      int i = yqu.b(paramObject);
      if (this.a.jdField_a_of_type_Int == 11) {}
      for (paramView = "3";; paramView = "1")
      {
        yqu.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramObject.feedId, "" });
        return;
      }
    case 2131374421: 
    case 2131374429: 
      String str1 = paramObject.getOwner().getUnionId();
      String str2 = paramObject.feedId;
      if (paramView.getId() == 2131374421) {}
      for (paramView = "1";; paramView = "2")
      {
        yqu.a("home_page", "clk_ac_card", 0, 0, new String[] { paramView, "", str1, str2 });
        if (!TextUtils.isEmpty(paramObject.schema)) {
          break;
        }
        yqp.e("Q.qqstory.home:FeedSegment", "The schema url is null!!");
        return;
      }
      yqp.a("Q.qqstory.home:FeedSegment", "click banner feed and jump to %s", paramObject.schema);
      if (((BannerFeedItem)paramynb.a()).schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bgng.a((QQAppInterface)QQStoryContext.a(), ynm.a(this.a), paramObject.schema).a();
        return;
      }
      if (!zky.a(ynm.a(this.a)))
      {
        QQToast.a(ynm.a(this.a), 1, anni.a(2131703259), 0).a();
        return;
      }
      paramView = new Intent(ynm.a(this.a), QQBrowserActivity.class);
      paramView.putExtra("url", paramObject.schema);
      ynm.a(this.a).startActivity(paramView);
      return;
      paramObject = ((BannerFeedItem)paramynb.a()).getOwner();
      ((wff)xfe.a().a(98)).a(1, paramObject.getUnionId(), 0, 12);
      paramView.setVisibility(8);
      yqu.a("home_page", "follow_recom", 0, 0, new String[] { "3", "1", paramObject.getUnionId(), ((BannerFeedItem)paramynb.a()).feedId });
      return;
    }
    ynm.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynw
 * JD-Core Version:    0.7.0.1
 */