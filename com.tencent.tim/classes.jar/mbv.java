import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mbv
  implements View.OnClickListener
{
  public mbv(ComponentContentUGCVoice paramComponentContentUGCVoice) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((ComponentContentUGCVoice.a(this.a) != null) && (!TextUtils.isEmpty(ComponentContentUGCVoice.a(this.a).voiceUrl))) {
      if (ComponentContentUGCVoice.a(this.a).isPlaying)
      {
        kbp.a(null, "", "0X8009CA4", "0X8009CA4", 0, 0, localQQAppInterface.getCurrentAccountUin(), ComponentContentUGCVoice.a(this.a).mFeedId + "", "2", "", false);
        mrh.a().aRx();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      kbp.a(null, "", "0X8009CA4", "0X8009CA4", 0, 0, localQQAppInterface.getCurrentAccountUin(), ComponentContentUGCVoice.a(this.a).mFeedId + "", "1", "", false);
      mrh.a().a(this.a, ComponentContentUGCVoice.a(this.a));
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(ComponentContentUGCVoice.TAG, 2, "mUGCVoiceInfo or its voiceUrl is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbv
 * JD-Core Version:    0.7.0.1
 */