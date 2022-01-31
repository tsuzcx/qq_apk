import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.List;

public class dsp
  implements IFileViewListener
{
  public dsp(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void a()
  {
    FileViewMusicService.a().a(FileBrowserActivity.a(this.a), FileBrowserActivity.a(this.a));
    Handler localHandler = this.a.app.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(1134026, null).sendToTarget();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == FileBrowserActivity.a(this.a)) {
      return;
    }
    FileBrowserActivity.a(this.a, paramInt);
    FileBrowserActivity.b(this.a);
    FileBrowserActivity.a(this.a).c();
    FileBrowserActivity.c(this.a);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (!FileBrowserActivity.b(this.a)) {
      return;
    }
    FileBrowserActivity.b(this.a);
    IFileViewerAdapter localIFileViewerAdapter = this.a.a();
    localIFileViewerAdapter.d(paramBoolean);
    if (FileBrowserActivity.a(this.a) > 0)
    {
      paramBoolean = true;
      if (FileBrowserActivity.a(this.a) >= FileBrowserActivity.a(this.a).size() - 1) {
        break label143;
      }
    }
    for (;;)
    {
      localIFileViewerAdapter.e(paramBoolean);
      localIFileViewerAdapter.f(bool);
      FileBrowserActivity.a(this.a).a(this.a.a());
      FileBrowserActivity.a(this.a).b();
      FileBrowserActivity.b(this.a);
      FileBrowserActivity.a(this.a).c();
      FileBrowserActivity.c(this.a);
      return;
      paramBoolean = false;
      break;
      label143:
      bool = false;
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (str != null) {
        FileManagerReporter.a(str);
      }
      return;
      if (FileBrowserActivity.e(this.a))
      {
        str = "0X8004BB5";
      }
      else
      {
        str = "0X8004BCA";
        continue;
        if (FileBrowserActivity.e(this.a)) {
          str = "0X8004BB4";
        } else {
          str = "0X8004BC9";
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!FileBrowserActivity.c(this.a)) {
      return;
    }
    FileBrowserActivity.c(this.a);
    IFileViewerAdapter localIFileViewerAdapter = this.a.a();
    boolean bool1;
    if (FileBrowserActivity.a(this.a) > 0)
    {
      bool1 = true;
      if (FileBrowserActivity.a(this.a) >= FileBrowserActivity.a(this.a).size() - 1) {
        break label142;
      }
    }
    for (;;)
    {
      localIFileViewerAdapter.e(bool1);
      localIFileViewerAdapter.f(bool2);
      localIFileViewerAdapter.d(paramBoolean);
      FileBrowserActivity.a(this.a).a(localIFileViewerAdapter);
      FileBrowserActivity.a(this.a).b();
      FileBrowserActivity.b(this.a);
      FileBrowserActivity.a(this.a).c();
      FileBrowserActivity.c(this.a);
      return;
      bool1 = false;
      break;
      label142:
      bool2 = false;
    }
  }
  
  public void c()
  {
    FileBrowserActivity.a(this.a, true);
  }
  
  public void c(boolean paramBoolean)
  {
    FileBrowserActivity.a(this.a, paramBoolean);
    View localView = this.a.findViewById(2131298099);
    if (!FileBrowserActivity.d(this.a)) {
      localView.setVisibility(0);
    }
    while (FileBrowserActivity.a(this.a) == null)
    {
      return;
      localView.setVisibility(8);
    }
    if (paramBoolean)
    {
      FileBrowserActivity.a(this.a).b();
      return;
    }
    FileBrowserActivity.a(this.a).a();
  }
  
  public void d()
  {
    FileBrowserActivity.a(this.a);
  }
  
  public void d(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.a.findViewById(2131296901);
    if (paramBoolean)
    {
      FileManagerUtil.a(this.a, localTextView);
      return;
    }
    FileManagerUtil.a(localTextView);
  }
  
  public void e()
  {
    FileBrowserActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsp
 * JD-Core Version:    0.7.0.1
 */