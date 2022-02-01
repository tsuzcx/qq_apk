import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient;", "", "()V", "TAG", "", "<set-?>", "Lcom/tencent/biz/pubaccount/readinjoy/service/IRIJAidlInterface;", "rijAidlInterface", "getRijAidlInterface", "()Lcom/tencent/biz/pubaccount/readinjoy/service/IRIJAidlInterface;", "rijServiceConnection", "Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient$RIJServiceConnection;", "bindService", "", "context", "Landroid/content/Context;", "getInstance", "unbindService", "RIJServiceConnection", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class mex
{
  @Nullable
  private static mew jdField_a_of_type_Mew;
  private static final mex.a jdField_a_of_type_Mex$a = new mex.a();
  public static final mex a;
  
  static
  {
    jdField_a_of_type_Mex = new mex();
  }
  
  @JvmStatic
  @NotNull
  public static final mex a()
  {
    return jdField_a_of_type_Mex;
  }
  
  @Nullable
  public final mew a()
  {
    return jdField_a_of_type_Mew;
  }
  
  public final void bu(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      paramContext.bindService(new Intent(paramContext, KandianVideoUploadService.class), (ServiceConnection)jdField_a_of_type_Mex$a, 1);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("RIJAidlClient", 1, QLog.getStackTraceString((Throwable)paramContext));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient$RIJServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  static final class a
    implements ServiceConnection
  {
    public void onServiceConnected(@NotNull ComponentName paramComponentName, @NotNull IBinder paramIBinder)
    {
      Intrinsics.checkParameterIsNotNull(paramComponentName, "name");
      Intrinsics.checkParameterIsNotNull(paramIBinder, "service");
      mex.a(mex.a, mew.a.a(paramIBinder));
      QLog.d("RIJAidlClient", 1, "onServiceConnected: " + paramComponentName);
    }
    
    public void onServiceDisconnected(@NotNull ComponentName paramComponentName)
    {
      Intrinsics.checkParameterIsNotNull(paramComponentName, "name");
      mex.a(mex.a, (mew)null);
      QLog.d("RIJAidlClient", 1, "onServiceDisconnected: " + paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mex
 * JD-Core Version:    0.7.0.1
 */