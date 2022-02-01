import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class vbp
  extends acfd
{
  public vbp(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((!this.this$0.d.uin.equals(paramString1)) || (!ProfileActivity.AllInOne.b(this.this$0.d))) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.this$0.a.cardName = paramString2;
        return;
      }
      paramString1 = (acff)this.this$0.app.getManager(51);
      if (paramString1 == null) {}
      for (paramString1 = null; (paramString1 != null) && (paramString1.remark != null) && (paramString1.isRemark == 1); paramString1 = paramString1.e(this.this$0.d.uin))
      {
        this.this$0.a.cardName = paramString1.remark;
        return;
      }
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.this$0.d.uin != null) && (ProfileActivity.AllInOne.b(this.this$0.d)))
    {
      localObject = (acff)this.this$0.app.getManager(51);
      if (localObject != null) {
        break label90;
      }
    }
    label90:
    for (Object localObject = null;; localObject = ((acff)localObject).e(this.this$0.d.uin))
    {
      if ((localObject != null) && (((Friends)localObject).remark != null) && (((Friends)localObject).isRemark == 1)) {
        this.this$0.a.cardName = ((Friends)localObject).remark;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbp
 * JD-Core Version:    0.7.0.1
 */