import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;

class atsu
  implements ProtoReqManager.b
{
  atsu(atsq paramatsq) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500".equals(paramc.clW)) {
      atsq.a(this.this$0, paramc, paramd);
    }
    do
    {
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(paramc.clW))
      {
        atsq.b(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramc.clW))
      {
        atsq.c(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000".equals(paramc.clW))
      {
        atsq.d(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(paramc.clW))
      {
        atsq.e(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(paramc.clW))
      {
        atsq.f(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100".equals(paramc.clW))
      {
        atsq.g(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900".equals(paramc.clW))
      {
        atsq.h(this.this$0, paramc, paramd);
        return;
      }
      if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(paramc.clW))
      {
        atsq.i(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600".equals(paramc.clW))
      {
        atsq.j(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(paramc.clW))
      {
        atsq.k(this.this$0, paramc, paramd);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800".equals(paramc.clW))
      {
        atsq.l(this.this$0, paramc, paramd);
        return;
      }
      if ("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ".equals(paramc.clW))
      {
        atsq.m(this.this$0, paramc, paramd);
        return;
      }
    } while (!"OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400".equals(paramc.clW));
    atsq.n(this.this$0, paramc, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsu
 * JD-Core Version:    0.7.0.1
 */