import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oro
  extends ogm<oqr>
  implements View.OnClickListener
{
  private WSVerticalPageFragment c;
  private stSimpleMetaFeed h;
  private TextView vm;
  
  public oro(Context paramContext, osf paramosf)
  {
    super(paramContext);
    if (paramosf != null) {
      this.c = paramosf.c;
    }
  }
  
  protected void Hp()
  {
    if ((getData() != null) && ((((oqr)getData()).B() instanceof stSimpleMetaFeed))) {
      this.h = ((stSimpleMetaFeed)((oqr)getData()).B());
    }
  }
  
  protected int gn()
  {
    return 2131560218;
  }
  
  protected void initView()
  {
    this.vm = ((TextView)findViewById(2131381540));
    this.vm.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131381540) {
        opw.a("nickname", this.c, this.h);
      }
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
    localObject = ((stSimpleMetaFeed)((oqr)localObject).B()).poster;
    if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaPerson)localObject).nick)))
    {
      this.vm.setVisibility(0);
      this.vm.setText(String.format("@%s", new Object[] { ((stSimpleMetaPerson)localObject).nick }));
      return;
    }
    this.vm.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oro
 * JD-Core Version:    0.7.0.1
 */