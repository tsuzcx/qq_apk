package mqq.app;

public class AccountNotMatchException
  extends Exception
{
  public AccountNotMatchException(String paramString1, String paramString2)
  {
    super("The current account is " + paramString1 + " instead of " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.AccountNotMatchException
 * JD-Core Version:    0.7.0.1
 */