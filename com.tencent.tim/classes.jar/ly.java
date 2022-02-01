import java.nio.FloatBuffer;

public class ly
{
  private static final FloatBuffer a;
  public static float[] a;
  private static final FloatBuffer b = lz.createFloatBuffer(jdField_c_of_type_ArrayOfFloat);
  private static final float[] jdField_c_of_type_ArrayOfFloat;
  private FloatBuffer jdField_c_of_type_JavaNioFloatBuffer = jdField_a_of_type_JavaNioFloatBuffer;
  private FloatBuffer d = b;
  private int iZ = jdField_a_of_type_ArrayOfFloat.length / this.jA;
  private int jA = 2;
  private int jB = this.jA * 4;
  private int jC = 8;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_c_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    jdField_a_of_type_JavaNioFloatBuffer = lz.createFloatBuffer(jdField_a_of_type_ArrayOfFloat);
  }
  
  public FloatBuffer a()
  {
    return this.jdField_c_of_type_JavaNioFloatBuffer;
  }
  
  public FloatBuffer b()
  {
    return this.d;
  }
  
  public int be()
  {
    return this.jB;
  }
  
  public int bg()
  {
    return this.jC;
  }
  
  public int bh()
  {
    return this.jA;
  }
  
  public int getVertexCount()
  {
    return this.iZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ly
 * JD-Core Version:    0.7.0.1
 */