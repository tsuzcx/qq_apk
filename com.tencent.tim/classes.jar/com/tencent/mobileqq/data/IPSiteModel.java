package com.tencent.mobileqq.data;

import acfp;
import aezd;
import aeze;
import aezf;
import aezg;
import aezh;
import aezi;
import aezj;
import aezk;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class IPSiteModel
{
  public static class Book
    implements Parcelable
  {
    public static final Parcelable.Creator<Book> CREATOR = new aezd();
    public String authorName;
    public String cover;
    public String desc;
    public String id;
    public String jumpUrl;
    public String name;
    public String recommDesc;
    
    public Book() {}
    
    public Book(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      this.cover = paramString1;
      this.desc = paramString2;
      this.id = paramString3;
      this.jumpUrl = paramString4;
      this.name = paramString5;
      this.recommDesc = paramString6;
      this.authorName = paramString7;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "Book{cover='" + this.cover + '\'' + ", desc='" + this.desc + '\'' + ", id='" + this.id + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + ", name='" + this.name + '\'' + ", recommDesc='" + this.recommDesc + '\'' + ", authorName='" + this.authorName + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.cover);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.recommDesc);
      paramParcel.writeString(this.authorName);
    }
  }
  
  public static class Comic
    implements Parcelable
  {
    public static final Parcelable.Creator<Comic> CREATOR = new aeze();
    public List<IPSiteModel.ComicRich> comicRiches;
    public int comicType;
    public String cover;
    public String desc;
    public String id;
    public String jumpUrl;
    public String name;
    public String recommDesc;
    public String typeName;
    
    public Comic() {}
    
    public Comic(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, List<IPSiteModel.ComicRich> paramList)
    {
      this.comicType = paramInt;
      this.cover = paramString1;
      this.desc = paramString2;
      this.id = paramString3;
      this.jumpUrl = paramString4;
      this.name = paramString5;
      this.recommDesc = paramString6;
      this.typeName = paramString7;
      this.comicRiches = paramList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "Comic{comicType=" + this.comicType + ", cover='" + this.cover + '\'' + ", desc='" + this.desc + '\'' + ", id='" + this.id + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + ", name='" + this.name + '\'' + ", recommDesc='" + this.recommDesc + '\'' + ", typeName='" + this.typeName + '\'' + ", comicRiches=" + this.comicRiches + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.comicType);
      paramParcel.writeString(this.cover);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.recommDesc);
      paramParcel.writeString(this.typeName);
      paramParcel.writeList(this.comicRiches);
    }
  }
  
  public static class ComicRich
    implements Parcelable
  {
    public static final Parcelable.Creator<ComicRich> CREATOR = new aezf();
    public String extCover;
    public String extName;
    public String extTitle;
    public String extUrl;
    
    public ComicRich() {}
    
    public ComicRich(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.extCover = paramString1;
      this.extName = paramString2;
      this.extTitle = paramString3;
      this.extUrl = paramString4;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "ComicRich{extCover='" + this.extCover + '\'' + ", extName='" + this.extName + '\'' + ", extTitle='" + this.extTitle + '\'' + ", extUrl='" + this.extUrl + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.extCover);
      paramParcel.writeString(this.extName);
      paramParcel.writeString(this.extTitle);
      paramParcel.writeString(this.extUrl);
    }
  }
  
  public static class Game
    implements Parcelable
  {
    public static final Parcelable.Creator<Game> CREATOR = new aezg();
    public String cover;
    public String desc;
    public List<IPSiteModel.GameRich> gameRiches;
    public String id;
    public String jumpUrl;
    public String name;
    public String recommDesc;
    
    public Game() {}
    
    public Game(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<IPSiteModel.GameRich> paramList)
    {
      this.cover = paramString1;
      this.desc = paramString2;
      this.id = paramString3;
      this.jumpUrl = paramString4;
      this.name = paramString5;
      this.recommDesc = paramString6;
      this.gameRiches = paramList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "Game{cover='" + this.cover + '\'' + ", desc='" + this.desc + '\'' + ", id='" + this.id + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + ", name='" + this.name + '\'' + ", recommDesc='" + this.recommDesc + '\'' + ", gameRiches=" + this.gameRiches + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.cover);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.recommDesc);
      paramParcel.writeList(this.gameRiches);
    }
  }
  
  public static class GameRich
    implements Parcelable
  {
    public static final Parcelable.Creator<GameRich> CREATOR = new aezh();
    public String anchorFaceUrl;
    public String anchorId;
    public String anchorName;
    public String coverUrl;
    public String online;
    public String richJumpUrl;
    public String title;
    
    public GameRich() {}
    
    public GameRich(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      this.anchorFaceUrl = paramString1;
      this.anchorId = paramString2;
      this.anchorName = paramString3;
      this.coverUrl = paramString4;
      this.online = paramString5;
      this.title = paramString6;
      this.richJumpUrl = paramString7;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "GameRich{anchorFaceUrl='" + this.anchorFaceUrl + '\'' + ", anchorId='" + this.anchorId + '\'' + ", anchorName='" + this.anchorName + '\'' + ", coverUrl='" + this.coverUrl + '\'' + ", online='" + this.online + '\'' + ", title='" + this.title + '\'' + ", richJumpUrl='" + this.richJumpUrl + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.anchorFaceUrl);
      paramParcel.writeString(this.anchorId);
      paramParcel.writeString(this.anchorName);
      paramParcel.writeString(this.coverUrl);
      paramParcel.writeString(this.online);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.richJumpUrl);
    }
  }
  
  public static class Goods
    implements Parcelable
  {
    public static final Parcelable.Creator<Goods> CREATOR = new aezi();
    public String cover;
    public String goodsTags;
    public String id;
    public String moreUrl;
    public String name;
    public String price;
    public String saleNum;
    public String saleTags;
    public String svipPrice;
    public String url;
    
    public Goods() {}
    
    public Goods(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
    {
      this.cover = paramString1;
      this.goodsTags = paramString2;
      this.id = paramString3;
      this.name = paramString4;
      this.price = paramString5;
      this.saleTags = paramString6;
      this.svipPrice = paramString7;
      this.url = paramString8;
      this.moreUrl = paramString9;
      this.saleNum = paramString10;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "Goods{cover='" + this.cover + '\'' + ", goodsTags='" + this.goodsTags + '\'' + ", id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", price='" + this.price + '\'' + ", saleTags='" + this.saleTags + '\'' + ", svipPrice='" + this.svipPrice + '\'' + ", url='" + this.url + '\'' + ", moreUrl='" + this.moreUrl + '\'' + ", saleNum='" + this.saleNum + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.cover);
      paramParcel.writeString(this.goodsTags);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.price);
      paramParcel.writeString(this.saleTags);
      paramParcel.writeString(this.svipPrice);
      paramParcel.writeString(this.url);
      paramParcel.writeString(this.moreUrl);
      paramParcel.writeString(this.saleNum);
    }
  }
  
  public static class Gxzb
    implements Parcelable
  {
    public static final String BACKGROUND;
    public static final String BUBBLE;
    public static final String CARD;
    public static final Parcelable.Creator<Gxzb> CREATOR = new aezj();
    public static final String EMOJI = acfp.m(2131707496);
    public static final String FONT;
    public static final String FUNCALL;
    public static final String PENDANT;
    public static final String REDPACKT;
    public static final String THEME;
    public String appName;
    public int appid;
    public String cover;
    public int feeType;
    public String id;
    public String name;
    
    static
    {
      BUBBLE = acfp.m(2131707493);
      THEME = acfp.m(2131707489);
      PENDANT = acfp.m(2131707492);
      FONT = acfp.m(2131707494);
      BACKGROUND = acfp.m(2131707495);
      FUNCALL = acfp.m(2131707488);
      CARD = acfp.m(2131707490);
      REDPACKT = acfp.m(2131707491);
    }
    
    public Gxzb() {}
    
    public Gxzb(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
    {
      this.appid = paramInt1;
      this.appName = paramString1;
      this.cover = paramString2;
      this.feeType = paramInt2;
      this.id = paramString3;
      this.name = paramString4;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "Gxzb{appid=" + this.appid + ", appName='" + this.appName + '\'' + ", cover='" + this.cover + '\'' + ", feeType=" + this.feeType + ", id='" + this.id + '\'' + ", name='" + this.name + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.appid);
      paramParcel.writeString(this.appName);
      paramParcel.writeString(this.cover);
      paramParcel.writeInt(this.feeType);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.name);
    }
  }
  
  public static class Video
    implements Parcelable
  {
    public static final Parcelable.Creator<Video> CREATOR = new aezk();
    public String buttonDesc;
    public String content;
    public String cover;
    public String desc;
    public String endTime;
    public String id;
    public int isShow;
    public String name;
    public long newEndTime;
    public long newStartTime;
    public String redirectUrl;
    public String showDate;
    public String videoSource;
    
    public Video() {}
    
    public Video(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, long paramLong1, long paramLong2, String paramString8, String paramString9, String paramString10)
    {
      this.id = paramString1;
      this.buttonDesc = paramString2;
      this.content = paramString3;
      this.cover = paramString4;
      this.desc = paramString5;
      this.name = paramString6;
      this.endTime = paramString7;
      this.isShow = paramInt;
      this.newStartTime = paramLong1;
      this.newEndTime = paramLong2;
      this.redirectUrl = paramString8;
      this.videoSource = paramString9;
      this.showDate = paramString10;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "Video{id='" + this.id + '\'' + ", buttonDesc='" + this.buttonDesc + '\'' + ", content='" + this.content + '\'' + ", cover='" + this.cover + '\'' + ", desc='" + this.desc + '\'' + ", name='" + this.name + '\'' + ", endTime='" + this.endTime + '\'' + ", isShow=" + this.isShow + ", newStartTime=" + this.newStartTime + ", newEndTime=" + this.newEndTime + ", redirectUrl='" + this.redirectUrl + '\'' + ", videoSource='" + this.videoSource + '\'' + ", showDate='" + this.showDate + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.buttonDesc);
      paramParcel.writeString(this.content);
      paramParcel.writeString(this.cover);
      paramParcel.writeString(this.desc);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.endTime);
      paramParcel.writeInt(this.isShow);
      paramParcel.writeLong(this.newStartTime);
      paramParcel.writeLong(this.newEndTime);
      paramParcel.writeString(this.redirectUrl);
      paramParcel.writeString(this.videoSource);
      paramParcel.writeString(this.showDate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel
 * JD-Core Version:    0.7.0.1
 */