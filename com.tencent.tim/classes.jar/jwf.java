import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

public class jwf
  implements BusinessObserver
{
  public jwf(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (this.this$0.isFirst)
      {
        if (this.this$0.jdField_a_of_type_Jtg == null) {
          break label112;
        }
        this.this$0.jdField_a_of_type_Jtg.hq(false);
        this.this$0.jdField_a_of_type_Jtg.notifyDataSetChanged();
      }
    }
    label398:
    label472:
    for (;;)
    {
      paramBundle = this.this$0;
      paramBundle.aDG -= 1;
      if (this.this$0.aDG == 0) {
        this.this$0.aAt();
      }
      return;
      label112:
      this.this$0.oh(2131697432);
      continue;
      for (;;)
      {
        byte[] arrayOfByte;
        oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse;
        try
        {
          arrayOfByte = paramBundle.getByteArray("data");
          paramInt = paramBundle.getInt("type", 0);
          if (arrayOfByte == null) {
            break label540;
          }
          paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
          if (paramInt != 0) {
            break label344;
          }
          paramBundle.mergeFrom(arrayOfByte);
          paramBoolean = true;
          if (!paramBoolean) {
            break label484;
          }
          if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() != 0) {
            break label472;
          }
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && ((!paramBundle.seqno.has()) || (paramBundle.seqno.get() == this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno))) {
            break label398;
          }
          if (QLog.isColorLevel()) {
            QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + paramBundle.seqno.get());
          }
          this.this$0.b = paramBundle;
          paramBundle = new AccountDetail(this.this$0.b);
          if (ocp.getAccountType(paramBundle.accountFlag) != -5) {
            break label356;
          }
          this.this$0.aAv();
        }
        catch (Exception paramBundle)
        {
          this.this$0.oh(2131697432);
          QLog.w("com.tencent.biz.pubaccount.AccountDetailActivity", 4, paramBundle.getMessage(), paramBundle);
        }
        break;
        label344:
        paramBoolean = ocp.a(arrayOfByte, localGetPublicAccountDetailInfoResponse, paramBundle);
      }
      label356:
      if ((this.this$0.abV) && (paramBundle.followType == 1))
      {
        this.this$0.a(paramBundle, false);
      }
      else
      {
        this.this$0.a(paramBundle, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: seqno is same, no need to update, seqno = " + this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
        }
        if ((this.this$0.abV) && (this.this$0.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1))
        {
          this.this$0.azt();
          continue;
          this.this$0.oh(2131697432);
          continue;
          label484:
          if (this.this$0.isFirst) {
            if (this.this$0.jdField_a_of_type_Jtg != null)
            {
              this.this$0.jdField_a_of_type_Jtg.hq(false);
              this.this$0.jdField_a_of_type_Jtg.notifyDataSetChanged();
            }
            else
            {
              this.this$0.oh(2131697432);
              continue;
              if (this.this$0.isFirst) {
                if (this.this$0.jdField_a_of_type_Jtg != null)
                {
                  this.this$0.jdField_a_of_type_Jtg.hq(false);
                  this.this$0.jdField_a_of_type_Jtg.notifyDataSetChanged();
                }
                else
                {
                  this.this$0.oh(2131697432);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwf
 * JD-Core Version:    0.7.0.1
 */