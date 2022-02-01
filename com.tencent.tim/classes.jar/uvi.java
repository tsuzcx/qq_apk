import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.widget.QQToast;

public class uvi
  extends aceg
{
  public uvi(EditActivity paramEditActivity) {}
  
  protected void x(boolean paramBoolean, Object paramObject)
  {
    EditActivity.a(this.this$0);
    if (paramBoolean)
    {
      paramObject = (CustomEmotionData)paramObject;
      if (paramObject != null)
      {
        ((afhv)this.this$0.app.getManager(103)).c(paramObject);
        EditActivity.b(this.this$0);
      }
    }
    while (!(paramObject instanceof String)) {
      return;
    }
    QQToast.a(this.this$0, 1, (String)paramObject, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvi
 * JD-Core Version:    0.7.0.1
 */