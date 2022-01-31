import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class bjl
  implements View.OnClickListener
{
  public bjl(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    Object localObject = paramView.getTag();
    if (j == 2131298897) {
      localObject = paramView.findViewById(2131298898).getTag();
    }
    if ((localObject != null) && ((localObject instanceof Integer))) {}
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetTroopAdminsActivity", 2, "mOnKickOutBtnClickListener:" + i);
      }
      if ((i < 0) || (i >= SetTroopAdminsActivity.a(this.a).size())) {}
      do
      {
        do
        {
          do
          {
            return;
            paramView = (SetTroopAdminsActivity.TroopAdmin)SetTroopAdminsActivity.a(this.a).get(i);
            if (j != 2131298898) {
              break;
            }
            localObject = this.a.a(paramView.a);
          } while (localObject == null);
          ((bjp)localObject).a.a(true);
          this.a.a.add(paramView.a);
          return;
          if (j != 2131298897) {
            break;
          }
          localObject = this.a.a(paramView.a);
        } while (localObject == null);
        ((bjp)localObject).a.b(true);
        this.a.a.remove(paramView.a);
        return;
      } while (j != 2131298901);
      SetTroopAdminsActivity.a(this.a, 2131362861);
      SetTroopAdminsActivity.a(this.a).put(paramView.a, paramView);
      ((TroopHandler)this.a.app.a(17)).a((byte)0, SetTroopAdminsActivity.a(this.a), paramView.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjl
 * JD-Core Version:    0.7.0.1
 */