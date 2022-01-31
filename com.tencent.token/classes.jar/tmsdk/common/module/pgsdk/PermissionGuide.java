package tmsdk.common.module.pgsdk;

import Protocol.MGuide.MSolution;
import Protocol.MMGRAuth.SolutionItem;
import android.app.Application;
import android.util.Log;
import com.tencent.qqpimsecure.pg.r;
import com.tencent.qqpimsecure.taiji.f;
import taiji.b;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.AccessFactoryManager;
import tmsdk.common.module.pgsdk.manager.IAccessFactory;
import tmsdk.common.module.pgsdk.manager.ITaijiFactory;

public class PermissionGuide
{
  public static PermissionGuide.PermissionRequest build(int... paramVarArgs)
  {
    return new PermissionGuide.PermissionRequest(paramVarArgs, null);
  }
  
  public static boolean canEnableHelper()
  {
    return r.a().d();
  }
  
  public static int checkPermission(int paramInt)
  {
    return checkPermissions(new int[] { paramInt })[0];
  }
  
  public static int[] checkPermissions(int... paramVarArgs)
  {
    return r.a().a(paramVarArgs);
  }
  
  public static int getHelperAdapterID(int paramInt)
  {
    return r.a().e(paramInt);
  }
  
  public static b getHelperSolution(int paramInt)
  {
    return r.a().h(paramInt);
  }
  
  public static long getHelperSolutionID(int paramInt)
  {
    return r.a().c(paramInt);
  }
  
  public static int getManualAdapterID(int paramInt)
  {
    return r.a().d(paramInt);
  }
  
  public static MSolution getManualSolution(int paramInt)
  {
    return r.a().g(paramInt);
  }
  
  public static long getManualSolutionID(int paramInt)
  {
    return r.a().b(paramInt);
  }
  
  public static String getPermissionName(int paramInt)
  {
    return r.a().j(paramInt);
  }
  
  public static SolutionItem getSolutionItem(int paramInt)
  {
    return r.a().i(paramInt);
  }
  
  public static boolean hasAdapterData()
  {
    return r.a().c();
  }
  
  public static int hasAdapterSolution(int paramInt)
  {
    return r.a().a(paramInt);
  }
  
  public static void init(Application paramApplication, ITaijiFactory paramITaijiFactory)
  {
    init(paramApplication, paramITaijiFactory, null);
  }
  
  public static void init(Application paramApplication, ITaijiFactory paramITaijiFactory, IAccessFactory paramIAccessFactory)
  {
    Log.i("TaiJi", "sdk version detail:2.0.0_2_107022_20191030215959_04578bd");
    f.a().a(paramITaijiFactory);
    AccessFactoryManager.get().init(paramIAccessFactory);
    r.a().a(paramApplication);
  }
  
  public static boolean isPermissionDefaultEnable(int paramInt)
  {
    return r.a().f(paramInt);
  }
  
  public static void pullAdapterSolution()
  {
    r.a().b();
  }
  
  public static void registerUpdateListener(UpdateListener paramUpdateListener)
  {
    r.a().a(paramUpdateListener);
  }
  
  public static void reportSolutionOperation(int paramInt, boolean paramBoolean)
  {
    r.a().a(paramInt, paramBoolean);
  }
  
  public static void setHelperCallback(ExecuteHelperCallback paramExecuteHelperCallback)
  {
    r.a().a(paramExecuteHelperCallback);
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    cl.a(paramBoolean);
  }
  
  public static void setPageCallback(PageCallback paramPageCallback)
  {
    r.a().a(paramPageCallback);
  }
  
  public static void setPreviewCallback(PreviewCallback paramPreviewCallback)
  {
    r.a().a(paramPreviewCallback);
  }
  
  public static void setWindowCallback(WindowCallback paramWindowCallback)
  {
    r.a().a(paramWindowCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.PermissionGuide
 * JD-Core Version:    0.7.0.1
 */