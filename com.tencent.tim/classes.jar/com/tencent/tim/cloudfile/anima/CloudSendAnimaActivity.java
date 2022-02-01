package com.tencent.tim.cloudfile.anima;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import aqnm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.MessageFormat;

public class CloudSendAnimaActivity
  extends BaseActivity
{
  float x;
  float y;
  
  private void a(DynamicButton paramDynamicButton, String paramString)
  {
    int[] arrayOfInt = new int[2];
    paramDynamicButton.getLocationOnScreen(arrayOfInt);
    float f1 = arrayOfInt[0];
    float f2 = paramDynamicButton.getPivotX() + f1;
    f1 = arrayOfInt[1] + paramDynamicButton.getPivotY();
    if (Build.VERSION.SDK_INT <= 20)
    {
      f2 = arrayOfInt[0] + paramDynamicButton.getWidth() / 2;
      f1 = arrayOfInt[1] + paramDynamicButton.getHeight() / 2;
    }
    float f3 = aqnm.dpToPx(25.0F);
    float f4 = this.x;
    float f5 = this.y;
    float f6 = aqnm.dpToPx(8.5F);
    paramDynamicButton.a(DynamicButton.a.a().a(100L).d(100).b((int)f3).a((int)f3).a(paramString).a(f4 - f2).b(f5 - f1 + f6).e(600).a(this).f(600).c(getResources().getColor(2131165781)));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2131558976);
    DynamicButton localDynamicButton = (DynamicButton)findViewById(2131377987);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("count", 0);
    this.x = paramBundle.getIntExtra("x", 0);
    this.y = paramBundle.getIntExtra("y", 0);
    if (i <= 99) {}
    for (paramBundle = MessageFormat.format(getString(2131691590), new Object[] { Integer.valueOf(i) });; paramBundle = MessageFormat.format(getString(2131691590), new Object[] { "99+" }))
    {
      localDynamicButton.setText(paramBundle);
      localDynamicButton.post(new CloudSendAnimaActivity.1(this, i, localDynamicButton));
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mNeedStatusTrans))
      {
        paramBundle = findViewById(16908310);
        if (paramBundle != null)
        {
          paramBundle = (View)paramBundle.getParent();
          if (paramBundle != null) {
            paramBundle.setVisibility(8);
          }
        }
      }
      return bool;
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.anima.CloudSendAnimaActivity
 * JD-Core Version:    0.7.0.1
 */