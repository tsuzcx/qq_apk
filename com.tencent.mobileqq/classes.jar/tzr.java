import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class tzr
  extends AbsVideoInfoWidget
{
  private tzt a = new tzt(this);
  private boolean e;
  
  public tzr(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "LoadingMoreWidget";
  }
  
  public tzt a()
  {
    return this.a;
  }
  
  public void a(View paramView) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new tzs(this), "");
  }
  
  public void a(@NonNull uav paramuav, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(@NonNull uav paramuav, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.e;
  }
  
  public int b()
  {
    return 2131561413;
  }
  
  public void d()
  {
    this.e = true;
    i();
    veg.b("Q.qqstory.playernew.LoadingMoreWidget", "showLoadMore");
  }
  
  public void e()
  {
    this.e = false;
    k();
    veg.b("Q.qqstory.playernew.LoadingMoreWidget", "hideLoadMore");
  }
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzr
 * JD-Core Version:    0.7.0.1
 */