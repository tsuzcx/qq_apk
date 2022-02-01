import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class xpv
  extends AbsVideoInfoWidget
{
  private xpx a = new xpx(this);
  private boolean e;
  
  public xpv(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "LoadingMoreWidget";
  }
  
  public xpx a()
  {
    return this.a;
  }
  
  public void a(View paramView) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xpw(this), "");
  }
  
  public void a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.e;
  }
  
  public int b()
  {
    return 2131561895;
  }
  
  public void d()
  {
    this.e = true;
    i();
    yuk.b("Q.qqstory.playernew.LoadingMoreWidget", "showLoadMore");
  }
  
  public void e()
  {
    this.e = false;
    k();
    yuk.b("Q.qqstory.playernew.LoadingMoreWidget", "hideLoadMore");
  }
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpv
 * JD-Core Version:    0.7.0.1
 */