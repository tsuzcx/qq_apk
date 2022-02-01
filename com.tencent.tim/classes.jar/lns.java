import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

class lns
  implements ViewBase.OnClickListener
{
  lns(lnr paramlnr, lie paramlie, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      try
      {
        ArticleInfo localArticleInfo = this.b.a();
        kvx.a(localArticleInfo, localArticleInfo.mProteusTemplateBean, paramViewBase);
        int j = 0;
        if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), "com.tencent.reading"))
        {
          i = j;
          if (this.b.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 2)
          {
            paramViewBase = lnr.a(this.a, this.b.a().weishiUGInfo.msg_url_jump_info.bytes_jump_schema);
            i = j;
            if (!TextUtils.isEmpty(paramViewBase))
            {
              lnr.a(this.a, this.c.getContext(), paramViewBase);
              break label315;
            }
          }
          if (i == 0)
          {
            paramViewBase = new JSONObject(localArticleInfo.proteusItemsData).getString("kandian_jump_url");
            if (!TextUtils.isEmpty(paramViewBase)) {
              amxk.g((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.c.getContext(), paramViewBase);
            }
          }
          kfq.ma(lnr.a(this.a, this.b.a().weishiUGInfo.bytes_report_base_url) + lnr.a(this.a, this.b.a().weishiUGInfo.bytes_click_report_tail));
        }
        else
        {
          i = j;
          if (this.b.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() != 1) {
            continue;
          }
          paramViewBase = lnr.a(this.a, this.b.a().weishiUGInfo.msg_url_jump_info.bytes_jump_url);
          i = j;
          if (TextUtils.isEmpty(paramViewBase)) {
            continue;
          }
          amxk.g((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.c.getContext(), paramViewBase);
        }
      }
      catch (Exception paramViewBase)
      {
        return;
      }
      label315:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lns
 * JD-Core Version:    0.7.0.1
 */