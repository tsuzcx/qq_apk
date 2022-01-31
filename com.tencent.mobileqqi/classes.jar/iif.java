import java.util.Comparator;
import wifiphoto.WifiPhotoDataCenter;
import wifiphoto.WifiPhotoDataCenter.WpBucketData;

public class iif
  implements Comparator
{
  public iif(WifiPhotoDataCenter paramWifiPhotoDataCenter) {}
  
  public int a(WifiPhotoDataCenter.WpBucketData paramWpBucketData1, WifiPhotoDataCenter.WpBucketData paramWpBucketData2)
  {
    return -Long.valueOf(paramWpBucketData1.a).compareTo(Long.valueOf(paramWpBucketData2.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     iif
 * JD-Core Version:    0.7.0.1
 */