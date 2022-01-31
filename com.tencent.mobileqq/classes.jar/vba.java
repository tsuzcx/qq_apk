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

public class vba
  extends use
{
  private tdo jdField_a_of_type_Tdo = (tdo)tdc.a(2);
  private uyl jdField_a_of_type_Uyl = new vbb(this);
  private vbc jdField_a_of_type_Vbc;
  
  public vba(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    paramvas.b = paramInt;
    paramvas.a(this.jdField_a_of_type_Uyl);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      veg.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramvas.a();
    }
    paramViewGroup = paramvas.a(2131364814);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramvas.a(2131378358);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramvas.a(2131378315);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvas.a(2131379251);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramvas.a(2131378262);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramvas.a(2131373270);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Uyh != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Uyh);
      }
      if (this.jdField_a_of_type_Uyk != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Uyk);
      }
      vbd.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", vzo.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), vzo.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Tdo.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(ajyc.a(2131705611));
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
      vel.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramvas.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(ajyc.a(2131705610));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130846006);
      localTextView1.setOnClickListener(paramvas);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected vas a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561273, paramViewGroup, false));
  }
  
  public void a(vbc paramvbc)
  {
    this.jdField_a_of_type_Vbc = paramvbc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vba
 * JD-Core Version:    0.7.0.1
 */