import java.util.Comparator;
import wifiphoto.WifiPhotoDataCenter;
import wifiphoto.WifiPhotoDataCenter.WpBucketData;

public class fmb
  implements Comparator
{
  public fmb(WifiPhotoDataCenter paramWifiPhotoDataCenter) {}
  
  public int a(WifiPhotoDataCenter.WpBucketData paramWpBucketData1, WifiPhotoDataCenter.WpBucketData paramWpBucketData2)
  {
    return -Long.valueOf(paramWpBucketData1.a).compareTo(Long.valueOf(paramWpBucketData2.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fmb
 * JD-Core Version:    0.7.0.1
 */