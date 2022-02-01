import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ikb
{
  String Nu;
  private aiym jdField_a_of_type_Aiym;
  ijy.a jdField_a_of_type_Ijy$a;
  private ijy jdField_a_of_type_Ijy;
  String audioPath;
  ijy.a jdField_b_of_type_Ijy$a;
  ijy.b jdField_b_of_type_Ijy$b;
  ijz jdField_b_of_type_Ijz;
  ijy.a c = new ikc(this);
  
  public ikb()
  {
    anl();
  }
  
  public void a(long paramLong, String paramString, ijz paramijz, ijy.b paramb, ijy.a parama)
  {
    if (this.jdField_a_of_type_Ijy.RS) {
      try
      {
        this.Nu = paramString;
        this.jdField_b_of_type_Ijz = paramijz;
        this.jdField_b_of_type_Ijy$b = paramb;
        this.jdField_a_of_type_Ijy$a = parama;
        this.jdField_a_of_type_Ijy.ank();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.audioPath = (paramString + "audio" + File.separator + paramijz.a.src);
      this.jdField_b_of_type_Ijy$a = parama;
      this.Nu = null;
      this.jdField_b_of_type_Ijz = null;
      this.jdField_b_of_type_Ijy$b = null;
      this.jdField_a_of_type_Ijy$a = null;
      if ((paramijz.a.src != null) && (!paramijz.a.src.equals("")) && (this.jdField_a_of_type_Aiym == null)) {
        this.jdField_a_of_type_Aiym = new aiym();
      }
      this.jdField_a_of_type_Ijy.setVideoPath(paramString);
      this.jdField_a_of_type_Ijy.a(paramijz);
      this.jdField_a_of_type_Ijy.a(paramb);
      this.jdField_a_of_type_Ijy.a(this.c);
      this.jdField_a_of_type_Ijy.startDecoder();
      return;
    }
    finally {}
  }
  
  public void ag(String paramString, int paramInt)
  {
    igd.aJ("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_Aiym != null) {
      this.jdField_a_of_type_Aiym.h(paramString, paramInt, 0);
    }
  }
  
  public void anl()
  {
    if (this.jdField_a_of_type_Ijy == null)
    {
      if (aqgz.aCF())
      {
        this.jdField_a_of_type_Ijy = new ika();
        igd.aL("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ijy = new ika();
    igd.aL("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void anm()
  {
    try
    {
      this.Nu = null;
      this.jdField_b_of_type_Ijz = null;
      this.jdField_b_of_type_Ijy$b = null;
      this.jdField_a_of_type_Ijy$a = null;
      this.jdField_a_of_type_Ijy.ank();
      return;
    }
    finally {}
  }
  
  public void iX(String paramString)
  {
    if (this.jdField_a_of_type_Aiym != null) {
      this.jdField_a_of_type_Aiym.LK(paramString);
    }
  }
  
  public boolean isPlaying()
  {
    return this.jdField_a_of_type_Ijy.RS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikb
 * JD-Core Version:    0.7.0.1
 */