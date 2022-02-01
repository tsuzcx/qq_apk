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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public IBinder asBinder()
  {
    return this.sC;
  }
  
  public String[] eY()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
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
        if (bool)
        {
          localArrayList.add(localParcel.readString());
          localParcel.recycle();
          ((Parcel)localObject).recycle();
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        label83:
        break label83;
      }
    }
    localObject = new String[localArrayList.size()];
    localArrayList.toArray((Object[])localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gy
 * JD-Core Version:    0.7.0.1
 */