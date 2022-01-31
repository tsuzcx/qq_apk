import com.tencent.mobileqq.config.struct.PicAndAdConf;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class fmx
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public byte a;
  public long a;
  public String a;
  public short a;
  public boolean a;
  public byte[] a;
  public String b = null;
  public String c = null;
  public String d = null;
  public String e = "";
  
  public fmx(PicAndAdConf paramPicAndAdConf)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Byte = 3;
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.jdField_a_of_type_Long = paramDataInputStream.readLong();
    this.jdField_a_of_type_JavaLangString = paramDataInputStream.readUTF();
    this.b = paramDataInputStream.readUTF();
    this.d = paramDataInputStream.readUTF();
    this.jdField_a_of_type_Byte = paramDataInputStream.readByte();
    this.c = paramDataInputStream.readUTF();
    this.e = paramDataInputStream.readUTF();
    this.jdField_a_of_type_Short = paramDataInputStream.readShort();
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (this.b == null) {
      this.b = "";
    }
    if (this.d == null) {
      this.d = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    paramDataOutputStream.writeLong(this.jdField_a_of_type_Long);
    paramDataOutputStream.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramDataOutputStream.writeUTF(this.b);
    paramDataOutputStream.writeUTF(this.d);
    paramDataOutputStream.writeByte(this.jdField_a_of_type_Byte);
    paramDataOutputStream.writeUTF(this.c);
    paramDataOutputStream.writeUTF(this.e);
    paramDataOutputStream.writeShort(this.jdField_a_of_type_Short);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fmx
 * JD-Core Version:    0.7.0.1
 */