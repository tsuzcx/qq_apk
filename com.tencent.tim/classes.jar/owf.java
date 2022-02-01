import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class owf
  extends rxk
  implements View.OnClickListener, rwx
{
  private SquareImageView c;
  private ImageView lI;
  private ImageView lJ;
  private ImageView lK;
  private View mContainer;
  private View nK;
  private View nL;
  private View nM;
  private View nj;
  private TextView vS;
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    this.mContainer = paramView.findViewById(2131373904);
    this.nj = paramView.findViewById(2131373902);
    this.nK = paramView.findViewById(2131373891);
    this.nK.setOnClickListener(this);
    this.nL = paramView.findViewById(2131373895);
    this.nL.setOnClickListener(this);
    pco.h("", 4, 1L);
    this.nM = paramView.findViewById(2131373890);
    this.c = ((SquareImageView)paramView.findViewById(2131373894));
    this.lI = ((ImageView)paramView.findViewById(2131374539));
    this.vS = ((TextView)paramView.findViewById(2131374542));
    this.lJ = ((ImageView)paramView.findViewById(2131374541));
    this.lK = ((ImageView)paramView.findViewById(2131374540));
    this.nM.setOnClickListener(this);
    if ((getActivity() != null) && ((getActivity() instanceof BaseActivity))) {
      this.c.setImageDrawable(aqdj.a(((BaseActivity)getActivity()).app, 1, 4, oum.lQ()));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFuelAnimationEvent.class);
    return localArrayList;
  }
  
  public String getLogTag()
  {
    return "QCircleFolderActivityChipPart";
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    rwv.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    rwv.a().b(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    String str = "1";
    if (pcr.a().ez(3)) {
      str = "2";
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((BaseActivity)getActivity()).doOnBackPressed();
      pco.a("", 21, 1L, 0L, str, "", "", "", "");
      continue;
      oux.b(getActivity(), ouw.arD, null);
      pco.h("", 4, 2L);
      continue;
      pco.a("", 21, 2L, 0L, str, "", "", "", "");
      oux.qm(oum.lQ());
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFuelAnimationEvent)) {
      pbv.a().a(this.lI, this.vS, this.lJ, this.lK, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owf
 * JD-Core Version:    0.7.0.1
 */