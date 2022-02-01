import android.support.annotation.NonNull;

public class ayhn
  extends aygy
  implements axtm.a
{
  private axtm a;
  
  public ayhn(@NonNull aygz paramaygz)
  {
    super(paramaygz);
    this.jdField_a_of_type_Axtm = new axtm();
    this.jdField_a_of_type_Axtm.a(this);
    this.jdField_a_of_type_Axtm.a().setEditVideoParams(this.b.a);
  }
  
  protected boolean Lj()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Axtm.aPI())
    {
      this.b.changeState(0);
      bool = true;
    }
    return bool;
  }
  
  public void aNX()
  {
    aygz localaygz = this.b;
    if (this.b.La()) {}
    for (String str = "2";; str = "1")
    {
      localaygz.c("change_poi", 0, 0, new String[] { str });
      ras.so("0X80076D0");
      ras.sp("0X80075E5");
      Lj();
      return;
    }
  }
  
  public void eNC()
  {
    Lj();
  }
  
  public void eND()
  {
    this.b.r(4, this.jdField_a_of_type_Axtm.a().a());
  }
  
  public boolean onBackPressed()
  {
    return Lj();
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_Axtm.bm(this.jdField_a_of_type_Ayii.getRootView());
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    this.jdField_a_of_type_Axtm.a().btm();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Axtm.onHide();
    }
    do
    {
      return;
      this.jdField_a_of_type_Axtm.bsQ();
      this.jdField_a_of_type_Axtm.a().d(true, this.jdField_a_of_type_Ayii.getActivity());
    } while (!(paramObject instanceof ayfw.e));
    paramObject = (ayfw.e)paramObject;
    this.jdField_a_of_type_Axtm.a().a(paramObject.c, paramObject.location);
    this.jdField_a_of_type_Axtm.notifyDataChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhn
 * JD-Core Version:    0.7.0.1
 */