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

public class uxq
  extends oam
{
  public uxq(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void a(uyc paramuyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond");
    }
    PublicAccountImageCollectionMainActivity.a(this.a, paramuyc);
    if (paramuyc == null)
    {
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.5(this), 0L);
      return;
    }
    PublicAccountImageCollectionMainActivity.a(this.a, paramuyc);
    PublicAccountImageCollectionMainActivity.a(this.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onReportReadPhotoCollectionRespond isSuccess =" + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onCreateArticleCommentRespond isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      PublicAccountImageCollectionMainActivity.b(this.a);
    }
    for (int i = 1;; i = 0)
    {
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.6(this, paramBoolean, paramInt), 0L);
      ocd.a(null, this.a.jdField_a_of_type_JavaLangString, "0X8007B97", "0X8007B97", 0, 0, this.a.b, this.a.c, "" + i, "", false);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onSendArticleLikeReq,articleID=" + paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onQueryArticleLikeCount,articleID=" + paramString + "likeCount" + paramInt);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.b)))
    {
      PublicAccountImageCollectionMainActivity.a(this.a, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.1(this, paramInt), 0L);
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onCheckIsArticleLiked,articleID=" + paramString + "isLiked" + paramBoolean2);
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.b)))
    {
      PublicAccountImageCollectionMainActivity.a(this.a, paramBoolean2);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.2(this), 0L);
    }
  }
  
  public void a(boolean paramBoolean, ArrayList<uyf> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetRecommendInfoRespond isSuccess =" + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.8(this), 0L);
        return;
      }
      PublicAccountImageCollectionMainActivity.a(this.a, paramArrayList);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.9(this, paramArrayList), 0L);
      return;
    }
    PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.10(this), 0L);
  }
  
  public void a(boolean paramBoolean, uyc paramuyc, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      if ((paramString != null) && (!paramString.equals(this.a.b)))
      {
        if (paramuyc != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + paramBoolean + " ;articleID = " + paramuyc.jdField_a_of_type_JavaLangString);
          }
          PublicAccountImageCollectionPreloadManager.a().a(paramuyc, paramArrayOfByte);
          PublicAccountImageCollectionPreloadManager.a().b(paramuyc);
        }
        if ((paramuyc == null) || (paramuyc.jdField_a_of_type_JavaUtilArrayList == null)) {
          break label308;
        }
      }
    }
    label308:
    for (int i = paramuyc.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      ocd.a(null, this.a.jdField_a_of_type_JavaLangString, "0X8007B8A", "0X8007B8A", 0, 0, this.a.b, this.a.c, "" + PublicAccountImageCollectionMainActivity.b(this.a, PublicAccountImageCollectionMainActivity.a(this.a)), "" + i, false);
      return;
      PublicAccountImageCollectionMainActivity.a(this.a, paramuyc);
      if (paramuyc == null)
      {
        PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.3(this), 0L);
        break;
      }
      PublicAccountImageCollectionMainActivity.a(this.a, paramuyc);
      PublicAccountImageCollectionPreloadManager.a().a(paramuyc, paramArrayOfByte);
      PublicAccountImageCollectionMainActivity.a(this.a);
      break;
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.4(this), 0L);
      break;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetArticleCommentCountRespond count=" + paramInt);
    }
    if (paramBoolean)
    {
      PublicAccountImageCollectionMainActivity.c(this.a, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.7(this), 0L);
    }
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.PublicAccountArticleObserver", 2, "onGetArticleReadCount isSuccess =" + paramBoolean);
    }
    if (paramBoolean)
    {
      PublicAccountImageCollectionMainActivity.d(this.a, paramInt);
      PublicAccountImageCollectionMainActivity.a(this.a).postDelayed(new PublicAccountImageCollectionMainActivity.3.11(this), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxq
 * JD-Core Version:    0.7.0.1
 */