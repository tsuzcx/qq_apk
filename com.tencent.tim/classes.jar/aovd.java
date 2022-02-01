import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.Pic_list;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

public class aovd
  extends Handler
{
  public aovd(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    long l1;
    label254:
    long l2;
    label418:
    long l3;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1001: 
      if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing()))
      {
        this.this$0.xa(false);
        this.this$0.rightViewText.setEnabled(true);
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
        QQToast.a(this.this$0.getActivity(), 2131698479, 1).show(this.this$0.getTitleBarHeight());
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
          break label254;
        }
      }
      for (localObject = "0";; localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
      {
        aprv.report("pub_page", "fail", (String)localObject, "51", TroopBarPublishActivity.b(this.this$0), "");
        QLog.d("tribe_publish_TroopBarPublishActivity", 2, "uploadVideoThumb failed " + paramMessage.obj);
        TroopBarPublishActivity.a(this.this$0, null);
        l1 = rox.getFileSize(TroopBarPublishActivity.c(this.this$0));
        aprv.a(this.this$0.getActivity(), "tribe_video", "video_thumb_upload", paramMessage.arg1, String.valueOf(l1), "", "");
        return;
      }
    case 1003: 
      localObject = (TroopBarPublishActivity.Pic_list)aprv.w.get(TroopBarPublishActivity.c(this.this$0));
      if (localObject != null)
      {
        this.this$0.jdField_a_of_type_Aora.thumbUrl = ((TroopBarPublishActivity.Pic_list)localObject).url;
        QLog.d("tribe_publish_TroopBarPublishActivity", 2, "uploadVideoThumb succ " + paramMessage.obj);
        l1 = rox.getFileSize(TroopBarPublishActivity.c(this.this$0));
        aprv.a(this.this$0.getActivity(), "tribe_video", "video_thumb_upload", paramMessage.arg1, String.valueOf(l1), String.valueOf(paramMessage.arg2), "");
        if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Aora.url)) {
          break label418;
        }
        this.this$0.dc(this.this$0.mVideoPath, true);
      }
      for (;;)
      {
        TroopBarPublishActivity.a(this.this$0, null);
        return;
        if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
          this.this$0.bsq();
        }
      }
    case 1011: 
      paramMessage = (aork)paramMessage.obj;
      this.this$0.jdField_a_of_type_Aora.vid = paramMessage.mVideoKey;
      this.this$0.jdField_a_of_type_Aora.url = paramMessage.mVideoUrl;
      TroopBarPublishActivity.a(this.this$0, null);
      if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
        this.this$0.bsq();
      }
      l1 = rox.getFileSize(paramMessage.mLocalVideoPath);
      l2 = SystemClock.elapsedRealtime();
      l3 = paramMessage.Aj;
      aprv.a(this.this$0.getActivity(), "tribe_video", "video_upload", 0, String.valueOf(l1), String.valueOf(l2 - l3), "");
      return;
    }
    Object localObject = (aork)paramMessage.obj;
    if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing()))
    {
      QQToast.a(this.this$0, 2131698479, 1).show(this.this$0.getTitleBarHeight());
      this.this$0.xa(false);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label732;
      }
    }
    label732:
    for (paramMessage = "0";; paramMessage = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
    {
      aprv.report("pub_page", "fail", paramMessage, "52", TroopBarPublishActivity.b(this.this$0), "");
      l1 = rox.getFileSize(((aork)localObject).mLocalVideoPath);
      l2 = SystemClock.elapsedRealtime();
      l3 = ((aork)localObject).Aj;
      aprv.a(this.this$0.getActivity(), "tribe_video", "video_upload", ((aork)localObject).bjJ, String.valueOf(l1), String.valueOf(l2 - l3), "");
      TroopBarPublishActivity.a(this.this$0, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovd
 * JD-Core Version:    0.7.0.1
 */