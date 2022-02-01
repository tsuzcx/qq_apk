import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.a;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class xng
  implements VideoPlayerCallback
{
  public xng(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "playShortVideoByPath, onLoopBack, id = " + paramLong1);
    }
    MessageForShortVideo localMessageForShortVideo = aqfv.a().a(Long.valueOf(paramLong1));
    this.this$0.a(localMessageForShortVideo, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onStateChange , state =  " + paramInt + ", msgUniseq = " + paramLong);
    }
    if (paramInt == 4)
    {
      localObject = aqfv.a().a(Long.valueOf(paramLong));
      if ((localObject != null) && (!aqfv.a().E(Long.valueOf(paramLong))))
      {
        ShortVideoUtils.a(this.this$0.app, "0X8008E51", this.this$0.sessionInfo, (MessageRecord)localObject, this.this$0.mContext);
        if (!aqfv.a().F(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          aqfv.a().bz(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.a(this.this$0.app, "0X8008E50", this.this$0.sessionInfo, (MessageRecord)localObject, this.this$0.mContext);
        }
        aqfv.a().f(Long.valueOf(paramLong), true);
      }
    }
    Object localObject = this.this$0.a(paramLong);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "holder == null, msgUniseq = " + paramLong);
      }
    }
    label219:
    MessageForShortVideo localMessageForShortVideo;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label219;
              break label219;
              break label219;
              do
              {
                return;
              } while (paramInt == 5);
              if ((paramInt != 7) && (paramInt != 8)) {
                break;
              }
              ShortVideoRealItemBuilder.a(this.this$0).removeCallbacksAndMessages(null);
              ((ShortVideoRealItemBuilder.a)localObject).a.setVisibility(0);
              this.this$0.a((ShortVideoRealItemBuilder.a)localObject);
            } while (paramInt != 8);
            localObject = aqfv.a().a(Long.valueOf(paramLong));
          } while (localObject == null);
          this.this$0.a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
          return;
          if (paramInt != 4) {
            break;
          }
          ShortVideoRealItemBuilder.a(this.this$0).removeCallbacksAndMessages(null);
          this.this$0.b((ShortVideoRealItemBuilder.a)localObject);
          localObject = aqfv.a().a(Long.valueOf(paramLong));
        } while (localObject == null);
        this.this$0.a((MessageForShortVideo)localObject, 0L);
        return;
      } while (paramInt != 1);
      localMessageForShortVideo = aqfv.a().a(Long.valueOf(paramLong));
    } while (localMessageForShortVideo == null);
    ((ShortVideoRealItemBuilder.a)localObject).a.setVisibility(0);
    this.this$0.c(localMessageForShortVideo, (ShortVideoRealItemBuilder.a)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xng
 * JD-Core Version:    0.7.0.1
 */