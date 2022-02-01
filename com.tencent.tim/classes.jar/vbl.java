import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;

public class vbl
  implements IphonePickerView.c
{
  public vbl(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void dn()
  {
    if ((this.this$0.mActionSheet != null) && (this.this$0.mActionSheet.isShowing())) {
      this.this$0.mActionSheet.dismiss();
    }
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      this.this$0.aWQ = true;
      this.this$0.aD(paramInt1, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbl
 * JD-Core Version:    0.7.0.1
 */