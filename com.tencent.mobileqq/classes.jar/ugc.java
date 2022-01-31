import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.activity.TroopMemberListActivity.SearchResultAdapter;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ugc
  implements View.OnClickListener
{
  public ugc(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    String str;
    label94:
    label767:
    do
    {
      do
      {
        do
        {
          int k;
          do
          {
            do
            {
              int i;
              do
              {
                do
                {
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnKickOutBtnClickListener onclick");
                  }
                  k = paramView.getId();
                  str = (String)paramView.getTag();
                  bool1 = str.equals(this.a.e);
                  int j;
                  if ((this.a.f != null) && (this.a.f.contains(str)))
                  {
                    i = 1;
                    boolean bool4 = this.a.app.getCurrentAccountUin().equals(this.a.e);
                    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.a.app.getManager(202);
                    if ((localTroopRobotManager == null) || (!localTroopRobotManager.b(str))) {
                      break label333;
                    }
                    j = 1;
                    if (((!bool4) || (str.equals(this.a.app.getCurrentAccountUin()))) && ((bool4) || (bool1) || (i != 0) || (j != 0))) {
                      break label338;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    if (k != 2131364324) {
                      break label597;
                    }
                    paramView = paramView.findViewById(2131364325);
                    bool1 = bool2;
                    if (paramView.getTag() != null)
                    {
                      bool1 = bool2;
                      if ((paramView.getTag() instanceof Boolean)) {
                        bool1 = ((Boolean)paramView.getTag()).booleanValue();
                      }
                    }
                    paramView = this.a.a(str, bool1);
                    if (this.a.jdField_d_of_type_Int != 20) {
                      break label343;
                    }
                    if (paramView == null) {
                      break;
                    }
                    paramView = paramView.a.getTag();
                    if ((paramView == null) || (!(paramView instanceof Integer))) {
                      break;
                    }
                    i = ((Integer)paramView).intValue();
                    if (i < 0) {
                      break;
                    }
                    paramView = (TroopMemberListActivity.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.getItem(i);
                    this.a.a(paramView);
                    return;
                    i = 0;
                    break label94;
                    j = 0;
                    break label151;
                  }
                  if (this.a.jdField_d_of_type_Boolean)
                  {
                    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.contains(str)) {
                      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.remove(str);
                    }
                    for (;;)
                    {
                      TroopMemberListActivity.a(this.a);
                      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
                      return;
                      if (i != 0) {
                        this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.add(str);
                      }
                    }
                  }
                  if (!bool1) {
                    break;
                  }
                } while (this.a.u.equals(str));
                if (paramView != null) {
                  paramView.a.a(true);
                }
                if (!TextUtils.isEmpty(this.a.u))
                {
                  paramView = this.a.a(this.a.u, bool1);
                  if (paramView != null) {
                    paramView.a.b(true);
                  }
                }
                this.a.u = str;
                return;
              } while (this.a.t.equals(str));
              if (paramView != null) {
                paramView.a.a(true);
              }
              if (!TextUtils.isEmpty(this.a.t))
              {
                paramView = this.a.a(this.a.t, bool1);
                if (paramView != null) {
                  paramView.a.b(true);
                }
              }
              this.a.t = str;
              return;
              if (k != 2131364323) {
                break;
              }
              paramView = paramView.findViewById(2131375137);
              boolean bool1 = bool3;
              if (paramView.getTag() != null)
              {
                bool1 = bool3;
                if ((paramView.getTag() instanceof Boolean)) {
                  bool1 = ((Boolean)paramView.getTag()).booleanValue();
                }
              }
              if (this.a.jdField_d_of_type_Boolean)
              {
                if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.contains(str)) {
                  break label767;
                }
                this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.remove(str);
              }
              for (;;)
              {
                TroopMemberListActivity.a(this.a);
                this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
                if (!bool1) {
                  break;
                }
                paramView = this.a.a(this.a.u, bool1);
                if (paramView != null)
                {
                  paramView.a.b(true);
                  this.a.u = "";
                }
                this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
                return;
                if (i != 0) {
                  this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_b_of_type_JavaUtilList.add(str);
                }
              }
              paramView = this.a.a(this.a.t, bool1);
            } while (paramView == null);
            paramView.a.b(true);
            this.a.t = "";
            return;
          } while ((k != 2131375325) || (!this.a.c));
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "delBtn onClick, uin=" + str);
          }
          if (NetworkUtil.d(BaseApplication.getContext())) {
            break;
          }
        } while (!this.a.isResume());
        QQToast.a(this.a, this.a.getString(2131434827), 0).b(this.a.getTitleBarHeight());
        return;
        if (this.a.jdField_d_of_type_Int == 1)
        {
          this.a.d(str);
          return;
        }
        if (this.a.jdField_d_of_type_Int != 13) {
          break;
        }
        paramView = this.a.a(str);
        this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
      } while (!this.a.jdField_b_of_type_AndroidAppDialog.isShowing());
      if (paramView != null) {
        this.a.jdField_b_of_type_JavaUtilList.remove(paramView);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
      if (this.a.jdField_d_of_type_Int != 21) {
        break;
      }
      paramView = this.a.a(str);
      this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
    } while (!this.a.jdField_b_of_type_AndroidAppDialog.isShowing());
    label151:
    label333:
    label338:
    label343:
    if (paramView != null) {
      this.a.jdField_b_of_type_JavaUtilList.remove(paramView);
    }
    label597:
    this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$SearchResultAdapter.notifyDataSetChanged();
    return;
    paramView = new ArrayList();
    paramView.add(Long.valueOf(Long.parseLong(str)));
    TroopMemberListActivity.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ugc
 * JD-Core Version:    0.7.0.1
 */