import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.j;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class kpp
{
  private kpp.a a = new kpp.a();
  
  public static kpp.a a(kqf paramkqf, boolean paramBoolean)
  {
    kpp.a locala = new kpp.a();
    if (paramkqf == null) {
      return locala;
    }
    QLog.d("RIJNewBiuCardTransformManager", 1, "convertRespToBiuInfo | respData : " + paramkqf.toString() + " ,isFromRecommentFeeds:" + paramBoolean);
    locala.agW = paramBoolean;
    locala.sD = paramkqf.ch();
    locala.articleInfo = paramkqf.a();
    locala.biuComment = paramkqf.ii();
    locala.aKX = paramkqf.nB();
    locala.abz = paramkqf.getCardJumpUrl();
    locala.commentBtnJumpUrl = paramkqf.iF();
    locala.commentShareUrl = paramkqf.iE();
    locala.contentSrc = paramkqf.getContentSrc();
    return locala;
  }
  
  public static kpp a()
  {
    return kpp.b.b();
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    int i = ndi.b(paramArticleInfo, 0);
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList | type : " + i);
    if ((i == 0) || (i == 3) || (i == 1) || (i == 5) || (i == 6) || (i == 126) || (b(paramArticleInfo)))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList | valid type : " + i);
      return true;
    }
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList not in white list");
    return false;
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType articleInfo is null");
      return false;
    }
    if (!paramArticleInfo.isPGCShortContent())
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | is not pgcShortContent");
      return false;
    }
    if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.a == null))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | socialFeedsInfo is null");
      return true;
    }
    int i = paramArticleInfo.mSocialFeedInfo.a.aSS;
    if ((i == 1) || (i == 3) || (i == 4) || (i == 2) || (i == 5))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | longContent out");
      return false;
    }
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | valid shortContent type");
    return true;
  }
  
  public boolean Ak()
  {
    boolean bool = true;
    if (this.a == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | false, biuInfo is null");
      return false;
    }
    if (this.a.articleInfo == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | false, articleInfo is null");
      return false;
    }
    if (this.a.agW)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | should refresh when out from related articles");
      return true;
    }
    if (!lbz.a().A(this.a.articleInfo)) {}
    for (;;)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | shouldRefresh: " + bool);
      return bool;
      bool = false;
    }
  }
  
  public void a(kpp.a parama)
  {
    if (parama != null)
    {
      this.a = parama;
      QLog.d("RIJNewBiuCardTransformManager", 2, "updateBiuInfo | mBiuInfo  : " + this.a);
      aFQ();
    }
  }
  
  public void aFP()
  {
    if (this.a == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "transformCard | mBiuInfo is null");
      return;
    }
    lbz.a().b(this.a);
    QLog.d("RIJNewBiuCardTransformManager", 1, " transformCard | mBiuInfo " + this.a);
  }
  
  public void aFQ()
  {
    QQAppInterface localQQAppInterface = kxm.a();
    if (localQQAppInterface != null)
    {
      Object localObject = (lcd)localQQAppInterface.getManager(163);
      if (localObject != null)
      {
        localObject = ((lcd)localObject).b().a();
        if (localObject != null) {
          ((lij)localObject).a(localQQAppInterface.getLongAccountUin(), new kpq(this));
        }
      }
    }
  }
  
  public void aFR()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public static class a
  {
    public int aKX;
    public String aby = "";
    public String abz;
    public boolean agW;
    public ArticleInfo articleInfo;
    public String biuComment = "";
    public String commentBtnJumpUrl = "";
    public String commentShareUrl = "";
    public int contentSrc = -1;
    public long sD = -1L;
    
    public void clear()
    {
      this.agW = false;
      this.sD = -1L;
      this.biuComment = "";
      this.aby = "";
      this.articleInfo = null;
      this.contentSrc = -1;
      this.abz = "";
      this.commentShareUrl = "";
      this.aKX = 0;
    }
    
    public String toString()
    {
      return "BiuInfo{isFromRecommendFeeds=" + this.agW + ", feedsID=" + this.sD + ", biuComment='" + this.biuComment + '\'' + ", biuMediaUrl='" + this.aby + '\'' + ", articleInfo=" + this.articleInfo + ", contentSrc=" + this.contentSrc + ", commentBtnJumpUrl='" + this.commentBtnJumpUrl + '\'' + ", commentShareUrl='" + this.commentShareUrl + '\'' + ", cardJumpUrl='" + this.abz + '\'' + ", isCardAvailable=" + this.aKX + '}';
    }
  }
  
  static class b
  {
    private static final kpp b = new kpp(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpp
 * JD-Core Version:    0.7.0.1
 */