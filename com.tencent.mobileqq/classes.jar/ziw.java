import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.io.IOException;

public class ziw
  extends ziu<zih, zih>
{
  private final String a;
  
  public ziw()
  {
    this(null);
  }
  
  public ziw(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, zih paramzih)
  {
    paramJobContext = null;
    int i = 0;
    Object localObject3 = paramzih.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, ".jpg");
    }
    String str2 = paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath;
    String str1 = paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath;
    if ((str2 != null) || (str1 != null))
    {
      try
      {
        localObject3 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject3 != null) {
          break label184;
        }
        super.notifyError(new ErrorMessage(-1, anzj.a(2131705448)));
        return;
      }
      catch (OutOfMemoryError paramJobContext)
      {
        yuk.e("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed : " + paramJobContext);
      }
      if (i == 0) {
        break label466;
      }
      zom.a(new File(paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_JavaLangString));
      super.notifyResult(paramzih);
      return;
      label184:
      if (str2 == null) {
        break label484;
      }
      try
      {
        localObject2 = zoc.a(str2, null);
        paramJobContext = (JobContext)localObject2;
        yuk.d("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", new Object[] { str2 });
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
            localObject2 = zoc.b((Bitmap)localObject3, paramJobContext);
            paramJobContext.recycle();
            ((Bitmap)localObject3).recycle();
            paramJobContext = (JobContext)localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            yuk.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str1 + " failed", localOutOfMemoryError);
            break label498;
          }
          localIOException = localIOException;
          yuk.c("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", localIOException);
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
      zom.a(win.e);
      boolean bool = zoc.a(paramJobContext, (String)localObject1);
      if (paramJobContext != null) {
        paramJobContext.recycle();
      }
      if (bool)
      {
        paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
        yuk.b("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image success : " + (String)localObject1);
        i = 1;
      }
      else
      {
        yuk.d("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
        i = 0;
        break label495;
        yuk.a("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", localObject1);
        if (zom.a(new File((String)localObject3), new File((String)localObject1)))
        {
          paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
          i = 1;
          break;
        }
        yuk.d("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", new Object[] { localObject3, localObject1 });
        break;
        super.notifyError(new ErrorMessage(-1, anzj.a(2131705447)));
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
 * Qualified Name:     ziw
 * JD-Core Version:    0.7.0.1
 */