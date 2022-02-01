package dov.com.tencent.biz.qqstory.takevideo;

import acbn;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QQStoryTakeVideoCloseAnimationActivity
  extends QQStoryBaseActivity
{
  public static final String azX = acbn.bmi + "qqstory/animation_cover.jpg";
  public static Bitmap hD;
  protected ImageView mImageView;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mImageView = new ImageView(this);
    super.getWindow().addFlags(1024);
    super.setContentViewNoTitle(this.mImageView);
    if ((hD != null) && (!hD.isRecycled())) {
      this.mImageView.setImageBitmap(hD);
    }
    hD = null;
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.getUIHandler().postDelayed(new QQStoryTakeVideoCloseAnimationActivity.1(this), 150L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity
 * JD-Core Version:    0.7.0.1
 */