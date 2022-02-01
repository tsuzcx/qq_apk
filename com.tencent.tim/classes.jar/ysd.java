import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilderV2.1;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilderV2.2;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilderV2.3;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.DenyRunnable.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ysd
  extends ysa
  implements View.OnClickListener
{
  public ytu a;
  
  public ysd(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
    this.jdField_a_of_type_Ytu = ((ytu)paramytv);
  }
  
  private void cll()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.mContext, new DenyRunnable.a(this.mApp));
    yuw.a((Activity)this.mContext, this.mApp, local3, localDenyRunnable);
  }
  
  private void removeSelf()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_Ytd.a(this);
      this.jdField_a_of_type_Ytd.notifyDataSetChanged();
      return;
    }
    this.mApp.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    String str3;
    String str2;
    String str1;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysd.a)))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131561727, null);
      localObject = new ysd.a(null);
      ((ysd.a)localObject).el = ((Button)paramView.findViewById(2131361975));
      ((ysd.a)localObject).title = ((TextView)paramView.findViewById(2131379769));
      ((ysd.a)localObject).xW = ((TextView)paramView.findViewById(2131379000));
      ((ysd.a)localObject).aq = ((ImageButton)paramView.findViewById(2131364677));
      paramView.setTag(localObject);
      if (this.jdField_a_of_type_Ytu.box) {
        break label277;
      }
      str3 = this.jdField_a_of_type_Ytu.a.a.title;
      str2 = this.jdField_a_of_type_Ytu.a.a.subTitle;
      str1 = this.jdField_a_of_type_Ytu.a.a.buttonTitle;
      label149:
      ((ysd.a)localObject).title.setText(str3);
      ((ysd.a)localObject).xW.setText(str2);
      ((ysd.a)localObject).el.setText(str1);
      paramView.setOnClickListener(this);
      ((ysd.a)localObject).aq.setOnClickListener(this);
      ((ysd.a)localObject).el.setOnClickListener(this);
      C(paramView, false);
      localObject = (ysf)this.mApp.getManager(34);
      if (this.jdField_a_of_type_Ytu.box) {
        break label325;
      }
      if (!((ysf)localObject).boz)
      {
        ((ysf)localObject).boz = true;
        anot.a(this.mApp, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
      }
    }
    label277:
    label325:
    while (((ysf)localObject).boA)
    {
      return paramView;
      localObject = (ysd.a)paramView.getTag();
      break;
      str3 = this.jdField_a_of_type_Ytu.a.b.title;
      str2 = this.jdField_a_of_type_Ytu.a.b.subTitle;
      str1 = this.jdField_a_of_type_Ytu.a.b.buttonTitle;
      break label149;
    }
    ((ysf)localObject).boA = true;
    anot.a(this.mApp, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
    return paramView;
  }
  
  public void clk()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendBindContactGuideBuilderV2", 2, "uploadContact");
    }
    ThreadManager.excute(new NewFriendBindContactGuideBuilderV2.1(this), 16, null, false);
    ContactBindedActivity.a(this.mApp, 15, 2, null);
    removeSelf();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131364677)
    {
      ((ysf)this.mApp.getManager(34)).clm();
      removeSelf();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 2131361975) || (i == 2131363488)) {
        if (!aqiw.isNetSupport(this.mContext))
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 1, 2131696348, 0).show(localBaseApplication.getResources().getDimensionPixelSize(2131299627));
        }
        else if (this.jdField_a_of_type_Ytu.box)
        {
          anot.a(this.mApp, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
          clk();
        }
        else
        {
          anot.a(this.mApp, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
          cll();
        }
      }
    }
  }
  
  static class a
    extends ysa.a
  {
    public ImageButton aq;
    public Button el;
    public TextView title;
    public TextView xW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysd
 * JD-Core Version:    0.7.0.1
 */