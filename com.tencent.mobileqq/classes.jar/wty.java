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

public class wty
  extends wlc
{
  private uwm jdField_a_of_type_Uwm = (uwm)uwa.a(2);
  private wrj jdField_a_of_type_Wrj = new wtz(this);
  private wua jdField_a_of_type_Wua;
  
  public wty(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramwtq.b = paramInt;
    paramwtq.a(this.jdField_a_of_type_Wrj);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      wxe.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramwtq.a();
    }
    paramViewGroup = paramwtq.a(2131364896);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramwtq.a(2131379014);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramwtq.a(2131378961);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwtq.a(2131380015);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramwtq.a(2131378896);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramwtq.a(2131373772);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Wrf != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Wrf);
      }
      if (this.jdField_a_of_type_Wri != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Wri);
      }
      wub.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", xsm.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Uwm.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(alud.a(2131706006));
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
      wxj.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramwtq.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(alud.a(2131706005));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130846464);
      localTextView1.setOnClickListener(paramwtq);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561480, paramViewGroup, false));
  }
  
  public void a(wua paramwua)
  {
    this.jdField_a_of_type_Wua = paramwua;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wty
 * JD-Core Version:    0.7.0.1
 */