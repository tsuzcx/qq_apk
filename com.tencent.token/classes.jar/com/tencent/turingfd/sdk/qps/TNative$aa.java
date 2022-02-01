package com.tencent.turingfd.sdk.qps;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.Map;

public class TNative$aa
{
  public static native SparseArray<Object> a(SparseArray<Object> paramSparseArray, Context paramContext, Map<String, String> paramMap, int paramInt);
  
  public static native SparseArray<Object> b(SparseArray<Object> paramSparseArray, byte[] paramArrayOfByte, Map<String, String> paramMap, int paramInt);
  
  public static native SparseArray<Object> c(SparseArray<Object> paramSparseArray, Context paramContext);
  
  public static native SparseArray<Object> d(SparseArray<Object> paramSparseArray, Context paramContext, int paramInt);
  
  public static native SparseArray<Object> e(SparseArray<Object> paramSparseArray, Context paramContext, Map<String, String> paramMap, int paramInt);
  
  public static native SparseArray<Object> f(SparseArray<Object> paramSparseArray, byte[] paramArrayOfByte, int paramInt);
  
  public static native SparseArray<Object> g(SparseArray<Object> paramSparseArray, Context paramContext, Map<String, String> paramMap, int paramInt);
  
  public static native SparseArray<Object> h(SparseArray<Object> paramSparseArray, Context paramContext, Map<String, String> paramMap, int paramInt);
  
  public static native SparseArray<Object> i(SparseArray<Object> paramSparseArray, Context paramContext, Map<String, String> paramMap);
  
  public static class bb
    implements ServiceConnection
  {
    public native void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.TNative.aa
 * JD-Core Version:    0.7.0.1
 */