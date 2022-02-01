package com.tencent.mobileqq.ocr.data;

import akny;
import aknz;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageRecord;
import com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageTranslateRspResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TranslateResult
  implements Parcelable
{
  public static final Parcelable.Creator<TranslateResult> CREATOR = new akny();
  public List<String> Eh;
  public String bta;
  public String btb;
  public int errCode;
  public String errMsg;
  public String imagePath;
  public List<Record> records;
  public int type;
  public String uuid;
  
  public TranslateResult(int paramInt)
  {
    this.type = paramInt;
    this.records = new ArrayList();
  }
  
  public TranslateResult(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.bta = paramParcel.readString();
    this.btb = paramParcel.readString();
    this.records = paramParcel.createTypedArrayList(Record.CREATOR);
    this.imagePath = paramParcel.readString();
    this.uuid = paramParcel.readString();
    this.Eh = paramParcel.createStringArrayList();
    this.errCode = paramParcel.readInt();
    this.errMsg = paramParcel.readString();
  }
  
  private boolean bl(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    while ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(paramString2))) {
      return true;
    }
    return false;
  }
  
  public void L(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.bta = paramString1;
    this.btb = paramString2;
    paramString1 = new Record();
    paramString1.bTZ = paramString3;
    paramString1.bUa = paramString4;
    this.records.add(paramString1);
  }
  
  public void a(ARCloudRecogCustomPb.ImageTranslateRspResult paramImageTranslateRspResult)
  {
    if (paramImageTranslateRspResult == null) {}
    for (;;)
    {
      return;
      if (paramImageTranslateRspResult.image_translate_err_code.has()) {
        this.errCode = paramImageTranslateRspResult.image_translate_err_code.get();
      }
      if (paramImageTranslateRspResult.image_translate_err_msg.has()) {
        this.errMsg = paramImageTranslateRspResult.image_translate_err_msg.get().toStringUtf8();
      }
      if (paramImageTranslateRspResult.session_uuid.has()) {
        this.uuid = paramImageTranslateRspResult.session_uuid.get().toStringUtf8();
      }
      if (paramImageTranslateRspResult.source_lange.has()) {
        this.bta = paramImageTranslateRspResult.source_lange.get().toStringUtf8();
      }
      if (paramImageTranslateRspResult.target_lang.has()) {
        this.btb = paramImageTranslateRspResult.target_lang.get().toStringUtf8();
      }
      Object localObject;
      if (paramImageTranslateRspResult.msg_image_record_list.has())
      {
        localObject = paramImageTranslateRspResult.msg_image_record_list.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ARCloudRecogCustomPb.ImageRecord localImageRecord = (ARCloudRecogCustomPb.ImageRecord)((Iterator)localObject).next();
            Record localRecord = new Record();
            localRecord.bTZ = localImageRecord.source_text.get().toStringUtf8();
            localRecord.bUa = localImageRecord.target_text.get().toStringUtf8();
            localRecord.x = localImageRecord.coordinate_x.get();
            localRecord.y = localImageRecord.coordinate_y.get();
            localRecord.width = localImageRecord.width.get();
            localRecord.height = localImageRecord.height.get();
            localRecord.bUb = localImageRecord.angle.get().toStringUtf8();
            this.records.add(localRecord);
          }
        }
      }
      if (paramImageTranslateRspResult.support_translate_lang.has())
      {
        paramImageTranslateRspResult = paramImageTranslateRspResult.support_translate_lang.get();
        this.Eh = new ArrayList();
        if (paramImageTranslateRspResult != null)
        {
          paramImageTranslateRspResult = paramImageTranslateRspResult.iterator();
          while (paramImageTranslateRspResult.hasNext())
          {
            localObject = (ByteStringMicro)paramImageTranslateRspResult.next();
            this.Eh.add(((ByteStringMicro)localObject).toStringUtf8());
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {}
    for (;;)
    {
      return;
      this.bta = paramString1;
      this.btb = paramString2;
      int j = Math.min(paramList1.size(), paramList2.size());
      int i = 0;
      while (i < j)
      {
        paramString1 = new Record();
        paramString1.bTZ = ((String)paramList1.get(i));
        paramString1.bUa = ((String)paramList2.get(i));
        this.records.add(paramString1);
        i += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getText()
  {
    if ((this.records == null) || (this.records.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.records.size())
    {
      Record localRecord = (Record)this.records.get(i);
      if ((!TextUtils.isEmpty(localRecord.bTZ)) && (!TextUtils.isEmpty(localRecord.bUa))) {
        localStringBuilder.append(localRecord.bTZ).append("\n").append(localRecord.bUa).append("\n").append("\n");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean isEmpty()
  {
    return (this.records == null) || (this.records.size() == 0);
  }
  
  public boolean isSuccess()
  {
    return this.errCode == 0;
  }
  
  public boolean nK(String paramString)
  {
    return (!TextUtils.isEmpty(this.imagePath)) && (!TextUtils.isEmpty(paramString)) && (this.imagePath.equals(paramString));
  }
  
  public boolean nL(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.isEmpty(paramString.trim())) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      String str;
      do
      {
        do
        {
          return bool1;
          str = xH();
          bool1 = bool2;
        } while (TextUtils.isEmpty(str));
        bool1 = bool2;
      } while (TextUtils.isEmpty(str.trim()));
      bool2 = paramString.trim().replace("\n", "").equals(str.trim().replace("\n", ""));
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TranslateResult", 2, "isSame: " + bool2);
    return bool2;
  }
  
  public CharSequence r()
  {
    if ((this.records == null) || (this.records.size() == 0)) {
      return "";
    }
    Object localObject1 = new StringBuilder();
    int i = 0;
    while (i < this.records.size())
    {
      localObject2 = (Record)this.records.get(i);
      if ((!TextUtils.isEmpty(((Record)localObject2).bTZ)) && (!TextUtils.isEmpty(((Record)localObject2).bUa)))
      {
        ((StringBuilder)localObject1).append(((Record)localObject2).bUa);
        if (i < this.records.size() - 1) {
          ((StringBuilder)localObject1).append("\n\n");
        }
      }
      i += 1;
    }
    Object localObject2 = new ForegroundColorSpan(Color.parseColor("#12B7F5"));
    localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
    ((SpannableString)localObject1).setSpan(localObject2, 0, ((SpannableString)localObject1).length(), 33);
    return localObject1;
  }
  
  public CharSequence s()
  {
    if ((this.records == null) || (this.records.size() == 0)) {
      return "";
    }
    Object localObject2 = new StringBuilder();
    Object localObject1 = new ArrayList();
    int i = 0;
    Object localObject3;
    while (i < this.records.size())
    {
      localObject3 = (Record)this.records.get(i);
      if ((!TextUtils.isEmpty(((Record)localObject3).bTZ)) && (!TextUtils.isEmpty(((Record)localObject3).bUa)))
      {
        ((StringBuilder)localObject2).append(((Record)localObject3).bTZ).append("\n");
        int j = ((StringBuilder)localObject2).length();
        ((StringBuilder)localObject2).append(((Record)localObject3).bUa);
        ((List)localObject1).add(new Pair(Integer.valueOf(j), Integer.valueOf(((StringBuilder)localObject2).length())));
        ((StringBuilder)localObject2).append("\n").append("\n");
      }
      i += 1;
    }
    localObject2 = new SpannableString(((StringBuilder)localObject2).toString());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Pair)((Iterator)localObject1).next();
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), ((Integer)((Pair)localObject3).first).intValue(), ((Integer)((Pair)localObject3).second).intValue(), 33);
    }
    return localObject2;
  }
  
  public boolean t(String paramString1, String paramString2, String paramString3)
  {
    if (this.type == 2) {}
    while ((bl(paramString2, this.bta)) && (bl(paramString3, this.btb)) && (nL(paramString1))) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "TranslateResult{type=" + this.type + ", srcLang='" + this.bta + '\'' + ", dstLang='" + this.btb + '\'' + ", records=" + this.records + ", imagePath='" + this.imagePath + '\'' + ", uuid='" + this.uuid + '\'' + ", sLanguages=" + this.Eh + ", errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.bta);
    paramParcel.writeString(this.btb);
    paramParcel.writeTypedList(this.records);
    paramParcel.writeString(this.imagePath);
    paramParcel.writeString(this.uuid);
    paramParcel.writeStringList(this.Eh);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
  }
  
  public String xG()
  {
    if ((this.records == null) || (this.records.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.records.size())
    {
      Record localRecord = (Record)this.records.get(i);
      if (!TextUtils.isEmpty(localRecord.bUa))
      {
        localStringBuilder.append(localRecord.bUa);
        if (i + 1 != this.records.size()) {
          localStringBuilder.append("\n");
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String xH()
  {
    if ((this.records == null) || (this.records.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.records.size())
    {
      Record localRecord = (Record)this.records.get(i);
      if ((!TextUtils.isEmpty(localRecord.bTZ)) && (!TextUtils.isEmpty(localRecord.bUa)))
      {
        localStringBuilder.append(localRecord.bTZ);
        if (i < this.records.size() - 1) {
          localStringBuilder.append("\n\n");
        }
      }
      i += 1;
    }
    return localStringBuilder.toString().trim();
  }
  
  public static class Record
    implements Parcelable
  {
    public static final Parcelable.Creator<Record> CREATOR = new aknz();
    public String bTZ;
    public String bUa;
    public String bUb;
    public int height;
    public int width;
    public int x;
    public int y;
    
    public Record() {}
    
    public Record(Parcel paramParcel)
    {
      this.bTZ = paramParcel.readString();
      this.bUa = paramParcel.readString();
      this.x = paramParcel.readInt();
      this.y = paramParcel.readInt();
      this.width = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.bUb = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "Record{srcText='" + this.bTZ + '\'' + ", dstText='" + this.bUa + '\'' + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", angle='" + this.bUb + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.bTZ);
      paramParcel.writeString(this.bUa);
      paramParcel.writeInt(this.x);
      paramParcel.writeInt(this.y);
      paramParcel.writeInt(this.width);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.bUb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.TranslateResult
 * JD-Core Version:    0.7.0.1
 */