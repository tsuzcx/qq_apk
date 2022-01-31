import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class cfl
  extends FMObserver
{
  private cfl(ChatActivity paramChatActivity) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInt, paramString);
    if (ChatActivity.a(this.a) != null) {
      ChatActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    ChatActivity.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      FileManagerUtil.a(paramString2);
      return;
    }
    FileManagerUtil.a(paramLong);
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {}
    do
    {
      return;
      if ((paramThumbnailInfo.a instanceof FileManagerEntity))
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
        if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0))
        {
          localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
          this.a.b.a().c(localFileManagerEntity);
        }
      }
    } while (ChatActivity.a(this.a) == null);
    ChatActivity.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    if (ChatActivity.a(this.a) != null) {
      ChatActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    ChatActivity.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.b.a().a(paramLong2);
    if (paramBoolean) {
      FileManagerUtil.a(paramLong2);
    }
    for (;;)
    {
      ChatActivity.a(this.a).notifyDataSetChanged();
      return;
      if ((paramString1.nOpType == 4) || (paramString1.nOpType == 6)) {
        FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      }
    }
  }
  
  protected void b()
  {
    ChatActivity.a(this.a).notifyDataSetChanged();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    ChatActivity.a(this.a).notifyDataSetChanged();
  }
  
  protected void c()
  {
    if (ChatActivity.a(this.a) != null) {
      ChatActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfl
 * JD-Core Version:    0.7.0.1
 */