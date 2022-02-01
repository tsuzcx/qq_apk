public class adkf
{
  public String fragmentShader;
  public int keyType = 0;
  public float uV = 0.0F;
  public float uW = 0.0F;
  public float uX = 0.0F;
  public float uY = 0.0F;
  public float uZ = 0.0F;
  public float va = 1.0F;
  public float vb = 0.0F;
  public float vc = 1.0F;
  public float vd = 0.0F;
  
  public adkf() {}
  
  public adkf(int paramInt)
  {
    this.keyType = paramInt;
  }
  
  public void i(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.uV = paramFloat1;
    this.uW = paramFloat2;
    this.uX = paramFloat3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyingParams {keyType: ").append(this.keyType).append(", screenColorR: ").append(this.uV).append(", screenColorG: ").append(this.uW).append(", screenColorB: ").append(this.uX).append(", uA: ").append(this.uY).append(", uD: ").append(this.uZ).append(", u_threshold: ").append(this.va).append(", u_clipBlack: ").append(this.vb).append(", u_clipWhite: ").append(this.vc).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkf
 * JD-Core Version:    0.7.0.1
 */