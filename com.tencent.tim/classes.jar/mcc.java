import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class mcc
  implements ljc.c
{
  public mcc(ComponentHeaderPolymeric paramComponentHeaderPolymeric, ArticleInfo paramArticleInfo) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPubAccount() unfollowUin uin=" + paramString + ", isSuccess=" + paramBoolean + " followStatus = " + this.d.mPolymericInfo.followStatus);
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.this$0).getTag())) {
      return;
    }
    ComponentHeaderPolymeric.a(this.this$0, true);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.this$0, false);
      ComponentHeaderPolymeric.a(this.this$0, this.d, 1);
      return;
    }
    ComponentHeaderPolymeric.a(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcc
 * JD-Core Version:    0.7.0.1
 */