import java.util.HashMap;

public class araq
{
  public static final HashMap<String, Long> pA = new HashMap();
  
  static
  {
    pA.put(ardn.PLUGIN_NAMESPACE, Long.valueOf(4294967295L));
    pA.put("Qzone", Long.valueOf(4294967295L));
    pA.put("qzDynamicAlbum", Long.valueOf(4294967295L));
    pA.put("QZImagePicker", Long.valueOf(4294967295L));
    pA.put("checkin", Long.valueOf(4294967295L));
    pA.put("qzlive", Long.valueOf(4294967295L));
    pA.put("PublicAccountJs", Long.valueOf(4L));
    pA.put("offline", Long.valueOf(3L));
    pA.put(suf.class.getSimpleName(), Long.valueOf(3L));
    pA.put(suw.PLUGIN_NAMESPACE, Long.valueOf(11L));
    pA.put("UrlSaveVerifyV2", Long.valueOf(3L));
    pA.put("forceHttps", Long.valueOf(1L));
    pA.put("qqmusic", Long.valueOf(3L));
    pA.put("emoji", Long.valueOf(32L));
    pA.put("msgRoam", Long.valueOf(1L));
    pA.put("qw.pay", Long.valueOf(32L));
    pA.put("qw_pay", Long.valueOf(32L));
    pA.put("common", Long.valueOf(32L));
    pA.put("readinjoy", Long.valueOf(16777216L));
    pA.put("ArkSecurity", Long.valueOf(3L));
    pA.put("miniApp", Long.valueOf(3L));
    pA.put("gameCenter", Long.valueOf(3L));
  }
  
  public static String bY(long paramLong)
  {
    String str = "";
    if (paramLong == 1L) {
      str = "http";
    }
    do
    {
      return str;
      if (paramLong == 2L) {
        return "https";
      }
      if (paramLong == 4L) {
        return "publicaccount";
      }
      if (paramLong == 8L) {
        return "pay";
      }
      if (paramLong == 16L) {
        return "qqvip";
      }
      if (paramLong == 32L) {
        return "qqjsbridge";
      }
      if (paramLong == 64L) {
        return "tel";
      }
      if (paramLong == 128L) {
        return "sms";
      }
      if (paramLong == 256L) {
        return "mqqapi";
      }
      if (paramLong == 512L) {
        return "mqqopensdkapi";
      }
      if (paramLong == 1024L) {
        return "mqqmdpass";
      }
      if (paramLong == 2048L) {
        return "mqq";
      }
      if (paramLong == 4096L) {
        return "qapp";
      }
      if (paramLong == 8192L) {
        return "mqqflyticket";
      }
      if (paramLong == 16384L) {
        return "mqqwpa";
      }
      if (paramLong == 32768L) {
        return "wtloginmqq";
      }
      if (paramLong == 65536L) {
        return "qqwifi";
      }
      if (paramLong == 131072L) {
        return "apollo";
      }
      if (paramLong == 262144L) {
        return "mqqverifycode";
      }
      if (paramLong == 524288L) {
        return "mqqconnect";
      }
      if (paramLong == 1048576L) {
        return "mqqvoipivr";
      }
      if (paramLong == 2097152L) {
        return "mqqdevlock";
      }
      if (paramLong == 4194304L) {
        return "qqfav";
      }
      if (paramLong == 16777216L) {
        return "readinjoy";
      }
    } while (paramLong != 33554432L);
    return "nowmqqapi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     araq
 * JD-Core Version:    0.7.0.1
 */