import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class qvd
{
  public final boolean aFH;
  public boolean aFI;
  public final String ayV;
  public int bls = -1;
  public long dateTimeMillis;
  public final String mFeedId;
  public final int mSeq;
  public final String mUnionId;
  
  public qvd(qqstory_struct.FeedSeqInfo paramFeedSeqInfo)
  {
    this.mFeedId = paramFeedSeqInfo.feed_id.get().toStringUtf8();
    this.mSeq = paramFeedSeqInfo.seq.get();
    this.mUnionId = paramFeedSeqInfo.union_id.get().toStringUtf8();
    this.ayV = String.valueOf(paramFeedSeqInfo.date.get());
    if (paramFeedSeqInfo.is_playable.has()) {
      if (paramFeedSeqInfo.is_playable.get() != 1) {}
    }
    for (;;)
    {
      this.aFH = bool;
      try
      {
        for (;;)
        {
          if (!TextUtils.isEmpty(this.ayV)) {
            this.dateTimeMillis = qvf.c().parse(this.ayV).getTime();
          }
          rom.sF(this.mFeedId);
          return;
          bool = false;
          break;
          this.aFH = true;
        }
      }
      catch (Exception paramFeedSeqInfo)
      {
        for (;;)
        {
          ram.e("Q.qqstory.home", "parse date " + this.ayV, paramFeedSeqInfo);
        }
      }
    }
  }
  
  public qvd(@NonNull String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.mFeedId = paramString1;
    this.mSeq = paramInt;
    this.mUnionId = paramString2;
    this.ayV = paramString3;
    this.aFH = true;
    try
    {
      if (!TextUtils.isEmpty(this.ayV)) {
        this.dateTimeMillis = qvf.c().parse(this.ayV).getTime();
      }
      rom.checkNotNull(paramString1);
      return;
    }
    catch (ParseException paramString2)
    {
      for (;;)
      {
        ram.e("Q.qqstory.home", "parse date", paramString2);
      }
    }
  }
  
  public static int a(List<qvd> paramList, String paramString)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      if (((qvd)paramList.next()).mFeedId.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public qqstory_struct.FeedSeqInfo a()
  {
    qqstory_struct.FeedSeqInfo localFeedSeqInfo = new qqstory_struct.FeedSeqInfo();
    localFeedSeqInfo.feed_id.set(ByteStringMicro.copyFromUtf8(this.mFeedId));
    localFeedSeqInfo.seq.set(this.mSeq);
    if (this.mUnionId != null) {
      localFeedSeqInfo.union_id.set(ByteStringMicro.copyFromUtf8(this.mUnionId));
    }
    try
    {
      Integer localInteger1 = Integer.valueOf(qvf.c().format(new Date(NetConnInfoCenter.getServerTimeMillis())));
      localFeedSeqInfo.date.set(localInteger1.intValue());
      return localFeedSeqInfo;
    }
    catch (Exception localException1)
    {
      ram.w("FeedIdListSeqInfo", "exception ", localException1);
      try
      {
        Integer localInteger2 = Integer.valueOf(qvf.c().format(new Date()));
        localFeedSeqInfo.date.set(localInteger2.intValue());
        return localFeedSeqInfo;
      }
      catch (Exception localException2)
      {
        ram.w("FeedIdListSeqInfo", "exception ", localException2);
      }
    }
    return localFeedSeqInfo;
  }
  
  public String toString()
  {
    return "FeedIdListSeqInfo{feedId='" + this.mFeedId + '\'' + ", mSeq=" + this.mSeq + ", mUnionId='" + this.mUnionId + '\'' + ", date='" + this.ayV + '\'' + '}';
  }
  
  public static class a
    implements Comparator<qvd>
  {
    public int a(qvd paramqvd1, qvd paramqvd2)
    {
      if (paramqvd1.dateTimeMillis == paramqvd2.dateTimeMillis) {
        if (!paramqvd1.aFI) {}
      }
      while (paramqvd1.dateTimeMillis > paramqvd2.dateTimeMillis)
      {
        return -1;
        if (paramqvd2.aFI) {
          return 1;
        }
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvd
 * JD-Core Version:    0.7.0.1
 */