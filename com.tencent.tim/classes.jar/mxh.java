import android.util.SparseIntArray;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShuntBarConfigure.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class mxh
{
  private static final String TAG = mxh.class.getSimpleName();
  private SparseIntArray B = new SparseIntArray();
  private SparseIntArray C = new SparseIntArray();
  private QQAppInterface mApp;
  private String uin;
  
  public mxh(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.uin = kxm.getAccount();
  }
  
  public boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo == null) {
      return false;
    }
    try
    {
      boolean bool = awit.M(this.mApp);
      if (!bool) {
        awit.H(this.uin + paramECommerceEntranceInfo.videoSource, Integer.valueOf(0));
      }
      if (bool) {}
      for (int i = ((Integer)awit.f(this.uin + paramECommerceEntranceInfo.videoSource, Integer.valueOf(0))).intValue();; i = 0)
      {
        int k = this.B.get(paramECommerceEntranceInfo.videoSource);
        int j = this.C.get(paramECommerceEntranceInfo.videoSource);
        if ((i + j >= paramECommerceEntranceInfo.aHp) || (k >= paramECommerceEntranceInfo.aHo)) {
          break;
        }
        k += 1;
        j += 1;
        this.B.put(paramECommerceEntranceInfo.videoSource, k);
        this.C.put(paramECommerceEntranceInfo.videoSource, j);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "video_source_id: " + paramECommerceEntranceInfo.videoSource + ", one_day_display_counts: " + paramECommerceEntranceInfo.aHp + ", session_display_counts: " + paramECommerceEntranceInfo.aHo + ", session_has_display_counts: " + k + ", one_day_has_display_counts: " + (i + j));
        }
        return true;
      }
      return false;
    }
    catch (Exception paramECommerceEntranceInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "解析引流条出现的条件出错: " + paramECommerceEntranceInfo.getMessage());
      }
    }
    return false;
  }
  
  public void aTu()
  {
    ThreadManagerV2.executeOnSubThread(new VideoFeedsShuntBarConfigure.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxh
 * JD-Core Version:    0.7.0.1
 */