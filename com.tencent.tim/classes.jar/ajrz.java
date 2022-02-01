import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajrz
  implements View.OnTouchListener
{
  protected arec b = new ajsd(this);
  protected BroadcastReceiver bv = new ajse(this);
  protected int cPZ;
  protected int dkS;
  protected Context mContext;
  protected boolean mIsAttached;
  protected boolean mIsDragging;
  protected int mState;
  protected TextView mView;
  protected WindowManager mWindowManager;
  
  public ajrz()
  {
    this(BaseApplicationImpl.getApplication());
  }
  
  public ajrz(Context paramContext)
  {
    this.mContext = paramContext;
    this.mView = new TextView(this.mContext);
    this.mView.setOnTouchListener(this);
    this.mView.setText(acfp.m(2131706780));
    this.mView.setTextSize(10.0F);
    this.mView.setTextColor(Color.parseColor("#B2FFFFFF"));
    this.mView.setGravity(81);
    this.mView.setPadding(0, 0, 0, riw.dip2px(this.mContext, 15.0F));
    paramContext = new IntentFilter("tencent.video.v2q.SmallScreenState");
    this.mContext.registerReceiver(this.bv, paramContext);
  }
  
  private void Jv()
  {
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.mView.getLayoutParams();
    int j = this.mWindowManager.getDefaultDisplay().getWidth();
    int i = this.mWindowManager.getDefaultDisplay().getHeight();
    if (localLayoutParams.x - this.mView.getWidth() / 2 > j / 2)
    {
      j = j - this.mView.getWidth() - riw.dip2px(this.mContext, 10.0F);
      if (localLayoutParams.y - this.mView.getHeight() / 2 <= i * 0.8F) {
        break label251;
      }
      i = i - this.mView.getHeight() - riw.dip2px(this.mContext, 10.0F);
    }
    for (;;)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { localLayoutParams.x, j });
      localValueAnimator.addUpdateListener(new ajsb(this, localLayoutParams, localValueAnimator));
      localValueAnimator.setDuration(200L);
      localValueAnimator.setTarget(this.mView);
      localValueAnimator.start();
      localValueAnimator = ValueAnimator.ofInt(new int[] { localLayoutParams.y, i });
      localValueAnimator.addUpdateListener(new ajsc(this, localLayoutParams, localValueAnimator));
      localValueAnimator.setDuration(200L);
      localValueAnimator.setTarget(this.mView);
      localValueAnimator.start();
      return;
      j = riw.dip2px(this.mContext, 10.0F);
      break;
      label251:
      if (localLayoutParams.y - this.mView.getHeight() / 2 > i * 0.6F) {
        i = (int)((i - this.mView.getHeight()) * 0.75F);
      } else if (localLayoutParams.y - this.mView.getHeight() / 2 > i * 0.4F) {
        i = (int)((i - this.mView.getHeight()) * 0.5F);
      } else if (localLayoutParams.y - this.mView.getHeight() / 2 > i * 0.2F) {
        i = (int)((i - this.mView.getHeight()) * 0.25F);
      } else {
        i = riw.dip2px(this.mContext, 10.0F);
      }
    }
  }
  
  protected void a(HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      paramHotChatInfo.isGameRoom = true;
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = ((QQAppInterface)localObject1).a().createEntityManager();
      ((EntityManager)localObject2).update(paramHotChatInfo);
      ((EntityManager)localObject2).close();
      localObject1 = (HotChatManager)((QQAppInterface)localObject1).getManager(60);
      localObject2 = ((HotChatManager)localObject1).dX();
      if ((localObject2 != null) && (!((List)localObject2).contains(paramHotChatInfo))) {
        ((List)localObject2).add(paramHotChatInfo);
      }
      ((HotChatManager)localObject1).a(paramHotChatInfo, 4);
      paramHotChatInfo = new Intent(this.mContext, ChatActivity.class);
      paramHotChatInfo.putExtra("uin", paramInt + "");
      paramHotChatInfo.putExtra("uintype", 1);
      paramHotChatInfo.putExtra("troop_uin", paramInt + "");
      paramHotChatInfo.putExtra("uinname", paramString2);
      paramHotChatInfo.putExtra("hotnamecode", paramString1);
      paramHotChatInfo = wja.a(paramHotChatInfo, new int[] { 2 });
      paramHotChatInfo.addFlags(268435456);
      this.mContext.startActivity(paramHotChatInfo);
      dismiss();
      return;
    }
    finally {}
  }
  
  public void b(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFloatView", 2, "GameRoomFloatView->show: state = " + paramInt1);
    }
    this.mState = paramInt1;
    if (this.mWindowManager == null) {
      this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
    }
    Object localObject;
    if (!this.mIsAttached) {
      if (!ivv.isFloatWindowOpAllowed(this.mContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameRoomFloatView", 2, "GameRoomFloatView->show: isFloatWindowOpAllowed = false");
        }
        localObject = new Intent(this.mContext, SmallScreenDialogActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(131072);
        this.mContext.startActivity((Intent)localObject);
      }
    }
    try
    {
      this.mWindowManager.removeViewImmediate(this.mView);
      label169:
      int j = this.mWindowManager.getDefaultDisplay().getWidth();
      int k = this.mWindowManager.getDefaultDisplay().getHeight();
      int i;
      if (Build.VERSION.SDK_INT >= 26) {
        i = 2038;
      }
      for (;;)
      {
        localObject = new WindowManager.LayoutParams(-2, -2, i, 776, -2);
        ((WindowManager.LayoutParams)localObject).gravity = 51;
        ((WindowManager.LayoutParams)localObject).x = (j - riw.dip2px(this.mContext, 62.0F) - riw.dip2px(this.mContext, 10.0F));
        ((WindowManager.LayoutParams)localObject).y = ((int)((k - riw.dip2px(this.mContext, 67.0F)) * 0.25F));
        this.mView.setBackgroundResource(2130843115);
        try
        {
          this.mWindowManager.addView(this.mView, (ViewGroup.LayoutParams)localObject);
          this.mIsAttached = true;
          if (paramInt1 == 0)
          {
            this.mView.setText(acfp.m(2131706831));
            this.mView.setOnClickListener(new ajsa(this, paramInt1, paramLong, paramString2, paramString1, paramInt2));
            ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.b);
            return;
            i = 2010;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QLog.e("GameRoomFloatView", 1, localException1, new Object[0]);
            continue;
            this.mView.setText(acfp.m(2131706822));
          }
        }
      }
    }
    catch (Exception localException2)
    {
      break label169;
    }
  }
  
  public void dismiss()
  {
    if (this.mIsAttached) {}
    try
    {
      this.mView.setBackgroundResource(0);
      this.mWindowManager.removeViewImmediate(this.mView);
      label28:
      this.mIsAttached = false;
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.b);
      return;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawX();
    int k = (int)paramMotionEvent.getRawY();
    if (i == 0)
    {
      this.dkS = ((int)paramMotionEvent.getX());
      this.cPZ = ((int)paramMotionEvent.getY());
    }
    label225:
    do
    {
      return false;
      if (i == 2)
      {
        if ((this.mIsDragging) || (Math.abs(paramMotionEvent.getX() - this.dkS) > riw.dip2px(this.mContext, 10.0F)) || (Math.abs(paramMotionEvent.getY() - this.cPZ) > riw.dip2px(this.mContext, 10.0F)))
        {
          this.mIsDragging = true;
          paramView = (WindowManager.LayoutParams)this.mView.getLayoutParams();
          paramView.x = (j - this.dkS);
          paramView.y = (k - this.cPZ - riw.dip2px(this.mContext, 25.0F));
          i = this.mWindowManager.getDefaultDisplay().getWidth();
          j = this.mWindowManager.getDefaultDisplay().getHeight();
          if (paramView.x >= 0) {
            break label225;
          }
          paramView.x = 0;
          if (paramView.y >= 0) {
            break label257;
          }
          paramView.y = 0;
        }
        for (;;)
        {
          this.mWindowManager.updateViewLayout(this.mView, paramView);
          return true;
          if (paramView.x <= i - this.mView.getWidth()) {
            break;
          }
          paramView.x = (i - this.mView.getWidth());
          break;
          if (paramView.y > j - this.mView.getHeight()) {
            paramView.y = (j - this.mView.getHeight());
          }
        }
      }
    } while ((i != 1) && (i != 3));
    label257:
    if (this.mIsDragging)
    {
      Jv();
      this.mIsDragging = false;
      return true;
    }
    this.mIsDragging = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrz
 * JD-Core Version:    0.7.0.1
 */