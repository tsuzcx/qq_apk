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

class ynx
  extends yku
{
  ynx(ynm paramynm) {}
  
  public void a(int paramInt, View paramView, Object paramObject, ynb paramynb)
  {
    if (zlx.b()) {}
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
          case 2131362128: 
          case 2131374446: 
            for (;;)
            {
              paramObject = (yjy)this.a.jdField_a_of_type_Yjc.a().get(paramInt);
              if (paramObject == ynm.a(this.a))
              {
                ynm.a(this.a, null);
                ynm.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof yir)) {
                break;
              }
              paramView = (yir)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Yjc.a().get(paramInt) instanceof yir)) {
                yqu.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Yjc.a().get(paramInt) instanceof yjx)) {
                yqu.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof yjx))
            {
              paramView = ((ShareGroupFeedItem)((yjx)paramObject).a()).getOwner();
              ynm.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof yis));
        if (!zky.a(ynm.a(this.a)))
        {
          QQToast.a(ynm.a(this.a), 1, anni.a(2131703251), 0).a();
          return;
        }
        paramObject = (yis)paramObject;
        localObject = paramObject.a().getOwner();
        ((wff)xfe.a().a(98)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramynb.a(2131374472)).setVisibility(8);
        yqu.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramynb = ((yjy)this.a.jdField_a_of_type_Yjc.a().get(paramInt)).a();
        localObject = paramynb.getOwner();
        paramInt = yqu.a(paramynb);
        i = yqu.b(paramynb);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((wqq)localObject).getUnionId();; paramObject = "")
        {
          yqu.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramynb.feedId, paramObject });
          if (!((wqq)localObject).isMe()) {
            break label554;
          }
          wjz.a(ynm.a(this.a), 4, paramynb.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((wqq)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramynb instanceof GeneralFeedItem)) || ((paramynb instanceof GeneralRecommendFeedItem)))
          {
            wjz.a(ynm.a(this.a), 4, ((wqq)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramynb instanceof ShareGroupFeedItem));
      paramView = ((wqq)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        yqp.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramynb.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(ynm.a(this.a), 2, paramView, null, paramInt, 74);
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
          QQStoryShareGroupProfileActivity.a(ynm.a(this.a), 1, ((wqq)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.a.jdField_a_of_type_Yjc.a() == null) || (this.a.jdField_a_of_type_Yjc.a().size() <= paramInt) || (this.a.jdField_a_of_type_Yjc.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Yjc.a().get(paramInt) instanceof yka));
    label776:
    label782:
    paramView = (yka)this.a.jdField_a_of_type_Yjc.a().get(paramInt);
    paramObject = new ArrayList();
    paramynb = paramView.a().iterator();
    paramInt = 0;
    label903:
    if (paramynb.hasNext())
    {
      localObject = (StoryVideoItem)paramynb.next();
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
        why.a(paramObject, ynm.a(this.a));
      }
      if (this.a.jdField_a_of_type_Yjc.a().size() <= 0) {
        break;
      }
      yqu.a("home_page", "clk_retry", yqu.a(paramView.a()), 0, new String[] { "1", yqu.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      yqp.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      ynm.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynx
 * JD-Core Version:    0.7.0.1
 */