package dov.com.qq.im.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import axpx;
import axqk;
import axte;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TemplateData
  implements Parcelable
{
  public static final Parcelable.Creator<TemplateData> CREATOR = new axqk();
  public List<QIMTemplateItem> Fv;
  public List<String> Nf;
  public List<axte> Ng;
  public String cVM;
  public int categoryId;
  public String categoryName;
  public boolean dvZ;
  public boolean dwa;
  public int eGF = 0;
  public String intro;
  
  public TemplateData(Parcel paramParcel)
  {
    this.categoryId = paramParcel.readInt();
    this.categoryName = paramParcel.readString();
    this.cVM = paramParcel.readString();
    this.Fv = paramParcel.createTypedArrayList(QIMTemplateItem.CREATOR);
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.dvZ = bool;
  }
  
  public TemplateData(JSONObject paramJSONObject)
    throws JSONException
  {
    this.categoryName = paramJSONObject.optString("name");
    this.categoryId = paramJSONObject.optInt("categoryId");
    this.cVM = paramJSONObject.optString("default_combo_id");
    this.dwa = "1".equals(paramJSONObject.optString("random_position", "0"));
    this.eGF = paramJSONObject.optInt("hide_mask", 0);
    this.intro = paramJSONObject.optString("introduction");
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      ArrayList localArrayList = new ArrayList();
      int k = paramJSONObject.length();
      int i = 0;
      for (boolean bool = false; i < k; bool = true)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        QIMTemplateItem localQIMTemplateItem = new QIMTemplateItem();
        localQIMTemplateItem.iconUrl = localJSONObject.optString("iconUrl");
        localQIMTemplateItem.name = localJSONObject.optString("name");
        localQIMTemplateItem.ceV = localJSONObject.optString("camera");
        localQIMTemplateItem.id = localJSONObject.optString("id");
        localQIMTemplateItem.type = localJSONObject.optString("type_combo");
        localQIMTemplateItem.categoryId = this.categoryId;
        localQIMTemplateItem.categoryName = this.categoryName;
        localQIMTemplateItem.coverUrl = localJSONObject.optString("cover_url");
        localQIMTemplateItem.videoUrl = localJSONObject.optString("video_url");
        localQIMTemplateItem.videoMd5 = localJSONObject.optString("video_md5");
        localQIMTemplateItem.dwu = localJSONObject.optBoolean("segments_twinkle");
        localQIMTemplateItem.localVideoPath = (axpx.cVH + localQIMTemplateItem.name + ".mp4");
        JSONArray localJSONArray = localJSONObject.optJSONArray("filters");
        if (localJSONArray != null)
        {
          int m = localJSONArray.length();
          int j = 0;
          if (j < m)
          {
            Object localObject = localJSONArray.getJSONObject(j);
            String str = ((JSONObject)localObject).optString("name");
            if (!TextUtils.isEmpty(str)) {
              localQIMTemplateItem.za.add(str);
            }
            for (;;)
            {
              j += 1;
              break;
              localObject = ((JSONObject)localObject).optString("name_android");
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                localQIMTemplateItem.za.add(localObject);
              }
            }
          }
        }
        localQIMTemplateItem.V = localJSONObject.optJSONArray("pasters");
        localQIMTemplateItem.W = localJSONObject.optJSONArray("musics");
        localQIMTemplateItem.X = localJSONObject.optJSONArray("ufaces");
        localQIMTemplateItem.Y = localJSONObject.optJSONArray("texts");
        localQIMTemplateItem.Z = localJSONObject.optJSONArray("transitions");
        localQIMTemplateItem.aa = localJSONObject.optJSONArray("interactions");
        a(localQIMTemplateItem);
        localQIMTemplateItem.dwd = true;
        localArrayList.add(localQIMTemplateItem);
        i += 1;
      }
      this.Fv = localArrayList;
      this.dvZ = bool;
    }
  }
  
  private void a(QIMTemplateItem paramQIMTemplateItem)
  {
    Object localObject1;
    if ((paramQIMTemplateItem != null) && (paramQIMTemplateItem.aa != null))
    {
      if (paramQIMTemplateItem.categoryId != 1001) {
        break label107;
      }
      localObject1 = new ArrayList();
      j = paramQIMTemplateItem.aa.length();
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          localJSONObject = paramQIMTemplateItem.aa.optJSONObject(i);
          if (localJSONObject != null) {}
          try
          {
            ((List)localObject1).add(localJSONObject.optString("question"));
            i += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              QLog.d("QTemplate", 1, "createTemplateSet exception", localException2);
            }
          }
        }
      }
      this.Nf = ((List)localObject1);
    }
    label107:
    while (paramQIMTemplateItem.categoryId != 1000)
    {
      JSONObject localJSONObject;
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramQIMTemplateItem.aa.length();
    int i = 0;
    if (i < j)
    {
      localObject1 = paramQIMTemplateItem.aa.optJSONObject(i);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        String str2 = ((JSONObject)localObject1).optString("question");
        localObject1 = ((JSONObject)localObject1).optJSONArray("options");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() != 2)) {
          break label288;
        }
        str1 = ((JSONArray)localObject1).get(0).toString();
        localObject1 = ((JSONArray)localObject1).get(1).toString();
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          localArrayList.add(new axte(str2, str1, (String)localObject1));
        }
      }
      catch (Exception localException1)
      {
        QLog.d("QTemplate", 1, "createTemplateSet exception", localException1);
        continue;
      }
      i += 1;
      break;
      this.Ng = localArrayList;
      return;
      label288:
      Object localObject2 = null;
      String str1 = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.categoryId);
    paramParcel.writeString(this.categoryName);
    paramParcel.writeString(this.cVM);
    paramParcel.writeTypedList(this.Fv);
    if (this.dvZ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.TemplateData
 * JD-Core Version:    0.7.0.1
 */