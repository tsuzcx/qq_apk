package wf7;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;

class gy
  implements gn
{
  private IBinder sC;
  
  public gy(IBinder paramIBinder)
  {
    this.sC = paramIBinder;
  }
  
  public IBinder P(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.os.IServiceManager");
    localParcel1.writeString(paramString);
    this.sC.transact(1, localParcel1, localParcel2, 0);
    paramString = localParcel2.readStrongBinder();
    localParcel2.recycle();
    localParcel1.recycle();
    return paramString;
  }
  
  public IBinder Q(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.os.IServiceManager");
    localParcel1.writeString(paramString);
    this.sC.transact(2, localParcel1, localParcel2, 0);
    paramString = localParcel2.readStrongBinder();
    localParcel2.recycle();
    localParcel1.recycle();
    return paramString;
  }
  
  public void a(String paramString, IBinder paramIBinder, boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.os.IServiceManager");
    localParcel1.writeString(paramString);
    localParcel1.writeStrongBinder(paramIBinder);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localParcel1.writeInt(i);
      this.sC.transact(3, localParcel1, localParcel2, 0);
      localParcel2.recycle();
      localParcel1.recycle();
      return;
    }
  }
  
  public IBinder asBinder()
  {
    return this.sC;
  }
  
  public String[] eY()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Object localObject = Parcel.obtain();
      Parcel localParcel = Parcel.obtain();
      ((Parcel)localObject).writeInterfaceToken("android.os.IServiceManager");
      ((Parcel)localObject).writeInt(i);
      i += 1;
      try
      {
        boolean bool = this.sC.transact(4, (Parcel)localObject, localParcel, 0);
        if (bool) {
          break label76;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        label57:
        label76:
        break label57;
      }
      localObject = new String[localArrayList.size()];
      localArrayList.toArray((Object[])localObject);
      return localObject;
      localArrayList.add(localParcel.readString());
      localParcel.recycle();
      ((Parcel)localObject).recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.gy
 * JD-Core Version:    0.7.0.1
 */