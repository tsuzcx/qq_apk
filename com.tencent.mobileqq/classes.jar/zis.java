import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class zis
  extends ziu<zih, zih>
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<yyf> jdField_a_of_type_JavaLangRefWeakReference;
  
  public zis(String paramString, yyf paramyyf, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyyf);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, zih paramzih)
  {
    yuk.a("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.jdField_a_of_type_Int));
    zin localzin = paramzih.jdField_a_of_type_Zin;
    int i = localzin.c;
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
            str1 = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, ".jpg");
          }
          i = new zip(localBitmap, str1, localzin.jdField_a_of_type_Int, localzin.jdField_b_of_type_Int, i, localzin.jdField_a_of_type_Float, localzin.jdField_a_of_type_Double, localzin.jdField_b_of_type_Double, paramzih.jdField_a_of_type_Int).a(new Void[0]).intValue();
          paramJobContext.a(localBitmap);
          if (i != 0) {
            break label217;
          }
          paramzih.jdField_a_of_type_JavaLangString = str1;
          paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = str1;
          yuk.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          super.notifyResult(paramzih);
          return;
        }
        finally
        {
          paramJobContext.a(localBitmap);
        }
        paramJobContext = null;
        continue;
        label217:
        yuk.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, anzj.a(2131704579) + this.jdField_a_of_type_Int));
      }
      else
      {
        yuk.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        super.notifyError(new ErrorMessage(-1, anzj.a(2131704584) + this.jdField_a_of_type_Int));
        return;
      }
    }
    yuk.d("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    super.notifyError(new ErrorMessage(-1, anzj.a(2131704580) + this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zis
 * JD-Core Version:    0.7.0.1
 */