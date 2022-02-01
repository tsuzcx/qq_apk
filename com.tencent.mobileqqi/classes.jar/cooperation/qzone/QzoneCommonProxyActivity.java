package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import iby;

public class QzoneCommonProxyActivity
  extends Activity
{
  private Intent a;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903321);
    this.a = getIntent();
    this.a.addFlags(33554432);
    paramBundle = iby.a(QzonePluginProxyActivity.a(this.a));
    this.a.setClass(this, paramBundle);
    startActivity(this.a);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.QzoneCommonProxyActivity
 * JD-Core Version:    0.7.0.1
 */