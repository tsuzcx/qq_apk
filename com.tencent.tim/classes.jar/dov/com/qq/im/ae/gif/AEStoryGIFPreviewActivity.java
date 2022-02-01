package dov.com.qq.im.ae.gif;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import axec;
import axem;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.SessionWrap;

public class AEStoryGIFPreviewActivity
  extends BaseVMPeakActivity
{
  private SessionWrap b;
  private String cTM = "";
  private boolean duf;
  private String materialId;
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 21) && (paramInt2 == -1))
    {
      setResult(201);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    setContentView(2131558622);
    paramBundle = getIntent().getStringExtra("KEY_PREVIEW_SOURCE_PATH");
    int i = getIntent().getIntExtra("AECAMERA_MODE", 200);
    this.duf = getIntent().getBooleanExtra("KEY_MATERIAL_APPLIED", false);
    this.materialId = getIntent().getStringExtra("ARG_GIF_MATERIAL_ID");
    this.cTM = getIntent().getStringExtra("KEY_AVAILABLE_SAVENAME");
    this.b = ((SessionWrap)getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    boolean bool = getIntent().getBooleanExtra("ARG_GIF_SEND_TO_AIO", false);
    long l = getIntent().getLongExtra("KEY_AVAILABLE_EMO_COUNT", 9223372036854775807L);
    FragmentManager localFragmentManager = getFragmentManager();
    if (i == 202) {
      if (localFragmentManager.findFragmentByTag(axec.class.getSimpleName()) == null) {
        localFragmentManager.beginTransaction().add(2131367564, axec.a(paramBundle, l), axec.class.getSimpleName()).commit();
      }
    }
    while (localFragmentManager.findFragmentByTag(axem.class.getSimpleName()) != null) {
      return;
    }
    localFragmentManager.beginTransaction().add(2131367564, axem.a(paramBundle, Boolean.valueOf(this.duf), this.materialId, this.cTM, this.b, bool), axem.class.getSimpleName()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity
 * JD-Core Version:    0.7.0.1
 */