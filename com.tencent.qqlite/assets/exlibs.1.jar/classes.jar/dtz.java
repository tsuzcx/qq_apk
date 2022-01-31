import android.app.Activity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView;

class dtz
  extends FMObserver
{
  dtz(dty paramdty) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        dty.a(this.a, paramString3, paramString4, paramInt2, paramString2);
        this.a.a.e();
        return;
      }
      finally {}
      PreviewingOfflineFileView.b(this.a.a).runOnUiThread(new dub(this, paramInt1, paramString1));
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        dty.a(this.a, paramString3, paramString4, paramInt2, paramString2);
        this.a.a.e();
        return;
      }
      finally {}
      PreviewingOfflineFileView.a(this.a.a).runOnUiThread(new dua(this, paramInt1, paramString1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtz
 * JD-Core Version:    0.7.0.1
 */