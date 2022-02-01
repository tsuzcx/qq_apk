package com.tencent.token.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import btmsdkobf.bw;
import com.tencent.token.xw;

public class DeviceInfo1Activity
  extends BaseActivity
  implements View.OnClickListener
{
  public static String starReplace(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("****");
    localStringBuilder.append(paramString.substring(paramString.length() - 6));
    return localStringBuilder.toString();
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296318);
    ((TextView)findViewById(2131165283)).setText(starReplace(xw.b(this)));
    ((TextView)findViewById(2131165583)).setText(starReplace(bw.ah().aj()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DeviceInfo1Activity
 * JD-Core Version:    0.7.0.1
 */