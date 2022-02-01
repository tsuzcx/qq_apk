package com.tencent.qqmail.card.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.UMA.CardData;
import com.tencent.qqmail.protocol.UMA.CardPara;
import com.tencent.qqmail.protocol.UMA.CardPicture;
import com.tencent.qqmail.protocol.UMA.FriendInfo;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.QMMath;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QMCardData
  implements Serializable
{
  private String cardCoverUrl;
  private String cardId;
  private long cardIdHash;
  private String cardMailUrl;
  private String cardOnePxUrl;
  private ArrayList<QMCardPara> cardParaList;
  private String cardThumbUrl;
  private String cardUrl;
  private boolean circlelimit;
  private int friendNum;
  private int friendType;
  private boolean isComplete;
  private String mailTitle;
  private String mailWord;
  private String name;
  private int pageType;
  private double priority;
  private boolean qqShareLimit;
  private int seqType;
  private String shareTitle;
  private String shareWord;
  private String tag;
  private int thanksCount;
  private ArrayList<QMCardFriendInfo> thanksFriendList;
  private int viewCount;
  private boolean wxShareLimit;
  
  public QMCardData() {}
  
  public QMCardData(QMCardData paramQMCardData)
  {
    this.cardId = paramQMCardData.cardId;
    this.cardIdHash = paramQMCardData.cardIdHash;
    this.name = paramQMCardData.name;
    this.cardThumbUrl = paramQMCardData.cardThumbUrl;
    this.cardMailUrl = paramQMCardData.cardMailUrl;
    this.cardCoverUrl = paramQMCardData.cardCoverUrl;
    this.cardOnePxUrl = paramQMCardData.cardOnePxUrl;
    this.cardUrl = paramQMCardData.cardUrl;
    this.viewCount = paramQMCardData.viewCount;
    this.thanksCount = paramQMCardData.thanksCount;
    this.thanksFriendList = paramQMCardData.thanksFriendList;
    this.isComplete = paramQMCardData.isComplete;
    this.cardParaList = paramQMCardData.cardParaList;
    this.priority = paramQMCardData.priority;
    this.tag = paramQMCardData.tag;
    this.mailTitle = paramQMCardData.mailTitle;
    this.mailWord = paramQMCardData.mailWord;
    this.shareTitle = paramQMCardData.shareTitle;
    this.shareWord = paramQMCardData.shareWord;
    this.circlelimit = paramQMCardData.circlelimit;
    this.pageType = paramQMCardData.pageType;
    this.friendType = paramQMCardData.friendType;
    this.friendNum = paramQMCardData.friendNum;
    this.seqType = paramQMCardData.seqType;
    this.wxShareLimit = paramQMCardData.wxShareLimit;
    this.qqShareLimit = paramQMCardData.qqShareLimit;
  }
  
  public static QMCardData parseFrom(CardData paramCardData, QMCardData paramQMCardData)
  {
    label13:
    label39:
    label59:
    Object localObject2;
    if (paramQMCardData != null)
    {
      paramQMCardData = new QMCardData(paramQMCardData);
      paramQMCardData.setCardId(paramCardData.cardid.toString());
      if (paramCardData.cardname == null) {
        break label179;
      }
      localObject1 = paramCardData.cardname.toString();
      paramQMCardData.name = ((String)localObject1);
      if (paramCardData.cardurl == null) {
        break label185;
      }
      localObject1 = paramCardData.cardurl.toString();
      paramQMCardData.cardUrl = ((String)localObject1);
      if (paramCardData.pictures == null) {
        break label213;
      }
      localObject2 = paramCardData.pictures.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label213;
      }
      CardPicture localCardPicture = (CardPicture)((Iterator)localObject2).next();
      if (localCardPicture.url != null) {}
      for (localObject1 = localCardPicture.url.toString();; localObject1 = "") {
        switch (localCardPicture.type)
        {
        default: 
          break;
        case 1: 
          paramQMCardData.cardThumbUrl = ((String)localObject1);
        case 4: 
          paramQMCardData.cardOnePxUrl = ((String)localObject1);
          break;
          paramQMCardData = new QMCardData();
          break label13;
          label179:
          localObject1 = "";
          break label39;
          label185:
          localObject1 = "";
          break label59;
        }
      }
      paramQMCardData.cardCoverUrl = ((String)localObject1);
      continue;
      paramQMCardData.cardMailUrl = ((String)localObject1);
    }
    label213:
    if (paramCardData.viewcount >= 0) {
      paramQMCardData.viewCount = paramCardData.viewcount;
    }
    if (paramCardData.thankscount >= 0) {
      paramQMCardData.thanksCount = paramCardData.thankscount;
    }
    if (paramCardData.thankslist != null)
    {
      paramQMCardData.thanksFriendList = new ArrayList(paramCardData.thankslist.size());
      localObject1 = paramCardData.thankslist.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = QMCardFriendInfo.parseFrom((FriendInfo)((Iterator)localObject1).next(), null);
        paramQMCardData.thanksFriendList.add(localObject2);
      }
    }
    paramQMCardData.isComplete = paramCardData.iscomplete;
    if (paramCardData.cardpara != null)
    {
      paramQMCardData.cardParaList = new ArrayList();
      localObject1 = paramCardData.cardpara.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CardPara)((Iterator)localObject1).next();
        localObject2 = QMCardPara.parseFrom(paramQMCardData.cardId, (CardPara)localObject2, null);
        paramQMCardData.cardParaList.add(localObject2);
      }
    }
    paramQMCardData.priority = paramCardData.priority;
    if (paramCardData.cardtag != null)
    {
      localObject1 = paramCardData.cardtag.toString();
      paramQMCardData.tag = ((String)localObject1);
      if (paramCardData.mailword == null) {
        break label558;
      }
      localObject1 = paramCardData.mailword.toString();
      label429:
      paramQMCardData.mailWord = ((String)localObject1);
      if (paramCardData.mailtitle == null) {
        break label564;
      }
      localObject1 = paramCardData.mailtitle.toString();
      label449:
      paramQMCardData.mailTitle = ((String)localObject1);
      if (paramCardData.shareword == null) {
        break label570;
      }
      localObject1 = paramCardData.shareword.toString();
      label469:
      paramQMCardData.shareWord = ((String)localObject1);
      if (paramCardData.sharetitle == null) {
        break label576;
      }
    }
    label558:
    label564:
    label570:
    label576:
    for (Object localObject1 = paramCardData.sharetitle.toString();; localObject1 = "")
    {
      paramQMCardData.shareTitle = ((String)localObject1);
      paramQMCardData.circlelimit = paramCardData.circlelimit;
      paramQMCardData.pageType = paramCardData.pagetype;
      paramQMCardData.friendType = paramCardData.friendtype;
      paramQMCardData.friendNum = paramCardData.friendnum;
      paramQMCardData.seqType = paramCardData.seqtype;
      paramQMCardData.wxShareLimit = paramCardData.wxsharelimit;
      paramQMCardData.qqShareLimit = paramCardData.qqsharelimit;
      return paramQMCardData;
      localObject1 = "";
      break;
      localObject1 = "";
      break label429;
      localObject1 = "";
      break label449;
      localObject1 = "";
      break label469;
    }
  }
  
  public String getCardCoverUrl()
  {
    return this.cardCoverUrl;
  }
  
  public String getCardId()
  {
    return this.cardId;
  }
  
  public long getCardIdHash()
  {
    return this.cardIdHash;
  }
  
  public String getCardMailUrl()
  {
    return this.cardMailUrl;
  }
  
  public String getCardOnePxUrl()
  {
    return this.cardOnePxUrl;
  }
  
  public ArrayList<QMCardPara> getCardParaList()
  {
    return this.cardParaList;
  }
  
  public String getCardThumbUrl()
  {
    return this.cardThumbUrl;
  }
  
  public String getCardUrl()
  {
    return this.cardUrl;
  }
  
  public int getFriendNum()
  {
    return this.friendNum;
  }
  
  public int getFriendType()
  {
    return this.friendType;
  }
  
  public String getMailTitle()
  {
    return this.mailTitle;
  }
  
  public String getMailWord()
  {
    return this.mailWord;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPageType()
  {
    return this.pageType;
  }
  
  public double getPriority()
  {
    return this.priority;
  }
  
  public int getSeqType()
  {
    return this.seqType;
  }
  
  public String getShareTitle()
  {
    return this.shareTitle;
  }
  
  public String getShareWord()
  {
    return this.shareWord;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public int getThanksCount()
  {
    return this.thanksCount;
  }
  
  public ArrayList<QMCardFriendInfo> getThanksFriendList()
  {
    return this.thanksFriendList;
  }
  
  public int getViewCount()
  {
    return this.viewCount;
  }
  
  public boolean isCirclelimit()
  {
    return this.circlelimit;
  }
  
  public boolean isComplete()
  {
    return this.isComplete;
  }
  
  public boolean isQqShareLimit()
  {
    return this.qqShareLimit;
  }
  
  public boolean isWxShareLimit()
  {
    return this.wxShareLimit;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    this.cardId = paramJSONObject.getString("cardId");
    Object localObject1 = paramJSONObject.getString("name");
    if (localObject1 != null) {
      this.name = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("cardThumbUrl");
    if (localObject1 != null) {
      this.cardThumbUrl = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("cardMailUrl");
    if (localObject1 != null) {
      this.cardMailUrl = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("cardCoverUrl");
    if (localObject1 != null) {
      this.cardCoverUrl = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("cardOnePxUrl");
    if (localObject1 != null) {
      this.cardOnePxUrl = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("cardUrl");
    if (localObject1 != null) {
      this.cardUrl = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getJSONArray("thanksFriendList");
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      if (this.thanksFriendList != null) {
        this.thanksFriendList.clear();
      }
      for (;;)
      {
        localObject1 = ((JSONArray)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = new QMCardFriendInfo();
          ((QMCardFriendInfo)localObject3).parseWithDictionary((JSONObject)localObject2);
          this.thanksFriendList.add(localObject3);
        }
        this.thanksFriendList = Lists.newArrayList();
      }
    }
    localObject1 = paramJSONObject.getJSONArray("cardParaList");
    if (localObject1 != null)
    {
      if (this.cardParaList != null) {
        this.cardParaList.clear();
      }
      for (;;)
      {
        localObject1 = ((JSONArray)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = new QMCardPara();
          ((QMCardPara)localObject3).parseWithDictionary((JSONObject)localObject2);
          this.cardParaList.add(localObject3);
        }
        this.cardParaList = Lists.newArrayList();
      }
    }
    localObject1 = paramJSONObject.getString("tag");
    if (localObject1 != null) {
      this.tag = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("mailTitle");
    if (localObject1 != null) {
      this.mailTitle = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("mailWord");
    if (localObject1 != null) {
      this.mailWord = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("shareTitle");
    if (localObject1 != null) {
      this.shareTitle = ((String)localObject1);
    }
    localObject1 = paramJSONObject.getString("shareWord");
    if (localObject1 != null) {
      this.shareWord = ((String)localObject1);
    }
    this.cardIdHash = paramJSONObject.getLongValue("cardIdHash");
    this.viewCount = paramJSONObject.getIntValue("viewCount");
    this.thanksCount = paramJSONObject.getIntValue("thanksCount");
    this.isComplete = paramJSONObject.getBooleanValue("isComplete");
    this.priority = paramJSONObject.getDoubleValue("priority");
    return true;
  }
  
  public void setCardCoverUrl(String paramString)
  {
    this.cardCoverUrl = paramString;
  }
  
  public void setCardId(String paramString)
  {
    this.cardId = paramString;
    this.cardIdHash = QMMath.hashPositivetInt(paramString);
  }
  
  public void setCardMailUrl(String paramString)
  {
    this.cardMailUrl = paramString;
  }
  
  public void setCardOnePxUrl(String paramString)
  {
    this.cardOnePxUrl = paramString;
  }
  
  public void setCardParaList(ArrayList<QMCardPara> paramArrayList)
  {
    this.cardParaList = paramArrayList;
  }
  
  public void setCardThumbUrl(String paramString)
  {
    this.cardThumbUrl = paramString;
  }
  
  public void setCardUrl(String paramString)
  {
    this.cardUrl = paramString;
  }
  
  public void setCirclelimit(boolean paramBoolean)
  {
    this.circlelimit = paramBoolean;
  }
  
  public void setFriendNum(int paramInt)
  {
    this.friendNum = paramInt;
  }
  
  public void setFriendType(int paramInt)
  {
    this.friendType = paramInt;
  }
  
  public void setIsComplete(boolean paramBoolean)
  {
    this.isComplete = paramBoolean;
  }
  
  public void setMailTitle(String paramString)
  {
    this.mailTitle = paramString;
  }
  
  public void setMailWord(String paramString)
  {
    this.mailWord = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPageType(int paramInt)
  {
    this.pageType = paramInt;
  }
  
  public void setPriority(double paramDouble)
  {
    this.priority = paramDouble;
  }
  
  public void setQqShareLimit(boolean paramBoolean)
  {
    this.qqShareLimit = paramBoolean;
  }
  
  public void setSeqType(int paramInt)
  {
    this.seqType = paramInt;
  }
  
  public void setShareTitle(String paramString)
  {
    this.shareTitle = paramString;
  }
  
  public void setShareWord(String paramString)
  {
    this.shareWord = paramString;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setThanksCount(int paramInt)
  {
    this.thanksCount = paramInt;
  }
  
  public void setThanksFriendList(ArrayList<QMCardFriendInfo> paramArrayList)
  {
    this.thanksFriendList = paramArrayList;
  }
  
  public void setViewCount(int paramInt)
  {
    this.viewCount = paramInt;
  }
  
  public void setWxShareLimit(boolean paramBoolean)
  {
    this.wxShareLimit = paramBoolean;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"QMCardData\",");
    if (this.name != null) {
      localStringBuilder.append("\"name\":\"").append(this.name).append("\",");
    }
    if (this.cardThumbUrl != null) {
      localStringBuilder.append("\"cardThumbUrl\":\"").append(this.cardThumbUrl).append("\",");
    }
    if (this.cardMailUrl != null) {
      localStringBuilder.append("\"cardMailUrl\":\"").append(this.cardMailUrl).append("\",");
    }
    if (this.cardCoverUrl != null) {
      localStringBuilder.append("\"cardCoverUrl\":\"").append(this.cardCoverUrl).append("\",");
    }
    if (this.cardOnePxUrl != null) {
      localStringBuilder.append("\"cardOnePxUrl\":\"").append(this.cardOnePxUrl).append("\",");
    }
    if (this.cardUrl != null) {
      localStringBuilder.append("\"cardUrl\":\"").append(this.cardUrl).append("\",");
    }
    int i;
    Object localObject;
    if ((this.thanksFriendList != null) && (this.thanksFriendList.size() > 0))
    {
      localStringBuilder.append("\"thanksFriendList\":[");
      i = 0;
      while (i < this.thanksFriendList.size())
      {
        localObject = (QMCardFriendInfo)this.thanksFriendList.get(i);
        if (localObject != null)
        {
          if (i > 0) {
            localStringBuilder.append(',');
          }
          localStringBuilder.append(((QMCardFriendInfo)localObject).toString());
        }
        i += 1;
      }
      localStringBuilder.append("],");
    }
    if ((this.cardParaList != null) && (this.cardParaList.size() > 0))
    {
      localStringBuilder.append("\"cardParaList\":[");
      i = j;
      while (i < this.cardParaList.size())
      {
        localObject = (QMCardPara)this.cardParaList.get(i);
        if (localObject != null)
        {
          if (i > 0) {
            localStringBuilder.append(',');
          }
          localStringBuilder.append(((QMCardPara)localObject).toString());
        }
        i += 1;
      }
      localStringBuilder.append("],");
    }
    if (this.tag != null) {
      localStringBuilder.append("\"tag\":\"").append(this.tag).append("\",");
    }
    if (this.mailTitle != null) {
      localStringBuilder.append("\"mailTitle\":\"").append(this.mailTitle).append("\",");
    }
    if (this.mailWord != null) {
      localStringBuilder.append("\"mailWord\":\"").append(this.mailWord).append("\",");
    }
    if (this.shareTitle != null) {
      localStringBuilder.append("\"shareTitle\":\"").append(this.shareTitle).append("\",");
    }
    if (this.shareWord != null) {
      localStringBuilder.append("\"shareWord\":\"").append(this.shareWord).append("\",");
    }
    localStringBuilder.append("\"circlelimit\":").append(this.circlelimit).append(",");
    localStringBuilder.append("\"wxShareLimit\":").append(this.wxShareLimit).append(",");
    localStringBuilder.append("\"qqShareLimit\":").append(this.qqShareLimit).append(",");
    localStringBuilder.append("\"pageType\":").append(this.pageType).append(",");
    localStringBuilder.append("\"friendType\":").append(this.friendType).append(",");
    localStringBuilder.append("\"friendNum\":").append(this.friendNum).append(",");
    localStringBuilder.append("\"seqType\":").append(this.seqType).append(",");
    localStringBuilder.append("\"cardIdHash\":").append(this.cardIdHash).append(",");
    localStringBuilder.append("\"viewCount\":").append(this.viewCount).append(",");
    localStringBuilder.append("\"thanksCount\":").append(this.thanksCount).append(",");
    localStringBuilder.append("\"isComplete\":").append(this.isComplete).append(",");
    localStringBuilder.append("\"priority\":").append(this.priority).append(",");
    localStringBuilder.append("\"cardId\":\"").append(this.cardId).append("\"}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.model.QMCardData
 * JD-Core Version:    0.7.0.1
 */