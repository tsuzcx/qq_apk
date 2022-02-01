package com.tencent.mobileqq.ar;

import adce;
import adcf;
import adhh;
import adhk;
import adhl;
import adhr;
import adht;
import adhy;
import adin;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ARRecognition
  implements Parcelable
{
  public static final Parcelable.Creator<ARRecognition> CREATOR = new adce();
  public long RZ;
  public int cCe;
  public int cCf;
  public int cCg;
  public int priority;
  public long type;
  
  public ARRecognition() {}
  
  public ARRecognition(Parcel paramParcel)
  {
    this.type = paramParcel.readLong();
    this.cCe = paramParcel.readInt();
    this.cCf = paramParcel.readInt();
    this.priority = paramParcel.readInt();
    this.RZ = paramParcel.readLong();
    this.cCg = paramParcel.readInt();
  }
  
  public static b a(ArrayList<ARRecognition> paramArrayList, adhr paramadhr)
  {
    b localb = new b(0L, false);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return localb;
    }
    boolean bool1 = adhh.a(paramadhr.jdField_a_of_type_Adhh);
    boolean bool2 = adhk.a(paramadhr.jdField_a_of_type_Adhk);
    boolean bool3 = adht.a(paramadhr.jdField_a_of_type_Adht);
    boolean bool4 = adin.a(paramadhr.jdField_a_of_type_Adin);
    boolean bool5 = adhy.a(paramadhr.jdField_a_of_type_Adhy);
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
      return localb;
    }
    paramadhr = new ArrayList();
    if (bool1) {
      paramadhr.add(new a(1L, b(paramArrayList, 1L)));
    }
    if (bool3) {
      paramadhr.add(new a(4L, b(paramArrayList, 4L)));
    }
    if (bool2) {
      paramadhr.add(new a(2L, b(paramArrayList, 2L)));
    }
    if (bool4) {
      paramadhr.add(new a(128L, b(paramArrayList, 128L)));
    }
    if (bool5) {
      paramadhr.add(new a(2048L, b(paramArrayList, 2048L)));
    }
    paramArrayList = new StringBuilder();
    int i = 0;
    while (i < paramadhr.size())
    {
      paramArrayList.append("(index:").append(i).append(",prority=" + ((a)paramadhr.get(i)).Sa + ")\n");
      i += 1;
    }
    QLog.i("AREngine_CommonConfigInfo", 1, "getCurrentPriorityHighestResult print result " + paramArrayList.toString());
    Collections.sort(paramadhr, new adcf());
    localb.Sb = ((a)paramadhr.get(0)).Sa;
    if (paramadhr.size() == 1) {}
    for (bool1 = true;; bool1 = false)
    {
      localb.bLk = bool1;
      return localb;
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      if (paramInt1 >= paramInt2) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                return false;
                if ((paramLong1 != 1L) && (paramLong2 != 1L)) {
                  break;
                }
              } while (paramLong1 == 1L);
              return false;
              if ((paramLong1 != 2L) && (paramLong2 != 2L)) {
                break;
              }
            } while (paramLong1 == 2L);
            return false;
            if ((paramLong1 != 128L) && (paramLong2 != 128L)) {
              break;
            }
          } while (paramLong1 == 128L);
          return false;
          if ((paramLong1 != 4L) && (paramLong2 != 4L)) {
            break;
          }
        } while (paramLong1 == 4L);
        return false;
        if ((paramLong1 != 64L) && (paramLong2 != 64L)) {
          break;
        }
      } while (paramLong1 == 64L);
      return false;
    } while (((paramLong1 != 2048L) && (paramLong2 != 2048L)) || (paramLong1 == 2048L));
    return false;
  }
  
  public static boolean a(adhr paramadhr, long paramLong)
  {
    if (paramadhr == null) {}
    do
    {
      return false;
      if (paramLong == 1L) {
        return adhh.a(paramadhr.jdField_a_of_type_Adhh);
      }
      if (paramLong == 2L) {
        return adhk.a(paramadhr.jdField_a_of_type_Adhk);
      }
      if (paramLong == 128L) {
        return adin.a(paramadhr.jdField_a_of_type_Adin);
      }
      if (paramLong == 4L) {
        return adht.a(paramadhr.jdField_a_of_type_Adht);
      }
      if (paramLong == 64L) {
        return adhl.a(paramadhr.jdField_a_of_type_Adhl);
      }
    } while (paramLong != 2048L);
    return adhy.a(paramadhr.jdField_a_of_type_Adhy);
  }
  
  public static boolean a(adhr paramadhr, ArrayList<ARRecognition> paramArrayList, long paramLong)
  {
    if ((paramadhr == null) || (paramArrayList == null) || (!a(paramadhr, paramLong))) {
      return false;
    }
    int j = b(paramArrayList, paramLong);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label107;
      }
      long l = 1 << (int)((ARRecognition)paramArrayList.get(i)).type;
      int k = ((ARRecognition)paramArrayList.get(i)).priority;
      if ((paramLong != l) && (a(paramadhr, l)) && (!a(paramLong, l, j, k))) {
        break;
      }
      i += 1;
    }
    label107:
    return true;
  }
  
  public static int b(ArrayList<ARRecognition> paramArrayList, long paramLong)
  {
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (paramLong == 1 << (int)((ARRecognition)paramArrayList.get(i)).type) {
          return ((ARRecognition)paramArrayList.get(i)).priority;
        }
        i += 1;
      }
    }
    return 5;
  }
  
  public static boolean b(ArrayList<ARRecognition> paramArrayList, long paramLong)
  {
    int j = b(paramArrayList, paramLong);
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (!a(paramLong, 1 << (int)((ARRecognition)paramArrayList.get(i)).type, j, ((ARRecognition)paramArrayList.get(i)).priority)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static boolean b(ArrayList<ARRecognition> paramArrayList, long paramLong1, long paramLong2)
  {
    int j;
    int i;
    if (paramArrayList != null)
    {
      j = 5;
      i = 5;
      int k = 0;
      if (k < paramArrayList.size())
      {
        long l = 1 << (int)((ARRecognition)paramArrayList.get(k)).type;
        int m;
        if (paramLong1 == l) {
          m = ((ARRecognition)paramArrayList.get(k)).priority;
        }
        for (;;)
        {
          k += 1;
          i = m;
          break;
          m = i;
          if (paramLong2 == l)
          {
            j = ((ARRecognition)paramArrayList.get(k)).priority;
            m = i;
          }
        }
      }
    }
    for (;;)
    {
      return a(paramLong1, paramLong2, i, j);
      j = 5;
      i = 5;
    }
  }
  
  public static long c(ArrayList<ARRecognition> paramArrayList)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayList != null)
    {
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= paramArrayList.size()) {
          break;
        }
        l2 = l1;
        if (((ARRecognition)paramArrayList.get(i)).cCe != 0) {
          l2 = l1 | 1 << (int)((ARRecognition)paramArrayList.get(i)).type;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public static long d(ArrayList<ARRecognition> paramArrayList)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayList != null)
    {
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= paramArrayList.size()) {
          break;
        }
        l2 = l1;
        if (((ARRecognition)paramArrayList.get(i)).cCf != 0) {
          l2 = l1 | 1 << (int)((ARRecognition)paramArrayList.get(i)).type;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("Recognition{");
    localStringBuffer.append("type=").append(this.type);
    localStringBuffer.append("CloudRecogOpen =").append(this.cCe);
    localStringBuffer.append("LocalRecogOpen =").append(this.cCf);
    localStringBuffer.append(", priority='").append(this.priority).append('\'');
    localStringBuffer.append(", wait_ms='").append(this.RZ).append('\'');
    localStringBuffer.append("ImagePreprocess_open =").append(this.cCg);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.type);
    paramParcel.writeInt(this.cCe);
    paramParcel.writeInt(this.cCf);
    paramParcel.writeInt(this.priority);
    paramParcel.writeLong(this.RZ);
    paramParcel.writeInt(this.cCg);
  }
  
  public static class a
  {
    public long Sa;
    public int priority;
    
    public a(long paramLong, int paramInt)
    {
      this.priority = paramInt;
      this.Sa = paramLong;
    }
  }
  
  public static class b
  {
    public long Sb;
    public boolean bLk;
    
    public b(long paramLong, boolean paramBoolean)
    {
      this.Sb = paramLong;
      this.bLk = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecognition
 * JD-Core Version:    0.7.0.1
 */