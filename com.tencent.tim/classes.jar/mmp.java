import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;

public class mmp
  implements mmh.b
{
  private mmh.c jdField_a_of_type_Mmh$c;
  private mmo jdField_a_of_type_Mmo;
  private mnp jdField_a_of_type_Mnp;
  
  public mmp(mmo parammmo)
  {
    this.jdField_a_of_type_Mmo = parammmo;
    this.jdField_a_of_type_Mnp = new mnp(this.jdField_a_of_type_Mmo);
  }
  
  public void a(UgcVideo paramUgcVideo)
  {
    if (this.jdField_a_of_type_Mmh$c != null) {
      this.jdField_a_of_type_Mmh$c.aQe();
    }
    this.jdField_a_of_type_Mmo.a(paramUgcVideo, null);
  }
  
  public void a(mmh.c paramc)
  {
    this.jdField_a_of_type_Mnp.a(paramc);
    this.jdField_a_of_type_Mmh$c = paramc;
  }
  
  public void aMF()
  {
    this.jdField_a_of_type_Mnp.aMF();
  }
  
  public void aMG()
  {
    this.jdField_a_of_type_Mnp.aMG();
  }
  
  public void detachView()
  {
    this.jdField_a_of_type_Mnp.detachView();
    this.jdField_a_of_type_Mmh$c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmp
 * JD-Core Version:    0.7.0.1
 */