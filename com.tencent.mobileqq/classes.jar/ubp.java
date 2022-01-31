import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

public class ubp
  implements Runnable
{
  public ubp(TroopTransferActivity paramTroopTransferActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    boolean bool = false;
    Object localObject;
    TroopTransferActivity.TroopMemberItem localTroopMemberItem;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (TroopMemberCardInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localTroopMemberItem = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a.a(((TroopMemberCardInfo)localObject).memberuin);
      if (localTroopMemberItem != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if (!Utils.a(((TroopMemberCardInfo)localObject).name, localTroopMemberItem.m))
      {
        localTroopMemberItem.m = ((TroopMemberCardInfo)localObject).name;
        if (!TextUtils.isEmpty(localTroopMemberItem.m))
        {
          localTroopMemberItem.n = ChnToSpell.a(localTroopMemberItem.m, 2);
          localTroopMemberItem.o = ChnToSpell.a(localTroopMemberItem.m, 1);
        }
      }
      else
      {
        label118:
        if (!Utils.a(((TroopMemberCardInfo)localObject).nick, localTroopMemberItem.g))
        {
          localTroopMemberItem.g = ((TroopMemberCardInfo)localObject).nick;
          if (TextUtils.isEmpty(localTroopMemberItem.g)) {
            break label277;
          }
          localTroopMemberItem.h = ChnToSpell.a(localTroopMemberItem.g, 2);
          localTroopMemberItem.i = ChnToSpell.a(localTroopMemberItem.g, 1);
        }
        label181:
        if (TextUtils.isEmpty(localTroopMemberItem.j)) {
          break label294;
        }
        localObject = localTroopMemberItem.j;
      }
      for (;;)
      {
        if (!Utils.a(localObject, localTroopMemberItem.b))
        {
          localTroopMemberItem.b = ((String)localObject);
          if (!TextUtils.isEmpty(localTroopMemberItem.b))
          {
            localTroopMemberItem.c = ChnToSpell.a(localTroopMemberItem.b, 2);
            localTroopMemberItem.d = ChnToSpell.a(localTroopMemberItem.b, 1);
            bool = true;
            break;
            localTroopMemberItem.n = "";
            localTroopMemberItem.o = "";
            break label118;
            label277:
            localTroopMemberItem.h = "";
            localTroopMemberItem.i = "";
            break label181;
            label294:
            if (!TextUtils.isEmpty(localTroopMemberItem.m))
            {
              localObject = localTroopMemberItem.m;
              continue;
            }
            if (!TextUtils.isEmpty(localTroopMemberItem.g))
            {
              localObject = localTroopMemberItem.g;
              continue;
            }
            if (!TextUtils.isEmpty(localTroopMemberItem.a))
            {
              localObject = localTroopMemberItem.a;
              continue;
            }
            localObject = "";
            continue;
          }
          localTroopMemberItem.c = "";
          localTroopMemberItem.d = "";
          bool = true;
          break;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a(bool);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ubp
 * JD-Core Version:    0.7.0.1
 */