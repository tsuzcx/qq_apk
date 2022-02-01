import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class addr
  extends addc
{
  public ArCloudConfigInfo b;
  
  public addr(String paramString, int paramInt1, int paramInt2, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.b = paramArCloudConfigInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MultiFragmentAnimARResourceInfo{");
    localStringBuilder.append("key=").append(this.key).append('\'');
    localStringBuilder.append(", arType=").append(this.cCE);
    localStringBuilder.append(", trackMode=").append(this.cCF);
    localStringBuilder.append(", arResourceInfo=").append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addr
 * JD-Core Version:    0.7.0.1
 */