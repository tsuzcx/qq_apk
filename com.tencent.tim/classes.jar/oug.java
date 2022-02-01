import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment;
import java.io.File;
import java.util.HashMap;

public class oug
{
  public static final String aro = QCircleFolderFollowTabFragment.TAG;
  public static final String arp = QCircleFolderRcmdTabFragment.TAG;
  private static final String arq;
  private static final String arr;
  private static final String ars;
  public static final String art;
  public static final String aru;
  public static final String arv;
  public static final String arw;
  public static final String arx;
  public static final String ary;
  public static final String arz;
  public static boolean ayA;
  public static final String[] bK = { "rockey1", "rockey2", "rockey3" };
  public static int bgg = 300;
  public static final HashMap<String, String> eP;
  public static final HashMap<String, String> eQ;
  public static final HashMap<String, String> eR;
  
  static
  {
    arq = aqul.getSDKPrivatePath("cache/");
    arr = aqul.getSDKPrivatePath("file/");
    ars = aqul.getSDKPrivatePath("qcircle/");
    art = ars + "file/";
    aru = ars + "cache/";
    arv = art + "download/";
    arw = arv + "base/";
    arx = arq + "qqcircle_video/";
    ary = art + "animation/";
    arz = arw + "qcircle_download_pics/";
    eP = new HashMap();
    eQ = new HashMap();
    eR = new HashMap();
    eP.put("rockey1", "https://downv6.qq.com/video_story/qcircle/animation/rockey1.zip");
    eP.put("rockey2", "https://downv6.qq.com/video_story/qcircle/animation/rockey2.zip");
    eP.put("rockey3", "https://downv6.qq.com/video_story/qcircle/animation/rockey3.zip");
    eQ.put("rockey1", ary + "rockey1" + File.separator);
    eQ.put("rockey2", ary + "rockey2" + File.separator);
    eQ.put("rockey3", ary + "rockey3" + File.separator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oug
 * JD-Core Version:    0.7.0.1
 */