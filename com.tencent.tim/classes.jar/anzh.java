import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tablequery.TableQueryController.1;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class anzh
{
  private static anzh jdField_a_of_type_Anzh;
  public static boolean cKQ = true;
  public static boolean cKR;
  private static boolean cKS;
  public static boolean isRunning;
  private anzj jdField_a_of_type_Anzj = new anzj();
  private TableQueryViewer jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer;
  private WeakReference<QQAppInterface> mApp;
  private BroadcastReceiver mBroadcastReceiver = new anzi(this);
  private boolean mIsAttached;
  private WindowManager mWindowManager;
  
  /* Error */
  public static anzh a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 44	anzh:jdField_a_of_type_Anzh	Lanzh;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	anzh
    //   15: dup
    //   16: invokespecial 45	anzh:<init>	()V
    //   19: putstatic 44	anzh:jdField_a_of_type_Anzh	Lanzh;
    //   22: ldc 2
    //   24: monitorexit
    //   25: ldc 2
    //   27: monitorexit
    //   28: getstatic 44	anzh:jdField_a_of_type_Anzh	Lanzh;
    //   31: areturn
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	5	0	localObject1	Object
    //   38	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	32	finally
    //   33	36	32	finally
    //   3	12	38	finally
    //   25	28	38	finally
    //   36	38	38	finally
    //   39	42	38	finally
  }
  
  public int a(anzg paramanzg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.a(paramanzg);
  }
  
  public void a(anzg paramanzg)
  {
    if (isRunning) {
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.a(paramanzg);
    }
  }
  
  public void clearData()
  {
    if (isRunning) {
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.clearData();
    }
  }
  
  public void hide()
  {
    if (this.mIsAttached) {
      this.mWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer);
    }
    this.mIsAttached = false;
  }
  
  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      cKS = true;
      if (!cKR) {
        a().clearData();
      }
    }
    while (paramMotionEvent.getAction() != 1) {
      return;
    }
    paramMotionEvent = new TableQueryController.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(paramMotionEvent, 400L);
  }
  
  public void show()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer == null)
    {
      this.mWindowManager = ((WindowManager)localBaseApplication.getSystemService("window"));
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = new TableQueryViewer(localBaseApplication);
    }
    if (!this.mIsAttached) {}
    try
    {
      this.mWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer);
      label56:
      int i;
      if (Build.VERSION.SDK_INT >= 26) {
        i = 2038;
      }
      for (;;)
      {
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
        localLayoutParams.gravity = 51;
        localLayoutParams.x = 0;
        localLayoutParams.y = aqcx.dip2px(localBaseApplication, 72.0F);
        try
        {
          this.mWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer, localLayoutParams);
          this.mIsAttached = true;
          return;
          i = 2003;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QQToast.a(localBaseApplication, 1, localBaseApplication.getString(2131690853), 0).show();
          }
        }
      }
    }
    catch (Exception localException2)
    {
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzh
 * JD-Core Version:    0.7.0.1
 */