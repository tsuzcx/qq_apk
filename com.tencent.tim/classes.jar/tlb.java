import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class tlb
{
  private static tlb.a a(int paramInt)
  {
    tlh localtlh = null;
    if ((paramInt == 0) || (1 == paramInt) || (2 == paramInt) || (3 == paramInt)) {
      localtlh = new tlh();
    }
    return localtlh;
  }
  
  public static void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 3)) {}
    tlb.a locala;
    do
    {
      do
      {
        return;
      } while ((paramInt2 < 0) || (paramInt2 >= 4));
      locala = a(paramInt2);
    } while (locala == null);
    locala.a(paramInt1, paramInt2, paramAdInfo);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlb
 * JD-Core Version:    0.7.0.1
 */