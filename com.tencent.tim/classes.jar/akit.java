import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.ilive_feeds_read.FeedsInfo;
import com.tencent.pb.now.ilive_feeds_read.ReadNearUserFeedsReq;
import com.tencent.pb.now.ilive_feeds_write.DelFeedReq;
import com.tencent.pb.now.ilive_feeds_write.DelFeedStuct;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class akit
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, akit.b paramb)
  {
    ilive_feeds_read.ReadNearUserFeedsReq localReadNearUserFeedsReq = new ilive_feeds_read.ReadNearUserFeedsReq();
    try
    {
      localReadNearUserFeedsReq.uin.set(Long.valueOf(paramString).longValue());
      localReadNearUserFeedsReq.pos.set(paramInt2);
      localReadNearUserFeedsReq.num.set(paramInt3);
      localReadNearUserFeedsReq.nowid.set(paramLong);
      localReadNearUserFeedsReq.id_type.set(paramInt1);
      paramString = SosoInterface.c();
      if ((paramString != null) && (paramString.a != null))
      {
        paramString = paramString.a;
        localReadNearUserFeedsReq.lat.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString.cd)));
        localReadNearUserFeedsReq.lng.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString.ce)));
        if (QLog.isColorLevel()) {
          QLog.i("NearbyMomentProtocol", 2, "getMomentList, req.lat=" + paramString.cd + ",req.lng=" + paramString.ce);
        }
      }
      new ajwu(paramQQAppInterface).a(24624).b(10).a(new akiv(paramInt2, paramb)).a(new akiu(paramb, paramInt2)).a(localReadNearUserFeedsReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      QLog.i("NearbyMomentProtocol", 1, "getNearbyMomentsList, transfer uin error, uin=" + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, akit.a parama)
  {
    ilive_feeds_write.DelFeedReq localDelFeedReq = new ilive_feeds_write.DelFeedReq();
    ilive_feeds_write.DelFeedStuct localDelFeedStuct = new ilive_feeds_write.DelFeedStuct();
    localDelFeedStuct.feed_id.set(ByteStringMicro.copyFromUtf8(paramString));
    localDelFeedStuct.timestamp.set(paramLong);
    localDelFeedStuct.feed_type.set(paramInt);
    localDelFeedReq.del_type.set(2);
    localDelFeedReq.select_all.set(0);
    localDelFeedReq.del_st.get().add(localDelFeedStuct);
    localDelFeedReq.uid.set(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue());
    new ajwu(paramQQAppInterface).a(22528).b(5).a(new akix(parama, paramString)).a(new akiw(parama, paramString)).a(localDelFeedReq.toByteArray());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, akit.c paramc)
  {
    new ajww(paramQQAppInterface).a(paramString, new akiy(paramc), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, akit.d paramd)
  {
    new ajww(paramQQAppInterface).b(paramString, new akiz(paramd), null);
  }
  
  public static abstract interface a
  {
    public abstract void y(boolean paramBoolean, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void c(boolean paramBoolean1, List<ilive_feeds_read.FeedsInfo> paramList, boolean paramBoolean2, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void bv(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bv(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akit
 * JD-Core Version:    0.7.0.1
 */