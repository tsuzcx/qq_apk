import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class usc
  extends TransProcessorHandler
{
  usc(usb paramusb) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || ((localFileMsg.fileType != 24) && (localFileMsg.fileType != 32))) {}
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
                  do
                  {
                    return;
                  } while ((localFileMsg.fileType == 24) && (localFileMsg.commandId != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localFileMsg.uniseq));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localFileMsg.uniseq);
              return;
              paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.uniseq));
              this.a.a(localFileMsg.uniseq);
              this.a.b(localFileMsg.uniseq);
            } while (paramMessage == null);
            if (localFileMsg.fileType == 32)
            {
              new usx();
              paramMessage.putLong("uniseq", localFileMsg.uniseq);
              paramMessage.putString("pic_server_id", usx.a());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localFileMsg.uniseq);
              }
              this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localFileMsg.uniseq);
              paramMessage.putString("pic_server_id", localFileMsg.fileUrl);
            }
            paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.uniseq));
            this.a.a(localFileMsg.uniseq);
            this.a.b(localFileMsg.uniseq);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localFileMsg.uniseq);
          }
          paramMessage.putLong("uniseq", localFileMsg.uniseq);
          paramMessage.putString("pic_server_id", "-1");
          this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localFileMsg.uniseq));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramMessage);
        return;
        this.a.b(localFileMsg.uniseq);
        paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.uniseq));
      } while (paramMessage == null);
      if (localFileMsg.fileType == 32) {
        paramMessage.putString("pic_local_id", new usx().a(null));
      }
      this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
      return;
      this.a.b(localFileMsg.uniseq);
      paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localFileMsg.uniseq));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usc
 * JD-Core Version:    0.7.0.1
 */