import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SelectLimitListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class vpj
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public vpj(PhotoListPanel paramPhotoListPanel) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter == null) {}
    LocalMediaInfo localLocalMediaInfo;
    int j;
    int i;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getCount() <= 0);
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(this.jdField_a_of_type_Int);
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(this.jdField_a_of_type_Int);
      if ((!localLocalMediaInfo.mChecked) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.d)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SelectLimitListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SelectLimitListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.d)))
          {
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
            return;
          }
          paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131432972), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size()) });
          paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, paramView);
          paramView.setPositiveButton(2131433016, new DialogUtil.DialogOnClickAdapter());
          paramView.show();
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
          return;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a((String)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.peek());
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.h) && (i != -1) && (i != j))
        {
          paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, 2131432975);
          paramView.setPositiveButton(2131433016, new DialogUtil.DialogOnClickAdapter());
          paramView.show();
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
          return;
        }
        if ((i == 1) && (j == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.e))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.e > 1) {}
          for (paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131432973), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size()) });; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131432976))
          {
            paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, paramView);
            paramView.setPositiveButton(2131433016, new DialogUtil.DialogOnClickAdapter());
            paramView.show();
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
            return;
          }
        }
      }
      if ((j != 1) || (localLocalMediaInfo.fileSize <= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Long)) {
        break;
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity));
    paramView = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity;
    paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, 232, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getString(2131437386), new vpk(this, paramView), new vpl(this));
    try
    {
      paramView.show();
      return;
    }
    catch (Exception paramView)
    {
      return;
    }
    if ((j == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (localLocalMediaInfo.fileSize > PhotoListPanel.jdField_a_of_type_Int))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131435920), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getDimensionPixelSize(2131558448));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) && (!localLocalMediaInfo.mChecked))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
      String str1;
      long l1;
      for (i = 0; paramView.hasNext(); i = (int)(FileUtils.a(str1) + l1))
      {
        str1 = (String)paramView.next();
        l1 = i;
      }
      if (i + FileUtils.a(localLocalMediaInfo.path) > 52428800L)
      {
        paramView = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if ((paramView != null) && (paramView.a()))
        {
          l1 = 0L;
          try
          {
            long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            l1 = l2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          if (paramView.a(l1, 1))
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, "选择图片总大小不能超过50M", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getDimensionPixelSize(2131558448));
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
            return;
          }
        }
      }
    }
    if ((GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!localLocalMediaInfo.mChecked) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size() > 0))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (paramView.hasNext())
      {
        String str2 = (String)paramView.next();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(str2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    boolean bool;
    if (!localLocalMediaInfo.mChecked)
    {
      bool = true;
      localLocalMediaInfo.mChecked = bool;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localLocalMediaInfo.mChecked);
      if (!localLocalMediaInfo.mChecked) {
        break label1108;
      }
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(localLocalMediaInfo.path, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.add(localLocalMediaInfo.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.add(localLocalMediaInfo.position);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size();
      ((NumberCheckBox)this.jdField_a_of_type_AndroidWidgetCheckBox).setCheckedNumber(i);
      PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      ReportController.b(null, "CliOper", "", "", "0X8005E08", "0X8005E08", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.j();
      return;
      bool = false;
      break;
      label1108:
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(localLocalMediaInfo.path);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.remove(localLocalMediaInfo.path);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilArrayList.remove(localLocalMediaInfo.position);
      PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpj
 * JD-Core Version:    0.7.0.1
 */