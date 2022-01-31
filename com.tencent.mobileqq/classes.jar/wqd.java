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

class wqd
  extends wna
{
  wqd(wps paramwps) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    if (xod.b()) {}
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
          case 2131373692: 
            for (;;)
            {
              paramObject = (wme)this.a.jdField_a_of_type_Wli.a().get(paramInt);
              if (paramObject == wps.a(this.a))
              {
                wps.a(this.a, null);
                wps.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof wkx)) {
                break;
              }
              paramView = (wkx)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Wli.a().get(paramInt) instanceof wkx)) {
                wta.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Wli.a().get(paramInt) instanceof wmd)) {
                wta.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof wmd))
            {
              paramView = ((ShareGroupFeedItem)((wmd)paramObject).a()).getOwner();
              wps.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof wky));
        if (!xne.a(wps.a(this.a)))
        {
          QQToast.a(wps.a(this.a), 1, alpo.a(2131704842), 0).a();
          return;
        }
        paramObject = (wky)paramObject;
        localObject = paramObject.a().getOwner();
        ((uhk)vhj.a().a(98)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramwph.a(2131373718)).setVisibility(8);
        wta.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramwph = ((wme)this.a.jdField_a_of_type_Wli.a().get(paramInt)).a();
        localObject = paramwph.getOwner();
        paramInt = wta.a(paramwph);
        i = wta.b(paramwph);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((usv)localObject).getUnionId();; paramObject = "")
        {
          wta.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramwph.feedId, paramObject });
          if (!((usv)localObject).isMe()) {
            break label554;
          }
          ume.a(wps.a(this.a), 4, paramwph.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((usv)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramwph instanceof GeneralFeedItem)) || ((paramwph instanceof GeneralRecommendFeedItem)))
          {
            ume.a(wps.a(this.a), 4, ((usv)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramwph instanceof ShareGroupFeedItem));
      paramView = ((usv)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        wsv.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramwph.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(wps.a(this.a), 2, paramView, null, paramInt, 74);
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
          QQStoryShareGroupProfileActivity.a(wps.a(this.a), 1, ((usv)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.a.jdField_a_of_type_Wli.a() == null) || (this.a.jdField_a_of_type_Wli.a().size() <= paramInt) || (this.a.jdField_a_of_type_Wli.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Wli.a().get(paramInt) instanceof wmg));
    label776:
    label782:
    paramView = (wmg)this.a.jdField_a_of_type_Wli.a().get(paramInt);
    paramObject = new ArrayList();
    paramwph = paramView.a().iterator();
    paramInt = 0;
    label903:
    if (paramwph.hasNext())
    {
      localObject = (StoryVideoItem)paramwph.next();
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
        ukd.a(paramObject, wps.a(this.a));
      }
      if (this.a.jdField_a_of_type_Wli.a().size() <= 0) {
        break;
      }
      wta.a("home_page", "clk_retry", wta.a(paramView.a()), 0, new String[] { "1", wta.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      wsv.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      wps.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqd
 * JD-Core Version:    0.7.0.1
 */