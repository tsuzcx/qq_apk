import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class vwv
  implements Handler.Callback
{
  public vwv(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 2: 
      if ((this.this$0.a.rightViewText != null) && (!this.this$0.a.rightViewText.isEnabled())) {
        this.this$0.a.rightViewText.setEnabled(true);
      }
      Object localObject = (String)paramMessage.obj;
      if (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0))
      {
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0, 1);
        this.this$0.getActivity().finish();
        paramMessage = new Bundle();
        paramMessage.putString("savedUrl", (String)localObject);
        localObject = (TeamWorkFileImportInfo)this.this$0.getIntent().getParcelableExtra("key_team_work_file_import_info");
        if (((TeamWorkFileImportInfo)localObject).nFileType != 3) {
          break label226;
        }
        paramMessage.putInt("editType", 1);
      }
      for (;;)
      {
        if (this.this$0.getIntent().getParcelableExtra("key_team_work_file_import_info") != null) {
          paramMessage.putParcelable("key_team_work_file_import_info", this.this$0.getIntent().getParcelableExtra("key_team_work_file_import_info"));
        }
        paramMessage = affz.a("ipc_save_team_work", "", -1, paramMessage);
        afjy.a().cq(paramMessage);
        return true;
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0, 0);
        TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0, (String)localObject);
        break;
        label226:
        if (((TeamWorkFileImportInfo)localObject).nFileType == 6) {
          paramMessage.putInt("editType", 2);
        }
      }
    }
    if ((this.this$0.a.rightViewText != null) && (!this.this$0.a.rightViewText.isEnabled())) {
      this.this$0.a.rightViewText.setEnabled(true);
    }
    QQToast.a(this.this$0.getActivity(), acfp.m(2131715141), 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwv
 * JD-Core Version:    0.7.0.1
 */