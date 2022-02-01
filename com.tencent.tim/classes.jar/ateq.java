import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;

class ateq
  implements ProtoReqManager.b
{
  ateq(ateh paramateh) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(paramc.clW)) {
      ateh.a(this.this$0, paramc, paramd);
    }
    do
    {
      return;
      if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(paramc.clW))
      {
        ateh.b(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100".equals(paramc.clW))
      {
        ateh.c(this.this$0, paramc, paramd);
        return;
      }
    } while (!"OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200".equals(paramc.clW));
    ateh.d(this.this$0, paramc, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ateq
 * JD-Core Version:    0.7.0.1
 */