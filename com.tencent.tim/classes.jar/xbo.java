import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xbo
  implements View.OnClickListener
{
  public xbo(FlashPicItemBuilder paramFlashPicItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) < 800L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FlashPicItemBuilder.a(this.a, l);
      FlashPicItemBuilder.a locala = (FlashPicItemBuilder.a)wja.a(paramView);
      if (locala != null)
      {
        Object localObject3 = locala.mMessage;
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = this.a.app.b().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
          localObject1 = localObject2;
          if ((localObject3 instanceof MessageForPic)) {
            localObject1 = (MessageForPic)localObject3;
          }
        }
        if (localObject1 != null)
        {
          if (acfx.W((MessageRecord)localObject1)) {}
          for (boolean bool = acfx.X((MessageRecord)localObject1);; bool = acei.X((MessageRecord)localObject1))
          {
            if (bool) {
              break label185;
            }
            if (locala.u.getStatus() != 0) {
              break label187;
            }
            if (locala.u.isDownloadStarted()) {
              break;
            }
            locala.u.startDownload();
            break;
          }
          label185:
          continue;
          label187:
          if (locala.u.getStatus() == 2) {
            locala.u.startDownload();
          } else {
            FlashPicItemBuilder.a(this.a, (MessageForPic)localObject1, locala.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbo
 * JD-Core Version:    0.7.0.1
 */