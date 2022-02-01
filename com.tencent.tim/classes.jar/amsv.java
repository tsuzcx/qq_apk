import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class amsv
  extends amtl
{
  private amsv.a a;
  private amrv jdField_b_of_type_Amrv;
  private amsf jdField_b_of_type_Amsf;
  private amss jdField_b_of_type_Amss;
  
  public amsv(aqdf paramaqdf)
  {
    super(paramaqdf);
    this.jdField_b_of_type_Amss = new amss(paramaqdf);
    this.jdField_b_of_type_Amsf = new amsf(paramaqdf);
    this.jdField_b_of_type_Amrv = new amrv(paramaqdf, 268435456);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    if ((!(paramampx instanceof ampt)) && (!(paramampx instanceof amow))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((paramampx instanceof ampt))
      {
        localObject = (ampt)paramampx;
        int i = amrf.jh(((ampt)localObject).IU());
        if (i == 2)
        {
          this.jdField_b_of_type_Amss.b(paramampx, paramamxy);
          return;
        }
        if (i == 1)
        {
          this.jdField_b_of_type_Amsf.b(paramampx, paramamxy);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((ampt)localObject).IU());
        return;
      }
    } while (!(paramampx instanceof amow));
    Object localObject = (amow)paramampx;
    if (amrf.jh(((amow)localObject).IU()) == 3)
    {
      this.jdField_b_of_type_Amrv.b(paramampx, paramamxy);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((amow)localObject).IU());
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    if (this.a != null)
    {
      if (paramamxy.getView() != null) {
        paramamxy.getView().setOnClickListener(new amsw(this));
      }
      return;
    }
    super.c(paramampx, paramamxy);
  }
  
  public static abstract interface a
  {
    public abstract void cR(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsv
 * JD-Core Version:    0.7.0.1
 */