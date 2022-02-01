import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class obi
  extends aook
{
  obi(obh paramobh) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || ((localaoko.fileType != 24) && (localaoko.fileType != 32))) {}
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
                  } while ((localaoko.fileType == 24) && (localaoko.commandId != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.er.remove(Long.valueOf(localaoko.uniseq));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.c.j(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localaoko.uniseq);
              return;
              paramMessage = (Bundle)this.a.es.remove(Long.valueOf(localaoko.uniseq));
              this.a.eV(localaoko.uniseq);
              this.a.eW(localaoko.uniseq);
            } while (paramMessage == null);
            if (localaoko.fileType == 32)
            {
              new obu();
              paramMessage.putLong("uniseq", localaoko.uniseq);
              paramMessage.putString("pic_server_id", obu.le());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localaoko.uniseq);
              }
              this.a.c.j(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localaoko.uniseq);
              paramMessage.putString("pic_server_id", localaoko.fileUrl);
            }
            paramMessage = (Bundle)this.a.es.remove(Long.valueOf(localaoko.uniseq));
            this.a.eV(localaoko.uniseq);
            this.a.eW(localaoko.uniseq);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localaoko.uniseq);
          }
          paramMessage.putLong("uniseq", localaoko.uniseq);
          paramMessage.putString("pic_server_id", "-1");
          this.a.c.j(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.er.remove(Long.valueOf(localaoko.uniseq));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.c.j(25, paramMessage);
        return;
        this.a.eW(localaoko.uniseq);
        paramMessage = (Bundle)this.a.es.remove(Long.valueOf(localaoko.uniseq));
      } while (paramMessage == null);
      if (localaoko.fileType == 32) {
        paramMessage.putString("pic_local_id", new obu().fn(null));
      }
      this.a.c.j(26, paramMessage);
      return;
      this.a.eW(localaoko.uniseq);
      paramMessage = (Bundle)this.a.es.remove(Long.valueOf(localaoko.uniseq));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.c.j(26, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obi
 * JD-Core Version:    0.7.0.1
 */