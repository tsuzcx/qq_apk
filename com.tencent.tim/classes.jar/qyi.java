import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class qyi
  extends qtc
{
  private qyi.a a;
  private ptf b = (ptf)psx.a(2);
  private qwo c = new qyj(this);
  
  public qyi(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramqyd.position = paramInt;
    paramqyd.b(this.c);
    if ((this.la == null) || (paramInt >= this.la.size()))
    {
      ram.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramqyd.getItemView();
    }
    paramViewGroup = paramqyd.get(2131365493);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramqyd.get(2131380947);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramqyd.get(2131380884);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramqyd.get(2131382005);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramqyd.get(2131380814);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramqyd.get(2131375154);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.la.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.e, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Qwn != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Qwn);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a);
      }
      qyk.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", rpq.dip2px(this.mContext, 100.0F), rpq.dip2px(this.mContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.b.b(localStoryVideoItem.mOwnerUid);
        if (localObject != null)
        {
          localTextView3.setVisibility(0);
          if (!TextUtils.isEmpty(((QQUserUIItem)localObject).remark)) {
            break label464;
          }
          localTextView3.setText(((QQUserUIItem)localObject).nickName);
          if (!TextUtils.isEmpty(((QQUserUIItem)localObject).getUnionId()))
          {
            localStoryUserBadgeView.setVisibility(0);
            localStoryUserBadgeView.setUnionID(((QQUserUIItem)localObject).getUnionId(), 1);
          }
          if (!TextUtils.isEmpty(localStoryVideoItem.mRecommendWording))
          {
            localTextView2.setVisibility(0);
            localTextView2.setText(localStoryVideoItem.mRecommendWording);
          }
          if ((!((QQUserUIItem)localObject).isVip()) || (((QQUserUIItem)localObject).isMe()) || (((QQUserUIItem)localObject).isFriend())) {
            break label513;
          }
          localTextView1.setVisibility(0);
          if (!((QQUserUIItem)localObject).isSubscribe()) {
            break label477;
          }
          localTextView1.setText(acfp.m(2131707274));
          localTextView1.setTextColor(Color.parseColor("#80FFFFFF"));
          localTextView1.setBackgroundDrawable(null);
          localTextView1.setOnClickListener(null);
          localTextView1.setClickable(false);
          paramViewGroup.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      rar.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramqyd.getItemView();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(acfp.m(2131707273));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130847785);
      localTextView1.setOnClickListener(paramqyd);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  public void a(qyi.a parama)
  {
    this.jdField_a_of_type_Qyi$a = parama;
  }
  
  protected qyd b(int paramInt, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(this.mContext).inflate(2131561873, paramViewGroup, false));
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, VideoListFeedItem paramVideoListFeedItem, QQUserUIItem paramQQUserUIItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qyi
 * JD-Core Version:    0.7.0.1
 */