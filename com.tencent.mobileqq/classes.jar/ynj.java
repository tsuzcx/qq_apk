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

public class ynj
  extends yen
{
  private wpy jdField_a_of_type_Wpy = (wpy)wpm.a(2);
  private yku jdField_a_of_type_Yku = new ynk(this);
  private ynl jdField_a_of_type_Ynl;
  
  public ynj(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    paramynb.b = paramInt;
    paramynb.a(this.jdField_a_of_type_Yku);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      yqp.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramynb.a();
    }
    paramViewGroup = paramynb.a(2131365131);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramynb.a(2131379923);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramynb.a(2131379856);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramynb.a(2131380975);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramynb.a(2131379779);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramynb.a(2131374475);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Ykq != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Ykq);
      }
      if (this.jdField_a_of_type_Ykt != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Ykt);
      }
      ynm.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", zlx.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Wpy.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(anni.a(2131704407));
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
      yqu.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramynb.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(anni.a(2131704406));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130846902);
      localTextView1.setOnClickListener(paramynb);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561715, paramViewGroup, false));
  }
  
  public void a(ynl paramynl)
  {
    this.jdField_a_of_type_Ynl = paramynl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynj
 * JD-Core Version:    0.7.0.1
 */