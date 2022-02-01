import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.Comparator;

class lhd
  implements Comparator<AdvertisementInfo>
{
  lhd(lhb paramlhb) {}
  
  public int a(AdvertisementInfo paramAdvertisementInfo1, AdvertisementInfo paramAdvertisementInfo2)
  {
    return paramAdvertisementInfo1.mAdKdPos - paramAdvertisementInfo2.mAdKdPos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhd
 * JD-Core Version:    0.7.0.1
 */