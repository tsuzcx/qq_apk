import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class jva
  extends acfd
{
  jva(juk paramjuk) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (this.b.aI == null) {}
    label134:
    for (;;)
    {
      return;
      int j = this.b.aI.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label134;
        }
        View localView = this.b.aI.getChildAt(i);
        if (((localView.getTag() instanceof String)) && ((localView instanceof ImageView)) && (((String)localView.getTag()).equals(paramString)))
        {
          ((ImageView)localView).setImageDrawable(this.b.app.l(paramString));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "onUpdateTroopHead:" + paramString);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jva
 * JD-Core Version:    0.7.0.1
 */