import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class dmr
  implements View.OnClickListener
{
  public dmr(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    paramView = (QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.i();
      return;
      this.a.a.a().ad();
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131363461);
        return;
      }
      if ((FileManagerUtil.a()) && (localFileManagerEntity.fileSize > 5242880L))
      {
        FMDialogUtil.a(this.a.getContext(), 2131362018, 2131362016, new dms(this, localFileManagerEntity));
      }
      else if (localFileManagerEntity.cloudType == 0)
      {
        QfileBaseRecentFileTabView.g(this.a).a().a(localFileManagerEntity.nSessionId);
      }
      else
      {
        QfileBaseRecentFileTabView.h(this.a).a().a(localFileManagerEntity);
        continue;
        this.a.a.a().ac();
        this.a.c(localFileManagerEntity);
        continue;
        this.a.a.a().ae();
        if (localFileManagerEntity.cloudType == 0)
        {
          QfileBaseRecentFileTabView.i(this.a).a().a(localFileManagerEntity.nSessionId);
        }
        else
        {
          QfileBaseRecentFileTabView.j(this.a).a().a(localFileManagerEntity.nSessionId);
          continue;
          this.a.a.a().af();
          if (!NetworkUtil.e(BaseApplication.getContext()))
          {
            FMToastUtil.a(2131363461);
            return;
          }
          if ((FileManagerUtil.a()) && (localFileManagerEntity.fileSize > 5242880L)) {
            FMDialogUtil.a(this.a.getContext(), 2131362018, 2131362016, new dmt(this, localFileManagerEntity));
          } else if (localFileManagerEntity.cloudType == 0) {
            QfileBaseRecentFileTabView.m(this.a).a().b(localFileManagerEntity.nSessionId);
          } else {
            QfileBaseRecentFileTabView.n(this.a).a().a(localFileManagerEntity.nSessionId);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmr
 * JD-Core Version:    0.7.0.1
 */