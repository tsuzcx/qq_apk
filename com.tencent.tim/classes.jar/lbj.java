import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.Comparator;

class lbj
  implements Comparator<DynamicChannelDataModel>
{
  lbj(lbg paramlbg) {}
  
  public int a(DynamicChannelDataModel paramDynamicChannelDataModel1, DynamicChannelDataModel paramDynamicChannelDataModel2)
  {
    if (paramDynamicChannelDataModel1.recommendSeq == paramDynamicChannelDataModel2.recommendSeq) {
      return 0;
    }
    if (paramDynamicChannelDataModel1.recommendSeq < paramDynamicChannelDataModel2.recommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbj
 * JD-Core Version:    0.7.0.1
 */