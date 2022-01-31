import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;

public class xlp
  extends xlo<xlb, xlb>
{
  public final String a;
  private boolean a;
  
  public xlp(String paramString)
  {
    this(true, paramString);
  }
  
  public xlp(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public xlp(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, xlb paramxlb)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = xlr.a(paramxlb.jdField_a_of_type_Int, paramxlb.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramxlb.jdField_a_of_type_Boolean)) {
      wxe.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = xqw.a(xqw.c(paramxlb.jdField_a_of_type_Xlf.jdField_a_of_type_AndroidGraphicsBitmap, paramxlb.jdField_a_of_type_Xlf.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        axpl.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        wxe.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, alud.a(2131706946)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        wxe.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramxlb.jdField_a_of_type_Xlf.jdField_a_of_type_Int > 0)
      {
        wxe.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = xqw.a(paramxlb.jdField_a_of_type_Xlf.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            wxe.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        wxe.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramxlb.jdField_a_of_type_Xlf.jdField_a_of_type_JavaLangString;
        wxk.b("0X80075C9");
        paramxlb.jdField_a_of_type_Xlf.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramxlb.jdField_a_of_type_Xlf.jdField_b_of_type_JavaLangString = paramJobContext;
    paramxlb.jdField_a_of_type_Xlf.jdField_a_of_type_Boolean = bool1;
    if ((paramxlb.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramxlb, paramxlb.jdField_a_of_type_Xlf.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramxlb);
  }
  
  public void a(xlb paramxlb, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b != 4.9E-324D) && (((EditTakePhotoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b;
      d2 = ((EditTakePhotoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!bjud.a(paramString1, paramString2)) {
          bjud.b(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        bjud.b(paramString2, d2, d1);
        return;
      } while ((!(paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a())) || (bjud.a(paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a(), paramString2)));
      paramxlb = ((EditLocalPhotoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    } while (paramxlb == null);
    bjud.a(paramString2, paramxlb.longitude / 1000000.0D, paramxlb.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xlp
 * JD-Core Version:    0.7.0.1
 */