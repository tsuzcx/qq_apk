import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class yyf
  extends yyn<yya, yya>
{
  private int a;
  public WeakReference<Activity> a;
  
  public yyf(@NonNull Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, yya paramyya)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null)
    {
      ykq.e("Q.qqstory.publish.edit.GeneratePicThumbSegment", "ChangePicArgToVideoArgSegment, activity is null");
      super.notifyError(new ErrorMessage(-1, "ChangePicArgToVideoArgSegment error"));
      return;
    }
    Object localObject = paramyya.jdField_a_of_type_Yye.jdField_a_of_type_JavaLangString;
    paramJobContext = (JobContext)localObject;
    if (!paramyya.jdField_a_of_type_Yye.jdField_b_of_type_Boolean)
    {
      paramJobContext = (JobContext)localObject;
      if (paramyya.jdField_a_of_type_Yye.jdField_a_of_type_Boolean) {
        paramJobContext = paramyya.jdField_a_of_type_Yye.jdField_b_of_type_JavaLangString;
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
      paramyya.jdField_a_of_type_Yyg = new yyg(localActivity, i, j, paramJobContext, 0.0F, bool, 0, 0.0D, 0.0D, null, false);
      paramyya.jdField_a_of_type_JavaLangString = paramJobContext;
      super.notifyResult(paramyya);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyf
 * JD-Core Version:    0.7.0.1
 */