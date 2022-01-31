import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

public class vsh
  extends vsn<vsa, vsa>
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<vhy> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public vsh()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public vsh(String paramString, vhy paramvhy, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvhy);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(vsa paramvsa, boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    for (File localFile = new File(paramString);; localFile = null)
    {
      Object localObject2;
      int i;
      if ((paramBoolean) && (localFile != null) && (localFile.exists()) && (localFile.isFile()) && (localFile.length() > 0L))
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.jdField_b_of_type_JavaLangString, ".jpg");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new File((String)localObject1);
          if (localFile.renameTo((File)localObject2))
          {
            ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir success : %s", new Object[] { ((File)localObject2).getPath() });
            paramvsa.jdField_a_of_type_JavaLangString = ((String)localObject1);
            paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
            i = 1;
          }
        }
      }
      while (i != 0)
      {
        ved.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb success ...");
        super.notifyResult(paramvsa);
        return;
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy failed : use the origin instead : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          paramvsa.jdField_a_of_type_JavaLangString = paramString;
          paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
        }
        else
        {
          ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir failed : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          i = 0;
          continue;
          paramvsa.jdField_a_of_type_JavaLangString = paramString;
          paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
          continue;
          i = 0;
        }
      }
      ved.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb failed ...");
      super.notifyError(new ErrorMessage(-1, "GenerateThumbTask error"));
      return;
    }
  }
  
  protected void a(JobContext paramJobContext, vsa paramvsa)
  {
    ved.a("Q.qqstory.publish.edit.GenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    vsg localvsg = paramvsa.jdField_a_of_type_Vsg;
    int i = localvsg.c;
    if (paramvsa.jdField_a_of_type_Int == 1) {
      i = 0;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramJobContext = new vsi(localvsg.jdField_a_of_type_Int, localvsg.jdField_b_of_type_Int, localvsg.jdField_a_of_type_JavaLangString, localvsg.jdField_a_of_type_Float, localvsg.jdField_a_of_type_Boolean, i, localvsg.jdField_a_of_type_Double, localvsg.jdField_b_of_type_Double, localvsg.jdField_b_of_type_JavaLangString, paramvsa.jdField_a_of_type_Int, localvsg.jdField_b_of_type_Boolean);
      if (paramJobContext.a(new Void[0]).intValue() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramvsa, bool, paramJobContext.jdField_a_of_type_JavaLangString);
        return;
      }
    }
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
            str1 = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.jdField_b_of_type_JavaLangString, ".jpg");
          }
          i = new vsi(localBitmap, str1, localvsg.jdField_a_of_type_Int, localvsg.jdField_b_of_type_Int, i, localvsg.jdField_a_of_type_Float, localvsg.jdField_a_of_type_Double, localvsg.jdField_b_of_type_Double, paramvsa.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label327;
          }
          paramvsa.jdField_a_of_type_JavaLangString = str1;
          paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(paramvsa);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label327:
        ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, ajya.a(2131705257) + this.jdField_a_of_type_Int));
      }
      else
      {
        ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, ajya.a(2131705256) + this.jdField_a_of_type_Int));
        return;
      }
    }
    ved.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, ajya.a(2131705260) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsh
 * JD-Core Version:    0.7.0.1
 */