import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

public class ayew
  extends aygy
  implements Handler.Callback, View.OnClickListener
{
  private ImageView IN;
  private TextView ahU;
  private boolean dyM;
  private PressDarkImageButton f;
  private Handler mHandler;
  
  public ayew(aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private void Zl(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setChecked(true);
      return;
    }
    this.f.setChecked(false);
  }
  
  private void eQZ()
  {
    String str;
    if (psr.IN())
    {
      this.dyM = psr.IO();
      this.f.setVisibility(0);
      if (this.dyM)
      {
        str = "1";
        rar.a("video_edit", "exp_qzone", 0, 0, new String[] { str });
        if (psr.IP())
        {
          this.mHandler.sendEmptyMessageDelayed(0, 5000L);
          this.IN.setVisibility(0);
          this.ahU.setVisibility(0);
          psr.bmF();
          rar.a("video_edit", "exp_qztip", 0, 0, new String[0]);
        }
      }
    }
    for (;;)
    {
      Zl(this.dyM);
      return;
      str = "2";
      break;
      this.dyM = false;
      this.f.setVisibility(8);
    }
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    boolean bool = this.dyM;
    ram.w("Q.qqstory.publish.edit.EditSyncQzonePart", "story_sync_qzone : %s", new Object[] { Boolean.valueOf(bool) });
    paramayqb.g.putExtra("story_sync_qzone", Boolean.valueOf(bool));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.IN.setVisibility(8);
      this.ahU.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.IN.setVisibility(8);
    this.ahU.setVisibility(8);
    this.mHandler.removeMessages(0);
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
      if (this.b.a() != null) {
        this.b.a().ca.add(Integer.valueOf(11));
      }
      axxe.a(paramView, 200L, new ayex(this));
      if (this.dyM) {}
      for (String str = "1";; str = "2")
      {
        rar.a("video_edit", "clk_qzone", 0, 0, new String[] { str });
        this.IN.setVisibility(8);
        this.ahU.setVisibility(8);
        this.mHandler.removeMessages(0);
        break;
      }
      this.IN.setVisibility(8);
      this.ahU.setVisibility(8);
      this.mHandler.removeMessages(0);
      rar.a("video_edit", "clk_qztip", 0, 0, new String[0]);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mHandler = new Handler(this);
    this.f = ((PressDarkImageButton)y(2131379091));
    this.IN = ((ImageView)y(2131379073));
    this.ahU = ((TextView)y(2131379074));
    this.f.setOnClickListener(this);
    this.ahU.setOnClickListener(this);
    eQZ();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayew
 * JD-Core Version:    0.7.0.1
 */