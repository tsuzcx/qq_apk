package dov.com.qq.im.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import axqe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FilterCategory
  implements Parcelable
{
  public static final Parcelable.Creator<FilterCategory> CREATOR = new axqe();
  public List<QIMFilterCategoryItem> Fv;
  public int categoryId;
  public String categoryName;
  public boolean dvZ;
  public boolean dwa;
  public int eGF = 0;
  public int mSourceType = 0;
  
  public FilterCategory(int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.categoryId = paramInt1;
    this.categoryName = paramString;
    this.Fv = new ArrayList();
    this.dvZ = paramBoolean1;
    this.dwa = paramBoolean2;
    this.eGF = paramInt2;
    this.mSourceType = paramInt3;
  }
  
  public FilterCategory(Parcel paramParcel)
  {
    this.categoryId = paramParcel.readInt();
    this.categoryName = paramParcel.readString();
    this.Fv = paramParcel.createTypedArrayList(QIMFilterCategoryItem.CREATOR);
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.dvZ = bool;
  }
  
  public FilterCategory(JSONObject paramJSONObject, QIMRedDotConfig paramQIMRedDotConfig)
    throws JSONException
  {
    this.categoryName = paramJSONObject.optString("name");
    this.categoryId = paramJSONObject.optInt("categoryId");
    this.dwa = "1".equals(paramJSONObject.optString("random_position", "0"));
    this.eGF = paramJSONObject.optInt("hide_mask", 0);
    this.mSourceType = paramJSONObject.optInt("source_type", 0);
    Object localObject1 = null;
    int i;
    boolean bool;
    Object localObject2;
    if (paramQIMRedDotConfig != null)
    {
      i = paramJSONObject.optInt("redDotVersion");
      bool = paramJSONObject.optBoolean("needRedDot");
      localObject2 = (QIMRedDotConfig.CategoryRedConfig)paramQIMRedDotConfig.categories.get(Integer.valueOf(this.categoryId));
      if (localObject2 == null) {
        break label395;
      }
      localObject1 = localObject2;
      if (((QIMRedDotConfig.CategoryRedConfig)localObject2).version != i)
      {
        ((QIMRedDotConfig.CategoryRedConfig)localObject2).version = i;
        ((QIMRedDotConfig.CategoryRedConfig)localObject2).showRedDot = bool;
        ((QIMRedDotConfig.CategoryRedConfig)localObject2).hasShow = false;
        ((QIMRedDotConfig.CategoryRedConfig)localObject2).firstShowTime = 0L;
        localObject1 = localObject2;
      }
    }
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      localObject2 = new ArrayList();
      int k = paramJSONObject.length();
      i = 0;
      bool = false;
      if (i < k)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        QIMFilterCategoryItem localQIMFilterCategoryItem = new QIMFilterCategoryItem();
        localQIMFilterCategoryItem.iconUrl = localJSONObject.optString("iconUrl");
        localQIMFilterCategoryItem.name = localJSONObject.optString("name");
        localQIMFilterCategoryItem.ceV = localJSONObject.optString("camera");
        localQIMFilterCategoryItem.id = localJSONObject.optString("id");
        localQIMFilterCategoryItem.type = localJSONObject.optString("type_combo");
        localQIMFilterCategoryItem.categoryId = this.categoryId;
        localQIMFilterCategoryItem.categoryName = this.categoryName;
        localQIMFilterCategoryItem.sourceType = this.mSourceType;
        localQIMFilterCategoryItem.aBF = localJSONObject.optString("jump_app");
        JSONArray localJSONArray = localJSONObject.optJSONArray("filters");
        label395:
        if (localJSONArray != null)
        {
          int j = 0;
          int m = localJSONArray.length();
          label342:
          if (j < m)
          {
            Object localObject3 = localJSONArray.getJSONObject(j);
            String str = ((JSONObject)localObject3).optString("name");
            if (!TextUtils.isEmpty(str)) {
              localQIMFilterCategoryItem.za.add(str);
            }
            for (;;)
            {
              j += 1;
              break label342;
              localObject1 = new QIMRedDotConfig.CategoryRedConfig();
              ((QIMRedDotConfig.CategoryRedConfig)localObject1).categoryId = this.categoryId;
              ((QIMRedDotConfig.CategoryRedConfig)localObject1).version = i;
              ((QIMRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
              break;
              localObject3 = ((JSONObject)localObject3).optString("name_android");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localQIMFilterCategoryItem.za.add(localObject3);
              }
            }
          }
        }
        localQIMFilterCategoryItem.V = localJSONObject.optJSONArray("pasters");
        localQIMFilterCategoryItem.W = localJSONObject.optJSONArray("musics");
        localQIMFilterCategoryItem.X = localJSONObject.optJSONArray("ufaces");
        localQIMFilterCategoryItem.Y = localJSONObject.optJSONArray("texts");
        localQIMFilterCategoryItem.desc = localJSONObject.optString("desc", "");
        if (((localQIMFilterCategoryItem.V == null) || (localQIMFilterCategoryItem.V.length() == 0)) && ((localQIMFilterCategoryItem.W == null) || (localQIMFilterCategoryItem.W.length() == 0)) && ((localQIMFilterCategoryItem.X == null) || (localQIMFilterCategoryItem.X.length() == 0))) {
          localQIMFilterCategoryItem.dwd = false;
        }
        for (;;)
        {
          ((List)localObject2).add(localQIMFilterCategoryItem);
          i += 1;
          break;
          localQIMFilterCategoryItem.dwd = true;
          bool = true;
        }
      }
      this.Fv = ((List)localObject2);
      if ((paramQIMRedDotConfig != null) && (localObject1 != null)) {
        paramQIMRedDotConfig.categories.put(Integer.valueOf(((QIMRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
      this.dvZ = bool;
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
 * Qualified Name:     dov.com.qq.im.capture.data.FilterCategory
 * JD-Core Version:    0.7.0.1
 */