import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.13.1;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.13.2;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ahsp
  implements QQGameIndicator.a
{
  public ahsp(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    QLog.d("QQGamePubAccountFragment", 2, "mFeedsAdapter.onPageScrolled position=" + paramInt1);
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("QQGamePubAccountFragment", 2, "mFeedsAdapter.onPageSelected position=" + paramInt);
    if ((paramInt != 0) && (QQGamePubAccountFragment.a(this.this$0) != null)) {
      QQGamePubAccountFragment.a(this.this$0).cii = false;
    }
    int i;
    if ((this.this$0.mHeaderRecords != null) && (paramInt < QQGamePubAccountFragment.a(this.this$0).size())) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i >= this.this$0.mHeaderRecords.size()) {
          break label485;
        }
        if (i != paramInt) {
          ((ahuh)this.this$0.mHeaderRecords.get(i)).onPause();
        } else {
          QQGamePubAccountFragment.a(this.this$0, (ahuh)this.this$0.mHeaderRecords.get(i));
        }
      }
      catch (Throwable localThrowable) {}
      com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.daZ = 0;
      if (paramInt < QQGamePubAccountFragment.a(this.this$0).size())
      {
        MessageRecord localMessageRecord = (MessageRecord)QQGamePubAccountFragment.a(this.this$0).get(paramInt);
        List localList = (List)QQGamePubAccountFragment.a(this.this$0).get(Long.valueOf(localMessageRecord.uniseq));
        FeedsItemData.TopCardInfo localTopCardInfo = (FeedsItemData.TopCardInfo)QQGamePubAccountFragment.b(this.this$0).get(Long.valueOf(localMessageRecord.uniseq));
        if (TextUtils.isEmpty((String)QQGamePubAccountFragment.c(this.this$0).get(Long.valueOf(localMessageRecord.uniseq)))) {
          String str = ahtz.bLK;
        }
        QQGamePubAccountFragment.a(this.this$0).a(localList, localTopCardInfo);
        QQGamePubAccountFragment.a(this.this$0, localTopCardInfo);
        if ((localList != null) && (localList.size() > 0)) {}
        for (;;)
        {
          QQGamePubAccountFragment.B(QQGamePubAccountFragment.a(this.this$0), paramInt);
          if (QQGamePubAccountFragment.d(this.this$0).containsKey(Long.valueOf(localMessageRecord.uniseq))) {
            QQGamePubAccountFragment.a(this.this$0).scrollToPosition(((Integer)QQGamePubAccountFragment.d(this.this$0).get(Long.valueOf(localMessageRecord.uniseq))).intValue());
          }
          tbb.a(abmt.getAppInterface(), "769", "205017", this.this$0.en(paramInt), "76901", "1", "160", new String[] { ahtz.t((MessageRecord)QQGamePubAccountFragment.a(this.this$0).get(paramInt)), "" + paramInt, "8" });
          ((aqrb)QQGamePubAccountFragment.a(this.this$0).getBusinessHandler(71)).X(2, ((MessageRecord)QQGamePubAccountFragment.a(this.this$0).get(0)).getExtInfoFromExtStr("pa_msgId"), "");
          return;
          label485:
          if (QQGamePubAccountFragment.a(this.this$0) == null) {
            break;
          }
          QQGamePubAccountFragment.a(this.this$0).onResume();
          break;
          this.this$0.KB(false);
        }
      }
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGamePubAccountFragment.13.1(this), 200L);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGamePubAccountFragment.13.2(this), 1200L);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsp
 * JD-Core Version:    0.7.0.1
 */