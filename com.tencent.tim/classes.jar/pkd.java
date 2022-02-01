import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Thumbnails;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.PicInfo;
import com.tencent.biz.qqstory.base.SerializationPB.StoryAlbum;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.biz.qqstory.database.StoryAlbumPicEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class pkd
{
  public static final DateFormat e = new SimpleDateFormat("yyyy年M月d日");
  public String asR;
  public String asS;
  public int bjc = 6;
  public int bjd = 0;
  private String debugInfo = "new";
  private List<pkd.a> lT = new ArrayList();
  public List<String> lU;
  public String mAlbumName;
  public int mAlbumType;
  private long mId = -1L;
  private int mState;
  public int mTextId;
  public String mTransId;
  private long zT;
  private long zU;
  
  @Deprecated
  public pkd(int paramInt)
  {
    this.mAlbumType = paramInt;
  }
  
  public pkd(int paramInt, List<pkd.a> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      rom.fail("It not allowed to new the story album by null picList", new Object[0]);
    }
    for (;;)
    {
      this.mAlbumType = paramInt;
      return;
      pju.dI(paramList);
      this.lT.addAll(paramList);
    }
  }
  
  private byte[] H()
  {
    SerializationPB.StoryAlbum localStoryAlbum = new SerializationPB.StoryAlbum();
    if ((this.lU != null) && (!this.lU.isEmpty())) {
      localStoryAlbum.geo_hash_list.set(this.lU);
    }
    if ((this.lT != null) && (this.lT.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.lT.size())
      {
        localArrayList.add(((pkd.a)this.lT.get(i)).a());
        i += 1;
      }
      localStoryAlbum.pic_list.set(localArrayList);
    }
    return localStoryAlbum.toByteArray();
  }
  
  private boolean N(String paramString1, String paramString2)
  {
    return TextUtils.equals(paramString1.substring(0, paramString1.indexOf(acfp.m(2131714817))), paramString2.substring(0, paramString2.indexOf(acfp.m(2131714814))));
  }
  
  private void O(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    Object localObject = new SerializationPB.StoryAlbum();
    ((SerializationPB.StoryAlbum)localObject).mergeFrom(paramArrayOfByte);
    this.lU = ((SerializationPB.StoryAlbum)localObject).geo_hash_list.get();
    paramArrayOfByte = ((SerializationPB.StoryAlbum)localObject).pic_list.get();
    localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayOfByte.size())
    {
      pkd.a locala = new pkd.a();
      locala.a((SerializationPB.PicInfo)paramArrayOfByte.get(i));
      ((List)localObject).add(locala);
      i += 1;
    }
    this.lT = ((List)localObject);
  }
  
  public static pkd a(int paramInt)
  {
    pkd localpkd = new pkd(-1);
    localpkd.bjd = paramInt;
    return localpkd;
  }
  
  public static pkd a(StoryAlbumEntry paramStoryAlbumEntry)
    throws InvalidProtocolBufferMicroException
  {
    pkd localpkd = new pkd(paramStoryAlbumEntry.albumType);
    localpkd.zT = paramStoryAlbumEntry.startTime;
    localpkd.zU = paramStoryAlbumEntry.endTime;
    localpkd.mAlbumName = paramStoryAlbumEntry.albumName;
    localpkd.mTransId = paramStoryAlbumEntry.transId;
    localpkd.mTextId = paramStoryAlbumEntry.textId;
    localpkd.asR = paramStoryAlbumEntry.albumDesc;
    localpkd.asS = paramStoryAlbumEntry.geoHashStr;
    localpkd.mState = paramStoryAlbumEntry.state;
    localpkd.bjc = paramStoryAlbumEntry.minCount;
    localpkd.debugInfo = paramStoryAlbumEntry.debugInfo;
    localpkd.mId = paramStoryAlbumEntry.getId();
    localpkd.O(paramStoryAlbumEntry.extraInfo);
    return localpkd;
  }
  
  public boolean Id()
  {
    return this.mAlbumType == -1;
  }
  
  public boolean Ie()
  {
    return (this.mAlbumType == -1) && (this.bjd != 1);
  }
  
  public boolean If()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lT.iterator();
    while (localIterator.hasNext())
    {
      pkd.a locala = (pkd.a)localIterator.next();
      if (new File(locala.mPath).exists()) {
        localArrayList.add(locala);
      }
    }
    this.lT = localArrayList;
    return localArrayList.size() >= 4;
  }
  
  public void M(long paramLong1, long paramLong2)
  {
    this.zT = paramLong1;
    this.zU = paramLong2;
  }
  
  public StoryAlbumEntry a()
  {
    StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
    localStoryAlbumEntry.albumType = this.mAlbumType;
    localStoryAlbumEntry.startTime = getStartTime();
    localStoryAlbumEntry.endTime = getEndTime();
    localStoryAlbumEntry.albumName = this.mAlbumName;
    localStoryAlbumEntry.transId = this.mTransId;
    localStoryAlbumEntry.textId = this.mTextId;
    localStoryAlbumEntry.albumDesc = this.asR;
    localStoryAlbumEntry.geoHashStr = this.asS;
    localStoryAlbumEntry.state = this.mState;
    localStoryAlbumEntry.minCount = this.bjc;
    localStoryAlbumEntry.debugInfo = this.debugInfo;
    localStoryAlbumEntry.extraInfo = H();
    if (this.mId >= 0L) {
      localStoryAlbumEntry.setId(this.mId);
    }
    return localStoryAlbumEntry;
  }
  
  public void a(pkd parampkd)
  {
    M(parampkd.dx(), parampkd.dz());
    if (!TextUtils.isEmpty(parampkd.asS)) {
      this.asS = parampkd.asS;
    }
    if (parampkd.lU != null) {
      this.lU = parampkd.lU;
    }
  }
  
  public void a(pku.a parama)
  {
    int i;
    if (parama != null)
    {
      if ((parama.lZ == null) || (parama.lZ.size() <= 0)) {
        break label85;
      }
      i = new Random().nextInt(parama.lZ.size());
    }
    label85:
    for (this.mTransId = ((String)parama.lZ.get(i));; this.mTransId = parama.mTransId)
    {
      this.asR = parama.asR;
      this.bjc = parama.bje;
      this.mTextId = parama.mTextId;
      return;
    }
  }
  
  public void b(pkd parampkd)
  {
    rom.checkNotNull(parampkd);
    ram.b("Q.qqstory.recommendAlbum.logic.StoryAlbum", "%s merge album %s", this, parampkd);
    this.mState = 0;
    parampkd = parampkd.lT.iterator();
    while (parampkd.hasNext())
    {
      pkd.a locala = (pkd.a)parampkd.next();
      if (!this.lT.contains(locala)) {
        this.lT.add(locala);
      }
    }
    pju.dI(this.lT);
  }
  
  public void b(pkm parampkm)
  {
    this.debugInfo = parampkm.toString();
  }
  
  public List<pkd.a> bD()
  {
    return Collections.unmodifiableList(new ArrayList(this.lT));
  }
  
  public String bQ(int paramInt)
  {
    if (TextUtils.isEmpty(this.asR)) {
      return "";
    }
    return this.asR.replace("[$album_name]", this.mAlbumName).replace("[$select_count]", paramInt + "");
  }
  
  public long dA()
  {
    if ((this.lT == null) || (this.lT.isEmpty())) {
      return 0L;
    }
    return ((pkd.a)this.lT.get(0)).mCreateTime;
  }
  
  public long dB()
  {
    if ((this.lT == null) || (this.lT.isEmpty())) {
      return 0L;
    }
    return ((pkd.a)this.lT.get(this.lT.size() - 1)).zV;
  }
  
  public void dN(List<pkd.a> paramList)
  {
    this.lT.clear();
    this.lT.addAll(paramList);
    pju.dI(this.lT);
  }
  
  public long dx()
  {
    return this.zT;
  }
  
  public long dz()
  {
    return this.zU;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof pkd))
    {
      if ((Id()) && (((pkd)paramObject).Id())) {
        return this.bjd == ((pkd)paramObject).bjd;
      }
      if (this.mId == ((pkd)paramObject).mId) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  public int getCount()
  {
    return this.lT.size();
  }
  
  public long getEndTime()
  {
    if (this.lT.isEmpty()) {
      return -1L;
    }
    return ((pkd.a)this.lT.get(this.lT.size() - 1)).mCreateTime;
  }
  
  public long getID()
  {
    return this.mId;
  }
  
  public int getReportType()
  {
    switch (this.mAlbumType)
    {
    case 5: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 6: 
      return 2;
    case 2: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public long getStartTime()
  {
    if (this.lT.isEmpty()) {
      return -1L;
    }
    return ((pkd.a)this.lT.get(0)).mCreateTime;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public String mf()
  {
    Object localObject2;
    if ((this.lT == null) || (this.lT.isEmpty()))
    {
      localObject2 = "";
      return localObject2;
    }
    long l1 = ((pkd.a)this.lT.get(0)).mCreateTime;
    long l2 = ((pkd.a)this.lT.get(this.lT.size() - 1)).mCreateTime;
    Object localObject1 = new Date(l1 * 1000L);
    String str1 = e.format((Date)localObject1);
    localObject1 = new Date(l2 * 1000L);
    String str2 = e.format((Date)localObject1);
    boolean bool = roq.aZ(l1 * 1000L);
    if (bool) {}
    for (localObject1 = str1.substring(str1.indexOf(acfp.m(2131714811)) + 1);; localObject1 = str1)
    {
      localObject2 = localObject1;
      if (TextUtils.equals(str1, str2)) {
        break;
      }
      if ((!bool) && (!N(str1, str2))) {
        break label317;
      }
      if (!TextUtils.equals(str1.substring(0, str1.indexOf(acfp.m(2131714813))), str2.substring(0, str2.indexOf(acfp.m(2131714816))))) {
        break label274;
      }
      return (String)localObject1 + "-" + str2.substring(str2.indexOf(acfp.m(2131714812)) + 1);
    }
    label274:
    return (String)localObject1 + "-" + str2.substring(str2.indexOf(acfp.m(2131714815)) + 1);
    label317:
    return (String)localObject1 + "-" + str2;
  }
  
  public void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public void setState(int paramInt)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbum", "setState:" + paramInt);
    this.mState = paramInt;
  }
  
  public int sh()
  {
    Iterator localIterator = this.lT.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((pkd.a)localIterator.next()).Ig()) {
        break label45;
      }
      i += 1;
    }
    label45:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("StoryAlbum=[");
    localStringBuilder1.append(" mId:").append(this.mId);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ;isHomeAlbum:");
    if (this.mAlbumType == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localStringBuilder2.append(bool);
      localStringBuilder1.append(" ;mAlbumType:").append(this.mAlbumType);
      localStringBuilder1.append(" ;mAlbumName:").append(this.mAlbumName);
      localStringBuilder1.append(" ;mAlbumTime:").append(mf());
      localStringBuilder1.append(" ;StartTime:").append(getStartTime());
      localStringBuilder1.append(" ;EndTime:").append(getEndTime());
      localStringBuilder1.append(" ;mUIAlbumType:").append(this.bjd);
      localStringBuilder1.append(" ;mTransId:").append(this.mTransId);
      localStringBuilder1.append(" ;mTextId:").append(this.mTextId);
      localStringBuilder1.append(" ;count:").append(this.lT.size());
      localStringBuilder1.append(" ;mAlbumDesc:").append(this.asR);
      localStringBuilder1.append(" ;kmeansTime1:").append(this.zT);
      localStringBuilder1.append(" ;kmeansTime2:").append(this.zU);
      localStringBuilder1.append(" ;mGeoHashHead:").append(this.asS);
      localStringBuilder1.append(" ;mGeoHashStringList:").append(this.lU);
      localStringBuilder1.append(" ;debugInfo:").append(this.debugInfo);
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
  
  public static class a
  {
    public String asT;
    public AddressItem b;
    @Deprecated
    public String bN;
    public double bg;
    public double bh;
    public int height;
    public long mAddTime;
    public long mCreateTime;
    public long mId;
    private LocalMediaInfo mLocalMediaInfo;
    public String mPath;
    private int mState;
    public String mime;
    public int orientation;
    public long size;
    public int width;
    public long zV;
    
    public boolean Ig()
    {
      return this.mState == 1;
    }
    
    public Bitmap a(Context paramContext, int paramInt, BitmapFactory.Options paramOptions)
    {
      
      if (paramContext == null)
      {
        rom.fail("Need the context to get thumbnail!", new Object[0]);
        return null;
      }
      if ((paramInt != 1) && (paramInt != 3))
      {
        rom.fail("kind is illegal", new Object[0]);
        return null;
      }
      return MediaStore.Images.Thumbnails.getThumbnail(paramContext.getContentResolver(), this.mId, paramInt, paramOptions);
    }
    
    public SerializationPB.PicInfo a()
    {
      SerializationPB.PicInfo localPicInfo = new SerializationPB.PicInfo();
      localPicInfo.id.set(this.mId);
      PBStringField localPBStringField = localPicInfo.path;
      if (TextUtils.isEmpty(this.mPath))
      {
        str = "";
        localPBStringField.set(str);
        localPBStringField = localPicInfo.thumb;
        if (!TextUtils.isEmpty(this.bN)) {
          break label196;
        }
      }
      label196:
      for (String str = "";; str = this.bN)
      {
        localPBStringField.set(str);
        localPicInfo.width.set(this.width);
        localPicInfo.height.set(this.height);
        localPicInfo.orientation.set(this.orientation);
        localPicInfo.create_time.set(this.mCreateTime);
        localPicInfo.lat.set(this.bg);
        localPicInfo.lng.set(this.bh);
        localPicInfo.geo_hash.set(this.asT);
        localPicInfo.state.set(this.mState);
        localPicInfo.mime.set(this.mime);
        localPicInfo.size.set(this.size);
        localPicInfo.db_create_time.set(this.zV);
        return localPicInfo;
        str = this.mPath;
        break;
      }
    }
    
    public StoryAlbumPicEntry a()
    {
      StoryAlbumPicEntry localStoryAlbumPicEntry = new StoryAlbumPicEntry();
      localStoryAlbumPicEntry.path = this.mPath;
      localStoryAlbumPicEntry.thumbPath = this.bN;
      localStoryAlbumPicEntry.width = this.width;
      localStoryAlbumPicEntry.height = this.height;
      localStoryAlbumPicEntry.orientation = this.orientation;
      localStoryAlbumPicEntry.createTime = this.mCreateTime;
      localStoryAlbumPicEntry.gpsLat = this.bg;
      localStoryAlbumPicEntry.gpsLng = this.bh;
      localStoryAlbumPicEntry.geohashString = this.asT;
      localStoryAlbumPicEntry.state = this.mState;
      localStoryAlbumPicEntry.mime = this.mime;
      localStoryAlbumPicEntry.size = this.size;
      return localStoryAlbumPicEntry;
    }
    
    public LocalMediaInfo a()
    {
      if (this.mLocalMediaInfo == null)
      {
        this.mLocalMediaInfo = new LocalMediaInfo();
        this.mLocalMediaInfo._id = this.mId;
        this.mLocalMediaInfo.path = this.mPath;
        this.mLocalMediaInfo.orientation = this.orientation;
        this.mLocalMediaInfo.mediaWidth = this.width;
        this.mLocalMediaInfo.mediaHeight = this.height;
        this.mLocalMediaInfo.mMimeType = this.mime;
        this.mLocalMediaInfo.fileSize = this.size;
        LocalMediaInfo localLocalMediaInfo1 = this.mLocalMediaInfo;
        LocalMediaInfo localLocalMediaInfo2 = this.mLocalMediaInfo;
        int i = AlbumThumbDownloader.THUMB_WIDHT;
        localLocalMediaInfo2.thumbHeight = i;
        localLocalMediaInfo1.thumbWidth = i;
      }
      return this.mLocalMediaInfo;
    }
    
    public void a(SerializationPB.PicInfo paramPicInfo)
      throws InvalidProtocolBufferMicroException
    {
      this.mId = paramPicInfo.id.get();
      this.mPath = paramPicInfo.path.get();
      this.bN = paramPicInfo.thumb.get();
      this.width = paramPicInfo.width.get();
      this.height = paramPicInfo.height.get();
      this.orientation = paramPicInfo.orientation.get();
      this.mCreateTime = paramPicInfo.create_time.get();
      this.bg = paramPicInfo.lat.get();
      this.bh = paramPicInfo.lng.get();
      this.asT = paramPicInfo.geo_hash.get();
      this.mState = paramPicInfo.state.get();
      this.mime = paramPicInfo.mime.get();
      this.size = paramPicInfo.size.get();
      this.zV = paramPicInfo.db_create_time.get();
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a)) {
        return this.mPath.equals(((a)paramObject).mPath);
      }
      return false;
    }
    
    public void rD(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.mState = i;
        return;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("PicInfo=[");
      localStringBuilder.append(" mId:").append(this.mId);
      localStringBuilder.append(" mPath:").append(this.mPath);
      localStringBuilder.append(" mThumbPath:").append(this.bN);
      localStringBuilder.append(" width:").append(this.width);
      localStringBuilder.append(" height:").append(this.height);
      localStringBuilder.append(" orientation:").append(this.orientation);
      localStringBuilder.append(" mCreateTime:").append(this.mCreateTime);
      localStringBuilder.append(" mDBCreateTime:").append(this.zV);
      localStringBuilder.append(" mGpsLat:").append(this.bg);
      localStringBuilder.append(" mGpsLng:").append(this.bh);
      localStringBuilder.append(" mGeohashString:").append(this.asT);
      localStringBuilder.append(" mState:").append(this.mState);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkd
 * JD-Core Version:    0.7.0.1
 */