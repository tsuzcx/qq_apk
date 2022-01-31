import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.mpfile.LiteMpFileMainActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.qphone.base.util.QLog;

public class djh
  implements View.OnClickListener
{
  public djh(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QfileFileAssistantActivity.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.i(QfileFileAssistantActivity.c, 2, "click too fast , wait a minute.");
      }
    }
    long l;
    do
    {
      do
      {
        return;
        QfileFileAssistantActivity.a(this.a);
        paramView = (FileCategoryAdapter.ItemHolder)paramView.getTag();
      } while (paramView.a == 0);
      l = paramView.a;
      switch ((int)l)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e(QfileFileAssistantActivity.c, 2, "unknow category!!! return onClick");
    return;
    paramView = new FileManagerReporter.fileAssistantReportData();
    paramView.b = "file_assistant_in";
    paramView.a = 1;
    FileManagerReporter.a(this.a.app.a(), paramView);
    paramView = new Intent(this.a.getApplicationContext(), LiteActivity.class);
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong("category", l);
        paramView.putExtra("bundle", localBundle);
        this.a.startActivityForResult(paramView, 101);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.b = "file_assistant_in";
      paramView.a = 2;
      FileManagerReporter.a(this.a.app.a(), paramView);
      paramView = new Intent(this.a.getApplicationContext(), FMActivity.class);
      paramView.putExtra("tab_tab_type", 0);
      continue;
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.b = "file_assistant_in";
      paramView.a = 3;
      FileManagerReporter.a(this.a.app.a(), paramView);
      QfileFileAssistantActivity.b(this.a);
      return;
      paramView = new Intent(this.a.getApplicationContext(), LiteMpFileMainActivity.class);
      this.a.startActivity(paramView);
      return;
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.b = "file_assistant_in";
      paramView.a = 10;
      FileManagerReporter.a(this.a.app.a(), paramView);
      paramView = new Intent(this.a.getApplicationContext(), FMActivity.class);
      paramView.putExtra("tab_tab_type", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     djh
 * JD-Core Version:    0.7.0.1
 */