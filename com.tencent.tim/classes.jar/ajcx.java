import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx.b;
import mqq.util.WeakReference;

public class ajcx
  extends ArrowKeyMovementMethod
  implements XEditTextEx.b
{
  private static ajcx a;
  private WeakReference<wvd> aM;
  private WeakReference<BaseChatPie> aN;
  private boolean cnx = true;
  private int dhU;
  private int dhV;
  private int dhW;
  private Class z;
  
  public static ajcx a(int paramInt, Class<? extends ImageSpan> paramClass)
  {
    if (a == null) {
      a = new ajcx();
    }
    a.dhW = paramInt;
    a.z = paramClass;
    return a;
  }
  
  public static void c(wvd paramwvd)
  {
    if (a != null)
    {
      if (paramwvd != null) {
        a.aM = new WeakReference(paramwvd);
      }
    }
    else {
      return;
    }
    a.aM = null;
  }
  
  public static void dwc()
  {
    if (a != null) {
      a.cnx = true;
    }
  }
  
  public static void z(BaseChatPie paramBaseChatPie)
  {
    if (a != null)
    {
      if (paramBaseChatPie != null) {
        a.aN = new WeakReference(paramBaseChatPie);
      }
    }
    else {
      return;
    }
    a.aN = null;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.dhU = ((int)paramMotionEvent.getX());
      this.dhV = ((int)paramMotionEvent.getY());
    }
    int j;
    int m;
    int k;
    Object[] arrayOfObject;
    int n;
    int i1;
    boolean bool;
    if (paramMotionEvent.getAction() == 1)
    {
      i = (int)paramMotionEvent.getX();
      j = (int)paramMotionEvent.getY();
      if ((Math.abs(this.dhU - i) < 10) && (Math.abs(this.dhV - j) < 10))
      {
        m = paramTextView.getTotalPaddingLeft();
        k = paramTextView.getTotalPaddingTop();
        i = i - m + paramTextView.getScrollX();
        j = j - k + paramTextView.getScrollY();
        Layout localLayout = paramTextView.getLayout();
        m = localLayout.getLineForVertical(j);
        k = localLayout.getOffsetForHorizontal(m, i);
        arrayOfObject = paramSpannable.getSpans(k, k, this.z);
        if (arrayOfObject.length > 0)
        {
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(arrayOfObject[0]), paramSpannable.getSpanEnd(arrayOfObject[0]));
          paramSpannable = (BaseChatPie)this.aN.get();
          if ((!(arrayOfObject[0] instanceof ImageSpan)) || (paramSpannable == null)) {
            return false;
          }
          k = localLayout.getLineTop(m);
          m = localLayout.getLineBottom(m);
          n = paramTextView.getTotalPaddingLeft();
          paramMotionEvent = ((ImageSpan)arrayOfObject[0]).getDrawable().getBounds();
          i1 = paramMotionEvent.width();
          if ((i < this.dhW) || (i > i1 + this.dhW)) {
            return false;
          }
          if ((j < k) || (j > m)) {
            return false;
          }
          i1 = m - paramMotionEvent.height() - paramTextView.getScrollY() + paramTextView.getTotalPaddingTop() + ayxa.getStatusBarHeight(BaseApplicationImpl.getContext());
          if ((this.aM != null) && (this.aM.get() != null) && (((wvd)this.aM.get()).isFullScreenMode()))
          {
            bool = true;
            if (bool) {
              break label732;
            }
            j = aqcx.a(BaseApplicationImpl.getApplication()).mHeight;
          }
        }
      }
    }
    for (int i = wja.dp2px(50.0F, BaseApplicationImpl.getApplication().getResources());; i = 0)
    {
      if (bool) {}
      for (paramTextView = new Rect(paramMotionEvent.left + n, paramMotionEvent.top + i1, paramMotionEvent.left + n + paramMotionEvent.width(), i1 + (paramMotionEvent.top + paramMotionEvent.height()));; paramTextView = new Rect(paramMotionEvent.left + n, j - paramMotionEvent.height() - i, paramMotionEvent.left + n + paramMotionEvent.width(), j - i))
      {
        if (QLog.isColorLevel()) {
          QLog.i("LinkMovementMethodExt", 2, "fullState:" + bool + ", top:" + k + ", bottom:" + m + ",padLeft:" + n + ", screenH:" + j + ", panelH:" + i + ", bounds:" + paramMotionEvent + ", rect:" + paramTextView);
        }
        if (paramSpannable.mActivity != null)
        {
          paramMotionEvent = new Intent(paramSpannable.mActivity, NewPhotoPreviewActivity.class);
          paramMotionEvent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", ((ImageSpan)arrayOfObject[0]).getSource());
          paramMotionEvent.putExtra("input_full_screen_click", true);
          paramMotionEvent.putExtra("PhotoConst.SHOW_ALBUM", false);
          paramMotionEvent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
          paramMotionEvent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
          paramMotionEvent.putExtra("showFlashPic", false);
          paramMotionEvent.putExtra("KEY_THUMBNAL_BOUND", paramTextView);
          paramMotionEvent.putExtra("enter_from", 1);
          paramMotionEvent.addFlags(603979776);
          paramSpannable.mActivity.startActivity(paramMotionEvent);
          paramSpannable.hideAllPanels();
        }
        this.cnx = false;
        return true;
        bool = false;
        break;
      }
      this.cnx = true;
      return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      label732:
      j = 0;
    }
  }
  
  public boolean shouldShow()
  {
    return this.cnx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcx
 * JD-Core Version:    0.7.0.1
 */