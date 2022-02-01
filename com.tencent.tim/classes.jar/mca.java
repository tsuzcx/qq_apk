import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class mca
  implements ljc.c
{
  public mca(ComponentHeaderPolymeric paramComponentHeaderPolymeric, ArticleInfo paramArticleInfo) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString + " followStatus = " + this.d.mPolymericInfo.followStatus);
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.this$0).getTag())) {}
    label227:
    do
    {
      do
      {
        return;
        ComponentHeaderPolymeric.a(this.this$0, true);
        if (!paramBoolean) {
          break label271;
        }
        if (this.d.mPolymericInfo.followStatus == 1) {
          ComponentHeaderPolymeric.a(this.this$0, true);
        }
        for (;;)
        {
          if ((this.d.mPolymericInfo.followStatus != 1) && (this.d.mPolymericInfo.followStatus != 2)) {
            break label227;
          }
          if (this.d.mPolymericInfo.followStatus != 1) {
            break;
          }
          ComponentHeaderPolymeric.a(this.this$0, this.d, 2);
          return;
          if (this.d.mPolymericInfo.followStatus == 2) {
            ComponentHeaderPolymeric.a(this.this$0, false);
          }
        }
      } while (this.d.mPolymericInfo.followStatus != 2);
      ComponentHeaderPolymeric.a(this.this$0, this.d, 1);
      return;
      QLog.e("ComponentHeaderPolymeric", 2, "978 resp error, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
      return;
      if (this.d.mPolymericInfo.followStatus == 1)
      {
        ComponentHeaderPolymeric.a(this.this$0, 1);
        return;
      }
    } while (this.d.mPolymericInfo.followStatus != 2);
    label271:
    ComponentHeaderPolymeric.a(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mca
 * JD-Core Version:    0.7.0.1
 */