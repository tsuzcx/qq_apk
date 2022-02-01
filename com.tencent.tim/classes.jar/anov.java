import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class anov
{
  protected List<String> GE;
  protected String Zm = "";
  protected QQAppInterface mApp;
  protected int mCount = 1;
  protected String mDepartment = "";
  protected int mOpIn;
  protected String mOpName = "";
  protected int mOpResult;
  protected String mOpType = "";
  protected String mToUin = "";
  
  public anov(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public anov a(int paramInt)
  {
    this.mOpIn = paramInt;
    return this;
  }
  
  public anov a(String paramString)
  {
    this.Zm = paramString;
    return this;
  }
  
  public anov a(String... paramVarArgs)
  {
    if (this.GE == null) {
      this.GE = new ArrayList(4);
    }
    if (paramVarArgs != null) {
      Collections.addAll(this.GE, paramVarArgs);
    }
    return this;
  }
  
  public anov b(int paramInt)
  {
    this.mOpResult = paramInt;
    return this;
  }
  
  public anov b(String paramString)
  {
    this.mDepartment = paramString;
    return this;
  }
  
  public anov c(String paramString)
  {
    this.mOpType = paramString;
    return this;
  }
  
  public anov d(String paramString)
  {
    this.mOpName = paramString;
    return this;
  }
  
  public anov e(String paramString)
  {
    this.mToUin = paramString;
    return this;
  }
  
  public void report()
  {
    if ((this.GE == null) || (this.GE.size() == 0))
    {
      anot.b(this.mApp, this.Zm, this.mDepartment, this.mToUin, this.mOpType, this.mOpName, this.mOpIn, this.mCount, this.mOpResult, "", "", "", "");
      return;
    }
    while (this.GE.size() < 4) {
      this.GE.add("");
    }
    anot.b(this.mApp, this.Zm, this.mDepartment, this.mToUin, this.mOpType, this.mOpName, this.mOpIn, this.mCount, this.mOpResult, (String)this.GE.get(0), (String)this.GE.get(1), (String)this.GE.get(2), (String)this.GE.get(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anov
 * JD-Core Version:    0.7.0.1
 */