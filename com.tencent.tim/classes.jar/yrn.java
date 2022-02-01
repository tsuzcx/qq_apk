import com.tencent.mobileqq.data.MayKnowRecommend;
import java.util.Comparator;

class yrn
  implements Comparator<MayKnowRecommend>
{
  yrn(yri paramyri) {}
  
  public int a(MayKnowRecommend paramMayKnowRecommend1, MayKnowRecommend paramMayKnowRecommend2)
  {
    return paramMayKnowRecommend2.timestamp - paramMayKnowRecommend1.timestamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrn
 * JD-Core Version:    0.7.0.1
 */