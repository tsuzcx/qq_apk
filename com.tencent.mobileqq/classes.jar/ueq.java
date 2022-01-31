import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.PicInfo;
import com.tencent.biz.qqstory.base.SerializationPB.StoryAlbum;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ueq
{
  public static final DateFormat a;
  public int a;
  private long a;
  public String a;
  public List<String> a;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<uer> jdField_b_of_type_JavaUtilList = new ArrayList();
  public int c;
  private long c;
  public String c;
  public int d;
  public String d;
  public int e;
  private String e = "new";
  private int f;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy年M月d日");
  }
  
  @Deprecated
  public ueq(int paramInt)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 6;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public ueq(int paramInt, List<uer> paramList)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = 6;
    this.jdField_d_of_type_Int = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      xmh.a("It not allowed to new the story album by null picList", new Object[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      uef.b(paramList);
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public static ueq a(int paramInt)
  {
    ueq localueq = new ueq(-1);
    localueq.jdField_d_of_type_Int = paramInt;
    return localueq;
  }
  
  public static ueq a(StoryAlbumEntry paramStoryAlbumEntry)
  {
    ueq localueq = new ueq(paramStoryAlbumEntry.albumType);
    localueq.jdField_b_of_type_Long = paramStoryAlbumEntry.startTime;
    localueq.jdField_c_of_type_Long = paramStoryAlbumEntry.endTime;
    localueq.jdField_b_of_type_JavaLangString = paramStoryAlbumEntry.albumName;
    localueq.jdField_a_of_type_JavaLangString = paramStoryAlbumEntry.transId;
    localueq.jdField_b_of_type_Int = paramStoryAlbumEntry.textId;
    localueq.jdField_c_of_type_JavaLangString = paramStoryAlbumEntry.albumDesc;
    localueq.jdField_d_of_type_JavaLangString = paramStoryAlbumEntry.geoHashStr;
    localueq.f = paramStoryAlbumEntry.state;
    localueq.jdField_c_of_type_Int = paramStoryAlbumEntry.minCount;
    localueq.e = paramStoryAlbumEntry.debugInfo;
    localueq.jdField_a_of_type_Long = paramStoryAlbumEntry.getId();
    localueq.a(paramStoryAlbumEntry.extraInfo);
    return localueq;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SerializationPB.StoryAlbum();
    ((SerializationPB.StoryAlbum)localObject).mergeFrom(paramArrayOfByte);
    this.jdField_a_of_type_JavaUtilList = ((SerializationPB.StoryAlbum)localObject).geo_hash_list.get();
    paramArrayOfByte = ((SerializationPB.StoryAlbum)localObject).pic_list.get();
    localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayOfByte.size())
    {
      uer localuer = new uer();
      localuer.a((SerializationPB.PicInfo)paramArrayOfByte.get(i));
      ((List)localObject).add(localuer);
      i += 1;
    }
    this.jdField_b_of_type_JavaUtilList = ((List)localObject);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return TextUtils.equals(paramString1.substring(0, paramString1.indexOf(alpo.a(2131714779))), paramString2.substring(0, paramString2.indexOf(alpo.a(2131714776))));
  }
  
  private byte[] a()
  {
    SerializationPB.StoryAlbum localStoryAlbum = new SerializationPB.StoryAlbum();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localStoryAlbum.geo_hash_list.set(this.jdField_a_of_type_JavaUtilList);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localArrayList.add(((uer)this.jdField_b_of_type_JavaUtilList.get(i)).a());
        i += 1;
      }
      localStoryAlbum.pic_list.set(localArrayList);
    }
    return localStoryAlbum.toByteArray();
  }
  
  public int a()
  {
    return this.f;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public StoryAlbumEntry a()
  {
    StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
    localStoryAlbumEntry.albumType = this.jdField_a_of_type_Int;
    localStoryAlbumEntry.startTime = f();
    localStoryAlbumEntry.endTime = g();
    localStoryAlbumEntry.albumName = this.jdField_b_of_type_JavaLangString;
    localStoryAlbumEntry.transId = this.jdField_a_of_type_JavaLangString;
    localStoryAlbumEntry.textId = this.jdField_b_of_type_Int;
    localStoryAlbumEntry.albumDesc = this.jdField_c_of_type_JavaLangString;
    localStoryAlbumEntry.geoHashStr = this.jdField_d_of_type_JavaLangString;
    localStoryAlbumEntry.state = this.f;
    localStoryAlbumEntry.minCount = this.jdField_c_of_type_Int;
    localStoryAlbumEntry.debugInfo = this.e;
    localStoryAlbumEntry.extraInfo = a();
    if (this.jdField_a_of_type_Long >= 0L) {
      localStoryAlbumEntry.setId(this.jdField_a_of_type_Long);
    }
    return localStoryAlbumEntry;
  }
  
  public String a()
  {
    Object localObject2;
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      localObject2 = "";
      return localObject2;
    }
    long l1 = ((uer)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
    long l2 = ((uer)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1)).jdField_b_of_type_Long;
    Object localObject1 = new Date(l1 * 1000L);
    String str1 = jdField_a_of_type_JavaTextDateFormat.format((Date)localObject1);
    localObject1 = new Date(l2 * 1000L);
    String str2 = jdField_a_of_type_JavaTextDateFormat.format((Date)localObject1);
    boolean bool = xmq.a(l1 * 1000L);
    if (bool) {}
    for (localObject1 = str1.substring(str1.indexOf(alpo.a(2131714773)) + 1);; localObject1 = str1)
    {
      localObject2 = localObject1;
      if (TextUtils.equals(str1, str2)) {
        break;
      }
      if ((!bool) && (!a(str1, str2))) {
        break label316;
      }
      if (!TextUtils.equals(str1.substring(0, str1.indexOf(alpo.a(2131714775))), str2.substring(0, str2.indexOf(alpo.a(2131714778))))) {
        break label273;
      }
      return (String)localObject1 + "-" + str2.substring(str2.indexOf(alpo.a(2131714774)) + 1);
    }
    label273:
    return (String)localObject1 + "-" + str2.substring(str2.indexOf(alpo.a(2131714777)) + 1);
    label316:
    return (String)localObject1 + "-" + str2;
  }
  
  public String a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return "";
    }
    return this.jdField_c_of_type_JavaLangString.replace("[$album_name]", this.jdField_b_of_type_JavaLangString).replace("[$select_count]", paramInt + "");
  }
  
  public List<uer> a()
  {
    return Collections.unmodifiableList(new ArrayList(this.jdField_b_of_type_JavaUtilList));
  }
  
  public void a(int paramInt)
  {
    wsv.d("Q.qqstory.recommendAlbum.logic.StoryAlbum", "setState:" + paramInt);
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
  }
  
  public void a(List<uer> paramList)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    uef.b(this.jdField_b_of_type_JavaUtilList);
  }
  
  public void a(ueq paramueq)
  {
    a(paramueq.b(), paramueq.c());
    if (!TextUtils.isEmpty(paramueq.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = paramueq.jdField_d_of_type_JavaLangString;
    }
    if (paramueq.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList = paramueq.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(ufe paramufe)
  {
    this.e = paramufe.toString();
  }
  
  public void a(ufn paramufn)
  {
    int i;
    if (paramufn != null)
    {
      if ((paramufn.jdField_a_of_type_JavaUtilList == null) || (paramufn.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label85;
      }
      i = new Random().nextInt(paramufn.jdField_a_of_type_JavaUtilList.size());
    }
    label85:
    for (this.jdField_a_of_type_JavaLangString = ((String)paramufn.jdField_a_of_type_JavaUtilList.get(i));; this.jdField_a_of_type_JavaLangString = paramufn.jdField_b_of_type_JavaLangString)
    {
      this.jdField_c_of_type_JavaLangString = paramufn.jdField_a_of_type_JavaLangString;
      this.jdField_c_of_type_Int = paramufn.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramufn.jdField_c_of_type_Int;
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b(ueq paramueq)
  {
    xmh.a(paramueq);
    wsv.a("Q.qqstory.recommendAlbum.logic.StoryAlbum", "%s merge album %s", this, paramueq);
    this.f = 0;
    paramueq = paramueq.jdField_b_of_type_JavaUtilList.iterator();
    while (paramueq.hasNext())
    {
      uer localuer = (uer)paramueq.next();
      if (!this.jdField_b_of_type_JavaUtilList.contains(localuer)) {
        this.jdField_b_of_type_JavaUtilList.add(localuer);
      }
    }
    uef.b(this.jdField_b_of_type_JavaUtilList);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == -1) && (this.jdField_d_of_type_Int != 1);
  }
  
  public int c()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((uer)localIterator.next()).a()) {
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
  
  public long c()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public boolean c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uer localuer = (uer)localIterator.next();
      if (new File(localuer.jdField_a_of_type_JavaLangString).exists()) {
        localArrayList.add(localuer);
      }
    }
    this.jdField_b_of_type_JavaUtilList = localArrayList;
    return localArrayList.size() >= 4;
  }
  
  public int d()
  {
    switch (this.jdField_a_of_type_Int)
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
  
  public long d()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return 0L;
    }
    return ((uer)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
  }
  
  public long e()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return 0L;
    }
    return ((uer)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1)).d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof ueq))
    {
      if ((a()) && (((ueq)paramObject).a())) {
        return this.jdField_d_of_type_Int == ((ueq)paramObject).jdField_d_of_type_Int;
      }
      if (this.jdField_a_of_type_Long == ((ueq)paramObject).jdField_a_of_type_Long) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return false;
  }
  
  public long f()
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return -1L;
    }
    return ((uer)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_b_of_type_Long;
  }
  
  public long g()
  {
    if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      return -1L;
    }
    return ((uer)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1)).jdField_b_of_type_Long;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("StoryAlbum=[");
    localStringBuilder1.append(" mId:").append(this.jdField_a_of_type_Long);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ;isHomeAlbum:");
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localStringBuilder2.append(bool);
      localStringBuilder1.append(" ;mAlbumType:").append(this.jdField_a_of_type_Int);
      localStringBuilder1.append(" ;mAlbumName:").append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder1.append(" ;mAlbumTime:").append(a());
      localStringBuilder1.append(" ;StartTime:").append(f());
      localStringBuilder1.append(" ;EndTime:").append(g());
      localStringBuilder1.append(" ;mUIAlbumType:").append(this.jdField_d_of_type_Int);
      localStringBuilder1.append(" ;mTransId:").append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder1.append(" ;mTextId:").append(this.jdField_b_of_type_Int);
      localStringBuilder1.append(" ;count:").append(this.jdField_b_of_type_JavaUtilList.size());
      localStringBuilder1.append(" ;mAlbumDesc:").append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder1.append(" ;kmeansTime1:").append(this.jdField_b_of_type_Long);
      localStringBuilder1.append(" ;kmeansTime2:").append(this.jdField_c_of_type_Long);
      localStringBuilder1.append(" ;mGeoHashHead:").append(this.jdField_d_of_type_JavaLangString);
      localStringBuilder1.append(" ;mGeoHashStringList:").append(this.jdField_a_of_type_JavaUtilList);
      localStringBuilder1.append(" ;debugInfo:").append(this.e);
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ueq
 * JD-Core Version:    0.7.0.1
 */