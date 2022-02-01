import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class vai
  implements DialogInterface.OnClickListener
{
  public vai(FriendProfileCardActivity paramFriendProfileCardActivity, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card click and aid=" + this.mS + " pay type=" + this.bHe);
    switch (this.bHe)
    {
    case 3: 
    default: 
      Toast.makeText(this.this$0.getApplicationContext(), 2131697311, 0).show();
    }
    for (;;)
    {
      anot.a(this.this$0.app, "dc00898", "", "", "", "0X800A4C2", 0, 0, "", "", "", "");
      this.this$0.bFU();
      return;
      VipUtils.b(this.this$0, 1, this.mS);
      continue;
      VipUtils.c(this.this$0, 1, this.mS);
      continue;
      VipUtils.a(this.this$0, false, 12, false, this.mS);
      continue;
      VipUtils.a(this.this$0, true, 12, false, this.mS);
      continue;
      aqrf.a(this.this$0, this.mS, "SVHHZLH", 0, false, false);
      continue;
      aqrf.a(this.this$0, this.mS, "SVHHZLH", 12, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vai
 * JD-Core Version:    0.7.0.1
 */