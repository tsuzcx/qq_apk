package cooperation.qqreader.host.binder;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper;

public class HostBinderInterfaceHelper
{
  public static void getPluginInterface(Context paramContext, OnHostBinderInterfaceLoadedCallback paramOnHostBinderInterfaceLoadedCallback)
  {
    PluginInterfaceHelper.getPluginInterface(paramContext, new HostBinderInterfaceHelper.1(paramOnHostBinderInterfaceLoadedCallback));
  }
  
  public static abstract interface OnHostBinderInterfaceLoadedCallback
  {
    public abstract void onHostBinderInterfaceLoaded(HostBinderInterface paramHostBinderInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.binder.HostBinderInterfaceHelper
 * JD-Core Version:    0.7.0.1
 */