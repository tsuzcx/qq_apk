import com.tencent.qphone.base.util.QLog;

public class aiyl
{
  private aiyb jdField_a_of_type_Aiyb;
  private aiyc jdField_a_of_type_Aiyc;
  private aiyf jdField_a_of_type_Aiyf;
  private aiym jdField_a_of_type_Aiym;
  private aiyc.b b;
  
  public void a(aiye paramaiye)
  {
    if ((this.jdField_a_of_type_Aiyb != null) && (paramaiye.bQb.equalsIgnoreCase(this.jdField_a_of_type_Aiyb.bQb))) {}
    for (;;)
    {
      this.jdField_a_of_type_Aiyc.a(this.jdField_a_of_type_Aiyb);
      this.jdField_a_of_type_Aiyc.startDecoder();
      return;
      this.jdField_a_of_type_Aiyb = this.jdField_a_of_type_Aiyf.a(paramaiye.bQb, paramaiye.bQc);
      this.jdField_a_of_type_Aiyb.bQb = paramaiye.bQb;
      this.jdField_a_of_type_Aiyb.bQc = paramaiye.bQc;
    }
  }
  
  public void a(aiyf paramaiyf)
  {
    this.jdField_a_of_type_Aiyf = paramaiyf;
  }
  
  public void a(aiym paramaiym)
  {
    this.jdField_a_of_type_Aiym = paramaiym;
  }
  
  public void ag(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Aiym != null) {
      this.jdField_a_of_type_Aiym.h(this.jdField_a_of_type_Aiyf.lI(paramString), paramInt, 3);
    }
  }
  
  public void anm()
  {
    if (this.jdField_a_of_type_Aiyc != null) {
      this.jdField_a_of_type_Aiyc.ank();
    }
  }
  
  public void b(aiyc.a parama)
  {
    if (this.jdField_a_of_type_Aiyc != null) {
      this.jdField_a_of_type_Aiyc.a(parama);
    }
  }
  
  public void b(aiyc.b paramb)
  {
    this.b = paramb;
  }
  
  public void iX(String paramString)
  {
    if (this.jdField_a_of_type_Aiym != null) {
      this.jdField_a_of_type_Aiym.LK(this.jdField_a_of_type_Aiyf.lI(paramString));
    }
  }
  
  public void init()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Aiyc);
    }
    if (this.jdField_a_of_type_Aiyc == null)
    {
      boolean bool = aqgz.aCF();
      long l = Math.min(aqgz.hI(), aqgz.hJ());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Aiyc = new aixz();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aiyc.a(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(aiyf.getVideoPath()))
      {
        this.jdField_a_of_type_Aiyc = new aiyg();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Aiyc = new aiyd();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_Aiyc != null) {
      this.jdField_a_of_type_Aiyc.release();
    }
  }
  
  public void setFps(int paramInt)
  {
    if (this.jdField_a_of_type_Aiyc != null) {
      this.jdField_a_of_type_Aiyc.setFps(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyl
 * JD-Core Version:    0.7.0.1
 */