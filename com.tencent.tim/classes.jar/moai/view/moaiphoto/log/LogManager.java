package moai.view.moaiphoto.log;

public final class LogManager
{
  private static Logger logger = new LoggerDefault();
  
  public static Logger getLogger()
  {
    return logger;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    logger = paramLogger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.log.LogManager
 * JD-Core Version:    0.7.0.1
 */