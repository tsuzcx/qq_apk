import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class xcu
  extends JobSegment<List<String>, List<Bitmap>>
{
  private int jdField_a_of_type_Int;
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString = "story.icon.UrlListToBitmapListSegment";
  private xcs jdField_a_of_type_Xcs;
  private String b;
  
  public xcu(@Nullable Bitmap paramBitmap, String paramString, int paramInt, xcs paramxcs)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "[" + paramString + "]");
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xcs = paramxcs;
  }
  
  protected void a(JobContext paramJobContext, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      notifyError(new ErrorMessage(-1, "url list is empty"));
    }
    for (;;)
    {
      return;
      paramJobContext = Collections.unmodifiableList(paramList);
      int i = paramJobContext.size();
      paramList = new Bitmap[i];
      Arrays.fill(paramList, this.jdField_a_of_type_AndroidGraphicsBitmap);
      xcb.b(this.jdField_a_of_type_JavaLangString, "bitmapListSize = %d, stubBitmap = %s", Integer.valueOf(i), this.jdField_a_of_type_AndroidGraphicsBitmap);
      Handler localHandler = new Handler(ThreadManager.getSubThreadLooper(), new xcw(this, null));
      localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramList), 300L);
      i = this.jdField_a_of_type_Int / 2;
      Iterator localIterator = paramJobContext.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!"stub_url".equals(str)) {
          this.jdField_a_of_type_Xcs.a(str, i, i, new xcv(this, paramJobContext, paramList, localHandler));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcu
 * JD-Core Version:    0.7.0.1
 */