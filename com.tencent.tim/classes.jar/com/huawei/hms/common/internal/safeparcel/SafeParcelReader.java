package com.huawei.hms.common.internal.safeparcel;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader
{
  private static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    paramInt1 = readSize(paramParcel, paramInt1);
    if (paramInt1 != paramInt2)
    {
      String str = Integer.toHexString(paramInt1);
      throw new a(String.valueOf(str).length() + 46 + "Expected size " + paramInt2 + " got " + paramInt1 + " (0x" + str + ")", paramParcel);
    }
  }
  
  private static void a(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt3)
    {
      String str = Integer.toHexString(paramInt2);
      throw new a(String.valueOf(str).length() + 46 + "Expected size " + paramInt3 + " got " + paramInt2 + " (0x" + str + ")", paramParcel);
    }
  }
  
  public static BigDecimal createBigDecimal(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(paramInt + i);
    return new BigDecimal(new BigInteger(arrayOfByte), j);
  }
  
  public static BigDecimal[] createBigDecimalArray(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    int j = readSize(paramParcel, paramInt);
    int k = paramParcel.dataPosition();
    if (j == 0) {
      return new BigDecimal[0];
    }
    int m = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[m];
    paramInt = i;
    while (paramInt < m)
    {
      arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(paramParcel.createByteArray()), paramParcel.readInt());
      paramInt += 1;
    }
    paramParcel.setDataPosition(k + j);
    return arrayOfBigDecimal;
  }
  
  public static BigInteger createBigInteger(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return new BigInteger(arrayOfByte);
  }
  
  public static BigInteger[] createBigIntegerArray(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    int j = readSize(paramParcel, paramInt);
    int k = paramParcel.dataPosition();
    if (j == 0) {
      return new BigInteger[0];
    }
    int m = paramParcel.readInt();
    BigInteger[] arrayOfBigInteger = new BigInteger[m];
    paramInt = i;
    while (paramInt < m)
    {
      arrayOfBigInteger[paramInt] = new BigInteger(paramParcel.createByteArray());
      paramInt += 1;
    }
    paramParcel.setDataPosition(k + j);
    return arrayOfBigInteger;
  }
  
  public static boolean[] createBooleanArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new boolean[0];
    }
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfBoolean;
  }
  
  public static ArrayList<Boolean> createBooleanList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    if (paramInt < k)
    {
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(Boolean.valueOf(bool));
        paramInt += 1;
        break;
      }
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static Bundle createBundle(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(paramInt + i);
    return localBundle;
  }
  
  public static byte[] createByteArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new byte[0];
    }
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfByte;
  }
  
  public static byte[][] createByteArrayArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return (byte[][])null;
    }
    int k = paramParcel.readInt();
    byte[][] arrayOfByte = new byte[k][];
    paramInt = 0;
    while (paramInt < k)
    {
      arrayOfByte[paramInt] = paramParcel.createByteArray();
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfByte;
  }
  
  public static SparseArray<byte[]> createByteArraySparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray(k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.createByteArray());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static char[] createCharArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new char[0];
    }
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfChar;
  }
  
  public static double[] createDoubleArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new double[0];
    }
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfDouble;
  }
  
  public static ArrayList<Double> createDoubleList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Double.valueOf(paramParcel.readDouble()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Double> createDoubleSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), Double.valueOf(paramParcel.readDouble()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static float[] createFloatArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new float[0];
    }
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfFloat;
  }
  
  public static ArrayList<Float> createFloatList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Float.valueOf(paramParcel.readFloat()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Float> createFloatSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), Float.valueOf(paramParcel.readFloat()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static IBinder[] createIBinderArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new IBinder[0];
    }
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfIBinder;
  }
  
  public static ArrayList<IBinder> createIBinderList(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ArrayList localArrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return localArrayList;
  }
  
  public static SparseArray<IBinder> createIBinderSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray(k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.readStrongBinder());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static int[] createIntArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new int[0];
    }
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfInt;
  }
  
  public static ArrayList<Integer> createIntegerList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Integer.valueOf(paramParcel.readInt()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static long[] createLongArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new long[0];
    }
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfLong;
  }
  
  public static ArrayList<Long> createLongList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Long.valueOf(paramParcel.readLong()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static Parcel createParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, i, paramInt);
    paramParcel.setDataPosition(paramInt + i);
    return localParcel;
  }
  
  public static Parcel[] createParcelArray(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    int j = readSize(paramParcel, paramInt);
    int k = paramParcel.dataPosition();
    if (j == 0) {
      return new Parcel[0];
    }
    int m = paramParcel.readInt();
    Parcel[] arrayOfParcel = new Parcel[m];
    paramInt = i;
    if (paramInt < m)
    {
      i = paramParcel.readInt();
      if (i == 0) {
        arrayOfParcel[paramInt] = null;
      }
      for (;;)
      {
        paramInt += 1;
        break;
        int n = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, i);
        arrayOfParcel[paramInt] = localParcel;
        paramParcel.setDataPosition(i + n);
      }
    }
    paramParcel.setDataPosition(k + j);
    return arrayOfParcel;
  }
  
  public static ArrayList<Parcel> createParcelList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    if (paramInt < k)
    {
      int m = paramParcel.readInt();
      if (m == 0) {
        localArrayList.add(null);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        int n = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, m);
        localArrayList.add(localParcel);
        paramParcel.setDataPosition(m + n);
      }
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Parcel> createParcelSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray();
    paramInt = 0;
    if (paramInt < k)
    {
      int m = paramParcel.readInt();
      int n = paramParcel.readInt();
      if (n == 0) {
        localSparseArray.append(m, null);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        int i1 = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, i1, n);
        localSparseArray.append(m, localParcel);
        paramParcel.setDataPosition(i1 + n);
      }
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static <P extends Parcelable> P createParcelable(Parcel paramParcel, int paramInt, Parcelable.Creator<P> paramCreator)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static SparseBooleanArray createSparseBooleanArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    SparseBooleanArray localSparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    return localSparseBooleanArray;
  }
  
  public static SparseIntArray createSparseIntArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseIntArray.append(paramParcel.readInt(), paramParcel.readInt());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseIntArray;
  }
  
  public static SparseLongArray createSparseLongArray(Parcel paramParcel, int paramInt)
  {
    SparseLongArray localSparseLongArray = null;
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 18) {
      localSparseLongArray = new SparseLongArray();
    }
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        localSparseLongArray.append(paramParcel.readInt(), paramParcel.readLong());
      }
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseLongArray;
  }
  
  public static String createString(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    String str = paramParcel.readString();
    paramParcel.setDataPosition(paramInt + i);
    return str;
  }
  
  public static String[] createStringArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new String[0];
    }
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfString;
  }
  
  public static ArrayList<String> createStringList(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return localArrayList;
  }
  
  public static SparseArray<String> createStringSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.readString());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static <C> C[] createTypedArray(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return paramCreator.newArray(0);
    }
    paramCreator = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static <C> ArrayList<C> createTypedList(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    paramCreator = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static <C> SparseArray<C> createTypedSparseArray(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    int k = paramParcel.readInt();
    SparseArray localSparseArray = new SparseArray();
    paramInt = 0;
    if (paramInt < k)
    {
      int m = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (Object localObject = paramCreator.createFromParcel(paramParcel);; localObject = null)
      {
        localSparseArray.append(m, localObject);
        paramInt += 1;
        break;
      }
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static void ensureAtEnd(Parcel paramParcel, int paramInt)
  {
    if (paramParcel.dataPosition() != paramInt) {
      throw new a("Overread allowed size end=" + paramInt, paramParcel);
    }
  }
  
  public static int getFieldId(int paramInt)
  {
    return 0xFFFF & paramInt;
  }
  
  public static boolean readBoolean(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }
  
  public static Boolean readBooleanObject(Parcel paramParcel, int paramInt)
  {
    boolean bool = false;
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return Boolean.valueOf(false);
    }
    a(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public static byte readByte(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static char readChar(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return (char)paramParcel.readInt();
  }
  
  public static double readDouble(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static Double readDoubleObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    a(paramParcel, paramInt, i, 8);
    return Double.valueOf(paramParcel.readDouble());
  }
  
  public static float readFloat(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static Float readFloatObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    a(paramParcel, paramInt, i, 4);
    return Float.valueOf(paramParcel.readFloat());
  }
  
  public static int readHeader(Parcel paramParcel)
  {
    return paramParcel.readInt();
  }
  
  public static IBinder readIBinder(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(paramInt + i);
    return localIBinder;
  }
  
  public static int readInt(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static Integer readIntegerObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    a(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }
  
  public static void readList(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt != 0)
    {
      paramParcel.readList(paramList, paramClassLoader);
      paramParcel.setDataPosition(paramInt + i);
    }
  }
  
  public static long readLong(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static Long readLongObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    a(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }
  
  public static short readShort(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static int readSize(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536) {
      return paramInt >> 16 & 0xFFFF;
    }
    return paramParcel.readInt();
  }
  
  public static void skipUnknownField(Parcel paramParcel, int paramInt)
  {
    paramParcel.setDataPosition(readSize(paramParcel, paramInt) + paramParcel.dataPosition());
  }
  
  public static int validateObjectHeader(Parcel paramParcel)
  {
    int j = readHeader(paramParcel);
    int k = readSize(paramParcel, j);
    int i = paramParcel.dataPosition();
    if (getFieldId(j) != 20293)
    {
      String str1 = "Expected object header. Got 0x";
      String str2 = String.valueOf(Integer.toHexString(j));
      if (str2.length() != 0) {
        str1 = "Expected object header. Got 0x".concat(str2);
      }
      throw new a(str1, paramParcel);
    }
    j = k + i;
    if ((j >= i) && (j <= paramParcel.dataSize())) {
      return j;
    }
    throw new a("invalid start=" + i + " end=" + j, paramParcel);
  }
  
  public static class a
    extends RuntimeException
  {
    public a(String paramString, Parcel paramParcel)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.safeparcel.SafeParcelReader
 * JD-Core Version:    0.7.0.1
 */