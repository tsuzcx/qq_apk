package com.tencent.biz.qrcode.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import rwh;

public class ScannerParams
  implements Parcelable
{
  public static final Parcelable.Creator<ScannerParams> CREATOR = new rwh();
  public String aCL;
  public String aCM;
  public String aCN;
  public boolean aKe;
  public boolean aKf;
  public boolean aKg;
  public boolean aKh;
  public boolean aKi;
  public boolean aKj;
  public boolean aKk;
  public boolean aKl;
  public boolean aKm;
  public int bvA;
  public String from;
  
  public ScannerParams() {}
  
  public ScannerParams(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.aKe = bool1;
      if (paramParcel.readByte() == 0) {
        break label178;
      }
      bool1 = true;
      label29:
      this.aKf = bool1;
      if (paramParcel.readByte() == 0) {
        break label183;
      }
      bool1 = true;
      label43:
      this.aKg = bool1;
      this.from = paramParcel.readString();
      this.aCL = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label188;
      }
      bool1 = true;
      label73:
      this.aKh = bool1;
      this.aCM = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label193;
      }
      bool1 = true;
      label95:
      this.aKi = bool1;
      if (paramParcel.readByte() == 0) {
        break label198;
      }
      bool1 = true;
      label109:
      this.aKj = bool1;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool1 = true;
      label123:
      this.aKk = bool1;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
      bool1 = true;
      label137:
      this.aKl = bool1;
      if (paramParcel.readByte() == 0) {
        break label213;
      }
    }
    label178:
    label183:
    label188:
    label193:
    label198:
    label203:
    label208:
    label213:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aKm = bool1;
      this.bvA = paramParcel.readByte();
      this.aCN = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label29;
      bool1 = false;
      break label43;
      bool1 = false;
      break label73;
      bool1 = false;
      break label95;
      bool1 = false;
      break label109;
      bool1 = false;
      break label123;
      bool1 = false;
      break label137;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScannerParams { scanForResult: ").append(this.aKe);
    localStringBuilder.append("  finishAfterSuccess: ").append(this.aKf);
    localStringBuilder.append("  isFormPublicAccountNew: ").append(this.aKg);
    localStringBuilder.append("  from: ").append(this.from);
    localStringBuilder.append("  subFrom: ").append(this.aCL);
    localStringBuilder.append("  isDecodingFile: ").append(this.aKh);
    localStringBuilder.append("  toDecodeFilePath: ").append(this.aCM);
    localStringBuilder.append("  fromQRDecode: ").append(this.aKi);
    localStringBuilder.append("  hasCamera: ").append(this.aKk);
    localStringBuilder.append("  fromQLink: ").append(this.aKl);
    localStringBuilder.append("  isCameraReadyToUse: ").append(this.aKm);
    localStringBuilder.append("  detectType: ").append(this.bvA);
    localStringBuilder.append("  preResult: ").append(this.aCN);
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (this.aKe)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.aKf) {
        break label184;
      }
      paramInt = 1;
      label26:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aKg) {
        break label189;
      }
      paramInt = 1;
      label41:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.from);
      paramParcel.writeString(this.aCL);
      if (!this.aKh) {
        break label194;
      }
      paramInt = 1;
      label72:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.aCM);
      if (!this.aKi) {
        break label199;
      }
      paramInt = 1;
      label95:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aKj) {
        break label204;
      }
      paramInt = 1;
      label110:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aKk) {
        break label209;
      }
      paramInt = 1;
      label125:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aKl) {
        break label214;
      }
      paramInt = 1;
      label140:
      paramParcel.writeByte((byte)paramInt);
      if (!this.aKm) {
        break label219;
      }
    }
    label184:
    label189:
    label194:
    label199:
    label204:
    label209:
    label214:
    label219:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeByte((byte)this.bvA);
      paramParcel.writeString(this.aCN);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label26;
      paramInt = 0;
      break label41;
      paramInt = 0;
      break label72;
      paramInt = 0;
      break label95;
      paramInt = 0;
      break label110;
      paramInt = 0;
      break label125;
      paramInt = 0;
      break label140;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.ScannerParams
 * JD-Core Version:    0.7.0.1
 */