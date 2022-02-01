public class akxm
  extends akxn
  implements akxw
{
  public akxl a = new akxl();
  public akxy b;
  public boolean bjd = true;
  public boolean cuW;
  public int dpD = -1;
  
  public akxm()
  {
    this.jdField_b_of_type_Akxy = new akxy();
  }
  
  public boolean check()
  {
    if (this.jdField_b_of_type_Akxy == null)
    {
      gT("PicFowardInfo.check", "upInfo == null");
      return false;
    }
    if (((this.jdField_b_of_type_Akxy.uinType == 1000) || (this.jdField_b_of_type_Akxy.uinType == 1020) || (this.jdField_b_of_type_Akxy.uinType == 1004)) && (this.jdField_b_of_type_Akxy.bUG == null))
    {
      gT("PicFowardInfo.check", "secondId invalid,uinType:" + this.jdField_b_of_type_Akxy.uinType + ",secondId:" + this.jdField_b_of_type_Akxy.bUG);
      return false;
    }
    if (this.jdField_b_of_type_Akxy.protocolType == -1)
    {
      gT("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.jdField_b_of_type_Akxy.protocolType);
      return false;
    }
    if (!aqhq.fileExistsAndNotEmpty(this.jdField_b_of_type_Akxy.localPath))
    {
      if (this.a == null)
      {
        gT("PicFowardInfo.check", "downInfo == null");
        return false;
      }
      if (!this.a.check())
      {
        this.jdField_b_of_type_Akxn$a = this.a.jdField_b_of_type_Akxn$a;
        return false;
      }
    }
    return true;
  }
  
  public akxl getPicDownloadInfo()
  {
    return this.a;
  }
  
  public akxy getPicUploadInfo()
  {
    return this.jdField_b_of_type_Akxy;
  }
  
  public boolean isSendFromLocal()
  {
    return this.bjd;
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicFowardInfo");
    if (this.jdField_b_of_type_Akxy != null) {}
    for (String str = this.jdField_b_of_type_Akxy.toLogString();; str = "\n |-upInfo=null")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(this.a);
      return localStringBuilder.toString();
    }
  }
  
  public String toString()
  {
    return toLogString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxm
 * JD-Core Version:    0.7.0.1
 */