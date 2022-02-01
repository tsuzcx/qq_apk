import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class addq
  extends addc
{
  public ArCloudConfigInfo b;
  public String bsg;
  public String bsh;
  public String bsi;
  
  public addq(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    this.bsg = paramString2;
    this.bsh = paramString3;
    this.bsi = paramString4;
    this.b = paramArCloudConfigInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GeneralAR_3D_ResourceInfo{");
    localStringBuilder.append("key=").append(this.key).append('\'');
    localStringBuilder.append(", arType=").append(this.cCE);
    localStringBuilder.append(", trackMode=").append(this.cCF);
    localStringBuilder.append(", mLuaScriptPath=").append(this.bsg);
    localStringBuilder.append(", mResourceDirPath='").append(this.bsh).append('\'');
    localStringBuilder.append(", mMusicPath='").append(this.bsi).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addq
 * JD-Core Version:    0.7.0.1
 */