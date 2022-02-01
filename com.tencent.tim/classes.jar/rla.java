import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tribe.async.async.JobContext;

public class rla
  extends rkz<rkm, rkm>
{
  public final String aBe;
  private boolean aIL;
  
  public rla(String paramString)
  {
    this(true, paramString);
  }
  
  public rla(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public rla(boolean paramBoolean, String paramString)
  {
    this.aIL = paramBoolean;
    this.aBe = paramString;
  }
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    boolean bool2 = false;
    int i = 1;
    String str = this.aBe;
    paramJobContext = str;
    if (str == null) {
      paramJobContext = rlc.f(paramrkm.businessId, paramrkm.aAU, ".jpg");
    }
    if ((this.aIL) && (paramrkm.aIA)) {
      ram.d("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
    }
    boolean bool1;
    for (;;)
    {
      try
      {
        bool1 = rop.d(rop.d(paramrkm.jdField_a_of_type_Rkq.cK, paramrkm.jdField_a_of_type_Rkq.doodleBitmap), paramJobContext);
        i = 0;
        bool2 = true;
        alwx.cAc = bool2;
        if ((i != 0) || (bool1)) {
          break;
        }
        ram.e("Q.qqstory.publish.edit.MergePicSegment", "save err");
        super.notifyError(new ErrorMessage(-1, acfp.m(2131708129)));
        return;
      }
      catch (Throwable paramJobContext)
      {
        ram.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
        paramJobContext = null;
        bool1 = false;
        continue;
      }
      if (paramrkm.jdField_a_of_type_Rkq.bsR > 0)
      {
        ram.d("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
        try
        {
          bool1 = rop.d(paramrkm.jdField_a_of_type_Rkq.cK, paramJobContext);
          i = 0;
          bool2 = true;
        }
        catch (Throwable paramJobContext)
        {
          for (;;)
          {
            ram.e("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + paramJobContext);
            paramJobContext = null;
            bool1 = false;
          }
        }
      }
      else
      {
        ram.d("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
        paramJobContext = paramrkm.jdField_a_of_type_Rkq.aAY;
        ras.sp("0X80075C9");
        paramrkm.jdField_a_of_type_Rkq.aIF = true;
        bool1 = false;
      }
    }
    paramrkm.jdField_a_of_type_Rkq.aAZ = paramJobContext;
    paramrkm.jdField_a_of_type_Rkq.result = bool1;
    if ((paramrkm.businessId == 3) && (bool1)) {
      a(paramrkm, paramrkm.jdField_a_of_type_Rkq.aAY, paramJobContext);
    }
    super.notifyResult(paramrkm);
  }
  
  public void a(rkm paramrkm, String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (((EditTakePhotoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).latitude != 4.9E-324D) && (((EditTakePhotoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).bn != 4.9E-324D))
    {
      d1 = ((EditTakePhotoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).latitude;
      d2 = ((EditTakePhotoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).bn;
      if (!TextUtils.isEmpty(paramString1)) {
        if (!awci.cr(paramString1, paramString2)) {
          awci.c(paramString2, d2, d1);
        }
      }
    }
    do
    {
      do
      {
        return;
        awci.c(paramString2, d2, d1);
        return;
      } while ((!(paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource)) || (TextUtils.isEmpty(paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath())) || (awci.cr(paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath(), paramString2)));
      paramrkm = ((EditLocalPhotoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).d;
    } while (paramrkm == null);
    awci.b(paramString2, paramrkm.longitude / 1000000.0D, paramrkm.latitude / 1000000.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rla
 * JD-Core Version:    0.7.0.1
 */