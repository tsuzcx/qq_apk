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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class xtd
  extends xqa
{
  xtd(xss paramxss) {}
  
  public void a(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if (UIUtils.isFastDoubleClick()) {}
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
          case 2131362134: 
          case 2131374351: 
            for (;;)
            {
              paramObject = (xpe)this.a.jdField_a_of_type_Xoi.a().get(paramInt);
              if (paramObject == xss.a(this.a))
              {
                xss.a(this.a, null);
                xss.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof xnx)) {
                break;
              }
              paramView = (xnx)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Xoi.a().get(paramInt) instanceof xnx)) {
                xwa.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Xoi.a().get(paramInt) instanceof xpd)) {
                xwa.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof xpd))
            {
              paramView = ((ShareGroupFeedItem)((xpd)paramObject).a()).getOwner();
              xss.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof xny));
        if (!ypp.a(xss.a(this.a)))
        {
          QQToast.a(xss.a(this.a), 1, amtj.a(2131703588), 0).a();
          return;
        }
        paramObject = (xny)paramObject;
        localObject = paramObject.a().getOwner();
        ((vkz)wkp.a().getBusinessHandler(98)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramxsh.a(2131374377)).setVisibility(8);
        xwa.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramxsh = ((xpe)this.a.jdField_a_of_type_Xoi.a().get(paramInt)).a();
        localObject = paramxsh.getOwner();
        paramInt = xwa.a(paramxsh);
        i = xwa.b(paramxsh);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((vwb)localObject).getUnionId();; paramObject = "")
        {
          xwa.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramxsh.feedId, paramObject });
          if (!((vwb)localObject).isMe()) {
            break label554;
          }
          vpl.a(xss.a(this.a), 4, paramxsh.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((vwb)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramxsh instanceof GeneralFeedItem)) || ((paramxsh instanceof GeneralRecommendFeedItem)))
          {
            vpl.a(xss.a(this.a), 4, ((vwb)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramxsh instanceof ShareGroupFeedItem));
      paramView = ((vwb)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        xvv.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramxsh.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(xss.a(this.a), 2, paramView, null, paramInt, 74);
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
          QQStoryShareGroupProfileActivity.a(xss.a(this.a), 1, ((vwb)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.a.jdField_a_of_type_Xoi.a() == null) || (this.a.jdField_a_of_type_Xoi.a().size() <= paramInt) || (this.a.jdField_a_of_type_Xoi.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Xoi.a().get(paramInt) instanceof xpg));
    label776:
    label782:
    paramView = (xpg)this.a.jdField_a_of_type_Xoi.a().get(paramInt);
    paramObject = new ArrayList();
    paramxsh = paramView.a().iterator();
    paramInt = 0;
    label903:
    if (paramxsh.hasNext())
    {
      localObject = (StoryVideoItem)paramxsh.next();
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
        vns.a(paramObject, xss.a(this.a));
      }
      if (this.a.jdField_a_of_type_Xoi.a().size() <= 0) {
        break;
      }
      xwa.a("home_page", "clk_retry", xwa.a(paramView.a()), 0, new String[] { "1", xwa.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      xvv.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      xss.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtd
 * JD-Core Version:    0.7.0.1
 */