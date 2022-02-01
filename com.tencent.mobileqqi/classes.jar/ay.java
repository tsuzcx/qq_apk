import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import mqq.app.MobileQQ;

public class ay
  implements View.OnClickListener
{
  public ay(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, DataLineMsgSet paramDataLineMsgSet, Context paramContext, String paramString, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    int i = 0;
    if ((LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity) != null) && (LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).isShowing())) {
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).dismiss();
    }
    if (2131234883 == paramView.getId())
    {
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a(), "dl_copy");
      ((ClipboardManager)LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg);
    }
    do
    {
      return;
      if (2131234877 == paramView.getId())
      {
        StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a(), "dl_delete");
        paramView = new az(this);
        localObject1 = new ba(this);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131558507), this.jdField_a_of_type_AndroidContentContext.getString(2131558527), 2131561746, 2131558509, paramView, (DialogInterface.OnClickListener)localObject1).show();
        return;
      }
      if (2131231189 == paramView.getId())
      {
        StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a(), "dl_forward");
        if (this.jdField_a_of_type_JavaLangString.isEmpty())
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
          localObject1 = new Intent(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, ForwardRecentActivity.class);
          localObject2 = AppConstants.P;
          ((Intent)localObject1).putExtra("forward_text", new QQText(paramView.msg, 13, 32, 6000).toString());
          ((Intent)localObject1).putExtra("forward_type", -1);
          ((Intent)localObject1).putExtra("isFromShare", true);
          this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult((Intent)localObject1, 4);
          return;
        }
        l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
        paramView = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
        localObject1 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject1).a(10000);
        ((ForwardFileInfo)localObject1).d(paramView);
        ((ForwardFileInfo)localObject1).d(l);
        ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_JavaLangString);
        localObject2 = new Intent(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, ForwardRecentActivity.class);
        ((Intent)localObject2).putExtra("forward_text", paramView);
        if (this.jdField_a_of_type_Boolean) {
          i = 1;
        }
        ((Intent)localObject2).putExtra("forward_type", i);
        ((Intent)localObject2).putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("not_forward", true);
        ((Intent)localObject2).putExtra("isFromShare", true);
        if (this.jdField_a_of_type_Boolean) {
          ((Intent)localObject2).putExtra("forward_thumb", this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path);
        }
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult((Intent)localObject2, 4);
        return;
      }
      if (2131231191 == paramView.getId())
      {
        if (this.jdField_a_of_type_JavaLangString.isEmpty())
        {
          QfavBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.getAccount());
          QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b, 64, 1);
          return;
        }
        QfavBuilder.c(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b, 64, 3);
        return;
      }
    } while (2131234884 != paramView.getId());
    StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a(), "dl_save2weiyun");
    long l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
    paramView = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
    if (((DataLineMsgRecord)localObject2).nWeiyunSessionId != 0L) {
      paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);
    }
    if ((FileManagerUtil.a()) && (l > 5242880L))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(), 2131558759, 2131558756, new bb(this, paramView, (String)localObject1, (DataLineMsgRecord)localObject2));
      return;
    }
    if (paramView == null)
    {
      FMToastUtil.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131558737, new Object[] { FileManagerUtil.d((String)localObject1) }));
      ((DataLineMsgRecord)localObject2).nWeiyunSessionId = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a().a(this.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.getAccount(), 0, false).nSessionId;
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a().c(((DataLineMsgRecord)localObject2).msgId);
      return;
    }
    FMToastUtil.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131558737, new Object[] { FileManagerUtil.d((String)localObject1) }));
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ay
 * JD-Core Version:    0.7.0.1
 */