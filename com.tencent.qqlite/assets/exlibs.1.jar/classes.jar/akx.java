import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class akx
  implements View.OnClickListener
{
  public akx(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("type", this.a.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("subtype", this.a.b);
      paramView = null;
      switch (this.a.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        this.a.b();
        if ((this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() != 0)) {
          break;
        }
        if ((paramView != null) && (paramView.length() != 0)) {
          break label170;
        }
        EditInfoActivity.a(this.a);
        return;
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
        continue;
        paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      }
      if ((paramView == null) || (paramView.length() == 0)) {}
      label170:
      while (!this.a.jdField_a_of_type_JavaLangString.equals(paramView))
      {
        ((Intent)localObject).putExtra("savetxt", paramView);
        this.a.setResult(-1, (Intent)localObject);
        EditInfoActivity.c(this.a);
        return;
      }
      EditInfoActivity.b(this.a);
      return;
    }
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if (!NetworkUtil.e(this.a.app.getApplication().getApplicationContext()))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131363515, 1000);
      return;
    }
    if (((TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(paramView))) || ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_JavaLangString.equals(paramView))))
    {
      EditInfoActivity.d(this.a);
      return;
    }
    Object localObject = new TroopMemberCardInfo();
    ((TroopMemberCardInfo)localObject).name = paramView;
    ((TroopMemberCardInfo)localObject).memberuin = this.a.d;
    ((TroopMemberCardInfo)localObject).troopuin = this.a.c;
    ((TroopMemberCardInfo)localObject).email = "";
    ((TroopMemberCardInfo)localObject).memo = "";
    ((TroopMemberCardInfo)localObject).sex = -1;
    ((TroopMemberCardInfo)localObject).tel = "";
    paramView = new ArrayList();
    paramView.add(localObject);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(1));
    TroopHandler localTroopHandler = (TroopHandler)this.a.app.a(17);
    if ((localTroopHandler != null) && (!TextUtils.isEmpty(this.a.c)))
    {
      EditInfoActivity.a(this.a, true);
      localTroopHandler.a(this.a.c, paramView, (ArrayList)localObject);
    }
    paramView = (FriendManager)this.a.app.getManager(8);
    int i;
    if (paramView != null)
    {
      paramView = paramView.a(this.a.c);
      if (paramView != null) {
        if ((!TextUtils.isEmpty(paramView.troopowneruin)) && (paramView.troopowneruin.equalsIgnoreCase(this.a.app.getAccount()))) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, this.a.c, i + "", "", "");
      return;
      if ((!TextUtils.isEmpty(paramView.Administrator)) && (paramView.Administrator.contains(this.a.app.getAccount()))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     akx
 * JD-Core Version:    0.7.0.1
 */