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
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class uoe
  extends ufi
{
  private sqs jdField_a_of_type_Sqs = (sqs)sqg.a(2);
  private ulp jdField_a_of_type_Ulp = new uof(this);
  private uog jdField_a_of_type_Uog;
  
  public uoe(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    paramunw.b = paramInt;
    paramunw.a(this.jdField_a_of_type_Ulp);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      urk.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramunw.a();
    }
    paramViewGroup = paramunw.a(2131299251);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramunw.a(2131312533);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramunw.a(2131312489);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramunw.a(2131313417);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramunw.a(2131312436);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramunw.a(2131307557);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Ull != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Ull);
      }
      if (this.jdField_a_of_type_Ulo != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Ulo);
      }
      uoh.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", vms.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Sqs.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(ajjy.a(2131639826));
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
      urp.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramunw.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(ajjy.a(2131639825));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130845825);
      localTextView1.setOnClickListener(paramunw);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected unw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495682, paramViewGroup, false));
  }
  
  public void a(uog paramuog)
  {
    this.jdField_a_of_type_Uog = paramuog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uoe
 * JD-Core Version:    0.7.0.1
 */