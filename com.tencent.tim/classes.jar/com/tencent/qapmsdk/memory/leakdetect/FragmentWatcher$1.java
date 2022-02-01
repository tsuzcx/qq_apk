package com.tencent.qapmsdk.memory.leakdetect;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.activty.IForeBackInterface;
import com.tencent.qapmsdk.common.util.ClassUtil;

final class FragmentWatcher$1
  implements IForeBackInterface
{
  public void onBackground(@NonNull Activity paramActivity) {}
  
  public void onCreate(@NonNull Activity paramActivity)
  {
    new AndroidOFragmentWatcher().registerCallbacks(paramActivity);
    if ((ClassUtil.classAvailable("android.support.v4.app.FragmentActivity")) && (ClassUtil.classAvailable("android.support.v4.app.Fragment")) && (ClassUtil.objectIsInstanceClass(paramActivity, "android.support.v4.app.FragmentActivity"))) {
      new AndroidOV4FragmentWatcher().registerCallbacks(paramActivity);
    }
  }
  
  public void onDestroy(@NonNull Activity paramActivity) {}
  
  public void onForeground(@NonNull Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.FragmentWatcher.1
 * JD-Core Version:    0.7.0.1
 */