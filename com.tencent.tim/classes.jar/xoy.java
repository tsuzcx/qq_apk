import android.app.Activity;
import android.view.View;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.b;
import com.tencent.qphone.base.util.QLog;

class xoy
  implements AnimationTextView.b
{
  xoy(xov paramxov, boolean paramBoolean) {}
  
  public void fk(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextItemBuilder", 2, "SingleTap invoked!");
    }
    Object localObject = (AnimationTextView)paramView;
    float f1 = ((AnimationTextView)localObject).touchL - xov.bTu;
    float f2 = ((AnimationTextView)localObject).touchT;
    float f3 = xov.bTs;
    if (this.awo) {
      f1 = ((AnimationTextView)localObject).touchL - xov.bTv;
    }
    localObject = ((AnimationTextView)localObject).getText();
    int k;
    boolean bool2;
    int j;
    boolean bool1;
    if ((localObject instanceof aofk))
    {
      localObject = (aofk)localObject;
      localObject = (aofk.a[])((aofk)localObject).getSpans(0, ((aofk)localObject).length(), aofk.a.class);
      if (!(paramView instanceof ETTextView)) {
        break label325;
      }
      paramView = (ETTextView)paramView;
      k = paramView.mClickEpId;
      int m = paramView.mClickcEId;
      if ((paramView.mFont == null) || (paramView.mFont.mFontId == 0) || (paramView.mFont.mFontType != 1)) {
        break label307;
      }
      bool2 = true;
      i = k;
      j = m;
      bool1 = bool2;
      if (bool2)
      {
        i = k;
        j = m;
        bool1 = bool2;
        if (paramView.getETLayout() != null)
        {
          paramView = paramView.getETLayout();
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "isHanYiFont, onlyEmoji: " + paramView.cr);
          }
          if (paramView.cr) {
            break label313;
          }
          bool1 = true;
          label241:
          j = m;
        }
      }
    }
    for (int i = k;; i = -1)
    {
      if ((i != -1) && (j != -1)) {}
      for (bool2 = true;; bool2 = false)
      {
        afnu.a((aofk.a[])localObject, f1, f2 - f3, bool2, i, j, this.this$0.app, this.this$0.sessionInfo, (Activity)this.this$0.mContext, bool1);
        return;
        label307:
        bool2 = false;
        break;
        label313:
        bool1 = false;
        break label241;
      }
      label325:
      bool1 = false;
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xoy
 * JD-Core Version:    0.7.0.1
 */