import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.VideoInviteFloatBar.1;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jet
  implements View.OnClickListener, View.OnTouchListener
{
  boolean VL = true;
  boolean Ys = false;
  boolean Yt = false;
  private WindowManager.LayoutParams a;
  private Runnable ce = new VideoInviteFloatBar.1(this);
  private float hU;
  private float hV;
  private Handler handler = new Handler();
  private boolean isShow;
  private int mAnimations = 2131756481;
  private Context mContext;
  private int mDuration = 0;
  Intent mIntent = null;
  String mPeerUin = null;
  private View mView;
  WindowManager mWindowManager;
  TextView ne;
  TextView nf;
  private float x;
  private float y;
  
  public jet(Context paramContext)
  {
    this.mContext = paramContext;
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.mView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131559989, null);
    this.mView.setOnTouchListener(this);
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    ((ImageView)this.mView.findViewById(2131366624)).setImageBitmap(paramBitmap);
    ((TextView)this.mView.findViewById(2131372190)).setText(paramString);
  }
  
  void avm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBar", 2, "initTN");
    }
    for (;;)
    {
      try
      {
        this.a = new WindowManager.LayoutParams();
        this.a.height = -2;
        this.a.width = -1;
        this.a.flags = 2098088;
        if (Build.VERSION.SDK_INT >= 26)
        {
          this.a.type = 2038;
          this.a.format = -3;
          if (Build.VERSION.SDK_INT >= 19)
          {
            WindowManager.LayoutParams localLayoutParams = this.a;
            localLayoutParams.flags |= 0x4000000;
          }
          this.a.gravity = 49;
          if (this.mAnimations != -1) {
            this.a.windowAnimations = this.mAnimations;
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoInviteFloatBar", 2, "startHandler addView start");
        }
        this.mWindowManager.addView(this.mView, this.a);
        this.isShow = true;
        if (QLog.isColorLevel()) {
          QLog.d("VideoInviteFloatBar", 2, "startHandler addView end");
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.mWindowManager.updateViewLayout(this.mView, this.a);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + localIllegalStateException);
        return;
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + localBadTokenException);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoInviteFloatBar", 2, "startHandler error : " + localSecurityException);
        return;
      }
      catch (Exception localException2)
      {
        igd.aL("VideoInviteFloatBar", "startHandler error : " + localException2);
      }
      this.a.type = 2010;
    }
  }
  
  public void avn()
  {
    Object localObject = (Button)this.mView.findViewById(2131361831);
    Button localButton = (Button)this.mView.findViewById(2131377092);
    ((Button)localObject).setVisibility(4);
    localButton.setVisibility(4);
    this.nf.setVisibility(4);
    localObject = (TextView)this.mView.findViewById(2131371310);
    this.mView.invalidate();
  }
  
  public void hide()
  {
    Log.i("VideoInviteFloatBar", "hide");
    if (!this.isShow) {}
    do
    {
      for (;;)
      {
        return;
        this.isShow = false;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoInviteFloatBar", 2, "hide removeView start");
          }
          if (this.mWindowManager != null) {
            this.mWindowManager.removeView(this.mView);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("VideoInviteFloatBar", 2, "hide removeView end");
            return;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoInviteFloatBar", 2, "hide error : " + localException);
  }
  
  public void i(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.VL = paramBoolean1;
    this.Yt = paramBoolean2;
    this.Ys = paramBoolean3;
    QLog.w("VideoInviteFloatBar", 1, "show, mIsAudioMode[" + this.VL + "], misMultiCall[" + this.Yt + "], mIsMultiIncomingCall[" + this.Ys + "]");
    if (this.isShow) {
      return;
    }
    TextView localTextView = (TextView)this.mView.findViewById(2131371310);
    Button localButton1 = (Button)this.mView.findViewById(2131361831);
    Button localButton2 = (Button)this.mView.findViewById(2131377092);
    localButton1.setClickable(true);
    localButton2.setClickable(true);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    if (paramBoolean3) {
      if (this.VL) {
        localTextView.setText(localTextView.getResources().getString(2131697541));
      }
    }
    for (;;)
    {
      avm();
      if (this.mDuration <= 0) {
        break;
      }
      this.handler.postDelayed(this.ce, this.mDuration * 1000);
      return;
      localTextView.setText(localTextView.getResources().getString(2131697542));
      continue;
      if (this.VL) {
        localTextView.setText(localTextView.getResources().getString(2131697540));
      } else {
        localTextView.setText(localTextView.getResources().getString(2131697543));
      }
    }
  }
  
  public void km(String paramString)
  {
    this.ne = ((TextView)this.mView.findViewById(2131371310));
    this.ne.setText(paramString);
    this.mView.invalidate();
  }
  
  public TextView o()
  {
    return (TextView)this.mView.findViewById(2131372190);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131361831: 
      l = AudioHelper.hG();
      QLog.w("VideoInviteFloatBar", 1, "onClick accept, mIsMultiIncomingCall[" + this.Ys + "], misMultiCall[" + this.Yt + "], seq[" + l + "]");
      localIntent = new Intent();
      jlc.a(localIntent, l);
      if (this.Ys) {
        localIntent.setAction("tencent.video.invite.multiaccept");
      }
      for (;;)
      {
        ((Button)this.mView.findViewById(2131361831)).setClickable(false);
        ((Button)this.mView.findViewById(2131377092)).setClickable(false);
        localIntent.setPackage(this.mContext.getPackageName());
        this.mContext.sendBroadcast(localIntent);
        break;
        if (this.Yt) {
          localIntent.setAction("tencent.video.invite.gaaccept");
        } else {
          localIntent.setAction("tencent.video.invite.accept");
        }
      }
    }
    long l = AudioHelper.hG();
    QLog.w("VideoInviteFloatBar", 1, "onClick reject, mIsMultiIncomingCall[" + this.Ys + "], misMultiCall[" + this.Yt + "], seq[" + l + "]");
    Intent localIntent = new Intent();
    jlc.a(localIntent, l);
    if (this.Ys) {
      localIntent.setAction("tencent.video.invite.multirefuse");
    }
    for (;;)
    {
      localIntent.setPackage(this.mContext.getPackageName());
      this.mContext.sendBroadcast(localIntent);
      hide();
      break;
      if (this.Yt) {
        localIntent.setAction("tencent.video.invite.gaignore");
      } else {
        localIntent.setAction("tencent.video.invite.refuse");
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.x = paramMotionEvent.getRawX();
    this.y = paramMotionEvent.getRawY();
    Log.i("currP", "currX" + this.x + "====currY" + this.y);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.hU = paramMotionEvent.getX();
      this.hV = paramMotionEvent.getY();
      continue;
      if (paramMotionEvent.getY() - this.hV < 0.0F) {
        hide();
      }
    }
  }
  
  public void setImg(Bitmap paramBitmap)
  {
    ((ImageView)this.mView.findViewById(2131366624)).setImageBitmap(paramBitmap);
  }
  
  public void setMessage(String paramString)
  {
    this.ne = ((TextView)this.mView.findViewById(2131371310));
    this.ne.setText(paramString);
    this.mView.invalidate();
  }
  
  public void setName(String paramString)
  {
    ((TextView)this.mView.findViewById(2131372190)).setText(paramString);
  }
  
  public void setTimeStamp(String paramString)
  {
    this.nf = ((TextView)this.mView.findViewById(2131379709));
    this.nf.setText(paramString);
    this.mView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jet
 * JD-Core Version:    0.7.0.1
 */