package com.tencent.tim.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import auky;

public class TeamWorkFileImportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TeamWorkFileImportInfo> CREATOR = new auky();
  public String bxe;
  public boolean cKX;
  public boolean cKZ;
  public boolean cLa;
  public String cjE;
  public String cjF;
  public String cjG;
  public int dNP;
  public int dNQ;
  public int dNR;
  public int dNS;
  public int dNT;
  public String fileName;
  public String filePath;
  public long fileSize;
  public int filetype;
  public String folderId = "";
  public boolean isFromAIO;
  public boolean isUserClick;
  public long msgUniseq;
  public int nFileType;
  public long nSessionId;
  public int peerType;
  public String peerUin;
  public String redirectUrl;
  public int retCode;
  public String traceId;
  public String troopUin;
  public int urlType;
  
  public TeamWorkFileImportInfo() {}
  
  public TeamWorkFileImportInfo(Parcel paramParcel)
  {
    this.peerType = paramParcel.readInt();
    this.peerUin = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.filePath = paramParcel.readString();
    this.msgUniseq = paramParcel.readLong();
    this.cjE = paramParcel.readString();
    this.dNP = paramParcel.readInt();
    this.troopUin = paramParcel.readString();
    this.nFileType = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cKX = bool1;
      this.dNQ = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label266;
      }
      bool1 = true;
      label115:
      this.isFromAIO = bool1;
      this.dNS = paramParcel.readInt();
      this.fileSize = paramParcel.readLong();
      this.nSessionId = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label271;
      }
      bool1 = true;
      label153:
      this.cKZ = bool1;
      if (paramParcel.readByte() == 0) {
        break label276;
      }
    }
    label266:
    label271:
    label276:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cLa = bool1;
      this.folderId = paramParcel.readString();
      this.retCode = paramParcel.readInt();
      this.cjF = paramParcel.readString();
      this.redirectUrl = paramParcel.readString();
      this.bxe = paramParcel.readString();
      this.traceId = paramParcel.readString();
      this.dNR = paramParcel.readInt();
      this.urlType = paramParcel.readInt();
      this.cjG = paramParcel.readString();
      this.filetype = paramParcel.readInt();
      this.dNT = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label115;
      bool1 = false;
      break label153;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.peerType);
    paramParcel.writeString(this.peerUin);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.filePath);
    paramParcel.writeLong(this.msgUniseq);
    paramParcel.writeString(this.cjE);
    paramParcel.writeInt(this.dNP);
    paramParcel.writeString(this.troopUin);
    paramParcel.writeInt(this.nFileType);
    if (this.cKX)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.dNQ);
      if (!this.isFromAIO) {
        break label260;
      }
      paramInt = 1;
      label106:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.dNS);
      paramParcel.writeLong(this.fileSize);
      paramParcel.writeLong(this.nSessionId);
      if (!this.cKZ) {
        break label265;
      }
      paramInt = 1;
      label145:
      paramParcel.writeByte((byte)paramInt);
      if (!this.cLa) {
        break label270;
      }
    }
    label260:
    label265:
    label270:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.folderId);
      paramParcel.writeInt(this.retCode);
      paramParcel.writeString(this.cjF);
      paramParcel.writeString(this.redirectUrl);
      paramParcel.writeString(this.bxe);
      paramParcel.writeString(this.traceId);
      paramParcel.writeInt(this.dNR);
      paramParcel.writeInt(this.urlType);
      paramParcel.writeString(this.cjG);
      paramParcel.writeInt(this.filetype);
      paramParcel.writeInt(this.dNT);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label106;
      paramInt = 0;
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkFileImportInfo
 * JD-Core Version:    0.7.0.1
 */