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
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yhk
  extends xyo
{
  private wke jdField_a_of_type_Wke = (wke)wjs.a(2);
  private yev jdField_a_of_type_Yev = new yhl(this);
  private yhm jdField_a_of_type_Yhm;
  
  public yhk(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramyhc.b = paramInt;
    paramyhc.a(this.jdField_a_of_type_Yev);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      ykq.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramyhc.a();
    }
    paramViewGroup = paramyhc.a(2131365292);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramyhc.a(2131380179);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramyhc.a(2131380114);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyhc.a(2131381226);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramyhc.a(2131380038);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramyhc.a(2131374618);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Yer != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Yer);
      }
      if (this.jdField_a_of_type_Yeu != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Yeu);
      }
      yhn.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 100.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Wke.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(anvx.a(2131705095));
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
      ykv.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramyhc.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(anvx.a(2131705094));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130846923);
      localTextView1.setOnClickListener(paramyhc);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561702, paramViewGroup, false));
  }
  
  public void a(yhm paramyhm)
  {
    this.jdField_a_of_type_Yhm = paramyhm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhk
 * JD-Core Version:    0.7.0.1
 */