import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class tzo
  extends AbsVideoInfoWidget
{
  private tzq a = new tzq(this);
  private boolean e;
  
  public tzo(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "LoadingMoreWidget";
  }
  
  public tzq a()
  {
    return this.a;
  }
  
  public void a(View paramView) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new tzp(this), "");
  }
  
  public void a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.e;
  }
  
  public int b()
  {
    return 2131561412;
  }
  
  public void d()
  {
    this.e = true;
    i();
    ved.b("Q.qqstory.playernew.LoadingMoreWidget", "showLoadMore");
  }
  
  public void e()
  {
    this.e = false;
    k();
    ved.b("Q.qqstory.playernew.LoadingMoreWidget", "hideLoadMore");
  }
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzo
 * JD-Core Version:    0.7.0.1
 */