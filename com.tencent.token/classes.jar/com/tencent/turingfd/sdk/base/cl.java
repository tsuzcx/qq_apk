package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cl
  extends cj
{
  public static final String b = db.a(db.a);
  
  public String a(IBinder paramIBinder)
  {
    localParcel2 = null;
    int i = 0;
    Object localObject1 = ed.b();
    String str1 = ((Context)localObject1).getPackageName();
    try
    {
      localObject3 = ((Context)localObject1).getPackageManager().getPackageInfo(str1, 64).signatures;
      localObject1 = localParcel2;
      if (localObject3 != null)
      {
        localObject1 = localParcel2;
        if (localObject3.length > 0) {
          localObject1 = localObject3[0].toByteArray();
        }
      }
      try
      {
        localObject3 = MessageDigest.getInstance("SHA1");
        if (localObject3 != null) {
          break label169;
        }
        localObject1 = localParcel2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;)
        {
          String str2;
          Object localObject2;
          int j;
          localNoSuchAlgorithmException.printStackTrace();
          Parcel localParcel1 = localParcel2;
        }
      }
      str2 = db.a(db.i);
      localObject3 = Parcel.obtain();
      localParcel2 = Parcel.obtain();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          ((Parcel)localObject3).writeInterfaceToken(b);
          ((Parcel)localObject3).writeString(str1);
          ((Parcel)localObject3).writeString((String)localObject1);
          ((Parcel)localObject3).writeString(str2);
          paramIBinder.transact(1, (Parcel)localObject3, localParcel2, 0);
          localParcel2.readException();
          paramIBinder = localParcel2.readString();
          return paramIBinder;
        }
        finally
        {
          Object localObject3;
          label169:
          localParcel2.recycle();
          ((Parcel)localObject3).recycle();
        }
        localThrowable = localThrowable;
        localObject3 = null;
        continue;
        localObject2 = ((MessageDigest)localObject3).digest(localThrowable);
        localObject3 = new StringBuilder();
        j = localObject2.length;
        if (i < j)
        {
          ((StringBuilder)localObject3).append(Integer.toHexString(localObject2[i] & 0xFF | 0x100).substring(1, 3));
          i += 1;
        }
        else
        {
          localObject2 = ((StringBuilder)localObject3).toString();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cl
 * JD-Core Version:    0.7.0.1
 */