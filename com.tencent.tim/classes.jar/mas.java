import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;

public class mas
{
  public lie a;
  public lwm.a b;
  
  public static boolean F(ArticleInfo paramArticleInfo)
  {
    return mde.I(paramArticleInfo);
  }
  
  public static boolean G(ArticleInfo paramArticleInfo)
  {
    return mde.G(paramArticleInfo);
  }
  
  public static boolean H(ArticleInfo paramArticleInfo)
  {
    int i = ndi.k(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean c(lie paramlie)
  {
    return (paramlie.getCellType() == 49) || (paramlie.getCellType() == 62) || (paramlie.getCellType() == 63);
  }
  
  public static boolean d(lie paramlie)
  {
    return (paramlie.getCellType() == 39) || (paramlie.getCellType() == 116) || (paramlie.getCellType() == 66) || (paramlie.getCellType() == 115) || (paramlie.getCellType() == 122);
  }
  
  public static boolean e(lie paramlie)
  {
    switch (paramlie.getCellType())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean f(lie paramlie)
  {
    return paramlie.oF() == 3;
  }
  
  public static boolean g(lie paramlie)
  {
    return paramlie.getCellType() == 10;
  }
  
  public static boolean h(lie paramlie)
  {
    return paramlie.getCellType() == 11;
  }
  
  public static boolean i(lie paramlie)
  {
    return paramlie.getCellType() == 12;
  }
  
  public static boolean j(lie paramlie)
  {
    return paramlie.getCellType() == 27;
  }
  
  public static boolean k(lie paramlie)
  {
    return paramlie.getCellType() == 28;
  }
  
  public static boolean l(lie paramlie)
  {
    return mde.dP(paramlie.getCellType());
  }
  
  public static boolean m(lie paramlie)
  {
    return mde.dO(paramlie.getCellType());
  }
  
  public boolean CV()
  {
    return f(this.a);
  }
  
  public boolean CW()
  {
    return g(this.a);
  }
  
  public boolean CX()
  {
    return h(this.a);
  }
  
  public boolean CY()
  {
    return i(this.a);
  }
  
  public boolean CZ()
  {
    return j(this.a);
  }
  
  public boolean Da()
  {
    return (this.a.getCellType() == 50) || (this.a.getCellType() == 51) || (this.a.getCellType() == 52);
  }
  
  public boolean Db()
  {
    return k(this.a);
  }
  
  public boolean Dc()
  {
    return c(this.a);
  }
  
  public boolean Dd()
  {
    return l(this.a);
  }
  
  public boolean De()
  {
    return m(this.a);
  }
  
  public boolean Df()
  {
    return e(this.a);
  }
  
  public boolean Dg()
  {
    return this.a.getCellType() == 16;
  }
  
  public boolean Dh()
  {
    return d(this.a);
  }
  
  public lie a()
  {
    return this.a;
  }
  
  public void b(lwm.a parama)
  {
    this.b = parama;
  }
  
  public long cG()
  {
    if ((this.a != null) && (this.a.a() != null) && (this.a.a().mSocialFeedInfo != null) && (this.a.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.a.a().mSocialFeedInfo.a.cuin;
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int oP()
  {
    if ((Dh()) && ((this.a.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.a.a());
    }
    return 0;
  }
  
  public void setModel(lie paramlie)
  {
    this.a = paramlie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mas
 * JD-Core Version:    0.7.0.1
 */