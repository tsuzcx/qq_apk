package dov.com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aywu;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FilterCategory
  implements Parcelable
{
  public static final Parcelable.Creator<FilterCategory> CREATOR = new aywu();
  public List<FilterCategoryItem> Fv;
  public int categoryId;
  public String categoryName;
  
  public FilterCategory(Parcel paramParcel)
  {
    this.categoryId = paramParcel.readInt();
    this.categoryName = paramParcel.readString();
    this.Fv = paramParcel.createTypedArrayList(FilterCategoryItem.CREATOR);
  }
  
  public FilterCategory(JSONObject paramJSONObject, CaptureRedDotConfig paramCaptureRedDotConfig)
    throws JSONException
  {
    this.categoryName = paramJSONObject.optString("name");
    this.categoryId = paramJSONObject.optInt("categoryId");
    Object localObject1 = null;
    int i;
    boolean bool;
    Object localObject2;
    if (paramCaptureRedDotConfig != null)
    {
      i = paramJSONObject.optInt("redDotVersion");
      bool = paramJSONObject.optBoolean("needRedDot");
      localObject2 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(this.categoryId));
      if (localObject2 == null) {
        break label434;
      }
      localObject1 = localObject2;
      if (((CaptureRedDotConfig.CategoryRedConfig)localObject2).version != i)
      {
        ((CaptureRedDotConfig.CategoryRedConfig)localObject2).version = i;
        ((CaptureRedDotConfig.CategoryRedConfig)localObject2).showRedDot = bool;
        ((CaptureRedDotConfig.CategoryRedConfig)localObject2).hasShow = false;
        ((CaptureRedDotConfig.CategoryRedConfig)localObject2).firstShowTime = 0L;
        localObject1 = localObject2;
      }
    }
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      localObject2 = new ArrayList();
      int k = paramJSONObject.length();
      i = 0;
      label145:
      if (i < k)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        FilterCategoryItem localFilterCategoryItem = new FilterCategoryItem();
        localFilterCategoryItem.iconUrl = localJSONObject.optString("iconUrl");
        localFilterCategoryItem.name = localJSONObject.optString("name");
        localFilterCategoryItem.id = localJSONObject.optString("id");
        localFilterCategoryItem.categoryId = this.categoryId;
        localFilterCategoryItem.bYY = localJSONObject.optString("englishName");
        localFilterCategoryItem.bYZ = localJSONObject.optString("usedPeople");
        localFilterCategoryItem.advertisement = localJSONObject.optBoolean("advertisement");
        if (localFilterCategoryItem.advertisement) {
          QLog.d("FilterCategory", 2, "item.advertisement is true name is:" + localFilterCategoryItem.name);
        }
        for (;;)
        {
          try
          {
            localFilterCategoryItem.badgeurl = localJSONObject.optString("badgeurl");
            localFilterCategoryItem.openurl = localJSONObject.optString("openurl");
            localFilterCategoryItem.androidopenurlheader = localJSONObject.optString("androidopenurlheader");
            localFilterCategoryItem.storeurl = localJSONObject.optString("storeurl");
            localFilterCategoryItem.popup = localJSONObject.optBoolean("popup");
            localFilterCategoryItem.popupbtn = localJSONObject.optString("popupbtn");
            localFilterCategoryItem.popupcontent = localJSONObject.optString("popupcontent");
            localFilterCategoryItem.popupbtn2 = localJSONObject.optString("popupbtn2");
            localFilterCategoryItem.popupcontent2 = localJSONObject.optString("popupcontent2");
            localFilterCategoryItem.popupimgurl = localJSONObject.optString("popupimgurl");
            localFilterCategoryItem.buttonbgcolor = localJSONObject.optString("buttonbgcolor");
            ((List)localObject2).add(localFilterCategoryItem);
            i += 1;
            break label145;
            label434:
            localObject1 = new CaptureRedDotConfig.CategoryRedConfig();
            ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = this.categoryId;
            ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = i;
            ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
          }
          catch (Exception localException)
          {
            QLog.e("FilterCategory", 2, "item.advertisement is true has Exception", localException);
            continue;
          }
          Object localObject3 = localException.optJSONArray("filters");
          if (localObject3 != null)
          {
            int j = 0;
            int m = ((JSONArray)localObject3).length();
            while (j < m)
            {
              String str = ((JSONArray)localObject3).getJSONObject(j).optString("name");
              if (!TextUtils.isEmpty(str)) {
                localFilterCategoryItem.za.add(str);
              }
              j += 1;
            }
          }
          localObject3 = localFilterCategoryItem.a();
          if ((localObject3 == null) || (((FilterDesc)localObject3).type != 1) || (QmcfManager.getInstance().hasQmcfEntrance(1))) {}
        }
      }
      this.Fv = ((List)localObject2);
      if ((paramCaptureRedDotConfig != null) && (localObject1 != null)) {
        paramCaptureRedDotConfig.categories.put(Integer.valueOf(((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.data.FilterCategory
 * JD-Core Version:    0.7.0.1
 */