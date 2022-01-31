package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;

public class TroopCreatePermissionData
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private static final int r = 111;
  private static final int s = 101;
  private static final int t = 102;
  private static final int u = 110;
  public String a = "";
  public String b = "";
  public int d = -1;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  
  public int a(String paramString)
  {
    int i4 = 0;
    if ((TextUtils.isEmpty(this.a)) || (!this.a.equals(paramString))) {
      return -1;
    }
    int i1;
    int i2;
    if (this.j < this.f)
    {
      i1 = 1;
      if (this.k >= this.g) {
        break label110;
      }
      i2 = 1;
      label52:
      if (this.l >= this.h) {
        break label115;
      }
    }
    label110:
    label115:
    for (int i3 = 1;; i3 = 0)
    {
      if (this.m < this.i) {
        i4 = 1;
      }
      if ((i1 != 0) || (i2 != 0) || (i3 != 0) || (i4 != 0)) {
        break label121;
      }
      this.e = 1;
      return -1;
      i1 = 0;
      break;
      i2 = 0;
      break label52;
    }
    label121:
    if ((i1 != 0) && (this.n == 1)) {
      i1 = 111;
    }
    for (;;)
    {
      return i1;
      if ((i2 != 0) && (this.o == 1))
      {
        i1 = 101;
      }
      else if ((i3 != 0) && (this.p == 1))
      {
        i1 = 102;
      }
      else if ((i4 != 0) && (this.q == 1))
      {
        i1 = 110;
      }
      else
      {
        this.e = 2;
        i1 = -1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.a = TroopCreateUtils.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreatePermissionData
 * JD-Core Version:    0.7.0.1
 */