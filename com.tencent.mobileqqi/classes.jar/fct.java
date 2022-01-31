import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.utils.Base64Util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class fct
{
  public int a;
  public long a;
  public int b;
  public long b;
  public int c;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  
  public fct(GuardManager paramGuardManager) {}
  
  public void a()
  {
    try
    {
      Object localObject = BaseApplicationImpl.a().getSharedPreferences("MemoryInfomation", 0).getString("MemoryInfomation", null);
      if (localObject != null)
      {
        if (((String)localObject).length() == 0) {
          return;
        }
        localObject = new DataInputStream(new ByteArrayInputStream(Base64Util.a((String)localObject, 0)));
        this.jdField_a_of_type_Long = ((DataInputStream)localObject).readLong();
        this.jdField_a_of_type_Int = ((DataInputStream)localObject).readInt();
        this.jdField_b_of_type_Long = ((DataInputStream)localObject).readLong();
        this.jdField_c_of_type_Long = ((DataInputStream)localObject).readLong();
        this.d = ((DataInputStream)localObject).readLong();
        this.e = ((DataInputStream)localObject).readLong();
        this.f = ((DataInputStream)localObject).readLong();
        this.g = ((DataInputStream)localObject).readLong();
        this.h = ((DataInputStream)localObject).readLong();
        this.jdField_b_of_type_Int = ((DataInputStream)localObject).readInt();
        this.jdField_c_of_type_Int = ((DataInputStream)localObject).readInt();
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public void c()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(this.jdField_a_of_type_Long);
      localDataOutputStream.writeInt(this.jdField_a_of_type_Int);
      localDataOutputStream.writeLong(this.jdField_b_of_type_Long);
      localDataOutputStream.writeLong(this.jdField_c_of_type_Long);
      localDataOutputStream.writeLong(this.d);
      localDataOutputStream.writeLong(this.e);
      localDataOutputStream.writeLong(this.f);
      localDataOutputStream.writeLong(this.g);
      localDataOutputStream.writeLong(this.h);
      localDataOutputStream.writeInt(this.jdField_b_of_type_Int);
      localDataOutputStream.writeInt(this.jdField_c_of_type_Int);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      BaseApplicationImpl.a().getSharedPreferences("MemoryInfomation", 0).edit().putString("MemoryInfomation", Base64Util.a((byte[])localObject, 0)).commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fct
 * JD-Core Version:    0.7.0.1
 */