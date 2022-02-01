import com.tencent.mobileqq.pic.CompressInfo;

public class akyq
  extends akyp
{
  akyq(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int Hm()
  {
    int i = 85;
    if (this.b.picQuality == 2)
    {
      i = 100;
      return i;
    }
    switch (this.b.networkType)
    {
    case 4: 
    case 2: 
    case 3: 
    default: 
      return 85;
    }
    return 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyq
 * JD-Core Version:    0.7.0.1
 */