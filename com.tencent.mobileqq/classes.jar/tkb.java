import UserGrowth.stBlockRecommPersonReq;
import UserGrowth.stBlockRecommPersonRsp;

public class tkb
  extends thb<stBlockRecommPersonRsp>
{
  public tkb(String paramString)
  {
    super("BlockRecommPerson");
    this.a = new stBlockRecommPersonReq(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tkb
 * JD-Core Version:    0.7.0.1
 */