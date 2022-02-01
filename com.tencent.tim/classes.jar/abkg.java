public class abkg
{
  public float bU;
  public float scale;
  public float xPos;
  
  public abkg(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.scale = paramFloat1;
    this.xPos = paramFloat2;
    this.bU = paramFloat3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloRoleInfo:").append("scale:").append(this.scale).append(",xPos:").append(this.xPos).append(",yPos:").append(this.bU);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkg
 * JD-Core Version:    0.7.0.1
 */