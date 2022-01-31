import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ViewHolder;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.LinkedHashMap;
import java.util.List;

public class drg
  extends Handler
{
  public drg(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (Object[])paramMessage.obj;
      if ((paramMessage == null) || (paramMessage.length != 4)) {
        break;
      }
    case 2: 
      for (;;)
      {
        synchronized (this.a.jdField_a_of_type_JavaUtilList)
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          this.a.jdField_a_of_type_JavaUtilList.addAll((List)paramMessage[0]);
          drx.a(this.a.jdField_a_of_type_Drx, (LinkedHashMap)paramMessage[1]);
          this.a.jdField_a_of_type_Drx.a = ((int[])paramMessage[2]);
          drx.a(this.a.jdField_a_of_type_Drx, (String[])paramMessage[3]);
          if (this.a.jdField_a_of_type_JavaUtilList.size() != 0)
          {
            if (this.a.jdField_a_of_type_Drx == null) {
              break label378;
            }
            this.a.jdField_a_of_type_Drx.notifyDataSetChanged();
            if (this.a.jdField_b_of_type_AndroidViewView != null) {
              ((TroopMemberListActivity.ViewHolder)this.a.jdField_b_of_type_AndroidViewView.getTag()).c.setText(this.a.l);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(new drh(this));
          }
          if (!this.a.c) {
            this.a.g();
          }
          this.a.d();
          return;
          this.a.g();
        }
        if ((paramMessage != null) && (paramMessage.length == 1))
        {
          synchronized (this.a.jdField_a_of_type_JavaUtilList)
          {
            this.a.jdField_a_of_type_JavaUtilList.clear();
            this.a.jdField_a_of_type_JavaUtilList.addAll((List)paramMessage[0]);
          }
          this.a.jdField_a_of_type_Drx = new drx(this.a);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.a.jdField_a_of_type_Drx);
        }
      }
    case 3: 
      this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 40, 0);
      return;
    case 4: 
      this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
      return;
    case 5: 
      this.a.g();
      return;
    case 6: 
      label378:
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      QQToast.a(this.a, this.a.getString(2131562786), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
      return;
    }
    this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    QQToast.a(this.a, this.a.getString(2131562783), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     drg
 * JD-Core Version:    0.7.0.1
 */