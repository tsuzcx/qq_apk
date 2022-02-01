import android.graphics.Color;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class mch
  implements ljc.c
{
  public mch(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    ComponentHeaderRecommend.a(this.b).setTextColor(Color.parseColor("#BBBBBB"));
    ComponentHeaderRecommend.a(this.b).setEnabled(false);
    ComponentHeaderRecommend.a(this.b).getPaint().setFakeBoldText(false);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderRecommend", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    ArticleInfo localArticleInfo;
    String str;
    if ((this.b.a.a != null) && (this.b.a.a.a() != null))
    {
      localArticleInfo = this.b.a.a.a();
      str = kxm.a(localArticleInfo.mAlgorithmID, kxm.a(localArticleInfo), this.b.a.a.nh(), 0, 0, aqiw.isWifiConnected(this.b.getContext()), ComponentHeaderRecommend.a(this.b) + "", null, localArticleInfo.innerUniqueID, null, localArticleInfo);
      if (!odv.aT(this.b.a.a.nh())) {
        break label290;
      }
    }
    label290:
    for (paramString = "0X800941D";; paramString = "0X80080EC")
    {
      kbp.a(null, ComponentHeaderRecommend.a(this.b) + "", paramString, paramString, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), Integer.toString(localArticleInfo.mStrategyId), str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mch
 * JD-Core Version:    0.7.0.1
 */