package com.tencent.tbs.reader;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PDFOutlineData$1
  implements Parcelable.Creator<PDFOutlineData>
{
  public PDFOutlineData createFromParcel(Parcel paramParcel)
  {
    PDFOutlineData localPDFOutlineData = new PDFOutlineData();
    PDFOutlineData.access$002(localPDFOutlineData, paramParcel.readString());
    PDFOutlineData.access$102(localPDFOutlineData, paramParcel.readInt());
    PDFOutlineData.access$202(localPDFOutlineData, paramParcel.readInt());
    PDFOutlineData.access$302(localPDFOutlineData, paramParcel.readInt());
    return localPDFOutlineData;
  }
  
  public PDFOutlineData[] newArray(int paramInt)
  {
    return new PDFOutlineData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.PDFOutlineData.1
 * JD-Core Version:    0.7.0.1
 */