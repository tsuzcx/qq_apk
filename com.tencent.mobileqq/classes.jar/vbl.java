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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class vbl
  extends uyi
{
  vbl(vba paramvba) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if (vzl.b()) {}
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
          case 2131362065: 
          case 2131373243: 
            for (;;)
            {
              paramObject = (uxm)this.a.jdField_a_of_type_Uwq.a().get(paramInt);
              if (paramObject == vba.a(this.a))
              {
                vba.a(this.a, null);
                vba.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof uwf)) {
                break;
              }
              paramView = (uwf)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Uwq.a().get(paramInt) instanceof uwf)) {
                vei.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Uwq.a().get(paramInt) instanceof uxl)) {
                vei.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof uxl))
            {
              paramView = ((ShareGroupFeedItem)((uxl)paramObject).a()).getOwner();
              vba.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof uwg));
        if (!vym.a(vba.a(this.a)))
        {
          bcql.a(vba.a(this.a), 1, ajya.a(2131704470), 0).a();
          return;
        }
        paramObject = (uwg)paramObject;
        localObject = paramObject.a().getOwner();
        ((sss)tsr.a().a(98)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramvap.a(2131373269)).setVisibility(8);
        vei.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramvap = ((uxm)this.a.jdField_a_of_type_Uwq.a().get(paramInt)).a();
        localObject = paramvap.getOwner();
        paramInt = vei.a(paramvap);
        i = vei.b(paramvap);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((ted)localObject).getUnionId();; paramObject = "")
        {
          vei.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramvap.feedId, paramObject });
          if (!((ted)localObject).isMe()) {
            break label554;
          }
          sxm.a(vba.a(this.a), 4, paramvap.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((ted)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramvap instanceof GeneralFeedItem)) || ((paramvap instanceof GeneralRecommendFeedItem)))
          {
            sxm.a(vba.a(this.a), 4, ((ted)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramvap instanceof ShareGroupFeedItem));
      paramView = ((ted)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        ved.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramvap.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(vba.a(this.a), 2, paramView, null, paramInt, 74);
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
          QQStoryShareGroupProfileActivity.a(vba.a(this.a), 1, ((ted)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.a.jdField_a_of_type_Uwq.a() == null) || (this.a.jdField_a_of_type_Uwq.a().size() <= paramInt) || (this.a.jdField_a_of_type_Uwq.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Uwq.a().get(paramInt) instanceof uxo));
    label776:
    label782:
    paramView = (uxo)this.a.jdField_a_of_type_Uwq.a().get(paramInt);
    paramObject = new ArrayList();
    paramvap = paramView.a().iterator();
    paramInt = 0;
    label903:
    if (paramvap.hasNext())
    {
      localObject = (StoryVideoItem)paramvap.next();
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
        svl.a(paramObject, vba.a(this.a));
      }
      if (this.a.jdField_a_of_type_Uwq.a().size() <= 0) {
        break;
      }
      vei.a("home_page", "clk_retry", vei.a(paramView.a()), 0, new String[] { "1", vei.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      ved.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      vba.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbl
 * JD-Core Version:    0.7.0.1
 */