import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

class ahqu
  extends aook
{
  ahqu(ahqt paramahqt, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.commandId != 76)) {}
    do
    {
      String str;
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
                switch (paramMessage.what)
                {
                case 1002: 
                case 1006: 
                case 1007: 
                default: 
                  return;
                }
              } while (!QLog.isColorLevel());
              QLog.i("PicOcrManager", 2, "handleMessage start!");
              return;
            } while (!QLog.isColorLevel());
            QLog.d("PicOcrManager", 2, "handleMessage success resId:" + localaoko.serverPath);
            return;
            Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
            str = "";
            paramMessage = str;
            if (localaoko.fL != null) {}
            try
            {
              localCommFileExtRsp.mergeFrom(localaoko.fL);
              paramMessage = str;
              if (localCommFileExtRsp.bytes_download_url.has()) {
                paramMessage = localCommFileExtRsp.bytes_download_url.get().toStringUtf8();
              }
            }
            catch (Exception paramMessage)
            {
              for (;;)
              {
                QLog.i("PicOcrManager", 2, "extRsp.mergeFrom(file.bdhExtendInfo) failed!");
                paramMessage = str;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("PicOcrManager", 2, "handleMessage finished resId:" + localaoko.serverPath + ", url:" + paramMessage);
            }
          } while (TextUtils.isEmpty(paramMessage));
          ahqt.a(this.this$0).bLs = paramMessage;
          paramMessage = (ahqs)ahqt.a(this.this$0).getBusinessHandler(170);
        } while (paramMessage == null);
        paramMessage.a(ahqt.a(this.this$0).bLs, ahqt.a(this.this$0).aaN, ahqt.a(this.this$0).bLq, ahqt.a(this.this$0).bLr, ahqt.a(this.this$0).chatType, (int)ahqt.a(this.this$0).fileSize, ahqt.a(this.this$0).daK, ahqt.a(this.this$0).daL, ahqt.a(this.this$0).aIG, ahqt.a(this.this$0).bLp);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicOcrManager", 2, "handleMessage upload error:" + localaoko.serverPath);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PicOcrManager", 2, "handleMessage upload cancel:" + localaoko.serverPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqu
 * JD-Core Version:    0.7.0.1
 */