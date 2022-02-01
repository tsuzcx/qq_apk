import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class abic
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public abic(ApolloRender paramApolloRender, View paramView) {}
  
  public void onGlobalLayout()
  {
    if ((this.b.mEditWindow == null) || (!this.b.mShowEditWindow)) {
      QLog.e("rogersxiao", 2, "render.mEditWindow return");
    }
    do
    {
      return;
      localObject = new Rect();
      this.val$contentView.getWindowVisibleDisplayFrame((Rect)localObject);
      i = (int)aqgz.getHeight();
      j = ((Rect)localObject).bottom;
      int k = ((Rect)localObject).top;
      ImmersiveUtils.getStatusBarHeight(this.val$contentView.getContext());
      if (i - (j - k) >= 200) {
        break;
      }
    } while (!ApolloRender.sIsKeyBoardShow);
    this.b.mEditWindow.dismiss();
    ApolloRender.sIsKeyBoardDissmiss = true;
    return;
    int i = ((Rect)localObject).bottom - this.b.mEditWindow.getHeight();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    int j = ((SharedPreferences)localObject).getInt("sp_key_apollo_keyboard_height", 0);
    if ((this.val$contentView.getContext() instanceof Activity))
    {
      if (((Activity)this.val$contentView.getContext()).isFinishing())
      {
        QLog.e("sava_ApolloRender", 1, "showKeyBorad activity is isFinishing");
        return;
      }
      if ((Build.VERSION.SDK_INT >= 17) && (((Activity)this.val$contentView.getContext()).isDestroyed()))
      {
        QLog.e("sava_ApolloRender", 1, "showKeyBorad activity is destroy");
        return;
      }
    }
    if (j != i) {}
    try
    {
      ((SharedPreferences)localObject).edit().putInt("sp_key_apollo_keyboard_height", i).commit();
      this.b.mEditWindow.showAtLocation(this.val$contentView.getRootView(), 0, 0, i);
      this.b.mEditWindow.update(0, i, this.b.mEditWindow.getWidth(), this.b.mEditWindow.getHeight());
      ApolloRender.sIsKeyBoardDissmiss = false;
      if (ApolloRender.sIsKeyBoardDissmiss)
      {
        this.b.mEditWindow.showAtLocation(this.val$contentView.getRootView(), 0, 0, i);
        this.b.mEditWindow.update(0, i, this.b.mEditWindow.getWidth(), this.b.mEditWindow.getHeight());
        ApolloRender.sIsKeyBoardDissmiss = false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("sava_ApolloRender", 1, localException, new Object[0]);
      }
    }
    ApolloRender.sIsKeyBoardShow = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abic
 * JD-Core Version:    0.7.0.1
 */