import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;

public class aafd
{
  public QQAppInterface mApp;
  
  public boolean a(MessageForScribble paramMessageForScribble, String paramString, akyf paramakyf)
  {
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.mFileType = 262153;
    localaool.mSelfUin = paramMessageForScribble.selfuin;
    localaool.mPeerUin = paramMessageForScribble.frienduin;
    localaool.mUinType = paramMessageForScribble.istroop;
    localaool.mUniseq = paramMessageForScribble.uniseq;
    localaool.b = paramakyf;
    localaool.dQ = paramString;
    localaool.F = paramMessageForScribble;
    paramMessageForScribble.fileUploadStatus = 3;
    this.mApp.a().a(localaool);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafd
 * JD-Core Version:    0.7.0.1
 */