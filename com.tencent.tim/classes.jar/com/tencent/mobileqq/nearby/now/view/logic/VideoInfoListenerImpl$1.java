package com.tencent.mobileqq.nearby.now.view.logic;

import ajwe;
import ajyb;
import ajzo;
import android.app.Activity;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.a;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VideoInfoListenerImpl$1
  implements Runnable
{
  public VideoInfoListenerImpl$1(ajzo paramajzo) {}
  
  public void run()
  {
    if (((ajzo.a(this.this$0).mContext instanceof Activity)) && (((Activity)ajzo.a(this.this$0).mContext).isFinishing())) {}
    label35:
    label246:
    do
    {
      do
      {
        do
        {
          do
          {
            break label35;
            break label35;
            do
            {
              return;
            } while ((ajzo.a(this.this$0).position < 0) || (ajzo.a(this.this$0).position >= ajzo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size()));
            if (ajzo.a(this.this$0).b.b == null) {
              break label246;
            }
            if (!ajzo.a(this.this$0).cqC) {
              break;
            }
            ajzo.a(this.this$0).jdField_a_of_type_Ajyb.restart();
          } while (!QLog.isColorLevel());
          QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          return;
          if (ajzo.a(this.this$0).arF()) {
            break;
          }
          ajzo.a(this.this$0).jdField_a_of_type_Ajyb.restart();
        } while (!QLog.isColorLevel());
        QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
        return;
        if (ajzo.a(this.this$0).position != ajzo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() - 1) {
          break;
        }
      } while (!(ajzo.a(this.this$0).getContext() instanceof Activity));
      ((Activity)ajzo.a(this.this$0).getContext()).finish();
      return;
      Object localObject = (VideoData)ajzo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(ajzo.a(this.this$0).position);
      ((VideoData)localObject).dlB = 0;
      ((VideoData)localObject).isReady = false;
      localObject = ajzo.a(this.this$0);
      ((StoryPlayController)localObject).mCurrentIndex += 1;
      if (ajzo.a(this.this$0).mCurrentIndex < ajzo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size())
      {
        ajzo.a(this.this$0).b.setCurrentItem(ajzo.a(this.this$0).mCurrentIndex, true);
        return;
      }
    } while (!ajzo.a(this.this$0).jdField_a_of_type_Ajwe.isEnd());
    ajzo.a(this.this$0).b.onClose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */