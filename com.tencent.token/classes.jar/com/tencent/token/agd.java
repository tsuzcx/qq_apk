package com.tencent.token;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;

public final class agd
  extends aga
{
  public static final String b = afz.a(afz.i);
  
  public final String a(IBinder paramIBinder)
  {
    String str;
    Object localObject3;
    try
    {
      localObject1 = ahr.a;
      str = ((Context)localObject1).getPackageName();
      localParcel = null;
    }
    finally {}
    try
    {
      localObject5 = ((Context)localObject1).getPackageManager().getPackageInfo(str, 64).signatures;
      break label44;
    }
    finally {}
    Object localObject5 = null;
    label44:
    Object localObject1 = localParcel;
    if (localObject5 != null)
    {
      localObject1 = localParcel;
      if (localObject5.length > 0)
      {
        localObject5 = localObject5[0].toByteArray();
        try
        {
          localObject6 = MessageDigest.getInstance("SHA1");
          localObject1 = localParcel;
          if (localObject6 != null)
          {
            localObject1 = ((MessageDigest)localObject6).digest((byte[])localObject5);
            localObject5 = new StringBuilder();
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject5).append(Integer.toHexString(localObject1[i] & 0xFF | 0x100).substring(1, 3));
              i += 1;
            }
            localObject1 = ((StringBuilder)localObject5).toString();
          }
        }
        finally
        {
          localObject2.printStackTrace();
          localObject3 = localParcel;
        }
      }
    }
    Object localObject6 = afz.a(afz.j);
    localObject5 = Parcel.obtain();
    Parcel localParcel = Parcel.obtain();
    try
    {
      ((Parcel)localObject5).writeInterfaceToken(b);
      ((Parcel)localObject5).writeString(str);
      ((Parcel)localObject5).writeString(localObject3);
      ((Parcel)localObject5).writeString((String)localObject6);
      paramIBinder.transact(1, (Parcel)localObject5, localParcel, 0);
      localParcel.readException();
      paramIBinder = localParcel.readString();
      return paramIBinder;
    }
    finally
    {
      localParcel.recycle();
      ((Parcel)localObject5).recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agd
 * JD-Core Version:    0.7.0.1
 */