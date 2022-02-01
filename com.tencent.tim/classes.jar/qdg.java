public abstract class qdg
  extends qci
{
  protected String mImageUrl;
  protected String mJumpUrl;
  protected String mSummary;
  protected String mTitle;
  
  public void a(qdj paramqdj)
  {
    super.a(paramqdj);
    paramqdj.url = this.mJumpUrl;
  }
  
  public void a(qdl paramqdl)
  {
    super.a(paramqdl);
    paramqdl.blM = 2;
    paramqdl.brief = ("[" + plr.asY + "] " + this.mTitle);
    paramqdl.imgUrl = this.mImageUrl;
    paramqdl.title = this.mTitle;
    paramqdl.summary = this.mSummary;
    paramqdl.msgAction = this.mJumpUrl;
  }
  
  public void a(qdm paramqdm)
  {
    super.a(paramqdm);
    paramqdm.title = this.mTitle;
    paramqdm.summary = this.mSummary;
    paramqdm.imageUrl = this.mImageUrl;
    paramqdm.url = this.mJumpUrl;
  }
  
  public void a(qdn paramqdn)
  {
    super.a(paramqdn);
    paramqdn.url = this.mJumpUrl;
    paramqdn.imageUrl = this.mImageUrl;
    paramqdn.title = this.mTitle;
    paramqdn.awU = qdv.fV(this.mImageUrl);
  }
  
  public void a(qdo paramqdo)
  {
    super.a(paramqdo);
    paramqdo.summary = this.mSummary;
    paramqdo.title = this.mTitle;
    paramqdo.url = this.mJumpUrl;
    paramqdo.imageUrl = this.mImageUrl;
    paramqdo.aCT = true;
  }
  
  public void b(qdo paramqdo)
  {
    super.b(paramqdo);
    paramqdo.summary = this.mSummary;
    paramqdo.title = this.mTitle;
    paramqdo.url = this.mJumpUrl;
    paramqdo.imageUrl = this.mImageUrl;
    paramqdo.aCT = true;
  }
  
  protected String bU(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdg
 * JD-Core Version:    0.7.0.1
 */