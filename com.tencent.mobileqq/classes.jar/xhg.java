import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;

public class xhg
  extends xhf<xgs, xgs>
{
  public final String a;
  private boolean a;
  
  public xhg(String paramString)
  {
    this(true, paramString);
  }
  
  public xhg(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public xhg(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, xgs paramxgs)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = xhi.a(paramxgs.jdField_a_of_type_Int, paramxgs.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramxgs.jdField_a_of_type_Boolean)) {
      wsv.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = xmn.a(xmn.c(paramxgs.jdField_a_of_type_Xgw.jdField_a_of_type_AndroidGraphicsBitmap, paramxgs.jdField_a_of_type_Xgw.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        axlc.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        wsv.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, alpo.a(2131706934)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        wsv.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramxgs.jdField_a_of_type_Xgw.jdField_a_of_type_Int > 0)
      {
        wsv.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = xmn.a(paramxgs.jdField_a_of_type_Xgw.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            wsv.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        wsv.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramxgs.jdField_a_of_type_Xgw.jdField_a_of_type_JavaLangString;
        wtb.b("0X80075C9");
        paramxgs.jdField_a_of_type_Xgw.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramxgs.jdField_a_of_type_Xgw.jdField_b_of_type_JavaLangString = paramJobContext;
    paramxgs.jdField_a_of_type_Xgw.jdField_a_of_type_Boolean = bool1;
    if ((paramxgs.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramxgs, paramxgs.jdField_a_of_type_Xgw.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramxgs);
  }
  
  public void a(xgs paramxgs, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b != 4.9E-324D) && (((EditTakePhotoSource)paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b;
      d2 = ((EditTakePhotoSource)paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!bjpw.a(paramString1, paramString2)) {
          bjpw.b(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        bjpw.b(paramString2, d2, d1);
        return;
      } while ((!(paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a())) || (bjpw.a(paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a(), paramString2)));
      paramxgs = ((EditLocalPhotoSource)paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    } while (paramxgs == null);
    bjpw.a(paramString2, paramxgs.longitude / 1000000.0D, paramxgs.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhg
 * JD-Core Version:    0.7.0.1
 */