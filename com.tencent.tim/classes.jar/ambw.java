import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.segment.VideoSend.1;
import com.tencent.mobileqq.richmedia.segment.VideoSend.2;
import com.tencent.mobileqq.richmedia.segment.VideoSend.3;
import com.tencent.mobileqq.richmedia.segment.VideoSend.4;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class ambw
  extends ambs
  implements akyf
{
  public akyf.a a;
  ambv a;
  public aolt a;
  public long aiv;
  public ambv b;
  MqqHandler b;
  protected String bZL = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  public ambv c;
  public MessageForLightVideo c;
  boolean cCc = false;
  boolean cCd = false;
  public int dBF;
  aool g;
  public QQAppInterface mApp;
  public int mVideoDuration;
  public ArrayList<ambv> zg = new ArrayList();
  public ArrayList<ambv> zh = new ArrayList();
  
  public ambw(long paramLong)
  {
    super(paramLong);
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  }
  
  public static aool a(MessageForLightVideo paramMessageForLightVideo)
  {
    aool localaool = new aool();
    localaool.F = paramMessageForLightVideo;
    localaool.mSelfUin = paramMessageForLightVideo.selfuin;
    localaool.mPeerUin = paramMessageForLightVideo.frienduin;
    localaool.mUinType = paramMessageForLightVideo.istroop;
    localaool.mUniseq = paramMessageForLightVideo.uniseq;
    localaool.mFileType = paramMessageForLightVideo.fileType;
    localaool.bN = paramMessageForLightVideo.mThumbFilePath;
    localaool.aIf = paramMessageForLightVideo.thumbMD5;
    localaool.cNy = true;
    localaool.mBusiType = paramMessageForLightVideo.busiType;
    return localaool;
  }
  
  private MessageForLightVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = anbi.a(paramQQAppInterface, paramBundle.aTl, paramBundle.troopUin, paramBundle.cZ);
    paramBundle = getThumbPath();
    if (ahbj.fileExistsAndNotEmpty(paramBundle))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramBundle);
      paramQQAppInterface.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      paramQQAppInterface.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      paramQQAppInterface.thumbMD5 = amjg.calcMD5(paramBundle);
      paramQQAppInterface.thumbFileSize = ((int)new File(paramBundle).length());
      localObject = ShortVideoUtils.bw(paramQQAppInterface.thumbMD5, "jpg");
      aqhq.copyFile(paramBundle, (String)localObject);
      paramQQAppInterface.mThumbFilePath = ((String)localObject);
    }
    paramQQAppInterface.lastModified = 0L;
    paramQQAppInterface.fileSource = "camera";
    paramQQAppInterface.extraflag = 32772;
    paramQQAppInterface.videoFileStatus = 999;
    paramQQAppInterface.videoFileFormat = 2;
    paramQQAppInterface.videoFileProgress = 0;
    paramQQAppInterface.busiType = 1;
    paramQQAppInterface.fileType = 327689;
    paramQQAppInterface.fromChatType = -1;
    paramQQAppInterface.toChatType = -1;
    paramQQAppInterface.uiOperatorFlag = 1;
    paramQQAppInterface.mPreUpload = true;
    paramQQAppInterface.serial();
    return paramQQAppInterface;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void a(ambv paramambv)
  {
    this.jdField_b_of_type_MqqOsMqqHandler.post(new VideoSend.2(this, paramambv));
  }
  
  public void a(ambv paramambv, Bundle paramBundle)
  {
    this.jdField_b_of_type_MqqOsMqqHandler.post(new VideoSend.1(this, paramambv, paramBundle));
  }
  
  public void a(aolt paramaolt)
  {
    this.jdField_b_of_type_MqqOsMqqHandler.post(new VideoSend.3(this, paramaolt));
  }
  
  public boolean avo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkAllSliceDone, mThumbInfo:" + this.jdField_a_of_type_Ambv + " mAudioInfo:" + this.jdField_b_of_type_Ambv);
    }
    return (this.jdField_a_of_type_Ambv != null) && (this.jdField_b_of_type_Ambv != null);
  }
  
  public boolean avp()
  {
    return this.cCd;
  }
  
  public void b(akyf.a parama)
  {
    this.jdField_b_of_type_MqqOsMqqHandler.post(new VideoSend.4(this, parama));
  }
  
  public void b(ambv paramambv, Bundle paramBundle)
  {
    this.jdField_a_of_type_Ambv = paramambv;
    paramBundle = a(this.mApp, paramBundle);
    paramBundle.uniseq = Long.parseLong(this.bZL);
    this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo = paramBundle;
    aool localaool = a(paramBundle);
    if (this.dBF == 1) {}
    for (localaool.cND = true;; localaool.cND = false)
    {
      localaool.b = this;
      localaool.extraObject = this;
      this.g = localaool;
      this.mApp.a().a(localaool);
      paramambv.mMd5 = paramBundle.thumbMD5;
      paramambv.mFileLength = paramBundle.thumbFileSize;
      a(paramambv);
      if (this.cCc) {
        dMk();
      }
      return;
    }
  }
  
  public void bme()
  {
    if (this.jdField_a_of_type_Aolt != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "cancelTask");
      }
      this.jdField_a_of_type_Aolt.cancel();
      this.jdField_a_of_type_Aolt = null;
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void dMk()
  {
    this.cCc = true;
    if ((this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (!this.cCd))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "addMsg");
      }
      this.cCd = true;
      Object localObject = (ambj)this.mApp.getManager(326);
      ((ambj)localObject).p(this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
      ((ambj)localObject).d(this.jdField_c_of_type_ComTencentMobileqqDataMessageForLightVideo, null);
      if (this.jdField_a_of_type_Aolt != null)
      {
        localObject = this.jdField_a_of_type_Aolt.b();
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "check processor status:" + ((aoko)localObject).status);
        }
        if (((aoko)localObject).status == 1007) {
          this.jdField_a_of_type_Aolt.Rb(false);
        }
      }
    }
  }
  
  public void destroy()
  {
    if ((this.jdField_a_of_type_Akyf$a != null) && (this.jdField_c_of_type_Ambv != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "destroy");
      }
      ambr.a(this.mApp).a(this);
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambw
 * JD-Core Version:    0.7.0.1
 */