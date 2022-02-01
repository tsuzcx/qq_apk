package dov.com.tencent.biz.qqstory.takevideo.artfilter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ayjh;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.io.File;
import wja;

public class ArtFilterItemView
  extends RelativeLayout
{
  AnimationDrawable a;
  public boolean aHx = false;
  public Handler br;
  private Context context;
  public RelativeLayout fV;
  private LinearLayout linearLayout;
  ImageView nl;
  String path;
  TextView yy;
  
  public ArtFilterItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    inflate(paramContext, 2131559767, this);
    this.linearLayout = ((LinearLayout)findViewById(2131363005));
    this.fV = ((RelativeLayout)findViewById(2131363007));
    this.nl = ((ImageView)findViewById(2131363008));
    this.yy = ((TextView)findViewById(2131363006));
  }
  
  public void a(EditVideoArtFilter paramEditVideoArtFilter)
  {
    btH();
    this.aHx = true;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.linearLayout.getHeight());
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setStartTime(0L);
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setAnimationListener(new ayjh(this, paramEditVideoArtFilter));
    this.linearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void as(int paramInt, boolean paramBoolean)
  {
    if (this.fV.getVisibility() == 8) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterItemView", 2, "updateProgress:updateCount:" + paramInt + ",hasFinished:" + paramBoolean);
      }
      if (paramBoolean)
      {
        this.yy.setText("100%");
        postDelayed(new ArtFilterItemView.1(this), 100L);
        return;
      }
    } while (this.yy.getText().equals("100&"));
    paramInt += 1;
    if (paramInt <= 40) {
      paramInt = (int)(paramInt * 1.25D);
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt >= 100) {
        i = 99;
      }
      this.yy.setText(i + "%");
      return;
      if (paramInt <= 50) {
        paramInt = (int)((paramInt - 40) * 2.5D + 50.0D);
      } else {
        paramInt = (paramInt - 50) / 6 + 75;
      }
    }
  }
  
  public void btH()
  {
    this.br.removeMessages(38);
    if (this.fV.getVisibility() == 0)
    {
      this.fV.setVisibility(8);
      this.a.stop();
      this.yy.setText("0%");
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.aHx;
  }
  
  public void setHandler(Handler paramHandler, String paramString)
  {
    this.br = paramHandler;
    this.path = paramString;
  }
  
  public void show()
  {
    setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, wja.dp2px(190.0F, this.context.getResources()), 0.0F);
    localTranslateAnimation.setInterpolator(new OvershootInterpolator());
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setStartTime(0L);
    localTranslateAnimation.setDuration(200L);
    this.aHx = false;
    this.linearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void xh(int paramInt)
  {
    if (this.a == null)
    {
      this.a = new AnimationDrawable();
      localObject = new File(this.path).listFiles();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          Drawable localDrawable = Drawable.createFromPath(localObject[i].getAbsolutePath());
          if (localDrawable != null) {
            this.a.addFrame(localDrawable, 50);
          }
          i += 1;
        }
      }
      if (this.a.getNumberOfFrames() != 0)
      {
        this.a.setOneShot(false);
        this.nl.setBackgroundDrawable(this.a);
      }
    }
    btH();
    this.fV.setVisibility(0);
    Object localObject = this.br.obtainMessage(38);
    ((Message)localObject).arg1 = paramInt;
    ((Message)localObject).arg2 = 0;
    this.br.sendMessageDelayed((Message)localObject, 100L);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView
 * JD-Core Version:    0.7.0.1
 */