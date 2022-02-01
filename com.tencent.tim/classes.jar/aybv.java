public class aybv
{
  public int EP = 2;
  private aybw jdField_a_of_type_Aybw;
  private ayby jdField_a_of_type_Ayby;
  private int bjK;
  public int ciS = 10000;
  public int mEntranceType = 100;
  
  public aybv(int paramInt1, int paramInt2, int paramInt3)
  {
    this.ciS = paramInt1;
    this.mEntranceType = paramInt2;
    this.EP = paramInt3;
  }
  
  public int RI()
  {
    return this.ciS;
  }
  
  public aybw a()
  {
    return this.jdField_a_of_type_Aybw;
  }
  
  public ayby a()
  {
    return this.jdField_a_of_type_Ayby;
  }
  
  public void a(aybw paramaybw)
  {
    this.jdField_a_of_type_Aybw = paramaybw;
    if (paramaybw.a() != null) {
      this.mEntranceType = paramaybw.RJ();
    }
  }
  
  public void a(ayby paramayby)
  {
    this.jdField_a_of_type_Ayby = paramayby;
  }
  
  public void aeY(int paramInt)
  {
    this.bjK = paramInt;
  }
  
  public int th()
  {
    return this.mEntranceType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybv
 * JD-Core Version:    0.7.0.1
 */