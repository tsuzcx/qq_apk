package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ChapterFrame> CREATOR = new ChapterFrame.1();
  public static final String ID = "CHAP";
  public final String chapterId;
  public final long endOffset;
  public final int endTimeMs;
  public final long startOffset;
  public final int startTimeMs;
  private final Id3Frame[] subFrames;
  
  ChapterFrame(Parcel paramParcel)
  {
    super("CHAP");
    this.chapterId = paramParcel.readString();
    this.startTimeMs = paramParcel.readInt();
    this.endTimeMs = paramParcel.readInt();
    this.startOffset = paramParcel.readLong();
    this.endOffset = paramParcel.readLong();
    int j = paramParcel.readInt();
    this.subFrames = new Id3Frame[j];
    int i = 0;
    while (i < j)
    {
      this.subFrames[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      i += 1;
    }
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.chapterId = paramString;
    this.startTimeMs = paramInt1;
    this.endTimeMs = paramInt2;
    this.startOffset = paramLong1;
    this.endOffset = paramLong2;
    this.subFrames = paramArrayOfId3Frame;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ChapterFrame)paramObject;
    } while ((this.startTimeMs == paramObject.startTimeMs) && (this.endTimeMs == paramObject.endTimeMs) && (this.startOffset == paramObject.startOffset) && (this.endOffset == paramObject.endOffset) && (Util.areEqual(this.chapterId, paramObject.chapterId)) && (Arrays.equals(this.subFrames, paramObject.subFrames)));
    return false;
  }
  
  public Id3Frame getSubFrame(int paramInt)
  {
    return this.subFrames[paramInt];
  }
  
  public int getSubFrameCount()
  {
    return this.subFrames.length;
  }
  
  public int hashCode()
  {
    int j = this.startTimeMs;
    int k = this.endTimeMs;
    int m = (int)this.startOffset;
    int n = (int)this.endOffset;
    if (this.chapterId != null) {}
    for (int i = this.chapterId.hashCode();; i = 0) {
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.chapterId);
    paramParcel.writeInt(this.startTimeMs);
    paramParcel.writeInt(this.endTimeMs);
    paramParcel.writeLong(this.startOffset);
    paramParcel.writeLong(this.endOffset);
    paramParcel.writeInt(this.subFrames.length);
    Id3Frame[] arrayOfId3Frame = this.subFrames;
    int i = arrayOfId3Frame.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfId3Frame[paramInt], 0);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterFrame
 * JD-Core Version:    0.7.0.1
 */