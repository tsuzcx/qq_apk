import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class ayqi
  extends ayqr<ayqb, ayqb>
{
  private int bsT;
  public WeakReference<Activity> mActivity;
  
  public ayqi(@NonNull Activity paramActivity, int paramInt)
  {
    this.mActivity = new WeakReference(paramActivity);
    this.bsT = paramInt;
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    Activity localActivity = (Activity)this.mActivity.get();
    if (localActivity == null)
    {
      ram.e("Q.qqstory.publish.edit.GeneratePicThumbSegment", "ChangePicArgToVideoArgSegment, activity is null");
      super.notifyError(new ErrorMessage(-1, "ChangePicArgToVideoArgSegment error"));
      return;
    }
    Object localObject = paramayqb.jdField_a_of_type_Ayqh.aAY;
    paramJobContext = (JobContext)localObject;
    if (!paramayqb.jdField_a_of_type_Ayqh.aIF)
    {
      paramJobContext = (JobContext)localObject;
      if (paramayqb.jdField_a_of_type_Ayqh.result) {
        paramJobContext = paramayqb.jdField_a_of_type_Ayqh.aAZ;
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
      paramayqb.jdField_a_of_type_Ayqj = new ayqj(localActivity, i, j, paramJobContext, 0.0F, bool, 0, 0.0D, 0.0D, null, false);
      paramayqb.aAT = paramJobContext;
      super.notifyResult(paramayqb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqi
 * JD-Core Version:    0.7.0.1
 */