import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.c;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import java.util.List;

public class aklt
  implements acci
{
  public void a(int paramInt, String paramString, OCRTextSearchInfo.c paramc) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult) {}
  
  public void f(boolean paramBoolean, String paramString, List<OCRTextSearchInfo.SougouSearchInfo> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length == 2))
      {
        f(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
        return;
      }
      f(false, "", null);
      return;
    case 2: 
      Object localObject = (Object[])paramObject;
      if ((paramObject != null) && (localObject.length == 2))
      {
        paramObject = (Integer)localObject[0];
        localObject = (TranslateResult)localObject[1];
        if (localObject != null)
        {
          a(paramBoolean, paramObject.intValue(), (TranslateResult)localObject);
          return;
        }
        a(false, paramObject.intValue(), null);
        return;
      }
      a(false, -1, null);
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length == 3))
    {
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (OCRTextSearchInfo.c)paramObject[2]);
      return;
    }
    a(-1, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklt
 * JD-Core Version:    0.7.0.1
 */