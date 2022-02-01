import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.a;

public class addv
  extends addc
{
  public adkf a;
  public ArCloudConfigInfo.a a;
  public int cDO;
  public int cra = 1;
  public String mVideoPath;
  
  public addv(String paramString1, int paramInt1, int paramInt2, int paramInt3, adkf paramadkf, ArCloudConfigInfo.a parama, String paramString2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt5, paramFloat1, paramFloat2, paramFloat3);
    this.cDO = paramInt3;
    this.mVideoPath = paramString2;
    this.cra = paramInt4;
    this.jdField_a_of_type_Adkf = paramadkf;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a = parama;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NormalVideoARResourceInfo{");
    localStringBuilder.append("key=").append(this.key).append('\'');
    localStringBuilder.append(", arType=").append(this.cCE);
    localStringBuilder.append(", trackMode=").append(this.cCF);
    localStringBuilder.append(", mRealRenderType=").append(this.cDO);
    localStringBuilder.append(", mKeyingParams='").append(this.jdField_a_of_type_Adkf).append('\'');
    localStringBuilder.append(", mVideoPath='").append(this.mVideoPath).append('\'');
    localStringBuilder.append(", mLayout='").append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addv
 * JD-Core Version:    0.7.0.1
 */