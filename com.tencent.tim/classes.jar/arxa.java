import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.open.base.ToastUtil.1;
import com.tencent.open.base.ToastUtil.2;
import com.tencent.open.base.ToastUtil.3;

public class arxa
{
  protected static arxa a;
  public Toast f;
  public Toast g;
  protected Handler handler = new Handler(Looper.getMainLooper());
  
  public static arxa a()
  {
    if (a == null) {
      a = new arxa();
    }
    return a;
  }
  
  public void az(View paramView, int paramInt)
  {
    this.handler.post(new ToastUtil.3(this, paramView, paramInt));
  }
  
  public void ba(int paramInt1, int paramInt2)
  {
    this.handler.post(new ToastUtil.2(this, paramInt1, paramInt2));
  }
  
  public void showToast(int paramInt)
  {
    ba(paramInt, 0);
  }
  
  public void showToast(String paramString)
  {
    showToast(paramString, 0);
  }
  
  public void showToast(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.handler.post(new ToastUtil.1(this, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxa
 * JD-Core Version:    0.7.0.1
 */