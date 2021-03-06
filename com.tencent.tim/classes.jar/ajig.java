import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.MultiAIOStarter.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.app.AppRuntime;

public class ajig
{
  public static boolean coN;
  
  private static void a(BaseActivity paramBaseActivity, ajil paramajil)
  {
    ThreadManagerV2.postImmediately(new MultiAIOStarter.2(paramBaseActivity, paramajil), null, false);
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start curType = " + paramInt + " from = " + paramString3 + ", hasOpened = " + coN);
    }
    if (!ajhz.aqM())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start is forbid: local switch is closed! do not start multiAIO!");
      }
      return false;
    }
    if (!((ajik)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).aqC())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start error: 配置下发限制 do not start multiAIO!");
      }
      return false;
    }
    if (AppSetting.enableTalkBack)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start error: 无障碍 mode do not start multiAIO!");
      }
      return false;
    }
    if (((paramContext instanceof BaseActivity)) && (((BaseActivity)paramContext).isInMultiWindow()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start error: 分屏 mode do not start multiAIO!");
      }
      return false;
    }
    if (coN) {
      return true;
    }
    if (ajhz.kr(paramInt))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("conversation_tab_flag", paramString3);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("OPEN_MULTI_FROM_ACTIVITY", paramContext.getClass().getSimpleName());
      ajhz.clear();
      QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
      ajil localajil = ajil.a(localQQAppInterface);
      Bitmap localBitmap = d(paramContext);
      int i = aw(paramContext);
      coN = true;
      localajil.U(localBitmap);
      localajil.QU(i);
      a((BaseActivity)paramContext, localajil);
      localajil.a((QQAppInterface)localQQAppInterface, (FragmentActivity)paramContext, paramString3, paramInt, paramString1, paramString2);
      localajil.a(new ajih(paramContext));
      localIntent.putExtra("OPEN_MULTI_AIO_CONTEXT", localajil.getId());
      if ("open_from_aio".equals(paramString3)) {
        localIntent.putExtra("OPEN_MULTI_AIO_LIST_VIEW_SPECIFY_BOTTOM", b(paramContext));
      }
      PublicFragmentActivity.b.start(paramContext, localIntent, PublicTransFragmentActivity.class, MultiAIOFragment.class);
      return true;
    }
    return false;
  }
  
  private static int aw(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).findViewById(16908290);
      if (paramContext != null) {
        return paramContext.getHeight();
      }
    }
    return 0;
  }
  
  private static int[] b(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int j;
    int i;
    View localView;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (ListView)((BaseActivity)paramContext).findViewById(2131370537);
      if (paramContext != null)
      {
        j = paramContext.getBottom() - paramContext.getPaddingBottom();
        i = paramContext.getChildCount();
        if (i < 0) {
          break label144;
        }
        localView = paramContext.getChildAt(i);
        if ((localView == null) || (j <= localView.getTop()) || (j > localView.getBottom())) {
          break label137;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == -1) {
        j = paramContext.getChildCount() - 1;
      }
      if (j != -1)
      {
        arrayOfInt[0] = (paramContext.getFirstVisiblePosition() + j);
        localView = paramContext.getChildAt(j);
        if (localView != null) {
          arrayOfInt[1] = (paramContext.getBottom() - paramContext.getPaddingBottom() - localView.getBottom());
        }
      }
      return arrayOfInt;
      label137:
      i -= 1;
      break;
      label144:
      i = -1;
    }
  }
  
  private static Bitmap d(Context paramContext)
  {
    View localView;
    int i;
    int j;
    if ((paramContext instanceof BaseActivity))
    {
      localView = ((BaseActivity)paramContext).getWindow().getDecorView();
      i = localView.getWidth();
      j = localView.getHeight();
    }
    for (;;)
    {
      try
      {
        localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        Canvas localCanvas;
        QLog.e("MultiAIOStarter", 1, "getDecorViewBitmap: ", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localBitmap.setDensity(paramContext.getResources().getDisplayMetrics().densityDpi);
          localCanvas = new Canvas(localBitmap);
          localView.draw(localCanvas);
          localCanvas.setBitmap(null);
          if (QLog.isColorLevel()) {
            QLog.d("MultiAIOStarter", 2, "getDecorViewBitmap() called with: context = [" + paramContext + "], bitmap = " + localBitmap);
          }
          return localBitmap;
        }
        catch (Throwable localThrowable2)
        {
          break label125;
        }
        localThrowable1 = localThrowable1;
        localBitmap = null;
      }
      label125:
      ajim.dxL();
      continue;
      Bitmap localBitmap = null;
    }
  }
  
  public static void dxI()
  {
    try
    {
      ((Vibrator)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("vibrator")).vibrate(20L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOStarter", 2, "asynViratorExecute Vibrator exception.");
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajig
 * JD-Core Version:    0.7.0.1
 */