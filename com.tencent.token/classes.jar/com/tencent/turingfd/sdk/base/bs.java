package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bs
  extends bq
{
  public static final String b = ct.a(ct.i);
  
  public String a(IBinder paramIBinder)
  {
    Object localObject1 = cm.a();
    String str1 = ((Context)localObject1).getPackageName();
    Parcel localParcel = null;
    try
    {
      localObject3 = ((Context)localObject1).getPackageManager().getPackageInfo(str1, 64).signatures;
    }
    catch (Throwable localThrowable)
    {
      Object localObject3;
      label35:
      Object localObject2;
      String str2;
      break label35;
    }
    localObject3 = null;
    localObject1 = localParcel;
    if (localObject3 != null)
    {
      localObject1 = localParcel;
      if (localObject3.length > 0)
      {
        localObject1 = localObject3[0].toByteArray();
        try
        {
          localObject3 = MessageDigest.getInstance("SHA1");
          if (localObject3 == null)
          {
            localObject1 = localParcel;
          }
          else
          {
            localObject1 = ((MessageDigest)localObject3).digest((byte[])localObject1);
            localObject3 = new StringBuilder();
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject3).append(Integer.toHexString(localObject1[i] & 0xFF | 0x100).substring(1, 3));
              i += 1;
            }
            localObject1 = ((StringBuilder)localObject3).toString();
          }
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          localNoSuchAlgorithmException.printStackTrace();
          localObject2 = localParcel;
        }
      }
    }
    str2 = ct.a(ct.j);
    localObject3 = Parcel.obtain();
    localParcel = Parcel.obtain();
    try
    {
      ((Parcel)localObject3).writeInterfaceToken(b);
      ((Parcel)localObject3).writeString(str1);
      ((Parcel)localObject3).writeString(localObject2);
      ((Parcel)localObject3).writeString(str2);
      paramIBinder.transact(1, (Parcel)localObject3, localParcel, 0);
      localParcel.readException();
      paramIBinder = localParcel.readString();
      return paramIBinder;
    }
    finally
    {
      localParcel.recycle();
      ((Parcel)localObject3).recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bs
 * JD-Core Version:    0.7.0.1
 */