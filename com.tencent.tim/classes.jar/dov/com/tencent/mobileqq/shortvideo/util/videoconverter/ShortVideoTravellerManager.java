package dov.com.tencent.mobileqq.shortvideo.util.videoconverter;

import aasa;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aqmj;
import azci;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShortVideoTravellerManager
  implements Manager
{
  public static final String cYv = aasa.SDCARD_ROOT + "/tencent/qim/travellervideos/";
  Bundle bR;
  WeakReference<MessengerService> cg;
  AtomicBoolean eU;
  private EntityManager em;
  private QQAppInterface mApp;
  private Object mLock;
  ArrayList<TravellerVideoItem> mS;
  
  private void oX(List<TravellerVideoItem> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoTravellerManager", 2, "saveVideoListToDB al not correct");
      }
    }
    do
    {
      return;
      this.em.drop(TravellerVideoItem.class);
      EntityTransaction localEntityTransaction = this.em.getTransaction();
      try
      {
        localEntityTransaction.begin();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TravellerVideoItem localTravellerVideoItem = (TravellerVideoItem)paramList.next();
          this.em.persistOrReplace(localTravellerVideoItem);
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
      localEntityTransaction.end();
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoTravellerManager", 2, "saveVideoListToDB");
  }
  
  void a(ArrayList<TravellerVideoItem> paramArrayList, Bundle paramBundle)
  {
    MessengerService localMessengerService = (MessengerService)this.cg.get();
    if ((localMessengerService != null) && (paramBundle != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("getDemoVideoList", paramArrayList);
      paramBundle.putBundle("response", localBundle);
      localMessengerService.cp(paramBundle);
    }
  }
  
  public void ho(String paramString, int paramInt)
  {
    synchronized (this.mLock)
    {
      if (this.mS == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoTravellerManager", 2, "parseTravellerConfig mJsonList is null");
        }
        return;
      }
    }
    try
    {
      localObject2 = new JSONObject(paramString);
      if ((localObject2 == null) || (!((JSONObject)localObject2).has("videos"))) {
        break label208;
      }
      localObject2 = ((JSONObject)localObject2).getJSONArray("videos");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoTravellerManager", 2, "parseTravellerConfig array not correct");
        }
        return;
        paramString = finally;
        throw paramString;
      }
      aqmj.g(this.mApp.getApp(), paramInt, this.mApp.getCurrentAccountUin(), paramString);
      if (this.mS.size() > 0) {
        this.mS.clear();
      }
      i = ((JSONArray)localObject2).length();
      paramInt = 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Object localObject2;
        int i;
        label208:
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoTravellerManager", 2, "parseTravellerConfig is wrong");
        }
        paramString.printStackTrace();
        continue;
        paramInt += 1;
      }
    }
    if (paramInt < i)
    {
      paramString = new TravellerVideoItem(((JSONArray)localObject2).getJSONObject(paramInt));
      if ((paramString.video_id != -1) && (!paramString.url.equals(""))) {
        this.mS.add(paramString);
      }
    }
    else
    {
      oX(this.mS);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public static class TravellerVideoItem
    extends Entity
    implements Parcelable
  {
    public static final Parcelable.Creator<TravellerVideoItem> CREATOR = new azci();
    public static final String TRAVELLER_PROVIDER_CATEGORY = "category";
    public static final String TRAVELLER_PROVIDER_ITEM_ID = "item_id";
    public static final String TRAVELLER_PROVIDER_TYPE = "type";
    public static final String TRAVELLER_VIDEO_ID = "video_id";
    public static final String TRAVELLER_VIDEO_LIST = "videos";
    public static final String TRAVELLER_VIDEO_MD5 = "md5";
    public static final String TRAVELLER_VIDEO_PLACE = "name";
    public static final String TRAVELLER_VIDEO_URL = "url";
    public int category;
    public String item_id;
    public String md5;
    public String name;
    public String path;
    public int type = 100;
    public String url = "";
    public int video_id = -1;
    
    public TravellerVideoItem() {}
    
    public TravellerVideoItem(Parcel paramParcel)
    {
      this.video_id = paramParcel.readInt();
      this.url = paramParcel.readString();
      this.md5 = paramParcel.readString();
      this.name = paramParcel.readString();
      this.type = paramParcel.readInt();
      this.category = paramParcel.readInt();
      this.item_id = paramParcel.readString();
      this.path = paramParcel.readString();
    }
    
    public TravellerVideoItem(JSONObject paramJSONObject)
    {
      if (paramJSONObject.has("video_id")) {
        this.video_id = paramJSONObject.optInt("video_id", -1);
      }
      if (paramJSONObject.has("url")) {
        this.url = paramJSONObject.optString("url", "");
      }
      if (paramJSONObject.has("md5")) {
        this.md5 = paramJSONObject.optString("md5", "");
      }
      if (paramJSONObject.has("name")) {
        this.name = paramJSONObject.optString("name", "");
      }
      if (paramJSONObject.has("type")) {
        this.type = paramJSONObject.optInt("type", -1);
      }
      if (paramJSONObject.has("category")) {
        this.category = paramJSONObject.optInt("category", -1);
      }
      if (paramJSONObject.has("item_id")) {
        this.item_id = paramJSONObject.optString("item_id", "");
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("TravellerVideoItem{");
      localStringBuilder.append("video_id=").append(this.video_id);
      localStringBuilder.append(", url='").append(this.url).append('\'');
      localStringBuilder.append(", md5='").append(this.md5).append('\'');
      localStringBuilder.append(", name='").append(this.name).append('\'');
      localStringBuilder.append(", type=").append(this.type);
      localStringBuilder.append(", category=").append(this.category);
      localStringBuilder.append(", item_id='").append(this.item_id).append('\'');
      localStringBuilder.append(", path='").append(this.path).append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.video_id);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.name);
      paramParcel.writeInt(this.type);
      paramParcel.writeInt(this.category);
      paramParcel.writeString(this.item_id);
      paramParcel.writeString(this.path);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.videoconverter.ShortVideoTravellerManager
 * JD-Core Version:    0.7.0.1
 */