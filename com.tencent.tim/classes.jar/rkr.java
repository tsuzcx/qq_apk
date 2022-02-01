import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class rkr
  extends rkz<rkm, rkm>
{
  private int bsT;
  public WeakReference<Activity> mActivity;
  
  public rkr(@NonNull Activity paramActivity, int paramInt)
  {
    this.mActivity = new WeakReference(paramActivity);
    this.bsT = paramInt;
  }
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    Activity localActivity = (Activity)this.mActivity.get();
    if (localActivity == null)
    {
      ram.e("Q.qqstory.publish.edit.GeneratePicThumbSegment", "ChangePicArgToVideoArgSegment, activity is null");
      super.notifyError(new ErrorMessage(-1, "ChangePicArgToVideoArgSegment error"));
      return;
    }
    Object localObject = paramrkm.jdField_a_of_type_Rkq.aAY;
    paramJobContext = (JobContext)localObject;
    if (!paramrkm.jdField_a_of_type_Rkq.aIF)
    {
      paramJobContext = (JobContext)localObject;
      if (paramrkm.jdField_a_of_type_Rkq.result) {
        paramJobContext = paramrkm.jdField_a_of_type_Rkq.aAZ;
      }
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramJobContext, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if (this.bsT == 5) {}
    for (boolean bool = true;; bool = false)
    {
      paramrkm.jdField_a_of_type_Rks = new rks(localActivity, i, j, paramJobContext, 0.0F, bool, 0, 0.0D, 0.0D, null, false);
      paramrkm.aAT = paramJobContext;
      super.notifyResult(paramrkm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkr
 * JD-Core Version:    0.7.0.1
 */