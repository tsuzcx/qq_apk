import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.1;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.10;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.11;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.2;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.3;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.4;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.5;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.6;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.7;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.8;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.3.9;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class otv
  extends jzv
{
  public otv(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void L(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onCreateArticleCommentRespond isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      PublicAccountImageCollectionMainActivity.b(this.this$0);
    }
    for (int i = 1;; i = 0)
    {
      PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.6(this, paramBoolean, paramInt), 0L);
      kbp.a(null, this.this$0.puin, "0X8007B97", "0X8007B97", 0, 0, this.this$0.Wz, this.this$0.webUrl, "" + i, "", false);
      return;
    }
  }
  
  public void M(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetArticleCommentCountRespond count=" + paramInt);
    }
    if (paramBoolean)
    {
      PublicAccountImageCollectionMainActivity.c(this.this$0, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.7(this), 0L);
    }
  }
  
  public void N(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetArticleReadCount isSuccess =" + paramBoolean);
    }
    if (paramBoolean)
    {
      PublicAccountImageCollectionMainActivity.d(this.this$0, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.11(this), 0L);
    }
  }
  
  public void a(oub.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond");
    }
    PublicAccountImageCollectionMainActivity.a(this.this$0, parama);
    if (parama == null)
    {
      PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.5(this), 0L);
      return;
    }
    PublicAccountImageCollectionMainActivity.a(this.this$0, parama);
    PublicAccountImageCollectionMainActivity.a(this.this$0);
  }
  
  public void a(boolean paramBoolean, ArrayList<oub.d> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetRecommendInfoRespond isSuccess =" + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.8(this), 0L);
        return;
      }
      PublicAccountImageCollectionMainActivity.a(this.this$0, paramArrayList);
      PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.9(this, paramArrayList), 0L);
      return;
    }
    PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.10(this), 0L);
  }
  
  public void a(boolean paramBoolean, oub.a parama, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      if ((paramString != null) && (!paramString.equals(this.this$0.Wz)))
      {
        if (parama != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + parama.articleId);
          }
          PublicAccountImageCollectionPreloadManager.a().a(parama, paramArrayOfByte);
          PublicAccountImageCollectionPreloadManager.a().d(parama);
        }
        if ((parama == null) || (parama.infos == null)) {
          break label308;
        }
      }
    }
    label308:
    for (int i = parama.infos.size();; i = 0)
    {
      kbp.a(null, this.this$0.puin, "0X8007B8A", "0X8007B8A", 0, 0, this.this$0.Wz, this.this$0.webUrl, "" + PublicAccountImageCollectionMainActivity.b(this.this$0, PublicAccountImageCollectionMainActivity.a(this.this$0)), "" + i, false);
      return;
      PublicAccountImageCollectionMainActivity.a(this.this$0, parama);
      if (parama == null)
      {
        PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.3(this), 0L);
        break;
      }
      PublicAccountImageCollectionMainActivity.a(this.this$0, parama);
      PublicAccountImageCollectionPreloadManager.a().a(parama, paramArrayOfByte);
      PublicAccountImageCollectionMainActivity.a(this.this$0);
      break;
      PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.4(this), 0L);
      break;
    }
  }
  
  public void c(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onCheckIsArticleLiked,articleID=" + paramString + "isLiked" + paramBoolean2);
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.this$0.Wz)))
    {
      PublicAccountImageCollectionMainActivity.a(this.this$0, paramBoolean2);
      PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.2(this), 0L);
    }
  }
  
  public void d(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onQueryArticleLikeCount,articleID=" + paramString + "likeCount" + paramInt);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.this$0.Wz)))
    {
      PublicAccountImageCollectionMainActivity.a(this.this$0, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.this$0).postDelayed(new PublicAccountImageCollectionMainActivity.3.1(this, paramInt), 0L);
    }
  }
  
  public void lI(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onReportReadPhotoCollectionRespond isSuccess =" + paramBoolean);
    }
  }
  
  public void n(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onSendArticleLikeReq,articleID=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otv
 * JD-Core Version:    0.7.0.1
 */