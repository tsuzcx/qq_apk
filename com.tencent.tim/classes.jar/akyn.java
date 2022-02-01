import com.tencent.mobileqq.pic.CompressInfo;

public class akyn
  extends akyp
{
  akyn(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int Hm()
  {
    return 80;
  }
  
  protected final int[] W()
  {
    if (this.b.picQuality == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 2560;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    akxe.a("PicTypeNormal", "getScaleLargerSide", "PicType.SendPhotoMaxLongSide = " + arrayOfInt[0]);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyn
 * JD-Core Version:    0.7.0.1
 */