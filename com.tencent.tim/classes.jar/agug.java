import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class agug
  implements agsu
{
  agug(aguc paramaguc) {}
  
  public void a(aguk.a parama)
  {
    parama = ((agsy)parama).b();
    if (parama == null) {}
    label12:
    do
    {
      do
      {
        do
        {
          break label12;
          do
          {
            return;
          } while ((TextUtils.isEmpty(parama.getFileName())) || (ahav.getFileType(parama.getFileName()) != 0) || (!TextUtils.isEmpty(parama.getFilePath())));
          parama = parama.b();
          if (parama != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DeviceFileModel<FileAssistant>", 2, "mEntity = null");
        return;
        if (TextUtils.isEmpty(parama.strThumbPath)) {
          break;
        }
      } while (this.a.a == null);
      this.a.a.fP(String.valueOf(parama.nSessionId), parama.strThumbPath);
      return;
      parama = this.a.mAppInterface.b().a(parama.peerUin, parama.peerType, parama.msgSeq);
    } while (parama == null);
    parama = (MessageForDeviceSingleStruct)parama;
    szv localszv = ((szy)this.a.mAppInterface.getBusinessHandler(49)).a();
    aguc.a(this.a, localszv.a(parama, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agug
 * JD-Core Version:    0.7.0.1
 */