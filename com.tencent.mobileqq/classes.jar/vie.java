import common.config.service.QzoneConfig;

public class vie
{
  private static Boolean a;
  private static Boolean b;
  private static Boolean c;
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("QzCustomFont", "TrueTypeViewCache", 1) != 0;
  }
  
  public static boolean a(int paramInt)
  {
    int i = QzoneConfig.getInstance().getConfig("QzCustomFont", "DiyFontShow", 0);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
          } while ((i & 0x1) == 0);
          return false;
        } while ((i & 0x2) == 0);
        return false;
      } while ((i & 0x4) == 0);
      return false;
    } while ((i & 0x8) == 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vie
 * JD-Core Version:    0.7.0.1
 */