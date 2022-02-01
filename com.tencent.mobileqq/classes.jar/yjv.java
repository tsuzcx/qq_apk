import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;
import cooperation.qzone.util.GpsComplementUtil;

public class yjv
  extends yju<yjh, yjh>
{
  public final String a;
  private boolean a;
  
  public yjv(String paramString)
  {
    this(true, paramString);
  }
  
  public yjv(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public yjv(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, yjh paramyjh)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = yjx.a(paramyjh.jdField_a_of_type_Int, paramyjh.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramyjh.jdField_a_of_type_Boolean)) {
      xvv.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = yoy.a(yoy.c(paramyjh.jdField_a_of_type_Yjl.jdField_a_of_type_AndroidGraphicsBitmap, paramyjh.jdField_a_of_type_Yjl.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        babc.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        xvv.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, amtj.a(2131705674)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        xvv.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramyjh.jdField_a_of_type_Yjl.jdField_a_of_type_Int > 0)
      {
        xvv.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = yoy.a(paramyjh.jdField_a_of_type_Yjl.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            xvv.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        xvv.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramyjh.jdField_a_of_type_Yjl.jdField_a_of_type_JavaLangString;
        xwb.b("0X80075C9");
        paramyjh.jdField_a_of_type_Yjl.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramyjh.jdField_a_of_type_Yjl.jdField_b_of_type_JavaLangString = paramJobContext;
    paramyjh.jdField_a_of_type_Yjl.jdField_a_of_type_Boolean = bool1;
    if ((paramyjh.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramyjh, paramyjh.jdField_a_of_type_Yjl.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramyjh);
  }
  
  public void a(yjh paramyjh, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).b != 4.9E-324D) && (((EditTakePhotoSource)paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).b;
      d2 = ((EditTakePhotoSource)paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!GpsComplementUtil.complementByExif(paramString1, paramString2)) {
          GpsComplementUtil.complementByLocal(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        GpsComplementUtil.complementByLocal(paramString2, d2, d1);
        return;
      } while ((!(paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath())) || (GpsComplementUtil.complementByExif(paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath(), paramString2)));
      paramyjh = ((EditLocalPhotoSource)paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).a;
    } while (paramyjh == null);
    GpsComplementUtil.complementByDB(paramString2, paramyjh.longitude / 1000000.0D, paramyjh.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjv
 * JD-Core Version:    0.7.0.1
 */