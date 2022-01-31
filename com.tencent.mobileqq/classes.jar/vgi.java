import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Map;

public class vgi
  implements Runnable
{
  public vgi(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (ShortVideoRealItemBuilder.a().size() == 0) {
        RMVideoStateMgr.c(this.jdField_a_of_type_JavaLangString);
      }
      FileUtils.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgi
 * JD-Core Version:    0.7.0.1
 */