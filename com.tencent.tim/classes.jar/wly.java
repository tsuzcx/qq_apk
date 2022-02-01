import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wly
  implements View.OnClickListener
{
  private long lastClickTime;
  public SessionInfo sessionInfo;
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.lastClickTime < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.lastClickTime = l;
      Object localObject = (URLImageView)paramView;
      MessageForPic localMessageForPic = (MessageForPic)((URLImageView)localObject).getTag(2131364517);
      URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getDrawable();
      if (localURLDrawable != null) {
        switch (localURLDrawable.getStatus())
        {
        default: 
          break;
        case 0: 
          if (!localURLDrawable.isDownloadStarted()) {
            localURLDrawable.startDownload();
          }
          break;
        case 2: 
          localObject = PicDownloadExplicitError.getFailedTip(localURLDrawable);
          if (localObject != null) {
            QQToast.a(paramView.getContext(), (CharSequence)localObject, 0).show();
          } else if (aqhq.bP(paramView.getContext())) {
            localURLDrawable.restartDownload();
          }
          break;
        case 1: 
          if (xkl.a(localMessageForPic))
          {
            AIOEmotionFragment.a(paramView.getContext(), localMessageForPic, this.sessionInfo, sxx.getViewRect(paramView));
          }
          else
          {
            localMessageForPic.isInMixedMsg = true;
            xkl.a(qem.getQQAppInterface(), paramView.getContext(), (View)localObject, localMessageForPic, this.sessionInfo, false, true, true, null);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wly
 * JD-Core Version:    0.7.0.1
 */