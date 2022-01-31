import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class vsl
  extends vsn<vsa, vsa>
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<vhy> jdField_a_of_type_JavaLangRefWeakReference;
  
  public vsl(String paramString, vhy paramvhy, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvhy);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, vsa paramvsa)
  {
    ved.a("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    vsg localvsg = paramvsa.jdField_a_of_type_Vsg;
    int i = localvsg.c;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      paramJobContext = (vhy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    while (paramJobContext != null)
    {
      Bitmap localBitmap = paramJobContext.a(this.jdField_a_of_type_Int);
      if (localBitmap != null)
      {
        try
        {
          String str2 = this.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (str2 == null) {
            str1 = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.b, ".jpg");
          }
          i = new vsi(localBitmap, str1, localvsg.jdField_a_of_type_Int, localvsg.jdField_b_of_type_Int, i, localvsg.jdField_a_of_type_Float, localvsg.jdField_a_of_type_Double, localvsg.jdField_b_of_type_Double, paramvsa.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label217;
          }
          paramvsa.jdField_a_of_type_JavaLangString = str1;
          paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          ved.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(paramvsa);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label217:
        ved.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, ajya.a(2131705687) + this.jdField_a_of_type_Int));
      }
      else
      {
        ved.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, ajya.a(2131705692) + this.jdField_a_of_type_Int));
        return;
      }
    }
    ved.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, ajya.a(2131705688) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsl
 * JD-Core Version:    0.7.0.1
 */