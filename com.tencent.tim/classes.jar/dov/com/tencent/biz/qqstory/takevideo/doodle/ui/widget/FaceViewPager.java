package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import ayny;
import java.util.ArrayList;
import java.util.List;

public class FaceViewPager
  extends ViewPager
{
  private List<a> jC;
  
  public FaceViewPager(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public FaceViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.jC = new ArrayList();
    setOnPageChangeListener(new ayny(this));
  }
  
  public void a(a parama)
  {
    if (!this.jC.contains(parama)) {
      this.jC.add(parama);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager
 * JD-Core Version:    0.7.0.1
 */