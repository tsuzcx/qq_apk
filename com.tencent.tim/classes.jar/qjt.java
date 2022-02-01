import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar.a;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import java.util.List;

class qjt
  implements VideoCoverListBar.a
{
  qjt(qjs paramqjs) {}
  
  public void rG(String paramString)
  {
    int i = 0;
    while (i < this.a.nR.size())
    {
      if (TextUtils.equals(paramString, ((qjq)this.a.nR.get(i)).vid)) {
        ((StoryPlayerGroupHolder)this.a.a()).a.setCurrentItem(i);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjt
 * JD-Core Version:    0.7.0.1
 */