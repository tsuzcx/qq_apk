import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric.4.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mcd
  implements ljc.c
{
  public mcd(ComponentHeaderPolymeric paramComponentHeaderPolymeric, ArticleInfo paramArticleInfo) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + " distUin = " + paramString + ", topicID : " + this.d.mPolymericInfo.vr + " followStatus = " + this.d.mPolymericInfo.followStatus);
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.this$0).getTag())) {}
    label280:
    label285:
    do
    {
      return;
      ComponentHeaderPolymeric.a(this.this$0, true);
      if (paramBoolean)
      {
        if (this.d.mPolymericInfo.followStatus == 1)
        {
          ComponentHeaderPolymeric.a(this.this$0, true);
          if ((this.d.mPolymericInfo.followStatus != 1) && (this.d.mPolymericInfo.followStatus != 2)) {
            break label285;
          }
          if (this.d.mPolymericInfo.followStatus != 1) {
            break label280;
          }
        }
        for (paramInt = 2;; paramInt = 1)
        {
          this.d.mPolymericInfo.followStatus = paramInt;
          if ((this.d.mTopicRecommendFeedsInfo != null) && (this.d.mTopicRecommendFeedsInfo.ld != null)) {
            ((mih.b)this.d.mTopicRecommendFeedsInfo.ld.get(0)).isFollow = (paramInt - 1);
          }
          ThreadManager.post(new ComponentHeaderPolymeric.4.1(this, paramInt), 5, null, true);
          return;
          if (this.d.mPolymericInfo.followStatus != 2) {
            break;
          }
          ComponentHeaderPolymeric.a(this.this$0, false);
          break;
        }
        QLog.e("ComponentHeaderPolymeric", 2, "978 resp error, result : " + paramBoolean + ", data : " + paramInt + ", topicID : " + this.d.mPolymericInfo.vr);
        return;
      }
      if (this.d.mPolymericInfo.followStatus == 1)
      {
        ComponentHeaderPolymeric.a(this.this$0, 1);
        return;
      }
    } while (this.d.mPolymericInfo.followStatus != 2);
    ComponentHeaderPolymeric.a(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcd
 * JD-Core Version:    0.7.0.1
 */