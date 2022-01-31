import android.os.Bundle;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.adapter.SigCommentSessionListAdapter;
import com.tencent.mobileqq.app.SignatureManager.SigComments;
import com.tencent.mobileqq.app.SignatureObserver;
import java.util.List;

public class txh
  extends SignatureObserver
{
  public txh(SigCommentListActivity paramSigCommentListActivity) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    List localList;
    if (this.a.isResume())
    {
      this.a.stopTitleProgress();
      if (!paramBoolean) {
        break label175;
      }
      if ((paramObject instanceof Bundle))
      {
        paramObject = (SignatureManager.SigComments)((Bundle)paramObject).getSerializable("data");
        paramBoolean = paramObject.isOver;
        paramObject = paramObject.mlist;
        localList = this.a.a.a();
        if (paramObject.size() <= 0) {
          break label128;
        }
        if (localList == null) {
          break label113;
        }
        localList.addAll(localList.size(), paramObject);
        this.a.a.a(localList, paramBoolean);
        this.a.a.notifyDataSetChanged();
      }
    }
    label113:
    do
    {
      return;
      this.a.a.a(paramObject, paramBoolean);
      break;
      if ((localList != null) && (localList.size() > 0)) {
        this.a.a.a(localList, paramBoolean);
      }
      for (;;)
      {
        this.a.a.notifyDataSetChanged();
        return;
        SigCommentListActivity.a(this.a, 3);
      }
      paramObject = this.a.a.a();
    } while ((paramObject != null) && (paramObject.size() > 0));
    label128:
    label175:
    SigCommentListActivity.a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txh
 * JD-Core Version:    0.7.0.1
 */