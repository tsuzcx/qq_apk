import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeWatched;

public class wnh
  extends wfh
{
  public wnh(qqstory_service.RspMsgTabNodeWatched paramRspMsgTabNodeWatched)
  {
    super(paramRspMsgTabNodeWatched.result);
  }
  
  public String toString()
  {
    return "MsgTabNodeWatchedResponse{errorCode=" + this.a + ", errorMsg='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnh
 * JD-Core Version:    0.7.0.1
 */