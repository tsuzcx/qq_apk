import android.support.annotation.NonNull;

public class ayhp
  extends aygy
  implements axti.a
{
  private axti b;
  
  public ayhp(@NonNull aygz paramaygz)
  {
    super(paramaygz);
    this.jdField_b_of_type_Axti = new axti();
    this.jdField_b_of_type_Axti.a(this);
    this.jdField_b_of_type_Axti.setEditVideoParams(this.jdField_b_of_type_Aygz.a);
  }
  
  public void aNX()
  {
    this.jdField_b_of_type_Aygz.changeState(0);
  }
  
  public boolean onBackPressed()
  {
    boolean bool = this.jdField_b_of_type_Axti.Lk();
    if (bool)
    {
      this.jdField_b_of_type_Aygz.changeState(0);
      this.jdField_b_of_type_Aygz.r(3, this.jdField_b_of_type_Axti.a());
    }
    return bool;
  }
  
  public void onCreate()
  {
    this.jdField_b_of_type_Axti.bm(this.a.getRootView());
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_Axti.onDestroy();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_b_of_type_Axti.dismiss();
      return;
    }
    if ((paramObject instanceof ayho)) {
      this.jdField_b_of_type_Axti.a((ayho)paramObject);
    }
    this.jdField_b_of_type_Axti.bsQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhp
 * JD-Core Version:    0.7.0.1
 */