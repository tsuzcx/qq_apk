import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class xug
  implements wla.a
{
  private xui b;
  private int bXd;
  private String[] cJ;
  private MessageForShortVideo l;
  private QQAppInterface mApp;
  private String mDomain;
  private int mErrCode;
  private long mId;
  private int mType;
  
  public xug(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, xui paramxui, long paramLong, int paramInt1, int paramInt2)
  {
    this.mApp = paramQQAppInterface;
    this.l = paramMessageForShortVideo;
    this.b = paramxui;
    this.mId = paramLong;
    this.bXd = paramInt1;
    this.mType = paramInt2;
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if ((this.l == null) || (this.l.uniseq != paramaoko.uniseq)) {
      if (QLog.isColorLevel()) {
        QLog.d("carverW GetUrlAction", 2, " handleMessage return file.uniseq=" + paramaoko.uniseq);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW GetUrlAction", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2 + " fileType=" + paramaoko.fileType + " status=" + paramaoko.status + " msg.id=" + this.l.uniseq);
                  }
                } while ((paramaoko.fileType != 6) && (paramaoko.fileType != 17) && (paramaoko.fileType != 9) && (paramaoko.fileType != 20));
                switch (paramaoko.status)
                {
                case 2004: 
                default: 
                  return;
                case 2002: 
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW GetUrlAction", 2, "STATUS_RECV_PROCESS: get url finished urls=" + paramaoko.urls + " domain =" + paramaoko.domain + " mMsg=" + this.l);
                  }
                  break;
                }
              } while (paramaoko.urls == null);
              this.cJ = paramaoko.urls;
              this.mDomain = paramaoko.domain;
              paramInt1 = 0;
              while (paramInt1 < 1)
              {
                if (!aqmr.isEmpty(this.mDomain))
                {
                  paramView = new StringBuilder();
                  String[] arrayOfString = this.cJ;
                  arrayOfString[paramInt1] = (arrayOfString[paramInt1] + "&txhost=" + this.mDomain);
                }
                paramInt1 += 1;
              }
            } while (!QLog.isColorLevel());
            QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_FINISHED");
            return;
            this.mErrCode = paramaoko.errorCode;
          } while (!QLog.isColorLevel());
          QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_ERROR  error = " + this.mErrCode);
          return;
          this.mErrCode = paramaoko.errorCode;
        } while (!QLog.isColorLevel());
        QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_UNSAFE  error = " + this.mErrCode);
        return;
        this.mErrCode = paramaoko.errorCode;
      } while (!QLog.isColorLevel());
      QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_EXPIRED  error = " + this.mErrCode);
      return;
    } while ((this.l == null) || (!MessageForShortVideo.class.isInstance(this.l)) || (this.b == null));
    paramView = ShortVideoUtils.a(this.l, "mp4");
    this.b.a(this.mId, this.bXd, this.mType, paramView, this.cJ, this.mDomain, this.l, paramaoko.fileType, null);
  }
  
  public void ceS()
  {
    Object localObject = this.l.frienduin;
    long l1 = this.l.uniseq;
    localObject = this.mApp.a().a((String)localObject, l1);
    if ((localObject != null) && ((localObject instanceof aoji))) {
      ((aoji)localObject).cancel();
    }
    localObject = new View(BaseApplicationImpl.getApplication());
    wla localwla = wla.a(this.mApp);
    if (localwla != null) {
      localwla.a((View)localObject, this);
    }
    localObject = anfr.a(this.mApp, this.l, 1);
    if (localObject != null) {
      anfr.a((angi)localObject, this.mApp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xug
 * JD-Core Version:    0.7.0.1
 */