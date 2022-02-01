import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.activity.StrangerManageActivity.StrangeManagerListAdapter;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class dkq
  extends StrangerObserver
{
  public dkq(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Stranger localStranger1 = (Stranger)paramList.next();
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Stranger localStranger2 = (Stranger)localIterator.next();
        if (TextUtils.equals(localStranger2.uin, localStranger1.uin)) {
          Stranger.copyInfo(localStranger1, localStranger2);
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField)
  {
    this.a.f();
    int i;
    int j;
    if (paramBoolean)
    {
      if (paramPBRepeatMessageField == null) {
        break label432;
      }
      paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
      i = 0;
      int k;
      for (j = 0; paramPBRepeatMessageField.hasNext(); j = k)
      {
        oidb_0x5d4.DelResult localDelResult = (oidb_0x5d4.DelResult)paramPBRepeatMessageField.next();
        k = this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        int m = i;
        i = j;
        j = m;
        if (k >= 0)
        {
          Stranger localStranger = (Stranger)this.a.jdField_a_of_type_JavaUtilArrayList.get(k);
          m = j;
          int n = i;
          if (localStranger.uin.equals(String.valueOf(localDelResult.uin.get())))
          {
            if (localDelResult.res.get() != 0) {
              break label174;
            }
            m = j + 1;
            this.a.jdField_a_of_type_JavaUtilArrayList.remove(localStranger);
            n = i;
          }
          for (;;)
          {
            k -= 1;
            j = m;
            i = n;
            break;
            label174:
            n = i + 1;
            m = j;
          }
        }
        k = i;
        i = j;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      if (j > 0) {
        if (i > 0) {
          QQToast.a(this.a, this.a.getString(2131561400, new Object[] { Integer.valueOf(j) }), 0).b(this.a.d());
        }
      }
      for (;;)
      {
        if (!this.a.jdField_c_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.a.jdField_a_of_type_AndroidWidgetLinearLayout);
          this.a.jdField_c_of_type_Boolean = true;
        }
        return;
        QQToast.a(this.a, this.a.getString(2131562060), 0).b(this.a.d());
        continue;
        QQToast.a(this.a, this.a.getString(2131561962), 0).b(this.a.d());
        this.a.b(false);
      }
      if (NetworkUtil.e(this.a))
      {
        QQToast.a(this.a, this.a.getString(2131562060), 0).b(this.a.d());
        return;
      }
      QQToast.a(this.a, this.a.getString(2131562056), 0).b(this.a.d());
      return;
      label432:
      i = 0;
      j = 0;
    }
  }
  
  public void a(boolean paramBoolean, List paramList)
  {
    boolean bool = StrangerManageActivity.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("StrangerManageActivity", 2, "onGetListRemote");
    }
    if (paramBoolean)
    {
      if (paramList != null)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
        StrangerManageActivity.a(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((!TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) && (!StrangerManageActivity.b(this.a)))
      {
        StrangerManageActivity.a(this.a, true);
        paramList = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        Stranger localStranger;
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localStranger = (Stranger)paramList.next();
        } while (!TextUtils.equals(this.a.jdField_c_of_type_JavaLangString, localStranger.uin));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        QQToast.a(this.a, this.a.getString(2131563052), 0).b(this.a.d());
      }
      if (!this.a.jdField_c_of_type_Boolean)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.a.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.a.jdField_c_of_type_Boolean = true;
      }
      paramList = StrangerManageActivity.a(this.a);
      if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        paramBoolean = true;
        paramList.setEnabled(paramBoolean);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
        this.a.b = false;
        return;
        paramBoolean = false;
        break;
        if ((bool) && (!NetworkUtil.e(this.a)) && (this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          QQToast.a(this.a, this.a.getString(2131562056), 0).b(this.a.d());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
      }
    }
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Long localLong = (Long)paramList.next();
        this.a.jdField_a_of_type_JavaUtilHashSet.remove(String.valueOf(localLong));
      }
    }
  }
  
  public void b(boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      if (paramList != null)
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
        StrangerManageActivity.a(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_JavaUtilArrayList);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
      }
      paramList = StrangerManageActivity.b(this.a);
      if (this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        break label87;
      }
    }
    label87:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramList.setEnabled(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dkq
 * JD-Core Version:    0.7.0.1
 */