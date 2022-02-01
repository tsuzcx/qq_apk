import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class qjx
  extends qjw
{
  Map<String, qjw> fV = new HashMap();
  
  public qjx(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    c(new VideoViewVideoHolder((ViewGroup)this.mItemView.findViewById(2131381865)));
    c(new qit((ViewGroup)this.mItemView.findViewById(2131369317)));
    c(new qjg((ViewGroup)this.mItemView.findViewById(2131381802)));
    c(new qjy(this.mItemView.findViewById(2131381771)));
    c(new qjv((ViewGroup)this.mItemView.findViewById(2131381866)));
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull qjq paramqjq, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramqjq, paramStoryPlayerGroupHolder);
    ram.a(this.TAG, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.bmn), Integer.valueOf(this.bmB), paramqjq);
    Iterator localIterator = this.fV.values().iterator();
    while (localIterator.hasNext()) {
      ((qjw)localIterator.next()).a(paramInt1, paramInt2, paramqjq, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(qji paramqji)
  {
    super.a(paramqji);
    Iterator localIterator = this.fV.values().iterator();
    while (localIterator.hasNext()) {
      ((qjw)localIterator.next()).a(paramqji);
    }
  }
  
  public void a(qjx paramqjx)
  {
    super.a(this);
    paramqjx = this.fV.values().iterator();
    while (paramqjx.hasNext()) {
      ((qjw)paramqjx.next()).a(this);
    }
  }
  
  @Nullable
  public qjw b(Class<? extends qjw> paramClass)
  {
    return (qjw)this.fV.get(paramClass.getName());
  }
  
  public void boy()
  {
    super.boy();
    ram.a(this.TAG, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.bmn), Integer.valueOf(this.bmB), this.a);
    Iterator localIterator = this.fV.values().iterator();
    while (localIterator.hasNext()) {
      ((qjw)localIterator.next()).boy();
    }
  }
  
  public void c(@NonNull qjw paramqjw)
  {
    this.fV.put(paramqjw.getClass().getName(), paramqjw);
  }
  
  public void dU(int paramInt1, int paramInt2)
  {
    super.dU(paramInt1, paramInt2);
    Iterator localIterator = this.fV.values().iterator();
    while (localIterator.hasNext()) {
      ((qjw)localIterator.next()).dU(paramInt1, paramInt2);
    }
  }
  
  public boolean isSelected()
  {
    return super.isSelected();
  }
  
  public void onCreate()
  {
    super.onCreate();
    Iterator localIterator = this.fV.values().iterator();
    while (localIterator.hasNext()) {
      ((qjw)localIterator.next()).onCreate();
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561933, paramViewGroup, false);
  }
  
  public void sE(boolean paramBoolean)
  {
    super.sE(paramBoolean);
    Iterator localIterator = this.fV.values().iterator();
    while (localIterator.hasNext()) {
      ((qjw)localIterator.next()).sE(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjx
 * JD-Core Version:    0.7.0.1
 */