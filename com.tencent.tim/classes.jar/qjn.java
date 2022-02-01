import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager.f;

public class qjn
  implements XViewPager.f
{
  public qjn(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if ((paramInt == 1) && (this.this$0.JI()) && (this.this$0.JH()))
    {
      ((qiv)this.this$0.b(qiv.class)).boz();
      ram.b(this.this$0.TAG + "Q.qqstory.weishi", "onPageScrolled, showLoadingMoreWidget position=%d", Integer.valueOf(this.this$0.bmz));
    }
    qiv localqiv = (qiv)this.this$0.b(qiv.class);
    if (localqiv != null) {
      localqiv.a().onPageScrollStateChanged(paramInt);
    }
    if (StoryPlayerGroupHolder.a(this.this$0) != null) {
      StoryPlayerGroupHolder.a(this.this$0).dT(this.this$0.bmu, paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (StoryPlayerGroupHolder.a(this.this$0) != null) {
      StoryPlayerGroupHolder.a(this.this$0).b(this.this$0.bmu, paramInt1, paramFloat, paramInt2);
    }
    qiv localqiv = (qiv)this.this$0.b(qiv.class);
    if (localqiv != null) {
      localqiv.a().onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    ram.b(this.this$0.TAG, "onPageSelected : position = %d", Integer.valueOf(paramInt));
    int i = this.this$0.bmz;
    this.this$0.bmz = paramInt;
    Object localObject = this.this$0.a();
    if (localObject != null)
    {
      localObject = (qjy)((qjw)localObject).a(qjy.class);
      if ((localObject != null) && (((qjy)localObject).oh.getVisibility() != 0)) {
        this.this$0.am(true, true);
      }
    }
    localObject = (qiv)this.this$0.b(qiv.class);
    if (localObject != null) {
      ((qiv)localObject).a().onPageSelected(paramInt);
    }
    wn(paramInt);
    if (StoryPlayerGroupHolder.a(this.this$0) != null) {
      StoryPlayerGroupHolder.a(this.this$0).aa(this.this$0.bmu, i, paramInt);
    }
  }
  
  public void wn(int paramInt)
  {
    ram.b(this.this$0.TAG, "onIdlePageSelected : position = %d", Integer.valueOf(paramInt));
    qjw localqjw = this.this$0.a();
    if ((localqjw != null) && (TextUtils.equals(StoryPlayerGroupHolder.a(this.this$0).a().groupId, this.this$0.d.groupId)) && (!localqjw.isSelected()))
    {
      ram.b(this.this$0.TAG, "onIdlePageSelected, setSelected => %s", localqjw);
      this.this$0.b(localqjw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjn
 * JD-Core Version:    0.7.0.1
 */