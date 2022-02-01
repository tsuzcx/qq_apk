import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;

public class zfa
  extends zez<zem, zem>
{
  public final String a;
  private boolean a;
  
  public zfa(String paramString)
  {
    this(true, paramString);
  }
  
  public zfa(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public zfa(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, zem paramzem)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.jdField_a_of_type_JavaLangString;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = zfc.a(paramzem.jdField_a_of_type_Int, paramzem.jdField_b_of_type_JavaLangString, ".jpg");
    }
    if ((this.jdField_a_of_type_Boolean) && (paramzem.jdField_a_of_type_Boolean)) {
      yqp.b("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = zkh.a(zkh.c(paramzem.jdField_a_of_type_Zeq.jdField_a_of_type_AndroidGraphicsBitmap, paramzem.jdField_a_of_type_Zeq.jdField_b_of_type_AndroidGraphicsBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        banm.d = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        yqp.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, anni.a(2131705337)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        yqp.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramzem.jdField_a_of_type_Zeq.jdField_a_of_type_Int > 0)
      {
        yqp.b("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = zkh.a(paramzem.jdField_a_of_type_Zeq.jdField_a_of_type_AndroidGraphicsBitmap, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            yqp.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        yqp.b("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramzem.jdField_a_of_type_Zeq.jdField_a_of_type_JavaLangString;
        yqv.b("0X80075C9");
        paramzem.jdField_a_of_type_Zeq.jdField_b_of_type_Boolean = true;
        bool1 = false;
      }
    }
    paramzem.jdField_a_of_type_Zeq.jdField_b_of_type_JavaLangString = paramJobContext;
    paramzem.jdField_a_of_type_Zeq.jdField_a_of_type_Boolean = bool1;
    if ((paramzem.jdField_a_of_type_Int == 3) && (bool1)) {
      a(paramzem, paramzem.jdField_a_of_type_Zeq.jdField_a_of_type_JavaLangString, paramJobContext);
    }
    super.notifyResult(paramzem);
  }
  
  public void a(zem paramzem, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b != 4.9E-324D) && (((EditTakePhotoSource)paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).b;
      d2 = ((EditTakePhotoSource)paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!bmin.a(paramString1, paramString2)) {
          bmin.b(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        bmin.b(paramString2, d2, d1);
        return;
      } while ((!(paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a())) || (bmin.a(paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a(), paramString2)));
      paramzem = ((EditLocalPhotoSource)paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).a;
    } while (paramzem == null);
    bmin.a(paramString2, paramzem.longitude / 1000000.0D, paramzem.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfa
 * JD-Core Version:    0.7.0.1
 */