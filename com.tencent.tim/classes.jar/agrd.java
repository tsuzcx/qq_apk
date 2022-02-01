import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import java.io.File;

public class agrd
{
  private static agrd jdField_a_of_type_Agrd;
  private TbsReaderView jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
  private TbsReaderView b;
  private int mCurrent = -1;
  
  public static agrd a()
  {
    if (jdField_a_of_type_Agrd == null) {
      jdField_a_of_type_Agrd = new agrd();
    }
    return jdField_a_of_type_Agrd;
  }
  
  public TbsReaderView a(Activity paramActivity, String paramString, agrd.a parama)
  {
    if ((this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null) && (paramActivity.hashCode() == this.mCurrent)) {
      return this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    }
    if (!ahbj.fileExistsAndNotEmpty(paramString)) {
      return null;
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
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = new TbsReaderView(paramActivity, new agre(this, paramActivity, parama, paramString));
    QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: TbsReaderView openFile");
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.setBackgroundColor(-1);
    Object localObject = ahbj.getExtension(paramString);
    parama = (agrd.a)localObject;
    if (((String)localObject).startsWith(".")) {
      parama = ((String)localObject).replaceFirst(".", "");
    }
    if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.preOpen(parama, false))
    {
      parama = new Bundle();
      parama.putString("filePath", paramString);
      paramString = ahaf.a().vZ();
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
    this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView = null;
    return null;
  }
  
  public boolean a(Activity paramActivity, String paramString, agrd.a parama, boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "canOpenFile return 2-------");
      }
      this.b.onStop();
      this.b = null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (parama != null) {
        parama.Jy(false);
      }
      return false;
    }
    TbsReaderView localTbsReaderView = new TbsReaderView(paramActivity, new agri(this, parama));
    paramActivity = ahbj.getExtension(paramString);
    if (paramActivity.startsWith(".")) {
      paramActivity = paramActivity.replaceFirst(".", "");
    }
    for (;;)
    {
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        if (localTbsReaderView.preOpen(paramActivity, bool)) {
          break label152;
        }
        localTbsReaderView.onStop();
        if (parama != null) {
          parama.Jy(false);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file false!");
        return false;
      }
      label152:
      if ((paramBoolean) && (parama != null)) {
        parama.Jy(true);
      }
      if (QLog.isColorLevel()) {
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file true! wait callback!");
      }
      this.b = localTbsReaderView;
      return true;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrd
 * JD-Core Version:    0.7.0.1
 */