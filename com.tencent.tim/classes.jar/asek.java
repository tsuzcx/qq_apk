import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import com.qq.jce.wup.UniPacket;
import java.util.ArrayList;

public abstract class asek
  implements asen
{
  private asel jdField_a_of_type_Asel;
  private asep jdField_a_of_type_Asep;
  
  private void a(MultiVideoMsg paramMultiVideoMsg)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("MultiVideo");
    localUniPacket.setFuncName("MultiVideos2cack");
    localUniPacket.put("MultiVideoMsg", paramMultiVideoMsg);
    bS(localUniPacket.encode());
  }
  
  private void d(SharpVideoMsg paramSharpVideoMsg)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("SharpSvr");
    localUniPacket.setFuncName("s2cack");
    localUniPacket.put("SharpVideoMsg", paramSharpVideoMsg);
    bQ(localUniPacket.encode());
  }
  
  private boolean isMultiVideoMsgSupport(int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Asep != null) {
      bool = this.jdField_a_of_type_Asep.isMultiVideoMsgSupport(paramInt);
    }
    return bool;
  }
  
  private boolean isSharpVideoMsgSupport(int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Asep != null) {
      bool = this.jdField_a_of_type_Asep.isSharpVideoMsgSupport(paramInt);
    }
    return bool;
  }
  
  public void a(asel paramasel)
  {
    this.jdField_a_of_type_Asel = paramasel;
  }
  
  public void a(asep paramasep)
  {
    this.jdField_a_of_type_Asep = paramasep;
  }
  
  public void bJ(byte[] paramArrayOfByte)
  {
    long l = getSelfUin();
    VideoCallMsg localVideoCallMsg = new VideoCallMsg();
    localVideoCallMsg.ver = 1;
    localVideoCallMsg.type = 1;
    localVideoCallMsg.lUin = l;
    localVideoCallMsg.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
    localVideoCallMsg.vMsg = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("VideoSvc");
    paramArrayOfByte.setFuncName("SendVideoMsg");
    paramArrayOfByte.put("VideoCallMsg", localVideoCallMsg);
    bP(paramArrayOfByte.encode());
  }
  
  public void bK(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Asel != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (SharpVideoMsg)localUniPacket.getByClass("SharpVideoMsg", new SharpVideoMsg());
      if (isSharpVideoMsgSupport(paramArrayOfByte.type))
      {
        d(paramArrayOfByte);
        this.jdField_a_of_type_Asel.bK(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void bL(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Asel != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (SharpVideoMsg)localUniPacket.getByClass("SharpVideoMsg", new SharpVideoMsg());
      if (isSharpVideoMsgSupport(paramArrayOfByte.type)) {
        this.jdField_a_of_type_Asel.bL(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void bM(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Asel != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (MultiVideoMsg)localUniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
      asev.d("VideoChannelBase", String.format("receiveMultiVideoMsg type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramArrayOfByte.type), Short.valueOf(paramArrayOfByte.csCmd) }));
      if (isMultiVideoMsgSupport(paramArrayOfByte.type))
      {
        a(paramArrayOfByte);
        this.jdField_a_of_type_Asel.bM(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void bN(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Asel != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (MultiVideoMsg)localUniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
      asev.d("VideoChannelBase", String.format("receiveMultiVideoAck type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramArrayOfByte.type), Short.valueOf(paramArrayOfByte.csCmd) }));
      if (isMultiVideoMsgSupport(paramArrayOfByte.type)) {
        this.jdField_a_of_type_Asel.bN(paramArrayOfByte.video_buff);
      }
    }
  }
  
  public void bO(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Asel != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (VideoCallMsg)localUniPacket.getByClass("VideoCallMsg", new VideoCallMsg());
      this.jdField_a_of_type_Asel.bO(paramArrayOfByte.vMsg);
    }
  }
  
  protected abstract void bP(byte[] paramArrayOfByte);
  
  protected abstract void bQ(byte[] paramArrayOfByte);
  
  protected abstract void bR(byte[] paramArrayOfByte);
  
  protected abstract void bS(byte[] paramArrayOfByte);
  
  public void c(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    long l = getSelfUin();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong1));
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = 0;
    localMultiVideoMsg.type = 1;
    localMultiVideoMsg.csCmd = ((short)(int)paramLong2);
    localMultiVideoMsg.from_uin = l;
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.video_buff = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("MultiVideo");
    paramArrayOfByte.setFuncName("MultiVideoMsg");
    paramArrayOfByte.put("MultiVideoMsg", localMultiVideoMsg);
    bR(paramArrayOfByte.encode());
  }
  
  public void emR()
  {
    emS();
  }
  
  protected abstract void emS();
  
  public void gB(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Asel != null) {
      this.jdField_a_of_type_Asel.gB(paramString, paramInt);
    }
  }
  
  protected abstract long getSelfUin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asek
 * JD-Core Version:    0.7.0.1
 */