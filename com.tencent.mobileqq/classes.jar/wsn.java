import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import java.util.List;

class wsn
  implements wni
{
  wsn(wsm paramwsm) {}
  
  public void a(String paramString)
  {
    int i = 0;
    while (i < this.a.a.size())
    {
      if (TextUtils.equals(paramString, ((wsk)this.a.a.get(i)).a)) {
        ((StoryPlayerGroupHolder)this.a.a()).a.setCurrentItem(i);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsn
 * JD-Core Version:    0.7.0.1
 */