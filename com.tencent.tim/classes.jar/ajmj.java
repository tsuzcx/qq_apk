import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.mobileqq.music.SongInfo;

public abstract interface ajmj
  extends IInterface
{
  public abstract int Gt()
    throws RemoteException;
  
  public abstract String I(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract SongInfo a()
    throws RemoteException;
  
  public abstract void a(ajmi paramajmi)
    throws RemoteException;
  
  public abstract void a(String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
    throws RemoteException;
  
  public abstract SongInfo[] a()
    throws RemoteException;
  
  public abstract void ag(Intent paramIntent)
    throws RemoteException;
  
  public abstract void b(ajmi paramajmi)
    throws RemoteException;
  
  public abstract SongInfo c()
    throws RemoteException;
  
  public abstract void dyn()
    throws RemoteException;
  
  public abstract int getCurrentSongPosition()
    throws RemoteException;
  
  public abstract int getDuration()
    throws RemoteException;
  
  public abstract Bundle getExtras()
    throws RemoteException;
  
  public abstract int getPlayMode()
    throws RemoteException;
  
  public abstract int getPlayState()
    throws RemoteException;
  
  public abstract String getToken()
    throws RemoteException;
  
  public abstract Intent i()
    throws RemoteException;
  
  public abstract int iH()
    throws RemoteException;
  
  public abstract int iI()
    throws RemoteException;
  
  public abstract boolean isPlaying()
    throws RemoteException;
  
  public abstract boolean nt(String paramString)
    throws RemoteException;
  
  public abstract void pause()
    throws RemoteException;
  
  public abstract void resume()
    throws RemoteException;
  
  public abstract void seekTo(int paramInt)
    throws RemoteException;
  
  public abstract void setExtras(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void setPlayMode(int paramInt)
    throws RemoteException;
  
  public abstract void stop()
    throws RemoteException;
  
  public abstract void yO()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ajmj
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.music.IQQPlayerService");
    }
    
    public static ajmj a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.music.IQQPlayerService");
      if ((localIInterface != null) && ((localIInterface instanceof ajmj))) {
        return (ajmj)localIInterface;
      }
      return new ajmj.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.music.IQQPlayerService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        a(paramParcel1.readString(), (SongInfo[])paramParcel1.createTypedArray(SongInfo.CREATOR), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        pause();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        resume();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        stop();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        setPlayMode(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        yO();
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        dyn();
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        bool = isPlaying();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramInt1 = getPlayState();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramInt1 = getPlayMode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramInt1 = getDuration();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramInt1 = getCurrentSongPosition();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramParcel1 = c();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramInt1 = iH();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramInt1 = iI();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeTypedArray(paramParcel1, 1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          ag(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramParcel1 = i();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          setExtras(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramParcel1 = getExtras();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        bool = nt(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramParcel1 = I(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramParcel1 = getToken();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        a(ajmi.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        b(ajmi.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
        paramInt1 = Gt();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      seekTo(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements ajmj
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public int Gt()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(27, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String I(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.mRemote.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.readString();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public SongInfo a()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	ajmj$a$a:mRemote	Landroid/os/IBinder;
        //   18: bipush 13
        //   20: aload_2
        //   21: aload_3
        //   22: iconst_0
        //   23: invokeinterface 41 5 0
        //   28: pop
        //   29: aload_3
        //   30: invokevirtual 44	android/os/Parcel:readException	()V
        //   33: aload_3
        //   34: invokevirtual 47	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 71	com/tencent/mobileqq/music/SongInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_3
        //   44: invokeinterface 77 2 0
        //   49: checkcast 67	com/tencent/mobileqq/music/SongInfo
        //   52: astore_1
        //   53: aload_3
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 50	android/os/Parcel:recycle	()V
        //   61: aload_1
        //   62: areturn
        //   63: aconst_null
        //   64: astore_1
        //   65: goto -12 -> 53
        //   68: astore_1
        //   69: aload_3
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   52	13	1	localSongInfo	SongInfo
        //   68	10	1	localObject	Object
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      /* Error */
      public void a(ajmi paramajmi)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 84 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 87	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	ajmj$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 25
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 41 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 44	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramajmi	ajmi
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      public void a(String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          localParcel1.writeString(paramString);
          localParcel1.writeTypedArray(paramArrayOfSongInfo, 0);
          localParcel1.writeInt(paramInt);
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
      
      public SongInfo[] a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          SongInfo[] arrayOfSongInfo = (SongInfo[])localParcel2.createTypedArray(SongInfo.CREATOR);
          return arrayOfSongInfo;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void ag(Intent paramIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 107	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	ajmj$a$a:mRemote	Landroid/os/IBinder;
        //   33: bipush 18
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 41 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 44	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 50	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_3
        //   67: invokevirtual 50	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   0	76	1	paramIntent	Intent
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public void b(ajmi paramajmi)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 84 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 87	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	ajmj$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 26
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 41 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 44	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramajmi	ajmi
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public SongInfo c()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	ajmj$a$a:mRemote	Landroid/os/IBinder;
        //   18: bipush 14
        //   20: aload_2
        //   21: aload_3
        //   22: iconst_0
        //   23: invokeinterface 41 5 0
        //   28: pop
        //   29: aload_3
        //   30: invokevirtual 44	android/os/Parcel:readException	()V
        //   33: aload_3
        //   34: invokevirtual 47	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 71	com/tencent/mobileqq/music/SongInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_3
        //   44: invokeinterface 77 2 0
        //   49: checkcast 67	com/tencent/mobileqq/music/SongInfo
        //   52: astore_1
        //   53: aload_3
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 50	android/os/Parcel:recycle	()V
        //   61: aload_1
        //   62: areturn
        //   63: aconst_null
        //   64: astore_1
        //   65: goto -12 -> 53
        //   68: astore_1
        //   69: aload_3
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   52	13	1	localSongInfo	SongInfo
        //   68	10	1	localObject	Object
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      public void dyn()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getCurrentSongPosition()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getDuration()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public Bundle getExtras()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	ajmj$a$a:mRemote	Landroid/os/IBinder;
        //   18: bipush 21
        //   20: aload_2
        //   21: aload_3
        //   22: iconst_0
        //   23: invokeinterface 41 5 0
        //   28: pop
        //   29: aload_3
        //   30: invokevirtual 44	android/os/Parcel:readException	()V
        //   33: aload_3
        //   34: invokevirtual 47	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 117	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_3
        //   44: invokeinterface 77 2 0
        //   49: checkcast 116	android/os/Bundle
        //   52: astore_1
        //   53: aload_3
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 50	android/os/Parcel:recycle	()V
        //   61: aload_1
        //   62: areturn
        //   63: aconst_null
        //   64: astore_1
        //   65: goto -12 -> 53
        //   68: astore_1
        //   69: aload_3
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   52	13	1	localBundle	Bundle
        //   68	10	1	localObject	Object
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      public int getPlayMode()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getPlayState()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getToken()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(24, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public Intent i()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	ajmj$a$a:mRemote	Landroid/os/IBinder;
        //   18: bipush 19
        //   20: aload_2
        //   21: aload_3
        //   22: iconst_0
        //   23: invokeinterface 41 5 0
        //   28: pop
        //   29: aload_3
        //   30: invokevirtual 44	android/os/Parcel:readException	()V
        //   33: aload_3
        //   34: invokevirtual 47	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 123	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_3
        //   44: invokeinterface 77 2 0
        //   49: checkcast 103	android/content/Intent
        //   52: astore_1
        //   53: aload_3
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 50	android/os/Parcel:recycle	()V
        //   61: aload_1
        //   62: areturn
        //   63: aconst_null
        //   64: astore_1
        //   65: goto -12 -> 53
        //   68: astore_1
        //   69: aload_3
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 50	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   52	13	1	localIntent	Intent
        //   68	10	1	localObject	Object
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      public int iH()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int iI()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isPlaying()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean nt(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          localParcel1.writeString(paramString);
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void pause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void resume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
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
      
      public void seekTo(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(28, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void setExtras(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 135	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	ajmj$a$a:mRemote	Landroid/os/IBinder;
        //   33: bipush 20
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 41 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 44	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 50	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_3
        //   67: invokevirtual 50	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   0	76	1	paramBundle	Bundle
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      public void setPlayMode(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void stop()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void yO()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerService");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmj
 * JD-Core Version:    0.7.0.1
 */