import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ajvr
  implements ajwe.a
{
  public ajvr(StoryPlayController paramStoryPlayController) {}
  
  public void a(VideoData paramVideoData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onFillData ! data is: " + paramVideoData.toString() + " " + paramVideoData.coverUrl);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() == 1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.da.size() == 1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.db.size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "onFillData ! suc");
      }
      paramVideoData.coverUrl = ((VideoData)this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(0)).coverUrl;
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.set(0, paramVideoData);
      ((VideoPlayerPagerAdapter.a)this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.da.get(0)).c = paramVideoData;
      VideoPlayerPagerAdapter.a locala = (VideoPlayerPagerAdapter.a)this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.da.get(0);
      ShortVideoCommentsView localShortVideoCommentsView = (ShortVideoCommentsView)this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.db.get(0);
      localShortVideoCommentsView.setVideoData(paramVideoData);
      localShortVideoCommentsView.dzX();
      localShortVideoCommentsView.dAc();
      locala.a.setCurrentAnchorUin(paramVideoData.ads);
      this.this$0.a(locala, paramVideoData, false, localShortVideoCommentsView, false);
    }
  }
  
  public void iQ(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onDataCome ! type is: " + paramInt1 + " errorCode is " + paramInt2);
    }
    if ((paramInt2 > 0) || (this.this$0.jdField_a_of_type_Ajwe.getDataList().size() == 0))
    {
      QLog.e("VideoPlayController", 1, "onDataCome errorCode > 0, errorCode=" + paramInt2 + " mPlayListDataModel.getDataList().size() is : " + this.this$0.jdField_a_of_type_Ajwe.getDataList().size());
      if (paramInt2 == 1000730) {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "onDataCome error! errorCode is: " + paramInt2);
        }
      }
      do
      {
        return;
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayController", 2, "onDataCome error! pass it! errorCode is: " + paramInt2);
      return;
      this.this$0.b.Mx(false);
      this.this$0.b.b.setVisibility(0);
      this.this$0.b.closeBtn.setVisibility(0);
      this.this$0.b.b.RC(paramInt2);
      return;
    }
    this.this$0.b.b.setVisibility(8);
    this.this$0.b.closeBtn.setVisibility(8);
    this.this$0.b.a.setTotalCount(this.this$0.jdField_a_of_type_Ajwe.getTotalCount());
    this.this$0.b.a.setShowMaxCount(this.this$0.jdField_a_of_type_Ajwe.getTotalCount());
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.cqR) {
      if (StoryPlayController.a(this.this$0))
      {
        paramInt2 = 0;
        if (paramInt2 >= this.this$0.jdField_a_of_type_Ajwe.getDataList().size()) {
          break label661;
        }
        if (!((VideoData)this.this$0.jdField_a_of_type_Ajwe.getDataList().get(paramInt2)).id.equals(StoryPlayController.a(this.this$0))) {}
      }
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 == -1) {
        i = this.this$0.jdField_a_of_type_Ajwe.getDataList().size() / 2 - 1;
      }
      this.this$0.dlk = i;
      if (i != -1)
      {
        this.this$0.mCurrentIndex = i;
        this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.dlI = this.this$0.mCurrentIndex;
      }
      ajxt.dzQ();
      for (;;)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.V(paramInt1, this.this$0.jdField_a_of_type_Ajwe.getDataList());
        this.this$0.dzE();
        if (StoryPlayController.a(this.this$0))
        {
          this.this$0.b.setCurrentItem(this.this$0.mCurrentIndex, false);
          StoryPlayController.a(this.this$0, false);
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.notifyDataSetChanged();
        StoryPlayController.b(this.this$0, this.this$0.mCurrentIndex);
        return;
        paramInt2 += 1;
        break;
        if (paramInt1 == 0)
        {
          paramInt2 = this.this$0.mCurrentIndex;
          this.this$0.jdField_a_of_type_Ajwe.getDataList().size();
        }
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.cqR) {
        break;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.V(paramInt1, this.this$0.jdField_a_of_type_Ajwe.getDataList());
      this.this$0.dzE();
      this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.this$0.b.setCurrentItem(this.this$0.mCurrentIndex, false);
      return;
      label661:
      paramInt2 = -1;
    }
  }
  
  public void onError()
  {
    if ((jqi.isNetworkAvailable(this.this$0.getContext())) && (this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() != 0))
    {
      this.this$0.b.b.dzW();
      this.this$0.b.b.setVisibility(0);
      this.this$0.b.closeBtn.setVisibility(0);
      this.this$0.b.b.setOnRetryClickListener(new ajvs(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvr
 * JD-Core Version:    0.7.0.1
 */