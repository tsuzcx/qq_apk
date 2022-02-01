import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class puw
  implements ppv.b<pvg, pvg.a>
{
  puw(puv parampuv, puh parampuh) {}
  
  public void a(@NonNull pvg parampvg, @Nullable pvg.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((parama == null) || (paramErrorMessage.isFail()))
    {
      ram.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, err=" + paramErrorMessage.getErrorMessage() + " node:" + this.e);
      puv.a(this.a, paramErrorMessage);
      return;
    }
    if (parama.a.video_list.size() == 0)
    {
      if (this.e.nodeType != 5)
      {
        ram.e("Q.qqstory.msgTab.jobPullVidList", "pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=" + this.e + ", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, " + paramErrorMessage.getErrorMessage());
        puv.b(this.a, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
        return;
      }
      puv.a(this.a, puv.an(parama.mD));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "pull succeed, info=" + this.e);
    }
    puy.a(this.e, parama.bB);
    parampvg = puv.an(parama.mD);
    if (this.e.nodeType == 12) {}
    puv.b(this.a, parampvg);
    if (this.e.nodeType == 12) {
      if (this.a.a != null)
      {
        this.a.a.mCookie = parama.a.cookie.get();
        parampvg = this.a.a;
        if (parama.a.is_end.get() <= 0) {
          break label345;
        }
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      parampvg.mIsEnd = bool;
      this.e.ava = parama.a.cookie.get();
      if (!QLog.isColorLevel()) {
        break;
      }
      ram.b("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.e.unionId, parama.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puw
 * JD-Core Version:    0.7.0.1
 */