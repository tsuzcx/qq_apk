import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.io.IOException;

public class yyp
  extends yyn<yya, yya>
{
  private final String a;
  
  public yyp()
  {
    this(null);
  }
  
  public yyp(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, yya paramyya)
  {
    paramJobContext = null;
    int i = 0;
    Object localObject3 = paramyya.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, ".jpg");
    }
    String str2 = paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath;
    String str1 = paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath;
    if ((str2 != null) || (str1 != null))
    {
      try
      {
        localObject3 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject3 != null) {
          break label184;
        }
        super.notifyError(new ErrorMessage(-1, anvx.a(2131706029)));
        return;
      }
      catch (OutOfMemoryError paramJobContext)
      {
        ykq.e("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed : " + paramJobContext);
      }
      if (i == 0) {
        break label466;
      }
      zeb.a(new File(paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_JavaLangString));
      super.notifyResult(paramyya);
      return;
      label184:
      if (str2 == null) {
        break label484;
      }
      try
      {
        localObject2 = zdr.a(str2, null);
        paramJobContext = (JobContext)localObject2;
        ykq.d("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", new Object[] { str2 });
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
            localObject2 = zdr.b((Bitmap)localObject3, paramJobContext);
            paramJobContext.recycle();
            ((Bitmap)localObject3).recycle();
            paramJobContext = (JobContext)localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            ykq.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str1 + " failed", localOutOfMemoryError);
            break label498;
          }
          localIOException = localIOException;
          ykq.c("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", localIOException);
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
      zeb.a(vzh.e);
      boolean bool = zdr.a(paramJobContext, (String)localObject1);
      if (paramJobContext != null) {
        paramJobContext.recycle();
      }
      if (bool)
      {
        paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
        ykq.b("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image success : " + (String)localObject1);
        i = 1;
      }
      else
      {
        ykq.d("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
        i = 0;
        break label495;
        ykq.a("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", localObject1);
        if (zeb.a(new File((String)localObject3), new File((String)localObject1)))
        {
          paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
          i = 1;
          break;
        }
        ykq.d("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", new Object[] { localObject3, localObject1 });
        break;
        super.notifyError(new ErrorMessage(-1, anvx.a(2131706028)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyp
 * JD-Core Version:    0.7.0.1
 */