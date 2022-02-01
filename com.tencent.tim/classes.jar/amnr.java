import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class amnr
  extends ampy
{
  protected List<? extends FTSEntity> FR;
  protected CharSequence ag;
  protected CharSequence ah;
  protected QQAppInterface app;
  protected String caY;
  protected CharSequence description;
  public int friendIndex = -1;
  public int friendNum = -1;
  protected String keyword;
  public int searchStrategy = -1;
  public int senderNum = -1;
  protected CharSequence title;
  protected ArrayList<String> zy;
  
  public amnr(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, List<? extends FTSEntity> paramList)
  {
    this.app = paramQQAppInterface;
    this.keyword = paramString1;
    this.caY = paramString2;
    this.zy = paramArrayList;
    this.FR = paramList;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public abstract CharSequence v();
  
  public abstract CharSequence w();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnr
 * JD-Core Version:    0.7.0.1
 */