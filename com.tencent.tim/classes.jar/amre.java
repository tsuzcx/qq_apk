import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class amre
  extends amot
{
  TroopMemberInfo h;
  String troopCode;
  
  public amre(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo, String paramString)
  {
    super(paramQQAppInterface, paramInt, paramTroopMemberInfo);
    this.h = paramTroopMemberInfo;
    this.troopCode = paramString;
  }
  
  public int Ja()
  {
    if (this.h.commonFrdCnt < 0) {
      return 0;
    }
    return this.h.commonFrdCnt;
  }
  
  public void cR(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((paramView.getId() == 2131377201) && (this.fromType == 23)) {
      TroopAddFrdsInnerFrame.a(localContext, this.h, this.troopCode, false);
    }
    while (this.fromType != 23) {
      return;
    }
    Intent localIntent = new Intent(localContext, FriendProfileCardActivity.class);
    localIntent.putExtra("troopUin", this.h.troopuin);
    localIntent.putExtra("memberUin", this.h.memberuin);
    localIntent.putExtra("fromFlag", 1);
    localIntent.putExtra("selfSet_leftViewText", paramView.getContext().getString(2131721410));
    localIntent.putExtra("custom_leftbackbutton_name", paramView.getContext().getString(2131691039));
    aldj.a(localContext, this.app, localIntent, 9);
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    acff localacff = (acff)this.app.getManager(51);
    if (localacff.isFriend(this.h.memberuin)) {
      return acfp.m(2131715610);
    }
    if (localacff.w(this.h.memberuin, false)) {
      return acfp.m(2131715611);
    }
    return null;
  }
  
  public String za()
  {
    return aqgv.h(this.app, this.h.troopuin, this.h.memberuin);
  }
  
  public String zb()
  {
    if (this.h.commonFrdCnt <= 0) {
      return "";
    }
    return this.h.commonFrdCnt + acfp.m(2131715612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amre
 * JD-Core Version:    0.7.0.1
 */