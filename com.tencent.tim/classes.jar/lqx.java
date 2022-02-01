import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class lqx
  implements ViewBase.OnClickListener
{
  public final String TAG = "OnTopicCapsuleClickListener";
  private ArticleInfo b;
  private Context mContext;
  
  public lqx(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
  }
  
  private void aNc()
  {
    if (this.b == null) {}
    String str;
    do
    {
      return;
      str = this.b.businessUrl;
      if (QLog.isColorLevel()) {
        QLog.d("OnTopicCapsuleClickListener", 2, "business url is " + str);
      }
    } while ((TextUtils.isEmpty(str)) || (this.mContext == null));
    Intent localIntent = new Intent(this.mContext, PublicAccountBrowser.class);
    localIntent.putExtra("url", str);
    this.mContext.startActivity(localIntent);
    kbp.a(this.b);
    ndi.g(this.b, (int)this.b.mChannelID);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    aNc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqx
 * JD-Core Version:    0.7.0.1
 */