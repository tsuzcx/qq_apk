import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class lqf
  implements ViewBase.OnClickListener
{
  private ArticleInfo b;
  private Context mContext;
  
  public lqf(Context paramContext, ArticleInfo paramArticleInfo)
  {
    this.mContext = paramContext;
    this.b = paramArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = awit.y("kd_topic_recommend_card_jump_url");
    if ((paramViewBase instanceof String)) {}
    for (paramViewBase = (String)paramViewBase;; paramViewBase = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnJumpWrapperClickListener", 2, new Object[] { "jumpUrl = ", paramViewBase });
      }
      if (!TextUtils.isEmpty(paramViewBase))
      {
        if (this.b != null) {
          ndi.g(this.b, (int)this.b.mChannelID);
        }
        kxm.aJ(this.mContext, paramViewBase);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqf
 * JD-Core Version:    0.7.0.1
 */