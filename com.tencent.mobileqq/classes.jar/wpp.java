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

public class wpp
  extends wgt
{
  private usd jdField_a_of_type_Usd = (usd)urr.a(2);
  private wna jdField_a_of_type_Wna = new wpq(this);
  private wpr jdField_a_of_type_Wpr;
  
  public wpp(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    paramwph.b = paramInt;
    paramwph.a(this.jdField_a_of_type_Wna);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      wsv.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramwph.a();
    }
    paramViewGroup = paramwph.a(2131364894);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramwph.a(2131378956);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramwph.a(2131378904);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwph.a(2131379957);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramwph.a(2131378839);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramwph.a(2131373721);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Wmw != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Wmw);
      }
      if (this.jdField_a_of_type_Wmz != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Wmz);
      }
      wps.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", xod.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), xod.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Usd.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(alpo.a(2131705994));
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
      wta.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramwph.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(alpo.a(2131705993));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130846391);
      localTextView1.setOnClickListener(paramwph);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected wph a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561462, paramViewGroup, false));
  }
  
  public void a(wpr paramwpr)
  {
    this.jdField_a_of_type_Wpr = paramwpr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpp
 * JD-Core Version:    0.7.0.1
 */