import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

public class ayij
  extends aygy
{
  VipFrwrdLinkView a;
  private boolean mShow;
  private pty mVideoLinkInfo;
  RelativeLayout oj;
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    if (this.mVideoLinkInfo != null) {
      paramayqb.g.setLinkInfo(this.mVideoLinkInfo);
    }
  }
  
  void eRB()
  {
    this.b.a().bsC();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.a == null)
    {
      this.oj = ((RelativeLayout)y(2131366038));
      if (this.oj != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131298491) + wja.dp2px(17.0F, getResources()));
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.oj.getChildCount())
      {
        if (this.oj.getChildAt(i).getId() == 2131366040)
        {
          this.a = new VipFrwrdLinkView(getContext());
          this.oj.addView(this.a, i, localLayoutParams);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mShow) {
      return;
    }
    Looper.myQueue().addIdleHandler(new ayik(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayij
 * JD-Core Version:    0.7.0.1
 */