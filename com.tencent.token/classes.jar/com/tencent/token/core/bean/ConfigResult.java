package com.tencent.token.core.bean;

import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import com.tencent.token.gb;
import com.tencent.token.global.e;
import com.tencent.token.utils.i;
import com.tencent.token.utils.p;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigResult
  implements Serializable
{
  private static final long serialVersionUID = 5361472330572016694L;
  public ArrayList bannerItemlist;
  public JSONArray bannerlist;
  public int displayAngle;
  public int face_algorithm;
  public ArrayList fucntionItemlist;
  public JSONArray fucntionlist;
  public int headlineVersion;
  public String headlinetip;
  public String headlineurl;
  public int imageAngle;
  public int logLevel;
  public String mActivityName;
  public String mActivityUrl;
  public int mActivityVersion;
  public FaceRecognitionParamResult mFaceRecognitionParamResult;
  public Bitmap mStartUpImg;
  public long mStartUpImgEndTime;
  public long mStartUpImgStartTime;
  public String mStartUpImgUrl;
  public String schemaKey;
  public int schemaTimeout;
  public int uploadDate;
  public int utilsShowFlag;
  
  public ConfigResult() {}
  
  public ConfigResult(JSONObject paramJSONObject)
  {
    this.mStartUpImgUrl = paramJSONObject.getString("startup_img_url");
    this.mStartUpImgStartTime = paramJSONObject.getLong("startup_img_start_time");
    this.mStartUpImgEndTime = paramJSONObject.getLong("startup_img_end_time");
    this.schemaKey = paramJSONObject.getString("schema_key");
    this.schemaTimeout = paramJSONObject.getInt("schema_timeout");
    this.utilsShowFlag = paramJSONObject.getInt("icon_show_flag");
    e.b("ConfigResult mStartUpImgUrl=" + this.mStartUpImgUrl + "mStartUpImgStartTime=" + this.mStartUpImgStartTime + "mStartUpImgEndTime=" + "schemaKey=" + this.schemaKey + "schemaTimeout=" + this.schemaTimeout);
    this.mActivityName = paramJSONObject.getString("my_activities_tip");
    this.mActivityUrl = paramJSONObject.getString("my_activities_url");
    this.mActivityVersion = paramJSONObject.getInt("my_activities_version");
    this.headlinetip = paramJSONObject.optString("headline_tip");
    this.headlineurl = paramJSONObject.optString("headline_url");
    this.headlineVersion = paramJSONObject.optInt("headline_version");
    this.mFaceRecognitionParamResult = new FaceRecognitionParamResult(paramJSONObject);
    try
    {
      this.face_algorithm = paramJSONObject.getInt("face_algorithm");
      try
      {
        this.displayAngle = paramJSONObject.getInt("displayangle");
        this.imageAngle = paramJSONObject.getInt("imageangle");
        label234:
        this.fucntionlist = paramJSONObject.optJSONArray("function_list");
        int i;
        Object localObject;
        if ((this.fucntionlist != null) && (this.fucntionlist.length() > 0))
        {
          this.fucntionItemlist = new ArrayList();
          i = 0;
          while (i < this.fucntionlist.length())
          {
            localObject = new UtilFucntionItem(this.fucntionlist.getJSONObject(i));
            this.fucntionItemlist.add(localObject);
            i += 1;
          }
        }
        this.bannerlist = paramJSONObject.optJSONArray("banner");
        if ((this.bannerlist != null) && (this.bannerlist.length() > 0))
        {
          this.bannerItemlist = new ArrayList();
          i = j;
          while (i < this.bannerlist.length())
          {
            localObject = new a(this.bannerlist.getJSONObject(i));
            this.bannerItemlist.add(localObject);
            i += 1;
          }
        }
        for (;;)
        {
          try
          {
            this.logLevel = paramJSONObject.getInt("log_level");
            switch (this.logLevel)
            {
            case 0: 
              gb.a(48);
              this.uploadDate = paramJSONObject.getInt("upload_date");
              if (this.uploadDate < 0) {
                return;
              }
              p.b("debug.file.uploadfiledate", this.uploadDate).commit();
              e.a("log file upload date=" + this.uploadDate);
              paramJSONObject = new File(gb.b(), "upload.file");
              if (!paramJSONObject.exists()) {
                return;
              }
              i.a(paramJSONObject);
              return;
            }
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return;
          }
          gb.a(63);
          continue;
          gb.a(60);
          continue;
          gb.a(48);
        }
      }
      catch (Exception localException1)
      {
        break label234;
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.ConfigResult
 * JD-Core Version:    0.7.0.1
 */