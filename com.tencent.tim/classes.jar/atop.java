import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.tim.filemanager.widget.NoFileRelativeLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class atop
  extends AsyncTask<String, String, List<FileInfo>>
{
  public atop(LocalFileBrowserActivity paramLocalFileBrowserActivity, boolean paramBoolean) {}
  
  protected List<FileInfo> doInBackground(String... paramVarArgs)
  {
    int i = 0;
    if (this.this$0.lN == 6) {
      if (audx.wc().equalsIgnoreCase(paramVarArgs[0])) {
        paramVarArgs = audx.a(false, 0);
      }
    }
    for (;;)
    {
      String[] arrayOfString = this.this$0.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
      if ((arrayOfString == null) || (paramVarArgs == null)) {
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
            if (asbc.f(localFileInfo.getName().toLowerCase(), arrayOfString)) {}
          }
          else
          {
            paramVarArgs.remove(i);
            j = i - 1;
          }
        }
        i = j + 1;
      }
      paramVarArgs = aueh.getFiles(paramVarArgs[0], false, 0);
      continue;
      paramVarArgs = aueh.getFiles(paramVarArgs[0], false, 1);
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
      if (this.this$0.jdField_a_of_type_Atwf.getCount() != 0)
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
      audx.H(this.this$0.centerView);
      return;
      if (this.this$0.kv.containsKey(this.this$0.currentPath))
      {
        int i = ((Integer)this.this$0.kv.get(this.this$0.currentPath)).intValue();
        if (this.this$0.jdField_a_of_type_Atwf.getCount() > i) {
          LocalFileBrowserActivity.a(this.this$0, i);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetNoFileRelativeLayout.setVisibility(8);
    audx.a(this.this$0.h, this.this$0.centerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atop
 * JD-Core Version:    0.7.0.1
 */