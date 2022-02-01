package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData
  implements Parcelable, Comparator<SchemeData>
{
  public static final Parcelable.Creator<DrmInitData> CREATOR = new DrmInitData.1();
  private int hashCode;
  public final int schemeDataCount;
  private final SchemeData[] schemeDatas;
  @Nullable
  public final String schemeType;
  
  DrmInitData(Parcel paramParcel)
  {
    this.schemeType = paramParcel.readString();
    this.schemeDatas = ((SchemeData[])paramParcel.createTypedArray(SchemeData.CREATOR));
    this.schemeDataCount = this.schemeDatas.length;
  }
  
  public DrmInitData(String paramString, List<SchemeData> paramList)
  {
    this(paramString, false, (SchemeData[])paramList.toArray(new SchemeData[paramList.size()]));
  }
  
  private DrmInitData(@Nullable String paramString, boolean paramBoolean, SchemeData... paramVarArgs)
  {
    this.schemeType = paramString;
    if (paramBoolean) {}
    for (paramString = (SchemeData[])paramVarArgs.clone();; paramString = paramVarArgs)
    {
      Arrays.sort(paramString, this);
      this.schemeDatas = paramString;
      this.schemeDataCount = paramString.length;
      return;
    }
  }
  
  public DrmInitData(@Nullable String paramString, SchemeData... paramVarArgs)
  {
    this(paramString, true, paramVarArgs);
  }
  
  public DrmInitData(List<SchemeData> paramList)
  {
    this(null, false, (SchemeData[])paramList.toArray(new SchemeData[paramList.size()]));
  }
  
  public DrmInitData(SchemeData... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  private static boolean containsSchemeDataWithUuid(ArrayList<SchemeData> paramArrayList, int paramInt, UUID paramUUID)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (((SchemeData)paramArrayList.get(i)).uuid.equals(paramUUID)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @Nullable
  public static DrmInitData createSessionCreationData(@Nullable DrmInitData paramDrmInitData1, @Nullable DrmInitData paramDrmInitData2)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    int k;
    int i;
    if (paramDrmInitData1 != null)
    {
      localObject1 = paramDrmInitData1.schemeType;
      localObject2 = paramDrmInitData1.schemeDatas;
      k = localObject2.length;
      i = 0;
      for (;;)
      {
        paramDrmInitData1 = (DrmInitData)localObject1;
        if (i >= k) {
          break;
        }
        paramDrmInitData1 = localObject2[i];
        if (paramDrmInitData1.hasData()) {
          localArrayList.add(paramDrmInitData1);
        }
        i += 1;
      }
    }
    paramDrmInitData1 = null;
    Object localObject2 = paramDrmInitData1;
    if (paramDrmInitData2 != null)
    {
      localObject1 = paramDrmInitData1;
      if (paramDrmInitData1 == null) {
        localObject1 = paramDrmInitData2.schemeType;
      }
      k = localArrayList.size();
      paramDrmInitData1 = paramDrmInitData2.schemeDatas;
      int m = paramDrmInitData1.length;
      i = j;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= m) {
          break;
        }
        paramDrmInitData2 = paramDrmInitData1[i];
        if ((paramDrmInitData2.hasData()) && (!containsSchemeDataWithUuid(localArrayList, k, paramDrmInitData2.uuid))) {
          localArrayList.add(paramDrmInitData2);
        }
        i += 1;
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return new DrmInitData((String)localObject2, localArrayList);
  }
  
  public int compare(SchemeData paramSchemeData1, SchemeData paramSchemeData2)
  {
    if (C.UUID_NIL.equals(paramSchemeData1.uuid))
    {
      if (C.UUID_NIL.equals(paramSchemeData2.uuid)) {
        return 0;
      }
      return 1;
    }
    return paramSchemeData1.uuid.compareTo(paramSchemeData2.uuid);
  }
  
  public DrmInitData copyWithSchemeType(@Nullable String paramString)
  {
    if (Util.areEqual(this.schemeType, paramString)) {
      return this;
    }
    return new DrmInitData(paramString, false, this.schemeDatas);
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
      paramObject = (DrmInitData)paramObject;
    } while ((Util.areEqual(this.schemeType, paramObject.schemeType)) && (Arrays.equals(this.schemeDatas, paramObject.schemeDatas)));
    return false;
  }
  
  public SchemeData get(int paramInt)
  {
    return this.schemeDatas[paramInt];
  }
  
  @Deprecated
  public SchemeData get(UUID paramUUID)
  {
    SchemeData[] arrayOfSchemeData = this.schemeDatas;
    int j = arrayOfSchemeData.length;
    int i = 0;
    while (i < j)
    {
      SchemeData localSchemeData = arrayOfSchemeData[i];
      if (localSchemeData.matches(paramUUID)) {
        return localSchemeData;
      }
      i += 1;
    }
    return null;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      if (this.schemeType != null) {
        break label37;
      }
    }
    label37:
    for (int i = 0;; i = this.schemeType.hashCode())
    {
      this.hashCode = (i * 31 + Arrays.hashCode(this.schemeDatas));
      return this.hashCode;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.schemeType);
    paramParcel.writeTypedArray(this.schemeDatas, 0);
  }
  
  public static final class SchemeData
    implements Parcelable
  {
    public static final Parcelable.Creator<SchemeData> CREATOR = new DrmInitData.SchemeData.1();
    public final byte[] data;
    private int hashCode;
    public final String mimeType;
    public final boolean requiresSecureDecryption;
    private final UUID uuid;
    
    SchemeData(Parcel paramParcel)
    {
      this.uuid = new UUID(paramParcel.readLong(), paramParcel.readLong());
      this.mimeType = paramParcel.readString();
      this.data = paramParcel.createByteArray();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.requiresSecureDecryption = bool;
        return;
      }
    }
    
    public SchemeData(UUID paramUUID, String paramString, byte[] paramArrayOfByte)
    {
      this(paramUUID, paramString, paramArrayOfByte, false);
    }
    
    public SchemeData(UUID paramUUID, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.uuid = ((UUID)Assertions.checkNotNull(paramUUID));
      this.mimeType = ((String)Assertions.checkNotNull(paramString));
      this.data = paramArrayOfByte;
      this.requiresSecureDecryption = paramBoolean;
    }
    
    public boolean canReplace(SchemeData paramSchemeData)
    {
      return (hasData()) && (!paramSchemeData.hasData()) && (matches(paramSchemeData.uuid));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool1;
      if (!(paramObject instanceof SchemeData)) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == this);
        paramObject = (SchemeData)paramObject;
        if ((!this.mimeType.equals(paramObject.mimeType)) || (!Util.areEqual(this.uuid, paramObject.uuid))) {
          break;
        }
        bool1 = bool2;
      } while (Arrays.equals(this.data, paramObject.data));
      return false;
    }
    
    public boolean hasData()
    {
      return this.data != null;
    }
    
    public int hashCode()
    {
      if (this.hashCode == 0) {
        this.hashCode = ((this.uuid.hashCode() * 31 + this.mimeType.hashCode()) * 31 + Arrays.hashCode(this.data));
      }
      return this.hashCode;
    }
    
    public boolean matches(UUID paramUUID)
    {
      return (C.UUID_NIL.equals(this.uuid)) || (paramUUID.equals(this.uuid));
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.uuid.getMostSignificantBits());
      paramParcel.writeLong(this.uuid.getLeastSignificantBits());
      paramParcel.writeString(this.mimeType);
      paramParcel.writeByteArray(this.data);
      if (this.requiresSecureDecryption) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData
 * JD-Core Version:    0.7.0.1
 */