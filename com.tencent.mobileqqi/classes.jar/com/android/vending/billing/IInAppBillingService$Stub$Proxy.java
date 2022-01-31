package com.android.vending.billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class IInAppBillingService$Stub$Proxy
  implements IInAppBillingService
{
  private IBinder mRemote;
  
  IInAppBillingService$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public int consumePurchase(int paramInt, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public Bundle getBuyIntent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 6
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 7
    //   10: aload 6
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 6
    //   19: iload_1
    //   20: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   23: aload 6
    //   25: aload_2
    //   26: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   29: aload 6
    //   31: aload_3
    //   32: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   35: aload 6
    //   37: aload 4
    //   39: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   42: aload 6
    //   44: aload 5
    //   46: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 15	com/android/vending/billing/IInAppBillingService$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   53: iconst_3
    //   54: aload 6
    //   56: aload 7
    //   58: iconst_0
    //   59: invokeinterface 45 5 0
    //   64: pop
    //   65: aload 7
    //   67: invokevirtual 48	android/os/Parcel:readException	()V
    //   70: aload 7
    //   72: invokevirtual 52	android/os/Parcel:readInt	()I
    //   75: ifeq +29 -> 104
    //   78: getstatic 63	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   81: aload 7
    //   83: invokeinterface 69 2 0
    //   88: checkcast 59	android/os/Bundle
    //   91: astore_2
    //   92: aload 7
    //   94: invokevirtual 55	android/os/Parcel:recycle	()V
    //   97: aload 6
    //   99: invokevirtual 55	android/os/Parcel:recycle	()V
    //   102: aload_2
    //   103: areturn
    //   104: aconst_null
    //   105: astore_2
    //   106: goto -14 -> 92
    //   109: astore_2
    //   110: aload 7
    //   112: invokevirtual 55	android/os/Parcel:recycle	()V
    //   115: aload 6
    //   117: invokevirtual 55	android/os/Parcel:recycle	()V
    //   120: aload_2
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	Proxy
    //   0	122	1	paramInt	int
    //   0	122	2	paramString1	String
    //   0	122	3	paramString2	String
    //   0	122	4	paramString3	String
    //   0	122	5	paramString4	String
    //   3	113	6	localParcel1	Parcel
    //   8	103	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	92	109	finally
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.android.vending.billing.IInAppBillingService";
  }
  
  /* Error */
  public Bundle getPurchases(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: iload_1
    //   20: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   23: aload 5
    //   25: aload_2
    //   26: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   29: aload 5
    //   31: aload_3
    //   32: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   35: aload 5
    //   37: aload 4
    //   39: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 15	com/android/vending/billing/IInAppBillingService$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   46: iconst_4
    //   47: aload 5
    //   49: aload 6
    //   51: iconst_0
    //   52: invokeinterface 45 5 0
    //   57: pop
    //   58: aload 6
    //   60: invokevirtual 48	android/os/Parcel:readException	()V
    //   63: aload 6
    //   65: invokevirtual 52	android/os/Parcel:readInt	()I
    //   68: ifeq +29 -> 97
    //   71: getstatic 63	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   74: aload 6
    //   76: invokeinterface 69 2 0
    //   81: checkcast 59	android/os/Bundle
    //   84: astore_2
    //   85: aload 6
    //   87: invokevirtual 55	android/os/Parcel:recycle	()V
    //   90: aload 5
    //   92: invokevirtual 55	android/os/Parcel:recycle	()V
    //   95: aload_2
    //   96: areturn
    //   97: aconst_null
    //   98: astore_2
    //   99: goto -14 -> 85
    //   102: astore_2
    //   103: aload 6
    //   105: invokevirtual 55	android/os/Parcel:recycle	()V
    //   108: aload 5
    //   110: invokevirtual 55	android/os/Parcel:recycle	()V
    //   113: aload_2
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	Proxy
    //   0	115	1	paramInt	int
    //   0	115	2	paramString1	String
    //   0	115	3	paramString2	String
    //   0	115	4	paramString3	String
    //   3	106	5	localParcel1	Parcel
    //   8	96	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	85	102	finally
  }
  
  public Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        localParcel1.writeInt(paramInt);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramString1;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public int isBillingSupported(int paramInt, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.android.vending.billing.IInAppBillingService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */