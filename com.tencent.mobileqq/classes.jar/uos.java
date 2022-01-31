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

class uos
  extends ulp
{
  uos(uoh paramuoh) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if (vms.b()) {}
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
          case 2131296525: 
          case 2131307528: 
            for (;;)
            {
              paramObject = (ukt)this.a.jdField_a_of_type_Ujx.a().get(paramInt);
              if (paramObject == uoh.a(this.a))
              {
                uoh.a(this.a, null);
                uoh.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof ujm)) {
                break;
              }
              paramView = (ujm)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Ujx.a().get(paramInt) instanceof ujm)) {
                urp.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Ujx.a().get(paramInt) instanceof uks)) {
                urp.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof uks))
            {
              paramView = ((ShareGroupFeedItem)((uks)paramObject).a()).getOwner();
              uoh.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof ujn));
        if (!vlt.a(uoh.a(this.a)))
        {
          bbmy.a(uoh.a(this.a), 1, ajjy.a(2131638674), 0).a();
          return;
        }
        paramObject = (ujn)paramObject;
        localObject = paramObject.a().getOwner();
        ((sfz)tfy.a().a(98)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramunw.a(2131307554)).setVisibility(8);
        urp.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramunw = ((ukt)this.a.jdField_a_of_type_Ujx.a().get(paramInt)).a();
        localObject = paramunw.getOwner();
        paramInt = urp.a(paramunw);
        i = urp.b(paramunw);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((srk)localObject).getUnionId();; paramObject = "")
        {
          urp.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramunw.feedId, paramObject });
          if (!((srk)localObject).isMe()) {
            break label554;
          }
          skt.a(uoh.a(this.a), 4, paramunw.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((srk)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramunw instanceof GeneralFeedItem)) || ((paramunw instanceof GeneralRecommendFeedItem)))
          {
            skt.a(uoh.a(this.a), 4, ((srk)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramunw instanceof ShareGroupFeedItem));
      paramView = ((srk)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        urk.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramunw.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(uoh.a(this.a), 2, paramView, null, paramInt, 74);
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
          QQStoryShareGroupProfileActivity.a(uoh.a(this.a), 1, ((srk)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.a.jdField_a_of_type_Ujx.a() == null) || (this.a.jdField_a_of_type_Ujx.a().size() <= paramInt) || (this.a.jdField_a_of_type_Ujx.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Ujx.a().get(paramInt) instanceof ukv));
    label776:
    label782:
    paramView = (ukv)this.a.jdField_a_of_type_Ujx.a().get(paramInt);
    paramObject = new ArrayList();
    paramunw = paramView.a().iterator();
    paramInt = 0;
    label903:
    if (paramunw.hasNext())
    {
      localObject = (StoryVideoItem)paramunw.next();
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
        sis.a(paramObject, uoh.a(this.a));
      }
      if (this.a.jdField_a_of_type_Ujx.a().size() <= 0) {
        break;
      }
      urp.a("home_page", "clk_retry", urp.a(paramView.a()), 0, new String[] { "1", urp.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      urk.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      uoh.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uos
 * JD-Core Version:    0.7.0.1
 */