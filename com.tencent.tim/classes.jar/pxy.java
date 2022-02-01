import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqForbidVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspForbidVideo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;

public class pxy
  implements ppv.b<pxy.a, pxy.b>
{
  public void a(@NonNull pxy.a parama, @Nullable pxy.b paramb, @NonNull ErrorMessage paramErrorMessage)
  {
    new pxy.c(paramErrorMessage, parama.vid);
  }
  
  public void rz(String paramString)
  {
    paramString = new pxy.a(paramString);
    ppv.a().a(paramString, this);
  }
  
  public class a
    extends ppw<pxy.b>
  {
    public final String CMD = ppf.fQ("StorySvc.forbid_video");
    public String vid = "";
    
    public a(String paramString)
    {
      this.vid = paramString;
    }
    
    public pxy.b a(byte[] paramArrayOfByte)
    {
      qqstory_service.RspForbidVideo localRspForbidVideo = new qqstory_service.RspForbidVideo();
      try
      {
        localRspForbidVideo.mergeFrom(paramArrayOfByte);
        return new pxy.b(pxy.this, localRspForbidVideo);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    
    protected byte[] encode()
    {
      qqstory_service.ReqForbidVideo localReqForbidVideo = new qqstory_service.ReqForbidVideo();
      localReqForbidVideo.vid.set(this.vid);
      return localReqForbidVideo.toByteArray();
    }
    
    public String mg()
    {
      return this.CMD;
    }
    
    public String toString()
    {
      return "ReportIgnoreVideoRequest{, vid='" + this.vid + '\'' + '}';
    }
  }
  
  public class b
    extends ppu
  {
    public b(qqstory_service.RspForbidVideo paramRspForbidVideo)
    {
      super();
    }
  }
  
  public static class c
    extends plt
  {
    public final String vid;
    
    public c(ErrorMessage paramErrorMessage, String paramString)
    {
      this.b = paramErrorMessage;
      this.vid = paramString;
    }
    
    public String toString()
    {
      return "ReportEvent{vid='" + this.vid + '\'' + "} ";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxy
 * JD-Core Version:    0.7.0.1
 */