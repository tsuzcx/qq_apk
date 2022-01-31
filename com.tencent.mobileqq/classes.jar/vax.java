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

public class vax
  extends usb
{
  private tdl jdField_a_of_type_Tdl = (tdl)tcz.a(2);
  private uyi jdField_a_of_type_Uyi = new vay(this);
  private vaz jdField_a_of_type_Vaz;
  
  public vax(Context paramContext, Activity paramActivity, int paramInt)
  {
    super(paramContext, paramActivity, paramInt);
  }
  
  protected View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramvap.b = paramInt;
    paramvap.a(this.jdField_a_of_type_Uyi);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      ved.e("HotRecommendFeedAdapter", "bind view failed because of invalidate data.");
      return paramvap.a();
    }
    paramViewGroup = paramvap.a(2131364813);
    paramViewGroup.setVisibility(8);
    TextView localTextView1 = (TextView)paramvap.a(2131378361);
    localTextView1.setVisibility(4);
    localTextView1.setOnClickListener(null);
    TextView localTextView2 = (TextView)paramvap.a(2131378318);
    localTextView2.setVisibility(4);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvap.a(2131379256);
    localStoryUserBadgeView.setVisibility(8);
    TextView localTextView3 = (TextView)paramvap.a(2131378265);
    localTextView3.setVisibility(8);
    Object localObject = (QQStoryAutoPlayView)paramvap.a(2131373272);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStoryVideoItem != null)
    {
      ((QQStoryAutoPlayView)localObject).setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
      if (this.jdField_a_of_type_Uye != null) {
        ((QQStoryAutoPlayView)localObject).a(this.jdField_a_of_type_Uye);
      }
      if (this.jdField_a_of_type_Uyh != null) {
        ((QQStoryAutoPlayView)localObject).setStoryCoverClickListener(this.jdField_a_of_type_Uyh);
      }
      vba.a(localStoryVideoItem, (QQStoryAutoPlayView)localObject, "QQStory_feed_min", vzl.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
      if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject = this.jdField_a_of_type_Tdl.b(localStoryVideoItem.mOwnerUid);
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
          localTextView1.setText(ajya.a(2131705622));
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
      vei.a("home_page", "multi_card_exp", 0, 0, new String[] { localStoryVideoItem.mOwnerUid, localStoryVideoItem.mVid });
      return paramvap.a();
      label464:
      localTextView3.setText(((QQUserUIItem)localObject).remark);
      break;
      label477:
      localTextView1.setText(ajya.a(2131705621));
      localTextView1.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView1.setBackgroundResource(2130846012);
      localTextView1.setOnClickListener(paramvap);
      continue;
      label513:
      if (QLog.isColorLevel()) {
        QLog.w("HotRecommendFeedAdapter", 2, "这个里显示不出关注按钮了，打个log \n" + localObject);
      }
    }
  }
  
  protected vap a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561272, paramViewGroup, false));
  }
  
  public void a(vaz paramvaz)
  {
    this.jdField_a_of_type_Vaz = paramvaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vax
 * JD-Core Version:    0.7.0.1
 */