import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class lpw
  implements ViewBase.OnClickListener
{
  private final Context context;
  private final BaseArticleInfo d;
  
  public lpw(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
  {
    this.d = paramBaseArticleInfo;
    this.context = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.d instanceof AdvertisementInfo))
    {
      paramViewBase = (AdvertisementInfo)this.d;
      if (paramViewBase.mLocalInfo != null)
      {
        String str = paramViewBase.mLocalInfo.store_url;
        if (!TextUtils.isEmpty(str))
        {
          kxm.C(this.context, str);
          jzk.a(new kku.a().a(this.context).a(jzk.aEJ).b(jzk.aFK).a(paramViewBase).d(jzk.aGA).a());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpw
 * JD-Core Version:    0.7.0.1
 */