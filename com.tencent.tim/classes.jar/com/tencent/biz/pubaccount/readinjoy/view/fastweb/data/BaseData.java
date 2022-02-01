package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import nli;
import nmx;

public class BaseData
  implements Parcelable
{
  public static final Parcelable.Creator<BaseData> CREATOR = new nli();
  public ArticleInfo articleInfo;
  public boolean ato;
  public FastWebArticleInfo d;
  public final float kB;
  public float kC = -1000.0F;
  public int pos = -1;
  public final int type;
  public int viewHeight = -1;
  
  public BaseData(int paramInt)
  {
    this.type = paramInt;
    this.kB = a(this);
  }
  
  public BaseData(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.articleInfo = ((ArticleInfo)paramParcel.readParcelable(ArticleInfo.class.getClassLoader()));
    this.d = ((FastWebArticleInfo)paramParcel.readParcelable(FastWebArticleInfo.class.getClassLoader()));
    this.kB = paramParcel.readFloat();
    this.pos = paramParcel.readInt();
    this.viewHeight = paramParcel.readInt();
  }
  
  public static float a(BaseData paramBaseData)
  {
    switch (paramBaseData.type)
    {
    }
    do
    {
      return -1000.0F;
      return 1.0F;
      return 1.5F;
      return 2.0F;
      return 3.0F;
      return paramBaseData.kC;
      return nmx.a(paramBaseData, false);
      return nmx.a(paramBaseData, true);
      return 9.0F;
      return 10.0F;
      return 11.0F;
    } while (!(paramBaseData instanceof ProteusItemData));
    return paramBaseData.kC;
  }
  
  public boolean c(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while (a(this) - a(paramBaseData) < 0.0F) {
      return true;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeParcelable(this.articleInfo, 0);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeFloat(this.kB);
    paramParcel.writeInt(this.pos);
    paramParcel.writeInt(this.viewHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData
 * JD-Core Version:    0.7.0.1
 */