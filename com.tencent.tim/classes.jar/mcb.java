import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class mcb
  implements ljc.c
{
  public mcb(ComponentHeaderPolymeric paramComponentHeaderPolymeric, ArticleInfo paramArticleInfo) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean + " followStatus = " + this.d.mPolymericInfo.followStatus);
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.this$0).getTag())) {
      return;
    }
    ComponentHeaderPolymeric.a(this.this$0, true);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.this$0, true);
      ComponentHeaderPolymeric.a(this.this$0, this.d, 2);
      return;
    }
    ComponentHeaderPolymeric.a(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcb
 * JD-Core Version:    0.7.0.1
 */