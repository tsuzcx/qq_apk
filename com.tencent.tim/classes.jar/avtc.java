import android.os.Environment;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class avtc
{
  public static final String Iw;
  public static final String Ix;
  public static final String ROOT_PATH = aqum.a().getExternalPath();
  public static final String SERVER_DIR;
  public static final String VIDEO_CONFIG = aqul.getSDKPrivatePath("Tencent/qzone_video_local_config.json");
  public static final String cNA;
  public static final String cNB;
  public static final String cNC;
  public static final String cND;
  public static final String cNE;
  public static final String cNF;
  public static final String cNG;
  public static final String cNo = aqul.getSDKPrivatePath("qzone");
  public static final String cNp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
  public static final String cNq = cNp + File.separator + "Camera";
  public static final String cNr = aqul.getSDKPrivatePath("Tencent/Qzone/AlbumAutoVConvGif/");
  public static final String cNs = aqul.getSDKPrivatePath("Tencent/Qzone/VoiceMoodAudio/");
  public static final String cNt = aqul.getSDKPrivatePath("jcedata/businessdata/");
  public static final String cNu;
  public static final String cNv;
  public static final String cNw;
  public static final String cNx;
  public static final String cNy;
  public static final String cNz;
  public static final String zj;
  
  static
  {
    Iw = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "qzone" + File.separator + "thumbs" + File.separator);
    Ix = cNo + File.separator + "MaxVideo";
    cNu = ROOT_PATH + File.separator + "ix.jpg";
    cNv = ROOT_PATH + File.separator + "Tencent" + File.separator + "MobileQQ" + File.separator + "trace";
    SERVER_DIR = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv";
    cNw = SERVER_DIR + File.separator + "testserver";
    cNx = ROOT_PATH + File.separator + "Tencent" + File.separator + "qzonebackup";
    cNy = ROOT_PATH + File.separator + "Tencent" + File.separator + "wns";
    cNz = ROOT_PATH + File.separator + "Tencent/Qzone/qzonedynamicalbum/";
    cNA = aqul.getSDKPrivatePath("qzone" + File.separator + "imageV2");
    cNB = aqul.getSDKPrivatePath("qzone" + File.separator + "video");
    cNC = aqul.getSDKPrivatePath("qzone" + File.separator + "video_cache");
    cND = aqul.getSDKPrivatePath("qzone" + File.separator + "image_sr");
    cNE = aqul.getSDKPrivatePath("qzone" + File.separator + "file");
    cNF = aqul.getSDKPrivatePath("qzone" + File.separator + "feeds");
    cNG = aqul.getSDKPrivatePath("Tencent/Qzone/cache");
    zj = aqul.getSDKPrivatePath("Tencent/mobileqq/.emotionsm/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtc
 * JD-Core Version:    0.7.0.1
 */