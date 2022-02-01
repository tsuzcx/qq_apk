import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.1;
import com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.3;
import com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class wwd
  implements wvs
{
  private long IF;
  private Runnable em = new MultiWindowAIOHelper.1(this);
  private BaseChatPie f;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  public wwd(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
  }
  
  private ajil a()
  {
    BaseActivity localBaseActivity = this.f.a();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {}
    int i;
    do
    {
      return null;
      i = localBaseActivity.getIntent().getIntExtra("KEY_MULTI_WINDOW_AIO_CONTEXT_ID", -1);
    } while (i == -1);
    return ((ajik)localBaseActivity.app.getManager(325)).b(i);
  }
  
  private void ccB()
  {
    this.IF = SystemClock.elapsedRealtime();
  }
  
  private void ccC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onShowFirst() called");
    }
  }
  
  private void ccD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "tryRestoreListViewState() called");
    }
    Object localObject1 = this.f.a;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((wki)localObject1).getList();
      i = wh();
      if ((localObject1 != null) && (((List)localObject1).size() == i))
      {
        localObject1 = a();
        if ((localObject1 != null) && (((ajil)localObject1).aqO()))
        {
          localObject2 = ((ajil)localObject1).a();
          if (localObject2 != null)
          {
            localObject2 = ((ajip)localObject2).e();
            if (localObject2 != null) {
              break label100;
            }
            QLog.e("MultiWindowAIOHelper", 1, "tryRestoreListViewState: listView == null");
          }
        }
      }
    }
    return;
    label100:
    int i = ((ListView)localObject2).getLastVisiblePosition();
    View localView = ((ListView)localObject2).getChildAt(((ListView)localObject2).getChildCount() - 1);
    int j = ((ListView)localObject2).getBottom() - localView.getBottom();
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "tryRestoreListViewState() anchorPosition = " + i + ", specifyBottom = " + j);
    }
    this.f.b.setOnLayoutListener(null);
    this.mUiHandler.post(new MultiWindowAIOHelper.3(this, i, j));
    this.mUiHandler.postDelayed(new MultiWindowAIOHelper.4(this, (ajil)localObject1), 350L);
  }
  
  private void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onCreate() called");
    }
    Object localObject = a();
    if ((localObject != null) && (((ajil)localObject).aqO()))
    {
      localObject = this.f.b;
      if (localObject != null) {
        ((ChatXListView)localObject).setOnLayoutListener(new wwe(this));
      }
    }
  }
  
  private void onDestroy() {}
  
  private void onPause()
  {
    this.mUiHandler.removeCallbacks(this.em);
  }
  
  private void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onResume() called");
    }
  }
  
  private void onShow()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onShow() called");
    }
  }
  
  private void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onStart() called");
    }
  }
  
  private int wh()
  {
    ajil localajil = a();
    if (localajil == null) {
      return -1;
    }
    return localajil.wh();
  }
  
  public int[] C()
  {
    return new int[] { 3, 5, 7, 8, 9, 13, 16 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 10: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    default: 
      return;
    case 3: 
      onCreate();
      return;
    case 4: 
      onStart();
      return;
    case 5: 
      onResume();
    case 7: 
      ccC();
      return;
    case 8: 
      onShow();
      return;
    case 9: 
      onPause();
      return;
    case 13: 
      onDestroy();
      return;
    }
    ccB();
  }
  
  public void ccA()
  {
    if ((this.f != null) && (this.f.a != null)) {
      this.f.a.bYX();
    }
    long l = SystemClock.elapsedRealtime();
    if (l - this.IF >= 1000L)
    {
      this.mUiHandler.removeCallbacks(this.em);
      this.mUiHandler.postDelayed(this.em, 300L);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MultiWindowAIOHelper", 2, "AIO start multi window!  but list idle time lower 2s!  please wait... dif time = " + (l - this.IF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwd
 * JD-Core Version:    0.7.0.1
 */