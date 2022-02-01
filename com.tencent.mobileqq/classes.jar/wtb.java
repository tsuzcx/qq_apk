import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;

public class wtb
  extends wla
{
  public wtb(qqstory_service.RspMsgTabNodeWatched paramRspMsgTabNodeWatched)
  {
    super(paramRspMsgTabNodeWatched.result);
  }
  
  public String toString()
  {
    return "MsgTabNodeWatchedResponse{errorCode=" + this.a + ", errorMsg='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtb
 * JD-Core Version:    0.7.0.1
 */