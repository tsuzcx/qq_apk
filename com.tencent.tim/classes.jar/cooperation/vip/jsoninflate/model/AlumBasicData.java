package cooperation.vip.jsoninflate.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import awlt;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.vac_adv_get.DefaultConf;
import cooperation.vip.pb.vac_adv_get.DropList;
import cooperation.vip.pb.vac_adv_get.VacAdvMetaMsg;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class AlumBasicData
  implements Parcelable
{
  public static final Parcelable.Creator<AlumBasicData> CREATOR = new awlt();
  public List<a> LU = new ArrayList();
  public long aBk;
  public qq_ad_get.QQAdGetRsp.AdInfo adInfo;
  public String ahF = "";
  public String cRl;
  public String cRm;
  public String cRn;
  public String cRo;
  public String cRp;
  public String cRq = "";
  public String cRr = "";
  public String cRs = "";
  public String click_url;
  public int eBF;
  public int eBG;
  public int eBH;
  public int eBI;
  public int eBJ;
  public int eBK = -1;
  public int eBL;
  public int imageHeight;
  public String mVideoUrl = "";
  public String negative_feedback_url;
  
  public AlumBasicData() {}
  
  public AlumBasicData(Parcel paramParcel)
  {
    this.cRl = paramParcel.readString();
    this.cRm = paramParcel.readString();
    this.cRn = paramParcel.readString();
    this.cRo = paramParcel.readString();
    this.eBF = paramParcel.readInt();
    this.imageHeight = paramParcel.readInt();
    this.cRp = paramParcel.readString();
    this.negative_feedback_url = paramParcel.readString();
    this.click_url = paramParcel.readString();
    this.aBk = paramParcel.readLong();
    this.eBG = paramParcel.readInt();
    byte[] arrayOfByte;
    if (this.eBG > 0)
    {
      arrayOfByte = new byte[this.eBG];
      paramParcel.readByteArray(arrayOfByte);
      this.adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
    }
    try
    {
      this.adInfo.mergeFrom(arrayOfByte);
      this.ahF = paramParcel.readString();
      this.cRq = paramParcel.readString();
      paramParcel.readList(this.LU, a.class.getClassLoader());
      this.eBH = paramParcel.readInt();
      this.mVideoUrl = paramParcel.readString();
      this.eBI = paramParcel.readInt();
      this.eBJ = paramParcel.readInt();
      this.eBK = paramParcel.readInt();
      this.eBL = paramParcel.readInt();
      this.cRr = paramParcel.readString();
      this.cRs = paramParcel.readString();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("AlumBasicData", 1, "parse ad info from byte error " + localException);
      }
    }
  }
  
  public static AlumBasicData a(vac_adv_get.VacAdvMetaMsg paramVacAdvMetaMsg)
  {
    int j = 0;
    AlumBasicData localAlumBasicData = new AlumBasicData();
    if (paramVacAdvMetaMsg == null) {
      return null;
    }
    localAlumBasicData.cRl = paramVacAdvMetaMsg.recomm_cookie.get();
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)paramVacAdvMetaMsg.adv_rsp.get();
    localAlumBasicData.adInfo = localAdInfo;
    int i;
    if ((localAdInfo != null) && (localAdInfo.display_info.get() != null))
    {
      paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localAdInfo.display_info.basic_info.get();
      if (paramVacAdvMetaMsg != null)
      {
        localAlumBasicData.cRm = paramVacAdvMetaMsg.img.get();
        localAlumBasicData.cRo = paramVacAdvMetaMsg.txt.get();
        localAlumBasicData.eBF = paramVacAdvMetaMsg.pic_width.get();
        localAlumBasicData.imageHeight = paramVacAdvMetaMsg.pic_height.get();
        if (!TextUtils.isEmpty(localAlumBasicData.cRm)) {
          break label416;
        }
        i = -1;
      }
    }
    for (;;)
    {
      localAlumBasicData.eBK = i;
      if ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)localAdInfo.display_info.advertiser_info.get() != null)
      {
        localAlumBasicData.cRn = localAdInfo.display_info.advertiser_info.corporate_image_name.get();
        localAlumBasicData.cRr = localAdInfo.display_info.advertiser_info.corporate_logo.get();
      }
      paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo)localAdInfo.display_info.video_info.get();
      if (paramVacAdvMetaMsg != null)
      {
        localAlumBasicData.mVideoUrl = paramVacAdvMetaMsg.video_url.get();
        localAlumBasicData.eBI = paramVacAdvMetaMsg.media_duration.get();
        if (!paramVacAdvMetaMsg.no_auto_play.get()) {
          break label421;
        }
        i = j;
        label247:
        localAlumBasicData.eBJ = i;
        if (!TextUtils.isEmpty(localAlumBasicData.mVideoUrl)) {
          localAlumBasicData.eBK = 1;
        }
      }
      if ((localAdInfo != null) && (localAdInfo.report_info != null))
      {
        paramVacAdvMetaMsg = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localAdInfo.report_info.get();
        localAlumBasicData.cRp = paramVacAdvMetaMsg.exposure_url.get();
        localAlumBasicData.negative_feedback_url = paramVacAdvMetaMsg.negative_feedback_url.get();
        localAlumBasicData.click_url = paramVacAdvMetaMsg.click_url.get();
        if (localAdInfo.report_info.trace_info != null) {
          localAlumBasicData.aBk = paramVacAdvMetaMsg.trace_info.aid.get();
        }
        if (paramVacAdvMetaMsg.video_report_url.get() == null)
        {
          paramVacAdvMetaMsg = "";
          localAlumBasicData.cRs = paramVacAdvMetaMsg;
        }
      }
      else
      {
        paramVacAdvMetaMsg = localAdInfo.ext_json.get();
        if (TextUtils.isEmpty(paramVacAdvMetaMsg)) {}
      }
      try
      {
        paramVacAdvMetaMsg = new JSONObject(paramVacAdvMetaMsg);
        if (paramVacAdvMetaMsg.has("mini_program_preload")) {
          localAlumBasicData.eBL = paramVacAdvMetaMsg.getInt("mini_program_preload");
        }
        return localAlumBasicData;
        label416:
        i = 0;
        continue;
        label421:
        i = 1;
        break label247;
        paramVacAdvMetaMsg = paramVacAdvMetaMsg.video_report_url.get();
      }
      catch (Exception paramVacAdvMetaMsg)
      {
        for (;;)
        {
          QLog.e("AlumBasicData", 2, paramVacAdvMetaMsg.toString());
        }
      }
    }
  }
  
  public static AlumBasicData a(byte[] paramArrayOfByte)
  {
    int j = 0;
    AlumBasicData localAlumBasicData = new AlumBasicData();
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length == 0)
      {
        QLog.i("AlumBasicData", 1, " bytes is null");
        return null;
      }
      QLog.i("AlumBasicData", 1, " begin createFrombyte");
      localObject1 = new vac_adv_get.VacFeedsAdvMetaInfo();
      ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (qq_ad_get.QQAdGetRsp.AdInfo)((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).adv_rsp.get();
      localAlumBasicData.adInfo = paramArrayOfByte;
      localAlumBasicData.cRl = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).recomm_cookie.get();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.display_info.get() == null)) {
        break label405;
      }
      localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)paramArrayOfByte.display_info.basic_info.get();
      if (localObject2 != null)
      {
        localAlumBasicData.cRm = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject2).img.get();
        localAlumBasicData.cRo = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject2).txt.get();
        localAlumBasicData.eBF = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject2).pic_width.get();
        localAlumBasicData.imageHeight = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo)localObject2).pic_height.get();
      }
      if ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo)paramArrayOfByte.display_info.advertiser_info.get() != null)
      {
        localAlumBasicData.cRn = paramArrayOfByte.display_info.advertiser_info.corporate_image_name.get();
        localAlumBasicData.cRr = paramArrayOfByte.display_info.advertiser_info.corporate_logo.get();
      }
      if ((!paramArrayOfByte.display_info.button_info.has()) || (paramArrayOfByte.display_info.button_info.get() == null) || (paramArrayOfByte.display_info.button_info.get().size() <= 0)) {
        break label376;
      }
      i = 0;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int i;
        label376:
        QLog.e("AlumBasicData", 1, "createFrombyte  from byte error " + paramArrayOfByte);
        label405:
        continue;
        i += 1;
      }
    }
    if (i < paramArrayOfByte.display_info.button_info.get().size())
    {
      localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)paramArrayOfByte.display_info.button_info.get(i);
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).pos.get() == 2) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get()))) {
        localAlumBasicData.cRq = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get();
      }
      if ((((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).pos.get() == 1) && (!TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get()))) {
        localAlumBasicData.ahF = ((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo)localObject2).txt.get();
      }
    }
    else
    {
      QLog.i("AlumBasicData", 1, " basicData.advTextTitle=" + localAlumBasicData.cRn);
      if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.get() != null))
      {
        if ((TextUtils.isEmpty(localAlumBasicData.ahF)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.left_bottom_text.has())) {
          localAlumBasicData.ahF = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.left_bottom_text.get();
        }
        if ((TextUtils.isEmpty(localAlumBasicData.cRq)) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.right_bottom_button.has())) {
          localAlumBasicData.cRq = ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).default_conf.right_bottom_button.get();
        }
      }
      if ((((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.has()) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get() != null) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().size() != 0))
      {
        i = j;
        while (i < ((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().size())
        {
          localAlumBasicData.LU.add(a.a((vac_adv_get.DropList)((vac_adv_get.VacFeedsAdvMetaInfo)localObject1).droplist.get().get(i)));
          i += 1;
        }
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.report_info != null))
      {
        localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)paramArrayOfByte.report_info.get();
        localAlumBasicData.cRp = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).exposure_url.get();
        localAlumBasicData.negative_feedback_url = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).negative_feedback_url.get();
        localAlumBasicData.click_url = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).click_url.get();
        if (paramArrayOfByte.report_info.trace_info != null) {
          localAlumBasicData.aBk = ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject1).trace_info.aid.get();
        }
      }
      return localAlumBasicData;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cRl);
    paramParcel.writeString(this.cRm);
    paramParcel.writeString(this.cRn);
    paramParcel.writeString(this.cRo);
    paramParcel.writeInt(this.eBF);
    paramParcel.writeInt(this.imageHeight);
    paramParcel.writeString(this.cRp);
    paramParcel.writeString(this.negative_feedback_url);
    paramParcel.writeString(this.click_url);
    paramParcel.writeLong(this.aBk);
    int i = 0;
    paramInt = i;
    try
    {
      byte[] arrayOfByte = this.adInfo.toByteArray();
      paramInt = i;
      i = arrayOfByte.length;
      paramInt = i;
      paramParcel.writeInt(i);
      paramInt = i;
      paramParcel.writeByteArray(arrayOfByte);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        QLog.e("AlumBasicData", 1, "AlumBasicData writeToParcel  error " + localException);
      }
    }
    paramParcel.writeString(this.ahF);
    paramParcel.writeString(this.cRq);
    paramParcel.writeList(this.LU);
    paramParcel.writeInt(this.eBH);
    paramParcel.writeString(this.mVideoUrl);
    paramParcel.writeInt(this.eBI);
    paramParcel.writeInt(this.eBJ);
    paramParcel.writeInt(this.eBK);
    paramParcel.writeInt(this.eBL);
    paramParcel.writeString(this.cRr);
    paramParcel.writeString(this.cRs);
  }
  
  public static class a
  {
    public int actionType;
    public String content;
    public String jumpUrl;
    public String logo_url;
    
    public static a a(vac_adv_get.DropList paramDropList)
    {
      if (paramDropList == null) {
        return null;
      }
      a locala = new a();
      locala.actionType = paramDropList.action_type.get();
      locala.content = paramDropList.optext.get();
      locala.logo_url = paramDropList.iconurl.get();
      locala.jumpUrl = paramDropList.jumpurl.get();
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.AlumBasicData
 * JD-Core Version:    0.7.0.1
 */