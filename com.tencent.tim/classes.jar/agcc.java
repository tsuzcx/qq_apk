import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class agcc
  extends AsyncTask<String, String, List<FileInfo>>
{
  public agcc(LocalFileBrowserActivity paramLocalFileBrowserActivity, boolean paramBoolean) {}
  
  protected List<FileInfo> doInBackground(String... paramVarArgs)
  {
    int i = 0;
    if (this.this$0.lN == 6) {
      if (ahav.wc().equalsIgnoreCase(paramVarArgs[0])) {
        paramVarArgs = ahav.a(false, 0);
      }
    }
    for (;;)
    {
      if (this.this$0.ccS)
      {
        localObject = ahbj.getFiles(new File(agmy.bmg).getAbsolutePath(), false, 0);
        if (localObject != null) {
          paramVarArgs.addAll((Collection)localObject);
        }
      }
      Object localObject = this.this$0.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
      if ((localObject == null) || (paramVarArgs == null)) {
        break;
      }
      while (i < paramVarArgs.size())
      {
        FileInfo localFileInfo = (FileInfo)paramVarArgs.get(i);
        int j = i;
        if (!localFileInfo.isDirectory()) {
          if (localFileInfo.getSize() != 0L)
          {
            j = i;
            if (asbc.f(localFileInfo.getName().toLowerCase(), (String[])localObject)) {}
          }
          else
          {
            paramVarArgs.remove(i);
            j = i - 1;
          }
        }
        i = j + 1;
      }
      paramVarArgs = ahbj.getFiles(paramVarArgs[0], false, 0);
      continue;
      paramVarArgs = ahbj.getFiles(paramVarArgs[0], false, 1);
    }
    return paramVarArgs;
  }
  
  protected void onPostExecute(List<FileInfo> paramList)
  {
    this.this$0.wA.clear();
    if (paramList != null)
    {
      this.this$0.wA.addAll(paramList);
      paramList.clear();
    }
    if (this.ccU)
    {
      if (this.this$0.jdField_a_of_type_Agnh.getCount() != 0)
      {
        if (!this.this$0.c.isStackFromBottom()) {
          this.this$0.c.setStackFromBottom(true);
        }
        this.this$0.c.setStackFromBottom(false);
      }
      LocalFileBrowserActivity.a(this.this$0);
    }
    for (;;)
    {
      ahav.H(this.this$0.centerView);
      return;
      if (this.this$0.kv.containsKey(this.this$0.currentPath))
      {
        int i = ((Integer)this.this$0.kv.get(this.this$0.currentPath)).intValue();
        if (this.this$0.jdField_a_of_type_Agnh.getCount() > i) {
          LocalFileBrowserActivity.a(this.this$0, i);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    ahav.a(this.this$0.h, this.this$0.centerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agcc
 * JD-Core Version:    0.7.0.1
 */