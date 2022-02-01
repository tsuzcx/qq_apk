package dov.com.qq.im.capture.data;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import axov;
import axpn;
import axpp;
import axpr;
import axpv;
import axpw;
import axqj;
import ayva;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class QIMFilterCategoryItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<QIMFilterCategoryItem> CREATOR = new axqj();
  public JSONArray V;
  public JSONArray W;
  public JSONArray X;
  public JSONArray Y;
  public String aBF;
  public String cVL = "";
  public int categoryId;
  public String categoryName;
  public String ceV;
  public String desc = "";
  public boolean dwd;
  public int eGG = 0;
  public String iconUrl;
  public String id;
  public String name;
  public int sourceType;
  public String type;
  public ArrayList<String> za = new ArrayList();
  
  public QIMFilterCategoryItem() {}
  
  public QIMFilterCategoryItem(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.ceV = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.categoryId = paramParcel.readInt();
    this.categoryName = paramParcel.readString();
    this.za = paramParcel.createStringArrayList();
    paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.dwd = bool;
    this.aBF = paramParcel.readString();
    this.desc = paramParcel.readString();
  }
  
  public static boolean b(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.za.iterator();
    while (paramQIMFilterCategoryItem.hasNext())
    {
      Object localObject = (String)paramQIMFilterCategoryItem.next();
      localObject = ayva.a().a((String)localObject);
      if ((localObject != null) && (((FilterDesc)localObject).id == 9)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean c(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (Build.VERSION.SDK_INT == 18)
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.za.iterator();
      while (paramQIMFilterCategoryItem.hasNext())
      {
        Object localObject = (String)paramQIMFilterCategoryItem.next();
        localObject = ayva.a().a((String)localObject);
        if ((localObject != null) && (((FilterDesc)localObject).id == 1011)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public QIMFilterCategoryItem a()
  {
    try
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)super.clone();
      return localQIMFilterCategoryItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean aPy()
  {
    Iterator localIterator = this.za.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = axpv.jm;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(str)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public boolean aPz()
  {
    if (this.dwd) {}
    while ((this.za == null) || (this.za.size() != 1)) {
      return false;
    }
    if (QQAVImageFilterConstants.getFilterType(ayva.a().a((String)this.za.get(0)).id) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean auG()
  {
    return (this.za != null) && (this.za.contains("EMPTY"));
  }
  
  public JSONObject convertToJSON()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.id);
      localJSONObject.put("name", this.name);
      localJSONObject.put("camera", this.ceV);
      localJSONObject.put("iconUrl", this.iconUrl);
      localJSONObject.put("categoryId", this.categoryId);
      localJSONObject.put("categoryName", this.categoryName);
      if ((this.za != null) && (!this.za.isEmpty()))
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.za.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put((String)localIterator.next());
        }
        localJSONObject.put("filterIds", localJSONArray);
      }
      localJSONObject.put("isCombo", this.dwd);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.hashCode() != hashCode()) {
      return false;
    }
    return true;
  }
  
  public int getFilterId()
  {
    int i = -1;
    Iterator localIterator = ((axpr)axov.a(5)).a(this).FV.iterator();
    if (localIterator.hasNext())
    {
      axpn localaxpn = (axpn)localIterator.next();
      if (!(localaxpn instanceof axpp)) {
        break label93;
      }
      i = ((axpp)localaxpn).d.id;
    }
    label93:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("FilterCategoryItem", 2, "getFilterId=" + i);
      }
      return i;
    }
  }
  
  public int hashCode()
  {
    return this.id.intern().hashCode();
  }
  
  public boolean isDovItem()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.aBF))
    {
      bool1 = bool2;
      if (this.aBF.startsWith("qim")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isEmptyFilter()
  {
    return (this.za != null) && ((this.za.contains("EMPTY")) || (this.za.contains("EMPTY2")));
  }
  
  public boolean isWsBanner()
  {
    return ("2".equals(this.type)) || ("3".equals(this.type));
  }
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", isCombo=" + this.dwd + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.ceV);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.categoryId);
    paramParcel.writeString(this.categoryName);
    paramParcel.writeStringList(this.za);
    paramParcel.writeInt(0);
    if (this.dwd) {
      paramInt = 1;
    }
    paramParcel.writeByte((byte)paramInt);
    paramParcel.writeString(this.aBF);
    paramParcel.writeString(this.desc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.QIMFilterCategoryItem
 * JD-Core Version:    0.7.0.1
 */