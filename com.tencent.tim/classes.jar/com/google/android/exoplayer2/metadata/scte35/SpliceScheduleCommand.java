package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new SpliceScheduleCommand.1();
  public final List<Event> events;
  
  private SpliceScheduleCommand(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Event.createFromParcel(paramParcel));
      i += 1;
    }
    this.events = Collections.unmodifiableList(localArrayList);
  }
  
  private SpliceScheduleCommand(List<Event> paramList)
  {
    this.events = Collections.unmodifiableList(paramList);
  }
  
  static SpliceScheduleCommand parseFromSection(ParsableByteArray paramParsableByteArray)
  {
    int j = paramParsableByteArray.readUnsignedByte();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Event.parseFromSection(paramParsableByteArray));
      i += 1;
    }
    return new SpliceScheduleCommand(localArrayList);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = this.events.size();
    paramParcel.writeInt(i);
    paramInt = 0;
    while (paramInt < i)
    {
      ((Event)this.events.get(paramInt)).writeToParcel(paramParcel);
      paramInt += 1;
    }
  }
  
  public static final class ComponentSplice
  {
    public final int componentTag;
    public final long utcSpliceTime;
    
    private ComponentSplice(int paramInt, long paramLong)
    {
      this.componentTag = paramInt;
      this.utcSpliceTime = paramLong;
    }
    
    private static ComponentSplice createFromParcel(Parcel paramParcel)
    {
      return new ComponentSplice(paramParcel.readInt(), paramParcel.readLong());
    }
    
    private void writeToParcel(Parcel paramParcel)
    {
      paramParcel.writeInt(this.componentTag);
      paramParcel.writeLong(this.utcSpliceTime);
    }
  }
  
  public static final class Event
  {
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<SpliceScheduleCommand.ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final int uniqueProgramId;
    public final long utcSpliceTime;
    
    private Event(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<SpliceScheduleCommand.ComponentSplice> paramList, long paramLong2, boolean paramBoolean4, long paramLong3, int paramInt1, int paramInt2, int paramInt3)
    {
      this.spliceEventId = paramLong1;
      this.spliceEventCancelIndicator = paramBoolean1;
      this.outOfNetworkIndicator = paramBoolean2;
      this.programSpliceFlag = paramBoolean3;
      this.componentSpliceList = Collections.unmodifiableList(paramList);
      this.utcSpliceTime = paramLong2;
      this.autoReturn = paramBoolean4;
      this.breakDurationUs = paramLong3;
      this.uniqueProgramId = paramInt1;
      this.availNum = paramInt2;
      this.availsExpected = paramInt3;
    }
    
    private Event(Parcel paramParcel)
    {
      this.spliceEventId = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.spliceEventCancelIndicator = bool1;
        if (paramParcel.readByte() != 1) {
          break label111;
        }
        bool1 = true;
        label43:
        this.outOfNetworkIndicator = bool1;
        if (paramParcel.readByte() != 1) {
          break label117;
        }
      }
      ArrayList localArrayList;
      label111:
      label117:
      for (boolean bool1 = true;; bool1 = false)
      {
        this.programSpliceFlag = bool1;
        int j = paramParcel.readInt();
        localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(SpliceScheduleCommand.ComponentSplice.createFromParcel(paramParcel));
          i += 1;
        }
        bool1 = false;
        break;
        bool1 = false;
        break label43;
      }
      this.componentSpliceList = Collections.unmodifiableList(localArrayList);
      this.utcSpliceTime = paramParcel.readLong();
      if (paramParcel.readByte() == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.autoReturn = bool1;
        this.breakDurationUs = paramParcel.readLong();
        this.uniqueProgramId = paramParcel.readInt();
        this.availNum = paramParcel.readInt();
        this.availsExpected = paramParcel.readInt();
        return;
      }
    }
    
    private static Event createFromParcel(Parcel paramParcel)
    {
      return new Event(paramParcel);
    }
    
    private static Event parseFromSection(ParsableByteArray paramParsableByteArray)
    {
      long l3 = paramParsableByteArray.readUnsignedInt();
      boolean bool4;
      boolean bool2;
      long l1;
      Object localObject;
      int i;
      int j;
      int k;
      boolean bool3;
      long l2;
      boolean bool1;
      if ((paramParsableByteArray.readUnsignedByte() & 0x80) != 0)
      {
        bool4 = true;
        bool2 = false;
        l1 = -9223372036854775807L;
        localObject = new ArrayList();
        i = 0;
        j = 0;
        k = 0;
        bool3 = false;
        l2 = -9223372036854775807L;
        if (bool4) {
          break label288;
        }
        i = paramParsableByteArray.readUnsignedByte();
        if ((i & 0x80) == 0) {
          break label168;
        }
        bool1 = true;
        label72:
        if ((i & 0x40) == 0) {
          break label174;
        }
        bool2 = true;
        label82:
        if ((i & 0x20) == 0) {
          break label180;
        }
        i = 1;
      }
      for (;;)
      {
        if (bool2)
        {
          l1 = paramParsableByteArray.readUnsignedInt();
          if (!bool2)
          {
            k = paramParsableByteArray.readUnsignedByte();
            ArrayList localArrayList = new ArrayList(k);
            j = 0;
            for (;;)
            {
              localObject = localArrayList;
              if (j >= k) {
                break;
              }
              localArrayList.add(new SpliceScheduleCommand.ComponentSplice(paramParsableByteArray.readUnsignedByte(), paramParsableByteArray.readUnsignedInt(), null));
              j += 1;
            }
            bool4 = false;
            break;
            label168:
            bool1 = false;
            break label72;
            label174:
            bool2 = false;
            break label82;
            label180:
            i = 0;
            continue;
          }
          if (i != 0)
          {
            l2 = paramParsableByteArray.readUnsignedByte();
            if ((0x80 & l2) != 0L)
            {
              bool3 = true;
              label210:
              l2 = ((l2 & 1L) << 32 | paramParsableByteArray.readUnsignedInt()) * 1000L / 90L;
            }
          }
          else
          {
            i = paramParsableByteArray.readUnsignedShort();
            j = paramParsableByteArray.readUnsignedByte();
            k = paramParsableByteArray.readUnsignedByte();
          }
        }
      }
      for (;;)
      {
        return new Event(l3, bool4, bool1, bool2, (List)localObject, l1, bool3, l2, i, j, k);
        bool3 = false;
        break label210;
        l1 = -9223372036854775807L;
        break;
        label288:
        l2 = -9223372036854775807L;
        bool1 = false;
        bool3 = false;
      }
    }
    
    private void writeToParcel(Parcel paramParcel)
    {
      int j = 1;
      paramParcel.writeLong(this.spliceEventId);
      if (this.spliceEventCancelIndicator)
      {
        i = 1;
        paramParcel.writeByte((byte)i);
        if (!this.outOfNetworkIndicator) {
          break label109;
        }
        i = 1;
        label34:
        paramParcel.writeByte((byte)i);
        if (!this.programSpliceFlag) {
          break label114;
        }
      }
      label109:
      label114:
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        int k = this.componentSpliceList.size();
        paramParcel.writeInt(k);
        i = 0;
        while (i < k)
        {
          ((SpliceScheduleCommand.ComponentSplice)this.componentSpliceList.get(i)).writeToParcel(paramParcel);
          i += 1;
        }
        i = 0;
        break;
        i = 0;
        break label34;
      }
      paramParcel.writeLong(this.utcSpliceTime);
      if (this.autoReturn) {}
      for (i = j;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeLong(this.breakDurationUs);
        paramParcel.writeInt(this.uniqueProgramId);
        paramParcel.writeInt(this.availNum);
        paramParcel.writeInt(this.availsExpected);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand
 * JD-Core Version:    0.7.0.1
 */