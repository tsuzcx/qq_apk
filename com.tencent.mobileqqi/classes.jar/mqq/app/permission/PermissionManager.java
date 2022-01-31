package mqq.app.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(23)
public class PermissionManager
{
  private static final int GRANTED = 0;
  private PermissionCallback callback;
  private Activity inActivity;
  private PermissionItem[] ps;
  private ConcurrentHashMap<Object, Object> tips = new ConcurrentHashMap();
  
  private PermissionManager(Activity paramActivity)
  {
    this.inActivity = paramActivity;
    if (this.tips.isEmpty())
    {
      this.tips.put("android.permission.CALL_PHONE", "拨号");
      this.tips.put("android.permission.RECORD_AUDIO", "麦克风");
      this.tips.put("android.permission.CAMERA", "摄像头");
      this.tips.put("android.permission.WRITE_EXTERNAL_STORAGE", "写存储");
      this.tips.put("android.permission.READ_EXTERNAL_STORAGE", "读存储");
      this.tips.put("android.permission.READ_PHONE_STATE", "电话权限");
      this.tips.put("android.permission.ACCESS_FINE_LOCATION", "位置");
      this.tips.put("android.permission.SEND_SMS", "发短信");
      this.tips.put("android.permission.READ_SMS", "读短信");
      this.tips.put("android.permission.READ_CONTACTS", "读通讯录");
      this.tips.put("android.permission.WRITE_CONTACTS", "写通讯录");
      this.tips.put("android.permission.GET_ACCOUNTS", "获取通讯录");
    }
  }
  
  public static PermissionManager init(Activity paramActivity)
  {
    return new PermissionManager(paramActivity);
  }
  
  public boolean checkPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (this.inActivity.checkSelfPermission(paramString) == 0) {
      return true;
    }
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i;
    if (paramArrayOfString.length > 0)
    {
      i = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      int k = 0;
      while (k < paramArrayOfInt.length)
      {
        int j = i;
        if (paramArrayOfInt[k] != 0)
        {
          j = i;
          if (i == 0) {
            j = -1;
          }
          if (localStringBuilder.indexOf((String)this.tips.get(paramArrayOfString[k])) < 0) {
            localStringBuilder.append(this.tips.get(paramArrayOfString[k])).append("、");
          }
          if (this.inActivity.shouldShowRequestPermissionRationale(paramArrayOfString[k])) {
            j = -2;
          }
        }
        k += 1;
        i = j;
      }
      if (i == 0) {
        this.callback.grant(paramInt, paramArrayOfString, paramArrayOfInt);
      }
    }
    else
    {
      return;
    }
    if (i == -1)
    {
      this.callback.deny(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    this.callback.deny(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  @TargetApi(23)
  public PermissionManager permissions(PermissionItem... paramVarArgs)
  {
    this.ps = null;
    if ((Build.VERSION.SDK_INT >= 23) && (paramVarArgs.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        PermissionItem localPermissionItem = paramVarArgs[i];
        if (this.inActivity.checkSelfPermission(localPermissionItem.getPermissionKey()) != 0) {
          localArrayList.add(localPermissionItem);
        }
        i += 1;
      }
      this.ps = ((PermissionItem[])localArrayList.toArray(new PermissionItem[localArrayList.size()]));
    }
    return this;
  }
  
  public void request(PermissionCallback paramPermissionCallback)
  {
    if ((this.ps != null) && (this.ps.length > 0))
    {
      this.callback = paramPermissionCallback;
      paramPermissionCallback = this.ps;
      int j = paramPermissionCallback.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramPermissionCallback[i];
        Activity localActivity = this.inActivity;
        String str = localObject.getPermissionKey();
        int k = localObject.getRequestCode();
        localActivity.requestPermissions(new String[] { str }, k);
        i += 1;
      }
    }
  }
  
  public void requests(PermissionCallback paramPermissionCallback)
  {
    if ((this.ps != null) && (this.ps.length > 0))
    {
      this.callback = paramPermissionCallback;
      paramPermissionCallback = new ArrayList();
      int j = 9999;
      PermissionItem[] arrayOfPermissionItem = this.ps;
      int k = arrayOfPermissionItem.length;
      int i = 0;
      while (i < k)
      {
        PermissionItem localPermissionItem = arrayOfPermissionItem[i];
        paramPermissionCallback.add(localPermissionItem.getPermissionKey());
        j = localPermissionItem.getRequestCode();
        i += 1;
      }
      this.inActivity.requestPermissions((String[])paramPermissionCallback.toArray(new String[paramPermissionCallback.size()]), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.permission.PermissionManager
 * JD-Core Version:    0.7.0.1
 */