import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.tim.filemanager.fileviewer.FileView.LocalTbsViewManager.3;
import java.io.File;

public class atxy
{
  private static atxy jdField_a_of_type_Atxy;
  private TbsReaderView jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
  private TbsReaderView b;
  private int mCurrent = -1;
  
  public static atxy a()
  {
    if (jdField_a_of_type_Atxy == null) {
      jdField_a_of_type_Atxy = new atxy();
    }
    return jdField_a_of_type_Atxy;
  }
  
  public TbsReaderView a(Activity paramActivity, String paramString, atxy.a parama, boolean paramBoolean)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null) && (paramActivity.hashCode() == this.mCurrent) && (!paramBoolean)) {
      localObject = this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    }
    while (!aueh.fileExistsAndNotEmpty(paramString)) {
      return localObject;
    }
    if (this.b != null)
    {
      this.b.onStop();
      this.b = null;
    }
    if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null)
    {
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
    }
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: new TbsReaderView");
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = new TbsReaderView(paramActivity, new atxz(this, paramActivity, parama, paramString));
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: TbsReaderView openFile");
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.setBackgroundColor(-65536);
    localObject = aueh.getExtension(paramString);
    parama = (atxy.a)localObject;
    if (((String)localObject).startsWith(".")) {
      parama = ((String)localObject).replaceFirst(".", "");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.preOpen(parama, false))
      {
        parama = new Bundle();
        parama.putString("filePath", paramString);
        paramString = audn.a().vZ();
        localObject = new File(paramString);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        parama.putString("tempPath", paramString);
        this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.openFile(parama);
        this.mCurrent = paramActivity.hashCode();
        return this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
      }
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
        QLog.e("LocalTbsViewManager<FileAssistant>", 1, " openfile preOpen , e = ", paramActivity);
      }
    }
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
    return null;
  }
  
  public void a(Activity paramActivity, String paramString, atxy.a parama, boolean paramBoolean)
  {
    if (paramActivity == null) {
      QLog.e("LocalTbsViewManager<FileAssistant>", 2, "activity is null-------");
    }
    do
    {
      return;
      if (this.b != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "canOpenFile return 2-------");
        }
        this.b.onStop();
        this.b = null;
      }
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (parama == null);
    parama.Jy(false);
    return;
    TbsReaderView localTbsReaderView = new TbsReaderView(paramActivity, new atyd(this, parama));
    ThreadManager.executeOnSubThread(new LocalTbsViewManager.3(this, paramString, paramBoolean, localTbsReaderView, paramActivity, parama));
    this.b = localTbsReaderView;
  }
  
  public void onDestroy(Activity paramActivity)
  {
    int i = paramActivity.hashCode();
    if (QLog.isDevelopLevel()) {
      QLog.d("LocalTbsViewManager<FileAssistant>", 4, "LocalTbsViewManager destroy hashCode[" + this.mCurrent + "],activity[" + i + "]");
    }
    if (this.mCurrent != i) {}
    do
    {
      return;
      if (this.b != null)
      {
        this.b.onStop();
        this.b = null;
      }
    } while (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView == null);
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
  }
  
  public static abstract interface a
  {
    public abstract void Jy(boolean paramBoolean);
    
    public abstract void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener);
    
    public abstract void as(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxy
 * JD-Core Version:    0.7.0.1
 */