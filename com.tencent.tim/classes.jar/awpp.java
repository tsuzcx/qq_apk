import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

final class awpp
{
  private static final AtomicInteger aW = new AtomicInteger(0);
  private final WeiyunPB.MsgHead a;
  private final byte[] mData;
  
  awpp(int paramInt, byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
    this.a = a(paramInt);
  }
  
  awpp(WeiyunPB.MsgHead paramMsgHead, byte[] paramArrayOfByte)
  {
    this.a = paramMsgHead;
    this.mData = paramArrayOfByte;
  }
  
  private WeiyunPB.MsgHead a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    WeiyunPB.MsgHead localMsgHead = new WeiyunPB.MsgHead();
    localMsgHead.uin.set(localAppRuntime.getLongAccountUin());
    localMsgHead.seq.set(getSeq());
    localMsgHead.type.set(1);
    localMsgHead.cmd.set(paramInt);
    localMsgHead.emulator_flag.set(0);
    localMsgHead.appid.set(31532);
    localMsgHead.encrypt.set(0);
    localMsgHead.zip_flag.set(0);
    localMsgHead.version.set(awrc.Qt());
    localMsgHead.fix_version.set(awrc.Qu());
    localMsgHead.nettype.set(jqi.getNetworkType(localAppRuntime.getApplication()));
    localMsgHead.major_version.set(awrc.getMajorVersion());
    localMsgHead.minor_version.set(awrc.getMinorVersion());
    return localMsgHead;
  }
  
  public WeiyunPB.MsgHead a()
  {
    return this.a;
  }
  
  public byte[] getData()
  {
    return this.mData;
  }
  
  public int getSeq()
  {
    return aW.getAndIncrement();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpp
 * JD-Core Version:    0.7.0.1
 */