import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.qphone.base.util.QLog;

public class xua
  implements agle
{
  public xua(AIOImageProviderService paramAIOImageProviderService, agsw paramagsw, long paramLong) {}
  
  public void e(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    xui localxui = this.this$0.c;
    if (localxui == null)
    {
      QLog.i("AIOImageProviderService", 2, "onDownloadProgressUpdate: callback = null , ctxId[" + this.a.ve() + "] ");
      return;
    }
    paramInt1 = (int)((float)paramLong1 / (float)paramLong2 * 10000.0F);
    localxui.b(this.val$id, 0, 269484035, paramInt1, paramLong2, false);
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    xui localxui = this.this$0.c;
    if (localxui == null)
    {
      QLog.i("AIOImageProviderService", 2, "onDownloadProgressUpdate: error, ctxId[" + this.val$id + "] ");
      return;
    }
    if ((paramInt2 == -7003) || (paramInt2 == -6101)) {}
    for (paramInt1 = 16;; paramInt1 = 0)
    {
      localxui.b(this.val$id, paramInt1, 269484034, 2, paramString, false);
      return;
    }
  }
  
  public void yd(String paramString)
  {
    xui localxui = this.this$0.c;
    if (localxui == null)
    {
      QLog.i("AIOImageProviderServiceXOXO", 2, "onDownloadFinish callback = null , ctxId[" + this.val$id + "] ");
      return;
    }
    QLog.i("AIOImageProviderService", 1, "-----------> notify download finish:" + this.val$id);
    localxui.b(this.val$id, 1, 269484034, 1, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xua
 * JD-Core Version:    0.7.0.1
 */