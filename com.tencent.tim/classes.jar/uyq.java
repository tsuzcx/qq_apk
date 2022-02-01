import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.12.2;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;

public class uyq
  implements DialogInterface.OnClickListener
{
  public uyq(FriendProfileCardActivity.12.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (aqiw.isNetworkAvailable(this.a.a.this$0))
    {
      this.a.b.Du(this.a.GA);
      if (this.a.a.this$0.jdField_a_of_type_Vbv != null) {
        this.a.a.this$0.jdField_a_of_type_Vbv.bPq();
      }
      return;
    }
    this.a.b.cHs();
    this.a.b.eD(this.a.a.this$0.jdField_a_of_type_Alcn.e.uin, "");
    this.a.a.this$0.ci(acfp.m(2131706623), 0);
    this.a.a.this$0.bF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyq
 * JD-Core Version:    0.7.0.1
 */