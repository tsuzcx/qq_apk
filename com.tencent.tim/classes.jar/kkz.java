import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class kkz
{
  public AdvertisementInfo advertisementInfo;
  public boolean agf;
  public long clickTime;
  public String hT;
  public long so;
  public long sp;
  public long sq;
  
  public void ar(Bundle paramBundle)
  {
    long l1;
    long l2;
    long l3;
    if (paramBundle != null)
    {
      String str = paramBundle.getString("adid", "");
      l1 = paramBundle.getLong("navigationStart", 0L);
      l2 = paramBundle.getLong("htmlLoaded", 0L);
      l3 = paramBundle.getLong("domComplete", 0L);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.hT)) && (str.equals(this.hT))) {
        break label71;
      }
    }
    label71:
    do
    {
      return;
      if (l1 > 0L) {
        this.so = l1;
      }
      if (l2 > 0L) {
        this.sp = l2;
      }
    } while (l3 <= 0L);
    this.sq = l3;
  }
  
  public boolean isVaild()
  {
    return (this.advertisementInfo != null) && (!TextUtils.isEmpty(this.hT)) && (this.clickTime > 0L) && ((this.so > 0L) || (this.sp > 0L) || (this.sq > 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkz
 * JD-Core Version:    0.7.0.1
 */