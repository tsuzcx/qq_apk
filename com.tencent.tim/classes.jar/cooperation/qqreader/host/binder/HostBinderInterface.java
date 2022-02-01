package cooperation.qqreader.host.binder;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginInterface;

public class HostBinderInterface
{
  private PluginInterface f;
  
  public HostBinderInterface(PluginInterface paramPluginInterface)
  {
    this.f = paramPluginInterface;
  }
  
  public String getNickName()
  {
    return this.f.getNickName();
  }
  
  public long getUin()
  {
    return this.f.getUin();
  }
  
  public Bundle transfer(String paramString, Bundle paramBundle)
  {
    return this.f.transfer(paramString, paramBundle);
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, TransferCallback paramTransferCallback)
  {
    this.f.transferAsync(paramString, paramBundle, new HostBinderInterface.1(this, paramTransferCallback));
  }
  
  public static abstract interface TransferCallback
  {
    public abstract void onCallback(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.binder.HostBinderInterface
 * JD-Core Version:    0.7.0.1
 */