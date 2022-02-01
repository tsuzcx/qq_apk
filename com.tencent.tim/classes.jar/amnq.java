import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import java.util.ArrayList;

public abstract class amnq
  extends ampy
{
  protected FTSEntity a;
  protected CharSequence ae;
  protected CharSequence af;
  protected QQAppInterface app;
  protected String keyword;
  private CharSequence message;
  protected CharSequence title;
  protected ArrayList<String> zy;
  
  public amnq(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    this.app = paramQQAppInterface;
    this.keyword = paramString;
    this.zy = paramArrayList;
    this.a = paramFTSEntity;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public CharSequence f()
  {
    if (this.message == null) {
      this.message = amxk.a(this.a.mContent, this.a.mProximityStart, this.zy);
    }
    return this.message;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public int pG()
  {
    return 1;
  }
  
  public abstract CharSequence u();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnq
 * JD-Core Version:    0.7.0.1
 */