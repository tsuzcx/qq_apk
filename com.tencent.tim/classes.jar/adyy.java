import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class adyy
  extends adyq
{
  public adyy(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void aa(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onModifyCard isSuccess=%s cardId=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    this.this$0.aqz();
    if (paramBoolean)
    {
      this.this$0.dN(acfp.m(2131703307));
      anot.a(this.this$0.app, "CliOper", "", "", "0X8007748", "0X8007748", this.this$0.cLF, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.this$0.getActivity(), 2, acfp.m(2131703314), 0).show(this.this$0.getTitleBarHeight());
  }
  
  public void ab(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onDelCard isSuccess=%s cardId=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    this.this$0.aqz();
    if (paramBoolean)
    {
      QQToast.a(this.this$0.getActivity(), 2, acfp.m(2131703309), 0).show(this.this$0.getTitleBarHeight());
      this.this$0.finish();
      return;
    }
    QQToast.a(this.this$0.getActivity(), 1, acfp.m(2131703305), 0).show(this.this$0.getTitleBarHeight());
  }
  
  public void k(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onGetCardInfo isSuccess=%s cardId=%s queryType=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    this.this$0.aqz();
    if ((paramBoolean) && (paramString.equals(this.this$0.mCardId)))
    {
      if ((this.this$0.isEditMode) && (this.this$0.cLC == 2) && (this.this$0.cLE == 1))
      {
        this.this$0.cLE = 0;
        this.this$0.a.GV(false);
      }
      if ((!this.this$0.isEditMode) || (!this.this$0.bSn) || (this.this$0.isFinishing())) {
        break label190;
      }
      this.this$0.a.a(paramString);
      QLog.i("BusinessCard_observer", 4, "after edit and require : cardId = " + paramString);
      this.this$0.finish();
    }
    label190:
    do
    {
      return;
      paramString = this.this$0.a.a(paramString);
    } while (paramString == null);
    this.this$0.b = paramString;
    BusinessCardEditActivity.a(this.this$0, false, true, true);
  }
  
  public void l(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, String.format("onAddCard isSuccess=%s cardId=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt) }));
    }
    this.this$0.aqz();
    Object localObject = this.this$0.getResources();
    if (paramBoolean)
    {
      localObject = ((Resources)localObject).getString(2131700737);
      this.this$0.dN((String)localObject);
      if (TextUtils.isEmpty(this.this$0.mCardId)) {
        this.this$0.mCardId = paramString;
      }
      return;
    }
    paramString = ((Resources)localObject).getString(2131700735);
    if (paramInt == 66) {
      paramString = ((Resources)localObject).getString(2131700736);
    }
    QQToast.a(this.this$0.getActivity(), 2, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyy
 * JD-Core Version:    0.7.0.1
 */