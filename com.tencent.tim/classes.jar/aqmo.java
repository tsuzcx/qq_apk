import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class aqmo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aqmo(aqmn paramaqmn) {}
  
  public void onGlobalLayout()
  {
    if (!aqmn.a(this.b)) {}
    for (;;)
    {
      return;
      Object localObject = new Rect();
      aqmn.a(this.b).getWindowVisibleDisplayFrame((Rect)localObject);
      int j = aqmn.a(this.b) - ((Rect)localObject).height();
      aqmn.a(this.b, ((Rect)localObject).height());
      if (j > aqmn.b(this.b) / 3) {}
      for (int i = 1; i != 0; i = 0)
      {
        aqmn.a(this.b, false);
        if (QLog.isColorLevel()) {
          QLog.d("SoftKeyboardHeight", 2, new Object[] { "onGlobalLayout, keyboard height:", Integer.valueOf(j) });
        }
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_soft_keyboard", 0);
        if (((SharedPreferences)localObject).getInt("key_height", 0) != j) {
          ((SharedPreferences)localObject).edit().putInt("key_height", j).commit();
        }
        if (aqmn.a(this.b) != null) {
          aqmn.a(this.b).aX(j, false);
        }
        this.b.destroy();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmo
 * JD-Core Version:    0.7.0.1
 */