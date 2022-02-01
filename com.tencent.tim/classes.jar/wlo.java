import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class wlo
  implements DialogInterface.OnClickListener
{
  wlo(wll paramwll) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.this$0.mFriendUin)) && (wll.a(this.this$0) != null))
    {
      if (wll.a(this.this$0) == 1) {
        wll.b(this.this$0, this.this$0.mFriendUin);
      }
    }
    else {
      return;
    }
    wll.a(this.this$0, this.this$0.mFriendUin, wll.a(this.this$0).maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wlo
 * JD-Core Version:    0.7.0.1
 */