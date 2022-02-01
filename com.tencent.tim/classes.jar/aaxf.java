import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;

public class aaxf
  extends acfd
{
  public aaxf(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxf
 * JD-Core Version:    0.7.0.1
 */