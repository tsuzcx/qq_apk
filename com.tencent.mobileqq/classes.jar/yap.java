import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class yap
  extends JobSegment<List<Bitmap>, Bitmap>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString = "story.icon.BitmapListToIconSegment";
  
  public yap(Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "[" + paramString + "]");
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, List<Bitmap> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      notifyError(new ErrorMessage(-1, "bitmap list should not be empty"));
      return;
    }
    paramJobContext = (Bitmap[])paramList.toArray(new Bitmap[paramList.size()]);
    paramList = bhib.a(this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888, paramJobContext);
    yaq.b(this.jdField_a_of_type_JavaLangString, "result bitmap = %s, child count = %d", paramList, Integer.valueOf(paramJobContext.length));
    notifyResult(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yap
 * JD-Core Version:    0.7.0.1
 */