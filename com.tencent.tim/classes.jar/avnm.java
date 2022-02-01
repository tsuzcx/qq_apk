import android.os.Bundle;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;

public class avnm
{
  private static avnm a;
  
  public static avnm a()
  {
    try
    {
      if (a == null) {
        a = new avnm();
      }
      avnm localavnm = a;
      return localavnm;
    }
    finally {}
  }
  
  public boolean handleEvent(String paramString, Bundle paramBundle)
  {
    if (!avmc.a().aKJ())
    {
      avoc.i("ReaderInterfacePlugin", "plugin is not Ready, launch it");
      avmc.a().elN();
    }
    ReaderInterfacePluginProxy localReaderInterfacePluginProxy;
    do
    {
      return false;
      localReaderInterfacePluginProxy = avmc.a().a();
    } while (localReaderInterfacePluginProxy == null);
    return localReaderInterfacePluginProxy.handleEvent(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnm
 * JD-Core Version:    0.7.0.1
 */