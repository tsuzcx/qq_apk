package cooperation.troop_homework.outer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import awkf;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;

public class TroopHWRecordArrangeActivity
  extends TroopHWRecordBaseActivity
{
  private Handler bI = new awkf(this);
  private String cQV;
  private int mId = 20;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (getIntent() != null) {
      this.cQV = getIntent().getStringExtra("webid");
    }
    return bool;
  }
  
  protected void eEb()
  {
    this.c = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2131560053, null));
    this.nO.addView(this.c);
    this.c.a(this.app, this, this.bI);
    this.c.reset();
    this.c.setTimeOutTime(360000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop_homework.outer.TroopHWRecordArrangeActivity
 * JD-Core Version:    0.7.0.1
 */