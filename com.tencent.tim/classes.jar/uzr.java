import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class uzr
  implements ausj.a
{
  uzr(uzn paramuzn, int[] paramArrayOfInt, jln paramjln) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.fq[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.fq) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_Jln.dismiss();
    switch (i)
    {
    default: 
      return;
    case 1: 
      FriendProfileCardActivity.a(this.jdField_a_of_type_Uzn.this$0.app, this.jdField_a_of_type_Uzn.this$0, this.jdField_a_of_type_Uzn.this$0.a);
      anot.a(this.jdField_a_of_type_Uzn.this$0.app, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
      return;
    }
    paramView = new SessionInfo();
    paramView.cZ = aqep.b(this.jdField_a_of_type_Uzn.this$0.a.e);
    paramView.aTl = this.jdField_a_of_type_Uzn.this$0.a.e.uin;
    paramView.aTn = FriendProfileCardActivity.a(this.jdField_a_of_type_Uzn.this$0.a, this.jdField_a_of_type_Uzn.this$0.app);
    paramView.troopUin = this.jdField_a_of_type_Uzn.this$0.a.e.troopUin;
    wmj.a(this.jdField_a_of_type_Uzn.this$0.app, this.jdField_a_of_type_Uzn.this$0, paramView, false, null, null);
    anot.a(this.jdField_a_of_type_Uzn.this$0.app, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzr
 * JD-Core Version:    0.7.0.1
 */