import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class lrh
{
  public static void a(Container paramContainer, lie paramlie, String paramString)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    paramContainer = paramContainer.getVirtualView();
    lro locallro = (lro)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (locallro != null) {
      locallro.setModel(paramlie);
    }
    paramContainer = (lst)paramContainer.findViewBaseByName(paramString);
    if (paramContainer != null)
    {
      long l = 0L;
      if (localArticleInfo.mPartnerAccountInfo != null) {
        l = localArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      }
      paramContainer.em(l);
    }
  }
  
  public static void b(Container paramContainer, lie paramlie)
  {
    a(paramContainer, paramlie, "id_nickname");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrh
 * JD-Core Version:    0.7.0.1
 */