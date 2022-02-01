import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.qphone.base.util.QLog;

public class oty
  extends jzv
{
  public oty(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, long paramLong) {}
  
  public void a(boolean paramBoolean, oub.a parama, byte[] paramArrayOfByte, String paramString)
  {
    if (paramBoolean)
    {
      this.this$0.v(true, this.val$beginTime);
      if (parama != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + parama.articleId);
        }
        this.this$0.a(parama, paramArrayOfByte);
        this.this$0.d(parama);
      }
      return;
    }
    this.this$0.v(false, this.val$beginTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oty
 * JD-Core Version:    0.7.0.1
 */