import android.os.Looper;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.qphone.base.util.QLog;

public class mco
  extends lce
{
  public mco(ComponentHeaderUgc paramComponentHeaderUgc) {}
  
  public void W(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
      QLog.e("ComponentHeaderUgc", 2, "Please call this method in main thread!!!");
    }
    label32:
    ArticleInfo localArticleInfo;
    do
    {
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentHeaderUgc", 2, "onUpdateAfterAccountFollow uin = " + paramLong + " isFollow = " + paramBoolean);
      }
      localArticleInfo = this.b.a.a.a();
    } while (paramLong != localArticleInfo.mSocialFeedInfo.a.uin);
    if (paramBoolean)
    {
      this.b.bR.setEnabled(false);
      this.b.bR.getPaint().setFakeBoldText(false);
      localArticleInfo.mSocialFeedInfo.mFollowStatus = 2;
      localArticleInfo.isNeedShowBtnWhenFollowed = true;
    }
    for (;;)
    {
      lcc.a().aCi();
      return;
      this.b.bR.setEnabled(true);
      this.b.bR.getPaint().setFakeBoldText(true);
      localArticleInfo.mSocialFeedInfo.mFollowStatus = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mco
 * JD-Core Version:    0.7.0.1
 */