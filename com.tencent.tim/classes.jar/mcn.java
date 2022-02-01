import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.qphone.base.util.QLog;

public class mcn
  implements ljc.c
{
  public mcn(ComponentHeaderUgc paramComponentHeaderUgc, ArticleInfo paramArticleInfo) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("ComponentHeaderUgc", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    if ((paramBoolean) && (paramInt == 2))
    {
      this.d.mSocialFeedInfo.mFollowStatus = paramInt;
      this.b.bR.setEnabled(false);
      this.b.bR.getPaint().setFakeBoldText(false);
      this.d.mSocialFeedInfo.mFollowStatus = 2;
      lbz.a().j(this.d);
      lbz.a().ab(this.d.mSocialFeedInfo.a.uin, paramInt);
      lcc.a().aCi();
      return;
    }
    this.b.bR.setEnabled(true);
    this.b.bR.getPaint().setFakeBoldText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcn
 * JD-Core Version:    0.7.0.1
 */