import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class kgg
  implements lhf.a
{
  kgg(kge paramkge, lhf paramlhf) {}
  
  private long a(List<ArticleInfo> paramList)
  {
    paramList = paramList.iterator();
    long l = 0L;
    if (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      if (l >= localArticleInfo.mRecommendSeq) {
        break label50;
      }
      l = localArticleInfo.mRecommendSeq;
    }
    label50:
    for (;;)
    {
      break;
      return l;
    }
  }
  
  public List<ArticleInfo> a(int paramInt, List<ArticleInfo> paramList1, List<ArticleInfo> paramList2)
  {
    if ((!kys.dv(paramInt)) || (paramList2 == null) || (paramList1 == null) || (paramList2.isEmpty())) {
      return null;
    }
    long l = a(paramList2);
    if (l < 1000L)
    {
      QLog.d("ReadInJoyDailyViewController", 1, "onPreDeal : " + l);
      return null;
    }
    paramList2 = new ArrayList();
    if (!kge.access$300())
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramList1.next();
        if ((localArticleInfo.mRecommendSeq > 0L) && (localArticleInfo.mRecommendSeq < 1000L))
        {
          localArticleInfo.mRecommendSeq += l;
          paramList2.add(localArticleInfo);
          QLog.d("ReadInJoyDailyViewController", 1, "onPreDeal : " + l + "  seq: " + localArticleInfo.mRecommendSeq);
        }
      }
    }
    awit.H(kge.access$400(), Boolean.valueOf(true));
    kge.access$302(true);
    this.jdField_a_of_type_Lhf.a(null);
    return paramList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgg
 * JD-Core Version:    0.7.0.1
 */