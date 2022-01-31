import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class ace
  implements AdapterView.OnItemClickListener
{
  public ace(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ChatBackgroundInfo localChatBackgroundInfo = (ChatBackgroundInfo)paramView.getTag();
    if ((localChatBackgroundInfo != null) && (localChatBackgroundInfo.type.equals("1")) && (this.a.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.c() < 1)) {
      DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131362935)).setMessage(this.a.getString(2131364081)).setPositiveButton(this.a.getString(2131364308), new acg(this, localChatBackgroundInfo, paramView, paramInt)).setNegativeButton(this.a.getString(2131362790), new acf(this)).show();
    }
    int i;
    do
    {
      return;
      int j = 0;
      i = j;
      if (this.a.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        i = j;
        if (localChatBackgroundInfo != null)
        {
          i = 0;
          j = 0;
          while (j < this.a.jdField_b_of_type_JavaUtilArrayList.size())
          {
            if (localChatBackgroundInfo.id.equals(((ChatBackgroundInfo)this.a.jdField_b_of_type_JavaUtilArrayList.get(j)).id)) {
              i = 1;
            }
            j += 1;
          }
        }
      }
    } while ((i == 0) && (localChatBackgroundInfo != null));
    this.a.c();
    String str1 = this.a.d;
    if (localChatBackgroundInfo == null)
    {
      this.a.d = "none";
      paramView.findViewById(2131296796).setVisibility(0);
      if ((this.a.jdField_b_of_type_Int != paramInt) && (paramAdapterView != null) && (this.a.jdField_b_of_type_Int < paramAdapterView.getCount()))
      {
        if (this.a.jdField_b_of_type_Int != -1) {
          paramAdapterView.getChildAt(this.a.jdField_b_of_type_Int).findViewById(2131296795).setContentDescription(paramView.getResources().getString(2131364377, new Object[] { Integer.valueOf(this.a.jdField_b_of_type_Int + 1) }));
        }
      }
      else
      {
        label351:
        this.a.jdField_b_of_type_Int = paramInt;
        paramView.findViewById(2131296795).setContentDescription(paramView.getResources().getString(2131364376, new Object[] { Integer.valueOf(this.a.jdField_b_of_type_Int + 1) }));
        ReportController.b(this.a.app, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "default", "", "", "");
        if ((str1 != null) && (str1.trim().length() != 0)) {
          break label1145;
        }
      }
    }
    label941:
    label1145:
    for (paramAdapterView = "null";; paramAdapterView = str1)
    {
      str1 = this.a.d;
      if (str1 != null)
      {
        paramView = str1;
        if (str1.trim().length() != 0) {}
      }
      else
      {
        paramView = "null";
      }
      if (QLog.isColorLevel()) {
        QLog.d(ChatBackgroundSettingActivity.jdField_a_of_type_JavaLangString, 2, "oldPicPath is:" + paramAdapterView + ",newPicPath is:" + paramView);
      }
      if (paramAdapterView.equals(paramView)) {
        break;
      }
      if ((this.a.c == null) || (this.a.c.trim().length() == 0)) {
        ChatBackgroundSettingActivity.a(this.a, this.a.app.a());
      }
      this.a.d();
      ChatBackgroundSettingActivity.a(this.a);
      return;
      if (this.a.jdField_b_of_type_AndroidViewView == null) {
        break label351;
      }
      this.a.jdField_b_of_type_AndroidViewView.findViewById(2131296796).setVisibility(8);
      this.a.jdField_b_of_type_AndroidViewView.findViewById(2131296795).setContentDescription(paramView.getResources().getString(2131364377, new Object[] { Integer.valueOf(paramInt + 1) }));
      break label351;
      String str2 = AppConstants.bb + localChatBackgroundInfo.id + ".png";
      File localFile = new File(str2);
      HttpDownloadFileProcessor localHttpDownloadFileProcessor = (HttpDownloadFileProcessor)this.a.app.a().a(localChatBackgroundInfo.url);
      if ((localFile.exists()) && ((localHttpDownloadFileProcessor == null) || (localHttpDownloadFileProcessor.f())))
      {
        this.a.d = str2;
        paramView.findViewById(2131296797).setVisibility(8);
        paramView.findViewById(2131296799).setVisibility(8);
        paramView.findViewById(2131296796).setVisibility(0);
        if ((this.a.jdField_b_of_type_Int != paramInt) && (paramAdapterView != null) && (this.a.jdField_b_of_type_Int < paramAdapterView.getCount()))
        {
          if (this.a.jdField_b_of_type_Int == -1) {
            break label941;
          }
          paramAdapterView.getChildAt(this.a.jdField_b_of_type_Int).findViewById(2131296795).setContentDescription(paramView.getResources().getString(2131364377, new Object[] { Integer.valueOf(this.a.jdField_b_of_type_Int + 1) }));
        }
        for (;;)
        {
          paramView.findViewById(2131296795).setContentDescription(paramView.getResources().getString(2131364376, new Object[] { Integer.valueOf(paramInt + 1) }));
          this.a.jdField_b_of_type_Int = paramInt;
          ReportController.b(this.a.app, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, localChatBackgroundInfo.id, "", "", "");
          break;
          if (this.a.jdField_b_of_type_AndroidViewView != null)
          {
            this.a.jdField_b_of_type_AndroidViewView.findViewById(2131296796).setVisibility(8);
            this.a.jdField_b_of_type_AndroidViewView.findViewById(2131296795).setContentDescription(paramView.getResources().getString(2131364377, new Object[] { Integer.valueOf(paramInt + 1) }));
          }
        }
      }
      if ((paramAdapterView == null) || (this.a.jdField_b_of_type_Int >= paramAdapterView.getCount())) {
        break;
      }
      if (this.a.jdField_b_of_type_Int == -1)
      {
        paramAdapterView = this.a.jdField_b_of_type_AndroidViewView.findViewById(2131296796);
        if (paramAdapterView == null) {
          break;
        }
        paramAdapterView.setVisibility(0);
        paramAdapterView.setContentDescription(paramView.getResources().getString(2131364376, new Object[] { Integer.valueOf(paramInt + 1) }));
        return;
      }
      paramAdapterView = paramAdapterView.getChildAt(this.a.jdField_b_of_type_Int).findViewById(2131296796);
      if (paramAdapterView == null) {
        break;
      }
      paramAdapterView.setVisibility(0);
      paramAdapterView.setContentDescription(paramView.getResources().getString(2131364376, new Object[] { Integer.valueOf(this.a.jdField_b_of_type_Int + 1) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ace
 * JD-Core Version:    0.7.0.1
 */