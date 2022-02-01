import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ambh
{
  private QQAppInterface mApp;
  
  public ambh(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static boolean lc(int paramInt)
  {
    return (paramInt == -2000) || (paramInt == -2022) || (paramInt == -1035) || (paramInt == -1036);
  }
  
  public static boolean ld(int paramInt)
  {
    return (paramInt == 1004) || (paramInt == 1005) || (paramInt == 2005) || (paramInt == 5001) || (paramInt == 5002);
  }
  
  public void a(MessageRecord paramMessageRecord, achq paramachq, ambj.a parama)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (parama != null) {
      parama.au(paramMessageRecord);
    }
    this.mApp.b().b(paramMessageRecord, paramachq);
  }
  
  public boolean aN(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.extraflag == 32768)) {
      return true;
    }
    int i;
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      i = ((MessageForShortVideo)paramMessageRecord).videoFileStatus;
    }
    for (;;)
    {
      return ld(i);
      if (((paramMessageRecord instanceof MessageForPic)) && (((MessageForPic)paramMessageRecord).size <= 0L))
      {
        int j = l(paramMessageRecord);
        i = j;
        if (j == -1) {
          return true;
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean aO(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramMessageRecord;
      if ((localMessageForShortVideo.busiType == 0) && (localMessageForShortVideo.videoFileStatus != 998) && (TextUtils.isEmpty(localMessageForShortVideo.md5)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaMsgController", 2, "isVideoNeedPreCompress is true, " + paramMessageRecord.uniseq);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean aP(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if (aO(paramMessageRecord))
    {
      bool = true;
      l((MessageForShortVideo)paramMessageRecord);
    }
    return bool;
  }
  
  public void at(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.mApp == null)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if (((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForLightVideo))) {
        this.mApp.b().z(paramMessageRecord);
      }
      while (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMsg cost:").append(System.currentTimeMillis() - l).append(" uniseq = ").append(paramMessageRecord.uniseq).append(", msgtype = ").append(paramMessageRecord.msgtype);
        QLog.d("MediaMsgController", 2, localStringBuilder.toString());
        return;
        ((acle)this.mApp.getBusinessHandler(13)).W(paramMessageRecord);
        this.mApp.b().b(paramMessageRecord, this.mApp.getCurrentAccountUin());
      }
    }
  }
  
  public int l(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = this.mApp.a().a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
      if ((paramMessageRecord instanceof aojn)) {
        return (int)((aojn)paramMessageRecord).hh();
      }
    }
    return -1;
  }
  
  protected void l(MessageForShortVideo paramMessageForShortVideo)
  {
    angw.a locala = new angw.a(this.mApp, this.mApp.getApplication(), paramMessageForShortVideo, null);
    angw.a().a(paramMessageForShortVideo.uniseq, locala);
  }
  
  public int m(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = this.mApp.a().a(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
      if (!(paramMessageRecord instanceof aojn)) {}
    }
    for (int i = ((aojn)paramMessageRecord).getCurrentProgress();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaMsgController", 2, new Object[] { "getUploadProgress:", Integer.valueOf(i) });
      }
      return i;
    }
  }
  
  public boolean oC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      File localFile = new File(paramString);
      if ((localFile.exists()) && (GifDrawable.isGifFile(localFile)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaMsgController", 2, "isDoutuPic gifFile");
        }
        return true;
      }
      i = avfp.fR(paramString);
    } while ((i != 2000) && (i != 3));
    if (QLog.isColorLevel()) {
      QLog.d("MediaMsgController", 2, new Object[] { "isDoutuPic imageType:", Integer.valueOf(i) });
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambh
 * JD-Core Version:    0.7.0.1
 */