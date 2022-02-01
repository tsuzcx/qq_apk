import android.app.Activity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.a;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.3;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ajzo
  implements ajzh.a
{
  private final String TAG = "VideoInfoListener";
  private HorizontalBallLoadingView a;
  private int aTw;
  private int aTx;
  private StoryPlayController jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController;
  private ShortVideoCommentsView jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView;
  private VideoPlayerPagerAdapter.a c;
  private boolean cqX;
  int dlN = -1;
  Runnable hg = new VideoInfoListenerImpl.3(this);
  
  public ajzo(VideoPlayerPagerAdapter.a parama, StoryPlayController paramStoryPlayController, ShortVideoCommentsView paramShortVideoCommentsView, boolean paramBoolean)
  {
    this.c = parama;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController = paramStoryPlayController;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView = paramShortVideoCommentsView;
    this.cqX = paramBoolean;
  }
  
  public void E(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onCoverComplete() called with: imageWidth = [" + paramInt1 + "], imageHeight = [" + paramInt2 + "], isSuc = [" + paramBoolean + "]");
    }
    this.aTw = paramInt1;
    this.aTx = paramInt2;
    if ((paramBoolean) && (this.cqX)) {
      ajxv.a(this.c, paramInt1, paramInt2);
    }
  }
  
  public void RF(int paramInt)
  {
    if ((paramInt == 0) || (this.dlN == paramInt)) {
      return;
    }
    this.dlN = paramInt;
    int i = paramInt;
    if (paramInt > 100) {
      i = 100;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.arD())
    {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.b.a.iP(this.c.position, i);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.b.a.iP(0, i);
  }
  
  public void dAj()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onStartPrepareVideo");
    }
    if (this.c == null) {}
    do
    {
      return;
      this.c.c.setVisibility(8);
      if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView != null) && (this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.Bs != null) && (((VideoData)this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.get(this.c.position)).type != 4)) {
        this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.Bs.setVisibility(8);
      }
    } while (this.c == null);
    this.c.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.Mu(true);
  }
  
  public void dAk()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onStartPlaying");
    }
    VideoData localVideoData;
    if (this.c != null)
    {
      this.c.c.setVisibility(8);
      if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView != null) && (this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.Bs != null) && (((VideoData)this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.get(this.c.position)).type != 4)) {
        this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.Bs.setVisibility(8);
      }
      hideLoading();
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.dzF();
      this.c.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.Mu(true);
      if ((this.c.position >= 0) && (this.c.position < this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.size()))
      {
        localVideoData = (VideoData)this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.get(this.c.position);
        if (1 != localVideoData.type) {
          break label195;
        }
      }
    }
    label195:
    while (this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mCurrentIndex != this.c.position)
    {
      return;
      QLog.e("VideoInfoListener", 1, "mHolder == null!");
      return;
    }
    localVideoData.isReady = true;
  }
  
  public void dAl()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onDoingStartPlayback");
    }
    showLoading();
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.dzL();
  }
  
  public void dzM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInfoListener", 2, "VideoInfoListenerImpl onLayoutChange");
    }
    if (this.c.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getVisibility() == 0) {
      if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.size() > this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mCurrentIndex) && (((VideoData)this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.get(this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mCurrentIndex)).yf.size() > 0)) {
        ajxv.a(this.c, ((ajwh)((VideoData)this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.get(this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mCurrentIndex)).yf.get(0)).dlm, ((ajwh)((VideoData)this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.get(this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mCurrentIndex)).yf.get(0)).imageWidth, (VideoData)this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.jG.get(this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mCurrentIndex), this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView);
      }
    }
    while ((this.aTw <= 0) || (this.aTx <= 0)) {
      return;
    }
    ajxv.a(this.c, this.aTw, this.aTx);
  }
  
  public void hideLoading()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("hideLoading： mHorizontalBallLoadingView is null? : ");
      if (this.a != null) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VideoInfoListener", 2, bool);
      ThreadManager.getUIHandler().removeCallbacks(this.hg);
      if (this.a != null) {
        break;
      }
      return;
    }
    this.a.setVisibility(8);
    this.a = null;
  }
  
  public void onComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onComplete");
    }
    if (((this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mContext instanceof Activity)) && (((Activity)this.jdField_b_of_type_ComTencentMobileqqNearbyNowStoryPlayController.mContext).isFinishing())) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new VideoInfoListenerImpl.1(this), 1000L);
  }
  
  public void scrollToTop()
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.scrollToTop();
  }
  
  public void showLoading()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showLoading： mHorizontalBallLoadingView is null? : ");
      if (this.a != null) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VideoInfoListener", 2, bool);
      this.a = ((HorizontalBallLoadingView)this.c.ld.findViewById(2131370787));
      ThreadManager.getUIHandler().postDelayed(this.hg, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzo
 * JD-Core Version:    0.7.0.1
 */