package com.tencent.biz.subscribe.other.story;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sfl;
import sfn;

public class VSUploadVideoBean
  implements Parcelable
{
  public static final Parcelable.Creator<VSUploadVideoBean> CREATOR = new sfn();
  public String fakeId;
  public String localVideoPath;
  public int retryTimes;
  public String thumbPath;
  public String uid;
  public int uploadStatus = 0;
  public String vid;
  
  public VSUploadVideoBean() {}
  
  public VSUploadVideoBean(Parcel paramParcel)
  {
    this.uploadStatus = paramParcel.readInt();
    this.fakeId = paramParcel.readString();
    this.vid = paramParcel.readString();
    this.uid = paramParcel.readString();
    this.localVideoPath = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.retryTimes = paramParcel.readInt();
  }
  
  public static VSUploadVideoBean a(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    VSUploadVideoBean localVSUploadVideoBean = new VSUploadVideoBean();
    if (paramVSUploadVideoEntry != null) {
      if (!sfl.a().fU(paramVSUploadVideoEntry.fakeId)) {
        break label91;
      }
    }
    label91:
    for (localVSUploadVideoBean.uploadStatus = 13;; localVSUploadVideoBean.uploadStatus = paramVSUploadVideoEntry.uploadStatus)
    {
      localVSUploadVideoBean.fakeId = paramVSUploadVideoEntry.fakeId;
      localVSUploadVideoBean.vid = paramVSUploadVideoEntry.vid;
      localVSUploadVideoBean.uid = paramVSUploadVideoEntry.uid;
      localVSUploadVideoBean.localVideoPath = paramVSUploadVideoEntry.localVideoPath;
      if (paramVSUploadVideoEntry.originalEntry != null) {
        localVSUploadVideoBean.thumbPath = paramVSUploadVideoEntry.originalEntry.thumbPath;
      }
      localVSUploadVideoBean.retryTimes = paramVSUploadVideoEntry.retryTimes;
      return localVSUploadVideoBean;
    }
  }
  
  public static ArrayList<VSUploadVideoBean> s(List<VSUploadVideoEntry> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VSUploadVideoEntry localVSUploadVideoEntry = (VSUploadVideoEntry)paramList.next();
        if (localVSUploadVideoEntry != null) {
          localArrayList.add(a(localVSUploadVideoEntry));
        }
      }
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.uploadStatus);
    paramParcel.writeString(this.fakeId);
    paramParcel.writeString(this.vid);
    paramParcel.writeString(this.uid);
    paramParcel.writeString(this.localVideoPath);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeInt(this.retryTimes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoBean
 * JD-Core Version:    0.7.0.1
 */