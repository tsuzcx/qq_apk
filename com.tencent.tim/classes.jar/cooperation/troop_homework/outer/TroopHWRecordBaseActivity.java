package cooperation.troop_homework.outer;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import awkg;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class TroopHWRecordBaseActivity
  extends BaseActivity
{
  protected View HQ;
  public AudioInfo a;
  public CommonRecordSoundPanel c;
  public boolean cQC;
  protected RelativeLayout nO;
  private View.OnClickListener x = new awkg(this);
  
  private void b(Resources paramResources, View paramView)
  {
    paramResources = paramResources.getDrawable(2130851275);
    if ((paramResources instanceof BitmapDrawable)) {
      paramResources = ((BitmapDrawable)paramResources).getBitmap();
    }
    for (;;)
    {
      paramResources = new BitmapDrawable(paramResources);
      paramResources.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramResources.setDither(true);
      paramView.setBackgroundDrawable(paramResources);
      return;
      if ((paramResources instanceof SkinnableBitmapDrawable)) {
        paramResources = ((SkinnableBitmapDrawable)paramResources).getBitmap();
      } else {
        paramResources = null;
      }
    }
  }
  
  private void initViews()
  {
    this.HQ = findViewById(2131380133);
    this.HQ.setBackgroundColor(1291845632);
    this.HQ.setOnClickListener(this.x);
    this.nO = ((RelativeLayout)findViewById(2131376959));
    b(getResources(), this.nO);
    eEb();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2131560823);
    initViews();
    return true;
  }
  
  protected void eEb() {}
  
  public void finish()
  {
    super.finish();
    this.HQ.setBackgroundResource(2130851773);
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkRecordActivity", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + this.c.isRecording());
    }
    this.c.onBackEvent();
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkRecordActivity", 2, "RecordPanel.onDestroy() is called,isRecording is:" + this.c.isRecording());
    }
    this.c.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkRecordActivity", 2, "RecordPanel.onPause() is called,isRecording is:" + this.c.isRecording());
    }
    this.c.onPause();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop_homework.outer.TroopHWRecordBaseActivity
 * JD-Core Version:    0.7.0.1
 */