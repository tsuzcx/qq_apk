package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

public class DexClassLoaderProviderService
  extends Service
{
  private static final String LOGTAG = "dexloader";
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Log.d("dexloader", "DexClassLoaderProviderService -- onCreate()");
    DexClassLoaderProvider.setForceLoadDexFlag(true, this);
  }
  
  public void onDestroy()
  {
    Log.d("dexloader", "DexClassLoaderProviderService -- onDestroy()");
    System.exit(0);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Log.d("dexloader", "DexClassLoaderProviderService -- onStartCommand(" + paramIntent + ")");
    if (paramIntent == null) {}
    for (;;)
    {
      return 1;
      try
      {
        Object localObject1 = paramIntent.getStringArrayListExtra("dex2oat");
        if (localObject1 != null)
        {
          Object localObject2 = (String)((ArrayList)localObject1).get(0);
          paramIntent = (String)((ArrayList)localObject1).get(1);
          String str = (String)((ArrayList)localObject1).get(2);
          localObject1 = (String)((ArrayList)localObject1).get(3);
          Log.d("dexloader", "DexClassLoaderProviderService -- onStartCommand(" + (String)localObject2 + ")");
          localObject2 = getClassLoader();
          File localFile = new File(str);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          DexClassLoaderProvider.createDexClassLoader(paramIntent, str, (String)localObject1, (ClassLoader)localObject2, getApplicationContext());
          return 1;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProviderService
 * JD-Core Version:    0.7.0.1
 */