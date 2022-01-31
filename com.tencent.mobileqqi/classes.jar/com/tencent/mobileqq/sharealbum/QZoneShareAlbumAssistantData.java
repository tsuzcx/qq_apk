package com.tencent.mobileqq.sharealbum;

import ShareAlbumHelperProtocol.GetMyAlbumListRsp;
import ShareAlbumHelperProtocol.GetMyAlbumListRspAlbumBase;
import ShareAlbumHelperProtocol.GetMyAlbumListRspAlbumExt;
import ShareAlbumHelperProtocol.GetMyAlbumListRspFeed;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QZoneShareAlbumAssistantData
  extends Entity
{
  private static final String TAG = "ShareAlbumAssistantData";
  public QZoneShareAlbumAssistantData.MyAlbumListRspFeed lastFeed;
  public long lastmsgtime;
  public List myAlbumNames = new ArrayList();
  public HashMap myExtList = new HashMap();
  public HashMap mybaseList = new HashMap();
  public String showText;
  public long showTime;
  public int showUnread;
  @unique
  public String uin;
  
  public QZoneShareAlbumAssistantData(String paramString)
  {
    this.uin = paramString;
  }
  
  private void decodeAlbumBase(GetMyAlbumListRsp paramGetMyAlbumListRsp)
  {
    if ((paramGetMyAlbumListRsp.update_album_bases != null) && (paramGetMyAlbumListRsp.update_album_bases.size() > 0))
    {
      paramGetMyAlbumListRsp = paramGetMyAlbumListRsp.update_album_bases.iterator();
      while (paramGetMyAlbumListRsp.hasNext())
      {
        Object localObject = (GetMyAlbumListRspAlbumBase)paramGetMyAlbumListRsp.next();
        QZoneShareAlbumAssistantData.MyAlbumListRspAlbumBase localMyAlbumListRspAlbumBase = new QZoneShareAlbumAssistantData.MyAlbumListRspAlbumBase(this);
        localMyAlbumListRspAlbumBase.jdField_a_of_type_JavaLangString = ((GetMyAlbumListRspAlbumBase)localObject).id;
        localMyAlbumListRspAlbumBase.jdField_b_of_type_JavaLangString = ((GetMyAlbumListRspAlbumBase)localObject).name;
        localMyAlbumListRspAlbumBase.c = ((GetMyAlbumListRspAlbumBase)localObject).cover_image;
        localMyAlbumListRspAlbumBase.d = "";
        localMyAlbumListRspAlbumBase.jdField_a_of_type_Int = ((int)((GetMyAlbumListRspAlbumBase)localObject).user_total);
        int i;
        StringBuilder localStringBuilder;
        int j;
        if (((GetMyAlbumListRspAlbumBase)localObject).users != null)
        {
          i = ((GetMyAlbumListRspAlbumBase)localObject).users.size();
          localStringBuilder = new StringBuilder();
          if (((GetMyAlbumListRspAlbumBase)localObject).users != null)
          {
            localObject = ((GetMyAlbumListRspAlbumBase)localObject).users.iterator();
            j = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label225;
            }
            Long localLong = (Long)((Iterator)localObject).next();
            j += 1;
            if (j == i)
            {
              localStringBuilder.append(localLong);
              continue;
              i = 0;
              break;
            }
            localStringBuilder.append(localLong + ";");
          }
          label225:
          localMyAlbumListRspAlbumBase.d = localStringBuilder.toString();
        }
        if (!TextUtils.isEmpty(localMyAlbumListRspAlbumBase.jdField_a_of_type_JavaLangString)) {
          this.mybaseList.put(localMyAlbumListRspAlbumBase.jdField_a_of_type_JavaLangString, localMyAlbumListRspAlbumBase);
        }
      }
    }
  }
  
  private void decodeAlbumExt(GetMyAlbumListRsp paramGetMyAlbumListRsp)
  {
    if ((paramGetMyAlbumListRsp.update_album_exts != null) && (paramGetMyAlbumListRsp.update_album_exts.size() > 0))
    {
      paramGetMyAlbumListRsp = paramGetMyAlbumListRsp.update_album_exts.iterator();
      while (paramGetMyAlbumListRsp.hasNext())
      {
        GetMyAlbumListRspAlbumExt localGetMyAlbumListRspAlbumExt = (GetMyAlbumListRspAlbumExt)paramGetMyAlbumListRsp.next();
        QZoneShareAlbumAssistantData.MyAlbumListRspAlbumExt localMyAlbumListRspAlbumExt = new QZoneShareAlbumAssistantData.MyAlbumListRspAlbumExt(this);
        localMyAlbumListRspAlbumExt.jdField_a_of_type_JavaLangString = localGetMyAlbumListRspAlbumExt.id;
        localMyAlbumListRspAlbumExt.jdField_a_of_type_Boolean = localGetMyAlbumListRspAlbumExt.is_unread_album;
        localMyAlbumListRspAlbumExt.jdField_b_of_type_JavaLangString = localGetMyAlbumListRspAlbumExt.last_feed;
        localMyAlbumListRspAlbumExt.jdField_b_of_type_Long = localGetMyAlbumListRspAlbumExt.last_time;
        localMyAlbumListRspAlbumExt.jdField_a_of_type_Long = localGetMyAlbumListRspAlbumExt.unread;
        if (!TextUtils.isEmpty(localMyAlbumListRspAlbumExt.jdField_a_of_type_JavaLangString)) {
          this.myExtList.put(localMyAlbumListRspAlbumExt.jdField_a_of_type_JavaLangString, localMyAlbumListRspAlbumExt);
        }
      }
    }
  }
  
  private void decodeAlbumLastFeed(GetMyAlbumListRsp paramGetMyAlbumListRsp)
  {
    if (this.lastFeed == null) {
      this.lastFeed = new QZoneShareAlbumAssistantData.MyAlbumListRspFeed(this);
    }
    if ((paramGetMyAlbumListRsp != null) && (paramGetMyAlbumListRsp.last_feed != null) && (paramGetMyAlbumListRsp.last_feed.last_time > 0L))
    {
      this.lastFeed.jdField_a_of_type_JavaLangString = paramGetMyAlbumListRsp.last_feed.desc;
      this.lastFeed.jdField_a_of_type_Long = paramGetMyAlbumListRsp.last_feed.last_time;
    }
  }
  
  private void decodeAlbumNames(GetMyAlbumListRsp paramGetMyAlbumListRsp)
  {
    if ((paramGetMyAlbumListRsp.album_ids != null) && (paramGetMyAlbumListRsp.album_ids.size() > 0))
    {
      this.myAlbumNames.clear();
      paramGetMyAlbumListRsp = paramGetMyAlbumListRsp.album_ids.iterator();
      while (paramGetMyAlbumListRsp.hasNext())
      {
        String str = (String)paramGetMyAlbumListRsp.next();
        this.myAlbumNames.add(str);
      }
    }
  }
  
  public void addPushAlbumID(String paramString)
  {
    if (this.myAlbumNames != null)
    {
      this.myAlbumNames.remove(paramString);
      this.myAlbumNames.add(paramString);
    }
  }
  
  public void decodeRsp(GetMyAlbumListRsp paramGetMyAlbumListRsp)
  {
    if (paramGetMyAlbumListRsp != null)
    {
      this.myAlbumNames.clear();
      decodeAlbumBase(paramGetMyAlbumListRsp);
      decodeAlbumExt(paramGetMyAlbumListRsp);
      decodeAlbumNames(paramGetMyAlbumListRsp);
      decodeAlbumLastFeed(paramGetMyAlbumListRsp);
      this.lastmsgtime = paramGetMyAlbumListRsp.last_visit_time;
      filter();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ShareAlbumAssistantData", 2, "ShareAlbum decode rsp null");
  }
  
  public void ensusureLocalName(Map paramMap)
  {
    if ((this.myAlbumNames != null) && (this.myAlbumNames.size() > 0)) {
      return;
    }
    if (this.myAlbumNames == null) {
      this.myAlbumNames = new ArrayList();
    }
    this.myAlbumNames.clear();
    this.myAlbumNames.addAll(paramMap.keySet());
  }
  
  public void filter()
  {
    if (this.lastFeed != null)
    {
      this.showTime = this.lastFeed.jdField_a_of_type_Long;
      this.showText = this.lastFeed.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("ShareAlbumAssistantData", 2, "ShareAlbum showTime:" + this.showTime + " showtext:" + this.showText + "showUnread" + this.showUnread);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ShareAlbumAssistantData", 2, "ShareAlbum lastFeed null");
  }
  
  public List getAlbumItems(Map paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.myAlbumNames != null) && (this.myAlbumNames.size() > 0))
    {
      Iterator localIterator = this.myAlbumNames.iterator();
      while (localIterator.hasNext())
      {
        QZoneShareAlbumAssistantItemData localQZoneShareAlbumAssistantItemData = (QZoneShareAlbumAssistantItemData)paramMap.get((String)localIterator.next());
        if (localQZoneShareAlbumAssistantItemData != null) {
          localArrayList.add(localQZoneShareAlbumAssistantItemData);
        }
      }
    }
    return localArrayList;
  }
  
  public List getAlbumRemoveItems(Map paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    int j = this.myAlbumNames.size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      localObject2 = (String)this.myAlbumNames.get(i);
      if ((this.mybaseList != null) && (this.mybaseList.containsKey(localObject2))) {
        if (!paramMap.containsKey(localObject2)) {
          break label442;
        }
      }
    }
    label433:
    label442:
    for (Object localObject1 = (QZoneShareAlbumAssistantItemData)paramMap.get(localObject2);; localObject1 = null)
    {
      if (localObject1 == null) {
        localObject1 = new QZoneShareAlbumAssistantItemData();
      }
      for (;;)
      {
        ((QZoneShareAlbumAssistantData.MyAlbumListRspAlbumBase)this.mybaseList.get(localObject2)).a((QZoneShareAlbumAssistantItemData)localObject1);
        paramMap.put(((QZoneShareAlbumAssistantItemData)localObject1).albumID, localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("ShareAlbumAssistantData", 2, "ShareAlbum add album base:" + (String)localObject2);
        }
        if ((this.myExtList != null) && (this.myExtList.containsKey(localObject2))) {
          if (!paramMap.containsKey(localObject2)) {
            break label433;
          }
        }
        for (localObject1 = (QZoneShareAlbumAssistantItemData)paramMap.get(localObject2);; localObject1 = null)
        {
          if (localObject1 == null) {
            localObject1 = new QZoneShareAlbumAssistantItemData();
          }
          for (;;)
          {
            ((QZoneShareAlbumAssistantData.MyAlbumListRspAlbumExt)this.myExtList.get(localObject2)).a((QZoneShareAlbumAssistantItemData)localObject1);
            paramMap.put(((QZoneShareAlbumAssistantItemData)localObject1).albumID, localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("ShareAlbumAssistantData", 2, "ShareAlbum add album ext:" + (String)localObject2);
            }
            i += 1;
            break;
            localObject1 = new ArrayList();
            localObject2 = new ArrayList(paramMap.keySet());
            j = ((List)localObject2).size();
            i = 0;
            while (i < j)
            {
              String str = (String)((List)localObject2).get(i);
              if ((!TextUtils.isEmpty(str)) && (this.myAlbumNames != null) && (!this.myAlbumNames.contains(str)))
              {
                paramMap.remove(str);
                ((List)localObject1).add(str);
                if (QLog.isColorLevel()) {
                  QLog.d("ShareAlbumAssistantData", 2, "ShareAlbum remove album:" + str);
                }
              }
              i += 1;
            }
            return localObject1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantData
 * JD-Core Version:    0.7.0.1
 */