import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.io.IOException;

public class xhh
  extends xhf<xgs, xgs>
{
  private final String a;
  
  public xhh()
  {
    this(null);
  }
  
  public xhh(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, xgs paramxgs)
  {
    paramJobContext = null;
    int i = 0;
    Object localObject3 = paramxgs.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = xhi.a(paramxgs.jdField_a_of_type_Int, paramxgs.b, ".jpg");
    }
    String str2 = paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath;
    String str1 = paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath;
    if ((str2 != null) || (str1 != null))
    {
      try
      {
        localObject3 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject3 != null) {
          break label184;
        }
        super.notifyError(new ErrorMessage(-1, alpo.a(2131706938)));
        return;
      }
      catch (OutOfMemoryError paramJobContext)
      {
        wsv.e("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed : " + paramJobContext);
      }
      if (i == 0) {
        break label466;
      }
      xmx.a(new File(paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_JavaLangString));
      super.notifyResult(paramxgs);
      return;
      label184:
      if (str2 == null) {
        break label484;
      }
      try
      {
        localObject2 = xmn.a(str2, null);
        paramJobContext = (JobContext)localObject2;
        wsv.d("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", new Object[] { str2 });
        paramJobContext = (JobContext)localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            label219:
            localObject2 = BitmapFactory.decodeFile(str1);
            paramJobContext = (JobContext)localObject2;
            if (paramJobContext == null) {
              break label501;
            }
            localObject2 = xmn.b((Bitmap)localObject3, paramJobContext);
            paramJobContext.recycle();
            ((Bitmap)localObject3).recycle();
            paramJobContext = (JobContext)localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            wsv.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str1 + " failed", localOutOfMemoryError);
            break label498;
          }
          localIOException = localIOException;
          wsv.c("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", localIOException);
        }
      }
      if ((paramJobContext != null) || (str1 == null)) {
        break label498;
      }
    }
    label238:
    label495:
    label498:
    label501:
    label505:
    for (;;)
    {
      xmx.a(ugx.e);
      boolean bool = xmn.a(paramJobContext, (String)localObject1);
      if (paramJobContext != null) {
        paramJobContext.recycle();
      }
      if (bool)
      {
        paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
        wsv.b("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image success : " + (String)localObject1);
        i = 1;
      }
      else
      {
        wsv.d("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
        i = 0;
        break label495;
        wsv.a("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", localObject1);
        if (xmx.a(new File((String)localObject3), new File((String)localObject1)))
        {
          paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
          i = 1;
          break;
        }
        wsv.d("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", new Object[] { localObject3, localObject1 });
        break;
        super.notifyError(new ErrorMessage(-1, alpo.a(2131706937)));
        return;
        paramJobContext = null;
        break label219;
      }
      for (;;)
      {
        if (paramJobContext != null) {
          break label505;
        }
        i = 0;
        break;
        break label238;
        paramJobContext = (JobContext)localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhh
 * JD-Core Version:    0.7.0.1
 */