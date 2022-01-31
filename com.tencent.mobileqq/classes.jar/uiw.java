import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class uiw
{
  public final int a;
  public long a;
  public final String a;
  public final boolean a;
  public int b;
  public final String b;
  public boolean b;
  public final String c;
  
  public uiw(qqstory_struct.FeedSeqInfo paramFeedSeqInfo)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramFeedSeqInfo.feed_id.get().toStringUtf8();
    this.jdField_a_of_type_Int = paramFeedSeqInfo.seq.get();
    this.jdField_b_of_type_JavaLangString = paramFeedSeqInfo.union_id.get().toStringUtf8();
    this.c = String.valueOf(paramFeedSeqInfo.date.get());
    if (paramFeedSeqInfo.is_playable.has()) {
      if (paramFeedSeqInfo.is_playable.get() != 1) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      try
      {
        for (;;)
        {
          if (!TextUtils.isEmpty(this.c)) {
            this.jdField_a_of_type_Long = uje.a().parse(this.c).getTime();
          }
          vkw.a(this.jdField_a_of_type_JavaLangString);
          return;
          bool = false;
          break;
          this.jdField_a_of_type_Boolean = true;
        }
      }
      catch (Exception paramFeedSeqInfo)
      {
        for (;;)
        {
          urk.c("Q.qqstory.home", "parse date " + this.c, paramFeedSeqInfo);
        }
      }
    }
  }
  
  public uiw(@NonNull String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Boolean = true;
    try
    {
      if (!TextUtils.isEmpty(this.c)) {
        this.jdField_a_of_type_Long = uje.a().parse(this.c).getTime();
      }
      vkw.a(paramString1);
      return;
    }
    catch (ParseException paramString2)
    {
      for (;;)
      {
        urk.c("Q.qqstory.home", "parse date", paramString2);
      }
    }
  }
  
  public static int a(List<uiw> paramList, String paramString)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      if (((uiw)paramList.next()).jdField_a_of_type_JavaLangString.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public qqstory_struct.FeedSeqInfo a()
  {
    qqstory_struct.FeedSeqInfo localFeedSeqInfo = new qqstory_struct.FeedSeqInfo();
    localFeedSeqInfo.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localFeedSeqInfo.seq.set(this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_JavaLangString != null) {
      localFeedSeqInfo.union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    try
    {
      Integer localInteger1 = Integer.valueOf(uje.a().format(new Date(NetConnInfoCenter.getServerTimeMillis())));
      localFeedSeqInfo.date.set(localInteger1.intValue());
      return localFeedSeqInfo;
    }
    catch (Exception localException1)
    {
      urk.b("FeedIdListSeqInfo", "exception ", localException1);
      try
      {
        Integer localInteger2 = Integer.valueOf(uje.a().format(new Date()));
        localFeedSeqInfo.date.set(localInteger2.intValue());
        return localFeedSeqInfo;
      }
      catch (Exception localException2)
      {
        urk.b("FeedIdListSeqInfo", "exception ", localException2);
      }
    }
    return localFeedSeqInfo;
  }
  
  public String toString()
  {
    return "FeedIdListSeqInfo{feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mSeq=" + this.jdField_a_of_type_Int + ", mUnionId='" + this.jdField_b_of_type_JavaLangString + '\'' + ", date='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uiw
 * JD-Core Version:    0.7.0.1
 */