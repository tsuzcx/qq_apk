import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.widget.ListView.d;

public class vam
  implements ListView.d
{
  public vam(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void j(int paramInt1, int paramInt2, int paramInt3)
  {
    FriendProfileCardActivity.a(this.this$0, paramInt1);
    if ((paramInt1 + paramInt2 != paramInt3) || (paramInt3 <= 0) || (this.this$0.PC()) || (!aqiw.isNetSupport(this.this$0))) {}
    while ((this.this$0.a == null) || (!this.this$0.a.hasMore())) {
      return;
    }
    this.this$0.a.eie();
    this.this$0.xn(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vam
 * JD-Core Version:    0.7.0.1
 */