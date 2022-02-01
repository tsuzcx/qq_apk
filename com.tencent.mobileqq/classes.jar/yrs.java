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

class yrs
  extends yop
{
  yrs(yrh paramyrh) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yqw paramyqw)
  {
    if (zps.b()) {}
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
          case 2131374583: 
            for (;;)
            {
              paramObject = (ynt)this.a.jdField_a_of_type_Ymx.a().get(paramInt);
              if (paramObject == yrh.a(this.a))
              {
                yrh.a(this.a, null);
                yrh.a(this.a, false);
                this.a.c(true);
              }
              if (!(paramObject instanceof ymm)) {
                break;
              }
              paramView = (ymm)paramObject;
              paramView.a = false;
              paramView.a();
              return;
              if ((this.a.jdField_a_of_type_Ymx.a().get(paramInt) instanceof ymm)) {
                yup.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.a.jdField_a_of_type_Ymx.a().get(paramInt) instanceof yns)) {
                yup.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof yns))
            {
              paramView = ((ShareGroupFeedItem)((yns)paramObject).a()).getOwner();
              yrh.a(this.a, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof ymn));
        if (!zot.a(yrh.a(this.a)))
        {
          QQToast.a(yrh.a(this.a), 1, anzj.a(2131703358), 0).a();
          return;
        }
        paramObject = (ymn)paramObject;
        localObject = paramObject.a().getOwner();
        ((wja)xiz.a().a(98)).a(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramyqw.a(2131374609)).setVisibility(8);
        yup.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.a().feedId });
        return;
        paramyqw = ((ynt)this.a.jdField_a_of_type_Ymx.a().get(paramInt)).a();
        localObject = paramyqw.getOwner();
        paramInt = yup.a(paramyqw);
        i = yup.b(paramyqw);
        if (this.a.jdField_a_of_type_Int == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((wul)localObject).getUnionId();; paramObject = "")
        {
          yup.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramyqw.feedId, paramObject });
          if (!((wul)localObject).isMe()) {
            break label554;
          }
          wnu.a(yrh.a(this.a), 4, paramyqw.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((wul)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramyqw instanceof GeneralFeedItem)) || ((paramyqw instanceof GeneralRecommendFeedItem)))
          {
            wnu.a(yrh.a(this.a), 4, ((wul)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramyqw instanceof ShareGroupFeedItem));
      paramView = ((wul)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        yuk.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramyqw.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(yrh.a(this.a), 2, paramView, null, paramInt, 74);
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
          QQStoryShareGroupProfileActivity.a(yrh.a(this.a), 1, ((wul)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.a.jdField_a_of_type_Ymx.a() == null) || (this.a.jdField_a_of_type_Ymx.a().size() <= paramInt) || (this.a.jdField_a_of_type_Ymx.a().get(paramInt) == null)) {
        break;
      }
    } while (!(this.a.jdField_a_of_type_Ymx.a().get(paramInt) instanceof ynv));
    label776:
    label782:
    paramView = (ynv)this.a.jdField_a_of_type_Ymx.a().get(paramInt);
    paramObject = new ArrayList();
    paramyqw = paramView.a().iterator();
    paramInt = 0;
    label903:
    if (paramyqw.hasNext())
    {
      localObject = (StoryVideoItem)paramyqw.next();
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
        wlt.a(paramObject, yrh.a(this.a));
      }
      if (this.a.jdField_a_of_type_Ymx.a().size() <= 0) {
        break;
      }
      yup.a("home_page", "clk_retry", yup.a(paramView.a()), 0, new String[] { "1", yup.a(this.a.jdField_a_of_type_Int), String.valueOf(paramInt), paramView.a().feedId });
      return;
      yuk.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      yrh.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrs
 * JD-Core Version:    0.7.0.1
 */