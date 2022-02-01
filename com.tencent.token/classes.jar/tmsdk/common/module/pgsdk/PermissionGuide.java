package tmsdk.common.module.pgsdk;

import Protocol.MGuide.MSolution;
import Protocol.MMGRAuth.SolutionItem;
import android.app.Application;
import android.util.Log;
import com.tencent.qqpimsecure.pg.g;
import com.tencent.qqpimsecure.taiji.c;
import taiji.b;
import taiji.bn;
import tmsdk.common.module.pgsdk.manager.AccessFactoryManager;
import tmsdk.common.module.pgsdk.manager.IAccessFactory;
import tmsdk.common.module.pgsdk.manager.ITaijiFactory;

public class PermissionGuide
{
  public static PermissionRequest build(int... paramVarArgs)
  {
    return new PermissionRequest(paramVarArgs, null);
  }
  
  public static boolean canEnableHelper()
  {
    return g.a().d();
  }
  
  public static int checkPermission(int paramInt)
  {
    return checkPermissions(new int[] { paramInt })[0];
  }
  
  public static int[] checkPermissions(int... paramVarArgs)
  {
    return g.a().a(paramVarArgs);
  }
  
  public static int getHelperAdapterID(int paramInt)
  {
    return g.a().e(paramInt);
  }
  
  public static b getHelperSolution(int paramInt)
  {
    return g.a().h(paramInt);
  }
  
  public static long getHelperSolutionID(int paramInt)
  {
    return g.a().c(paramInt);
  }
  
  public static int getManualAdapterID(int paramInt)
  {
    return g.a().d(paramInt);
  }
  
  public static MSolution getManualSolution(int paramInt)
  {
    return g.a().g(paramInt);
  }
  
  public static long getManualSolutionID(int paramInt)
  {
    return g.a().b(paramInt);
  }
  
  public static String getPermissionName(int paramInt)
  {
    return g.a().j(paramInt);
  }
  
  public static SolutionItem getSolutionItem(int paramInt)
  {
    return g.a().i(paramInt);
  }
  
  public static boolean hasAdapterData()
  {
    return g.a().c();
  }
  
  public static int hasAdapterSolution(int paramInt)
  {
    return g.a().a(paramInt);
  }
  
  public static void init(Application paramApplication, ITaijiFactory paramITaijiFactory)
  {
    init(paramApplication, paramITaijiFactory, null);
  }
  
  public static void init(Application paramApplication, ITaijiFactory paramITaijiFactory, IAccessFactory paramIAccessFactory)
  {
    Log.i("TaiJi", "sdk version detail:2.0.0_2_107022_20191030215959_04578bd");
    c.a().a(paramITaijiFactory);
    AccessFactoryManager.get().init(paramIAccessFactory);
    g.a().a(paramApplication);
  }
  
  public static boolean isPermissionDefaultEnable(int paramInt)
  {
    return g.a().f(paramInt);
  }
  
  public static void pullAdapterSolution()
  {
    g.a().b();
  }
  
  public static void registerUpdateListener(UpdateListener paramUpdateListener)
  {
    g.a().a(paramUpdateListener);
  }
  
  public static void reportSolutionOperation(int paramInt, boolean paramBoolean)
  {
    g.a().a(paramInt, paramBoolean);
  }
  
  public static void setHelperCallback(ExecuteHelperCallback paramExecuteHelperCallback)
  {
    g.a().a(paramExecuteHelperCallback);
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    bn.a(paramBoolean);
  }
  
  public static void setPageCallback(PageCallback paramPageCallback)
  {
    g.a().a(paramPageCallback);
  }
  
  public static void setPreviewCallback(PreviewCallback paramPreviewCallback)
  {
    g.a().a(paramPreviewCallback);
  }
  
  public static void setWindowCallback(WindowCallback paramWindowCallback)
  {
    g.a().a(paramWindowCallback);
  }
  
  public static abstract interface AdapterState
  {
    public static final int STATE_BOTH_ALL_SOLUTION = 3;
    public static final int STATE_NO_SOLUTION = 0;
    public static final int STATE_ONLY_HELPER_SOLUTION = 1;
    public static final int STATE_ONLY_MANUAL_SOLUTION = 2;
  }
  
  public static class PermissionRequest
  {
    private int[] a;
    private int b = 0;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    
    private PermissionRequest(int... paramVarArgs)
    {
      this.a = paramVarArgs;
    }
    
    public PermissionRequest manualQuick(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public PermissionRequest monitor(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }
    
    public void request(RequestCallback paramRequestCallback)
    {
      if (this.b != 0)
      {
        g.a().a(this.a, this.d, this.e, this.c, paramRequestCallback);
        return;
      }
      if (this.f)
      {
        g.a().c(this.a, this.d, this.e, this.c, paramRequestCallback);
        return;
      }
      g.a().b(this.a, this.d, this.e, this.c, paramRequestCallback);
    }
    
    public PermissionRequest skipCheck(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
    
    public PermissionRequest source(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public PermissionRequest type(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
  }
  
  public static abstract interface RequestType
  {
    public static final int HELPER_TYPE = 1;
    public static final int MANUAL_TYPE = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.PermissionGuide
 * JD-Core Version:    0.7.0.1
 */