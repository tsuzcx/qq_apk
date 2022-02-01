import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class afsw
  implements aolm.b
{
  public afsw(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(aomh paramaomh)
  {
    int i = 0;
    afsi.b localb = (afsi.b)paramaomh.b.U();
    if (localb != null)
    {
      if (paramaomh.mResult == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + paramaomh.mErrCode + ", errorMsg: " + paramaomh.clO + ", file: " + localb.url);
    }
    for (;;)
    {
      if ((i != 0) && (afss.a(this.a.this$0, localb)))
      {
        ((afsg)afss.a(this.a.this$0).getBusinessHandler(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      afss.a(this.a.this$0, localb);
      return;
      label147:
      if (!localb.md5.equalsIgnoreCase(SecUtil.getFileMd5(paramaomh.b.atY)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localb.url + "md5 is not match. ：" + SecUtil.getFileMd5(paramaomh.b.atY) + " infomd5:" + localb.md5);
        aqhq.deleteFile(paramaomh.b.atY);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localb.name + localb.url);
        }
        String str = afwv.uN();
        boolean bool = afss.b(this.a.this$0, paramaomh.b.atY, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsw
 * JD-Core Version:    0.7.0.1
 */