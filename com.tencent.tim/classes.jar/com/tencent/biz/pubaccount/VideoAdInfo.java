package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kby;
import kbz;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.NegFeedback;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;

public class VideoAdInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoAdInfo> CREATOR = new kby();
  public String VZ;
  public String Wa;
  public String Wb;
  public String Wc;
  public String Wd;
  public String We;
  public String Wf;
  public String Wg;
  public String Wh;
  public String Wi;
  public String Wj;
  public String Wk;
  public String Wl;
  public String Wm;
  public String Wn;
  public String Wo;
  public String Wp;
  public String Wq;
  @notColumn
  public String Wr = "";
  @notColumn
  public String Ws = "";
  @notColumn
  public String Wt = "";
  @notColumn
  public String Wu = "";
  @notColumn
  public String Wv = "";
  @notColumn
  public String Ww;
  @notColumn
  public String Wx;
  public int aGT;
  public int aGU;
  public int aGV;
  public int aGW;
  public int aGX;
  @notColumn
  public int aGY = 1;
  @notColumn
  public int aGZ = 3;
  @notColumn
  public boolean adA;
  @notColumn
  public boolean adz;
  public ArrayList<String> gk = new ArrayList();
  public boolean isMultiyVideo;
  public ArrayList<VideoAdInfo> jM;
  public ArrayList<String> jN = new ArrayList();
  public ArrayList<NegFeedback> jO = new ArrayList();
  @notColumn
  public ArrayList<String> jP = new ArrayList();
  public long mAdAdvertiseId;
  public String mAdAppDownLoadSchema;
  public String mAdAppJson;
  public String mAdCanvasJson;
  public int mAdDestType;
  public String mAdEffectUrl;
  public String mAdExtInfo;
  public int mAdJumpMode;
  public String mAdLandingPageReportUrl;
  public int mAdLayout;
  public int mAdMaterialHeight;
  public int mAdMaterialId;
  public int mAdMaterialWidth;
  public long mAdNocoId;
  public int mAdType;
  public long mAdUin;
  @notColumn
  public ArrayList<String> mC2SClickUrl;
  @notColumn
  public ArrayList<String> mC2SExposureUrl;
  @notColumn
  public int mC2SSwitch;
  public long mChannelID;
  public String mDesc;
  public int mDuration;
  public ArrayList<String> mImageList = new ArrayList();
  public String mImg;
  public String mPopFormH5Url;
  public int mRevisionVideoType = 1;
  public boolean mShowAdButton = true;
  public String mVia;
  public String mVideoUrl;
  @notColumn
  public int replay;
  public long rr;
  public long rt;
  public long ru;
  public long rv;
  
  public VideoAdInfo() {}
  
  public VideoAdInfo(long paramLong, oidb_0x6cf.PosAdInfo paramPosAdInfo)
  {
    if ((paramPosAdInfo == null) || (paramPosAdInfo.int32_ret.get() != 0) || (!paramPosAdInfo.msg_ad_info.has()) || (paramPosAdInfo.msg_ad_info.get() == null)) {
      return;
    }
    this.rr = paramLong;
    this.aGT = paramPosAdInfo.enum_pos_layout.get();
    this.rt = paramPosAdInfo.uint64_pos_id.get();
    paramPosAdInfo = (oidb_0x6cf.AdInfo)paramPosAdInfo.msg_ad_info.get();
    this.mChannelID = paramPosAdInfo.uint64_channel_id.get();
    this.aGU = paramPosAdInfo.int32_kd_pos.get();
    this.VZ = paramPosAdInfo.bytes_cl.get().toStringUtf8();
    this.mImg = paramPosAdInfo.bytes_img.get().toStringUtf8();
    this.Wa = paramPosAdInfo.bytes_img_s.get().toStringUtf8();
    this.Wb = paramPosAdInfo.bytes_txt.get().toStringUtf8();
    this.mDesc = paramPosAdInfo.bytes_desc.get().toStringUtf8();
    this.Wc = paramPosAdInfo.bytes_rl.get().toStringUtf8();
    this.Wd = paramPosAdInfo.bytes_apurl.get().toStringUtf8();
    this.We = paramPosAdInfo.bytes_trace_id.get().toStringUtf8();
    this.Wf = paramPosAdInfo.bytes_product_id.get().toStringUtf8();
    this.aGV = paramPosAdInfo.int32_product_type.get();
    this.mAdType = paramPosAdInfo.uint32_ad_type.get();
    this.Wg = paramPosAdInfo.bytes_landing_page.get().toStringUtf8();
    this.Wh = paramPosAdInfo.bytes_price.get().toStringUtf8();
    this.Wi = paramPosAdInfo.bytes_button_txt.get().toStringUtf8();
    this.Wj = paramPosAdInfo.bytes_view_id.get().toStringUtf8();
    this.Wk = paramPosAdInfo.bytes_customized_invoke_url.get().toStringUtf8();
    this.Wl = paramPosAdInfo.bytes_corporation_name.get().toStringUtf8();
    this.Wm = paramPosAdInfo.bytes_corporate_image_name.get().toStringUtf8();
    this.Wn = paramPosAdInfo.bytes_corporate_logo.get().toStringUtf8();
    this.mAdUin = paramPosAdInfo.uint64_ad_uin.get();
    this.Wo = paramPosAdInfo.bytes_ext.get().toStringUtf8();
    if (TextUtils.isEmpty(this.Wo)) {
      this.Wo = new JSONObject().toString();
    }
    this.mVideoUrl = paramPosAdInfo.bytes_video_url.get().toStringUtf8();
    this.aGW = paramPosAdInfo.uint32_cost_type.get();
    Iterator localIterator;
    ByteStringMicro localByteStringMicro;
    if ((paramPosAdInfo.bytes_title_list.has()) && (paramPosAdInfo.bytes_title_list.get() != null))
    {
      localIterator = paramPosAdInfo.bytes_title_list.get().iterator();
      while (localIterator.hasNext())
      {
        localByteStringMicro = (ByteStringMicro)localIterator.next();
        this.jN.add(localByteStringMicro.toStringUtf8());
      }
    }
    if ((paramPosAdInfo.bytes_image_list.has()) && (paramPosAdInfo.bytes_image_list.get() != null))
    {
      localIterator = paramPosAdInfo.bytes_image_list.get().iterator();
      while (localIterator.hasNext())
      {
        localByteStringMicro = (ByteStringMicro)localIterator.next();
        this.mImageList.add(localByteStringMicro.toStringUtf8());
      }
    }
    if ((paramPosAdInfo.bytes_url_list.has()) && (paramPosAdInfo.bytes_url_list.get() != null))
    {
      localIterator = paramPosAdInfo.bytes_url_list.get().iterator();
      while (localIterator.hasNext())
      {
        localByteStringMicro = (ByteStringMicro)localIterator.next();
        this.gk.add(localByteStringMicro.toStringUtf8());
      }
    }
    this.ru = paramPosAdInfo.uint64_aid.get();
    this.mAdLayout = paramPosAdInfo.enum_ad_layout.get();
    this.mAdMaterialId = paramPosAdInfo.uint32_ad_material_id.get();
    this.mAdMaterialWidth = paramPosAdInfo.uint32_ad_material_width.get();
    this.mAdMaterialHeight = paramPosAdInfo.uint32_ad_material_height.get();
    this.mVia = paramPosAdInfo.bytes_via.get().toStringUtf8();
    this.aGX = paramPosAdInfo.uint32_dis_channel.get();
    this.Wp = paramPosAdInfo.bytes_button_url.get().toStringUtf8();
    this.mDuration = paramPosAdInfo.uint32_duration.get();
    this.mAdExtInfo = paramPosAdInfo.bytes_extra_data.get().toStringUtf8();
    this.mAdJumpMode = paramPosAdInfo.enum_ad_jump_mode.get();
    this.mAdAppDownLoadSchema = paramPosAdInfo.bytes_app_download_schema.get().toStringUtf8();
    this.mAdCanvasJson = paramPosAdInfo.string_canvas_json.get();
    this.mAdLandingPageReportUrl = paramPosAdInfo.bytes_landing_page_report_url.get().toStringUtf8();
    this.mAdAdvertiseId = paramPosAdInfo.uint64_advertiser_id.get();
    this.mAdDestType = paramPosAdInfo.uint32_dest_type.get();
    this.mAdEffectUrl = paramPosAdInfo.string_effect_url.get();
    this.mAdNocoId = paramPosAdInfo.int64_noco_id.get();
    this.Wq = paramPosAdInfo.bytes_download_api_url.get().toStringUtf8();
    lP(this.mAdExtInfo);
    lQ(this.mAdExtInfo);
  }
  
  public VideoAdInfo(Parcel paramParcel)
  {
    this.rr = paramParcel.readLong();
    this.aGT = paramParcel.readInt();
    this.rt = paramParcel.readLong();
    this.mChannelID = paramParcel.readLong();
    this.aGU = paramParcel.readInt();
    this.VZ = paramParcel.readString();
    this.mImg = paramParcel.readString();
    this.Wa = paramParcel.readString();
    this.Wb = paramParcel.readString();
    this.mDesc = paramParcel.readString();
    this.Wc = paramParcel.readString();
    this.Wd = paramParcel.readString();
    this.We = paramParcel.readString();
    this.Wf = paramParcel.readString();
    this.aGV = paramParcel.readInt();
    this.mAdType = paramParcel.readInt();
    this.jM = paramParcel.readArrayList(VideoAdInfo.class.getClassLoader());
    this.Wg = paramParcel.readString();
    this.Wh = paramParcel.readString();
    this.Wi = paramParcel.readString();
    this.Wj = paramParcel.readString();
    this.Wk = paramParcel.readString();
    this.Wl = paramParcel.readString();
    this.Wm = paramParcel.readString();
    this.Wn = paramParcel.readString();
    this.mAdUin = paramParcel.readLong();
    this.Wo = paramParcel.readString();
    this.mVideoUrl = paramParcel.readString();
    this.aGW = paramParcel.readInt();
    paramParcel.readStringList(this.jN);
    paramParcel.readStringList(this.mImageList);
    paramParcel.readStringList(this.gk);
    this.ru = paramParcel.readLong();
    this.mAdLayout = paramParcel.readInt();
    this.mAdMaterialId = paramParcel.readInt();
    this.mAdMaterialWidth = paramParcel.readInt();
    this.mAdMaterialHeight = paramParcel.readInt();
    this.mVia = paramParcel.readString();
    this.aGX = paramParcel.readInt();
    this.Wp = paramParcel.readString();
    this.mDuration = paramParcel.readInt();
    this.jO = paramParcel.readArrayList(NegFeedback.class.getClassLoader());
    this.rv = paramParcel.readLong();
    this.mAdExtInfo = paramParcel.readString();
    this.mAdJumpMode = paramParcel.readInt();
    this.mAdAppDownLoadSchema = paramParcel.readString();
    this.mAdCanvasJson = paramParcel.readString();
    this.mAdLandingPageReportUrl = paramParcel.readString();
    this.mAdAdvertiseId = paramParcel.readLong();
    this.mAdDestType = paramParcel.readInt();
    this.mAdEffectUrl = paramParcel.readString();
    this.mAdNocoId = paramParcel.readLong();
    this.Wq = paramParcel.readString();
    this.mRevisionVideoType = paramParcel.readInt();
  }
  
  public static void a(VideoAdInfo paramVideoAdInfo)
  {
    if ((paramVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoAdInfo.mAdExtInfo))) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramVideoAdInfo.mAdExtInfo);
        if (((JSONObject)localObject1).has("c2s_switch")) {
          paramVideoAdInfo.mC2SSwitch = ((JSONObject)localObject1).optInt("c2s_switch");
        }
        Object localObject2;
        int j;
        ArrayList localArrayList;
        int i;
        String str;
        if (((JSONObject)localObject1).has("c2s_click_url"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONArray("c2s_click_url");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            j = ((JSONArray)localObject2).length();
            localArrayList = new ArrayList();
            i = 0;
            if (i < j)
            {
              str = (String)((JSONArray)localObject2).opt(i);
              if (QLog.isColorLevel()) {
                QLog.d("setVideoAdInfoC2SInfo", 2, " setVideoAdInfoC2SInfo clickUrl = " + str);
              }
              localArrayList.add(str);
              i += 1;
              continue;
            }
            paramVideoAdInfo.mC2SClickUrl = localArrayList;
          }
        }
        if (((JSONObject)localObject1).has("c2s_exposure_url"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONArray("c2s_exposure_url");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            j = ((JSONArray)localObject2).length();
            localArrayList = new ArrayList();
            i = 0;
            if (i < j)
            {
              str = (String)((JSONArray)localObject2).opt(i);
              if (QLog.isColorLevel()) {
                QLog.d("setVideoAdInfoC2SInfo", 2, " setVideoAdInfoC2SInfo exposureUrl = " + str);
              }
              localArrayList.add(str);
              i += 1;
              continue;
            }
            paramVideoAdInfo.mC2SExposureUrl = localArrayList;
          }
        }
        if (((JSONObject)localObject1).has("pop_sheet"))
        {
          localObject2 = new JSONObject(((JSONObject)localObject1).optString("pop_sheet")).getString("h5Url");
          if (QLog.isColorLevel()) {
            QLog.d("processAdExtraDataInfo", 2, "h5Url = " + (String)localObject2);
          }
          paramVideoAdInfo.mPopFormH5Url = ((String)localObject2);
        }
        if (((JSONObject)localObject1).has("button_flag"))
        {
          localObject1 = ((JSONObject)localObject1).optString("button_flag", "1");
          if (QLog.isColorLevel()) {
            QLog.d("processAdExtraDataInfo", 2, "buttonFlag = " + (String)localObject1);
          }
          if (!((String)localObject1).equals("0"))
          {
            bool = true;
            paramVideoAdInfo.mShowAdButton = bool;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("setVideoAdInfoC2SInfo", 2, " setVideoAdInfoC2SInfo mCorporateImageName = " + paramVideoAdInfo.Wm + " mTraceID = " + paramVideoAdInfo.We + " c2s_switch = " + paramVideoAdInfo.mC2SSwitch);
          return;
        }
      }
      catch (Exception paramVideoAdInfo)
      {
        QLog.e("setVideoAdInfoC2SInfo", 1, "setVideoAdInfoC2SInfo exception " + paramVideoAdInfo.toString());
        return;
      }
      boolean bool = false;
    }
  }
  
  public void bG(List<oidb_0x6cf.NegFeedback> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_0x6cf.NegFeedback localNegFeedback = (oidb_0x6cf.NegFeedback)paramList.next();
        this.jO.add(new NegFeedback(localNegFeedback));
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void lP(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("c2s_switch")) {
          this.mC2SSwitch = paramString.optInt("c2s_switch");
        }
        Object localObject;
        int j;
        ArrayList localArrayList;
        int i;
        String str;
        if (paramString.has("c2s_click_url"))
        {
          localObject = paramString.optJSONArray("c2s_click_url");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            j = ((JSONArray)localObject).length();
            localArrayList = new ArrayList();
            i = 0;
            if (i < j)
            {
              str = (String)((JSONArray)localObject).opt(i);
              if (QLog.isColorLevel()) {
                QLog.d("setVideoAdInfoC2SInfo", 2, " setVideoAdInfoC2SInfo clickUrl = " + str);
              }
              localArrayList.add(str);
              i += 1;
              continue;
            }
            this.mC2SClickUrl = localArrayList;
          }
        }
        if (paramString.has("c2s_exposure_url"))
        {
          localObject = paramString.optJSONArray("c2s_exposure_url");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            j = ((JSONArray)localObject).length();
            localArrayList = new ArrayList();
            i = 0;
            if (i < j)
            {
              str = (String)((JSONArray)localObject).opt(i);
              if (QLog.isColorLevel()) {
                QLog.d("setVideoAdInfoC2SInfo", 2, " setVideoAdInfoC2SInfo exposureUrl = " + str);
              }
              localArrayList.add(str);
              i += 1;
              continue;
            }
            this.mC2SExposureUrl = localArrayList;
          }
        }
        if (paramString.has("pop_sheet"))
        {
          localObject = new JSONObject(paramString.optString("pop_sheet")).getString("h5Url");
          if (QLog.isColorLevel()) {
            QLog.d("processAdExtraDataInfo", 2, "h5Url = " + (String)localObject);
          }
          this.mPopFormH5Url = ((String)localObject);
        }
        if (paramString.has("button_flag"))
        {
          localObject = paramString.optString("button_flag", "1");
          if (QLog.isColorLevel()) {
            QLog.d("processAdExtraDataInfo", 2, "buttonFlag = " + (String)localObject);
          }
          if (!((String)localObject).equals("0"))
          {
            bool = true;
            this.mShowAdButton = bool;
          }
        }
        else
        {
          if (paramString.has("video_rowkey"))
          {
            this.Wr = paramString.optString("video_rowkey", "");
            if (QLog.isColorLevel()) {
              QLog.d("processAdExtraDataInfo", 2, "video_rowkey = " + this.Wr);
            }
          }
          if (paramString.has("revisionVideoType")) {
            this.mRevisionVideoType = paramString.optInt("revisionVideoType");
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("setVideoAdInfoC2SInfo", 2, " setVideoAdInfoC2SInfo mAdCorporateImageName = " + this.Wm + " mAdTraceId = " + this.We + "c2s_switch = " + this.mC2SSwitch);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("setVideoAdInfoC2SInfo", 1, "setVideoAdInfoC2SInfo exception " + paramString.toString());
        return;
      }
      boolean bool = false;
    }
  }
  
  public void lQ(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        this.Ws = paramString.optString("dpa_img");
        this.Wt = paramString.optString("dpa_name");
        this.Wu = paramString.optString("dpa_price");
        this.Wv = paramString.optString("dpa_discount");
        JSONArray localJSONArray = paramString.optJSONArray("dpa_additional");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            Object localObject = localJSONArray.get(i);
            if (!(localObject instanceof String)) {
              break label176;
            }
            this.jP.add((String)localObject);
            break label176;
          }
        }
        this.aGY = paramString.optInt("ad_first_category");
        this.aGZ = paramString.optInt("dpa_display_seconds");
        this.Ww = paramString.optString("dpa_button_text1");
        this.Ww = paramString.optString("dpa_button_text1");
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label176:
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[\n");
    localStringBuilder.append("    kd_pos=").append(this.aGU).append(", pull_time=").append(this.rr).append("\n");
    localStringBuilder.append("    img=").append(this.mImg).append("\n");
    localStringBuilder.append("    rl=").append(this.Wc).append("\n");
    localStringBuilder.append("    txt=").append(this.Wb).append(", trace_id=").append(this.We).append("\n");
    localStringBuilder.append("    button_txt=").append(this.Wi).append(", corporation_name=").append(this.Wl).append("\n");
    localStringBuilder.append("    corporate_logo=").append(this.Wn).append("\n");
    localStringBuilder.append("    video_url=").append(this.mVideoUrl).append("\n");
    localStringBuilder.append("    aid=").append(this.ru).append(", duration=").append(this.mDuration).append("\n");
    localStringBuilder.append("    material_id=").append(this.mAdMaterialId).append(", material_width=").append(this.mAdMaterialWidth).append(", material_height=").append(this.mAdMaterialHeight).append("\n");
    localStringBuilder.append("    extra_info=").append(this.mAdExtInfo).append("\n");
    localStringBuilder.append("    jump_mode=").append(this.mAdJumpMode).append("\n");
    localStringBuilder.append("    appDownLoad_schema=").append(this.mAdAppDownLoadSchema).append("\n");
    localStringBuilder.append("    canvas_json=").append(this.mAdCanvasJson).append("\n");
    localStringBuilder.append("    landingPage_reporturl=").append(this.mAdLandingPageReportUrl).append("\n");
    localStringBuilder.append("    advertise_id=").append(this.mAdAdvertiseId).append("\n");
    localStringBuilder.append("    dest_type=").append(this.mAdDestType).append("\n");
    localStringBuilder.append("    effect_url=").append(this.mAdEffectUrl).append("\n");
    localStringBuilder.append("    noco_id=").append(this.mAdNocoId).append("\n");
    localStringBuilder.append("    noco_id=").append(this.Wq).append("\n");
    localStringBuilder.append("    revisionVideoType=").append(this.mRevisionVideoType).append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.rr);
    paramParcel.writeInt(this.aGT);
    paramParcel.writeLong(this.rt);
    paramParcel.writeLong(this.mChannelID);
    paramParcel.writeInt(this.aGU);
    paramParcel.writeString(this.VZ);
    paramParcel.writeString(this.mImg);
    paramParcel.writeString(this.Wa);
    paramParcel.writeString(this.Wb);
    paramParcel.writeString(this.mDesc);
    paramParcel.writeString(this.Wc);
    paramParcel.writeString(this.Wd);
    paramParcel.writeString(this.We);
    paramParcel.writeString(this.Wf);
    paramParcel.writeInt(this.aGV);
    paramParcel.writeInt(this.mAdType);
    paramParcel.writeList(this.jM);
    paramParcel.writeString(this.Wg);
    paramParcel.writeString(this.Wh);
    paramParcel.writeString(this.Wi);
    paramParcel.writeString(this.Wj);
    paramParcel.writeString(this.Wk);
    paramParcel.writeString(this.Wl);
    paramParcel.writeString(this.Wm);
    paramParcel.writeString(this.Wn);
    paramParcel.writeLong(this.mAdUin);
    paramParcel.writeString(this.Wo);
    paramParcel.writeString(this.mVideoUrl);
    paramParcel.writeInt(this.aGW);
    paramParcel.writeStringList(this.jN);
    paramParcel.writeStringList(this.mImageList);
    paramParcel.writeStringList(this.gk);
    paramParcel.writeLong(this.ru);
    paramParcel.writeInt(this.mAdLayout);
    paramParcel.writeInt(this.mAdMaterialId);
    paramParcel.writeInt(this.mAdMaterialWidth);
    paramParcel.writeInt(this.mAdMaterialHeight);
    paramParcel.writeString(this.mVia);
    paramParcel.writeInt(this.aGX);
    paramParcel.writeString(this.Wp);
    paramParcel.writeInt(this.mDuration);
    paramParcel.writeList(this.jO);
    paramParcel.writeLong(this.rv);
    paramParcel.writeString(this.mAdExtInfo);
    paramParcel.writeInt(this.mAdJumpMode);
    paramParcel.writeString(this.mAdAppDownLoadSchema);
    paramParcel.writeString(this.mAdCanvasJson);
    paramParcel.writeString(this.mAdLandingPageReportUrl);
    paramParcel.writeLong(this.mAdAdvertiseId);
    paramParcel.writeInt(this.mAdDestType);
    paramParcel.writeString(this.mAdEffectUrl);
    paramParcel.writeLong(this.mAdNocoId);
    paramParcel.writeString(this.Wq);
    paramParcel.writeInt(this.mRevisionVideoType);
  }
  
  public static class NegFeedback
    implements Parcelable
  {
    public static final Parcelable.Creator<NegFeedback> CREATOR = new kbz();
    public String Wy;
    public long rw;
    
    public NegFeedback() {}
    
    public NegFeedback(Parcel paramParcel)
    {
      this.rw = paramParcel.readLong();
      this.Wy = paramParcel.readString();
    }
    
    public NegFeedback(oidb_0x6cf.NegFeedback paramNegFeedback)
    {
      this.rw = paramNegFeedback.uint64_type_id.get();
      this.Wy = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.rw);
      paramParcel.writeString(this.Wy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoAdInfo
 * JD-Core Version:    0.7.0.1
 */