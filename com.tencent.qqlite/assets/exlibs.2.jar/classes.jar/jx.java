import com.tencent.biz.PoiMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class jx
  implements AbsListView.OnScrollListener
{
  public jx(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.r() == paramAbsListView.b() - 1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "onScrollStateChanged");
      }
      if ((!this.a.jdField_e_of_type_Boolean) && (this.a.jdField_c_of_type_Boolean))
      {
        this.a.jdField_e_of_type_Boolean = true;
        paramAbsListView = this.a;
        paramAbsListView.h += 1;
        if (QLog.isDevelopLevel()) {
          QLog.i("PoiMapActivity", 4, "onScrollStateChanged mSearchPage:" + this.a.h);
        }
        this.a.a(this.a.d, this.a.jdField_e_of_type_Int, this.a.jdField_c_of_type_JavaLangString, "", this.a.h, 20);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     jx
 * JD-Core Version:    0.7.0.1
 */