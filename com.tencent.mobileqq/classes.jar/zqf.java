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

public class zqf
  extends BaseShortVideoOprerator
{
  public zqf() {}
  
  public zqf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public ayyz a(Object paramObject, ayzo paramayzo)
  {
    return null;
  }
  
  public azae a(Object paramObject, ayzo paramayzo)
  {
    if (paramObject == null)
    {
      awen.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
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
      azae localazae = new azae();
      localazae.jdField_c_of_type_JavaLangString = str7;
      localazae.h = str5;
      localazae.j = str4;
      localazae.b = m;
      localazae.jdField_d_of_type_JavaLangString = str6;
      localazae.jdField_e_of_type_Int = ((int)l);
      localazae.f = k;
      localazae.jdField_e_of_type_JavaLangString = str3;
      localazae.jdField_c_of_type_Boolean = bool;
      localazae.jdField_c_of_type_Int = j;
      localazae.jdField_d_of_type_Int = i;
      localazae.jdField_g_of_type_Int = paramayzo.a;
      localazae.jdField_a_of_type_JavaLangObject = paramObject;
      localazae.jdField_g_of_type_JavaLangString = str2;
      localazae.l = str1;
      localazae.k = ((String)localObject);
      awen.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localazae;
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
  
  public MessageRecord a(ayyz paramayyz)
  {
    return null;
  }
  
  public MessageRecord a(azae paramazae)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = ayvw.a(this.a, paramazae.jdField_c_of_type_JavaLangString, paramazae.jdField_d_of_type_JavaLangString, paramazae.b);
    localMessageForDevLittleVideo.videoFileName = paramazae.h;
    if (paramazae.jdField_a_of_type_JavaLangString == null) {
      paramazae.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = paramazae.jdField_a_of_type_JavaLangString;
    if (paramazae.jdField_e_of_type_JavaLangString == null) {
      paramazae.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = paramazae.jdField_c_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = paramazae.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = paramazae.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = paramazae.f;
    localMessageForDevLittleVideo.thumbWidth = paramazae.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = paramazae.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = paramazae.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = paramazae.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = paramazae.jdField_g_of_type_JavaLangString;
    if (paramazae.l == null) {
      paramazae.l = "";
    }
    localMessageForDevLittleVideo.fileSource = paramazae.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = alpo.a(2131703622);
    localMessageForDevLittleVideo.serial();
    paramazae.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    awen.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    awen.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public void a(awfz paramawfz) {}
  
  public void a(azae paramazae)
  {
    awen.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, paramazae));
  }
  
  public boolean a(String paramString)
  {
    zpa localzpa = (zpa)this.a.a(51);
    DeviceInfo localDeviceInfo = localzpa.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localzpa.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!bdje.a(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zqf
 * JD-Core Version:    0.7.0.1
 */