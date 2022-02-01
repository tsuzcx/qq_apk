package com.tencent.shadow.dynamic.manager;

import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.shadow.dynamic.loader.PluginLoader;
import com.tencent.shadow.dynamic.loader.PluginServiceConnection;
import java.util.HashMap;
import java.util.Map;

class BinderPluginLoader
  implements PluginLoader
{
  private final IBinder mRemote;
  
  BinderPluginLoader(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public boolean bindPluginService(Intent paramIntent, PluginServiceConnection paramPluginServiceConnection, int paramInt)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken(DESCRIPTOR);
        if (paramIntent != null)
        {
          localParcel1.writeInt(1);
          paramIntent.writeToParcel(localParcel1, 0);
          if (paramPluginServiceConnection != null)
          {
            paramIntent = new PluginServiceConnectionBinder(paramPluginServiceConnection);
            localParcel1.writeStrongBinder(paramIntent);
            localParcel1.writeInt(paramInt);
            this.mRemote.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramInt = localParcel2.readInt();
            if (paramInt == 0) {
              break label135;
            }
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramIntent = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label135:
      bool = false;
    }
  }
  
  public void callApplicationOnCreate(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      localParcel1.writeString(paramString);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Intent convertActivityIntent(Intent paramIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken(DESCRIPTOR);
        if (paramIntent != null)
        {
          localParcel1.writeInt(1);
          paramIntent.writeToParcel(localParcel1, 0);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
            return paramIntent;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramIntent = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public Map getLoadedPlugin()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      HashMap localHashMap = localParcel2.readHashMap(getClass().getClassLoader());
      return localHashMap;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void loadPlugin(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      localParcel1.writeString(paramString);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public ComponentName startPluginService(Intent paramIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken(DESCRIPTOR);
        if (paramIntent != null)
        {
          localParcel1.writeInt(1);
          paramIntent.writeToParcel(localParcel1, 0);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramIntent = (ComponentName)ComponentName.CREATOR.createFromParcel(localParcel2);
            return paramIntent;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramIntent = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public boolean stopPluginService(Intent paramIntent)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken(DESCRIPTOR);
        if (paramIntent != null)
        {
          localParcel1.writeInt(1);
          paramIntent.writeToParcel(localParcel1, 0);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        bool = false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public void unbindService(PluginServiceConnection paramPluginServiceConnection)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: getstatic 28	com/tencent/shadow/dynamic/manager/BinderPluginLoader:DESCRIPTOR	Ljava/lang/String;
    //   12: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +45 -> 61
    //   19: new 44	com/tencent/shadow/dynamic/manager/PluginServiceConnectionBinder
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 47	com/tencent/shadow/dynamic/manager/PluginServiceConnectionBinder:<init>	(Lcom/tencent/shadow/dynamic/loader/PluginServiceConnection;)V
    //   27: astore_1
    //   28: aload_2
    //   29: aload_1
    //   30: invokevirtual 50	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   33: aload_0
    //   34: getfield 15	com/tencent/shadow/dynamic/manager/BinderPluginLoader:mRemote	Landroid/os/IBinder;
    //   37: bipush 8
    //   39: aload_2
    //   40: aload_3
    //   41: iconst_0
    //   42: invokeinterface 56 5 0
    //   47: pop
    //   48: aload_3
    //   49: invokevirtual 59	android/os/Parcel:readException	()V
    //   52: aload_3
    //   53: invokevirtual 66	android/os/Parcel:recycle	()V
    //   56: aload_2
    //   57: invokevirtual 66	android/os/Parcel:recycle	()V
    //   60: return
    //   61: aconst_null
    //   62: astore_1
    //   63: goto -35 -> 28
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 66	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 66	android/os/Parcel:recycle	()V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	BinderPluginLoader
    //   0	77	1	paramPluginServiceConnection	PluginServiceConnection
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	15	66	finally
    //   19	28	66	finally
    //   28	52	66	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.manager.BinderPluginLoader
 * JD-Core Version:    0.7.0.1
 */