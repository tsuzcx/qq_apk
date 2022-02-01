import com.tencent.qphone.base.util.QLog;

class ikc
  implements ijy.a
{
  ikc(ikb paramikb) {}
  
  public void c(long paramLong, String paramString, boolean paramBoolean)
  {
    igd.aJ("AVMagicfacePlayer", "play audio begin. id = " + paramString + ", repeat = " + paramBoolean);
    if (paramBoolean)
    {
      this.b.ag(this.b.audioPath, 100);
      return;
    }
    this.b.ag(this.b.audioPath, 1);
  }
  
  public void f(long paramLong, String arg3, int paramInt)
  {
    QLog.w("AVMagicfacePlayer", 1, "onEndMagicPlay, id[" + ??? + "], reason[" + paramInt + "], seq[" + paramLong + "]");
    if (this.b.jdField_b_of_type_Ijy$a != null) {
      this.b.jdField_b_of_type_Ijy$a.f(paramLong, ???, paramInt);
    }
    synchronized (this.b)
    {
      if ((this.b.Nu != null) && (this.b.jdField_b_of_type_Ijz != null)) {
        this.b.a(paramLong, this.b.Nu, this.b.jdField_b_of_type_Ijz, this.b.jdField_b_of_type_Ijy$b, this.b.a);
      }
      return;
    }
  }
  
  public void m(long paramLong, String paramString)
  {
    igd.aJ("AVMagicfacePlayer", "play video begin." + paramString);
    if (this.b.jdField_b_of_type_Ijy$a != null) {
      this.b.jdField_b_of_type_Ijy$a.m(paramLong, paramString);
    }
  }
  
  public void n(long paramLong, String paramString)
  {
    igd.aJ("AVMagicfacePlayer", "play audio end. id = " + paramString);
    this.b.iX(this.b.audioPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikc
 * JD-Core Version:    0.7.0.1
 */