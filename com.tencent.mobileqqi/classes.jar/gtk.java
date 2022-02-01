import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.observer.AccountObserver;

public class gtk
  extends AccountObserver
{
  public gtk(TroopCreateAvatarActivity paramTroopCreateAvatarActivity) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    if (paramString1 == null) {
      while (i > 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b - 1);
        i -= 1;
      }
    }
    paramString2 = new HashMap();
    paramString2.put("groupsig", this.a.c);
    TroopUtils.a(paramString1, this.a.b.a(), this.a.d, this.a.jdField_a_of_type_JavaUtilArrayList, paramString2, this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gtk
 * JD-Core Version:    0.7.0.1
 */