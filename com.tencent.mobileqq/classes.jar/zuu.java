import android.content.Intent;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.file.DevLittleVideoOperator.1;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class zuu
  extends BaseShortVideoOprerator
{
  public zuu() {}
  
  public zuu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public azdi a(Object paramObject, azdx paramazdx)
  {
    return null;
  }
  
  public azen a(Object paramObject, azdx paramazdx)
  {
    if (paramObject == null)
    {
      awiw.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str7 = "0";
    String str6 = "0";
    int m = 0;
    long l = 0L;
    int k = 0;
    String str5 = "";
    String str4 = "";
    Object localObject = "";
    String str3 = "";
    boolean bool = false;
    int j = 0;
    int i = 0;
    String str2 = "";
    String str1 = "";
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      str7 = ((Intent)localObject).getStringExtra("uin");
      str6 = ((Intent)localObject).getStringExtra("troop_uin");
      m = ((Intent)localObject).getIntExtra("uintype", 1003);
      l = ((Intent)localObject).getLongExtra("file_send_size", 0L);
      ((Intent)localObject).getIntExtra("file_send_business_type", -1);
      k = ((Intent)localObject).getIntExtra("file_send_duration", -1);
      str5 = ((Intent)localObject).getStringExtra("file_send_path");
      str4 = ((Intent)localObject).getStringExtra("thumbfile_send_path");
      str3 = ((Intent)localObject).getStringExtra("file_shortvideo_md5");
      bool = ((Intent)localObject).getBooleanExtra("mediacodec_encode_enable", false);
      j = ((Intent)localObject).getIntExtra("thumbfile_send_width", 0);
      i = ((Intent)localObject).getIntExtra("thumbfile_send_height", 0);
      str2 = ((Intent)localObject).getStringExtra("thumbfile_md5");
      str1 = ((Intent)localObject).getStringExtra("file_source");
      localObject = ((Intent)localObject).getStringExtra("file_video_source_dir");
    }
    for (;;)
    {
      azen localazen = new azen();
      localazen.jdField_c_of_type_JavaLangString = str7;
      localazen.h = str5;
      localazen.j = str4;
      localazen.b = m;
      localazen.jdField_d_of_type_JavaLangString = str6;
      localazen.jdField_e_of_type_Int = ((int)l);
      localazen.f = k;
      localazen.jdField_e_of_type_JavaLangString = str3;
      localazen.jdField_c_of_type_Boolean = bool;
      localazen.jdField_c_of_type_Int = j;
      localazen.jdField_d_of_type_Int = i;
      localazen.jdField_g_of_type_Int = paramazdx.a;
      localazen.jdField_a_of_type_JavaLangObject = paramObject;
      localazen.jdField_g_of_type_JavaLangString = str2;
      localazen.l = str1;
      localazen.k = ((String)localObject);
      awiw.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localazen;
      if ((paramObject instanceof MessageForDevLittleVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        str7 = ((MessageForShortVideo)localObject).frienduin;
        str6 = ((MessageForShortVideo)localObject).frienduin;
        m = ((MessageForShortVideo)localObject).istroop;
        l = ((MessageForShortVideo)localObject).videoFileSize;
        k = ((MessageForShortVideo)localObject).videoFileTime;
        str5 = ((MessageForShortVideo)localObject).videoFileName;
        str4 = ShortVideoUtils.a(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        str3 = ((MessageForShortVideo)localObject).md5;
        bool = ((MessageForShortVideo)localObject).mediacodecEncode;
        j = ((MessageForShortVideo)localObject).thumbWidth;
        i = ((MessageForShortVideo)localObject).thumbHeight;
        str2 = ((MessageForShortVideo)localObject).thumbMD5;
        str1 = ((MessageForShortVideo)localObject).fileSource;
        localObject = ((MessageForShortVideo)localObject).mVideoFileSourceDir;
      }
    }
  }
  
  public MessageRecord a(azdi paramazdi)
  {
    return null;
  }
  
  public MessageRecord a(azen paramazen)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = azaf.a(this.a, paramazen.jdField_c_of_type_JavaLangString, paramazen.jdField_d_of_type_JavaLangString, paramazen.b);
    localMessageForDevLittleVideo.videoFileName = paramazen.h;
    if (paramazen.jdField_a_of_type_JavaLangString == null) {
      paramazen.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = paramazen.jdField_a_of_type_JavaLangString;
    if (paramazen.jdField_e_of_type_JavaLangString == null) {
      paramazen.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = paramazen.jdField_c_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = paramazen.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = paramazen.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = paramazen.f;
    localMessageForDevLittleVideo.thumbWidth = paramazen.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = paramazen.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = paramazen.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = paramazen.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = paramazen.jdField_g_of_type_JavaLangString;
    if (paramazen.l == null) {
      paramazen.l = "";
    }
    localMessageForDevLittleVideo.fileSource = paramazen.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = alud.a(2131703634);
    localMessageForDevLittleVideo.serial();
    paramazen.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    awiw.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    awiw.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public void a(awki paramawki) {}
  
  public void a(azen paramazen)
  {
    awiw.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, paramazen));
  }
  
  public boolean a(String paramString)
  {
    ztp localztp = (ztp)this.a.a(51);
    DeviceInfo localDeviceInfo = localztp.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localztp.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!bdnn.a(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zuu
 * JD-Core Version:    0.7.0.1
 */