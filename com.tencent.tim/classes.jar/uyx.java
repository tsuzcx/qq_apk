import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class uyx
  extends aqnl.a
{
  public uyx(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt)
  {
    super(paramInt);
  }
  
  public void onClick()
  {
    aqep.a(this.this$0, this.this$0.app.getCurrentAccountUin(), "inside.myCardButton", 1, 3, 1, "", true);
    anot.a(this.this$0.app, "CliOper", "", "", "card_mall", "0X8004DBF", 0, 0, "", "", "", "");
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "defaultcard", "click_card_mine", "", 1, 0, 0, "", "", "");
    this.this$0.AK(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyx
 * JD-Core Version:    0.7.0.1
 */