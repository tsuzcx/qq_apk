package com.tencent.token.core.bean;

import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import com.tencent.token.dx;
import com.tencent.token.global.g;
import com.tencent.token.utils.e;
import com.tencent.token.utils.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigResult
  implements Serializable
{
  private static final long serialVersionUID = 5361472330572016694L;
  public int displayAngle = -1;
  public int face_algorithm;
  public int imageAngle = -1;
  public int live_angle;
  public int logLevel;
  public FaceRecognitionParamResult mFaceRecognitionParamResult;
  public Bitmap mStartUpImg;
  public long mStartUpImgEndTime;
  public long mStartUpImgStartTime;
  public String mStartUpImgUrl;
  public JSONArray mToolsList;
  public JSONArray mToolsTitleList;
  public String schemaKey;
  public int schemaTimeout;
  public String so_param_ids;
  public String so_param_values;
  public int uploadDate;
  public int uploadDeviceInfoInt = 0;
  public int useFaceChmobile = 0;
  public int useFaceChpwd = 0;
  public int useFaceStart = 0;
  public int utilsShowFlag;
  public ArrayList<ZzbIntroItem> zzbIntroItemlist;
  public JSONArray zzbIntroList;
  
  public ConfigResult() {}
  
  public ConfigResult(JSONObject paramJSONObject)
  {
    this.mStartUpImgUrl = paramJSONObject.getString("startup_img_url");
    this.mStartUpImgStartTime = paramJSONObject.getLong("startup_img_start_time");
    this.mStartUpImgEndTime = paramJSONObject.getLong("startup_img_end_time");
    this.schemaKey = paramJSONObject.getString("schema_key");
    this.schemaTimeout = paramJSONObject.getInt("schema_timeout");
    this.utilsShowFlag = paramJSONObject.getInt("icon_show_flag");
    g.b("ConfigResult mStartUpImgUrl=" + this.mStartUpImgUrl + "mStartUpImgStartTime=" + this.mStartUpImgStartTime + "mStartUpImgEndTime=schemaKey=" + this.schemaKey + "schemaTimeout=" + this.schemaTimeout);
    this.so_param_ids = paramJSONObject.optString("so_param_ids");
    this.so_param_values = paramJSONObject.optString("so_param_values");
    this.mFaceRecognitionParamResult = new FaceRecognitionParamResult(paramJSONObject);
    try
    {
      this.face_algorithm = paramJSONObject.getInt("face_algorithm");
      try
      {
        this.displayAngle = paramJSONObject.getInt("displayangle");
        this.imageAngle = paramJSONObject.getInt("imageangle");
        label219:
        this.live_angle = paramJSONObject.optInt("live_angle", 21);
        try
        {
          this.mToolsTitleList = paramJSONObject.optJSONArray("tools_title");
          this.mToolsList = paramJSONObject.optJSONArray("tools");
          label251:
          this.zzbIntroList = paramJSONObject.optJSONArray("zzb_intro_list");
          if ((this.zzbIntroList != null) && (this.zzbIntroList.length() > 0))
          {
            this.zzbIntroItemlist = new ArrayList();
            while (i < this.zzbIntroList.length())
            {
              ZzbIntroItem localZzbIntroItem = new ZzbIntroItem(this.zzbIntroList.getJSONObject(i));
              this.zzbIntroItemlist.add(localZzbIntroItem);
              i += 1;
            }
          }
          this.uploadDeviceInfoInt = paramJSONObject.optInt("collect_device_info");
          this.useFaceStart = paramJSONObject.optInt("use_face_start");
          this.useFaceChpwd = paramJSONObject.optInt("use_face_chpwd");
          this.useFaceChmobile = paramJSONObject.optInt("use_face_chmobile");
          for (;;)
          {
            try
            {
              this.logLevel = paramJSONObject.optInt("log_level");
              switch (this.logLevel)
              {
              case 0: 
                dx.a(48);
              }
            }
            catch (Exception paramJSONObject)
            {
              paramJSONObject.printStackTrace();
              return;
            }
            try
            {
              this.uploadDate = paramJSONObject.getInt("upload_date");
              if (this.uploadDate >= 0)
              {
                i.b("debug.file.uploadfiledate", this.uploadDate).commit();
                g.a("log file upload date=" + this.uploadDate);
                paramJSONObject = new File(dx.b(), "upload.file");
                if (paramJSONObject.exists()) {
                  e.a(paramJSONObject);
                }
              }
              return;
            }
            catch (Exception paramJSONObject)
            {
              paramJSONObject.printStackTrace();
              return;
            }
            dx.a(63);
            continue;
            dx.a(60);
            continue;
            dx.a(48);
          }
        }
        catch (Exception localException1)
        {
          break label251;
        }
      }
      catch (Exception localException2)
      {
        break label219;
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.ConfigResult
 * JD-Core Version:    0.7.0.1
 */