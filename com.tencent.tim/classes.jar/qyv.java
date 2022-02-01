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

class qyv
  extends qwo
{
  qyv(qyk paramqyk) {}
  
  public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
  {
    if (rpq.isFastDoubleClick()) {}
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
          case 2131362166: 
          case 2131375125: 
            for (;;)
            {
              paramObject = (qwa)this.this$0.a.bY().get(paramInt);
              if (paramObject == qyk.a(this.this$0))
              {
                qyk.a(this.this$0, null);
                qyk.a(this.this$0, false);
                this.this$0.notifyDataSetChanged(true);
              }
              if (!(paramObject instanceof qvj)) {
                break;
              }
              paramView = (qvj)paramObject;
              paramView.aFN = false;
              paramView.bS();
              return;
              if ((this.this$0.a.bY().get(paramInt) instanceof qvj)) {
                rar.a("share_story", "clk_guide", 1, 0, new String[0]);
              } else if ((this.this$0.a.bY().get(paramInt) instanceof qvz)) {
                rar.a("share_story", "clk_guide", 2, 0, new String[0]);
              }
            }
            if ((paramObject instanceof qvz))
            {
              paramView = ((ShareGroupFeedItem)((qvz)paramObject).c()).getOwner();
              qyk.a(this.this$0, paramObject, paramView);
              return;
            }
            break;
          }
        } while (!(paramObject instanceof qvk));
        if (!rpc.hasInternet(qyk.a(this.this$0)))
        {
          QQToast.a(qyk.a(this.this$0), 1, acfp.m(2131706182), 0).show();
          return;
        }
        paramObject = (qvk)paramObject;
        localObject = paramObject.b().getOwner();
        ((pma)qem.getQQAppInterface().getBusinessHandler(98)).b(1, ((QQUserUIItem)localObject).getUnionId(), 0, 10);
        paramView.setVisibility(8);
        ((RelativeLayout)paramqyd.get(2131375151)).setVisibility(8);
        rar.a("home_page", "follow_recom", 0, 0, new String[] { "1", "1", ((QQUserUIItem)localObject).getUnionId(), paramObject.b().feedId });
        return;
        paramqyd = ((qwa)this.this$0.a.bY().get(paramInt)).a();
        localObject = paramqyd.getOwner();
        paramInt = rar.a(paramqyd);
        i = rar.b(paramqyd);
        if (this.this$0.mFeedType == 11)
        {
          paramView = "3";
          if (!(localObject instanceof ShareGroupItem)) {
            break label548;
          }
        }
        for (paramObject = ((ptq)localObject).getUnionId();; paramObject = "")
        {
          rar.a("home_page", "clk_head_nick", paramInt, 0, new String[] { String.valueOf(i), paramView, paramqyd.feedId, paramObject });
          if (!((ptq)localObject).isMe()) {
            break label554;
          }
          ppf.f(qyk.a(this.this$0), 4, paramqyd.getOwner().getUnionId());
          return;
          paramView = "1";
          break;
        }
        switch (((ptq)localObject).getRelationType())
        {
        default: 
          return;
        case 0: 
        case 1: 
          if (((paramqyd instanceof GeneralFeedItem)) || ((paramqyd instanceof GeneralRecommendFeedItem)))
          {
            ppf.f(qyk.a(this.this$0), 4, ((ptq)localObject).getUnionId());
            return;
          }
          break;
        }
      } while (!(paramqyd instanceof ShareGroupFeedItem));
      paramView = ((ptq)localObject).getUnionId();
      if (TextUtils.isEmpty(paramView))
      {
        ram.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
        return;
      }
      if (paramqyd.type == 2) {}
      for (paramInt = 1;; paramInt = 2)
      {
        QQStoryShareGroupProfileActivity.a(qyk.a(this.this$0), 2, paramView, null, paramInt, 74);
        return;
      }
      for (;;)
      {
        try
        {
          if (!(localObject instanceof ShareGroupItem)) {
            break;
          }
          if (this.this$0.mFeedType != 10) {
            break label777;
          }
          paramInt = 1;
          if (this.this$0.mFeedType != 10) {
            break label783;
          }
          i = 88;
          QQStoryShareGroupProfileActivity.a(qyk.a(this.this$0), 1, ((ptq)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), paramInt, i);
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
      if ((this.this$0.a.bY() == null) || (this.this$0.a.bY().size() <= paramInt) || (this.this$0.a.bY().get(paramInt) == null)) {
        break;
      }
    } while (!(this.this$0.a.bY().get(paramInt) instanceof qwc));
    label777:
    label783:
    paramView = (qwc)this.this$0.a.bY().get(paramInt);
    paramObject = new ArrayList();
    paramqyd = paramView.bS().iterator();
    paramInt = 0;
    label904:
    if (paramqyd.hasNext())
    {
      localObject = (StoryVideoItem)paramqyd.next();
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
        pnx.a(paramObject, qyk.a(this.this$0));
      }
      if (this.this$0.a.bY().size() <= 0) {
        break;
      }
      rar.a("home_page", "clk_retry", rar.a(paramView.c()), 0, new String[] { "1", rar.bX(this.this$0.mFeedType), String.valueOf(paramInt), paramView.c().feedId });
      return;
      ram.e("Q.qqstory.home:FeedSegment", "feed upload retry failed!!");
      return;
      qyk.a(this.this$0, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qyv
 * JD-Core Version:    0.7.0.1
 */