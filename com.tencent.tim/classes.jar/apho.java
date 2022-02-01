import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class apho
  extends acnd
{
  public apho(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, apgk paramapgk)
  {
    super.a(paramBoolean, paramapgk);
    this.this$0.bF();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("获取作业信息");
      if (!paramBoolean) {
        break label79;
      }
    }
    label79:
    for (String str = "成功";; str = "失败")
    {
      QLog.d("PublishHomeWorkFragment", 2, str);
      if ((!paramBoolean) || (paramapgk == null) || (paramapgk.content == null)) {
        break;
      }
      this.this$0.a(paramapgk);
      return;
    }
    this.this$0.getActivity().finish();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super.a(paramBoolean, paramString1, paramString2, paramInt, paramString3, paramString4);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onGetHomeworkTroopIdentity: isSuccess:" + paramBoolean + ", identity:" + paramInt + ", course:" + paramString3);
    }
    if (!this.this$0.cQG)
    {
      if (!this.this$0.cQE) {
        this.this$0.SS(paramString3);
      }
      this.this$0.W(paramInt, paramString3, paramString4);
      if (!paramBoolean) {
        break label142;
      }
      this.this$0.cps = paramString3;
      this.this$0.dZA();
    }
    for (;;)
    {
      QLog.i("PublishHomeWorkFragment", 1, "init data success");
      this.this$0.dZD();
      return;
      label142:
      QQToast.a(this.this$0.getActivity(), acfp.m(2131710255), 0).show();
    }
  }
  
  public void g(boolean paramBoolean, long paramLong, int paramInt)
  {
    super.g(paramBoolean, paramLong, paramInt);
    this.this$0.bF();
    this.this$0.bD(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apho
 * JD-Core Version:    0.7.0.1
 */