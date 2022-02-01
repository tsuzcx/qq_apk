import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator.1;
import com.tencent.qphone.base.util.QLog;

public class amiy
{
  public QQAppInterface mApp;
  
  public amiy(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public MessageForScribble a(MessageForScribble paramMessageForScribble)
  {
    MessageForScribble localMessageForScribble = (MessageForScribble)anbi.e(paramMessageForScribble);
    if (localMessageForScribble == null) {
      QLog.e("CreateResendScribbleMsg", 2, "null msg");
    }
    if (localMessageForScribble != null)
    {
      localMessageForScribble.offSet = paramMessageForScribble.offSet;
      localMessageForScribble.gifId = paramMessageForScribble.gifId;
      localMessageForScribble.localFildPath = paramMessageForScribble.localFildPath;
      localMessageForScribble.combineFileMd5 = paramMessageForScribble.combineFileMd5;
      localMessageForScribble.isread = true;
      localMessageForScribble.fileUploadStatus = 0;
    }
    return localMessageForScribble;
  }
  
  public MessageForScribble a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    MessageForScribble localMessageForScribble = (MessageForScribble)anbi.d(-7001);
    anbi.a(this.mApp, localMessageForScribble, paramString3, paramString3, paramInt2);
    localMessageForScribble.msgtype = -7001;
    localMessageForScribble.offSet = paramInt1;
    localMessageForScribble.gifId = paramInt3;
    localMessageForScribble.localFildPath = paramString1;
    localMessageForScribble.combineFileMd5 = paramString2;
    localMessageForScribble.selfuin = this.mApp.getCurrentAccountUin();
    localMessageForScribble.senderuin = localMessageForScribble.selfuin;
    localMessageForScribble.issend = 1;
    localMessageForScribble.fileUploadStatus = 0;
    return localMessageForScribble;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble)
  {
    ThreadManager.post(new ScribbleBaseOperator.1(this, paramMessageForScribble), 8, null, false);
    return true;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble, akxb paramakxb)
  {
    aool localaool = new aool();
    localaool.cNy = false;
    localaool.mFileType = 262153;
    localaool.mSelfUin = paramMessageForScribble.selfuin;
    localaool.mPeerUin = paramMessageForScribble.frienduin;
    localaool.mUinType = paramMessageForScribble.istroop;
    localaool.mUniseq = paramMessageForScribble.uniseq;
    localaool.jdField_b_of_type_Akxb = paramakxb;
    localaool.F = paramMessageForScribble;
    this.mApp.a().a(localaool);
    return true;
  }
  
  public boolean a(MessageForScribble paramMessageForScribble, String paramString, akyf paramakyf)
  {
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.mFileType = 262153;
    localaool.mSelfUin = paramMessageForScribble.selfuin;
    localaool.mPeerUin = paramMessageForScribble.frienduin;
    localaool.mUinType = paramMessageForScribble.istroop;
    localaool.mUniseq = paramMessageForScribble.uniseq;
    localaool.jdField_b_of_type_Akyf = paramakyf;
    localaool.dQ = paramString;
    localaool.F = paramMessageForScribble;
    paramMessageForScribble.fileUploadStatus = 3;
    this.mApp.a().a(localaool);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amiy
 * JD-Core Version:    0.7.0.1
 */