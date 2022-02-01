package com.tencent.tim.dingdong;

import acci;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import atnh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DingdongPluginBizObserver
  implements acci
{
  public void a(b paramb) {}
  
  public void a(c paramc) {}
  
  public void a(d paramd) {}
  
  public void a(e parame) {}
  
  public void a(g paramg) {}
  
  public void a(h paramh) {}
  
  public void a(i parami) {}
  
  public void a(j paramj) {}
  
  public void a(k paramk) {}
  
  public void a(l paraml) {}
  
  public void b(j paramj) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
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
                          return;
                        } while ((paramObject == null) || (!(paramObject instanceof l)));
                        a((l)paramObject);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof g)));
                      a((g)paramObject);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof c)));
                    a((c)paramObject);
                    return;
                  } while ((paramObject == null) || (!(paramObject instanceof b)));
                  a((b)paramObject);
                  return;
                } while (!(paramObject instanceof h));
                a((h)paramObject);
                return;
              } while (!(paramObject instanceof j));
              QLog.e("dingdongSchedule", 2, "Observer notify get");
              b((j)paramObject);
              return;
            } while ((paramObject == null) || (!(paramObject instanceof e)));
            a((e)paramObject);
            return;
          } while ((paramObject == null) || (!(paramObject instanceof d)));
          a((d)paramObject);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof k)));
        a((k)paramObject);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof i)));
      a((i)paramObject);
      return;
    } while ((!(paramObject instanceof j)) || (!paramBoolean));
    QLog.e("ScheduleAccept ", 2, "DingDongBizObserver notify get");
    a((j)paramObject);
  }
  
  public static class TempLiteMailIndexInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<TempLiteMailIndexInfo> CREATOR = new atnh();
    public long ayz;
    public String feedId;
    public int sourceType;
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.feedId);
      paramParcel.writeInt(this.sourceType);
      paramParcel.writeLong(this.ayz);
    }
  }
  
  public static class a
  {
    public int dT;
    public String sourceId;
    public int sourceType;
    public String uin;
  }
  
  public static class b
  {
    public String authorUin;
    public int eqv;
    public int errCode;
    public String feedId;
    public String fromUin;
    public String sourceId;
    public int sourceType;
  }
  
  public static class c
  {
    public ArrayList<DingdongPluginBizObserver.TempLiteMailIndexInfo> Ee;
    public int errCode;
    public String feedId;
    public String fromUin;
    public String sourceId;
    public int sourceType;
    public int updateType;
  }
  
  public static class d
  {
    public ArrayList<Long> Ch;
    public String IV;
    public long ayw;
    public long ayx;
    public int resultCode;
  }
  
  public static class e
  {
    public a[] a;
    public long appId;
    public long asr;
    public int dataNum;
    public int errCode;
    
    public static class a
    {
      public DingdongPluginBizObserver.e.b a;
      public String cHF;
      public String cHG;
      public String openId;
      public int resultCode;
      public String token;
    }
    
    public static class b
    {
      public int flag;
      public long hostUin;
      public long uin;
    }
  }
  
  public static class f
  {
    public int eqw;
    public int errCode;
    public String feedId;
    public String fromUin;
    public String msgBrief;
    public String sourceId;
    public int sourceType;
  }
  
  public static class g
  {
    public DingdongPluginBizObserver.f a;
    public DingdongPluginBizObserver.l a;
    public int errCode;
  }
  
  public static class h
  {
    public long authorUin;
    public int changeType;
    public int errCode;
    public String id;
  }
  
  public static class i
  {
    public ArrayList<DingdongPluginBizObserver.a> Ef;
    public long seq;
    public DingdongPluginDataFactory.ScheduleSummaryData summaryData;
  }
  
  public static class j
  {
    public boolean dim;
    public int errCode;
    public DingdongPluginDataFactory.ScheduleSummaryData summaryData;
  }
  
  public static class k
  {
    public ArrayList<Long> Ch;
    public String IV;
    public long ayw;
    public long ayy;
    public int resultCode;
  }
  
  public static class l
  {
    public int eqx;
    public int errCode;
    public int unreadNum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.dingdong.DingdongPluginBizObserver
 * JD-Core Version:    0.7.0.1
 */