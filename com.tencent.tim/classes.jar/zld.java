import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class zld
  implements AbsListView.e
{
  int cdH = 0;
  int cdI = 0;
  int firstVisibleItem = 0;
  
  zld(zky paramzky) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.firstVisibleItem = paramInt1;
    this.cdH = (paramInt1 + paramInt2);
    this.cdI = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onScrollStateChanged, reach bottom, scrollState " + paramInt + " firstVisibleItem: " + this.firstVisibleItem + ", lastItem:" + this.cdH + ", totalItemCount = " + this.cdI + ", mIsComplete: " + this.b.Hf + ", requesting:" + this.b.gV + ", mSearchMode: " + this.b.cdG + ", mCurrentKeyword: " + this.b.ban);
    }
    if (this.cdI == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.cdH != this.cdI) || (paramInt != 0));
      if ((this.firstVisibleItem != 0) && (!this.b.gV))
      {
        this.b.gV = true;
        if (this.b.cdG == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("LinkMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: " + this.b.Hf);
          }
          this.b.a.j(this.b.Lj, this.b.ban, 2);
          this.b.MS.setText(this.b.mContext.getString(2131719291));
          this.b.footerView.setVisibility(0);
          this.b.hI.findViewById(2131373660).setVisibility(0);
          this.b.hI.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("LinkMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: " + this.b.Hf);
        }
        if (this.b.Hf)
        {
          this.b.MS.setText(acfp.m(2131703326));
          this.b.hI.findViewById(2131373660).setVisibility(8);
          this.b.hI.setVisibility(0);
          this.b.footerView.setVisibility(0);
          return;
        }
        this.b.MS.setText(this.b.mContext.getString(2131719290));
        this.b.footerView.setVisibility(0);
        this.b.hI.findViewById(2131373660).setVisibility(0);
        this.b.hI.setVisibility(0);
        this.b.Lj = System.currentTimeMillis();
        return;
      }
    } while ((this.firstVisibleItem != 0) || (this.b.gV) || (!this.b.Hf) || (this.b.cdG != 1));
    this.b.MS.setText(acfp.m(2131703327));
    this.b.hI.findViewById(2131373660).setVisibility(8);
    this.b.hI.setVisibility(0);
    this.b.footerView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zld
 * JD-Core Version:    0.7.0.1
 */