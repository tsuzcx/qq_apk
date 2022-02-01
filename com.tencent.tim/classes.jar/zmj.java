import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;

class zmj
  implements AbsListView.e
{
  int cdH = 0;
  int cdI = 0;
  
  zmj(zme paramzme) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.cdH = (paramInt1 + paramInt2);
    this.cdI = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.b.F.getAdapter() == this.b.a) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(zme.TAG, 2, "onScrollStateChanged, scrollState = " + paramInt + ", lastItem = " + this.cdH + ", totalItemCount = " + this.cdI);
      }
    } while ((this.cdI == 0) || (this.cdH != this.cdI) || (paramInt != 0));
    if (QLog.isColorLevel()) {
      QLog.i(zme.TAG, 2, "onScrollStateChanged, reach bottom, lastItem = " + this.cdH + ", totalItemCount = " + this.cdI);
    }
    zme.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmj
 * JD-Core Version:    0.7.0.1
 */