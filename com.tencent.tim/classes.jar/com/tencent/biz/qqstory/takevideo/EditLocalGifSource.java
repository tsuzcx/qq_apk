package com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import awdu;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;
import java.util.ArrayList;
import rbf;

public class EditLocalGifSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditLocalGifSource> CREATOR = new rbf();
  @NonNull
  public int checkedSimilarityOK;
  @NonNull
  public final LocalMediaInfo d;
  @NonNull
  public long delay;
  @NonNull
  public boolean hasAntishake;
  @NonNull
  public ArrayList<String> ns = new ArrayList();
  @NonNull
  public ArrayList<String> nt = new ArrayList();
  @NonNull
  public String sourcePath;
  
  public EditLocalGifSource(Parcel paramParcel)
  {
    this.sourcePath = paramParcel.readString();
    paramParcel.readStringList(this.ns);
    this.d = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
    this.delay = paramParcel.readLong();
  }
  
  public EditLocalGifSource(String paramString, ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo)
  {
    this.sourcePath = paramString;
    this.ns = paramArrayList;
    paramString = paramLocalMediaInfo;
    if (paramLocalMediaInfo == null) {
      paramString = new LocalMediaInfo();
    }
    this.d = paramString;
    this.delay = awdu.bpx;
  }
  
  public EditLocalGifSource(String paramString, ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, long paramLong)
  {
    this.sourcePath = paramString;
    this.ns = paramArrayList;
    paramString = paramLocalMediaInfo;
    if (paramLocalMediaInfo == null) {
      paramString = new LocalMediaInfo();
    }
    this.d = paramString;
    this.delay = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getHeight()
  {
    return this.d.mediaHeight;
  }
  
  @NonNull
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public int getWidth()
  {
    return this.d.mediaWidth;
  }
  
  public String mR()
  {
    if ((TextUtils.isEmpty(this.sourcePath)) && ((this.ns == null) || (this.ns.size() == 0))) {
      return "sourcePath is empty";
    }
    if (this.sourcePath != null)
    {
      if (!new File(this.sourcePath).exists()) {
        return "Can not find file by sourcePath = " + this.sourcePath;
      }
    }
    else if (!new File((String)this.ns.get(0)).exists()) {
      return "Can not find file by sourcePath = " + this.sourcePath;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.sourcePath);
    paramParcel.writeStringList(this.ns);
    paramParcel.writeParcelable(this.d, 1);
    paramParcel.writeLong(this.delay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditLocalGifSource
 * JD-Core Version:    0.7.0.1
 */