package com.tencent.token.core.bean;

import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import com.tencent.token.aaa;
import com.tencent.token.abk;
import com.tencent.token.xb;
import com.tencent.token.zx;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigResult
  implements Serializable
{
  private static final long serialVersionUID = 5361472330572016694L;
  public int displayAngle;
  public int face_algorithm;
  public int imageAngle;
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
  public int uploadDeviceInfoInt;
  public int useFaceChmobile;
  public int useFaceChpwd;
  public int useFaceStart;
  public int utilsShowFlag;
  public ArrayList<ZzbIntroItem> zzbIntroItemlist;
  public JSONArray zzbIntroList;
  
  public ConfigResult()
  {
    this.uploadDeviceInfoInt = 0;
    this.useFaceStart = 0;
    this.useFaceChpwd = 0;
    this.useFaceChmobile = 0;
    this.displayAngle = -1;
    this.imageAngle = -1;
  }
  
  public ConfigResult(JSONObject paramJSONObject)
  {
    int i = 0;
    this.uploadDeviceInfoInt = 0;
    this.useFaceStart = 0;
    this.useFaceChpwd = 0;
    this.useFaceChmobile = 0;
    this.displayAngle = -1;
    this.imageAngle = -1;
    this.mStartUpImgUrl = paramJSONObject.getString("startup_img_url");
    this.mStartUpImgStartTime = paramJSONObject.getLong("startup_img_start_time");
    this.mStartUpImgEndTime = paramJSONObject.getLong("startup_img_end_time");
    this.schemaKey = paramJSONObject.getString("schema_key");
    this.schemaTimeout = paramJSONObject.getInt("schema_timeout");
    this.utilsShowFlag = paramJSONObject.getInt("icon_show_flag");
    Object localObject = new StringBuilder("ConfigResult mStartUpImgUrl=");
    ((StringBuilder)localObject).append(this.mStartUpImgUrl);
    ((StringBuilder)localObject).append("mStartUpImgStartTime=");
    ((StringBuilder)localObject).append(this.mStartUpImgStartTime);
    ((StringBuilder)localObject).append("mStartUpImgEndTime=schemaKey=");
    ((StringBuilder)localObject).append(this.schemaKey);
    ((StringBuilder)localObject).append("schemaTimeout=");
    ((StringBuilder)localObject).append(this.schemaTimeout);
    xb.b(((StringBuilder)localObject).toString());
    this.so_param_ids = paramJSONObject.optString("so_param_ids");
    this.so_param_values = paramJSONObject.optString("so_param_values");
    this.mFaceRecognitionParamResult = new FaceRecognitionParamResult(paramJSONObject);
    try
    {
      this.face_algorithm = paramJSONObject.getInt("face_algorithm");
    }
    catch (Exception localException2)
    {
      try
      {
        this.displayAngle = paramJSONObject.getInt("displayangle");
        this.imageAngle = paramJSONObject.getInt("imageangle");
        this.live_angle = paramJSONObject.optInt("live_angle", 21);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.mToolsTitleList = paramJSONObject.optJSONArray("tools_title");
            this.mToolsList = paramJSONObject.optJSONArray("tools");
            this.zzbIntroList = paramJSONObject.optJSONArray("zzb_intro_list");
            localObject = this.zzbIntroList;
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              this.zzbIntroItemlist = new ArrayList();
              while (i < this.zzbIntroList.length())
              {
                localObject = new ZzbIntroItem(this.zzbIntroList.getJSONObject(i));
                this.zzbIntroItemlist.add(localObject);
                i += 1;
              }
            }
            this.uploadDeviceInfoInt = paramJSONObject.optInt("collect_device_info");
            this.useFaceStart = paramJSONObject.optInt("use_face_start");
            this.useFaceChpwd = paramJSONObject.optInt("use_face_chpwd");
            this.useFaceChmobile = paramJSONObject.optInt("use_face_chmobile");
            try
            {
              this.logLevel = paramJSONObject.optInt("log_level");
              switch (this.logLevel)
              {
              case 2: 
                abk.a(48);
                break;
                abk.a(48);
                break;
              case 1: 
                abk.a(60);
                break;
              case 0: 
                abk.a(63);
                try
                {
                  if (paramJSONObject.has("upload_date")) {
                    this.uploadDate = paramJSONObject.getInt("upload_date");
                  }
                  if (this.uploadDate >= 0)
                  {
                    aaa.b("debug.file.uploadfiledate", this.uploadDate).commit();
                    paramJSONObject = new StringBuilder("log file upload date=");
                    paramJSONObject.append(this.uploadDate);
                    xb.a(paramJSONObject.toString());
                    paramJSONObject = new File(abk.b(), "upload.file");
                    if (paramJSONObject.exists()) {
                      zx.a(paramJSONObject);
                    }
                  }
                  return;
                }
                catch (Exception paramJSONObject)
                {
                  paramJSONObject.printStackTrace();
                  return;
                }
                localException1 = localException1;
              }
            }
            catch (Exception paramJSONObject)
            {
              paramJSONObject.printStackTrace();
              return;
            }
          }
          localException2 = localException2;
        }
        catch (Exception localException3)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.ConfigResult
 * JD-Core Version:    0.7.0.1
 */