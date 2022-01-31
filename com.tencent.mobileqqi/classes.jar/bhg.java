import com.tencent.av.config.ByteBuffer;
import com.tencent.av.config.ConfigProtocol;
import com.tencent.av.config.ConfigProtocol.TLVBase;

public class bhg
  extends ConfigProtocol.TLVBase
{
  private byte jdField_a_of_type_Byte;
  private short jdField_a_of_type_Short;
  private byte b;
  private byte c;
  private byte d;
  private byte e;
  private byte f;
  private byte g;
  private byte h;
  private byte i;
  private byte j;
  private byte k;
  private byte l;
  private byte m;
  private byte n;
  private byte o;
  private byte p;
  
  public bhg(ConfigProtocol paramConfigProtocol, short paramShort)
  {
    super(paramConfigProtocol, (short)8, (short)16);
    this.jdField_a_of_type_Short = paramShort;
    this.jdField_a_of_type_Byte = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.o = 0;
    this.p = 0;
  }
  
  public byte a()
  {
    return this.jdField_a_of_type_Byte;
  }
  
  public boolean a(ByteBuffer paramByteBuffer)
  {
    if ((this.jdField_a_of_type_Short != c()) || (paramByteBuffer.b() < this.jdField_a_of_type_Short)) {
      return false;
    }
    this.jdField_a_of_type_Byte = paramByteBuffer.a();
    this.b = paramByteBuffer.a();
    this.c = paramByteBuffer.a();
    this.d = paramByteBuffer.a();
    this.e = paramByteBuffer.a();
    this.f = paramByteBuffer.a();
    this.g = paramByteBuffer.a();
    this.h = paramByteBuffer.a();
    this.i = paramByteBuffer.a();
    this.j = paramByteBuffer.a();
    this.k = paramByteBuffer.a();
    this.l = paramByteBuffer.a();
    this.m = paramByteBuffer.a();
    this.n = paramByteBuffer.a();
    this.o = paramByteBuffer.a();
    this.p = paramByteBuffer.a();
    return true;
  }
  
  public byte[] a()
  {
    return null;
  }
  
  public byte b()
  {
    return this.b;
  }
  
  public byte c()
  {
    return this.c;
  }
  
  public byte d()
  {
    return this.d;
  }
  
  public byte e()
  {
    return this.e;
  }
  
  public byte f()
  {
    return this.f;
  }
  
  public byte g()
  {
    return this.g;
  }
  
  public byte h()
  {
    return this.h;
  }
  
  public byte i()
  {
    return this.i;
  }
  
  public byte j()
  {
    return this.j;
  }
  
  public byte k()
  {
    return this.k;
  }
  
  public byte l()
  {
    return this.l;
  }
  
  public byte m()
  {
    return this.m;
  }
  
  public byte n()
  {
    return this.n;
  }
  
  public byte o()
  {
    return this.o;
  }
  
  public byte p()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhg
 * JD-Core Version:    0.7.0.1
 */