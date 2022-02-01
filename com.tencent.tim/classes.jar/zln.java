import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class zln
  implements AbsListView.e
{
  int cdH = 0;
  int cdI = 0;
  int firstVisibleItem = 0;
  
  zln(zli paramzli) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.firstVisibleItem = paramInt1;
    this.cdH = (paramInt1 + paramInt2);
    this.cdI = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged, reach bottom, scrollState " + paramInt + " firstVisibleItem: " + this.firstVisibleItem + ", lastItem:" + this.cdH + ", totalItemCount = " + this.cdI + ", mIsComplete: " + this.c.Hf + ", requesting:" + this.c.gV + ", mSearchMode: " + this.c.cdG + ", mCurrentKeyword: " + this.c.ban);
    }
    if (this.cdI == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.cdH != this.cdI) || (paramInt != 0));
      if ((this.firstVisibleItem != 0) && (!this.c.gV))
      {
        this.c.gV = true;
        if (this.c.cdG == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: " + this.c.Hf);
          }
          this.c.a.j(this.c.Lj, this.c.ban, 2);
          this.c.MS.setText(this.c.mContext.getString(2131719291));
          this.c.footerView.setVisibility(0);
          this.c.hI.findViewById(2131373660).setVisibility(0);
          this.c.hI.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: " + this.c.Hf);
        }
        if (this.c.Hf)
        {
          this.c.MS.setText(acfp.m(2131703334));
          this.c.hI.findViewById(2131373660).setVisibility(8);
          this.c.hI.setVisibility(0);
          this.c.footerView.setVisibility(0);
          return;
        }
        this.c.MS.setText(this.c.mContext.getString(2131719290));
        this.c.footerView.setVisibility(0);
        this.c.hI.findViewById(2131373660).setVisibility(0);
        this.c.hI.setVisibility(0);
        this.c.Lj = System.currentTimeMillis();
        this.c.Fp(2);
        VipUtils.a(this.c.app, "chat_history", "ChatSearch", "Slip_resultup", 0, 0, new String[0]);
        return;
      }
    } while ((this.firstVisibleItem != 0) || (this.c.gV) || (!this.c.Hf) || (this.c.cdG != 1));
    this.c.MS.setText(acfp.m(2131703339));
    this.c.hI.findViewById(2131373660).setVisibility(8);
    this.c.hI.setVisibility(0);
    this.c.footerView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zln
 * JD-Core Version:    0.7.0.1
 */