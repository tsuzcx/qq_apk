import NS_QQ_STORY_META.META.StStoryFeed;
import NS_QQ_STORY_META.META.StUser;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.StStoryFeedUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;

class wyh
  implements View.OnClickListener
{
  wyh(wyg paramwyg, MessageForAIOStoryVideo paramMessageForAIOStoryVideo) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = (wkh)this.jdField_a_of_type_Wyg.app.getManager(282);
    if (localObject1 != null) {
      ((wkh)localObject1).report(4, 7);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForAIOStoryVideo.mStStoryFeed;
    if ((localObject2 != null) && (((META.StStoryFeed)localObject2).postUser != null))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_launch_time", l);
      ((Bundle)localObject1).putLong("key_current_feeduin", ((META.StStoryFeed)localObject2).postUser.uin.get());
      ((Bundle)localObject1).putInt("key_request_from", 3);
      ((Bundle)localObject1).putInt("key_weishi_entrance_type", 19);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      localObject2 = StStoryFeedUtil.getConvertDataList(localArrayList);
      ((Bundle)localObject1).putInt("key_video_story_jump_position", 0);
      ((Bundle)localObject1).putSerializable("key_video_story_tranparent_story_feed", (Serializable)localObject2);
      ((Bundle)localObject1).putInt("key_request_business_type", 7);
      aqhv.dt((Bundle)localObject1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyh
 * JD-Core Version:    0.7.0.1
 */