import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

public class zio
  extends ziu<zih, zih>
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<yyf> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public zio()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public zio(String paramString, yyf paramyyf, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyyf);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(zih paramzih, boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    for (File localFile = new File(paramString);; localFile = null)
    {
      Object localObject2;
      int i;
      if ((paramBoolean) && (localFile != null) && (localFile.exists()) && (localFile.isFile()) && (localFile.length() > 0L))
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = zix.a(paramzih.jdField_a_of_type_Int, paramzih.jdField_b_of_type_JavaLangString, ".jpg");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new File((String)localObject1);
          if (localFile.renameTo((File)localObject2))
          {
            yuk.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir success : %s", new Object[] { ((File)localObject2).getPath() });
            paramzih.jdField_a_of_type_JavaLangString = ((String)localObject1);
            paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject1);
            i = 1;
          }
        }
      }
      while (i != 0)
      {
        yuk.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb success ...");
        super.notifyResult(paramzih);
        return;
        if (this.jdField_a_of_type_JavaLangString == null)
        {
          yuk.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy failed : use the origin instead : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          paramzih.jdField_a_of_type_JavaLangString = paramString;
          paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
        }
        else
        {
          yuk.d("Q.qqstory.publish.edit.GenerateThumbSegment", "copy thumb file to upload dir failed : origin %s, target %s", new Object[] { localFile.getPath(), ((File)localObject2).getPath() });
          i = 0;
          continue;
          paramzih.jdField_a_of_type_JavaLangString = paramString;
          paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = paramString;
          i = 1;
          continue;
          i = 0;
        }
      }
      yuk.b("Q.qqstory.publish.edit.GenerateThumbSegment", "generate thumb failed ...");
      super.notifyError(new ErrorMessage(-1, "GenerateThumbTask error"));
      return;
    }
  }
  
  protected void a(JobContext paramJobContext, zih paramzih)
  {
    yuk.a("Q.qqstory.publish.edit.GenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    zin localzin = paramzih.jdField_a_of_type_Zin;
    int i = localzin.c;
    if (paramzih.jdField_a_of_type_Int == 1) {
      i = 0;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramJobContext = new zip(localzin.jdField_a_of_type_Int, localzin.jdField_b_of_type_Int, localzin.jdField_a_of_type_JavaLangString, localzin.jdField_a_of_type_Float, localzin.jdField_a_of_type_Boolean, i, localzin.jdField_a_of_type_Double, localzin.jdField_b_of_type_Double, localzin.jdField_b_of_type_JavaLangString, paramzih.jdField_a_of_type_Int, localzin.jdField_b_of_type_Boolean);
      if (paramJobContext.a(new Void[0]).intValue() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramzih, bool, paramJobContext.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      paramJobContext = (yyf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    while (paramJobContext != null)
    {
      Bitmap localBitmap = paramJobContext.a(this.jdField_a_of_type_Int);
      if (localBitmap != null)
      {
        try
        {
          String str2 = this.jdField_a_of_type_JavaLangString;
          String str1 = str2;
          if (str2 == null) {
            str1 = zix.a(paramzih.jdField_a_of_type_Int, paramzih.jdField_b_of_type_JavaLangString, ".jpg");
          }
          i = new zip(localBitmap, str1, localzin.jdField_a_of_type_Int, localzin.jdField_b_of_type_Int, i, localzin.jdField_a_of_type_Float, localzin.jdField_a_of_type_Double, localzin.jdField_b_of_type_Double, paramzih.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label327;
          }
          paramzih.jdField_a_of_type_JavaLangString = str1;
          paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          yuk.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(paramzih);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label327:
        yuk.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, anzj.a(2131704144) + this.jdField_a_of_type_Int));
      }
      else
      {
        yuk.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, anzj.a(2131704143) + this.jdField_a_of_type_Int));
        return;
      }
    }
    yuk.d("Q.qqstory.publish.edit.GenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, anzj.a(2131704147) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zio
 * JD-Core Version:    0.7.0.1
 */