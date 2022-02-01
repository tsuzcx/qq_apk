import java.util.List;

public class qpt
  extends qts
{
  protected final String axY;
  protected final int mDataType;
  
  public qpt(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramString2);
    this.axY = paramString1;
    this.mDataType = paramInt;
  }
  
  protected pxe a(String paramString, List<String> paramList)
  {
    return new pyd(paramString, paramList);
  }
  
  protected pxf a()
  {
    return new qpu(this.axY, this.mDataType, this.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpt
 * JD-Core Version:    0.7.0.1
 */