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

public class ybm
  extends BaseShortVideoOprerator
{
  public ybm() {}
  
  public ybm(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public axdv a(Object paramObject, axei paramaxei)
  {
    return null;
  }
  
  public axey a(Object paramObject, axei paramaxei)
  {
    if (paramObject == null)
    {
      aung.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
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
      axey localaxey = new axey();
      localaxey.jdField_c_of_type_JavaLangString = str7;
      localaxey.h = str5;
      localaxey.j = str4;
      localaxey.b = m;
      localaxey.jdField_d_of_type_JavaLangString = str6;
      localaxey.jdField_e_of_type_Int = ((int)l);
      localaxey.f = k;
      localaxey.jdField_e_of_type_JavaLangString = str3;
      localaxey.jdField_c_of_type_Boolean = bool;
      localaxey.jdField_c_of_type_Int = j;
      localaxey.jdField_d_of_type_Int = i;
      localaxey.jdField_g_of_type_Int = paramaxei.a;
      localaxey.jdField_a_of_type_JavaLangObject = paramObject;
      localaxey.jdField_g_of_type_JavaLangString = str2;
      localaxey.l = str1;
      localaxey.k = ((String)localObject);
      aung.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localaxey;
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
  
  public MessageRecord a(axdv paramaxdv)
  {
    return null;
  }
  
  public MessageRecord a(axey paramaxey)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = axas.a(this.a, paramaxey.jdField_c_of_type_JavaLangString, paramaxey.jdField_d_of_type_JavaLangString, paramaxey.b);
    localMessageForDevLittleVideo.videoFileName = paramaxey.h;
    if (paramaxey.jdField_a_of_type_JavaLangString == null) {
      paramaxey.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = paramaxey.jdField_a_of_type_JavaLangString;
    if (paramaxey.jdField_e_of_type_JavaLangString == null) {
      paramaxey.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = paramaxey.jdField_c_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = paramaxey.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = paramaxey.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = paramaxey.f;
    localMessageForDevLittleVideo.thumbWidth = paramaxey.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = paramaxey.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = paramaxey.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = paramaxey.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = paramaxey.jdField_g_of_type_JavaLangString;
    if (paramaxey.l == null) {
      paramaxey.l = "";
    }
    localMessageForDevLittleVideo.fileSource = paramaxey.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = ajya.a(2131703250);
    localMessageForDevLittleVideo.serial();
    paramaxey.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    aung.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    aung.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public void a(auor paramauor) {}
  
  public void a(axey paramaxey)
  {
    aung.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, paramaxey));
  }
  
  public boolean a(String paramString)
  {
    yah localyah = (yah)this.a.a(51);
    DeviceInfo localDeviceInfo = localyah.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localyah.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!bbkk.a(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ybm
 * JD-Core Version:    0.7.0.1
 */