import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class akfy
  implements DialogInterface.OnClickListener
{
  akfy(akfw paramakfw, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.L.dismiss();
    this.a.this$0.a.dAy();
    paramInt = ((Integer)ajrb.c(this.a.this$0.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    anot.a(this.a.this$0.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, ajrk.eD(this.a.this$0.a.from), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akfy
 * JD-Core Version:    0.7.0.1
 */