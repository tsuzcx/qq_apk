import android.graphics.Bitmap;
import java.util.List;

public class ajve
{
  public void M(List<String> paramList1, List<String> paramList2) {}
  
  protected void M(boolean paramBoolean, String paramString) {}
  
  public void T(boolean paramBoolean, List<Long> paramList) {}
  
  protected void b(int paramInt, String paramString, Bitmap paramBitmap) {}
  
  public void bF(int paramInt, boolean paramBoolean) {}
  
  protected void bRP() {}
  
  protected void cA(int paramInt, String paramString) {}
  
  protected void dph() {}
  
  public void m(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 4118: 
    case 4131: 
      do
      {
        do
        {
          return;
        } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
        M((List)paramVarArgs[0], (List)paramVarArgs[1]);
        return;
      } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
      bF(((Integer)paramVarArgs[0]).intValue(), ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 4113: 
      t(((Boolean)paramVarArgs[0]).booleanValue(), (List)paramVarArgs[1]);
      return;
    case 4114: 
      T(((Boolean)paramVarArgs[0]).booleanValue(), (List)paramVarArgs[1]);
      return;
    case 4115: 
      p(((Boolean)paramVarArgs[0]).booleanValue(), null);
      return;
    case 4116: 
      M(((Boolean)paramVarArgs[0]).booleanValue(), null);
      return;
    case 4159: 
      dph();
      return;
    case 4161: 
      try
      {
        b(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1], (Bitmap)paramVarArgs[2]);
        return;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
    case 4162: 
      try
      {
        if (((Integer)paramVarArgs[0]).intValue() == 0)
        {
          cA(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1]);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
      onUploadFailed(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1]);
      return;
    }
    try
    {
      bRP();
      return;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  protected void onUploadFailed(int paramInt, String paramString) {}
  
  protected void p(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void t(boolean paramBoolean, List<Long> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajve
 * JD-Core Version:    0.7.0.1
 */