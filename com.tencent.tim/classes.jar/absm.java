import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowTest.4;
import com.tencent.mobileqq.apollo.sdk.CmShowTest.5;
import com.tencent.mobileqq.apollo.sdk.CmShowTest.6;
import com.tencent.mobileqq.apollo.sdk.CmShowTest.7;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class absm
{
  private static int SE;
  
  private static void a(CmShowRenderView paramCmShowRenderView)
  {
    QLog.i("CmShowTest", 1, "testMainAction");
    CmShowRenderView.PlayActionConfig localPlayActionConfig = new CmShowRenderView.PlayActionConfig();
    localPlayActionConfig.mActionId = 3000272;
    localPlayActionConfig.crn = 101;
    localPlayActionConfig.cri = 2;
    localPlayActionConfig.bFa = false;
    paramCmShowRenderView.a(localPlayActionConfig);
  }
  
  private static void b(CmShowRenderView paramCmShowRenderView)
  {
    QLog.i("CmShowTest", 1, "testPostAction");
    CmShowRenderView.PlayActionConfig localPlayActionConfig = new CmShowRenderView.PlayActionConfig();
    localPlayActionConfig.mActionId = 3000272;
    localPlayActionConfig.crn = 102;
    localPlayActionConfig.bFa = false;
    localPlayActionConfig.cri = 3;
    paramCmShowRenderView.a(localPlayActionConfig);
  }
  
  private static void c(CmShowRenderView paramCmShowRenderView)
  {
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.4(paramCmShowRenderView), 5000L);
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.5(paramCmShowRenderView), 10000L);
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.6(paramCmShowRenderView), 15000L);
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.7(paramCmShowRenderView), 20000L);
  }
  
  private static void u(RelativeLayout paramRelativeLayout)
  {
    QLog.i("CmShowTest", 1, "init relativeLayout:" + paramRelativeLayout);
    CmShowRenderView localCmShowRenderView = new CmShowRenderView(paramRelativeLayout.getContext());
    paramRelativeLayout.addView(localCmShowRenderView, new RelativeLayout.LayoutParams(-1, -1));
    localCmShowRenderView.a(new abso(localCmShowRenderView), "1725000451", "1174992642", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absm
 * JD-Core Version:    0.7.0.1
 */