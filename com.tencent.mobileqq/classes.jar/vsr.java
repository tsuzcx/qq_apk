import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;

public class vsr
  extends vsq<vsd, vsd>
{
  public final String a;
  private boolean a;
  
  public vsr(String paramString)
  {
    this(true, paramString);
  }
  
  public vsr(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public vsr(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, vsd paramvsd)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = vst.a(paramvsd.jdField_a_of_type_Int, paramvsd.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramvsd.jdField_a_of_type_Boolean)) {
      veg.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = vxy.a(vxy.c(paramvsd.jdField_a_of_type_Vsh.jdField_a_of_type_AndroidGraphicsBitmap, paramvsd.jdField_a_of_type_Vsh.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        avtb.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        veg.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, ajyc.a(2131706551)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        veg.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramvsd.jdField_a_of_type_Vsh.jdField_a_of_type_Int > 0)
      {
        veg.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = vxy.a(paramvsd.jdField_a_of_type_Vsh.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            veg.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        veg.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramvsd.jdField_a_of_type_Vsh.jdField_a_of_type_JavaLangString;
        vem.b("0X80075C9");
        paramvsd.jdField_a_of_type_Vsh.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramvsd.jdField_a_of_type_Vsh.jdField_b_of_type_JavaLangString = paramJobContext;
    paramvsd.jdField_a_of_type_Vsh.jdField_a_of_type_Boolean = bool1;
    if ((paramvsd.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramvsd, paramvsd.jdField_a_of_type_Vsh.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramvsd);
  }
  
  public void a(vsd paramvsd, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b != 4.9E-324D) && (((EditTakePhotoSource)paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b;
      d2 = ((EditTakePhotoSource)paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!bhnu.a(paramString1, paramString2)) {
          bhnu.b(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        bhnu.b(paramString2, d2, d1);
        return;
      } while ((!(paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a())) || (bhnu.a(paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a(), paramString2)));
      paramvsd = ((EditLocalPhotoSource)paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    } while (paramvsd == null);
    bhnu.a(paramString2, paramvsd.longitude / 1000000.0D, paramvsd.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsr
 * JD-Core Version:    0.7.0.1
 */