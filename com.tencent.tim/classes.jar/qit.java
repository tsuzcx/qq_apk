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
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Locale;

public class qit
  extends qjw
  implements IEventReceiver, rpg.c, rpg.e, rsr.a, rsr.b
{
  private qit.a jdField_a_of_type_Qit$a;
  private qit.b jdField_a_of_type_Qit$b;
  private boolean aDA;
  private rpg.a jdField_b_of_type_Rpg$a;
  private rsk jdField_b_of_type_Rsk;
  private FrameLayout q = (FrameLayout)this.mItemView.findViewById(2131373483);
  
  public qit(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    paramViewGroup.setVisibility(4);
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull qjq paramqjq, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramqjq, paramStoryPlayerGroupHolder);
    if (!this.jdField_a_of_type_Qjq.JM()) {
      return;
    }
    paramqjq = ((psu)psx.a(5)).b(this.jdField_a_of_type_Qjq.vid);
    if ((paramqjq != null) && (paramqjq.isPollVideo()))
    {
      if (this.jdField_b_of_type_Rpg$a == null) {
        this.jdField_b_of_type_Rpg$a = rpg.a(this.q.getContext(), 1, 1, null);
      }
      qel.a(this, this, this.q, this.jdField_b_of_type_Rpg$a, 0, paramqjq);
      qel.b(this, this, this.q, this.jdField_b_of_type_Rpg$a, paramInt2, paramqjq);
      return;
    }
    if ((paramqjq != null) && (paramqjq.isInteractVideo()))
    {
      if (this.jdField_b_of_type_Rsk == null) {
        this.jdField_b_of_type_Rsk = new rsr(this.q.getContext());
      }
      qek.a(this, this, this.q, this.jdField_b_of_type_Rsk, paramInt2, paramqjq);
      qek.b(this, this, this.q, this.jdField_b_of_type_Rsk, paramInt2, paramqjq);
      return;
    }
    this.q.setVisibility(4);
  }
  
  public void a(rpg.a parama)
  {
    parama = ((psu)psx.a(5)).b(this.jdField_a_of_type_Qjq.vid);
    if (parama != null)
    {
      rar.a("play_video", "vote_detail", 1, 0, new String[0]);
      Intent localIntent = new Intent(n(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { parama.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      n().startActivity(localIntent);
    }
  }
  
  public void a(rpg.a parama, rpg.i parami)
  {
    StoryVideoItem localStoryVideoItem = ((psu)psx.a(5)).b(this.jdField_a_of_type_Qjq.vid);
    if (localStoryVideoItem == null) {
      return;
    }
    qel.a(this, this, parama, this.bmB, this.jdField_a_of_type_Qjq.feedId, localStoryVideoItem, parami);
  }
  
  public void a(rsr paramrsr)
  {
    paramrsr = ((psu)psx.a(5)).b(this.jdField_a_of_type_Qjq.vid);
    if (paramrsr != null)
    {
      rar.a("play_video", "vote_detail", 2, 0, new String[0]);
      Intent localIntent = new Intent(n(), QQBrowserActivity.class);
      localIntent.putExtra("url", String.format(Locale.getDefault(), "https://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { paramrsr.mVid }));
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      n().startActivity(localIntent);
    }
  }
  
  public void a(rsr paramrsr, float paramFloat)
  {
    StoryVideoItem localStoryVideoItem = ((psu)psx.a(5)).b(this.jdField_a_of_type_Qjq.vid);
    if (localStoryVideoItem == null)
    {
      ram.e("InteractWidgetPageHolder", "video item is null while rate changed.");
      return;
    }
    qek.a(this.bmB, this.jdField_a_of_type_Qjq.feedId, localStoryVideoItem, paramrsr, paramFloat);
  }
  
  public boolean isValidate()
  {
    return this.aDA;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.aDA = true;
    this.jdField_a_of_type_Qit$a = new qit.a(this);
    this.jdField_a_of_type_Qit$b = new qit.b(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qit$a);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qit$b);
    a(new qiu(this));
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public static class a
    extends QQUIEventReceiver<qit, pxt.a>
  {
    public a(@NonNull qit paramqit)
    {
      super();
    }
    
    public void a(@NonNull qit paramqit, @NonNull pxt.a parama)
    {
      ram.d("InteractWidgetPageHolder", "receive poll info event.");
      if (paramqit.JN()) {
        paramqit.a(paramqit.bmn, paramqit.bmB, paramqit.a, paramqit.c);
      }
    }
    
    public Class acceptEventClass()
    {
      return pxt.a.class;
    }
  }
  
  public static class b
    extends QQUIEventReceiver<qit, pya.a>
  {
    public b(@NonNull qit paramqit)
    {
      super();
    }
    
    public void a(@NonNull qit paramqit, @NonNull pya.a parama)
    {
      ram.d("InteractWidgetPageHolder", "receive send vid rate data result event.");
      if (paramqit.JN()) {
        paramqit.a(paramqit.bmn, paramqit.bmB, paramqit.a, paramqit.c);
      }
    }
    
    public Class acceptEventClass()
    {
      return pya.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qit
 * JD-Core Version:    0.7.0.1
 */