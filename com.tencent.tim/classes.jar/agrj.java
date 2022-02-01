import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.kwstudio.office.preview.TdsReaderView;
import com.tencent.kwstudio.office.preview.TdsReaderView.OpenCallback;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTdsViewManager.OpenCallbackImpl.1;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class agrj
{
  private static agrj jdField_a_of_type_Agrj;
  private TdsReaderView jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView;
  private int mCurrent = -1;
  
  public static agrj a()
  {
    if (jdField_a_of_type_Agrj == null) {
      jdField_a_of_type_Agrj = new agrj();
    }
    return jdField_a_of_type_Agrj;
  }
  
  private static boolean a(TdsReaderView paramTdsReaderView, String paramString)
  {
    String str = ahbj.getExtension(paramString);
    paramString = str;
    if (str.startsWith(".")) {
      paramString = str.replaceFirst(".", "");
    }
    return paramTdsReaderView.preOpen(paramString);
  }
  
  public TdsReaderView a(Activity paramActivity, String paramString, agrj.a parama)
  {
    TdsReaderView localTdsReaderView = null;
    if ((this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView != null) && (paramActivity.hashCode() == this.mCurrent)) {
      localTdsReaderView = this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView;
    }
    do
    {
      return localTdsReaderView;
      if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView != null)
      {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.onStop();
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView = null;
      }
    } while (!ahbj.fileExistsAndNotEmpty(paramString));
    if (!TdsReaderGlobal.isEnable())
    {
      QLog.w("TdsReaderView_LocalTdsViewManager", 4, "openFile: tds disable for filePath=" + paramString);
      return null;
    }
    QLog.w("TdsReaderView_LocalTdsViewManager", 4, "initVarView: new TdsReaderView");
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView = TdsReaderView.newInstance(new agrj.b(paramActivity, false, parama, null));
    if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView != null)
    {
      QLog.w("TdsReaderView_LocalTdsViewManager", 4, "initVarView: TbsReaderView openFile");
      if (a(this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView, paramString))
      {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.openFile(paramString, ".pdf");
        this.mCurrent = paramActivity.hashCode();
        return this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView;
      }
      this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.onStop();
      this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView = null;
      return null;
    }
    QLog.w("TdsReaderView_LocalTdsViewManager", 4, "openFile: tds instance failed for filePath=" + paramString);
    return null;
  }
  
  public boolean a(Activity paramActivity, String paramString, agrj.a parama, boolean paramBoolean)
  {
    boolean bool = false;
    paramBoolean = bool;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TdsReaderGlobal.isEnable())
      {
        QLog.w("TdsReaderView_LocalTdsViewManager", 4, "canOpenFile: tds disable for filePath=" + paramString);
        paramBoolean = bool;
      }
    }
    else if (QLog.isColorLevel()) {
      if (!paramBoolean) {
        break label150;
      }
    }
    label150:
    for (paramActivity = "pre open file true! wait callback!";; paramActivity = "pre open file false! strPath=" + paramString)
    {
      QLog.i("TdsReaderView_LocalTdsViewManager", 1, paramActivity);
      if (parama != null) {
        parama.Jy(paramBoolean);
      }
      return paramBoolean;
      paramActivity = TdsReaderView.newInstance(new agrj.b(paramActivity, true, null, null));
      if (paramActivity != null)
      {
        paramBoolean = a(paramActivity, paramString);
        paramActivity.onStop();
        break;
      }
      QLog.w("TdsReaderView_LocalTdsViewManager", 4, "canOpenFile: tds instance failed for filePath=" + paramString);
      paramBoolean = bool;
      break;
    }
  }
  
  public void onDestroy(Activity paramActivity)
  {
    int i = paramActivity.hashCode();
    if (QLog.isDevelopLevel()) {
      QLog.d("TdsReaderView_LocalTdsViewManager", 4, "destroy hashCode[" + this.mCurrent + "],activity[" + i + "]");
    }
    if (this.mCurrent != i) {}
    while (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.onStop();
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView = null;
  }
  
  public static abstract interface a
  {
    public abstract void Jy(boolean paramBoolean);
    
    public abstract void bY(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static final class b
    implements TdsReaderView.OpenCallback
  {
    private final agrj.a a;
    private final boolean ceR;
    private final WeakReference<Activity> gR;
    private final int mTitleBarHeight;
    
    private b(Activity paramActivity, boolean paramBoolean, agrj.a parama)
    {
      this.gR = new WeakReference(paramActivity);
      this.ceR = paramBoolean;
      this.a = parama;
      if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
      for (int i = (int)paramActivity.getResources().getDimension(2131299627);; i = 0)
      {
        this.mTitleBarHeight = i;
        return;
      }
    }
    
    public void onCallBackAction(Integer paramInteger, Object paramObject, Bundle paramBundle)
    {
      if (this.ceR) {
        QLog.i("TdsReaderView_LocalTdsViewManager", 1, "onCallBackAction actionType[" + paramInteger + "]");
      }
      Activity localActivity;
      do
      {
        do
        {
          return;
          localActivity = (Activity)this.gR.get();
        } while ((localActivity == null) || (localActivity.isFinishing()));
        if (paramInteger.intValue() != 1001) {
          break;
        }
      } while (paramBundle == null);
      paramBundle.putInt("result_", this.mTitleBarHeight);
      return;
      localActivity.runOnUiThread(new LocalTdsViewManager.OpenCallbackImpl.1(this, paramInteger, paramObject, paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrj
 * JD-Core Version:    0.7.0.1
 */