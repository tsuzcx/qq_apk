import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class orn
  extends ogm<oqr>
  implements View.OnClickListener
{
  private WSVerticalPageFragment c;
  private FeedRichTextView e;
  private stSimpleMetaFeed h;
  private TextView vl;
  
  public orn(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  private void bgA()
  {
    opw.b(this.c, this.h);
    osv.f(this.c.getFrom(), this.c.getPlayScene(), this.h);
  }
  
  private void pR(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
    this.e.setText(paramString);
  }
  
  private void pS(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.vl.setVisibility(8);
      return;
    }
    this.vl.setVisibility(0);
    this.vl.setText(paramString);
  }
  
  protected void Hp()
  {
    oqr localoqr = (oqr)getData();
    if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed))) {
      this.h = ((stSimpleMetaFeed)localoqr.B());
    }
  }
  
  protected int gn()
  {
    return 2131560217;
  }
  
  protected void initView()
  {
    this.e = ((FeedRichTextView)findViewById(2131381541));
    this.e.setOnClickListener(this);
    this.vl = ((TextView)findViewById(2131381542));
    this.vl.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ooz.d("WSVerticalItemBottomContentController", "跳转到微视端内");
      bgA();
    }
  }
  
  protected void onRecycle() {}
  
  protected void onUpdateUI()
  {
    Object localObject = (oqr)getData();
    if (localObject == null) {}
    while (!(((oqr)localObject).B() instanceof stSimpleMetaFeed)) {
      return;
    }
    localObject = (stSimpleMetaFeed)((oqr)localObject).B();
    pR(((stSimpleMetaFeed)localObject).feed_desc);
    pS(((stSimpleMetaFeed)localObject).material_desc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orn
 * JD-Core Version:    0.7.0.1
 */