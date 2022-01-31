import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class tmv
  extends AbsVideoInfoWidget
{
  private tmx a = new tmx(this);
  private boolean e;
  
  public tmv(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "LoadingMoreWidget";
  }
  
  public tmx a()
  {
    return this.a;
  }
  
  public void a(View paramView) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new tmw(this), "");
  }
  
  public void a(@NonNull tnz paramtnz, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(@NonNull tnz paramtnz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.e;
  }
  
  public int b()
  {
    return 2131495822;
  }
  
  public void d()
  {
    this.e = true;
    i();
    urk.b("Q.qqstory.playernew.LoadingMoreWidget", "showLoadMore");
  }
  
  public void e()
  {
    this.e = false;
    k();
    urk.b("Q.qqstory.playernew.LoadingMoreWidget", "hideLoadMore");
  }
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmv
 * JD-Core Version:    0.7.0.1
 */