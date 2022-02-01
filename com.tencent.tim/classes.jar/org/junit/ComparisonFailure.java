package org.junit;

public class ComparisonFailure
  extends AssertionError
{
  private static final int MAX_CONTEXT_LENGTH = 20;
  private static final long serialVersionUID = 1L;
  private String fActual;
  private String fExpected;
  
  public ComparisonFailure(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.fExpected = paramString2;
    this.fActual = paramString3;
  }
  
  public String getActual()
  {
    return this.fActual;
  }
  
  public String getExpected()
  {
    return this.fExpected;
  }
  
  public String getMessage()
  {
    return new ComparisonCompactor(20, this.fExpected, this.fActual).compact(super.getMessage());
  }
  
  static class ComparisonCompactor
  {
    private static final String DIFF_END = "]";
    private static final String DIFF_START = "[";
    private static final String ELLIPSIS = "...";
    private final String actual;
    private final int contextLength;
    private final String expected;
    
    public ComparisonCompactor(int paramInt, String paramString1, String paramString2)
    {
      this.contextLength = paramInt;
      this.expected = paramString1;
      this.actual = paramString2;
    }
    
    private String sharedPrefix()
    {
      int j = Math.min(this.expected.length(), this.actual.length());
      int i = 0;
      while (i < j)
      {
        if (this.expected.charAt(i) != this.actual.charAt(i)) {
          return this.expected.substring(0, i);
        }
        i += 1;
      }
      return this.expected.substring(0, j);
    }
    
    private String sharedSuffix(String paramString)
    {
      int i = 0;
      int j = Math.min(this.expected.length() - paramString.length(), this.actual.length() - paramString.length());
      for (;;)
      {
        if ((i > j - 1) || (this.expected.charAt(this.expected.length() - 1 - i) != this.actual.charAt(this.actual.length() - 1 - i))) {
          return this.expected.substring(this.expected.length() - i);
        }
        i += 1;
      }
    }
    
    public String compact(String paramString)
    {
      if ((this.expected == null) || (this.actual == null) || (this.expected.equals(this.actual))) {
        return Assert.format(paramString, this.expected, this.actual);
      }
      DiffExtractor localDiffExtractor = new DiffExtractor(null);
      String str1 = localDiffExtractor.compactPrefix();
      String str2 = localDiffExtractor.compactSuffix();
      return Assert.format(paramString, str1 + localDiffExtractor.expectedDiff() + str2, str1 + localDiffExtractor.actualDiff() + str2);
    }
    
    class DiffExtractor
    {
      private final String sharedPrefix = ComparisonFailure.ComparisonCompactor.this.sharedPrefix();
      private final String sharedSuffix = ComparisonFailure.ComparisonCompactor.this.sharedSuffix(this.sharedPrefix);
      
      private DiffExtractor() {}
      
      private String extractDiff(String paramString)
      {
        return "[" + paramString.substring(this.sharedPrefix.length(), paramString.length() - this.sharedSuffix.length()) + "]";
      }
      
      public String actualDiff()
      {
        return extractDiff(ComparisonFailure.ComparisonCompactor.this.actual);
      }
      
      public String compactPrefix()
      {
        if (this.sharedPrefix.length() <= ComparisonFailure.ComparisonCompactor.this.contextLength) {
          return this.sharedPrefix;
        }
        return "..." + this.sharedPrefix.substring(this.sharedPrefix.length() - ComparisonFailure.ComparisonCompactor.this.contextLength);
      }
      
      public String compactSuffix()
      {
        if (this.sharedSuffix.length() <= ComparisonFailure.ComparisonCompactor.this.contextLength) {
          return this.sharedSuffix;
        }
        return this.sharedSuffix.substring(0, ComparisonFailure.ComparisonCompactor.this.contextLength) + "...";
      }
      
      public String expectedDiff()
      {
        return extractDiff(ComparisonFailure.ComparisonCompactor.this.expected);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.ComparisonFailure
 * JD-Core Version:    0.7.0.1
 */