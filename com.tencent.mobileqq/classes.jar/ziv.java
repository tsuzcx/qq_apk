import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;

public class ziv
  extends ziu<zih, zih>
{
  public final String a;
  private boolean a;
  
  public ziv(String paramString)
  {
    this(true, paramString);
  }
  
  public ziv(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public ziv(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, zih paramzih)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = zix.a(paramzih.jdField_a_of_type_Int, paramzih.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramzih.jdField_a_of_type_Boolean)) {
      yuk.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = zoc.a(zoc.c(paramzih.jdField_a_of_type_Zil.jdField_a_of_type_AndroidGraphicsBitmap, paramzih.jdField_a_of_type_Zil.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        bbgf.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        yuk.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, anzj.a(2131705444)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        yuk.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramzih.jdField_a_of_type_Zil.jdField_a_of_type_Int > 0)
      {
        yuk.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = zoc.a(paramzih.jdField_a_of_type_Zil.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            yuk.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        yuk.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramzih.jdField_a_of_type_Zil.jdField_a_of_type_JavaLangString;
        yuq.b("0X80075C9");
        paramzih.jdField_a_of_type_Zil.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramzih.jdField_a_of_type_Zil.jdField_b_of_type_JavaLangString = paramJobContext;
    paramzih.jdField_a_of_type_Zil.jdField_a_of_type_Boolean = bool1;
    if ((paramzih.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramzih, paramzih.jdField_a_of_type_Zil.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramzih);
  }
  
  public void a(zih paramzih, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b != 4.9E-324D) && (((EditTakePhotoSource)paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b;
      d2 = ((EditTakePhotoSource)paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!bnjp.a(paramString1, paramString2)) {
          bnjp.b(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        bnjp.b(paramString2, d2, d1);
        return;
      } while ((!(paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a())) || (bnjp.a(paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a(), paramString2)));
      paramzih = ((EditLocalPhotoSource)paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    } while (paramzih == null);
    bnjp.a(paramString2, paramzih.longitude / 1000000.0D, paramzih.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ziv
 * JD-Core Version:    0.7.0.1
 */