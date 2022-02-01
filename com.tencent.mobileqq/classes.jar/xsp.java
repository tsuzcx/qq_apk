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

public class xsp
  extends xjt
{
  private vvj jdField_a_of_type_Vvj = (vvj)vux.a(2);
  private xqa jdField_a_of_type_Xqa = new xsq(this);
  private xsr jdField_a_of_type_Xsr;
  
  public xsp(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    paramxsh.b = paramInt;
    paramxsh.a(this.jdField_a_of_type_Xqa);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      xvv.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramxsh.a();
    }
    paramViewGroup = paramxsh.a(2131365201);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramxsh.a(2131379852);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramxsh.a(2131379791);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramxsh.a(2131380874);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramxsh.a(2131379724);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramxsh.a(2131374380);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Xpw != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Xpw);
      }
      if (this.jdField_a_of_type_Xpz != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Xpz);
      }
      xss.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 100.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Vvj.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(amtj.a(2131704744));
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
      xwa.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramxsh.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(amtj.a(2131704743));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130846827);
      localTextView1.setOnClickListener(paramxsh);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561634, paramViewGroup, false));
  }
  
  public void a(xsr paramxsr)
  {
    this.jdField_a_of_type_Xsr = paramxsr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xsp
 * JD-Core Version:    0.7.0.1
 */