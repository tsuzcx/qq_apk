package moai.log;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

public abstract interface FileOperation
{
  public abstract void flush();
  
  public abstract List<String> list(GregorianCalendar paramGregorianCalendar1, GregorianCalendar paramGregorianCalendar2);
  
  public abstract void zip(Config paramConfig, String paramString);
  
  public static class Config
  {
    private GregorianCalendar begin;
    private GregorianCalendar end;
    private Pattern pattern;
    private String patternString;
    
    public GregorianCalendar getBegin()
    {
      return this.begin;
    }
    
    public GregorianCalendar getEnd()
    {
      return this.end;
    }
    
    public Pattern getPattern()
    {
      return this.pattern;
    }
    
    public String getPatternString()
    {
      return this.patternString;
    }
    
    public static class Builder
    {
      private final FileOperation.Config config = new FileOperation.Config();
      
      public static Builder newBuilder()
      {
        return new Builder();
      }
      
      public FileOperation.Config build()
      {
        return this.config;
      }
      
      public Builder setBeginTime(GregorianCalendar paramGregorianCalendar)
      {
        FileOperation.Config.access$002(this.config, paramGregorianCalendar);
        return this;
      }
      
      public Builder setEndTime(GregorianCalendar paramGregorianCalendar)
      {
        FileOperation.Config.access$102(this.config, paramGregorianCalendar);
        return this;
      }
      
      public Builder setPattern(Pattern paramPattern)
      {
        FileOperation.Config.access$202(this.config, paramPattern);
        return this;
      }
      
      public Builder setPatternString(String paramString)
      {
        FileOperation.Config.access$302(this.config, paramString);
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.FileOperation
 * JD-Core Version:    0.7.0.1
 */