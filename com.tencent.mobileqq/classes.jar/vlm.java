import android.content.Context;
import android.view.View;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public final class vlm
  implements ActionSheet.OnButtonClickListener
{
  public vlm(VideoActionSheet paramVideoActionSheet, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    int i;
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramView = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
      if (paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
        i = 2131429198;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(i);
        DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230, null, paramView, 2131429048, 2131428674, new vln(this), null).show();
        return;
        if (paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false).jdField_a_of_type_Boolean) {
          i = 2131429197;
        }
      }
      else
      {
        QAVGroupConfig.Report.a(this.jdField_a_of_type_Boolean, paramInt);
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b);
          return;
        }
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_Boolean);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005DC7", "0X8005DC7", 0, 0, "", "", "", "");
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlm
 * JD-Core Version:    0.7.0.1
 */