import com.tencent.biz.PoiMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class bgl
  implements AbsListView.OnScrollListener
{
  public bgl(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.r() == paramAbsListView.a() - 1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "onScrollStateChanged");
      }
      if ((!this.a.f) && (this.a.jdField_d_of_type_Boolean))
      {
        this.a.f = true;
        paramAbsListView = this.a;
        paramAbsListView.i += 1;
        if (QLog.isDevelopLevel()) {
          QLog.i("PoiMapActivity", 4, "onScrollStateChanged mSearchPage:" + this.a.i);
        }
        this.a.a(this.a.jdField_d_of_type_Int, this.a.e, this.a.c, "", this.a.i, 20);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgl
 * JD-Core Version:    0.7.0.1
 */