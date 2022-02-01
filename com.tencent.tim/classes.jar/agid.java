import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;

class agid
  implements ProtoReqManager.b
{
  agid(agib paramagib) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100".equals(paramc.clW)) {
      agib.a(this.this$0, paramc, paramd);
    }
    do
    {
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200".equals(paramc.clW))
      {
        agib.b(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500".equals(paramc.clW))
      {
        agib.c(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(paramc.clW))
      {
        agib.d(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramc.clW))
      {
        agib.e(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000".equals(paramc.clW))
      {
        agib.f(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(paramc.clW))
      {
        agib.g(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(paramc.clW))
      {
        agib.h(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100".equals(paramc.clW))
      {
        agib.i(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900".equals(paramc.clW))
      {
        agib.j(this.this$0, paramc, paramd);
        return;
      }
      if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(paramc.clW))
      {
        agib.k(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600".equals(paramc.clW))
      {
        agib.l(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(paramc.clW))
      {
        agib.m(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800".equals(paramc.clW))
      {
        agib.n(this.this$0, paramc, paramd);
        return;
      }
      if ("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ".equals(paramc.clW))
      {
        agib.o(this.this$0, paramc, paramd);
        return;
      }
    } while (!"OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400".equals(paramc.clW));
    agib.p(this.this$0, paramc, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agid
 * JD-Core Version:    0.7.0.1
 */