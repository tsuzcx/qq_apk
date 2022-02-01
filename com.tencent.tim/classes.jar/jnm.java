import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver.1;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver.1;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class jnm
{
  public static void a(AppInterface paramAppInterface, jnm.a parama, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramAppInterface == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.getVersion());
    paramArrayOfByte = new NewIntent(paramAppInterface.getApp(), jnl.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (parama != null)
    {
      parama.n = new WeakReference(paramAppInterface);
      parama.mType = 1;
      paramArrayOfByte.setObserver(parama);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramAppInterface.startServlet(paramArrayOfByte);
  }
  
  public static void a(AppInterface paramAppInterface, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    a(paramAppInterface, paramArrayOfByte, paramInt, paramString, null, false);
  }
  
  public static void a(AppInterface paramAppInterface, byte[] paramArrayOfByte, int paramInt, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppInterface.getApp(), jnl.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", paramBoolean);
    localNewIntent.putExtra("RequestType", paramInt);
    localNewIntent.putExtra("DataType", 2);
    paramAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.b paramb, byte[] paramArrayOfByte, String paramString)
  {
    a(paramQQAppInterface, paramb, paramArrayOfByte, paramString, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.b paramb, byte[] paramArrayOfByte, String paramString, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), jnl.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    paramb.n = new WeakReference(paramQQAppInterface);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramb);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString)
  {
    a(paramQQAppInterface, paramd, paramArrayOfByte, paramString, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramd, paramArrayOfByte, paramString, paramInt1, paramInt2, null, 0L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    a(paramQQAppInterface, paramd, paramArrayOfByte, paramString, paramInt1, paramInt2, paramBundle, 0L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    b(paramQQAppInterface, paramd, paramArrayOfByte, paramString, paramInt1, paramInt2, paramBundle, paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, Bundle paramBundle)
  {
    a(paramQQAppInterface, paramd, paramArrayOfByte, paramString, paramBundle, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), jnl.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    paramd.n = new WeakReference(paramQQAppInterface);
    paramd.mType = 2;
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", paramBoolean);
    localNewIntent.setObserver(paramd);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, jnm.d paramd, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.getVersion());
    paramArrayOfByte = new NewIntent(BaseApplicationImpl.getContext(), jnl.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (paramd != null)
    {
      paramd.mType = 1;
      paramArrayOfByte.setObserver(paramd);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramAppRuntime.startServlet(paramArrayOfByte);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    b(paramQQAppInterface, paramd, paramArrayOfByte, paramString, paramInt1, paramInt2, null, 0L);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    b(paramQQAppInterface, paramd, paramArrayOfByte, paramString, paramInt1, paramInt2, paramBundle, 0L);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.getVersion());
    paramArrayOfByte = new NewIntent(paramQQAppInterface.getApp(), jnl.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (paramd != null)
    {
      paramd.n = new WeakReference(paramQQAppInterface);
      paramd.mType = 1;
      paramArrayOfByte.setObserver(paramd);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramQQAppInterface.startServlet(paramArrayOfByte);
  }
  
  public static abstract class a
    extends jnm.d
  {
    public WeakReference<AppInterface> n = new WeakReference(null);
  }
  
  public static abstract class b
    implements BusinessObserver
  {
    public boolean aaN = true;
    public WeakReference<QQAppInterface> n = new WeakReference(null);
    public final long startTime = System.currentTimeMillis();
    
    private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      long l = System.currentTimeMillis() - this.startTime;
      String str = paramBundle.getString("cmd");
      if (paramBoolean)
      {
        localObject = paramBundle.getByteArray("data");
        if ((localObject != null) && (localObject.length > 0))
        {
          paramBundle = a(0, (byte[])localObject, paramBundle);
          if (paramBundle != null)
          {
            paramInt = paramBundle.error_code.get();
            paramBundle = paramBundle.error_desc.get().toStringUtf8();
            if (paramInt == 0) {
              ram.a("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s success take time:%d data length=%d", str, Long.valueOf(l), Integer.valueOf(localObject.length));
            }
            for (;;)
            {
              rar.b("story_net", str, 0, paramInt, new String[] { paramBundle, String.valueOf(l), rar.getNetworkType(BaseApplication.getContext()) });
              return;
              ram.w("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { str, Integer.valueOf(paramInt), paramBundle, Long.valueOf(l), Integer.valueOf(localObject.length) });
            }
          }
          ram.w("Q.qqstory.net:StoryProtocolObserver", "get cmd:%s error. response is null", new Object[] { str });
          rar.b("story_net", str, 0, 940002, new String[] { "response is null", String.valueOf(l), rar.getNetworkType(BaseApplication.getContext()) });
          return;
        }
        a(-1, null, paramBundle);
        ram.w("Q.qqstory.net:StoryProtocolObserver", "get cmd:" + str + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
        rar.b("story_net", str, 0, 940002, new String[] { "rsp data error", String.valueOf(l), rar.getNetworkType(BaseApplication.getContext()) });
        return;
      }
      paramInt = paramBundle.getInt("data_error_code");
      Object localObject = paramBundle.getString("data_error_msg");
      a(paramInt, null, paramBundle);
      ram.w("Q.qqstory.net:StoryProtocolObserver", "get cmd:" + str + " channel error:%d, take time:%d", new Object[] { Integer.valueOf(-1), Long.valueOf(l) });
      rar.b("story_net", str, 0, paramInt, new String[] { localObject, String.valueOf(l), rar.getNetworkType(BaseApplication.getContext()) });
    }
    
    public abstract qqstory_struct.ErrorInfo a(int paramInt, @Nullable byte[] paramArrayOfByte, Bundle paramBundle);
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      if (this.aaN)
      {
        a(paramInt, paramBoolean, paramBundle);
        return;
      }
      ThreadManager.post(new ProtoUtils.StoryProtocolObserver.1(this, paramInt, paramBoolean, paramBundle), 5, null, false);
    }
  }
  
  public static abstract class c
    extends jnm.a
  {}
  
  public static abstract class d
    implements BusinessObserver
  {
    public boolean aaN;
    public int mType = 1;
    public WeakReference<QQAppInterface> n = new WeakReference(null);
    
    public d()
    {
      this.aaN = true;
    }
    
    public d(boolean paramBoolean)
    {
      this.aaN = paramBoolean;
    }
    
    private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      if (!paramBoolean) {
        a(-1, null, paramBundle);
      }
      label168:
      do
      {
        for (;;)
        {
          return;
          Object localObject = paramBundle.getByteArray("data");
          if (this.mType != 1) {
            break label168;
          }
          oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
          try
          {
            localObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])localObject);
            if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() == 0) || (!a(((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get(), ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get(), paramBundle))) {
              if ((localObject == null) || (!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null))
              {
                a(-1, null, paramBundle);
                return;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            a(-1, null, paramBundle);
            return;
          }
        }
        a(localInvalidProtocolBufferMicroException.uint32_result.get(), localInvalidProtocolBufferMicroException.bytes_bodybuffer.get().toByteArray(), paramBundle);
        return;
      } while (this.mType != 2);
      a(0, localInvalidProtocolBufferMicroException, paramBundle);
    }
    
    public abstract void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
    
    public boolean a(int paramInt, String paramString, Bundle paramBundle)
    {
      return false;
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      if (this.aaN)
      {
        a(paramInt, paramBoolean, paramBundle);
        return;
      }
      ThreadManager.post(new ProtoUtils.TroopProtocolObserver.1(this, paramInt, paramBoolean, paramBundle), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnm
 * JD-Core Version:    0.7.0.1
 */