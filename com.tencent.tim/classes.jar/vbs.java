import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class vbs
  implements DialogInterface.OnClickListener
{
  public vbs(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anot.a(this.this$0.app, "dc00898", "", "", "0X800A0D9", "0X800A0D9", 0, 0, "", "", "", "");
    if (aqiw.isNetSupport(this.this$0)) {
      FriendProfileMoreInfoActivity.b(this.this$0);
    }
    FriendProfileMoreInfoActivity.a(this.this$0, "https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbs
 * JD-Core Version:    0.7.0.1
 */