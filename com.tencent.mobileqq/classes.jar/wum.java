import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class wum
  extends wrj
{
  wum(wub paramwub) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if (xsm.b()) {}
    Object localObject;
    label548:
    label554:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131362068: 
          case 2131373743: 
            for (;;)
            {
              paramObject = (wqn)this.a.jdField_a_of_type_Wpr.a().get(paramInt);
              if (paramObject == wub.a(this.a))
              {
                wub.a(this.a, null);
                wub.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof wpg)) {
                break;
              }
              paramView = (wpg)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Wpr.a().get(paramInt) instanceof wpg)) {
                wxj.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Wpr.a().get(paramInt) instanceof wqm)) {
                wxj.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof wqm))
            {
              paramView = ((ShareGroupFeedItem)((wqm)paramObject).a()).getOwner();
              wub.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof wph));
        if (!xrn.a(wub.a(this.a)))
        {
          QQToast.a(wub.a(this.a), 1, alud.a(2131704854), 0).a();
          return;
        }
        paramObject = (wph)paramObject;
        localObject = paramObject.a().getOwner();
        ((ult)vls.a().a(98)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramwtq.a(2131373769)).setVisibility(8);
        wxj.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramwtq = ((wqn)this.a.jdField_a_of_type_Wpr.a().get(paramInt)).a();
        localObject = paramwtq.getOwner();
        paramInt = wxj.a(paramwtq);
        i = wxj.b(paramwtq);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((uxe)localObject).getUnionId();; paramObject = "")
        {
          wxj.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramwtq.feedId, paramObject });
          if (!((uxe)localObject).isMe()) {
            break label554;
          }
          uqn.a(wub.a(this.a), 4, paramwtq.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((uxe)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramwtq instanceof GeneralFeedItem)) || ((paramwtq instanceof GeneralRecommendFeedItem)))
          {
            uqn.a(wub.a(this.a), 4, ((uxe)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramwtq instanceof ShareGroupFeedItem));
      paramView = ((uxe)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        wxe.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramwtq.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(wub.a(this.a), 2, paramView, null, paramInt, 74);
        return;
      }
      for (;;)
      {
        try
        {
          if (!(localObject instanceof ShareGroupItem)) {
            break;
          }
          if (this.a.jdField_a_of_type_Int != 10) {
            break label776;
          }
          paramInt = 1;
          if (this.a.jdField_a_of_type_Int != 10) {
            break label782;
          }
          i = 88;
          QQStoryShareGroupProfileActivity.a(wub.a(this.a), 1, ((uxe)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
          return;
        }
        catch (NumberFormatException paramView) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.qqstory.home:FeedSegment", 2, "troopId error ", paramView);
        return;
        paramInt = 9;
        continue;
        i = 76;
      }
      if ((this.a.jdField_a_of_type_Wpr.a() == null) || (this.a.jdField_a_of_type_Wpr.a().size() <= paramInt) || (this.a.jdField_a_of_type_Wpr.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Wpr.a().get(paramInt) instanceof wqp));
    label776:
    label782:
    paramView = (wqp)this.a.jdField_a_of_type_Wpr.a().get(paramInt);
    paramObject = new ArrayList();
    paramwtq = paramView.a().iterator();
    paramInt = 0;
    label903:
    if (paramwtq.hasNext())
    {
      localObject = (StoryVideoItem)paramwtq.next();
      if (!((StoryVideoItem)localObject).isUploadFail()) {
        break label1061;
      }
      paramObject.add(localObject);
      paramInt += 1;
    }
    label1061:
    for (;;)
    {
      break label903;
      if (paramObject.size() > 0) {
        uom.a(paramObject, wub.a(this.a));
      }
      if (this.a.jdField_a_of_type_Wpr.a().size() <= 0) {
        break;
      }
      wxj.a("home_page", "clk_retry", wxj.a(paramView.a()), 0, new String[] { "1", wxj.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      wxe.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      wub.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wum
 * JD-Core Version:    0.7.0.1
 */