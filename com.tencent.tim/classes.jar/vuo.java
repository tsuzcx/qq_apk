import android.os.Bundle;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.mobileqq.app.SignatureManager.SigComments;
import java.util.List;

public class vuo
  extends aclv
{
  public vuo(SigCommentListActivity paramSigCommentListActivity) {}
  
  protected void C(boolean paramBoolean, Object paramObject)
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
        localList = this.a.a.dy();
        if (paramObject.size() <= 0) {
          break label128;
        }
        if (localList == null) {
          break label113;
        }
        localList.addAll(localList.size(), paramObject);
        this.a.a.setData(localList, paramBoolean);
        this.a.a.notifyDataSetChanged();
      }
    }
    label113:
    do
    {
      return;
      this.a.a.setData(paramObject, paramBoolean);
      break;
      if ((localList != null) && (localList.size() > 0)) {
        this.a.a.setData(localList, paramBoolean);
      }
      for (;;)
      {
        this.a.a.notifyDataSetChanged();
        return;
        SigCommentListActivity.a(this.a, 3);
      }
      paramObject = this.a.a.dy();
    } while ((paramObject != null) && (paramObject.size() > 0));
    label128:
    label175:
    SigCommentListActivity.a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vuo
 * JD-Core Version:    0.7.0.1
 */