import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;
import cooperation.qzone.util.GpsComplementUtil;

public class yyo
  extends yyn<yya, yya>
{
  public final String a;
  private boolean a;
  
  public yyo(String paramString)
  {
    this(true, paramString);
  }
  
  public yyo(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public yyo(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, yya paramyya)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramyya.jdField_a_of_type_Boolean)) {
      ykq.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = zdr.a(zdr.c(paramyya.jdField_a_of_type_Yye.jdField_a_of_type_AndroidGraphicsBitmap, paramyya.jdField_a_of_type_Yye.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        bbhl.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        ykq.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, anvx.a(2131706025)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        ykq.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramyya.jdField_a_of_type_Yye.jdField_a_of_type_Int > 0)
      {
        ykq.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = zdr.a(paramyya.jdField_a_of_type_Yye.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            ykq.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        ykq.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramyya.jdField_a_of_type_Yye.jdField_a_of_type_JavaLangString;
        ykw.b("0X80075C9");
        paramyya.jdField_a_of_type_Yye.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramyya.jdField_a_of_type_Yye.jdField_b_of_type_JavaLangString = paramJobContext;
    paramyya.jdField_a_of_type_Yye.jdField_a_of_type_Boolean = bool1;
    if ((paramyya.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramyya, paramyya.jdField_a_of_type_Yye.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramyya);
  }
  
  public void a(yya paramyya, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).b != 4.9E-324D) && (((EditTakePhotoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).b;
      d2 = ((EditTakePhotoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).a;
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
      } while ((!(paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath())) || (GpsComplementUtil.complementByExif(paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath(), paramString2)));
      paramyya = ((EditLocalPhotoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource).a;
    } while (paramyya == null);
    GpsComplementUtil.complementByDB(paramString2, paramyya.longitude / 1000000.0D, paramyya.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyo
 * JD-Core Version:    0.7.0.1
 */