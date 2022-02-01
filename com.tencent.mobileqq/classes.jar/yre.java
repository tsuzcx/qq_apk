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

public class yre
  extends yii
{
  private wtt jdField_a_of_type_Wtt = (wtt)wth.a(2);
  private yop jdField_a_of_type_Yop = new yrf(this);
  private yrg jdField_a_of_type_Yrg;
  
  public yre(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    paramyqw.b = paramInt;
    paramyqw.a(this.jdField_a_of_type_Yop);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      yuk.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramyqw.a();
    }
    paramViewGroup = paramyqw.a(2131365176);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramyqw.a(2131380106);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramyqw.a(2131380036);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyqw.a(2131381155);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramyqw.a(2131379958);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramyqw.a(2131374612);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Yol != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Yol);
      }
      if (this.jdField_a_of_type_Yoo != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Yoo);
      }
      yrh.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", zps.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), zps.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Wtt.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(anzj.a(2131704514));
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
      yup.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramyqw.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(anzj.a(2131704513));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130846919);
      localTextView1.setOnClickListener(paramyqw);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561756, paramViewGroup, false));
  }
  
  public void a(yrg paramyrg)
  {
    this.jdField_a_of_type_Yrg = paramyrg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yre
 * JD-Core Version:    0.7.0.1
 */