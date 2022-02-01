import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class txo
  extends bdzm
{
  txo(txn paramtxn) {}
  
  public void handleMessage(Message paramMessage)
  {
    bduk localbduk = (bduk)paramMessage.obj;
    if ((localbduk == null) || ((localbduk.jdField_b_of_type_Int != 24) && (localbduk.jdField_b_of_type_Int != 32))) {}
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
                  } while ((localbduk.jdField_b_of_type_Int == 24) && (localbduk.c != 10));
                  switch (paramMessage.what)
                  {
                  case 1002: 
                  case 1004: 
                  default: 
                    return;
                  case 1001: 
                    paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localbduk.jdField_b_of_type_Long));
                  }
                } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
                this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(23, paramMessage);
              } while (!QLog.isColorLevel());
              QLog.d("PAH5Manager", 2, "start" + localbduk.jdField_b_of_type_Long);
              return;
              paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localbduk.jdField_b_of_type_Long));
              this.a.a(localbduk.jdField_b_of_type_Long);
              this.a.b(localbduk.jdField_b_of_type_Long);
            } while (paramMessage == null);
            if (localbduk.jdField_b_of_type_Int == 32)
            {
              new tyj();
              paramMessage.putLong("uniseq", localbduk.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", tyj.a());
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PAH5Manager", 2, "finished" + localbduk.jdField_b_of_type_Long);
              }
              this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
              return;
              paramMessage.putLong("uniseq", localbduk.jdField_b_of_type_Long);
              paramMessage.putString("pic_server_id", localbduk.i);
            }
            paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localbduk.jdField_b_of_type_Long));
            this.a.a(localbduk.jdField_b_of_type_Long);
            this.a.b(localbduk.jdField_b_of_type_Long);
          } while (paramMessage == null);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "error" + localbduk.jdField_b_of_type_Long);
          }
          paramMessage.putLong("uniseq", localbduk.jdField_b_of_type_Long);
          paramMessage.putString("pic_server_id", "-1");
          this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramMessage);
          return;
          paramMessage = (Bundle)this.a.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(localbduk.jdField_b_of_type_Long));
        } while ((paramMessage == null) || (paramMessage.getInt("is_showProgress_tips") != 1));
        this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramMessage);
        return;
        this.a.b(localbduk.jdField_b_of_type_Long);
        paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localbduk.jdField_b_of_type_Long));
      } while (paramMessage == null);
      if (localbduk.jdField_b_of_type_Int == 32) {
        paramMessage.putString("pic_local_id", new tyj().a(null));
      }
      this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
      return;
      this.a.b(localbduk.jdField_b_of_type_Long);
      paramMessage = (Bundle)this.a.b.remove(Long.valueOf(localbduk.jdField_b_of_type_Long));
    } while (paramMessage == null);
    paramMessage.putString("pic_local_id", "-1");
    this.a.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txo
 * JD-Core Version:    0.7.0.1
 */