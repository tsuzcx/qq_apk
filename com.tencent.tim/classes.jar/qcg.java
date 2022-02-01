import com.tencent.biz.qqstory.app.QQStoryContext;

public abstract class qcg
  extends qci
{
  protected boolean aCP;
  protected String awO = QQStoryContext.a().getCurrentUid();
  protected String awP;
  protected String mBrief;
  protected String mCompatibleText;
  protected String mImageUrl;
  protected String mSummary;
  protected String mTitle;
  protected int shareType = -1;
  protected int type = -1;
  
  public final void a(qdj paramqdj)
  {
    super.a(paramqdj);
    paramqdj.url = bU(6);
    g(paramqdj);
  }
  
  public void a(qdl paramqdl)
  {
    super.a(paramqdl);
    paramqdl.blM = 1;
    paramqdl.compatibleText = this.mCompatibleText;
    paramqdl.brief = this.mBrief;
    paramqdl.summary = this.mSummary;
    paramqdl.title = this.mTitle;
    paramqdl.imgUrl = this.mImageUrl;
    paramqdl.msgAction = bU(1);
    if (this.shareType != -1) {
      paramqdl.shareType = this.shareType;
    }
    if (this.type != -1) {
      paramqdl.type = this.type;
    }
    g(paramqdl);
  }
  
  public void a(qdm paramqdm)
  {
    super.a(paramqdm);
    paramqdm.title = this.mTitle;
    paramqdm.summary = this.mSummary;
    paramqdm.imageUrl = this.mImageUrl;
    paramqdm.url = bU(2);
    g(paramqdm);
  }
  
  public void a(qdn paramqdn)
  {
    super.a(paramqdn);
    paramqdn.title = this.awP;
    paramqdn.imageUrl = this.mImageUrl;
    paramqdn.aCS = this.aCP;
    paramqdn.awU = qdv.fV(this.mImageUrl);
    paramqdn.url = bU(5);
    g(paramqdn);
  }
  
  public void a(qdo paramqdo)
  {
    super.a(paramqdo);
    paramqdo.title = this.mTitle;
    paramqdo.summary = this.mSummary;
    paramqdo.url = bU(3);
    paramqdo.imageUrl = this.mImageUrl;
    paramqdo.aCS = true;
    g(paramqdo);
  }
  
  public void b(qdo paramqdo)
  {
    super.b(paramqdo);
    paramqdo.title = this.mTitle;
    paramqdo.summary = this.mSummary;
    paramqdo.url = bU(4);
    paramqdo.imageUrl = this.mImageUrl;
    paramqdo.aCS = true;
    g(paramqdo);
  }
  
  protected void g(qdk paramqdk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qcg
 * JD-Core Version:    0.7.0.1
 */