import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class yjm
  extends yju<yjh, yjh>
{
  private int a;
  public WeakReference<Activity> a;
  
  public yjm(@NonNull Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, yjh paramyjh)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null)
    {
      xvv.e("Q.qqstory.publish.edit.GeneratePicThumbSegment", "ChangePicArgToVideoArgSegment, activity is null");
      super.notifyError(new ErrorMessage(-1, "ChangePicArgToVideoArgSegment error"));
      return;
    }
    Object localObject = paramyjh.jdField_a_of_type_Yjl.jdField_a_of_type_JavaLangString;
    paramJobContext = (JobContext)localObject;
    if (!paramyjh.jdField_a_of_type_Yjl.jdField_b_of_type_Boolean)
    {
      paramJobContext = (JobContext)localObject;
      if (paramyjh.jdField_a_of_type_Yjl.jdField_a_of_type_Boolean) {
        paramJobContext = paramyjh.jdField_a_of_type_Yjl.jdField_b_of_type_JavaLangString;
      }
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramJobContext, (BitmapFactory.Options)localObject);
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    if (this.jdField_a_of_type_Int == 5) {}
    for (boolean bool = true;; bool = false)
    {
      paramyjh.jdField_a_of_type_Yjn = new yjn(localActivity, i, j, paramJobContext, 0.0F, bool, 0, 0.0D, 0.0D, null, false);
      paramyjh.jdField_a_of_type_JavaLangString = paramJobContext;
      super.notifyResult(paramyjh);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjm
 * JD-Core Version:    0.7.0.1
 */