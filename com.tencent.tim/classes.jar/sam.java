import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;

public class sam
{
  public CertifiedAccountMeta.StFeed feed;
  public int type;
  public CertifiedAccountMeta.StUser user;
  
  public sam(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.feed = paramStFeed;
    this.type = 2;
  }
  
  public sam(CertifiedAccountMeta.StUser paramStUser)
  {
    this.user = paramStUser;
    this.type = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sam
 * JD-Core Version:    0.7.0.1
 */