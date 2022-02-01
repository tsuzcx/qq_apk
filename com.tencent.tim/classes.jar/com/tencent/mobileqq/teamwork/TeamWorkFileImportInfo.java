package com.tencent.mobileqq.teamwork;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aoat;

public class TeamWorkFileImportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TeamWorkFileImportInfo> CREATOR = new aoat();
  public String Uuid;
  public String WeiYunFileId;
  public String aTw;
  public long aoR;
  public boolean bSend;
  public String bxe;
  public boolean cKX;
  public boolean cKY;
  public boolean cKZ;
  public boolean cLa;
  public String cjE;
  public String cjF;
  public String cjG;
  public String cjH;
  public String cjI;
  public long createTime;
  public int dNP;
  public int dNQ;
  public int dNR;
  public int dNS;
  public int dNT;
  public int dNU;
  public int device;
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
  public int peerType = -1;
  public String peerUin;
  public String redirectUrl;
  public int retCode;
  public String srcUrl;
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
    this.nSessionId = paramParcel.readLong();
    this.cjE = paramParcel.readString();
    this.dNP = paramParcel.readInt();
    this.device = paramParcel.readInt();
    this.troopUin = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cKX = bool1;
      this.dNQ = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label363;
      }
      bool1 = true;
      label128:
      this.isFromAIO = bool1;
      if (paramParcel.readByte() == 0) {
        break label368;
      }
      bool1 = true;
      label142:
      this.cKY = bool1;
      if (paramParcel.readByte() == 0) {
        break label373;
      }
      bool1 = true;
      label156:
      this.cKZ = bool1;
      if (paramParcel.readByte() == 0) {
        break label378;
      }
      bool1 = true;
      label170:
      this.isUserClick = bool1;
      if (paramParcel.readByte() == 0) {
        break label383;
      }
    }
    label363:
    label368:
    label373:
    label378:
    label383:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cLa = bool1;
      this.nFileType = paramParcel.readInt();
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
      this.dNS = paramParcel.readInt();
      this.fileSize = paramParcel.readLong();
      this.aoR = paramParcel.readLong();
      this.cjH = paramParcel.readString();
      this.srcUrl = paramParcel.readString();
      this.createTime = paramParcel.readLong();
      this.dNU = paramParcel.readInt();
      this.cjI = paramParcel.readString();
      this.WeiYunFileId = paramParcel.readString();
      this.Uuid = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label128;
      bool1 = false;
      break label142;
      bool1 = false;
      break label156;
      bool1 = false;
      break label170;
    }
  }
  
  public boolean azr()
  {
    return this.dNQ == 8;
  }
  
  public boolean azs()
  {
    return this.dNQ == 11;
  }
  
  public boolean azt()
  {
    return this.dNQ == 13;
  }
  
  public boolean azu()
  {
    return this.dNQ == 7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "TeamWorkFileImportInfo{peerType=" + this.peerType + ", peerUin='" + this.peerUin + '\'' + ", fileName='" + this.fileName + '\'' + ", filePath='" + this.filePath + '\'' + ", msgUniseq=" + this.msgUniseq + ", nSessionId=" + this.nSessionId + ", troopFilePath='" + this.cjE + '\'' + ", troopFileBusId=" + this.dNP + ", device=" + this.device + ", troopUin='" + this.troopUin + '\'' + ", isNeedDownLoadUrl=" + this.cKX + ", entranceFrom=" + this.dNQ + ", isFromAIO=" + this.isFromAIO + ", isFromDataLine=" + this.cKY + ", isOpenTeamWork=" + this.cKZ + ", isUserClick=" + this.isUserClick + ", isMessageConvert=" + this.cLa + ", nFileType=" + this.nFileType + ", folderId='" + this.folderId + '\'' + ", retCode=" + this.retCode + ", errorString='" + this.cjF + '\'' + ", redirectUrl='" + this.redirectUrl + '\'' + ", strSendUin='" + this.bxe + '\'' + ", traceId='" + this.traceId + '\'' + ", importOption=" + this.dNR + ", urlType=" + this.urlType + ", fileid='" + this.cjG + '\'' + ", filetype=" + this.filetype + ", fileImportType=" + this.dNS + ", fileSize=" + this.fileSize + ", structUniseq=" + this.aoR + ", editedUrl='" + this.cjH + '\'' + ", srcUrl='" + this.srcUrl + '\'' + ", createTime='" + this.createTime + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.peerType);
    paramParcel.writeString(this.peerUin);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.filePath);
    paramParcel.writeLong(this.msgUniseq);
    paramParcel.writeLong(this.nSessionId);
    paramParcel.writeString(this.cjE);
    paramParcel.writeInt(this.dNP);
    paramParcel.writeInt(this.device);
    paramParcel.writeString(this.troopUin);
    if (this.cKX)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.dNQ);
      if (!this.isFromAIO) {
        break label354;
      }
      paramInt = 1;
      label114:
      paramParcel.writeByte((byte)paramInt);
      if (!this.cKY) {
        break label359;
      }
      paramInt = 1;
      label129:
      paramParcel.writeByte((byte)paramInt);
      if (!this.cKZ) {
        break label364;
      }
      paramInt = 1;
      label144:
      paramParcel.writeByte((byte)paramInt);
      if (!this.isUserClick) {
        break label369;
      }
      paramInt = 1;
      label159:
      paramParcel.writeByte((byte)paramInt);
      if (!this.cLa) {
        break label374;
      }
    }
    label354:
    label359:
    label364:
    label369:
    label374:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.nFileType);
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
      paramParcel.writeInt(this.dNS);
      paramParcel.writeLong(this.fileSize);
      paramParcel.writeLong(this.aoR);
      paramParcel.writeString(this.cjH);
      paramParcel.writeString(this.srcUrl);
      paramParcel.writeLong(this.createTime);
      paramParcel.writeInt(this.dNU);
      paramParcel.writeString(this.cjI);
      paramParcel.writeString(this.WeiYunFileId);
      paramParcel.writeString(this.Uuid);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label114;
      paramInt = 0;
      break label129;
      paramInt = 0;
      break label144;
      paramInt = 0;
      break label159;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo
 * JD-Core Version:    0.7.0.1
 */