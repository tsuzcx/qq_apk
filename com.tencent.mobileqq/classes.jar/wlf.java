import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class wlf
  extends wlw
{
  public wlf(MoveFileActivity paramMoveFileActivity, ayoq paramayoq) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.b();
    Intent localIntent = new Intent();
    localIntent.putExtra("fileId", MoveFileActivity.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity));
    localIntent.putExtra("folderId", this.jdField_a_of_type_Ayoq.b);
    int i = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity().getResources().getDimensionPixelSize(2131167766);
    if (paramBoolean)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app;
      String str = Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a);
      if (MoveFileActivity.c(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).equals("/"))
      {
        paramString = "0";
        awqx.b(localQQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_suc", 0, 0, str, paramString, "", "");
        bbmy.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 2, ajjy.a(2131641115), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(-1, localIntent);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.finish();
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.overridePendingTransition(0, 2130772001);
      return;
      paramString = "1";
      break;
      switch (paramInt)
      {
      default: 
        paramString = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getString(2131630677);
        bbmy.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, paramString, 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -302: 
      case -301: 
      case -103: 
        awqx.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move_nofile", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        bbmy.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, ajjy.a(2131641108), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -136: 
        awqx.b(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, "P_CliOper", "Grp_files", "", "file", "fail_move", 0, 0, Long.toString(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a), "", "", "");
        bbmy.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, ajjy.a(2131641112), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -107: 
      case -102: 
        bbmy.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, ajjy.a(2131641111), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -406: 
        bbmy.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, ajjy.a(2131641107), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
        break;
      case -407: 
        bbmy.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getActivity(), 1, ajjy.a(2131641109), 0).b(i);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.setResult(0, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wlf
 * JD-Core Version:    0.7.0.1
 */