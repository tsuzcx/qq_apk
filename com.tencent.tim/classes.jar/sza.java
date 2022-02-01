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

public class sza
  extends BaseShortVideoOprerator
{
  public sza() {}
  
  public sza(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public anfw a(Object paramObject, angi paramangi)
  {
    return null;
  }
  
  public angt a(Object paramObject, angi paramangi)
  {
    if (paramObject == null)
    {
      akxe.M(this.logTag, this.bUB, "createShortVideoUploadInfo", "unknow obj");
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
      angt localangt = new angt();
      localangt.peerUin = str7;
      localangt.localPath = str5;
      localangt.thumbPath = str4;
      localangt.uinType = m;
      localangt.bUG = str6;
      localangt.ceG = ((int)l);
      localangt.dFo = k;
      localangt.md5 = str3;
      localangt.mediacodecEncode = bool;
      localangt.thumbWidth = j;
      localangt.thumbHeight = i;
      localangt.dFp = paramangi.dFq;
      localangt.message = paramObject;
      localangt.thumbMD5 = str2;
      localangt.fileSource = str1;
      localangt.cdH = ((String)localObject);
      akxe.M(this.logTag, this.bUB, "createShortVideoUploadInfo", "");
      return localangt;
      if ((paramObject instanceof MessageForDevLittleVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        str7 = ((MessageForShortVideo)localObject).frienduin;
        str6 = ((MessageForShortVideo)localObject).frienduin;
        m = ((MessageForShortVideo)localObject).istroop;
        l = ((MessageForShortVideo)localObject).videoFileSize;
        k = ((MessageForShortVideo)localObject).videoFileTime;
        str5 = ((MessageForShortVideo)localObject).videoFileName;
        str4 = ShortVideoUtils.bw(((MessageForShortVideo)localObject).thumbMD5, "jpg");
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
  
  public MessageRecord a(anfw paramanfw)
  {
    return null;
  }
  
  public MessageRecord a(angt paramangt)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = anbi.a(this.mApp, paramangt.peerUin, paramangt.bUG, paramangt.uinType);
    localMessageForDevLittleVideo.videoFileName = paramangt.localPath;
    if (paramangt.uuid == null) {
      paramangt.uuid = "";
    }
    localMessageForDevLittleVideo.uuid = paramangt.uuid;
    if (paramangt.md5 == null) {
      paramangt.md5 = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = paramangt.mediacodecEncode;
    localMessageForDevLittleVideo.md5 = paramangt.md5;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = paramangt.ceG;
    localMessageForDevLittleVideo.videoFileTime = paramangt.dFo;
    localMessageForDevLittleVideo.thumbWidth = paramangt.thumbWidth;
    localMessageForDevLittleVideo.thumbHeight = paramangt.thumbHeight;
    localMessageForDevLittleVideo.mThumbFilePath = paramangt.thumbPath;
    localMessageForDevLittleVideo.mVideoFileSourceDir = paramangt.cdH;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = paramangt.thumbMD5;
    if (paramangt.fileSource == null) {
      paramangt.fileSource = "";
    }
    localMessageForDevLittleVideo.fileSource = paramangt.fileSource;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = acfp.m(2131705037);
    localMessageForDevLittleVideo.serial();
    paramangt.uniseq = localMessageForDevLittleVideo.uniseq;
    akxe.M(this.logTag, this.bUB, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    akxe.M(this.logTag, this.bUB, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public void a(akyf.a parama) {}
  
  public void a(angt paramangt)
  {
    akxe.M(this.logTag, this.bUB, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, paramangt));
  }
  
  public boolean gt(String paramString)
  {
    syw localsyw = (syw)this.mApp.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = localsyw.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localsyw.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!aqmr.isEmpty(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sza
 * JD-Core Version:    0.7.0.1
 */