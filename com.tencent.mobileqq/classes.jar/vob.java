import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.Locale;

public class vob
  extends vpr
  implements IEventReceiver, xnl, xnn, xsb, xsc
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372156);
  private vod jdField_a_of_type_Vod;
  private voe jdField_a_of_type_Voe;
  private xnj jdField_a_of_type_Xnj;
  private xrq jdField_a_of_type_Xrq;
  private boolean c;
  
  public vob(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull vpk paramvpk, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramvpk, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Vpk.c()) {
      return;
    }
    paramvpk = ((uro)urr.a(5)).b(this.jdField_a_of_type_Vpk.a);
    if ((paramvpk != null) && (paramvpk.isPollVideo()))
    {
      if (this.jdField_a_of_type_Xnj == null) {
        this.jdField_a_of_type_Xnj = xni.a(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), 1, 1, null);
      }
      vhi.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Xnj, 0, paramvpk);
      vhi.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Xnj, paramInt2, paramvpk);
      return;
    }
    if ((paramvpk != null) && (paramvpk.isInteractVideo()))
    {
      if (this.jdField_a_of_type_Xrq == null) {
        this.jdField_a_of_type_Xrq = new xsa(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      }
      vhh.a(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Xrq, paramInt2, paramvpk);
      vhh.b(this, this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_Xrq, paramInt2, paramvpk);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public void a(xnj paramxnj)
  {
    paramxnj = ((uro)urr.a(5)).b(this.jdField_a_of_type_Vpk.a);
    if (paramxnj != null)
    {
      wta.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { paramxnj.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(xnj paramxnj, xnr paramxnr)
  {
    StoryVideoItem localStoryVideoItem = ((uro)urr.a(5)).b(this.jdField_a_of_type_Vpk.a);
    if (localStoryVideoItem == null) {
      return;
    }
    vhi.a(this, this, paramxnj, this.b, this.jdField_a_of_type_Vpk.b, localStoryVideoItem, paramxnr);
  }
  
  public void a(xsa paramxsa)
  {
    paramxsa = ((uro)urr.a(5)).b(this.jdField_a_of_type_Vpk.a);
    if (paramxsa != null)
    {
      wta.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "http://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramxsa.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      a().startActivity(localIntent);
    }
  }
  
  public void a(xsa paramxsa, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((uro)urr.a(5)).b(this.jdField_a_of_type_Vpk.a);
    if (localStoryVideoItem == null)
    {
      wsv.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    vhh.a(this.b, this.jdField_a_of_type_Vpk.b, localStoryVideoItem, paramxsa, paramFloat);
  }
  
  protected void b()
  {
    super.b();
    this.c = true;
    this.jdField_a_of_type_Vod = new vod(this);
    this.jdField_a_of_type_Voe = new voe(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Vod);
    uht.a().registerSubscriber(this.jdField_a_of_type_Voe);
    a(new voc(this));
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vob
 * JD-Core Version:    0.7.0.1
 */