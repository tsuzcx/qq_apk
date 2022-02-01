import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class mil
{
  private static mhk a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new mgy(paramBaseArticleInfo);
    }
    return new mii(paramBaseArticleInfo);
  }
  
  public static mhk a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (ae(paramBaseArticleInfo)) {
      return a(1, paramBaseArticleInfo);
    }
    return a(0, paramBaseArticleInfo);
  }
  
  public static boolean ae(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (!ndi.aa((ArticleInfo)paramBaseArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mil
 * JD-Core Version:    0.7.0.1
 */