import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;

public class vfv
  extends vfu<vfh, vfh>
{
  public final String a;
  private boolean a;
  
  public vfv(String paramString)
  {
    this(true, paramString);
  }
  
  public vfv(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public vfv(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, vfh paramvfh)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = vfx.a(paramvfh.jdField_a_of_type_Int, paramvfh.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramvfh.jdField_a_of_type_Boolean)) {
      urk.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = vlc.a(vlc.c(paramvfh.jdField_a_of_type_Vfl.jdField_a_of_type_AndroidGraphicsBitmap, paramvfh.jdField_a_of_type_Vfl.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        auts.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        urk.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, ajjy.a(2131640766)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        urk.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramvfh.jdField_a_of_type_Vfl.jdField_a_of_type_Int > 0)
      {
        urk.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = vlc.a(paramvfh.jdField_a_of_type_Vfl.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            urk.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        urk.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramvfh.jdField_a_of_type_Vfl.jdField_a_of_type_JavaLangString;
        urq.b("0X80075C9");
        paramvfh.jdField_a_of_type_Vfl.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramvfh.jdField_a_of_type_Vfl.jdField_b_of_type_JavaLangString = paramJobContext;
    paramvfh.jdField_a_of_type_Vfl.jdField_a_of_type_Boolean = bool1;
    if ((paramvfh.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramvfh, paramvfh.jdField_a_of_type_Vfl.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramvfh);
  }
  
  public void a(vfh paramvfh, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b != 4.9E-324D) && (((EditTakePhotoSource)paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b;
      d2 = ((EditTakePhotoSource)paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!bgff.a(paramString1, paramString2)) {
          bgff.b(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        bgff.b(paramString2, d2, d1);
        return;
      } while ((!(paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a())) || (bgff.a(paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a(), paramString2)));
      paramvfh = ((EditLocalPhotoSource)paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    } while (paramvfh == null);
    bgff.a(paramString2, paramvfh.longitude / 1000000.0D, paramvfh.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfv
 * JD-Core Version:    0.7.0.1
 */