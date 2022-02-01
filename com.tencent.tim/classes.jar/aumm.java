import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.teamworkforgroup.GPadInfo;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity.20.1;
import java.util.List;
import mqq.os.MqqHandler;

public class aumm
  extends aumy
{
  public aumm(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, GPadInfo paramGPadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupTeamWorkListActivity", 2, " onAddGroupTeamWorkLink success: " + paramBoolean + " \nretCode: " + paramInt + " \nerrorMsg: " + paramString);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.a(this.this$0, 3);
      paramString = this.this$0.getResources().getString(2131689833);
      QQToast.a(this.this$0, paramString, 0).show(this.this$0.getTitleBarHeight());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, List<GPadInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, " onGetPadTemplateList success: " + paramBoolean + " \nretCode: " + paramInt + " \nerrorMsg: " + paramString);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.b(this.this$0, 2);
      if (GroupTeamWorkListActivity.a(this.this$0) != null) {
        GroupTeamWorkListActivity.a(this.this$0).notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, List<GPadInfo> paramList, int paramInt2, int paramInt3)
  {
    int i = 1;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, " onGetPadList success: " + paramBoolean + " \nretCode: " + paramInt1 + " \nerrorMsg: " + paramString + "\n next =" + paramInt2);
    }
    this.this$0.dOd = paramInt2;
    if (GroupTeamWorkListActivity.c(this.this$0))
    {
      if (paramBoolean)
      {
        paramInt2 = 1;
        paramString = this.this$0.uiHandler.obtainMessage(111, paramInt2, 0);
        this.this$0.uiHandler.sendMessageDelayed(paramString, 500L);
        GroupTeamWorkListActivity.b(this.this$0, false);
      }
    }
    else
    {
      if (GroupTeamWorkListActivity.d(this.this$0))
      {
        this.this$0.VI(2);
        GroupTeamWorkListActivity.c(this.this$0, false);
      }
      if (paramInt3 != 2) {
        break label211;
      }
      paramInt2 = 3;
    }
    for (;;)
    {
      if ((paramBoolean) && (paramInt1 == 0))
      {
        GroupTeamWorkListActivity.a(this.this$0, paramInt2);
        paramInt1 = j;
        if (paramInt1 != 0) {
          GroupTeamWorkListActivity.d(this.this$0).setVisibility(8);
        }
        return;
        paramInt2 = 2;
        break;
        label211:
        if (paramInt3 != 3) {
          break label433;
        }
        paramInt2 = 4;
        continue;
      }
      if (paramInt2 == 2)
      {
        if ((GroupTeamWorkListActivity.a(this.this$0) != null) && (GroupTeamWorkListActivity.a(this.this$0).getCount() == 0))
        {
          GroupTeamWorkListActivity.a(this.this$0).setVisibility(8);
          if (GroupTeamWorkListActivity.b(this.this$0).getVisibility() == 0) {
            GroupTeamWorkListActivity.b(this.this$0).setVisibility(8);
          }
          if ((this.this$0.djg) && (this.this$0.b.getVisibility() == 0)) {
            this.this$0.b.setVisibility(8);
          }
          GroupTeamWorkListActivity.c(this.this$0).setVisibility(0);
        }
      }
      else
      {
        label335:
        if (paramInt2 != 4) {
          break label428;
        }
        QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131695453), 0).show(this.this$0.getTitleBarHeight());
      }
      label428:
      for (paramInt1 = i;; paramInt1 = 0)
      {
        this.this$0.VI(2);
        break;
        QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131695453), 0).show(this.this$0.getTitleBarHeight());
        break label335;
      }
      label433:
      paramInt2 = 2;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, GPadInfo paramGPadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupTeamWorkListActivity", 2, " onAddGroupTeamWorkCopy success: " + paramBoolean + " \nretCode: " + paramInt + " \nerrorMsg: " + paramString);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.a(this.this$0.app.getApp(), 2, this.this$0.getString(2131689833), 0).show(this.this$0.getTitleBarHeight());
      ThreadManager.postImmediately(new GroupTeamWorkListActivity.20.1(this), null, true);
    }
  }
  
  public void u(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupTeamWorkListActivity", 2, " onDeletePanInfo success: " + paramBoolean + " \nretCode: " + paramInt + " \nerrorMsg: " + paramString);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.a(this.this$0, 5);
      QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131692524), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131692513), 0).show(this.this$0.getTitleBarHeight());
    this.this$0.VI(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumm
 * JD-Core Version:    0.7.0.1
 */