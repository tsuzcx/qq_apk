import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;

public class vso
  extends vsn<vsa, vsa>
{
  public final String a;
  private boolean a;
  
  public vso(String paramString)
  {
    this(true, paramString);
  }
  
  public vso(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public vso(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, vsa paramvsa)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramvsa.jdField_a_of_type_Boolean)) {
      ved.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = vxv.a(vxv.c(paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_AndroidGraphicsBitmap, paramvsa.jdField_a_of_type_Vse.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        avtd.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        ved.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, ajya.a(2131706562)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        ved.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_Int > 0)
      {
        ved.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = vxv.a(paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            ved.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        ved.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_JavaLangString;
        vej.b("0X80075C9");
        paramvsa.jdField_a_of_type_Vse.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramvsa.jdField_a_of_type_Vse.jdField_b_of_type_JavaLangString = paramJobContext;
    paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_Boolean = bool1;
    if ((paramvsa.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramvsa, paramvsa.jdField_a_of_type_Vse.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramvsa);
  }
  
  public void a(vsa paramvsa, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b != 4.9E-324D) && (((EditTakePhotoSource)paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b;
      d2 = ((EditTakePhotoSource)paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!bhol.a(paramString1, paramString2)) {
          bhol.b(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        bhol.b(paramString2, d2, d1);
        return;
      } while ((!(paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a())) || (bhol.a(paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a(), paramString2)));
      paramvsa = ((EditLocalPhotoSource)paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    } while (paramvsa == null);
    bhol.a(paramString2, paramvsa.longitude / 1000000.0D, paramvsa.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vso
 * JD-Core Version:    0.7.0.1
 */