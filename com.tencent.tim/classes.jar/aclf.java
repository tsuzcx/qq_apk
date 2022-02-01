import android.text.TextUtils;
import com.tencent.mobileqq.app.SVIPHandler.1;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class aclf
  implements acci
{
  public aclf(SVIPHandler.1 param1, adxn paramadxn) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    try
    {
      String str1 = String.valueOf(this.a.this$0.AS());
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if (paramObject.size() > 0)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            Object localObject = (BubbleDiyEntity)paramObject.next();
            String str2;
            if (!TextUtils.isEmpty(((BubbleDiyEntity)localObject).topLeftId))
            {
              str2 = "BubbleDiyFetcher_" + str1 + "_TL_" + ((BubbleDiyEntity)localObject).topLeftId;
              this.b.i.add(str2);
            }
            if (!TextUtils.isEmpty(((BubbleDiyEntity)localObject).topRightId))
            {
              str2 = "BubbleDiyFetcher_" + str1 + "_TR_" + ((BubbleDiyEntity)localObject).topRightId;
              this.b.i.add(str2);
            }
            if (!TextUtils.isEmpty(((BubbleDiyEntity)localObject).bottomRightId))
            {
              str2 = "BubbleDiyFetcher_" + str1 + "_BR_" + ((BubbleDiyEntity)localObject).bottomRightId;
              this.b.i.add(str2);
            }
            if (!TextUtils.isEmpty(((BubbleDiyEntity)localObject).bottomLeftId))
            {
              localObject = "BubbleDiyFetcher_" + str1 + "_BL_" + ((BubbleDiyEntity)localObject).bottomLeftId;
              this.b.i.add(localObject);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, paramObject.getMessage());
      }
    }
    this.b.cBr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclf
 * JD-Core Version:    0.7.0.1
 */