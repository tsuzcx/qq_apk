import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserSelfInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserSelfInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class qxh
  extends qxm
  implements ppv.b<qxh.a, qxh.b>
{
  private qwy a;
  private boolean isReset;
  
  public qxh(qwy paramqwy)
  {
    this.a = paramqwy;
  }
  
  public static boolean a(qwm paramqwm)
  {
    if (paramqwm == null) {
      throw new IllegalArgumentException("argument can't be null");
    }
    psr localpsr = (psr)psx.a(10);
    paramqwm.fansCount = ((Integer)localpsr.c("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
    if (((Integer)localpsr.c("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramqwm.isVip = bool;
      paramqwm.blJ = ((Integer)localpsr.c("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramqwm.Bs = ((Integer)localpsr.c("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramqwm.ayX = ((String)localpsr.c("qqstory_my_newest_video_cover", ""));
      paramqwm.ayY = ((String)localpsr.c("qqstory_my_newest_video_vid", ""));
      return true;
    }
  }
  
  public void a(@NonNull qxh.a parama, @Nullable qxh.b paramb, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    ram.w("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (isReset())
    {
      ram.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      completed();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      ram.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      f(paramErrorMessage);
      return;
    }
    parama = (ptf)psx.a(2);
    if (parama.b(paramb.unionId) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramb.unionId;
      if (paramb.isVip != 1) {
        break label129;
      }
    }
    for (;;)
    {
      paramErrorMessage.isVip = bool;
      parama.a(paramErrorMessage);
      if (this.a == null) {
        break;
      }
      this.a.L(new GetUserSelfInfoStep.1(this, paramb));
      return;
      label129:
      bool = false;
    }
    ram.b("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramb);
    parama = (psr)psx.a(10);
    parama.n("qqstory_my_fans_count", Integer.valueOf(paramb.fansCount));
    parama.n("qqstory_i_am_vip", Integer.valueOf(paramb.isVip));
    parama.n("qqstory_my_vidoe_count", Integer.valueOf(paramb.aPg));
    parama.n("qqstory_my_visiter_count", Integer.valueOf(paramb.bot));
    parama.n("qqstory_my_newest_video_cover", paramb.ayX);
    parama.n("qqstory_my_newest_video_vid", paramb.ayY);
    QQStoryContext.a().qL(paramb.unionId);
    completed();
  }
  
  public void dump() {}
  
  public String getKey()
  {
    return "GetUserSelfInfoStep";
  }
  
  public boolean isReset()
  {
    try
    {
      boolean bool = this.isReset;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void reset()
  {
    try
    {
      this.isReset = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    ram.w("Q.qqstory.home.GetUserSelfInfoStep", "run");
    qxh.a locala = new qxh.a();
    ppv.a().a(locala, this);
  }
  
  public static class a
    extends ppw<qxh.b>
  {
    public static final String CMD = ppf.fQ("StorySvc.get_user_base_info");
    
    public qxh.b a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspGetUserSelfInfo localRspGetUserSelfInfo = new qqstory_service.RspGetUserSelfInfo();
      try
      {
        localRspGetUserSelfInfo.mergeFrom(paramArrayOfByte);
        return new qxh.b(localRspGetUserSelfInfo);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          ram.e("Q.qqstory.home.GetUserSelfInfoStep", "decodeResponse error=%s", paramArrayOfByte);
        }
      }
    }
    
    protected byte[] encode()
    {
      return new qqstory_service.ReqGetUserSelfInfo().toByteArray();
    }
    
    public String mg()
    {
      return CMD;
    }
  }
  
  public static class b
    extends ppu
  {
    public int aPg;
    public String ayX = "";
    public String ayY = "";
    public int bot;
    public int fansCount;
    public int isVip;
    public String unionId;
    
    public b(qqstory_service.RspGetUserSelfInfo paramRspGetUserSelfInfo)
    {
      Object localObject = paramRspGetUserSelfInfo.result;
      this.errorCode = ((qqstory_struct.ErrorInfo)localObject).error_code.get();
      this.errorMsg = ((qqstory_struct.ErrorInfo)localObject).error_desc.get().toStringUtf8();
      int i;
      if (paramRspGetUserSelfInfo.is_vip.has())
      {
        i = paramRspGetUserSelfInfo.is_vip.get();
        this.isVip = i;
        if (!paramRspGetUserSelfInfo.union_id.has()) {
          break label233;
        }
        localObject = paramRspGetUserSelfInfo.union_id.get().toStringUtf8();
        label96:
        this.unionId = ((String)localObject);
        if (!paramRspGetUserSelfInfo.fans_count.has()) {
          break label240;
        }
        i = paramRspGetUserSelfInfo.fans_count.get();
        label120:
        this.fansCount = i;
        if (!paramRspGetUserSelfInfo.video_count.has()) {
          break label245;
        }
        i = paramRspGetUserSelfInfo.video_count.get();
        label143:
        this.aPg = i;
        i = j;
        if (paramRspGetUserSelfInfo.visit_total_count.has()) {
          i = paramRspGetUserSelfInfo.visit_total_count.get();
        }
        this.bot = i;
        if (!paramRspGetUserSelfInfo.newest_video_cover.has()) {
          break label250;
        }
        localObject = paramRspGetUserSelfInfo.newest_video_cover.get().toStringUtf8();
        label195:
        this.ayX = ((String)localObject);
        if (!paramRspGetUserSelfInfo.newest_video_vid.has()) {
          break label257;
        }
      }
      label257:
      for (paramRspGetUserSelfInfo = paramRspGetUserSelfInfo.newest_video_vid.get().toStringUtf8();; paramRspGetUserSelfInfo = "")
      {
        this.ayY = paramRspGetUserSelfInfo;
        return;
        i = 0;
        break;
        label233:
        localObject = "";
        break label96;
        label240:
        i = 0;
        break label120;
        label245:
        i = 0;
        break label143;
        label250:
        localObject = "";
        break label195;
      }
    }
    
    public String toString()
    {
      return qwr.b(new Object[] { "Response{ isVip=", Integer.valueOf(this.isVip), " fansCount=", Integer.valueOf(this.fansCount), " myVideoCount=", Integer.valueOf(this.aPg), " myVisitTotalCount=", Integer.valueOf(this.bot), " newestVideoCover=", this.ayX, " newestVideoVid=", this.ayY });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxh
 * JD-Core Version:    0.7.0.1
 */