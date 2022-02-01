import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class xmu
  implements VideoPlayerCallback
{
  public xmu(ShortVideoItemBuilder paramShortVideoItemBuilder, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoItemBuilder", 2, "onDownloadComplete, id = " + paramLong);
    }
    if (ShortVideoItemBuilder.a(this.this$0) == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "onDownloadComplete , mListView is null.");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = wja.a(paramLong, ShortVideoItemBuilder.a(this.this$0).getAdapter());
      } while (!(localObject instanceof MessageForShortVideo));
      localObject = (MessageForShortVideo)localObject;
    } while (((((MessageForShortVideo)localObject).fileType != 6) && (((MessageForShortVideo)localObject).fileType != 17) && (((MessageForShortVideo)localObject).fileType != 9)) || (((MessageForShortVideo)localObject).videoFileStatus == 2003));
    ((MessageForShortVideo)localObject).videoFileStatus = 2003;
    ((MessageForShortVideo)localObject).transferedSize = 0;
    ((MessageForShortVideo)localObject).videoFileProgress = 100;
    ((MessageForShortVideo)localObject).serial();
    this.this$0.app.b().c(((MessageForShortVideo)localObject).frienduin, this.this$0.sessionInfo.cZ, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).msgData);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onLoopBack, id = " + paramLong1 + " ,position = " + paramLong2);
    }
    MessageForShortVideo localMessageForShortVideo = aqfv.a().a(Long.valueOf(paramLong1));
    ShortVideoItemBuilder.a(this.this$0, localMessageForShortVideo, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ShortVideoItemBuilder.a(this.this$0, paramLong, paramInt1, paramInt2, paramInt3, paramString, this.a);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    ShortVideoItemBuilder.a(this.this$0, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmu
 * JD-Core Version:    0.7.0.1
 */