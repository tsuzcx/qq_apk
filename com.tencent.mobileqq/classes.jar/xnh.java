import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import java.util.List;

class xnh
  implements xic
{
  xnh(xng paramxng) {}
  
  public void a(String paramString)
  {
    int i = 0;
    while (i < this.a.a.size())
    {
      if (TextUtils.equals(paramString, ((xne)this.a.a.get(i)).a)) {
        ((StoryPlayerGroupHolder)this.a.a()).a.setCurrentItem(i);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnh
 * JD-Core Version:    0.7.0.1
 */