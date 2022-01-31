import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class vog
  extends AbsVideoInfoWidget
{
  private voi a = new voi(this);
  private boolean e;
  
  public vog(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "LoadingMoreWidget";
  }
  
  public voi a()
  {
    return this.a;
  }
  
  public void a(View paramView) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new voh(this), "");
  }
  
  public void a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem) {}
  
  public boolean a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return this.e;
  }
  
  public int b()
  {
    return 2131561602;
  }
  
  public void d()
  {
    this.e = true;
    i();
    wsv.b("Q.qqstory.playernew.LoadingMoreWidget", "showLoadMore");
  }
  
  public void e()
  {
    this.e = false;
    k();
    wsv.b("Q.qqstory.playernew.LoadingMoreWidget", "hideLoadMore");
  }
  
  public void f() {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vog
 * JD-Core Version:    0.7.0.1
 */