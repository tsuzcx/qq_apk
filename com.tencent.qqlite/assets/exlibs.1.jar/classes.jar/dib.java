import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter.CloudItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class dib
  implements View.OnClickListener
{
  public dib(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).a;
    paramView = QfileBaseCloudFileTabView.d(this.a).a().b(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    if (paramView != null) {
      if (((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).c == 1)
      {
        this.a.a.a().ad();
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131363449);
          return;
        }
        if ((FileManagerUtil.a()) && (paramView.fileSize > 5242880L)) {
          FMDialogUtil.a(this.a.getContext(), 2131362021, 2131362019, new dic(this, paramView));
        }
      }
    }
    for (;;)
    {
      this.a.i();
      return;
      QfileBaseCloudFileTabView.f(this.a).a().a(paramView.nSessionId);
      continue;
      if (((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).c == 3)
      {
        this.a.a.a().af();
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131363449);
          return;
        }
        if ((FileManagerUtil.a()) && (paramView.fileSize > 5242880L)) {
          FMDialogUtil.a(this.a.getContext(), 2131362021, 2131362019, new did(this, paramView));
        } else {
          QfileBaseCloudFileTabView.h(this.a).a().a(paramView.nSessionId);
        }
      }
      else if (((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).c == 0)
      {
        this.a.a.a().ac();
        localObject = new FileManagerReporter.fileAssistantReportData();
        ((FileManagerReporter.fileAssistantReportData)localObject).b = "file_viewer_in";
        ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
        ((FileManagerReporter.fileAssistantReportData)localObject).c = FileUtil.a(paramView.fileName);
        ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = paramView.fileSize;
        FileManagerReporter.a(QfileBaseCloudFileTabView.i(this.a).a(), (FileManagerReporter.fileAssistantReportData)localObject);
        localObject = new ForwardFileInfo();
        ((ForwardFileInfo)localObject).c(paramView.cloudType);
        ((ForwardFileInfo)localObject).a(10001);
        ((ForwardFileInfo)localObject).b(paramView.nSessionId);
        ((ForwardFileInfo)localObject).c(paramView.uniseq);
        ((ForwardFileInfo)localObject).d(paramView.fileName);
        ((ForwardFileInfo)localObject).d(paramView.fileSize);
        ((ForwardFileInfo)localObject).b(paramView.Uuid);
        paramView = new Intent(QfileBaseCloudFileTabView.a(this.a), FileBrowserActivity.class);
        paramView.putExtra("fileinfo", (Parcelable)localObject);
        QfileBaseCloudFileTabView.b(this.a).startActivityForResult(paramView, 102);
      }
      else if (((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject).c == 2)
      {
        this.a.a.a().ae();
        QfileBaseCloudFileTabView.j(this.a).a().a(paramView.nSessionId);
        continue;
        this.a.a.a().ad();
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131363449);
          return;
        }
        if ((FileManagerUtil.a()) && (localWeiYunFileInfo.jdField_a_of_type_Long > 5242880L))
        {
          FMDialogUtil.a(this.a.getContext(), 2131362021, 2131362019, new die(this, localWeiYunFileInfo));
        }
        else
        {
          paramView = FileManagerUtil.a(localWeiYunFileInfo);
          QfileBaseCloudFileTabView.m(this.a).a().a(paramView);
          QfileBaseCloudFileTabView.n(this.a).a().a(paramView);
          this.a.a(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dib
 * JD-Core Version:    0.7.0.1
 */