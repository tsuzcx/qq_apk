import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class txq
  extends beyf
{
  txq(txp paramtxp) {}
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || ((localbete.jdField_b_of_type_Int != 24) && (localbete.jdField_b_of_type_Int != 32))) {}
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
                  } while ((localbete.jdField_b_of_type_Int == 24) && (localbete.c != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localbete.jdField_b_of_type_Long));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localbete.jdField_b_of_type_Long);
              return;
              paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localbete.jdField_b_of_type_Long));
              this.a.a(localbete.jdField_b_of_type_Long);
              this.a.b(localbete.jdField_b_of_type_Long);
            } while (paramMessage == null);
            if (localbete.jdField_b_of_type_Int == 32)
            {
              new tyl();
              paramMessage.putLong("uniseq", localbete.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", tyl.a());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localbete.jdField_b_of_type_Long);
              }
              this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localbete.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", localbete.i);
            }
            paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localbete.jdField_b_of_type_Long));
            this.a.a(localbete.jdField_b_of_type_Long);
            this.a.b(localbete.jdField_b_of_type_Long);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localbete.jdField_b_of_type_Long);
          }
          paramMessage.putLong("uniseq", localbete.jdField_b_of_type_Long);
          paramMessage.putString("pic_server_id", "-1");
          this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localbete.jdField_b_of_type_Long));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramMessage);
        return;
        this.a.b(localbete.jdField_b_of_type_Long);
        paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localbete.jdField_b_of_type_Long));
      } while (paramMessage == null);
      if (localbete.jdField_b_of_type_Int == 32) {
        paramMessage.putString("pic_local_id", new tyl().a(null));
      }
      this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
      return;
      this.a.b(localbete.jdField_b_of_type_Long);
      paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localbete.jdField_b_of_type_Long));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txq
 * JD-Core Version:    0.7.0.1
 */