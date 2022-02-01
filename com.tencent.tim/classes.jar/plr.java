import android.annotation.TargetApi;
import com.tencent.common.config.AppSetting;

@TargetApi(14)
public class plr
{
  public static final Boolean L = Boolean.valueOf(true);
  public static final String asY = acfp.m(2131712217);
  public static final String asZ = acfp.m(2131712214);
  public static final String ata;
  public static final String atb;
  public static final String atc;
  public static final String atd;
  public static final String ate;
  public static final String atf;
  public static final String atg;
  public static final String ath;
  public static final String ati;
  public static final String atj;
  public static final String atk;
  public static final String atl;
  public static final String atm;
  public static final String atn;
  public static final String ato;
  public static final String atp;
  public static final String atq;
  public static final String atr;
  public static final String bY;
  public static boolean isRdmBuild = AppSetting.nT().contains("r");
  
  static
  {
    ata = aasa.SDCARD_ROOT + "/qqstory/";
    atb = ata + "debug/";
    atc = ata + "upload/";
    atd = atc + ".music/";
    ate = ata + ".tmp/";
    atf = ate + "download/preload/";
    atg = ate + "download/mine/";
    bY = ate + ".tmp/";
    ath = bY + "watermark/";
    ati = bY + "merge/";
    atj = bY + "audio/";
    atk = bY + "video/";
    atl = bY + "slideshow/";
    atm = bY + "textfilter/";
    atn = bY + "pk/result/";
    ato = ath + "source/";
    atp = ath + "doodle/";
    atq = ath + "composite/";
    atr = ath + "download/";
  }
  
  public static String bR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "VIDEO";
    case 1: 
      return "MASK_PIC";
    }
    return "THUMBNAIL";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plr
 * JD-Core Version:    0.7.0.1
 */