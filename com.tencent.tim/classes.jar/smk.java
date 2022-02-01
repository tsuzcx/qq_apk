import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class smk
  extends smq.i
{
  public smk(MoveFileActivity paramMoveFileActivity, apbr paramapbr) {}
  
  protected void e(boolean paramBoolean, int paramInt, String paramString)
  {
    this.this$0.ath();
    Intent localIntent = new Intent();
    localIntent.putExtra("fileId", MoveFileActivity.b(this.this$0));
    localIntent.putExtra("folderId", this.a.mFileId);
    int i = this.this$0.getActivity().getResources().getDimensionPixelSize(2131299627);
    if (paramBoolean)
    {
      QQAppInterface localQQAppInterface = this.this$0.app;
      String str = Long.toString(this.this$0.CV);
      if (MoveFileActivity.c(this.this$0).equals("/"))
      {
        paramString = "0";
        anot.a(localQQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_suc", 0, 0, str, paramString, "", "");
        QQToast.a(this.this$0.getActivity(), 2, acfp.m(2131708477), 0).show(i);
        this.this$0.setResult(-1, localIntent);
      }
    }
    for (;;)
    {
      this.this$0.finish();
      this.this$0.overridePendingTransition(0, 2130772013);
      return;
      paramString = "1";
      break;
      switch (paramInt)
      {
      default: 
        paramString = this.this$0.getString(2131698310);
        QQToast.a(this.this$0.getActivity(), 1, paramString, 0).show(i);
        this.this$0.setResult(0, localIntent);
        break;
      case -302: 
      case -301: 
      case -103: 
        anot.a(this.this$0.app, "P_CliOper", "Grp_files", "", "file", "fail_move_nofile", 0, 0, Long.toString(this.this$0.CV), "", "", "");
        QQToast.a(this.this$0.getActivity(), 1, acfp.m(2131708470), 0).show(i);
        this.this$0.setResult(0, localIntent);
        break;
      case -136: 
        anot.a(this.this$0.app, "P_CliOper", "Grp_files", "", "file", "fail_move", 0, 0, Long.toString(this.this$0.CV), "", "", "");
        QQToast.a(this.this$0.getActivity(), 1, acfp.m(2131708474), 0).show(i);
        this.this$0.setResult(0, localIntent);
        break;
      case -107: 
      case -102: 
        QQToast.a(this.this$0.getActivity(), 1, acfp.m(2131708473), 0).show(i);
        this.this$0.setResult(0, localIntent);
        break;
      case -406: 
        QQToast.a(this.this$0.getActivity(), 1, acfp.m(2131708469), 0).show(i);
        this.this$0.setResult(0, localIntent);
        break;
      case -407: 
        QQToast.a(this.this$0.getActivity(), 1, acfp.m(2131708471), 0).show(i);
        this.this$0.setResult(0, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smk
 * JD-Core Version:    0.7.0.1
 */