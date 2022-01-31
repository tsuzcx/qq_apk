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

public class ybp
  extends BaseShortVideoOprerator
{
  public ybp() {}
  
  public ybp(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public axdt a(Object paramObject, axeg paramaxeg)
  {
    return null;
  }
  
  public axew a(Object paramObject, axeg paramaxeg)
  {
    if (paramObject == null)
    {
      aune.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
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
      axew localaxew = new axew();
      localaxew.jdField_c_of_type_JavaLangString = str7;
      localaxew.h = str5;
      localaxew.j = str4;
      localaxew.b = m;
      localaxew.jdField_d_of_type_JavaLangString = str6;
      localaxew.jdField_e_of_type_Int = ((int)l);
      localaxew.f = k;
      localaxew.jdField_e_of_type_JavaLangString = str3;
      localaxew.jdField_c_of_type_Boolean = bool;
      localaxew.jdField_c_of_type_Int = j;
      localaxew.jdField_d_of_type_Int = i;
      localaxew.jdField_g_of_type_Int = paramaxeg.a;
      localaxew.jdField_a_of_type_JavaLangObject = paramObject;
      localaxew.jdField_g_of_type_JavaLangString = str2;
      localaxew.l = str1;
      localaxew.k = ((String)localObject);
      aune.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localaxew;
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
  
  public MessageRecord a(axdt paramaxdt)
  {
    return null;
  }
  
  public MessageRecord a(axew paramaxew)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = axaq.a(this.a, paramaxew.jdField_c_of_type_JavaLangString, paramaxew.jdField_d_of_type_JavaLangString, paramaxew.b);
    localMessageForDevLittleVideo.videoFileName = paramaxew.h;
    if (paramaxew.jdField_a_of_type_JavaLangString == null) {
      paramaxew.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = paramaxew.jdField_a_of_type_JavaLangString;
    if (paramaxew.jdField_e_of_type_JavaLangString == null) {
      paramaxew.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = paramaxew.jdField_c_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = paramaxew.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = paramaxew.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = paramaxew.f;
    localMessageForDevLittleVideo.thumbWidth = paramaxew.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = paramaxew.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = paramaxew.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = paramaxew.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = paramaxew.jdField_g_of_type_JavaLangString;
    if (paramaxew.l == null) {
      paramaxew.l = "";
    }
    localMessageForDevLittleVideo.fileSource = paramaxew.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = ajyc.a(2131703239);
    localMessageForDevLittleVideo.serial();
    paramaxew.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    aune.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    aune.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public void a(auop paramauop) {}
  
  public void a(axew paramaxew)
  {
    aune.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, paramaxew));
  }
  
  public boolean a(String paramString)
  {
    yak localyak = (yak)this.a.a(51);
    DeviceInfo localDeviceInfo = localyak.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localyak.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!bbjw.a(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ybp
 * JD-Core Version:    0.7.0.1
 */