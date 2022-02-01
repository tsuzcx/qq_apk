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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class yhy
  extends yev
{
  yhy(yhn paramyhn) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if (UIUtils.isFastDoubleClick()) {}
    Object localObject;
    label549:
    label555:
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
          case 2131362138: 
          case 2131374589: 
            for (;;)
            {
              paramObject = (ydz)this.a.jdField_a_of_type_Ydd.a().get(paramInt);
              if (paramObject == yhn.a(this.a))
              {
                yhn.a(this.a, null);
                yhn.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof ycs)) {
                break;
              }
              paramView = (ycs)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Ydd.a().get(paramInt) instanceof ycs)) {
                ykv.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Ydd.a().get(paramInt) instanceof ydy)) {
                ykv.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof ydy))
            {
              paramView = ((ShareGroupFeedItem)((ydy)paramObject).a()).getOwner();
              yhn.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof yct));
        if (!zei.a(yhn.a(this.a)))
        {
          QQToast.a(yhn.a(this.a), 1, anvx.a(2131703939), 0).a();
          return;
        }
        paramObject = (yct)paramObject;
        localObject = paramObject.a().getOwner();
        ((vzu)wzk.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramyhc.a(2131374615)).setVisibility(8);
        ykv.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramyhc = ((ydz)this.a.jdField_a_of_type_Ydd.a().get(paramInt)).a();
        localObject = paramyhc.getOwner();
        paramInt = ykv.a(paramyhc);
        i = ykv.b(paramyhc);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label549;
          }
        }
        for (paramObject = ((wkw)localObject).getUnionId();; paramObject = "")
        {
          ykv.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramyhc.feedId, paramObject });
          if (!((wkw)localObject).isMe()) {
            break label555;
          }
          weg.a(yhn.a(this.a), 4, paramyhc.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((wkw)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramyhc instanceof GeneralFeedItem)) || ((paramyhc instanceof GeneralRecommendFeedItem)))
          {
            weg.a(yhn.a(this.a), 4, ((wkw)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramyhc instanceof ShareGroupFeedItem));
      paramView = ((wkw)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        ykq.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramyhc.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(yhn.a(this.a), 2, paramView, null, paramInt, 74);
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
            break label777;
          }
          paramInt = 1;
          if (this.a.jdField_a_of_type_Int != 10) {
            break label783;
          }
          i = 88;
          QQStoryShareGroupProfileActivity.a(yhn.a(this.a), 1, ((wkw)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.a.jdField_a_of_type_Ydd.a() == null) || (this.a.jdField_a_of_type_Ydd.a().size() <= paramInt) || (this.a.jdField_a_of_type_Ydd.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Ydd.a().get(paramInt) instanceof yeb));
    label777:
    label783:
    paramView = (yeb)this.a.jdField_a_of_type_Ydd.a().get(paramInt);
    paramObject = new ArrayList();
    paramyhc = paramView.a().iterator();
    paramInt = 0;
    label904:
    if (paramyhc.hasNext())
    {
      localObject = (StoryVideoItem)paramyhc.next();
      if (!((StoryVideoItem)localObject).isUploadFail()) {
        break label1062;
      }
      paramObject.add(localObject);
      paramInt += 1;
    }
    label1062:
    for (;;)
    {
      break label904;
      if (paramObject.size() > 0) {
        wcn.a(paramObject, yhn.a(this.a));
      }
      if (this.a.jdField_a_of_type_Ydd.a().size() <= 0) {
        break;
      }
      ykv.a("home_page", "clk_retry", ykv.a(paramView.a()), 0, new String[] { "1", ykv.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      ykq.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      yhn.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhy
 * JD-Core Version:    0.7.0.1
 */