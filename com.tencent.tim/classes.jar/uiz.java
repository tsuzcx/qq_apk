import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class uiz
  extends acea
{
  public uiz(BaseChatPie paramBaseChatPie) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((BaseChatPie.a(this.this$0) == null) || (paramObject == null) || (this.this$0.a == null));
      localObject = this.this$0.a.getText().toString();
      paramObject = (EmoticonResp)paramObject;
      BaseChatPie.a(this.this$0).a(paramBoolean, paramInt, paramObject, (String)localObject);
      return;
      if ((this.this$0.x != null) && (this.this$0.x.isShowing())) {
        this.this$0.x.dismiss();
      }
    } while (paramObject == null);
    Object localObject = (EmoticonResp)paramObject;
    int i;
    if (paramBoolean)
    {
      i = ((EmoticonResp)localObject).delEpId;
      if ((((EmoticonResp)localObject).keySeq == null) || (((EmoticonResp)localObject).keySeq.equals(""))) {
        paramObject = acfp.m(2131703095);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(((EmoticonResp)localObject).emoticonId)) {
        break label240;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.this$0.TAG, 2, "auth type emoticon id is null");
      return;
      paramObject = ((EmoticonResp)localObject).keySeq;
      continue;
      paramObject = acfp.m(2131703080);
      i = -404;
    }
    label240:
    ((ajdg)this.this$0.app.getManager(14)).a(String.valueOf(((EmoticonResp)localObject).epId), ((EmoticonResp)localObject).emoticonId, new uja(this, paramInt, i, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uiz
 * JD-Core Version:    0.7.0.1
 */