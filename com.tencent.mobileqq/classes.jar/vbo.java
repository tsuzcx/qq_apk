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

class vbo
  extends uyl
{
  vbo(vbd paramvbd) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if (vzo.b()) {}
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
          case 2131362066: 
          case 2131373241: 
            for (;;)
            {
              paramObject = (uxp)this.a.jdField_a_of_type_Uwt.a().get(paramInt);
              if (paramObject == vbd.a(this.a))
              {
                vbd.a(this.a, null);
                vbd.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof uwi)) {
                break;
              }
              paramView = (uwi)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Uwt.a().get(paramInt) instanceof uwi)) {
                vel.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Uwt.a().get(paramInt) instanceof uxo)) {
                vel.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof uxo))
            {
              paramView = ((ShareGroupFeedItem)((uxo)paramObject).a()).getOwner();
              vbd.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof uwj));
        if (!vyp.a(vbd.a(this.a)))
        {
          bcpw.a(vbd.a(this.a), 1, ajyc.a(2131704459), 0).a();
          return;
        }
        paramObject = (uwj)paramObject;
        localObject = paramObject.a().getOwner();
        ((ssv)tsu.a().a(98)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramvas.a(2131373267)).setVisibility(8);
        vel.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramvas = ((uxp)this.a.jdField_a_of_type_Uwt.a().get(paramInt)).a();
        localObject = paramvas.getOwner();
        paramInt = vel.a(paramvas);
        i = vel.b(paramvas);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((teg)localObject).getUnionId();; paramObject = "")
        {
          vel.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramvas.feedId, paramObject });
          if (!((teg)localObject).isMe()) {
            break label554;
          }
          sxp.a(vbd.a(this.a), 4, paramvas.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((teg)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramvas instanceof GeneralFeedItem)) || ((paramvas instanceof GeneralRecommendFeedItem)))
          {
            sxp.a(vbd.a(this.a), 4, ((teg)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramvas instanceof ShareGroupFeedItem));
      paramView = ((teg)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        veg.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramvas.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(vbd.a(this.a), 2, paramView, null, paramInt, 74);
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
          QQStoryShareGroupProfileActivity.a(vbd.a(this.a), 1, ((teg)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.a.jdField_a_of_type_Uwt.a() == null) || (this.a.jdField_a_of_type_Uwt.a().size() <= paramInt) || (this.a.jdField_a_of_type_Uwt.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Uwt.a().get(paramInt) instanceof uxr));
    label776:
    label782:
    paramView = (uxr)this.a.jdField_a_of_type_Uwt.a().get(paramInt);
    paramObject = new ArrayList();
    paramvas = paramView.a().iterator();
    paramInt = 0;
    label903:
    if (paramvas.hasNext())
    {
      localObject = (StoryVideoItem)paramvas.next();
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
        svo.a(paramObject, vbd.a(this.a));
      }
      if (this.a.jdField_a_of_type_Uwt.a().size() <= 0) {
        break;
      }
      vel.a("home_page", "clk_retry", vel.a(paramView.a()), 0, new String[] { "1", vel.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      veg.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      vbd.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbo
 * JD-Core Version:    0.7.0.1
 */