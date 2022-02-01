import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.os.ResultReceiver;

public abstract interface iua
  extends IInterface
{
  public abstract void D(String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract void T(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract void U(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract Bundle a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, Bundle paramBundle, ResultReceiver paramResultReceiver)
    throws RemoteException;
  
  public abstract void a(itz paramitz)
    throws RemoteException;
  
  public abstract void a(itz paramitz, String paramString)
    throws RemoteException;
  
  public abstract void a(iub paramiub)
    throws RemoteException;
  
  public abstract void a(long[] paramArrayOfLong, String paramString)
    throws RemoteException;
  
  public abstract long[] a(String paramString)
    throws RemoteException;
  
  public abstract int aj(String paramString)
    throws RemoteException;
  
  public abstract void amF()
    throws RemoteException;
  
  public abstract void aqJ()
    throws RemoteException;
  
  public abstract void aqK()
    throws RemoteException;
  
  public abstract int aw(String paramString)
    throws RemoteException;
  
  public abstract int ax(String paramString)
    throws RemoteException;
  
  public abstract boolean ay(long paramLong)
    throws RemoteException;
  
  public abstract void b(itw paramitw)
    throws RemoteException;
  
  public abstract void b(iub paramiub)
    throws RemoteException;
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract boolean b(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract long[] b(String paramString)
    throws RemoteException;
  
  public abstract boolean bF()
    throws RemoteException;
  
  public abstract void bL(long paramLong)
    throws RemoteException;
  
  public abstract void c(int paramInt1, long paramLong, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public abstract void c(itw paramitw)
    throws RemoteException;
  
  public abstract boolean cB(String paramString)
    throws RemoteException;
  
  public abstract boolean cf(int paramInt)
    throws RemoteException;
  
  public abstract boolean cz(String paramString)
    throws RemoteException;
  
  public abstract String[] d(String paramString)
    throws RemoteException;
  
  public abstract String dd(String paramString)
    throws RemoteException;
  
  public abstract String di(String paramString)
    throws RemoteException;
  
  public abstract String du(String paramString)
    throws RemoteException;
  
  public abstract String dv(String paramString)
    throws RemoteException;
  
  public abstract int e(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract void e(long paramLong1, String paramString, long paramLong2)
    throws RemoteException;
  
  public abstract boolean e(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract boolean f(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void g(long paramLong, String paramString, int paramInt)
    throws RemoteException;
  
  public abstract boolean g(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract String getDisplayName(int paramInt, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract String getSKey()
    throws RemoteException;
  
  public abstract void h(int paramInt, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void hW(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void i(String paramString1, String paramString2, String paramString3, int paramInt)
    throws RemoteException;
  
  public abstract void iX(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void iY(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void iZ(boolean paramBoolean)
    throws RemoteException;
  
  public abstract boolean isFriend(String paramString)
    throws RemoteException;
  
  public abstract void ix(String paramString)
    throws RemoteException;
  
  public abstract void iy(String paramString)
    throws RemoteException;
  
  public abstract void jC(String paramString)
    throws RemoteException;
  
  public abstract void jD(String paramString)
    throws RemoteException;
  
  public abstract void jE(String paramString)
    throws RemoteException;
  
  public abstract void ju(String paramString)
    throws RemoteException;
  
  public abstract boolean l(int paramInt, long paramLong)
    throws RemoteException;
  
  public abstract int lB()
    throws RemoteException;
  
  public abstract int lC()
    throws RemoteException;
  
  public abstract int lD()
    throws RemoteException;
  
  public abstract int lE()
    throws RemoteException;
  
  public abstract void lL(int paramInt)
    throws RemoteException;
  
  public abstract boolean m(String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public abstract int[] s()
    throws RemoteException;
  
  public abstract boolean sL()
    throws RemoteException;
  
  public abstract boolean sM()
    throws RemoteException;
  
  public abstract boolean sN()
    throws RemoteException;
  
  public abstract boolean sO()
    throws RemoteException;
  
  public abstract boolean sP()
    throws RemoteException;
  
  public abstract boolean sQ()
    throws RemoteException;
  
  public abstract boolean sy()
    throws RemoteException;
  
  public abstract void t(String paramString, long paramLong)
    throws RemoteException;
  
  public abstract long v(String paramString)
    throws RemoteException;
  
  public abstract boolean w(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract long y(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements iua
  {
    public a()
    {
      attachInterface(this, "com.tencent.av.service.IQQServiceForAV");
    }
    
    public static iua a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceForAV");
      if ((localIInterface != null) && ((localIInterface instanceof iua))) {
        return (iua)localIInterface;
      }
      return new iua.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      int i5 = 0;
      boolean bool1 = false;
      int i6 = 0;
      int i7 = 0;
      int i8 = 0;
      int i9 = 0;
      int i10 = 0;
      boolean bool2 = false;
      boolean bool3 = false;
      int i11 = 0;
      boolean bool4 = false;
      int i12 = 0;
      int i13 = 0;
      int i14 = 0;
      int i = 0;
      Object localObject1;
      label825:
      label831:
      long l;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.av.service.IQQServiceForAV");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = isFriend(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (bool1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = paramParcel1.readInt();
        localObject1 = paramParcel1.readString();
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          if (paramParcel1.readInt() == 0) {
            break label825;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          paramParcel1 = a(paramInt1, (String)localObject1, (String)localObject2, bool1, bool2);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label831;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
          bool1 = false;
          break;
        }
        paramParcel2.writeInt(0);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = getDisplayName(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = dd(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        T(paramParcel1.readInt(), paramParcel1.readString());
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        aqJ();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        a(itz.a.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        a(itz.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        h(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        U(paramParcel1.readInt(), paramParcel1.readString());
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = l(paramParcel1.readInt(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = e(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        l = v(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = f(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = sL();
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = a(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeLongArray(paramParcel1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bL(paramParcel1.readLong());
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = cz(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = aw(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = lB();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        l = y(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = b(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = ay(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = i1;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = e(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i2;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        localObject1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          bool1 = m((String)localObject1, bool1);
          paramParcel2.writeNoException();
          paramInt1 = i3;
          if (bool1) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 26: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        a(iub.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        b(iub.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        b(itw.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        c(itw.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = getSKey();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        lL(paramParcel1.readInt());
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        ju(paramParcel1.readString());
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = g(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i4;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 34: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        jC(paramParcel1.readString());
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        jD(paramParcel1.readString());
        return true;
      case 36: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        amF();
        return true;
      case 37: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        aqK();
        return true;
      case 38: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = ax(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 39: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        D(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        a(paramParcel1.createLongArray(), paramParcel1.readString());
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        g(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt());
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = w(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i5;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 43: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = b(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeLongArray(paramParcel1);
        return true;
      case 44: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = d(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeStringArray(paramParcel1);
        return true;
      case 45: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = du(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 46: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        iX(bool1);
        return true;
      case 47: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = sN();
        paramParcel2.writeNoException();
        paramInt1 = i6;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 48: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = dv(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 49: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = di(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 50: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = lC();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 51: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = lD();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 52: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramParcel1 = s();
        paramParcel2.writeNoException();
        paramParcel2.writeIntArray(paramParcel1);
        return true;
      case 53: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = sO();
        paramParcel2.writeNoException();
        paramInt1 = i7;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 54: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = sP();
        paramParcel2.writeNoException();
        paramInt1 = i8;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 55: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = sQ();
        paramParcel2.writeNoException();
        paramInt1 = i9;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 56: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = cf(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i10;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 57: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = lE();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 58: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        iY(bool1);
        return true;
      case 59: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        t(paramParcel1.readString(), paramParcel1.readLong());
        return true;
      case 60: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        iZ(bool1);
        return true;
      case 61: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = cB(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i11;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 62: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        ix(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 63: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        iy(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 64: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        c(paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 65: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        b(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 66: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        i(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 67: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        e(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 68: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = aj(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 69: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        byte[] arrayOfByte = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);
          }
          paramParcel1 = a(paramInt1, paramInt2, i, arrayOfByte, (Bundle)localObject1, (ResultReceiver)localObject2);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 70: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        jE(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 71: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = bool4;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        hW(bool1);
        paramParcel2.writeNoException();
        return true;
      case 72: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = bF();
        paramParcel2.writeNoException();
        paramInt1 = i12;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 73: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
        bool1 = sM();
        paramParcel2.writeNoException();
        paramInt1 = i13;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = sy();
      paramParcel2.writeNoException();
      paramInt1 = i14;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static class a
      implements iua
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void D(String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeString(paramString3);
          this.mRemote.transact(39, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void T(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString);
          this.mRemote.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void U(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString);
          this.mRemote.transact(10, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 6
        //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 7
        //   8: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 8
        //   13: aload 7
        //   15: ldc 31
        //   17: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 7
        //   22: iload_1
        //   23: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   26: aload 7
        //   28: aload_2
        //   29: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   32: aload 7
        //   34: aload_3
        //   35: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: iload 4
        //   40: ifeq +80 -> 120
        //   43: iconst_1
        //   44: istore_1
        //   45: aload 7
        //   47: iload_1
        //   48: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   51: iload 5
        //   53: ifeq +72 -> 125
        //   56: iload 6
        //   58: istore_1
        //   59: aload 7
        //   61: iload_1
        //   62: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   65: aload_0
        //   66: getfield 18	iua$a$a:mRemote	Landroid/os/IBinder;
        //   69: iconst_2
        //   70: aload 7
        //   72: aload 8
        //   74: iconst_0
        //   75: invokeinterface 44 5 0
        //   80: pop
        //   81: aload 8
        //   83: invokevirtual 59	android/os/Parcel:readException	()V
        //   86: aload 8
        //   88: invokevirtual 63	android/os/Parcel:readInt	()I
        //   91: ifeq +39 -> 130
        //   94: getstatic 69	android/graphics/Bitmap:CREATOR	Landroid/os/Parcelable$Creator;
        //   97: aload 8
        //   99: invokeinterface 75 2 0
        //   104: checkcast 65	android/graphics/Bitmap
        //   107: astore_2
        //   108: aload 8
        //   110: invokevirtual 47	android/os/Parcel:recycle	()V
        //   113: aload 7
        //   115: invokevirtual 47	android/os/Parcel:recycle	()V
        //   118: aload_2
        //   119: areturn
        //   120: iconst_0
        //   121: istore_1
        //   122: goto -77 -> 45
        //   125: iconst_0
        //   126: istore_1
        //   127: goto -68 -> 59
        //   130: aconst_null
        //   131: astore_2
        //   132: goto -24 -> 108
        //   135: astore_2
        //   136: aload 8
        //   138: invokevirtual 47	android/os/Parcel:recycle	()V
        //   141: aload 7
        //   143: invokevirtual 47	android/os/Parcel:recycle	()V
        //   146: aload_2
        //   147: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	148	0	this	a
        //   0	148	1	paramInt	int
        //   0	148	2	paramString1	String
        //   0	148	3	paramString2	String
        //   0	148	4	paramBoolean1	boolean
        //   0	148	5	paramBoolean2	boolean
        //   1	56	6	i	int
        //   6	136	7	localParcel1	Parcel
        //   11	126	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	38	135	finally
        //   45	51	135	finally
        //   59	108	135	finally
      }
      
      public Bundle a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, Bundle paramBundle, ResultReceiver paramResultReceiver)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            localParcel1.writeByteArray(paramArrayOfByte);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramResultReceiver != null)
              {
                localParcel1.writeInt(1);
                paramResultReceiver.writeToParcel(localParcel1, 0);
                this.mRemote.transact(69, localParcel1, localParcel2, 0);
                localParcel2.readException();
                if (localParcel2.readInt() == 0) {
                  break label171;
                }
                paramArrayOfByte = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramArrayOfByte;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label171:
          paramArrayOfByte = null;
        }
      }
      
      public void a(itz paramitz)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          if (paramitz != null) {
            localIBinder = paramitz.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(8, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(itz paramitz, String paramString)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          if (paramitz != null) {
            localIBinder = paramitz.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          localParcel.writeString(paramString);
          this.mRemote.transact(7, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(iub paramiub)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          if (paramiub != null) {
            localIBinder = paramiub.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(26, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(long[] paramArrayOfLong, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeLongArray(paramArrayOfLong);
          localParcel.writeString(paramString);
          this.mRemote.transact(40, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public long[] a(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createLongArray();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int aj(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(68, localParcel1, localParcel2, 0);
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
      
      public void amF()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(36, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void aqJ()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(6, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void aqK()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(37, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public int aw(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
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
      
      public int ax(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(38, localParcel1, localParcel2, 0);
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
      
      public boolean ay(long paramLong)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(23, localParcel1, localParcel2, 0);
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
      
      public void b(itw paramitw)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          if (paramitw != null) {
            localIBinder = paramitw.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(28, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void b(iub paramiub)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          if (paramiub != null) {
            localIBinder = paramiub.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(27, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void b(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(65, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean b(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          if (paramInt1 != 0) {
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
      
      public long[] b(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(43, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createLongArray();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean bF()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(72, localParcel1, localParcel2, 0);
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
      
      public void bL(long paramLong)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeLong(paramLong);
          this.mRemote.transact(17, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void c(int paramInt1, long paramLong, int paramInt2, int paramInt3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          this.mRemote.transact(64, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void c(itw paramitw)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          if (paramitw != null) {
            localIBinder = paramitw.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(29, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public boolean cB(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(61, localParcel1, localParcel2, 0);
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
      
      public boolean cf(int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(56, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
      
      public boolean cz(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
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
      
      public String[] d(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(44, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createStringArray();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String dd(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
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
      
      public String di(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(49, localParcel1, localParcel2, 0);
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
      
      public String du(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(45, localParcel1, localParcel2, 0);
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
      
      public String dv(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(48, localParcel1, localParcel2, 0);
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
      
      public int e(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
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
      
      public void e(long paramLong1, String paramString, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeLong(paramLong1);
          localParcel1.writeString(paramString);
          localParcel1.writeLong(paramLong2);
          this.mRemote.transact(67, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean e(String paramString, int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(24, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
      
      public boolean f(String paramString, int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
      
      public void g(long paramLong, String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeLong(paramLong);
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.mRemote.transact(41, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public boolean g(String paramString, int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(33, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
      
      public String getDisplayName(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString1 = localParcel2.readString();
          return paramString1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getSKey()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(30, localParcel1, localParcel2, 0);
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
      
      public void h(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          this.mRemote.transact(9, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void hW(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.mRemote.transact(71, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void i(String paramString1, String paramString2, String paramString3, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(66, localParcel1, localParcel2, 0);
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
      public void iX(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: aload_3
        //   7: ldc 31
        //   9: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: iload_1
        //   13: ifeq +28 -> 41
        //   16: aload_3
        //   17: iload_2
        //   18: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   21: aload_0
        //   22: getfield 18	iua$a$a:mRemote	Landroid/os/IBinder;
        //   25: bipush 46
        //   27: aload_3
        //   28: aconst_null
        //   29: iconst_1
        //   30: invokeinterface 44 5 0
        //   35: pop
        //   36: aload_3
        //   37: invokevirtual 47	android/os/Parcel:recycle	()V
        //   40: return
        //   41: iconst_0
        //   42: istore_2
        //   43: goto -27 -> 16
        //   46: astore 4
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:recycle	()V
        //   52: aload 4
        //   54: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	55	0	this	a
        //   0	55	1	paramBoolean	boolean
        //   1	42	2	i	int
        //   5	44	3	localParcel	Parcel
        //   46	7	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   6	12	46	finally
        //   16	36	46	finally
      }
      
      /* Error */
      public void iY(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: aload_3
        //   7: ldc 31
        //   9: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: iload_1
        //   13: ifeq +28 -> 41
        //   16: aload_3
        //   17: iload_2
        //   18: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   21: aload_0
        //   22: getfield 18	iua$a$a:mRemote	Landroid/os/IBinder;
        //   25: bipush 58
        //   27: aload_3
        //   28: aconst_null
        //   29: iconst_1
        //   30: invokeinterface 44 5 0
        //   35: pop
        //   36: aload_3
        //   37: invokevirtual 47	android/os/Parcel:recycle	()V
        //   40: return
        //   41: iconst_0
        //   42: istore_2
        //   43: goto -27 -> 16
        //   46: astore 4
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:recycle	()V
        //   52: aload 4
        //   54: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	55	0	this	a
        //   0	55	1	paramBoolean	boolean
        //   1	42	2	i	int
        //   5	44	3	localParcel	Parcel
        //   46	7	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   6	12	46	finally
        //   16	36	46	finally
      }
      
      /* Error */
      public void iZ(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: aload_3
        //   7: ldc 31
        //   9: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: iload_1
        //   13: ifeq +28 -> 41
        //   16: aload_3
        //   17: iload_2
        //   18: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   21: aload_0
        //   22: getfield 18	iua$a$a:mRemote	Landroid/os/IBinder;
        //   25: bipush 60
        //   27: aload_3
        //   28: aconst_null
        //   29: iconst_1
        //   30: invokeinterface 44 5 0
        //   35: pop
        //   36: aload_3
        //   37: invokevirtual 47	android/os/Parcel:recycle	()V
        //   40: return
        //   41: iconst_0
        //   42: istore_2
        //   43: goto -27 -> 16
        //   46: astore 4
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:recycle	()V
        //   52: aload 4
        //   54: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	55	0	this	a
        //   0	55	1	paramBoolean	boolean
        //   1	42	2	i	int
        //   5	44	3	localParcel	Parcel
        //   46	7	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   6	12	46	finally
        //   16	36	46	finally
      }
      
      /* Error */
      public boolean isFriend(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 5
        //   12: aload 4
        //   14: ldc 31
        //   16: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload 4
        //   21: aload_1
        //   22: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_0
        //   26: getfield 18	iua$a$a:mRemote	Landroid/os/IBinder;
        //   29: iconst_1
        //   30: aload 4
        //   32: aload 5
        //   34: iconst_0
        //   35: invokeinterface 44 5 0
        //   40: pop
        //   41: aload 5
        //   43: invokevirtual 59	android/os/Parcel:readException	()V
        //   46: aload 5
        //   48: invokevirtual 63	android/os/Parcel:readInt	()I
        //   51: istore_2
        //   52: iload_2
        //   53: ifeq +15 -> 68
        //   56: aload 5
        //   58: invokevirtual 47	android/os/Parcel:recycle	()V
        //   61: aload 4
        //   63: invokevirtual 47	android/os/Parcel:recycle	()V
        //   66: iload_3
        //   67: ireturn
        //   68: iconst_0
        //   69: istore_3
        //   70: goto -14 -> 56
        //   73: astore_1
        //   74: aload 5
        //   76: invokevirtual 47	android/os/Parcel:recycle	()V
        //   79: aload 4
        //   81: invokevirtual 47	android/os/Parcel:recycle	()V
        //   84: aload_1
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	a
        //   0	86	1	paramString	String
        //   51	2	2	i	int
        //   1	69	3	bool	boolean
        //   5	75	4	localParcel1	Parcel
        //   10	65	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   12	52	73	finally
      }
      
      public void ix(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(62, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void iy(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(63, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void jC(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeString(paramString);
          this.mRemote.transact(34, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void jD(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeString(paramString);
          this.mRemote.transact(35, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void jE(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(70, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void ju(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeString(paramString);
          this.mRemote.transact(32, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public boolean l(int paramInt, long paramLong)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeInt(paramInt);
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
      
      public int lB()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(20, localParcel1, localParcel2, 0);
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
      
      public int lC()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(50, localParcel1, localParcel2, 0);
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
      
      public int lD()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(51, localParcel1, localParcel2, 0);
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
      
      public int lE()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(57, localParcel1, localParcel2, 0);
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
      
      public void lL(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeInt(paramInt);
          this.mRemote.transact(31, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public boolean m(String paramString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 31
        //   17: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: aload_1
        //   23: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: iload_2
        //   27: ifeq +58 -> 85
        //   30: iconst_1
        //   31: istore_3
        //   32: aload 5
        //   34: iload_3
        //   35: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   38: aload_0
        //   39: getfield 18	iua$a$a:mRemote	Landroid/os/IBinder;
        //   42: bipush 25
        //   44: aload 5
        //   46: aload 6
        //   48: iconst_0
        //   49: invokeinterface 44 5 0
        //   54: pop
        //   55: aload 6
        //   57: invokevirtual 59	android/os/Parcel:readException	()V
        //   60: aload 6
        //   62: invokevirtual 63	android/os/Parcel:readInt	()I
        //   65: istore_3
        //   66: iload_3
        //   67: ifeq +23 -> 90
        //   70: iload 4
        //   72: istore_2
        //   73: aload 6
        //   75: invokevirtual 47	android/os/Parcel:recycle	()V
        //   78: aload 5
        //   80: invokevirtual 47	android/os/Parcel:recycle	()V
        //   83: iload_2
        //   84: ireturn
        //   85: iconst_0
        //   86: istore_3
        //   87: goto -55 -> 32
        //   90: iconst_0
        //   91: istore_2
        //   92: goto -19 -> 73
        //   95: astore_1
        //   96: aload 6
        //   98: invokevirtual 47	android/os/Parcel:recycle	()V
        //   101: aload 5
        //   103: invokevirtual 47	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	a
        //   0	108	1	paramString	String
        //   0	108	2	paramBoolean	boolean
        //   31	56	3	i	int
        //   1	70	4	bool	boolean
        //   6	96	5	localParcel1	Parcel
        //   11	86	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	95	finally
        //   32	66	95	finally
      }
      
      public int[] s()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(52, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int[] arrayOfInt = localParcel2.createIntArray();
          return arrayOfInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean sL()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
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
      
      public boolean sM()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(73, localParcel1, localParcel2, 0);
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
      
      public boolean sN()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(47, localParcel1, localParcel2, 0);
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
      
      public boolean sO()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(53, localParcel1, localParcel2, 0);
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
      
      public boolean sP()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(54, localParcel1, localParcel2, 0);
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
      
      public boolean sQ()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(55, localParcel1, localParcel2, 0);
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
      
      public boolean sy()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          this.mRemote.transact(74, localParcel1, localParcel2, 0);
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
      
      public void t(String paramString, long paramLong)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel.writeString(paramString);
          localParcel.writeLong(paramLong);
          this.mRemote.transact(59, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public long v(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean w(String paramString1, String paramString2)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(42, localParcel1, localParcel2, 0);
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
      
      public long y(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
          localParcel1.writeString(paramString);
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iua
 * JD-Core Version:    0.7.0.1
 */